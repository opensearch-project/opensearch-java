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

package org.opensearch.clients.elasticsearch.cluster.stats;

import jakarta.json.stream.JsonGenerator;
import org.opensearch.clients.json.DelegatingDeserializer;
import org.opensearch.clients.json.JsonpDeserializer;
import org.opensearch.clients.json.JsonpMapper;
import org.opensearch.clients.json.ObjectBuilderDeserializer;
import org.opensearch.clients.json.ToJsonp;
import org.opensearch.clients.util.ObjectBuilder;

import java.util.Objects;

// typedef: cluster.stats.ClusterProcessOpenFileDescriptors
public final class ClusterProcessOpenFileDescriptors implements ToJsonp {
	private final Number avg;

	private final Number max;

	private final Number min;

	// ---------------------------------------------------------------------------------------------

	protected ClusterProcessOpenFileDescriptors(Builder builder) {

		this.avg = Objects.requireNonNull(builder.avg, "avg");
		this.max = Objects.requireNonNull(builder.max, "max");
		this.min = Objects.requireNonNull(builder.min, "min");

	}

	/**
	 * API name: {@code avg}
	 */
	public Number avg() {
		return this.avg;
	}

	/**
	 * API name: {@code max}
	 */
	public Number max() {
		return this.max;
	}

	/**
	 * API name: {@code min}
	 */
	public Number min() {
		return this.min;
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

		generator.writeKey("avg");
		generator.write(this.avg.doubleValue());

		generator.writeKey("max");
		generator.write(this.max.doubleValue());

		generator.writeKey("min");
		generator.write(this.min.doubleValue());

	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Builder for {@link ClusterProcessOpenFileDescriptors}.
	 */
	public static class Builder implements ObjectBuilder<ClusterProcessOpenFileDescriptors> {
		private Number avg;

		private Number max;

		private Number min;

		/**
		 * API name: {@code avg}
		 */
		public Builder avg(Number value) {
			this.avg = value;
			return this;
		}

		/**
		 * API name: {@code max}
		 */
		public Builder max(Number value) {
			this.max = value;
			return this;
		}

		/**
		 * API name: {@code min}
		 */
		public Builder min(Number value) {
			this.min = value;
			return this;
		}

		/**
		 * Builds a {@link ClusterProcessOpenFileDescriptors}.
		 *
		 * @throws NullPointerException
		 *             if some of the required fields are null.
		 */
		public ClusterProcessOpenFileDescriptors build() {

			return new ClusterProcessOpenFileDescriptors(this);
		}
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Json deserializer for ClusterProcessOpenFileDescriptors
	 */
	public static final JsonpDeserializer<ClusterProcessOpenFileDescriptors> DESERIALIZER = ObjectBuilderDeserializer
			.createForObject(Builder::new,
					ClusterProcessOpenFileDescriptors::setupClusterProcessOpenFileDescriptorsDeserializer);

	protected static void setupClusterProcessOpenFileDescriptorsDeserializer(
			DelegatingDeserializer<ClusterProcessOpenFileDescriptors.Builder> op) {

		op.add(Builder::avg, JsonpDeserializer.numberDeserializer(), "avg");
		op.add(Builder::max, JsonpDeserializer.numberDeserializer(), "max");
		op.add(Builder::min, JsonpDeserializer.numberDeserializer(), "min");

	}

}
