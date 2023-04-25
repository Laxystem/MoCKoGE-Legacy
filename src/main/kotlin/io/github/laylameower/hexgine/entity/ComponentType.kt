package io.github.laylameower.hexgine.entity

interface ComponentType<C : Component> {
    fun createComponentFor(entity: Entity): C
}