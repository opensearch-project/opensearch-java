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

package org.opensearch.clients.opensearch._types.query_dsl;

import org.opensearch.clients.json.DelegatingDeserializer;
import org.opensearch.clients.json.JsonpDeserializable;
import org.opensearch.clients.json.JsonpDeserializer;
import org.opensearch.clients.json.JsonpMapper;
import org.opensearch.clients.json.ObjectBuilderDeserializer;
import org.opensearch.clients.util.ModelTypeHelper;
import org.opensearch.clients.util.ObjectBuilder;
import jakarta.json.stream.JsonGenerator;

import java.util.function.Function;

// typedef: _types.query_dsl.SpanMultiTermQuery
@JsonpDeserializable
public class SpanMultiTermQuery extends QueryBase implements SpanQueryVariant, QueryVariant {
	private final Query match;

	// ---------------------------------------------------------------------------------------------

	private SpanMultiTermQuery(Builder builder) {
		super(builder);

		this.match = ModelTypeHelper.requireNonNull(builder.match, this, "match");

	}

	public static SpanMultiTermQuery of(Function<Builder, ObjectBuilder<SpanMultiTermQuery>> fn) {
		return fn.apply(new Builder()).build();
	}

	/**
	 * {@link SpanQuery}, {@link Query} variant type
	 */
	@Override
	public String _variantType() {
		return "span_multi";
	}

	/**
	 * Required - Should be a multi term query (one of wildcard, fuzzy, prefix,
	 * range or regexp query)
	 * <p>
	 * API name: {@code match}
	 */
	public final Query match() {
		return this.match;
	}

	protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {

		super.serializeInternal(generator, mapper);
		generator.writeKey("match");
		this.match.serialize(generator, mapper);

	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Builder for {@link SpanMultiTermQuery}.
	 */
	public static class Builder extends QueryBase.AbstractBuilder<Builder>
			implements
				ObjectBuilder<SpanMultiTermQuery> {
		private Query match;

		/**
		 * Required - Should be a multi term query (one of wildcard, fuzzy, prefix,
		 * range or regexp query)
		 * <p>
		 * API name: {@code match}
		 */
		public final Builder match(Query value) {
			this.match = value;
			return this;
		}

		/**
		 * Required - Should be a multi term query (one of wildcard, fuzzy, prefix,
		 * range or regexp query)
		 * <p>
		 * API name: {@code match}
		 */
		public final Builder match(Function<Query.Builder, ObjectBuilder<Query>> fn) {
			return this.match(fn.apply(new Query.Builder()).build());
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
			_checkSingleUse();

			return new SpanMultiTermQuery(this);
		}
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Json deserializer for {@link SpanMultiTermQuery}
	 */
	public static final JsonpDeserializer<SpanMultiTermQuery> _DESERIALIZER = ObjectBuilderDeserializer
			.lazy(Builder::new, SpanMultiTermQuery::setupSpanMultiTermQueryDeserializer, Builder::build);

	protected static void setupSpanMultiTermQueryDeserializer(DelegatingDeserializer<SpanMultiTermQuery.Builder> op) {
		QueryBase.setupQueryBaseDeserializer(op);
		op.add(Builder::match, Query._DESERIALIZER, "match");

	}

}
