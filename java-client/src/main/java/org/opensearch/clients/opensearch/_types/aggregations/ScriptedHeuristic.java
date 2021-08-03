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

package org.opensearch.clients.opensearch._types.aggregations;

import jakarta.json.JsonValue;
import jakarta.json.stream.JsonGenerator;
import org.opensearch.clients.json.DelegatingDeserializer;
import org.opensearch.clients.json.JsonpDeserializer;
import org.opensearch.clients.json.JsonpMapper;
import org.opensearch.clients.json.ObjectBuilderDeserializer;
import org.opensearch.clients.json.ToJsonp;
import org.opensearch.clients.util.ObjectBuilder;

import java.util.Objects;

// typedef: _types.aggregations.ScriptedHeuristic
public final class ScriptedHeuristic implements ToJsonp {
	private final JsonValue script;

	// ---------------------------------------------------------------------------------------------

	protected ScriptedHeuristic(Builder builder) {

		this.script = Objects.requireNonNull(builder.script, "script");

	}

	/**
	 * API name: {@code script}
	 */
	public JsonValue script() {
		return this.script;
	}

	/**
	 * Serialize this object to JSON.
	 */
	public void toJsonp(JsonGenerator generator, JsonpMapper mapper) {
		generator.writeStartObject();
		toJsonpInternal(generator, mapper);
		generator.writeEnd();
	}

	protected void toJsonpInternal(JsonGenerator generator, JsonpMapper mapper) {

		generator.writeKey("script");
		generator.write(this.script);

	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Builder for {@link ScriptedHeuristic}.
	 */
	public static class Builder implements ObjectBuilder<ScriptedHeuristic> {
		private JsonValue script;

		/**
		 * API name: {@code script}
		 */
		public Builder script(JsonValue value) {
			this.script = value;
			return this;
		}

		/**
		 * Builds a {@link ScriptedHeuristic}.
		 *
		 * @throws NullPointerException
		 *             if some of the required fields are null.
		 */
		public ScriptedHeuristic build() {

			return new ScriptedHeuristic(this);
		}
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Json deserializer for ScriptedHeuristic
	 */
	public static final JsonpDeserializer<ScriptedHeuristic> DESERIALIZER = ObjectBuilderDeserializer
			.createForObject(Builder::new, ScriptedHeuristic::setupScriptedHeuristicDeserializer);

	protected static void setupScriptedHeuristicDeserializer(DelegatingDeserializer<ScriptedHeuristic.Builder> op) {

		op.add(Builder::script, JsonpDeserializer.jsonValueDeserializer(), "script");

	}

}
