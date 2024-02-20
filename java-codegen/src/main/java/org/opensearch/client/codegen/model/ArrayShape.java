/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.codegen.model;

import java.util.Collection;
import java.util.List;
import org.opensearch.client.codegen.openapi.OpenApiSchema;

public class ArrayShape extends ObjectShape {
    public static ArrayShape from(Context ctx, String name, OpenApiSchema schema) {
        return new ArrayShape(ctx.namespace, name, Field.from(ctx, "_value_body", schema, true, "Response value."));
    }

    private final Field valueBodyField;

    protected ArrayShape(Namespace parent, String className, Field valueBodyField) {
        super(parent, className);
        this.valueBodyField = valueBodyField;
    }

    @Override
    public Collection<Field> fields() {
        return List.of(valueBodyField);
    }

    @Override
    public Collection<Type> annotations() {
        return List.of(Types.Client.Json.JsonpDeserializable);
    }

    @Override
    public Type implementsType() {
        return Types.Client.Json.JsonpSerializable;
    }

    public Field valueBodyField() {
        return valueBodyField;
    }
}
