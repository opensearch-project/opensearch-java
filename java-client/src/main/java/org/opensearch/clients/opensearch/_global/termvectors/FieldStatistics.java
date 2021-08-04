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

package org.opensearch.clients.opensearch._global.termvectors;

import jakarta.json.stream.JsonGenerator;
import org.opensearch.clients.json.DelegatingDeserializer;
import org.opensearch.clients.json.JsonpDeserializer;
import org.opensearch.clients.json.JsonpMapper;
import org.opensearch.clients.json.ObjectBuilderDeserializer;
import org.opensearch.clients.json.ToJsonp;
import org.opensearch.clients.util.ObjectBuilder;

import java.util.Objects;

// typedef: _global.termvectors.FieldStatistics
public final class FieldStatistics implements ToJsonp {
	private final Number docCount;

	private final Number sumDocFreq;

	private final Number sumTtf;

	// ---------------------------------------------------------------------------------------------

	protected FieldStatistics(Builder builder) {

		this.docCount = Objects.requireNonNull(builder.docCount, "doc_count");
		this.sumDocFreq = Objects.requireNonNull(builder.sumDocFreq, "sum_doc_freq");
		this.sumTtf = Objects.requireNonNull(builder.sumTtf, "sum_ttf");

	}

	/**
	 * API name: {@code doc_count}
	 */
	public Number docCount() {
		return this.docCount;
	}

	/**
	 * API name: {@code sum_doc_freq}
	 */
	public Number sumDocFreq() {
		return this.sumDocFreq;
	}

	/**
	 * API name: {@code sum_ttf}
	 */
	public Number sumTtf() {
		return this.sumTtf;
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

		generator.writeKey("doc_count");
		generator.write(this.docCount.doubleValue());

		generator.writeKey("sum_doc_freq");
		generator.write(this.sumDocFreq.doubleValue());

		generator.writeKey("sum_ttf");
		generator.write(this.sumTtf.doubleValue());

	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Builder for {@link FieldStatistics}.
	 */
	public static class Builder implements ObjectBuilder<FieldStatistics> {
		private Number docCount;

		private Number sumDocFreq;

		private Number sumTtf;

		/**
		 * API name: {@code doc_count}
		 */
		public Builder docCount(Number value) {
			this.docCount = value;
			return this;
		}

		/**
		 * API name: {@code sum_doc_freq}
		 */
		public Builder sumDocFreq(Number value) {
			this.sumDocFreq = value;
			return this;
		}

		/**
		 * API name: {@code sum_ttf}
		 */
		public Builder sumTtf(Number value) {
			this.sumTtf = value;
			return this;
		}

		/**
		 * Builds a {@link FieldStatistics}.
		 *
		 * @throws NullPointerException
		 *             if some of the required fields are null.
		 */
		public FieldStatistics build() {

			return new FieldStatistics(this);
		}
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Json deserializer for FieldStatistics
	 */
	public static final JsonpDeserializer<FieldStatistics> DESERIALIZER = ObjectBuilderDeserializer
			.createForObject(Builder::new, FieldStatistics::setupFieldStatisticsDeserializer);

	protected static void setupFieldStatisticsDeserializer(DelegatingDeserializer<FieldStatistics.Builder> op) {

		op.add(Builder::docCount, JsonpDeserializer.numberDeserializer(), "doc_count");
		op.add(Builder::sumDocFreq, JsonpDeserializer.numberDeserializer(), "sum_doc_freq");
		op.add(Builder::sumTtf, JsonpDeserializer.numberDeserializer(), "sum_ttf");

	}

}
