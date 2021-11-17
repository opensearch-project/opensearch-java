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

package org.opensearch.clients.opensearch.core.search;

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
import java.lang.Integer;
import java.util.function.Function;
import javax.annotation.Nullable;

// typedef: _global.search._types.Rescore
@JsonpDeserializable
public class Rescore implements JsonpSerializable {
	private final RescoreQuery query;

	@Nullable
	private final Integer windowSize;

	// ---------------------------------------------------------------------------------------------

	private Rescore(Builder builder) {

		this.query = ModelTypeHelper.requireNonNull(builder.query, this, "query");
		this.windowSize = builder.windowSize;

	}

	public static Rescore of(Function<Builder, ObjectBuilder<Rescore>> fn) {
		return fn.apply(new Builder()).build();
	}

	/**
	 * Required - API name: {@code query}
	 */
	public final RescoreQuery query() {
		return this.query;
	}

	/**
	 * API name: {@code window_size}
	 */
	@Nullable
	public final Integer windowSize() {
		return this.windowSize;
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

		generator.writeKey("query");
		this.query.serialize(generator, mapper);

		if (this.windowSize != null) {
			generator.writeKey("window_size");
			generator.write(this.windowSize);

		}

	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Builder for {@link Rescore}.
	 */
	public static class Builder extends ObjectBuilderBase implements ObjectBuilder<Rescore> {
		private RescoreQuery query;

		@Nullable
		private Integer windowSize;

		/**
		 * Required - API name: {@code query}
		 */
		public final Builder query(RescoreQuery value) {
			this.query = value;
			return this;
		}

		/**
		 * Required - API name: {@code query}
		 */
		public final Builder query(Function<RescoreQuery.Builder, ObjectBuilder<RescoreQuery>> fn) {
			return this.query(fn.apply(new RescoreQuery.Builder()).build());
		}

		/**
		 * API name: {@code window_size}
		 */
		public final Builder windowSize(@Nullable Integer value) {
			this.windowSize = value;
			return this;
		}

		/**
		 * Builds a {@link Rescore}.
		 *
		 * @throws NullPointerException
		 *             if some of the required fields are null.
		 */
		public Rescore build() {
			_checkSingleUse();

			return new Rescore(this);
		}
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Json deserializer for {@link Rescore}
	 */
	public static final JsonpDeserializer<Rescore> _DESERIALIZER = ObjectBuilderDeserializer.lazy(Builder::new,
			Rescore::setupRescoreDeserializer, Builder::build);

	protected static void setupRescoreDeserializer(DelegatingDeserializer<Rescore.Builder> op) {

		op.add(Builder::query, RescoreQuery._DESERIALIZER, "query");
		op.add(Builder::windowSize, JsonpDeserializer.integerDeserializer(), "window_size");

	}

}
