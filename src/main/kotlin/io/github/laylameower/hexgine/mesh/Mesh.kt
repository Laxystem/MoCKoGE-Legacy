package io.github.laylameower.hexgine.mesh

interface Mesh {
    val vertices: Array<Vertex>

    operator fun get(index: Int) = vertices[index]
}