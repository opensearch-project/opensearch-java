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

package org.opensearch.client.opensearch._types.aggregations;

import org.opensearch.client.json.JsonpDeserializable;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.ObjectBuilderDeserializer;
import org.opensearch.client.json.ObjectDeserializer;
import org.opensearch.client.util.ObjectBuilder;

import java.util.function.Function;

// typedef: _types.aggregations.AverageAggregation

/**
 *
 * @see <a href=
 *      "https://github.com/elastic/elasticsearch-specification/tree/98036c3/specification/_types/aggregations/metric.ts#L48-L48">API
 *      specification</a>
 */
@JsonpDeserializable
public class AverageAggregation extends FormatMetricAggregationBase implements AggregationVariant {
	// ---------------------------------------------------------------------------------------------

	private AverageAggregation(Builder builder) {
		super(builder);

	}

	public static AverageAggregation of(Function<Builder, ObjectBuilder<AverageAggregation>> fn) {
		return fn.apply(new Builder()).build();
	}

	/**
	 * Aggregation variant kind.
	 */
	@Override
	public Aggregation.Kind _aggregationKind() {
		return Aggregation.Kind.Avg;
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Builder for {@link AverageAggregation}.
	 */

	public static class Builder extends FormatMetricAggregationBase.AbstractBuilder<Builder>
			implements
				ObjectBuilder<AverageAggregation> {
		@Override
		protected Builder self() {
			return this;
		}

		/**
		 * Builds a {@link AverageAggregation}.
		 *
		 * @throws NullPointerException
		 *             if some of the required fields are null.
		 */
		public AverageAggregation build() {
			_checkSingleUse();

			return new AverageAggregation(this);
		}
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Json deserializer for {@link AverageAggregation}
	 */
	public static final JsonpDeserializer<AverageAggregation> _DESERIALIZER = ObjectBuilderDeserializer
			.lazy(Builder::new, AverageAggregation::setupAverageAggregationDeserializer);

	protected static void setupAverageAggregationDeserializer(ObjectDeserializer<AverageAggregation.Builder> op) {
		FormatMetricAggregationBase.setupFormatMetricAggregationBaseDeserializer(op);

	}

}
