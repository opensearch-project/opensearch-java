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

import org.opensearch.clients.opensearch._types.LatLon;
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

// typedef: _types.aggregations.GeoBounds
@JsonpDeserializable
public class GeoBounds implements JsonpSerializable {
	private final LatLon bottomRight;

	private final LatLon topLeft;

	// ---------------------------------------------------------------------------------------------

	private GeoBounds(Builder builder) {

		this.bottomRight = ModelTypeHelper.requireNonNull(builder.bottomRight, this, "bottomRight");
		this.topLeft = ModelTypeHelper.requireNonNull(builder.topLeft, this, "topLeft");

	}

	public static GeoBounds of(Function<Builder, ObjectBuilder<GeoBounds>> fn) {
		return fn.apply(new Builder()).build();
	}

	/**
	 * Required - API name: {@code bottom_right}
	 */
	public final LatLon bottomRight() {
		return this.bottomRight;
	}

	/**
	 * Required - API name: {@code top_left}
	 */
	public final LatLon topLeft() {
		return this.topLeft;
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

		generator.writeKey("bottom_right");
		this.bottomRight.serialize(generator, mapper);

		generator.writeKey("top_left");
		this.topLeft.serialize(generator, mapper);

	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Builder for {@link GeoBounds}.
	 */
	public static class Builder extends ObjectBuilderBase implements ObjectBuilder<GeoBounds> {
		private LatLon bottomRight;

		private LatLon topLeft;

		/**
		 * Required - API name: {@code bottom_right}
		 */
		public final Builder bottomRight(LatLon value) {
			this.bottomRight = value;
			return this;
		}

		/**
		 * Required - API name: {@code bottom_right}
		 */
		public final Builder bottomRight(Function<LatLon.Builder, ObjectBuilder<LatLon>> fn) {
			return this.bottomRight(fn.apply(new LatLon.Builder()).build());
		}

		/**
		 * Required - API name: {@code top_left}
		 */
		public final Builder topLeft(LatLon value) {
			this.topLeft = value;
			return this;
		}

		/**
		 * Required - API name: {@code top_left}
		 */
		public final Builder topLeft(Function<LatLon.Builder, ObjectBuilder<LatLon>> fn) {
			return this.topLeft(fn.apply(new LatLon.Builder()).build());
		}

		/**
		 * Builds a {@link GeoBounds}.
		 *
		 * @throws NullPointerException
		 *             if some of the required fields are null.
		 */
		public GeoBounds build() {
			_checkSingleUse();

			return new GeoBounds(this);
		}
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Json deserializer for {@link GeoBounds}
	 */
	public static final JsonpDeserializer<GeoBounds> _DESERIALIZER = ObjectBuilderDeserializer.lazy(Builder::new,
			GeoBounds::setupGeoBoundsDeserializer, Builder::build);

	protected static void setupGeoBoundsDeserializer(DelegatingDeserializer<GeoBounds.Builder> op) {

		op.add(Builder::bottomRight, LatLon._DESERIALIZER, "bottom_right");
		op.add(Builder::topLeft, LatLon._DESERIALIZER, "top_left");

	}

}
