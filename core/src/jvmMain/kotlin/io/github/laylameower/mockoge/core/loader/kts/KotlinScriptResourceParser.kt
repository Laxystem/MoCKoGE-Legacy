package io.github.laylameower.mockoge.core.loader.kts

import io.github.laylameower.mockoge.core.loader.ResourceParser
import io.github.laylameower.mockoge.core.util.bundleFile
import io.github.laylameower.mockoge.core.util.sceneFile
import kotlinx.collections.immutable.toImmutableMap
import java.util.logging.Logger
import kotlin.script.experimental.api.ResultValue
import kotlin.script.experimental.api.ResultWithDiagnostics
import kotlin.script.experimental.api.SourceCode
import kotlin.script.experimental.jvmhost.BasicJvmScriptingHost
import kotlin.script.experimental.jvmhost.createJvmCompilationConfigurationFromTemplate

public object KotlinScriptResourceParser : ResourceParser {
    private val host = BasicJvmScriptingHost()
    private val entrypointCompilationConfiguration = createJvmCompilationConfigurationFromTemplate<BundleScript>()

    override val bundleFileExtension: String = bundleFile
    override val sceneFileExtension: String = sceneFile

    override fun parseBundleFile(
        entrypoint: SourceCode,
        fileName: String,
        logger: Logger
    ): io.github.laylameower.mockoge.core.Bundle? {
        val evaluationResult = host.eval(entrypoint, entrypointCompilationConfiguration, null)

        evaluationResult.reports.forEach { it.logTo(logger) }

        val namespace = getNamespace(fileName, logger) ?: return null

        return (evaluationResult as? ResultWithDiagnostics.Success)?.value?.returnValue?.let { result ->
            val script = result.scriptInstance

            if (script is BundleScript) io.github.laylameower.mockoge.core.Bundle(
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