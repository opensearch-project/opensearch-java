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

// typedef: _types.aggregations.SamplerAggregate

/**
 *
 * @see <a href=
 *      "https://github.com/elastic/elasticsearch-specification/tree/98036c3/specification/_types/aggregations/Aggregate.ts#L476-L477">API
 *      specification</a>
 */
@JsonpDeserializable
public class SamplerAggregate extends SingleBucketAggregateBase implements AggregateVariant {
	// ---------------------------------------------------------------------------------------------

	private SamplerAggregate(Builder builder) {
		super(builder);

	}

	public static SamplerAggregate of(Function<Builder, ObjectBuilder<SamplerAggregate>> fn) {
		return fn.apply(new Builder()).build();
	}

	/**
	 * Aggregate variant kind.
	 */
	@Override
	public Aggregate.Kind _aggregateKind() {
		return Aggregate.Kind.Sampler;
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Builder for {@link SamplerAggregate}.
	 */

	public static class Builder extends SingleBucketAggregateBase.AbstractBuilder<Builder>
			implements
				ObjectBuilder<SamplerAggregate> {
		@Override
		protected Builder self() {
			return this;
		}

		/**
		 * Builds a {@link SamplerAggregate}.
		 *
		 * @throws NullPointerException
		 *             if some of the required fields are null.
		 */
		public SamplerAggregate build() {
			_checkSingleUse();

			return new SamplerAggregate(this);
		}
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Json deserializer for {@link SamplerAggregate}
	 */
	public static final JsonpDeserializer<SamplerAggregate> _DESERIALIZER = ObjectBuilderDeserializer.lazy(Builder::new,
			SamplerAggregate::setupSamplerAggregateDeserializer);

	protected static void setupSamplerAggregateDeserializer(ObjectDeserializer<SamplerAggregate.Builder> op) {
		setupSingleBucketAggregateBaseDeserializer(op);

	}

}
