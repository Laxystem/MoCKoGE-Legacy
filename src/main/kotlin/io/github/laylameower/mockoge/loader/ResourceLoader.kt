package io.github.laylameower.mockoge.loader

import org.apache.logging.log4j.Logger
import java.io.File

/**
 * Loads complete bundles from files.
 */
public interface ResourceLoader {
    public fun parse(file: File)

    public fun isLoadable(fileName: String, logger: Logger): Boolean
}