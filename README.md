> ***Note:** This document may not be always up-to-date, and may refer to a future change that isn't implemented already. This note will be removed when MoCKoGE goes beta.*
# MoCKoGE

***Mo**dular **C**oncurrent **Ko**tlin **G**ame **E**ngine, inspired
by [Gaming32's Kilo Engine](https://github.com/Gaming32/kilo-engine).*

### Modular
While MoCKoGE *can* be used as a stand-alone game engine, where's the fun in that? MoCKoGE code, scenes, assets, everything - are all stored in *bundles*. a bundle is a compressed directory that contains code and assets, whether it be a library, the game itself, or mods. See more below in the [bundles](#bundles) section.

This technique allows you to have two full, working games on the same MoCKoGE installation, with almost no performance hit, and enables out-of-the-box support for mods!

### Concurrent

MoCKoGE uses Kotlin's *coroutines* library to run multiple events at the same time, making it stupidly fast.

The `C` also stands for `Caching`, because MoCKoGE caches stuff. Very fast.

### Kotlin

MoCKoGE is written in Kotlin, scripted in Kotlin, basically *everything* in kotlin.

Using Kotlin Multiplatform, MoCKoGE games can be compiled to run on the JVM, Windows, Linux, MacOS, WASM, Android, iOS, and more.

### Game Engine

Well, it's a game engine. And it's [open source](LICENSE.md).

It's better than *Unity GE* - because it's open source, and it's Kotlin, not C# - for any other reason Unity is probably better than MoCKoGE - and than *Unreal GE* - because it loads in less than 50 minutes. It's also better than *Godot*, because it doesn't use the weird blue-ish color theme, and Kotlin support is official and actually works. Basically - you want Kotlin? *MoCKoGE* is (probably) the engine for you.

## Community

Please read the [license](LICENSE.md), the [contribution guidelines](CONTRIBUTING.md), and the [code of conduct](CODE_OF_CONDUCT.md).

You can also join our [Discord](https://discord.gg/TAs7PtCqnm)!

## Tooling

### Language

You ***must*** have a basic knowledge of Kotlin and easy access to [the Kotlin Documentation](https://kotlinlang.org/docs/home.html) in order to use MoCKoGE -
learning it "on the way" isn't such a good idea.

Java isn't officially supported, as it cannot override `suspend` (asynchronous/concurrent) functions and doesn't support kotlin multiplatform, not allowing your game to run on the Xbox or on the web.

> ***Note:** Feel free to make an issue if you need a feature or two - just create an issue before PRing, as your functionality might be possible with an external bundle, and we might not want it built-in to the engine.*

### Build System

MoCKoGE uses the Kotlin Multiplatform, that is built ontop of Gradle. There'll be a [plugin](#todo) to remove some of the complexity.

### IDE

We recommend using Intellij IDEA Ultimate -
it's [free for students](https://www.jetbrains.com/community/education/#students), for its advanced profiling features.
If you aren't a student, there's also the [FOSS CE](https://www.jetbrains.com/idea/).

| IDE                             | Officially Supported By MoCKoGE | Kotlin                                                                                             | Kotlin Script                                                                                                                           | Debugging                           | Logging                                                                                                  |
|---------------------------------|---------------------------------|----------------------------------------------------------------------------------------------------|-----------------------------------------------------------------------------------------------------------------------------------------|-------------------------------------|----------------------------------------------------------------------------------------------------------|
| IntelliJ IDEA                   | Yes                             | Full                                                                                               | Full                                                                                                                                    | Full                                | Basic, Improvable with an [official JetBrains Plugin](https://plugins.jetbrains.com/plugin/9746-ideolog) |
| Visual Studio Code & GitHub.dev | Partially                       | With a [3rd-Party Plugin](https://github.com/mathiasfrohlich/vscode-kotlin)                        | Syntax Highlighting Only                                                                                                                | None                                | Basic, Improvable with 3rd-Party Plugins                                                                 |
| Eclipse                         | No                              | With an [official JetBrains Plugin](https://marketplace.eclipse.org/content/kotlin-plugin-eclipse) | Syntax Highlighting Only, [Improvable with an official Jetbrains Plugin](https://marketplace.eclipse.org/content/kotlin-plugin-eclipse) | Partial, Doesn't Support Coroutines | Basic                                                                                                    |
| Apache NetBeans                 | No                              | With a discontinued official JetBrains Plugin only for Kotlin 1.4 and below                        | None                                                                                                                                    | None                                | Basic                                                                                                    |

> ***Note:** feel free to update this table (and the README as a whole) using a PR, or by creating an issue, as it may
be inaccurate or not updated.*

---

## TODO

As MoCKoGE is still a work-in-progress, there is a good deal of stuff to be done - feel free to contribute. Items that
use *italics* are already implemented, and **bold** marks the current focus.

- **Math API** (`mockoge:math`)
- Relations API (`mockoge:util`)
- Resource Loader
    - Kotlin Script Resource Loader
        - Bundles
            - _Definitions_
            - Relations
        - Scenes
        - Assets
    - Json5 Resource Loader
    - YAML Resource Loader
- Events (Using Kotlin Coroutines)
- Rendering (Using Vulkan)
    - Textures
    - Shaders
- Input System
- UI API
    - Built-in
    - Extra (`mockoge:ui`)
- Gradle Plug-In (`mockoge:gradle`)
- IDEA Plug-In (`mockoge:idea`)
- Documentation website using Dokka ([mockoge.lax.la](https://mockoge.lax.la/))

> ***But so much stuff isn't done yet! How can you say MoCKoGE will be finished soon?** Well, I didn't say that. Also,
most of the hard, infrastructure stuff is ~~done~~ WIP. Note this list isn't sorted in any way.*

### Crusades

The crusades, like the ones that happened in the Middle Ages, try to replace what was there before.
Basically, they're rewrites with fancy names.
Note such rewrites may not even affect you:
they may only break a singular feature of the engine, or just rewrite all the internals and keep the API the same. On the other hand, they can throw your entire project into chaos.

The following crusades are planned (_italics_ mean that crusade already happened):
- Separating `mockoge:core.util` into `mockoge:util`
- Changing package `io.github.laylameower` to `la.lax`
- _Renaming `Hexagine` to `MoCKoGE`_
- *Switching from `log4j` to `KLogging`*
- *Separating the single-project single-platform project to a gradle multi-project kotlin multi-platform project structure, renaming `mockoge` to `mockoge:core`*
