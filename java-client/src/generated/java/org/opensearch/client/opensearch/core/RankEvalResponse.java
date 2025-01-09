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

package org.opensearch.client.opensearch.core;

import jakarta.json.stream.JsonGenerator;
import java.util.Map;
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import org.opensearch.client.json.JsonData;
import org.opensearch.client.json.JsonpDeserializable;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.ObjectBuilderDeserializer;
import org.opensearch.client.json.ObjectDeserializer;
import org.opensearch.client.json.PlainJsonSerializable;
import org.opensearch.client.opensearch.core.rank_eval.RankEvalMetricDetail;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: rank_eval.Response

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class RankEvalResponse implements PlainJsonSerializable, ToCopyableBuilder<RankEvalResponse.Builder, RankEvalResponse> {

    @Nonnull
    private final Map<String, RankEvalMetricDetail> details;

    @Nonnull
    private final Map<String, JsonData> failures;

    private final double metricScore;

    // ---------------------------------------------------------------------------------------------

    private RankEvalResponse(Builder builder) {
        this.details = ApiTypeHelper.unmodifiableRequired(builder.details, this, "details");
        this.failures = ApiTypeHelper.unmodifiableRequired(builder.failures, this, "failures");
        this.metricScore = ApiTypeHelper.requireNonNull(builder.metricScore, this, "metricScore");
    }

    public static RankEvalResponse of(Function<RankEvalResponse.Builder, ObjectBuilder<RankEvalResponse>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - The details section contains one entry for every query in the original requests section, keyed by the search request id
     * <p>
     * API name: {@code details}
     * </p>
     */
    @Nonnull
    public final Map<String, RankEvalMetricDetail> details() {
        return this.details;
    }

    /**
     * Required - API name: {@code failures}
     */
    @Nonnull
    public final Map<String, JsonData> failures() {
        return this.failures;
    }

    /**
     * Required - The overall evaluation quality calculated by the defined metric
     * <p>
     * API name: {@code metric_score}
     * </p>
     */
    public final double metricScore() {
        return this.metricScore;
    }

    /**
     * Serialize this object to JSON.
     */
    @Override
    public void serialize(JsonGenerator generator, JsonpMapper mapper) {
        generator.writeStartObject();
        serializeInternal(generator, mapper);
        generator.writeEnd();
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        generator.writeKey("details");
        generator.writeStartObject();
        for (Map.Entry<String, RankEvalMetricDetail> item0 : this.details.entrySet()) {
            generator.writeKey(item0.getKey());
            item0.getValue().serialize(generator, mapper);
        }
        generator.writeEnd();

        generator.writeKey("failures");
        generator.writeStartObject();
        for (Map.Entry<String, JsonData> item0 : this.failures.entrySet()) {
            generator.writeKey(item0.getKey());
            item0.getValue().serialize(generator, mapper);
        }
        generator.writeEnd();

        generator.writeKey("metric_score");
        generator.write(this.metricScore);
    }

    // ---------------------------------------------------------------------------------------------

    @Override
    @Nonnull
    public Builder toBuilder() {
        return new Builder(this);
    }

    @Nonnull
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Builder for {@link RankEvalResponse}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, RankEvalResponse> {
        private Map<String, RankEvalMetricDetail> details;
        private Map<String, JsonData> failures;
        private Double metricScore;

        public Builder() {}

        private Builder(RankEvalResponse o) {
            this.details = _mapCopy(o.details);
            this.failures = _mapCopy(o.failures);
            this.metricScore = o.metricScore;
        }

        private Builder(Builder o) {
            this.details = _mapCopy(o.details);
            this.failures = _mapCopy(o.failures);
            this.metricScore = o.metricScore;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - The details section contains one entry for every query in the original requests section, keyed by the search request
         * id
         * <p>
         * API name: {@code details}
         * </p>
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>details</code>.
         * </p>
         */
        @Nonnull
        public final Builder details(Map<String, RankEvalMetricDetail> map) {
            this.details = _mapPutAll(this.details, map);
            return this;
        }

        /**
         * Required - The details section contains one entry for every query in the original requests section, keyed by the search request
         * id
         * <p>
         * API name: {@code details}
         * </p>
         *
         * <p>
         * Adds an entry to <code>details</code>.
         * </p>
         */
        @Nonnull
        public final Builder details(String key, RankEvalMetricDetail value) {
            this.details = _mapPut(this.details, key, value);
            return this;
        }

        /**
         * Required - The details section contains one entry for every query in the original requests section, keyed by the search request
         * id
         * <p>
         * API name: {@code details}
         * </p>
         *
         * <p>
         * Adds a value to <code>details</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder details(String key, Function<RankEvalMetricDetail.Builder, ObjectBuilder<RankEvalMetricDetail>> fn) {
            return details(key, fn.apply(new RankEvalMetricDetail.Builder()).build());
        }

        /**
         * Required - API name: {@code failures}
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>failures</code>.
         * </p>
         */
        @Nonnull
        public final Builder failures(Map<String, JsonData> map) {
            this.failures = _mapPutAll(this.failures, map);
            return this;
        }

        /**
         * Required - API name: {@code failures}
         *
         * <p>
         * Adds an entry to <code>failures</code>.
         * </p>
         */
        @Nonnull
        public final Builder failures(String key, JsonData value) {
            this.failures = _mapPut(this.failures, key, value);
            return this;
        }

        /**
         * Required - The overall evaluation quality calculated by the defined metric
         * <p>
         * API name: {@code metric_score}
         * </p>
         */
        @Nonnull
        public final Builder metricScore(double value) {
            this.metricScore = value;
            return this;
        }

        /**
         * Builds a {@link RankEvalResponse}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public RankEvalResponse build() {
            _checkSingleUse();

            return new RankEvalResponse(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link RankEvalResponse}
     */
    public static final JsonpDeserializer<RankEvalResponse> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        RankEvalResponse::setupRankEvalResponseDeserializer
    );

    protected static void setupRankEvalResponseDeserializer(ObjectDeserializer<RankEvalResponse.Builder> op) {
        op.add(Builder::details, JsonpDeserializer.stringMapDeserializer(RankEvalMetricDetail._DESERIALIZER), "details");
        op.add(Builder::failures, JsonpDeserializer.stringMapDeserializer(JsonData._DESERIALIZER), "failures");
        op.add(Builder::metricScore, JsonpDeserializer.doubleDeserializer(), "metric_score");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.details.hashCode();
        result = 31 * result + this.failures.hashCode();
        result = 31 * result + Double.hashCode(this.metricScore);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        RankEvalResponse other = (RankEvalResponse) o;
        return this.details.equals(other.details) && this.failures.equals(other.failures) && this.metricScore == other.metricScore;
    }
}
