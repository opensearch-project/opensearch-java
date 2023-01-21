# CHANGELOG
Inspired from [Keep a Changelog](https://keepachangelog.com/en/1.0.0/)

## [Unreleased]

### Added
- Add GitHub workflow for changelog verification ([#239](https://github.com/opensearch-project/opensearch-java/pull/239))
- Add GitHub workflow for dependabot PRs ([#247](https://github.com/opensearch-project/opensearch-java/pull/247))
- Add javadoc link for the client ([#255](https://github.com/opensearch-project/opensearch-java/pull/255))
- Add support for signing service name in AwsSdk2Transport ([#324](https://github.com/opensearch-project/opensearch-java/pull/324))
- Add 1-click release workflows ([#321](https://github.com/opensearch-project/opensearch-java/pull/321))
- Add new `OpenSearchTransport` based on Apache HttpClient 5 ([#281](https://github.com/opensearch-project/opensearch-java/pull/281))
- Add workflow to publish snapshots via GHA ([#325](https://github.com/opensearch-project/opensearch-java/pull/325))
- Document HTTP/2 support ([#330](https://github.com/opensearch-project/opensearch-java/pull/330))

### Dependencies
- Bumps `classgraph` from 4.8.149 to 4.8.154

### Dependencies
- Bumps `grgit-gradle` from 4.0.1 to 5.0.0
- Update Jackson to 2.14.0 ([#258](https://github.com/opensearch-project/opensearch-java/pull/258))
- Update Jackson to 2.14.1 ([#279](https://github.com/opensearch-project/opensearch-java/pull/279))

### Changed
- Update literature around changelog contributions in CONTRIBUTING.md ([#242](https://github.com/opensearch-project/opensearch-java/pull/242))
- Update tests to use JUnit's Assert ([#244](https://github.com/opensearch-project/opensearch-java/pull/244))
- Add support to parse sub-aggregations from filter/nested aggregations ([#234](https://github.com/opensearch-project/opensearch-java/pull/234))
- Add timeout and throttle to the jenkins workflows ([#231](https://github.com/opensearch-project/opensearch-java/pull/231)) 
- Update maintainers, admins and documentation ([#248](https://github.com/opensearch-project/opensearch-java/pull/248))
- Migrate client transports to Apache HttpClient / Core 5.x ([#246](https://github.com/opensearch-project/opensearch-java/pull/246))
- Document how to use Java 8 Time (JSR 310) objects ([#251](https://github.com/opensearch-project/opensearch-java/pull/251))
- Fix version and build ([#254](https://github.com/opensearch-project/opensearch-java/pull/254))
- Update Gradle to 7.6 ([#309](https://github.com/opensearch-project/opensearch-java/pull/309))
- Prevent SPI calls at runtime ([#293](https://github.com/opensearch-project/opensearch-java/pull/293))
- Add x-amz-content-sha256 header for signed requests ([#]())

### Deprecated

### Removed
- Remove support for unsupported dynamic_templates in bulk ([#276](https://github.com/opensearch-project/opensearch-java/pull/276))

### Fixed
- Make ChildrenAggregate as a SingleBucketAggregate ([#306](https://github.com/opensearch-project/opensearch-java/pull/306))
- Fix /_nodes/stats, /_nodes/info throwing serialization error ([#315](https://github.com/opensearch-project/opensearch-java/pull/315))
- Do not double-wrap OpenSearchException on error ([#323](https://github.com/opensearch-project/opensearch-java/pull/323))
- Fix AwsSdk2TransportOptions.responseCompression ([#322](https://github.com/opensearch-project/opensearch-java/pull/322))

### Security

[Unreleased]: https://github.com/opensearch-project/opensearch-java/compare/2.0...HEAD