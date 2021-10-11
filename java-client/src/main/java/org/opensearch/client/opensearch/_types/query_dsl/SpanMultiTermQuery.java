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

package org.opensearch.client.opensearch._types.query_dsl;

import jakarta.json.stream.JsonGenerator;
import org.opensearch.client.json.DelegatingDeserializer;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.ObjectBuilderDeserializer;
import org.opensearch.client.util.ObjectBuilder;

import javax.annotation.Nullable;
import java.util.function.Function;

// typedef: _types.query_dsl.SpanMultiTermQuery
public final class SpanMultiTermQuery extends QueryBase {
	@Nullable
	private final QueryContainer match;

	// ---------------------------------------------------------------------------------------------

	protected SpanMultiTermQuery(Builder builder) {
		super(builder);
		this.match = builder.match;

	}

	/**
	 * API name: {@code match}
	 */
	@Nullable
	public QueryContainer match() {
		return this.match;
	}

	protected void toJsonpInternal(JsonGenerator generator, JsonpMapper mapper) {
		super.toJsonpInternal(generator, mapper);
		if (this.match != null) {

			generator.writeKey("match");
			this.match.toJsonp(generator, mapper);

		}

	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Builder for {@link SpanMultiTermQuery}.
	 */
	public static class Builder extends QueryBase.AbstractBuilder<Builder>
			implements
				ObjectBuilder<SpanMultiTermQuery> {
		@Nullable
		private QueryContainer match;

		/**
		 * API name: {@code match}
		 */
		public Builder match(@Nullable QueryContainer value) {
			this.match = value;
			return this;
		}

		/**
		 * API name: {@code match}
		 */
		public Builder match(Function<QueryContainer.Builder, ObjectBuilder<QueryContainer>> fn) {
			return this.match(fn.apply(new QueryContainer.Builder()).build());
		}

		@Override
		protected Builder self() {
			return this;
		}

		/**
		 * Builds a {@link SpanMultiTermQuery}.
		 *
		 * @throws NullPointerException
		 *             if some of the required fields are null.
		 */
		public SpanMultiTermQuery build() {

			return new SpanMultiTermQuery(this);
		}
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Json deserializer for SpanMultiTermQuery
	 */
	public static final JsonpDeserializer<SpanMultiTermQuery> DESERIALIZER = ObjectBuilderDeserializer
			.createForObject(Builder::new, SpanMultiTermQuery::setupSpanMultiTermQueryDeserializer);

	protected static void setupSpanMultiTermQueryDeserializer(DelegatingDeserializer<SpanMultiTermQuery.Builder> op) {
		QueryBase.setupQueryBaseDeserializer(op);
		op.add(Builder::match, QueryContainer.DESERIALIZER, "match");

	}

}
