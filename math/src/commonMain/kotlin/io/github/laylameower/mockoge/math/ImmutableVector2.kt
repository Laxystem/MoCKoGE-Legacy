package io.github.laylameower.mockoge.math

public interface ImmutableVector2<T : Comparable<T>> : Vector2<T>, ImmutableVector1<T> {
    override var y: T

    public override operator fun times(other: Vector1<T>): ImmutableVector2<T>
    public override operator fun div(other: Vector1<T>): ImmutableVector2<T>

    public override operator fun times(other: Vector2<T>): ImmutableVector2<T>
    public override operator fun div(other: Vector2<T>): ImmutableVector2<T>

    public override operator fun times(other: T): ImmutableVector2<T>
    public override operator fun div(other: T): ImmutableVector2<T>

    public override operator fun plus(other: Vector1<T>): ImmutableVector2<T>
    public override operator fun minus(other: Vector1<T>): ImmutableVector2<T>

    public override operator fun plus(other: Vector2<T>): ImmutableVector2<T>
    public override operator fun minus(other: Vector2<T>): ImmutableVector2<T>

    public override operator fun plus(other: T): ImmutableVector2<T>
    public override operator fun minus(other: T): ImmutableVector2<T>

    public override val normalized: ImmutableVector2<T>
}