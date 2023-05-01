package io.github.laylameower.hexgine.entity

import io.github.laylameower.hexgine.utils.Dirtable

interface Component<C : Component<C>>: Dirtable {
    val type: ComponentType<C>

    fun preUpdate(deltaTime: Double)
    fun update(deltaTime: Double)
    fun postUpdate(deltaTime: Double)

    fun preRender()

    fun onInput()
}