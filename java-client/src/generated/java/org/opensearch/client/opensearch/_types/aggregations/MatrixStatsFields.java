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
import java.util.Map;
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

// typedef: _types.aggregations.MatrixStatsFields

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class MatrixStatsFields implements PlainJsonSerializable, ToCopyableBuilder<MatrixStatsFields.Builder, MatrixStatsFields> {

    @Nonnull
    private final Map<String, Double> correlation;

    private final long count;

    @Nonnull
    private final Map<String, Double> covariance;

    private final double kurtosis;

    private final double mean;

    @Nonnull
    private final String name;

    private final double skewness;

    private final double variance;

    // ---------------------------------------------------------------------------------------------

    private MatrixStatsFields(Builder builder) {
        this.correlation = ApiTypeHelper.unmodifiableRequired(builder.correlation, this, "correlation");
        this.count = ApiTypeHelper.requireNonNull(builder.count, this, "count");
        this.covariance = ApiTypeHelper.unmodifiableRequired(builder.covariance, this, "covariance");
        this.kurtosis = ApiTypeHelper.requireNonNull(builder.kurtosis, this, "kurtosis");
        this.mean = ApiTypeHelper.requireNonNull(builder.mean, this, "mean");
        this.name = ApiTypeHelper.requireNonNull(builder.name, this, "name");
        this.skewness = ApiTypeHelper.requireNonNull(builder.skewness, this, "skewness");
        this.variance = ApiTypeHelper.requireNonNull(builder.variance, this, "variance");
    }

    public static MatrixStatsFields of(Function<MatrixStatsFields.Builder, ObjectBuilder<MatrixStatsFields>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - API name: {@code correlation}
     */
    @Nonnull
    public final Map<String, Double> correlation() {
        return this.correlation;
    }

    /**
     * Required - API name: {@code count}
     */
    public final long count() {
        return this.count;
    }

    /**
     * Required - API name: {@code covariance}
     */
    @Nonnull
    public final Map<String, Double> covariance() {
        return this.covariance;
    }

    /**
     * Required - API name: {@code kurtosis}
     */
    public final double kurtosis() {
        return this.kurtosis;
    }

    /**
     * Required - API name: {@code mean}
     */
    public final double mean() {
        return this.mean;
    }

    /**
     * Required - API name: {@code name}
     */
    @Nonnull
    public final String name() {
        return this.name;
    }

    /**
     * Required - API name: {@code skewness}
     */
    public final double skewness() {
        return this.skewness;
    }

    /**
     * Required - API name: {@code variance}
     */
    public final double variance() {
        return this.variance;
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
        generator.writeKey("correlation");
        generator.writeStartObject();
        for (Map.Entry<String, Double> item0 : this.correlation.entrySet()) {
            generator.writeKey(item0.getKey());
            generator.write(item0.getValue());
        }
        generator.writeEnd();

        generator.writeKey("count");
        generator.write(this.count);

        generator.writeKey("covariance");
        generator.writeStartObject();
        for (Map.Entry<String, Double> item0 : this.covariance.entrySet()) {
            generator.writeKey(item0.getKey());
            generator.write(item0.getValue());
        }
        generator.writeEnd();

        generator.writeKey("kurtosis");
        generator.write(this.kurtosis);

        generator.writeKey("mean");
        generator.write(this.mean);

        generator.writeKey("name");
        generator.write(this.name);

        generator.writeKey("skewness");
        generator.write(this.skewness);

        generator.writeKey("variance");
        generator.write(this.variance);
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
     * Builder for {@link MatrixStatsFields}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, MatrixStatsFields> {
        private Map<String, Double> correlation;
        private Long count;
        private Map<String, Double> covariance;
        private Double kurtosis;
        private Double mean;
        private String name;
        private Double skewness;
        private Double variance;

        public Builder() {}

        private Builder(MatrixStatsFields o) {
            this.correlation = _mapCopy(o.correlation);
            this.count = o.count;
            this.covariance = _mapCopy(o.covariance);
            this.kurtosis = o.kurtosis;
            this.mean = o.mean;
            this.name = o.name;
            this.skewness = o.skewness;
            this.variance = o.variance;
        }

        private Builder(Builder o) {
            this.correlation = _mapCopy(o.correlation);
            this.count = o.count;
            this.covariance = _mapCopy(o.covariance);
            this.kurtosis = o.kurtosis;
            this.mean = o.mean;
            this.name = o.name;
            this.skewness = o.skewness;
            this.variance = o.variance;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - API name: {@code correlation}
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>correlation</code>.
         * </p>
         */
        @Nonnull
        public final Builder correlation(Map<String, Double> map) {
            this.correlation = _mapPutAll(this.correlation, map);
            return this;
        }

        /**
         * Required - API name: {@code correlation}
         *
         * <p>
         * Adds an entry to <code>correlation</code>.
         * </p>
         */
        @Nonnull
        public final Builder correlation(String key, Double value) {
            this.correlation = _mapPut(this.correlation, key, value);
            return this;
        }

        /**
         * Required - API name: {@code count}
         */
        @Nonnull
        public final Builder count(long value) {
            this.count = value;
            return this;
        }

        /**
         * Required - API name: {@code covariance}
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>covariance</code>.
         * </p>
         */
        @Nonnull
        public final Builder covariance(Map<String, Double> map) {
            this.covariance = _mapPutAll(this.covariance, map);
            return this;
        }

        /**
         * Required - API name: {@code covariance}
         *
         * <p>
         * Adds an entry to <code>covariance</code>.
         * </p>
         */
        @Nonnull
        public final Builder covariance(String key, Double value) {
            this.covariance = _mapPut(this.covariance, key, value);
            return this;
        }

        /**
         * Required - API name: {@code kurtosis}
         */
        @Nonnull
        public final Builder kurtosis(double value) {
            this.kurtosis = value;
            return this;
        }

        /**
         * Required - API name: {@code mean}
         */
        @Nonnull
        public final Builder mean(double value) {
            this.mean = value;
            return this;
        }

        /**
         * Required - API name: {@code name}
         */
        @Nonnull
        public final Builder name(String value) {
            this.name = value;
            return this;
        }

        /**
         * Required - API name: {@code skewness}
         */
        @Nonnull
        public final Builder skewness(double value) {
            this.skewness = value;
            return this;
        }

        /**
         * Required - API name: {@code variance}
         */
        @Nonnull
        public final Builder variance(double value) {
            this.variance = value;
            return this;
        }

        /**
         * Builds a {@link MatrixStatsFields}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public MatrixStatsFields build() {
            _checkSingleUse();

            return new MatrixStatsFields(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link MatrixStatsFields}
     */
    public static final JsonpDeserializer<MatrixStatsFields> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        MatrixStatsFields::setupMatrixStatsFieldsDeserializer
    );

    protected static void setupMatrixStatsFieldsDeserializer(ObjectDeserializer<MatrixStatsFields.Builder> op) {
        op.add(Builder::correlation, JsonpDeserializer.stringMapDeserializer(JsonpDeserializer.doubleDeserializer()), "correlation");
        op.add(Builder::count, JsonpDeserializer.longDeserializer(), "count");
        op.add(Builder::covariance, JsonpDeserializer.stringMapDeserializer(JsonpDeserializer.doubleDeserializer()), "covariance");
        op.add(Builder::kurtosis, JsonpDeserializer.doubleDeserializer(), "kurtosis");
        op.add(Builder::mean, JsonpDeserializer.doubleDeserializer(), "mean");
        op.add(Builder::name, JsonpDeserializer.stringDeserializer(), "name");
        op.add(Builder::skewness, JsonpDeserializer.doubleDeserializer(), "skewness");
        op.add(Builder::variance, JsonpDeserializer.doubleDeserializer(), "variance");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.correlation.hashCode();
        result = 31 * result + Long.hashCode(this.count);
        result = 31 * result + this.covariance.hashCode();
        result = 31 * result + Double.hashCode(this.kurtosis);
        result = 31 * result + Double.hashCode(this.mean);
        result = 31 * result + this.name.hashCode();
        result = 31 * result + Double.hashCode(this.skewness);
        result = 31 * result + Double.hashCode(this.variance);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        MatrixStatsFields other = (MatrixStatsFields) o;
        return this.correlation.equals(other.correlation)
            && this.count == other.count
            && this.covariance.equals(other.covariance)
            && this.kurtosis == other.kurtosis
            && this.mean == other.mean
            && this.name.equals(other.name)
            && this.skewness == other.skewness
            && this.variance == other.variance;
    }
}
