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

package org.opensearch.client.opensearch._types.analysis;

import java.util.function.Function;

import org.opensearch.client.json.JsonpDeserializable;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.ObjectBuilderDeserializer;
import org.opensearch.client.json.ObjectDeserializer;
import org.opensearch.client.util.ObjectBuilder;

import jakarta.json.stream.JsonGenerator;

// typedef: _types.analysis.IcuTokenizer

@JsonpDeserializable
public class SmartcnTokenizer extends TokenizerBase implements TokenizerDefinitionVariant {
	// ---------------------------------------------------------------------------------------------

	private SmartcnTokenizer(Builder builder) {
		super(builder);

	}

	public static SmartcnTokenizer of(Function<Builder, ObjectBuilder<SmartcnTokenizer>> fn) {
		return fn.apply(new Builder()).build();
	}

	/**
	 * TokenizerDefinition variant kind.
	 */
	@Override
	public TokenizerDefinition.Kind _tokenizerDefinitionKind() {
		return TokenizerDefinition.Kind.SmartcnTokenizer;
	}

	protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {

		generator.write("type", TokenizerDefinition.Kind.SmartcnTokenizer.jsonValue());
		super.serializeInternal(generator, mapper);

	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Builder for {@link SmartcnTokenizer}.
	 */

	public static class Builder extends AbstractBuilder<Builder> implements ObjectBuilder<SmartcnTokenizer> {

		@Override
		protected Builder self() {
			return this;
		}

		/**
		 * Builds a {@link SmartcnTokenizer}.
		 *
		 * @throws NullPointerException
		 *             if some required fields are null.
		 */
		public SmartcnTokenizer build() {
			_checkSingleUse();

			return new SmartcnTokenizer(this);
		}
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Json deserializer for {@link SmartcnTokenizer}
	 */
	public static final JsonpDeserializer<SmartcnTokenizer> _DESERIALIZER = ObjectBuilderDeserializer.lazy(Builder::new,
			SmartcnTokenizer::setupSmartcnTokenizerDeserializer);

	protected static void setupSmartcnTokenizerDeserializer(ObjectDeserializer<SmartcnTokenizer.Builder> op) {
		TokenizerBase.setupTokenizerBaseDeserializer(op);

		op.ignore("type");
	}

}
