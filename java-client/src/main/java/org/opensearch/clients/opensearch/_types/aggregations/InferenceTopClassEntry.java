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

package org.opensearch.clients.opensearch._types.aggregations;

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
import java.lang.Double;
import java.lang.String;
import java.util.function.Function;

// typedef: _types.aggregations.InferenceTopClassEntry
@JsonpDeserializable
public class InferenceTopClassEntry implements JsonpSerializable {
	private final String className;

	private final double classProbability;

	private final double classScore;

	// ---------------------------------------------------------------------------------------------

	private InferenceTopClassEntry(Builder builder) {

		this.className = ModelTypeHelper.requireNonNull(builder.className, this, "className");
		this.classProbability = ModelTypeHelper.requireNonNull(builder.classProbability, this, "classProbability");
		this.classScore = ModelTypeHelper.requireNonNull(builder.classScore, this, "classScore");

	}

	public static InferenceTopClassEntry of(Function<Builder, ObjectBuilder<InferenceTopClassEntry>> fn) {
		return fn.apply(new Builder()).build();
	}

	/**
	 * Required - API name: {@code class_name}
	 */
	public final String className() {
		return this.className;
	}

	/**
	 * Required - API name: {@code class_probability}
	 */
	public final double classProbability() {
		return this.classProbability;
	}

	/**
	 * Required - API name: {@code class_score}
	 */
	public final double classScore() {
		return this.classScore;
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

		generator.writeKey("class_name");
		generator.write(this.className);

		generator.writeKey("class_probability");
		generator.write(this.classProbability);

		generator.writeKey("class_score");
		generator.write(this.classScore);

	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Builder for {@link InferenceTopClassEntry}.
	 */
	public static class Builder extends ObjectBuilderBase implements ObjectBuilder<InferenceTopClassEntry> {
		private String className;

		private Double classProbability;

		private Double classScore;

		/**
		 * Required - API name: {@code class_name}
		 */
		public final Builder className(String value) {
			this.className = value;
			return this;
		}

		/**
		 * Required - API name: {@code class_probability}
		 */
		public final Builder classProbability(double value) {
			this.classProbability = value;
			return this;
		}

		/**
		 * Required - API name: {@code class_score}
		 */
		public final Builder classScore(double value) {
			this.classScore = value;
			return this;
		}

		/**
		 * Builds a {@link InferenceTopClassEntry}.
		 *
		 * @throws NullPointerException
		 *             if some of the required fields are null.
		 */
		public InferenceTopClassEntry build() {
			_checkSingleUse();

			return new InferenceTopClassEntry(this);
		}
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Json deserializer for {@link InferenceTopClassEntry}
	 */
	public static final JsonpDeserializer<InferenceTopClassEntry> _DESERIALIZER = ObjectBuilderDeserializer
			.lazy(Builder::new, InferenceTopClassEntry::setupInferenceTopClassEntryDeserializer, Builder::build);

	protected static void setupInferenceTopClassEntryDeserializer(
			DelegatingDeserializer<InferenceTopClassEntry.Builder> op) {

		op.add(Builder::className, JsonpDeserializer.stringDeserializer(), "class_name");
		op.add(Builder::classProbability, JsonpDeserializer.doubleDeserializer(), "class_probability");
		op.add(Builder::classScore, JsonpDeserializer.doubleDeserializer(), "class_score");

	}

}
