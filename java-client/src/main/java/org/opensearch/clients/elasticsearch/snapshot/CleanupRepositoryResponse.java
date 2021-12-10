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

package org.opensearch.clients.elasticsearch.snapshot;

import org.opensearch.clients.elasticsearch.snapshot.cleanup_repository.CleanupRepositoryResults;
import org.opensearch.clients.json.JsonpDeserializable;
import org.opensearch.clients.json.JsonpDeserializer;
import org.opensearch.clients.json.JsonpMapper;
import org.opensearch.clients.json.JsonpSerializable;
import org.opensearch.clients.json.ObjectBuilderDeserializer;
import org.opensearch.clients.json.ObjectDeserializer;
import org.opensearch.clients.util.ApiTypeHelper;
import org.opensearch.clients.util.ObjectBuilder;
import org.opensearch.clients.util.ObjectBuilderBase;
import jakarta.json.stream.JsonGenerator;

import java.util.function.Function;

// typedef: snapshot.cleanup_repository.Response

/**
 *
 * @see <a href=
 *      "https://github.com/elastic/elasticsearch-specification/tree/98036c3/specification/snapshot/cleanup_repository/SnapshotCleanupRepositoryResponse.ts#L22-L24">API
 *      specification</a>
 */
@JsonpDeserializable
public class CleanupRepositoryResponse implements JsonpSerializable {
	private final CleanupRepositoryResults results;

	// ---------------------------------------------------------------------------------------------

	private CleanupRepositoryResponse(Builder builder) {

		this.results = ApiTypeHelper.requireNonNull(builder.results, this, "results");

	}

	public static CleanupRepositoryResponse of(Function<Builder, ObjectBuilder<CleanupRepositoryResponse>> fn) {
		return fn.apply(new Builder()).build();
	}

	/**
	 * Required - API name: {@code results}
	 */
	public final CleanupRepositoryResults results() {
		return this.results;
	}

	/**
	 * Serialize this object to JSON.
	 */
	public void serialize(JsonGenerator generator, JsonpMapper mapper) {
		generator.writeStartObject();
		serializeInternal(generator, mapper);
		generator.writeEnd();
	}

	protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {

		generator.writeKey("results");
		this.results.serialize(generator, mapper);

	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Builder for {@link CleanupRepositoryResponse}.
	 */

	public static class Builder extends ObjectBuilderBase implements ObjectBuilder<CleanupRepositoryResponse> {
		private CleanupRepositoryResults results;

		/**
		 * Required - API name: {@code results}
		 */
		public final Builder results(CleanupRepositoryResults value) {
			this.results = value;
			return this;
		}

		/**
		 * Required - API name: {@code results}
		 */
		public final Builder results(
				Function<CleanupRepositoryResults.Builder, ObjectBuilder<CleanupRepositoryResults>> fn) {
			return this.results(fn.apply(new CleanupRepositoryResults.Builder()).build());
		}

		/**
		 * Builds a {@link CleanupRepositoryResponse}.
		 *
		 * @throws NullPointerException
		 *             if some of the required fields are null.
		 */
		public CleanupRepositoryResponse build() {
			_checkSingleUse();

			return new CleanupRepositoryResponse(this);
		}
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Json deserializer for {@link CleanupRepositoryResponse}
	 */
	public static final JsonpDeserializer<CleanupRepositoryResponse> _DESERIALIZER = ObjectBuilderDeserializer
			.lazy(Builder::new, CleanupRepositoryResponse::setupCleanupRepositoryResponseDeserializer);

	protected static void setupCleanupRepositoryResponseDeserializer(
			ObjectDeserializer<CleanupRepositoryResponse.Builder> op) {

		op.add(Builder::results, CleanupRepositoryResults._DESERIALIZER, "results");

	}

}
