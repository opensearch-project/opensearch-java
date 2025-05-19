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

package org.opensearch.client.opensearch.indices;

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

// typedef: indices.IndexRoutingAllocationInclude

/**
 * The inclusion rules for shard allocation.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class IndexRoutingAllocationInclude
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<IndexRoutingAllocationInclude.Builder, IndexRoutingAllocationInclude> {

    @Nullable
    private final String id;

    @Nullable
    private final String tierPreference;

    // ---------------------------------------------------------------------------------------------

    private IndexRoutingAllocationInclude(Builder builder) {
        this.id = builder.id;
        this.tierPreference = builder.tierPreference;
    }

    public static IndexRoutingAllocationInclude of(
        Function<IndexRoutingAllocationInclude.Builder, ObjectBuilder<IndexRoutingAllocationInclude>> fn
    ) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code _id}
     */
    @Nullable
    public final String id() {
        return this.id;
    }

    /**
     * The data tier preference for the index.
     * <p>
     * API name: {@code _tier_preference}
     * </p>
     */
    @Nullable
    public final String tierPreference() {
        return this.tierPreference;
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
        if (this.id != null) {
            generator.writeKey("_id");
            generator.write(this.id);
        }

        if (this.tierPreference != null) {
            generator.writeKey("_tier_preference");
            generator.write(this.tierPreference);
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
     * Builder for {@link IndexRoutingAllocationInclude}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, IndexRoutingAllocationInclude> {
        @Nullable
        private String id;
        @Nullable
        private String tierPreference;

        public Builder() {}

        private Builder(IndexRoutingAllocationInclude o) {
            this.id = o.id;
            this.tierPreference = o.tierPreference;
        }

        private Builder(Builder o) {
            this.id = o.id;
            this.tierPreference = o.tierPreference;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code _id}
         */
        @Nonnull
        public final Builder id(@Nullable String value) {
            this.id = value;
            return this;
        }

        /**
         * The data tier preference for the index.
         * <p>
         * API name: {@code _tier_preference}
         * </p>
         */
        @Nonnull
        public final Builder tierPreference(@Nullable String value) {
            this.tierPreference = value;
            return this;
        }

        /**
         * Builds a {@link IndexRoutingAllocationInclude}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public IndexRoutingAllocationInclude build() {
            _checkSingleUse();

            return new IndexRoutingAllocationInclude(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link IndexRoutingAllocationInclude}
     */
    public static final JsonpDeserializer<IndexRoutingAllocationInclude> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        IndexRoutingAllocationInclude::setupIndexRoutingAllocationIncludeDeserializer
    );

    protected static void setupIndexRoutingAllocationIncludeDeserializer(ObjectDeserializer<IndexRoutingAllocationInclude.Builder> op) {
        op.add(Builder::id, JsonpDeserializer.stringDeserializer(), "_id");
        op.add(Builder::tierPreference, JsonpDeserializer.stringDeserializer(), "_tier_preference");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.id);
        result = 31 * result + Objects.hashCode(this.tierPreference);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        IndexRoutingAllocationInclude other = (IndexRoutingAllocationInclude) o;
        return Objects.equals(this.id, other.id) && Objects.equals(this.tierPreference, other.tierPreference);
    }
}
