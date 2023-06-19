package io.github.laylameower.mockoge.core

import io.github.laylameower.mockoge.util.*
import io.github.laylameower.mockoge.util.registry.Identifier
import io.github.laylameower.mockoge.util.registry.Registry
import io.github.oshai.KLogger
import io.github.oshai.KotlinLogging
import io.github.z4kn4fein.semver.Version
import kotlinx.collections.immutable.ImmutableMap

@Suppress("unused")
public class Bundle internal constructor(
    public val namespace: String,
    public val bundleName: String,
    override val version: Version,
    public val definitions: ImmutableMap<Identifier, Pair<Identifier, Any>>,
    public val registries: ImmutableMap<String, Registry<*>>
) : Versioned {
    public val logger: KLogger = KotlinLogging.logger(namespace)

    init {
        if (!Identifier.Companion.regex.matches(namespace)) throw IllegalArgumentException("Namespace must conform to regex (${Identifier.Companion.regex}) - only use the following: [a-z_/]")
    }

    public fun createIdentifier(path: String): Identifier = path at namespace
    public fun createLogger(path: String): KLogger? = path.ifMatches(Identifier.Companion.regex) {
        KotlinLogging.logger("$namespace:$path")
    }

    override fun toString(): String = "$namespace v$version ($bundleName)"
}