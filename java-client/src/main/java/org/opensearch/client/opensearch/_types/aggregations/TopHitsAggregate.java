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

import org.opensearch.client.opensearch.core.search.HitsMetadata;
import org.opensearch.client.json.JsonData;
import org.opensearch.client.json.JsonpDeserializable;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.ObjectBuilderDeserializer;
import org.opensearch.client.json.ObjectDeserializer;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.ObjectBuilder;
import jakarta.json.stream.JsonGenerator;

import java.util.function.Function;

// typedef: _types.aggregations.TopHitsAggregate

/**
 *
 * @see <a href=
 *      "https://github.com/elastic/elasticsearch-specification/tree/98036c3/specification/_types/aggregations/Aggregate.ts#L591-L594">API
 *      specification</a>
 */
@JsonpDeserializable
public class TopHitsAggregate extends AggregateBase implements AggregateVariant {
	private final HitsMetadata<JsonData> hits;

	// ---------------------------------------------------------------------------------------------

	private TopHitsAggregate(Builder builder) {
		super(builder);

		this.hits = ApiTypeHelper.requireNonNull(builder.hits, this, "hits");

	}

	public static TopHitsAggregate of(Function<Builder, ObjectBuilder<TopHitsAggregate>> fn) {
		return fn.apply(new Builder()).build();
	}

	/**
	 * Aggregate variant kind.
	 */
	@Override
	public Aggregate.Kind _aggregateKind() {
		return Aggregate.Kind.TopHits;
	}

	/**
	 * Required - API name: {@code hits}
	 */
	public final HitsMetadata<JsonData> hits() {
		return this.hits;
	}

	protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {

		super.serializeInternal(generator, mapper);
		generator.writeKey("hits");
		this.hits.serialize(generator, mapper);

	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Builder for {@link TopHitsAggregate}.
	 */

	public static class Builder extends AggregateBase.AbstractBuilder<Builder>
			implements
				ObjectBuilder<TopHitsAggregate> {
		private HitsMetadata<JsonData> hits;

		/**
		 * Required - API name: {@code hits}
		 */
		public final Builder hits(HitsMetadata<JsonData> value) {
			this.hits = value;
			return this;
		}

		/**
		 * Required - API name: {@code hits}
		 */
		public final Builder hits(Function<HitsMetadata.Builder<JsonData>, ObjectBuilder<HitsMetadata<JsonData>>> fn) {
			return this.hits(fn.apply(new HitsMetadata.Builder<JsonData>()).build());
		}

		@Override
		protected Builder self() {
			return this;
		}

		/**
		 * Builds a {@link TopHitsAggregate}.
		 *
		 * @throws NullPointerException
		 *             if some of the required fields are null.
		 */
		public TopHitsAggregate build() {
			_checkSingleUse();

			return new TopHitsAggregate(this);
		}
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Json deserializer for {@link TopHitsAggregate}
	 */
	public static final JsonpDeserializer<TopHitsAggregate> _DESERIALIZER = ObjectBuilderDeserializer.lazy(Builder::new,
			TopHitsAggregate::setupTopHitsAggregateDeserializer);

	protected static void setupTopHitsAggregateDeserializer(ObjectDeserializer<TopHitsAggregate.Builder> op) {
		AggregateBase.setupAggregateBaseDeserializer(op);
		op.add(Builder::hits, HitsMetadata.createHitsMetadataDeserializer(JsonData._DESERIALIZER), "hits");

	}

}
