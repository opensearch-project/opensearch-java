/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

/*
 * Licensed to Elasticsearch B.V. under one or more contributor
 * license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright
 * ownership. Elasticsearch B.V. licenses this file to you under
 * the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

/*
 * Modifications Copyright OpenSearch Contributors. See
 * GitHub history for details.
 */

//----------------------------------------------------
// THIS CODE IS GENERATED. MANUAL EDITS WILL BE LOST.
//----------------------------------------------------

package org.opensearch.client.opensearch.nodes.stats;

import jakarta.json.stream.JsonGenerator;
import java.util.Objects;
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.opensearch.client.json.JsonpDeserializable;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.ObjectBuilderDeserializer;
import org.opensearch.client.json.ObjectDeserializer;
import org.opensearch.client.json.PlainJsonSerializable;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: nodes.stats.PublishedClusterStates

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class PublishedClusterStates
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<PublishedClusterStates.Builder, PublishedClusterStates> {

    @Nullable
    private final Long compatibleDiffs;

    @Nullable
    private final Long fullStates;

    @Nullable
    private final Long incompatibleDiffs;

    // ---------------------------------------------------------------------------------------------

    private PublishedClusterStates(Builder builder) {
        this.compatibleDiffs = builder.compatibleDiffs;
        this.fullStates = builder.fullStates;
        this.incompatibleDiffs = builder.incompatibleDiffs;
    }

    public static PublishedClusterStates of(Function<PublishedClusterStates.Builder, ObjectBuilder<PublishedClusterStates>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Number of compatible differences between published cluster states.
     * <p>
     * API name: {@code compatible_diffs}
     * </p>
     */
    @Nullable
    public final Long compatibleDiffs() {
        return this.compatibleDiffs;
    }

    /**
     * Number of published cluster states.
     * <p>
     * API name: {@code full_states}
     * </p>
     */
    @Nullable
    public final Long fullStates() {
        return this.fullStates;
    }

    /**
     * Number of incompatible differences between published cluster states.
     * <p>
     * API name: {@code incompatible_diffs}
     * </p>
     */
    @Nullable
    public final Long incompatibleDiffs() {
        return this.incompatibleDiffs;
    }

    /**
     * Serialize this object to JSON.
     */
    @Override
    public void serialize(JsonGenerator generator, JsonpMapper mapper) {
        generator.writeStartObject();
        serializeInternal(generator, mapper);
        generator.writeEnd();
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        if (this.compatibleDiffs != null) {
            generator.writeKey("compatible_diffs");
            generator.write(this.compatibleDiffs);
        }

        if (this.fullStates != null) {
            generator.writeKey("full_states");
            generator.write(this.fullStates);
        }

        if (this.incompatibleDiffs != null) {
            generator.writeKey("incompatible_diffs");
            generator.write(this.incompatibleDiffs);
        }
    }

    // ---------------------------------------------------------------------------------------------

    @Override
    @Nonnull
    public Builder toBuilder() {
        return new Builder(this);
    }

    @Nonnull
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Builder for {@link PublishedClusterStates}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, PublishedClusterStates> {
        @Nullable
        private Long compatibleDiffs;
        @Nullable
        private Long fullStates;
        @Nullable
        private Long incompatibleDiffs;

        public Builder() {}

        private Builder(PublishedClusterStates o) {
            this.compatibleDiffs = o.compatibleDiffs;
            this.fullStates = o.fullStates;
            this.incompatibleDiffs = o.incompatibleDiffs;
        }

        private Builder(Builder o) {
            this.compatibleDiffs = o.compatibleDiffs;
            this.fullStates = o.fullStates;
            this.incompatibleDiffs = o.incompatibleDiffs;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Number of compatible differences between published cluster states.
         * <p>
         * API name: {@code compatible_diffs}
         * </p>
         */
        @Nonnull
        public final Builder compatibleDiffs(@Nullable Long value) {
            this.compatibleDiffs = value;
            return this;
        }

        /**
         * Number of published cluster states.
         * <p>
         * API name: {@code full_states}
         * </p>
         */
        @Nonnull
        public final Builder fullStates(@Nullable Long value) {
            this.fullStates = value;
            return this;
        }

        /**
         * Number of incompatible differences between published cluster states.
         * <p>
         * API name: {@code incompatible_diffs}
         * </p>
         */
        @Nonnull
        public final Builder incompatibleDiffs(@Nullable Long value) {
            this.incompatibleDiffs = value;
            return this;
        }

        /**
         * Builds a {@link PublishedClusterStates}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public PublishedClusterStates build() {
            _checkSingleUse();

            return new PublishedClusterStates(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link PublishedClusterStates}
     */
    public static final JsonpDeserializer<PublishedClusterStates> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        PublishedClusterStates::setupPublishedClusterStatesDeserializer
    );

    protected static void setupPublishedClusterStatesDeserializer(ObjectDeserializer<PublishedClusterStates.Builder> op) {
        op.add(Builder::compatibleDiffs, JsonpDeserializer.longDeserializer(), "compatible_diffs");
        op.add(Builder::fullStates, JsonpDeserializer.longDeserializer(), "full_states");
        op.add(Builder::incompatibleDiffs, JsonpDeserializer.longDeserializer(), "incompatible_diffs");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.compatibleDiffs);
        result = 31 * result + Objects.hashCode(this.fullStates);
        result = 31 * result + Objects.hashCode(this.incompatibleDiffs);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        PublishedClusterStates other = (PublishedClusterStates) o;
        return Objects.equals(this.compatibleDiffs, other.compatibleDiffs)
            && Objects.equals(this.fullStates, other.fullStates)
            && Objects.equals(this.incompatibleDiffs, other.incompatibleDiffs);
    }
}
