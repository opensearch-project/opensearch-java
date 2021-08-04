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

import org.opensearch.clients.json.JsonpDeserializable;
import org.opensearch.clients.json.JsonpDeserializer;
import org.opensearch.clients.json.ObjectBuilderDeserializer;
import org.opensearch.clients.json.ObjectDeserializer;
import org.opensearch.clients.transport.endpoints.DictionaryResponse;
import org.opensearch.clients.util.ObjectBuilder;

import java.lang.String;
import java.util.function.Function;

// typedef: indices.get_settings.Response

/**
 *
 * @see <a href=
 *      "https://github.com/elastic/elasticsearch-specification/tree/98036c3/specification/indices/get_settings/IndicesGetSettingsResponse.ts#L24-L24">API
 *      specification</a>
 */
@JsonpDeserializable
public class GetIndicesSettingsResponse extends DictionaryResponse<String, IndexState> {
	// ---------------------------------------------------------------------------------------------

	private GetIndicesSettingsResponse(Builder builder) {
		super(builder);

	}

	public static GetIndicesSettingsResponse of(Function<Builder, ObjectBuilder<GetIndicesSettingsResponse>> fn) {
		return fn.apply(new Builder()).build();
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Builder for {@link GetIndicesSettingsResponse}.
	 */

	public static class Builder extends DictionaryResponse.AbstractBuilder<String, IndexState, Builder>
			implements
				ObjectBuilder<GetIndicesSettingsResponse> {
		@Override
		protected Builder self() {
			return this;
		}

		/**
		 * Builds a {@link GetIndicesSettingsResponse}.
		 *
		 * @throws NullPointerException
		 *             if some of the required fields are null.
		 */
		public GetIndicesSettingsResponse build() {
			_checkSingleUse();
			super.tKeySerializer(null);
			super.tValueSerializer(null);

			return new GetIndicesSettingsResponse(this);
		}
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Json deserializer for {@link GetIndicesSettingsResponse}
	 */
	public static final JsonpDeserializer<GetIndicesSettingsResponse> _DESERIALIZER = ObjectBuilderDeserializer
			.lazy(Builder::new, GetIndicesSettingsResponse::setupGetIndicesSettingsResponseDeserializer);

	protected static void setupGetIndicesSettingsResponseDeserializer(
			ObjectDeserializer<GetIndicesSettingsResponse.Builder> op) {
		DictionaryResponse.setupDictionaryResponseDeserializer(op, JsonpDeserializer.stringDeserializer(),
				IndexState._DESERIALIZER);

	}

}
