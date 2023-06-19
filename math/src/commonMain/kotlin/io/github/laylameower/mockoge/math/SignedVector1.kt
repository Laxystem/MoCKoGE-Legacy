package io.github.laylameower.mockoge.math

public interface SignedVector1<T> : Vector1<T> where T : Comparable<T> {
    public override operator fun times(other: Vector1<T>): SignedVector1<T>
    public override operator fun div(other: Vector1<T>): SignedVector1<T>

    public override operator fun times(other: T): SignedVector1<T>
    public override operator fun div(other: T): SignedVector1<T>

    public override operator fun plus(other: Vector1<T>): SignedVector1<T>
    public override operator fun minus(other: Vector1<T>): SignedVector1<T>

    public override operator fun plus(other: T): SignedVector1<T>
    public override operator fun minus(other: T): SignedVector1<T>

    public operator fun unaryMinus(): SignedVector1<T>

    public override val normalized: SignedVector1<T>
}