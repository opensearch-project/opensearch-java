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

import org.opensearch.clients.opensearch._types.WriteResponseBase;
import org.opensearch.clients.json.DelegatingDeserializer;
import org.opensearch.clients.json.JsonpDeserializable;
import org.opensearch.clients.json.JsonpDeserializer;
import org.opensearch.clients.json.ObjectBuilderDeserializer;
import org.opensearch.clients.util.ObjectBuilder;

import java.util.function.Function;

// typedef: _global.index.Response
@JsonpDeserializable
public class IndexResponse extends WriteResponseBase {
	// ---------------------------------------------------------------------------------------------

	private IndexResponse(Builder builder) {
		super(builder);

	}

	public static IndexResponse of(Function<Builder, ObjectBuilder<IndexResponse>> fn) {
		return fn.apply(new Builder()).build();
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Builder for {@link IndexResponse}.
	 */
	public static class Builder extends WriteResponseBase.AbstractBuilder<Builder>
			implements
				ObjectBuilder<IndexResponse> {
		@Override
		protected Builder self() {
			return this;
		}

		/**
		 * Builds a {@link IndexResponse}.
		 *
		 * @throws NullPointerException
		 *             if some of the required fields are null.
		 */
		public IndexResponse build() {
			_checkSingleUse();

			return new IndexResponse(this);
		}
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Json deserializer for {@link IndexResponse}
	 */
	public static final JsonpDeserializer<IndexResponse> _DESERIALIZER = ObjectBuilderDeserializer.lazy(Builder::new,
			IndexResponse::setupIndexResponseDeserializer, Builder::build);

	protected static void setupIndexResponseDeserializer(DelegatingDeserializer<IndexResponse.Builder> op) {
		WriteResponseBase.setupWriteResponseBaseDeserializer(op);

	}

}
