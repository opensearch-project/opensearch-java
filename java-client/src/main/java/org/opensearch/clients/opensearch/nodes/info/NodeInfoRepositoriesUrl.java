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

package org.opensearch.clients.opensearch.nodes.info;

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

// typedef: nodes.info.NodeInfoRepositoriesUrl

/**
 *
 * @see <a href=
 *      "https://github.com/elastic/elasticsearch-specification/tree/98036c3/specification/nodes/info/types.ts#L158-L160">API
 *      specification</a>
 */
@JsonpDeserializable
public class NodeInfoRepositoriesUrl implements JsonpSerializable {
	private final String allowedUrls;

	// ---------------------------------------------------------------------------------------------

	private NodeInfoRepositoriesUrl(Builder builder) {

		this.allowedUrls = ApiTypeHelper.requireNonNull(builder.allowedUrls, this, "allowedUrls");

	}

	public static NodeInfoRepositoriesUrl of(Function<Builder, ObjectBuilder<NodeInfoRepositoriesUrl>> fn) {
		return fn.apply(new Builder()).build();
	}

	/**
	 * Required - API name: {@code allowed_urls}
	 */
	public final String allowedUrls() {
		return this.allowedUrls;
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

		generator.writeKey("allowed_urls");
		generator.write(this.allowedUrls);

	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Builder for {@link NodeInfoRepositoriesUrl}.
	 */

	public static class Builder extends ObjectBuilderBase implements ObjectBuilder<NodeInfoRepositoriesUrl> {
		private String allowedUrls;

		/**
		 * Required - API name: {@code allowed_urls}
		 */
		public final Builder allowedUrls(String value) {
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
			_checkSingleUse();

			return new NodeInfoRepositoriesUrl(this);
		}
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Json deserializer for {@link NodeInfoRepositoriesUrl}
	 */
	public static final JsonpDeserializer<NodeInfoRepositoriesUrl> _DESERIALIZER = ObjectBuilderDeserializer
			.lazy(Builder::new, NodeInfoRepositoriesUrl::setupNodeInfoRepositoriesUrlDeserializer);

	protected static void setupNodeInfoRepositoriesUrlDeserializer(
			ObjectDeserializer<NodeInfoRepositoriesUrl.Builder> op) {

		op.add(Builder::allowedUrls, JsonpDeserializer.stringDeserializer(), "allowed_urls");

	}

}
