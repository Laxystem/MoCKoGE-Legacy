# Contributing to MoCKoGE
MoCKoGE is a sophisticated piece of technology, and even for its creators, it is hard to understand it sometimes.

## Requirements
- Have OpenJDK 17 installed.
- An IDE with Git, Kotlin, and Gradle support, preferably Intellij IDEA. See [here](README.md#ide) for more details.
- Decent knowledge and experience with how the engine works, Kotlin, Git, gradle, and if you're messing with the build system, the kotlin multiplatform plug-in.
- Willingness to learn, and have fun!

## Project Structure

The `mockoge` project is separated to modules - for example, `mockoge:math`, `mockoge:core`, and `mockoge:util`. Each module declares in its `README.md` the modules and libraries it depends on, its purpose, and its own contribution guidelines.

Dependency (and module) versions are declared in [`gradle.properties`](gradle.properties) - all mockoge modules must depend on the same dependency version - for example, `mockoge:util` and `mockoge:core` may not depend on different versions of `semver`, to prevent complications in the build scripts. The following syntax can be used to get the version of a dependency or a module:
```kotlin
// <module>:build.gradle.kts

// for modules
version = providers.gradleProperty("mockoge.<module>").get()
// for dependencies
val coroutines: String by project
```

Repositories are declared in the `subprojects` block of the root [`build.gradle.kts`](build.gradle.kts), for example:
```kotlin
// root build.gradle.kts

subprojects {
  repositories {
    mavenCentral()
    // etc....
  }
}
```
### Package Structure
The package naming is as such: `io.github.laylameower.mockoge.<module>.<package>` (will soon be changed to `la.lax.mockoge.<module>.<package>` - see more [here](README.md#crusades)), and may be shortened to `mockoge:<module>.<package>`, that way we all know what package exactly are we talking about.

The purpose of a package is explained briefly in the module's `README.md`, and may be explained further in a `README.md` of its own, if needed.
