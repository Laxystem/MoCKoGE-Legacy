package io.github.laylameower.mockoge.math.implementation

import io.github.laylameower.mockoge.math.Primitive
import kotlin.jvm.JvmInline

@JvmInline
internal value class UIntPrimitive(private val number: UInt) : Primitive {
    override fun toDouble(): Double = number.toDouble()

    override fun toFloat(): Float = number.toFloat()

    override fun toLong(): Long = number.toLong()

    override fun toULong(): ULong = number.toULong()

    override fun toInt(): Int = number.toInt()

    override fun toUInt(): UInt = number

    override fun toShort(): Short = number.toShort()

    override fun toUShort(): UShort = number.toUShort()

    override fun toByte(): Byte = number.toByte()

    override fun toUByte(): UByte = number.toUByte()
}