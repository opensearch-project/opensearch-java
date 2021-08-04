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

package org.opensearch.clients.opensearch._global.search;

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

// typedef: _global.search._types.PointInTimeReference
public final class PointInTimeReference implements ToJsonp {
	private final String id;

	@Nullable
	private final JsonValue keepAlive;

	// ---------------------------------------------------------------------------------------------

	protected PointInTimeReference(Builder builder) {

		this.id = Objects.requireNonNull(builder.id, "id");
		this.keepAlive = builder.keepAlive;

	}

	/**
	 * API name: {@code id}
	 */
	public String id() {
		return this.id;
	}

	/**
	 * API name: {@code keep_alive}
	 */
	@Nullable
	public JsonValue keepAlive() {
		return this.keepAlive;
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

		generator.writeKey("id");
		generator.write(this.id);

		if (this.keepAlive != null) {

			generator.writeKey("keep_alive");
			generator.write(this.keepAlive);

		}

	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Builder for {@link PointInTimeReference}.
	 */
	public static class Builder implements ObjectBuilder<PointInTimeReference> {
		private String id;

		@Nullable
		private JsonValue keepAlive;

		/**
		 * API name: {@code id}
		 */
		public Builder id(String value) {
			this.id = value;
			return this;
		}

		/**
		 * API name: {@code keep_alive}
		 */
		public Builder keepAlive(@Nullable JsonValue value) {
			this.keepAlive = value;
			return this;
		}

		/**
		 * Builds a {@link PointInTimeReference}.
		 *
		 * @throws NullPointerException
		 *             if some of the required fields are null.
		 */
		public PointInTimeReference build() {

			return new PointInTimeReference(this);
		}
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Json deserializer for PointInTimeReference
	 */
	public static final JsonpDeserializer<PointInTimeReference> DESERIALIZER = ObjectBuilderDeserializer
			.createForObject(Builder::new, PointInTimeReference::setupPointInTimeReferenceDeserializer);

	protected static void setupPointInTimeReferenceDeserializer(
			DelegatingDeserializer<PointInTimeReference.Builder> op) {

		op.add(Builder::id, JsonpDeserializer.stringDeserializer(), "id");
		op.add(Builder::keepAlive, JsonpDeserializer.jsonValueDeserializer(), "keep_alive");

	}

}
