package io.github.laylameower.hexgine.loader.kts

import io.github.laylameower.hexgine.Identifier
import io.github.laylameower.hexgine.Registry
import io.github.laylameower.hexgine.RootRegistry
import io.github.laylameower.hexgine.utils.Named
import io.github.laylameower.hexgine.utils.at

data class DefinitionsScript(private val namespace: String) : Named<String> by Named.Delegate(namespace) {
    internal val definitions = mutableMapOf<Registry<*>, Pair<Identifier, Any>>()

    operator fun <T : Any> Identifier.invoke(definitions: SpecificDefiner<T>) = definitions(Registrar(this))

    operator fun <T : Any> String.invoke(registries: RegistryReferencer<T>) = registries(NamespaceReference(this))

    inner class Registrar<T : Any>(private val registryIdentifier: Identifier) {

        infix fun Identifier.to(value: T) {
            definitions[RootRegistry[registryIdentifier] ?: return] = Pair(this, value)
        }
    }

    inner class NamespaceReference<T : Any>(private val namespace: String) {
        operator fun String.invoke(definitions: SpecificDefiner<T>) {
            definitions(Registrar(this at namespace))
        }
    }
}