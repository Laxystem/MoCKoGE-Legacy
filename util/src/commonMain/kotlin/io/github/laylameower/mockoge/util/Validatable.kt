package io.github.laylameower.mockoge.util

/**
 * Implementations of this interface have specific requirements in order to be usable.
 * @author Laxla
 */
public interface Validatable {

    /**
     * Can this instance be used safely without unexpected exceptions?
     */
    public val isValid: Boolean
}