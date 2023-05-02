package io.github.laylameower.mockoge.event

import io.github.laylameower.mockoge.entity.Component
import io.github.laylameower.mockoge.util.Named

typealias EventInvoker = (Any?) -> Any?

class EventType<T, R>(override val name: String, val argumentType: Class<T>? = null, @Suppress("unused") val returnType: Class<R>? = null) :
    Named<String> {
    operator fun <C : Component<C>> invoke(target: C): EventInvoker {
        if (argumentType == null) {
            val method = target.javaClass.getMethod(name)
            return {
                method.invoke(target)
            }
        } else {
            val method = target.javaClass.getMethod(name, argumentType)
            return {
                method.invoke(target, it)
            }
        }
    }
}