package io.github.laylameower.mockoge.math.implementation

import io.github.laylameower.mockoge.math.*
import kotlin.math.sqrt
import kotlin.toUInt

internal open class MutableVector4Ui(
    x: UInt, y: UInt, z: UInt,
    override var w: UInt
) : MutableVector3Ui(x, y ,z), MutableVector4<UInt> {

    constructor(x: UInt, y: UInt?, z: UInt?, w: UInt?) : this(x, y ?: 0u, z ?: 0u, w ?: 0u)

    override fun timesAssign(other: Vector4<UInt>) {
        super.timesAssign(other)
        w *= other.w
    }

    override fun divAssign(other: Vector4<UInt>) {
        super.divAssign(other)
        w /= other.w
    }

    override fun remAssign(other: Vector4<UInt>) {
        super.remAssign(other)
        w %= other.w
    }

    override fun timesAssign(other: UInt) {
        super.timesAssign(other)
        w *= other
    }

    override fun divAssign(other: UInt) {
        super.divAssign(other)
        w /= other
    }

    override fun remAssign(other: UInt) {
        super.remAssign(other)
        w %= other
    }

    override fun plusAssign(other: Vector4<UInt>) {
        super.plusAssign(other)
        w += other.w
    }

    override fun minusAssign(other: Vector4<UInt>) {
        super.minusAssign(other)
        w += other.x
    }

    override fun plusAssign(other: UInt) {
        super.plusAssign(other)
        w += other
    }

    override fun minusAssign(other: UInt) {
        super.minusAssign(other)
        w += other
    }

    override val normalized: MutableVector4<UInt> get() = this / length.toUInt()
    override val length: Double get() = sqrt((x * x + y * y + z * z).toDouble())
}