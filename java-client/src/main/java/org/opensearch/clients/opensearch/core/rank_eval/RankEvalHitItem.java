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

package org.opensearch.clients.opensearch.core.rank_eval;

import org.opensearch.clients.json.JsonpDeserializable;
import org.opensearch.clients.json.JsonpDeserializer;
import org.opensearch.clients.json.JsonpMapper;
import org.opensearch.clients.json.JsonpSerializable;
import org.opensearch.clients.json.ObjectBuilderDeserializer;
import org.opensearch.clients.json.ObjectDeserializer;
import org.opensearch.clients.util.ApiTypeHelper;
import org.opensearch.clients.util.ObjectBuilder;
import org.opensearch.clients.util.ObjectBuilderBase;
import jakarta.json.stream.JsonGenerator;
import java.lang.Double;
import java.util.function.Function;
import javax.annotation.Nullable;

// typedef: _global.rank_eval.RankEvalHitItem

/**
 *
 * @see <a href=
 *      "https://github.com/elastic/elasticsearch-specification/tree/98036c3/specification/_global/rank_eval/types.ts#L136-L139">API
 *      specification</a>
 */
@JsonpDeserializable
public class RankEvalHitItem implements JsonpSerializable {
	private final RankEvalHit hit;

	@Nullable
	private final Double rating;

	// ---------------------------------------------------------------------------------------------

	private RankEvalHitItem(Builder builder) {

		this.hit = ApiTypeHelper.requireNonNull(builder.hit, this, "hit");
		this.rating = builder.rating;

	}

	public static RankEvalHitItem of(Function<Builder, ObjectBuilder<RankEvalHitItem>> fn) {
		return fn.apply(new Builder()).build();
	}

	/**
	 * Required - API name: {@code hit}
	 */
	public final RankEvalHit hit() {
		return this.hit;
	}

	/**
	 * API name: {@code rating}
	 */
	@Nullable
	public final Double rating() {
		return this.rating;
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

		generator.writeKey("hit");
		this.hit.serialize(generator, mapper);

		if (this.rating != null) {
			generator.writeKey("rating");
			generator.write(this.rating);

		}

	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Builder for {@link RankEvalHitItem}.
	 */

	public static class Builder extends ObjectBuilderBase implements ObjectBuilder<RankEvalHitItem> {
		private RankEvalHit hit;

		@Nullable
		private Double rating;

		/**
		 * Required - API name: {@code hit}
		 */
		public final Builder hit(RankEvalHit value) {
			this.hit = value;
			return this;
		}

		/**
		 * Required - API name: {@code hit}
		 */
		public final Builder hit(Function<RankEvalHit.Builder, ObjectBuilder<RankEvalHit>> fn) {
			return this.hit(fn.apply(new RankEvalHit.Builder()).build());
		}

		/**
		 * API name: {@code rating}
		 */
		public final Builder rating(@Nullable Double value) {
			this.rating = value;
			return this;
		}

		/**
		 * Builds a {@link RankEvalHitItem}.
		 *
		 * @throws NullPointerException
		 *             if some of the required fields are null.
		 */
		public RankEvalHitItem build() {
			_checkSingleUse();

			return new RankEvalHitItem(this);
		}
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Json deserializer for {@link RankEvalHitItem}
	 */
	public static final JsonpDeserializer<RankEvalHitItem> _DESERIALIZER = ObjectBuilderDeserializer.lazy(Builder::new,
			RankEvalHitItem::setupRankEvalHitItemDeserializer);

	protected static void setupRankEvalHitItemDeserializer(ObjectDeserializer<RankEvalHitItem.Builder> op) {

		op.add(Builder::hit, RankEvalHit._DESERIALIZER, "hit");
		op.add(Builder::rating, JsonpDeserializer.doubleDeserializer(), "rating");

	}

}
