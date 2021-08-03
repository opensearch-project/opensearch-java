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

package org.opensearch.clients.opensearch.indices.shard_stores;

import jakarta.json.stream.JsonGenerator;
import org.opensearch.clients.json.DelegatingDeserializer;
import org.opensearch.clients.json.JsonpDeserializer;
import org.opensearch.clients.json.JsonpMapper;
import org.opensearch.clients.json.ObjectBuilderDeserializer;
import org.opensearch.clients.json.ToJsonp;
import org.opensearch.clients.util.ObjectBuilder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;

// typedef: indices.shard_stores.ShardStoreWrapper
public final class ShardStoreWrapper implements ToJsonp {
	private final List<ShardStore> stores;

	// ---------------------------------------------------------------------------------------------

	protected ShardStoreWrapper(Builder builder) {

		this.stores = Objects.requireNonNull(builder.stores, "stores");

	}

	/**
	 * API name: {@code stores}
	 */
	public List<ShardStore> stores() {
		return this.stores;
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

		generator.writeKey("stores");
		generator.writeStartArray();
		for (ShardStore item0 : this.stores) {
			item0.toJsonp(generator, mapper);

		}
		generator.writeEnd();

	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Builder for {@link ShardStoreWrapper}.
	 */
	public static class Builder implements ObjectBuilder<ShardStoreWrapper> {
		private List<ShardStore> stores;

		/**
		 * API name: {@code stores}
		 */
		public Builder stores(List<ShardStore> value) {
			this.stores = value;
			return this;
		}

		/**
		 * API name: {@code stores}
		 */
		public Builder stores(ShardStore... value) {
			this.stores = Arrays.asList(value);
			return this;
		}

		/**
		 * Add a value to {@link #stores(List)}, creating the list if needed.
		 */
		public Builder addStores(ShardStore value) {
			if (this.stores == null) {
				this.stores = new ArrayList<>();
			}
			this.stores.add(value);
			return this;
		}

		/**
		 * Set {@link #stores(List)} to a singleton list.
		 */
		public Builder stores(Function<ShardStore.Builder, ObjectBuilder<ShardStore>> fn) {
			return this.stores(fn.apply(new ShardStore.Builder()).build());
		}

		/**
		 * Add a value to {@link #stores(List)}, creating the list if needed.
		 */
		public Builder addStores(Function<ShardStore.Builder, ObjectBuilder<ShardStore>> fn) {
			return this.addStores(fn.apply(new ShardStore.Builder()).build());
		}

		/**
		 * Builds a {@link ShardStoreWrapper}.
		 *
		 * @throws NullPointerException
		 *             if some of the required fields are null.
		 */
		public ShardStoreWrapper build() {

			return new ShardStoreWrapper(this);
		}
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Json deserializer for ShardStoreWrapper
	 */
	public static final JsonpDeserializer<ShardStoreWrapper> DESERIALIZER = ObjectBuilderDeserializer
			.createForObject(Builder::new, ShardStoreWrapper::setupShardStoreWrapperDeserializer);

	protected static void setupShardStoreWrapperDeserializer(DelegatingDeserializer<ShardStoreWrapper.Builder> op) {

		op.add(Builder::stores, JsonpDeserializer.arrayDeserializer(ShardStore.DESERIALIZER), "stores");

	}

}
