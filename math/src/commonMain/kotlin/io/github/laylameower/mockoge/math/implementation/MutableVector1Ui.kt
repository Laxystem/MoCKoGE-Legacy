package io.github.laylameower.mockoge.math.implementation

import io.github.laylameower.mockoge.math.MutableVector1
import io.github.laylameower.mockoge.math.Vector1
import io.github.laylameower.mockoge.math.Wrapper

internal open class MutableVector1Ui(override var x: UInt) : MutableVector1<UInt> {

    override fun timesAssign(other: Vector1<UInt>) {
        x *= other.x
    }

    override fun divAssign(other: Vector1<UInt>) {
        x /= other.x
    }

    override fun remAssign(other: Vector1<UInt>) {
        x %= other.x
    }

    override fun timesAssign(other: UInt) {
        x *= other
    }

    override fun divAssign(other: UInt) {
        x /= other
    }

    override fun remAssign(other: UInt) {
        x %= other
    }

    override fun plusAssign(other: Vector1<UInt>) {
        x += other.x
    }

    override fun minusAssign(other: Vector1<UInt>) {
        x -= other.x
    }

    override fun plusAssign(other: UInt) {
        x += other
    }

    override fun minusAssign(other: UInt) {
        x -= other
    }

    override val normalized: MutableVector1<UInt> get() = this / length.toUInt()
    override val length: Double get() = x.toDouble()
}