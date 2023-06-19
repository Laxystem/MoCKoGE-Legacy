package io.github.laylameower.mockoge.math

public interface ImmutableSignedVector2<T> : SignedVector2<T>, ImmutableVector2<T>,
    ImmutableSignedVector1<T> where T : Comparable<T> {
    public override operator fun times(other: Vector1<T>): ImmutableSignedVector2<T>
    public override operator fun div(other: Vector1<T>): ImmutableSignedVector2<T>
    public override operator fun rem(other: Vector1<T>): ImmutableSignedVector2<T>

    public override operator fun times(other: Vector2<T>): ImmutableSignedVector2<T>
    public override operator fun div(other: Vector2<T>): ImmutableSignedVector2<T>
    public override operator fun rem(other: Vector2<T>): ImmutableSignedVector2<T>

    public override operator fun times(other: T): ImmutableSignedVector2<T>
    public override operator fun div(other: T): ImmutableSignedVector2<T>
    public override operator fun rem(other: T): ImmutableSignedVector2<T>

    public override operator fun plus(other: Vector1<T>): ImmutableSignedVector2<T>
    public override operator fun minus(other: Vector1<T>): ImmutableSignedVector2<T>

    public override operator fun plus(other: Vector2<T>): ImmutableSignedVector2<T>
    public override operator fun minus(other: Vector2<T>): ImmutableSignedVector2<T>

    public override operator fun plus(other: T): ImmutableSignedVector2<T>
    public override operator fun minus(other: T): ImmutableSignedVector2<T>

    public override operator fun unaryMinus(): ImmutableSignedVector2<T>

    public override val normalized: ImmutableSignedVector2<T>
}