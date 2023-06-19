package io.github.laylameower.mockoge.math

public interface ImmutableVector1<T : Comparable<T>> : Vector1<T> {
    override var x: T

    public override operator fun times(other: Vector1<T>): ImmutableVector1<T>
    public override operator fun div(other: Vector1<T>): ImmutableVector1<T>
    public override operator fun rem(other: Vector1<T>): ImmutableVector1<T>

    public override operator fun times(other: T): ImmutableVector1<T>
    public override operator fun div(other: T): ImmutableVector1<T>
    public override operator fun rem(other: T): ImmutableVector1<T>

    public override operator fun plus(other: Vector1<T>): ImmutableVector1<T>
    public override operator fun minus(other: Vector1<T>): ImmutableVector1<T>

    public override operator fun plus(other: T): ImmutableVector1<T>
    public override operator fun minus(other: T): ImmutableVector1<T>

    public override val normalized: ImmutableVector1<T>
}