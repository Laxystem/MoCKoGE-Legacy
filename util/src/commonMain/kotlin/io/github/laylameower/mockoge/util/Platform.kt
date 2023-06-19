package io.github.laylameower.mockoge.util

/**
 * @author Laxla
 */
public enum class Platform {
    JavaScript,
    Jvm,
    Native,

    @ExperimentalMultiplatform
    Wasm;

    @OptIn(ExperimentalMultiplatform::class)
    public val isExperimental: Boolean get() = this == Wasm

    /**
     * @see Platform.Companion.fileSystem
     * @see Platform.Companion.current
     */
    public companion object
}