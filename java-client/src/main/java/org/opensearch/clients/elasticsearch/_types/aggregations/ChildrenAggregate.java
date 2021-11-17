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

package org.opensearch.clients.elasticsearch._types.aggregations;

import org.opensearch.clients.json.DelegatingDeserializer;
import org.opensearch.clients.json.JsonpDeserializable;
import org.opensearch.clients.json.JsonpDeserializer;
import org.opensearch.clients.json.ObjectBuilderDeserializer;
import org.opensearch.clients.util.ObjectBuilder;

import java.util.function.Function;

// typedef: _types.aggregations.ChildrenAggregate
@JsonpDeserializable
public class ChildrenAggregate extends MultiBucketAggregateBase<ChildrenAggregateBucket> implements AggregateVariant {
	// ---------------------------------------------------------------------------------------------

	private ChildrenAggregate(Builder builder) {
		super(builder);

	}

	public static ChildrenAggregate of(Function<Builder, ObjectBuilder<ChildrenAggregate>> fn) {
		return fn.apply(new Builder()).build();
	}

	/**
	 * {@link Aggregate} variant type
	 */
	@Override
	public String _variantType() {
		return "children";
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Builder for {@link ChildrenAggregate}.
	 */
	public static class Builder extends MultiBucketAggregateBase.AbstractBuilder<ChildrenAggregateBucket, Builder>
			implements
				ObjectBuilder<ChildrenAggregate> {
		@Override
		protected Builder self() {
			return this;
		}

		/**
		 * Builds a {@link ChildrenAggregate}.
		 *
		 * @throws NullPointerException
		 *             if some of the required fields are null.
		 */
		public ChildrenAggregate build() {
			_checkSingleUse();
			super.tBucketSerializer(null);

			return new ChildrenAggregate(this);
		}
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Json deserializer for {@link ChildrenAggregate}
	 */
	public static final JsonpDeserializer<ChildrenAggregate> _DESERIALIZER = ObjectBuilderDeserializer
			.lazy(Builder::new, ChildrenAggregate::setupChildrenAggregateDeserializer, Builder::build);

	protected static void setupChildrenAggregateDeserializer(DelegatingDeserializer<ChildrenAggregate.Builder> op) {
		MultiBucketAggregateBase.setupMultiBucketAggregateBaseDeserializer(op, ChildrenAggregateBucket._DESERIALIZER);

	}

}
