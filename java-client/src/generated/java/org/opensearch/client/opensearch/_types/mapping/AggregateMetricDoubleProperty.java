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

package org.opensearch.client.opensearch._types.mapping;

import jakarta.json.stream.JsonGenerator;
import java.util.List;
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import org.opensearch.client.json.JsonpDeserializable;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.ObjectBuilderDeserializer;
import org.opensearch.client.json.ObjectDeserializer;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: _types.mapping.AggregateMetricDoubleProperty

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class AggregateMetricDoubleProperty extends PropertyBase
    implements
        PropertyVariant,
        ToCopyableBuilder<AggregateMetricDoubleProperty.Builder, AggregateMetricDoubleProperty> {

    @Nonnull
    private final String defaultMetric;

    @Nonnull
    private final List<String> metrics;

    // ---------------------------------------------------------------------------------------------

    private AggregateMetricDoubleProperty(Builder builder) {
        super(builder);
        this.defaultMetric = ApiTypeHelper.requireNonNull(builder.defaultMetric, this, "defaultMetric");
        this.metrics = ApiTypeHelper.unmodifiableRequired(builder.metrics, this, "metrics");
    }

    public static AggregateMetricDoubleProperty of(
        Function<AggregateMetricDoubleProperty.Builder, ObjectBuilder<AggregateMetricDoubleProperty>> fn
    ) {
        return fn.apply(new Builder()).build();
    }

    /**
     * {@link Property} variant kind.
     */
    @Override
    public Property.Kind _propertyKind() {
        return Property.Kind.AggregateMetricDouble;
    }

    /**
     * Required - API name: {@code default_metric}
     */
    @Nonnull
    public final String defaultMetric() {
        return this.defaultMetric;
    }

    /**
     * Required - API name: {@code metrics}
     */
    @Nonnull
    public final List<String> metrics() {
        return this.metrics;
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        generator.write("type", "aggregate_metric_double");
        super.serializeInternal(generator, mapper);
        generator.writeKey("default_metric");
        generator.write(this.defaultMetric);

        generator.writeKey("metrics");
        generator.writeStartArray();
        for (String item0 : this.metrics) {
            generator.write(item0);
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
     * Builder for {@link AggregateMetricDoubleProperty}.
     */
    public static class Builder extends PropertyBase.AbstractBuilder<Builder>
        implements
            CopyableBuilder<Builder, AggregateMetricDoubleProperty> {
        private String defaultMetric;
        private List<String> metrics;

        public Builder() {}

        private Builder(AggregateMetricDoubleProperty o) {
            super(o);
            this.defaultMetric = o.defaultMetric;
            this.metrics = _listCopy(o.metrics);
        }

        private Builder(Builder o) {
            super(o);
            this.defaultMetric = o.defaultMetric;
            this.metrics = _listCopy(o.metrics);
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
         * Required - API name: {@code default_metric}
         */
        @Nonnull
        public final Builder defaultMetric(String value) {
            this.defaultMetric = value;
            return this;
        }

        /**
         * Required - API name: {@code metrics}
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
         * Required - API name: {@code metrics}
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
         * Builds a {@link AggregateMetricDoubleProperty}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public AggregateMetricDoubleProperty build() {
            _checkSingleUse();

            return new AggregateMetricDoubleProperty(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link AggregateMetricDoubleProperty}
     */
    public static final JsonpDeserializer<AggregateMetricDoubleProperty> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        AggregateMetricDoubleProperty::setupAggregateMetricDoublePropertyDeserializer
    );

    protected static void setupAggregateMetricDoublePropertyDeserializer(ObjectDeserializer<AggregateMetricDoubleProperty.Builder> op) {
        setupPropertyBaseDeserializer(op);
        op.add(Builder::defaultMetric, JsonpDeserializer.stringDeserializer(), "default_metric");
        op.add(Builder::metrics, JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()), "metrics");

        op.ignore("type");
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + this.defaultMetric.hashCode();
        result = 31 * result + this.metrics.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        AggregateMetricDoubleProperty other = (AggregateMetricDoubleProperty) o;
        return this.defaultMetric.equals(other.defaultMetric) && this.metrics.equals(other.metrics);
    }
}
