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

import org.opensearch.clients.opensearch.core.update_by_query_rethrottle.UpdateByQueryRethrottleNode;
import org.opensearch.clients.json.DelegatingDeserializer;
import org.opensearch.clients.json.JsonpDeserializable;
import org.opensearch.clients.json.JsonpDeserializer;
import org.opensearch.clients.json.JsonpMapper;
import org.opensearch.clients.json.JsonpSerializable;
import org.opensearch.clients.json.ObjectBuilderDeserializer;
import org.opensearch.clients.util.MapBuilder;
import org.opensearch.clients.util.ModelTypeHelper;
import org.opensearch.clients.util.ObjectBuilder;
import org.opensearch.clients.util.ObjectBuilderBase;
import jakarta.json.stream.JsonGenerator;

import java.lang.String;
import java.util.Collections;
import java.util.Map;
import java.util.function.Function;

// typedef: _global.update_by_query_rethrottle.Response
@JsonpDeserializable
public class UpdateByQueryRethrottleResponse implements JsonpSerializable {
	private final Map<String, UpdateByQueryRethrottleNode> nodes;

	// ---------------------------------------------------------------------------------------------

	private UpdateByQueryRethrottleResponse(Builder builder) {

		this.nodes = ModelTypeHelper.unmodifiableRequired(builder.nodes, this, "nodes");

	}

	public static UpdateByQueryRethrottleResponse of(
			Function<Builder, ObjectBuilder<UpdateByQueryRethrottleResponse>> fn) {
		return fn.apply(new Builder()).build();
	}

	/**
	 * Required - API name: {@code nodes}
	 */
	public final Map<String, UpdateByQueryRethrottleNode> nodes() {
		return this.nodes;
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

		if (ModelTypeHelper.isDefined(this.nodes)) {
			generator.writeKey("nodes");
			generator.writeStartObject();
			for (Map.Entry<String, UpdateByQueryRethrottleNode> item0 : this.nodes.entrySet()) {
				generator.writeKey(item0.getKey());
				item0.getValue().serialize(generator, mapper);

			}
			generator.writeEnd();

		}

	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Builder for {@link UpdateByQueryRethrottleResponse}.
	 */
	public static class Builder extends ObjectBuilderBase implements ObjectBuilder<UpdateByQueryRethrottleResponse> {
		private Map<String, UpdateByQueryRethrottleNode> nodes;

		/**
		 * Required - API name: {@code nodes}
		 */
		public final Builder nodes(Map<String, UpdateByQueryRethrottleNode> value) {
			this.nodes = value;
			return this;
		}

		/**
		 * Set {@link #nodes(Map)} to a singleton map.
		 */
		public Builder nodes(String key,
				Function<UpdateByQueryRethrottleNode.Builder, ObjectBuilder<UpdateByQueryRethrottleNode>> fn) {
			return this
					.nodes(Collections.singletonMap(key, fn.apply(new UpdateByQueryRethrottleNode.Builder()).build()));
		}

		public final Builder nodes(
				Function<MapBuilder<String, UpdateByQueryRethrottleNode, UpdateByQueryRethrottleNode.Builder>, ObjectBuilder<Map<String, UpdateByQueryRethrottleNode>>> fn) {
			return nodes(fn.apply(new MapBuilder<>(UpdateByQueryRethrottleNode.Builder::new)).build());
		}

		/**
		 * Builds a {@link UpdateByQueryRethrottleResponse}.
		 *
		 * @throws NullPointerException
		 *             if some of the required fields are null.
		 */
		public UpdateByQueryRethrottleResponse build() {
			_checkSingleUse();

			return new UpdateByQueryRethrottleResponse(this);
		}
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Json deserializer for {@link UpdateByQueryRethrottleResponse}
	 */
	public static final JsonpDeserializer<UpdateByQueryRethrottleResponse> _DESERIALIZER = ObjectBuilderDeserializer
			.lazy(Builder::new, UpdateByQueryRethrottleResponse::setupUpdateByQueryRethrottleResponseDeserializer,
					Builder::build);

	protected static void setupUpdateByQueryRethrottleResponseDeserializer(
			DelegatingDeserializer<UpdateByQueryRethrottleResponse.Builder> op) {

		op.add(Builder::nodes, JsonpDeserializer.stringMapDeserializer(UpdateByQueryRethrottleNode._DESERIALIZER),
				"nodes");

	}

}
