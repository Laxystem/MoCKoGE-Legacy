package io.github.laylameower.mockoge

import io.github.laylameower.mockoge.loader.kts.KotlinScriptResourceLoader
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

fun main() {
    LOGGER.info("Initializing MoCKoGE Loader...")

    val bundles = mutableListOf<Bundle>()

    LOGGER.info("Querying for built-in bundles...")

    Mockoge::class.java.getResource("/$mockoge${KotlinScriptResourceLoader.bundleExtension}")!!.toURI().let {

        try {
            Path.of(it)
        } catch (e: FileSystemNotFoundException) {
            LOGGER.debug("Creating file system...", e)

            FileSystems.newFileSystem(it, emptyMap<String, Any?>(), Mockoge::class.java.classLoader)
            Path.of(it)
        }

    }.parent.listDirectoryEntries("*${KotlinScriptResourceLoader.bundleExtension}").forEach { file ->

        KotlinScriptResourceLoader.parseEntrypoint(
            file.inputStream().bufferedReader().use(BufferedReader::readText).toScriptSource(), file.name, LOGGER
        )?.let {
            bundles += it
        } ?: LOGGER.error("Failed to parse built-in bundle [${file.name}], skipping")
    }


    LOGGER.info("Querying for bundles...")

    getDirectory("bundles/").listFiles { file -> file.name.endsWith(".mockoge") }?.forEach { bundle ->
        LOGGER.debug("Found bundle [${bundle.name}]")

        val bundleZip = ZipFile(bundle)
        val entrypoints =
            bundleZip.entries().asSequence().filter { KotlinScriptResourceLoader.isLoadable(it.name, LOGGER) }.toList()

        if (entrypoints.isEmpty()) {
            LOGGER.debug("Skipped bundle [${bundle.name}]: found no bundle scripts")
            return@forEach
        }

        for (entrypoint in entrypoints) {
            KotlinScriptResourceLoader.parseEntrypoint(
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
        bundle.logger.debug("Initializing version {}", bundle.version)

        for ((registry, value) in bundle.definitions) {
            registry[value.first] = value.second
        }
    }

    Registry.freeze()

    TODO("Scenes")
    TODO("Relations")

    // Mockoge(null, bundles)
}