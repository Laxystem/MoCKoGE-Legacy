package io.github.laylameower.mockoge.core.loader.kts

import io.github.laylameower.mockoge.Registry

public class RegistryScript {
    internal val registries = mutableMapOf<String, Registry<*>>()

    public infix fun <T : Any> String.to(registry: Registry<T>) {
        registries[this] = registry
    }
}