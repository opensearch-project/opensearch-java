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
import org.opensearch.client.json.JsonData;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.JsonpSerializable;
import org.opensearch.client.util.ModelTypeHelper;
import org.opensearch.client.util.ObjectBuilderBase;
import jakarta.json.stream.JsonGenerator;
import java.lang.String;
import java.util.Map;
import javax.annotation.Nullable;

// typedef: _types.ScriptBase

public abstract class ScriptBase implements JsonpSerializable {
	@Nullable
	private final ScriptLanguage lang;

	private final Map<String, JsonData> params;

	// ---------------------------------------------------------------------------------------------

	protected ScriptBase(AbstractBuilder<?> builder) {

		this.lang = builder.lang;
		this.params = ModelTypeHelper.unmodifiable(builder.params);

	}

	/**
	 * API name: {@code lang}
	 */
	@Nullable
	public final ScriptLanguage lang() {
		return this.lang;
	}

	/**
	 * API name: {@code params}
	 */
	public final Map<String, JsonData> params() {
		return this.params;
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
		if (ModelTypeHelper.isDefined(this.params)) {
			generator.writeKey("params");
			generator.writeStartObject();
			for (Map.Entry<String, JsonData> item0 : this.params.entrySet()) {
				generator.writeKey(item0.getKey());
				item0.getValue().serialize(generator, mapper);

			}
			generator.writeEnd();

		}

	}

	protected abstract static class AbstractBuilder<BuilderT extends AbstractBuilder<BuilderT>>
			extends
				ObjectBuilderBase {
		@Nullable
		private ScriptLanguage lang;

		@Nullable
		private Map<String, JsonData> params;

		/**
		 * API name: {@code lang}
		 */
		public final BuilderT lang(@Nullable ScriptLanguage value) {
			this.lang = value;
			return self();
		}

		/**
		 * API name: {@code params}
		 */
		public final BuilderT params(@Nullable Map<String, JsonData> value) {
			this.params = value;
			return self();
		}

		protected abstract BuilderT self();

	}

	// ---------------------------------------------------------------------------------------------
	protected static <BuilderT extends AbstractBuilder<BuilderT>> void setupScriptBaseDeserializer(
			DelegatingDeserializer<BuilderT> op) {

		op.add(AbstractBuilder::lang, ScriptLanguage._DESERIALIZER, "lang");
		op.add(AbstractBuilder::params, JsonpDeserializer.stringMapDeserializer(JsonData._DESERIALIZER), "params");

	}

}
