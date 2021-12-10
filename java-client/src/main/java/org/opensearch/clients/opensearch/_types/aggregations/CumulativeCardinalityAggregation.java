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

package org.opensearch.clients.opensearch._types.aggregations;

import org.opensearch.clients.json.JsonpDeserializable;
import org.opensearch.clients.json.JsonpDeserializer;
import org.opensearch.clients.json.ObjectBuilderDeserializer;
import org.opensearch.clients.json.ObjectDeserializer;
import org.opensearch.clients.util.ObjectBuilder;

import java.util.function.Function;

// typedef: _types.aggregations.CumulativeCardinalityAggregation

/**
 *
 * @see <a href=
 *      "https://github.com/elastic/elasticsearch-specification/tree/98036c3/specification/_types/aggregations/pipeline.ts#L63-L63">API
 *      specification</a>
 */
@JsonpDeserializable
public class CumulativeCardinalityAggregation extends PipelineAggregationBase implements AggregationVariant {
	// ---------------------------------------------------------------------------------------------

	private CumulativeCardinalityAggregation(Builder builder) {
		super(builder);

	}

	public static CumulativeCardinalityAggregation of(
			Function<Builder, ObjectBuilder<CumulativeCardinalityAggregation>> fn) {
		return fn.apply(new Builder()).build();
	}

	/**
	 * Aggregation variant kind.
	 */
	@Override
	public Aggregation.Kind _aggregationKind() {
		return Aggregation.Kind.CumulativeCardinality;
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Builder for {@link CumulativeCardinalityAggregation}.
	 */

	public static class Builder extends PipelineAggregationBase.AbstractBuilder<Builder>
			implements
				ObjectBuilder<CumulativeCardinalityAggregation> {
		@Override
		protected Builder self() {
			return this;
		}

		/**
		 * Builds a {@link CumulativeCardinalityAggregation}.
		 *
		 * @throws NullPointerException
		 *             if some of the required fields are null.
		 */
		public CumulativeCardinalityAggregation build() {
			_checkSingleUse();

			return new CumulativeCardinalityAggregation(this);
		}
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Json deserializer for {@link CumulativeCardinalityAggregation}
	 */
	public static final JsonpDeserializer<CumulativeCardinalityAggregation> _DESERIALIZER = ObjectBuilderDeserializer
			.lazy(Builder::new, CumulativeCardinalityAggregation::setupCumulativeCardinalityAggregationDeserializer);

	protected static void setupCumulativeCardinalityAggregationDeserializer(
			ObjectDeserializer<CumulativeCardinalityAggregation.Builder> op) {
		PipelineAggregationBase.setupPipelineAggregationBaseDeserializer(op);

	}

}
