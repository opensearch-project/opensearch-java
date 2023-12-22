# UPGRADING

## [UPGRADING 2.x to 3.0]
### SearchAfter of SearchRequest type
- Changed SearchAfter of SearchRequest type to FieldValue instead of String
- Consider using `FieldValue.of("")` to make string type values compatible.
