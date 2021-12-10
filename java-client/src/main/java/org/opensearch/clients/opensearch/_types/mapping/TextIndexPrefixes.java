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

package org.opensearch.clients.opensearch._types.mapping;

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

// typedef: _types.mapping.TextIndexPrefixes

/**
 *
 * @see <a href=
 *      "https://github.com/elastic/elasticsearch-specification/tree/98036c3/specification/_types/mapping/core.ts#L247-L250">API
 *      specification</a>
 */
@JsonpDeserializable
public class TextIndexPrefixes implements JsonpSerializable {
	private final int maxChars;

	private final int minChars;

	// ---------------------------------------------------------------------------------------------

	private TextIndexPrefixes(Builder builder) {

		this.maxChars = ApiTypeHelper.requireNonNull(builder.maxChars, this, "maxChars");
		this.minChars = ApiTypeHelper.requireNonNull(builder.minChars, this, "minChars");

	}

	public static TextIndexPrefixes of(Function<Builder, ObjectBuilder<TextIndexPrefixes>> fn) {
		return fn.apply(new Builder()).build();
	}

	/**
	 * Required - API name: {@code max_chars}
	 */
	public final int maxChars() {
		return this.maxChars;
	}

	/**
	 * Required - API name: {@code min_chars}
	 */
	public final int minChars() {
		return this.minChars;
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

		generator.writeKey("max_chars");
		generator.write(this.maxChars);

		generator.writeKey("min_chars");
		generator.write(this.minChars);

	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Builder for {@link TextIndexPrefixes}.
	 */

	public static class Builder extends ObjectBuilderBase implements ObjectBuilder<TextIndexPrefixes> {
		private Integer maxChars;

		private Integer minChars;

		/**
		 * Required - API name: {@code max_chars}
		 */
		public final Builder maxChars(int value) {
			this.maxChars = value;
			return this;
		}

		/**
		 * Required - API name: {@code min_chars}
		 */
		public final Builder minChars(int value) {
			this.minChars = value;
			return this;
		}

		/**
		 * Builds a {@link TextIndexPrefixes}.
		 *
		 * @throws NullPointerException
		 *             if some of the required fields are null.
		 */
		public TextIndexPrefixes build() {
			_checkSingleUse();

			return new TextIndexPrefixes(this);
		}
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Json deserializer for {@link TextIndexPrefixes}
	 */
	public static final JsonpDeserializer<TextIndexPrefixes> _DESERIALIZER = ObjectBuilderDeserializer
			.lazy(Builder::new, TextIndexPrefixes::setupTextIndexPrefixesDeserializer);

	protected static void setupTextIndexPrefixesDeserializer(ObjectDeserializer<TextIndexPrefixes.Builder> op) {

		op.add(Builder::maxChars, JsonpDeserializer.integerDeserializer(), "max_chars");
		op.add(Builder::minChars, JsonpDeserializer.integerDeserializer(), "min_chars");

	}

}
