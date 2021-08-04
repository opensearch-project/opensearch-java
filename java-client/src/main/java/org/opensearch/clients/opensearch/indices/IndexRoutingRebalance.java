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

import java.util.function.Function;

// typedef: indices._types.IndexRoutingRebalance

/**
 *
 * @see <a href=
 *      "https://github.com/elastic/elasticsearch-specification/tree/98036c3/specification/indices/_types/IndexRouting.ts#L34-L36">API
 *      specification</a>
 */
@JsonpDeserializable
public class IndexRoutingRebalance implements JsonpSerializable {
	private final IndexRoutingRebalanceOptions enable;

	// ---------------------------------------------------------------------------------------------

	private IndexRoutingRebalance(Builder builder) {

		this.enable = ApiTypeHelper.requireNonNull(builder.enable, this, "enable");

	}

	public static IndexRoutingRebalance of(Function<Builder, ObjectBuilder<IndexRoutingRebalance>> fn) {
		return fn.apply(new Builder()).build();
	}

	/**
	 * Required - API name: {@code enable}
	 */
	public final IndexRoutingRebalanceOptions enable() {
		return this.enable;
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

		generator.writeKey("enable");
		this.enable.serialize(generator, mapper);

	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Builder for {@link IndexRoutingRebalance}.
	 */

	public static class Builder extends ObjectBuilderBase implements ObjectBuilder<IndexRoutingRebalance> {
		private IndexRoutingRebalanceOptions enable;

		/**
		 * Required - API name: {@code enable}
		 */
		public final Builder enable(IndexRoutingRebalanceOptions value) {
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
			_checkSingleUse();

			return new IndexRoutingRebalance(this);
		}
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Json deserializer for {@link IndexRoutingRebalance}
	 */
	public static final JsonpDeserializer<IndexRoutingRebalance> _DESERIALIZER = ObjectBuilderDeserializer
			.lazy(Builder::new, IndexRoutingRebalance::setupIndexRoutingRebalanceDeserializer);

	protected static void setupIndexRoutingRebalanceDeserializer(ObjectDeserializer<IndexRoutingRebalance.Builder> op) {

		op.add(Builder::enable, IndexRoutingRebalanceOptions._DESERIALIZER, "enable");

	}

}
