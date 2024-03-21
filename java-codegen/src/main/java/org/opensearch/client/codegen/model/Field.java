/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.codegen.model;

import org.opensearch.client.codegen.NameSanitizer;

public class Field {
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

    public String getWireName() {
        return wireName;
    }

    public String getName() {
        return NameSanitizer.wireNameToField(wireName);
    }

    public Type getType() {
        return required ? type : type.getBoxed();
    }

    public boolean isRequired() {
        return required;
    }

    public void setRequired(boolean required) {
        this.required = required;
    }

    public String getDescription() {
        return description;
    }
}
