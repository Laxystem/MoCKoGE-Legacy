package io.github.laylameower.mockoge.event

import io.github.laylameower.mockoge.NamedRegistry
import io.github.laylameower.mockoge.util.at
import io.github.laylameower.mockoge.util.events
import io.github.laylameower.mockoge.util.mockoge

@Suppress("unused")
object EventRegistry: NamedRegistry<EventType<*, *>>(events at mockoge, EventType::class.java)