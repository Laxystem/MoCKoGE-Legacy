package io.github.laylameower.mockoge.math

public interface Primitive {
    /**
     * Returns the value of this number as a [Double], which may involve rounding.
     * @see Number.toDouble
     */
    public fun toDouble(): Double

    /**
     * Returns the value of this number as a [Float], which may involve rounding.
     * @see Number.toFloat
     */
    public fun toFloat(): Float

    /**
     * Returns the value of this number as a [Long], which may involve rounding or truncation.
     * @see Number.toLong
     */
    public fun toLong(): Long

    /**
     * Returns the value of this number as a [ULong], which may involve rounding, truncation.
     * @see Number.toLong
     * @see Long.toULong
     */
    public fun toULong(): ULong

    /**
     * Returns the value of this number as an [Int], which may involve rounding or truncation.
     * @see Number.toInt
     */
    public fun toInt(): Int

    /**
     * Returns the value of this number as a [UInt], which may involve rounding or truncation.
     * @see Number.toInt
     * @see Int.toUInt
     */
    public fun toUInt(): UInt

    /**
     * Returns the value of this number as a [Short], which may involve rounding or truncation.
     * @see Number.toShort
     */
    public fun toShort(): Short

    /**
     * Returns the value of this number as a [Short], which may involve rounding or truncation.
     * @see Number.toShort
     * @see Short.toUShort
     */
    public fun toUShort(): UShort

    /**
     * Returns the value of this number as a [Byte], which may involve rounding or truncation.
     * @see Number.toByte
     */
    public fun toByte(): Byte

    /**
     * Returns the value of this number as a [UByte], which may involve rounding or truncation.
     * @see Number.toByte
     * @see Byte.toUByte
     */
    public fun toUByte(): UByte
}