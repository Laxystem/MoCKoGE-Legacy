package io.github.laylameower.mockoge.math

import io.github.laylameower.mockoge.math.implementation.*
import io.github.laylameower.mockoge.math.implementation.UIntPrimitive
import io.github.laylameower.mockoge.math.implementation.UShortPrimitive

public typealias MutableVector1f = MutableSignedVector1<Float>
public typealias MutableVector2f = MutableSignedVector2<Float>
public typealias MutableVector3f = MutableSignedVector3<Float>
public typealias MutableVector4f = MutableSignedVector4<Float>

public typealias Vector1f = ImmutableSignedVector1<Float>
public typealias Vector2f = ImmutableSignedVector2<Float>
public typealias Vector3f = ImmutableSignedVector3<Float>
public typealias Vector4f = ImmutableSignedVector4<Float>

public typealias MutableVector1d = MutableSignedVector1<Double>
public typealias MutableVector2d = MutableSignedVector2<Double>
public typealias MutableVector3d = MutableSignedVector3<Double>
public typealias MutableVector4d = MutableSignedVector4<Double>

public typealias Vector1d = ImmutableSignedVector1<Double>
public typealias Vector2d = ImmutableSignedVector2<Double>
public typealias Vector3d = ImmutableSignedVector3<Double>
public typealias Vector4d = ImmutableSignedVector4<Double>

public typealias MutableVector1b = MutableSignedVector1<Byte>
public typealias MutableVector2b = MutableSignedVector2<Byte>
public typealias MutableVector3b = MutableSignedVector3<Byte>
public typealias MutableVector4b = MutableSignedVector4<Byte>

public typealias Vector1b = ImmutableSignedVector1<Byte>
public typealias Vector2b = ImmutableSignedVector2<Byte>
public typealias Vector3b = ImmutableSignedVector3<Byte>
public typealias Vector4b = ImmutableSignedVector4<Byte>

public typealias MutableVector1Ub = MutableVector1<UByte>
public typealias MutableVector2Ub = MutableVector2<UByte>
public typealias MutableVector3Ub = MutableVector3<UByte>
public typealias MutableVector4Ub = MutableVector4<UByte>

public typealias Vector1Ub = ImmutableVector1<UByte>
public typealias Vector2Ub = ImmutableVector2<UByte>
public typealias Vector3Ub = ImmutableVector3<UByte>
public typealias Vector4Ub = ImmutableVector4<UByte>

public typealias MutableVector1s = MutableSignedVector1<Short>
public typealias MutableVector2s = MutableSignedVector2<Short>
public typealias MutableVector3s = MutableSignedVector3<Short>
public typealias MutableVector4s = MutableSignedVector4<Short>

public typealias Vector1s = ImmutableSignedVector1<Short>
public typealias Vector2s = ImmutableSignedVector2<Short>
public typealias Vector3s = ImmutableSignedVector3<Short>
public typealias Vector4s = ImmutableSignedVector4<Short>

public typealias MutableVector1Us = MutableVector1<UShort>
public typealias MutableVector2Us = MutableVector2<UShort>
public typealias MutableVector3Us = MutableVector3<UShort>
public typealias MutableVector4Us = MutableVector4<UShort>

public typealias Vector1Us = ImmutableVector1<UShort>
public typealias Vector2Us = ImmutableVector2<UShort>
public typealias Vector3Us = ImmutableVector3<UShort>
public typealias Vector4Us = ImmutableVector4<UShort>

public typealias MutableVector1i = MutableSignedVector1<Int>
public typealias MutableVector2i = MutableSignedVector2<Int>
public typealias MutableVector3i = MutableSignedVector3<Int>
public typealias MutableVector4i = MutableSignedVector4<Int>

public typealias Vector1i = ImmutableSignedVector1<Int>
public typealias Vector2i = ImmutableSignedVector2<Int>
public typealias Vector3i = ImmutableSignedVector3<Int>
public typealias Vector4i = ImmutableSignedVector4<Int>

public typealias MutableVector1Ui = MutableVector1<UInt>
public typealias MutableVector2Ui = MutableVector2<UInt>
public typealias MutableVector3Ui = MutableVector3<UInt>
public typealias MutableVector4Ui = MutableVector4<UInt>

public typealias Vector1Ui = ImmutableVector1<UInt>
public typealias Vector2Ui = ImmutableVector2<UInt>
public typealias Vector3Ui = ImmutableVector3<UInt>
public typealias Vector4Ui = ImmutableVector4<UInt>

public typealias MutableVector1l = MutableSignedVector1<Long>
public typealias MutableVector2l = MutableSignedVector2<Long>
public typealias MutableVector3l = MutableSignedVector3<Long>
public typealias MutableVector4l = MutableSignedVector4<Long>

public typealias Vector1l = ImmutableSignedVector1<Long>
public typealias Vector2l = ImmutableSignedVector2<Long>
public typealias Vector3l = ImmutableSignedVector3<Long>
public typealias Vector4l = ImmutableSignedVector4<Long>

public typealias MutableVector1Ul = MutableVector1<ULong>
public typealias MutableVector2Ul = MutableVector2<ULong>
public typealias MutableVector3Ul = MutableVector3<ULong>
public typealias MutableVector4Ul = MutableVector4<ULong>

public typealias Vector1Ul = ImmutableVector1<ULong>
public typealias Vector2Ul = ImmutableVector2<ULong>
public typealias Vector3Ul = ImmutableVector3<ULong>
public typealias Vector4Ul = ImmutableVector4<ULong>

/**
 * Does this vector contain a number that can be negative?
 */
public inline val Vector1<*>.isSigned: Boolean get() = this is SignedVector1

/**
 * Will operations such as `vector * 42` modify the vector, or create a new one?
 */
public inline val Vector1<*>.isMutable: Boolean get() = this is MutableVector1

/**
 * Is this vector [normalized][Vector1.normalized]?
 */
public inline val Vector1<*>.isNormalized: Boolean get() = length == 1.0

public val Number.boxed: Primitive get() = SignedPrimitive(this)
public val UByte.boxed: Primitive get() = UBytePrimitive(this)
public val UShort.boxed: Primitive get() = UShortPrimitive(this)
public val UInt.boxed: Primitive get() = UIntPrimitive(this)
public val ULong.boxed: Primitive get() = ULongPrimitive(this)

public val Any.primitiveOrNull: Primitive?
    get() = when (this) {
        is Primitive -> this
        is Number -> boxed
        is UByte -> boxed
        is UShort -> boxed
        is UInt -> boxed
        is ULong -> boxed
        else -> null
    }

public val Any.primitive: Primitive get() = primitiveOrNull!!

public val <T : Comparable<T>> Vector1<T>.yOrNull: T? get() = if (this is Vector2<T>) y else null
public val <T : Comparable<T>> Vector1<T>.zOrNull: T? get() = if (this is Vector3<T>) z else null
public val <T : Comparable<T>> Vector1<T>.wOrNull: T? get() = if (this is Vector4<T>) w else null

public fun <T : Comparable<T>> Vector1<T>.toVector1Ui(): Vector1Ui = ImmutableVector1Ui(x.primitive.toUInt())

public fun <T : Comparable<T>> Vector1<T>.toMutableVector1Ui(): MutableVector1Ui =
    MutableVector1Ui(x.primitive.toUInt())

public fun <T : Comparable<T>> Vector1<T>.toMutableVector2Ui(): MutableVector2Ui =
    MutableVector2Ui(x.primitive.toUInt(), yOrNull?.primitive?.toUInt())

public fun <T : Comparable<T>> Vector1<T>.toMutableVector3Ui(): MutableVector3Ui =
    MutableVector3Ui(x.primitive.toUInt(), yOrNull?.primitive?.toUInt(), zOrNull?.primitive?.toUInt())

public fun <T : Comparable<T>> Vector1<T>.toMutableVector4Ui(): MutableVector4Ui =
    MutableVector4Ui(
        x.primitive.toUInt(),
        yOrNull?.primitive?.toUInt(),
        zOrNull?.primitive?.toUInt(),
        wOrNull?.primitive?.toUInt()
    )

public inline fun Vector1Ui.modified(block: MutableVector1Ui.() -> Unit): Vector1Ui =
    toMutableVector1Ui().also { block(it) }.toVector1Ui()

public fun main() {
    var vector = vectorOf(x = 1u)

    vector = vector.modified {
        x *= 5u
        this += 3u
    }
}

fun vectorOf(x: UInt): Vector1Ui {

}
