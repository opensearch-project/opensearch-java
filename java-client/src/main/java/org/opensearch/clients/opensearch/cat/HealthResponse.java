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

package org.opensearch.clients.opensearch.cat;

import jakarta.json.stream.JsonGenerator;
import org.opensearch.clients.opensearch.cat.health.HealthRecord;
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

// typedef: cat.health.Response
public final class HealthResponse implements ToJsonp {
	private final List<HealthRecord> value;

	// ---------------------------------------------------------------------------------------------

	protected HealthResponse(Builder builder) {

		this.value = Objects.requireNonNull(builder.value, "value");

	}

	/**
	 * Response value.
	 *
	 * API name: {@code value}
	 */
	public List<HealthRecord> value() {
		return this.value;
	}

	/**
	 * Serialize this value to JSON.
	 */
	public void toJsonp(JsonGenerator generator, JsonpMapper mapper) {
		generator.writeStartArray();
		for (HealthRecord item0 : this.value) {
			item0.toJsonp(generator, mapper);

		}
		generator.writeEnd();

	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Builder for {@link HealthResponse}.
	 */
	public static class Builder implements ObjectBuilder<HealthResponse> {
		private List<HealthRecord> value;

		/**
		 * Response value.
		 *
		 * API name: {@code value}
		 */
		public Builder value(List<HealthRecord> value) {
			this.value = value;
			return this;
		}

		/**
		 * Response value.
		 *
		 * API name: {@code value}
		 */
		public Builder value(HealthRecord... value) {
			this.value = Arrays.asList(value);
			return this;
		}

		/**
		 * Add a value to {@link #value(List)}, creating the list if needed.
		 */
		public Builder addValue(HealthRecord value) {
			if (this.value == null) {
				this.value = new ArrayList<>();
			}
			this.value.add(value);
			return this;
		}

		/**
		 * Set {@link #value(List)} to a singleton list.
		 */
		public Builder value(Function<HealthRecord.Builder, ObjectBuilder<HealthRecord>> fn) {
			return this.value(fn.apply(new HealthRecord.Builder()).build());
		}

		/**
		 * Add a value to {@link #value(List)}, creating the list if needed.
		 */
		public Builder addValue(Function<HealthRecord.Builder, ObjectBuilder<HealthRecord>> fn) {
			return this.addValue(fn.apply(new HealthRecord.Builder()).build());
		}

		/**
		 * Builds a {@link HealthResponse}.
		 *
		 * @throws NullPointerException
		 *             if some of the required fields are null.
		 */
		public HealthResponse build() {

			return new HealthResponse(this);
		}
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Json deserializer for HealthResponse
	 */
	public static final JsonpDeserializer<HealthResponse> DESERIALIZER = ObjectBuilderDeserializer
			.createForObject(Builder::new, HealthResponse::setupHealthResponseDeserializer);

	protected static void setupHealthResponseDeserializer(DelegatingDeserializer<HealthResponse.Builder> op) {

		op.add(Builder::value, JsonpDeserializer.arrayDeserializer(HealthRecord.DESERIALIZER), "value");

	}

}
