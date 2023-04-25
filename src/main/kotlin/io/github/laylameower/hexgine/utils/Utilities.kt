@file:JvmName("Utilities")
@file:JvmMultifileClass

package io.github.laylameower.hexgine.utils

import io.github.laylameower.hexgine.Application
import io.github.z4kn4fein.semver.Version
import org.lwjgl.glfw.GLFW
import org.lwjgl.glfw.GLFWVidMode

val GLFWVidMode.x
    get() = width()

val GLFWVidMode.y
    get() = height()

/**
 * Uses the map as the GLFW window hints. If you don't know what you're doing, don't use this.
 */
fun Map<Int, Int>.applyWindowHints() = forEach {
    GLFW.glfwWindowHint(it.key, it.value)
}

internal val String.asIdentifier
    get() = Application.BUNDLE.createIdentifier(this)

val String.asVersion
    get() = Version.parse(this)

val String.asStrictVersion
    get() = Version.parse(this, true)