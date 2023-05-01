@file:JvmName("Utilities")
@file:JvmMultifileClass
@file:Suppress("unused")

package io.github.laylameower.hexgine.utils

import io.github.laylameower.hexgine.Identifier
import io.github.laylameower.hexgine.entity.Component
import io.github.laylameower.hexgine.entity.ComponentType
import io.github.laylameower.hexgine.entity.Entity
import io.github.laylameower.hexgine.scene.Scene
import io.github.z4kn4fein.semver.Version
import org.lwjgl.glfw.GLFW
import org.lwjgl.glfw.GLFWVidMode
import java.io.BufferedReader
import java.io.File
import java.io.InputStream
import java.util.zip.ZipEntry
import java.util.zip.ZipFile

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



fun getDirectory(path: String): File {
    val directory = File(path)
    if (!directory.exists()) directory.mkdirs()

    return directory
}

val InputStream.asString get() = bufferedReader().use(BufferedReader::readText)