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

package org.opensearch.clients.opensearch._types;

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

import java.util.Map;
import java.util.function.Function;
import javax.annotation.Nullable;

// typedef: _types.StoredScript

/**
 *
 * @see <a href=
 *      "https://github.com/elastic/elasticsearch-specification/tree/98036c3/specification/_types/Scripting.ts#L37-L41">API
 *      specification</a>
 */
@JsonpDeserializable
public class StoredScript implements JsonpSerializable {
	private final String lang;

	private final Map<String, String> options;

	private final String source;

	// ---------------------------------------------------------------------------------------------

	private StoredScript(Builder builder) {

		this.lang = ApiTypeHelper.requireNonNull(builder.lang, this, "lang");
		this.options = ApiTypeHelper.unmodifiable(builder.options);
		this.source = ApiTypeHelper.requireNonNull(builder.source, this, "source");

	}

	public static StoredScript of(Function<Builder, ObjectBuilder<StoredScript>> fn) {
		return fn.apply(new Builder()).build();
	}

	/**
	 * Required - API name: {@code lang}
	 */
	public final String lang() {
		return this.lang;
	}

	/**
	 * API name: {@code options}
	 */
	public final Map<String, String> options() {
		return this.options;
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

		generator.writeKey("lang");
		generator.write(this.lang);

		if (ApiTypeHelper.isDefined(this.options)) {
			generator.writeKey("options");
			generator.writeStartObject();
			for (Map.Entry<String, String> item0 : this.options.entrySet()) {
				generator.writeKey(item0.getKey());
				generator.write(item0.getValue());

			}
			generator.writeEnd();

		}
		generator.writeKey("source");
		generator.write(this.source);

	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Builder for {@link StoredScript}.
	 */

	public static class Builder extends ObjectBuilderBase implements ObjectBuilder<StoredScript> {
		private String lang;

		@Nullable
		private Map<String, String> options;

		private String source;

		/**
		 * Required - API name: {@code lang}
		 */
		public final Builder lang(String value) {
			this.lang = value;
			return this;
		}

		/**
		 * API name: {@code options}
		 * <p>
		 * Adds all entries of <code>map</code> to <code>options</code>.
		 */
		public final Builder options(Map<String, String> map) {
			this.options = _mapPutAll(this.options, map);
			return this;
		}

		/**
		 * API name: {@code options}
		 * <p>
		 * Adds an entry to <code>options</code>.
		 */
		public final Builder options(String key, String value) {
			this.options = _mapPut(this.options, key, value);
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
			StoredScript::setupStoredScriptDeserializer);

	protected static void setupStoredScriptDeserializer(ObjectDeserializer<StoredScript.Builder> op) {

		op.add(Builder::lang, JsonpDeserializer.stringDeserializer(), "lang");
		op.add(Builder::options, JsonpDeserializer.stringMapDeserializer(JsonpDeserializer.stringDeserializer()),
				"options");
		op.add(Builder::source, JsonpDeserializer.stringDeserializer(), "source");

	}

}
