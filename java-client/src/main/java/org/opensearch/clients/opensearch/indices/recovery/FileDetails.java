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

package org.opensearch.clients.opensearch.indices.recovery;

import jakarta.json.stream.JsonGenerator;
import org.opensearch.clients.json.DelegatingDeserializer;
import org.opensearch.clients.json.JsonpDeserializer;
import org.opensearch.clients.json.JsonpMapper;
import org.opensearch.clients.json.ObjectBuilderDeserializer;
import org.opensearch.clients.json.ToJsonp;
import org.opensearch.clients.util.ObjectBuilder;

import java.util.Objects;

// typedef: indices.recovery.FileDetails
public final class FileDetails implements ToJsonp {
	private final Number length;

	private final String name;

	private final Number recovered;

	// ---------------------------------------------------------------------------------------------

	protected FileDetails(Builder builder) {

		this.length = Objects.requireNonNull(builder.length, "length");
		this.name = Objects.requireNonNull(builder.name, "name");
		this.recovered = Objects.requireNonNull(builder.recovered, "recovered");

	}

	/**
	 * API name: {@code length}
	 */
	public Number length() {
		return this.length;
	}

	/**
	 * API name: {@code name}
	 */
	public String name() {
		return this.name;
	}

	/**
	 * API name: {@code recovered}
	 */
	public Number recovered() {
		return this.recovered;
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

		generator.writeKey("length");
		generator.write(this.length.doubleValue());

		generator.writeKey("name");
		generator.write(this.name);

		generator.writeKey("recovered");
		generator.write(this.recovered.doubleValue());

	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Builder for {@link FileDetails}.
	 */
	public static class Builder implements ObjectBuilder<FileDetails> {
		private Number length;

		private String name;

		private Number recovered;

		/**
		 * API name: {@code length}
		 */
		public Builder length(Number value) {
			this.length = value;
			return this;
		}

		/**
		 * API name: {@code name}
		 */
		public Builder name(String value) {
			this.name = value;
			return this;
		}

		/**
		 * API name: {@code recovered}
		 */
		public Builder recovered(Number value) {
			this.recovered = value;
			return this;
		}

		/**
		 * Builds a {@link FileDetails}.
		 *
		 * @throws NullPointerException
		 *             if some of the required fields are null.
		 */
		public FileDetails build() {

			return new FileDetails(this);
		}
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Json deserializer for FileDetails
	 */
	public static final JsonpDeserializer<FileDetails> DESERIALIZER = ObjectBuilderDeserializer
			.createForObject(Builder::new, FileDetails::setupFileDetailsDeserializer);

	protected static void setupFileDetailsDeserializer(DelegatingDeserializer<FileDetails.Builder> op) {

		op.add(Builder::length, JsonpDeserializer.numberDeserializer(), "length");
		op.add(Builder::name, JsonpDeserializer.stringDeserializer(), "name");
		op.add(Builder::recovered, JsonpDeserializer.numberDeserializer(), "recovered");

	}

}
