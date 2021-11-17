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

package org.opensearch.clients.elasticsearch.nodes.info;

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

// typedef: nodes.info.NodeInfoSettingsClusterElection
@JsonpDeserializable
public class NodeInfoSettingsClusterElection implements JsonpSerializable {
	private final String strategy;

	// ---------------------------------------------------------------------------------------------

	private NodeInfoSettingsClusterElection(Builder builder) {

		this.strategy = ModelTypeHelper.requireNonNull(builder.strategy, this, "strategy");

	}

	public static NodeInfoSettingsClusterElection of(
			Function<Builder, ObjectBuilder<NodeInfoSettingsClusterElection>> fn) {
		return fn.apply(new Builder()).build();
	}

	/**
	 * Required - API name: {@code strategy}
	 */
	public final String strategy() {
		return this.strategy;
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

		generator.writeKey("strategy");
		generator.write(this.strategy);

	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Builder for {@link NodeInfoSettingsClusterElection}.
	 */
	public static class Builder extends ObjectBuilderBase implements ObjectBuilder<NodeInfoSettingsClusterElection> {
		private String strategy;

		/**
		 * Required - API name: {@code strategy}
		 */
		public final Builder strategy(String value) {
			this.strategy = value;
			return this;
		}

		/**
		 * Builds a {@link NodeInfoSettingsClusterElection}.
		 *
		 * @throws NullPointerException
		 *             if some of the required fields are null.
		 */
		public NodeInfoSettingsClusterElection build() {
			_checkSingleUse();

			return new NodeInfoSettingsClusterElection(this);
		}
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Json deserializer for {@link NodeInfoSettingsClusterElection}
	 */
	public static final JsonpDeserializer<NodeInfoSettingsClusterElection> _DESERIALIZER = ObjectBuilderDeserializer
			.lazy(Builder::new, NodeInfoSettingsClusterElection::setupNodeInfoSettingsClusterElectionDeserializer,
					Builder::build);

	protected static void setupNodeInfoSettingsClusterElectionDeserializer(
			DelegatingDeserializer<NodeInfoSettingsClusterElection.Builder> op) {

		op.add(Builder::strategy, JsonpDeserializer.stringDeserializer(), "strategy");

	}

}
