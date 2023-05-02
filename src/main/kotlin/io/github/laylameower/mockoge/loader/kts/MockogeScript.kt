package io.github.laylameower.mockoge.loader.kts

import io.github.z4kn4fein.semver.Version
import kotlin.script.experimental.annotations.KotlinScript

typealias Definer = DefinitionsScript.() -> Unit

typealias SpecificDefiner<T> = DefinitionsScript.Registrar<T>.() -> Unit

typealias RegistryReferencer<T> = DefinitionsScript.NamespaceReference<T>.() -> Unit

@Suppress("Unused")
@KotlinScript(fileExtension = "bundle.kts", compilationConfiguration = MockogeScriptConfiguration::class)
abstract class MockogeScript {
    open var version: Version? = null
        protected set
    open var name: String? = null
        protected set

    internal var definer: Definer? = null
        private set

    protected fun definitions(definer: Definer) {
        this.definer = definer
    }
}