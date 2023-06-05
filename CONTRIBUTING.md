# Contributing to MoCKoGE
*Before* contributing, you must read the [code of conduct](CODE_OF_CONDUCT.md). *By* contributing, you're publishing your code under the terms of the [license](LICENSE.md).

MoCKoGE is a sophisticated piece of technology, and even for its creators, it is hard to understand it sometimes. Therefore, before contributing, please read the following document. If your PR doesn't comply with this document, it may be rejected or changed.

## Requirements
- OpenJDK 17
- An IDE with Git, Kotlin, and Gradle support, preferably Intellij IDEA. See [here](README.md#ide) for more details.
- Decent knowledge and experience with how the engine works, Kotlin, Git, gradle, and if you're messing with the build system, the kotlin multiplatform plug-in.
- Willingness to learn, and have fun!

## Contribution Cycle

Before creating a PR (pull/push request), you must first create an issue, and get it approved for contribution - otherwise, your hard work may be rejected (we don't want that...)

For a PR to be merged, its build and tests must be succesfull, no merge conflicts must be found, the contribution guidelines must be complied, and it must be reviewed (currently by two people, one of which is the person who presses the big blue "merge" button).

## Documentation & Licensing

At the start of each source code file, the following notice must be written:
```kotlin
/*
* This Source Code Form is subject to the terms of the Mozilla Public
* License, v. 2.0. If a copy of the MPL was not distributed with this
* file, You can obtain one at http://mozilla.org/MPL/2.0/.
*/

package io.github.laylameower.mockoge...
```
You may configure your IDE to only add the above notice to *changed* files only, to prevent creating unneeded merge conflicts.

> ***Note:** From now on, we'll call every code element, for example, but not limited to, functions, classses, properties, and more, that KDoc supports "code element".*

Additionally, you must document using KDoc all changed and new code elements, explaining its intended usage, inputs, outputs, how it works, limitations, etc. If you create, refactor, or implement a new non-`abstract` non-`expect` element, add your Github username to the KDoc under the `@author <username>` tag. If an author tag already exists, add another one below it.

### Creating Tests

Create as much tests for your code as possible. Every single edge case deserves a test!

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
