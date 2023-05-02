@file:JvmName("Utilities")
@file:JvmMultifileClass
@file:Suppress("unused")

package io.github.laylameower.mockoge.util

import java.io.File

fun getDirectory(path: String): File {
    val directory = File(path)
    if (!directory.exists()) directory.mkdirs()

    return directory
}