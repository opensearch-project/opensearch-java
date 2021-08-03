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

import jakarta.json.stream.JsonGenerator;
import org.opensearch.clients.json.DelegatingDeserializer;
import org.opensearch.clients.json.JsonpDeserializer;
import org.opensearch.clients.json.JsonpMapper;
import org.opensearch.clients.json.ObjectBuilderDeserializer;
import org.opensearch.clients.util.ObjectBuilder;

import javax.annotation.Nullable;

// typedef: _types.aggregations.MedianAbsoluteDeviationAggregation
public final class MedianAbsoluteDeviationAggregation extends FormatMetricAggregationBase {
	@Nullable
	private final Number compression;

	// ---------------------------------------------------------------------------------------------

	protected MedianAbsoluteDeviationAggregation(Builder builder) {
		super(builder);
		this.compression = builder.compression;

	}

	/**
	 * API name: {@code compression}
	 */
	@Nullable
	public Number compression() {
		return this.compression;
	}

	protected void toJsonpInternal(JsonGenerator generator, JsonpMapper mapper) {
		super.toJsonpInternal(generator, mapper);
		if (this.compression != null) {

			generator.writeKey("compression");
			generator.write(this.compression.doubleValue());

		}

	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Builder for {@link MedianAbsoluteDeviationAggregation}.
	 */
	public static class Builder extends FormatMetricAggregationBase.AbstractBuilder<Builder>
			implements
				ObjectBuilder<MedianAbsoluteDeviationAggregation> {
		@Nullable
		private Number compression;

		/**
		 * API name: {@code compression}
		 */
		public Builder compression(@Nullable Number value) {
			this.compression = value;
			return this;
		}

		@Override
		protected Builder self() {
			return this;
		}

		/**
		 * Builds a {@link MedianAbsoluteDeviationAggregation}.
		 *
		 * @throws NullPointerException
		 *             if some of the required fields are null.
		 */
		public MedianAbsoluteDeviationAggregation build() {

			return new MedianAbsoluteDeviationAggregation(this);
		}
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Json deserializer for MedianAbsoluteDeviationAggregation
	 */
	public static final JsonpDeserializer<MedianAbsoluteDeviationAggregation> DESERIALIZER = ObjectBuilderDeserializer
			.createForObject(Builder::new,
					MedianAbsoluteDeviationAggregation::setupMedianAbsoluteDeviationAggregationDeserializer);

	protected static void setupMedianAbsoluteDeviationAggregationDeserializer(
			DelegatingDeserializer<MedianAbsoluteDeviationAggregation.Builder> op) {
		FormatMetricAggregationBase.setupFormatMetricAggregationBaseDeserializer(op);
		op.add(Builder::compression, JsonpDeserializer.numberDeserializer(), "compression");

	}

}
