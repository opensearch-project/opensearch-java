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

package org.opensearch.client.opensearch.shutdown;

import org.opensearch.client.opensearch.shutdown.get_node.NodeShutdownStatus;
import org.opensearch.client.json.DelegatingDeserializer;
import org.opensearch.client.json.JsonpDeserializable;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.JsonpSerializable;
import org.opensearch.client.json.ObjectBuilderDeserializer;
import org.opensearch.client.util.ModelTypeHelper;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import jakarta.json.stream.JsonGenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

// typedef: shutdown.get_node.Response
@JsonpDeserializable
public class GetNodeResponse implements JsonpSerializable {
	private final List<NodeShutdownStatus> nodes;

	// ---------------------------------------------------------------------------------------------

	private GetNodeResponse(Builder builder) {

		this.nodes = ModelTypeHelper.unmodifiableRequired(builder.nodes, this, "nodes");

	}

	public static GetNodeResponse of(Function<Builder, ObjectBuilder<GetNodeResponse>> fn) {
		return fn.apply(new Builder()).build();
	}

	/**
	 * Required - API name: {@code nodes}
	 */
	public final List<NodeShutdownStatus> nodes() {
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
			generator.writeStartArray();
			for (NodeShutdownStatus item0 : this.nodes) {
				item0.serialize(generator, mapper);

			}
			generator.writeEnd();

		}

	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Builder for {@link GetNodeResponse}.
	 */
	public static class Builder extends ObjectBuilderBase implements ObjectBuilder<GetNodeResponse> {
		private List<NodeShutdownStatus> nodes;

		/**
		 * Required - API name: {@code nodes}
		 */
		public final Builder nodes(List<NodeShutdownStatus> value) {
			this.nodes = value;
			return this;
		}

		/**
		 * Required - API name: {@code nodes}
		 */
		public final Builder nodes(NodeShutdownStatus... value) {
			this.nodes = Arrays.asList(value);
			return this;
		}

		/**
		 * Required - API name: {@code nodes}
		 */
		@SafeVarargs
		public final Builder nodes(Function<NodeShutdownStatus.Builder, ObjectBuilder<NodeShutdownStatus>>... fns) {
			this.nodes = new ArrayList<>(fns.length);
			for (Function<NodeShutdownStatus.Builder, ObjectBuilder<NodeShutdownStatus>> fn : fns) {
				this.nodes.add(fn.apply(new NodeShutdownStatus.Builder()).build());
			}
			return this;
		}

		/**
		 * Builds a {@link GetNodeResponse}.
		 *
		 * @throws NullPointerException
		 *             if some of the required fields are null.
		 */
		public GetNodeResponse build() {
			_checkSingleUse();

			return new GetNodeResponse(this);
		}
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Json deserializer for {@link GetNodeResponse}
	 */
	public static final JsonpDeserializer<GetNodeResponse> _DESERIALIZER = ObjectBuilderDeserializer.lazy(Builder::new,
			GetNodeResponse::setupGetNodeResponseDeserializer, Builder::build);

	protected static void setupGetNodeResponseDeserializer(DelegatingDeserializer<GetNodeResponse.Builder> op) {

		op.add(Builder::nodes, JsonpDeserializer.arrayDeserializer(NodeShutdownStatus._DESERIALIZER), "nodes");

	}

}
