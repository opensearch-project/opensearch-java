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

// typedef: indices.IndexSettingsStarTreeFieldDefault

/**
 * The field-specific settings for star tree indexing.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class IndexSettingsStarTreeFieldDefault
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<IndexSettingsStarTreeFieldDefault.Builder, IndexSettingsStarTreeFieldDefault> {

    @Nonnull
    private final List<String> dateIntervals;

    @Nonnull
    private final List<String> metrics;

    // ---------------------------------------------------------------------------------------------

    private IndexSettingsStarTreeFieldDefault(Builder builder) {
        this.dateIntervals = ApiTypeHelper.unmodifiable(builder.dateIntervals);
        this.metrics = ApiTypeHelper.unmodifiable(builder.metrics);
    }

    public static IndexSettingsStarTreeFieldDefault of(
        Function<IndexSettingsStarTreeFieldDefault.Builder, ObjectBuilder<IndexSettingsStarTreeFieldDefault>> fn
    ) {
        return fn.apply(new Builder()).build();
    }

    /**
     * The list of date intervals to use.
     * <p>
     * API name: {@code date_intervals}
     * </p>
     */
    @Nonnull
    public final List<String> dateIntervals() {
        return this.dateIntervals;
    }

    /**
     * The list of metrics to calculate.
     * <p>
     * API name: {@code metrics}
     * </p>
     */
    @Nonnull
    public final List<String> metrics() {
        return this.metrics;
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
        if (ApiTypeHelper.isDefined(this.dateIntervals)) {
            generator.writeKey("date_intervals");
            generator.writeStartArray();
            for (String item0 : this.dateIntervals) {
                generator.write(item0);
            }
            generator.writeEnd();
        }

        if (ApiTypeHelper.isDefined(this.metrics)) {
            generator.writeKey("metrics");
            generator.writeStartArray();
            for (String item0 : this.metrics) {
                generator.write(item0);
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
     * Builder for {@link IndexSettingsStarTreeFieldDefault}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, IndexSettingsStarTreeFieldDefault> {
        @Nullable
        private List<String> dateIntervals;
        @Nullable
        private List<String> metrics;

        public Builder() {}

        private Builder(IndexSettingsStarTreeFieldDefault o) {
            this.dateIntervals = _listCopy(o.dateIntervals);
            this.metrics = _listCopy(o.metrics);
        }

        private Builder(Builder o) {
            this.dateIntervals = _listCopy(o.dateIntervals);
            this.metrics = _listCopy(o.metrics);
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * The list of date intervals to use.
         * <p>
         * API name: {@code date_intervals}
         * </p>
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>dateIntervals</code>.
         * </p>
         */
        @Nonnull
        public final Builder dateIntervals(List<String> list) {
            this.dateIntervals = _listAddAll(this.dateIntervals, list);
            return this;
        }

        /**
         * The list of date intervals to use.
         * <p>
         * API name: {@code date_intervals}
         * </p>
         *
         * <p>
         * Adds one or more values to <code>dateIntervals</code>.
         * </p>
         */
        @Nonnull
        public final Builder dateIntervals(String value, String... values) {
            this.dateIntervals = _listAdd(this.dateIntervals, value, values);
            return this;
        }

        /**
         * The list of metrics to calculate.
         * <p>
         * API name: {@code metrics}
         * </p>
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>metrics</code>.
         * </p>
         */
        @Nonnull
        public final Builder metrics(List<String> list) {
            this.metrics = _listAddAll(this.metrics, list);
            return this;
        }

        /**
         * The list of metrics to calculate.
         * <p>
         * API name: {@code metrics}
         * </p>
         *
         * <p>
         * Adds one or more values to <code>metrics</code>.
         * </p>
         */
        @Nonnull
        public final Builder metrics(String value, String... values) {
            this.metrics = _listAdd(this.metrics, value, values);
            return this;
        }

        /**
         * Builds a {@link IndexSettingsStarTreeFieldDefault}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public IndexSettingsStarTreeFieldDefault build() {
            _checkSingleUse();

            return new IndexSettingsStarTreeFieldDefault(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link IndexSettingsStarTreeFieldDefault}
     */
    public static final JsonpDeserializer<IndexSettingsStarTreeFieldDefault> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        IndexSettingsStarTreeFieldDefault::setupIndexSettingsStarTreeFieldDefaultDeserializer
    );

    protected static void setupIndexSettingsStarTreeFieldDefaultDeserializer(
        ObjectDeserializer<IndexSettingsStarTreeFieldDefault.Builder> op
    ) {
        op.add(Builder::dateIntervals, JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()), "date_intervals");
        op.add(Builder::metrics, JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()), "metrics");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.dateIntervals);
        result = 31 * result + Objects.hashCode(this.metrics);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        IndexSettingsStarTreeFieldDefault other = (IndexSettingsStarTreeFieldDefault) o;
        return Objects.equals(this.dateIntervals, other.dateIntervals) && Objects.equals(this.metrics, other.metrics);
    }
}
