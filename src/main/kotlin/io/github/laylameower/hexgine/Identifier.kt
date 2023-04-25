package io.github.laylameower.hexgine

data class Identifier internal constructor(val namespace: String, val path: String) {
    override fun toString() = "$namespace:$path"
}
