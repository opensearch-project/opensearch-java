/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.codegen.utils;

import java.util.Map;
import org.apache.commons.lang3.tuple.Pair;
import org.openapi4j.parser.model.v3.AbsExtendedOpenApiSchema;
import org.openapi4j.parser.model.v3.AbsExtendedRefOpenApiSchema;
import org.opensearch.client.codegen.model.OperationGroup;

public class Extensions {
    private final Either<AbsExtendedOpenApiSchema<?>, AbsExtendedRefOpenApiSchema<?>> schema;

    public static Extensions of(AbsExtendedOpenApiSchema<?> schema) {
        return new Extensions(Either.left(schema));
    }

    public static Extensions of(AbsExtendedRefOpenApiSchema<?> schema) {
        return new Extensions(Either.right(schema));
    }

    private Extensions(Either<AbsExtendedOpenApiSchema<?>, AbsExtendedRefOpenApiSchema<?>> schema) {
        this.schema = schema;
    }

    private Object get(String name) {
        Map<String, Object> extensions = schema.fold(AbsExtendedOpenApiSchema::getExtensions, AbsExtendedRefOpenApiSchema::getExtensions);
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
