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

import jakarta.json.stream.JsonGenerator;
import org.opensearch.clients.json.DelegatingDeserializer;
import org.opensearch.clients.json.JsonpDeserializer;
import org.opensearch.clients.json.JsonpMapper;
import org.opensearch.clients.json.ObjectBuilderDeserializer;
import org.opensearch.clients.json.ToJsonp;
import org.opensearch.clients.util.ObjectBuilder;

import javax.annotation.Nullable;

// typedef: _types.aggregations.HdrMethod
public final class HdrMethod implements ToJsonp {
	@Nullable
	private final Number numberOfSignificantValueDigits;

	// ---------------------------------------------------------------------------------------------

	protected HdrMethod(Builder builder) {

		this.numberOfSignificantValueDigits = builder.numberOfSignificantValueDigits;

	}

	/**
	 * API name: {@code number_of_significant_value_digits}
	 */
	@Nullable
	public Number numberOfSignificantValueDigits() {
		return this.numberOfSignificantValueDigits;
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

		if (this.numberOfSignificantValueDigits != null) {

			generator.writeKey("number_of_significant_value_digits");
			generator.write(this.numberOfSignificantValueDigits.doubleValue());

		}

	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Builder for {@link HdrMethod}.
	 */
	public static class Builder implements ObjectBuilder<HdrMethod> {
		@Nullable
		private Number numberOfSignificantValueDigits;

		/**
		 * API name: {@code number_of_significant_value_digits}
		 */
		public Builder numberOfSignificantValueDigits(@Nullable Number value) {
			this.numberOfSignificantValueDigits = value;
			return this;
		}

		/**
		 * Builds a {@link HdrMethod}.
		 *
		 * @throws NullPointerException
		 *             if some of the required fields are null.
		 */
		public HdrMethod build() {

			return new HdrMethod(this);
		}
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Json deserializer for HdrMethod
	 */
	public static final JsonpDeserializer<HdrMethod> DESERIALIZER = ObjectBuilderDeserializer
			.createForObject(Builder::new, HdrMethod::setupHdrMethodDeserializer);

	protected static void setupHdrMethodDeserializer(DelegatingDeserializer<HdrMethod.Builder> op) {

		op.add(Builder::numberOfSignificantValueDigits, JsonpDeserializer.numberDeserializer(),
				"number_of_significant_value_digits");

	}

}
