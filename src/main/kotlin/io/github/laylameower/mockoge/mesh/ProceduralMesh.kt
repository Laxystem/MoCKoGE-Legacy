package io.github.laylameower.mockoge.mesh

import io.github.laylameower.mockoge.util.Dirtable

interface ProceduralMesh: Mesh, Dirtable {
    /**
     * Will be called if [isDirty]
     */
    fun preRender()
}