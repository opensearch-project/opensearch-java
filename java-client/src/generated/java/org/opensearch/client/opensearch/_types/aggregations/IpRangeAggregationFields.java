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

package org.opensearch.client.opensearch._types.aggregations;

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
import org.opensearch.client.json.PlainJsonSerializable;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: _types.aggregations.IpRangeAggregationFields

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class IpRangeAggregationFields
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<IpRangeAggregationFields.Builder, IpRangeAggregationFields> {

    @Nullable
    private final String field;

    @Nonnull
    private final List<IpRangeAggregationRange> ranges;

    // ---------------------------------------------------------------------------------------------

    private IpRangeAggregationFields(Builder builder) {
        this.field = builder.field;
        this.ranges = ApiTypeHelper.unmodifiable(builder.ranges);
    }

    public static IpRangeAggregationFields of(Function<IpRangeAggregationFields.Builder, ObjectBuilder<IpRangeAggregationFields>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code field}
     */
    @Nullable
    public final String field() {
        return this.field;
    }

    /**
     * Array of IP ranges.
     * <p>
     * API name: {@code ranges}
     * </p>
     */
    @Nonnull
    public final List<IpRangeAggregationRange> ranges() {
        return this.ranges;
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
        if (this.field != null) {
            generator.writeKey("field");
            generator.write(this.field);
        }

        if (ApiTypeHelper.isDefined(this.ranges)) {
            generator.writeKey("ranges");
            generator.writeStartArray();
            for (IpRangeAggregationRange item0 : this.ranges) {
                item0.serialize(generator, mapper);
            }
            generator.writeEnd();
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
     * Builder for {@link IpRangeAggregationFields}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, IpRangeAggregationFields> {
        @Nullable
        private String field;
        @Nullable
        private List<IpRangeAggregationRange> ranges;

        public Builder() {}

        private Builder(IpRangeAggregationFields o) {
            this.field = o.field;
            this.ranges = _listCopy(o.ranges);
        }

        private Builder(Builder o) {
            this.field = o.field;
            this.ranges = _listCopy(o.ranges);
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code field}
         */
        @Nonnull
        public final Builder field(@Nullable String value) {
            this.field = value;
            return this;
        }

        /**
         * Array of IP ranges.
         * <p>
         * API name: {@code ranges}
         * </p>
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>ranges</code>.
         * </p>
         */
        @Nonnull
        public final Builder ranges(List<IpRangeAggregationRange> list) {
            this.ranges = _listAddAll(this.ranges, list);
            return this;
        }

        /**
         * Array of IP ranges.
         * <p>
         * API name: {@code ranges}
         * </p>
         *
         * <p>
         * Adds one or more values to <code>ranges</code>.
         * </p>
         */
        @Nonnull
        public final Builder ranges(IpRangeAggregationRange value, IpRangeAggregationRange... values) {
            this.ranges = _listAdd(this.ranges, value, values);
            return this;
        }

        /**
         * Array of IP ranges.
         * <p>
         * API name: {@code ranges}
         * </p>
         *
         * <p>
         * Adds a value to <code>ranges</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder ranges(Function<IpRangeAggregationRange.Builder, ObjectBuilder<IpRangeAggregationRange>> fn) {
            return ranges(fn.apply(new IpRangeAggregationRange.Builder()).build());
        }

        /**
         * Builds a {@link IpRangeAggregationFields}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public IpRangeAggregationFields build() {
            _checkSingleUse();

            return new IpRangeAggregationFields(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link IpRangeAggregationFields}
     */
    public static final JsonpDeserializer<IpRangeAggregationFields> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        IpRangeAggregationFields::setupIpRangeAggregationFieldsDeserializer
    );

    protected static void setupIpRangeAggregationFieldsDeserializer(ObjectDeserializer<IpRangeAggregationFields.Builder> op) {
        op.add(Builder::field, JsonpDeserializer.stringDeserializer(), "field");
        op.add(Builder::ranges, JsonpDeserializer.arrayDeserializer(IpRangeAggregationRange._DESERIALIZER), "ranges");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.field);
        result = 31 * result + Objects.hashCode(this.ranges);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        IpRangeAggregationFields other = (IpRangeAggregationFields) o;
        return Objects.equals(this.field, other.field) && Objects.equals(this.ranges, other.ranges);
    }
}
