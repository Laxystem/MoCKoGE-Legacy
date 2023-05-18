@file:JvmName("Utilities")
@file:JvmMultifileClass
@file:Suppress("unused")

package io.github.laylameower.mockoge.util

import io.github.laylameower.mockoge.Identifier
import io.github.laylameower.mockoge.component.Component
import io.github.laylameower.mockoge.component.ComponentType
import io.github.laylameower.mockoge.Scene
import io.github.laylameower.mockoge.event.EventHandler
import io.github.z4kn4fein.semver.Version
import org.apache.logging.log4j.Logger
import org.lwjgl.glfw.GLFW
import org.lwjgl.glfw.GLFWVidMode
import java.io.BufferedReader
import java.io.File
import java.io.IOException
import java.io.InputStream
import java.security.MessageDigest
import java.util.zip.ZipException
import java.util.zip.ZipFile
import kotlin.jvm.Throws
import kotlin.script.experimental.api.ScriptDiagnostic

public val GLFWVidMode.x: Int get() = width()
public val GLFWVidMode.y: Int get() = height()

internal fun Map<Int, Int>.applyWindowHints() = forEach {
    GLFW.glfwWindowHint(it.key, it.value)
}

public infix fun String.at(namespace: String): Identifier = Identifier.of(namespace, this)
public val String.asIdentifier: Identifier? get() = Identifier.of(this)

public val String.asVersion: Version get() = Version.parse(this)
public val String.asStrictVersion: Version get() = Version.parse(this, true)

public operator fun <C : Component<C>> Scene.Entity.plusAssign(component: ComponentType<C>) {
    addComponent(component)
}

public operator fun <C : Component<C>> Scene.Entity.get(component: ComponentType<C>): C = getComponent(component)

public operator fun <C : Component<C>> Scene.plusAssign(component: ComponentType<C>) {
    addComponent(component)
}

public operator fun <C : Component<C>> Scene.get(component: ComponentType<C>): C = getComponent(component)

public val InputStream.asString: String get() = bufferedReader().use(BufferedReader::readText)

public inline fun <T : CharSequence, R> T.ifMatches(regex: Regex, block: (T) -> R): R? =
    if (regex.matches(this)) block(this) else null

public inline fun <T : CharSequence, R> T.ifNotMatches(regex: Regex, block: (T) -> R): T = also {
    if (!regex.matches(it)) block(it)
}

public val String.asFile: File
    get() = File(this).apply {
        parent?.let { File(it).mkdirs() }
    }

/**
 * Returns a file if one exists as this string as a path, or null if it doesn't.
 * @see File
 */
public val String.asExistingFile: File? get() = File(this).takeIf { it.exists() }

public val ScriptDiagnostic.asString: String
    get() = render(
        withSeverity = false,
        withLocation = true,
        withException = false,
        withStackTrace = false
    )

public fun ScriptDiagnostic.logTo(logger: Logger): Unit = when (severity) {
    ScriptDiagnostic.Severity.DEBUG -> logger.debug(asString, exception)
    ScriptDiagnostic.Severity.INFO -> logger.info(asString, exception)
    ScriptDiagnostic.Severity.WARNING -> logger.warn(asString, exception)
    ScriptDiagnostic.Severity.ERROR -> logger.error(asString, exception)
    ScriptDiagnostic.Severity.FATAL -> logger.fatal(asString, exception)
}

/**
 * All the Byte-Array related stuff were created by `Gaming32`, the creator of `Kilo Engine`.
 * @author Gaming32
 */
private val encoder = MessageDigest.getInstance("SHA-1")
private val secureEncoder = MessageDigest.getInstance("SHA3-224")

/**
 * Encodes the byte array under the `SHA3-224` algorithm.
 *
 * This is an unnecessary overkill for a game engine, considering we don't need the output to be secure,
 * yet it is a great way to see who reads the documentation.
 */
public val ByteArray.encodedSecurely: ByteArray
    get() = secureEncoder.run {
        reset()
        digest(this@encodedSecurely)
    }

public val ByteArray.encoded: ByteArray
    get() = encoder.run {
        reset()
        digest(this@encoded)
    }

public val ByteArray.asHexString: String get() = joinToString("") { it.toUByte().toString(16).padStart(2, '0') }

private val createCamelCaseRegex = "[^a-zA-Z][a-zA-Z]".toRegex()

public val String.asCamelCase: String get() = replace(createCamelCaseRegex) { it.value.last().uppercase() }

/**
 * Create a tree string from the files and directories stored under this file.
 *
 * @param level the indentation to render at.
 * @param isLast is this file the last one in its directory -
 * set this to true if you intend on printing the trees of multiple files (except the last one)
 * @param pipes a boolean array stored in an int, marking where pipes should not render (`true` = ignore, `false` = render).
 */
@OptIn(ExperimentalStdlibApi::class)
public fun File.toTreeString(level: Int = 0, isLast: Boolean = true, pipes: Int = 0): String = buildString {
    // TODO: replace bit-shifted boolean array with string
    val offset = buildString {
        for (i in 0..<level) {
            append(if ((pipes ushr i) % 2 == 0) "│   " else "    ")
        }
    }

    if (isDirectory) {
        append(offset)
        if (isLast) append("╰───┬─ ") else append("├───┬─ ")
        appendLine(name)

        val pipe = if (isLast) ' ' else '│'

        listFiles()?.apply {
            if (isEmpty()) {
                appendLine("$offset$pipe   ╰╌╌╌ empty")
            } else {
                val newPipes = if (isLast) pipes or (1 shl level) else pipes and (1 shl level).inv()
                val newLevel = level + 1

                sortedBy { !it.isDirectory }.forEachIndexed { index, it ->
                    append(it.toTreeString(level = newLevel, isLast = index == size - 1, newPipes))
                }
            }

        } ?: appendLine("$offset$pipe   ╰╌╌╌ IO Error")
    } else try {
        append(toZipTreeString(isLast, offset = offset))
    } catch (_: IOException) {
        append(offset)
        if (isLast) append("╰─── ") else append("├─── ")
        appendLine(name)
    }
}

@Throws(ZipException::class)
public fun File.toZipTreeString(isLast: Boolean = true, offset: String = ""): String = buildString {
    // TODO: add directories support
    val zip = ZipFile(this@toZipTreeString)

    append(offset)
    append(if (isLast) "╰" else "├")
    append("──┰─ ")
    appendLine(name)

    zip.entries().toList().let { list ->
        val offsetWithPipe = when { // Apparently this is a thing. More readable, for sure!
            isLast -> "$offset "
            else -> "$offset│"
        } + "  "

        if (list.isNotEmpty()) {
            list.sortedBy { it.name }.forEachIndexed { index, entry ->
                append(offsetWithPipe)
                append(if (index == list.size - 1) "┗" else "┣" )
                append("━━━ ")
                appendLine(entry.name)
            }
        } else {
            append(offsetWithPipe)
            appendLine("   ┗╍╍╍ empty")
        }
    }
}

public val File.asTreeString: String get() = toTreeString()
public val File.asZipTreeString: String get() = toZipTreeString()

public val EventHandler.asIdentifier: Identifier get() = path at namespace