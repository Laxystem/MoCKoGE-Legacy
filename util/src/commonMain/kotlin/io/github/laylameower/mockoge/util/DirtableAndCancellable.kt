package io.github.laylameower.mockoge.util

/**
 * Implementations of this interface allow their "dirtiness" to be canceled - for example, a camera component might cancel the rendering of a mesh component if it is outside the screen.
 * @author Laxla
 */
public interface DirtableAndCancellable : Dirtable {
    override var isDirty: Boolean

    override fun markDirty() {
        isDirty = true
    }
}