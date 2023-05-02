package io.github.laylameower.mockoge

import io.github.laylameower.mockoge.util.registries

object RootRegistry: Registry<Registry<*>>(registries, Registry::class.java)