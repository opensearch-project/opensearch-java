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

package org.opensearch.client.opensearch._global;

import jakarta.json.stream.JsonGenerator;
import org.opensearch.client.json.DelegatingDeserializer;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.JsonpSerializer;
import org.opensearch.client.json.JsonpUtils;
import org.opensearch.client.json.ObjectBuilderDeserializer;
import org.opensearch.client.json.ToJsonp;
import org.opensearch.client.util.ObjectBuilder;

import javax.annotation.Nullable;
import java.util.Objects;
import java.util.function.Supplier;

// typedef: _global.scripts_painless_execute.Response
public final class ScriptsPainlessExecuteResponse<TResult> implements ToJsonp {
	private final TResult result;

	@Nullable
	private final JsonpSerializer<TResult> tResultSerializer;

	// ---------------------------------------------------------------------------------------------

	protected ScriptsPainlessExecuteResponse(Builder<TResult> builder) {

		this.result = Objects.requireNonNull(builder.result, "result");
		this.tResultSerializer = builder.tResultSerializer;

	}

	/**
	 * API name: {@code result}
	 */
	public TResult result() {
		return this.result;
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

		generator.writeKey("result");
		JsonpUtils.serialize(this.result, generator, tResultSerializer, mapper);

	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Builder for {@link ScriptsPainlessExecuteResponse}.
	 */
	public static class Builder<TResult> implements ObjectBuilder<ScriptsPainlessExecuteResponse<TResult>> {
		private TResult result;

		@Nullable
		private JsonpSerializer<TResult> tResultSerializer;

		/**
		 * API name: {@code result}
		 */
		public Builder<TResult> result(TResult value) {
			this.result = value;
			return this;
		}

		/**
		 * Serializer for TResult. If not set, an attempt will be made to find a
		 * serializer from the JSON context.
		 *
		 */
		public Builder<TResult> tResultSerializer(@Nullable JsonpSerializer<TResult> value) {
			this.tResultSerializer = value;
			return this;
		}

		/**
		 * Builds a {@link ScriptsPainlessExecuteResponse}.
		 *
		 * @throws NullPointerException
		 *             if some of the required fields are null.
		 */
		public ScriptsPainlessExecuteResponse<TResult> build() {

			return new ScriptsPainlessExecuteResponse<TResult>(this);
		}
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Create a json deserializer for ScriptsPainlessExecuteResponse
	 */
	public static <TResult> JsonpDeserializer<ScriptsPainlessExecuteResponse<TResult>> createScriptsPainlessExecuteResponseDeserializer(
			JsonpDeserializer<TResult> tResultDeserializer) {
		return ObjectBuilderDeserializer.createForObject((Supplier<Builder<TResult>>) Builder::new,
				op -> ScriptsPainlessExecuteResponse.setupScriptsPainlessExecuteResponseDeserializer(op,
						tResultDeserializer));
	};

	protected static <TResult> void setupScriptsPainlessExecuteResponseDeserializer(
			DelegatingDeserializer<ScriptsPainlessExecuteResponse.Builder<TResult>> op,
			JsonpDeserializer<TResult> tResultDeserializer) {

		op.add(Builder::result, tResultDeserializer, "result");

	}

}
