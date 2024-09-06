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

### tasks.State class renamed to tasks.TaskInfo
- The `tasks.State` class has been renamed to `tasks.TaskInfo`, this affects:
  - `TaskExecutingNode`'s `tasks` field.
- The `headers` field is now a `Map<String, String>` instead of a `Map<String, List<String>>`.