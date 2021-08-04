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

package org.opensearch.clients.opensearch.cluster.stats;

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
import javax.annotation.Nullable;

// typedef: cluster.stats.FieldTypesMappings
@JsonpDeserializable
public class FieldTypesMappings implements JsonpSerializable {
	private final List<FieldTypes> fieldTypes;

	private final List<RuntimeFieldTypes> runtimeFieldTypes;

	// ---------------------------------------------------------------------------------------------

	private FieldTypesMappings(Builder builder) {

		this.fieldTypes = ModelTypeHelper.unmodifiableRequired(builder.fieldTypes, this, "fieldTypes");
		this.runtimeFieldTypes = ModelTypeHelper.unmodifiable(builder.runtimeFieldTypes);

	}

	public static FieldTypesMappings of(Function<Builder, ObjectBuilder<FieldTypesMappings>> fn) {
		return fn.apply(new Builder()).build();
	}

	/**
	 * Required - API name: {@code field_types}
	 */
	public final List<FieldTypes> fieldTypes() {
		return this.fieldTypes;
	}

	/**
	 * API name: {@code runtime_field_types}
	 */
	public final List<RuntimeFieldTypes> runtimeFieldTypes() {
		return this.runtimeFieldTypes;
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

		if (ModelTypeHelper.isDefined(this.fieldTypes)) {
			generator.writeKey("field_types");
			generator.writeStartArray();
			for (FieldTypes item0 : this.fieldTypes) {
				item0.serialize(generator, mapper);

			}
			generator.writeEnd();

		}
		if (ModelTypeHelper.isDefined(this.runtimeFieldTypes)) {
			generator.writeKey("runtime_field_types");
			generator.writeStartArray();
			for (RuntimeFieldTypes item0 : this.runtimeFieldTypes) {
				item0.serialize(generator, mapper);

			}
			generator.writeEnd();

		}

	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Builder for {@link FieldTypesMappings}.
	 */
	public static class Builder extends ObjectBuilderBase implements ObjectBuilder<FieldTypesMappings> {
		private List<FieldTypes> fieldTypes;

		@Nullable
		private List<RuntimeFieldTypes> runtimeFieldTypes;

		/**
		 * Required - API name: {@code field_types}
		 */
		public final Builder fieldTypes(List<FieldTypes> value) {
			this.fieldTypes = value;
			return this;
		}

		/**
		 * Required - API name: {@code field_types}
		 */
		public final Builder fieldTypes(FieldTypes... value) {
			this.fieldTypes = Arrays.asList(value);
			return this;
		}

		/**
		 * Required - API name: {@code field_types}
		 */
		@SafeVarargs
		public final Builder fieldTypes(Function<FieldTypes.Builder, ObjectBuilder<FieldTypes>>... fns) {
			this.fieldTypes = new ArrayList<>(fns.length);
			for (Function<FieldTypes.Builder, ObjectBuilder<FieldTypes>> fn : fns) {
				this.fieldTypes.add(fn.apply(new FieldTypes.Builder()).build());
			}
			return this;
		}

		/**
		 * API name: {@code runtime_field_types}
		 */
		public final Builder runtimeFieldTypes(@Nullable List<RuntimeFieldTypes> value) {
			this.runtimeFieldTypes = value;
			return this;
		}

		/**
		 * API name: {@code runtime_field_types}
		 */
		public final Builder runtimeFieldTypes(RuntimeFieldTypes... value) {
			this.runtimeFieldTypes = Arrays.asList(value);
			return this;
		}

		/**
		 * API name: {@code runtime_field_types}
		 */
		@SafeVarargs
		public final Builder runtimeFieldTypes(
				Function<RuntimeFieldTypes.Builder, ObjectBuilder<RuntimeFieldTypes>>... fns) {
			this.runtimeFieldTypes = new ArrayList<>(fns.length);
			for (Function<RuntimeFieldTypes.Builder, ObjectBuilder<RuntimeFieldTypes>> fn : fns) {
				this.runtimeFieldTypes.add(fn.apply(new RuntimeFieldTypes.Builder()).build());
			}
			return this;
		}

		/**
		 * Builds a {@link FieldTypesMappings}.
		 *
		 * @throws NullPointerException
		 *             if some of the required fields are null.
		 */
		public FieldTypesMappings build() {
			_checkSingleUse();

			return new FieldTypesMappings(this);
		}
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Json deserializer for {@link FieldTypesMappings}
	 */
	public static final JsonpDeserializer<FieldTypesMappings> _DESERIALIZER = ObjectBuilderDeserializer
			.lazy(Builder::new, FieldTypesMappings::setupFieldTypesMappingsDeserializer, Builder::build);

	protected static void setupFieldTypesMappingsDeserializer(DelegatingDeserializer<FieldTypesMappings.Builder> op) {

		op.add(Builder::fieldTypes, JsonpDeserializer.arrayDeserializer(FieldTypes._DESERIALIZER), "field_types");
		op.add(Builder::runtimeFieldTypes, JsonpDeserializer.arrayDeserializer(RuntimeFieldTypes._DESERIALIZER),
				"runtime_field_types");

	}

}
