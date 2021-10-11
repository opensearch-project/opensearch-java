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

package org.opensearch.client.opensearch.indices;

import jakarta.json.stream.JsonGenerator;
import org.opensearch.client.opensearch._types.AcknowledgedResponseBase;
import org.opensearch.client.json.DelegatingDeserializer;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.ObjectBuilderDeserializer;
import org.opensearch.client.util.ObjectBuilder;

import java.util.Objects;

// typedef: indices.create.Response
public final class CreateResponse extends AcknowledgedResponseBase {
	private final String index;

	private final Boolean shardsAcknowledged;

	// ---------------------------------------------------------------------------------------------

	protected CreateResponse(Builder builder) {
		super(builder);
		this.index = Objects.requireNonNull(builder.index, "index");
		this.shardsAcknowledged = Objects.requireNonNull(builder.shardsAcknowledged, "shards_acknowledged");

	}

	/**
	 * API name: {@code index}
	 */
	public String index() {
		return this.index;
	}

	/**
	 * API name: {@code shards_acknowledged}
	 */
	public Boolean shardsAcknowledged() {
		return this.shardsAcknowledged;
	}

	protected void toJsonpInternal(JsonGenerator generator, JsonpMapper mapper) {
		super.toJsonpInternal(generator, mapper);

		generator.writeKey("index");
		generator.write(this.index);

		generator.writeKey("shards_acknowledged");
		generator.write(this.shardsAcknowledged);

	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Builder for {@link CreateResponse}.
	 */
	public static class Builder extends AcknowledgedResponseBase.AbstractBuilder<Builder>
			implements
				ObjectBuilder<CreateResponse> {
		private String index;

		private Boolean shardsAcknowledged;

		/**
		 * API name: {@code index}
		 */
		public Builder index(String value) {
			this.index = value;
			return this;
		}

		/**
		 * API name: {@code shards_acknowledged}
		 */
		public Builder shardsAcknowledged(Boolean value) {
			this.shardsAcknowledged = value;
			return this;
		}

		@Override
		protected Builder self() {
			return this;
		}

		/**
		 * Builds a {@link CreateResponse}.
		 *
		 * @throws NullPointerException
		 *             if some of the required fields are null.
		 */
		public CreateResponse build() {

			return new CreateResponse(this);
		}
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Json deserializer for CreateResponse
	 */
	public static final JsonpDeserializer<CreateResponse> DESERIALIZER = ObjectBuilderDeserializer
			.createForObject(Builder::new, CreateResponse::setupCreateResponseDeserializer);

	protected static void setupCreateResponseDeserializer(DelegatingDeserializer<CreateResponse.Builder> op) {
		AcknowledgedResponseBase.setupAcknowledgedResponseBaseDeserializer(op);
		op.add(Builder::index, JsonpDeserializer.stringDeserializer(), "index");
		op.add(Builder::shardsAcknowledged, JsonpDeserializer.booleanDeserializer(), "shards_acknowledged");

	}

}
