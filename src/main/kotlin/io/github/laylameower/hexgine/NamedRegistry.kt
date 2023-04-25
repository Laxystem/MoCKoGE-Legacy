package io.github.laylameower.hexgine

import io.github.laylameower.hexgine.utils.Named
import kotlin.reflect.KClass

abstract class NamedRegistry<T : Named<N>, N>(valueType: KClass<T>) : Registry<T, Identifier>(valueType, Identifier::class) {
    fun register(namespace: String, value: T) = register(Identifier(namespace, value.name.toString()), value)
    operator fun set(namespace: String, value: T) = register(namespace, value)

    override fun isValid(value: T, identifier: Identifier): Boolean {
        return value.name.toString() == identifier.path
    }
}