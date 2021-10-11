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

package org.opensearch.client.opensearch.nodes;

import jakarta.json.stream.JsonGenerator;
import org.opensearch.client.json.DelegatingDeserializer;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.ObjectBuilderDeserializer;
import org.opensearch.client.json.ToJsonp;
import org.opensearch.client.util.ObjectBuilder;

import java.util.Objects;
import java.util.function.Function;

// typedef: nodes._types.KeyedProcessor
public final class KeyedProcessor implements ToJsonp {
	private final Process statistics;

	private final String type;

	// ---------------------------------------------------------------------------------------------

	protected KeyedProcessor(Builder builder) {

		this.statistics = Objects.requireNonNull(builder.statistics, "statistics");
		this.type = Objects.requireNonNull(builder.type, "type");

	}

	/**
	 * API name: {@code statistics}
	 */
	public Process statistics() {
		return this.statistics;
	}

	/**
	 * API name: {@code type}
	 */
	public String type() {
		return this.type;
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

		generator.writeKey("statistics");
		this.statistics.toJsonp(generator, mapper);

		generator.writeKey("type");
		generator.write(this.type);

	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Builder for {@link KeyedProcessor}.
	 */
	public static class Builder implements ObjectBuilder<KeyedProcessor> {
		private Process statistics;

		private String type;

		/**
		 * API name: {@code statistics}
		 */
		public Builder statistics(Process value) {
			this.statistics = value;
			return this;
		}

		/**
		 * API name: {@code statistics}
		 */
		public Builder statistics(Function<Process.Builder, ObjectBuilder<Process>> fn) {
			return this.statistics(fn.apply(new Process.Builder()).build());
		}

		/**
		 * API name: {@code type}
		 */
		public Builder type(String value) {
			this.type = value;
			return this;
		}

		/**
		 * Builds a {@link KeyedProcessor}.
		 *
		 * @throws NullPointerException
		 *             if some of the required fields are null.
		 */
		public KeyedProcessor build() {

			return new KeyedProcessor(this);
		}
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Json deserializer for KeyedProcessor
	 */
	public static final JsonpDeserializer<KeyedProcessor> DESERIALIZER = ObjectBuilderDeserializer
			.createForObject(Builder::new, KeyedProcessor::setupKeyedProcessorDeserializer);

	protected static void setupKeyedProcessorDeserializer(DelegatingDeserializer<KeyedProcessor.Builder> op) {

		op.add(Builder::statistics, Process.DESERIALIZER, "statistics");
		op.add(Builder::type, JsonpDeserializer.stringDeserializer(), "type");

	}

}
