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

package org.opensearch.clients.opensearch.nodes.info;

import jakarta.json.stream.JsonGenerator;
import org.opensearch.clients.json.DelegatingDeserializer;
import org.opensearch.clients.json.JsonpDeserializer;
import org.opensearch.clients.json.JsonpMapper;
import org.opensearch.clients.json.ObjectBuilderDeserializer;
import org.opensearch.clients.json.ToJsonp;
import org.opensearch.clients.util.ObjectBuilder;

import java.util.Objects;

// typedef: nodes.info.NodeInfoSettingsNetwork
public final class NodeInfoSettingsNetwork implements ToJsonp {
	private final String host;

	// ---------------------------------------------------------------------------------------------

	protected NodeInfoSettingsNetwork(Builder builder) {

		this.host = Objects.requireNonNull(builder.host, "host");

	}

	/**
	 * API name: {@code host}
	 */
	public String host() {
		return this.host;
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

		generator.writeKey("host");
		generator.write(this.host);

	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Builder for {@link NodeInfoSettingsNetwork}.
	 */
	public static class Builder implements ObjectBuilder<NodeInfoSettingsNetwork> {
		private String host;

		/**
		 * API name: {@code host}
		 */
		public Builder host(String value) {
			this.host = value;
			return this;
		}

		/**
		 * Builds a {@link NodeInfoSettingsNetwork}.
		 *
		 * @throws NullPointerException
		 *             if some of the required fields are null.
		 */
		public NodeInfoSettingsNetwork build() {

			return new NodeInfoSettingsNetwork(this);
		}
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Json deserializer for NodeInfoSettingsNetwork
	 */
	public static final JsonpDeserializer<NodeInfoSettingsNetwork> DESERIALIZER = ObjectBuilderDeserializer
			.createForObject(Builder::new, NodeInfoSettingsNetwork::setupNodeInfoSettingsNetworkDeserializer);

	protected static void setupNodeInfoSettingsNetworkDeserializer(
			DelegatingDeserializer<NodeInfoSettingsNetwork.Builder> op) {

		op.add(Builder::host, JsonpDeserializer.stringDeserializer(), "host");

	}

}
