@file:Suppress("unused", "MemberVisibilityCanBePrivate")

package io.github.laylameower.mockoge.core

import io.github.laylameower.mockoge.core.component.ComponentRegistry
import io.github.laylameower.mockoge.core.component.Component
import io.github.laylameower.mockoge.core.component.ComponentType
import io.github.laylameower.mockoge.core.event.Event
import io.github.laylameower.mockoge.core.event.EventType
import io.github.laylameower.mockoge.util.*
import io.github.laylameower.mockoge.util.registry.Identifier

public class Scene(public var title: String) : Iterable<Scene.Entity>, Dirtable {
    @PublishedApi
    internal val entities: MutableList<Entity> = mutableListOf()

    private val events: MutableMap<EventType, MutableList<Event>> = mutableMapOf()

    public val identifier: Identifier = SceneRegistry[this]!! // TODO

    /**
     * Returns the engine instance running the game.
     *
     * Should only be used inside a [Component] event.
     */
    public var engineInstance: Mockoge? = null
        internal set

    public val isCurrent: Boolean get() = engineInstance != null

    /**
     * Should events be re-calculated?
     */
    override var isDirty: Boolean = true
        internal set

    override fun markDirty() {
        isDirty = true
    }

    /**
     * Recalculates events if not [dirty][isDirty].
     */
    public fun recalculateEvents() {
        if (!isDirty) return

        /*
        for ((_, event) in EventRegistry) {
            val events = mutableListOf<Event>()

            components.forEach { component ->
                component::class.functions.forEach { function ->
                    if (function.findAnnotations<EventHandler>().any { it.asIdentifier == event.identifier } &&
                        !function.hasAnnotation<IgnoredEventHandler>() ||
                        function.returnType.isSubtypeOf(event.returnType) ||
                        if (event.parameter == null) function.parameters.isNotEmpty()
                        else {
                            function.parameters.size != 1 ||
                                    !function.parameters[0].type.isSupertypeOf(event.parameter)
                        }
                    ) return

                    @Suppress("LiftReturnOrAssignment") // IDEA bug: "+=" cannot be used with an if expression

                    if (event.parameter == null) {
                        events += { function.callSuspend(component) }
                    } else {
                        events += { function.callSuspend(component, it) }
                    }
                }
            }

            this.events[event] = events
        }
         */
    }

    private fun calculateEventsFor(@Suppress("UNUSED_PARAMETER") component: Component<*>) { // TODO: complete this
/*
        for ((_, event) in EventRegistry) {
            if (events[event] == null) events[event] = mutableListOf()

            event.eventCache[component.type].let {
                it ?: queryEventsFor(component.type).also { event.eventCache[component.type] = it}
            }.forEach { function ->
                if (event.parameter == null) {
                    events[event]!! += { function.callSuspend(component) }
                } else {
                    events[event]!! +=  { function.callSuspend(component, it) }
                }
            }
        }*/
    }

    public fun <C : Component<C>> addComponent(component: ComponentType<C>): C = Entity().let {
        it.addComponent(component).also { markDirty() }
    }

    public fun addComponents(vararg components: ComponentType<*>): Entity = Entity().also { entity ->
        entity.components.addAll(components.map { it.createComponentFor(entity) })
        markDirty()
    }

    public fun <C : Component<C>> getComponentOrNull(type: ComponentType<C>): C? =
        entities.firstNotNullOfOrNull { it.getComponentOrNull(type) }

    public fun <C : Component<C>> getComponent(type: ComponentType<C>): C = getComponentOrNull(type)
        ?: throw IllegalArgumentException("scene [$this] does not have component of type [$type]")

    public fun <T : Component<T>> getComponents(type: ComponentType<T>): Sequence<T> =
        entities.asSequence().flatMap { it.getComponents(type) }

    public inline fun <reified C : Component<C>> getComponentOrNull(): C? =
        entities.firstNotNullOfOrNull { it.getComponentOrNull<C>() }

    public inline fun <reified C : Component<C>> getComponent(): C = getComponentOrNull<C>()
        ?: throw IllegalArgumentException("scene [$this] does not have component of type [${C::class.simpleName}]")

    public inline fun <reified C : Component<C>> getComponents(): Sequence<C> =
        entities.asSequence().flatMap { it.getComponents<C>() }

    public inline val components: Sequence<Component<*>> get() = entities.asSequence().flatMap { it.components }

    override fun iterator(): Iterator<Entity> = entities.iterator()

    public inner class Entity internal constructor() : Iterable<Component<*>> {
        @PublishedApi
        internal val components: MutableList<Component<*>> = mutableListOf()

        public val scene: Scene get() = this@Scene

        init {
            entities += this
            markDirty()
        }

        public fun <C : Component<C>> addComponent(component: ComponentType<C>): C =
            component.createComponentFor(this).also {
                components += it
                markDirty()
            }

        @Suppress("UNCHECKED_CAST")
        public fun <C : Component<C>> getComponentOrNull(type: ComponentType<C>): C? =
            components.firstOrNull { it.type == type } as C?

        public fun <C : Component<C>> getComponent(type: ComponentType<C>): C = getComponentOrNull(type)
            ?: throw IllegalArgumentException("entity [$this] does not have component of type [${ComponentRegistry[type]}]")

        @Suppress("UNCHECKED_CAST")
        public fun <C : Component<C>> getComponents(type: ComponentType<C>): Sequence<C> =
            components.asSequence().filter { it.type == type }.map { it as C }

        public inline fun <reified C : Component<C>> getComponentOrNull(): C? = components.firstOrNull { it is C } as C?

        public inline fun <reified C : Component<C>> getComponent(): C = getComponentOrNull<C>()
            ?: throw IllegalArgumentException("entity [$this] does not have component of type [${C::class.simpleName}]")

        public inline fun <reified C : Component<C>> getComponents(): Sequence<C> =
            components.asSequence().filter { it is C }.map { it as C }

        override fun iterator(): Iterator<Component<*>> = components.iterator()
    }
}
