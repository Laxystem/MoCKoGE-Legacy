package io.github.laylameower.mockoge.core

import io.github.laylameower.mockoge.core.util.*
import io.github.laylameower.mockoge.util.*
import io.github.laylameower.mockoge.util.registry.Registry

@InitializeFirst
public object RootRegistry : MockogeRegistry<Registry<*>>(Registry::class) {
    init {
        registerOrNull(root at mockoge, this)
    }
}
