@file:Suppress("MemberVisibilityCanBePrivate")

package io.github.laylameower.hexgine

import io.github.laylameower.hexgine.utils.applyWindowHints
import io.github.laylameower.hexgine.utils.asVersion
import io.github.laylameower.hexgine.utils.x
import io.github.laylameower.hexgine.utils.y
import org.joml.Vector2i
import org.lwjgl.glfw.Callbacks.glfwFreeCallbacks
import org.lwjgl.glfw.GLFW.*
import org.lwjgl.glfw.GLFWErrorCallback
import org.lwjgl.opengl.GL.createCapabilities
import org.lwjgl.opengl.GL30.*
import org.apache.logging.log4j.core.Version.getProductString as log4jVersion
import org.lwjgl.Version.getVersion as lwjglVersion
import org.lwjgl.glfw.GLFW.GLFW_TRUE as False
import org.lwjgl.glfw.GLFW.GLFW_TRUE as True
import org.lwjgl.glfw.GLFW.glfwInit as tryToInitialize
import org.lwjgl.system.MemoryUtil.NULL as Null

@Suppress("EmptyMethod")
abstract class Application : Runnable {
    abstract val title: String

    companion object {
        @JvmField
        internal val BUNDLE: Bundle =
            Bundle("hexagine", "Hexagine", System.getProperty("hexagine-version").asVersion, emptyMap())
    }

    private var window = 0L
    var windowSize = Vector2i(600, 400)
        private set
    val time
        get() = glfwGetTime()
    var lastLoopTime = 0.0
        private set
    var averageFPS = 0.0
        private set
    var fps = 0.0
        private set
    private var vao: Int = 0 // <- magic stuff it just works
    private var vbo: Int = 0 // <- they both exist dunno why


    override fun run() {
        BUNDLE.logger.info("Launching Hexagine (${BUNDLE.version}) with LWJGL (${lwjglVersion()}) & Log4J (${log4jVersion()})")
        if (!BUNDLE.version.isStable) BUNDLE.logger.warn("You're using an unstable version of Hexagine! Here be dragons!")

        try {
            initiate()
            runGameLoop()
        } catch (e: Exception) {
            BUNDLE.logger.fatal("Caught unhandled critical error. Expect disposal errors.", e)
        } finally {
            dispose()
        }
}

    private fun initiate() {
        GLFWErrorCallback.createPrint(System.err).set()

        if (!tryToInitialize()) throw IllegalStateException("GLFW initialization failed")

        glfwDefaultWindowHints()

        mapOf(
            GLFW_VISIBLE to False,
            GLFW_RESIZABLE to True,
            GLFW_OPENGL_FORWARD_COMPAT to True,
            GLFW_CONTEXT_VERSION_MAJOR to 3,
            GLFW_CONTEXT_VERSION_MINOR to 2,
            GLFW_OPENGL_PROFILE to GLFW_OPENGL_CORE_PROFILE

        ).applyWindowHints()

        window = glfwCreateWindow(windowSize.x, windowSize.y, title, Null, Null)

        if (window == Null) throw RuntimeException("GLFW window initialization failed")

        glfwSetKeyCallback(window, this::handleKeys)

        // center screen
        val resolution = glfwGetVideoMode(glfwGetPrimaryMonitor())!!
        glfwSetWindowPos(window, (resolution.x - windowSize.x) / 2, (resolution.y - windowSize.y) / 2)

        glfwMakeContextCurrent(window)
        glfwSwapInterval(1) // <- turn on vsync
        glfwShowWindow(window)

        createCapabilities()

        vao = glGenVertexArrays()
        glBindVertexArray(vao)

        vbo = glGenBuffers()
        glBindBuffer(GL_ARRAY_BUFFER, vbo)

        lastLoopTime = time
    }

    private fun runGameLoop() {
        while (!glfwWindowShouldClose(window)) {
            val time = time
            val deltaTime = time - lastLoopTime
            fps = 1 / deltaTime
            averageFPS = averageFPS * 0.95 + fps * 0.05
            lastLoopTime = time

            input()
            update(deltaTime)
            render()

            glfwSwapBuffers(window)
        }
    }

    private fun input() {
        glfwPollEvents()
        // TODO("Input")
    }

    @Suppress("unused", "UNUSED_PARAMETER")
    private fun update(deltaTime: Double) {}

    private fun render() {
        glClear(GL_DEPTH_BUFFER_BIT or GL_COLOR_BUFFER_BIT)

        glBindVertexArray(vao)
        glBindBuffer(GL_ARRAY_BUFFER, vbo)
    }

    private fun dispose() {
        BUNDLE.logger.debug("Disposing...")

        glfwFreeCallbacks(window)
        glfwDestroyWindow(window)

        glfwTerminate()
        glfwSetErrorCallback(null)?.free()

        BUNDLE.logger.info("Closed Hexagine after $time seconds.")
    }

    protected open fun handleKeys(window: Long, key: Int, scancode: Int, action: Int, mods: Int) {
        when (key) {
            GLFW_KEY_ESCAPE -> if (action == GLFW_RELEASE) glfwSetWindowShouldClose(window, true)
        }
    }
}