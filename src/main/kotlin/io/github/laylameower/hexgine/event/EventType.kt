package io.github.laylameower.hexgine.event

import io.github.laylameower.hexgine.entity.Component
import io.github.laylameower.hexgine.utils.Named

typealias EventInvoker = (Any?) -> Any?

class EventType<T, R>(override val name: String, val argumentType: Class<T>? = null, val returnType: Class<R>? = null) : Named<String> {
    operator fun invoke(target: Component): EventInvoker {
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