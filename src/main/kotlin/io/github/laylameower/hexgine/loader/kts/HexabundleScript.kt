package io.github.laylameower.hexgine.loader.kts

import io.github.z4kn4fein.semver.Version
import kotlin.script.experimental.annotations.KotlinScript

typealias Definer = DefinitionsScript.() -> Unit

typealias SpecificDefiner<T> = DefinitionsScript.Registrar<T>.() -> Unit

typealias RegistryReferencer<T> = DefinitionsScript.NamespaceReference<T>.() -> Unit

@KotlinScript(fileExtension = "hexabundle.kts", compilationConfiguration = HexabundleScriptConfiguration::class)
abstract class HexabundleScript {
    abstract var version: Version
        protected set
    open var name: String? = null
        protected set

    internal var definer: Definer? = null
        private set

    protected fun definitions(definer: Definer) {
        this.definer = definer
    }
}