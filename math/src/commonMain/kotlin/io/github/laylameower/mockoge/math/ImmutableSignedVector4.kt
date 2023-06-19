package io.github.laylameower.mockoge.math

public interface ImmutableSignedVector4<T> : SignedVector4<T>, ImmutableVector4<T> where T : Comparable<T> {
    public override operator fun times(other: Vector1<T>): ImmutableSignedVector4<T>
    public override operator fun div(other: Vector1<T>): ImmutableSignedVector4<T>

    public override operator fun times(other: Vector2<T>): ImmutableSignedVector4<T>
    public override operator fun div(other: Vector2<T>): ImmutableSignedVector4<T>

    public override operator fun times(other: Vector3<T>): ImmutableSignedVector4<T>
    public override operator fun div(other: Vector3<T>): ImmutableSignedVector4<T>

    public override operator fun times(other: Vector4<T>): ImmutableSignedVector4<T>
    public override operator fun div(other: Vector4<T>): ImmutableSignedVector4<T>

    public override operator fun times(other: T): ImmutableSignedVector4<T>
    public override operator fun div(other: T): ImmutableSignedVector4<T>

    public override operator fun plus(other: Vector1<T>): ImmutableSignedVector4<T>
    public override operator fun minus(other: Vector1<T>): ImmutableSignedVector4<T>

    public override operator fun plus(other: Vector2<T>): ImmutableSignedVector4<T>
    public override operator fun minus(other: Vector2<T>): ImmutableSignedVector4<T>

    public override operator fun plus(other: Vector3<T>): ImmutableSignedVector4<T>
    public override operator fun minus(other: Vector3<T>): ImmutableSignedVector4<T>

    public override operator fun plus(other: Vector4<T>): ImmutableSignedVector4<T>
    public override operator fun minus(other: Vector4<T>): ImmutableSignedVector4<T>

    public override operator fun plus(other: T): ImmutableSignedVector4<T>
    public override operator fun minus(other: T): ImmutableSignedVector4<T>

    public override operator fun unaryMinus(): ImmutableSignedVector4<T>

    public override val normalized: ImmutableSignedVector4<T>
}