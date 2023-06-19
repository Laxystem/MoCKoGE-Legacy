package io.github.laylameower.mockoge.util

/**
 * Implementations of this interface may [require][RelationType.REQUIRED], [recommend][RelationType.RECOMMENDED], or be [incompatible][RelationType.INCOMPATIBLE] with others of their type.
 * @author LaylaMeower
 */
public interface Relatable<T : Relatable<T>> {
    public fun getRelationWith(other: T): RelationType
}