package io.github.laylameower.mockoge.util

import okio.FileSystem
import java.io.BufferedReader
import java.io.InputStream

public actual val Platform.Companion.current: Platform get() = Platform.Jvm
public actual val Platform.Companion.fileSystem: FileSystem
    get() = FileSystem.SYSTEM

public val InputStream.asString: String get() = bufferedReader().use(BufferedReader::readText) // TODO: Okio