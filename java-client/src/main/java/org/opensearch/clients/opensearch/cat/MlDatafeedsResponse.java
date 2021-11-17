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

package org.opensearch.clients.opensearch.cat;

import org.opensearch.clients.opensearch.cat.ml_datafeeds.DatafeedsRecord;
import org.opensearch.clients.json.JsonpDeserializable;
import org.opensearch.clients.json.JsonpDeserializer;
import org.opensearch.clients.json.JsonpMapper;
import org.opensearch.clients.json.JsonpSerializable;
import org.opensearch.clients.util.ModelTypeHelper;
import org.opensearch.clients.util.ObjectBuilder;
import org.opensearch.clients.util.ObjectBuilderBase;
import jakarta.json.stream.JsonGenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

// typedef: cat.ml_datafeeds.Response
@JsonpDeserializable
public class MlDatafeedsResponse implements JsonpSerializable {
	private final List<DatafeedsRecord> valueBody;

	// ---------------------------------------------------------------------------------------------

	private MlDatafeedsResponse(Builder builder) {

		this.valueBody = ModelTypeHelper.unmodifiableRequired(builder.valueBody, this, "valueBody");

	}

	public static MlDatafeedsResponse of(Function<Builder, ObjectBuilder<MlDatafeedsResponse>> fn) {
		return fn.apply(new Builder()).build();
	}

	/**
	 * Required - Response value.
	 * <p>
	 * API name: {@code _value_body}
	 */
	public final List<DatafeedsRecord> valueBody() {
		return this.valueBody;
	}

	/**
	 * Serialize this value to JSON.
	 */
	public void serialize(JsonGenerator generator, JsonpMapper mapper) {
		generator.writeStartArray();
		for (DatafeedsRecord item0 : this.valueBody) {
			item0.serialize(generator, mapper);

		}
		generator.writeEnd();

	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Builder for {@link MlDatafeedsResponse}.
	 */
	public static class Builder extends ObjectBuilderBase implements ObjectBuilder<MlDatafeedsResponse> {
		private List<DatafeedsRecord> valueBody;

		/**
		 * Required - Response value.
		 * <p>
		 * API name: {@code _value_body}
		 */
		public final Builder valueBody(List<DatafeedsRecord> value) {
			this.valueBody = value;
			return this;
		}

		/**
		 * Required - Response value.
		 * <p>
		 * API name: {@code _value_body}
		 */
		public final Builder valueBody(DatafeedsRecord... value) {
			this.valueBody = Arrays.asList(value);
			return this;
		}

		/**
		 * Required - Response value.
		 * <p>
		 * API name: {@code _value_body}
		 */
		@SafeVarargs
		public final Builder valueBody(Function<DatafeedsRecord.Builder, ObjectBuilder<DatafeedsRecord>>... fns) {
			this.valueBody = new ArrayList<>(fns.length);
			for (Function<DatafeedsRecord.Builder, ObjectBuilder<DatafeedsRecord>> fn : fns) {
				this.valueBody.add(fn.apply(new DatafeedsRecord.Builder()).build());
			}
			return this;
		}

		/**
		 * Builds a {@link MlDatafeedsResponse}.
		 *
		 * @throws NullPointerException
		 *             if some of the required fields are null.
		 */
		public MlDatafeedsResponse build() {
			_checkSingleUse();

			return new MlDatafeedsResponse(this);
		}
	}

	public static final JsonpDeserializer<MlDatafeedsResponse> _DESERIALIZER = createMlDatafeedsResponseDeserializer();
	protected static JsonpDeserializer<MlDatafeedsResponse> createMlDatafeedsResponseDeserializer() {

		JsonpDeserializer<List<DatafeedsRecord>> valueDeserializer = JsonpDeserializer
				.arrayDeserializer(DatafeedsRecord._DESERIALIZER);

		return JsonpDeserializer.of(valueDeserializer.acceptedEvents(), (parser, mapper, event) -> new Builder()
				.valueBody(valueDeserializer.deserialize(parser, mapper, event)).build());
	}

}
