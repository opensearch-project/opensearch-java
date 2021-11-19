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

import org.opensearch.client.opensearch._types.query_dsl.Query;
import org.opensearch.client.json.DelegatingDeserializer;
import org.opensearch.client.json.JsonpDeserializable;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.ObjectBuilderDeserializer;
import org.opensearch.client.util.MapBuilder;
import org.opensearch.client.util.ModelTypeHelper;
import org.opensearch.client.util.ObjectBuilder;
import jakarta.json.stream.JsonGenerator;
import java.lang.String;
import java.util.Collections;
import java.util.Map;
import java.util.function.Function;
import javax.annotation.Nullable;

// typedef: _types.aggregations.AdjacencyMatrixAggregation
@JsonpDeserializable
public class AdjacencyMatrixAggregation extends BucketAggregationBase implements AggregationVariant {
	private final Map<String, Query> filters;

	// ---------------------------------------------------------------------------------------------

	private AdjacencyMatrixAggregation(Builder builder) {
		super(builder);

		this.filters = ModelTypeHelper.unmodifiable(builder.filters);

	}

	public static AdjacencyMatrixAggregation of(Function<Builder, ObjectBuilder<AdjacencyMatrixAggregation>> fn) {
		return fn.apply(new Builder()).build();
	}

	/**
	 * {@link Aggregation} variant type
	 */
	@Override
	public String _variantType() {
		return "adjacency_matrix";
	}

	/**
	 * API name: {@code filters}
	 */
	public final Map<String, Query> filters() {
		return this.filters;
	}

	protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {

		super.serializeInternal(generator, mapper);
		if (ModelTypeHelper.isDefined(this.filters)) {
			generator.writeKey("filters");
			generator.writeStartObject();
			for (Map.Entry<String, Query> item0 : this.filters.entrySet()) {
				generator.writeKey(item0.getKey());
				item0.getValue().serialize(generator, mapper);

			}
			generator.writeEnd();

		}

	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Builder for {@link AdjacencyMatrixAggregation}.
	 */
	public static class Builder extends BucketAggregationBase.AbstractBuilder<Builder>
			implements
				ObjectBuilder<AdjacencyMatrixAggregation> {
		@Nullable
		private Map<String, Query> filters;

		/**
		 * API name: {@code filters}
		 */
		public final Builder filters(@Nullable Map<String, Query> value) {
			this.filters = value;
			return this;
		}

		/**
		 * Set {@link #filters(Map)} to a singleton map.
		 */
		public Builder filters(String key, Function<Query.Builder, ObjectBuilder<Query>> fn) {
			return this.filters(Collections.singletonMap(key, fn.apply(new Query.Builder()).build()));
		}

		public final Builder filters(
				Function<MapBuilder<String, Query, Query.Builder>, ObjectBuilder<Map<String, Query>>> fn) {
			return filters(fn.apply(new MapBuilder<>(Query.Builder::new)).build());
		}

		@Override
		protected Builder self() {
			return this;
		}

		/**
		 * Builds a {@link AdjacencyMatrixAggregation}.
		 *
		 * @throws NullPointerException
		 *             if some of the required fields are null.
		 */
		public AdjacencyMatrixAggregation build() {
			_checkSingleUse();

			return new AdjacencyMatrixAggregation(this);
		}
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Json deserializer for {@link AdjacencyMatrixAggregation}
	 */
	public static final JsonpDeserializer<AdjacencyMatrixAggregation> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
			Builder::new, AdjacencyMatrixAggregation::setupAdjacencyMatrixAggregationDeserializer, Builder::build);

	protected static void setupAdjacencyMatrixAggregationDeserializer(
			DelegatingDeserializer<AdjacencyMatrixAggregation.Builder> op) {
		BucketAggregationBase.setupBucketAggregationBaseDeserializer(op);
		op.add(Builder::filters, JsonpDeserializer.stringMapDeserializer(Query._DESERIALIZER), "filters");

	}

}
