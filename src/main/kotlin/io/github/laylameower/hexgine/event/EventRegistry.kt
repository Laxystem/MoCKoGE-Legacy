package io.github.laylameower.hexgine.event

import io.github.laylameower.hexgine.NamedRegistry

object EventRegistry: NamedRegistry<EventType<*, *>, String>(EventType::class)