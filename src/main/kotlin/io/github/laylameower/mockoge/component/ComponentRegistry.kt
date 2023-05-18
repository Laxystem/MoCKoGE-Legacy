package io.github.laylameower.mockoge.component

import io.github.laylameower.mockoge.Registry

public object ComponentRegistry: Registry<ComponentType<*>>(ComponentType::class)