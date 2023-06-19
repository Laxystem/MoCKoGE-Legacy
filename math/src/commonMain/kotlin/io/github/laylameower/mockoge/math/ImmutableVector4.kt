package io.github.laylameower.mockoge.math

public interface ImmutableVector4<T : Comparable<T>> : Vector4<T>, ImmutableVector3<T> {
    override var w: T

    public override operator fun times(other: Vector1<T>): ImmutableVector4<T>
    public override operator fun div(other: Vector1<T>): ImmutableVector4<T>

    public override operator fun times(other: Vector2<T>): ImmutableVector4<T>
    public override operator fun div(other: Vector2<T>): ImmutableVector4<T>

    public override operator fun times(other: Vector3<T>): ImmutableVector4<T>
    public override operator fun div(other: Vector3<T>): ImmutableVector4<T>

    public override operator fun times(other: Vector4<T>): ImmutableVector4<T>
    public override operator fun div(other: Vector4<T>): ImmutableVector4<T>

    public override operator fun times(other: T): ImmutableVector4<T>
    public override operator fun div(other: T): ImmutableVector4<T>

    public override operator fun plus(other: Vector1<T>): ImmutableVector4<T>
    public override operator fun minus(other: Vector1<T>): ImmutableVector4<T>

    public override operator fun plus(other: Vector2<T>): ImmutableVector4<T>
    public override operator fun minus(other: Vector2<T>): ImmutableVector4<T>

    public override operator fun plus(other: Vector3<T>): ImmutableVector4<T>
    public override operator fun minus(other: Vector3<T>): ImmutableVector4<T>

    public override operator fun plus(other: Vector4<T>): ImmutableVector4<T>
    public override operator fun minus(other: Vector4<T>): ImmutableVector4<T>

    public override operator fun plus(other: T): ImmutableVector4<T>
    public override operator fun minus(other: T): ImmutableVector4<T>

    public override val normalized: ImmutableVector4<T>
}
