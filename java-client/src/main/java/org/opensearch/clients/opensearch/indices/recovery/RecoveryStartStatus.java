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

package org.opensearch.clients.opensearch.indices.recovery;

import jakarta.json.stream.JsonGenerator;
import org.opensearch.clients.json.DelegatingDeserializer;
import org.opensearch.clients.json.JsonpDeserializer;
import org.opensearch.clients.json.JsonpMapper;
import org.opensearch.clients.json.ObjectBuilderDeserializer;
import org.opensearch.clients.json.ToJsonp;
import org.opensearch.clients.util.ObjectBuilder;

import java.util.Objects;

// typedef: indices.recovery.RecoveryStartStatus
public final class RecoveryStartStatus implements ToJsonp {
	private final Number checkIndexTime;

	private final String totalTimeInMillis;

	// ---------------------------------------------------------------------------------------------

	protected RecoveryStartStatus(Builder builder) {

		this.checkIndexTime = Objects.requireNonNull(builder.checkIndexTime, "check_index_time");
		this.totalTimeInMillis = Objects.requireNonNull(builder.totalTimeInMillis, "total_time_in_millis");

	}

	/**
	 * API name: {@code check_index_time}
	 */
	public Number checkIndexTime() {
		return this.checkIndexTime;
	}

	/**
	 * API name: {@code total_time_in_millis}
	 */
	public String totalTimeInMillis() {
		return this.totalTimeInMillis;
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

		generator.writeKey("check_index_time");
		generator.write(this.checkIndexTime.doubleValue());

		generator.writeKey("total_time_in_millis");
		generator.write(this.totalTimeInMillis);

	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Builder for {@link RecoveryStartStatus}.
	 */
	public static class Builder implements ObjectBuilder<RecoveryStartStatus> {
		private Number checkIndexTime;

		private String totalTimeInMillis;

		/**
		 * API name: {@code check_index_time}
		 */
		public Builder checkIndexTime(Number value) {
			this.checkIndexTime = value;
			return this;
		}

		/**
		 * API name: {@code total_time_in_millis}
		 */
		public Builder totalTimeInMillis(String value) {
			this.totalTimeInMillis = value;
			return this;
		}

		/**
		 * Builds a {@link RecoveryStartStatus}.
		 *
		 * @throws NullPointerException
		 *             if some of the required fields are null.
		 */
		public RecoveryStartStatus build() {

			return new RecoveryStartStatus(this);
		}
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Json deserializer for RecoveryStartStatus
	 */
	public static final JsonpDeserializer<RecoveryStartStatus> DESERIALIZER = ObjectBuilderDeserializer
			.createForObject(Builder::new, RecoveryStartStatus::setupRecoveryStartStatusDeserializer);

	protected static void setupRecoveryStartStatusDeserializer(DelegatingDeserializer<RecoveryStartStatus.Builder> op) {

		op.add(Builder::checkIndexTime, JsonpDeserializer.numberDeserializer(), "check_index_time");
		op.add(Builder::totalTimeInMillis, JsonpDeserializer.stringDeserializer(), "total_time_in_millis");

	}

}
