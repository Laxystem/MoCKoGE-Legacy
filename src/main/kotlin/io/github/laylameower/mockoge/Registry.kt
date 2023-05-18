package io.github.laylameower.mockoge

import io.github.laylameower.mockoge.util.*
import org.apache.logging.log4j.LogManager
import kotlin.collections.Iterable
import kotlin.collections.Iterator
import kotlin.collections.Map
import kotlin.collections.asSequence
import kotlin.collections.iterator
import kotlin.collections.mutableMapOf
import kotlin.collections.set
import kotlin.reflect.KClass
import kotlin.reflect.full.safeCast
import kotlinx.collections.immutable.toImmutableMap

/**
 * Stores entries of a [specific type][T] under unique identifiers.
 * @param T the type of entries this registry stores
 * @property valueType the type of entries this registry stores, for JVM reasons.
 */
public abstract class Registry<T : Any>(public val valueType: KClass<T>) :
    Iterable<Map.Entry<Identifier, T>>{
    private val entries = mutableMapOf<Identifier, T>()

    /**
     * registries are kept in the [RootRegistry], which is included in the [RootRegistry],
     * which is included in the [RootRegistry]...
     */
    public val name: Identifier get() = RootRegistry[this]!!

    /**
     * Adds an [entry] to the registry.
     *
     * May return `null` if:
     * - an entry is already registered with the given [identifier]
     * - the given [entry] already exists in the registry
     * - registries are frozen (some registries may ignore this requirement)
     * - the registry doesn't deem the provided [entry] and [identifier] to be [valid][isValid]
     */
    public fun register(identifier: Identifier, entry: T): T? = if (entries.containsKey(identifier)) {
        LOGGER.warn("Attempted to override [$identifier] in registry [$name] with [$entry]")
        null
    } else if (entries.containsValue(entry)) {
        LOGGER.warn("Attempted to register duplicate of [$entry] at [$identifier] in registry [$name]")
        null
    } else if (isValid(entry, identifier)) {
        entries[identifier] = entry
        entry
    } else {
        LOGGER.warn("Attempted to insert invalid value [$entry] at [$identifier] in registry [$name]")
        null
    }

    /**
     * [Registers][register] the given [entry] if its type matches the [Registry's][T].
     */
    public operator fun set(identifier: Identifier, entry: Any): T? = valueType.safeCast(entry)?.let {
        register(identifier, it)
    }

    public open fun isValid(entry: T, identifier: Identifier): Boolean = !isFrozen

    override fun iterator(): Iterator<Map.Entry<Identifier, T>> = entries.toImmutableMap().iterator()

    public operator fun get(identifier: Identifier): T? = entries[identifier]
    public operator fun get(entry: T): Identifier? = entries.asSequence().filter { it.value == entry }.firstOrNull()?.key

    override fun toString(): String = "$name of ${valueType.simpleName}"

    public val T.identifier: Identifier? get() = this@Registry[this]

    public fun contains(identifier: Identifier): Boolean = entries.containsKey(identifier)
    public fun contains(entry: T): Boolean = entries.containsValue(entry)

    public companion object {
        private val LOGGER = LogManager.getLogger("$mockoge/registry")

        public var isFrozen: Boolean = true
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