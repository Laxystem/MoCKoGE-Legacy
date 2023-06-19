package io.github.laylameower.mockoge.core.component

import io.github.laylameower.mockoge.Scene
import org.joml.Vector3f
import org.joml.Vector3fc

public class Transform3DComponent(entity: Scene.Entity, position: Vector3fc = Vector3f()) : Component<Transform3DComponent>(Type, entity), Vector3fc by position {
    public companion object Type : ComponentType<Transform3DComponent> {
        override fun createComponentFor(entity: Scene.Entity): Transform3DComponent = Transform3DComponent(entity)
    }
}