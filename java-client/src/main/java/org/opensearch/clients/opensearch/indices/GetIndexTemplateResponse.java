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

package org.opensearch.clients.opensearch.indices;

import org.opensearch.clients.opensearch.indices.get_index_template.IndexTemplateItem;
import org.opensearch.clients.json.DelegatingDeserializer;
import org.opensearch.clients.json.JsonpDeserializable;
import org.opensearch.clients.json.JsonpDeserializer;
import org.opensearch.clients.json.JsonpMapper;
import org.opensearch.clients.json.JsonpSerializable;
import org.opensearch.clients.json.ObjectBuilderDeserializer;
import org.opensearch.clients.util.ModelTypeHelper;
import org.opensearch.clients.util.ObjectBuilder;
import org.opensearch.clients.util.ObjectBuilderBase;
import jakarta.json.stream.JsonGenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

// typedef: indices.get_index_template.Response
@JsonpDeserializable
public class GetIndexTemplateResponse implements JsonpSerializable {
	private final List<IndexTemplateItem> indexTemplates;

	// ---------------------------------------------------------------------------------------------

	private GetIndexTemplateResponse(Builder builder) {

		this.indexTemplates = ModelTypeHelper.unmodifiableRequired(builder.indexTemplates, this, "indexTemplates");

	}

	public static GetIndexTemplateResponse of(Function<Builder, ObjectBuilder<GetIndexTemplateResponse>> fn) {
		return fn.apply(new Builder()).build();
	}

	/**
	 * Required - API name: {@code index_templates}
	 */
	public final List<IndexTemplateItem> indexTemplates() {
		return this.indexTemplates;
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

		if (ModelTypeHelper.isDefined(this.indexTemplates)) {
			generator.writeKey("index_templates");
			generator.writeStartArray();
			for (IndexTemplateItem item0 : this.indexTemplates) {
				item0.serialize(generator, mapper);

			}
			generator.writeEnd();

		}

	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Builder for {@link GetIndexTemplateResponse}.
	 */
	public static class Builder extends ObjectBuilderBase implements ObjectBuilder<GetIndexTemplateResponse> {
		private List<IndexTemplateItem> indexTemplates;

		/**
		 * Required - API name: {@code index_templates}
		 */
		public final Builder indexTemplates(List<IndexTemplateItem> value) {
			this.indexTemplates = value;
			return this;
		}

		/**
		 * Required - API name: {@code index_templates}
		 */
		public final Builder indexTemplates(IndexTemplateItem... value) {
			this.indexTemplates = Arrays.asList(value);
			return this;
		}

		/**
		 * Required - API name: {@code index_templates}
		 */
		@SafeVarargs
		public final Builder indexTemplates(
				Function<IndexTemplateItem.Builder, ObjectBuilder<IndexTemplateItem>>... fns) {
			this.indexTemplates = new ArrayList<>(fns.length);
			for (Function<IndexTemplateItem.Builder, ObjectBuilder<IndexTemplateItem>> fn : fns) {
				this.indexTemplates.add(fn.apply(new IndexTemplateItem.Builder()).build());
			}
			return this;
		}

		/**
		 * Builds a {@link GetIndexTemplateResponse}.
		 *
		 * @throws NullPointerException
		 *             if some of the required fields are null.
		 */
		public GetIndexTemplateResponse build() {
			_checkSingleUse();

			return new GetIndexTemplateResponse(this);
		}
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Json deserializer for {@link GetIndexTemplateResponse}
	 */
	public static final JsonpDeserializer<GetIndexTemplateResponse> _DESERIALIZER = ObjectBuilderDeserializer
			.lazy(Builder::new, GetIndexTemplateResponse::setupGetIndexTemplateResponseDeserializer, Builder::build);

	protected static void setupGetIndexTemplateResponseDeserializer(
			DelegatingDeserializer<GetIndexTemplateResponse.Builder> op) {

		op.add(Builder::indexTemplates, JsonpDeserializer.arrayDeserializer(IndexTemplateItem._DESERIALIZER),
				"index_templates");

	}

}
