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

package org.opensearch.client.opensearch.nodes.info;

import jakarta.json.stream.JsonGenerator;
import org.opensearch.client.json.DelegatingDeserializer;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.ObjectBuilderDeserializer;
import org.opensearch.client.json.ToJsonp;
import org.opensearch.client.util.ObjectBuilder;

import java.util.Objects;

// typedef: nodes.info.NodeInfoRepositoriesUrl
public final class NodeInfoRepositoriesUrl implements ToJsonp {
	private final String allowedUrls;

	// ---------------------------------------------------------------------------------------------

	protected NodeInfoRepositoriesUrl(Builder builder) {

		this.allowedUrls = Objects.requireNonNull(builder.allowedUrls, "allowed_urls");

	}

	/**
	 * API name: {@code allowed_urls}
	 */
	public String allowedUrls() {
		return this.allowedUrls;
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

		generator.writeKey("allowed_urls");
		generator.write(this.allowedUrls);

	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Builder for {@link NodeInfoRepositoriesUrl}.
	 */
	public static class Builder implements ObjectBuilder<NodeInfoRepositoriesUrl> {
		private String allowedUrls;

		/**
		 * API name: {@code allowed_urls}
		 */
		public Builder allowedUrls(String value) {
			this.allowedUrls = value;
			return this;
		}

		/**
		 * Builds a {@link NodeInfoRepositoriesUrl}.
		 *
		 * @throws NullPointerException
		 *             if some of the required fields are null.
		 */
		public NodeInfoRepositoriesUrl build() {

			return new NodeInfoRepositoriesUrl(this);
		}
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Json deserializer for NodeInfoRepositoriesUrl
	 */
	public static final JsonpDeserializer<NodeInfoRepositoriesUrl> DESERIALIZER = ObjectBuilderDeserializer
			.createForObject(Builder::new, NodeInfoRepositoriesUrl::setupNodeInfoRepositoriesUrlDeserializer);

	protected static void setupNodeInfoRepositoriesUrlDeserializer(
			DelegatingDeserializer<NodeInfoRepositoriesUrl.Builder> op) {

		op.add(Builder::allowedUrls, JsonpDeserializer.stringDeserializer(), "allowed_urls");

	}

}
