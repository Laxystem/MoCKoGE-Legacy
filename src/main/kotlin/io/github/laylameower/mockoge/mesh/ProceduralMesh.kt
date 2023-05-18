package io.github.laylameower.mockoge.mesh

import io.github.laylameower.mockoge.util.Dirtable

@Deprecated("May not be available in full release. Here for reference.")
public interface ProceduralMesh: Mesh, Dirtable {
    /**
     * Will be called if [isDirty]
     */
    public suspend fun preRender()
}