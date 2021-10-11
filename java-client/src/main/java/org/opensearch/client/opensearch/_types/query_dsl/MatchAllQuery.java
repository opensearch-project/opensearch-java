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

// typedef: _types.query_dsl.MatchAllQuery
public final class MatchAllQuery extends QueryBase {
	@Nullable
	private final String normField;

	// ---------------------------------------------------------------------------------------------

	protected MatchAllQuery(Builder builder) {
		super(builder);
		this.normField = builder.normField;

	}

	/**
	 * API name: {@code norm_field}
	 */
	@Nullable
	public String normField() {
		return this.normField;
	}

	protected void toJsonpInternal(JsonGenerator generator, JsonpMapper mapper) {
		super.toJsonpInternal(generator, mapper);
		if (this.normField != null) {

			generator.writeKey("norm_field");
			generator.write(this.normField);

		}

	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Builder for {@link MatchAllQuery}.
	 */
	public static class Builder extends QueryBase.AbstractBuilder<Builder> implements ObjectBuilder<MatchAllQuery> {
		@Nullable
		private String normField;

		/**
		 * API name: {@code norm_field}
		 */
		public Builder normField(@Nullable String value) {
			this.normField = value;
			return this;
		}

		@Override
		protected Builder self() {
			return this;
		}

		/**
		 * Builds a {@link MatchAllQuery}.
		 *
		 * @throws NullPointerException
		 *             if some of the required fields are null.
		 */
		public MatchAllQuery build() {

			return new MatchAllQuery(this);
		}
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Json deserializer for MatchAllQuery
	 */
	public static final JsonpDeserializer<MatchAllQuery> DESERIALIZER = ObjectBuilderDeserializer
			.createForObject(Builder::new, MatchAllQuery::setupMatchAllQueryDeserializer);

	protected static void setupMatchAllQueryDeserializer(DelegatingDeserializer<MatchAllQuery.Builder> op) {
		QueryBase.setupQueryBaseDeserializer(op);
		op.add(Builder::normField, JsonpDeserializer.stringDeserializer(), "norm_field");

	}

}
