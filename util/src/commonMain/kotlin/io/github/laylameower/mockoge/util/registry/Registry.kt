package io.github.laylameower.mockoge.util.registry

import io.github.laylameower.mockoge.util.InvalidArgumentException
import io.github.laylameower.mockoge.util.Validatable
import io.github.laylameower.mockoge.util.isValid
import io.github.laylameower.mockoge.util.validate
import kotlin.collections.Iterable
import kotlin.collections.Iterator
import kotlin.collections.Map
import kotlin.collections.asSequence
import kotlin.collections.iterator
import kotlin.collections.mutableMapOf
import kotlin.collections.set
import kotlin.reflect.KClass
import kotlinx.collections.immutable.toImmutableMap
import kotlin.reflect.safeCast

/**
 * Stores entries of a [specific type][T] under unique identifiers.
 *
 * @param T the type of entries this registry stores
 * @property valueType the type of entries this registry stores, for JVM reasons.
 * @author Laxla
 */
public abstract class Registry<T : Any>(public val valueType: KClass<T>) : Iterable<Map.Entry<Identifier, T>> {
    private val entries = mutableMapOf<Identifier, T>()
    private val tags = mutableMapOf<Identifier, Tag>()

    /**
     * The name this registry is registered under. Fun stuff.
     */
    public abstract val name: Identifier

    /**
     * Should [tags][Tag] be modifiable?
     *
     * If false, an [UnsupportedOperationException] will be thrown on tag modification.
     */
    public abstract val isTagModificationAllowed: Boolean

    /**
     * Adds an [entry] to the registry.
     *
     * May return `null` if the identifier and/or entry aren't [valid][Registry.isValid].
     * @author Laxla
     */
    public fun registerOrNull(identifier: Identifier, entry: T): T? = if (isValid(entry, identifier)) {
        entries[identifier] = entry
        entry
    } else null

    /**
     * Adds an [entry] to the registry.
     *
     * May throw an [InvalidArgumentException] if the identifier and/or entry aren't [valid][Registry.isValid]
     */
    public fun register(identifier: Identifier, entry: T): T = registerOrNull(identifier, entry)
        ?: throw InvalidArgumentException("Invalid entry [$entry] of type [${entry::class.simpleName}] and/or identifier [$identifier] (Registry of [${valueType.simpleName}])")

    /**
     * [Registers][registerOrNull] the given [entry] if its type matches the [Registry's][T].
     * @author Laxla
     */
    public operator fun set(identifier: Identifier, entry: Any): T? = valueType.safeCast(entry)?.let {
        registerOrNull(identifier, it)
    }

    /**
     * Should this entry-identifier pair be allowed to register?
     *
     * By default, returns null if one of the following is true:
     * - an entry is already registered under the given [identifier]
     * - the given [entry] already exists in the registry
     * - the given [entry] isn't [valid][Any.isValid]
     *
     * @author Laxla
     */
    public open fun isValid(entry: T, identifier: Identifier): Boolean =
        !entries.containsKey(identifier) && !entries.containsValue(entry) && entry.isValid()

    public open fun isValid(identifier: Identifier, tag: Tag): Boolean = identifier !in tag

    override fun iterator(): Iterator<Map.Entry<Identifier, T>> = entries.toImmutableMap().iterator()

    /**
     * Get the entry stored under the provided [identifier]
     * @param identifier the [Identifier] to look under
     */
    public operator fun get(identifier: Identifier): T? = entries[identifier]

    /**
     * Get the identifier the provided [entry] is stored under
     */
    public operator fun get(entry: T): Identifier? =
        entries.asSequence().filter { it.value == entry }.firstOrNull()?.key

    override fun toString(): String = "registry of ${valueType.simpleName}"

    public infix operator fun contains(identifier: Identifier): Boolean = entries.containsKey(identifier)
    public infix operator fun contains(entry: T): Boolean = entries.containsValue(entry)

    /**
     * Provides the tag stored under
     */
    public infix fun tag(identifier: Identifier): Tag =
        tags.asSequence().filter { it.key == identifier }.firstNotNullOfOrNull { it.value } ?: Tag(identifier)


    public inner class Tag internal constructor(
        identifier: Identifier
    ) : Iterable<Identifier>, Validatable by identifier {
        private val contents: MutableList<Identifier> = mutableListOf()

        public val registry: Registry<T> get() = this@Registry
        public val identifier: Identifier get() = tags.asSequence().filter { it.value === this }.first().key

        init {
            validate { "Invalid tag found: The registry might already contain an instance of this tag, or the identifier used to create the tag was created invalidly by created unknown means " }
            tags[identifier] = this
        }

        /**
         * Adds the provided [identifier] to this tag.
         *
         * @param identifier the [Identifier] of the entry to be added to this [Tag].
         * @see add
         */
        public operator fun plusAssign(identifier: Identifier) {
            if (isValid(identifier, this)) contents += identifier
        }

        /**
         * Recursively adds all provided [identifiers] to this tag, skipping invalid ones.
         *
         * It is assumed prevention of addition is intended, and isn't failure, unlike [Registry] entry addition - for that reason,
         * it is not reported to the user if the addition has failed.
         *
         * @see plusAssign
         */
        public fun add(vararg identifiers: Identifier) {
            identifiers.forEach { this += it }
        }

        override fun iterator(): Iterator<Identifier> = contents.asSequence().iterator()
        override fun toString(): String = "${registry.name}$tagMarker${super.toString()}"
    }

    public companion object {
        public const val tagMarker: Char = '#'

        public val tagRegex: Regex = "$tagMarker${Identifier.fullRegex}".toRegex()
    }
}