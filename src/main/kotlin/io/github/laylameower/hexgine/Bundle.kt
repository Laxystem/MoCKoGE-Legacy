package io.github.laylameower.hexgine

import io.github.laylameower.hexgine.utils.Named
import io.github.laylameower.hexgine.utils.Versioned
import io.github.z4kn4fein.semver.Version
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger

class Bundle internal constructor(
    val namespace: String,
    val bundleName: String,
    override val version: Version,
    val definitions: Map<Registry<*, *>, List<String>>

) : Versioned, Named<String> by Named.Delegate(namespace) {
    val logger: Logger = LogManager.getLogger(namespace)

    fun createIdentifier(path: String) = Identifier(namespace, path)
}