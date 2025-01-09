# UPGRADING

## Upgrading 2.x to 3.0
### URL Path Encoding
- The default URL path encoding has been changed to be more conservative. Previously the `!`, `$`, `&`, `'`, `(`, `)`, `*`, `+`, `,`, `;`, `=`, `@` and `:` characters were left un-encoded, they will now be percent-encoded. If you require the previous behavior you can specify the `org.opensearch.path.encoding=HTTP_CLIENT_V4_EQUIV` system property.

### OpenSearchClient & OpenSearchAsyncClient
- The `listAllPit` operation has been replaced by `getAllPits`.

### SearchAfter of SearchRequest type
- Changed SearchAfter of SearchRequest type to FieldValue instead of String ([#769](https://github.com/opensearch-project/opensearch-java/pull/769))
- Consider using `FieldValue.of` to make string type values compatible.

Before:
```
.searchAfter("string")
.searchAfter("string1", "string2")
.searchAfter(List.of("String"))
```

After:
```
.searchAfter(FieldValue.of("string"))
.searchAfter(FieldValue.of("string1"), FieldValue.of("string2"))
.searchAfter(List.of(FieldValue.of("String")))
```

### DanglingIndex creationDateMillis type
- The type of `DanglingIndex`'s `creationDateMillis` field has been corrected from a `String` to a `long`.

### ShardStatistics properties types
- The type of the `total`, `successful` and `failed` fields has been corrected from `Number` to `int`.
- The type of the `skipped` field has been corrected from `Number` to `Integer`.

### Unified tasks.Info & tasks.State classes into tasks.TaskInfo
- The `tasks.Info` and `tasks.State` classes have been unified into `tasks.TaskInfo`, this affects:
  - `TaskExecutingNode`'s `tasks` field.
  - `GetTasksResponse`'s `task` field.
  - `core.update_by_query_rethrottle.UpdateByQueryRethrottleNode`'s `tasks` field.
- The `headers` field is now a `Map<String, String>` instead of a `Map<String, List<String>>`.

### tasks.ListResponse properties lifted to tasks.TaskListResponseBase
- All fields previously defined on `tasks.ListResponse` have been lifted to `tasks.TaskListResponseBase`.
- `DeleteByQueryRethrottleResponse` now extends `tasks.TaskListResponseBase` instead of `tasks.ListResponse`.
- The `tasks` field is now a `TaskInfos` union type instead of a `Map<String, Info>` to correctly handle `groupBy` parents or none.

### GetTasksResponse response type
- The type of `GetTasksResponse`'s `response` field has been changed from `tasks.Status` to `tasks.TaskResponse`.

### VerifyRepositoryRequest property naming
- The `name` field, getter and builder method have been renamed to `repository`.

### CleanupRepositoryRequest property naming
- The `name` field, getter and builder method have been renamed to `repository`.

### CloneSnapshotRequest timeout removal
- The `timeout` field, getter and builder method have been removed from `CloneSnapshotRequest` as it is not supported by OpenSearch.

### DynamicMapping
- Removed the `Runtime` variant from the `DynamicMapping` enum as it is not supported by OpenSearch.

### TypeMapping
- Removed the `runtime` field, getter and builder methods from `TypeMapping` as it is not supported by OpenSearch.

### InlineScript
- The `lang` property now accepts a `ScriptLanguage` enum instead of a `String`.

### IcuCollationDecomposition enum variants
- The `IcuCollationDecomposition.Identical` variant has been corrected to be `IcuCollationDecomposition.Canonical`.

### IcuCollationTokenFilter property name casing
- The following fields, getters and builder methods on `IcuCollationTokenFilter` have had their casing corrected:
  - `casefirst` -> `caseFirst`
  - `caselevel` -> `caseLevel`
  - `hiraganaquaternarymode` -> `hiraganaQuaternaryMode`
  - `variabletop` -> `variableTop`

### TokenFilterDefinition
- The `smartcn_stop` Builder method has been renamed to `smartcnStop`.

### TokenizerDefinition
- The `smartcn` Builder method has been renamed to `smartcnTokenizer`.

### PointProperty
- `PointProperty` has been removed and is replaced by `XyPointProperty`.

### PropertyBase
- The `name` and `localMetadata` fields, getters and builder methods have been removed from `PropertyBase` as they are not supported by OpenSearch.

### IndexTemplate
- `IndexTemplate` has been moved from the `org.opensearch.client.opensearch.indices.get_index_template` package to the `org.opensearch.client.opensearch.indices` package.
- The `dataStream` property is now of type `IndexTemplateDataStreamConfiguration` instead of `Map<String, JsonData>`.

### IndexTemplateSummary
- `IndexTemplateSummary` has been moved from the `org.opensearch.client.opensearch.indices.get_index_template` package to the `org.opensearch.client.opensearch.indices` package.
- The `settings` property is now of type `IndexSettings` instead of `Map<String, JsonData>`.

### DataStream renamed to IndexTemplateDataStreamConfiguration
- The `DataStream` class has been renamed to `IndexTemplateDataStreamConfiguration`, this affects:
  - `PutIndexTemplateRequest`'s `dataStream` field.
  - `SimulateIndexTemplateRequest`'s `dataStream` field.

### Translog
- The `durability` property now accepts a `TranslogDurability` enum instead of a `String`.

### IndexSettingsMapping
- The mapping limit fields now have specialized types instead of a generic `IndexSettingsMappingLimit` type:
  - `depth` is now of type `IndexSettingsMappingLimitDepth`.
  - `fieldNameLength` is now of type `IndexSettingsMappingLimitFieldNameLength`.
  - `nestedFields` is now of type `IndexSettingsMappingLimitNestedFields`.
  - `nestedObjects` is now of type `IndexSettingsMappingLimitNestedObjects`.
  - `totalFields` is now of type `IndexSettingsMappingLimitTotalFields`.

### IndexSettings
- The `creationDate` property is now of type `Long` instead of `String`.
- The `translogDurability` property now accepts a `TranslogDurability` enum instead of a `String`.
- The `numberOfReplicas` property is now of type `Integer` instead of `String`.
- The `numberOfShards` property is now of type `Integer` instead of `String`.

### BoostingQuery
- The `negativeBoost` property has been corrected to be of type `float` instead of `double`.

### DisMaxQuery
- The `tieBreaker` property has been corrected to be of type `Float` instead of `Double`.

### FunctionScoreQuery
- The `maxBoost` property has been corrected to be of type `Float` instead of `Double`.
- The `minScore` property has been corrected to be of type `Float` instead of `Double`.

### KnnQuery
- The `filter` property is now of type `List<Query>` instead of `Query`.
- The `vector` property is now of type `List<Float>` instead of `float[]`.

### LikeDocument
- The `type` property has been removed as it is not supported by OpenSearch as of version 2.0.0.

### MatchQuery
- The `cutoffFrequency` property has been corrected to be of type `Float` instead of `Double`.

### MoreLikeThisQuery
- The `boostTerms` property has been corrected to be of type `Float` instead of `Double`.

### MultiMatchQuery
- The `cutoffFrequency` property has been corrected to be of type `Float` instead of `Double`.
- The `tieBreaker` property has been corrected to be of type `Float` instead of `Double`.

### QueryStringQuery
- The `phraseSlop` property has been corrected to be of type `Integer` instead of `Double`.
- The `tieBreaker` property has been corrected to be of type `Float` instead of `Double`.

### simulate_template.Template
- The `settings` property is now of type `IndexSettings` instead of `Map<String, JsonData>`.
- The `overlapping` property has been moved to `SimulateTemplateResponse`.

### PutTemplateRequest
- The `flatSettings` property has been removed as it is not supported by OpenSearch.
- The `timeout` property has been removed as it is not supported by OpenSearch.

### DataStreamInfo renamed to DataStream
- The `DataStreamInfo` class has been renamed to `DataStream`, this affects:
  - `GetDataStreamResponse`'s `dataStreams` field.
- The `generation` property is now of type `long` instead of `int`.

### DataStreamIndexInfo renamed to DataStreamIndex
- The `DataStreamIndexInfo` class has been renamed to `DataStreamIndex`, this affects:
  - `DataStream`'s (previously `DataStreamInfo`) `indices` field.

### RepositorySettings
- The `concurrentStreams` property is now of type `Integer` instead of `String`.

### snapshot.RestoreRequest renamed to snapshot.RestoreSnapshotRequest
- The `snapshot.RestoreRequest` class has been renamed to `snapshot.RestoreSnapshotRequest`.
- The `indexSettings` property has been corrected to be of type `IndexSettings` instead of `PutIndicesSettingsRequest`.

### snapshot.RestoreResponse renamed to snapshot.RestoreSnapshotResponse
- The `snapshot.RestoreResponse` class has been renamed to `snapshot.RestoreSnapshotResponse`.

### snapshot.Status renamed to snapshot.SnapshotStatus
- The `snapshot.Status` class has been renamed to `snapshot.SnapshotStatus`, this affects:
  - `snapshot.SnapshotStatusResponse`'s `snapshots` field.

### snapshot.ShardStats renamed to snapshot.SnapshotShardStats
- The `snapshot.ShardStats` class has been renamed to `snapshot.SnapshotShardStats`, this affects:
  - `snapshot.SnapshotStatus`'s (previous `snapshot.Status`) `shardsStats` field.
  - `snapshot.SnapshotIndexStats`'s `shardsStats` field.

### snapshot.ShardsStatsStage renamed to snapshot.SnapshotShardsStatsStage
- The `snapshot.ShardsStatsStage` class has been renamed to `snapshot.SnapshotShardsStatsStage`, this affects:
  - `snapshot.SnapshotShardsStatus`'s `stage` field.

### snapshot.ShardsStatsSummary renamed to snapshot.SnapshotShardsStatsSummary
- The `snapshot.ShardsStatsSummary` class has been renamed to `snapshot.SnapshotShardsStatsSummary`, this affects:
  - `snapshot.SnapshotShardsStatus`'s `summary` field.

### snapshot.ShardsStatsSummaryItem renamed to snapshot.SnapshotShardsStatsSummaryItem
- The `snapshot.ShardsStatsSummaryItem` class has been renamed to `snapshot.SnapshotShardsStatsSummaryItem`, this affects:
  - `snapshot.SnapshotShardsStatsSummary`'s (previously `snapshot.ShardsStatsSummary`) `incremental` and `total` fields.

### AnalyzeToken
- The `endOffset`, `position`, `positionLength` and `startOffset` properties have been corrected to be of type `int` instead of `long`.

### ExplainAnalyzeToken
- The `endOffset`, `position`, `positionLength`, `startOffset` and `termFrequency` properties have been corrected to be of type `int` instead of `long`.
- The `positionlength` and `termfrequency` properties have had their casing corrected to `positionLength` and `termFrequency` respectively.

### RecoveryBytes
- The `recoveredFromSnapshotInBytes`, `recoveredInBytes`, `reusedInBytes` and `totalInBytes` properties have been corrected to be of type `long` instead of `String`.

### RecoveryIndexStatus
- The `sourceThrottleTimeInMillis`, `targetThrottleTimeInMillis` and `totalTimeInMillis` properties have been corrected to be of type `long` instead of `String`.

### RecoveryOrigin
- The `restoreuuid` property has had its casing corrected to `restoreUuid`.

### RecoveryStartStatus
- The `checkIndexTime` property has been corrected to be of type `Time` instead of `long`.
- The `totalTimeInMillis` property has been corrected to be of type `long` instead of `String`.

### ShardRecovery
- The `id` property has been corrected to be of type `int` instead of `long`.
- The `startTimeInMillis`, `stopTimeInMillis` and `totalTimeInMillis` properties have been corrected to be of type `long` instead of `String`.
- The `totalTime` property has been corrected to be of type `Time` instead of `String`.

### indices.recovery.TranslogStatus
- The `recovered`, `total` and `totalOnStart` properties have been corrected to be of type `int` instead of `long`.
- The `totalTime` property has been corrected to be of type `Time` instead of `String`.
- The `totalTimeInMillis` property has been corrected to be of type `long` instead of `String`.

### indices.recovery.VerifyIndex
- The `checkIndexTimeInMillis` and `totalTimeInMillis` properties have been corrected to be of type `long` instead of `String`.

### RolloverRequest
- The `mappings` property is now of type `TypeMapping` instead of `IndexRolloverMapping`.

### IndexRolloverMapping
- The `IndexRolloverMapping` class has been removed.

### Segment
- The `deletedDocs` and `numDocs` properties have been corrected to be of type `int` instead of `long`.
- The `memoryInBytes` and `sizeInBytes` properties have been corrected to be of type `long` instead of `double`.

### ShardStore
- The `attributes`, `id`, `legacyVersion`, `name` and `transportAddress` properties have been removed and are now correctly nested within the `NodeAttributes` under the `nodes` property map.

### FlushStats
- The `totalTime` property has been corrected to be of type `Time` instead of `String`.

### GetStats
- The `existsTime`, `missingTime` and `time` properties have been corrected to be of type `Time` instead of `String`.

### IndexingStats
- The `deleteTime`, `indexTime` and `throttleTime` properties have been corrected to be of type `Time` instead of `String`.
- The `types` property has been removed as it is no longer supported by OpenSearch as of version 2.0.0.

### MergesStats
- The `totalStoppedTime`, `totalThrottledTime` and `totalTime` properties have been corrected to be of type `Time` instead of `String`.

### RecoveryStats
- The `throttleTime` property has been corrected to be of type `Time` instead of `String`.

### RefreshStats
- The `totalTime` property has been corrected to be of type `Time` instead of `String`.

### SegmentsStats
- The `storedMemory` property has been renamed to `storedFieldsMemory` to match the OpenSearch response.

### StoreStats
- The `totalDataSetSize` and `totalDataSetSizeInBytes` properties have been removed as they are not returned by OpenSearch.

### TranslogStats
- The `operations` property has been corrected to be of type `int` instead of `long`.

### WarmerStats
- The `totalTime` property has been corrected to be of type `Time` instead of `String`.

### IndicesStatsRequest
- The `metric` property is now of type `List<IndicesStatsMetric>` instead of `List<String>`.
- The `types` property has been removed as it is no longer supported by OpenSearch as of version 2.0.0.

### IndicesStatsResponse
- The `all` property is now of type `AllIndicesStats` instead of `IndicesStats`.

### ShardStats renamed to IndexShardStats
- The `ShardStats` class has been renamed to `IndexShardStats`, this affects:
  - `IndicesStats`'s `shards` field.

### AllocationExplainResponse
- The `allocationDelay`, `configuredDelay` and `remainingDelay` properties have been corrected to be of type `Time` instead of `String`.

### PutComponentTemplateRequest
- The `aliases`, `mappings` and `settings` properties have been removed as they should be set within the `template` property.

### HealthRequest
- The `level` property is now of type `ClusterHealthLevel` instead of `Level`.

### HealthResponse
- The `activeShardsPercentAsNumber` property has been corrected to be of type `double` instead of `String`.
- The `taskMaxWaitingInQueueMillis` property has been corrected to be of type `long` instead of `String`. 

### PendingTask
- The `timeInQueue` property has been corrected to be of type `Time` instead of `String`.
- The `timeInQueueMillis` property has been corrected to be of type `long` instead of `int`.

### RerouteRequest
- The `metric` property is now of type `List<ClusterRerouteMetric>` instead of `List<String>`.

### StateRequest
- The `metric` property is now of type `List<ClusterStateMetric>` instead of `List<String>`.

### ClusterIndicesShards
- The `primaries`, `replication` and `total` properties have been corrected to be of type `Integer` instead of `Double`.

### ClusterProcessCpu
- The `percent` property has been corrected to be of type `double` instead of `int`.

### FieldTypes
- The `scriptCount` property has been removed as it is not supported by OpenSearch.

### FieldTypesMappings
- The `runtimeFieldTypes` property has been removed as it is not supported by OpenSearch.

### OperatingSystemMemoryInfo
- The `freePercent` and `usedPercent` properties have been corrected to be of type `double` instead of `int`.

### NodeInfoSettingsHttpType
- The `NodeInfoSettingsHttpType` class is now an untagged union between `String` and `NodeInfoSettingsHttpTypeConfig`.

### NodeInfoSettingsTransportType
- The `NodeInfoSettingsHttpType` class is now an untagged union between `String` and `NodeInfoSettingsHttpTypeConfig`.

### NodeThreadPoolInfo
- The `keepAlive` property has been corrected to be of type `Time` instead of `String`.

### NodesInfoRequest
- The `metric` property is now of type `List<NodesInfoMetric>` instead of `List<String>`.
- The `clusterManagerTimeout` and `masterTimeout` properties have been removed as they are not supported by OpenSearch.

### NodeReloadResult
- The `NodeReloadResult` class has been corrected to be an object with an optional `reloadException` instead of a union of stats and error.

### NodesStatsRequest
- The `groups` property has been corrected to be of type `List<String>` instead of `Boolean`.
- The `indexMetric` property is now of type `List<NodesStatsIndexMetric>` instead of `List<String>`.
- The `metric` property is now of type `List<NodesStatsMetric>` instead of `List<String>`.
- The `includeUnloadedSegments`, `masterTimeout` and `clusterManagerTimeout` properties have been removed as they are not supported by OpenSearch.

### nodes.AdaptiveSelection
- The `AdaptiveSelection` class has been moved from the `org.opensearch.client.opensearch.nodes` package to the `org.opensearch.client.opensearch.nodes.stats` package.

### nodes.Breaker
- The `Breaker` class has been moved from the `org.opensearch.client.opensearch.nodes` package to the `org.opensearch.client.opensearch.nodes.stats` package.
- The `overhead` property has been corrected to be of type `double` instead of `float`.
- The `tripped` property has been corrected to be of type `long` instead of `float`.

### nodes.DataPathStats
- The `DataPathStats` class has been moved from the `org.opensearch.client.opensearch.nodes` package to the `org.opensearch.client.opensearch.nodes.stats` package.

### nodes.ExtendedMemoryStats
- The `ExtendedMemoryStats` class has been moved from the `org.opensearch.client.opensearch.nodes` package to the `org.opensearch.client.opensearch.nodes.stats` package.
- The `freePercent` and `usedPercent` properties have been corrected to be of type `double` instead of `int`.

### nodes.FileSystem
- The `FileSystem` class has been moved from the `org.opensearch.client.opensearch.nodes` package to the `org.opensearch.client.opensearch.nodes.stats` package.

### nodes.FileSystemTotal
- The `FileSystemTotal` class has been moved from the `org.opensearch.client.opensearch.nodes` package to the `org.opensearch.client.opensearch.nodes.stats` package.

### nodes.GarbageCollector
- The `GarbageCollector` class has been moved from the `org.opensearch.client.opensearch.nodes` package to the `org.opensearch.client.opensearch.nodes.stats` package.

### nodes.GarbageCollectorTotal
- The `GarbageCollectorTotal` class has been moved from the `org.opensearch.client.opensearch.nodes` package to the `org.opensearch.client.opensearch.nodes.stats` package.

### nodes.Http
- The `Http` class has been moved from the `org.opensearch.client.opensearch.nodes` package to the `org.opensearch.client.opensearch.nodes.stats` package.
- The `currentOpen` property has been corrected to be of type `long` instead of `int`.

### nodes.Ingest
- The `Ingest` class has been moved from the `org.opensearch.client.opensearch.nodes` package to the `org.opensearch.client.opensearch.nodes.stats` package.

### nodes.IngestTotal
- The `IngestTotal` class has been moved from the `org.opensearch.client.opensearch.nodes` package to the `org.opensearch.client.opensearch.nodes.stats` package.

### nodes.Jvm
- The `Jvm` class has been moved from the `org.opensearch.client.opensearch.nodes` package to the `org.opensearch.client.opensearch.nodes.stats` package.
- The `mem` property is now of type `JvmMemoryStats` instead of `MemoryStats`.

### nodes.JvmClasses
- The `JvmClasses` class has been moved from the `org.opensearch.client.opensearch.nodes` package to the `org.opensearch.client.opensearch.nodes.stats` package.

### nodes.JvmThreads
- The `JvmThreads` class has been moved from the `org.opensearch.client.opensearch.nodes` package to the `org.opensearch.client.opensearch.nodes.stats` package.

### nodes.KeyedProcessor
- The `KeyedProcessor` class has been moved from the `org.opensearch.client.opensearch.nodes` package to the `org.opensearch.client.opensearch.nodes.stats` package.
- The `statistics` property has had its naming corrected to `stats` and its type corrected to `Processor`.

### nodes.MemoryStats
- The `MemoryStats` class has been moved from the `org.opensearch.client.opensearch.nodes` package to the `org.opensearch.client.opensearch.nodes.stats` package.
- The `resident`, `residentInBytes`, `share`, `shareInBytes`, `totalVirtual` and `totalVirtualInBytes` properties have been removed as they are not returned by OpenSearch.

### nodes.NodeBufferPool
- The `NodeBufferPool` class has been moved from the `org.opensearch.client.opensearch.nodes` package to the `org.opensearch.client.opensearch.nodes.stats` package.

### nodes.OperatingSystem
- The `OperatingSystem` class has been moved from the `org.opensearch.client.opensearch.nodes` package to the `org.opensearch.client.opensearch.nodes.stats` package.
- The `cpu` property is now of type `OperatingSystemCpuStats` instead of `Cpu`.

### nodes.Process
- The `Process` class has been moved from the `org.opensearch.client.opensearch.nodes` package to the `org.opensearch.client.opensearch.nodes.stats` package.
- The `cpu` property is now of type `ProcessCpuStats` instead of `Cpu`.
- The `mem` property is now of type `ProcessMemoryStats` instead of `MemoryStats`.
- The `openFileDescriptors` property has been corrected to be of type `long` instead of `int`.

### nodes.Stats
- The `Stats` class has been moved from the `org.opensearch.client.opensearch.nodes` package to the `org.opensearch.client.opensearch.nodes.stats` package.
- The `indices` property is now of type `NodesIndicesStats` instead of `IndexStats`.
- The `script` property is now of type `ScriptStats` instead of `Scripting`.

### nodes.ThreadCount
- The `ThreadCount` class has been moved from the `org.opensearch.client.opensearch.nodes` package to the `org.opensearch.client.opensearch.nodes.stats` package.

### nodes.Transport
- The `Transport` class has been moved from the `org.opensearch.client.opensearch.nodes` package to the `org.opensearch.client.opensearch.nodes.stats` package.
- The `serverOpen` property has been corrected to be of type `long` instead of `int`.

### NodesUsageRequest
- The `metric` property is now of type `List<NodesUsageMetric>` instead of `List<String>`.

### NodeUsage
- The `restActions` property has been corrected to be of type `Map<String, Long>` instead of `Map<String, Integer>`.
- The `since` and `timestamp` properties have been corrected to be of type `long` instead of `String`.

### GetPipelineRequest
- The `summary` property has been removed as it is not supported by OpenSearch.

### InferenceProcessor
- The `InferenceProcessor` class has been removed as it is not supported by OpenSearch.
  - This also affects the associated `InferenceConfig` and `InferenceConfigRegression` classes.

### DocumentSimulation
- The `type` property has been removed as it is no longer supported by OpenSearch.

### CountRequest
- The `minScore` property has been corrected to be of type `Float` instead of `Double`.
- The `routing` property is now of type `List<String>` instead of `String`.
- The `terminateAfter` property is now of type `Integer` instead of `Long`.

### CreatePitRequest
- The `CreatePitRequest` class has been moved from the `org.opensearch.client.opensearch.core.pit` package to the `org.opensearch.client.opensearch.core` package.
- The `targetIndexes` property has been renamed to `index`.
- The `routing` property is now of type `List<String>` instead of `String`.

### CreatePitResponse
- The `CreatePitResponse` class has been moved from the `org.opensearch.client.opensearch.core.pit` package to the `org.opensearch.client.opensearch.core` package.

### DeleteRequest
- The `routing` property is now of type `List<String>` instead of `String`.

### DeletePitRequest
- The `DeletePitRequest` class has been moved from the `org.opensearch.client.opensearch.core.pit` package to the `org.opensearch.client.opensearch.core` package.

### DeletePitResponse
- The `DeletePitResponse` class has been moved from the `org.opensearch.client.opensearch.core.pit` package to the `org.opensearch.client.opensearch.core` package.

### DeletePitRecord renamed to DeletedPit
- The `DeletePitRecord` class has been renamed to `DeletedPit`, this affects:
  - `DeletePitResponse`'s `pits` field.

### DeleteByQueryRequest
- The `from` property has been corrected to be of type `Integer` instead of `Long`.
- The `maxDocs` property has been corrected to be of type `Integer` instead of `Long`.
- The `refresh` property has been corrected to be of type `Refresh` instead of `Boolean`.
- The `requestsPerSecond` property has been corrected to be of type `Float` instead of `Long`.
- The `routing` property is now of type `List<String>` instead of `String`.
- The `scrollSize` property has been corrected to be of type `Integer` instead of `Long`.
- The `size` property has been corrected to be of type `Integer` instead of `Long`.
- The `slices` property now accepts a `Slices` union type instead of a `Long`.
- The `terminateAfter` property is now of type `Integer` instead of `Long`.

### DeleteByQueryResponse
- The `batches` property has been corrected to be of type `Integer` instead of `Long`.

### BulkIndexByScrollFailure renamed to BulkByScrollFailure
- The `BulkIndexByScrollFailure` class has been renamed to `BulkByScrollFailure`, this affects:
  - `DeleteByQueryResponse`'s `failures` field.
  - `ReindexResponse`'s `failures` field.
  - `UpdateByQueryResponse`'s `failures` field.

### core.reindex.Source
- The `runtimeMappings` property has been removed as it is not supported by OpenSearch.

### ReindexRequest
- The `maxDocs` property has been corrected to be of type `Integer` instead of `Long`.
- The `refresh` property has been corrected to be of type `Refresh` instead of `Boolean`.
- The `requestsPerSecond` property has been corrected to be of type `Float` instead of `Long`.
- The `size` property has been corrected to be of type `Integer` instead of `Long`.
- The `slices` property now accepts a `Slices` union type instead of a `Long`.

### ReindexResponse
- The `batches` property has been corrected to be of type `Integer` instead of `Long`.
- The `requestsPerSecond` property has been corrected to be of type `Float` instead of `Long`.
- The `throttledMillis` and `throttledUntilMillis` properties have been corrected to be of type `Long` instead of `String`.
- The `took` property has been corrected to be of type `Long` instead of `Time`.

### UpdateByQueryRequest
- The `from` property has been corrected to be of type `Integer` instead of `Long`.
- The `maxDocs` property has been corrected to be of type `Integer` instead of `Long`.
- The `refresh` property has been corrected to be of type `Refresh` instead of `Boolean`.
- The `requestsPerSecond` property has been corrected to be of type `Float` instead of `Long`.
- The `routing` property is now of type `List<String>` instead of `String`.
- The `scrollSize` property has been corrected to be of type `Integer` instead of `Long`.
- The `size` property has been corrected to be of type `Integer` instead of `Long`.
- The `slices` property now accepts a `Slices` union type instead of a `Long`.
- The `terminateAfter` property is now of type `Integer` instead of `Long`.
- The `versionType` property has been removed as it is not supported by OpenSearch.

### UpdateByQueryResponse
- The `batches` property has been corrected to be of type `Integer` instead of `Long`.
- The `throttledMillis` and `throttledUntilMillis` properties have been corrected to be of type `Long` instead of `Number`.

### DeleteByQueryRethrottleRequest
- The `requestsPerSecond` property has been corrected to be of type `Float` instead of `Long`.

### ReindexRethrottleRequest
- The `requestsPerSecond` property has been corrected to be of type `Float` instead of `Long`.

### UpdateByQueryRethrottleRequest
- The `requestsPerSecond` property has been corrected to be of type `Float` instead of `Long`.

### StoredScript
- The `lang` property now accepts a `ScriptLanguage` enum instead of a `String`.

### get_script_languages.LanguageContext
- The `language` property now accepts a `ScriptLanguage` enum instead of a `String`.

### ExistsRequest
- The `refresh` property has been corrected to be of type `Refresh` instead of `Boolean`.
- The `routing` property is now of type `List<String>` instead of `String`.

### ExistsSourceRequest
- The `refresh` property has been corrected to be of type `Refresh` instead of `Boolean`.
- The `routing` property is now of type `List<String>` instead of `String`.