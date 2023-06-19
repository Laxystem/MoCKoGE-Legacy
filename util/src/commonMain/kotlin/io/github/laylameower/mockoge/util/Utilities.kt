@file:Suppress("unused")

package io.github.laylameower.mockoge.util

import io.github.laylameower.mockoge.util.registry.Identifier
import okio.FileSystem
import okio.Path
import kotlin.reflect.KClass

/**
 * Get the platform Kotlin is ran on.
 */
public expect val Platform.Companion.current: Platform

/**
 * Creates an [Identifier]
 * @author Laxla
 */
public infix fun String.at(namespace: String): Identifier = Identifier(namespace, this)

/**
 * Try parsing an [Identifier] from the provided string, or return null.
 * @author Laxla
 */
public fun String.toIdentifierOrNull(): Identifier? = Identifier.of(this)

/**
 * Try parsing an [Identifier] from the provided String, throw an exception on failure.
 * @throws IllegalArgumentException if cannot parse an identifier.
 * @author Laxla
 */
public fun String.toIdentifier(): Identifier =
    toIdentifierOrNull() ?: throw IllegalArgumentException("Cannot parse identifier from string [$this]")

/**
 * The same as using [takeIf] with [Regex.matches].
 * @see ifNotMatches
 * @author Laxla
 */
public inline fun <T : CharSequence, R> T.ifMatches(regex: Regex, block: (T) -> R): R? =
    if (regex.matches(this)) block(this) else null

/**
 * The same as using [takeIf] with [Regex.matches], except it's the opposite.
 * @see ifMatches
 * @author Laxla
 */
public inline fun <T : CharSequence, R> T.ifNotMatches(regex: Regex, block: (T) -> R): T = also {
    if (!regex.matches(it)) block(it)
}

/**
 * Renders the byte array as a string of hexadecimal numbers.
 * @author Gaming32
 */
public fun ByteArray.toHexString(): String = joinToString("") { it.toUByte().toString(16).padStart(2, '0') }

private val createCamelCaseRegex = "[^a-zA-Z][a-zA-Z]".toRegex()

/**
 * Converts the string to camelCase.
 * @author Laxla
 */
public fun String.camelCase(): String = replace(createCamelCaseRegex) { it.value.last().uppercase() }

/*

/**
 * Create a tree string from the files and directories stored under this file.
 *
 * @param level the indentation to render at.
 * @param isLast is this file the last one in its directory -
 * set this to true if you intend on printing the trees of multiple files (except the last one)
 * @param pipes a boolean array stored in an int, marking where pipes should not render (`true` = ignore, `false` = render).
 */
@OptIn(ExperimentalStdlibApi::class)
public fun File.toTreeString(level: Int = 0, isLast: Boolean = true, pipes: Int = 0): String =
    buildString { // TODO: Okio
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

@Throws(ZipException::class) // TODO: Okio
public fun File.toZipTreeString(isLast: Boolean = true, offset: String = ""): String = buildString { // TODO: Okio
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
                append(if (index == list.size - 1) "┗" else "┣")
                append("━━━ ")
                appendLine(entry.name)
            }
        } else {
            append(offsetWithPipe)
            appendLine("   ┗╍╍╍ empty")
        }
    }
}

public val File.asTreeString: String get() = toTreeString() // TODO: Okio
public val File.asZipTreeString: String get() = toZipTreeString() // TODO: okio

*/

/**
 * @author Laxla
 */
public inline val Validatable.isNotValid: Boolean get() = !isValid

/**
 * Returns itself if [valid][Validatable.isValid], null otherwise.
 * @author Laxla
 */
public inline val <V : Validatable> V?.validOrNull: V? get() = if (this != null && isValid) this else null

/**
 * Throws an [exception][InvalidArgumentException] if not [valid][Validatable.isValid].
 * @author Laxla
 */
public inline fun <reified T : Any?> T.validate(message: (T) -> String = { "Found invalid [${T::class.simpleName}]: [$it]" }): T = also {
    if (it.isNotValid()) throw InvalidArgumentException(message(it))
}

/**
 * Returns [Validatable.isValid] if [Validatable], else false.
 * @author Laxla
 */
public inline fun Any?.isValid(): Boolean = this?.let { this !is Validatable || isValid } ?: false

/**
 * Returns `false` if [Any.isValid], else true.
 * @author Laxla
 */
public inline fun Any?.isNotValid(): Boolean = !isValid()