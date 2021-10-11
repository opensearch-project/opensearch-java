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

package org.opensearch.client.opensearch._types.mapping;

import jakarta.json.JsonValue;
import jakarta.json.stream.JsonGenerator;
import org.opensearch.client.json.DelegatingDeserializer;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.ObjectBuilderDeserializer;
import org.opensearch.client.json.ToJsonp;
import org.opensearch.client.util.ObjectBuilder;

import javax.annotation.Nullable;
import java.util.Objects;

// typedef: _types.mapping.RuntimeField
public final class RuntimeField implements ToJsonp {
	@Nullable
	private final String format;

	@Nullable
	private final JsonValue script;

	private final JsonValue type;

	// ---------------------------------------------------------------------------------------------

	protected RuntimeField(Builder builder) {

		this.format = builder.format;
		this.script = builder.script;
		this.type = Objects.requireNonNull(builder.type, "type");

	}

	/**
	 * API name: {@code format}
	 */
	@Nullable
	public String format() {
		return this.format;
	}

	/**
	 * API name: {@code script}
	 */
	@Nullable
	public JsonValue script() {
		return this.script;
	}

	/**
	 * API name: {@code type}
	 */
	public JsonValue type() {
		return this.type;
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

		if (this.format != null) {

			generator.writeKey("format");
			generator.write(this.format);

		}
		if (this.script != null) {

			generator.writeKey("script");
			generator.write(this.script);

		}

		generator.writeKey("type");
		generator.write(this.type);

	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Builder for {@link RuntimeField}.
	 */
	public static class Builder implements ObjectBuilder<RuntimeField> {
		@Nullable
		private String format;

		@Nullable
		private JsonValue script;

		private JsonValue type;

		/**
		 * API name: {@code format}
		 */
		public Builder format(@Nullable String value) {
			this.format = value;
			return this;
		}

		/**
		 * API name: {@code script}
		 */
		public Builder script(@Nullable JsonValue value) {
			this.script = value;
			return this;
		}

		/**
		 * API name: {@code type}
		 */
		public Builder type(JsonValue value) {
			this.type = value;
			return this;
		}

		/**
		 * Builds a {@link RuntimeField}.
		 *
		 * @throws NullPointerException
		 *             if some of the required fields are null.
		 */
		public RuntimeField build() {

			return new RuntimeField(this);
		}
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Json deserializer for RuntimeField
	 */
	public static final JsonpDeserializer<RuntimeField> DESERIALIZER = ObjectBuilderDeserializer
			.createForObject(Builder::new, RuntimeField::setupRuntimeFieldDeserializer);

	protected static void setupRuntimeFieldDeserializer(DelegatingDeserializer<RuntimeField.Builder> op) {

		op.add(Builder::format, JsonpDeserializer.stringDeserializer(), "format");
		op.add(Builder::script, JsonpDeserializer.jsonValueDeserializer(), "script");
		op.add(Builder::type, JsonpDeserializer.jsonValueDeserializer(), "type");

	}

}
