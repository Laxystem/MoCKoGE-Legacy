package io.github.laylameower.mockoge.util

/**
 * Implementations of this interface rely on mutable data to calculate a heavy operation - and it is much more efficient to only do so when marked as changed - aka, dirty.
 * @author Laxla
 */
public interface Dirtable {
    /**
     * Has something that requires a re-calculation happened?
     *
     * Implementations should provide their own documentation as to what
     * has changed and what will be recalculated as a result of that change.
     */
    public val isDirty: Boolean

    /**
     * Sets [isDirty] to true.
     */
    public fun markDirty()
}
