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

package org.opensearch.clients.elasticsearch._types.analysis;

import org.opensearch.clients.json.DelegatingDeserializer;
import org.opensearch.clients.json.JsonpDeserializable;
import org.opensearch.clients.json.JsonpDeserializer;
import org.opensearch.clients.json.JsonpMapper;
import org.opensearch.clients.json.ObjectBuilderDeserializer;
import org.opensearch.clients.util.ModelTypeHelper;
import org.opensearch.clients.util.ObjectBuilder;
import jakarta.json.stream.JsonGenerator;

import java.util.function.Function;

// typedef: _types.analysis.IcuNormalizationTokenFilter
@JsonpDeserializable
public class IcuNormalizationTokenFilter extends TokenFilterBase implements TokenFilterVariant {
	private final IcuNormalizationType name;

	// ---------------------------------------------------------------------------------------------

	private IcuNormalizationTokenFilter(Builder builder) {
		super(builder);

		this.name = ModelTypeHelper.requireNonNull(builder.name, this, "name");

	}

	public static IcuNormalizationTokenFilter of(Function<Builder, ObjectBuilder<IcuNormalizationTokenFilter>> fn) {
		return fn.apply(new Builder()).build();
	}

	/**
	 * {@link TokenFilter} variant type
	 */
	@Override
	public String _variantType() {
		return "icu_normalizer";
	}

	/**
	 * Required - API name: {@code name}
	 */
	public final IcuNormalizationType name() {
		return this.name;
	}

	protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {

		generator.write("type", "icu_normalizer");
		super.serializeInternal(generator, mapper);
		generator.writeKey("name");
		this.name.serialize(generator, mapper);

	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Builder for {@link IcuNormalizationTokenFilter}.
	 */
	public static class Builder extends TokenFilterBase.AbstractBuilder<Builder>
			implements
				ObjectBuilder<IcuNormalizationTokenFilter> {
		private IcuNormalizationType name;

		/**
		 * Required - API name: {@code name}
		 */
		public final Builder name(IcuNormalizationType value) {
			this.name = value;
			return this;
		}

		@Override
		protected Builder self() {
			return this;
		}

		/**
		 * Builds a {@link IcuNormalizationTokenFilter}.
		 *
		 * @throws NullPointerException
		 *             if some of the required fields are null.
		 */
		public IcuNormalizationTokenFilter build() {
			_checkSingleUse();

			return new IcuNormalizationTokenFilter(this);
		}
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Json deserializer for {@link IcuNormalizationTokenFilter}
	 */
	public static final JsonpDeserializer<IcuNormalizationTokenFilter> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
			Builder::new, IcuNormalizationTokenFilter::setupIcuNormalizationTokenFilterDeserializer, Builder::build);

	protected static void setupIcuNormalizationTokenFilterDeserializer(
			DelegatingDeserializer<IcuNormalizationTokenFilter.Builder> op) {
		setupTokenFilterBaseDeserializer(op);
		op.add(Builder::name, IcuNormalizationType._DESERIALIZER, "name");

		op.ignore("type");
	}

}
