package io.github.laylameower.mockoge.mesh

public interface Mesh {
    public val vertices: Array<Vertex>

    public operator fun get(index: Int): Vertex = vertices[index]
}