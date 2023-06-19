package io.github.laylameower.mockoge.math

public interface SignedVector3<T> : Vector3<T>, SignedVector2<T> where T : Comparable<T> {
    public override operator fun times(other: Vector1<T>): SignedVector3<T>
    public override operator fun div(other: Vector1<T>): SignedVector3<T>

    public override operator fun times(other: Vector2<T>): SignedVector3<T>
    public override operator fun div(other: Vector2<T>): SignedVector3<T>

    public override operator fun times(other: Vector3<T>): SignedVector3<T>
    public override operator fun div(other: Vector3<T>): SignedVector3<T>

    public override operator fun times(other: T): SignedVector3<T>
    public override operator fun div(other: T): SignedVector3<T>

    public override operator fun plus(other: Vector1<T>): SignedVector3<T>
    public override operator fun minus(other: Vector1<T>): SignedVector3<T>

    public override operator fun plus(other: Vector2<T>): SignedVector3<T>
    public override operator fun minus(other: Vector2<T>): SignedVector3<T>

    public override operator fun plus(other: Vector3<T>): SignedVector3<T>
    public override operator fun minus(other: Vector3<T>): SignedVector3<T>

    public override operator fun plus(other: T): SignedVector3<T>
    public override operator fun minus(other: T): SignedVector3<T>

    public override operator fun unaryMinus(): SignedVector3<T>

    public override val normalized: SignedVector3<T>
}