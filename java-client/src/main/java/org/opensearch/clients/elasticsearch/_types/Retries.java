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

package org.opensearch.clients.elasticsearch._types;

import jakarta.json.stream.JsonGenerator;
import org.opensearch.clients.json.DelegatingDeserializer;
import org.opensearch.clients.json.JsonpDeserializer;
import org.opensearch.clients.json.JsonpMapper;
import org.opensearch.clients.json.ObjectBuilderDeserializer;
import org.opensearch.clients.json.ToJsonp;
import org.opensearch.clients.util.ObjectBuilder;

import java.util.Objects;

// typedef: _types.Retries
public final class Retries implements ToJsonp {
	private final Number bulk;

	private final Number search;

	// ---------------------------------------------------------------------------------------------

	protected Retries(Builder builder) {

		this.bulk = Objects.requireNonNull(builder.bulk, "bulk");
		this.search = Objects.requireNonNull(builder.search, "search");

	}

	/**
	 * API name: {@code bulk}
	 */
	public Number bulk() {
		return this.bulk;
	}

	/**
	 * API name: {@code search}
	 */
	public Number search() {
		return this.search;
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

		generator.writeKey("bulk");
		generator.write(this.bulk.doubleValue());

		generator.writeKey("search");
		generator.write(this.search.doubleValue());

	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Builder for {@link Retries}.
	 */
	public static class Builder implements ObjectBuilder<Retries> {
		private Number bulk;

		private Number search;

		/**
		 * API name: {@code bulk}
		 */
		public Builder bulk(Number value) {
			this.bulk = value;
			return this;
		}

		/**
		 * API name: {@code search}
		 */
		public Builder search(Number value) {
			this.search = value;
			return this;
		}

		/**
		 * Builds a {@link Retries}.
		 *
		 * @throws NullPointerException
		 *             if some of the required fields are null.
		 */
		public Retries build() {

			return new Retries(this);
		}
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Json deserializer for Retries
	 */
	public static final JsonpDeserializer<Retries> DESERIALIZER = ObjectBuilderDeserializer
			.createForObject(Builder::new, Retries::setupRetriesDeserializer);

	protected static void setupRetriesDeserializer(DelegatingDeserializer<Retries.Builder> op) {

		op.add(Builder::bulk, JsonpDeserializer.numberDeserializer(), "bulk");
		op.add(Builder::search, JsonpDeserializer.numberDeserializer(), "search");

	}

}
