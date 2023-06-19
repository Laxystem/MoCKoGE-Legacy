@file:Suppress("UNUSED_VARIABLE")

import org.jetbrains.kotlin.konan.target.HostManager

plugins {
    kotlin("multiplatform")
}

group = "io.github.laylameower.mockoge"
version = providers.gradleProperty("mockoge.util").get()

val collections: String by project
val jvm: String by project
val klogging: String by project
val okio: String by project
val semver: String by project

kotlin {
    explicitApi()

    js(IR)
    //wasm()

    jvm {
        jvmToolchain(jvm.toInt())
        testRuns["test"].executionTask.configure {
            useJUnitPlatform()
        }
    }

    when {
        HostManager.hostIsMac -> macosX64("native")
        HostManager.hostIsLinux -> linuxX64("native")
        HostManager.hostIsMingw -> mingwX64("native")
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                api("org.jetbrains.kotlinx:kotlinx-collections-immutable:$collections")
                api("io.github.oshai:kotlin-logging:$klogging")
                api("io.github.z4kn4fein:semver:$semver")
                api("com.squareup.okio:okio:$okio")
            }
        }
        val commonTest by getting {
            dependencies {
                implementation("com.squareup.okio:okio-fakefilesystem:$okio")
                implementation(kotlin("test"))
            }
        }
        val jvmMain by getting {
            dependencies {
                implementation("io.github.oshai:kotlin-logging-jvm:$klogging")
            }
        }
        val jvmTest by getting
        val jsMain by getting {
            dependencies {
                implementation("com.squareup.okio:okio-nodefilesystem:$okio")
            }
        }
        val jsTest by getting
        val nativeMain by getting
        val nativeTest by getting
    }
}