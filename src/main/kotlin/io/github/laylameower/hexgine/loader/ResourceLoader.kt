package io.github.laylameower.hexgine.loader

import io.github.laylameower.hexgine.Bundle
import io.github.laylameower.hexgine.Identifier
import org.apache.logging.log4j.Logger
import kotlin.script.experimental.api.SourceCode

interface ResourceLoader {
    val bundleExtension: String

    fun parseEntrypoint(entrypoint: SourceCode, fileName: String, logger: Logger): Bundle?
    fun getNamespace(fileName: String, logger: Logger): String? =
        fileName.substringBeforeLast(bundleExtension).let {
            if (Identifier.regex.matches(it)) it else {
                logger.error("Invalid bundle script namespace: [$it], skipping")
                null
            }
        }

    fun isLoadable(fileName: String, logger: Logger): Boolean = fileName.endsWith(bundleExtension)
}