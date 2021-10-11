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

package org.opensearch.client.opensearch._types.aggregations;

import jakarta.json.stream.JsonGenerator;
import org.opensearch.client.json.DelegatingDeserializer;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.ObjectBuilderDeserializer;
import org.opensearch.client.json.ToJsonp;
import org.opensearch.client.util.ObjectBuilder;

import javax.annotation.Nullable;

// typedef: _types.aggregations.IpRangeAggregationRange
public final class IpRangeAggregationRange implements ToJsonp {
	@Nullable
	private final String from;

	@Nullable
	private final String mask;

	@Nullable
	private final String to;

	// ---------------------------------------------------------------------------------------------

	protected IpRangeAggregationRange(Builder builder) {

		this.from = builder.from;
		this.mask = builder.mask;
		this.to = builder.to;

	}

	/**
	 * API name: {@code from}
	 */
	@Nullable
	public String from() {
		return this.from;
	}

	/**
	 * API name: {@code mask}
	 */
	@Nullable
	public String mask() {
		return this.mask;
	}

	/**
	 * API name: {@code to}
	 */
	@Nullable
	public String to() {
		return this.to;
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

		if (this.from != null) {

			generator.writeKey("from");
			generator.write(this.from);

		}
		if (this.mask != null) {

			generator.writeKey("mask");
			generator.write(this.mask);

		}
		if (this.to != null) {

			generator.writeKey("to");
			generator.write(this.to);

		}

	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Builder for {@link IpRangeAggregationRange}.
	 */
	public static class Builder implements ObjectBuilder<IpRangeAggregationRange> {
		@Nullable
		private String from;

		@Nullable
		private String mask;

		@Nullable
		private String to;

		/**
		 * API name: {@code from}
		 */
		public Builder from(@Nullable String value) {
			this.from = value;
			return this;
		}

		/**
		 * API name: {@code mask}
		 */
		public Builder mask(@Nullable String value) {
			this.mask = value;
			return this;
		}

		/**
		 * API name: {@code to}
		 */
		public Builder to(@Nullable String value) {
			this.to = value;
			return this;
		}

		/**
		 * Builds a {@link IpRangeAggregationRange}.
		 *
		 * @throws NullPointerException
		 *             if some of the required fields are null.
		 */
		public IpRangeAggregationRange build() {

			return new IpRangeAggregationRange(this);
		}
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Json deserializer for IpRangeAggregationRange
	 */
	public static final JsonpDeserializer<IpRangeAggregationRange> DESERIALIZER = ObjectBuilderDeserializer
			.createForObject(Builder::new, IpRangeAggregationRange::setupIpRangeAggregationRangeDeserializer);

	protected static void setupIpRangeAggregationRangeDeserializer(
			DelegatingDeserializer<IpRangeAggregationRange.Builder> op) {

		op.add(Builder::from, JsonpDeserializer.stringDeserializer(), "from");
		op.add(Builder::mask, JsonpDeserializer.stringDeserializer(), "mask");
		op.add(Builder::to, JsonpDeserializer.stringDeserializer(), "to");

	}

}
