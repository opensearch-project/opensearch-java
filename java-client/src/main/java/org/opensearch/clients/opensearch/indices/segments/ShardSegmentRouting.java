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

package org.opensearch.clients.opensearch.indices.segments;

import org.opensearch.clients.json.JsonpDeserializable;
import org.opensearch.clients.json.JsonpDeserializer;
import org.opensearch.clients.json.JsonpMapper;
import org.opensearch.clients.json.JsonpSerializable;
import org.opensearch.clients.json.ObjectBuilderDeserializer;
import org.opensearch.clients.json.ObjectDeserializer;
import org.opensearch.clients.util.ApiTypeHelper;
import org.opensearch.clients.util.ObjectBuilder;
import org.opensearch.clients.util.ObjectBuilderBase;
import jakarta.json.stream.JsonGenerator;
import java.lang.Boolean;
import java.lang.String;
import java.util.function.Function;

// typedef: indices.segments.ShardSegmentRouting

/**
 *
 * @see <a href=
 *      "https://github.com/elastic/elasticsearch-specification/tree/98036c3/specification/indices/segments/types.ts#L41-L45">API
 *      specification</a>
 */
@JsonpDeserializable
public class ShardSegmentRouting implements JsonpSerializable {
	private final String node;

	private final boolean primary;

	private final String state;

	// ---------------------------------------------------------------------------------------------

	private ShardSegmentRouting(Builder builder) {

		this.node = ApiTypeHelper.requireNonNull(builder.node, this, "node");
		this.primary = ApiTypeHelper.requireNonNull(builder.primary, this, "primary");
		this.state = ApiTypeHelper.requireNonNull(builder.state, this, "state");

	}

	public static ShardSegmentRouting of(Function<Builder, ObjectBuilder<ShardSegmentRouting>> fn) {
		return fn.apply(new Builder()).build();
	}

	/**
	 * Required - API name: {@code node}
	 */
	public final String node() {
		return this.node;
	}

	/**
	 * Required - API name: {@code primary}
	 */
	public final boolean primary() {
		return this.primary;
	}

	/**
	 * Required - API name: {@code state}
	 */
	public final String state() {
		return this.state;
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

		generator.writeKey("node");
		generator.write(this.node);

		generator.writeKey("primary");
		generator.write(this.primary);

		generator.writeKey("state");
		generator.write(this.state);

	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Builder for {@link ShardSegmentRouting}.
	 */

	public static class Builder extends ObjectBuilderBase implements ObjectBuilder<ShardSegmentRouting> {
		private String node;

		private Boolean primary;

		private String state;

		/**
		 * Required - API name: {@code node}
		 */
		public final Builder node(String value) {
			this.node = value;
			return this;
		}

		/**
		 * Required - API name: {@code primary}
		 */
		public final Builder primary(boolean value) {
			this.primary = value;
			return this;
		}

		/**
		 * Required - API name: {@code state}
		 */
		public final Builder state(String value) {
			this.state = value;
			return this;
		}

		/**
		 * Builds a {@link ShardSegmentRouting}.
		 *
		 * @throws NullPointerException
		 *             if some of the required fields are null.
		 */
		public ShardSegmentRouting build() {
			_checkSingleUse();

			return new ShardSegmentRouting(this);
		}
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Json deserializer for {@link ShardSegmentRouting}
	 */
	public static final JsonpDeserializer<ShardSegmentRouting> _DESERIALIZER = ObjectBuilderDeserializer
			.lazy(Builder::new, ShardSegmentRouting::setupShardSegmentRoutingDeserializer);

	protected static void setupShardSegmentRoutingDeserializer(ObjectDeserializer<ShardSegmentRouting.Builder> op) {

		op.add(Builder::node, JsonpDeserializer.stringDeserializer(), "node");
		op.add(Builder::primary, JsonpDeserializer.booleanDeserializer(), "primary");
		op.add(Builder::state, JsonpDeserializer.stringDeserializer(), "state");

	}

}
