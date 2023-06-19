package io.github.laylameower.mockoge.core.event

import io.github.laylameower.mockoge.util.registry.Identifier
import io.github.laylameower.mockoge.component.ComponentType
import io.github.laylameower.mockoge.util.*
import kotlin.reflect.KFunction
import kotlin.reflect.KType

internal typealias Event = suspend (Any?) -> Any?

public class EventType(
    public val returnType: KType = Unit::class.createType(),
    public val parameter: KType? = null
) {
    internal val eventCache: MutableMap<ComponentType<*>, MutableList<KFunction<*>>> = mutableMapOf<ComponentType<*>, MutableList<KFunction<*>>>()
    public val identifier: Identifier get() = EventRegistry[this]!!

    override fun toString(): String = identifier.toString()

    internal companion object : Disposable {
        override fun dispose() = EventRegistry.forEach {
            it.value.eventCache.clear()
        }
    }
}