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

//----------------------------------------------------
// THIS CODE IS GENERATED. MANUAL EDITS WILL BE LOST.
//----------------------------------------------------

package org.opensearch.clients.opensearch._types.mapping;

import org.opensearch.clients.json.DelegatingDeserializer;
import org.opensearch.clients.json.JsonpDeserializable;
import org.opensearch.clients.json.JsonpDeserializer;
import org.opensearch.clients.json.JsonpMapper;
import org.opensearch.clients.json.ObjectBuilderDeserializer;
import org.opensearch.clients.util.ModelTypeHelper;
import org.opensearch.clients.util.ObjectBuilder;
import jakarta.json.stream.JsonGenerator;
import java.lang.String;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

// typedef: _types.mapping.AggregateMetricDoubleProperty
@JsonpDeserializable
public class AggregateMetricDoubleProperty extends PropertyBase implements PropertyVariant {
	private final String defaultMetric;

	private final List<String> metrics;

	// ---------------------------------------------------------------------------------------------

	private AggregateMetricDoubleProperty(Builder builder) {
		super(builder);

		this.defaultMetric = ModelTypeHelper.requireNonNull(builder.defaultMetric, this, "defaultMetric");
		this.metrics = ModelTypeHelper.unmodifiableRequired(builder.metrics, this, "metrics");

	}

	public static AggregateMetricDoubleProperty of(Function<Builder, ObjectBuilder<AggregateMetricDoubleProperty>> fn) {
		return fn.apply(new Builder()).build();
	}

	/**
	 * {@link Property} variant type
	 */
	@Override
	public String _variantType() {
		return "aggregate_metric_double";
	}

	/**
	 * Required - API name: {@code default_metric}
	 */
	public final String defaultMetric() {
		return this.defaultMetric;
	}

	/**
	 * Required - API name: {@code metrics}
	 */
	public final List<String> metrics() {
		return this.metrics;
	}

	protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {

		generator.write("type", "aggregate_metric_double");
		super.serializeInternal(generator, mapper);
		generator.writeKey("default_metric");
		generator.write(this.defaultMetric);

		if (ModelTypeHelper.isDefined(this.metrics)) {
			generator.writeKey("metrics");
			generator.writeStartArray();
			for (String item0 : this.metrics) {
				generator.write(item0);

			}
			generator.writeEnd();

		}

	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Builder for {@link AggregateMetricDoubleProperty}.
	 */
	public static class Builder extends PropertyBase.AbstractBuilder<Builder>
			implements
				ObjectBuilder<AggregateMetricDoubleProperty> {
		private String defaultMetric;

		private List<String> metrics;

		/**
		 * Required - API name: {@code default_metric}
		 */
		public final Builder defaultMetric(String value) {
			this.defaultMetric = value;
			return this;
		}

		/**
		 * Required - API name: {@code metrics}
		 */
		public final Builder metrics(List<String> value) {
			this.metrics = value;
			return this;
		}

		/**
		 * Required - API name: {@code metrics}
		 */
		public final Builder metrics(String... value) {
			this.metrics = Arrays.asList(value);
			return this;
		}

		@Override
		protected Builder self() {
			return this;
		}

		/**
		 * Builds a {@link AggregateMetricDoubleProperty}.
		 *
		 * @throws NullPointerException
		 *             if some of the required fields are null.
		 */
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
			Builder::new, AggregateMetricDoubleProperty::setupAggregateMetricDoublePropertyDeserializer,
			Builder::build);

	protected static void setupAggregateMetricDoublePropertyDeserializer(
			DelegatingDeserializer<AggregateMetricDoubleProperty.Builder> op) {
		PropertyBase.setupPropertyBaseDeserializer(op);
		op.add(Builder::defaultMetric, JsonpDeserializer.stringDeserializer(), "default_metric");
		op.add(Builder::metrics, JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()),
				"metrics");

		op.ignore("type");
	}

}
