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

package org.opensearch.clients.opensearch.cluster.reroute;

import jakarta.json.stream.JsonGenerator;
import org.opensearch.clients.json.DelegatingDeserializer;
import org.opensearch.clients.json.JsonpDeserializer;
import org.opensearch.clients.json.JsonpMapper;
import org.opensearch.clients.json.ObjectBuilderDeserializer;
import org.opensearch.clients.json.ToJsonp;
import org.opensearch.clients.util.ObjectBuilder;

import java.util.Objects;

// typedef: cluster.reroute.CommandAllocateReplicaAction
public final class CommandAllocateReplicaAction implements ToJsonp {
	private final String index;

	private final Number shard;

	private final String node;

	// ---------------------------------------------------------------------------------------------

	protected CommandAllocateReplicaAction(Builder builder) {

		this.index = Objects.requireNonNull(builder.index, "index");
		this.shard = Objects.requireNonNull(builder.shard, "shard");
		this.node = Objects.requireNonNull(builder.node, "node");

	}

	/**
	 * API name: {@code index}
	 */
	public String index() {
		return this.index;
	}

	/**
	 * API name: {@code shard}
	 */
	public Number shard() {
		return this.shard;
	}

	/**
	 * API name: {@code node}
	 */
	public String node() {
		return this.node;
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

		generator.writeKey("index");
		generator.write(this.index);

		generator.writeKey("shard");
		generator.write(this.shard.doubleValue());

		generator.writeKey("node");
		generator.write(this.node);

	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Builder for {@link CommandAllocateReplicaAction}.
	 */
	public static class Builder implements ObjectBuilder<CommandAllocateReplicaAction> {
		private String index;

		private Number shard;

		private String node;

		/**
		 * API name: {@code index}
		 */
		public Builder index(String value) {
			this.index = value;
			return this;
		}

		/**
		 * API name: {@code shard}
		 */
		public Builder shard(Number value) {
			this.shard = value;
			return this;
		}

		/**
		 * API name: {@code node}
		 */
		public Builder node(String value) {
			this.node = value;
			return this;
		}

		/**
		 * Builds a {@link CommandAllocateReplicaAction}.
		 *
		 * @throws NullPointerException
		 *             if some of the required fields are null.
		 */
		public CommandAllocateReplicaAction build() {

			return new CommandAllocateReplicaAction(this);
		}
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Json deserializer for CommandAllocateReplicaAction
	 */
	public static final JsonpDeserializer<CommandAllocateReplicaAction> DESERIALIZER = ObjectBuilderDeserializer
			.createForObject(Builder::new, CommandAllocateReplicaAction::setupCommandAllocateReplicaActionDeserializer);

	protected static void setupCommandAllocateReplicaActionDeserializer(
			DelegatingDeserializer<CommandAllocateReplicaAction.Builder> op) {

		op.add(Builder::index, JsonpDeserializer.stringDeserializer(), "index");
		op.add(Builder::shard, JsonpDeserializer.numberDeserializer(), "shard");
		op.add(Builder::node, JsonpDeserializer.stringDeserializer(), "node");

	}

}
