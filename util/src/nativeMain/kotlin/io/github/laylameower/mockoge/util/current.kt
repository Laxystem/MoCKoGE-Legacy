package io.github.laylameower.mockoge.util

import okio.FileSystem

public actual val Platform.Companion.current: Platform get() = Platform.Native
public actual val Platform.Companion.fileSystem: FileSystem get() = FileSystem.SYSTEM