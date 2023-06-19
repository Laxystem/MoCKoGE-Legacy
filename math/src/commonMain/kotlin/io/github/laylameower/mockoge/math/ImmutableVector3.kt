package io.github.laylameower.mockoge.math

public interface ImmutableVector3<T : Comparable<T>> : Vector3<T>, ImmutableVector2<T> {
    override var z: T

    public override operator fun times(other: Vector1<T>): ImmutableVector3<T>
    public override operator fun div(other: Vector1<T>): ImmutableVector3<T>

    public override operator fun times(other: Vector2<T>): ImmutableVector3<T>
    public override operator fun div(other: Vector2<T>): ImmutableVector3<T>

    public override operator fun times(other: Vector3<T>): ImmutableVector3<T>
    public override operator fun div(other: Vector3<T>): ImmutableVector3<T>

    public override operator fun times(other: T): ImmutableVector3<T>
    public override operator fun div(other: T): ImmutableVector3<T>

    public override operator fun plus(other: Vector1<T>): ImmutableVector3<T>
    public override operator fun minus(other: Vector1<T>): ImmutableVector3<T>

    public override operator fun plus(other: Vector2<T>): ImmutableVector3<T>
    public override operator fun minus(other: Vector2<T>): ImmutableVector3<T>

    public override operator fun plus(other: Vector3<T>): ImmutableVector3<T>
    public override operator fun minus(other: Vector3<T>): ImmutableVector3<T>

    public override operator fun plus(other: T): ImmutableVector3<T>
    public override operator fun minus(other: T): ImmutableVector3<T>

    public override val normalized: ImmutableVector3<T>
}