package io.github.laylameower.hexgine.resources

import kotlin.script.experimental.api.ScriptCompilationConfiguration
import kotlin.script.experimental.api.defaultImports
import kotlin.script.experimental.jvm.dependenciesFromCurrentContext
import kotlin.script.experimental.jvm.jvm

object HexabundleScriptConfiguration: ScriptCompilationConfiguration({
    defaultImports()
    jvm {
        dependenciesFromCurrentContext(wholeClasspath = true)

    }
})