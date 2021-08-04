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

package org.opensearch.clients.opensearch.core;

import org.opensearch.clients.json.JsonpDeserializer;
import org.opensearch.clients.json.JsonpMapper;
import org.opensearch.clients.json.JsonpSerializable;
import org.opensearch.clients.json.JsonpSerializer;
import org.opensearch.clients.json.JsonpUtils;
import org.opensearch.clients.util.ModelTypeHelper;
import org.opensearch.clients.util.ObjectBuilder;
import org.opensearch.clients.util.ObjectBuilderBase;
import jakarta.json.stream.JsonGenerator;

import java.util.function.Function;
import javax.annotation.Nullable;

// typedef: _global.get_source.Response

public class GetSourceResponse<TDocument> implements JsonpSerializable {
	private final TDocument valueBody;

	@Nullable
	private final JsonpSerializer<TDocument> tDocumentSerializer;

	// ---------------------------------------------------------------------------------------------

	private GetSourceResponse(Builder<TDocument> builder) {

		this.valueBody = ModelTypeHelper.requireNonNull(builder.valueBody, this, "valueBody");
		this.tDocumentSerializer = builder.tDocumentSerializer;

	}

	public static <TDocument> GetSourceResponse<TDocument> of(
			Function<Builder<TDocument>, ObjectBuilder<GetSourceResponse<TDocument>>> fn) {
		return fn.apply(new Builder<>()).build();
	}

	/**
	 * Required - Response value.
	 * <p>
	 * API name: {@code _value_body}
	 */
	public final TDocument valueBody() {
		return this.valueBody;
	}

	/**
	 * Serialize this value to JSON.
	 */
	public void serialize(JsonGenerator generator, JsonpMapper mapper) {
		JsonpUtils.serialize(this.valueBody, generator, tDocumentSerializer, mapper);

	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Builder for {@link GetSourceResponse}.
	 */
	public static class Builder<TDocument> extends ObjectBuilderBase
			implements
				ObjectBuilder<GetSourceResponse<TDocument>> {
		private TDocument valueBody;

		@Nullable
		private JsonpSerializer<TDocument> tDocumentSerializer;

		/**
		 * Required - Response value.
		 * <p>
		 * API name: {@code _value_body}
		 */
		public final Builder<TDocument> valueBody(TDocument value) {
			this.valueBody = value;
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
		 * Builds a {@link GetSourceResponse}.
		 *
		 * @throws NullPointerException
		 *             if some of the required fields are null.
		 */
		public GetSourceResponse<TDocument> build() {
			_checkSingleUse();

			return new GetSourceResponse<TDocument>(this);
		}
	}

	public static <TDocument> JsonpDeserializer<GetSourceResponse<TDocument>> createGetSourceResponseDeserializer(
			JsonpDeserializer<TDocument> tDocumentDeserializer) {

		JsonpDeserializer<TDocument> valueDeserializer = tDocumentDeserializer;

		return JsonpDeserializer.of(valueDeserializer.acceptedEvents(),
				(parser, mapper, event) -> new Builder<TDocument>()
						.valueBody(valueDeserializer.deserialize(parser, mapper, event)).build());
	}

}
