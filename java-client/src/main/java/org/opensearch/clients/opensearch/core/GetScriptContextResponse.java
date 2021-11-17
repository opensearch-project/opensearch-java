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

package org.opensearch.clients.opensearch.core;

import org.opensearch.clients.opensearch.core.get_script_context.Context;
import org.opensearch.clients.json.DelegatingDeserializer;
import org.opensearch.clients.json.JsonpDeserializable;
import org.opensearch.clients.json.JsonpDeserializer;
import org.opensearch.clients.json.JsonpMapper;
import org.opensearch.clients.json.JsonpSerializable;
import org.opensearch.clients.json.ObjectBuilderDeserializer;
import org.opensearch.clients.util.ModelTypeHelper;
import org.opensearch.clients.util.ObjectBuilder;
import org.opensearch.clients.util.ObjectBuilderBase;
import jakarta.json.stream.JsonGenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

// typedef: _global.get_script_context.Response
@JsonpDeserializable
public class GetScriptContextResponse implements JsonpSerializable {
	private final List<Context> contexts;

	// ---------------------------------------------------------------------------------------------

	private GetScriptContextResponse(Builder builder) {

		this.contexts = ModelTypeHelper.unmodifiableRequired(builder.contexts, this, "contexts");

	}

	public static GetScriptContextResponse of(Function<Builder, ObjectBuilder<GetScriptContextResponse>> fn) {
		return fn.apply(new Builder()).build();
	}

	/**
	 * Required - API name: {@code contexts}
	 */
	public final List<Context> contexts() {
		return this.contexts;
	}

	/**
	 * Serialize this object to JSON.
	 */
	public void serialize(JsonGenerator generator, JsonpMapper mapper) {
		generator.writeStartObject();
		serializeInternal(generator, mapper);
		generator.writeEnd();
	}

	protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {

		if (ModelTypeHelper.isDefined(this.contexts)) {
			generator.writeKey("contexts");
			generator.writeStartArray();
			for (Context item0 : this.contexts) {
				item0.serialize(generator, mapper);

			}
			generator.writeEnd();

		}

	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Builder for {@link GetScriptContextResponse}.
	 */
	public static class Builder extends ObjectBuilderBase implements ObjectBuilder<GetScriptContextResponse> {
		private List<Context> contexts;

		/**
		 * Required - API name: {@code contexts}
		 */
		public final Builder contexts(List<Context> value) {
			this.contexts = value;
			return this;
		}

		/**
		 * Required - API name: {@code contexts}
		 */
		public final Builder contexts(Context... value) {
			this.contexts = Arrays.asList(value);
			return this;
		}

		/**
		 * Required - API name: {@code contexts}
		 */
		@SafeVarargs
		public final Builder contexts(Function<Context.Builder, ObjectBuilder<Context>>... fns) {
			this.contexts = new ArrayList<>(fns.length);
			for (Function<Context.Builder, ObjectBuilder<Context>> fn : fns) {
				this.contexts.add(fn.apply(new Context.Builder()).build());
			}
			return this;
		}

		/**
		 * Builds a {@link GetScriptContextResponse}.
		 *
		 * @throws NullPointerException
		 *             if some of the required fields are null.
		 */
		public GetScriptContextResponse build() {
			_checkSingleUse();

			return new GetScriptContextResponse(this);
		}
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Json deserializer for {@link GetScriptContextResponse}
	 */
	public static final JsonpDeserializer<GetScriptContextResponse> _DESERIALIZER = ObjectBuilderDeserializer
			.lazy(Builder::new, GetScriptContextResponse::setupGetScriptContextResponseDeserializer, Builder::build);

	protected static void setupGetScriptContextResponseDeserializer(
			DelegatingDeserializer<GetScriptContextResponse.Builder> op) {

		op.add(Builder::contexts, JsonpDeserializer.arrayDeserializer(Context._DESERIALIZER), "contexts");

	}

}
