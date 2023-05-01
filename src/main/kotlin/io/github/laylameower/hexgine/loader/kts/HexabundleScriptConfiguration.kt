package io.github.laylameower.hexgine.loader.kts

import kotlin.script.experimental.api.ScriptCompilationConfiguration
import kotlin.script.experimental.api.defaultImports
import kotlin.script.experimental.jvm.dependenciesFromCurrentContext
import kotlin.script.experimental.jvm.jvm

object HexabundleScriptConfiguration: ScriptCompilationConfiguration({
    defaultImports("io.github.laylameower.hexgine.loader.LoaderConstants.*")
    jvm {
        dependenciesFromCurrentContext(wholeClasspath = true)
    }
})