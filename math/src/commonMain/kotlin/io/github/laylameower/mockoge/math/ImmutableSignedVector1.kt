package io.github.laylameower.mockoge.math

public interface ImmutableSignedVector1<T> : SignedVector1<T>, ImmutableVector1<T> where T : Comparable<T> {
    public override operator fun times(other: Vector1<T>): ImmutableSignedVector1<T>
    public override operator fun div(other: Vector1<T>): ImmutableSignedVector1<T>
    public override operator fun rem(other: Vector1<T>): ImmutableSignedVector1<T>

    public override operator fun times(other: T): ImmutableSignedVector1<T>
    public override operator fun div(other: T): ImmutableSignedVector1<T>
    public override operator fun rem(other: T): ImmutableSignedVector1<T>

    public override operator fun plus(other: Vector1<T>): ImmutableSignedVector1<T>
    public override operator fun minus(other: Vector1<T>): ImmutableSignedVector1<T>

    public override operator fun plus(other: T): ImmutableSignedVector1<T>
    public override operator fun minus(other: T): ImmutableSignedVector1<T>

    public override operator fun unaryMinus(): ImmutableSignedVector1<T>

    public override val normalized: ImmutableSignedVector1<T>
}