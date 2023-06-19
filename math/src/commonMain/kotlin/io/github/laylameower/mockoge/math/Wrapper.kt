package io.github.laylameower.mockoge.math

import kotlinx.coroutines.*
import kotlin.reflect.KProperty

/**
 *
 */
@ExperimentalCoroutinesApi
public class Wrapper<T>(private var field : T) {
    public operator fun getValue(thisRef: Any?, property: KProperty<*>): T = runBlocking(context) {
        field
    }

    public operator fun setValue(thisRef: Any?, property: KProperty<*>, value: T): Unit = runBlocking(context) {
        field = value
    }

    public operator fun invoke(block: suspend (T) -> Unit): Unit = runBlocking(context) {
        block(field)
    }

    public operator fun invoke(block: suspend (T) -> T): Unit = runBlocking(context) {
        field = block(field)
    }

    public companion object {
        private val context = newSingleThreadContext("mockogeThreadSafetyWrapper")
    }
}
