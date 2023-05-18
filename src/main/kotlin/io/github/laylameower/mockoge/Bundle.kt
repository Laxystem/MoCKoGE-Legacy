package io.github.laylameower.mockoge

import io.github.laylameower.mockoge.util.Versioned
import io.github.laylameower.mockoge.util.at
import io.github.z4kn4fein.semver.Version
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import kotlinx.collections.immutable.ImmutableMap

@Suppress("unused")
public class Bundle internal constructor(
    public val namespace: String,
    public val bundleName: String,
    override val version: Version,
    public val definitions: ImmutableMap<Identifier, Pair<Identifier, Any>>,
    public val registries: ImmutableMap<String, Registry<*>>
) : Versioned {
    public val logger: Logger = LogManager.getLogger(namespace)

    init {
        if (!Identifier.regex.matches(namespace)) throw IllegalArgumentException("Namespace must conform to regex (${Identifier.regex}) - only use the following: [a-z_/]")
    }

    public fun createIdentifier(path: String): Identifier = path at namespace
    public fun createLogger(path: String): Logger? =
        if (path.matches(Identifier.regex)) LogManager.getLogger(namespace)!! else null

    override fun toString(): String = "$namespace v$version ($bundleName)"
}