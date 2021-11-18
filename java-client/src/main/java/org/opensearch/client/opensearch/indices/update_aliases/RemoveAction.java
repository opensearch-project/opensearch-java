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

package org.opensearch.client.opensearch.indices.update_aliases;

import org.opensearch.client.json.DelegatingDeserializer;
import org.opensearch.client.json.JsonpDeserializable;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.JsonpSerializable;
import org.opensearch.client.json.ObjectBuilderDeserializer;
import org.opensearch.client.util.ModelTypeHelper;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import jakarta.json.stream.JsonGenerator;

import java.lang.Boolean;
import java.lang.String;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import javax.annotation.Nullable;

// typedef: indices.update_aliases.RemoveAction
@JsonpDeserializable
public class RemoveAction implements ActionVariant, JsonpSerializable {
	@Nullable
	private final String alias;

	private final List<String> aliases;

	@Nullable
	private final String index;

	private final List<String> indices;

	@Nullable
	private final Boolean mustExist;

	// ---------------------------------------------------------------------------------------------

	private RemoveAction(Builder builder) {

		this.alias = builder.alias;
		this.aliases = ModelTypeHelper.unmodifiable(builder.aliases);
		this.index = builder.index;
		this.indices = ModelTypeHelper.unmodifiable(builder.indices);
		this.mustExist = builder.mustExist;

	}

	public static RemoveAction of(Function<Builder, ObjectBuilder<RemoveAction>> fn) {
		return fn.apply(new Builder()).build();
	}

	/**
	 * {@link Action} variant type
	 */
	@Override
	public String _variantType() {
		return "remove";
	}

	/**
	 * API name: {@code alias}
	 */
	@Nullable
	public final String alias() {
		return this.alias;
	}

	/**
	 * API name: {@code aliases}
	 */
	public final List<String> aliases() {
		return this.aliases;
	}

	/**
	 * API name: {@code index}
	 */
	@Nullable
	public final String index() {
		return this.index;
	}

	/**
	 * API name: {@code indices}
	 */
	public final List<String> indices() {
		return this.indices;
	}

	/**
	 * API name: {@code must_exist}
	 */
	@Nullable
	public final Boolean mustExist() {
		return this.mustExist;
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

		if (this.alias != null) {
			generator.writeKey("alias");
			generator.write(this.alias);

		}
		if (ModelTypeHelper.isDefined(this.aliases)) {
			generator.writeKey("aliases");
			generator.writeStartArray();
			for (String item0 : this.aliases) {
				generator.write(item0);

			}
			generator.writeEnd();

		}
		if (this.index != null) {
			generator.writeKey("index");
			generator.write(this.index);

		}
		if (ModelTypeHelper.isDefined(this.indices)) {
			generator.writeKey("indices");
			generator.writeStartArray();
			for (String item0 : this.indices) {
				generator.write(item0);

			}
			generator.writeEnd();

		}
		if (this.mustExist != null) {
			generator.writeKey("must_exist");
			generator.write(this.mustExist);

		}

	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Builder for {@link RemoveAction}.
	 */
	public static class Builder extends ObjectBuilderBase implements ObjectBuilder<RemoveAction> {
		@Nullable
		private String alias;

		@Nullable
		private List<String> aliases;

		@Nullable
		private String index;

		@Nullable
		private List<String> indices;

		@Nullable
		private Boolean mustExist;

		/**
		 * API name: {@code alias}
		 */
		public final Builder alias(@Nullable String value) {
			this.alias = value;
			return this;
		}

		/**
		 * API name: {@code aliases}
		 */
		public final Builder aliases(@Nullable List<String> value) {
			this.aliases = value;
			return this;
		}

		/**
		 * API name: {@code aliases}
		 */
		public final Builder aliases(String... value) {
			this.aliases = Arrays.asList(value);
			return this;
		}

		/**
		 * API name: {@code index}
		 */
		public final Builder index(@Nullable String value) {
			this.index = value;
			return this;
		}

		/**
		 * API name: {@code indices}
		 */
		public final Builder indices(@Nullable List<String> value) {
			this.indices = value;
			return this;
		}

		/**
		 * API name: {@code indices}
		 */
		public final Builder indices(String... value) {
			this.indices = Arrays.asList(value);
			return this;
		}

		/**
		 * API name: {@code must_exist}
		 */
		public final Builder mustExist(@Nullable Boolean value) {
			this.mustExist = value;
			return this;
		}

		/**
		 * Builds a {@link RemoveAction}.
		 *
		 * @throws NullPointerException
		 *             if some of the required fields are null.
		 */
		public RemoveAction build() {
			_checkSingleUse();

			return new RemoveAction(this);
		}
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Json deserializer for {@link RemoveAction}
	 */
	public static final JsonpDeserializer<RemoveAction> _DESERIALIZER = ObjectBuilderDeserializer.lazy(Builder::new,
			RemoveAction::setupRemoveActionDeserializer, Builder::build);

	protected static void setupRemoveActionDeserializer(DelegatingDeserializer<RemoveAction.Builder> op) {

		op.add(Builder::alias, JsonpDeserializer.stringDeserializer(), "alias");
		op.add(Builder::aliases, JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()),
				"aliases");
		op.add(Builder::index, JsonpDeserializer.stringDeserializer(), "index");
		op.add(Builder::indices, JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()),
				"indices");
		op.add(Builder::mustExist, JsonpDeserializer.booleanDeserializer(), "must_exist");

	}

}
