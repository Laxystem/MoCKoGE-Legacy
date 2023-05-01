package io.github.laylameower.hexgine.event

import io.github.laylameower.hexgine.NamedRegistry
import io.github.laylameower.hexgine.utils.at
import io.github.laylameower.hexgine.utils.events
import io.github.laylameower.hexgine.utils.hexagine

@Suppress("unused")
object EventRegistry: NamedRegistry<EventType<*, *>>(events at hexagine, EventType::class.java)