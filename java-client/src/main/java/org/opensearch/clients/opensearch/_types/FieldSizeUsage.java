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

package org.opensearch.clients.opensearch._types;

import jakarta.json.JsonValue;
import jakarta.json.stream.JsonGenerator;
import org.opensearch.clients.json.DelegatingDeserializer;
import org.opensearch.clients.json.JsonpDeserializer;
import org.opensearch.clients.json.JsonpMapper;
import org.opensearch.clients.json.ObjectBuilderDeserializer;
import org.opensearch.clients.json.ToJsonp;
import org.opensearch.clients.util.ObjectBuilder;

import javax.annotation.Nullable;
import java.util.Objects;

// typedef: _types.FieldSizeUsage
public final class FieldSizeUsage implements ToJsonp {
	@Nullable
	private final JsonValue size;

	private final Number sizeInBytes;

	// ---------------------------------------------------------------------------------------------

	protected FieldSizeUsage(Builder builder) {

		this.size = builder.size;
		this.sizeInBytes = Objects.requireNonNull(builder.sizeInBytes, "size_in_bytes");

	}

	/**
	 * API name: {@code size}
	 */
	@Nullable
	public JsonValue size() {
		return this.size;
	}

	/**
	 * API name: {@code size_in_bytes}
	 */
	public Number sizeInBytes() {
		return this.sizeInBytes;
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

		if (this.size != null) {

			generator.writeKey("size");
			generator.write(this.size);

		}

		generator.writeKey("size_in_bytes");
		generator.write(this.sizeInBytes.doubleValue());

	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Builder for {@link FieldSizeUsage}.
	 */
	public static class Builder implements ObjectBuilder<FieldSizeUsage> {
		@Nullable
		private JsonValue size;

		private Number sizeInBytes;

		/**
		 * API name: {@code size}
		 */
		public Builder size(@Nullable JsonValue value) {
			this.size = value;
			return this;
		}

		/**
		 * API name: {@code size_in_bytes}
		 */
		public Builder sizeInBytes(Number value) {
			this.sizeInBytes = value;
			return this;
		}

		/**
		 * Builds a {@link FieldSizeUsage}.
		 *
		 * @throws NullPointerException
		 *             if some of the required fields are null.
		 */
		public FieldSizeUsage build() {

			return new FieldSizeUsage(this);
		}
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Json deserializer for FieldSizeUsage
	 */
	public static final JsonpDeserializer<FieldSizeUsage> DESERIALIZER = ObjectBuilderDeserializer
			.createForObject(Builder::new, FieldSizeUsage::setupFieldSizeUsageDeserializer);

	protected static void setupFieldSizeUsageDeserializer(DelegatingDeserializer<FieldSizeUsage.Builder> op) {

		op.add(Builder::size, JsonpDeserializer.jsonValueDeserializer(), "size");
		op.add(Builder::sizeInBytes, JsonpDeserializer.numberDeserializer(), "size_in_bytes");

	}

}
