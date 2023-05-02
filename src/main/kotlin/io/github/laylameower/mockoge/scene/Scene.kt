package io.github.laylameower.mockoge.scene

import io.github.laylameower.mockoge.entity.Component
import io.github.laylameower.mockoge.entity.ComponentType
import io.github.laylameower.mockoge.entity.Entity

/**
 * @see Entity
 * @author Laxla
 * @author Gaming32
 */
@Suppress("unused")
class Scene(var title: String) : Iterable<Entity> {
    @PublishedApi
    internal val entities = mutableListOf<Entity>()

    fun addEntity(entity: Entity) {
        if (!entities.contains(entity)) entities += entity
    }

    fun <C : Component<C>> addComponent(component: ComponentType<C>) = Entity().let {
        entities.add(it)
        it.addComponent(component)
    }

    fun <C : Component<C>> getComponentOrNull(type: ComponentType<C>) =
        entities.firstNotNullOfOrNull { it.getComponentOrNull(type) }

    fun <C : Component<C>> getComponent(type: ComponentType<C>) = getComponentOrNull(type)
        ?: throw IllegalArgumentException("scene [$this] does not have component of type [$type]")

    fun <T : Component<T>> getComponents(type: ComponentType<T>) =
        entities.asSequence().flatMap { it.getComponents(type) }

    inline fun <reified C : Component<C>> getComponentOrNull() =
        entities.firstNotNullOfOrNull { it.getComponentOrNull<C>() }

    inline fun <reified C : Component<C>> getComponent() = getComponentOrNull<C>()
        ?: throw IllegalArgumentException("scene [$this] does not have component of type [${C::class.java.simpleName}]")

    inline fun <reified C : Component<C>> getComponents() = entities.asSequence().flatMap { it.getComponents<C>() }

    override fun iterator() = entities.iterator()
}
