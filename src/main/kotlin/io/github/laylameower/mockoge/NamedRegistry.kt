package io.github.laylameower.mockoge

import io.github.laylameower.mockoge.util.Named
import io.github.laylameower.mockoge.util.at

abstract class NamedRegistry<T : Named<String>>(name: Identifier, valueType: Class<T>) : Registry<T>(name, valueType) {
    fun register(namespace: String, value: T) = register(value.name at namespace, value)

    override fun isValid(value: T, identifier: Identifier): Boolean {
        return !isFrozen && value.name == identifier.path
    }
}