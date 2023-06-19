package io.github.laylameower.mockoge.core.event

import io.github.laylameower.mockoge.util.registry.Identifier
import io.github.laylameower.mockoge.Scene
import io.github.laylameower.mockoge.component.Component
import io.github.laylameower.mockoge.util.*


/**
 * Signifies this function implements an [event][EventType], and will be executed by the [Scene] when triggered.
 *
 * Must be used on [Component] functions, otherwise is useless.
 *
 * Intended to be inherited.
 * Use [IgnoredEventHandler] to explicitly ignore the function,
 * as the annotation *will* be inherited when implemented in Kotlin.
 *
 * @property namespace the [namespace][Identifier.namespace] of the [Identifier] the [event][EventType] this function implements is [registered][EventRegistry] under.
 * @property path the [path][Identifier.path] of the [Identifier] the [event][EventType] this function implements is [registered][EventRegistry] under.
 */
@Platform(AnnotationTarget.FUNCTION)
@Repeatable
public annotation class EventHandler(val namespace: String = mockoge, val path: String)
