package io.github.laylameower.mockoge.loader

import io.github.laylameower.mockoge.Bundle
import io.github.laylameower.mockoge.Identifier
import org.apache.logging.log4j.Logger
import kotlin.script.experimental.api.SourceCode

/**
 * Parses bundles, scenes, and resources from their original encoding (for example, Kotlin Script)
 */
public interface ResourceParser {
    public val bundleFileExtension: String
    public val sceneFileExtension: String

    public fun parseBundleFile(entrypoint: SourceCode, fileName: String, logger: Logger): Bundle?
    public fun getNamespace(fileName: String, logger: Logger): String? =
        fileName.substringBeforeLast(".$bundleFileExtension").let {
            if (Identifier.regex.matches(it)) it else {
                logger.error("Invalid bundle script namespace: [$it], skipping")
                null
            }
        }

    public fun isBundleFile(fileName: String, logger: Logger): Boolean = fileName.endsWith(bundleFileExtension)
}