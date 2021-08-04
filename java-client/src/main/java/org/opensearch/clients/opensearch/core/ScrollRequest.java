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

import org.opensearch.clients.opensearch._types.ErrorResponse;
import org.opensearch.clients.opensearch._types.RequestBase;
import org.opensearch.clients.opensearch._types.Time;
import org.opensearch.clients.json.JsonpDeserializable;
import org.opensearch.clients.json.JsonpDeserializer;
import org.opensearch.clients.json.JsonpMapper;
import org.opensearch.clients.json.JsonpSerializable;
import org.opensearch.clients.json.ObjectBuilderDeserializer;
import org.opensearch.clients.json.ObjectDeserializer;
import org.opensearch.clients.transport.Endpoint;
import org.opensearch.clients.transport.endpoints.SimpleEndpoint;
import org.opensearch.clients.util.ApiTypeHelper;
import org.opensearch.clients.util.ObjectBuilder;
import org.opensearch.clients.util.ObjectBuilderBase;
import jakarta.json.stream.JsonGenerator;

import java.util.Collections;
import java.util.function.Function;
import javax.annotation.Nullable;

// typedef: _global.scroll.Request

/**
 * Allows to retrieve a large numbers of results from a single search request.
 * 
 * @see <a href=
 *      "https://github.com/elastic/elasticsearch-specification/tree/98036c3/specification/_global/scroll/ScrollRequest.ts#L24-L59">API
 *      specification</a>
 */
@JsonpDeserializable
public class ScrollRequest extends RequestBase implements JsonpSerializable {
	@Nullable
	private final Time scroll;

	private final String scrollId;

	// ---------------------------------------------------------------------------------------------

	private ScrollRequest(Builder builder) {

		this.scroll = builder.scroll;
		this.scrollId = ApiTypeHelper.requireNonNull(builder.scrollId, this, "scrollId");

	}

	public static ScrollRequest of(Function<Builder, ObjectBuilder<ScrollRequest>> fn) {
		return fn.apply(new Builder()).build();
	}

	/**
	 * Period to retain the search context for scrolling.
	 * <p>
	 * API name: {@code scroll}
	 */
	@Nullable
	public final Time scroll() {
		return this.scroll;
	}

	/**
	 * Required - Scroll ID of the search.
	 * <p>
	 * API name: {@code scroll_id}
	 */
	public final String scrollId() {
		return this.scrollId;
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

		if (this.scroll != null) {
			generator.writeKey("scroll");
			this.scroll.serialize(generator, mapper);

		}
		generator.writeKey("scroll_id");
		generator.write(this.scrollId);

	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Builder for {@link ScrollRequest}.
	 */

	public static class Builder extends ObjectBuilderBase implements ObjectBuilder<ScrollRequest> {
		@Nullable
		private Time scroll;

		private String scrollId;

		/**
		 * Period to retain the search context for scrolling.
		 * <p>
		 * API name: {@code scroll}
		 */
		public final Builder scroll(@Nullable Time value) {
			this.scroll = value;
			return this;
		}

		/**
		 * Period to retain the search context for scrolling.
		 * <p>
		 * API name: {@code scroll}
		 */
		public final Builder scroll(Function<Time.Builder, ObjectBuilder<Time>> fn) {
			return this.scroll(fn.apply(new Time.Builder()).build());
		}

		/**
		 * Required - Scroll ID of the search.
		 * <p>
		 * API name: {@code scroll_id}
		 */
		public final Builder scrollId(String value) {
			this.scrollId = value;
			return this;
		}

		/**
		 * Builds a {@link ScrollRequest}.
		 *
		 * @throws NullPointerException
		 *             if some of the required fields are null.
		 */
		public ScrollRequest build() {
			_checkSingleUse();

			return new ScrollRequest(this);
		}
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Json deserializer for {@link ScrollRequest}
	 */
	public static final JsonpDeserializer<ScrollRequest> _DESERIALIZER = ObjectBuilderDeserializer.lazy(Builder::new,
			ScrollRequest::setupScrollRequestDeserializer);

	protected static void setupScrollRequestDeserializer(ObjectDeserializer<ScrollRequest.Builder> op) {

		op.add(Builder::scroll, Time._DESERIALIZER, "scroll");
		op.add(Builder::scrollId, JsonpDeserializer.stringDeserializer(), "scroll_id");

	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Endpoint "{@code scroll}".
	 */
	public static final SimpleEndpoint<ScrollRequest, ?> _ENDPOINT = new SimpleEndpoint<>("es/scroll",

			// Request method
			request -> {
				return "POST";

			},

			// Request path
			request -> {
				return "/_search/scroll";

			},

			// Request parameters
			request -> {
				return Collections.emptyMap();

			}, SimpleEndpoint.emptyMap(), true, ScrollResponse._DESERIALIZER);

	/**
	 * Create an "{@code scroll}" endpoint.
	 */
	public static <TDocument> Endpoint<ScrollRequest, ScrollResponse<TDocument>, ErrorResponse> createScrollEndpoint(
			JsonpDeserializer<TDocument> tDocumentDeserializer) {
		return _ENDPOINT
				.withResponseDeserializer(ScrollResponse.createScrollResponseDeserializer(tDocumentDeserializer));
	}
}
