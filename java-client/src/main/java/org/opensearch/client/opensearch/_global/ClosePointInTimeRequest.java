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

package org.opensearch.client.opensearch._global;

import jakarta.json.stream.JsonGenerator;
import org.opensearch.client.base.OpenSearchError;
import org.opensearch.client.base.Endpoint;
import org.opensearch.client.opensearch._types.RequestBase;
import org.opensearch.client.json.DelegatingDeserializer;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.ObjectBuilderDeserializer;
import org.opensearch.client.json.ToJsonp;
import org.opensearch.client.util.ObjectBuilder;

import java.util.Collections;
import java.util.Objects;

// typedef: _global.close_point_in_time.Request
public final class ClosePointInTimeRequest extends RequestBase implements ToJsonp {
	private final String id;

	// ---------------------------------------------------------------------------------------------

	protected ClosePointInTimeRequest(Builder builder) {

		this.id = Objects.requireNonNull(builder.id, "id");

	}

	/**
	 * API name: {@code id}
	 */
	public String id() {
		return this.id;
	}

	/**
	 * Serialize this object to JSON.
	 */
	public void toJsonp(JsonGenerator generator, JsonpMapper mapper) {
		generator.writeStartObject();
		toJsonpInternal(generator, mapper);
		generator.writeEnd();
	}

	protected void toJsonpInternal(JsonGenerator generator, JsonpMapper mapper) {

		generator.writeKey("id");
		generator.write(this.id);

	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Builder for {@link ClosePointInTimeRequest}.
	 */
	public static class Builder implements ObjectBuilder<ClosePointInTimeRequest> {
		private String id;

		/**
		 * API name: {@code id}
		 */
		public Builder id(String value) {
			this.id = value;
			return this;
		}

		/**
		 * Builds a {@link ClosePointInTimeRequest}.
		 *
		 * @throws NullPointerException
		 *             if some of the required fields are null.
		 */
		public ClosePointInTimeRequest build() {

			return new ClosePointInTimeRequest(this);
		}
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Json deserializer for ClosePointInTimeRequest
	 */
	public static final JsonpDeserializer<ClosePointInTimeRequest> DESERIALIZER = ObjectBuilderDeserializer
			.createForObject(Builder::new, ClosePointInTimeRequest::setupClosePointInTimeRequestDeserializer);

	protected static void setupClosePointInTimeRequestDeserializer(
			DelegatingDeserializer<ClosePointInTimeRequest.Builder> op) {

		op.add(Builder::id, JsonpDeserializer.stringDeserializer(), "id");

	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Endpoint "{@code close_point_in_time}".
	 */
	public static final Endpoint<ClosePointInTimeRequest, ClosePointInTimeResponse, OpenSearchError> ENDPOINT = new Endpoint.Simple<>(
			// Request method
			request -> {
				return "DELETE";

			},

			// Request path
			request -> {
				return "/_pit";

			},

			// Request parameters
			request -> {
				return Collections.emptyMap();

			}, Endpoint.Simple.emptyMap(), true, ClosePointInTimeResponse.DESERIALIZER);
}
