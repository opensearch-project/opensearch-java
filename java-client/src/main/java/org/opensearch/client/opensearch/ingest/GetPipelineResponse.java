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

package org.opensearch.client.opensearch.ingest;

import org.opensearch.client.base.AdditionalProperties;
import org.opensearch.client.json.DelegatingDeserializer;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.ObjectBuilderDeserializer;
import org.opensearch.client.util.ObjectBuilder;

// typedef: ingest.get_pipeline.Response
public final class GetPipelineResponse extends AdditionalProperties<String, Pipeline> {
	// ---------------------------------------------------------------------------------------------

	protected GetPipelineResponse(Builder builder) {
		super(builder);

	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Builder for {@link GetPipelineResponse}.
	 */
	public static class Builder extends AdditionalProperties.AbstractBuilder<String, Pipeline, Builder>
			implements
				ObjectBuilder<GetPipelineResponse> {
		@Override
		protected Builder self() {
			return this;
		}

		/**
		 * Builds a {@link GetPipelineResponse}.
		 *
		 * @throws NullPointerException
		 *             if some of the required fields are null.
		 */
		public GetPipelineResponse build() {
			super.tKeySerializer(null);
			super.tValueSerializer(null);

			return new GetPipelineResponse(this);
		}
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Json deserializer for GetPipelineResponse
	 */
	public static final JsonpDeserializer<GetPipelineResponse> DESERIALIZER = ObjectBuilderDeserializer
			.createForObject(Builder::new, GetPipelineResponse::setupGetPipelineResponseDeserializer);

	protected static void setupGetPipelineResponseDeserializer(DelegatingDeserializer<GetPipelineResponse.Builder> op) {
		AdditionalProperties.setupAdditionalPropertiesDeserializer(op, JsonpDeserializer.stringDeserializer(),
				Pipeline.DESERIALIZER);

	}

}
