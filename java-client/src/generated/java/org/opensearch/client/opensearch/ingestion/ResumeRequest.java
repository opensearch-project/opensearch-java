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

package org.opensearch.client.opensearch.ingestion;

import jakarta.json.stream.JsonGenerator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.opensearch.client.json.JsonpDeserializable;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.ObjectBuilderDeserializer;
import org.opensearch.client.json.ObjectDeserializer;
import org.opensearch.client.json.PlainJsonSerializable;
import org.opensearch.client.opensearch._types.ErrorResponse;
import org.opensearch.client.opensearch._types.RequestBase;
import org.opensearch.client.opensearch._types.Time;
import org.opensearch.client.transport.Endpoint;
import org.opensearch.client.transport.endpoints.SimpleEndpoint;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: ingestion.resume.Request

/**
 * Use this API to resume ingestion for the given index.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public final class ResumeRequest extends RequestBase
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<ResumeRequest.Builder, ResumeRequest> {

    @Nullable
    private final Time clusterManagerTimeout;

    @Nonnull
    private final String index;

    @Nonnull
    private final List<ResetSettings> resetSettings;

    @Nullable
    private final Time timeout;

    // ---------------------------------------------------------------------------------------------

    private ResumeRequest(Builder builder) {
        super(builder);
        this.clusterManagerTimeout = builder.clusterManagerTimeout;
        this.index = ApiTypeHelper.requireNonNull(builder.index, this, "index");
        this.resetSettings = ApiTypeHelper.unmodifiable(builder.resetSettings);
        this.timeout = builder.timeout;
    }

    public static ResumeRequest of(Function<ResumeRequest.Builder, ObjectBuilder<ResumeRequest>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Time to wait for cluster manager connection.
     * <p>
     * API name: {@code cluster_manager_timeout}
     * </p>
     */
    @Nullable
    public final Time clusterManagerTimeout() {
        return this.clusterManagerTimeout;
    }

    /**
     * Required - Index for which ingestion should be resumed.
     * <p>
     * API name: {@code index}
     * </p>
     */
    @Nonnull
    public final String index() {
        return this.index;
    }

    /**
     * Reset settings to be applied before resuming ingestion on a shard. This is optional.
     * <p>
     * API name: {@code reset_settings}
     * </p>
     */
    @Nonnull
    public final List<ResetSettings> resetSettings() {
        return this.resetSettings;
    }

    /**
     * Timeout for the request.
     * <p>
     * API name: {@code timeout}
     * </p>
     */
    @Nullable
    public final Time timeout() {
        return this.timeout;
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
        if (ApiTypeHelper.isDefined(this.resetSettings)) {
            generator.writeKey("reset_settings");
            generator.writeStartArray();
            for (ResetSettings item0 : this.resetSettings) {
                item0.serialize(generator, mapper);
            }
            generator.writeEnd();
        }
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
     * Builder for {@link ResumeRequest}.
     */
    public static class Builder extends RequestBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, ResumeRequest> {
        @Nullable
        private Time clusterManagerTimeout;
        private String index;
        @Nullable
        private List<ResetSettings> resetSettings;
        @Nullable
        private Time timeout;

        public Builder() {}

        private Builder(ResumeRequest o) {
            super(o);
            this.clusterManagerTimeout = o.clusterManagerTimeout;
            this.index = o.index;
            this.resetSettings = _listCopy(o.resetSettings);
            this.timeout = o.timeout;
        }

        private Builder(Builder o) {
            super(o);
            this.clusterManagerTimeout = o.clusterManagerTimeout;
            this.index = o.index;
            this.resetSettings = _listCopy(o.resetSettings);
            this.timeout = o.timeout;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        @Override
        @Nonnull
        protected Builder self() {
            return this;
        }

        /**
         * Time to wait for cluster manager connection.
         * <p>
         * API name: {@code cluster_manager_timeout}
         * </p>
         */
        @Nonnull
        public final Builder clusterManagerTimeout(@Nullable Time value) {
            this.clusterManagerTimeout = value;
            return this;
        }

        /**
         * Time to wait for cluster manager connection.
         * <p>
         * API name: {@code cluster_manager_timeout}
         * </p>
         */
        @Nonnull
        public final Builder clusterManagerTimeout(Function<Time.Builder, ObjectBuilder<Time>> fn) {
            return clusterManagerTimeout(fn.apply(new Time.Builder()).build());
        }

        /**
         * Required - Index for which ingestion should be resumed.
         * <p>
         * API name: {@code index}
         * </p>
         */
        @Nonnull
        public final Builder index(String value) {
            this.index = value;
            return this;
        }

        /**
         * Reset settings to be applied before resuming ingestion on a shard. This is optional.
         * <p>
         * API name: {@code reset_settings}
         * </p>
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>resetSettings</code>.
         * </p>
         */
        @Nonnull
        public final Builder resetSettings(List<ResetSettings> list) {
            this.resetSettings = _listAddAll(this.resetSettings, list);
            return this;
        }

        /**
         * Reset settings to be applied before resuming ingestion on a shard. This is optional.
         * <p>
         * API name: {@code reset_settings}
         * </p>
         *
         * <p>
         * Adds one or more values to <code>resetSettings</code>.
         * </p>
         */
        @Nonnull
        public final Builder resetSettings(ResetSettings value, ResetSettings... values) {
            this.resetSettings = _listAdd(this.resetSettings, value, values);
            return this;
        }

        /**
         * Reset settings to be applied before resuming ingestion on a shard. This is optional.
         * <p>
         * API name: {@code reset_settings}
         * </p>
         *
         * <p>
         * Adds a value to <code>resetSettings</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder resetSettings(Function<ResetSettings.Builder, ObjectBuilder<ResetSettings>> fn) {
            return resetSettings(fn.apply(new ResetSettings.Builder()).build());
        }

        /**
         * Timeout for the request.
         * <p>
         * API name: {@code timeout}
         * </p>
         */
        @Nonnull
        public final Builder timeout(@Nullable Time value) {
            this.timeout = value;
            return this;
        }

        /**
         * Timeout for the request.
         * <p>
         * API name: {@code timeout}
         * </p>
         */
        @Nonnull
        public final Builder timeout(Function<Time.Builder, ObjectBuilder<Time>> fn) {
            return timeout(fn.apply(new Time.Builder()).build());
        }

        /**
         * Builds a {@link ResumeRequest}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public ResumeRequest build() {
            _checkSingleUse();

            return new ResumeRequest(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link ResumeRequest}
     */
    public static final JsonpDeserializer<ResumeRequest> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        ResumeRequest::setupResumeRequestDeserializer
    );

    protected static void setupResumeRequestDeserializer(ObjectDeserializer<ResumeRequest.Builder> op) {
        op.add(Builder::resetSettings, JsonpDeserializer.arrayDeserializer(ResetSettings._DESERIALIZER), "reset_settings");
    }

    // ---------------------------------------------------------------------------------------------

    @Override
    protected void applyQueryParameters(@Nonnull Map<String, String> params) {
        super.applyQueryParameters(params);
        if (this.clusterManagerTimeout != null) {
            params.put("cluster_manager_timeout", this.clusterManagerTimeout._toJsonString());
        }
        if (this.timeout != null) {
            params.put("timeout", this.timeout._toJsonString());
        }
    }

    /**
     * Endpoint "{@code ingestion.resume}".
     */
    public static final Endpoint<ResumeRequest, ResumeResponse, ErrorResponse> _ENDPOINT = new SimpleEndpoint<>(
        // Request method
        request -> "POST",
        // Request path
        request -> {
            StringBuilder buf = new StringBuilder();
            buf.append("/");
            SimpleEndpoint.pathEncode(request.index, buf);
            buf.append("/ingestion/_resume");
            return buf.toString();
        },
        // Request parameters
        request -> {
            Map<String, String> params = new HashMap<>();
            request.applyQueryParameters(params);
            return params;
        },
        SimpleEndpoint.emptyMap(),
        true,
        ResumeResponse._DESERIALIZER
    );

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.clusterManagerTimeout);
        result = 31 * result + this.index.hashCode();
        result = 31 * result + Objects.hashCode(this.resetSettings);
        result = 31 * result + Objects.hashCode(this.timeout);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        ResumeRequest other = (ResumeRequest) o;
        return Objects.equals(this.clusterManagerTimeout, other.clusterManagerTimeout)
            && this.index.equals(other.index)
            && Objects.equals(this.resetSettings, other.resetSettings)
            && Objects.equals(this.timeout, other.timeout);
    }
}
