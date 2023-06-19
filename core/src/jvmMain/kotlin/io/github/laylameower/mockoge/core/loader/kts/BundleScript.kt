package io.github.laylameower.mockoge.core.loader.kts

import kotlin.script.experimental.annotations.KotlinScript

public typealias Definer = DefinitionsScript.() -> Unit

public typealias SpecificDefiner = DefinitionsScript.Registrar.() -> Unit

public typealias RegistryReferencer = DefinitionsScript.NamespaceReference.() -> Unit

public typealias RegistryAdder = RegistryScript.() -> Unit

@Suppress("Unused")
@KotlinScript(fileExtension = "bundle.kts", compilationConfiguration = MockogeScriptConfiguration::class)
public abstract class BundleScript {
    public open var version: Version? = null
        protected set
    public open var name: String? = null
        protected set

    internal var definer: Definer? = null
        private set

    protected fun definitions(definer: Definer) {
        this.definer = definer
    }

    internal var registries: RegistryAdder? = null
        private set

    protected fun registries(registryAdder: RegistryAdder) {
        this.registries = registryAdder
    }
}