package io.github.laylameower.hexgine

import io.github.laylameower.hexgine.utils.*

abstract class NamedRegistry<T : Named<String>>(name: Identifier, valueType: Class<T>) : Registry<T>(name, valueType) {
    fun register(namespace: String, value: T) = register(value.name at namespace, value)
    operator fun set(namespace: String, value: T) = register(namespace, value)

    override fun isValid(value: T, identifier: Identifier): Boolean {
        return !isFrozen && value.name == identifier.path
    }
}