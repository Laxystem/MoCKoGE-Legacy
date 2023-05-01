package io.github.laylameower.hexgine.loader.kts

import io.github.laylameower.hexgine.Bundle
import io.github.laylameower.hexgine.loader.ResourceLoader
import org.apache.logging.log4j.Logger
import kotlin.script.experimental.api.ResultValue
import kotlin.script.experimental.api.ResultWithDiagnostics
import kotlin.script.experimental.api.ScriptDiagnostic
import kotlin.script.experimental.api.SourceCode
import kotlin.script.experimental.jvmhost.BasicJvmScriptingHost
import kotlin.script.experimental.jvmhost.createJvmCompilationConfigurationFromTemplate

object KotlinScriptResourceLoader : ResourceLoader {
    private val host = BasicJvmScriptingHost()
    private val entrypointCompilationConfiguration = createJvmCompilationConfigurationFromTemplate<HexabundleScript>()

    override val bundleExtension: String = ".bundle.kts"

    override fun parseEntrypoint(entrypoint: SourceCode, fileName: String, logger: Logger): Bundle? {
        val evaluationResult = host.eval(entrypoint, entrypointCompilationConfiguration, null)

        evaluationResult.reports.forEach {
            when (it.severity) {
                ScriptDiagnostic.Severity.DEBUG -> logger.debug(it.message, it.exception)
                ScriptDiagnostic.Severity.INFO -> logger.info(it.message, it.exception)
                ScriptDiagnostic.Severity.WARNING -> logger.warn(it.message, it.exception)
                ScriptDiagnostic.Severity.ERROR -> logger.error(it.message, it.exception)
                ScriptDiagnostic.Severity.FATAL -> logger.fatal(it.message, it.exception)
            }
        }

        val namespace = getNamespace(fileName, logger) ?: return null

        return (evaluationResult as? ResultWithDiagnostics.Success)?.value?.returnValue?.let { result ->
            val script = result.scriptInstance

            if (script is HexabundleScript) Bundle(
                namespace,
                script.name ?: namespace,
                script.version,
                DefinitionsScript(namespace).let {
                    script.definer?.invoke(it)
                    it.definitions.toMap()
                })

            else {
                if (result is ResultValue.Error)
                    logger.error("Encountered an unhandled throwable during kotlin script assessment", result.error)
                null
            }
        }
    }
}