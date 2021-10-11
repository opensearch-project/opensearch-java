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

// typedef: _types.ClusterStatistics
public final class ClusterStatistics implements ToJsonp {
	private final Number skipped;

	private final Number successful;

	private final Number total;

	// ---------------------------------------------------------------------------------------------

	protected ClusterStatistics(Builder builder) {

		this.skipped = Objects.requireNonNull(builder.skipped, "skipped");
		this.successful = Objects.requireNonNull(builder.successful, "successful");
		this.total = Objects.requireNonNull(builder.total, "total");

	}

	/**
	 * API name: {@code skipped}
	 */
	public Number skipped() {
		return this.skipped;
	}

	/**
	 * API name: {@code successful}
	 */
	public Number successful() {
		return this.successful;
	}

	/**
	 * API name: {@code total}
	 */
	public Number total() {
		return this.total;
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

		generator.writeKey("skipped");
		generator.write(this.skipped.doubleValue());

		generator.writeKey("successful");
		generator.write(this.successful.doubleValue());

		generator.writeKey("total");
		generator.write(this.total.doubleValue());

	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Builder for {@link ClusterStatistics}.
	 */
	public static class Builder implements ObjectBuilder<ClusterStatistics> {
		private Number skipped;

		private Number successful;

		private Number total;

		/**
		 * API name: {@code skipped}
		 */
		public Builder skipped(Number value) {
			this.skipped = value;
			return this;
		}

		/**
		 * API name: {@code successful}
		 */
		public Builder successful(Number value) {
			this.successful = value;
			return this;
		}

		/**
		 * API name: {@code total}
		 */
		public Builder total(Number value) {
			this.total = value;
			return this;
		}

		/**
		 * Builds a {@link ClusterStatistics}.
		 *
		 * @throws NullPointerException
		 *             if some of the required fields are null.
		 */
		public ClusterStatistics build() {

			return new ClusterStatistics(this);
		}
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Json deserializer for ClusterStatistics
	 */
	public static final JsonpDeserializer<ClusterStatistics> DESERIALIZER = ObjectBuilderDeserializer
			.createForObject(Builder::new, ClusterStatistics::setupClusterStatisticsDeserializer);

	protected static void setupClusterStatisticsDeserializer(DelegatingDeserializer<ClusterStatistics.Builder> op) {

		op.add(Builder::skipped, JsonpDeserializer.numberDeserializer(), "skipped");
		op.add(Builder::successful, JsonpDeserializer.numberDeserializer(), "successful");
		op.add(Builder::total, JsonpDeserializer.numberDeserializer(), "total");

	}

}
