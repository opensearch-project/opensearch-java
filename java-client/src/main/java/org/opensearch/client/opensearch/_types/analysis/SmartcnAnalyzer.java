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
import org.opensearch.client.json.JsonpSerializable;
import org.opensearch.client.json.ObjectBuilderDeserializer;
import org.opensearch.client.json.ObjectDeserializer;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;

import jakarta.json.stream.JsonGenerator;

// typedef: _types.analysis.LanguageAnalyzer

@JsonpDeserializable
public class SmartcnAnalyzer implements AnalyzerVariant, JsonpSerializable {

	// ---------------------------------------------------------------------------------------------

	private SmartcnAnalyzer(Builder builder) {

	}

	public static SmartcnAnalyzer of(Function<Builder, ObjectBuilder<SmartcnAnalyzer>> fn) {
		return fn.apply(new Builder()).build();
	}

	/**
	 * Analyzer variant kind.
	 */
	@Override
	public Analyzer.Kind _analyzerKind() {
		return Analyzer.Kind.Smartcn;
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

		generator.write("type", Analyzer.Kind.Smartcn.jsonValue());

	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Builder for {@link SmartcnAnalyzer}.
	 */

	public static class Builder extends ObjectBuilderBase implements ObjectBuilder<SmartcnAnalyzer> {

		/**
		 * Builds a {@link SmartcnAnalyzer}.
		 *
		 * @throws NullPointerException
		 *             if some required fields are null.
		 */
		public SmartcnAnalyzer build() {
			_checkSingleUse();

			return new SmartcnAnalyzer(this);
		}
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Json deserializer for {@link SmartcnAnalyzer}
	 */
	public static final JsonpDeserializer<SmartcnAnalyzer> _DESERIALIZER = ObjectBuilderDeserializer.lazy(Builder::new,
			SmartcnAnalyzer::setupLanguageAnalyzerDeserializer);

	protected static void setupLanguageAnalyzerDeserializer(ObjectDeserializer<SmartcnAnalyzer.Builder> op) {

		op.ignore("type");
	}

}
