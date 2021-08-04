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
import java.util.List;
import java.util.Map;
import java.util.function.Function;

// typedef: indices.segments.IndexSegment
@JsonpDeserializable
public class IndexSegment implements JsonpSerializable {
	private final Map<String, List<ShardsSegment>> shards;

	// ---------------------------------------------------------------------------------------------

	private IndexSegment(Builder builder) {

		this.shards = ModelTypeHelper.unmodifiableRequired(builder.shards, this, "shards");

	}

	public static IndexSegment of(Function<Builder, ObjectBuilder<IndexSegment>> fn) {
		return fn.apply(new Builder()).build();
	}

	/**
	 * Required - API name: {@code shards}
	 */
	public final Map<String, List<ShardsSegment>> shards() {
		return this.shards;
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

		if (ModelTypeHelper.isDefined(this.shards)) {
			generator.writeKey("shards");
			generator.writeStartObject();
			for (Map.Entry<String, List<ShardsSegment>> item0 : this.shards.entrySet()) {
				generator.writeKey(item0.getKey());
				generator.writeStartArray();
				if (item0.getValue() != null) {
					for (ShardsSegment item1 : item0.getValue()) {
						item1.serialize(generator, mapper);

					}
				}
				generator.writeEnd();

			}
			generator.writeEnd();

		}

	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Builder for {@link IndexSegment}.
	 */
	public static class Builder extends ObjectBuilderBase implements ObjectBuilder<IndexSegment> {
		private Map<String, List<ShardsSegment>> shards;

		/**
		 * Required - API name: {@code shards}
		 */
		public final Builder shards(Map<String, List<ShardsSegment>> value) {
			this.shards = value;
			return this;
		}

		/**
		 * Builds a {@link IndexSegment}.
		 *
		 * @throws NullPointerException
		 *             if some of the required fields are null.
		 */
		public IndexSegment build() {
			_checkSingleUse();

			return new IndexSegment(this);
		}
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Json deserializer for {@link IndexSegment}
	 */
	public static final JsonpDeserializer<IndexSegment> _DESERIALIZER = ObjectBuilderDeserializer.lazy(Builder::new,
			IndexSegment::setupIndexSegmentDeserializer, Builder::build);

	protected static void setupIndexSegmentDeserializer(DelegatingDeserializer<IndexSegment.Builder> op) {

		op.add(Builder::shards, JsonpDeserializer
				.stringMapDeserializer(JsonpDeserializer.arrayDeserializer(ShardsSegment._DESERIALIZER)), "shards");

	}

}
