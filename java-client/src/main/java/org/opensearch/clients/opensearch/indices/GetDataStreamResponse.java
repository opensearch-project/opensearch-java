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

import org.opensearch.clients.opensearch.indices.get_data_stream.IndicesGetDataStreamItem;
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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

// typedef: indices.get_data_stream.Response
@JsonpDeserializable
public class GetDataStreamResponse implements JsonpSerializable {
	private final List<IndicesGetDataStreamItem> dataStreams;

	// ---------------------------------------------------------------------------------------------

	private GetDataStreamResponse(Builder builder) {

		this.dataStreams = ModelTypeHelper.unmodifiableRequired(builder.dataStreams, this, "dataStreams");

	}

	public static GetDataStreamResponse of(Function<Builder, ObjectBuilder<GetDataStreamResponse>> fn) {
		return fn.apply(new Builder()).build();
	}

	/**
	 * Required - API name: {@code data_streams}
	 */
	public final List<IndicesGetDataStreamItem> dataStreams() {
		return this.dataStreams;
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

		if (ModelTypeHelper.isDefined(this.dataStreams)) {
			generator.writeKey("data_streams");
			generator.writeStartArray();
			for (IndicesGetDataStreamItem item0 : this.dataStreams) {
				item0.serialize(generator, mapper);

			}
			generator.writeEnd();

		}

	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Builder for {@link GetDataStreamResponse}.
	 */
	public static class Builder extends ObjectBuilderBase implements ObjectBuilder<GetDataStreamResponse> {
		private List<IndicesGetDataStreamItem> dataStreams;

		/**
		 * Required - API name: {@code data_streams}
		 */
		public final Builder dataStreams(List<IndicesGetDataStreamItem> value) {
			this.dataStreams = value;
			return this;
		}

		/**
		 * Required - API name: {@code data_streams}
		 */
		public final Builder dataStreams(IndicesGetDataStreamItem... value) {
			this.dataStreams = Arrays.asList(value);
			return this;
		}

		/**
		 * Required - API name: {@code data_streams}
		 */
		@SafeVarargs
		public final Builder dataStreams(
				Function<IndicesGetDataStreamItem.Builder, ObjectBuilder<IndicesGetDataStreamItem>>... fns) {
			this.dataStreams = new ArrayList<>(fns.length);
			for (Function<IndicesGetDataStreamItem.Builder, ObjectBuilder<IndicesGetDataStreamItem>> fn : fns) {
				this.dataStreams.add(fn.apply(new IndicesGetDataStreamItem.Builder()).build());
			}
			return this;
		}

		/**
		 * Builds a {@link GetDataStreamResponse}.
		 *
		 * @throws NullPointerException
		 *             if some of the required fields are null.
		 */
		public GetDataStreamResponse build() {
			_checkSingleUse();

			return new GetDataStreamResponse(this);
		}
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Json deserializer for {@link GetDataStreamResponse}
	 */
	public static final JsonpDeserializer<GetDataStreamResponse> _DESERIALIZER = ObjectBuilderDeserializer
			.lazy(Builder::new, GetDataStreamResponse::setupGetDataStreamResponseDeserializer, Builder::build);

	protected static void setupGetDataStreamResponseDeserializer(
			DelegatingDeserializer<GetDataStreamResponse.Builder> op) {

		op.add(Builder::dataStreams, JsonpDeserializer.arrayDeserializer(IndicesGetDataStreamItem._DESERIALIZER),
				"data_streams");

	}

}
