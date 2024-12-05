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
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: _types.query_dsl.ParentIdQuery

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class ParentIdQuery extends QueryBase implements QueryVariant, ToCopyableBuilder<ParentIdQuery.Builder, ParentIdQuery> {

    @Nullable
    private final String id;

    @Nullable
    private final Boolean ignoreUnmapped;

    @Nullable
    private final String type;

    // ---------------------------------------------------------------------------------------------

    private ParentIdQuery(Builder builder) {
        super(builder);
        this.id = builder.id;
        this.ignoreUnmapped = builder.ignoreUnmapped;
        this.type = builder.type;
    }

    public static ParentIdQuery of(Function<ParentIdQuery.Builder, ObjectBuilder<ParentIdQuery>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * {@link Query} variant kind.
     */
    @Override
    public Query.Kind _queryKind() {
        return Query.Kind.ParentId;
    }

    /**
     * API name: {@code id}
     */
    @Nullable
    public final String id() {
        return this.id;
    }

    /**
     * Indicates whether to ignore an unmapped <code>type</code> and not return any documents instead of an error.
     * <p>
     * API name: {@code ignore_unmapped}
     * </p>
     */
    @Nullable
    public final Boolean ignoreUnmapped() {
        return this.ignoreUnmapped;
    }

    /**
     * API name: {@code type}
     */
    @Nullable
    public final String type() {
        return this.type;
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        super.serializeInternal(generator, mapper);
        if (this.id != null) {
            generator.writeKey("id");
            generator.write(this.id);
        }

        if (this.ignoreUnmapped != null) {
            generator.writeKey("ignore_unmapped");
            generator.write(this.ignoreUnmapped);
        }

        if (this.type != null) {
            generator.writeKey("type");
            generator.write(this.type);
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
     * Builder for {@link ParentIdQuery}.
     */
    public static class Builder extends QueryBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, ParentIdQuery> {
        @Nullable
        private String id;
        @Nullable
        private Boolean ignoreUnmapped;
        @Nullable
        private String type;

        public Builder() {}

        private Builder(ParentIdQuery o) {
            super(o);
            this.id = o.id;
            this.ignoreUnmapped = o.ignoreUnmapped;
            this.type = o.type;
        }

        private Builder(Builder o) {
            super(o);
            this.id = o.id;
            this.ignoreUnmapped = o.ignoreUnmapped;
            this.type = o.type;
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
         * API name: {@code id}
         */
        @Nonnull
        public final Builder id(@Nullable String value) {
            this.id = value;
            return this;
        }

        /**
         * Indicates whether to ignore an unmapped <code>type</code> and not return any documents instead of an error.
         * <p>
         * API name: {@code ignore_unmapped}
         * </p>
         */
        @Nonnull
        public final Builder ignoreUnmapped(@Nullable Boolean value) {
            this.ignoreUnmapped = value;
            return this;
        }

        /**
         * API name: {@code type}
         */
        @Nonnull
        public final Builder type(@Nullable String value) {
            this.type = value;
            return this;
        }

        /**
         * Builds a {@link ParentIdQuery}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public ParentIdQuery build() {
            _checkSingleUse();

            return new ParentIdQuery(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link ParentIdQuery}
     */
    public static final JsonpDeserializer<ParentIdQuery> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        ParentIdQuery::setupParentIdQueryDeserializer
    );

    protected static void setupParentIdQueryDeserializer(ObjectDeserializer<ParentIdQuery.Builder> op) {
        setupQueryBaseDeserializer(op);
        op.add(Builder::id, JsonpDeserializer.stringDeserializer(), "id");
        op.add(Builder::ignoreUnmapped, JsonpDeserializer.booleanDeserializer(), "ignore_unmapped");
        op.add(Builder::type, JsonpDeserializer.stringDeserializer(), "type");
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Objects.hashCode(this.id);
        result = 31 * result + Objects.hashCode(this.ignoreUnmapped);
        result = 31 * result + Objects.hashCode(this.type);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        ParentIdQuery other = (ParentIdQuery) o;
        return Objects.equals(this.id, other.id)
            && Objects.equals(this.ignoreUnmapped, other.ignoreUnmapped)
            && Objects.equals(this.type, other.type);
    }
}
