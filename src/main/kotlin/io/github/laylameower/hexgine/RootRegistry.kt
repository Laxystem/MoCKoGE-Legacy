package io.github.laylameower.hexgine

import io.github.laylameower.hexgine.utils.registries

object RootRegistry: Registry<Registry<*>>(registries, Registry::class.java)