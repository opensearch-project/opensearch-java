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

package org.opensearch.clients.opensearch.indices;

import org.opensearch.clients.opensearch.indices.shard_stores.IndicesShardStores;
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

import java.lang.String;
import java.util.Map;
import java.util.function.Function;

// typedef: indices.shard_stores.Response

/**
 *
 * @see <a href=
 *      "https://github.com/elastic/elasticsearch-specification/tree/98036c3/specification/indices/shard_stores/IndicesShardStoresResponse.ts#L24-L26">API
 *      specification</a>
 */
@JsonpDeserializable
public class ShardStoresResponse implements JsonpSerializable {
	private final Map<String, IndicesShardStores> indices;

	// ---------------------------------------------------------------------------------------------

	private ShardStoresResponse(Builder builder) {

		this.indices = ApiTypeHelper.unmodifiableRequired(builder.indices, this, "indices");

	}

	public static ShardStoresResponse of(Function<Builder, ObjectBuilder<ShardStoresResponse>> fn) {
		return fn.apply(new Builder()).build();
	}

	/**
	 * Required - API name: {@code indices}
	 */
	public final Map<String, IndicesShardStores> indices() {
		return this.indices;
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

		if (ApiTypeHelper.isDefined(this.indices)) {
			generator.writeKey("indices");
			generator.writeStartObject();
			for (Map.Entry<String, IndicesShardStores> item0 : this.indices.entrySet()) {
				generator.writeKey(item0.getKey());
				item0.getValue().serialize(generator, mapper);

			}
			generator.writeEnd();

		}

	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Builder for {@link ShardStoresResponse}.
	 */

	public static class Builder extends ObjectBuilderBase implements ObjectBuilder<ShardStoresResponse> {
		private Map<String, IndicesShardStores> indices;

		/**
		 * Required - API name: {@code indices}
		 * <p>
		 * Adds all entries of <code>map</code> to <code>indices</code>.
		 */
		public final Builder indices(Map<String, IndicesShardStores> map) {
			this.indices = _mapPutAll(this.indices, map);
			return this;
		}

		/**
		 * Required - API name: {@code indices}
		 * <p>
		 * Adds an entry to <code>indices</code>.
		 */
		public final Builder indices(String key, IndicesShardStores value) {
			this.indices = _mapPut(this.indices, key, value);
			return this;
		}

		/**
		 * Required - API name: {@code indices}
		 * <p>
		 * Adds an entry to <code>indices</code> using a builder lambda.
		 */
		public final Builder indices(String key,
				Function<IndicesShardStores.Builder, ObjectBuilder<IndicesShardStores>> fn) {
			return indices(key, fn.apply(new IndicesShardStores.Builder()).build());
		}

		/**
		 * Builds a {@link ShardStoresResponse}.
		 *
		 * @throws NullPointerException
		 *             if some of the required fields are null.
		 */
		public ShardStoresResponse build() {
			_checkSingleUse();

			return new ShardStoresResponse(this);
		}
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Json deserializer for {@link ShardStoresResponse}
	 */
	public static final JsonpDeserializer<ShardStoresResponse> _DESERIALIZER = ObjectBuilderDeserializer
			.lazy(Builder::new, ShardStoresResponse::setupShardStoresResponseDeserializer);

	protected static void setupShardStoresResponseDeserializer(ObjectDeserializer<ShardStoresResponse.Builder> op) {

		op.add(Builder::indices, JsonpDeserializer.stringMapDeserializer(IndicesShardStores._DESERIALIZER), "indices");

	}

}
