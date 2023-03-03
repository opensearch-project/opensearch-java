/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.codegen.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.openapi4j.parser.model.v3.Operation;
import org.openapi4j.parser.model.v3.Parameter;
import org.openapi4j.parser.model.v3.Path;
import org.openapi4j.parser.model.v3.Schema;
import org.opensearch.client.codegen.NameSanitizer;
import org.opensearch.client.codegen.utils.Schemas;

public class Field {
    public static Field from(Context ctx, Parameter parameter) {
        return from(ctx, parameter.getName(), parameter.getSchema(), parameter.isRequired());
    }

    public static Field from(Context ctx, String name, Schema schema, boolean required) {
        return new Field(name, ctx.typeMapper.mapType(schema), required);
    }

    public static List<Field> allFrom(Context ctx, Schema schema) {
        List<Field> fields = new ArrayList<>();
        Schemas.forEachProperty(schema, (name, prop, required) -> fields.add(from(ctx, name, prop, required)));
        return fields;
    }

    public static List<Field> allFrom(Context ctx, Path path, Operation operation, String in) {
        return Schemas.getParametersIn(ctx.openApiCtx, path, operation, in)
                .map(p -> from(ctx, p))
                .collect(Collectors.toList());
    }

    private final String wireName;
    private final Type type;
    private final boolean required;

    private Field(String wireName, Type type, boolean required) {
        this.wireName = wireName;
        this.type = required ? type : type.boxed();
        this.required = required;
    }

    public String wireName() {
        return wireName;
    }

    public String name() {
        return NameSanitizer.wireNameToField(wireName);
    }

    public Type type() {
        return type;
    }

    public boolean required() {
        return required;
    }
}
