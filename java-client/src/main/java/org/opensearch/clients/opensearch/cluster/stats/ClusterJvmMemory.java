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

package org.opensearch.clients.opensearch.cluster.stats;

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
import java.lang.Long;
import java.util.function.Function;

// typedef: cluster.stats.ClusterJvmMemory
@JsonpDeserializable
public class ClusterJvmMemory implements JsonpSerializable {
	private final long heapMaxInBytes;

	private final long heapUsedInBytes;

	// ---------------------------------------------------------------------------------------------

	private ClusterJvmMemory(Builder builder) {

		this.heapMaxInBytes = ModelTypeHelper.requireNonNull(builder.heapMaxInBytes, this, "heapMaxInBytes");
		this.heapUsedInBytes = ModelTypeHelper.requireNonNull(builder.heapUsedInBytes, this, "heapUsedInBytes");

	}

	public static ClusterJvmMemory of(Function<Builder, ObjectBuilder<ClusterJvmMemory>> fn) {
		return fn.apply(new Builder()).build();
	}

	/**
	 * Required - API name: {@code heap_max_in_bytes}
	 */
	public final long heapMaxInBytes() {
		return this.heapMaxInBytes;
	}

	/**
	 * Required - API name: {@code heap_used_in_bytes}
	 */
	public final long heapUsedInBytes() {
		return this.heapUsedInBytes;
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

		generator.writeKey("heap_max_in_bytes");
		generator.write(this.heapMaxInBytes);

		generator.writeKey("heap_used_in_bytes");
		generator.write(this.heapUsedInBytes);

	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Builder for {@link ClusterJvmMemory}.
	 */
	public static class Builder extends ObjectBuilderBase implements ObjectBuilder<ClusterJvmMemory> {
		private Long heapMaxInBytes;

		private Long heapUsedInBytes;

		/**
		 * Required - API name: {@code heap_max_in_bytes}
		 */
		public final Builder heapMaxInBytes(long value) {
			this.heapMaxInBytes = value;
			return this;
		}

		/**
		 * Required - API name: {@code heap_used_in_bytes}
		 */
		public final Builder heapUsedInBytes(long value) {
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
			_checkSingleUse();

			return new ClusterJvmMemory(this);
		}
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Json deserializer for {@link ClusterJvmMemory}
	 */
	public static final JsonpDeserializer<ClusterJvmMemory> _DESERIALIZER = ObjectBuilderDeserializer.lazy(Builder::new,
			ClusterJvmMemory::setupClusterJvmMemoryDeserializer, Builder::build);

	protected static void setupClusterJvmMemoryDeserializer(DelegatingDeserializer<ClusterJvmMemory.Builder> op) {

		op.add(Builder::heapMaxInBytes, JsonpDeserializer.longDeserializer(), "heap_max_in_bytes");
		op.add(Builder::heapUsedInBytes, JsonpDeserializer.longDeserializer(), "heap_used_in_bytes");

	}

}
