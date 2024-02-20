/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.codegen.model;

import java.util.stream.Stream;
import org.opensearch.client.codegen.NameSanitizer;
import org.opensearch.client.codegen.openapi.OpenApiParameter;
import org.opensearch.client.codegen.openapi.OpenApiSchema;

public class Field {
    public static Field from(Context ctx, OpenApiParameter parameter) {
        return from(ctx, parameter.getName(), parameter.getSchema(), parameter.getRequired(), parameter.getDescription());
    }

    public static Field from(Context ctx, String name, OpenApiSchema schema, boolean required, String description) {
        return new Field(name, ctx.typeMapper.mapType(schema), required, description);
    }

    public static Stream<Field> allFrom(Context ctx, OpenApiSchema schema) {
        return schema.getProperties()
                .map(p -> from(ctx, p.getName(), p.getSchema(), p.isRequired(), p.getDescription()));
    }

    private final String wireName;
    private final Type type;
    private boolean required;
    private final String description;

    public Field(String wireName, Type type, boolean required, String description) {
        this.wireName = wireName;
        this.type = type;
        this.required = required;
        this.description = description;
    }

    public String wireName() {
        return wireName;
    }

    public String name() {
        return NameSanitizer.wireNameToField(wireName);
    }

    public Type type() {
        return required ? type : type.boxed();
    }

    public boolean required() {
        return required;
    }

    public void setRequired(boolean required) {
        this.required = required;
    }

    public String description() {
        return description;
    }
}
