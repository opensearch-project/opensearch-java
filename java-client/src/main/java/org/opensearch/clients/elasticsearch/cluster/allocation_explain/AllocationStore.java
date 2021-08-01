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

package org.opensearch.clients.elasticsearch.cluster.allocation_explain;

import jakarta.json.stream.JsonGenerator;
import org.opensearch.clients.json.DelegatingDeserializer;
import org.opensearch.clients.json.JsonpDeserializer;
import org.opensearch.clients.json.JsonpMapper;
import org.opensearch.clients.json.ObjectBuilderDeserializer;
import org.opensearch.clients.json.ToJsonp;
import org.opensearch.clients.util.ObjectBuilder;

import java.util.Objects;

// typedef: cluster.allocation_explain.AllocationStore
public final class AllocationStore implements ToJsonp {
	private final String allocationId;

	private final Boolean found;

	private final Boolean inSync;

	private final Number matchingSizeInBytes;

	private final Boolean matchingSyncId;

	private final String storeException;

	// ---------------------------------------------------------------------------------------------

	protected AllocationStore(Builder builder) {

		this.allocationId = Objects.requireNonNull(builder.allocationId, "allocation_id");
		this.found = Objects.requireNonNull(builder.found, "found");
		this.inSync = Objects.requireNonNull(builder.inSync, "in_sync");
		this.matchingSizeInBytes = Objects.requireNonNull(builder.matchingSizeInBytes, "matching_size_in_bytes");
		this.matchingSyncId = Objects.requireNonNull(builder.matchingSyncId, "matching_sync_id");
		this.storeException = Objects.requireNonNull(builder.storeException, "store_exception");

	}

	/**
	 * API name: {@code allocation_id}
	 */
	public String allocationId() {
		return this.allocationId;
	}

	/**
	 * API name: {@code found}
	 */
	public Boolean found() {
		return this.found;
	}

	/**
	 * API name: {@code in_sync}
	 */
	public Boolean inSync() {
		return this.inSync;
	}

	/**
	 * API name: {@code matching_size_in_bytes}
	 */
	public Number matchingSizeInBytes() {
		return this.matchingSizeInBytes;
	}

	/**
	 * API name: {@code matching_sync_id}
	 */
	public Boolean matchingSyncId() {
		return this.matchingSyncId;
	}

	/**
	 * API name: {@code store_exception}
	 */
	public String storeException() {
		return this.storeException;
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

		generator.writeKey("allocation_id");
		generator.write(this.allocationId);

		generator.writeKey("found");
		generator.write(this.found);

		generator.writeKey("in_sync");
		generator.write(this.inSync);

		generator.writeKey("matching_size_in_bytes");
		generator.write(this.matchingSizeInBytes.doubleValue());

		generator.writeKey("matching_sync_id");
		generator.write(this.matchingSyncId);

		generator.writeKey("store_exception");
		generator.write(this.storeException);

	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Builder for {@link AllocationStore}.
	 */
	public static class Builder implements ObjectBuilder<AllocationStore> {
		private String allocationId;

		private Boolean found;

		private Boolean inSync;

		private Number matchingSizeInBytes;

		private Boolean matchingSyncId;

		private String storeException;

		/**
		 * API name: {@code allocation_id}
		 */
		public Builder allocationId(String value) {
			this.allocationId = value;
			return this;
		}

		/**
		 * API name: {@code found}
		 */
		public Builder found(Boolean value) {
			this.found = value;
			return this;
		}

		/**
		 * API name: {@code in_sync}
		 */
		public Builder inSync(Boolean value) {
			this.inSync = value;
			return this;
		}

		/**
		 * API name: {@code matching_size_in_bytes}
		 */
		public Builder matchingSizeInBytes(Number value) {
			this.matchingSizeInBytes = value;
			return this;
		}

		/**
		 * API name: {@code matching_sync_id}
		 */
		public Builder matchingSyncId(Boolean value) {
			this.matchingSyncId = value;
			return this;
		}

		/**
		 * API name: {@code store_exception}
		 */
		public Builder storeException(String value) {
			this.storeException = value;
			return this;
		}

		/**
		 * Builds a {@link AllocationStore}.
		 *
		 * @throws NullPointerException
		 *             if some of the required fields are null.
		 */
		public AllocationStore build() {

			return new AllocationStore(this);
		}
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Json deserializer for AllocationStore
	 */
	public static final JsonpDeserializer<AllocationStore> DESERIALIZER = ObjectBuilderDeserializer
			.createForObject(Builder::new, AllocationStore::setupAllocationStoreDeserializer);

	protected static void setupAllocationStoreDeserializer(DelegatingDeserializer<AllocationStore.Builder> op) {

		op.add(Builder::allocationId, JsonpDeserializer.stringDeserializer(), "allocation_id");
		op.add(Builder::found, JsonpDeserializer.booleanDeserializer(), "found");
		op.add(Builder::inSync, JsonpDeserializer.booleanDeserializer(), "in_sync");
		op.add(Builder::matchingSizeInBytes, JsonpDeserializer.numberDeserializer(), "matching_size_in_bytes");
		op.add(Builder::matchingSyncId, JsonpDeserializer.booleanDeserializer(), "matching_sync_id");
		op.add(Builder::storeException, JsonpDeserializer.stringDeserializer(), "store_exception");

	}

}
