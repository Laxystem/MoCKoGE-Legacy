# MoCKoGE

***Mo**dular **C**oncurrent **Ko**tlin **G**ame **E**ngine, inspired
by [Gaming32's Kilo Engine](https://github.com/Gaming32/kilo-engine).*

Pronounced "Mo-Koge" - but _you_ can pronounce it however you like.

## Tooling

### Language

You ***must*** have a basic knowledge of Kotlin (or decent experience in Java and easy access
to [the Kotlin Documentation](https://kotlinlang.org/docs/home.html)) in order to use MoCKoGE - learning it "on the way"
isn't such a good idea.

Java isn't officially supported, as it cannot override `suspend` (asynchronous/concurrent) functions, and usage of
Kotlin Scripts is required (unless you're using a [custom resource loader](#todo)) but feel free to make an issue (or PR
it yourself) if you need a feature or two.

### Build System

We recommend using Gradle w/ the Kotlin DSL. There'll be an [official Gradle Plug-In](#todo).

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

As MoCKoGE is still a work-in-progress, there are a good deal of stuff to be done - feel free to contribute. Items that
use *italics* are already implemented.

- Relations API
- Resource Loader
    - Kotlin Script Resource Loader
        - Bundles
            - _Definitions_
            - Relations
        - Scenes
        - Assets
    - Support for custom Resource Loaders
- Events (Using Kotlin Coroutines)
- Rendering (Using [LearnOpenGL.com](https://learnopengl.com))
    - Textures
    - Scripts
- Input System
- Components
    - Relations
    - UI (Potentially Using [Dear ImgGui](https://github.com/kotlin-graphics/imgui) & NanoVG)
- Gradle Plug-In

> ***But so much stuff isn't done yet! How can you say MoCKoGE will be finished soon?** Well, I didn't say that. Also,
most of the hard, infrastructure stuff is done. Note this list isn't sorted in any way.*