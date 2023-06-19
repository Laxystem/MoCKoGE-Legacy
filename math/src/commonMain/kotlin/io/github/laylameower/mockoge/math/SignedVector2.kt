package io.github.laylameower.mockoge.math

public interface SignedVector2<T> : Vector2<T>, SignedVector1<T> where T : Comparable<T> {
    public override operator fun times(other: Vector1<T>): SignedVector2<T>
    public override operator fun div(other: Vector1<T>): SignedVector2<T>

    public override operator fun times(other: Vector2<T>): SignedVector2<T>
    public override operator fun div(other: Vector2<T>): SignedVector2<T>

    public override operator fun times(other: T): SignedVector2<T>
    public override operator fun div(other: T): SignedVector2<T>

    public override operator fun plus(other: Vector1<T>): SignedVector2<T>
    public override operator fun minus(other: Vector1<T>): SignedVector2<T>

    public override operator fun plus(other: Vector2<T>): SignedVector2<T>
    public override operator fun minus(other: Vector2<T>): SignedVector2<T>

    public override operator fun plus(other: T): SignedVector2<T>
    public override operator fun minus(other: T): SignedVector2<T>

    public override operator fun unaryMinus(): SignedVector2<T>

    public override val normalized: SignedVector2<T>
}