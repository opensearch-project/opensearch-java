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

import java.lang.Boolean;
import java.util.function.Function;

// typedef: indices._types.IndexRoutingAllocationDisk
@JsonpDeserializable
public class IndexRoutingAllocationDisk implements JsonpSerializable {
	private final boolean thresholdEnabled;

	// ---------------------------------------------------------------------------------------------

	private IndexRoutingAllocationDisk(Builder builder) {

		this.thresholdEnabled = ModelTypeHelper.requireNonNull(builder.thresholdEnabled, this, "thresholdEnabled");

	}

	public static IndexRoutingAllocationDisk of(Function<Builder, ObjectBuilder<IndexRoutingAllocationDisk>> fn) {
		return fn.apply(new Builder()).build();
	}

	/**
	 * Required - API name: {@code threshold_enabled}
	 */
	public final boolean thresholdEnabled() {
		return this.thresholdEnabled;
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

		generator.writeKey("threshold_enabled");
		generator.write(this.thresholdEnabled);

	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Builder for {@link IndexRoutingAllocationDisk}.
	 */
	public static class Builder extends ObjectBuilderBase implements ObjectBuilder<IndexRoutingAllocationDisk> {
		private Boolean thresholdEnabled;

		/**
		 * Required - API name: {@code threshold_enabled}
		 */
		public final Builder thresholdEnabled(boolean value) {
			this.thresholdEnabled = value;
			return this;
		}

		/**
		 * Builds a {@link IndexRoutingAllocationDisk}.
		 *
		 * @throws NullPointerException
		 *             if some of the required fields are null.
		 */
		public IndexRoutingAllocationDisk build() {
			_checkSingleUse();

			return new IndexRoutingAllocationDisk(this);
		}
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Json deserializer for {@link IndexRoutingAllocationDisk}
	 */
	public static final JsonpDeserializer<IndexRoutingAllocationDisk> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
			Builder::new, IndexRoutingAllocationDisk::setupIndexRoutingAllocationDiskDeserializer, Builder::build);

	protected static void setupIndexRoutingAllocationDiskDeserializer(
			DelegatingDeserializer<IndexRoutingAllocationDisk.Builder> op) {

		op.add(Builder::thresholdEnabled, JsonpDeserializer.booleanDeserializer(), "threshold_enabled");

	}

}
