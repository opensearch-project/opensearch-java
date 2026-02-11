# CHANGELOG
Inspired from [Keep a Changelog](https://keepachangelog.com/en/1.0.0/)

## [Unreleased 3.x]
### Added

### Dependencies

### Changed

### Deprecated

### Removed

### Fixed

### Security

## [Unreleased 2.x]
### Added

### Dependencies

### Changed

### Deprecated

### Removed

### Fixed

### Security

## [3.6.0] - 02/11/2026
### Added

### Dependencies
- Bump `de.undercouch.download` from 5.6.0 to 5.7.0 ([#1867](https://github.com/opensearch-project/opensearch-java/pull/1867))
- Bump `org.owasp.dependencycheck` from 12.1.2 to 12.2.0 ([#1735](https://github.com/opensearch-project/opensearch-java/pull/1735), [#1742](https://github.com/opensearch-project/opensearch-java/pull/1742), [#1754](https://github.com/opensearch-project/opensearch-java/pull/1754), [#1765](https://github.com/opensearch-project/opensearch-java/pull/1765), [#1796](https://github.com/opensearch-project/opensearch-java/pull/1796), [#1854](https://github.com/opensearch-project/opensearch-java/pull/1854))
- Bump `gradle-wrapper` from 9.3.0 to 9.3.1 ([#1864](https://github.com/opensearch-project/opensearch-java/pull/1864))
- Bump `gradle-wrapper` from 9.2.0 to 9.3.0 ([#1862](https://github.com/opensearch-project/opensearch-java/pull/1862))
- Bump `org.apache.httpcomponents.client5:httpclient5` from 5.5 to 5.6 [#1844](https://github.com/opensearch-project/opensearch-java/pull/1844)

### Changed

### Deprecated

### Removed

### Fixed

### Security

## [3.5.0] - 01/15/2026
### Added
- Fix formatting of the main method to run for various samples ([#1749](https://github.com/opensearch-project/opensearch-java/pull/1749))
- Fix NPE when null ObjectBuilder is accessed ([#1717](https://github.com/opensearch-project/opensearch-java/issues/1717))
- Added BulkIngester helper for efficient bulk operations with buffering, retries, and backpressure. Ported from elasticsearch-java (commit e7120d4) ([#1809](https://github.com/opensearch-project/opensearch-java/pull/1809))
- Added equals and hashCode implementation to JsonDataImpl ([#1803](https://github.com/opensearch-project/opensearch-java/pull/1838))

### Dependencies
- Bump `com.github.jk1.dependency-license-report` from 2.9 to 3.0.1 ([#1779](https://github.com/opensearch-project/opensearch-java/pull/1779), [#1781](https://github.com/opensearch-project/opensearch-java/pull/1781))

### Changed

### Deprecated

### Removed

### Fixed

### Security

## [3.4.0] - 12/15/2025
### Added

### Dependencies

### Changed

### Deprecated

### Removed

### Fixed
- Fixed an issue where `AwsSdk2Transport` would create a default `JacksonJsonpMapper` on every instantiation even if a mapper was already provided, which could cause issues with Jackson module resolution ([#1788](https://github.com/opensearch-project/opensearch-java/pull/1788))
- Fixed the regression introduced in the OpenSearch OpenAPI spec ([#1794](https://github.com/opensearch-project/opensearch-java/pull/1794))

### Security

## [3.3.0] - 10/29/2025
### Added
- Added decommission awareness & weighted routing operations ([#1632](https://github.com/opensearch-project/opensearch-java/pull/1632))
- Added support for the `ltr` namespace ([#1689](https://github.com/opensearch-project/opensearch-java/pull/1689))
- Added support for the `geospatial` namespace ([#1690](https://github.com/opensearch-project/opensearch-java/pull/1690))
- Added support for the `knn` namespace ([#1693](https://github.com/opensearch-project/opensearch-java/pull/1693))
- Added getter for retrieve all nodes along with their state ([#1698](https://github.com/opensearch-project/opensearch-java/pull/1698))
- Added support for the `search_relevance` namespace ([#1748](https://github.com/opensearch-project/opensearch-java/pull/1748))

### Dependencies
- Bump `io.github.classgraph:classgraph` from 4.8.180 to 4.8.181 ([#1703](https://github.com/opensearch-project/opensearch-java/pull/1703))
- Bump `org.junit:junit-bom` from 5.13.3 to 5.13.4 ([#1704](https://github.com/opensearch-project/opensearch-java/pull/1704))

## [3.2.0] - 07/10/2025
### Added
- Added support for Index Management plugin APIs ([#1604](https://github.com/opensearch-project/opensearch-java/pull/1604))
- Added support for the security plugin APIs ([#1601](https://github.com/opensearch-project/opensearch-java/pull/1601))
- Added Jackson `ObjectMapper` module auto-detection ([#1643](https://github.com/opensearch-project/opensearch-java/pull/1643))
- Added support for the `ingestion` namespace ([#1663](https://github.com/opensearch-project/opensearch-java/pull/1663))

### Dependencies
- Bump `org.owasp.dependencycheck` from 12.1.1 to 12.1.3 ([#1608](https://github.com/opensearch-project/opensearch-java/pull/1608), [#1607](https://github.com/opensearch-project/opensearch-java/pull/1607), [#1623](https://github.com/opensearch-project/opensearch-java/pull/1623))
- Bump `org.junit:junit-bom` from 5.13.0 to 5.13.2 ([#1606](https://github.com/opensearch-project/opensearch-java/pull/1606), [#1650](https://github.com/opensearch-project/opensearch-java/pull/1650), [#1665](https://github.com/opensearch-project/opensearch-java/pull/1665))
- Bump `org.ajoberstar.grgit:grgit-gradle` from 5.3.0 to 5.3.2 ([#1621](https://github.com/opensearch-project/opensearch-java/pull/1621))
- Bump `io.github.classgraph:classgraph` from 4.8.179 to 4.8.180 ([#1651](https://github.com/opensearch-project/opensearch-java/pull/1651))

### Changed
- Changed the type of the properties in DocStatus from integer to Long to resolve the integer overflow issue ([#1644](https://github.com/opensearch-project/opensearch-java/pull/1644))

### Fixed
- Fixed building instances of `Explanation` by making `details` optional ([#1620](https://github.com/opensearch-project/opensearch-java/pull/1620))
- Fixed `ApacheHttpClient5Transport` not honoring connect & socket timeouts configured on `ConnectionConfig` ([#1662](https://github.com/opensearch-project/opensearch-java/pull/1662))

## [2.26.0] - 07/10/2025
### Added
- Added Jackson `ObjectMapper` module auto-detection ([#1643](https://github.com/opensearch-project/opensearch-java/pull/1643))

### Dependencies
- Bump `org.owasp.dependencycheck` from 12.1.1 to 12.1.3 ([#1608](https://github.com/opensearch-project/opensearch-java/pull/1608), [#1607](https://github.com/opensearch-project/opensearch-java/pull/1607), [#1623](https://github.com/opensearch-project/opensearch-java/pull/1623))
- Bump `org.junit:junit-bom` from 5.13.0 to 5.13.2 ([#1606](https://github.com/opensearch-project/opensearch-java/pull/1606), [#1650](https://github.com/opensearch-project/opensearch-java/pull/1650), [#1665](https://github.com/opensearch-project/opensearch-java/pull/1665))
- Bump `org.ajoberstar.grgit:grgit-gradle` from 5.3.0 to 5.3.2 ([#1621](https://github.com/opensearch-project/opensearch-java/pull/1621))
- Bump `io.github.classgraph:classgraph` from 4.8.179 to 4.8.180 ([#1651](https://github.com/opensearch-project/opensearch-java/pull/1651))

### Fixed
- Fixed `ApacheHttpClient5Transport` not honoring connect & socket timeouts configured on `ConnectionConfig` ([#1662](https://github.com/opensearch-project/opensearch-java/pull/1662))

## [3.1.0] - 06/04/2025
### Added
- Added support for the `template` query type ([#1586](https://github.com/opensearch-project/opensearch-java/pull/1586))
- Added support for Search Shards request `slice` property ([#1586](https://github.com/opensearch-project/opensearch-java/pull/1586))
- Added support for the `score-ranker-processor` phase results processor ([#1594](https://github.com/opensearch-project/opensearch-java/pull/1594))

### Dependencies
- Bump `org.apache.httpcomponents.client5:httpclient5` from 5.4.4 to 5.5 ([#1578](https://github.com/opensearch-project/opensearch-java/pull/1578))
- Bump `org.junit:junit-bom` from 5.12.2 to 5.13.0 ([#1587](https://github.com/opensearch-project/opensearch-java/pull/1587))

## [2.25.0] - 06/03/2025
### Added
- Added support for the `template` query type ([#1586](https://github.com/opensearch-project/opensearch-java/pull/1586))
- Added support for Search Shards request `slice` property ([#1586](https://github.com/opensearch-project/opensearch-java/pull/1586))
- Added support for ML tool attributes ([#1594](https://github.com/opensearch-project/opensearch-java/pull/1594))
- Added support for the `score-ranker-processor` phase results processor ([#1594](https://github.com/opensearch-project/opensearch-java/pull/1594))

### Dependencies
- Bump `org.junit:junit-bom` from 5.12.2 to 5.13.0 ([#1587](https://github.com/opensearch-project/opensearch-java/pull/1587))

### Fixed
- Fixed ScoreCombination's `parameters` structure ([#1594](https://github.com/opensearch-project/opensearch-java/pull/1594))

## [3.0.0] - 05/16/2025
### ⚠️ Breaking Changes ⚠️
- As part of efforts to re-generate the client from our [OpenAPI specification](https://github.com/opensearch-project/opensearch-api-specification) there have been numerous corrections and changes that resulted in breaking changes. Please refer to [UPGRADING.md](UPGRADING.md) for a complete list of these breakages and any relevant guidance for upgrading to this version of the client.

### Added
- Document HTTP/2 support ([#330](https://github.com/opensearch-project/opensearch-java/pull/330))

### Dependencies
- Bumps `org.eclipse.parsson:parsson` from 1.1.6 to 1.1.7
- Bumps `org.hamcrest:hamcrest` from 2.2 to 3.0
- Bumps `com.github.jk1.dependency-license-report` from 2.8 to 2.9
- Bump `com.carrotsearch.randomizedtesting:randomizedtesting-runner` from 2.8.2 to 2.8.3 ([#1487](https://github.com/opensearch-project/opensearch-java/pull/1487))
- Bump `org.opensearch.gradle:build-tools` from 3.0.0-alpha1-SNAPSHOT to 3.1.0-SNAPSHOT ([#1543](https://github.com/opensearch-project/opensearch-java/pull/1543))

### Changed
- Migrate client transports to Apache HttpClient / Core 5.x ([#246](https://github.com/opensearch-project/opensearch-java/pull/246))
- Changed SearchAfter of SearchRequest type to FieldValue instead of String ([#769](https://github.com/opensearch-project/opensearch-java/pull/769))
- Changed type of `DanglingIndex`'s `creationDateMillis` field from `String` to `long` ([#1124](https://github.com/opensearch-project/opensearch-java/pull/1124))
- Changed type of `ShardStatistics`'s `total`, `successful`, `failed` & `skipped` fields from `Number` to `int/Integer` ([#1158](https://github.com/opensearch-project/opensearch-java/pull/1158))
- Unified `tasks.Info` and `tasks.State` classes into `tasks.TaskInfo` ([#1187](https://github.com/opensearch-project/opensearch-java/pull/1187))
- Changed type of `Hit`'s `sort` field from `List<String>` to `List<FieldValue>` ([#1225](https://github.com/opensearch-project/opensearch-java/pull/1225))
- Changed type of `MultisearchBody`'s `searchAfter` field from `List<String>` to `List<FieldValue>` ([#1225](https://github.com/opensearch-project/opensearch-java/pull/1225))

### Deprecated
- Deprecate RestClientTransport ([#536](https://github.com/opensearch-project/opensearch-java/pull/536))

### Removed
- Removed the `features` and `shutdown` namespaces as they're not supported by OpenSearch ([#1361](https://github.com/opensearch-project/opensearch-java/pull/1361))
- Removed the `indices.diskUsage` operation as it's not supported by OpenSearch ([#1361](https://github.com/opensearch-project/opensearch-java/pull/1361))
- Removed the `ingest.geoIpStats` operation as it's not supported by OpenSearch ([#1375](https://github.com/opensearch-project/opensearch-java/pull/1375))
- Removed the `indices.getUpgrade` and `indices.upgrade` operations as they're not supported by OpenSearch ([#1377](https://github.com/opensearch-project/opensearch-java/pull/1377))
- Removed the `termsEnum` operation as it's not supported by OpenSearch ([#1377](https://github.com/opensearch-project/opensearch-java/pull/1377))

### Fixed
- Fix version and build ([#254](https://github.com/opensearch-project/opensearch-java/pull/254))
- Fixed deserializing `tasks.ListResponse` when using `GroupBy.None` ([#1187](https://github.com/opensearch-project/opensearch-java/pull/1187))

## [2.24.0] - 05/16/2025
### Dependencies
- Bump `org.apache.httpcomponents.client5:httpclient5` from 5.4.3 to 5.4.4 ([#1544](https://github.com/opensearch-project/opensearch-java/pull/1544))

### Changed
- Changed `StopTokenFilter`'s `stopwords` field to no longer be required ([#1551](https://github.com/opensearch-project/opensearch-java/pull/1551))

### Fixed
- Fixed deserializing `wrapper` queries ([#1537](https://github.com/opensearch-project/opensearch-java/pull/1537))
- Add `is_hidden` to `AliasDefinition` ([#1537](https://github.com/opensearch-project/opensearch-java/pull/1537))

## [2.23.0] - 04/17/2025
### Added
- Added `normalizer` to wildcard field ([#1489](https://github.com/opensearch-project/opensearch-java/pull/1489))
- Added `paginationDepth` to `HybridQuery` ([#1490](https://github.com/opensearch-project/opensearch-java/pull/1490))

### Dependencies
- Bump `org.owasp.dependencycheck` from 12.0.2 to 12.1.1 ([#1440](https://github.com/opensearch-project/opensearch-java/pull/1440), [#1514](https://github.com/opensearch-project/opensearch-java/pull/1514))
- Bump `org.junit:junit-bom` from 5.12.0 to 5.12.2 ([#1486](https://github.com/opensearch-project/opensearch-java/pull/1486), [#1525](https://github.com/opensearch-project/opensearch-java/pull/1525))
- Bump `org.apache.httpcomponents.client5:httpclient5` from 5.4.2 to 5.4.3 ([#1506](https://github.com/opensearch-project/opensearch-java/pull/1506))
- Bump `org.apache.httpcomponents.core5:httpcore5-h2` from 5.3.3 to 5.3.4 ([#1498](https://github.com/opensearch-project/opensearch-java/pull/1498))
- Bump `org.apache.httpcomponents.core5:httpcore5` from 5.3.3 to 5.3.4 ([#1497](https://github.com/opensearch-project/opensearch-java/pull/1497))

### Fixed
- Fixed ClassCastException in extractAndWrapCause when handling ExecutionException ([#1483](https://github.com/opensearch-project/opensearch-java/pull/1483))
- Fixed getting cluster & node stats and node info against AOS due to missing properties ([#1520](https://github.com/opensearch-project/opensearch-java/pull/1520), [#1521](https://github.com/opensearch-project/opensearch-java/pull/1521))

## [2.22.0] - 03/05/2025
### Added
- Added `toBuilder()` and `Builder.copy()` methods to all generated classes ([#1300](https://github.com/opensearch-project/opensearch-java/pull/1300))
- Added support for additional ML APIs ([#1443](https://github.com/opensearch-project/opensearch-java/pull/1443))
- Added support for the Search Pipeline APIs ([#1442](https://github.com/opensearch-project/opensearch-java/pull/1442))
- Added support for `simple_pattern` and `simple_pattern_split` tokenizers ([#1448](https://github.com/opensearch-project/opensearch-java/pull/1448), [#1451](https://github.com/opensearch-project/opensearch-java/pull/1451))
- Added support for the Search response `phase_took` field ([#1449](https://github.com/opensearch-project/opensearch-java/pull/1449))
- Added support for `GeoDistanceSort`'s `nested` and `validation_method` fields ([#1470](https://github.com/opensearch-project/opensearch-java/pull/1470))

### Dependencies
- Bump `org.junit:junit-bom` from 5.11.4 to 5.12.0 ([#1456](https://github.com/opensearch-project/opensearch-java/pull/1456))

### Changed
- Changed abstract builders visibility to public ([#1464](https://github.com/opensearch-project/opensearch-java/pull/1464))

## [2.21.0] - 02/14/2025
### Added
- Added support for `GeoDistanceQuery`'s `ignore_unmapped` property ([#1430](https://github.com/opensearch-project/opensearch-java/pull/1430))
- Added support for docvalue_fields in msearch ([#1429](https://github.com/opensearch-project/opensearch-java/pull/1429))

### Dependencies
- Bump `commons-logging:commons-logging` from 1.3.4 to 1.3.5 ([#1418](https://github.com/opensearch-project/opensearch-java/pull/1418))

### Fixed
- Fixed serialization of `KnnQuery`'s `method_parameters` property ([#1427](https://github.com/opensearch-project/opensearch-java/pull/1427))
- Fixed deserializing `GeoValidationMethod` enum values when uppercase ([#1431](https://github.com/opensearch-project/opensearch-java/pull/1431))

## [2.20.0] - 02/04/2025
### Added
- Added support for `KnnQuery`'s `expand_nested_docs`, `method_parameters` and `rescore` properties ([#1407](https://github.com/opensearch-project/opensearch-java/pull/1407))

### Dependencies
- Bump `org.junit:junit-bom` from 5.11.3 to 5.11.4 ([#1367](https://github.com/opensearch-project/opensearch-java/pull/1367))
- Bumps `org.apache.httpcomponents.client5:httpclient5` from 5.4 to 5.4.2 ([#1401](https://github.com/opensearch-project/opensearch-java/pull/1401))
- Bumps `org.apache.httpcomponents.core5:httpcore5` from 5.3 to 5.3.3 ([#1383](https://github.com/opensearch-project/opensearch-java/pull/1383), [#1402](https://github.com/opensearch-project/opensearch-java/pull/1402))
- Bump `org.owasp.dependencycheck` from 11.1.1 to 12.0.2 ([#1381](https://github.com/opensearch-project/opensearch-java/pull/1381), [#1393](https://github.com/opensearch-project/opensearch-java/pull/1393), [#1399](https://github.com/opensearch-project/opensearch-java/pull/1399))

### Fixed
- Fixed serialization of `time_zone` field in `CompositeDateHistogramAggregationSource` ([#1362](https://github.com/opensearch-project/opensearch-java/pull/1362))

## [2.19.0] - 12/12/2024
### Added
- Added support for `IcuCollationKeywordProperty`'s `country`, `language` and `variant` properties ([#1321](https://github.com/opensearch-project/opensearch-java/pull/1321))

### Dependencies
- Bumps `org.junit:junit-bom` from 5.10.2 to 5.11.3
- Bump `com.carrotsearch.randomizedtesting:randomizedtesting-runner` from 2.8.1 to 2.8.2 ([#1343](https://github.com/opensearch-project/opensearch-java/pull/1343))
- Bump `org.owasp.dependencycheck` from 11.1.0 to 11.1.1 ([#1344](https://github.com/opensearch-project/opensearch-java/pull/1344))

### Fixed
- Fixed `IcuCollationDecomposition`'s variants to align with those supported by OpenSearch ([#1321](https://github.com/opensearch-project/opensearch-java/pull/1321))
- Fixed don't invoke the mapper's serialize method for the RangeQuery JsonData raw value [#1309](https://github.com/opensearch-project/opensearch-java/pull/1309)
- Fixed an issue where `FieldSort` was not implementing `SortOptionsVariant` ([#1323](https://github.com/opensearch-project/opensearch-java/pull/1323))
- Fixed `GetSnapshotResponse` deserialization ([#1299](https://github.com/opensearch-project/opensearch-java/pull/1299))
- Fixed `CreateSnapshotResponse` deserialization when wait_for_completion is false  ([#1332](https://github.com/opensearch-project/opensearch-java/pull/1332))
- Fixed serialization of nested aggregates under `SingleBucketAggregateBase` ([#1350](https://github.com/opensearch-project/opensearch-java/pull/1350))

## [2.18.0] - 11/19/2024
### Added
- Added support for disabling typed keys serialization ([#1296](https://github.com/opensearch-project/opensearch-java/pull/1296))
- Added support for the `batch_size` param on the `text_embedding` processor ([#1298](https://github.com/opensearch-project/opensearch-java/pull/1298))

### Dependencies
- Bump `io.github.classgraph:classgraph` from 4.8.177 to 4.8.179 ([#1302](https://github.com/opensearch-project/opensearch-java/pull/1302))

### Changed
- Changed AwsSdk2Transport to pre-emptively throw an exception when using AWS SDK's ApacheHttpClient to make an unsupported DELETE/GET request with a body ([#1256](https://github.com/opensearch-project/opensearch-java/pull/1256))

## [2.17.0] - 11/05/2024
### Added
- Added support for `KnnVectorProperty`'s `compression_level`, `data_type`, `mode` & `space_type` properties ([#1255](https://github.com/opensearch-project/opensearch-java/pull/1255))

### Dependencies
- Bumps `org.apache.httpcomponents.core5:httpcore5-h2` from 5.3 to 5.3.1
- Bumps `org.owasp.dependencycheck` from 10.0.2 to 11.1.0

### Fixed
- Fixed `UndeployModelResponse` deserialization ([#1257](https://github.com/opensearch-project/opensearch-java/pull/1257))

## [2.16.0] - 10/22/2024
### Added
- Added `minScore` and `maxDistance` to `KnnQuery` ([#1166](https://github.com/opensearch-project/opensearch-java/pull/1166))
- Added `minScore` and `maxDistance` to `NeuralQuery` ([#1235](https://github.com/opensearch-project/opensearch-java/pull/1235))

### Dependencies
- Bumps `org.ajoberstar.grgit:grgit-gradle` from 5.2.2 to 5.3.0

### Fixed
- Fixed deserializing `GeoBoundsAggregate` when `bounds` is not returned by OpenSearch ([#1238](https://github.com/opensearch-project/opensearch-java/pull/1238))

## [2.15.0] - 10/17/2024
### Added
- Added `hashCode` and `equals` implementations to generated code ([#312](https://github.com/opensearch-project/opensearch-java/pull/312))
- Added `sortVals` to `Hit` to allow retrieving non-string sort values ([#1224](https://github.com/opensearch-project/opensearch-java/pull/1224))
- Added `searchAfterVals` to `MultisearchBody` to allow passing arbitrary `FieldValue`s to `search_after` ([#1224](https://github.com/opensearch-project/opensearch-java/pull/1224))

### Dependencies
- Bumps `org.junit:junit-bom` from 5.10.3 to 5.11.1
- Bumps `org.apache.httpcomponents.core5:httpcore5-h2` from 5.2.5 to 5.3
- Bumps `org.apache.httpcomponents.core5:httpcore5` from 5.2.5 to 5.3
- Bumps `org.apache.httpcomponents.client5:httpclient5` from 5.3.1 to 5.4
- Bumps `io.github.classgraph:classgraph` from 4.8.175 to 4.8.177

### Fixed
- Fix queries not preserving boost and name when converted to builders ([#1181](https://github.com/opensearch-project/opensearch-java/pull/1181))
- Remove required check on ShardStats.shards ([#1177](https://github.com/opensearch-project/opensearch-java/pull/1177))
- Fixed `TextEmbeddingProcessor` returning the wrong processor kind ([#1127](https://github.com/opensearch-project/opensearch-java/pull/1127))

## [2.14.0] - 08/27/2024
### Added
- Added `queryImage` (query_image) field to `NeuralQuery`, following definition in ([Neural Query](https://opensearch.org/docs/latest/query-dsl/specialized/neural/)) ([#1137](https://github.com/opensearch-project/opensearch-java/pull/1138))
- Added `cancelAfterTimeInterval` to `SearchRequest` and `MsearchRequest` ([#1147](https://github.com/opensearch-project/opensearch-java/pull/1147))
- Added the `ml` namespace operations ([#1158](https://github.com/opensearch-project/opensearch-java/pull/1158))
- Added `IndexTemplateMapping.Builder#withJson`, `SourceField.Builder#withJson` and `IndexSettings.Builder#withJson` for streamlining deserialization ([#1148](https://github.com/opensearch-project/opensearch-java/pull/1148))

### Dependencies
- Bumps `commons-logging:commons-logging` from 1.3.3 to 1.3.4
- Bumps `io.github.classgraph:classgraph` from 4.8.174 to 4.8.175

### Fixed
- Fixed handling of NodeInfo fields that are not returned by Amazon OpenSearch Service ([#1132](https://github.com/opensearch-project/opensearch-java/pull/1132))

## [2.13.0] - 08/01/2024
### Added
- Added `searchAfterVals` to `SearchRequest` to allow passing arbitrary `FieldValue`s to `search_after` ([#1105](https://github.com/opensearch-project/opensearch-java/pull/1105))

### Changed
- Changed URL path encoding to own implementation adapted from Apache HTTP Client 5's ([#1109](https://github.com/opensearch-project/opensearch-java/pull/1109))

### Fixed
- Fixed error when deserializing a normalizer without 'type' ([#1111](https://github.com/opensearch-project/opensearch-java/pull/1111))
- Fixed deserialization of SearchRequest when `_source` is an array ([#1117](https://github.com/opensearch-project/opensearch-java/pull/1117))

## [2.12.0] - 07/22/2024
### Added
- Added support for the `parent` aggregation type ([#706](https://github.com/opensearch-project/opensearch-java/pull/706))
- Added support for phase_took & search_pipeline request params ([#1036](https://github.com/opensearch-project/opensearch-java/pull/1036))
- Added an interface PlainJsonSerializable with a default method for serialization to Json ([#1064](https://github.com/opensearch-project/opensearch-java/pull/1064))

### Dependencies
- Bumps `io.github.classgraph:classgraph` from 4.8.173 to 4.8.174
- Bumps `org.owasp.dependencycheck` from 9.1.0 to 10.0.2
- Bumps `com.github.jk1.dependency-license-report` from 2.7 to 2.8
- Bumps `commons-logging:commons-logging` from 1.3.2 to 1.3.3
- Bumps `org.apache.httpcomponents.core5:httpcore5-h2` from 5.2.4 to 5.2.5
- Bumps `org.apache.httpcomponents.core5:httpcore5` from 5.2.4 to 5.2.5

### Fixed
- Fixed deserializing of error responses when using AwsSdk2Transport ([#1068](https://github.com/opensearch-project/opensearch-java/pull/1068))

## [2.11.1] - 06/27/2024
### Fixed
- Fixed handling of an absent `source` in InlineGet ([#1042](https://github.com/opensearch-project/opensearch-java/pull/1042))

## [2.11.0] - 06/20/2024
### Fixed
- Fixed error when deserializing an analyzer without `type` specified ([#1033](https://github.com/opensearch-project/opensearch-java/pull/1033))

## [2.10.4] - 06/05/2024
### Added
- Added support for [text embedding processor](https://opensearch.org/docs/latest/ingest-pipelines/processors/text-embedding/) ([#1007](https://github.com/opensearch-project/opensearch-java/pull/1007))

### Fixed
- ApacheHttpClient5Transport requires Apache Commons Logging dependency ([#1003](https://github.com/opensearch-project/opensearch-java/pull/1003))
- Preserve caller information in stack traces when synchronous callers use asynchronous transports ([#656](https://github.com/opensearch-project/opensearch-java/pull/656))
- Fix java.lang.NoSuchMethodError: org.apache.http.client.utils.URLEncodedUtils.formatSegments w/o httpclient ([#999](https://github.com/opensearch-project/opensearch-java/pull/999))

## [2.10.3] - 05/16/2024
### Dependencies
- Bumps `io.github.classgraph:classgraph` from 4.8.170 to 4.8.172

### Fixed
- Fix the deserialization of SortOptions ([#981](https://github.com/opensearch-project/opensearch-java/pull/981))
- Generic HTTP Actions in Java Client does not work with AwsSdk2Transport ([#978](https://github.com/opensearch-project/opensearch-java/pull/978))

## [2.10.2] - 05/07/2024
### Fixed
- Fix integer overflow for variables in indices stats response ([#960](https://github.com/opensearch-project/opensearch-java/pull/960))
- Fix composite aggregations for search requests ([#967](https://github.com/opensearch-project/opensearch-java/pull/967))

## [2.10.1] - 04/16/2024
### Added
- Add missed fields to PhraseSuggestOption: collapseMatch ([#940](https://github.com/opensearch-project/opensearch-java/pull/940))
- Add missed fields to bulk's UpdateOperation: source ([#947](https://github.com/opensearch-project/opensearch-java/pull/947))

### Dependencies
- Bumps `com.github.jk1.dependency-license-report` from 2.6 to 2.7

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

### Removed
- Delete shape property ([#884](https://github.com/opensearch-project/opensearch-java/pull/885))

### Fixed
- Fix integer overflow for variables in indices stats response ([#877](https://github.com/opensearch-project/opensearch-java/pull/877))
- Support weight function in function score query ([#880](https://github.com/opensearch-project/opensearch-java/pull/880))
- Fix pattern replace by making flag and replacement optional as on api  ([#895](https://github.com/opensearch-project/opensearch-java/pull/895))
- Client with Java 8 runtime and Apache HttpClient 5 Transport fails with java.lang.NoSuchMethodError: java.nio.ByteBuffer.flip()Ljava/nio/ByteBuffer ([#920](https://github.com/opensearch-project/opensearch-java/pull/920))
- Add missed field  "filter" to NeuralQuery model class

## [2.9.0] - 02/22/2024
### Added
- Add support for Hybrid query type ([#850](https://github.com/opensearch-project/opensearch-java/pull/850))

### Dependencies
- Bumps org.ajoberstar.grgit:grgit-gradle from 5.2.0 to 5.2.2

### Changed
- Restore support for Java 8 ([#767](https://github.com/opensearch-project/opensearch-java/pull/767))
- Add an integration test that runs on JDK-8 ([#795](https://github.com/opensearch-project/opensearch-java/pull/795))

### Fixed
- Fix missing properties on UpdateOperation ([#744](https://github.com/opensearch-project/opensearch-java/pull/744))

## [2.8.4] - 02/20/2024
### Added
- Add search role type for nodes in cluster stats ([#848](https://github.com/opensearch-project/opensearch-java/pull/848))

### Fixed
- Fix ClusterStatsResponse field deserialization ([#848](https://github.com/opensearch-project/opensearch-java/pull/848))

## [2.8.3] - 02/12/2024
### Fixed
- Fix PutTemplateRequest field deserialization ([#723](https://github.com/opensearch-project/opensearch-java/pull/723))
- Fix InnerHits to no longer enforce the nullable Index field when converting to Hit. ([#838](https://github.com/opensearch-project/opensearch-java/pull/838))

## [2.8.2] - 02/07/2024
### Added
- Added support for icu_collation_keyword type ([#725](https://github.com/opensearch-project/opensearch-java/pull/725))
- Added support for flat_object field property ([#735](https://github.com/opensearch-project/opensearch-java/pull/735))
- Expose HTTP status code through `ResponseException#status` ([#756](https://github.com/opensearch-project/opensearch-java/pull/756))
- Added toBuilder method to all request model in core package & _types.query_dsl package ([#766](https://github.com/opensearch-project/opensearch-java/pull/766))
- Added toQuery method in Query and QueryVariant ([#760](https://github.com/opensearch-project/opensearch-java/pull/760))
- Added missing WrapperQuery accessors and builder methods ([#806](https://github.com/opensearch-project/opensearch-java/pull/806))

### Dependencies
- Bumps `com.diffplug.spotless` from 6.22.0 to 6.25.0
- Bumps `org.apache.httpcomponents.client5:httpclient5` from 5.2.1 to 5.3
- Bumps `org.owasp.dependencycheck` from 8.4.2 to 9.0.8

### Deprecated
- Deprecated "_toQuery()" in Query and QueryVariant ([#760](https://github.com/opensearch-project/opensearch-java/pull/760))

### Removed
- Removed unsupported `prefix` field from CompletionSuggester ([#812](https://github.com/opensearch-project/opensearch-java/pull/812))

### Fixed
- Fix partial success results for msearch_template ([#709](https://github.com/opensearch-project/opensearch-java/pull/709))
- Fix deserialization of node stats response ([#745](https://github.com/opensearch-project/opensearch-java/pull/745))
- Fix PutIndexTemplateRequest field deserialization ([#765](https://github.com/opensearch-project/opensearch-java/pull/765))
- Fix InnerHits to no longer enforce the nullable Index field when converting to Hit. ([#825](https://github.com/opensearch-project/opensearch-java/issues/825))

## [2.8.1]
### Fixed
- Fix partial success results for msearch_template ([#709](https://github.com/opensearch-project/opensearch-java/pull/709))

## [2.8.0] - 01/11/2023
### Added
- Added support for indexing and search index settings ([#667](https://github.com/opensearch-project/opensearch-java/pull/667))
- Added support for neural query type ([#674](https://github.com/opensearch-project/opensearch-java/pull/674))

### Changed
- Allow null values in arrays ([#687](https://github.com/opensearch-project/opensearch-java/pull/687))
- Add an example for bulk update operation in samples ([#690](https://github.com/opensearch-project/opensearch-java/pull/690))

### Fixed
- Fixed Hit response when search request has storedFields as null ([#698](https://github.com/opensearch-project/opensearch-java/pull/698))

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

### Deprecated
- Deprecate translogDurability and translogFlushThresholdSize in IndexSettings in favor of a separate translog object ([#518](https://github.com/opensearch-project/opensearch-java/pull/518))

### Fixed
- Fixed Suggesters for Completion, Term, and Phrase and refactored the Suggestion class ([#477](https://github.com/opensearch-project/opensearch-java/pull/477))
- Fix highlight max_analyzer_offset field name to match with the one introduced in OpenSearch 2.2.0 ([#555](https://github.com/opensearch-project/opensearch-java/pull/555))

## [2.5.0] - 06/02/2023
### Added
- Add workflow to publish snapshots via GHA ([#454](https://github.com/opensearch-project/opensearch-java/pull/454))
- Added Point-In-Time APIs ([#461](https://github.com/opensearch-project/opensearch-java/pull/461))

### Dependencies
- Bumps `com.github.jk1.dependency-license-report` from 1.19 to 2.2
- Bumps `org.eclipse.parsson:parsson` from 1.1.1 to 1.1.2

### Changed
- Improve time taken by Github actions by using cache ([#439](https://github.com/opensearch-project/opensearch-java/pull/439))
- Introduce intermediary SearchResult for SearchResponse and SearchTemplateResponse classes, enabling similar response handling for both ([#462](https://github.com/opensearch-project/opensearch-java/pull/462))

### Fixed
- Fix missing Highlight and SourceConfig in the MultisearchBody ([#442](https://github.com/opensearch-project/opensearch-java/pull/442))
- Fix search failure with missing required property HitsMetadata.total when trackTotalHits is disabled ([#372](https://github.com/opensearch-project/opensearch-java/pull/372))
- Fix failure when deserialing response for tasks API ([#463](https://github.com/opensearch-project/opensearch-java/pull/463))
- Fix failure when deserializing boolean types for enums ([#463](https://github.com/opensearch-project/opensearch-java/pull/482))
- Fix missing minScore, postFilter, searchAfter, sort, trackScores in the MultisearchBody ([#516](https://github.com/opensearch-project/opensearch-java/pull/516))

## [2.4.0] - 04/11/2023
### Added
- Add buffered lookahead for Jackson ([#338](https://github.com/opensearch-project/opensearch-java/pull/338))
- Add support for headers and sort parameters in cat requests ([#413](https://github.com/opensearch-project/opensearch-java/pull/413))
- Add support for data stream operations ([#419](https://github.com/opensearch-project/opensearch-java/pull/419))

### Dependencies
- Bumps `io.github.classgraph:classgraph` from 4.8.156 to 4.8.157 ([#408](https://github.com/opensearch-project/opensearch-java/pull/408))

## [2.3.0] - 03/15/2023
### Added
- Require two maintainers to approve release ([#383](https://github.com/opensearch-project/opensearch-java/pull/383))
- Add support for mapping limit settings ([#382](https://github.com/opensearch-project/opensearch-java/pull/382))

### Dependencies
- Bumps `Jackson` from 2.14.1 to 2.14.2 ([#357](https://github.com/opensearch-project/opensearch-java/pull/357))
- Bumps `classgraph` from 4.8.149 to 4.8.156 ([#395](https://github.com/opensearch-project/opensearch-java/pull/395))

### Changed
- Prevent SPI calls at runtime ([#293](https://github.com/opensearch-project/opensearch-java/pull/293))

### Fixed
- Fix issue where completion suggestions were failing, due to being parsed as term suggestions ([#350](https://github.com/opensearch-project/opensearch-java/pull/350))
- Bulk UpdateOperation misses upsert options ([#353](https://github.com/opensearch-project/opensearch-java/pull/353))
- Fix missing key property in the RangeBucket ([#381](https://github.com/opensearch-project/opensearch-java/pull/381))

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

[Unreleased 3.x]: https://github.com/opensearch-project/opensearch-java/compare/v3.6.0...3.x
[Unreleased 2.x]: https://github.com/opensearch-project/opensearch-java/compare/v2.26.0...2.x
[3.6.0]: https://github.com/opensearch-project/opensearch-java/compare/v3.5.0...v3.6.0
[3.5.0]: https://github.com/opensearch-project/opensearch-java/compare/v3.4.0...v3.5.0
[3.4.0]: https://github.com/opensearch-project/opensearch-java/compare/v3.3.0...v3.4.0
[3.3.0]: https://github.com/opensearch-project/opensearch-java/compare/v3.2.0...v3.3.0
[3.2.0]: https://github.com/opensearch-project/opensearch-java/compare/v3.1.0...v3.2.0
[3.1.0]: https://github.com/opensearch-project/opensearch-java/compare/v3.0.0...v3.1.0
[3.0.0]: https://github.com/opensearch-project/opensearch-java/compare/v2.24.0...v3.0.0
[2.26.0]: https://github.com/opensearch-project/opensearch-java/compare/v2.25.0...v2.26.0
[2.25.0]: https://github.com/opensearch-project/opensearch-java/compare/v2.24.0...v2.25.0
[2.24.0]: https://github.com/opensearch-project/opensearch-java/compare/v2.23.0...v2.24.0
[2.23.0]: https://github.com/opensearch-project/opensearch-java/compare/v2.22.0...v2.23.0
[2.22.0]: https://github.com/opensearch-project/opensearch-java/compare/v2.21.0...v2.22.0
[2.21.0]: https://github.com/opensearch-project/opensearch-java/compare/v2.20.0...v2.21.0
[2.20.0]: https://github.com/opensearch-project/opensearch-java/compare/v2.19.0...v2.20.0
[2.19.0]: https://github.com/opensearch-project/opensearch-java/compare/v2.18.0...v2.19.0
[2.18.0]: https://github.com/opensearch-project/opensearch-java/compare/v2.17.0...v2.18.0
[2.17.0]: https://github.com/opensearch-project/opensearch-java/compare/v2.16.0...v2.17.0
[2.16.0]: https://github.com/opensearch-project/opensearch-java/compare/v2.15.0...v2.16.0
[2.15.0]: https://github.com/opensearch-project/opensearch-java/compare/v2.14.0...v2.15.0
[2.14.0]: https://github.com/opensearch-project/opensearch-java/compare/v2.13.0...v2.14.0
[2.13.0]: https://github.com/opensearch-project/opensearch-java/compare/v2.12.0...v2.13.0
[2.12.0]: https://github.com/opensearch-project/opensearch-java/compare/v2.11.1...v2.12.0
[2.11.1]: https://github.com/opensearch-project/opensearch-java/compare/v2.11.0...v2.11.1
[2.11.0]: https://github.com/opensearch-project/opensearch-java/compare/v2.10.4...v2.11.0
[2.10.4]: https://github.com/opensearch-project/opensearch-java/compare/v2.10.3...v2.10.4
[2.10.3]: https://github.com/opensearch-project/opensearch-java/compare/v2.10.2...v2.10.3
[2.10.2]: https://github.com/opensearch-project/opensearch-java/compare/v2.10.1...v2.10.2
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
