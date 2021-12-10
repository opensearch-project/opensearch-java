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

// typedef: _types.aggregations.MaxAggregate

/**
 *
 * @see <a href=
 *      "https://github.com/elastic/elasticsearch-specification/tree/98036c3/specification/_types/aggregations/Aggregate.ts#L186-L187">API
 *      specification</a>
 */
@JsonpDeserializable
public class MaxAggregate extends SingleMetricAggregateBase implements AggregateVariant {
	// ---------------------------------------------------------------------------------------------

	private MaxAggregate(Builder builder) {
		super(builder);

	}

	public static MaxAggregate of(Function<Builder, ObjectBuilder<MaxAggregate>> fn) {
		return fn.apply(new Builder()).build();
	}

	/**
	 * Aggregate variant kind.
	 */
	@Override
	public Aggregate.Kind _aggregateKind() {
		return Aggregate.Kind.Max;
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Builder for {@link MaxAggregate}.
	 */

	public static class Builder extends SingleMetricAggregateBase.AbstractBuilder<Builder>
			implements
				ObjectBuilder<MaxAggregate> {
		@Override
		protected Builder self() {
			return this;
		}

		/**
		 * Builds a {@link MaxAggregate}.
		 *
		 * @throws NullPointerException
		 *             if some of the required fields are null.
		 */
		public MaxAggregate build() {
			_checkSingleUse();

			return new MaxAggregate(this);
		}
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Json deserializer for {@link MaxAggregate}
	 */
	public static final JsonpDeserializer<MaxAggregate> _DESERIALIZER = ObjectBuilderDeserializer.lazy(Builder::new,
			MaxAggregate::setupMaxAggregateDeserializer);

	protected static void setupMaxAggregateDeserializer(ObjectDeserializer<MaxAggregate.Builder> op) {
		setupSingleMetricAggregateBaseDeserializer(op);

	}

}
