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

package org.opensearch.clients.opensearch._types;

import org.opensearch.clients.json.JsonpDeserializable;
import org.opensearch.clients.json.JsonpDeserializer;
import org.opensearch.clients.json.JsonpMapper;
import org.opensearch.clients.json.JsonpSerializable;
import org.opensearch.clients.json.ObjectBuilderDeserializer;
import org.opensearch.clients.json.ObjectDeserializer;
import org.opensearch.clients.util.ApiTypeHelper;
import org.opensearch.clients.util.ObjectBuilder;
import org.opensearch.clients.util.ObjectBuilderBase;
import jakarta.json.stream.JsonGenerator;
import java.lang.Integer;
import java.lang.String;
import java.util.function.Function;
import javax.annotation.Nullable;

// typedef: _types.SlicedScroll

/**
 *
 * @see <a href=
 *      "https://github.com/elastic/elasticsearch-specification/tree/98036c3/specification/_types/SlicedScroll.ts#L23-L27">API
 *      specification</a>
 */
@JsonpDeserializable
public class SlicedScroll implements JsonpSerializable {
	@Nullable
	private final String field;

	private final int id;

	private final int max;

	// ---------------------------------------------------------------------------------------------

	private SlicedScroll(Builder builder) {

		this.field = builder.field;
		this.id = ApiTypeHelper.requireNonNull(builder.id, this, "id");
		this.max = ApiTypeHelper.requireNonNull(builder.max, this, "max");

	}

	public static SlicedScroll of(Function<Builder, ObjectBuilder<SlicedScroll>> fn) {
		return fn.apply(new Builder()).build();
	}

	/**
	 * API name: {@code field}
	 */
	@Nullable
	public final String field() {
		return this.field;
	}

	/**
	 * Required - API name: {@code id}
	 */
	public final int id() {
		return this.id;
	}

	/**
	 * Required - API name: {@code max}
	 */
	public final int max() {
		return this.max;
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

		if (this.field != null) {
			generator.writeKey("field");
			generator.write(this.field);

		}
		generator.writeKey("id");
		generator.write(this.id);

		generator.writeKey("max");
		generator.write(this.max);

	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Builder for {@link SlicedScroll}.
	 */

	public static class Builder extends ObjectBuilderBase implements ObjectBuilder<SlicedScroll> {
		@Nullable
		private String field;

		private Integer id;

		private Integer max;

		/**
		 * API name: {@code field}
		 */
		public final Builder field(@Nullable String value) {
			this.field = value;
			return this;
		}

		/**
		 * Required - API name: {@code id}
		 */
		public final Builder id(int value) {
			this.id = value;
			return this;
		}

		/**
		 * Required - API name: {@code max}
		 */
		public final Builder max(int value) {
			this.max = value;
			return this;
		}

		/**
		 * Builds a {@link SlicedScroll}.
		 *
		 * @throws NullPointerException
		 *             if some of the required fields are null.
		 */
		public SlicedScroll build() {
			_checkSingleUse();

			return new SlicedScroll(this);
		}
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Json deserializer for {@link SlicedScroll}
	 */
	public static final JsonpDeserializer<SlicedScroll> _DESERIALIZER = ObjectBuilderDeserializer.lazy(Builder::new,
			SlicedScroll::setupSlicedScrollDeserializer);

	protected static void setupSlicedScrollDeserializer(ObjectDeserializer<SlicedScroll.Builder> op) {

		op.add(Builder::field, JsonpDeserializer.stringDeserializer(), "field");
		op.add(Builder::id, JsonpDeserializer.integerDeserializer(), "id");
		op.add(Builder::max, JsonpDeserializer.integerDeserializer(), "max");

	}

}
