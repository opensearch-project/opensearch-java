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

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class PhaseTook implements PlainJsonSerializable, ToCopyableBuilder<PhaseTook.Builder, PhaseTook> {

    private final int canMatch;

    private final int dfsPreQuery;

    private final int dfsQuery;

    private final int expand;

    private final int fetch;

    private final int query;

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
     * Required - API name: {@code can_match}
     */
    public final int canMatch() {
        return this.canMatch;
    }

    /**
     * Required - API name: {@code dfs_pre_query}
     */
    public final int dfsPreQuery() {
        return this.dfsPreQuery;
    }

    /**
     * Required - API name: {@code dfs_query}
     */
    public final int dfsQuery() {
        return this.dfsQuery;
    }

    /**
     * Required - API name: {@code expand}
     */
    public final int expand() {
        return this.expand;
    }

    /**
     * Required - API name: {@code fetch}
     */
    public final int fetch() {
        return this.fetch;
    }

    /**
     * Required - API name: {@code query}
     */
    public final int query() {
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
        private Integer canMatch;
        private Integer dfsPreQuery;
        private Integer dfsQuery;
        private Integer expand;
        private Integer fetch;
        private Integer query;

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
         * Required - API name: {@code can_match}
         */
        @Nonnull
        public final Builder canMatch(int value) {
            this.canMatch = value;
            return this;
        }

        /**
         * Required - API name: {@code dfs_pre_query}
         */
        @Nonnull
        public final Builder dfsPreQuery(int value) {
            this.dfsPreQuery = value;
            return this;
        }

        /**
         * Required - API name: {@code dfs_query}
         */
        @Nonnull
        public final Builder dfsQuery(int value) {
            this.dfsQuery = value;
            return this;
        }

        /**
         * Required - API name: {@code expand}
         */
        @Nonnull
        public final Builder expand(int value) {
            this.expand = value;
            return this;
        }

        /**
         * Required - API name: {@code fetch}
         */
        @Nonnull
        public final Builder fetch(int value) {
            this.fetch = value;
            return this;
        }

        /**
         * Required - API name: {@code query}
         */
        @Nonnull
        public final Builder query(int value) {
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
        op.add(Builder::canMatch, JsonpDeserializer.integerDeserializer(), "can_match");
        op.add(Builder::dfsPreQuery, JsonpDeserializer.integerDeserializer(), "dfs_pre_query");
        op.add(Builder::dfsQuery, JsonpDeserializer.integerDeserializer(), "dfs_query");
        op.add(Builder::expand, JsonpDeserializer.integerDeserializer(), "expand");
        op.add(Builder::fetch, JsonpDeserializer.integerDeserializer(), "fetch");
        op.add(Builder::query, JsonpDeserializer.integerDeserializer(), "query");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Integer.hashCode(this.canMatch);
        result = 31 * result + Integer.hashCode(this.dfsPreQuery);
        result = 31 * result + Integer.hashCode(this.dfsQuery);
        result = 31 * result + Integer.hashCode(this.expand);
        result = 31 * result + Integer.hashCode(this.fetch);
        result = 31 * result + Integer.hashCode(this.query);
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
