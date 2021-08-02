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

package org.opensearch.clients.opensearch.snapshot;

import org.opensearch.clients.opensearch._types.AcknowledgedResponseBase;
import org.opensearch.clients.json.DelegatingDeserializer;
import org.opensearch.clients.json.JsonpDeserializer;
import org.opensearch.clients.json.ObjectBuilderDeserializer;
import org.opensearch.clients.util.ObjectBuilder;

// typedef: snapshot.create_repository.Response
public final class CreateRepositoryResponse extends AcknowledgedResponseBase {
	// ---------------------------------------------------------------------------------------------

	protected CreateRepositoryResponse(Builder builder) {
		super(builder);

	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Builder for {@link CreateRepositoryResponse}.
	 */
	public static class Builder extends AcknowledgedResponseBase.AbstractBuilder<Builder>
			implements
				ObjectBuilder<CreateRepositoryResponse> {
		@Override
		protected Builder self() {
			return this;
		}

		/**
		 * Builds a {@link CreateRepositoryResponse}.
		 *
		 * @throws NullPointerException
		 *             if some of the required fields are null.
		 */
		public CreateRepositoryResponse build() {

			return new CreateRepositoryResponse(this);
		}
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Json deserializer for CreateRepositoryResponse
	 */
	public static final JsonpDeserializer<CreateRepositoryResponse> DESERIALIZER = ObjectBuilderDeserializer
			.createForObject(Builder::new, CreateRepositoryResponse::setupCreateRepositoryResponseDeserializer);

	protected static void setupCreateRepositoryResponseDeserializer(
			DelegatingDeserializer<CreateRepositoryResponse.Builder> op) {
		AcknowledgedResponseBase.setupAcknowledgedResponseBaseDeserializer(op);

	}

}
