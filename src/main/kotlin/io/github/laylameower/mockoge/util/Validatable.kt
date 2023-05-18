package io.github.laylameower.mockoge.util

/**
 * Instances of implementations of this interface have specific requirements in order to be usable.
 */
public interface Validatable {

    /**
     * Can this instance be used safely without unexpected exceptions?
     */
    public val isValid: Boolean
}