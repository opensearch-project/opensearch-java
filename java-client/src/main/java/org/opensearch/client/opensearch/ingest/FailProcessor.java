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

package org.opensearch.client.opensearch.ingest;

import jakarta.json.stream.JsonGenerator;
import org.opensearch.client.json.DelegatingDeserializer;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.ObjectBuilderDeserializer;
import org.opensearch.client.util.ObjectBuilder;

import java.util.Objects;

// typedef: ingest._types.FailProcessor
public final class FailProcessor extends ProcessorBase {
	private final String message;

	// ---------------------------------------------------------------------------------------------

	protected FailProcessor(Builder builder) {
		super(builder);
		this.message = Objects.requireNonNull(builder.message, "message");

	}

	/**
	 * API name: {@code message}
	 */
	public String message() {
		return this.message;
	}

	protected void toJsonpInternal(JsonGenerator generator, JsonpMapper mapper) {
		super.toJsonpInternal(generator, mapper);

		generator.writeKey("message");
		generator.write(this.message);

	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Builder for {@link FailProcessor}.
	 */
	public static class Builder extends ProcessorBase.AbstractBuilder<Builder> implements ObjectBuilder<FailProcessor> {
		private String message;

		/**
		 * API name: {@code message}
		 */
		public Builder message(String value) {
			this.message = value;
			return this;
		}

		@Override
		protected Builder self() {
			return this;
		}

		/**
		 * Builds a {@link FailProcessor}.
		 *
		 * @throws NullPointerException
		 *             if some of the required fields are null.
		 */
		public FailProcessor build() {

			return new FailProcessor(this);
		}
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Json deserializer for FailProcessor
	 */
	public static final JsonpDeserializer<FailProcessor> DESERIALIZER = ObjectBuilderDeserializer
			.createForObject(Builder::new, FailProcessor::setupFailProcessorDeserializer);

	protected static void setupFailProcessorDeserializer(DelegatingDeserializer<FailProcessor.Builder> op) {
		ProcessorBase.setupProcessorBaseDeserializer(op);
		op.add(Builder::message, JsonpDeserializer.stringDeserializer(), "message");

	}

}
