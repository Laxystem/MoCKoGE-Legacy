package io.github.laylameower.hexgine.resources

import io.github.laylameower.hexgine.Identifier
import io.github.laylameower.hexgine.RootRegistry
import io.github.laylameower.hexgine.utils.Named
import kotlin.reflect.KClass

data class DefinitionsScript(private val namespace: String) : Named<String> by Named.Delegate(namespace) {

    /**
     * Usage: `"path" at "namespace"` or `"path" at namespace`
     */
    infix fun String.at(namespace: String) = Identifier(namespace, this)

    operator fun <T : Any> KClass<T>.invoke(definitions: SpecificDefiner<T>) {
        definitions(Registrar(this))
    }

    inner class Registrar<T : Any>(private val identifier: KClass<T>) {

        infix fun <K : Any> K.of(value: T) {
            RootRegistry[identifier]?.let {
                it[this] = value
            }
        }
    }
}