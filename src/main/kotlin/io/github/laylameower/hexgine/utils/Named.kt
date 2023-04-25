package io.github.laylameower.hexgine.utils

interface Named<T> {
    val name: T

    data class Delegate<T>(override val name: T): Named<T>
}