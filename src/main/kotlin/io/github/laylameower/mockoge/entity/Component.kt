package io.github.laylameower.mockoge.entity

import io.github.laylameower.mockoge.util.Dirtable

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