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

package org.opensearch.clients.elasticsearch._global.search;

import jakarta.json.stream.JsonGenerator;
import org.opensearch.clients.json.DelegatingDeserializer;
import org.opensearch.clients.json.JsonpDeserializer;
import org.opensearch.clients.json.JsonpMapper;
import org.opensearch.clients.json.ObjectBuilderDeserializer;
import org.opensearch.clients.json.ToJsonp;
import org.opensearch.clients.util.ObjectBuilder;

import javax.annotation.Nullable;
import java.util.Objects;
import java.util.function.Function;

// typedef: _global.search._types.NestedIdentity
public final class NestedIdentity implements ToJsonp {
	private final String field;

	private final Number offset;

	@Nullable
	private final org.opensearch.clients.elasticsearch._global.search.NestedIdentity nested;

	// ---------------------------------------------------------------------------------------------

	protected NestedIdentity(Builder builder) {

		this.field = Objects.requireNonNull(builder.field, "field");
		this.offset = Objects.requireNonNull(builder.offset, "offset");
		this.nested = builder.nested;

	}

	/**
	 * API name: {@code field}
	 */
	public String field() {
		return this.field;
	}

	/**
	 * API name: {@code offset}
	 */
	public Number offset() {
		return this.offset;
	}

	/**
	 * API name: {@code _nested}
	 */
	@Nullable
	public org.opensearch.clients.elasticsearch._global.search.NestedIdentity nested() {
		return this.nested;
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

		generator.writeKey("field");
		generator.write(this.field);

		generator.writeKey("offset");
		generator.write(this.offset.doubleValue());

		if (this.nested != null) {

			generator.writeKey("_nested");
			this.nested.toJsonp(generator, mapper);

		}

	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Builder for {@link NestedIdentity}.
	 */
	public static class Builder implements ObjectBuilder<NestedIdentity> {
		private String field;

		private Number offset;

		@Nullable
		private org.opensearch.clients.elasticsearch._global.search.NestedIdentity nested;

		/**
		 * API name: {@code field}
		 */
		public Builder field(String value) {
			this.field = value;
			return this;
		}

		/**
		 * API name: {@code offset}
		 */
		public Builder offset(Number value) {
			this.offset = value;
			return this;
		}

		/**
		 * API name: {@code _nested}
		 */
		public Builder nested(@Nullable org.opensearch.clients.elasticsearch._global.search.NestedIdentity value) {
			this.nested = value;
			return this;
		}

		/**
		 * API name: {@code _nested}
		 */
		public Builder nested(
				Function<org.opensearch.clients.elasticsearch._global.search.NestedIdentity.Builder, ObjectBuilder<org.opensearch.clients.elasticsearch._global.search.NestedIdentity>> fn) {
			return this.nested(
					fn.apply(new org.opensearch.clients.elasticsearch._global.search.NestedIdentity.Builder()).build());
		}

		/**
		 * Builds a {@link NestedIdentity}.
		 *
		 * @throws NullPointerException
		 *             if some of the required fields are null.
		 */
		public NestedIdentity build() {

			return new NestedIdentity(this);
		}
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Json deserializer for NestedIdentity
	 */
	public static final JsonpDeserializer<NestedIdentity> DESERIALIZER = ObjectBuilderDeserializer
			.createForObject(Builder::new, NestedIdentity::setupNestedIdentityDeserializer);

	protected static void setupNestedIdentityDeserializer(DelegatingDeserializer<NestedIdentity.Builder> op) {

		op.add(Builder::field, JsonpDeserializer.stringDeserializer(), "field");
		op.add(Builder::offset, JsonpDeserializer.numberDeserializer(), "offset");
		op.add(Builder::nested, org.opensearch.clients.elasticsearch._global.search.NestedIdentity.DESERIALIZER, "_nested");

	}

}
