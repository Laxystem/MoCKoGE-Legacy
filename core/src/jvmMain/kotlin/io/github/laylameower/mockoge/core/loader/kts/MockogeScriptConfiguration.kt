package io.github.laylameower.mockoge.core.loader.kts

import io.github.laylameower.mockoge.util.getToPathWithDirectories
import kotlin.script.experimental.api.ScriptCompilationConfiguration
import kotlin.script.experimental.api.defaultImports
import kotlin.script.experimental.api.hostConfiguration
import kotlin.script.experimental.jvm.dependenciesFromCurrentContext
import kotlin.script.experimental.jvm.jvm
import io.github.laylameower.mockoge.core.util.*

public object MockogeScriptConfiguration : ScriptCompilationConfiguration({
    defaultImports("io.github.laylameower.mockoge.util.*")
    jvm {
        dependenciesFromCurrentContext(wholeClasspath = true)
    }
    hostConfiguration(ScriptingHostConfiguration(defaultJvmScriptingHostConfiguration) {
        jvm {
            compilationCache(CompiledScriptJarsCache { source, _ ->
                "$cacheDirectory/${source.text.encodeToByteArray().encoded.asHexString}.$cacheFile".getToPathWithDirectories()
            })
        }
    })
})