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

package org.opensearch.clients.opensearch._global;

import jakarta.json.stream.JsonGenerator;
import org.opensearch.clients.opensearch._types.ShardStatistics;
import org.opensearch.clients.json.DelegatingDeserializer;
import org.opensearch.clients.json.JsonpDeserializer;
import org.opensearch.clients.json.JsonpMapper;
import org.opensearch.clients.json.ObjectBuilderDeserializer;
import org.opensearch.clients.json.ToJsonp;
import org.opensearch.clients.util.ObjectBuilder;

import java.util.Objects;
import java.util.function.Function;

// typedef: _global.count.Response
public final class CountResponse implements ToJsonp {
	private final Number count;

	private final ShardStatistics shards;

	// ---------------------------------------------------------------------------------------------

	protected CountResponse(Builder builder) {

		this.count = Objects.requireNonNull(builder.count, "count");
		this.shards = Objects.requireNonNull(builder.shards, "_shards");

	}

	/**
	 * API name: {@code count}
	 */
	public Number count() {
		return this.count;
	}

	/**
	 * API name: {@code _shards}
	 */
	public ShardStatistics shards() {
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

		generator.writeKey("count");
		generator.write(this.count.doubleValue());

		generator.writeKey("_shards");
		this.shards.toJsonp(generator, mapper);

	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Builder for {@link CountResponse}.
	 */
	public static class Builder implements ObjectBuilder<CountResponse> {
		private Number count;

		private ShardStatistics shards;

		/**
		 * API name: {@code count}
		 */
		public Builder count(Number value) {
			this.count = value;
			return this;
		}

		/**
		 * API name: {@code _shards}
		 */
		public Builder shards(ShardStatistics value) {
			this.shards = value;
			return this;
		}

		/**
		 * API name: {@code _shards}
		 */
		public Builder shards(Function<ShardStatistics.Builder, ObjectBuilder<ShardStatistics>> fn) {
			return this.shards(fn.apply(new ShardStatistics.Builder()).build());
		}

		/**
		 * Builds a {@link CountResponse}.
		 *
		 * @throws NullPointerException
		 *             if some of the required fields are null.
		 */
		public CountResponse build() {

			return new CountResponse(this);
		}
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Json deserializer for CountResponse
	 */
	public static final JsonpDeserializer<CountResponse> DESERIALIZER = ObjectBuilderDeserializer
			.createForObject(Builder::new, CountResponse::setupCountResponseDeserializer);

	protected static void setupCountResponseDeserializer(DelegatingDeserializer<CountResponse.Builder> op) {

		op.add(Builder::count, JsonpDeserializer.numberDeserializer(), "count");
		op.add(Builder::shards, ShardStatistics.DESERIALIZER, "_shards");

	}

}
