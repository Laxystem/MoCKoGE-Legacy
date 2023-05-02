package io.github.laylameower.mockoge.entity

interface ComponentType<C : Component<C>> {
    fun createComponentFor(entity: Entity): C
}