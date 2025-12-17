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
import org.opensearch.client.json.JsonData;
import org.opensearch.client.json.JsonpDeserializable;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.ObjectBuilderDeserializer;
import org.opensearch.client.json.ObjectDeserializer;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: _types.query_dsl.RangeQuery

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class RangeQuery extends RangeQueryBase implements QueryVariant, ToCopyableBuilder<RangeQuery.Builder, RangeQuery> {

    @Nonnull
    private final String field;

    @Nullable
    private final String format;

    @Nullable
    private final JsonData from;

    @Nullable
    private final JsonData gt;

    @Nullable
    private final JsonData gte;

    @Nullable
    private final JsonData lt;

    @Nullable
    private final JsonData lte;

    @Nullable
    private final String timeZone;

    @Nullable
    private final JsonData to;

    // ---------------------------------------------------------------------------------------------

    private RangeQuery(Builder builder) {
        super(builder);
        this.field = ApiTypeHelper.requireNonNull(builder.field, this, "field");
        this.format = builder.format;
        this.from = builder.from;
        this.gt = builder.gt;
        this.gte = builder.gte;
        this.lt = builder.lt;
        this.lte = builder.lte;
        this.timeZone = builder.timeZone;
        this.to = builder.to;
    }

    public static RangeQuery of(Function<RangeQuery.Builder, ObjectBuilder<RangeQuery>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * {@link Query} variant kind.
     */
    @Override
    public Query.Kind _queryKind() {
        return Query.Kind.Range;
    }

    /**
     * Required - The target field
     */
    @Nonnull
    public final String field() {
        return this.field;
    }

    /**
     * API name: {@code format}
     */
    @Nullable
    public final String format() {
        return this.format;
    }

    /**
     * API name: {@code from}
     */
    @Nullable
    public final JsonData from() {
        return this.from;
    }

    /**
     * API name: {@code gt}
     */
    @Nullable
    public final JsonData gt() {
        return this.gt;
    }

    /**
     * API name: {@code gte}
     */
    @Nullable
    public final JsonData gte() {
        return this.gte;
    }

    /**
     * API name: {@code lt}
     */
    @Nullable
    public final JsonData lt() {
        return this.lt;
    }

    /**
     * API name: {@code lte}
     */
    @Nullable
    public final JsonData lte() {
        return this.lte;
    }

    /**
     * API name: {@code time_zone}
     */
    @Nullable
    public final String timeZone() {
        return this.timeZone;
    }

    /**
     * API name: {@code to}
     */
    @Nullable
    public final JsonData to() {
        return this.to;
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        generator.writeStartObject(this.field);
        super.serializeInternal(generator, mapper);
        if (this.format != null) {
            generator.writeKey("format");
            generator.write(this.format);
        }

        if (this.from != null) {
            generator.writeKey("from");
            this.from.serialize(generator, mapper);
        }

        if (this.gt != null) {
            generator.writeKey("gt");
            this.gt.serialize(generator, mapper);
        }

        if (this.gte != null) {
            generator.writeKey("gte");
            this.gte.serialize(generator, mapper);
        }

        if (this.lt != null) {
            generator.writeKey("lt");
            this.lt.serialize(generator, mapper);
        }

        if (this.lte != null) {
            generator.writeKey("lte");
            this.lte.serialize(generator, mapper);
        }

        if (this.timeZone != null) {
            generator.writeKey("time_zone");
            generator.write(this.timeZone);
        }

        if (this.to != null) {
            generator.writeKey("to");
            this.to.serialize(generator, mapper);
        }
        generator.writeEnd();
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
     * Builder for {@link RangeQuery}.
     */
    public static class Builder extends RangeQueryBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, RangeQuery> {
        private String field;
        @Nullable
        private String format;
        @Nullable
        private JsonData from;
        @Nullable
        private JsonData gt;
        @Nullable
        private JsonData gte;
        @Nullable
        private JsonData lt;
        @Nullable
        private JsonData lte;
        @Nullable
        private String timeZone;
        @Nullable
        private JsonData to;

        public Builder() {}

        private Builder(RangeQuery o) {
            super(o);
            this.field = o.field;
            this.format = o.format;
            this.from = o.from;
            this.gt = o.gt;
            this.gte = o.gte;
            this.lt = o.lt;
            this.lte = o.lte;
            this.timeZone = o.timeZone;
            this.to = o.to;
        }

        private Builder(Builder o) {
            super(o);
            this.field = o.field;
            this.format = o.format;
            this.from = o.from;
            this.gt = o.gt;
            this.gte = o.gte;
            this.lt = o.lt;
            this.lte = o.lte;
            this.timeZone = o.timeZone;
            this.to = o.to;
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
         * Required - The target field
         */
        @Nonnull
        public final Builder field(String value) {
            this.field = value;
            return this;
        }

        /**
         * API name: {@code format}
         */
        @Nonnull
        public final Builder format(@Nullable String value) {
            this.format = value;
            return this;
        }

        /**
         * API name: {@code from}
         */
        @Nonnull
        public final Builder from(@Nullable JsonData value) {
            this.from = value;
            return this;
        }

        /**
         * API name: {@code gt}
         */
        @Nonnull
        public final Builder gt(@Nullable JsonData value) {
            this.gt = value;
            return this;
        }

        /**
         * API name: {@code gte}
         */
        @Nonnull
        public final Builder gte(@Nullable JsonData value) {
            this.gte = value;
            return this;
        }

        /**
         * API name: {@code lt}
         */
        @Nonnull
        public final Builder lt(@Nullable JsonData value) {
            this.lt = value;
            return this;
        }

        /**
         * API name: {@code lte}
         */
        @Nonnull
        public final Builder lte(@Nullable JsonData value) {
            this.lte = value;
            return this;
        }

        /**
         * API name: {@code time_zone}
         */
        @Nonnull
        public final Builder timeZone(@Nullable String value) {
            this.timeZone = value;
            return this;
        }

        /**
         * API name: {@code to}
         */
        @Nonnull
        public final Builder to(@Nullable JsonData value) {
            this.to = value;
            return this;
        }

        /**
         * Builds a {@link RangeQuery}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public RangeQuery build() {
            _checkSingleUse();

            return new RangeQuery(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link RangeQuery}
     */
    public static final JsonpDeserializer<RangeQuery> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        RangeQuery::setupRangeQueryDeserializer
    );

    protected static void setupRangeQueryDeserializer(ObjectDeserializer<RangeQuery.Builder> op) {
        setupRangeQueryBaseDeserializer(op);
        op.add(Builder::format, JsonpDeserializer.stringDeserializer(), "format");
        op.add(Builder::from, JsonData._DESERIALIZER, "from");
        op.add(Builder::gt, JsonData._DESERIALIZER, "gt");
        op.add(Builder::gte, JsonData._DESERIALIZER, "gte");
        op.add(Builder::lt, JsonData._DESERIALIZER, "lt");
        op.add(Builder::lte, JsonData._DESERIALIZER, "lte");
        op.add(Builder::timeZone, JsonpDeserializer.stringDeserializer(), "time_zone");
        op.add(Builder::to, JsonData._DESERIALIZER, "to");
        op.setKey(Builder::field, JsonpDeserializer.stringDeserializer());
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + this.field.hashCode();
        result = 31 * result + Objects.hashCode(this.format);
        result = 31 * result + Objects.hashCode(this.from);
        result = 31 * result + Objects.hashCode(this.gt);
        result = 31 * result + Objects.hashCode(this.gte);
        result = 31 * result + Objects.hashCode(this.lt);
        result = 31 * result + Objects.hashCode(this.lte);
        result = 31 * result + Objects.hashCode(this.timeZone);
        result = 31 * result + Objects.hashCode(this.to);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        RangeQuery other = (RangeQuery) o;
        return this.field.equals(other.field)
            && Objects.equals(this.format, other.format)
            && Objects.equals(this.from, other.from)
            && Objects.equals(this.gt, other.gt)
            && Objects.equals(this.gte, other.gte)
            && Objects.equals(this.lt, other.lt)
            && Objects.equals(this.lte, other.lte)
            && Objects.equals(this.timeZone, other.timeZone)
            && Objects.equals(this.to, other.to);
    }
}
