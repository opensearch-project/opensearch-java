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

package org.opensearch.clients.opensearch.cluster;

import jakarta.json.stream.JsonGenerator;
import org.opensearch.clients.json.DelegatingDeserializer;
import org.opensearch.clients.json.JsonpDeserializer;
import org.opensearch.clients.json.JsonpMapper;
import org.opensearch.clients.json.ObjectBuilderDeserializer;
import org.opensearch.clients.json.ToJsonp;
import org.opensearch.clients.util.ObjectBuilder;

import java.util.Objects;

// typedef: cluster.exists_component_template.Response
public final class ExistsComponentTemplateResponse implements ToJsonp {
	private final Number stub;

	// ---------------------------------------------------------------------------------------------

	protected ExistsComponentTemplateResponse(Builder builder) {

		this.stub = Objects.requireNonNull(builder.stub, "stub");

	}

	/**
	 * API name: {@code stub}
	 */
	public Number stub() {
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
		generator.write(this.stub.doubleValue());

	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Builder for {@link ExistsComponentTemplateResponse}.
	 */
	public static class Builder implements ObjectBuilder<ExistsComponentTemplateResponse> {
		private Number stub;

		/**
		 * API name: {@code stub}
		 */
		public Builder stub(Number value) {
			this.stub = value;
			return this;
		}

		/**
		 * Builds a {@link ExistsComponentTemplateResponse}.
		 *
		 * @throws NullPointerException
		 *             if some of the required fields are null.
		 */
		public ExistsComponentTemplateResponse build() {

			return new ExistsComponentTemplateResponse(this);
		}
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Json deserializer for ExistsComponentTemplateResponse
	 */
	public static final JsonpDeserializer<ExistsComponentTemplateResponse> DESERIALIZER = ObjectBuilderDeserializer
			.createForObject(Builder::new,
					ExistsComponentTemplateResponse::setupExistsComponentTemplateResponseDeserializer);

	protected static void setupExistsComponentTemplateResponseDeserializer(
			DelegatingDeserializer<ExistsComponentTemplateResponse.Builder> op) {

		op.add(Builder::stub, JsonpDeserializer.numberDeserializer(), "stub");

	}

}
