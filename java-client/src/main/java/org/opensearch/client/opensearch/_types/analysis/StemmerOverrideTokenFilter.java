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

package org.opensearch.client.opensearch._types.analysis;

import org.opensearch.client.json.DelegatingDeserializer;
import org.opensearch.client.json.JsonpDeserializable;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.ObjectBuilderDeserializer;
import org.opensearch.client.util.ModelTypeHelper;
import org.opensearch.client.util.ObjectBuilder;
import jakarta.json.stream.JsonGenerator;
import java.lang.String;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import javax.annotation.Nullable;

// typedef: _types.analysis.StemmerOverrideTokenFilter
@JsonpDeserializable
public class StemmerOverrideTokenFilter extends TokenFilterBase implements TokenFilterVariant {
	private final List<String> rules;

	@Nullable
	private final String rulesPath;

	// ---------------------------------------------------------------------------------------------

	private StemmerOverrideTokenFilter(Builder builder) {
		super(builder);

		this.rules = ModelTypeHelper.unmodifiable(builder.rules);
		this.rulesPath = builder.rulesPath;

	}

	public static StemmerOverrideTokenFilter of(Function<Builder, ObjectBuilder<StemmerOverrideTokenFilter>> fn) {
		return fn.apply(new Builder()).build();
	}

	/**
	 * {@link TokenFilter} variant type
	 */
	@Override
	public String _variantType() {
		return "stemmer_override";
	}

	/**
	 * API name: {@code rules}
	 */
	public final List<String> rules() {
		return this.rules;
	}

	/**
	 * API name: {@code rules_path}
	 */
	@Nullable
	public final String rulesPath() {
		return this.rulesPath;
	}

	protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {

		generator.write("type", "stemmer_override");
		super.serializeInternal(generator, mapper);
		if (ModelTypeHelper.isDefined(this.rules)) {
			generator.writeKey("rules");
			generator.writeStartArray();
			for (String item0 : this.rules) {
				generator.write(item0);

			}
			generator.writeEnd();

		}
		if (this.rulesPath != null) {
			generator.writeKey("rules_path");
			generator.write(this.rulesPath);

		}

	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Builder for {@link StemmerOverrideTokenFilter}.
	 */
	public static class Builder extends TokenFilterBase.AbstractBuilder<Builder>
			implements
				ObjectBuilder<StemmerOverrideTokenFilter> {
		@Nullable
		private List<String> rules;

		@Nullable
		private String rulesPath;

		/**
		 * API name: {@code rules}
		 */
		public final Builder rules(@Nullable List<String> value) {
			this.rules = value;
			return this;
		}

		/**
		 * API name: {@code rules}
		 */
		public final Builder rules(String... value) {
			this.rules = Arrays.asList(value);
			return this;
		}

		/**
		 * API name: {@code rules_path}
		 */
		public final Builder rulesPath(@Nullable String value) {
			this.rulesPath = value;
			return this;
		}

		@Override
		protected Builder self() {
			return this;
		}

		/**
		 * Builds a {@link StemmerOverrideTokenFilter}.
		 *
		 * @throws NullPointerException
		 *             if some of the required fields are null.
		 */
		public StemmerOverrideTokenFilter build() {
			_checkSingleUse();

			return new StemmerOverrideTokenFilter(this);
		}
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Json deserializer for {@link StemmerOverrideTokenFilter}
	 */
	public static final JsonpDeserializer<StemmerOverrideTokenFilter> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
			Builder::new, StemmerOverrideTokenFilter::setupStemmerOverrideTokenFilterDeserializer, Builder::build);

	protected static void setupStemmerOverrideTokenFilterDeserializer(
			DelegatingDeserializer<StemmerOverrideTokenFilter.Builder> op) {
		setupTokenFilterBaseDeserializer(op);
		op.add(Builder::rules, JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()), "rules");
		op.add(Builder::rulesPath, JsonpDeserializer.stringDeserializer(), "rules_path");

		op.ignore("type");
	}

}
