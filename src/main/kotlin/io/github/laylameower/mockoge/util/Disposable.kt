package io.github.laylameower.mockoge.util

/**
 * Implementations of this interface cache objects that may need to be disposed of on registry re-load.
 */
public interface Disposable {
    public fun dispose()
}