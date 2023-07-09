# MoCKoGE Versioning

Before reading this document, read the [official Kotlin backwards compatibility guide](https://kotlinlang.org/docs/jvm-api-guidelines-backward-compatibility.html).

### `major.feature.patch-stage`

Each MoCKoGE [module](https://github.com/LaylaMeower/MoCKoGE/blob/community/CONTRIBUTING.md#project-structure) has its own version, declared in [`gradle.properties`](gradle.properties).

#### Increase `major` when:
- Source and behaviour incompatible changes are made to features released more than a week ago.
- Error-deprecated feature are removed.

#### Increase `feature` when:
- Source and behaviour changes are made to features released less than a week ago.
- Bytecode changes are made to features released more than a week ago.
- Major behavior-altering heavily relied upon bugs are fixed.
- Warning-deprecated features become error-deprecated.
- New major features are introduced.
- Experimental features become stable.

#### Increase `patch` when:
- Bytecode incompatible changes are made to features released less than a week ago.
- Behaviour, source and incompatible changes are made to features during an `alpha` or `beta` stage.
- Minor bugs are fixed.
- Features become warning-deprecated or warning-experimental.

#### About `stage`:
- For releases, drop this element.
- `rc` (release candicate) versions are released for public beta-testing, in order to verify the release-to-be has no bugs. One week later, if no major bugs were found, the same build, versioned the same except without the stage, should be released. Otherwise, another release candicate should be released with an increased `patch`, and go through the same 7-day process.
- `beta` versions only increase `patch`, and when they become stable, `major` and `feature` should be increased if necessary. May be used for production, although unrecommended.
- `alpha` versions have a `major` of `0` - the entire module is still experimental. Shouldn't be used for production.


## Important Note
> ***All*** versions must be uploaded to Maven Central. A version bump must happen on a special commit that ***only*** changes the version in `gradle.properties` ***immediately before*** release. If there was another commit between the version increase and the release, increase `patch` before releasing. Snapshots (`-SNAPSHOT`) may ***not*** be used, as Maven Central doesn't support them, and they're a hassle to work with.
