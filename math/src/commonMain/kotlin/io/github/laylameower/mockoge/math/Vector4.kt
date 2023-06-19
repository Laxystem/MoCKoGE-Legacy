package io.github.laylameower.mockoge.math

public interface Vector4<T : Comparable<T>> : Vector3<T> {
    public val w: T

    public override operator fun times(other: Vector1<T>): Vector4<T>
    public override operator fun div(other: Vector1<T>): Vector4<T>
    public override operator fun rem(other: Vector1<T>): Vector4<T>

    public override operator fun times(other: Vector2<T>): Vector4<T>
    public override operator fun div(other: Vector2<T>): Vector4<T>
    public override operator fun rem(other: Vector2<T>): Vector4<T>


    public override operator fun times(other: Vector3<T>): Vector4<T>
    public override operator fun div(other: Vector3<T>): Vector4<T>
    public override operator fun rem(other: Vector3<T>): Vector4<T>

    public operator fun times(other: Vector4<T>): Vector4<T>
    public operator fun div(other: Vector4<T>): Vector4<T>
    public operator fun rem(other: Vector4<T>): Vector4<T>

    public override operator fun times(other: T): Vector4<T>
    public override operator fun div(other: T): Vector4<T>
    public override operator fun rem(other: T): Vector4<T>

    public override operator fun plus(other: Vector1<T>): Vector4<T>
    public override operator fun minus(other: Vector1<T>): Vector4<T>

    public override operator fun plus(other: Vector2<T>): Vector4<T>
    public override operator fun minus(other: Vector2<T>): Vector4<T>

    public override operator fun plus(other: Vector3<T>): Vector4<T>
    public override operator fun minus(other: Vector3<T>): Vector4<T>

    public operator fun plus(other: Vector4<T>): Vector4<T>
    public operator fun minus(other: Vector4<T>): Vector4<T>

    public override operator fun plus(other: T): Vector4<T>
    public override operator fun minus(other: T): Vector4<T>

    public override val normalized: Vector4<T>

    override val size: Int get() = 4
    override infix fun contains(element: T): Boolean = super.contains(element) || w == element

    override fun iterator(): Iterator<T> = sequenceOf(x, y, z, w).iterator()
}
