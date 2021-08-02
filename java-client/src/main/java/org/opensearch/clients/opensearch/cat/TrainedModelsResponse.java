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

import jakarta.json.stream.JsonGenerator;
import org.opensearch.clients.opensearch.cat.trained_models.TrainedModelsRecord;
import org.opensearch.clients.json.DelegatingDeserializer;
import org.opensearch.clients.json.JsonpDeserializer;
import org.opensearch.clients.json.JsonpMapper;
import org.opensearch.clients.json.ObjectBuilderDeserializer;
import org.opensearch.clients.json.ToJsonp;
import org.opensearch.clients.util.ObjectBuilder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;

// typedef: cat.trained_models.Response
public final class TrainedModelsResponse implements ToJsonp {
	private final List<TrainedModelsRecord> value;

	// ---------------------------------------------------------------------------------------------

	protected TrainedModelsResponse(Builder builder) {

		this.value = Objects.requireNonNull(builder.value, "value");

	}

	/**
	 * Response value.
	 *
	 * API name: {@code value}
	 */
	public List<TrainedModelsRecord> value() {
		return this.value;
	}

	/**
	 * Serialize this value to JSON.
	 */
	public void toJsonp(JsonGenerator generator, JsonpMapper mapper) {
		generator.writeStartArray();
		for (TrainedModelsRecord item0 : this.value) {
			item0.toJsonp(generator, mapper);

		}
		generator.writeEnd();

	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Builder for {@link TrainedModelsResponse}.
	 */
	public static class Builder implements ObjectBuilder<TrainedModelsResponse> {
		private List<TrainedModelsRecord> value;

		/**
		 * Response value.
		 *
		 * API name: {@code value}
		 */
		public Builder value(List<TrainedModelsRecord> value) {
			this.value = value;
			return this;
		}

		/**
		 * Response value.
		 *
		 * API name: {@code value}
		 */
		public Builder value(TrainedModelsRecord... value) {
			this.value = Arrays.asList(value);
			return this;
		}

		/**
		 * Add a value to {@link #value(List)}, creating the list if needed.
		 */
		public Builder addValue(TrainedModelsRecord value) {
			if (this.value == null) {
				this.value = new ArrayList<>();
			}
			this.value.add(value);
			return this;
		}

		/**
		 * Set {@link #value(List)} to a singleton list.
		 */
		public Builder value(Function<TrainedModelsRecord.Builder, ObjectBuilder<TrainedModelsRecord>> fn) {
			return this.value(fn.apply(new TrainedModelsRecord.Builder()).build());
		}

		/**
		 * Add a value to {@link #value(List)}, creating the list if needed.
		 */
		public Builder addValue(Function<TrainedModelsRecord.Builder, ObjectBuilder<TrainedModelsRecord>> fn) {
			return this.addValue(fn.apply(new TrainedModelsRecord.Builder()).build());
		}

		/**
		 * Builds a {@link TrainedModelsResponse}.
		 *
		 * @throws NullPointerException
		 *             if some of the required fields are null.
		 */
		public TrainedModelsResponse build() {

			return new TrainedModelsResponse(this);
		}
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Json deserializer for TrainedModelsResponse
	 */
	public static final JsonpDeserializer<TrainedModelsResponse> DESERIALIZER = ObjectBuilderDeserializer
			.createForObject(Builder::new, TrainedModelsResponse::setupTrainedModelsResponseDeserializer);

	protected static void setupTrainedModelsResponseDeserializer(
			DelegatingDeserializer<TrainedModelsResponse.Builder> op) {

		op.add(Builder::value, JsonpDeserializer.arrayDeserializer(TrainedModelsRecord.DESERIALIZER), "value");

	}

}
