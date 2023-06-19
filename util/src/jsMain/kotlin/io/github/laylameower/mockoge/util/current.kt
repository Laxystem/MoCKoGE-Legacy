package io.github.laylameower.mockoge.util

import okio.FileSystem
import okio.NodeJsFileSystem

public actual val Platform.Companion.current: Platform get() = Platform.JavaScript
public actual val Platform.Companion.fileSystem: FileSystem
    get() = NodeJsFileSystem