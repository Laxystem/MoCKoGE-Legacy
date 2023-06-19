@file:Suppress("unused")

package io.github.laylameower.mockoge.core.util

import io.github.laylameower.mockoge.core.mesh.Vertex
import io.github.laylameower.mockoge.math.Vector3f


public fun Vertex.bundleIntoSequence(): Sequence<Vertex> = sequenceOf(this)

public fun Vector3f.toVertex(color: Color = Color.WHITE): Vertex = Vertex(this, color)

public fun Array<Vector3f>.toVertices(color: Color = Color.WHITE): Sequence<Vertex> = asSequence().map { Vertex(it, color) }

public fun Sequence<Vertex>.removeDuplicates(): Sequence<Vertex> = distinct()