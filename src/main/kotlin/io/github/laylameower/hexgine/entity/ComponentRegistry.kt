package io.github.laylameower.hexgine.entity

import io.github.laylameower.hexgine.Registry
import io.github.laylameower.hexgine.utils.at
import io.github.laylameower.hexgine.utils.components
import io.github.laylameower.hexgine.utils.hexagine

object ComponentRegistry: Registry<ComponentType<*>>(components at hexagine, ComponentType::class.java)