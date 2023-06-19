package io.github.laylameower.mockoge.util

/**
 * Thrown by [validate], if the validation was unsuccessful.
 *
 * @see Validatable
 * @author Laxla
 */
public class InvalidArgumentException(message: String? = null, cause: Throwable? = null) : IllegalArgumentException(message, cause)