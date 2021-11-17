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

package org.opensearch.clients.opensearch.indices;

import org.opensearch.clients.json.DelegatingDeserializer;
import org.opensearch.clients.json.JsonpDeserializable;
import org.opensearch.clients.json.JsonpDeserializer;
import org.opensearch.clients.json.JsonpMapper;
import org.opensearch.clients.json.JsonpSerializable;
import org.opensearch.clients.json.ObjectBuilderDeserializer;
import org.opensearch.clients.util.ModelTypeHelper;
import org.opensearch.clients.util.ObjectBuilder;
import org.opensearch.clients.util.ObjectBuilderBase;
import jakarta.json.stream.JsonGenerator;

import java.util.function.Function;

// typedef: indices._types.NumericFielddata
@JsonpDeserializable
public class NumericFielddata implements JsonpSerializable {
	private final NumericFielddataFormat format;

	// ---------------------------------------------------------------------------------------------

	private NumericFielddata(Builder builder) {

		this.format = ModelTypeHelper.requireNonNull(builder.format, this, "format");

	}

	public static NumericFielddata of(Function<Builder, ObjectBuilder<NumericFielddata>> fn) {
		return fn.apply(new Builder()).build();
	}

	/**
	 * Required - API name: {@code format}
	 */
	public final NumericFielddataFormat format() {
		return this.format;
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

		generator.writeKey("format");
		this.format.serialize(generator, mapper);

	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Builder for {@link NumericFielddata}.
	 */
	public static class Builder extends ObjectBuilderBase implements ObjectBuilder<NumericFielddata> {
		private NumericFielddataFormat format;

		/**
		 * Required - API name: {@code format}
		 */
		public final Builder format(NumericFielddataFormat value) {
			this.format = value;
			return this;
		}

		/**
		 * Builds a {@link NumericFielddata}.
		 *
		 * @throws NullPointerException
		 *             if some of the required fields are null.
		 */
		public NumericFielddata build() {
			_checkSingleUse();

			return new NumericFielddata(this);
		}
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Json deserializer for {@link NumericFielddata}
	 */
	public static final JsonpDeserializer<NumericFielddata> _DESERIALIZER = ObjectBuilderDeserializer.lazy(Builder::new,
			NumericFielddata::setupNumericFielddataDeserializer, Builder::build);

	protected static void setupNumericFielddataDeserializer(DelegatingDeserializer<NumericFielddata.Builder> op) {

		op.add(Builder::format, NumericFielddataFormat._DESERIALIZER, "format");

	}

}
