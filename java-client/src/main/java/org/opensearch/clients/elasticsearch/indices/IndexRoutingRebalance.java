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

package org.opensearch.clients.elasticsearch.indices;

import jakarta.json.JsonValue;
import jakarta.json.stream.JsonGenerator;
import org.opensearch.clients.json.DelegatingDeserializer;
import org.opensearch.clients.json.JsonpDeserializer;
import org.opensearch.clients.json.JsonpMapper;
import org.opensearch.clients.json.ObjectBuilderDeserializer;
import org.opensearch.clients.json.ToJsonp;
import org.opensearch.clients.util.ObjectBuilder;

import java.util.Objects;

// typedef: indices._types.IndexRoutingRebalance
public final class IndexRoutingRebalance implements ToJsonp {
	private final JsonValue enable;

	// ---------------------------------------------------------------------------------------------

	protected IndexRoutingRebalance(Builder builder) {

		this.enable = Objects.requireNonNull(builder.enable, "enable");

	}

	/**
	 * API name: {@code enable}
	 */
	public JsonValue enable() {
		return this.enable;
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

		generator.writeKey("enable");
		generator.write(this.enable);

	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Builder for {@link IndexRoutingRebalance}.
	 */
	public static class Builder implements ObjectBuilder<IndexRoutingRebalance> {
		private JsonValue enable;

		/**
		 * API name: {@code enable}
		 */
		public Builder enable(JsonValue value) {
			this.enable = value;
			return this;
		}

		/**
		 * Builds a {@link IndexRoutingRebalance}.
		 *
		 * @throws NullPointerException
		 *             if some of the required fields are null.
		 */
		public IndexRoutingRebalance build() {

			return new IndexRoutingRebalance(this);
		}
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Json deserializer for IndexRoutingRebalance
	 */
	public static final JsonpDeserializer<IndexRoutingRebalance> DESERIALIZER = ObjectBuilderDeserializer
			.createForObject(Builder::new, IndexRoutingRebalance::setupIndexRoutingRebalanceDeserializer);

	protected static void setupIndexRoutingRebalanceDeserializer(
			DelegatingDeserializer<IndexRoutingRebalance.Builder> op) {

		op.add(Builder::enable, JsonpDeserializer.jsonValueDeserializer(), "enable");

	}

}
