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

package org.opensearch.clients.opensearch.indices.segments;

import jakarta.json.stream.JsonGenerator;
import org.opensearch.clients.json.DelegatingDeserializer;
import org.opensearch.clients.json.JsonpDeserializer;
import org.opensearch.clients.json.JsonpMapper;
import org.opensearch.clients.json.ObjectBuilderDeserializer;
import org.opensearch.clients.json.ToJsonp;
import org.opensearch.clients.util.ObjectBuilder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

// typedef: indices.segments.IndexSegment
public final class IndexSegment implements ToJsonp {
	private final Map<String, List<ShardsSegment>> shards;

	// ---------------------------------------------------------------------------------------------

	protected IndexSegment(Builder builder) {

		this.shards = Objects.requireNonNull(builder.shards, "shards");

	}

	/**
	 * API name: {@code shards}
	 */
	public Map<String, List<ShardsSegment>> shards() {
		return this.shards;
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

		generator.writeKey("shards");
		generator.writeStartObject();
		for (Map.Entry<String, List<ShardsSegment>> item0 : this.shards.entrySet()) {
			generator.writeKey(item0.getKey());
			generator.writeStartArray();
			for (ShardsSegment item1 : item0.getValue()) {
				item1.toJsonp(generator, mapper);

			}
			generator.writeEnd();

		}
		generator.writeEnd();

	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Builder for {@link IndexSegment}.
	 */
	public static class Builder implements ObjectBuilder<IndexSegment> {
		private Map<String, List<ShardsSegment>> shards;

		/**
		 * API name: {@code shards}
		 */
		public Builder shards(Map<String, List<ShardsSegment>> value) {
			this.shards = value;
			return this;
		}

		/**
		 * Add a key/value to {@link #shards(Map)}, creating the map if needed.
		 */
		public Builder putShards(String key, List<ShardsSegment> value) {
			if (this.shards == null) {
				this.shards = new HashMap<>();
			}
			this.shards.put(key, value);
			return this;
		}

		/**
		 * Builds a {@link IndexSegment}.
		 *
		 * @throws NullPointerException
		 *             if some of the required fields are null.
		 */
		public IndexSegment build() {

			return new IndexSegment(this);
		}
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Json deserializer for IndexSegment
	 */
	public static final JsonpDeserializer<IndexSegment> DESERIALIZER = ObjectBuilderDeserializer
			.createForObject(Builder::new, IndexSegment::setupIndexSegmentDeserializer);

	protected static void setupIndexSegmentDeserializer(DelegatingDeserializer<IndexSegment.Builder> op) {

		op.add(Builder::shards, JsonpDeserializer
				.stringMapDeserializer(JsonpDeserializer.arrayDeserializer(ShardsSegment.DESERIALIZER)), "shards");

	}

}
