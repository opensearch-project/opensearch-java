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

package org.opensearch.clients.opensearch.cat.master;

import jakarta.json.stream.JsonGenerator;
import org.opensearch.clients.json.DelegatingDeserializer;
import org.opensearch.clients.json.JsonpDeserializer;
import org.opensearch.clients.json.JsonpMapper;
import org.opensearch.clients.json.ObjectBuilderDeserializer;
import org.opensearch.clients.json.ToJsonp;
import org.opensearch.clients.util.ObjectBuilder;

import javax.annotation.Nullable;

// typedef: cat.master.MasterRecord
public final class MasterRecord implements ToJsonp {
	@Nullable
	private final String id;

	@Nullable
	private final String host;

	@Nullable
	private final String ip;

	@Nullable
	private final String node;

	// ---------------------------------------------------------------------------------------------

	protected MasterRecord(Builder builder) {

		this.id = builder.id;
		this.host = builder.host;
		this.ip = builder.ip;
		this.node = builder.node;

	}

	/**
	 * node id
	 *
	 * API name: {@code id}
	 */
	@Nullable
	public String id() {
		return this.id;
	}

	/**
	 * host name
	 *
	 * API name: {@code host}
	 */
	@Nullable
	public String host() {
		return this.host;
	}

	/**
	 * ip address
	 *
	 * API name: {@code ip}
	 */
	@Nullable
	public String ip() {
		return this.ip;
	}

	/**
	 * node name
	 *
	 * API name: {@code node}
	 */
	@Nullable
	public String node() {
		return this.node;
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

		if (this.id != null) {

			generator.writeKey("id");
			generator.write(this.id);

		}
		if (this.host != null) {

			generator.writeKey("host");
			generator.write(this.host);

		}
		if (this.ip != null) {

			generator.writeKey("ip");
			generator.write(this.ip);

		}
		if (this.node != null) {

			generator.writeKey("node");
			generator.write(this.node);

		}

	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Builder for {@link MasterRecord}.
	 */
	public static class Builder implements ObjectBuilder<MasterRecord> {
		@Nullable
		private String id;

		@Nullable
		private String host;

		@Nullable
		private String ip;

		@Nullable
		private String node;

		/**
		 * node id
		 *
		 * API name: {@code id}
		 */
		public Builder id(@Nullable String value) {
			this.id = value;
			return this;
		}

		/**
		 * host name
		 *
		 * API name: {@code host}
		 */
		public Builder host(@Nullable String value) {
			this.host = value;
			return this;
		}

		/**
		 * ip address
		 *
		 * API name: {@code ip}
		 */
		public Builder ip(@Nullable String value) {
			this.ip = value;
			return this;
		}

		/**
		 * node name
		 *
		 * API name: {@code node}
		 */
		public Builder node(@Nullable String value) {
			this.node = value;
			return this;
		}

		/**
		 * Builds a {@link MasterRecord}.
		 *
		 * @throws NullPointerException
		 *             if some of the required fields are null.
		 */
		public MasterRecord build() {

			return new MasterRecord(this);
		}
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Json deserializer for MasterRecord
	 */
	public static final JsonpDeserializer<MasterRecord> DESERIALIZER = ObjectBuilderDeserializer
			.createForObject(Builder::new, MasterRecord::setupMasterRecordDeserializer);

	protected static void setupMasterRecordDeserializer(DelegatingDeserializer<MasterRecord.Builder> op) {

		op.add(Builder::id, JsonpDeserializer.stringDeserializer(), "id");
		op.add(Builder::host, JsonpDeserializer.stringDeserializer(), "host", "h");
		op.add(Builder::ip, JsonpDeserializer.stringDeserializer(), "ip");
		op.add(Builder::node, JsonpDeserializer.stringDeserializer(), "node", "n");

	}

}
