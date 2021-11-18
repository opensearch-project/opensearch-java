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

package org.opensearch.client.opensearch.nodes;

import org.opensearch.client.json.DelegatingDeserializer;
import org.opensearch.client.json.JsonpDeserializable;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.JsonpSerializable;
import org.opensearch.client.json.ObjectBuilderDeserializer;
import org.opensearch.client.util.ModelTypeHelper;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import jakarta.json.stream.JsonGenerator;

import java.lang.Integer;
import java.lang.Long;
import java.util.function.Function;

// typedef: nodes._types.Http
@JsonpDeserializable
public class Http implements JsonpSerializable {
	private final int currentOpen;

	private final long totalOpened;

	// ---------------------------------------------------------------------------------------------

	private Http(Builder builder) {

		this.currentOpen = ModelTypeHelper.requireNonNull(builder.currentOpen, this, "currentOpen");
		this.totalOpened = ModelTypeHelper.requireNonNull(builder.totalOpened, this, "totalOpened");

	}

	public static Http of(Function<Builder, ObjectBuilder<Http>> fn) {
		return fn.apply(new Builder()).build();
	}

	/**
	 * Required - API name: {@code current_open}
	 */
	public final int currentOpen() {
		return this.currentOpen;
	}

	/**
	 * Required - API name: {@code total_opened}
	 */
	public final long totalOpened() {
		return this.totalOpened;
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

		generator.writeKey("current_open");
		generator.write(this.currentOpen);

		generator.writeKey("total_opened");
		generator.write(this.totalOpened);

	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Builder for {@link Http}.
	 */
	public static class Builder extends ObjectBuilderBase implements ObjectBuilder<Http> {
		private Integer currentOpen;

		private Long totalOpened;

		/**
		 * Required - API name: {@code current_open}
		 */
		public final Builder currentOpen(int value) {
			this.currentOpen = value;
			return this;
		}

		/**
		 * Required - API name: {@code total_opened}
		 */
		public final Builder totalOpened(long value) {
			this.totalOpened = value;
			return this;
		}

		/**
		 * Builds a {@link Http}.
		 *
		 * @throws NullPointerException
		 *             if some of the required fields are null.
		 */
		public Http build() {
			_checkSingleUse();

			return new Http(this);
		}
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Json deserializer for {@link Http}
	 */
	public static final JsonpDeserializer<Http> _DESERIALIZER = ObjectBuilderDeserializer.lazy(Builder::new,
			Http::setupHttpDeserializer, Builder::build);

	protected static void setupHttpDeserializer(DelegatingDeserializer<Http.Builder> op) {

		op.add(Builder::currentOpen, JsonpDeserializer.integerDeserializer(), "current_open");
		op.add(Builder::totalOpened, JsonpDeserializer.longDeserializer(), "total_opened");

	}

}
