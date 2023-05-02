package io.github.laylameower.mockoge.util

interface Named<T> {
    val name: T

    data class Delegate<T>(override val name: T): Named<T>
}