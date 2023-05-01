package io.github.laylameower.hexgine.entity

import io.github.laylameower.hexgine.utils.Dirtable

@Suppress("unused")
interface Component<C : Component<C>>: Dirtable {
    val type: ComponentType<C>

    fun preUpdate(deltaTime: Double)
    fun preTick()
    fun update(deltaTime: Double)
    fun tick()
    fun postTick()
    fun postUpdate(deltaTime: Double)

    fun preRender()

    fun onInput()
}