plugins {
    kotlin("multiplatform") apply false
    kotlin("jvm") apply false
    id("com.google.devtools.ksp") apply false
}

repositories {
    mavenCentral()
}

subprojects {
    repositories {
        mavenCentral()

        maven("https://maven.pkg.github.com/Dominaezzz/kgl") {
            name = "KGL"

            credentials {
                username = System.getenv("GITHUB_USERNAME") // Your GitHub username.
                password = System.getenv("GITHUB_PASSWORD") // A GitHub token with `read:packages`.
            }
        }

        maven("https://repo.repsy.io/mvn/chrynan/public") {
            name = "Colors"
        }

        google()
    }
}