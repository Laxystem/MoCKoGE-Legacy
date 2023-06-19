package io.github.laylameower.mockoge.math.implementation

import io.github.laylameower.mockoge.math.MutableVector2
import io.github.laylameower.mockoge.math.Vector2
import io.github.laylameower.mockoge.math.Wrapper
import kotlin.math.sqrt

internal open class MutableVector2Ui(
    x: UInt,
    override var y: UInt
) : MutableVector1Ui(x), MutableVector2<UInt> {
    constructor(x: UInt, y: UInt?) : this(x, y ?: 0u)

    override fun timesAssign(other: Vector2<UInt>) {
        super.timesAssign(other)
        y *= other.y
    }

    override fun divAssign(other: Vector2<UInt>) {
        super.divAssign(other)
        y /= other.y
    }

    override fun remAssign(other: Vector2<UInt>) {
        super.remAssign(other)
        y %= other.y
    }

    override fun timesAssign(other: UInt) {
        super.timesAssign(other)
        y *= other
    }

    override fun divAssign(other: UInt) {
        super.divAssign(other)
        y /= other
    }

    override fun plusAssign(other: Vector2<UInt>) {
        super.plusAssign(other)
        y += other.y
    }

    override fun minusAssign(other: Vector2<UInt>) {
        super.minusAssign(other)
        y += other.x
    }

    override fun plusAssign(other: UInt) {
        super.plusAssign(other)
        y += other
    }

    override fun minusAssign(other: UInt) {
        super.minusAssign(other)
        y += other
    }

    override val normalized: MutableVector2<UInt> get() = this / length.toUInt()

    override val length: Double get() = sqrt((x * x + y * y).toDouble())
}