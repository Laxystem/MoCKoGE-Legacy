package io.github.laylameower.mockoge.math

public interface MutableSignedVector2<T> : SignedVector2<T>, MutableVector2<T>, MutableSignedVector1<T> where T : Comparable<T> {
    public override operator fun times(other: Vector1<T>): MutableSignedVector2<T> = also { this *= other }
    public override operator fun div(other: Vector1<T>): MutableSignedVector2<T> = also { this /= other }

    public override operator fun times(other: Vector2<T>): MutableSignedVector2<T> = also { this *= other }
    public override operator fun div(other: Vector2<T>): MutableSignedVector2<T> = also { this /= other }

    public override operator fun times(other: T): MutableSignedVector2<T> = also { this *= other }
    public override operator fun div(other: T): MutableSignedVector2<T> = also { this /= other }

    public override operator fun plus(other: Vector1<T>): MutableSignedVector2<T>
    public override operator fun minus(other: Vector1<T>): MutableSignedVector2<T>

    public override operator fun plus(other: Vector2<T>): MutableSignedVector2<T>
    public override operator fun minus(other: Vector2<T>): MutableSignedVector2<T>

    public override operator fun plus(other: T): MutableSignedVector2<T>
    public override operator fun minus(other: T): MutableSignedVector2<T>

    public override operator fun unaryMinus(): MutableSignedVector2<T>

    public override val normalized: MutableSignedVector2<T>
}