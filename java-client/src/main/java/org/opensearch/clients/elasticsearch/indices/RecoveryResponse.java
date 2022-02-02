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

package org.opensearch.clients.elasticsearch.indices;

import org.opensearch.clients.elasticsearch.indices.recovery.RecoveryStatus;
import org.opensearch.clients.json.JsonpDeserializable;
import org.opensearch.clients.json.JsonpDeserializer;
import org.opensearch.clients.json.ObjectBuilderDeserializer;
import org.opensearch.clients.json.ObjectDeserializer;
import org.opensearch.clients.transport.endpoints.DictionaryResponse;
import org.opensearch.clients.util.ObjectBuilder;

import java.util.function.Function;

// typedef: indices.recovery.Response

@JsonpDeserializable
public class RecoveryResponse extends DictionaryResponse<String, RecoveryStatus> {
	// ---------------------------------------------------------------------------------------------

	private RecoveryResponse(Builder builder) {
		super(builder);

	}

	public static RecoveryResponse of(Function<Builder, ObjectBuilder<RecoveryResponse>> fn) {
		return fn.apply(new Builder()).build();
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Builder for {@link RecoveryResponse}.
	 */

	public static class Builder extends DictionaryResponse.AbstractBuilder<String, RecoveryStatus, Builder>
			implements
				ObjectBuilder<RecoveryResponse> {
		@Override
		protected Builder self() {
			return this;
		}

		/**
		 * Builds a {@link RecoveryResponse}.
		 *
		 * @throws NullPointerException
		 *             if some of the required fields are null.
		 */
		public RecoveryResponse build() {
			_checkSingleUse();
			super.tKeySerializer(null);
			super.tValueSerializer(null);

			return new RecoveryResponse(this);
		}
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Json deserializer for {@link RecoveryResponse}
	 */
	public static final JsonpDeserializer<RecoveryResponse> _DESERIALIZER = ObjectBuilderDeserializer.lazy(Builder::new,
			RecoveryResponse::setupRecoveryResponseDeserializer);

	protected static void setupRecoveryResponseDeserializer(ObjectDeserializer<RecoveryResponse.Builder> op) {
		DictionaryResponse.setupDictionaryResponseDeserializer(op, JsonpDeserializer.stringDeserializer(),
				RecoveryStatus._DESERIALIZER);

	}

}
