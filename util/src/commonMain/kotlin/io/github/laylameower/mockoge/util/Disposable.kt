package io.github.laylameower.mockoge.util

import okio.Closeable

/**
 * Implementations of this interface can be [closed][Closeable.close] without exceptions, and will dispose of every [Disposable] field they contain within them.
 * @author Laxla
 */
@OptIn(ExperimentalStdlibApi::class)
public interface Disposable : AutoCloseable {
    /**
     * Dispose of this resource.
     * @see AutoCloseable.close
     */
    public fun dispose()

    @Deprecated("Inconsistent", ReplaceWith("dispose()"), DeprecationLevel.HIDDEN)
    override fun close() {
        dispose()
    }
}