package io.github.laylameower.mockoge.event

/**
 * Scenes won't execute event implementations annotated with this annotation.
 */
@Target(AnnotationTarget.FUNCTION)
@MustBeDocumented
public annotation class IgnoredEventHandler