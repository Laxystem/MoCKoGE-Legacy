package io.github.laylameower.hexgine.entity

/**
 * Credit to *Gaming32* (check out his GitHub) for creating the Kilo Engine entity & event systems from which this one has been stolen.
 * @author Laxla
 * @author Gaming32
 */
@Suppress("unused")
class Entity : Iterable<Component<*>> {
    @PublishedApi
    internal val components = mutableListOf<Component<*>>()

    fun <C : Component<C>> addComponent(component: ComponentType<C>) =
        component.createComponentFor(this).also { components += it }

    @Suppress("UNCHECKED_CAST")
    fun <C : Component<C>> getComponentOrNull(type: ComponentType<C>) = components.firstOrNull { it.type == type } as C?

    fun <C : Component<C>> getComponent(type: ComponentType<C>) = getComponentOrNull(type)
        ?: throw IllegalArgumentException("entity [$this] does not have component of type [${ComponentRegistry[type]}]")

    @Suppress("UNCHECKED_CAST")
    fun <C : Component<C>> getComponents(type: ComponentType<C>) =
        components.asSequence().filter { it.type == type }.map { it as C }

    inline fun <reified C : Component<C>> getComponentOrNull() = components.firstOrNull { it is C } as C?

    inline fun <reified C : Component<C>> getComponent() = getComponentOrNull<C>()
        ?: throw IllegalArgumentException("entity [$this] does not have component of type [${C::class.java.simpleName}]")

    inline fun <reified C : Component<C>> getComponents() = components.asSequence().filter { it is C }.map { it as C }

    override fun iterator() = components.iterator()
}