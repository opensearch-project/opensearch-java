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

package org.opensearch.client.opensearch.core.rank_eval;

import jakarta.json.stream.JsonGenerator;
import java.util.List;
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
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: core.rank_eval.RankEvalMetricDetail

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class RankEvalMetricDetail implements PlainJsonSerializable, ToCopyableBuilder<RankEvalMetricDetail.Builder, RankEvalMetricDetail> {

    @Nonnull
    private final List<RankEvalHitItem> hits;

    @Nonnull
    private final Map<String, Map<String, JsonData>> metricDetails;

    private final double metricScore;

    @Nonnull
    private final List<UnratedDocument> unratedDocs;

    // ---------------------------------------------------------------------------------------------

    private RankEvalMetricDetail(Builder builder) {
        this.hits = ApiTypeHelper.unmodifiableRequired(builder.hits, this, "hits");
        this.metricDetails = ApiTypeHelper.unmodifiableRequired(builder.metricDetails, this, "metricDetails");
        this.metricScore = ApiTypeHelper.requireNonNull(builder.metricScore, this, "metricScore");
        this.unratedDocs = ApiTypeHelper.unmodifiableRequired(builder.unratedDocs, this, "unratedDocs");
    }

    public static RankEvalMetricDetail of(Function<RankEvalMetricDetail.Builder, ObjectBuilder<RankEvalMetricDetail>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - The <code>hits</code> section provides a grouping of the search results with their supplied ratings.
     * <p>
     * API name: {@code hits}
     * </p>
     */
    @Nonnull
    public final List<RankEvalHitItem> hits() {
        return this.hits;
    }

    /**
     * Required - The <code>metric_details</code> section provides additional information about the calculated quality metric indicating the
     * number of relevant retrieved documents. The content varies for each metric but allows for better interpretation of the results.
     * <p>
     * API name: {@code metric_details}
     * </p>
     */
    @Nonnull
    public final Map<String, Map<String, JsonData>> metricDetails() {
        return this.metricDetails;
    }

    /**
     * Required - The <code>metric_score</code>, found in the <code>metric_details</code> section, shows the contribution of this query to
     * the global quality metric score.
     * <p>
     * API name: {@code metric_score}
     * </p>
     */
    public final double metricScore() {
        return this.metricScore;
    }

    /**
     * Required - The <code>unrated_docs</code> section contains an <code>_index</code> and <code>_id</code> entry for each document that
     * didn't have a <code>ratings</code> value. This can be used to ask the user to supply ratings for these documents.
     * <p>
     * API name: {@code unrated_docs}
     * </p>
     */
    @Nonnull
    public final List<UnratedDocument> unratedDocs() {
        return this.unratedDocs;
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
        generator.writeKey("hits");
        generator.writeStartArray();
        for (RankEvalHitItem item0 : this.hits) {
            item0.serialize(generator, mapper);
        }
        generator.writeEnd();

        generator.writeKey("metric_details");
        generator.writeStartObject();
        for (Map.Entry<String, Map<String, JsonData>> item0 : this.metricDetails.entrySet()) {
            generator.writeKey(item0.getKey());
            generator.writeStartObject();
            for (Map.Entry<String, JsonData> item1 : item0.getValue().entrySet()) {
                generator.writeKey(item1.getKey());
                item1.getValue().serialize(generator, mapper);
            }
            generator.writeEnd();
        }
        generator.writeEnd();

        generator.writeKey("metric_score");
        generator.write(this.metricScore);

        generator.writeKey("unrated_docs");
        generator.writeStartArray();
        for (UnratedDocument item0 : this.unratedDocs) {
            item0.serialize(generator, mapper);
        }
        generator.writeEnd();
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
     * Builder for {@link RankEvalMetricDetail}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, RankEvalMetricDetail> {
        private List<RankEvalHitItem> hits;
        private Map<String, Map<String, JsonData>> metricDetails;
        private Double metricScore;
        private List<UnratedDocument> unratedDocs;

        public Builder() {}

        private Builder(RankEvalMetricDetail o) {
            this.hits = _listCopy(o.hits);
            this.metricDetails = _mapCopy(o.metricDetails);
            this.metricScore = o.metricScore;
            this.unratedDocs = _listCopy(o.unratedDocs);
        }

        private Builder(Builder o) {
            this.hits = _listCopy(o.hits);
            this.metricDetails = _mapCopy(o.metricDetails);
            this.metricScore = o.metricScore;
            this.unratedDocs = _listCopy(o.unratedDocs);
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - The <code>hits</code> section provides a grouping of the search results with their supplied ratings.
         * <p>
         * API name: {@code hits}
         * </p>
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>hits</code>.
         * </p>
         */
        @Nonnull
        public final Builder hits(List<RankEvalHitItem> list) {
            this.hits = _listAddAll(this.hits, list);
            return this;
        }

        /**
         * Required - The <code>hits</code> section provides a grouping of the search results with their supplied ratings.
         * <p>
         * API name: {@code hits}
         * </p>
         *
         * <p>
         * Adds one or more values to <code>hits</code>.
         * </p>
         */
        @Nonnull
        public final Builder hits(RankEvalHitItem value, RankEvalHitItem... values) {
            this.hits = _listAdd(this.hits, value, values);
            return this;
        }

        /**
         * Required - The <code>hits</code> section provides a grouping of the search results with their supplied ratings.
         * <p>
         * API name: {@code hits}
         * </p>
         *
         * <p>
         * Adds a value to <code>hits</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder hits(Function<RankEvalHitItem.Builder, ObjectBuilder<RankEvalHitItem>> fn) {
            return hits(fn.apply(new RankEvalHitItem.Builder()).build());
        }

        /**
         * Required - The <code>metric_details</code> section provides additional information about the calculated quality metric indicating
         * the number of relevant retrieved documents. The content varies for each metric but allows for better interpretation of the
         * results.
         * <p>
         * API name: {@code metric_details}
         * </p>
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>metricDetails</code>.
         * </p>
         */
        @Nonnull
        public final Builder metricDetails(Map<String, Map<String, JsonData>> map) {
            this.metricDetails = _mapPutAll(this.metricDetails, map);
            return this;
        }

        /**
         * Required - The <code>metric_details</code> section provides additional information about the calculated quality metric indicating
         * the number of relevant retrieved documents. The content varies for each metric but allows for better interpretation of the
         * results.
         * <p>
         * API name: {@code metric_details}
         * </p>
         *
         * <p>
         * Adds an entry to <code>metricDetails</code>.
         * </p>
         */
        @Nonnull
        public final Builder metricDetails(String key, Map<String, JsonData> value) {
            this.metricDetails = _mapPut(this.metricDetails, key, value);
            return this;
        }

        /**
         * Required - The <code>metric_score</code>, found in the <code>metric_details</code> section, shows the contribution of this query
         * to the global quality metric score.
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
         * Required - The <code>unrated_docs</code> section contains an <code>_index</code> and <code>_id</code> entry for each document
         * that didn't have a <code>ratings</code> value. This can be used to ask the user to supply ratings for these documents.
         * <p>
         * API name: {@code unrated_docs}
         * </p>
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>unratedDocs</code>.
         * </p>
         */
        @Nonnull
        public final Builder unratedDocs(List<UnratedDocument> list) {
            this.unratedDocs = _listAddAll(this.unratedDocs, list);
            return this;
        }

        /**
         * Required - The <code>unrated_docs</code> section contains an <code>_index</code> and <code>_id</code> entry for each document
         * that didn't have a <code>ratings</code> value. This can be used to ask the user to supply ratings for these documents.
         * <p>
         * API name: {@code unrated_docs}
         * </p>
         *
         * <p>
         * Adds one or more values to <code>unratedDocs</code>.
         * </p>
         */
        @Nonnull
        public final Builder unratedDocs(UnratedDocument value, UnratedDocument... values) {
            this.unratedDocs = _listAdd(this.unratedDocs, value, values);
            return this;
        }

        /**
         * Required - The <code>unrated_docs</code> section contains an <code>_index</code> and <code>_id</code> entry for each document
         * that didn't have a <code>ratings</code> value. This can be used to ask the user to supply ratings for these documents.
         * <p>
         * API name: {@code unrated_docs}
         * </p>
         *
         * <p>
         * Adds a value to <code>unratedDocs</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder unratedDocs(Function<UnratedDocument.Builder, ObjectBuilder<UnratedDocument>> fn) {
            return unratedDocs(fn.apply(new UnratedDocument.Builder()).build());
        }

        /**
         * Builds a {@link RankEvalMetricDetail}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public RankEvalMetricDetail build() {
            _checkSingleUse();

            return new RankEvalMetricDetail(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link RankEvalMetricDetail}
     */
    public static final JsonpDeserializer<RankEvalMetricDetail> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        RankEvalMetricDetail::setupRankEvalMetricDetailDeserializer
    );

    protected static void setupRankEvalMetricDetailDeserializer(ObjectDeserializer<RankEvalMetricDetail.Builder> op) {
        op.add(Builder::hits, JsonpDeserializer.arrayDeserializer(RankEvalHitItem._DESERIALIZER), "hits");
        op.add(
            Builder::metricDetails,
            JsonpDeserializer.stringMapDeserializer(JsonpDeserializer.stringMapDeserializer(JsonData._DESERIALIZER)),
            "metric_details"
        );
        op.add(Builder::metricScore, JsonpDeserializer.doubleDeserializer(), "metric_score");
        op.add(Builder::unratedDocs, JsonpDeserializer.arrayDeserializer(UnratedDocument._DESERIALIZER), "unrated_docs");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.hits.hashCode();
        result = 31 * result + this.metricDetails.hashCode();
        result = 31 * result + Double.hashCode(this.metricScore);
        result = 31 * result + this.unratedDocs.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        RankEvalMetricDetail other = (RankEvalMetricDetail) o;
        return this.hits.equals(other.hits)
            && this.metricDetails.equals(other.metricDetails)
            && this.metricScore == other.metricScore
            && this.unratedDocs.equals(other.unratedDocs);
    }
}
