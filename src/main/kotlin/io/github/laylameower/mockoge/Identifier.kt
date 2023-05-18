package io.github.laylameower.mockoge

import io.github.laylameower.mockoge.util.*


/**
 * @constructor Use [Bundle.createIdentifier] or [at] instead.
 */
@Suppress("DataClassPrivateConstructor")
public data class Identifier private constructor(val namespace: String, val path: String) : Validatable {
    override val isValid: Boolean get() = regex.matches(namespace) && regex.matches(path)

    /**
     * Does this identifier belong to the engine's or an official module's namespace?
     */
    val isOfficial: Boolean get() = namespace.startsWith(mockoge)

    /**
     * Does this identifier belong to the engine namespace?
     */
    val isEngine: Boolean get() = namespace == mockoge

    init {
        if (!isValid) throw IllegalArgumentException("Invalid identifier: path [$path] or namespace [$namespace] may not match regex [${regex.pattern}]")
    }

    override fun toString(): String = "$namespace:$path"


    public companion object {
        private const val separator = ':'

        @JvmField
        public val regex: Regex = "[a-z_]+(/[a-z_]+)*".toRegex()

        @JvmField
        public val fullRegex: Regex = "${regex.pattern}$separator${regex.pattern}".toRegex()

        @JvmStatic
        public fun of(identifier: String): Identifier? = identifier.ifMatches(regex) {
            of(identifier.substringBefore(separator), identifier.substringAfter(separator))
        }

        @JvmStatic
        public fun of(namespace: String, path: String): Identifier = Identifier(namespace, path)
    }
}
