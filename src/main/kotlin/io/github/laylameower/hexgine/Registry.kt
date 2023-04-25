package io.github.laylameower.hexgine

import io.github.laylameower.hexgine.Application.Companion.BUNDLE
import io.github.laylameower.hexgine.utils.Named
import kotlin.reflect.KClass
import kotlin.reflect.safeCast

/**
 * @param T value type
 * @param K key type
 */
abstract class Registry<T : Any>(override val name: Identifier, val valueType: KClass<T>) :
    Iterable<Map.Entry<Identifier, T>>, Named<Identifier> {
    private val contents = mutableMapOf<Identifier, T>()

    init {
        @Suppress("LeakingThis")
        RootRegistry.register(valueType, this)
    }

    fun register(identifier: Identifier, value: T): T? = if (contents.containsKey(identifier)) {
        BUNDLE.logger.warn("Attempted to override [$identifier] in registry [$name] with [$value]")
        null
    } else if (contents.containsValue(value)) {
        BUNDLE.logger.warn("Attempted to register duplicate of [$value] at [$identifier] in registry [$name]")
        null
    } else if (isValid(value, identifier)) {
        contents[identifier] = value
        value
    } else {
        BUNDLE.logger.warn("Attempted to insert invalid value [$value] at [$identifier] in registry [$name]")
        null
    }

    open fun isValid(value: T, identifier: K) = true

    override fun iterator() = contents.iterator()

    operator fun get(identifier: Identifier) = contents[identifier]
    operator fun set(identifier: Identifier, value: T) = register(identifier, value)

    operator fun set(identifier: Identifier, value: Any): T? {
        return register(identifier, valueType.safeCast(value) ?: return null)
    }
}