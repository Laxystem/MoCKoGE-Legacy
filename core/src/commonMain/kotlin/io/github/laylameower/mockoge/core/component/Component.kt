package io.github.laylameower.mockoge.core.component

import io.github.laylameower.mockoge.Scene
import io.github.laylameower.mockoge.event.EventHandler
import io.github.laylameower.mockoge.event.IgnoredEventHandler
import io.github.laylameower.mockoge.util.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel

/**
 * Implement this class to create a component!
 */
public abstract class Component<C : Component<C>>(
    public val type: ComponentType<C>,
    public val entity: Scene.Entity
) : Disposable, DirtableAndCancellable {
    internal val scope: CoroutineScope = CoroutineScope(Dispatchers.Default)

    /**
     * Should [preRender] execute this frame?
     */
    final override var isDirty: Boolean = true

    @EventHandler(path = disposeEvent)
    public final override fun dispose() {
        scope.cancel()
        onDisposal()
    }

    @EventHandler(path = inputEvent)
    @IgnoredEventHandler
    public open suspend fun onInput() { }

    @EventHandler(path = preUpdateEvent)
    @IgnoredEventHandler
    public open suspend fun preUpdate(deltaTime: Double) { }

    @EventHandler(path = preTickEvent)
    @IgnoredEventHandler
    public open suspend fun preTick() { }

    @EventHandler(path = tickEvent)
    @IgnoredEventHandler
    public open suspend fun tick() { }

    @EventHandler(path = postTickEvent)
    @IgnoredEventHandler
    public open suspend fun postTick() { }

    @EventHandler(path = updateEvent)
    @IgnoredEventHandler
    public open suspend fun update(deltaTime: Double) { }

    @EventHandler(path = postUpdateEvent)
    @IgnoredEventHandler
    public open suspend fun postUpdate(deltaTime: Double) { }

    @EventHandler(path = preRenderEvent)
    @IgnoredEventHandler
    public open suspend fun preRender() { }

    public open fun onDisposal() { }
}