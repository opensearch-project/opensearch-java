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

package org.opensearch.client.opensearch._types.aggregations;

import org.opensearch.client.json.DelegatingDeserializer;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.util.ModelTypeHelper;
import jakarta.json.JsonValue;
import jakarta.json.stream.JsonGenerator;

// typedef: _types.aggregations.PercentilesAggregateBase

public abstract class PercentilesAggregateBase extends AggregateBase {
	private final JsonValue /*
							 * Union(Array<_types.aggregations.ArrayPercentilesItem> |
							 * _types.aggregations.KeyedPercentiles)
							 */ values;

	// ---------------------------------------------------------------------------------------------

	protected PercentilesAggregateBase(AbstractBuilder<?> builder) {
		super(builder);

		this.values = ModelTypeHelper.requireNonNull(builder.values, this, "values");

	}

	/**
	 * Required - API name: {@code values}
	 */
	public final JsonValue /*
							 * Union(Array<_types.aggregations.ArrayPercentilesItem> |
							 * _types.aggregations.KeyedPercentiles)
							 */ values() {
		return this.values;
	}

	protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {

		super.serializeInternal(generator, mapper);
		generator.writeKey("values");
		generator.write(this.values);

	}

	protected abstract static class AbstractBuilder<BuilderT extends AbstractBuilder<BuilderT>>
			extends
				AggregateBase.AbstractBuilder<BuilderT> {
		private JsonValue /*
							 * Union(Array<_types.aggregations.ArrayPercentilesItem> |
							 * _types.aggregations.KeyedPercentiles)
							 */ values;

		/**
		 * Required - API name: {@code values}
		 */
		public final BuilderT values(JsonValue /*
												 * Union(Array<_types.aggregations.ArrayPercentilesItem> |
												 * _types.aggregations.KeyedPercentiles)
												 */ value) {
			this.values = value;
			return self();
		}

	}

	// ---------------------------------------------------------------------------------------------
	protected static <BuilderT extends AbstractBuilder<BuilderT>> void setupPercentilesAggregateBaseDeserializer(
			DelegatingDeserializer<BuilderT> op) {
		AggregateBase.setupAggregateBaseDeserializer(op);
		op.add(AbstractBuilder::values, JsonpDeserializer.jsonValueDeserializer(), "values");

	}

}
