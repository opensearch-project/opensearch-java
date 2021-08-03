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

package org.opensearch.clients.opensearch.cluster.stats;

import jakarta.json.stream.JsonGenerator;
import org.opensearch.clients.json.DelegatingDeserializer;
import org.opensearch.clients.json.JsonpDeserializer;
import org.opensearch.clients.json.JsonpMapper;
import org.opensearch.clients.json.ObjectBuilderDeserializer;
import org.opensearch.clients.json.ToJsonp;
import org.opensearch.clients.util.ObjectBuilder;

import java.util.Objects;

// typedef: cluster.stats.ClusterJvmMemory
public final class ClusterJvmMemory implements ToJsonp {
	private final Number heapMaxInBytes;

	private final Number heapUsedInBytes;

	// ---------------------------------------------------------------------------------------------

	protected ClusterJvmMemory(Builder builder) {

		this.heapMaxInBytes = Objects.requireNonNull(builder.heapMaxInBytes, "heap_max_in_bytes");
		this.heapUsedInBytes = Objects.requireNonNull(builder.heapUsedInBytes, "heap_used_in_bytes");

	}

	/**
	 * API name: {@code heap_max_in_bytes}
	 */
	public Number heapMaxInBytes() {
		return this.heapMaxInBytes;
	}

	/**
	 * API name: {@code heap_used_in_bytes}
	 */
	public Number heapUsedInBytes() {
		return this.heapUsedInBytes;
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

		generator.writeKey("heap_max_in_bytes");
		generator.write(this.heapMaxInBytes.doubleValue());

		generator.writeKey("heap_used_in_bytes");
		generator.write(this.heapUsedInBytes.doubleValue());

	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Builder for {@link ClusterJvmMemory}.
	 */
	public static class Builder implements ObjectBuilder<ClusterJvmMemory> {
		private Number heapMaxInBytes;

		private Number heapUsedInBytes;

		/**
		 * API name: {@code heap_max_in_bytes}
		 */
		public Builder heapMaxInBytes(Number value) {
			this.heapMaxInBytes = value;
			return this;
		}

		/**
		 * API name: {@code heap_used_in_bytes}
		 */
		public Builder heapUsedInBytes(Number value) {
			this.heapUsedInBytes = value;
			return this;
		}

		/**
		 * Builds a {@link ClusterJvmMemory}.
		 *
		 * @throws NullPointerException
		 *             if some of the required fields are null.
		 */
		public ClusterJvmMemory build() {

			return new ClusterJvmMemory(this);
		}
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Json deserializer for ClusterJvmMemory
	 */
	public static final JsonpDeserializer<ClusterJvmMemory> DESERIALIZER = ObjectBuilderDeserializer
			.createForObject(Builder::new, ClusterJvmMemory::setupClusterJvmMemoryDeserializer);

	protected static void setupClusterJvmMemoryDeserializer(DelegatingDeserializer<ClusterJvmMemory.Builder> op) {

		op.add(Builder::heapMaxInBytes, JsonpDeserializer.numberDeserializer(), "heap_max_in_bytes");
		op.add(Builder::heapUsedInBytes, JsonpDeserializer.numberDeserializer(), "heap_used_in_bytes");

	}

}
