package io.github.laylameower.hexgine.resources

import io.github.z4kn4fein.semver.Version
import kotlin.script.experimental.annotations.KotlinScript

typealias Definer = DefinitionsScript.() -> Unit

typealias SpecificDefiner<T> = DefinitionsScript.Registrar<T>.() -> Unit

@KotlinScript(fileExtension = "hexabundle.kts", compilationConfiguration = HexabundleScriptConfiguration::class)
abstract class HexabundleScript {
    abstract var namespace: String
        protected set
    abstract var version: Version
        protected set

    var definer: Definer? = null
        private set

    protected fun definitions(definer: Definer) {
        this.definer = definer
    }
}