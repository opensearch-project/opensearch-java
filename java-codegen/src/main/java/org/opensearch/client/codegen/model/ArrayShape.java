package org.opensearch.client.codegen.model;

import io.swagger.v3.oas.models.media.Schema;
import java.util.List;

public class ArrayShape extends ObjectShape {
    public static ArrayShape from(Context ctx, String name, Schema<?> schema) {
        return new ArrayShape(ctx.namespace, name, Field.from(ctx, "_value_body", schema, true, "Response value"));
    }

    private final Field valueBodyField;

    protected ArrayShape(Namespace parent, String className, Field valueBodyField) {
        super(parent, className, valueBodyField);
        this.valueBodyField = valueBodyField;
    }

    public Field valueBodyField() {
        return valueBodyField;
    }
}
