package io.github.laylameower.mockoge.loader.kts

import io.github.laylameower.mockoge.Registry
import kotlin.collections.mutableMapOf
import kotlin.collections.set

public class RegistryScript {
    internal val registries = mutableMapOf<String, Registry<*>>()

    public infix fun <T : Any> String.to(registry: Registry<T>) {
        registries[this] = registry
    }
}
