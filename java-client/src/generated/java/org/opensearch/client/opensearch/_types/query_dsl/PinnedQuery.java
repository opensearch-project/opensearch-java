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
import org.opensearch.client.json.JsonEnum;
import org.opensearch.client.json.JsonpDeserializable;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.JsonpSerializable;
import org.opensearch.client.json.ObjectBuilderDeserializer;
import org.opensearch.client.json.ObjectDeserializer;
import org.opensearch.client.json.PlainJsonSerializable;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.TaggedUnion;
import org.opensearch.client.util.TaggedUnionUtils;

// typedef: _types.query_dsl.PinnedQuery

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class PinnedQuery extends QueryBase implements TaggedUnion<PinnedQuery.Kind, Object>, QueryVariant, PlainJsonSerializable {
    /**
     * {@link PinnedQuery} variant kinds.
     */
    public enum Kind implements JsonEnum {
        Docs("docs"),
        Ids("ids");

        private final String jsonValue;

        Kind(String jsonValue) {
            this.jsonValue = jsonValue;
        }

        @Override
        public String jsonValue() {
            return jsonValue;
        }
    }

    /**
     * {@link Query} variant kind.
     */
    @Override
    public Query.Kind _queryKind() {
        return Query.Kind.Pinned;
    }

    private final Kind _kind;
    private final Object _value;

    @Override
    public final Kind _kind() {
        return _kind;
    }

    @Override
    public final Object _get() {
        return _value;
    }

    @Nonnull
    private final Query organic;

    private PinnedQuery(Builder builder) {
        super(builder);
        this.organic = ApiTypeHelper.requireNonNull(builder.organic, this, "organic");
        this._kind = ApiTypeHelper.requireNonNull(builder._kind, builder, "<variant kind>");
        this._value = ApiTypeHelper.requireNonNull(builder._value, builder, "<variant value>");
    }

    public static PinnedQuery of(Function<PinnedQuery.Builder, ObjectBuilder<PinnedQuery>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - API name: {@code organic}
     */
    @Nonnull
    public final Query organic() {
        return this.organic;
    }

    /**
     * Is this variant instance of kind {@code docs}?
     */
    public boolean isDocs() {
        return _kind == Kind.Docs;
    }

    /**
     * Get the {@code docs} variant value.
     *
     * @throws IllegalStateException if the current variant is not the {@code docs} kind.
     */
    public List<PinnedDoc> docs() {
        return TaggedUnionUtils.get(this, Kind.Docs);
    }

    /**
     * Is this variant instance of kind {@code ids}?
     */
    public boolean isIds() {
        return _kind == Kind.Ids;
    }

    /**
     * Get the {@code ids} variant value.
     *
     * @throws IllegalStateException if the current variant is not the {@code ids} kind.
     */
    public List<String> ids() {
        return TaggedUnionUtils.get(this, Kind.Ids);
    }

    @Override
    public void serialize(JsonGenerator generator, JsonpMapper mapper) {
        generator.writeStartObject();
        super.serializeInternal(generator, mapper);
        generator.writeKey("organic");
        this.organic.serialize(generator, mapper);
        generator.writeKey(_kind.jsonValue());
        if (_value instanceof JsonpSerializable) {
            ((JsonpSerializable) _value).serialize(generator, mapper);
        } else {
            switch (_kind) {
                case Docs:
                    generator.writeStartArray();
                    for (PinnedDoc item0 : ((List<PinnedDoc>) this._value)) {
                        item0.serialize(generator, mapper);
                    }
                    generator.writeEnd();
                    break;
                case Ids:
                    generator.writeStartArray();
                    for (String item0 : ((List<String>) this._value)) {
                        generator.write(item0);
                    }
                    generator.writeEnd();
                    break;
            }
        }
        generator.writeEnd();
    }

    @Nonnull
    public Builder toBuilder() {
        return new Builder(this);
    }

    @Nonnull
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder extends QueryBase.AbstractBuilder<Builder> {
        private Kind _kind;
        private Object _value;
        private Query organic;

        public Builder() {}

        private Builder(PinnedQuery o) {
            super(o);
            this.organic = o.organic;
            this._kind = o._kind;
            this._value = o._value;
        }

        @Override
        @Nonnull
        protected Builder self() {
            return this;
        }

        /**
         * Required - API name: {@code organic}
         */
        @Nonnull
        public final Builder organic(Query value) {
            this.organic = value;
            return this;
        }

        /**
         * Required - API name: {@code organic}
         */
        @Nonnull
        public final Builder organic(Function<Query.Builder, ObjectBuilder<Query>> fn) {
            return organic(fn.apply(new Query.Builder()).build());
        }

        public ContainerBuilder docs(List<PinnedDoc> v) {
            this._kind = Kind.Docs;
            this._value = v;
            return new ContainerBuilder();
        }

        public ContainerBuilder ids(List<String> v) {
            this._kind = Kind.Ids;
            this._value = v;
            return new ContainerBuilder();
        }

        protected PinnedQuery build() {
            _checkSingleUse();
            return new PinnedQuery(this);
        }

        public class ContainerBuilder implements ObjectBuilder<PinnedQuery> {
            private ContainerBuilder() {}

            /**
             * Required - API name: {@code organic}
             */
            @Nonnull
            public final ContainerBuilder organic(Query value) {
                Builder.this.organic = value;
                return this;
            }

            /**
             * Required - API name: {@code organic}
             */
            @Nonnull
            public final ContainerBuilder organic(Function<Query.Builder, ObjectBuilder<Query>> fn) {
                return organic(fn.apply(new Query.Builder()).build());
            }

            @Override
            public PinnedQuery build() {
                return Builder.this.build();
            }
        }
    }

    protected static void setupPinnedQueryDeserializer(ObjectDeserializer<Builder> op) {
        setupQueryBaseDeserializer(op);
        op.add(Builder::organic, Query._DESERIALIZER, "organic");
        op.add(Builder::docs, JsonpDeserializer.arrayDeserializer(PinnedDoc._DESERIALIZER), "docs");
        op.add(Builder::ids, JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()), "ids");
    }

    public static final JsonpDeserializer<PinnedQuery> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        PinnedQuery::setupPinnedQueryDeserializer,
        Builder::build
    );

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Objects.hashCode(this._kind);
        result = 31 * result + Objects.hashCode(this._value);
        result = 31 * result + this.organic.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        PinnedQuery other = (PinnedQuery) o;
        return Objects.equals(this._kind, other._kind) && Objects.equals(this._value, other._value) && this.organic.equals(other.organic);
    }
}
