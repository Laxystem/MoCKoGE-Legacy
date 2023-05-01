package io.github.laylameower.hexgine

import io.github.laylameower.hexgine.utils.Validatable

@Suppress("DataClassPrivateConstructor")
data class Identifier private constructor(val namespace: String, val path: String) : Validatable {
    override val isValid get() = regex.matches(namespace) && regex.matches(path)

    init {
        if (!isValid) throw IllegalArgumentException("Invalid identifier: path [$path] or namespace [$namespace] may not match regex [${regex.pattern}]")
    }

    override fun toString() = "$namespace:$path"


    companion object {
        @JvmField
        val regex = Regex("[a-z_]+(/[a-z_]+)*")

        @JvmField
        val fullRegex = Regex("${regex.pattern}:${regex.pattern}")

        @JvmStatic
        fun of(identifier: String) = if (fullRegex.matches(identifier)) of(
            identifier.substringBefore(':'),
            identifier.substringAfter(':')
        ) else null

        @JvmStatic
        fun of(namespace: String, path: String) = Identifier(namespace, path)
    }
}
