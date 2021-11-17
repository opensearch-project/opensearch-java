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

package org.opensearch.clients.elasticsearch.core.rank_eval;

import org.opensearch.clients.json.DelegatingDeserializer;
import org.opensearch.clients.json.JsonpDeserializable;
import org.opensearch.clients.json.JsonpDeserializer;
import org.opensearch.clients.json.ObjectBuilderDeserializer;
import org.opensearch.clients.util.ObjectBuilder;

import java.util.function.Function;

// typedef: _global.rank_eval.RankEvalMetricMeanReciprocalRank
@JsonpDeserializable
public class RankEvalMetricMeanReciprocalRank extends RankEvalMetricRatingTreshold {
	// ---------------------------------------------------------------------------------------------

	private RankEvalMetricMeanReciprocalRank(Builder builder) {
		super(builder);

	}

	public static RankEvalMetricMeanReciprocalRank of(
			Function<Builder, ObjectBuilder<RankEvalMetricMeanReciprocalRank>> fn) {
		return fn.apply(new Builder()).build();
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Builder for {@link RankEvalMetricMeanReciprocalRank}.
	 */
	public static class Builder extends RankEvalMetricRatingTreshold.AbstractBuilder<Builder>
			implements
				ObjectBuilder<RankEvalMetricMeanReciprocalRank> {
		@Override
		protected Builder self() {
			return this;
		}

		/**
		 * Builds a {@link RankEvalMetricMeanReciprocalRank}.
		 *
		 * @throws NullPointerException
		 *             if some of the required fields are null.
		 */
		public RankEvalMetricMeanReciprocalRank build() {
			_checkSingleUse();

			return new RankEvalMetricMeanReciprocalRank(this);
		}
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Json deserializer for {@link RankEvalMetricMeanReciprocalRank}
	 */
	public static final JsonpDeserializer<RankEvalMetricMeanReciprocalRank> _DESERIALIZER = ObjectBuilderDeserializer
			.lazy(Builder::new, RankEvalMetricMeanReciprocalRank::setupRankEvalMetricMeanReciprocalRankDeserializer,
					Builder::build);

	protected static void setupRankEvalMetricMeanReciprocalRankDeserializer(
			DelegatingDeserializer<RankEvalMetricMeanReciprocalRank.Builder> op) {
		RankEvalMetricRatingTreshold.setupRankEvalMetricRatingTresholdDeserializer(op);

	}

}
