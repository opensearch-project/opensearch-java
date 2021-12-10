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

package org.opensearch.clients.elasticsearch.security.get_role;

import org.opensearch.clients.elasticsearch._types.Script;
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
import javax.annotation.Nullable;

// typedef: security.get_role.RoleTemplate

/**
 *
 * @see <a href=
 *      "https://github.com/elastic/elasticsearch-specification/tree/98036c3/specification/security/get_role/types.ts#L47-L50">API
 *      specification</a>
 */
@JsonpDeserializable
public class RoleTemplate implements JsonpSerializable {
	@Nullable
	private final TemplateFormat format;

	private final Script template;

	// ---------------------------------------------------------------------------------------------

	private RoleTemplate(Builder builder) {

		this.format = builder.format;
		this.template = ApiTypeHelper.requireNonNull(builder.template, this, "template");

	}

	public static RoleTemplate of(Function<Builder, ObjectBuilder<RoleTemplate>> fn) {
		return fn.apply(new Builder()).build();
	}

	/**
	 * API name: {@code format}
	 */
	@Nullable
	public final TemplateFormat format() {
		return this.format;
	}

	/**
	 * Required - API name: {@code template}
	 */
	public final Script template() {
		return this.template;
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

		if (this.format != null) {
			generator.writeKey("format");
			this.format.serialize(generator, mapper);
		}
		generator.writeKey("template");
		this.template.serialize(generator, mapper);

	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Builder for {@link RoleTemplate}.
	 */

	public static class Builder extends ObjectBuilderBase implements ObjectBuilder<RoleTemplate> {
		@Nullable
		private TemplateFormat format;

		private Script template;

		/**
		 * API name: {@code format}
		 */
		public final Builder format(@Nullable TemplateFormat value) {
			this.format = value;
			return this;
		}

		/**
		 * Required - API name: {@code template}
		 */
		public final Builder template(Script value) {
			this.template = value;
			return this;
		}

		/**
		 * Required - API name: {@code template}
		 */
		public final Builder template(Function<Script.Builder, ObjectBuilder<Script>> fn) {
			return this.template(fn.apply(new Script.Builder()).build());
		}

		/**
		 * Builds a {@link RoleTemplate}.
		 *
		 * @throws NullPointerException
		 *             if some of the required fields are null.
		 */
		public RoleTemplate build() {
			_checkSingleUse();

			return new RoleTemplate(this);
		}
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Json deserializer for {@link RoleTemplate}
	 */
	public static final JsonpDeserializer<RoleTemplate> _DESERIALIZER = ObjectBuilderDeserializer.lazy(Builder::new,
			RoleTemplate::setupRoleTemplateDeserializer);

	protected static void setupRoleTemplateDeserializer(ObjectDeserializer<RoleTemplate.Builder> op) {

		op.add(Builder::format, TemplateFormat._DESERIALIZER, "format");
		op.add(Builder::template, Script._DESERIALIZER, "template");

	}

}
