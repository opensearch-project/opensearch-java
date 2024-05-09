# CHANGELOG
Inspired from [Keep a Changelog](https://keepachangelog.com/en/1.0.0/)

## [Unreleased 2.x]
### Added

### Dependencies
- Bumps `io.github.classgraph:classgraph` from 4.8.170 to 4.8.172

### Changed

### Deprecated

### Removed

### Fixed

### Security

## [2.10.2]
### Added

### Dependencies

### Changed

### Deprecated

### Removed

### Fixed
- Fix integer overflow for variables in indices stats response ([#960](https://github.com/opensearch-project/opensearch-java/pull/960))
- Fix composite aggregations for search requests ([#967](https://github.com/opensearch-project/opensearch-java/pull/967))

## [2.10.1] - 04/16/2024
### Added
- Add missed fields to PhraseSuggestOption: collapseMatch ([#940](https://github.com/opensearch-project/opensearch-java/pull/940))
- Add missed fields to bulk's UpdateOperation: source ([#947](https://github.com/opensearch-project/opensearch-java/pull/947))

### Dependencies
- Bumps `com.github.jk1.dependency-license-report` from 2.6 to 2.7

### Changed

### Deprecated

### Removed

### Fixed

### Security


## [2.10.0] - 04/11/2024
### Added
- Add xy_shape property ([#884](https://github.com/opensearch-project/opensearch-java/pull/885))
- Add missed fields to MultisearchBody: seqNoPrimaryTerm, storedFields, explain, fields, indicesBoost ([#914](https://github.com/opensearch-project/opensearch-java/pull/914))
- Add OpenSearchGenericClient with support for raw HTTP request/responses ([#910](https://github.com/opensearch-project/opensearch-java/pull/910), [#929](https://github.com/opensearch-project/opensearch-java/pull/929))
- Add missed fields to MultisearchBody: collapse, version, timeout ([#916](https://github.com/opensearch-project/opensearch-java/pull/916)
- Add missed fields to MultisearchBody: ext, rescore and to SearchRequest: ext ([#918](https://github.com/opensearch-project/opensearch-java/pull/918)

### Dependencies
- Bumps `io.github.classgraph:classgraph` from 4.8.161 to 4.8.165
- Bumps `org.owasp.dependencycheck` from 9.0.8 to 9.1.0
- Bumps `org.apache.httpcomponents.client5:httpclient5` from 5.3.0 to 5.3.1
- Bumps `io.github.classgraph:classgraph` from 4.8.165 to 4.8.170
- Bumps `jackson` from 2.15.2 to 2.17.0
- Bumps `org.eclipse.parsson:parsson` from 1.1.5 to 1.1.6

### Changed

### Deprecated

### Removed
- Delete shape property ([#884](https://github.com/opensearch-project/opensearch-java/pull/885))

### Fixed
- Fix integer overflow for variables in indices stats response ([#877](https://github.com/opensearch-project/opensearch-java/pull/877))
- Support weight function in function score query ([#880](https://github.com/opensearch-project/opensearch-java/pull/880))
- Fix pattern replace by making flag and replacement optional as on api  ([#895](https://github.com/opensearch-project/opensearch-java/pull/895))
- Client with Java 8 runtime and Apache HttpClient 5 Transport fails with java.lang.NoSuchMethodError: java.nio.ByteBuffer.flip()Ljava/nio/ByteBuffer ([#920](https://github.com/opensearch-project/opensearch-java/pull/920)) 
- Add missed field  "filter" to NeuralQuery model class

### Security

## [2.9.0] - 02/22/2024
### Added
- Add support for Hybrid query type ([#850](https://github.com/opensearch-project/opensearch-java/pull/850))

### Dependencies
- Bumps `org.ajoberstar.grgit:grgit-gradle` from 5.2.0 to 5.2.2

### Changed
- Restore support for Java 8 ([#767](https://github.com/opensearch-project/opensearch-java/pull/767))
- Add an integration test that runs on JDK-8 ([#795](https://github.com/opensearch-project/opensearch-java/pull/795))

### Deprecated

### Removed

### Fixed
- Fix missing properties on UpdateOperation ([#744](https://github.com/opensearch-project/opensearch-java/pull/744))

### Security

## [2.8.4] - 02/20/2024
### Added
- Add search role type for nodes in cluster stats ([#848](https://github.com/opensearch-project/opensearch-java/pull/848))

### Dependencies

### Changed

### Deprecated

### Removed

### Fixed
- Fix ClusterStatsResponse field deserialization ([#848](https://github.com/opensearch-project/opensearch-java/pull/848))

## [2.8.3] - 02/12/2024
### Added

### Dependencies

### Changed

### Deprecated

### Removed

### Fixed
- Fix PutTemplateRequest field deserialization ([#723](https://github.com/opensearch-project/opensearch-java/pull/723))
- Fix InnerHits to no longer enforce the nullable Index field when converting to Hit. ([#838](https://github.com/opensearch-project/opensearch-java/pull/838))

## [2.8.2] - 02/07/2024
### Added
- Added support for icu_collation_keyword type ([#725](https://github.com/opensearch-project/opensearch-java/pull/725))
- Added support for flat_object field property ([#735](https://github.com/opensearch-project/opensearch-java/pull/735))
- Expose HTTP status code through `ResponseException#status` ([#756](https://github.com/opensearch-project/opensearch-java/pull/756))
- Added toBuilder method to all request model in core package & _types.query_dsl package ([#766](https://github.com/opensearch-project/opensearch-java/pull/766))
- Added toQuery method in Query and QueryVariant ([#760](https://github.com/opensearch-project/opensearch-java/pull/760)
- Added missing WrapperQuery accessors and builder methods ([#806](https://github.com/opensearch-project/opensearch-java/pull/806))

### Dependencies
- Bumps `com.diffplug.spotless` from 6.22.0 to 6.25.0
- Bumps `org.apache.httpcomponents.client5:httpclient5` from 5.2.1 to 5.3
- Bumps `org.owasp.dependencycheck` from 8.4.2 to 9.0.8

### Changed

### Deprecated
- Deprecated "_toQuery()" in Query and QueryVariant ([#760](https://github.com/opensearch-project/opensearch-java/pull/760))

### Removed
- Removed unsupported `prefix` field from CompletionSuggester ([#812](https://github.com/opensearch-project/opensearch-java/pull/812))

### Fixed
- Fix partial success results for msearch_template ([#709](https://github.com/opensearch-project/opensearch-java/pull/709))
- Fix deserialization of node stats response ([#745](https://github.com/opensearch-project/opensearch-java/pull/745))
- Fix PutIndexTemplateRequest field deserialization ([#765](https://github.com/opensearch-project/opensearch-java/pull/765))
- Fix InnerHits to no longer enforce the nullable Index field when converting to Hit. ([#825](https://github.com/opensearch-project/opensearch-java/issues/825))

### Security

## [2.8.1]
### Added

### Dependencies

### Changed

### Deprecated

### Removed

### Fixed
- Fix partial success results for msearch_template ([#709](https://github.com/opensearch-project/opensearch-java/pull/709))

### Security

## [2.8.0] - 01/11/2023
### Added
- Added support for indexing and search index settings ([#667](https://github.com/opensearch-project/opensearch-java/pull/667))
- Added support for neural query type ([#674](https://github.com/opensearch-project/opensearch-java/pull/674))

### Dependencies
  
### Changed
- Allow null values in arrays ([#687](https://github.com/opensearch-project/opensearch-java/pull/687))
- Add an example for bulk update operation in samples ([#690](https://github.com/opensearch-project/opensearch-java/pull/690))

### Deprecated

### Removed

### Fixed
- Fixed Hit response when search request has storedFields as null ([#698](https://github.com/opensearch-project/opensearch-java/pull/698))
- Fix InnerHits storedFields deserialization/serialization ([#781](https://github.com/opensearch-project/opensearch-java/pull/781)

### Security

## [2.7.0] - 10/13/2023
### Added
- Added support for "smartcn" analyzer ([#605](https://github.com/opensearch-project/opensearch-java/pull/605))
- Added support for "cjk" analyzer ([#604](https://github.com/opensearch-project/opensearch-java/pull/604))
- Added support for wrapper queries ([#630](https://github.com/opensearch-project/opensearch-java/pull/630))
- Added support for "script_fields" in multi search request ([#632](https://github.com/opensearch-project/opensearch-java/pull/632))
- Added size attribute to MultiTermsAggregation ([#627](https://github.com/opensearch-project/opensearch-java/pull/627))
- Added version increment workflow that executes after release ([#664](https://github.com/opensearch-project/opensearch-java/pull/664))

### Dependencies
- Bumps `org.ajoberstar.grgit:grgit-gradle` from 5.0.0 to 5.2.0
- Bumps `com.github.jk1.dependency-license-report` from 2.4 to 2.5
- Bumps `io.github.classgraph:classgraph` from 4.8.160 to 4.8.161
  
### Changed
- Moved "software.amazon.awssdk" dependencies to the compileOnly scope. ([#628](https://github.com/opensearch-project/opensearch-java/pull/628))
- Migrated from checkstyle to spotless ([#648](https://github.com/opensearch-project/opensearch-java/pull/648))

### Deprecated

### Removed
- Remove generated code comments from all files ([#598](https://github.com/opensearch-project/opensearch-java/pull/598))

### Fixed
- Fix PutMappingRequest by removing unsupported fields ([#597](https://github.com/opensearch-project/opensearch-java/pull/597))
- [BUG] JarHell caused by latest software.amazon.awssdk 2.20.141 ([#616](https://github.com/opensearch-project/opensearch-java/pull/616))
- Don't over-allocate in HeapBufferedAsyncEntityConsumer in order to consume the response ([#620](https://github.com/opensearch-project/opensearch-java/pull/620))
- Fixed CVE-2976 + added CVE checker ([#624](https://github.com/opensearch-project/opensearch-java/pull/624))
- Fix parsing of GetFieldMappingResponse ([#641](https://github.com/opensearch-project/opensearch-java/pull/641))
- Fix TermvectorsResponse for optional fields ([#642](https://github.com/opensearch-project/opensearch-java/pull/642))
- Fix deserialization of MsearchTemplateResponse ([#660](https://github.com/opensearch-project/opensearch-java/pull/660))

### Security

## [2.6.0] - 07/05/2023
### Added
- Add support for knn_vector field type ([#524](https://github.com/opensearch-project/opensearch-java/pull/524))
- Add translog option object and missing translog sync interval option in index settings ([#518](https://github.com/opensearch-project/opensearch-java/pull/518))
- Adds the option to set slices=auto for UpdateByQueryRequest, DeleteByQueryRequest and ReindexRequest ([#538](https://github.com/opensearch-project/opensearch-java/pull/538))
- Add support for approximate k-NN queries ([#548](https://github.com/opensearch-project/opensearch-java/pull/548))

### Dependencies
- Bumps `com.github.jk1.dependency-license-report` from 2.2 to 2.4
- Bumps `io.github.classgraph:classgraph` from 4.8.157 to 4.8.160
- Bumps `jackson` from 2.14.2 to 2.15.2 ((#537)[https://github.com/opensearch-project/opensearch-java/pull/537])
- Update `org.apache.httpcomponents.client5:httpclient5` from `5.1.4` to `5.2.1` and `org.apache.httpcomponents.core5:httpcore5` from `5.1.5` to `5.2.2`

### Changed

### Deprecated
- Deprecate translogDurability and translogFlushThresholdSize in IndexSettings in favor of a separate translog object ([#518](https://github.com/opensearch-project/opensearch-java/pull/518))

### Removed

### Fixed
- Fixed Suggesters for Completion, Term, and Phrase and refactored the Suggestion class ([#477](https://github.com/opensearch-project/opensearch-java/pull/477))
- Fix highlight max_analyzer_offset field name to match with the one introduced in OpenSearch 2.2.0 ([#555](https://github.com/opensearch-project/opensearch-java/pull/555))

### Security

## [2.5.0] - 06/02/2023
### Added
- Add workflow to publish snapshots via GHA ([#454](https://github.com/opensearch-project/opensearch-java/pull/454))
- Added Point-In-Time APIs ([#461](https://github.com/opensearch-project/opensearch-java/pull/461))

### Dependencies
- Bumps `com.github.jk1.dependency-license-report` from 1.19 to 2.2
- Bumps `org.eclipse.parsson:parsson` from 1.1.2 to 1.1.4

### Changed
- Improve time taken by Github actions by using cache ([#439](https://github.com/opensearch-project/opensearch-java/pull/439))
- Introduce intermediary SearchResult for SearchResponse and SearchTemplateResponse classes, enabling similar response handling for both ([#462](https://github.com/opensearch-project/opensearch-java/pull/462))

### Deprecated

### Removed

### Fixed
- Fix missing Highlight and SourceConfig in the MultisearchBody ([#442](https://github.com/opensearch-project/opensearch-java/pull/442))
- Fix search failure with missing required property HitsMetadata.total when trackTotalHits is disabled ([#372](https://github.com/opensearch-project/opensearch-java/pull/372))
- Fix failure when deserialing response for tasks API ([#463](https://github.com/opensearch-project/opensearch-java/pull/463))
- Fix failure when deserializing boolean types for enums ([#463](https://github.com/opensearch-project/opensearch-java/pull/482))
- Fix missing minScore, postFilter, searchAfter, sort, trackScores in the MultisearchBody ([#516](https://github.com/opensearch-project/opensearch-java/pull/516))
### Security

## [2.4.0] - 04/11/2023

### Added
- Add buffered lookahead for Jackson ([#338](https://github.com/opensearch-project/opensearch-java/pull/338))
- Add support for headers and sort parameters in cat requests ([#413](https://github.com/opensearch-project/opensearch-java/pull/413))
- Add support for data stream operations ([#419](https://github.com/opensearch-project/opensearch-java/pull/419))

### Dependencies
- Bumps `io.github.classgraph:classgraph` from 4.8.156 to 4.8.157 ([#408](https://github.com/opensearch-project/opensearch-java/pull/408))

### Changed

### Deprecated

### Removed

### Fixed

### Security

## [2.3.0] - 03/15/2023

### Added
- Require two maintainers to approve release ([#383](https://github.com/opensearch-project/opensearch-java/pull/383))
- Add support for mapping limit settings ([#382](https://github.com/opensearch-project/opensearch-java/pull/382))

### Dependencies
- Bumps `Jackson` from 2.14.1 to 2.14.2 ([#357](https://github.com/opensearch-project/opensearch-java/pull/357))
- Bumps `classgraph` from 4.8.149 to 4.8.156 ([#395](https://github.com/opensearch-project/opensearch-java/pull/395))

### Changed
- Prevent SPI calls at runtime ([#293](https://github.com/opensearch-project/opensearch-java/pull/293))

### Deprecated

### Removed

### Fixed
- Fix issue where completion suggestions were failing, due to being parsed as term suggestions ([#350](https://github.com/opensearch-project/opensearch-java/pull/350))
- Bulk UpdateOperation misses upsert options ([#353](https://github.com/opensearch-project/opensearch-java/pull/353))
- Fix missing key property in the RangeBucket ([#381](https://github.com/opensearch-project/opensearch-java/pull/381))

### Security

## [2.2.0] - 01/23/2023

### Added
- Add Github workflow for changelog verification ([#239](https://github.com/opensearch-project/opensearch-java/pull/239))
- Add Github workflow for dependabot PRs ([#247](https://github.com/opensearch-project/opensearch-java/pull/247))
- Add support for signing service name in AwsSdk2Transport ([#324](https://github.com/opensearch-project/opensearch-java/pull/324))
- Add new OpenSearchTransport based on Apache HttpClient 5 ([#328](https://github.com/opensearch-project/opensearch-java/pull/328))
- Add 1-click release workflows ([#321](https://github.com/opensearch-project/opensearch-java/pull/321))
- Add support for OpenSearch Serverless ([#339](https://github.com/opensearch-project/opensearch-java/pull/339))
- Add support to parse sub-aggregations from filter/nested aggregations ([#234](https://github.com/opensearch-project/opensearch-java/pull/234))
  
### Dependencies
- Bumps `grgit-gradle` from 4.0.1 to 5.0.0
- Update Jackson to 2.14.0 ([#259](https://github.com/opensearch-project/opensearch-java/pull/259))
- Update Gradle to 7.6 ([#311](https://github.com/opensearch-project/opensearch-java/pull/311))

### Changed
- Update literature around changelog contributions in CONTRIBUTING.md ([#242](https://github.com/opensearch-project/opensearch-java/pull/242))
- Update tests to use JUnit's Assert ([#244](https://github.com/opensearch-project/opensearch-java/pull/244))
- Add timeout and throttle to the jenkins workflows ([#231](https://github.com/opensearch-project/opensearch-java/pull/231)) 
- Update maintainers, admins and documentation ([#248](https://github.com/opensearch-project/opensearch-java/pull/248))

### Deprecated
- Deprecate the totalDataSetSize and totalDataSetSizeInBytes fields in the StoreStats ([#498](https://github.com/opensearch-project/opensearch-java/pull/498))


### Removed
- Remove support for unsupported dynamic_templates in bulk ([#276](https://github.com/opensearch-project/opensearch-java/pull/276))

### Fixed
- Make ChildrenAggregate as a SingleBucketAggregate ([#306](https://github.com/opensearch-project/opensearch-java/pull/306))
- Fix /_nodes/stats, /_nodes/info throwing serialization error ([#315](https://github.com/opensearch-project/opensearch-java/pull/315))
- Do not double-wrap OpenSearchException on error ([#323](https://github.com/opensearch-project/opensearch-java/pull/323))
- Fix AwsSdk2TransportOptions.responseCompression ([#322](https://github.com/opensearch-project/opensearch-java/pull/322))
- Fix missing Highlight and SourceConfig in the MultisearchBody ([#442](https://github.com/opensearch-project/opensearch-java/pull/442))
- Fix parsing /_alias error response for not existing alias ([#476](https://github.com/opensearch-project/opensearch-java/pull/476))
- Fix missing cause message in missing permission to call Fine Grained Access Control Amazon OpenSearch domain ([#473](https://github.com/opensearch-project/opensearch-java/issues/473))
- Fix catching JsonParsingException ([#494](https://github.com/opensearch-project/opensearch-java/issues/494))
- Fix StoryStats numeric value out of range of int ([#489](https://github.com/opensearch-project/opensearch-java/pull/489))
 
### Security

[Unreleased 2.x]: https://github.com/opensearch-project/opensearch-java/compare/v2.10.1...2.x
[2.10.1]: https://github.com/opensearch-project/opensearch-java/compare/v2.10.0...v2.10.1
[2.10.0]: https://github.com/opensearch-project/opensearch-java/compare/v2.9.1...v2.10.0
[2.9.1]: https://github.com/opensearch-project/opensearch-java/compare/v2.9.0...v2.9.1
[2.9.0]: https://github.com/opensearch-project/opensearch-java/compare/v2.8.4...v2.9.0
[2.8.4]: https://github.com/opensearch-project/opensearch-java/compare/v2.8.3...v2.8.4
[2.8.3]: https://github.com/opensearch-project/opensearch-java/compare/v2.8.2...v2.8.3
[2.8.2]: https://github.com/opensearch-project/opensearch-java/compare/v2.8.1...v2.8.2
[2.8.1]: https://github.com/opensearch-project/opensearch-java/compare/v2.8.0...v2.8.1
[2.8.0]: https://github.com/opensearch-project/opensearch-java/compare/v2.7.0...v2.8.0
[2.7.0]: https://github.com/opensearch-project/opensearch-java/compare/v2.6.0...v2.7.0
[2.6.0]: https://github.com/opensearch-project/opensearch-java/compare/v2.5.0...v2.6.0
[2.5.0]: https://github.com/opensearch-project/opensearch-java/compare/v2.4.0...v2.5.0
[2.4.0]: https://github.com/opensearch-project/opensearch-java/compare/v2.3.0...v2.4.0
[2.3.0]: https://github.com/opensearch-project/opensearch-java/compare/v2.2.0...v2.3.0
[2.2.0]: https://github.com/opensearch-project/opensearch-java/compare/v2.1.0...v2.2.0
