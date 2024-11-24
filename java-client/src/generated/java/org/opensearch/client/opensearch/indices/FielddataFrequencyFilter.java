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

// typedef: indices.FielddataFrequencyFilter

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class FielddataFrequencyFilter
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<FielddataFrequencyFilter.Builder, FielddataFrequencyFilter> {

    private final double max;

    private final double min;

    private final int minSegmentSize;

    // ---------------------------------------------------------------------------------------------

    private FielddataFrequencyFilter(Builder builder) {
        this.max = ApiTypeHelper.requireNonNull(builder.max, this, "max");
        this.min = ApiTypeHelper.requireNonNull(builder.min, this, "min");
        this.minSegmentSize = ApiTypeHelper.requireNonNull(builder.minSegmentSize, this, "minSegmentSize");
    }

    public static FielddataFrequencyFilter of(Function<FielddataFrequencyFilter.Builder, ObjectBuilder<FielddataFrequencyFilter>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - API name: {@code max}
     */
    public final double max() {
        return this.max;
    }

    /**
     * Required - API name: {@code min}
     */
    public final double min() {
        return this.min;
    }

    /**
     * Required - API name: {@code min_segment_size}
     */
    public final int minSegmentSize() {
        return this.minSegmentSize;
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
        generator.writeKey("max");
        generator.write(this.max);

        generator.writeKey("min");
        generator.write(this.min);

        generator.writeKey("min_segment_size");
        generator.write(this.minSegmentSize);
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
     * Builder for {@link FielddataFrequencyFilter}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, FielddataFrequencyFilter> {
        private Double max;
        private Double min;
        private Integer minSegmentSize;

        public Builder() {}

        private Builder(FielddataFrequencyFilter o) {
            this.max = o.max;
            this.min = o.min;
            this.minSegmentSize = o.minSegmentSize;
        }

        private Builder(Builder o) {
            this.max = o.max;
            this.min = o.min;
            this.minSegmentSize = o.minSegmentSize;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - API name: {@code max}
         */
        @Nonnull
        public final Builder max(double value) {
            this.max = value;
            return this;
        }

        /**
         * Required - API name: {@code min}
         */
        @Nonnull
        public final Builder min(double value) {
            this.min = value;
            return this;
        }

        /**
         * Required - API name: {@code min_segment_size}
         */
        @Nonnull
        public final Builder minSegmentSize(int value) {
            this.minSegmentSize = value;
            return this;
        }

        /**
         * Builds a {@link FielddataFrequencyFilter}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public FielddataFrequencyFilter build() {
            _checkSingleUse();

            return new FielddataFrequencyFilter(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link FielddataFrequencyFilter}
     */
    public static final JsonpDeserializer<FielddataFrequencyFilter> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        FielddataFrequencyFilter::setupFielddataFrequencyFilterDeserializer
    );

    protected static void setupFielddataFrequencyFilterDeserializer(ObjectDeserializer<FielddataFrequencyFilter.Builder> op) {
        op.add(Builder::max, JsonpDeserializer.doubleDeserializer(), "max");
        op.add(Builder::min, JsonpDeserializer.doubleDeserializer(), "min");
        op.add(Builder::minSegmentSize, JsonpDeserializer.integerDeserializer(), "min_segment_size");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Double.hashCode(this.max);
        result = 31 * result + Double.hashCode(this.min);
        result = 31 * result + Integer.hashCode(this.minSegmentSize);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        FielddataFrequencyFilter other = (FielddataFrequencyFilter) o;
        return this.max == other.max && this.min == other.min && this.minSegmentSize == other.minSegmentSize;
    }
}
