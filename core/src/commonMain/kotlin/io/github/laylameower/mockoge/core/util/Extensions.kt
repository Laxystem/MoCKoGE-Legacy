package io.github.laylameower.mockoge.core.util

import io.github.laylameower.mockoge.core.RootRegistry
import io.github.laylameower.mockoge.core.Scene
import io.github.laylameower.mockoge.core.component.Component
import io.github.laylameower.mockoge.core.component.ComponentType
import io.github.laylameower.mockoge.core.event.EventHandler
import io.github.laylameower.mockoge.util.registry.Identifier
import io.github.laylameower.mockoge.util.registry.Registry
import io.github.laylameower.mockoge.util.at
import io.github.laylameower.mockoge.util.mockoge

public val EventHandler.asIdentifier: Identifier get() = path at namespace

public operator fun <C : Component<C>> Scene.Entity.plusAssign(component: ComponentType<C>) {
    addComponent<C>(component)
}

public operator fun <C : Component<C>> Scene.Entity.get(component: ComponentType<C>): C = getComponent(component)

public operator fun <C : Component<C>> Scene.plusAssign(component: ComponentType<C>) {
    addComponent<C>(component)
}

public operator fun <C : Component<C>> Scene.get(component: ComponentType<C>): C = getComponent(component)

/**
 * Does this identifier belong to the engine's or an official module's namespace?
 */
public val Identifier.isOfficial: Boolean get() = namespace.startsWith(mockoge)

/**
 * registries are kept in the [RootRegistry], which is included in the [RootRegistry],
 * which is included in the [RootRegistry]...
 * @author Laxla
 */
public val Registry<*>.name: Identifier get() = RootRegistry[this]!!