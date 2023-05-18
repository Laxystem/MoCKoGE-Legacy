package io.github.laylameower.mockoge

import io.github.laylameower.mockoge.loader.kts.KotlinScriptResourceParser
import io.github.laylameower.mockoge.util.*
import org.apache.logging.log4j.LogManager
import java.io.BufferedReader
import java.nio.file.FileSystemNotFoundException
import java.nio.file.FileSystems
import java.nio.file.Path
import java.util.zip.ZipFile
import kotlin.io.path.inputStream
import kotlin.io.path.listDirectoryEntries
import kotlin.io.path.name
import kotlin.script.experimental.host.toScriptSource

private val LOGGER = LogManager.getLogger("$mockoge/loader")

public fun main() {
    LOGGER.info("Initializing MoCKoGE Loader...")

    val bundles = mutableListOf<Bundle>()

    LOGGER.info("Querying for built-in bundles...")

    Mockoge::class.java.getResource("/$mockoge.${KotlinScriptResourceParser.bundleFileExtension}")!!.toURI().let {

        try {
            Path.of(it)
        } catch (e: FileSystemNotFoundException) {
            LOGGER.debug("Creating file system...", e)

            FileSystems.newFileSystem(it, emptyMap<String, Any?>(), Mockoge::class.java.classLoader)
            Path.of(it)
        }

    }.parent.listDirectoryEntries("*.${KotlinScriptResourceParser.bundleFileExtension}").forEach { file ->

        KotlinScriptResourceParser.parseBundleFile(
            file.inputStream().bufferedReader().use(BufferedReader::readText).toScriptSource(), file.name, LOGGER
        )?.let {
            bundles += it
        } ?: LOGGER.error("Failed to parse built-in bundle [${file.name}], skipping")
    }


    LOGGER.info("Querying for bundles...")

    "bundles/".asFile.listFiles { file -> file.extension == mockoge }?.forEach { bundle ->
        LOGGER.debug("Found bundle [${bundle.name}]")

        val bundleZip = ZipFile(bundle)
        val entrypoints =
            bundleZip.entries().asSequence().filter { KotlinScriptResourceParser.isBundleFile(it.name, LOGGER) }
                .toList()

        if (entrypoints.isEmpty()) {
            LOGGER.debug("Skipped bundle [${bundle.name}]: found no bundle scripts")
            return@forEach
        }

        for (entrypoint in entrypoints) {
            KotlinScriptResourceParser.parseBundleFile(
                bundleZip.getInputStream(entrypoint).asString.toScriptSource(),
                entrypoint.name,
                LOGGER
            )?.let {
                bundles += it
            } ?: LOGGER.error("Failed to parse bundle [${entrypoint.name}], skipping")
        }
    }

    LOGGER.info("Loading bundles...")

    Registry.unfreeze()

    bundles.forEach { bundle ->
        bundle.logger.info("Initializing version {}", bundle.version)

        for ((registry, value) in bundle.definitions) {
            bundle.logger.debug(
                "Definition [{}] of type [{} added to registry [{}]",
                value.first,
                value.second::class.simpleName,
                registry
            )

            RootRegistry[registry]?.let { it[value.first] = value.second }
        }
    }

    Registry.freeze()

    TODO("Scenes")
    @Suppress("UNREACHABLE_CODE")
    TODO("Relations")

    // Mockoge(null, bundles)
}
