- [Overview](#overview)
- [Branching](#branching)
  - [Release Branching](#release-branching)
  - [Feature Branches](#feature-branches)
- [Release Labels](#release-labels)
- [Releasing](#releasing)
  - [Releasing New Versions](#releasing-new-versions)
    - [Releasing a Patch (v3.2.1)](#releasing-a-patch-v321)
    - [Releasing a new Minor Version (v3.3.0)](#releasing-a-new-minor-version-v330)
    - [Releasing a new Major Version (v4.0.0)](#releasing-a-new-major-version-v400)
  - [Automated Release](#automated-release)
  - [CHANGELOG Entries](#changelog-entries)

## Overview

This document explains the release strategy for artifacts in this organization.

## Branching

### Release Branching

Given the next major release of 4.0, current major release of 3.x, and latest minor release of 3.2, this project maintains the following active branches.

* **main**: The next _major_ release, e.g. `4.0.0`. This is the branch where all merges take place and code moves fast.
* **3.x**: The next _minor_ release, e.g. `3.3.0`. Once a change is merged into `main`, decide whether to backport it to `3.x`.
* **3.2**: The _next_ patch release, e.g. `3.2.1`. In between minor releases, only hotfixes (e.g. security) are backported to `3.2`.

PRs go into `main`. Label PRs that you need to be backported as `backport 3.x`. Backport PRs by checking out the versioned branch, cherry-pick changes and open a PR against each target backport branch.

### Feature Branches

Do not create branches in the upstream repo, use your fork, except for long-lasting feature branches that require active collaboration from multiple developers. Name feature branches `feature/<thing>`. Once the work is merged to `main`, please make sure to delete the feature branch.

## Release Labels

Repositories create consistent release labels, such as `v1.0.0`, `v1.1.0` and `v2.0.0`, as well as `patch` and `backport`. Use release labels to target an issue or a PR for a given release. See [MAINTAINERS](MAINTAINERS.md#triage-open-issues) for more information on triaging issues.

## Releasing

The release process is standard across repositories in this org and is run by a release manager volunteering from amongst [MAINTAINERS](MAINTAINERS.md).

Assuming the following current state.

1. `3.2`: next patch, i.e. `3.2.1-SNAPSHOT`
2. `3.x`: next minor, i.e. `3.3.0-SNAPSHOT`
3. `main`: next major, i.e. `4.0.0-SNAPSHOT`

#### Releasing a Patch (v3.2.1)

1. If the `3.2` branch does not exist, create it at the commit tagged `v3.2.0` and push it to the upstream repo. The [bump version workflow](.github/workflows/bump-version.yml) will make a pull request to set `systemProp.version` in [gradle.properties](gradle.properties) to `3.2.1` in the `3.2` branch.
2. Check out the `3.2` branch, and create a new branch in your fork from it (i.e. `release/3.2.1`).
3. Ensure `systemProp.version` in [gradle.properties](gradle.properties) matches the version being released, i.e. `3.2.1`.
4. Replace `## [Unreleased x.y]` with `## [3.2.1] - 07/20/2025` in [CHANGELOG](CHANGELOG.md).
5. Commit changes to `gradle.properties` and [CHANGELOG](CHANGELOG.md).
6. Pull-request the changes from your fork into the `3.2` branch.
7. Create a tag, `v3.2.1`, on the `3.2` branch and push it to the upstream repo. An automated release will be made.
8. The [bump version workflow](.github/workflows/bump-version.yml) will make a pull request to set `systemProp.version` in [gradle.properties](gradle.properties) to `3.2.2` in the `3.2` branch.

#### Releasing a new Minor Version (v3.3.0)

1. Check out the `3.x` branch, and create a new branch in your fork from it (i.e. `release/3.3.0`).
2. Ensure `systemProp.version` in [gradle.properties](gradle.properties) matches the version being released, i.e. `3.3.0`.
3. Replace `## [Unreleased x.y]` with `## [3.3.0] - 07/20/2025` in [CHANGELOG](CHANGELOG.md).
4. Commit changes to `gradle.properties` and [CHANGELOG](CHANGELOG.md).
5. Pull-request the changes from your fork into the `3.x` branch.
6. Create a tag, `v3.3.0`, on the `3.x` branch and push it to the upstream repo. An automated release will be made.
7. The [bump version workflow](.github/workflows/bump-version.yml) will make a pull request to set `systemProp.version` in [gradle.properties](gradle.properties) to `3.4.0` in the `3.x` branch.

#### Releasing a new Major Version (v4.0.0)

1. Check out the `main` branch, and create a new branch in your fork from it (i.e. `release/4.0.0`).
2. Ensure `systemProp.version` in [gradle.properties](gradle.properties) matches the version being released, i.e. `4.0.0`.
3. Replace `## [Unreleased x.y]` with `## [4.0.0] - 07/20/2025` in [CHANGELOG](CHANGELOG.md).
4. Commit changes to `gradle.properties` and [CHANGELOG](CHANGELOG.md).
5. Pull-request the changes from your fork into the `main` branch.
6. Create a tag, `v4.0.0`, on the `main` branch and push it to the upstream repo. An automated release will be made.
7. The [bump version workflow](.github/workflows/bump-version.yml) will automatically:
   1. Make a pull request to set `systemProp.version` in [gradle.properties](gradle.properties) to `5.0.0` in the `main` branch.
   2. Create a `4.x` branch.
   3. Make a pull request to set `systemProp.version` in [gradle.properties](gradle.properties) to `4.1.0` in the `4.x` branch.

### Automated Release

The [release-drafter workflow](.github/workflows/release-drafter.yml) will be automatically kicked off and is responsible for drafting a new release on GitHub containing release artifacts. Before creating a draft release, this workflow creates a GitHub issue asking for approval from the [maintainers](MAINTAINERS.md). See sample [issue](https://github.com/gaiksaya/opensearch-java/issues/1). The maintainers need to approve in order to continue the workflow run. Once a release is drafted [opensearch-java-maven-sign-and-release](https://build.ci.opensearch.org/job/opensearch-java-maven-sign-and-release/) Jenkins workflow is triggered. The artifacts will be automatically signed and published to maven.

### CHANGELOG Entries

The unreleased section in [CHANGELOG](CHANGELOG.md) should look like so.

```markdown
## [Unreleased 3.x]
### Added
### Dependencies
### Changed
### Deprecated
### Removed
### Fixed
### Security
```
