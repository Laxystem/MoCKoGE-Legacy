package io.github.laylameower.mockoge.math

public interface MutableSignedVector3<T> : SignedVector3<T>, MutableVector3<T>, MutableSignedVector2<T> where T : Comparable<T> {
    public override operator fun times(other: Vector1<T>): MutableSignedVector3<T> = also { this *= other }
    public override operator fun div(other: Vector1<T>): MutableSignedVector3<T> = also { this /= other }

    public override operator fun times(other: Vector2<T>): MutableSignedVector3<T> = also { this *= other }
    public override operator fun div(other: Vector2<T>): MutableSignedVector3<T> = also { this /= other }

    public override operator fun times(other: Vector3<T>): MutableSignedVector3<T> = also { this *= other }
    public override operator fun div(other: Vector3<T>): MutableSignedVector3<T> = also { this /= other }

    public override operator fun times(other: T): MutableSignedVector3<T> = also { this *= other }
    public override operator fun div(other: T): MutableSignedVector3<T> = also { this /= other }

    public override operator fun plus(other: Vector1<T>): MutableSignedVector3<T> = also { this += other }
    public override operator fun minus(other: Vector1<T>): MutableSignedVector3<T>

    public override operator fun plus(other: Vector2<T>): MutableSignedVector3<T> = also { this += other }
    public override operator fun minus(other: Vector2<T>): MutableSignedVector3<T>

    public override operator fun plus(other: Vector3<T>): MutableSignedVector3<T> = also { this += other }
    public override operator fun minus(other: Vector3<T>): MutableSignedVector3<T>

    public override operator fun plus(other: T): MutableSignedVector3<T> = also { this += other }
    public override operator fun minus(other: T): MutableSignedVector3<T>

    public override operator fun unaryMinus(): MutableSignedVector3<T>

    public override val normalized: MutableSignedVector3<T>

}