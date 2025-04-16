/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.codegen.openapi.reference;

import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.opensearch.client.codegen.openapi.JsonPointer;
import org.opensearch.client.codegen.openapi.OpenApiElement;
import org.opensearch.client.codegen.openapi.OpenApiSpecification;
import org.opensearch.client.codegen.utils.Strings;

public final class RelativeRef {
    @Nonnull
    public static RelativeRef parse(@Nonnull String $ref) {
        Objects.requireNonNull($ref, "$ref must not be null");
        var fragmentIdx = $ref.indexOf('#');
        if (fragmentIdx < 0) throw new IllegalArgumentException("$ref must be a valid relative reference");

        var relativeLocation = $ref.substring(0, fragmentIdx);
        var pointer = JsonPointer.parse($ref.substring(fragmentIdx + 1));
        return new RelativeRef(relativeLocation, pointer);
    }

    @Nullable
    private final String relativeLocation;
    @Nonnull
    private final JsonPointer pointer;

    private RelativeRef(@Nullable String relativeLocation, @Nonnull JsonPointer pointer) {
        this.relativeLocation = relativeLocation;
        this.pointer = Objects.requireNonNull(pointer, "pointer must not be null");
    }

    public Optional<OpenApiElement<?>> resolveIn(OpenApiSpecification specification) {
        Objects.requireNonNull(specification, "specification must not be null");

        if (!Strings.isNullOrEmpty(relativeLocation)) {
            specification = OpenApiSpecification.retrieve(specification.getLocation().resolve(relativeLocation));
        }

        return specification.getElement(pointer);
    }

    @Nonnull
    public JsonPointer getPointer() {
        return pointer;
    }

    @Override
    public String toString() {
        return relativeLocation + '#' + pointer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        RelativeRef that = (RelativeRef) o;

        return new EqualsBuilder().append(relativeLocation, that.relativeLocation).append(pointer, that.pointer).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(relativeLocation).append(pointer).toHashCode();
    }
}
