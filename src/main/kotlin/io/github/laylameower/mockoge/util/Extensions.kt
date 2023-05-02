@file:JvmName("Utilities")
@file:JvmMultifileClass
@file:Suppress("unused")

package io.github.laylameower.mockoge.util

import io.github.laylameower.mockoge.Identifier
import io.github.laylameower.mockoge.NamedRegistry
import io.github.laylameower.mockoge.Registry
import io.github.laylameower.mockoge.entity.Component
import io.github.laylameower.mockoge.entity.ComponentType
import io.github.laylameower.mockoge.entity.Entity
import io.github.laylameower.mockoge.scene.Scene
import io.github.z4kn4fein.semver.Version
import org.lwjgl.glfw.GLFW
import org.lwjgl.glfw.GLFWVidMode
import java.io.BufferedReader
import java.io.InputStream

val GLFWVidMode.x get() = width()
val GLFWVidMode.y get() = height()

internal fun Map<Int, Int>.applyWindowHints() = forEach {
    GLFW.glfwWindowHint(it.key, it.value)
}

infix fun String.at(namespace: String) = Identifier.of(namespace, this)
val String.asIdentifier get() = Identifier.of(this)

val String.asVersion get() = Version.parse(this)
val String.asStrictVersion get() = Version.parse(this, true)

operator fun <C : Component<C>> Entity.plusAssign(component: ComponentType<C>) {
    addComponent(component)
}

operator fun <C : Component<C>> Entity.get(component: ComponentType<C>) = getComponent(component)

operator fun <C : Component<C>> Scene.plusAssign(component: ComponentType<C>) {
    addComponent(component)
}

operator fun Scene.plusAssign(entity: Entity) {
    addEntity(entity)
}

operator fun <C : Component<C>> Scene.get(component: ComponentType<C>) = getComponent(component)

val InputStream.asString get() = bufferedReader().use(BufferedReader::readText)

operator fun <T : Any> Registry<T>.set(identifier: Identifier, value: Any): T? {
    return register(identifier, valueType.cast(value) ?: return null)
}

operator fun <T : Named<String>> NamedRegistry<T>.set(namespace: String, value: T) = register(namespace, value)