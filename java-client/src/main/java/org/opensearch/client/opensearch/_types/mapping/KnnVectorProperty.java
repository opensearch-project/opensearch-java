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

package org.opensearch.client.opensearch._types.mapping;

import java.util.function.Function;

import javax.annotation.Nullable;

import org.opensearch.client.json.JsonpDeserializable;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.ObjectBuilderDeserializer;
import org.opensearch.client.json.ObjectDeserializer;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.ObjectBuilder;

import jakarta.json.stream.JsonGenerator;

// typedef: _types.mapping.KnnVectorProperty

@JsonpDeserializable
public class KnnVectorProperty extends PropertyBase implements PropertyVariant {
	/**
	 * Builder for {@link KnnVectorProperty}.
	 */

	public static class Builder extends PropertyBase.AbstractBuilder<Builder>
			implements
			ObjectBuilder<KnnVectorProperty> {
		private Integer dimension;

		@Nullable
		private String modelId;

		@Nullable
		private KnnVectorMethod method;

		/**
		 * Required - API name: {@code dimension}
		 */
		public final Builder dimension(int value) {
			this.dimension = value;
			return this;
		}

		/**
		 * API name: {@code model_id}
		 */
		public final Builder modelId(@Nullable String value) {
			this.modelId = value;
			return this;
		}

		/**
		 * API name: {@code method}
		 */
		public final Builder method(@Nullable KnnVectorMethod value) {
			this.method = value;
			return this;
		}

		/**
		 * Builds a {@link KnnVectorProperty}.
		 *
		 * @throws NullPointerException
		 *                              if some of the required fields are null.
		 */
		public KnnVectorProperty build() {
			_checkSingleUse();

			return new KnnVectorProperty(this);
		}

		@Override
		protected Builder self() {
			return this;
		}
	}

	/**
	 * Json deserializer for {@link KnnVectorProperty}
	 */
	public static final JsonpDeserializer<KnnVectorProperty> _DESERIALIZER = ObjectBuilderDeserializer
			.lazy(Builder::new, KnnVectorProperty::setupKnnVectorPropertyDeserializer);

	public static KnnVectorProperty of(Function<Builder, ObjectBuilder<KnnVectorProperty>> fn) {
		return fn.apply(new Builder()).build();
	}

	// ---------------------------------------------------------------------------------------------

	protected static void setupKnnVectorPropertyDeserializer(ObjectDeserializer<KnnVectorProperty.Builder> op) {
		PropertyBase.setupPropertyBaseDeserializer(op);
		op.add(Builder::dimension, JsonpDeserializer.integerDeserializer(), "dimension");
		op.add(Builder::modelId, JsonpDeserializer.stringDeserializer(), "model_id");
		op.add(Builder::method, KnnVectorMethod._DESERIALIZER, "method");

		op.ignore("type");
	}

	private final int dimension;

	@Nullable
	private final String modelId;

	@Nullable
	private final KnnVectorMethod method;

	private KnnVectorProperty(Builder builder) {
		super(builder);

		this.dimension = ApiTypeHelper.requireNonNull(builder.dimension, this, "dimension");
		this.modelId = builder.modelId;
		this.method = builder.method;

	}

	/**
	 * Property variant kind.
	 */
	@Override
	public Property.Kind _propertyKind() {
		return Property.Kind.KnnVector;
	}

	/**
	 * Required - API name: {@code dimension}
	 */
	public final int dimension() {
		return this.dimension;
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * API name: {@code model_id}
	 */
	@Nullable
	public final String modelId() {
		return this.modelId;
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * API name: {@code method}
	 */
	@Nullable
	public final KnnVectorMethod method() {
		return this.method;
	}

	@Override
	protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {

		generator.write("type", "knn_vector");
		super.serializeInternal(generator, mapper);
		generator.writeKey("dimension");
		generator.write(this.dimension);

		if (this.modelId != null) {

			generator.writeKey("model_id");
			generator.write(this.modelId);

		}

		if (this.method != null) {

			generator.writeKey("method");
			this.method.serialize(generator, mapper);
		}

	}

}
