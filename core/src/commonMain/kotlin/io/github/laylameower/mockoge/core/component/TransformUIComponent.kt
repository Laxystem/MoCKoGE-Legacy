package io.github.laylameower.mockoge.core.component

import io.github.laylameower.mockoge.Scene
import org.joml.Vector3i
import org.joml.Vector3ic

public class TransformUIComponent(entity: Scene.Entity, position: Vector3ic = Vector3i()) :
    Component<TransformUIComponent>(Type, entity), Vector3ic by position {

    public companion object Type : ComponentType<TransformUIComponent> {
        override fun createComponentFor(entity: Scene.Entity): TransformUIComponent = TransformUIComponent(entity)
    }
}