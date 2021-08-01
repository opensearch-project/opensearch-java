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

package org.opensearch.clients.elasticsearch.shutdown;

import org.opensearch.clients.json.DelegatingDeserializer;
import org.opensearch.clients.json.JsonpDeserializer;
import org.opensearch.clients.json.JsonpMapper;
import org.opensearch.clients.json.ObjectBuilderDeserializer;
import org.opensearch.clients.json.ObjectDeserializer;
import org.opensearch.clients.json.ToJsonp;
import org.opensearch.clients.util.ObjectBuilder;
import jakarta.json.stream.JsonGenerator;
import java.lang.Boolean;
import java.util.Objects;
import javax.annotation.Nullable;

// typedef: shutdown.get_node.Response
public final class GetNodeResponse implements ToJsonp {
	private final Boolean stub;

	// ---------------------------------------------------------------------------------------------

	protected GetNodeResponse(Builder builder) {

		this.stub = Objects.requireNonNull(builder.stub, "stub");

	}

	/**
	 * API name: {@code stub}
	 */
	public Boolean stub() {
		return this.stub;
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

		generator.writeKey("stub");
		generator.write(this.stub);

	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Builder for {@link GetNodeResponse}.
	 */
	public static class Builder implements ObjectBuilder<GetNodeResponse> {
		private Boolean stub;

		/**
		 * API name: {@code stub}
		 */
		public Builder stub(Boolean value) {
			this.stub = value;
			return this;
		}

		/**
		 * Builds a {@link GetNodeResponse}.
		 *
		 * @throws NullPointerException
		 *             if some of the required fields are null.
		 */
		public GetNodeResponse build() {

			return new GetNodeResponse(this);
		}
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Json deserializer for GetNodeResponse
	 */
	public static final JsonpDeserializer<GetNodeResponse> DESERIALIZER = ObjectBuilderDeserializer
			.createForObject(Builder::new, GetNodeResponse::setupGetNodeResponseDeserializer);

	protected static void setupGetNodeResponseDeserializer(DelegatingDeserializer<GetNodeResponse.Builder> op) {

		op.add(Builder::stub, JsonpDeserializer.booleanDeserializer(), "stub");

	}

}
