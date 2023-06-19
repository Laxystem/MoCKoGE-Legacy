package io.github.laylameower.mockoge.math

public interface Vector2<T : Comparable<T>> : Vector1<T> {
    public val y: T

    public override operator fun times(other: Vector1<T>): Vector2<T>
    public override operator fun div(other: Vector1<T>): Vector2<T>
    public override operator fun rem(other: Vector1<T>): Vector2<T>

    public operator fun times(other: Vector2<T>): Vector2<T>
    public operator fun div(other: Vector2<T>): Vector2<T>
    public operator fun rem(other: Vector2<T>): Vector2<T>

    public override operator fun times(other: T): Vector2<T>
    public override operator fun div(other: T): Vector2<T>
    public override operator fun rem(other: T): Vector2<T>

    public override operator fun plus(other: Vector1<T>): Vector2<T>
    public override operator fun minus(other: Vector1<T>): Vector2<T>

    public operator fun plus(other: Vector2<T>): Vector2<T>
    public operator fun minus(other: Vector2<T>): Vector2<T>

    public override operator fun plus(other: T): Vector2<T>
    public override operator fun minus(other: T): Vector2<T>

    public override val normalized: Vector2<T>

    override val size: Int get() = 2
    override infix fun contains(element: T): Boolean = super.contains(element) || y == element

    override fun iterator(): Iterator<T> = sequenceOf(x, y).iterator()
}
