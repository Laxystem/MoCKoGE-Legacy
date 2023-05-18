package io.github.laylameower.mockoge.mesh

public data class Triangle(val vertex1: Vertex, val vertex2: Vertex, val vertex3: Vertex) {
    /**
     * Rotate the triangle from clockwise, to counterclockwise, and vice-versa.
     */
    public fun opposite(): Triangle = copy(vertex1 = vertex3, vertex3 = vertex1)

    val asVertexArray: Array<Vertex> = arrayOf(vertex1, vertex2, vertex3)
}
