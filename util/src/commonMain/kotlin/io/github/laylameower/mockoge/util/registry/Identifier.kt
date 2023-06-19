package io.github.laylameower.mockoge.util.registry

import io.github.laylameower.mockoge.util.*

/**
 * Used to register stuff to [registries][Registry].
 */
public class Identifier(public val namespace: String, public val path: String) : Validatable {
    override val isValid: Boolean get() = regex.matches(namespace) && regex.matches(path)

    init {
        validate { "Invalid identifier: path [$path] or namespace [$namespace] may not match regex [${regex.pattern}]" }
    }

    override fun toString(): String = "$namespace$separator$path"

    override fun equals(other: Any?): Boolean = when {
        this === other -> true
        other == null || this::class != other::class -> false

        else -> {
            other as Identifier

            if (namespace != other.namespace) false
            else path == other.path
        }
    }

    override fun hashCode(): Int {
        var result = namespace.hashCode()
        result = 31 * result + path.hashCode()
        return result
    }

    public companion object {
        public const val separator: Char = ':'

        public val regex: Regex = "[a-z_]+(/[a-z_]+)*".toRegex()

        public val fullRegex: Regex = "${regex.pattern}$separator${regex.pattern}".toRegex()

        public fun of(identifier: String): Identifier? = identifier.ifMatches(regex) {
            Identifier(identifier.substringBefore(separator), identifier.substringAfter(separator))
        }
    }
}
