package io.github.laylameower.hexgine.mesh

import io.github.laylameower.hexgine.utils.Dirtable

interface ProceduralMesh: Mesh, Dirtable {
    /**
     * Will be called if [isDirty]
     */
    fun preRender()
}