@file:Suppress("UNUSED_VARIABLE")

import org.jetbrains.kotlin.konan.target.HostManager

plugins {
    kotlin("multiplatform")
    id("com.google.devtools.ksp")
}

group = "io.github.laylameower.mockoge"
version = providers.gradleProperty("mockoge.math").get()

val collections: String by project
val coroutines: String by project
val jvm: String by project

kotlin {
    explicitApi()

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
                implementation("org.jetbrains.kotlinx:kotlinx-collections-immutable:$collections")
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutines")
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
        val jvmMain by getting
        val jvmTest by getting
        val nativeMain by getting
        val nativeTest by getting
    }
}

dependencies {
    /*
    add("kspCommonMainMetadata", project(":codegen"))
    add("kspJvm", project(":codegen"))
    add("kspJvmTest", project(":codegen"))
     */
}