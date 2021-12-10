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

package org.opensearch.client.opensearch.ingest;

import org.opensearch.client.opensearch._types.AcknowledgedResponseBase;
import org.opensearch.client.json.JsonpDeserializable;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.ObjectBuilderDeserializer;
import org.opensearch.client.json.ObjectDeserializer;
import org.opensearch.client.util.ObjectBuilder;

import java.util.function.Function;

// typedef: ingest.delete_pipeline.Response

/**
 *
 * @see <a href=
 *      "https://github.com/elastic/elasticsearch-specification/tree/98036c3/specification/ingest/delete_pipeline/DeletePipelineResponse.ts#L22-L22">API
 *      specification</a>
 */
@JsonpDeserializable
public class DeletePipelineResponse extends AcknowledgedResponseBase {
	// ---------------------------------------------------------------------------------------------

	private DeletePipelineResponse(Builder builder) {
		super(builder);

	}

	public static DeletePipelineResponse of(Function<Builder, ObjectBuilder<DeletePipelineResponse>> fn) {
		return fn.apply(new Builder()).build();
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Builder for {@link DeletePipelineResponse}.
	 */

	public static class Builder extends AcknowledgedResponseBase.AbstractBuilder<Builder>
			implements
				ObjectBuilder<DeletePipelineResponse> {
		@Override
		protected Builder self() {
			return this;
		}

		/**
		 * Builds a {@link DeletePipelineResponse}.
		 *
		 * @throws NullPointerException
		 *             if some of the required fields are null.
		 */
		public DeletePipelineResponse build() {
			_checkSingleUse();

			return new DeletePipelineResponse(this);
		}
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Json deserializer for {@link DeletePipelineResponse}
	 */
	public static final JsonpDeserializer<DeletePipelineResponse> _DESERIALIZER = ObjectBuilderDeserializer
			.lazy(Builder::new, DeletePipelineResponse::setupDeletePipelineResponseDeserializer);

	protected static void setupDeletePipelineResponseDeserializer(
			ObjectDeserializer<DeletePipelineResponse.Builder> op) {
		AcknowledgedResponseBase.setupAcknowledgedResponseBaseDeserializer(op);

	}

}
