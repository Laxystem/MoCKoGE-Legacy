package io.github.laylameower.mockoge

import io.github.laylameower.mockoge.util.*

public object RootRegistry : Registry<Registry<*>>(Registry::class) {
    init {
        register(root at mockoge, this)
    }
}
