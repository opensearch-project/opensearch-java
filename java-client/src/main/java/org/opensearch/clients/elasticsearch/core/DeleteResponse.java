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

package org.opensearch.clients.elasticsearch.core;

import org.opensearch.clients.elasticsearch._types.WriteResponseBase;
import org.opensearch.clients.json.JsonpDeserializable;
import org.opensearch.clients.json.JsonpDeserializer;
import org.opensearch.clients.json.ObjectBuilderDeserializer;
import org.opensearch.clients.json.ObjectDeserializer;
import org.opensearch.clients.util.ObjectBuilder;

import java.util.function.Function;

// typedef: _global.delete.Response

/**
 *
 * @see <a href=
 *      "https://github.com/elastic/elasticsearch-specification/tree/98036c3/specification/_global/delete/DeleteResponse.ts#L22-L22">API
 *      specification</a>
 */
@JsonpDeserializable
public class DeleteResponse extends WriteResponseBase {
	// ---------------------------------------------------------------------------------------------

	private DeleteResponse(Builder builder) {
		super(builder);

	}

	public static DeleteResponse of(Function<Builder, ObjectBuilder<DeleteResponse>> fn) {
		return fn.apply(new Builder()).build();
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Builder for {@link DeleteResponse}.
	 */

	public static class Builder extends WriteResponseBase.AbstractBuilder<Builder>
			implements
				ObjectBuilder<DeleteResponse> {
		@Override
		protected Builder self() {
			return this;
		}

		/**
		 * Builds a {@link DeleteResponse}.
		 *
		 * @throws NullPointerException
		 *             if some of the required fields are null.
		 */
		public DeleteResponse build() {
			_checkSingleUse();

			return new DeleteResponse(this);
		}
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Json deserializer for {@link DeleteResponse}
	 */
	public static final JsonpDeserializer<DeleteResponse> _DESERIALIZER = ObjectBuilderDeserializer.lazy(Builder::new,
			DeleteResponse::setupDeleteResponseDeserializer);

	protected static void setupDeleteResponseDeserializer(ObjectDeserializer<DeleteResponse.Builder> op) {
		WriteResponseBase.setupWriteResponseBaseDeserializer(op);

	}

}
