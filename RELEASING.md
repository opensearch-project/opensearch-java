- [Overview](#overview)
- [Branching](#branching)
  - [Release Branching](#release-branching)
  - [Feature Branches](#feature-branches)
- [Release Labels](#release-labels)
- [Releasing](#releasing)
  - [Releasing New Versions](#releasing-new-versions)
    - [Releasing a Patch (v2.10.5)](#releasing-a-patch-v2105)
    - [Releasing a new Minor Version (v2.11.0)](#releasing-a-new-minor-version-v2110)
    - [Releasing a new Major Version (v3.0.0)](#releasing-a-new-major-version-v300)
  - [Automated Release](#automated-release)
  - [CHANGELOG Entries](#changelog-entries)

## Overview

This document explains the release strategy for artifacts in this organization.

## Branching

### Release Branching

Given the next major release of 3.0, current major release of 2.x, and latest minor release of 2.10, this project maintains the following active branches.

* **main**: The next _major_ release, e.g. `3.0.0`. This is the branch where all merges take place and code moves fast.
* **2.x**: The next _minor_ release, e.g. `2.11.0`. Once a change is merged into `main`, decide whether to backport it to `2.x`.
* **2.10**: The _next_ patch release, e.g. `2.10.5`. In between minor releases, only hotfixes (e.g. security) are backported to `2.10`.

PRs go into `main`. Label PRs that you need to be backported as `backport 2.x`. Backport PRs by checking out the versioned branch, cherry-pick changes and open a PR against each target backport branch.

### Feature Branches

Do not create branches in the upstream repo, use your fork, for the exception of long lasting feature branches that require active collaboration from multiple developers. Name feature branches `feature/<thing>`. Once the work is merged to `main`, please make sure to delete the feature branch.

## Release Labels

Repositories create consistent release labels, such as `v1.0.0`, `v1.1.0` and `v2.0.0`. Use release labels to target an issue or a PR for a given release. See [MAINTAINERS](MAINTAINERS.md#triage-open-issues) for more information on triaging issues.

## Releasing

### Releasing New Versions

The release process is standard across repositories in this org and is run by a release manager volunteering from amongst [MAINTAINERS](MAINTAINERS.md).

Assuming the following current state.

1. `2.10`: next patch, i.e. `2.10.5-SNAPSHOT`
2. `2.x`: next minor, i.e. `2.11.0-SNAPSHOT`
3. `main`: next major, i.e. `3.0.0-SNAPSHOT`

#### Releasing a Patch (v2.10.5)

1. Check out `2.10`.
2. Ensure `systemProp.version` in [gradle.properties](gradle.properties) matches the version being released, i.e. `2.10.5`.
3. Replace `## [Unreleased x.y]` with `## [2.10.5] - 06/20/2024` in [CHANGELOG](CHANGELOG.md).
4. Commit changes to `gradle.properties` and [CHANGELOG](CHANGELOG.md).
5. Create a tag, `v2.10.5`, and push your changes and the new tag to GitHub. An automated release will be made.
6. An [increment version workflow](.github/workflows/increment-version.yml) will make a pull request to set `systemProp.version` in [gradle.properties](gradle.properties) to `2.10.6` in the `2.10` branch.

#### Releasing a new Minor Version (v2.11.0)

1. Check out `2.x`.
2. Ensure `systemProp.version` in [gradle.properties](gradle.properties) matches the version being released, i.e. `2.11.0`.
3. Replace `## [Unreleased x.y]` with `## [2.11.0] - 06/20/2024` in [CHANGELOG](CHANGELOG.md).
4. Commit changes to `gradle.properties` and [CHANGELOG](CHANGELOG.md).
5. Create a tag, `v2.11.0`, and push your changes and the new tag to GitHub. An automated release will be made.
6. Create a branch, `2.11`, set `systemProp.version` in [gradle.properties](gradle.properties) to `2.11.1`, and push the new branch to GitHub.
7. An [increment version workflow](.github/workflows/increment-version.yml) will make a pull request to set `systemProp.version` in [gradle.properties](gradle.properties) to `2.12.0` in the `2.x` branch.

#### Releasing a new Major Version (v3.0.0)

1. Check out `main`.
2. Ensure `systemProp.version` in [gradle.properties](gradle.properties) matches the version being released, i.e. `3.0.0`.
3. Replace `## [Unreleased x.y]` with `## [3.0.0] - 06/20/2024` in [CHANGELOG](CHANGELOG.md).
4. Commit changes to `gradle.properties` and [CHANGELOG](CHANGELOG.md).
5. Create a tag, `v3.0.0`, and push your changes and the new tag to GitHub. An automated release will be made.
6. Create a branch, `3.0`, set `systemProp.version` in [gradle.properties](gradle.properties) to `3.0.1`, and push the new branch to GitHub.
7. Create a branch, `3.x`, set `systemProp.version` in [gradle.properties](gradle.properties) to `3.1.0`, and push the new branch to GitHub.
8. An [increment version workflow](.github/workflows/increment-version.yml) will make a pull request to set `systemProp.version` in [gradle.properties](gradle.properties) to `4.0.0` in the `main` branch.

### Automated Release

The [release-drafter workflow](.github/workflows/release-drafter.yml) will be automatically kicked off and is responsible for drafting a new release on GitHub containing release artifacts. Before creating a draft release, this workflow creates a GitHub issue asking for approval from the [maintainers](MAINTAINERS.md). See sample [issue](https://github.com/gaiksaya/opensearch-java/issues/1). The maintainers need to approve in order to continue the workflow run. Once a release is drafted [opensearch-java-maven-sign-and-release](https://build.ci.opensearch.org/job/opensearch-java-maven-sign-and-release/) Jenkins workflow is triggered. The artifacts will be automatically signed and published to maven.

### CHANGELOG Entries

The unreleased section in [CHANGELOG](CHANGELOG.md) should look like so.

```markdown
## [Unreleased 2.x]
### Added
### Dependencies
### Changed
### Deprecated
### Removed
### Fixed
### Security
```
