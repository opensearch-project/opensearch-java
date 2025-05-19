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

// typedef: _types.query_dsl.SpanGapQuery

/**
 * Can only be used as a clause in a <code>span_near</code> query.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class SpanGapQuery implements SpanQueryVariant, PlainJsonSerializable, ToCopyableBuilder<SpanGapQuery.Builder, SpanGapQuery> {

    @Nonnull
    private final String field;

    private final int spanWidth;

    // ---------------------------------------------------------------------------------------------

    private SpanGapQuery(Builder builder) {
        this.field = ApiTypeHelper.requireNonNull(builder.field, this, "field");
        this.spanWidth = ApiTypeHelper.requireNonNull(builder.spanWidth, this, "spanWidth");
    }

    public static SpanGapQuery of(Function<SpanGapQuery.Builder, ObjectBuilder<SpanGapQuery>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * {@link SpanQuery} variant kind.
     */
    @Override
    public SpanQuery.Kind _spanQueryKind() {
        return SpanQuery.Kind.SpanGap;
    }

    /**
     * Required - The path to a field or an array of paths. Some APIs support wildcards in the path, which allows you to select multiple
     * fields.
     */
    @Nonnull
    public final String field() {
        return this.field;
    }

    /**
     * Required -
     */
    public final int spanWidth() {
        return this.spanWidth;
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
        generator.writeKey(this.field);
        generator.write(this.spanWidth);
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
     * Builder for {@link SpanGapQuery}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, SpanGapQuery> {
        private String field;
        private Integer spanWidth;

        public Builder() {}

        private Builder(SpanGapQuery o) {
            this.field = o.field;
            this.spanWidth = o.spanWidth;
        }

        private Builder(Builder o) {
            this.field = o.field;
            this.spanWidth = o.spanWidth;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - The path to a field or an array of paths. Some APIs support wildcards in the path, which allows you to select multiple
         * fields.
         */
        @Nonnull
        public final Builder field(String value) {
            this.field = value;
            return this;
        }

        /**
         * Required -
         */
        @Nonnull
        public final Builder spanWidth(int value) {
            this.spanWidth = value;
            return this;
        }

        /**
         * Builds a {@link SpanGapQuery}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public SpanGapQuery build() {
            _checkSingleUse();

            return new SpanGapQuery(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link SpanGapQuery}
     */
    public static final JsonpDeserializer<SpanGapQuery> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        SpanGapQuery::setupSpanGapQueryDeserializer
    );

    protected static void setupSpanGapQueryDeserializer(ObjectDeserializer<SpanGapQuery.Builder> op) {
        op.setUnknownFieldHandler((builder, name, parser, mapper) -> {
            builder.field(name);
            builder.spanWidth(JsonpDeserializer.integerDeserializer().deserialize(parser, mapper));
        });
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.field.hashCode();
        result = 31 * result + Integer.hashCode(this.spanWidth);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        SpanGapQuery other = (SpanGapQuery) o;
        return this.field.equals(other.field) && this.spanWidth == other.spanWidth;
    }
}
