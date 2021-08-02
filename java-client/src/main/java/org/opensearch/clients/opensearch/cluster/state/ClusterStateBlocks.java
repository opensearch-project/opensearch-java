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

package org.opensearch.clients.opensearch.cluster.state;

import jakarta.json.stream.JsonGenerator;
import org.opensearch.clients.opensearch.cluster.ClusterStateBlockIndex;
import org.opensearch.clients.json.DelegatingDeserializer;
import org.opensearch.clients.json.JsonpDeserializer;
import org.opensearch.clients.json.JsonpMapper;
import org.opensearch.clients.json.ObjectBuilderDeserializer;
import org.opensearch.clients.json.ToJsonp;
import org.opensearch.clients.util.ObjectBuilder;

import javax.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;

// typedef: cluster.state.ClusterStateBlocks
public final class ClusterStateBlocks implements ToJsonp {
	@Nullable
	private final Map<String, Map<String, ClusterStateBlockIndex>> indices;

	// ---------------------------------------------------------------------------------------------

	protected ClusterStateBlocks(Builder builder) {

		this.indices = builder.indices;

	}

	/**
	 * API name: {@code indices}
	 */
	@Nullable
	public Map<String, Map<String, ClusterStateBlockIndex>> indices() {
		return this.indices;
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

		if (this.indices != null) {

			generator.writeKey("indices");
			generator.writeStartObject();
			for (Map.Entry<String, Map<String, ClusterStateBlockIndex>> item0 : this.indices.entrySet()) {
				generator.writeKey(item0.getKey());
				generator.writeStartObject();
				for (Map.Entry<String, ClusterStateBlockIndex> item1 : item0.getValue().entrySet()) {
					generator.writeKey(item1.getKey());
					item1.getValue().toJsonp(generator, mapper);

				}
				generator.writeEnd();

			}
			generator.writeEnd();

		}

	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Builder for {@link ClusterStateBlocks}.
	 */
	public static class Builder implements ObjectBuilder<ClusterStateBlocks> {
		@Nullable
		private Map<String, Map<String, ClusterStateBlockIndex>> indices;

		/**
		 * API name: {@code indices}
		 */
		public Builder indices(@Nullable Map<String, Map<String, ClusterStateBlockIndex>> value) {
			this.indices = value;
			return this;
		}

		/**
		 * Add a key/value to {@link #indices(Map)}, creating the map if needed.
		 */
		public Builder putIndices(String key, Map<String, ClusterStateBlockIndex> value) {
			if (this.indices == null) {
				this.indices = new HashMap<>();
			}
			this.indices.put(key, value);
			return this;
		}

		/**
		 * Builds a {@link ClusterStateBlocks}.
		 *
		 * @throws NullPointerException
		 *             if some of the required fields are null.
		 */
		public ClusterStateBlocks build() {

			return new ClusterStateBlocks(this);
		}
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Json deserializer for ClusterStateBlocks
	 */
	public static final JsonpDeserializer<ClusterStateBlocks> DESERIALIZER = ObjectBuilderDeserializer
			.createForObject(Builder::new, ClusterStateBlocks::setupClusterStateBlocksDeserializer);

	protected static void setupClusterStateBlocksDeserializer(DelegatingDeserializer<ClusterStateBlocks.Builder> op) {

		op.add(Builder::indices, JsonpDeserializer.stringMapDeserializer(
				JsonpDeserializer.stringMapDeserializer(ClusterStateBlockIndex.DESERIALIZER)), "indices");

	}

}
