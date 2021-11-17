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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

// typedef: _global.search._types.Profile
@JsonpDeserializable
public class Profile implements JsonpSerializable {
	private final List<ShardProfile> shards;

	// ---------------------------------------------------------------------------------------------

	private Profile(Builder builder) {

		this.shards = ModelTypeHelper.unmodifiableRequired(builder.shards, this, "shards");

	}

	public static Profile of(Function<Builder, ObjectBuilder<Profile>> fn) {
		return fn.apply(new Builder()).build();
	}

	/**
	 * Required - API name: {@code shards}
	 */
	public final List<ShardProfile> shards() {
		return this.shards;
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

		if (ModelTypeHelper.isDefined(this.shards)) {
			generator.writeKey("shards");
			generator.writeStartArray();
			for (ShardProfile item0 : this.shards) {
				item0.serialize(generator, mapper);

			}
			generator.writeEnd();

		}

	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Builder for {@link Profile}.
	 */
	public static class Builder extends ObjectBuilderBase implements ObjectBuilder<Profile> {
		private List<ShardProfile> shards;

		/**
		 * Required - API name: {@code shards}
		 */
		public final Builder shards(List<ShardProfile> value) {
			this.shards = value;
			return this;
		}

		/**
		 * Required - API name: {@code shards}
		 */
		public final Builder shards(ShardProfile... value) {
			this.shards = Arrays.asList(value);
			return this;
		}

		/**
		 * Required - API name: {@code shards}
		 */
		@SafeVarargs
		public final Builder shards(Function<ShardProfile.Builder, ObjectBuilder<ShardProfile>>... fns) {
			this.shards = new ArrayList<>(fns.length);
			for (Function<ShardProfile.Builder, ObjectBuilder<ShardProfile>> fn : fns) {
				this.shards.add(fn.apply(new ShardProfile.Builder()).build());
			}
			return this;
		}

		/**
		 * Builds a {@link Profile}.
		 *
		 * @throws NullPointerException
		 *             if some of the required fields are null.
		 */
		public Profile build() {
			_checkSingleUse();

			return new Profile(this);
		}
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Json deserializer for {@link Profile}
	 */
	public static final JsonpDeserializer<Profile> _DESERIALIZER = ObjectBuilderDeserializer.lazy(Builder::new,
			Profile::setupProfileDeserializer, Builder::build);

	protected static void setupProfileDeserializer(DelegatingDeserializer<Profile.Builder> op) {

		op.add(Builder::shards, JsonpDeserializer.arrayDeserializer(ShardProfile._DESERIALIZER), "shards");

	}

}
