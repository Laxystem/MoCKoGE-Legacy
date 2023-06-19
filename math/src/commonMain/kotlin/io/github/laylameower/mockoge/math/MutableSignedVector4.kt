package io.github.laylameower.mockoge.math

public interface MutableSignedVector4<T> : SignedVector4<T>, MutableVector4<T>, MutableSignedVector3<T> where T : Comparable<T> {
    public override operator fun times(other: Vector1<T>): MutableSignedVector4<T> = also { this *= other }
    public override operator fun div(other: Vector1<T>): MutableSignedVector4<T> = also { this /= other }

    public override operator fun times(other: Vector2<T>): MutableSignedVector4<T> = also { this *= other }
    public override operator fun div(other: Vector2<T>): MutableSignedVector4<T> = also { this /= other }

    public override operator fun times(other: Vector3<T>): MutableSignedVector4<T> = also { this *= other }
    public override operator fun div(other: Vector3<T>): MutableSignedVector4<T> = also { this /= other }

    public override operator fun times(other: Vector4<T>): MutableSignedVector4<T> = also { this *= other }
    public override operator fun div(other: Vector4<T>): MutableSignedVector4<T> = also { this /= other }

    public override operator fun times(other: T): MutableSignedVector4<T> = also { this *= other }
    public override operator fun div(other: T): MutableSignedVector4<T> = also { this /= other }

    public override operator fun plus(other: Vector1<T>): MutableSignedVector4<T>
    public override operator fun minus(other: Vector1<T>): MutableSignedVector4<T>

    public override operator fun plus(other: Vector2<T>): MutableSignedVector4<T>
    public override operator fun minus(other: Vector2<T>): MutableSignedVector4<T>

    public override operator fun plus(other: Vector3<T>): MutableSignedVector4<T>
    public override operator fun minus(other: Vector3<T>): MutableSignedVector4<T>

    public override operator fun plus(other: Vector4<T>): MutableSignedVector4<T>
    public override operator fun minus(other: Vector4<T>): MutableSignedVector4<T>

    public override operator fun plus(other: T): MutableSignedVector4<T>
    public override operator fun minus(other: T): MutableSignedVector4<T>

    public override operator fun unaryMinus(): MutableSignedVector4<T>

    public override val normalized: MutableSignedVector4<T>
}
