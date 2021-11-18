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

package org.opensearch.client.opensearch._types;

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
import java.lang.String;
import java.util.function.Function;
import javax.annotation.Nullable;

// typedef: _types.StoredScript
@JsonpDeserializable
public class StoredScript implements JsonpSerializable {
	@Nullable
	private final ScriptLanguage lang;

	private final String source;

	// ---------------------------------------------------------------------------------------------

	private StoredScript(Builder builder) {

		this.lang = builder.lang;
		this.source = ModelTypeHelper.requireNonNull(builder.source, this, "source");

	}

	public static StoredScript of(Function<Builder, ObjectBuilder<StoredScript>> fn) {
		return fn.apply(new Builder()).build();
	}

	/**
	 * API name: {@code lang}
	 */
	@Nullable
	public final ScriptLanguage lang() {
		return this.lang;
	}

	/**
	 * Required - API name: {@code source}
	 */
	public final String source() {
		return this.source;
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

		if (this.lang != null) {
			generator.writeKey("lang");
			this.lang.serialize(generator, mapper);
		}
		generator.writeKey("source");
		generator.write(this.source);

	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Builder for {@link StoredScript}.
	 */
	public static class Builder extends ObjectBuilderBase implements ObjectBuilder<StoredScript> {
		@Nullable
		private ScriptLanguage lang;

		private String source;

		/**
		 * API name: {@code lang}
		 */
		public final Builder lang(@Nullable ScriptLanguage value) {
			this.lang = value;
			return this;
		}

		/**
		 * Required - API name: {@code source}
		 */
		public final Builder source(String value) {
			this.source = value;
			return this;
		}

		/**
		 * Builds a {@link StoredScript}.
		 *
		 * @throws NullPointerException
		 *             if some of the required fields are null.
		 */
		public StoredScript build() {
			_checkSingleUse();

			return new StoredScript(this);
		}
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Json deserializer for {@link StoredScript}
	 */
	public static final JsonpDeserializer<StoredScript> _DESERIALIZER = ObjectBuilderDeserializer.lazy(Builder::new,
			StoredScript::setupStoredScriptDeserializer, Builder::build);

	protected static void setupStoredScriptDeserializer(DelegatingDeserializer<StoredScript.Builder> op) {

		op.add(Builder::lang, ScriptLanguage._DESERIALIZER, "lang");
		op.add(Builder::source, JsonpDeserializer.stringDeserializer(), "source");

	}

}
