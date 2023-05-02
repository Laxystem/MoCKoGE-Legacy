package io.github.laylameower.mockoge.mesh

interface Mesh {
    val vertices: Array<Vertex>

    operator fun get(index: Int) = vertices[index]
}