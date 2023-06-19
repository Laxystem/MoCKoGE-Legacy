@file:Suppress("UNUSED_VARIABLE")

import org.jetbrains.kotlin.konan.target.HostManager

plugins {
    kotlin("multiplatform")
}

group = "io.github.laylameower.mockoge"
version = providers.gradleProperty("mockoge.core").get()

val coroutines: String by project

val kgl: String by project
val ktor: String by project
val semver: String by project
val colors: String by project
val jvm: String by project

kotlin {
    explicitApi()

    jvm {
        jvmToolchain(jvm.toInt())
        testRuns["test"].executionTask.configure {
            useJUnitPlatform()
        }
    }

    val natives = when {
        HostManager.hostIsMac -> {
            macosX64("native") {
                colors::provideDelegate
            }
            "macos"
        }

        HostManager.hostIsLinux -> {
            linuxX64("native")
            "linux"
        }

        HostManager.hostIsMingw -> {
            mingwX64("native")
            "mingw"
        }

        else -> throw GradleException("Host OS is not supported in Kotlin/Native.")
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                //implementation("org.jetbrains.kotlin:kotlin-scripting")
                //implementation("org.jetbrains.kotlin:kotlin-scripting-host")
                api("org.jetbrains.kotlin:kotlin-reflect")
                api("org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutines")
                api("io.ktor:ktor-io:$ktor")
                api("com.chrynan.colors:colors-core:$colors")
                api("com.chrynan.colors:colors-extension:$colors")
                api("com.chrynan.colors:colors-core:$colors")
                // api("com.chrynan.colors:colors-serialization:$colors")
                api(project(":util"))
                api(project(":math"))

                api("io.github.z4kn4fein:semver:$semver")

                api("com.kgl:kgl-core:$kgl")
                api("com.kgl:kgl-glfw:$kgl")
                api("com.kgl:kgl-vulkan:$kgl")
                api("com.kgl:kgl-glfw-vulkan:$kgl")
                api("com.kgl:kgl-stb:$kgl")
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:$coroutines")
            }
        }
        val jvmMain by getting {
            dependencies {
                implementation("org.jetbrains.kotlin:kotlin-scripting-jvm")
                implementation("org.jetbrains.kotlin:kotlin-scripting-jvm-host")
                api("org.jetbrains.kotlinx:kotlinx-coroutines-core-jvm:$coroutines")
                api("com.kgl:kgl-core-jvm:$kgl")
                api("com.kgl:kgl-glfw-jvm:$kgl")
                api("com.kgl:kgl-vulkan-jvm:$kgl")
                api("com.kgl:kgl-glfw-vulkan-jvm:$kgl")
                api("com.kgl:kgl-stb-jvm:$kgl")
            }
        }
        val jvmTest by getting
        val nativeMain by getting {
            dependencies {
                api("com.kgl:kgl-core-$natives:$kgl")
                api("com.kgl:kgl-glfw-$natives:$kgl")
                api("com.kgl:kgl-vulkan-$natives:$kgl")
                api("com.kgl:kgl-glfw-vulkan-$natives:$kgl")
                api("com.kgl:kgl-stb-$natives:$kgl")
            }
        }
        val nativeTest by getting
    }
}
