package io.github.laylameower.mockoge.entity

import io.github.laylameower.mockoge.Registry
import io.github.laylameower.mockoge.util.at
import io.github.laylameower.mockoge.util.components
import io.github.laylameower.mockoge.util.mockoge

object ComponentRegistry: Registry<ComponentType<*>>(components at mockoge, ComponentType::class.java)