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

// typedef: cluster.stats.ClusterProcessCpu
public final class ClusterProcessCpu implements ToJsonp {
	private final Number percent;

	// ---------------------------------------------------------------------------------------------

	protected ClusterProcessCpu(Builder builder) {

		this.percent = Objects.requireNonNull(builder.percent, "percent");

	}

	/**
	 * API name: {@code percent}
	 */
	public Number percent() {
		return this.percent;
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

		generator.writeKey("percent");
		generator.write(this.percent.doubleValue());

	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Builder for {@link ClusterProcessCpu}.
	 */
	public static class Builder implements ObjectBuilder<ClusterProcessCpu> {
		private Number percent;

		/**
		 * API name: {@code percent}
		 */
		public Builder percent(Number value) {
			this.percent = value;
			return this;
		}

		/**
		 * Builds a {@link ClusterProcessCpu}.
		 *
		 * @throws NullPointerException
		 *             if some of the required fields are null.
		 */
		public ClusterProcessCpu build() {

			return new ClusterProcessCpu(this);
		}
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Json deserializer for ClusterProcessCpu
	 */
	public static final JsonpDeserializer<ClusterProcessCpu> DESERIALIZER = ObjectBuilderDeserializer
			.createForObject(Builder::new, ClusterProcessCpu::setupClusterProcessCpuDeserializer);

	protected static void setupClusterProcessCpuDeserializer(DelegatingDeserializer<ClusterProcessCpu.Builder> op) {

		op.add(Builder::percent, JsonpDeserializer.numberDeserializer(), "percent");

	}

}
