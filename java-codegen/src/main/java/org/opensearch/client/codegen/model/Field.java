/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.codegen.model;

import io.swagger.v3.oas.models.Operation;
import io.swagger.v3.oas.models.PathItem;
import io.swagger.v3.oas.models.media.Schema;
import io.swagger.v3.oas.models.parameters.Parameter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.opensearch.client.codegen.NameSanitizer;
import org.opensearch.client.codegen.utils.Schemas;

public class Field {
    public static Field from(Context ctx, Parameter parameter) {
        return from(ctx, parameter.getName(), parameter.getSchema(), parameter.getRequired(), parameter.getDescription());
    }

    public static Field from(Context ctx, String name, Schema<?> schema, boolean required, String description) {
        return new Field(name, ctx.typeMapper.mapType(schema), required, description);
    }

    public static List<Field> allFrom(Context ctx, Schema<?> schema) {
        List<Field> fields = new ArrayList<>();
        Schemas.forEachProperty(schema, (name, prop, required) -> fields.add(from(ctx, name, prop, required, prop.getDescription())));
        return fields;
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
