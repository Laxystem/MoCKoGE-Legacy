package io.github.laylameower.mockoge.math

/**
 * Represents a mutable vector of [T]s.
 *
 * Operations will modify the vector, for example:
 * ```kotlin
 * fun foo(vector MutableVector1<UInt>, bar: UInt) {
 *     assertTrue { (vector * bar) === vector4 }
 *
 *     val copyOfVector = vector.toVector1Ui()
 *
 *     assertFalse { (copyOfVector /= bar) == vector }
 * }
 * ```
 * ***WARNING:** mutable vectors **aren't** thread-safe.*
 */
public interface MutableVector1<T : Comparable<T>> : Vector1<T> {
    override var x: T

    public operator fun timesAssign(other: Vector1<T>)
    public operator fun divAssign(other: Vector1<T>)
    public operator fun remAssign(other: Vector1<T>)

    public operator fun timesAssign(other: T)
    public operator fun divAssign(other: T)
    public operator fun remAssign(other: T)

    public operator fun plusAssign(other: Vector1<T>)
    public operator fun minusAssign(other: Vector1<T>)

    public operator fun plusAssign(other: T)
    public operator fun minusAssign(other: T)

    public override val normalized: MutableVector1<T>

    public override operator fun times(other: Vector1<T>): MutableVector1<T> = also { this *= other }
    public override operator fun div(other: Vector1<T>): MutableVector1<T> = also { this /= other }
    public override operator fun rem(other: Vector1<T>): MutableVector1<T> = also { this %= other}

    public override operator fun times(other: T): MutableVector1<T> = also { this *= other }
    public override operator fun div(other: T): MutableVector1<T> = also { this /= other }
    public override operator fun rem(other: T): MutableVector1<T> = also { this %= other}

    public override operator fun plus(other: Vector1<T>): MutableVector1<T> = also { this += other }
    public override operator fun minus(other: Vector1<T>): MutableVector1<T> = also { this -= other }

    public override operator fun plus(other: T): MutableVector1<T> = also { this += other }
    public override operator fun minus(other: T): MutableVector1<T> = also { this -= other }
}