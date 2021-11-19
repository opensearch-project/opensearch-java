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

import org.opensearch.client.json.DelegatingDeserializer;
import org.opensearch.client.json.JsonpDeserializable;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.ObjectBuilderDeserializer;
import org.opensearch.client.util.ModelTypeHelper;
import org.opensearch.client.util.ObjectBuilder;
import jakarta.json.JsonValue;
import jakarta.json.stream.JsonGenerator;
import java.lang.String;
import java.util.function.Function;

// typedef: _types.query_dsl.TermsQuery
@JsonpDeserializable
public class TermsQuery extends QueryBase implements QueryVariant {
	private final String field;

	private final JsonValue /*
							 * Union(Array<_types.long> | Array<internal.string> |
							 * _types.query_dsl.TermsLookup)
							 */ value;

	// ---------------------------------------------------------------------------------------------

	private TermsQuery(Builder builder) {
		super(builder);
		this.field = ModelTypeHelper.requireNonNull(builder.field, this, "field");
		this.value = ModelTypeHelper.requireNonNull(builder.value, this, "value");

	}

	public static TermsQuery of(Function<Builder, ObjectBuilder<TermsQuery>> fn) {
		return fn.apply(new Builder()).build();
	}

	/**
	 * {@link Query} variant type
	 */
	@Override
	public String _variantType() {
		return "terms";
	}

	/**
	 * Required -
	 */
	public final String field() {
		return this.field;
	}

	/**
	 * Required -
	 */
	public final JsonValue /*
							 * Union(Array<_types.long> | Array<internal.string> |
							 * _types.query_dsl.TermsLookup)
							 */ value() {
		return this.value;
	}

	protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
		generator.writeKey(this.field);
		generator.write(this.value);

		super.serializeInternal(generator, mapper);

	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Builder for {@link TermsQuery}.
	 */
	public static class Builder extends QueryBase.AbstractBuilder<Builder> implements ObjectBuilder<TermsQuery> {
		private String field;

		private JsonValue /*
							 * Union(Array<_types.long> | Array<internal.string> |
							 * _types.query_dsl.TermsLookup)
							 */ value;

		/**
		 * Required -
		 */
		public final Builder field(String value) {
			this.field = value;
			return this;
		}

		/**
		 * Required -
		 */
		public final Builder value(JsonValue /*
												 * Union(Array<_types.long> | Array<internal.string> |
												 * _types.query_dsl.TermsLookup)
												 */ value) {
			this.value = value;
			return this;
		}

		@Override
		protected Builder self() {
			return this;
		}

		/**
		 * Builds a {@link TermsQuery}.
		 *
		 * @throws NullPointerException
		 *             if some of the required fields are null.
		 */
		public TermsQuery build() {
			_checkSingleUse();

			return new TermsQuery(this);
		}
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Json deserializer for {@link TermsQuery}
	 */
	public static final JsonpDeserializer<TermsQuery> _DESERIALIZER = ObjectBuilderDeserializer.lazy(Builder::new,
			TermsQuery::setupTermsQueryDeserializer, Builder::build);

	protected static void setupTermsQueryDeserializer(DelegatingDeserializer<TermsQuery.Builder> op) {
		setupQueryBaseDeserializer(op);

		op.setUnknownFieldHandler((builder, name, parser, mapper) -> {
			builder.field(name);
			builder.value(JsonpDeserializer.jsonValueDeserializer().deserialize(parser, mapper));
		});

	}

}
