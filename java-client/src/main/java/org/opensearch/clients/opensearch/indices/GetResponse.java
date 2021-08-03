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

package org.opensearch.clients.opensearch.indices;

import org.opensearch.clients.base.AdditionalProperties;
import org.opensearch.clients.json.DelegatingDeserializer;
import org.opensearch.clients.json.JsonpDeserializer;
import org.opensearch.clients.json.ObjectBuilderDeserializer;
import org.opensearch.clients.util.ObjectBuilder;

// typedef: indices.get.Response
public final class GetResponse extends AdditionalProperties<String, IndexState> {
	// ---------------------------------------------------------------------------------------------

	protected GetResponse(Builder builder) {
		super(builder);

	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Builder for {@link GetResponse}.
	 */
	public static class Builder extends AdditionalProperties.AbstractBuilder<String, IndexState, Builder>
			implements
				ObjectBuilder<GetResponse> {
		@Override
		protected Builder self() {
			return this;
		}

		/**
		 * Builds a {@link GetResponse}.
		 *
		 * @throws NullPointerException
		 *             if some of the required fields are null.
		 */
		public GetResponse build() {
			super.tKeySerializer(null);
			super.tValueSerializer(null);

			return new GetResponse(this);
		}
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Json deserializer for GetResponse
	 */
	public static final JsonpDeserializer<GetResponse> DESERIALIZER = ObjectBuilderDeserializer
			.createForObject(Builder::new, GetResponse::setupGetResponseDeserializer);

	protected static void setupGetResponseDeserializer(DelegatingDeserializer<GetResponse.Builder> op) {
		AdditionalProperties.setupAdditionalPropertiesDeserializer(op, JsonpDeserializer.stringDeserializer(),
				IndexState.DESERIALIZER);

	}

}
