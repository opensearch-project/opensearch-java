/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.codegen.model;

import java.util.Collection;
import java.util.Map;
import java.util.TreeMap;
import org.openapi4j.parser.model.v3.Schema;

public class ObjectShape extends Shape {
    public static ObjectShape from(Context ctx, String name, Schema schema) {
        return new ObjectShape(ctx.namespace, name, Field.allFrom(ctx, schema));
    }

    protected final Map<String, Field> bodyFields = new TreeMap<>();

    protected ObjectShape(Namespace parent, String className, Collection<Field> bodyFields) {
        super(parent, className);
        bodyFields.forEach(f -> this.bodyFields.put(f.name(), f));
    }

    public Collection<Field> bodyFields() { return bodyFields.values(); }

    public Collection<Field> fields() {
        return bodyFields();
    }
}
