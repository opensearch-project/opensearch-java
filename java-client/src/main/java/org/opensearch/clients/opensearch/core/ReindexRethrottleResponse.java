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

import org.opensearch.clients.opensearch.core.reindex_rethrottle.ReindexNode;
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

// typedef: _global.reindex_rethrottle.Response
@JsonpDeserializable
public class ReindexRethrottleResponse implements JsonpSerializable {
	private final Map<String, ReindexNode> nodes;

	// ---------------------------------------------------------------------------------------------

	private ReindexRethrottleResponse(Builder builder) {

		this.nodes = ModelTypeHelper.unmodifiableRequired(builder.nodes, this, "nodes");

	}

	public static ReindexRethrottleResponse of(Function<Builder, ObjectBuilder<ReindexRethrottleResponse>> fn) {
		return fn.apply(new Builder()).build();
	}

	/**
	 * Required - API name: {@code nodes}
	 */
	public final Map<String, ReindexNode> nodes() {
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
			for (Map.Entry<String, ReindexNode> item0 : this.nodes.entrySet()) {
				generator.writeKey(item0.getKey());
				item0.getValue().serialize(generator, mapper);

			}
			generator.writeEnd();

		}

	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Builder for {@link ReindexRethrottleResponse}.
	 */
	public static class Builder extends ObjectBuilderBase implements ObjectBuilder<ReindexRethrottleResponse> {
		private Map<String, ReindexNode> nodes;

		/**
		 * Required - API name: {@code nodes}
		 */
		public final Builder nodes(Map<String, ReindexNode> value) {
			this.nodes = value;
			return this;
		}

		/**
		 * Set {@link #nodes(Map)} to a singleton map.
		 */
		public Builder nodes(String key, Function<ReindexNode.Builder, ObjectBuilder<ReindexNode>> fn) {
			return this.nodes(Collections.singletonMap(key, fn.apply(new ReindexNode.Builder()).build()));
		}

		public final Builder nodes(
				Function<MapBuilder<String, ReindexNode, ReindexNode.Builder>, ObjectBuilder<Map<String, ReindexNode>>> fn) {
			return nodes(fn.apply(new MapBuilder<>(ReindexNode.Builder::new)).build());
		}

		/**
		 * Builds a {@link ReindexRethrottleResponse}.
		 *
		 * @throws NullPointerException
		 *             if some of the required fields are null.
		 */
		public ReindexRethrottleResponse build() {
			_checkSingleUse();

			return new ReindexRethrottleResponse(this);
		}
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Json deserializer for {@link ReindexRethrottleResponse}
	 */
	public static final JsonpDeserializer<ReindexRethrottleResponse> _DESERIALIZER = ObjectBuilderDeserializer
			.lazy(Builder::new, ReindexRethrottleResponse::setupReindexRethrottleResponseDeserializer, Builder::build);

	protected static void setupReindexRethrottleResponseDeserializer(
			DelegatingDeserializer<ReindexRethrottleResponse.Builder> op) {

		op.add(Builder::nodes, JsonpDeserializer.stringMapDeserializer(ReindexNode._DESERIALIZER), "nodes");

	}

}
