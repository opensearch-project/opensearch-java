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

import org.opensearch.client.json.DelegatingDeserializer;
import org.opensearch.client.json.JsonpDeserializable;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.ObjectBuilderDeserializer;
import org.opensearch.client.util.ObjectBuilder;

import java.util.function.Function;

// typedef: _types.aggregations.TopMetricsAggregate
@JsonpDeserializable
public class TopMetricsAggregate extends MultiBucketAggregateBase<TopMetricsBucket> implements AggregateVariant {
	// ---------------------------------------------------------------------------------------------

	private TopMetricsAggregate(Builder builder) {
		super(builder);

	}

	public static TopMetricsAggregate of(Function<Builder, ObjectBuilder<TopMetricsAggregate>> fn) {
		return fn.apply(new Builder()).build();
	}

	/**
	 * {@link Aggregate} variant type
	 */
	@Override
	public String _variantType() {
		return "top_metrics";
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Builder for {@link TopMetricsAggregate}.
	 */
	public static class Builder extends MultiBucketAggregateBase.AbstractBuilder<TopMetricsBucket, Builder>
			implements
				ObjectBuilder<TopMetricsAggregate> {
		@Override
		protected Builder self() {
			return this;
		}

		/**
		 * Builds a {@link TopMetricsAggregate}.
		 *
		 * @throws NullPointerException
		 *             if some of the required fields are null.
		 */
		public TopMetricsAggregate build() {
			_checkSingleUse();
			super.tBucketSerializer(null);

			return new TopMetricsAggregate(this);
		}
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Json deserializer for {@link TopMetricsAggregate}
	 */
	public static final JsonpDeserializer<TopMetricsAggregate> _DESERIALIZER = ObjectBuilderDeserializer
			.lazy(Builder::new, TopMetricsAggregate::setupTopMetricsAggregateDeserializer, Builder::build);

	protected static void setupTopMetricsAggregateDeserializer(DelegatingDeserializer<TopMetricsAggregate.Builder> op) {
		setupMultiBucketAggregateBaseDeserializer(op, TopMetricsBucket._DESERIALIZER);

	}

}
