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

public class ObjectShape extends Shape {
    private final Map<String, Field> bodyFields = new TreeMap<>();

    public ObjectShape(String namespace, String className) {
        super(namespace, className);
    }

    public void addBodyField(Field field) {
        bodyFields.put(field.name(), field);
    }

    public Collection<Field> bodyFields() { return bodyFields.values(); }

    public Collection<Field> fields() {
        return bodyFields();
    }
}
