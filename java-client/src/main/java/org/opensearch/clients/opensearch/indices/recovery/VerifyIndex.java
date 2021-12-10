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

package org.opensearch.clients.opensearch.indices.recovery;

import org.opensearch.clients.opensearch._types.Time;
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
import java.lang.String;
import java.util.function.Function;
import javax.annotation.Nullable;

// typedef: indices.recovery.VerifyIndex

/**
 *
 * @see <a href=
 *      "https://github.com/elastic/elasticsearch-specification/tree/98036c3/specification/indices/recovery/types.ts#L104-L109">API
 *      specification</a>
 */
@JsonpDeserializable
public class VerifyIndex implements JsonpSerializable {
	@Nullable
	private final Time checkIndexTime;

	private final String checkIndexTimeInMillis;

	@Nullable
	private final Time totalTime;

	private final String totalTimeInMillis;

	// ---------------------------------------------------------------------------------------------

	private VerifyIndex(Builder builder) {

		this.checkIndexTime = builder.checkIndexTime;
		this.checkIndexTimeInMillis = ApiTypeHelper.requireNonNull(builder.checkIndexTimeInMillis, this,
				"checkIndexTimeInMillis");
		this.totalTime = builder.totalTime;
		this.totalTimeInMillis = ApiTypeHelper.requireNonNull(builder.totalTimeInMillis, this, "totalTimeInMillis");

	}

	public static VerifyIndex of(Function<Builder, ObjectBuilder<VerifyIndex>> fn) {
		return fn.apply(new Builder()).build();
	}

	/**
	 * API name: {@code check_index_time}
	 */
	@Nullable
	public final Time checkIndexTime() {
		return this.checkIndexTime;
	}

	/**
	 * Required - API name: {@code check_index_time_in_millis}
	 */
	public final String checkIndexTimeInMillis() {
		return this.checkIndexTimeInMillis;
	}

	/**
	 * API name: {@code total_time}
	 */
	@Nullable
	public final Time totalTime() {
		return this.totalTime;
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

		if (this.checkIndexTime != null) {
			generator.writeKey("check_index_time");
			this.checkIndexTime.serialize(generator, mapper);

		}
		generator.writeKey("check_index_time_in_millis");
		generator.write(this.checkIndexTimeInMillis);

		if (this.totalTime != null) {
			generator.writeKey("total_time");
			this.totalTime.serialize(generator, mapper);

		}
		generator.writeKey("total_time_in_millis");
		generator.write(this.totalTimeInMillis);

	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Builder for {@link VerifyIndex}.
	 */

	public static class Builder extends ObjectBuilderBase implements ObjectBuilder<VerifyIndex> {
		@Nullable
		private Time checkIndexTime;

		private String checkIndexTimeInMillis;

		@Nullable
		private Time totalTime;

		private String totalTimeInMillis;

		/**
		 * API name: {@code check_index_time}
		 */
		public final Builder checkIndexTime(@Nullable Time value) {
			this.checkIndexTime = value;
			return this;
		}

		/**
		 * API name: {@code check_index_time}
		 */
		public final Builder checkIndexTime(Function<Time.Builder, ObjectBuilder<Time>> fn) {
			return this.checkIndexTime(fn.apply(new Time.Builder()).build());
		}

		/**
		 * Required - API name: {@code check_index_time_in_millis}
		 */
		public final Builder checkIndexTimeInMillis(String value) {
			this.checkIndexTimeInMillis = value;
			return this;
		}

		/**
		 * API name: {@code total_time}
		 */
		public final Builder totalTime(@Nullable Time value) {
			this.totalTime = value;
			return this;
		}

		/**
		 * API name: {@code total_time}
		 */
		public final Builder totalTime(Function<Time.Builder, ObjectBuilder<Time>> fn) {
			return this.totalTime(fn.apply(new Time.Builder()).build());
		}

		/**
		 * Required - API name: {@code total_time_in_millis}
		 */
		public final Builder totalTimeInMillis(String value) {
			this.totalTimeInMillis = value;
			return this;
		}

		/**
		 * Builds a {@link VerifyIndex}.
		 *
		 * @throws NullPointerException
		 *             if some of the required fields are null.
		 */
		public VerifyIndex build() {
			_checkSingleUse();

			return new VerifyIndex(this);
		}
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Json deserializer for {@link VerifyIndex}
	 */
	public static final JsonpDeserializer<VerifyIndex> _DESERIALIZER = ObjectBuilderDeserializer.lazy(Builder::new,
			VerifyIndex::setupVerifyIndexDeserializer);

	protected static void setupVerifyIndexDeserializer(ObjectDeserializer<VerifyIndex.Builder> op) {

		op.add(Builder::checkIndexTime, Time._DESERIALIZER, "check_index_time");
		op.add(Builder::checkIndexTimeInMillis, JsonpDeserializer.stringDeserializer(), "check_index_time_in_millis");
		op.add(Builder::totalTime, Time._DESERIALIZER, "total_time");
		op.add(Builder::totalTimeInMillis, JsonpDeserializer.stringDeserializer(), "total_time_in_millis");

	}

}
