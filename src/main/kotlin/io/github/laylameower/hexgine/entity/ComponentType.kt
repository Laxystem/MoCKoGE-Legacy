package io.github.laylameower.hexgine.entity

interface ComponentType<C : Component<C>> {
    fun createComponentFor(entity: Entity): C
}