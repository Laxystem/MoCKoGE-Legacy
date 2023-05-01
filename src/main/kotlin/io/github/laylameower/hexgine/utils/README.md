# Hexagine Utilities
The `utils` folder should only contain `interfaces` and `enums`, no implementations.

In addition, it may contain general utility function files, that all start with:
```kotlin
@file:JvmName("Utilities")
@file:JvmMultifileClass
```

Notice that is in addition to the following - **all** files must start with:
```kotlin
@file:Suppress("unused")
```

> *the naming convention is `PascalCase`, even for files, as usual in Kotlin.*