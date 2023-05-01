package io.github.laylameower.hexgine.mesh

/**
 * Represents a static model, that cannot and would not change. Usually loaded from file.
 */
@Deprecated("May not be available in full release. Here for reference.")
data class Model(override val vertices: Array<Vertex>) : Mesh, Iterable<Vertex> by vertices.asIterable() {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Model

        return vertices.contentEquals(other.vertices)
    }

    override fun hashCode(): Int {
        return vertices.contentHashCode()
    }
}