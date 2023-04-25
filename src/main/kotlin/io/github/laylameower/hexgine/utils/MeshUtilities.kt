@file:JvmName("Utilities")
@file:JvmMultifileClass

package io.github.laylameower.hexgine.utils

import io.github.laylameower.hexgine.mesh.Vertex
import org.joml.Vector3f
import java.awt.Color

fun Vertex.bundleIntoSequence() = sequenceOf(this)

fun Vector3f.toVertex(color: Color = Color.WHITE) = Vertex(this, color)

fun Array<Vector3f>.toVertices(color: Color = Color.WHITE) = asSequence().map { Vertex(it, color) }

fun Sequence<Vertex>.removeDuplicates() = distinct()