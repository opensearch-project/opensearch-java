/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.codegen.utils;

import io.swagger.v3.oas.models.Operation;
import io.swagger.v3.oas.models.media.Schema;
import java.util.Map;
import org.opensearch.client.codegen.model.OperationGroup;

public class Extensions {
    private final Either<Operation, Schema<?>> schema;

    public static Extensions of(Operation schema) {
        return new Extensions(Either.left(schema));
    }

    public static Extensions of(Schema<?> schema) {
        return new Extensions(Either.right(schema));
    }

    private Extensions(Either<Operation, Schema<?>> schema) {
        this.schema = schema;
    }

    private Object get(String name) {
        Map<String, Object> extensions = schema.fold(Operation::getExtensions, Schema::getExtensions);
        if (extensions == null) return null;
        return extensions.get(name);
    }

    public OperationGroup operationGroup() {
        String group = (String) get("x-operation-group");
        if (group == null) return null;
        return OperationGroup.from(group);
    }

    public String namespace() {
        OperationGroup group = operationGroup();
        if (group == null) return null;
        return group.namespace();
    }

    public String operationName() {
        OperationGroup group = operationGroup();
        if (group == null) return null;
        return group.name();
    }
}
