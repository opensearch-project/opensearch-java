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

import org.opensearch.clients.json.DelegatingDeserializer;
import org.opensearch.clients.json.JsonpDeserializable;
import org.opensearch.clients.json.JsonpDeserializer;
import org.opensearch.clients.json.ObjectBuilderDeserializer;
import org.opensearch.clients.util.ObjectBuilder;

// typedef: _types.aggregations.RangeAggregate
@JsonpDeserializable
public class RangeAggregate extends MultiBucketAggregateBase<RangeBucket> implements AggregateVariant {
	// ---------------------------------------------------------------------------------------------

	protected RangeAggregate(AbstractBuilder<?> builder) {
		super(builder);

	}

	/**
	 * {@link Aggregate} variant type
	 */
	@Override
	public String _variantType() {
		return "range";
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Builder for {@link RangeAggregate}.
	 */
	public static class Builder extends RangeAggregate.AbstractBuilder<Builder>
			implements
				ObjectBuilder<RangeAggregate> {
		@Override
		protected Builder self() {
			return this;
		}

		/**
		 * Builds a {@link RangeAggregate}.
		 *
		 * @throws NullPointerException
		 *             if some of the required fields are null.
		 */
		public RangeAggregate build() {
			_checkSingleUse();
			super.tBucketSerializer(null);

			return new RangeAggregate(this);
		}
	}

	protected abstract static class AbstractBuilder<BuilderT extends AbstractBuilder<BuilderT>>
			extends
				MultiBucketAggregateBase.AbstractBuilder<RangeBucket, BuilderT> {
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Json deserializer for {@link RangeAggregate}
	 */
	public static final JsonpDeserializer<RangeAggregate> _DESERIALIZER = ObjectBuilderDeserializer.lazy(Builder::new,
			RangeAggregate::setupRangeAggregateDeserializer, Builder::build);

	protected static <BuilderT extends AbstractBuilder<BuilderT>> void setupRangeAggregateDeserializer(
			DelegatingDeserializer<BuilderT> op) {
		setupMultiBucketAggregateBaseDeserializer(op, RangeBucket._DESERIALIZER);

	}

}
