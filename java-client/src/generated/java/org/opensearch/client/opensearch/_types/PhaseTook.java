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

package org.opensearch.client.opensearch._types;

import jakarta.json.stream.JsonGenerator;
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import org.opensearch.client.json.JsonpDeserializable;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.ObjectBuilderDeserializer;
import org.opensearch.client.json.ObjectDeserializer;
import org.opensearch.client.json.PlainJsonSerializable;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: _types.PhaseTook

/**
 * The time taken by different phases of the search.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class PhaseTook implements PlainJsonSerializable, ToCopyableBuilder<PhaseTook.Builder, PhaseTook> {

    private final long canMatch;

    private final long dfsPreQuery;

    private final long dfsQuery;

    private final long expand;

    private final long fetch;

    private final long query;

    // ---------------------------------------------------------------------------------------------

    private PhaseTook(Builder builder) {
        this.canMatch = ApiTypeHelper.requireNonNull(builder.canMatch, this, "canMatch");
        this.dfsPreQuery = ApiTypeHelper.requireNonNull(builder.dfsPreQuery, this, "dfsPreQuery");
        this.dfsQuery = ApiTypeHelper.requireNonNull(builder.dfsQuery, this, "dfsQuery");
        this.expand = ApiTypeHelper.requireNonNull(builder.expand, this, "expand");
        this.fetch = ApiTypeHelper.requireNonNull(builder.fetch, this, "fetch");
        this.query = ApiTypeHelper.requireNonNull(builder.query, this, "query");
    }

    public static PhaseTook of(Function<PhaseTook.Builder, ObjectBuilder<PhaseTook>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - The time taken for the <code>can_match</code> phase.
     * <p>
     * API name: {@code can_match}
     * </p>
     */
    public final long canMatch() {
        return this.canMatch;
    }

    /**
     * Required - The time taken for the distributed frequency search <code>pre-query</code> phase.
     * <p>
     * API name: {@code dfs_pre_query}
     * </p>
     */
    public final long dfsPreQuery() {
        return this.dfsPreQuery;
    }

    /**
     * Required - The time taken for the distributed frequency search query phase.
     * <p>
     * API name: {@code dfs_query}
     * </p>
     */
    public final long dfsQuery() {
        return this.dfsQuery;
    }

    /**
     * Required - The time taken for the <code>expand</code> phase.
     * <p>
     * API name: {@code expand}
     * </p>
     */
    public final long expand() {
        return this.expand;
    }

    /**
     * Required - The time taken for the <code>fetch</code> phase.
     * <p>
     * API name: {@code fetch}
     * </p>
     */
    public final long fetch() {
        return this.fetch;
    }

    /**
     * Required - The time taken for the <code>query</code> phase.
     * <p>
     * API name: {@code query}
     * </p>
     */
    public final long query() {
        return this.query;
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
        generator.writeKey("can_match");
        generator.write(this.canMatch);

        generator.writeKey("dfs_pre_query");
        generator.write(this.dfsPreQuery);

        generator.writeKey("dfs_query");
        generator.write(this.dfsQuery);

        generator.writeKey("expand");
        generator.write(this.expand);

        generator.writeKey("fetch");
        generator.write(this.fetch);

        generator.writeKey("query");
        generator.write(this.query);
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
     * Builder for {@link PhaseTook}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, PhaseTook> {
        private Long canMatch;
        private Long dfsPreQuery;
        private Long dfsQuery;
        private Long expand;
        private Long fetch;
        private Long query;

        public Builder() {}

        private Builder(PhaseTook o) {
            this.canMatch = o.canMatch;
            this.dfsPreQuery = o.dfsPreQuery;
            this.dfsQuery = o.dfsQuery;
            this.expand = o.expand;
            this.fetch = o.fetch;
            this.query = o.query;
        }

        private Builder(Builder o) {
            this.canMatch = o.canMatch;
            this.dfsPreQuery = o.dfsPreQuery;
            this.dfsQuery = o.dfsQuery;
            this.expand = o.expand;
            this.fetch = o.fetch;
            this.query = o.query;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - The time taken for the <code>can_match</code> phase.
         * <p>
         * API name: {@code can_match}
         * </p>
         */
        @Nonnull
        public final Builder canMatch(long value) {
            this.canMatch = value;
            return this;
        }

        /**
         * Required - The time taken for the distributed frequency search <code>pre-query</code> phase.
         * <p>
         * API name: {@code dfs_pre_query}
         * </p>
         */
        @Nonnull
        public final Builder dfsPreQuery(long value) {
            this.dfsPreQuery = value;
            return this;
        }

        /**
         * Required - The time taken for the distributed frequency search query phase.
         * <p>
         * API name: {@code dfs_query}
         * </p>
         */
        @Nonnull
        public final Builder dfsQuery(long value) {
            this.dfsQuery = value;
            return this;
        }

        /**
         * Required - The time taken for the <code>expand</code> phase.
         * <p>
         * API name: {@code expand}
         * </p>
         */
        @Nonnull
        public final Builder expand(long value) {
            this.expand = value;
            return this;
        }

        /**
         * Required - The time taken for the <code>fetch</code> phase.
         * <p>
         * API name: {@code fetch}
         * </p>
         */
        @Nonnull
        public final Builder fetch(long value) {
            this.fetch = value;
            return this;
        }

        /**
         * Required - The time taken for the <code>query</code> phase.
         * <p>
         * API name: {@code query}
         * </p>
         */
        @Nonnull
        public final Builder query(long value) {
            this.query = value;
            return this;
        }

        /**
         * Builds a {@link PhaseTook}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public PhaseTook build() {
            _checkSingleUse();

            return new PhaseTook(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link PhaseTook}
     */
    public static final JsonpDeserializer<PhaseTook> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        PhaseTook::setupPhaseTookDeserializer
    );

    protected static void setupPhaseTookDeserializer(ObjectDeserializer<PhaseTook.Builder> op) {
        op.add(Builder::canMatch, JsonpDeserializer.longDeserializer(), "can_match");
        op.add(Builder::dfsPreQuery, JsonpDeserializer.longDeserializer(), "dfs_pre_query");
        op.add(Builder::dfsQuery, JsonpDeserializer.longDeserializer(), "dfs_query");
        op.add(Builder::expand, JsonpDeserializer.longDeserializer(), "expand");
        op.add(Builder::fetch, JsonpDeserializer.longDeserializer(), "fetch");
        op.add(Builder::query, JsonpDeserializer.longDeserializer(), "query");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Long.hashCode(this.canMatch);
        result = 31 * result + Long.hashCode(this.dfsPreQuery);
        result = 31 * result + Long.hashCode(this.dfsQuery);
        result = 31 * result + Long.hashCode(this.expand);
        result = 31 * result + Long.hashCode(this.fetch);
        result = 31 * result + Long.hashCode(this.query);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        PhaseTook other = (PhaseTook) o;
        return this.canMatch == other.canMatch
            && this.dfsPreQuery == other.dfsPreQuery
            && this.dfsQuery == other.dfsQuery
            && this.expand == other.expand
            && this.fetch == other.fetch
            && this.query == other.query;
    }
}
