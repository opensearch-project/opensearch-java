/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.codegen.openapi;

import static org.opensearch.client.codegen.utils.Functional.ifNonnull;

import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.opensearch.client.codegen.utils.Strings;

public abstract class OpenApiRefElement<TSelf extends OpenApiRefElement<TSelf>> extends OpenApiElement<TSelf> {
    @Nullable
    private final RelativeRef $ref;
    @Nonnull
    private final Class<TSelf> clazz;

    OpenApiRefElement(
        @Nullable OpenApiElement<?> parent,
        @Nonnull JsonPointer pointer,
        @Nullable String $ref,
        @Nonnull Class<TSelf> clazz
    ) {
        super(parent, pointer);
        this.$ref = ifNonnull($ref, RelativeRef::parse);
        this.clazz = Objects.requireNonNull(clazz, "clazz must not be null");
    }

    public boolean has$ref() {
        return $ref != null;
    }

    @Nonnull
    public Optional<RelativeRef> get$ref() {
        return Optional.ofNullable($ref);
    }

    @Nonnull
    public TSelf resolve() {
        if ($ref == null) {
            return self();
        }
        return getSpecification().map(s -> $ref.resolveIn(s, clazz))
            .orElseThrow(() -> new UnsupportedOperationException("Cannot resolve $ref in anonymous component"));
    }

    public static class RelativeRef {
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

        public <TElement extends OpenApiElement<TElement>> TElement resolveIn(OpenApiSpecification specification, Class<TElement> clazz) {
            Objects.requireNonNull(specification, "specification must not be null");

            if (!Strings.isNullOrEmpty(relativeLocation)) {
                specification = OpenApiSpecification.retrieve(specification.getLocation().resolve(relativeLocation));
            }

            return specification.getElement(pointer, clazz);
        }

        @Nonnull
        public JsonPointer getPointer() {
            return pointer;
        }

        @Override
        public String toString() {
            return new ToStringBuilder(this).append("pointer", pointer).append("relativeLocation", relativeLocation).toString();
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
}
