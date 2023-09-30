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

package org.opensearch.client.opensearch.core.msearch;

import org.opensearch.client.opensearch._types.ScriptField;
import org.opensearch.client.opensearch._types.SortOptions;
import org.opensearch.client.opensearch._types.aggregations.Aggregation;
import org.opensearch.client.opensearch._types.query_dsl.Query;
import org.opensearch.client.opensearch.core.search.Highlight;
import org.opensearch.client.opensearch.core.search.SourceConfig;
import org.opensearch.client.opensearch.core.search.Suggester;
import org.opensearch.client.opensearch.core.search.TrackHits;
import org.opensearch.client.json.JsonpDeserializable;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.JsonpSerializable;
import org.opensearch.client.json.ObjectBuilderDeserializer;
import org.opensearch.client.json.ObjectDeserializer;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import jakarta.json.stream.JsonGenerator;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import javax.annotation.Nullable;

// typedef: _global.msearch.MultisearchBody


@JsonpDeserializable
public class MultisearchBody implements JsonpSerializable {
	private final Map<String, Aggregation> aggregations;

	@Nullable
	private final Query query;

	@Nullable
	private final Integer from;

	@Nullable
	private final Double minScore;

	@Nullable
	private final Query postFilter;

	private final List<String> searchAfter;

	@Nullable
	private final Integer size;

	private final List<SortOptions> sort;

	@Nullable
	private final Boolean trackScores;

	@Nullable
	private final TrackHits trackTotalHits;

	@Nullable
	private final Suggester suggest;

	@Nullable
	private Highlight highlight;

	@Nullable
	private SourceConfig source;

	private final Map<String, ScriptField> scriptFields;

	// ---------------------------------------------------------------------------------------------

	private MultisearchBody(Builder builder) {

		this.aggregations = ApiTypeHelper.unmodifiable(builder.aggregations);
		this.query = builder.query;
		this.from = builder.from;
		this.minScore = builder.minScore;
		this.postFilter = builder.postFilter;
		this.searchAfter = ApiTypeHelper.unmodifiable(builder.searchAfter);
		this.size = builder.size;
		this.sort = ApiTypeHelper.unmodifiable(builder.sort);
		this.trackScores = builder.trackScores;
		this.trackTotalHits = builder.trackTotalHits;
		this.suggest = builder.suggest;
		this.highlight = builder.highlight;
		this.source = builder.source;
		this.scriptFields = ApiTypeHelper.unmodifiable(builder.scriptFields);
	}

	public static MultisearchBody of(Function<Builder, ObjectBuilder<MultisearchBody>> fn) {
		return fn.apply(new Builder()).build();
	}

	/**
	 * API name: {@code aggregations}
	 */
	public final Map<String, Aggregation> aggregations() {
		return this.aggregations;
	}

	/**
	 * API name: {@code query}
	 */
	@Nullable
	public final Query query() {
		return this.query;
	}

	/**
	 * API name: {@code from}
	 */
	@Nullable
	public final Integer from() {
		return this.from;
	}

	/**
	 * API name: {@code from}
	 */
	@Nullable
	public final Double minScore() {
		return this.minScore;
	}

	/**
	 * API name: {@code post_filter}
	 */
	@Nullable
	public final Query postFilter() {
		return this.postFilter;
	}

	/**
	 * API name: {@code search_after}
	 */
	public final List<String> searchAfter() {
		return this.searchAfter;
	}

	/**
	 * API name: {@code size}
	 */
	@Nullable
	public final Integer size() {
		return this.size;
	}

	/**
	 * API name: {@code sort}
	 */
	public final List<SortOptions> sort() {
		return this.sort;
	}

	/**
	 * API name: {@code track_scores}
	 */
	@Nullable
	public final Boolean trackScores() {
		return this.trackScores;
	}

	/**
	 * API name: {@code track_total_hits}
	 */
	@Nullable
	public final TrackHits trackTotalHits() {
		return this.trackTotalHits;
	}

	/**
	 * API name: {@code suggest}
	 */
	@Nullable
	public final Suggester suggest() {
		return this.suggest;
	}

	/**
	 * API name: {@code highlight}
	 */
	@Nullable
	public final Highlight highlight() {
		return this.highlight;
	}

	/**
	 * API name: {@code _source}
	 */
	@Nullable
	public final SourceConfig source() {
		return this.source;
	}

	public final Map<String, ScriptField> scriptFields() {
		return this.scriptFields;
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

		if (ApiTypeHelper.isDefined(this.aggregations)) {
			generator.writeKey("aggregations");
			generator.writeStartObject();
			for (Map.Entry<String, Aggregation> item0 : this.aggregations.entrySet()) {
				generator.writeKey(item0.getKey());
				item0.getValue().serialize(generator, mapper);

			}
			generator.writeEnd();

		}
		if (this.query != null) {
			generator.writeKey("query");
			this.query.serialize(generator, mapper);

		}
		if (this.from != null) {
			generator.writeKey("from");
			generator.write(this.from);

		}
		if (this.minScore != null) {
			generator.writeKey("min_score");
			generator.write(this.minScore);

		}
		if (this.postFilter != null) {
			generator.writeKey("post_filter");
			this.postFilter.serialize(generator, mapper);

		}
		if (ApiTypeHelper.isDefined(this.searchAfter)) {
			generator.writeKey("search_after");
			generator.writeStartArray();
			for (String item0 : this.searchAfter) {
				generator.write(item0);

			}
			generator.writeEnd();

		}
		if (this.size != null) {
			generator.writeKey("size");
			generator.write(this.size);

		}
		if (ApiTypeHelper.isDefined(this.sort)) {
			generator.writeKey("sort");
			generator.writeStartArray();
			for (SortOptions item0 : this.sort) {
				item0.serialize(generator, mapper);

			}
			generator.writeEnd();

		}
		if (this.trackScores != null) {
			generator.writeKey("track_scores");
			generator.write(this.trackScores);

		}
		if (this.trackTotalHits != null) {
			generator.writeKey("track_total_hits");
			this.trackTotalHits.serialize(generator, mapper);

		}
		if (this.suggest != null) {
			generator.writeKey("suggest");
			this.suggest.serialize(generator, mapper);

		}

		if (this.highlight != null) {
			generator.writeKey("highlight");
			this.highlight.serialize(generator, mapper);

		}

		if (this.source != null) {
			generator.writeKey("_source");
			this.source.serialize(generator, mapper);

		}

		if (ApiTypeHelper.isDefined(this.scriptFields)) {
			generator.writeKey("script_fields");
			generator.writeStartObject();
			for (Map.Entry<String, ScriptField> item0 : this.scriptFields.entrySet()) {
				generator.writeKey(item0.getKey());
				item0.getValue().serialize(generator, mapper);

			}
			generator.writeEnd();

		}

	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Builder for {@link MultisearchBody}.
	 */

	public static class Builder extends ObjectBuilderBase implements ObjectBuilder<MultisearchBody> {
		@Nullable
		private Map<String, Aggregation> aggregations;

		@Nullable
		private Query query;

		@Nullable
		private Integer from;

		@Nullable
		private Double minScore;

		@Nullable
		private Query postFilter;

		@Nullable
		private List<String> searchAfter;

		@Nullable
		private Integer size;

		@Nullable
		private List<SortOptions> sort;

		@Nullable
		private Boolean trackScores;

		@Nullable
		private TrackHits trackTotalHits;

		@Nullable
		private Suggester suggest;

		@Nullable
		private Highlight highlight;

		@Nullable
		private SourceConfig source;

		private Map<String, ScriptField> scriptFields;


		/**
		 * API name: {@code aggregations}
		 * <p>
		 * Adds all entries of <code>map</code> to <code>aggregations</code>.
		 */
		public final Builder aggregations(Map<String, Aggregation> map) {
			this.aggregations = _mapPutAll(this.aggregations, map);
			return this;
		}

		/**
		 * API name: {@code aggregations}
		 * <p>
		 * Adds an entry to <code>aggregations</code>.
		 */
		public final Builder aggregations(String key, Aggregation value) {
			this.aggregations = _mapPut(this.aggregations, key, value);
			return this;
		}

		/**
		 * API name: {@code aggregations}
		 * <p>
		 * Adds an entry to <code>aggregations</code> using a builder lambda.
		 */
		public final Builder aggregations(String key, Function<Aggregation.Builder, ObjectBuilder<Aggregation>> fn) {
			return aggregations(key, fn.apply(new Aggregation.Builder()).build());
		}

		/**
		 * API name: {@code query}
		 */
		public final Builder query(@Nullable Query value) {
			this.query = value;
			return this;
		}

		/**
		 * API name: {@code query}
		 */
		public final Builder query(Function<Query.Builder, ObjectBuilder<Query>> fn) {
			return this.query(fn.apply(new Query.Builder()).build());
		}

		/**
		 * API name: {@code from}
		 */
		public final Builder from(@Nullable Integer value) {
			this.from = value;
			return this;
		}

		/**
		 * Minimum _score for matching documents. Documents with a lower _score are not
		 * included in the search results.
		 * <p>
		 * API name: {@code min_score}
		 */
		public final Builder minScore(@Nullable Double value) {
			this.minScore = value;
			return this;
		}

		/**
		 * API name: {@code post_filter}
		 */
		public final Builder postFilter(@Nullable Query value) {
			this.postFilter = value;
			return this;
		}

		/**
		 * API name: {@code post_filter}
		 */
		public final Builder postFilter(Function<Query.Builder, ObjectBuilder<Query>> fn) {
			return this.postFilter(fn.apply(new Query.Builder()).build());
		}

		/**
		 * API name: {@code search_after}
		 * <p>
		 * Adds all elements of <code>list</code> to <code>searchAfter</code>.
		 */
		public final Builder searchAfter(List<String> list) {
			this.searchAfter = _listAddAll(this.searchAfter, list);
			return this;
		}

		/**
		 * API name: {@code search_after}
		 * <p>
		 * Adds one or more values to <code>searchAfter</code>.
		 */
		public final Builder searchAfter(String value, String... values) {
			this.searchAfter = _listAdd(this.searchAfter, value, values);
			return this;
		}

		/**
		 * API name: {@code size}
		 */
		public final Builder size(@Nullable Integer value) {
			this.size = value;
			return this;
		}

		/**
		 * API name: {@code sort}
		 * <p>
		 * Adds all elements of <code>list</code> to <code>sort</code>.
		 */
		public final Builder sort(List<SortOptions> list) {
			this.sort = _listAddAll(this.sort, list);
			return this;
		}

		/**
		 * API name: {@code sort}
		 * <p>
		 * Adds one or more values to <code>sort</code>.
		 */
		public final Builder sort(SortOptions value, SortOptions... values) {
			this.sort = _listAdd(this.sort, value, values);
			return this;
		}

		/**
		 * API name: {@code sort}
		 * <p>
		 * Adds a value to <code>sort</code> using a builder lambda.
		 */
		public final Builder sort(Function<SortOptions.Builder, ObjectBuilder<SortOptions>> fn) {
			return sort(fn.apply(new SortOptions.Builder()).build());
		}

		/**
		 * If true, calculate and return document scores, even if the scores are not
		 * used for sorting.
		 * <p>
		 * API name: {@code track_scores}
		 */
		public final Builder trackScores(@Nullable Boolean value) {
			this.trackScores = value;
			return this;
		}

		/**
		 * API name: {@code track_total_hits}
		 */
		public final Builder trackTotalHits(@Nullable TrackHits value) {
			this.trackTotalHits = value;
			return this;
		}

		/**
		 * API name: {@code track_total_hits}
		 */
		public final Builder trackTotalHits(Function<TrackHits.Builder, ObjectBuilder<TrackHits>> fn) {
			return this.trackTotalHits(fn.apply(new TrackHits.Builder()).build());
		}

		/**
		 * API name: {@code suggest}
		 */
		public final Builder suggest(@Nullable Suggester value) {
			this.suggest = value;
			return this;
		}

		/**
		 * API name: {@code suggest}
		 */
		public final Builder suggest(Function<Suggester.Builder, ObjectBuilder<Suggester>> fn) {
			return this.suggest(fn.apply(new Suggester.Builder()).build());
		}

		/**
		 * API name: {@code highlight}
		 */
		public final Builder highlight(@Nullable Highlight value) {
			this.highlight = value;
			return this;
		}

		/**
		 * API name: {@code highlight}
		 */
		public final Builder highlight(Function<Highlight.Builder, ObjectBuilder<Highlight>> fn) {
			return this.highlight(fn.apply(new Highlight.Builder()).build());
		}

		/**
		 * API name: {@code _source}
		 */
		public final Builder source(@Nullable SourceConfig value) {
			this.source = value;
			return this;
		}

		/**
		 * API name: {@code _source}
		 */
		public final Builder source(Function<SourceConfig.Builder, ObjectBuilder<SourceConfig>> fn) {
			return this.source(fn.apply(new SourceConfig.Builder()).build());
		}

		/**
		 * API name: {@code script_fields}
		 */
		public final Builder scriptFields(Map<String, ScriptField> map) {
			this.scriptFields = _mapPutAll(this.scriptFields, map);
			return this;
		}

		/**
		 * API name: {@code script_fields}
		 */
		public final Builder scriptFields(String key, ScriptField value) {
			this.scriptFields = _mapPut(this.scriptFields, key, value);
			return this;
		}

		/**
		 * API name: {@code script_fields}
		 */
		public final Builder scriptFields(String key, Function<ScriptField.Builder, ObjectBuilder<ScriptField>> fn) {
			return scriptFields(key, fn.apply(new ScriptField.Builder()).build());
		}

		/**
		 * Builds a {@link MultisearchBody}.
		 *
		 * @throws NullPointerException
		 *             if some of the required fields are null.
		 */
		public MultisearchBody build() {
			_checkSingleUse();

			return new MultisearchBody(this);
		}
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Json deserializer for {@link MultisearchBody}
	 */
	public static final JsonpDeserializer<MultisearchBody> _DESERIALIZER = ObjectBuilderDeserializer.lazy(Builder::new,
			MultisearchBody::setupMultisearchBodyDeserializer);

	protected static void setupMultisearchBodyDeserializer(ObjectDeserializer<MultisearchBody.Builder> op) {

		op.add(Builder::aggregations, JsonpDeserializer.stringMapDeserializer(Aggregation._DESERIALIZER),
				"aggregations", "aggs");
		op.add(Builder::query, Query._DESERIALIZER, "query");
		op.add(Builder::from, JsonpDeserializer.integerDeserializer(), "from");
		op.add(Builder::minScore, JsonpDeserializer.doubleDeserializer(), "min_score");
		op.add(Builder::postFilter, Query._DESERIALIZER, "post_filter");
		op.add(Builder::searchAfter, JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()),
				"search_after");
		op.add(Builder::size, JsonpDeserializer.integerDeserializer(), "size");
		op.add(Builder::sort, JsonpDeserializer.arrayDeserializer(SortOptions._DESERIALIZER), "sort");
		op.add(Builder::trackScores, JsonpDeserializer.booleanDeserializer(), "track_scores");
		op.add(Builder::trackTotalHits, TrackHits._DESERIALIZER, "track_total_hits");
		op.add(Builder::suggest, Suggester._DESERIALIZER, "suggest");
		op.add(Builder::highlight, Highlight._DESERIALIZER, "highlight");
		op.add(Builder::source, SourceConfig._DESERIALIZER, "_source");
		op.add(Builder::scriptFields, JsonpDeserializer.stringMapDeserializer(ScriptField._DESERIALIZER),
				"script_fields");

	}

}
