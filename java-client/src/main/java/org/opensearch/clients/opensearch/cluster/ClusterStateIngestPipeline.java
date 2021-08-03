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

package org.opensearch.clients.opensearch.cluster;

import jakarta.json.stream.JsonGenerator;
import org.opensearch.clients.json.DelegatingDeserializer;
import org.opensearch.clients.json.JsonpDeserializer;
import org.opensearch.clients.json.JsonpMapper;
import org.opensearch.clients.json.ObjectBuilderDeserializer;
import org.opensearch.clients.json.ToJsonp;
import org.opensearch.clients.util.ObjectBuilder;

import java.util.Objects;
import java.util.function.Function;

// typedef: cluster._types.ClusterStateIngestPipeline
public final class ClusterStateIngestPipeline implements ToJsonp {
	private final String id;

	private final ClusterStateIngestPipelineConfig config;

	// ---------------------------------------------------------------------------------------------

	protected ClusterStateIngestPipeline(Builder builder) {

		this.id = Objects.requireNonNull(builder.id, "id");
		this.config = Objects.requireNonNull(builder.config, "config");

	}

	/**
	 * API name: {@code id}
	 */
	public String id() {
		return this.id;
	}

	/**
	 * API name: {@code config}
	 */
	public ClusterStateIngestPipelineConfig config() {
		return this.config;
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

		generator.writeKey("config");
		this.config.toJsonp(generator, mapper);

	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Builder for {@link ClusterStateIngestPipeline}.
	 */
	public static class Builder implements ObjectBuilder<ClusterStateIngestPipeline> {
		private String id;

		private ClusterStateIngestPipelineConfig config;

		/**
		 * API name: {@code id}
		 */
		public Builder id(String value) {
			this.id = value;
			return this;
		}

		/**
		 * API name: {@code config}
		 */
		public Builder config(ClusterStateIngestPipelineConfig value) {
			this.config = value;
			return this;
		}

		/**
		 * API name: {@code config}
		 */
		public Builder config(
				Function<ClusterStateIngestPipelineConfig.Builder, ObjectBuilder<ClusterStateIngestPipelineConfig>> fn) {
			return this.config(fn.apply(new ClusterStateIngestPipelineConfig.Builder()).build());
		}

		/**
		 * Builds a {@link ClusterStateIngestPipeline}.
		 *
		 * @throws NullPointerException
		 *             if some of the required fields are null.
		 */
		public ClusterStateIngestPipeline build() {

			return new ClusterStateIngestPipeline(this);
		}
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Json deserializer for ClusterStateIngestPipeline
	 */
	public static final JsonpDeserializer<ClusterStateIngestPipeline> DESERIALIZER = ObjectBuilderDeserializer
			.createForObject(Builder::new, ClusterStateIngestPipeline::setupClusterStateIngestPipelineDeserializer);

	protected static void setupClusterStateIngestPipelineDeserializer(
			DelegatingDeserializer<ClusterStateIngestPipeline.Builder> op) {

		op.add(Builder::id, JsonpDeserializer.stringDeserializer(), "id");
		op.add(Builder::config, ClusterStateIngestPipelineConfig.DESERIALIZER, "config");

	}

}
