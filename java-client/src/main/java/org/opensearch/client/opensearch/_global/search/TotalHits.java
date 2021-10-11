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

package org.opensearch.client.opensearch._global.search;

import jakarta.json.JsonValue;
import jakarta.json.stream.JsonGenerator;
import org.opensearch.client.json.DelegatingDeserializer;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.ObjectBuilderDeserializer;
import org.opensearch.client.json.ToJsonp;
import org.opensearch.client.util.ObjectBuilder;

import java.util.Objects;

// typedef: _global.search._types.TotalHits
public final class TotalHits implements ToJsonp {
	private final JsonValue relation;

	private final Number value;

	// ---------------------------------------------------------------------------------------------

	protected TotalHits(Builder builder) {

		this.relation = Objects.requireNonNull(builder.relation, "relation");
		this.value = Objects.requireNonNull(builder.value, "value");

	}

	/**
	 * API name: {@code relation}
	 */
	public JsonValue relation() {
		return this.relation;
	}

	/**
	 * API name: {@code value}
	 */
	public Number value() {
		return this.value;
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

		generator.writeKey("relation");
		generator.write(this.relation);

		generator.writeKey("value");
		generator.write(this.value.doubleValue());

	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Builder for {@link TotalHits}.
	 */
	public static class Builder implements ObjectBuilder<TotalHits> {
		private JsonValue relation;

		private Number value;

		/**
		 * API name: {@code relation}
		 */
		public Builder relation(JsonValue value) {
			this.relation = value;
			return this;
		}

		/**
		 * API name: {@code value}
		 */
		public Builder value(Number value) {
			this.value = value;
			return this;
		}

		/**
		 * Builds a {@link TotalHits}.
		 *
		 * @throws NullPointerException
		 *             if some of the required fields are null.
		 */
		public TotalHits build() {

			return new TotalHits(this);
		}
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Json deserializer for TotalHits
	 */
	public static final JsonpDeserializer<TotalHits> DESERIALIZER = ObjectBuilderDeserializer
			.createForObject(Builder::new, TotalHits::setupTotalHitsDeserializer);

	protected static void setupTotalHitsDeserializer(DelegatingDeserializer<TotalHits.Builder> op) {

		op.add(Builder::relation, JsonpDeserializer.jsonValueDeserializer(), "relation");
		op.add(Builder::value, JsonpDeserializer.numberDeserializer(), "value");

	}

}
