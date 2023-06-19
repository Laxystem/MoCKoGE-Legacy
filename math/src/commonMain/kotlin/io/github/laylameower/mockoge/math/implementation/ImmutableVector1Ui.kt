package io.github.laylameower.mockoge.math.implementation

import io.github.laylameower.mockoge.math.ImmutableVector1
import io.github.laylameower.mockoge.math.Vector1
import io.github.laylameower.mockoge.math.modified

internal open class ImmutableVector1Ui(override var x: UInt) : ImmutableVector1<UInt> {
    override fun times(other: Vector1<UInt>): ImmutableVector1<UInt> = modified { this *= other }

    override fun div(other: Vector1<UInt>): ImmutableVector1<UInt> = modified { this /= other }

    override fun rem(other: Vector1<UInt>): ImmutableVector1<UInt> = modified { this %= other }

    override fun times(other: UInt): ImmutableVector1<UInt> {
        TODO("Not yet implemented")
    }

    override fun div(other: UInt): ImmutableVector1<UInt> {
        TODO("Not yet implemented")
    }

    override fun rem(other: UInt): ImmutableVector1<UInt> {
        TODO("Not yet implemented")
    }

    override fun plus(other: Vector1<UInt>): ImmutableVector1<UInt> {
        TODO("Not yet implemented")
    }

    override fun minus(other: Vector1<UInt>): ImmutableVector1<UInt> {
        TODO("Not yet implemented")
    }

    override fun plus(other: UInt): ImmutableVector1<UInt> {
        TODO("Not yet implemented")
    }

    override fun minus(other: UInt): ImmutableVector1<UInt> {
        TODO("Not yet implemented")
    }

    override val normalized: ImmutableVector1<UInt>
        get() = TODO("Not yet implemented")
    override val length: Double
        get() = TODO("Not yet implemented")
}