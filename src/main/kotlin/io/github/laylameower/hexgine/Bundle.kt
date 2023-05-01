package io.github.laylameower.hexgine

import io.github.laylameower.hexgine.utils.Named
import io.github.laylameower.hexgine.utils.Versioned
import io.github.laylameower.hexgine.utils.at
import io.github.z4kn4fein.semver.Version
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger

class Bundle internal constructor(
    val namespace: String,
    val bundleName: String,
    override val version: Version,
    val definitions: Map<Registry<*>, Pair<Identifier, Any>>

) : Versioned, Named<String> by Named.Delegate(namespace) {
    val logger: Logger = LogManager.getLogger(namespace)

    init {
        if (!Identifier.regex.matches(namespace)) throw IllegalArgumentException("Namespace must conform to regex (${Identifier.regex}) - only use the following: [a-z_/]")
    }

    fun createIdentifier(path: String) = path at namespace
    fun createLogger(path: String): Logger? {
        return LogManager.getLogger(path.takeIf { path matches Identifier.regex } ?: return null)!!
    }
}