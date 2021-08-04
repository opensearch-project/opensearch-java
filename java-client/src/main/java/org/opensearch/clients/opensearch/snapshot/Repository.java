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

package org.opensearch.clients.opensearch.snapshot;

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

// typedef: snapshot._types.Repository
public final class Repository implements ToJsonp {
	private final String type;

	@Nullable
	private final String uuid;

	private final RepositorySettings settings;

	// ---------------------------------------------------------------------------------------------

	protected Repository(Builder builder) {

		this.type = Objects.requireNonNull(builder.type, "type");
		this.uuid = builder.uuid;
		this.settings = Objects.requireNonNull(builder.settings, "settings");

	}

	/**
	 * API name: {@code type}
	 */
	public String type() {
		return this.type;
	}

	/**
	 * API name: {@code uuid}
	 */
	@Nullable
	public String uuid() {
		return this.uuid;
	}

	/**
	 * API name: {@code settings}
	 */
	public RepositorySettings settings() {
		return this.settings;
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

		generator.writeKey("type");
		generator.write(this.type);

		if (this.uuid != null) {

			generator.writeKey("uuid");
			generator.write(this.uuid);

		}

		generator.writeKey("settings");
		this.settings.toJsonp(generator, mapper);

	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Builder for {@link Repository}.
	 */
	public static class Builder implements ObjectBuilder<Repository> {
		private String type;

		@Nullable
		private String uuid;

		private RepositorySettings settings;

		/**
		 * API name: {@code type}
		 */
		public Builder type(String value) {
			this.type = value;
			return this;
		}

		/**
		 * API name: {@code uuid}
		 */
		public Builder uuid(@Nullable String value) {
			this.uuid = value;
			return this;
		}

		/**
		 * API name: {@code settings}
		 */
		public Builder settings(RepositorySettings value) {
			this.settings = value;
			return this;
		}

		/**
		 * API name: {@code settings}
		 */
		public Builder settings(Function<RepositorySettings.Builder, ObjectBuilder<RepositorySettings>> fn) {
			return this.settings(fn.apply(new RepositorySettings.Builder()).build());
		}

		/**
		 * Builds a {@link Repository}.
		 *
		 * @throws NullPointerException
		 *             if some of the required fields are null.
		 */
		public Repository build() {

			return new Repository(this);
		}
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Json deserializer for Repository
	 */
	public static final JsonpDeserializer<Repository> DESERIALIZER = ObjectBuilderDeserializer
			.createForObject(Builder::new, Repository::setupRepositoryDeserializer);

	protected static void setupRepositoryDeserializer(DelegatingDeserializer<Repository.Builder> op) {

		op.add(Builder::type, JsonpDeserializer.stringDeserializer(), "type");
		op.add(Builder::uuid, JsonpDeserializer.stringDeserializer(), "uuid");
		op.add(Builder::settings, RepositorySettings.DESERIALIZER, "settings");

	}

}
