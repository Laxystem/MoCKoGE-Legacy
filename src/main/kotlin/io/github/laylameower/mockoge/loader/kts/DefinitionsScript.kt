package io.github.laylameower.mockoge.loader.kts

import io.github.laylameower.mockoge.Identifier
import io.github.laylameower.mockoge.Registry
import io.github.laylameower.mockoge.RootRegistry
import io.github.laylameower.mockoge.util.at

public data class DefinitionsScript(public val namespace: String) {
    internal val definitions = mutableMapOf<Identifier, Pair<Identifier, Any>>()

    public operator fun Registry<*>.invoke(definitions: SpecificDefiner) {
        definitions(Registrar(RootRegistry[this]!!))
    }

    public operator fun Identifier.invoke(definitions: SpecificDefiner) {
        definitions(Registrar(this))
    }

    public operator fun String.invoke(registries: RegistryReferencer) {
        registries(NamespaceReference(this))
    }

    public inner class Registrar(private val registryIdentifier: Identifier) {
        public infix fun String.to(value: Any) {
            definitions[registryIdentifier] = Pair(this at namespace, value)
        }
    }

    public inner class NamespaceReference(private val namespace: String) {
        public operator fun String.invoke(definitions: SpecificDefiner) {
            definitions(Registrar(this at namespace))
        }
    }
}