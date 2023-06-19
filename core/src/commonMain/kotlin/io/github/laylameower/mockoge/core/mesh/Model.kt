package io.github.laylameower.mockoge.core.mesh

/**
 * Represents a static model, that cannot and would not change. Usually loaded from file.
 */
@Suppress("DEPRECATION")
@Deprecated("May not be available in full release. Here for reference.")
public data class Model(override val vertices: Array<Vertex>) : Mesh, Iterable<Vertex> by vertices.asIterable() {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other === null || this::class != other::class) return false

        other as Model

        return vertices.contentEquals(other.vertices)
    }

    override fun hashCode(): Int {
        return vertices.contentHashCode()
    }
}