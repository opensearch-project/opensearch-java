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

import java.lang.Long;
import java.lang.String;
import java.util.function.Function;

// typedef: indices.recovery.RecoveryStartStatus
@JsonpDeserializable
public class RecoveryStartStatus implements JsonpSerializable {
	private final long checkIndexTime;

	private final String totalTimeInMillis;

	// ---------------------------------------------------------------------------------------------

	private RecoveryStartStatus(Builder builder) {

		this.checkIndexTime = ModelTypeHelper.requireNonNull(builder.checkIndexTime, this, "checkIndexTime");
		this.totalTimeInMillis = ModelTypeHelper.requireNonNull(builder.totalTimeInMillis, this, "totalTimeInMillis");

	}

	public static RecoveryStartStatus of(Function<Builder, ObjectBuilder<RecoveryStartStatus>> fn) {
		return fn.apply(new Builder()).build();
	}

	/**
	 * Required - API name: {@code check_index_time}
	 */
	public final long checkIndexTime() {
		return this.checkIndexTime;
	}

	/**
	 * Required - API name: {@code total_time_in_millis}
	 */
	public final String totalTimeInMillis() {
		return this.totalTimeInMillis;
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

		generator.writeKey("check_index_time");
		generator.write(this.checkIndexTime);

		generator.writeKey("total_time_in_millis");
		generator.write(this.totalTimeInMillis);

	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Builder for {@link RecoveryStartStatus}.
	 */
	public static class Builder extends ObjectBuilderBase implements ObjectBuilder<RecoveryStartStatus> {
		private Long checkIndexTime;

		private String totalTimeInMillis;

		/**
		 * Required - API name: {@code check_index_time}
		 */
		public final Builder checkIndexTime(long value) {
			this.checkIndexTime = value;
			return this;
		}

		/**
		 * Required - API name: {@code total_time_in_millis}
		 */
		public final Builder totalTimeInMillis(String value) {
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
			_checkSingleUse();

			return new RecoveryStartStatus(this);
		}
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Json deserializer for {@link RecoveryStartStatus}
	 */
	public static final JsonpDeserializer<RecoveryStartStatus> _DESERIALIZER = ObjectBuilderDeserializer
			.lazy(Builder::new, RecoveryStartStatus::setupRecoveryStartStatusDeserializer, Builder::build);

	protected static void setupRecoveryStartStatusDeserializer(DelegatingDeserializer<RecoveryStartStatus.Builder> op) {

		op.add(Builder::checkIndexTime, JsonpDeserializer.longDeserializer(), "check_index_time");
		op.add(Builder::totalTimeInMillis, JsonpDeserializer.stringDeserializer(), "total_time_in_millis");

	}

}
