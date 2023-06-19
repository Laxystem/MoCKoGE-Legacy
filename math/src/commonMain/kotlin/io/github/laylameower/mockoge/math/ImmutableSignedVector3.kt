package io.github.laylameower.mockoge.math

public interface ImmutableSignedVector3<T> : SignedVector3<T>, ImmutableVector3<T> where T : Comparable<T> {
    public override operator fun times(other: Vector1<T>): ImmutableSignedVector3<T>
    public override operator fun div(other: Vector1<T>): ImmutableSignedVector3<T>
    public override operator fun rem(other: Vector1<T>): ImmutableSignedVector3<T>

    public override operator fun times(other: Vector2<T>): ImmutableSignedVector3<T>
    public override operator fun div(other: Vector2<T>): ImmutableSignedVector3<T>
    public override operator fun rem(other: Vector2<T>): ImmutableSignedVector3<T>

    public override operator fun times(other: Vector3<T>): ImmutableSignedVector3<T>
    public override operator fun div(other: Vector3<T>): ImmutableSignedVector3<T>
    public override operator fun rem(other: Vector3<T>): ImmutableSignedVector3<T>

    public override operator fun times(other: T): ImmutableSignedVector3<T>
    public override operator fun div(other: T): ImmutableSignedVector3<T>
    public override operator fun rem(other: T): ImmutableSignedVector3<T>

    public override operator fun plus(other: Vector1<T>): ImmutableSignedVector3<T>
    public override operator fun minus(other: Vector1<T>): ImmutableSignedVector3<T>

    public override operator fun plus(other: Vector2<T>): ImmutableSignedVector3<T>
    public override operator fun minus(other: Vector2<T>): ImmutableSignedVector3<T>

    public override operator fun plus(other: Vector3<T>): ImmutableSignedVector3<T>
    public override operator fun minus(other: Vector3<T>): ImmutableSignedVector3<T>

    public override operator fun plus(other: T): ImmutableSignedVector3<T>
    public override operator fun minus(other: T): ImmutableSignedVector3<T>

    public override operator fun unaryMinus(): ImmutableSignedVector3<T>

    public override val normalized: ImmutableSignedVector3<T>
}