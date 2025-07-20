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

package org.opensearch.client.opensearch.geospatial;

import jakarta.json.stream.JsonGenerator;
import java.util.List;
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
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

// typedef: geospatial.get_upload_stats.Response

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class GetUploadStatsResponse
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<GetUploadStatsResponse.Builder, GetUploadStatsResponse> {

    @Nonnull
    private final List<UploadStatsMetric> metrics;

    @Nonnull
    private final UploadStatsTotal total;

    // ---------------------------------------------------------------------------------------------

    private GetUploadStatsResponse(Builder builder) {
        this.metrics = ApiTypeHelper.unmodifiableRequired(builder.metrics, this, "metrics");
        this.total = ApiTypeHelper.requireNonNull(builder.total, this, "total");
    }

    public static GetUploadStatsResponse of(Function<GetUploadStatsResponse.Builder, ObjectBuilder<GetUploadStatsResponse>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - API name: {@code metrics}
     */
    @Nonnull
    public final List<UploadStatsMetric> metrics() {
        return this.metrics;
    }

    /**
     * Required - API name: {@code total}
     */
    @Nonnull
    public final UploadStatsTotal total() {
        return this.total;
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
        generator.writeKey("metrics");
        generator.writeStartArray();
        for (UploadStatsMetric item0 : this.metrics) {
            item0.serialize(generator, mapper);
        }
        generator.writeEnd();

        generator.writeKey("total");
        this.total.serialize(generator, mapper);
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
     * Builder for {@link GetUploadStatsResponse}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, GetUploadStatsResponse> {
        private List<UploadStatsMetric> metrics;
        private UploadStatsTotal total;

        public Builder() {}

        private Builder(GetUploadStatsResponse o) {
            this.metrics = _listCopy(o.metrics);
            this.total = o.total;
        }

        private Builder(Builder o) {
            this.metrics = _listCopy(o.metrics);
            this.total = o.total;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - API name: {@code metrics}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>metrics</code>.
         * </p>
         */
        @Nonnull
        public final Builder metrics(List<UploadStatsMetric> list) {
            this.metrics = _listAddAll(this.metrics, list);
            return this;
        }

        /**
         * Required - API name: {@code metrics}
         *
         * <p>
         * Adds one or more values to <code>metrics</code>.
         * </p>
         */
        @Nonnull
        public final Builder metrics(UploadStatsMetric value, UploadStatsMetric... values) {
            this.metrics = _listAdd(this.metrics, value, values);
            return this;
        }

        /**
         * Required - API name: {@code metrics}
         *
         * <p>
         * Adds a value to <code>metrics</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder metrics(Function<UploadStatsMetric.Builder, ObjectBuilder<UploadStatsMetric>> fn) {
            return metrics(fn.apply(new UploadStatsMetric.Builder()).build());
        }

        /**
         * Required - API name: {@code total}
         */
        @Nonnull
        public final Builder total(UploadStatsTotal value) {
            this.total = value;
            return this;
        }

        /**
         * Required - API name: {@code total}
         */
        @Nonnull
        public final Builder total(Function<UploadStatsTotal.Builder, ObjectBuilder<UploadStatsTotal>> fn) {
            return total(fn.apply(new UploadStatsTotal.Builder()).build());
        }

        /**
         * Builds a {@link GetUploadStatsResponse}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public GetUploadStatsResponse build() {
            _checkSingleUse();

            return new GetUploadStatsResponse(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link GetUploadStatsResponse}
     */
    public static final JsonpDeserializer<GetUploadStatsResponse> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        GetUploadStatsResponse::setupGetUploadStatsResponseDeserializer
    );

    protected static void setupGetUploadStatsResponseDeserializer(ObjectDeserializer<GetUploadStatsResponse.Builder> op) {
        op.add(Builder::metrics, JsonpDeserializer.arrayDeserializer(UploadStatsMetric._DESERIALIZER), "metrics");
        op.add(Builder::total, UploadStatsTotal._DESERIALIZER, "total");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.metrics.hashCode();
        result = 31 * result + this.total.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        GetUploadStatsResponse other = (GetUploadStatsResponse) o;
        return this.metrics.equals(other.metrics) && this.total.equals(other.total);
    }
}
