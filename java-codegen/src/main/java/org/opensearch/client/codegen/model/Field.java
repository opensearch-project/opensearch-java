/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.codegen.model;

import java.util.Objects;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.opensearch.client.codegen.NameSanitizer;
import org.opensearch.client.codegen.utils.Strings;

public class Field {
    @Nonnull
    private final String wireName;
    @Nonnull
    private final Type type;
    private boolean required;
    @Nullable
    private final String description;
    @Nullable
    private final Deprecation deprecation;
    private final boolean isAdditionalProperties;

    public Field(
        @Nonnull String wireName,
        @Nonnull Type type,
        boolean required,
        @Nullable String description,
        @Nullable Deprecation deprecation
    ) {
        this(wireName, type, required, description, deprecation, false);
    }

    public Field(
        @Nonnull String wireName,
        @Nonnull Type type,
        boolean required,
        @Nullable String description,
        @Nullable Deprecation deprecation,
        boolean isAdditionalProperties
    ) {
        this.wireName = Strings.requireNonBlank(wireName, "wireName must not be null");
        this.type = Objects.requireNonNull(type, "type must not be null");
        this.required = required;
        this.description = description;
        this.deprecation = deprecation;
        this.isAdditionalProperties = isAdditionalProperties;
    }

    @Nonnull
    public String getWireName() {
        return wireName;
    }

    @Nonnull
    public String getName() {
        return NameSanitizer.wireNameToField(wireName);
    }

    @Nonnull
    public Type getType() {
        this.
        return required ? type : type.getBoxed();

    }

    public boolean isRequired() {
        return required;
    }

    public void setRequired(boolean required) {
        this.required = required;
    }

    @Nullable
    public String getDescription() {
        return description;
    }

    @Nullable
    public Deprecation getDeprecation() {
        return deprecation;
    }
}
