package io.github.laylameower.hexgine

import io.github.laylameower.hexgine.Hexagine.Companion.BUNDLE
import io.github.laylameower.hexgine.utils.Named

/**
 * @param T value type
 */
abstract class Registry<T : Any>(override val name: Identifier, val valueType: Class<T>) :
    Iterable<Map.Entry<Identifier, T>>, Named<Identifier> {
    private val contents = mutableMapOf<Identifier, T>()

    init {
        @Suppress("LeakingThis")
        RootRegistry.register(name, this)
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

    open fun isValid(value: T, identifier: Identifier) = !isFrozen

    override fun iterator() = contents.iterator()

    operator fun get(identifier: Identifier) = contents[identifier]
    operator fun get(value: T) = contents.asSequence().filter { it.value == value }.firstOrNull()?.key

    operator fun set(identifier: Identifier, value: Any): T? {
        return register(identifier, valueType.cast(value) ?: return null)
    }

    companion object {
        var isFrozen = true
            private set

        internal fun unfreeze() {
            BUNDLE.logger.info("Unfreezing registries...")
            isFrozen = false
        }

        internal fun freeze() {
            BUNDLE.logger.info("Freezing registries...")
            isFrozen = true
        }
    }
}