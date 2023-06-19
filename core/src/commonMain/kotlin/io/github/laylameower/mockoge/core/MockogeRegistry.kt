package io.github.laylameower.mockoge.core

import io.github.laylameower.mockoge.util.isNotValid
import io.github.laylameower.mockoge.util.mockoge
import io.github.laylameower.mockoge.util.registry.Identifier
import io.github.laylameower.mockoge.util.registry.Registry
import io.github.oshai.KotlinLogging
import kotlin.reflect.KClass

public abstract class MockogeRegistry<T : Any>(valueType: KClass<T>) : Registry<T>(valueType) {
    public override val name: Identifier get() = RootRegistry[this]!!

    /**
     * Should this entry-identifier pair be allowed to register?
     *
     * By default, returns false if one of the following is true:
     * - an entry is already registered with the given [identifier]
     * - the given [entry] already exists in the registry
     * - registries are frozen (some registries may ignore this requirement)
     * - the given [entry] isn't valid
     */
    override fun isValid(entry: T, identifier: Identifier): Boolean = when {
        this contains identifier -> {
            LOGGER.warn { "Attempted to override [$identifier] with [$entry] in registry [$this]" }
            false
        }

        this contains entry -> {
            LOGGER.warn { "Attempted to register duplicate of [$entry] at [$identifier] in registry [$this]" }
            false
        }

        entry.isNotValid() -> {
            LOGGER.warn { "Attempted to insert invalid entry [$entry] at [$identifier] in registry [$this]" }
            false
        }

        isFrozen -> false

        else -> true
    }

    override fun toString(): String = "$name of ${valueType.simpleName}"

    public companion object {
        private val LOGGER = KotlinLogging.logger("$mockoge/registry")

        public var isFrozen: Boolean = true
            internal set(value) {
                LOGGER.info { "${if (value) "" else "un"}freezing registries..." }
                field = value
            }
    }
}