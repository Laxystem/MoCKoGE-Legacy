package io.github.laylameower.mockoge.math

public interface MutableVector2<T : Comparable<T>> : Vector2<T>, MutableVector1<T> {
    override var y: T

    public operator fun timesAssign(other: Vector2<T>)
    public operator fun divAssign(other: Vector2<T>)
    public operator fun remAssign(other: Vector2<T>)

    public operator fun plusAssign(other: Vector2<T>)
    public operator fun minusAssign(other: Vector2<T>)

    public override val normalized: MutableVector2<T>

    public override operator fun times(other: Vector1<T>): MutableVector2<T> = also { this *= other }
    public override operator fun div(other: Vector1<T>): MutableVector2<T> = also { this /= other }
    public override operator fun rem(other: Vector1<T>): MutableVector2<T> = also { this %= other}

    public override operator fun times(other: Vector2<T>): MutableVector2<T> = also { this *= other }
    public override operator fun div(other: Vector2<T>): MutableVector2<T> = also { this /= other }
    public override operator fun rem(other: Vector2<T>): MutableVector2<T> = also { this %= other}

    public override operator fun times(other: T): MutableVector2<T> = also { this *= other }
    public override operator fun div(other: T): MutableVector2<T> = also { this /= other }
    public override operator fun rem(other: T): MutableVector2<T> = also { this %= other}

    public override operator fun plus(other: Vector1<T>): MutableVector2<T> = also { this += other }
    public override operator fun minus(other: Vector1<T>): MutableVector2<T> = also { this -= other }

    public override operator fun plus(other: Vector2<T>): MutableVector2<T> = also { this += other }
    public override operator fun minus(other: Vector2<T>): MutableVector2<T> = also { this -= other }

    public override operator fun plus(other: T): MutableVector2<T> = also { this += other }
    public override operator fun minus(other: T): MutableVector2<T> = also { this -= other }
}