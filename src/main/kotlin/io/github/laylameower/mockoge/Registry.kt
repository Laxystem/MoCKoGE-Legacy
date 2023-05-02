package io.github.laylameower.mockoge

import io.github.laylameower.mockoge.Mockoge.Companion.bundle
import io.github.laylameower.mockoge.util.Named
import io.github.laylameower.mockoge.util.mockoge
import org.apache.logging.log4j.LogManager

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
        bundle.logger.warn("Attempted to override [$identifier] in registry [$name] with [$value]")
        null
    } else if (contents.containsValue(value)) {
        bundle.logger.warn("Attempted to register duplicate of [$value] at [$identifier] in registry [$name]")
        null
    } else if (isValid(value, identifier)) {
        contents[identifier] = value
        value
    } else {
        bundle.logger.warn("Attempted to insert invalid value [$value] at [$identifier] in registry [$name]")
        null
    }

    open fun isValid(value: T, identifier: Identifier) = !isFrozen

    override fun iterator() = contents.iterator()

    operator fun get(identifier: Identifier) = contents[identifier]
    operator fun get(value: T) = contents.asSequence().filter { it.value == value }.firstOrNull()?.key

    companion object {
        private val LOGGER = LogManager.getLogger("$mockoge/registry")

        var isFrozen = true
            private set

        internal fun unfreeze() {
            LOGGER.info("Unfreezing registries...")
            isFrozen = false
        }

        internal fun freeze() {
            LOGGER.info("Freezing registries...")
            isFrozen = true
        }
    }
}