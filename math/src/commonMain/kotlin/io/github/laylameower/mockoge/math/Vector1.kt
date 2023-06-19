package io.github.laylameower.mockoge.math

import kotlinx.collections.immutable.ImmutableCollection

/**
 * Represents a vector of [T]s - usually a [Float], [Double], [Int], [UInt], or [Long].
 *
 * Can be [Immutable][ImmutableVector1] or [Mutable][MutableVector1].
 *
 * Vectors are sorted by [length] - therefore, [normalized] vectors *cannot* be sorted.
 */
public interface Vector1<T : Comparable<T>> : ImmutableCollection<T>, Comparable<Vector1<T>> {
    public val x: T

    public operator fun times(other: Vector1<T>): Vector1<T>
    public operator fun div(other: Vector1<T>): Vector1<T>
    public operator fun rem(other: Vector1<T>): Vector1<T>

    public operator fun times(other: T): Vector1<T>
    public operator fun div(other: T): Vector1<T>
    public operator fun rem(other: T): Vector1<T>

    public operator fun plus(other: Vector1<T>): Vector1<T>
    public operator fun minus(other: Vector1<T>): Vector1<T>

    public operator fun plus(other: T): Vector1<T>
    public operator fun minus(other: T): Vector1<T>

    /**
     * The length of the vector.
     *
     * This is a double, in order to keep [normalized] and [isNormalized] accurate.
     * @see normalized the links at the bottom of the [normalized] documentation.
     */
    public val length: Double

    /**
     * Normalize this vector, discarding its length and only keeping its direction.
     *
     * Normalized vectors are useful for uniform operations that only need a direction.
     *
     * Note that with two vectors of the same direction, `a.normalized == b.normalized` is always true.
     *
     * More about normalized vectors, aka unit vectors,
     * can be found on [wikipedia](https://en.wikipedia.org/wiki/Unit_vector),
     * and on [this StackOverflow question](https://stackoverflow.com/questions/10002918/what-is-the-need-for-normalizing-a-vector).
     */
    public val normalized: Vector1<T>

    override val size: Int get() = 1
    override infix fun contains(element: T): Boolean = x == element

    override fun containsAll(elements: Collection<T>): Boolean {
        elements.forEach {
            if (!contains(it)) return false
        }

        return true
    }

    @Deprecated("A vector cannot be empty", level = DeprecationLevel.HIDDEN)
    override fun isEmpty(): Boolean = false

    override fun iterator(): Iterator<T> = sequenceOf(x).iterator()

    override operator fun compareTo(other: Vector1<T>): Int = length.compareTo(other.length)
}