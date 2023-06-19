package io.github.laylameower.mockoge.core.component

import io.github.laylameower.mockoge.util.registry.Registry

public object ComponentRegistry: Registry<ComponentType<*>>(ComponentType::class)