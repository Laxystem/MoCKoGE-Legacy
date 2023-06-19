package io.github.laylameower.mockoge.math

public interface MutableSignedVector1<T> : SignedVector1<T>, MutableVector1<T> where T : Comparable<T> {
    public override operator fun times(other: Vector1<T>): MutableSignedVector1<T> = also { this *= other }
    public override operator fun div(other: Vector1<T>): MutableSignedVector1<T> = also { this /= other }

    public override operator fun times(other: T): MutableSignedVector1<T> = also { this *= other }
    public override operator fun div(other: T): MutableSignedVector1<T> = also { this /= other }

    public override operator fun plus(other: Vector1<T>): MutableSignedVector1<T> = also { this += other }
    public override operator fun minus(other: Vector1<T>): MutableSignedVector1<T> = also { this -= other }

    public override operator fun plus(other: T): MutableSignedVector1<T> = also { this += other }
    public override operator fun minus(other: T): MutableSignedVector1<T> = also { this -= other }

    public override operator fun unaryMinus(): MutableSignedVector1<T>

    public override val normalized: MutableSignedVector1<T>
}