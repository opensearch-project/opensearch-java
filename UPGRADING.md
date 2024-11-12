# UPGRADING

## Upgrading 2.x to 3.0
### URL Path Encoding
- The default URL path encoding has been changed to be more conservative. Previously the `!`, `$`, `&`, `'`, `(`, `)`, `*`, `+`, `,`, `;`, `=`, `@` and `:` characters were left un-encoded, they will now be percent-encoded. If you require the previous behavior you can specify the `org.opensearch.path.encoding=HTTP_CLIENT_V4_EQUIV` system property.

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