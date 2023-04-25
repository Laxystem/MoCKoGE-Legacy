package io.github.laylameower.hexgine

import kotlin.reflect.KClass

/**
 * Registries are rings, because I said so.
 */
object RootRegistry: Registry<Registry<*, *>, KClass<*>>(Registry::class, KClass::class)