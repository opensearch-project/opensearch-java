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

package org.opensearch.client.opensearch._types;

import jakarta.json.stream.JsonGenerator;
import org.opensearch.client.json.DelegatingDeserializer;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.ObjectBuilderDeserializer;
import org.opensearch.client.json.ToJsonp;
import org.opensearch.client.util.ObjectBuilder;

import java.util.Objects;

// typedef: _types.LatLon
public final class LatLon implements ToJsonp {
	private final Number lat;

	private final Number lon;

	// ---------------------------------------------------------------------------------------------

	protected LatLon(Builder builder) {

		this.lat = Objects.requireNonNull(builder.lat, "lat");
		this.lon = Objects.requireNonNull(builder.lon, "lon");

	}

	/**
	 * API name: {@code lat}
	 */
	public Number lat() {
		return this.lat;
	}

	/**
	 * API name: {@code lon}
	 */
	public Number lon() {
		return this.lon;
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

		generator.writeKey("lat");
		generator.write(this.lat.doubleValue());

		generator.writeKey("lon");
		generator.write(this.lon.doubleValue());

	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Builder for {@link LatLon}.
	 */
	public static class Builder implements ObjectBuilder<LatLon> {
		private Number lat;

		private Number lon;

		/**
		 * API name: {@code lat}
		 */
		public Builder lat(Number value) {
			this.lat = value;
			return this;
		}

		/**
		 * API name: {@code lon}
		 */
		public Builder lon(Number value) {
			this.lon = value;
			return this;
		}

		/**
		 * Builds a {@link LatLon}.
		 *
		 * @throws NullPointerException
		 *             if some of the required fields are null.
		 */
		public LatLon build() {

			return new LatLon(this);
		}
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Json deserializer for LatLon
	 */
	public static final JsonpDeserializer<LatLon> DESERIALIZER = ObjectBuilderDeserializer.createForObject(Builder::new,
			LatLon::setupLatLonDeserializer);

	protected static void setupLatLonDeserializer(DelegatingDeserializer<LatLon.Builder> op) {

		op.add(Builder::lat, JsonpDeserializer.numberDeserializer(), "lat");
		op.add(Builder::lon, JsonpDeserializer.numberDeserializer(), "lon");

	}

}
