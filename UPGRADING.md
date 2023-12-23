# UPGRADING

## [UPGRADING 2.x to 3.0]
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
