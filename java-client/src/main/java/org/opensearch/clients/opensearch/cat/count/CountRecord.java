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

package org.opensearch.clients.opensearch.cat.count;

import jakarta.json.JsonValue;
import jakarta.json.stream.JsonGenerator;
import org.opensearch.clients.json.DelegatingDeserializer;
import org.opensearch.clients.json.JsonpDeserializer;
import org.opensearch.clients.json.JsonpMapper;
import org.opensearch.clients.json.ObjectBuilderDeserializer;
import org.opensearch.clients.json.ToJsonp;
import org.opensearch.clients.util.ObjectBuilder;

import javax.annotation.Nullable;

// typedef: cat.count.CountRecord
public final class CountRecord implements ToJsonp {
	@Nullable
	private final JsonValue epoch;

	@Nullable
	private final String timestamp;

	@Nullable
	private final String count;

	// ---------------------------------------------------------------------------------------------

	protected CountRecord(Builder builder) {

		this.epoch = builder.epoch;
		this.timestamp = builder.timestamp;
		this.count = builder.count;

	}

	/**
	 * seconds since 1969-01-01 00:00:00
	 *
	 * API name: {@code epoch}
	 */
	@Nullable
	public JsonValue epoch() {
		return this.epoch;
	}

	/**
	 * time in HH:MM:SS
	 *
	 * API name: {@code timestamp}
	 */
	@Nullable
	public String timestamp() {
		return this.timestamp;
	}

	/**
	 * the document count
	 *
	 * API name: {@code count}
	 */
	@Nullable
	public String count() {
		return this.count;
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

		if (this.epoch != null) {

			generator.writeKey("epoch");
			generator.write(this.epoch);

		}
		if (this.timestamp != null) {

			generator.writeKey("timestamp");
			generator.write(this.timestamp);

		}
		if (this.count != null) {

			generator.writeKey("count");
			generator.write(this.count);

		}

	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Builder for {@link CountRecord}.
	 */
	public static class Builder implements ObjectBuilder<CountRecord> {
		@Nullable
		private JsonValue epoch;

		@Nullable
		private String timestamp;

		@Nullable
		private String count;

		/**
		 * seconds since 1969-01-01 00:00:00
		 *
		 * API name: {@code epoch}
		 */
		public Builder epoch(@Nullable JsonValue value) {
			this.epoch = value;
			return this;
		}

		/**
		 * time in HH:MM:SS
		 *
		 * API name: {@code timestamp}
		 */
		public Builder timestamp(@Nullable String value) {
			this.timestamp = value;
			return this;
		}

		/**
		 * the document count
		 *
		 * API name: {@code count}
		 */
		public Builder count(@Nullable String value) {
			this.count = value;
			return this;
		}

		/**
		 * Builds a {@link CountRecord}.
		 *
		 * @throws NullPointerException
		 *             if some of the required fields are null.
		 */
		public CountRecord build() {

			return new CountRecord(this);
		}
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Json deserializer for CountRecord
	 */
	public static final JsonpDeserializer<CountRecord> DESERIALIZER = ObjectBuilderDeserializer
			.createForObject(Builder::new, CountRecord::setupCountRecordDeserializer);

	protected static void setupCountRecordDeserializer(DelegatingDeserializer<CountRecord.Builder> op) {

		op.add(Builder::epoch, JsonpDeserializer.jsonValueDeserializer(), "epoch", "t", "time");
		op.add(Builder::timestamp, JsonpDeserializer.stringDeserializer(), "timestamp", "ts", "hms", "hhmmss");
		op.add(Builder::count, JsonpDeserializer.stringDeserializer(), "count", "dc", "docs.count", "docsCount");

	}

}
