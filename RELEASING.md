- [Overview](#overview)
- [Branching](#branching)
  - [Release Branching](#release-branching)
  - [Feature Branches](#feature-branches)
- [Release Labels](#release-labels)
- [Releasing](#releasing)
  - [Preparing for Release](#preparing-for-release)
  - [Release](#release)
  - [Preparing for Next Developer Iteration](#preparing-for-next-developer-iteration)

## Overview

This document explains the release strategy for artifacts in this organization.

## Branching

### Release Branching

Given the current major release of 2.0, projects in this organization maintain the following active branches.

* **main**: The next _major_ release 3.0. This is the branch where all merges take place and code moves fast.
* **2.x**: The next _minor_ release. Once a change is merged into `main`, decide whether to backport it to `2.x`.
* **2.0**: The _current_ release. In between minor releases, only hotfixes (e.g. security) are backported to `2.0`.

Label PRs with the next major version label (e.g. `2.0.0`) and merge changes into `main`. Label PRs that you believe need to be backported as `2.x` and `2.0`. Backport PRs by checking out the versioned branch, cherry-pick changes and open a PR against each target backport branch.

### Feature Branches

Do not create branches in the upstream repo, use your fork, for the exception of long lasting feature branches that require active collaboration from multiple developers. Name feature branches `feature/<thing>`. Once the work is merged to `main`, please make sure to delete the feature branch.

## Release Labels

Repositories create consistent release labels, such as `v1.0.0`, `v1.1.0` and `v2.0.0`, as well as `patch` and `backport`. Use release labels to target an issue or a PR for a given release. See [MAINTAINERS](MAINTAINERS.md#triage-open-issues) for more information on triaging issues.

## Releasing

The release process is standard across repositories in this org and is run by a release manager volunteering from amongst [MAINTAINERS](MAINTAINERS.md).

### Preparing for Release

1. Check out the branch being released, e.g. `2.x`. 
2. Create a new branch that matches the version number being released, e.g. `2.10.5`.
3. Ensure `systemProp.version` in [gradle.properties](gradle.properties) matches the version being released.
4. Replace `## [Unreleased x.y]` with a version number and date, e.g. `## [2.11.0] - 06/20/2024` in [CHANGELOG](CHANGELOG.md).
5. Commit your changes, create a tag, e.g. `v2.1.0`, and push your changes and the new tag to GitHub.

### Release

The [release-drafter workflow](.github/workflows/release-drafter.yml) will be automatically kicked off and is responsible for drafting a new release on GitHub containing release artifacts. Before creating a draft release, this workflow creates a GitHub issue asking for approval from the [maintainers](MAINTAINERS.md). See sample [issue](https://github.com/gaiksaya/opensearch-java/issues/1). The maintainers need to approve in order to continue the workflow run.

Once a release is drafted [opensearch-java-maven-sign-and-release](https://build.ci.opensearch.org/job/opensearch-java-maven-sign-and-release/) Jenkins workflow is triggered. The artifacts will be automatically signed and published to maven.

### Preparing for Next Developer Iteration

An [increment version workflow](.github/workflows/increment-version.yml) will make a pull request to set `systemProp.version` in [gradle.properties](gradle.properties) to the next version.

Add an unreleased section to [CHANGELOG](CHANGELOG.md) in `main` and backport the change to `2.x`.

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
