plugins {
    kotlin("jvm") version "1.8.20"
    application
}

group = "io.github.laylameower"
version = "0.0.1"

repositories {
    mavenCentral()
    maven {
        name = "Quilt"
        url = uri("https://maven.quiltmc.org/repository/release")
    }
}

val lwjgl = "3.3.2"
val joml = "1.10.5"
val log4j = "2.20.0"
val semver = "1.4.2"
val coroutines = "1.6.4"

val lwjglNatives = "natives-windows"

dependencies {
    testImplementation(kotlin("test"))

    implementation("org.jetbrains.kotlin", "kotlin-scripting-common")
    implementation("org.jetbrains.kotlin", "kotlin-scripting-jvm")
    implementation("org.jetbrains.kotlin", "kotlin-scripting-jvm-host")
    implementation("org.jetbrains.kotlinx", "kotlinx-coroutines-core", coroutines)

    implementation("org.joml", "joml", joml)
    implementation("org.apache.logging.log4j", "log4j-api", log4j)
    implementation("org.apache.logging.log4j", "log4j-core", log4j)
    implementation("io.github.z4kn4fein", "semver", semver)

    implementation(platform("org.lwjgl:lwjgl-bom:$lwjgl"))

    implementation("org.lwjgl", "lwjgl")
    implementation("org.lwjgl", "lwjgl-glfw")
    implementation("org.lwjgl", "lwjgl-opengl")
    runtimeOnly("org.lwjgl", "lwjgl", classifier = lwjglNatives)
    runtimeOnly("org.lwjgl", "lwjgl-glfw", classifier = lwjglNatives)
    runtimeOnly("org.lwjgl", "lwjgl-opengl", classifier = lwjglNatives)
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(17)
}

application {
    mainClass.set("io.github.laylameower.MainKt")
}