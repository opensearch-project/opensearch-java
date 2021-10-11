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

package org.opensearch.client.opensearch.nodes.info;

import jakarta.json.stream.JsonGenerator;
import org.opensearch.client.json.DelegatingDeserializer;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.ObjectBuilderDeserializer;
import org.opensearch.client.json.ToJsonp;
import org.opensearch.client.util.ObjectBuilder;

import java.util.Objects;

// typedef: nodes.info.NodeInfoMemory
public final class NodeInfoMemory implements ToJsonp {
	private final String total;

	private final Number totalInBytes;

	// ---------------------------------------------------------------------------------------------

	protected NodeInfoMemory(Builder builder) {

		this.total = Objects.requireNonNull(builder.total, "total");
		this.totalInBytes = Objects.requireNonNull(builder.totalInBytes, "total_in_bytes");

	}

	/**
	 * API name: {@code total}
	 */
	public String total() {
		return this.total;
	}

	/**
	 * API name: {@code total_in_bytes}
	 */
	public Number totalInBytes() {
		return this.totalInBytes;
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

		generator.writeKey("total");
		generator.write(this.total);

		generator.writeKey("total_in_bytes");
		generator.write(this.totalInBytes.doubleValue());

	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Builder for {@link NodeInfoMemory}.
	 */
	public static class Builder implements ObjectBuilder<NodeInfoMemory> {
		private String total;

		private Number totalInBytes;

		/**
		 * API name: {@code total}
		 */
		public Builder total(String value) {
			this.total = value;
			return this;
		}

		/**
		 * API name: {@code total_in_bytes}
		 */
		public Builder totalInBytes(Number value) {
			this.totalInBytes = value;
			return this;
		}

		/**
		 * Builds a {@link NodeInfoMemory}.
		 *
		 * @throws NullPointerException
		 *             if some of the required fields are null.
		 */
		public NodeInfoMemory build() {

			return new NodeInfoMemory(this);
		}
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Json deserializer for NodeInfoMemory
	 */
	public static final JsonpDeserializer<NodeInfoMemory> DESERIALIZER = ObjectBuilderDeserializer
			.createForObject(Builder::new, NodeInfoMemory::setupNodeInfoMemoryDeserializer);

	protected static void setupNodeInfoMemoryDeserializer(DelegatingDeserializer<NodeInfoMemory.Builder> op) {

		op.add(Builder::total, JsonpDeserializer.stringDeserializer(), "total");
		op.add(Builder::totalInBytes, JsonpDeserializer.numberDeserializer(), "total_in_bytes");

	}

}
