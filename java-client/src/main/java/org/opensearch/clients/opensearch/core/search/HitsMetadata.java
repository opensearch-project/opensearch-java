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

package org.opensearch.clients.opensearch.core.search;

import org.opensearch.clients.json.DelegatingDeserializer;
import org.opensearch.clients.json.JsonpDeserializer;
import org.opensearch.clients.json.JsonpMapper;
import org.opensearch.clients.json.JsonpSerializable;
import org.opensearch.clients.json.JsonpSerializer;
import org.opensearch.clients.json.ObjectBuilderDeserializer;
import org.opensearch.clients.util.ModelTypeHelper;
import org.opensearch.clients.util.ObjectBuilder;
import org.opensearch.clients.util.ObjectBuilderBase;
import jakarta.json.stream.JsonGenerator;
import java.lang.Double;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import javax.annotation.Nullable;

// typedef: _global.search._types.HitsMetadata

public class HitsMetadata<T> implements JsonpSerializable {
	private final TotalHits total;

	private final List<Hit<T>> hits;

	@Nullable
	private final Double maxScore;

	@Nullable
	private final JsonpSerializer<T> tSerializer;

	// ---------------------------------------------------------------------------------------------

	private HitsMetadata(Builder<T> builder) {

		this.total = ModelTypeHelper.requireNonNull(builder.total, this, "total");
		this.hits = ModelTypeHelper.unmodifiableRequired(builder.hits, this, "hits");
		this.maxScore = builder.maxScore;
		this.tSerializer = builder.tSerializer;

	}

	public static <T> HitsMetadata<T> of(Function<Builder<T>, ObjectBuilder<HitsMetadata<T>>> fn) {
		return fn.apply(new Builder<>()).build();
	}

	/**
	 * Required - API name: {@code total}
	 */
	public final TotalHits total() {
		return this.total;
	}

	/**
	 * Required - API name: {@code hits}
	 */
	public final List<Hit<T>> hits() {
		return this.hits;
	}

	/**
	 * API name: {@code max_score}
	 */
	@Nullable
	public final Double maxScore() {
		return this.maxScore;
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

		generator.writeKey("total");
		this.total.serialize(generator, mapper);

		if (ModelTypeHelper.isDefined(this.hits)) {
			generator.writeKey("hits");
			generator.writeStartArray();
			for (Hit<T> item0 : this.hits) {
				item0.serialize(generator, mapper);

			}
			generator.writeEnd();

		}
		if (this.maxScore != null) {
			generator.writeKey("max_score");
			generator.write(this.maxScore);

		}

	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Builder for {@link HitsMetadata}.
	 */
	public static class Builder<T> extends ObjectBuilderBase implements ObjectBuilder<HitsMetadata<T>> {
		private TotalHits total;

		private List<Hit<T>> hits;

		@Nullable
		private Double maxScore;

		@Nullable
		private JsonpSerializer<T> tSerializer;

		/**
		 * Required - API name: {@code total}
		 */
		public final Builder<T> total(TotalHits value) {
			this.total = value;
			return this;
		}

		/**
		 * Required - API name: {@code total}
		 */
		public final Builder<T> total(Function<TotalHits.Builder, ObjectBuilder<TotalHits>> fn) {
			return this.total(fn.apply(new TotalHits.Builder()).build());
		}

		/**
		 * Required - API name: {@code hits}
		 */
		public final Builder<T> hits(List<Hit<T>> value) {
			this.hits = value;
			return this;
		}

		/**
		 * Required - API name: {@code hits}
		 */
		public final Builder<T> hits(Hit<T>... value) {
			this.hits = Arrays.asList(value);
			return this;
		}

		/**
		 * Required - API name: {@code hits}
		 */
		@SafeVarargs
		public final Builder<T> hits(Function<Hit.Builder<T>, ObjectBuilder<Hit<T>>>... fns) {
			this.hits = new ArrayList<>(fns.length);
			for (Function<Hit.Builder<T>, ObjectBuilder<Hit<T>>> fn : fns) {
				this.hits.add(fn.apply(new Hit.Builder<T>()).build());
			}
			return this;
		}

		/**
		 * API name: {@code max_score}
		 */
		public final Builder<T> maxScore(@Nullable Double value) {
			this.maxScore = value;
			return this;
		}

		/**
		 * Serializer for T. If not set, an attempt will be made to find a serializer
		 * from the JSON context.
		 */
		public final Builder<T> tSerializer(@Nullable JsonpSerializer<T> value) {
			this.tSerializer = value;
			return this;
		}

		/**
		 * Builds a {@link HitsMetadata}.
		 *
		 * @throws NullPointerException
		 *             if some of the required fields are null.
		 */
		public HitsMetadata<T> build() {
			_checkSingleUse();

			return new HitsMetadata<T>(this);
		}
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Create a json deserializer for HitsMetadata
	 */
	public static <T> JsonpDeserializer<HitsMetadata<T>> createHitsMetadataDeserializer(
			JsonpDeserializer<T> tDeserializer) {
		return ObjectBuilderDeserializer.createForObject((Supplier<Builder<T>>) Builder::new,
				op -> HitsMetadata.setupHitsMetadataDeserializer(op, tDeserializer));
	};

	protected static <T> void setupHitsMetadataDeserializer(DelegatingDeserializer<HitsMetadata.Builder<T>> op,
			JsonpDeserializer<T> tDeserializer) {

		op.add(Builder::total, TotalHits._DESERIALIZER, "total");
		op.add(Builder::hits, JsonpDeserializer.arrayDeserializer(Hit.createHitDeserializer(tDeserializer)), "hits");
		op.add(Builder::maxScore, JsonpDeserializer.doubleDeserializer(), "max_score");

	}

}
