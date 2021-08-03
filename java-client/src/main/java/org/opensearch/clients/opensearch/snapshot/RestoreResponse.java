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
import org.opensearch.clients.opensearch.snapshot.restore.SnapshotRestore;
import org.opensearch.clients.json.DelegatingDeserializer;
import org.opensearch.clients.json.JsonpDeserializer;
import org.opensearch.clients.json.JsonpMapper;
import org.opensearch.clients.json.ObjectBuilderDeserializer;
import org.opensearch.clients.json.ToJsonp;
import org.opensearch.clients.util.ObjectBuilder;

import java.util.Objects;
import java.util.function.Function;

// typedef: snapshot.restore.Response
public final class RestoreResponse implements ToJsonp {
	private final SnapshotRestore snapshot;

	// ---------------------------------------------------------------------------------------------

	protected RestoreResponse(Builder builder) {

		this.snapshot = Objects.requireNonNull(builder.snapshot, "snapshot");

	}

	/**
	 * API name: {@code snapshot}
	 */
	public SnapshotRestore snapshot() {
		return this.snapshot;
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

		generator.writeKey("snapshot");
		this.snapshot.toJsonp(generator, mapper);

	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Builder for {@link RestoreResponse}.
	 */
	public static class Builder implements ObjectBuilder<RestoreResponse> {
		private SnapshotRestore snapshot;

		/**
		 * API name: {@code snapshot}
		 */
		public Builder snapshot(SnapshotRestore value) {
			this.snapshot = value;
			return this;
		}

		/**
		 * API name: {@code snapshot}
		 */
		public Builder snapshot(Function<SnapshotRestore.Builder, ObjectBuilder<SnapshotRestore>> fn) {
			return this.snapshot(fn.apply(new SnapshotRestore.Builder()).build());
		}

		/**
		 * Builds a {@link RestoreResponse}.
		 *
		 * @throws NullPointerException
		 *             if some of the required fields are null.
		 */
		public RestoreResponse build() {

			return new RestoreResponse(this);
		}
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Json deserializer for RestoreResponse
	 */
	public static final JsonpDeserializer<RestoreResponse> DESERIALIZER = ObjectBuilderDeserializer
			.createForObject(Builder::new, RestoreResponse::setupRestoreResponseDeserializer);

	protected static void setupRestoreResponseDeserializer(DelegatingDeserializer<RestoreResponse.Builder> op) {

		op.add(Builder::snapshot, SnapshotRestore.DESERIALIZER, "snapshot");

	}

}
