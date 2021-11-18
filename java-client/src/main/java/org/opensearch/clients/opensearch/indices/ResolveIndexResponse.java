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

package org.opensearch.clients.opensearch.indices;

import org.opensearch.clients.opensearch.indices.resolve_index.ResolveIndexAliasItem;
import org.opensearch.clients.opensearch.indices.resolve_index.ResolveIndexItem;
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

// typedef: indices.resolve_index.Response
@JsonpDeserializable
public class ResolveIndexResponse implements JsonpSerializable {
	private final List<ResolveIndexItem> indices;

	private final List<ResolveIndexAliasItem> aliases;

	// ---------------------------------------------------------------------------------------------

	private ResolveIndexResponse(Builder builder) {

		this.indices = ModelTypeHelper.unmodifiableRequired(builder.indices, this, "indices");
		this.aliases = ModelTypeHelper.unmodifiableRequired(builder.aliases, this, "aliases");
	}

	public static ResolveIndexResponse of(Function<Builder, ObjectBuilder<ResolveIndexResponse>> fn) {
		return fn.apply(new Builder()).build();
	}

	/**
	 * Required - API name: {@code indices}
	 */
	public final List<ResolveIndexItem> indices() {
		return this.indices;
	}

	/**
	 * Required - API name: {@code aliases}
	 */
	public final List<ResolveIndexAliasItem> aliases() {
		return this.aliases;
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

		if (ModelTypeHelper.isDefined(this.indices)) {
			generator.writeKey("indices");
			generator.writeStartArray();
			for (ResolveIndexItem item0 : this.indices) {
				item0.serialize(generator, mapper);

			}
			generator.writeEnd();

		}
		if (ModelTypeHelper.isDefined(this.aliases)) {
			generator.writeKey("aliases");
			generator.writeStartArray();
			for (ResolveIndexAliasItem item0 : this.aliases) {
				item0.serialize(generator, mapper);

			}
			generator.writeEnd();

		}

	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Builder for {@link ResolveIndexResponse}.
	 */
	public static class Builder extends ObjectBuilderBase implements ObjectBuilder<ResolveIndexResponse> {
		private List<ResolveIndexItem> indices;

		private List<ResolveIndexAliasItem> aliases;

		/**
		 * Required - API name: {@code indices}
		 */
		public final Builder indices(List<ResolveIndexItem> value) {
			this.indices = value;
			return this;
		}

		/**
		 * Required - API name: {@code indices}
		 */
		public final Builder indices(ResolveIndexItem... value) {
			this.indices = Arrays.asList(value);
			return this;
		}

		/**
		 * Required - API name: {@code indices}
		 */
		@SafeVarargs
		public final Builder indices(Function<ResolveIndexItem.Builder, ObjectBuilder<ResolveIndexItem>>... fns) {
			this.indices = new ArrayList<>(fns.length);
			for (Function<ResolveIndexItem.Builder, ObjectBuilder<ResolveIndexItem>> fn : fns) {
				this.indices.add(fn.apply(new ResolveIndexItem.Builder()).build());
			}
			return this;
		}

		/**
		 * Required - API name: {@code aliases}
		 */
		public final Builder aliases(List<ResolveIndexAliasItem> value) {
			this.aliases = value;
			return this;
		}

		/**
		 * Required - API name: {@code aliases}
		 */
		public final Builder aliases(ResolveIndexAliasItem... value) {
			this.aliases = Arrays.asList(value);
			return this;
		}

		/**
		 * Required - API name: {@code aliases}
		 */
		@SafeVarargs
		public final Builder aliases(
				Function<ResolveIndexAliasItem.Builder, ObjectBuilder<ResolveIndexAliasItem>>... fns) {
			this.aliases = new ArrayList<>(fns.length);
			for (Function<ResolveIndexAliasItem.Builder, ObjectBuilder<ResolveIndexAliasItem>> fn : fns) {
				this.aliases.add(fn.apply(new ResolveIndexAliasItem.Builder()).build());
			}
			return this;
		}

		/**
		 * Builds a {@link ResolveIndexResponse}.
		 *
		 * @throws NullPointerException
		 *             if some of the required fields are null.
		 */
		public ResolveIndexResponse build() {
			_checkSingleUse();

			return new ResolveIndexResponse(this);
		}
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Json deserializer for {@link ResolveIndexResponse}
	 */
	public static final JsonpDeserializer<ResolveIndexResponse> _DESERIALIZER = ObjectBuilderDeserializer
			.lazy(Builder::new, ResolveIndexResponse::setupResolveIndexResponseDeserializer, Builder::build);

	protected static void setupResolveIndexResponseDeserializer(
			DelegatingDeserializer<ResolveIndexResponse.Builder> op) {

		op.add(Builder::indices, JsonpDeserializer.arrayDeserializer(ResolveIndexItem._DESERIALIZER), "indices");
		op.add(Builder::aliases, JsonpDeserializer.arrayDeserializer(ResolveIndexAliasItem._DESERIALIZER), "aliases");

	}

}
