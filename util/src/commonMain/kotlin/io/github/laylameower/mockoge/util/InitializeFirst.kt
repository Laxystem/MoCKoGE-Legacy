package io.github.laylameower.mockoge.util

/**
 * If possible on the target platform, do not initialize this property lazily.
 */
@OptIn(ExperimentalMultiplatform::class)
@OptionalExpectation
public expect annotation class InitializeFirst()