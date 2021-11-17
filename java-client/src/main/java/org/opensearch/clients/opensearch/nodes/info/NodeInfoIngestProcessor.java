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

package org.opensearch.clients.opensearch.nodes.info;

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

import java.lang.String;
import java.util.function.Function;

// typedef: nodes.info.NodeInfoIngestProcessor
@JsonpDeserializable
public class NodeInfoIngestProcessor implements JsonpSerializable {
	private final String type;

	// ---------------------------------------------------------------------------------------------

	private NodeInfoIngestProcessor(Builder builder) {

		this.type = ModelTypeHelper.requireNonNull(builder.type, this, "type");

	}

	public static NodeInfoIngestProcessor of(Function<Builder, ObjectBuilder<NodeInfoIngestProcessor>> fn) {
		return fn.apply(new Builder()).build();
	}

	/**
	 * Required - API name: {@code type}
	 */
	public final String type() {
		return this.type;
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

		generator.writeKey("type");
		generator.write(this.type);

	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Builder for {@link NodeInfoIngestProcessor}.
	 */
	public static class Builder extends ObjectBuilderBase implements ObjectBuilder<NodeInfoIngestProcessor> {
		private String type;

		/**
		 * Required - API name: {@code type}
		 */
		public final Builder type(String value) {
			this.type = value;
			return this;
		}

		/**
		 * Builds a {@link NodeInfoIngestProcessor}.
		 *
		 * @throws NullPointerException
		 *             if some of the required fields are null.
		 */
		public NodeInfoIngestProcessor build() {
			_checkSingleUse();

			return new NodeInfoIngestProcessor(this);
		}
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Json deserializer for {@link NodeInfoIngestProcessor}
	 */
	public static final JsonpDeserializer<NodeInfoIngestProcessor> _DESERIALIZER = ObjectBuilderDeserializer
			.lazy(Builder::new, NodeInfoIngestProcessor::setupNodeInfoIngestProcessorDeserializer, Builder::build);

	protected static void setupNodeInfoIngestProcessorDeserializer(
			DelegatingDeserializer<NodeInfoIngestProcessor.Builder> op) {

		op.add(Builder::type, JsonpDeserializer.stringDeserializer(), "type");

	}

}
