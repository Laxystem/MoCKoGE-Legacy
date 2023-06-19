package io.github.laylameower.mockoge.math

public interface MutableVector3<T : Comparable<T>> : Vector3<T>, MutableVector2<T> {
    override var z: T

    public operator fun timesAssign(other: Vector3<T>)
    public operator fun divAssign(other: Vector3<T>)
    public operator fun remAssign(other: Vector3<T>)

    public operator fun plusAssign(other: Vector3<T>)
    public operator fun minusAssign(other: Vector3<T>)

    public override val normalized: MutableVector3<T>

    public override operator fun times(other: Vector1<T>): MutableVector3<T> = also { this *= other }
    public override operator fun div(other: Vector1<T>): MutableVector3<T> = also { this /= other }
    public override operator fun rem(other: Vector1<T>): MutableVector3<T> = also { this %= other}

    public override operator fun times(other: Vector2<T>): MutableVector3<T> = also { this *= other }
    public override operator fun div(other: Vector2<T>): MutableVector3<T> = also { this /= other }
    public override operator fun rem(other: Vector2<T>): MutableVector3<T> = also { this %= other}

    public override operator fun times(other: Vector3<T>): MutableVector3<T> = also { this *= other }
    public override operator fun div(other: Vector3<T>): MutableVector3<T> = also { this /= other }
    public override operator fun rem(other: Vector3<T>): MutableVector3<T> = also { this %= other}

    public override operator fun times(other: T): MutableVector3<T> = also { this *= other }
    public override operator fun div(other: T): MutableVector3<T> = also { this /= other }
    public override operator fun rem(other: T): MutableVector3<T> = also { this %= other}

    public override operator fun plus(other: Vector1<T>): MutableVector3<T> = also { this += other }
    public override operator fun minus(other: Vector1<T>): MutableVector3<T> = also { this -= other }

    public override operator fun plus(other: Vector2<T>): MutableVector3<T> = also { this += other }
    public override operator fun minus(other: Vector2<T>): MutableVector3<T> = also { this -= other }

    public override operator fun plus(other: Vector3<T>): MutableVector3<T> = also { this += other }
    public override operator fun minus(other: Vector3<T>): MutableVector3<T> = also { this -= other }

    public override operator fun plus(other: T): MutableVector3<T> = also { this += other }
    public override operator fun minus(other: T): MutableVector3<T> = also { this -= other }
}