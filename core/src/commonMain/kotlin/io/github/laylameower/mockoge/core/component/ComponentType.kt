package io.github.laylameower.mockoge.core.component

import io.github.laylameower.mockoge.Scene

public interface ComponentType<C : Component<C>> {
    public fun createComponentFor(entity: Scene.Entity): C // TODO: Improve this function to support component configuration
}