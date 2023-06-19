plugins {
    kotlin("jvm")
}

val jvm: String by project

kotlin {
    explicitApi()
    jvmToolchain(jvm.toInt())

}