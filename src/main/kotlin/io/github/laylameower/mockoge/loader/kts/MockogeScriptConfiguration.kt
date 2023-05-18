package io.github.laylameower.mockoge.loader.kts

import io.github.laylameower.mockoge.util.*
import kotlin.script.experimental.api.*
import kotlin.script.experimental.host.ScriptingHostConfiguration
import kotlin.script.experimental.jvm.compilationCache
import kotlin.script.experimental.jvm.defaultJvmScriptingHostConfiguration
import kotlin.script.experimental.jvm.dependenciesFromCurrentContext
import kotlin.script.experimental.jvm.jvm
import kotlin.script.experimental.jvmhost.CompiledScriptJarsCache

public object MockogeScriptConfiguration : ScriptCompilationConfiguration({
    defaultImports("io.github.laylameower.mockoge.util.*")
    jvm {
        dependenciesFromCurrentContext(wholeClasspath = true)
    }
    hostConfiguration(ScriptingHostConfiguration(defaultJvmScriptingHostConfiguration) {
        jvm {
            compilationCache(CompiledScriptJarsCache { source, _ ->
                "$cacheDirectory/${source.text.encodeToByteArray().encoded.asHexString}.$cacheFile".asFile
            })
        }
    })
})