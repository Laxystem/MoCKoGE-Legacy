package io.github.laylameower.mockoge.math

public interface MutableVector4<T : Comparable<T>> : Vector4<T>, MutableVector3<T> {
    override var w: T

    public operator fun timesAssign(other: Vector4<T>)
    public operator fun divAssign(other: Vector4<T>)
    public operator fun remAssign(other: Vector4<T>)

    public operator fun plusAssign(other: Vector4<T>)
    public operator fun minusAssign(other: Vector4<T>)

    public override val normalized: MutableVector4<T>

    public override operator fun times(other: Vector1<T>): MutableVector4<T> = also { this *= other }
    public override operator fun div(other: Vector1<T>): MutableVector4<T> = also { this /= other }
    public override operator fun rem(other: Vector1<T>): MutableVector4<T> = also { this %= other}

    public override operator fun times(other: Vector2<T>): MutableVector4<T> = also { this *= other }
    public override operator fun div(other: Vector2<T>): MutableVector4<T> = also { this /= other }
    public override operator fun rem(other: Vector2<T>): MutableVector4<T> = also { this %= other}

    public override operator fun times(other: Vector3<T>): MutableVector4<T> = also { this *= other }
    public override operator fun div(other: Vector3<T>): MutableVector4<T> = also { this /= other }
    public override operator fun rem(other: Vector3<T>): MutableVector4<T> = also { this %= other}

    public override operator fun times(other: Vector4<T>): MutableVector4<T> = also { this *= other }
    public override operator fun div(other: Vector4<T>): MutableVector4<T> = also { this /= other }
    public override operator fun rem(other: Vector4<T>): MutableVector4<T> = also { this %= other}

    public override operator fun times(other: T): MutableVector4<T> = also { this *= other }
    public override operator fun div(other: T): MutableVector4<T> = also { this /= other }
    public override operator fun rem(other: T): MutableVector4<T> = also { this %= other}

    public override operator fun plus(other: Vector1<T>): MutableVector4<T> = also { this += other }
    public override operator fun minus(other: Vector1<T>): MutableVector4<T> = also { this -= other }

    public override operator fun plus(other: Vector2<T>): MutableVector4<T> = also { this += other }
    public override operator fun minus(other: Vector2<T>): MutableVector4<T> = also { this -= other }

    public override operator fun plus(other: Vector3<T>): MutableVector4<T> = also { this += other }
    public override operator fun minus(other: Vector3<T>): MutableVector4<T> = also { this -= other }

    public override operator fun plus(other: Vector4<T>): MutableVector4<T> = also { this += other }
    public override operator fun minus(other: Vector4<T>): MutableVector4<T> = also { this -= other }

    public override operator fun plus(other: T): MutableVector4<T> = also { this += other }
    public override operator fun minus(other: T): MutableVector4<T> = also { this -= other }
}
