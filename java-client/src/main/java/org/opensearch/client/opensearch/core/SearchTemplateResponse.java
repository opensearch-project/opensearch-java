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

package org.opensearch.client.opensearch.core;

import org.opensearch.client.opensearch._types.ShardStatistics;
import org.opensearch.client.opensearch._types.aggregations.Aggregate;
import org.opensearch.client.opensearch.core.SearchResponse.AbstractBuilder;
import org.opensearch.client.opensearch.core.search.HitsMetadata;
import org.opensearch.client.opensearch.core.search.Suggestion;
import org.opensearch.client.json.ExternallyTaggedUnion;
import org.opensearch.client.json.JsonpDeserializable;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.JsonpSerializable;
import org.opensearch.client.json.JsonpSerializer;
import org.opensearch.client.json.NamedDeserializer;
import org.opensearch.client.json.ObjectBuilderDeserializer;
import org.opensearch.client.json.ObjectDeserializer;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import jakarta.json.stream.JsonGenerator;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;
import javax.annotation.Nullable;

// typedef: _global.search_template.Response

@JsonpDeserializable
public class SearchTemplateResponse<TDocument> implements JsonpSerializable {
	private final ShardStatistics shards;

	private final boolean timedOut;

	private final int took;

	private final HitsMetadata<TDocument> hits;
	
	private final Map<String, Aggregate> aggregations;

	private final Map<String, List<Suggestion<TDocument>>> suggest;

	@Nullable
	private final JsonpSerializer<TDocument> tDocumentSerializer;

	// ---------------------------------------------------------------------------------------------

	private SearchTemplateResponse(Builder<TDocument> builder) {

		this.shards = ApiTypeHelper.requireNonNull(builder.shards, this, "shards");
		this.timedOut = ApiTypeHelper.requireNonNull(builder.timedOut, this, "timedOut");
		this.took = ApiTypeHelper.requireNonNull(builder.took, this, "took");
		this.hits = ApiTypeHelper.requireNonNull(builder.hits, this, "hits");
		this.aggregations = ApiTypeHelper.unmodifiable(builder.aggregations);
		this.suggest = ApiTypeHelper.unmodifiable(builder.suggest);
		this.tDocumentSerializer = builder.tDocumentSerializer;

	}

	public static <TDocument> SearchTemplateResponse<TDocument> of(
			Function<Builder<TDocument>, ObjectBuilder<SearchTemplateResponse<TDocument>>> fn) {
		return fn.apply(new Builder<>()).build();
	}

	/**
	 * Required - API name: {@code _shards}
	 */
	public final ShardStatistics shards() {
		return this.shards;
	}

	/**
	 * Required - API name: {@code timed_out}
	 */
	public final boolean timedOut() {
		return this.timedOut;
	}

	/**
	 * Required - API name: {@code took}
	 */
	public final int took() {
		return this.took;
	}

	/**
	 * Required - API name: {@code hits}
	 */
	public final HitsMetadata<TDocument> hits() {
		return this.hits;
	}
	
	/**
	 * API name: {@code aggregations}
	 */
	public final Map<String, Aggregate> aggregations() {
		return this.aggregations;
	}
	
	/**
	 * API name: {@code suggest}
	 */
	public final Map<String, List<Suggestion<TDocument>>> suggest() {
		return this.suggest;
	}

	/**
	 * Serialize this object to JSON.
	 */
	public void serialize(JsonGenerator generator, JsonpMapper mapper) {
		generator.writeStartObject();
		serializeInternal(generator, mapper);
		generator.writeEnd();
	}

	protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {

		generator.writeKey("_shards");
		this.shards.serialize(generator, mapper);

		generator.writeKey("timed_out");
		generator.write(this.timedOut);

		generator.writeKey("took");
		generator.write(this.took);

		generator.writeKey("hits");
		this.hits.serialize(generator, mapper);

		if (ApiTypeHelper.isDefined(this.aggregations)) {
			generator.writeKey("aggregations");
			ExternallyTaggedUnion.serializeTypedKeys(this.aggregations, generator, mapper);
		}
		
		if (ApiTypeHelper.isDefined(this.suggest)) {
			generator.writeKey("suggest");
			generator.writeStartObject();
			for (Map.Entry<String, List<Suggestion<TDocument>>> item0 : this.suggest.entrySet()) {
				generator.writeKey(item0.getKey());
				generator.writeStartArray();
				if (item0.getValue() != null) {
					for (Suggestion<TDocument> item1 : item0.getValue()) {
						item1.serialize(generator, mapper);

					}
				}
				generator.writeEnd();

			}
			generator.writeEnd();
		}
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Builder for {@link SearchTemplateResponse}.
	 */

	public static class Builder<TDocument> extends ObjectBuilderBase
			implements
				ObjectBuilder<SearchTemplateResponse<TDocument>> {
		private ShardStatistics shards;

		private Boolean timedOut;

		private Integer took;

		private HitsMetadata<TDocument> hits;
		
		@Nullable
		private Map<String, Aggregate> aggregations;
		
		@Nullable
		private Map<String, List<Suggestion<TDocument>>> suggest;

		@Nullable
		private JsonpSerializer<TDocument> tDocumentSerializer;

		/**
		 * Required - API name: {@code _shards}
		 */
		public final Builder<TDocument> shards(ShardStatistics value) {
			this.shards = value;
			return this;
		}

		/**
		 * Required - API name: {@code _shards}
		 */
		public final Builder<TDocument> shards(Function<ShardStatistics.Builder, ObjectBuilder<ShardStatistics>> fn) {
			return this.shards(fn.apply(new ShardStatistics.Builder()).build());
		}

		/**
		 * Required - API name: {@code timed_out}
		 */
		public final Builder<TDocument> timedOut(boolean value) {
			this.timedOut = value;
			return this;
		}

		/**
		 * Required - API name: {@code took}
		 */
		public final Builder<TDocument> took(int value) {
			this.took = value;
			return this;
		}

		/**
		 * Required - API name: {@code hits}
		 */
		public final Builder<TDocument> hits(HitsMetadata<TDocument> value) {
			this.hits = value;
			return this;
		}

		/**
		 * Required - API name: {@code hits}
		 */
		public final Builder<TDocument> hits(
				Function<HitsMetadata.Builder<TDocument>, ObjectBuilder<HitsMetadata<TDocument>>> fn) {
			return this.hits(fn.apply(new HitsMetadata.Builder<TDocument>()).build());
		}
		
		/**
		 * API name: {@code aggregations}
		 * <p>
		 * Adds all entries of <code>map</code> to <code>aggregations</code>.
		 */
		public final Builder<TDocument> aggregations(Map<String, Aggregate> map) {
			this.aggregations = _mapPutAll(this.aggregations, map);
			return this;
		}

		/**
		 * API name: {@code aggregations}
		 * <p>
		 * Adds an entry to <code>aggregations</code>.
		 */
		public final Builder<TDocument> aggregations(String key, Aggregate value) {
			this.aggregations = _mapPut(this.aggregations, key, value);
			return this;
		}

		/**
		 * API name: {@code aggregations}
		 * <p>
		 * Adds an entry to <code>aggregations</code> using a builder lambda.
		 */
		public final Builder<TDocument> aggregations(String key, Function<Aggregate.Builder, ObjectBuilder<Aggregate>> fn) {
			return aggregations(key, fn.apply(new Aggregate.Builder()).build());
		}
		
		/**
		 * API name: {@code suggest}
		 * <p>
		 * Adds all entries of <code>map</code> to <code>suggest</code>.
		 */
		public final Builder<TDocument> suggest(Map<String, List<Suggestion<TDocument>>> map) {
			this.suggest = _mapPutAll(this.suggest, map);
			return this;
		}

		/**
		 * API name: {@code suggest}
		 * <p>
		 * Adds an entry to <code>suggest</code>.
		 */
		public final Builder<TDocument> suggest(String key, List<Suggestion<TDocument>> value) {
			this.suggest = _mapPut(this.suggest, key, value);
			return this;
		}

		/**
		 * Serializer for TDocument. If not set, an attempt will be made to find a
		 * serializer from the JSON context.
		 */
		public final Builder<TDocument> tDocumentSerializer(@Nullable JsonpSerializer<TDocument> value) {
			this.tDocumentSerializer = value;
			return this;
		}

		/**
		 * Builds a {@link SearchTemplateResponse}.
		 *
		 * @throws NullPointerException
		 *             if some of the required fields are null.
		 */
		public SearchTemplateResponse<TDocument> build() {
			_checkSingleUse();

			return new SearchTemplateResponse<TDocument>(this);
		}
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Create a JSON deserializer for SearchTemplateResponse
	 */
	public static <TDocument> JsonpDeserializer<SearchTemplateResponse<TDocument>> createSearchTemplateResponseDeserializer(
			JsonpDeserializer<TDocument> tDocumentDeserializer) {
		return ObjectBuilderDeserializer.createForObject((Supplier<Builder<TDocument>>) Builder::new,
				op -> SearchTemplateResponse.setupSearchTemplateResponseDeserializer(op, tDocumentDeserializer));
	};

	/**
	 * Json deserializer for {@link SearchTemplateResponse} based on named
	 * deserializers provided by the calling {@code JsonMapper}.
	 */
	public static final JsonpDeserializer<SearchTemplateResponse<Object>> _DESERIALIZER = createSearchTemplateResponseDeserializer(
			new NamedDeserializer<>("org.opensearch.client:Deserializer:_global.search_template.TDocument"));

	protected static <TDocument> void setupSearchTemplateResponseDeserializer(
			ObjectDeserializer<SearchTemplateResponse.Builder<TDocument>> op,
			JsonpDeserializer<TDocument> tDocumentDeserializer) {

		op.add(Builder::shards, ShardStatistics._DESERIALIZER, "_shards");
		op.add(Builder::timedOut, JsonpDeserializer.booleanDeserializer(), "timed_out");
		op.add(Builder::took, JsonpDeserializer.integerDeserializer(), "took");
		op.add(Builder::hits, HitsMetadata.createHitsMetadataDeserializer(tDocumentDeserializer), "hits");
		op.add(Builder::aggregations, Aggregate._TYPED_KEYS_DESERIALIZER, "aggregations");
		op.add(Builder::suggest, JsonpDeserializer.stringMapDeserializer(
				JsonpDeserializer.arrayDeserializer(Suggestion.createSuggestionDeserializer(tDocumentDeserializer))),
				"suggest");

	}

}
