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

package org.opensearch.clients.elasticsearch._types.query_dsl;

import org.opensearch.clients.json.DelegatingDeserializer;
import org.opensearch.clients.json.JsonpDeserializable;
import org.opensearch.clients.json.JsonpDeserializer;
import org.opensearch.clients.json.JsonpMapper;
import org.opensearch.clients.json.ObjectBuilderDeserializer;
import org.opensearch.clients.util.ModelTypeHelper;
import org.opensearch.clients.util.ObjectBuilder;
import jakarta.json.stream.JsonGenerator;
import java.lang.String;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import javax.annotation.Nullable;

// typedef: _types.query_dsl.IdsQuery
@JsonpDeserializable
public class IdsQuery extends QueryBase implements QueryVariant {
	private final List<String> values;

	// ---------------------------------------------------------------------------------------------

	private IdsQuery(Builder builder) {
		super(builder);

		this.values = ModelTypeHelper.unmodifiable(builder.values);

	}

	public static IdsQuery of(Function<Builder, ObjectBuilder<IdsQuery>> fn) {
		return fn.apply(new Builder()).build();
	}

	/**
	 * {@link Query} variant type
	 */
	@Override
	public String _variantType() {
		return "ids";
	}

	/**
	 * API name: {@code values}
	 */
	public final List<String> values() {
		return this.values;
	}

	protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {

		super.serializeInternal(generator, mapper);
		if (ModelTypeHelper.isDefined(this.values)) {
			generator.writeKey("values");
			generator.writeStartArray();
			for (String item0 : this.values) {
				generator.write(item0);

			}
			generator.writeEnd();

		}

	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Builder for {@link IdsQuery}.
	 */
	public static class Builder extends QueryBase.AbstractBuilder<Builder> implements ObjectBuilder<IdsQuery> {
		@Nullable
		private List<String> values;

		/**
		 * API name: {@code values}
		 */
		public final Builder values(@Nullable List<String> value) {
			this.values = value;
			return this;
		}

		/**
		 * API name: {@code values}
		 */
		public final Builder values(String... value) {
			this.values = Arrays.asList(value);
			return this;
		}

		@Override
		protected Builder self() {
			return this;
		}

		/**
		 * Builds a {@link IdsQuery}.
		 *
		 * @throws NullPointerException
		 *             if some of the required fields are null.
		 */
		public IdsQuery build() {
			_checkSingleUse();

			return new IdsQuery(this);
		}
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Json deserializer for {@link IdsQuery}
	 */
	public static final JsonpDeserializer<IdsQuery> _DESERIALIZER = ObjectBuilderDeserializer.lazy(Builder::new,
			IdsQuery::setupIdsQueryDeserializer, Builder::build);

	protected static void setupIdsQueryDeserializer(DelegatingDeserializer<IdsQuery.Builder> op) {
		setupQueryBaseDeserializer(op);
		op.add(Builder::values, JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()), "values");

	}

}
