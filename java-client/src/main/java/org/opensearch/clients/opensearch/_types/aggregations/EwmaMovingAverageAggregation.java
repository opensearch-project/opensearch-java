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

package org.opensearch.clients.opensearch._types.aggregations;

import org.opensearch.clients.json.JsonpDeserializable;
import org.opensearch.clients.json.JsonpDeserializer;
import org.opensearch.clients.json.JsonpMapper;
import org.opensearch.clients.json.ObjectBuilderDeserializer;
import org.opensearch.clients.json.ObjectDeserializer;
import org.opensearch.clients.util.ApiTypeHelper;
import org.opensearch.clients.util.ObjectBuilder;
import jakarta.json.stream.JsonGenerator;

import java.util.function.Function;

// typedef: _types.aggregations.EwmaMovingAverageAggregation

/**
 *
 * @see <a href=
 *      "https://github.com/elastic/elasticsearch-specification/tree/98036c3/specification/_types/aggregations/pipeline.ts#L139-L142">API
 *      specification</a>
 */
@JsonpDeserializable
public class EwmaMovingAverageAggregation extends MovingAverageAggregationBase
		implements
			MovingAverageAggregationVariant {
	private final EwmaModelSettings settings;

	// ---------------------------------------------------------------------------------------------

	private EwmaMovingAverageAggregation(Builder builder) {
		super(builder);

		this.settings = ApiTypeHelper.requireNonNull(builder.settings, this, "settings");

	}

	public static EwmaMovingAverageAggregation of(Function<Builder, ObjectBuilder<EwmaMovingAverageAggregation>> fn) {
		return fn.apply(new Builder()).build();
	}

	/**
	 * MovingAverageAggregation variant kind.
	 */
	@Override
	public MovingAverageAggregation.Kind _movingAverageAggregationKind() {
		return MovingAverageAggregation.Kind.Ewma;
	}

	/**
	 * Required - API name: {@code settings}
	 */
	public final EwmaModelSettings settings() {
		return this.settings;
	}

	protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {

		generator.write("model", "ewma");
		super.serializeInternal(generator, mapper);
		generator.writeKey("settings");
		this.settings.serialize(generator, mapper);

	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Builder for {@link EwmaMovingAverageAggregation}.
	 */

	public static class Builder extends MovingAverageAggregationBase.AbstractBuilder<Builder>
			implements
				ObjectBuilder<EwmaMovingAverageAggregation> {
		private EwmaModelSettings settings;

		/**
		 * Required - API name: {@code settings}
		 */
		public final Builder settings(EwmaModelSettings value) {
			this.settings = value;
			return this;
		}

		/**
		 * Required - API name: {@code settings}
		 */
		public final Builder settings(Function<EwmaModelSettings.Builder, ObjectBuilder<EwmaModelSettings>> fn) {
			return this.settings(fn.apply(new EwmaModelSettings.Builder()).build());
		}

		@Override
		protected Builder self() {
			return this;
		}

		/**
		 * Builds a {@link EwmaMovingAverageAggregation}.
		 *
		 * @throws NullPointerException
		 *             if some of the required fields are null.
		 */
		public EwmaMovingAverageAggregation build() {
			_checkSingleUse();

			return new EwmaMovingAverageAggregation(this);
		}
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Json deserializer for {@link EwmaMovingAverageAggregation}
	 */
	public static final JsonpDeserializer<EwmaMovingAverageAggregation> _DESERIALIZER = ObjectBuilderDeserializer
			.lazy(Builder::new, EwmaMovingAverageAggregation::setupEwmaMovingAverageAggregationDeserializer);

	protected static void setupEwmaMovingAverageAggregationDeserializer(
			ObjectDeserializer<EwmaMovingAverageAggregation.Builder> op) {
		MovingAverageAggregationBase.setupMovingAverageAggregationBaseDeserializer(op);
		op.add(Builder::settings, EwmaModelSettings._DESERIALIZER, "settings");

		op.ignore("model");
	}

}
