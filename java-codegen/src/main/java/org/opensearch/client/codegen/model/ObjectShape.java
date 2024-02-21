/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.codegen.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import org.opensearch.client.codegen.openapi.OpenApiSchema;

public class ObjectShape extends Shape {
    public static ObjectShape from(Context ctx, String name, OpenApiSchema schema) {
        return new ObjectShape(ctx, name, schema);
    }

    protected Type extendsType;
    protected final Map<String, Field> bodyFields = new TreeMap<>();
    protected Field additionalPropertiesField;

    protected ObjectShape(Context ctx, String className, OpenApiSchema schema) {
        super(ctx.namespace, className);
        var allOf = schema.getAllOf();
        if (allOf.isPresent()) {
            this.extendsType = ctx.typeMapper.mapType(allOf.get().get(0));
            schema = allOf.get().get(1);
        } else {
            this.extendsType = null;
        }
        Field.allFrom(ctx, schema).forEach(f -> this.bodyFields.put(f.name(), f));
        var additionalProperties = schema.getAdditionalProperties();
        if (additionalProperties.isPresent()) {
            var valueType = ctx.typeMapper.mapType(additionalProperties.get());
            this.additionalPropertiesField = new Field(
                "metadata",
                Types.Java.Util.Map(Types.Java.Lang.String, valueType),
                false,
                additionalProperties.get().getDescription()
            );
        }
    }

    protected ObjectShape(Namespace parent, String className) {
        super(parent, className);
        this.extendsType = null;
    }

    public Collection<Field> bodyFields() {
        return bodyFields.values();
    }

    public Collection<Field> fields() {
        if (additionalPropertiesField != null) {
            var fields = new ArrayList<>(bodyFields());
            fields.add(additionalPropertiesField);
            return fields;
        }
        return bodyFields();
    }

    public Type extendsType() {
        return extendsType;
    }

    public Type implementsType() {
        return !bodyFields.isEmpty() ? Types.Client.Json.JsonpSerializable : null;
    }

    public Collection<Type> annotations() {
        return !bodyFields.isEmpty() ? List.of(Types.Client.Json.JsonpDeserializable) : null;
    }

    public Type builderFnType() {
        return Types.Java.Util.Function.Function(type().builderType(), Types.Client.Util.ObjectBuilder(type()));
    }
}
