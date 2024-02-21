/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.codegen.openapi;

import io.swagger.v3.oas.models.media.Schema;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Stream;

@SuppressWarnings({ "rawtypes", "unchecked" })
public class OpenApiSchema extends OpenApiRefObject<OpenApiSchema, Schema> implements OpenApiExtensions {
    public static final OpenApiSchema EMPTY = new OpenApiSchema(null, new Schema<>());

    protected OpenApiSchema(OpenApiSpec parent, Schema<?> schema) {
        super(parent, schema, OpenApiSchema::new, api -> api.getComponents().getSchemas(), Schema::get$ref);
    }

    public String getDescription() {
        return getInner().getDescription();
    }

    public Optional<Type> getType() {
        return getXDataType().or(() -> Optional.ofNullable(getInner().getType())).or(() -> {
            var types = (Set<String>) getInner().getTypes();
            if (types == null || types.isEmpty()) return Optional.empty();
            if (types.size() > 1) {
                throw new IllegalStateException("Multiple types are not yet supported");
            }
            return Optional.of(types.toArray(new String[0])[0]);
        }).map(Type::from);
    }

    public boolean is(Type type) {
        return getType().map(type::equals).orElse(false);
    }

    public boolean isString() {
        return is(Type.STRING);
    }

    public boolean isArray() {
        return is(Type.ARRAY);
    }

    public boolean isObject() {
        return is(Type.OBJECT);
    }

    public Optional<Format> getFormat() {
        return Optional.ofNullable(getInner().getFormat()).map(Format::from);
    }

    public boolean shouldKeepRef() {
        var type = getType();
        if (type.isEmpty()) return false;
        switch (type.get()) {
            case OBJECT:
                return true;
            case STRING:
                return hasEnums();
            default:
                return false;
        }
    }

    public Optional<List<String>> getEnum() {
        return Optional.ofNullable((List<String>) getInner().getEnum());
    }

    public boolean hasEnums() {
        return getEnum().map(l -> !l.isEmpty()).orElse(false);
    }

    private Optional<List<OpenApiSchema>> composedOf(List<Schema> schemas) {
        return Optional.ofNullable(schemas).map(l -> l.stream().map(s -> new OpenApiSchema(getParent(), s)).toList());
    }

    public Optional<List<OpenApiSchema>> getOneOf() {
        return composedOf(getInner().getOneOf());
    }

    public Optional<List<OpenApiSchema>> getAllOf() {
        return composedOf(getInner().getAllOf());
    }

    private Optional<OpenApiSchema> subSchema(Schema schema) {
        return Optional.ofNullable(schema).map(s -> new OpenApiSchema(getParent(), s));
    }

    public Optional<OpenApiSchema> getItems() {
        return subSchema(getInner().getItems());
    }

    public Optional<OpenApiSchema> getAdditionalProperties() {
        return subSchema((Schema) getInner().getAdditionalProperties());
    }

    public Set<String> getRequired() {
        return Optional.ofNullable((List<String>) getInner().getRequired()).map(HashSet::new).orElseGet(HashSet::new);
    }

    public Stream<OpenApiProperty> getProperties() {
        var properties = (Map<String, Schema<?>>) getInner().getProperties();
        if (properties == null) return Stream.empty();
        var requiredFields = getRequired();
        return properties.entrySet()
            .stream()
            .map(e -> new OpenApiProperty(getParent(), e.getKey(), e.getValue(), requiredFields.contains(e.getKey())));
    }

    @Override
    public Map<String, Object> getExtensions() {
        return getInner().getExtensions();
    }

    public Optional<String> getXDataType() {
        return getExtensionAsString("x-data-type");
    }

    public enum Type {
        ARRAY,
        BOOLEAN,
        INTEGER,
        NUMBER,
        OBJECT,
        STRING,
        TIME;

        public static Type from(String s) {
            return valueOf(s.toUpperCase());
        }
    }

    public enum Format {
        INT32,
        INT64,
        FLOAT,
        DOUBLE;

        public static Format from(String s) {
            return valueOf(s.toUpperCase());
        }
    }
}
