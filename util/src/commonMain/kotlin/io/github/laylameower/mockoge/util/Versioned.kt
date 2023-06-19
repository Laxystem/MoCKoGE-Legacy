package io.github.laylameower.mockoge.util

import io.github.z4kn4fein.semver.Version

public interface Versioned : Comparable<Version> {
    public val version: Version

    override fun compareTo(other: Version): Int = version.compareTo(other)
}
