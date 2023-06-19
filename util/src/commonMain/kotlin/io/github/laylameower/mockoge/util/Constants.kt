package io.github.laylameower.mockoge.util

/**
 * Camel-case text will always match this regex.
 */
public val camelCaseRegex: Regex = "[a-z]+([A-Z])*".toRegex()
