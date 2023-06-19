package io.github.laylameower.mockoge.math

public interface SignedVector4<T> : Vector4<T>, SignedVector3<T> where T : Comparable<T> {
    public override operator fun times(other: Vector1<T>): SignedVector4<T>
    public override operator fun div(other: Vector1<T>): SignedVector4<T>

    public override operator fun times(other: Vector2<T>): SignedVector4<T>
    public override operator fun div(other: Vector2<T>): SignedVector4<T>

    public override operator fun times(other: Vector3<T>): SignedVector4<T>
    public override operator fun div(other: Vector3<T>): SignedVector4<T>

    public override operator fun times(other: T): SignedVector4<T>
    public override operator fun div(other: T): SignedVector4<T>

    public override operator fun plus(other: Vector1<T>): SignedVector4<T>
    public override operator fun minus(other: Vector1<T>): SignedVector4<T>

    public override operator fun plus(other: Vector2<T>): SignedVector4<T>
    public override operator fun minus(other: Vector2<T>): SignedVector4<T>

    public override operator fun plus(other: Vector3<T>): SignedVector4<T>
    public override operator fun minus(other: Vector3<T>): SignedVector4<T>

    public override operator fun plus(other: T): SignedVector4<T>
    public override operator fun minus(other: T): SignedVector4<T>

    public override operator fun unaryMinus(): SignedVector4<T>

    public override val normalized: SignedVector4<T>
}
