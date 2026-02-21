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

package org.opensearch.client.opensearch._types.query_dsl;

import jakarta.json.stream.JsonGenerator;
import java.util.List;
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
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: _types.query_dsl.AgenticQuery

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class AgenticQuery extends QueryBase implements QueryVariant, ToCopyableBuilder<AgenticQuery.Builder, AgenticQuery> {

    @Nonnull
    private final String queryText;

    @Nonnull
    private final List<String> queryFields;

    @Nullable
    private final String memoryId;

    // ---------------------------------------------------------------------------------------------

    private AgenticQuery(Builder builder) {
        super(builder);
        this.queryText = ApiTypeHelper.requireNonNull(builder.queryText, this, "queryText");
        this.queryFields = ApiTypeHelper.unmodifiable(builder.queryFields);
        this.memoryId = builder.memoryId;
    }

    public static AgenticQuery of(Function<AgenticQuery.Builder, ObjectBuilder<AgenticQuery>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * {@link Query} variant kind.
     */
    @Override
    public Query.Kind _queryKind() {
        return Query.Kind.Agentic;
    }

    /**
     * Required - The natural language question.
     * <p>
     * API name: {@code query_text}
     * </p>
     */
    @Nonnull
    public final String queryText() {
        return this.queryText;
    }

    /**
     * Index fields the agent should consider.
     * <p>
     * API name: {@code query_fields}
     * </p>
     */
    @Nonnull
    public final List<String> queryFields() {
        return this.queryFields;
    }

    /**
     * Memory ID for conversational context.
     * <p>
     * API name: {@code memory_id}
     * </p>
     */
    @Nullable
    public final String memoryId() {
        return this.memoryId;
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        super.serializeInternal(generator, mapper);
        generator.writeKey("query_text");
        generator.write(this.queryText);

        if (ApiTypeHelper.isDefined(this.queryFields)) {
            generator.writeKey("query_fields");
            generator.writeStartArray();
            for (String item0 : this.queryFields) {
                generator.write(item0);
            }
            generator.writeEnd();
        }

        if (this.memoryId != null) {
            generator.writeKey("memory_id");
            generator.write(this.memoryId);
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
     * Builder for {@link AgenticQuery}.
     */
    public static class Builder extends QueryBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, AgenticQuery> {
        private String queryText;
        @Nullable
        private List<String> queryFields;
        @Nullable
        private String memoryId;

        public Builder() {}

        private Builder(AgenticQuery o) {
            super(o);
            this.queryText = o.queryText;
            this.queryFields = _listCopy(o.queryFields);
            this.memoryId = o.memoryId;
        }

        private Builder(Builder o) {
            super(o);
            this.queryText = o.queryText;
            this.queryFields = _listCopy(o.queryFields);
            this.memoryId = o.memoryId;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        @Override
        @Nonnull
        protected Builder self() {
            return this;
        }

        /**
         * Required - The natural language question.
         * <p>
         * API name: {@code query_text}
         * </p>
         */
        @Nonnull
        public final Builder queryText(String value) {
            this.queryText = value;
            return this;
        }

        /**
         * Index fields the agent should consider.
         * <p>
         * API name: {@code query_fields}
         * </p>
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>queryFields</code>.
         * </p>
         */
        @Nonnull
        public final Builder queryFields(List<String> list) {
            this.queryFields = _listAddAll(this.queryFields, list);
            return this;
        }

        /**
         * Index fields the agent should consider.
         * <p>
         * API name: {@code query_fields}
         * </p>
         *
         * <p>
         * Adds one or more values to <code>queryFields</code>.
         * </p>
         */
        @Nonnull
        public final Builder queryFields(String value, String... values) {
            this.queryFields = _listAdd(this.queryFields, value, values);
            return this;
        }

        /**
         * Memory ID for conversational context.
         * <p>
         * API name: {@code memory_id}
         * </p>
         */
        @Nonnull
        public final Builder memoryId(@Nullable String value) {
            this.memoryId = value;
            return this;
        }

        /**
         * Builds a {@link AgenticQuery}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public AgenticQuery build() {
            _checkSingleUse();

            return new AgenticQuery(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link AgenticQuery}
     */
    public static final JsonpDeserializer<AgenticQuery> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        AgenticQuery::setupAgenticQueryDeserializer
    );

    protected static void setupAgenticQueryDeserializer(ObjectDeserializer<AgenticQuery.Builder> op) {
        setupQueryBaseDeserializer(op);
        op.add(Builder::queryText, JsonpDeserializer.stringDeserializer(), "query_text");
        op.add(Builder::queryFields, JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()), "query_fields");
        op.add(Builder::memoryId, JsonpDeserializer.stringDeserializer(), "memory_id");
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + this.queryText.hashCode();
        result = 31 * result + Objects.hashCode(this.queryFields);
        result = 31 * result + Objects.hashCode(this.memoryId);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        AgenticQuery other = (AgenticQuery) o;
        return this.queryText.equals(other.queryText)
            && Objects.equals(this.queryFields, other.queryFields)
            && Objects.equals(this.memoryId, other.memoryId);
    }
}
