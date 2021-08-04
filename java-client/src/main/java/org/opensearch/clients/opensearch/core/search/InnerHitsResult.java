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
import org.opensearch.clients.json.JsonpDeserializable;
import org.opensearch.clients.json.JsonpDeserializer;
import org.opensearch.clients.json.JsonpMapper;
import org.opensearch.clients.json.JsonpSerializable;
import org.opensearch.clients.json.ObjectBuilderDeserializer;
import org.opensearch.clients.util.ModelTypeHelper;
import org.opensearch.clients.util.ObjectBuilder;
import org.opensearch.clients.util.ObjectBuilderBase;
import jakarta.json.stream.JsonGenerator;

import java.util.function.Function;

// typedef: _global.search._types.InnerHitsResult
@JsonpDeserializable
public class InnerHitsResult implements JsonpSerializable {
	private final InnerHitsMetadata hits;

	// ---------------------------------------------------------------------------------------------

	private InnerHitsResult(Builder builder) {

		this.hits = ModelTypeHelper.requireNonNull(builder.hits, this, "hits");

	}

	public static InnerHitsResult of(Function<Builder, ObjectBuilder<InnerHitsResult>> fn) {
		return fn.apply(new Builder()).build();
	}

	/**
	 * Required - API name: {@code hits}
	 */
	public final InnerHitsMetadata hits() {
		return this.hits;
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

		generator.writeKey("hits");
		this.hits.serialize(generator, mapper);

	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Builder for {@link InnerHitsResult}.
	 */
	public static class Builder extends ObjectBuilderBase implements ObjectBuilder<InnerHitsResult> {
		private InnerHitsMetadata hits;

		/**
		 * Required - API name: {@code hits}
		 */
		public final Builder hits(InnerHitsMetadata value) {
			this.hits = value;
			return this;
		}

		/**
		 * Required - API name: {@code hits}
		 */
		public final Builder hits(Function<InnerHitsMetadata.Builder, ObjectBuilder<InnerHitsMetadata>> fn) {
			return this.hits(fn.apply(new InnerHitsMetadata.Builder()).build());
		}

		/**
		 * Builds a {@link InnerHitsResult}.
		 *
		 * @throws NullPointerException
		 *             if some of the required fields are null.
		 */
		public InnerHitsResult build() {
			_checkSingleUse();

			return new InnerHitsResult(this);
		}
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Json deserializer for {@link InnerHitsResult}
	 */
	public static final JsonpDeserializer<InnerHitsResult> _DESERIALIZER = ObjectBuilderDeserializer.lazy(Builder::new,
			InnerHitsResult::setupInnerHitsResultDeserializer, Builder::build);

	protected static void setupInnerHitsResultDeserializer(DelegatingDeserializer<InnerHitsResult.Builder> op) {

		op.add(Builder::hits, InnerHitsMetadata._DESERIALIZER, "hits");

	}

}
