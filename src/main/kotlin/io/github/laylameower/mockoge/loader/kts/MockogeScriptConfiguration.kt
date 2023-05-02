package io.github.laylameower.mockoge.loader.kts

import kotlin.script.experimental.api.ScriptCompilationConfiguration
import kotlin.script.experimental.api.defaultImports
import kotlin.script.experimental.jvm.dependenciesFromCurrentContext
import kotlin.script.experimental.jvm.jvm

object MockogeScriptConfiguration : ScriptCompilationConfiguration({
    defaultImports("io.github.laylameower.mockoge.util.*")
    jvm {
        dependenciesFromCurrentContext(wholeClasspath = true)
    }
})