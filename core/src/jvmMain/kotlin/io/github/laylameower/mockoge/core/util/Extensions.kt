package io.github.laylameower.mockoge.core.util

import io.github.oshai.KLogger
import kotlin.script.experimental.api.ScriptDiagnostic

public val ScriptDiagnostic.asString: String
    get() = render(
        withSeverity = false,
        withLocation = true,
        withException = false,
        withStackTrace = false
    )

public fun ScriptDiagnostic.logTo(logger: KLogger): Unit = when (severity) { // TODO: KLogging
    ScriptDiagnostic.Severity.DEBUG -> logger.debug(asString, exception)
    ScriptDiagnostic.Severity.INFO -> logger.info(asString, exception)
    ScriptDiagnostic.Severity.WARNING -> logger.warn(asString, exception)
    ScriptDiagnostic.Severity.ERROR -> logger.error(asString, exception)
    ScriptDiagnostic.Severity.FATAL -> logger.error(asString, exception)
}