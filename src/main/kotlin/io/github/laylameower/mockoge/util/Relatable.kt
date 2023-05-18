package io.github.laylameower.mockoge.util

/**
 * Implementations of this interface are [Versioned], and may [require][RelationType.REQUIRED], [recommend][RelationType.RECOMMENDED], or be [incompatible][RelationType.INCOMPATIBLE] with others of their type.
 */
public interface Relatable<T : Relatable<T>> : Versioned {
    public fun getRelationWith(other: T): RelationType
}