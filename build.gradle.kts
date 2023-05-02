plugins {
    kotlin("jvm") version "1.8.21"
    application
}

group = "io.github.laylameower"
version = "0.0.1-alpha"

repositories {
    mavenCentral()
}

val lwjgl = "3.3.2"
val joml = "1.10.5"
val log4j = "2.20.0"
val semver = "1.4.2"
val coroutines = "1.6.4"

val lwjglNatives = "natives-windows" // TODO: Support More Natives

dependencies {
    testImplementation(kotlin("test"))

    implementation("org.jetbrains.kotlin", "kotlin-scripting-common")
    implementation("org.jetbrains.kotlin", "kotlin-scripting-jvm")
    implementation("org.jetbrains.kotlin", "kotlin-scripting-jvm-host")
    api("org.jetbrains.kotlinx", "kotlinx-coroutines-core", coroutines)

    api("org.joml", "joml", joml)
    api("org.apache.logging.log4j", "log4j-api", log4j)
    implementation("org.apache.logging.log4j", "log4j-core", log4j)
    api("io.github.z4kn4fein", "semver", semver)

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

val bundle = tasks.register("bundle") {
    doLast {
        project.delete("out/bundles")

        copy {
            from("build/libs")
            include("*.jar")
            exclude("mockoge-$version.jar")
            exclude("*-sources.jar")
            exclude("*-javadoc.jar")
            into("out/bundles")
            rename {
                if (it.endsWith(".jar"))
                    "${it.substringBeforeLast(".jar")}.hexabundle"
                else it
            }
        }
    }
}

kotlin {
    jvmToolchain(17)
}

application {
    mainClass.set("io.github.laylameower.mockoge.MockogeLauncherKt")
    applicationDefaultJvmArgs = listOf("-DmockogeVersion=$version")

    tasks.withType<JavaExec> {
        dependsOn(bundle)
        workingDir = rootProject.file("out")
   }
}