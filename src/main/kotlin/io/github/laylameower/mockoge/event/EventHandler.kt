package io.github.laylameower.mockoge.event

import io.github.laylameower.mockoge.Identifier
import io.github.laylameower.mockoge.Scene
import io.github.laylameower.mockoge.component.Component
import io.github.laylameower.mockoge.util.*
import java.lang.annotation.Inherited


/**
 * Signifies this function implements an [event][EventType], and will be executed by the [Scene] when triggered.
 *
 * Must be used on [Component] functions, otherwise is useless.
 *
 * Meant to be [inherited][Inherited].
 * Use [IgnoredEventHandler] to explicitly ignore the function,
 * as the annotation *will* be inherited when implemented in Kotlin.
 *
 * @property namespace the [namespace][Identifier.namespace] of the [Identifier] the [event][EventType] this function implements is [registered][EventRegistry] under.
 * @property path the [path][Identifier.path] of the [Identifier] the [event][EventType] this function implements is [registered][EventRegistry] under.
 */
@Target(AnnotationTarget.FUNCTION)
@Repeatable
public annotation class EventHandler(val namespace: String = mockoge, val path: String)
