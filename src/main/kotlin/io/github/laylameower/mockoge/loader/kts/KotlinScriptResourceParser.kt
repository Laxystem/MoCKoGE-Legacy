package io.github.laylameower.mockoge.loader.kts

import io.github.laylameower.mockoge.Bundle
import io.github.laylameower.mockoge.loader.ResourceParser
import io.github.laylameower.mockoge.util.*
import org.apache.logging.log4j.Logger
import kotlin.script.experimental.api.ResultValue
import kotlin.script.experimental.api.ResultWithDiagnostics
import kotlin.script.experimental.api.SourceCode
import kotlin.script.experimental.jvmhost.BasicJvmScriptingHost
import kotlin.script.experimental.jvmhost.createJvmCompilationConfigurationFromTemplate
import kotlinx.collections.immutable.toImmutableMap

public object KotlinScriptResourceParser : ResourceParser {
    private val host = BasicJvmScriptingHost()
    private val entrypointCompilationConfiguration = createJvmCompilationConfigurationFromTemplate<BundleScript>()

    override val bundleFileExtension: String = bundleFile
    override val sceneFileExtension: String = sceneFile

    override fun parseBundleFile(entrypoint: SourceCode, fileName: String, logger: Logger): Bundle? {
        val evaluationResult = host.eval(entrypoint, entrypointCompilationConfiguration, null)

        evaluationResult.reports.forEach {it.logTo(logger)}

        val namespace = getNamespace(fileName, logger) ?: return null

        return (evaluationResult as? ResultWithDiagnostics.Success)?.value?.returnValue?.let { result ->
            val script = result.scriptInstance

            if (script is BundleScript) Bundle(
                namespace,
                script.name ?: namespace,
                script.version ?: let {
                    logger.error("Cannot find bundle version")
                    return null
                },
                DefinitionsScript(namespace).let {
                    script.definer?.invoke(it)
                    it.definitions.toImmutableMap()
                },
                RegistryScript().let {
                    script.registries?.invoke(it)
                    it.registries.toImmutableMap()
                })
            else {
                if (result is ResultValue.Error)
                    logger.error("Encountered an unhandled throwable during kotlin script assessment", result.error)
                null
            }
        }
    }
}