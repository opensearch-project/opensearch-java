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
        return from(ctx, parameter.getName(), parameter.getSchema(), parameter.getRequired());
    }

    public static Field from(Context ctx, String name, Schema<?> schema, boolean required) {
        return new Field(name, ctx.typeMapper.mapType(schema), required);
    }

    public static List<Field> allFrom(Context ctx, Schema<?> schema) {
        List<Field> fields = new ArrayList<>();
        Schemas.forEachProperty(schema, (name, prop, required) -> fields.add(from(ctx, name, prop, required)));
        return fields;
    }

    public static List<Field> allFrom(Context ctx, PathItem path, Operation operation, String in) {
        var fields = new ArrayList<Field>();
        for (var parameter : Schemas.getParametersIn(path, operation, in).collect(Collectors.toList())) {
            fields.add(from(ctx, parameter));
        }
        return fields;
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
