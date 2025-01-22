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

package org.opensearch.client.opensearch.ingest;

import jakarta.json.stream.JsonGenerator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.opensearch.client.json.JsonData;
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

// typedef: ingest.put_pipeline.Request

/**
 * Creates or updates a pipeline.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public final class PutPipelineRequest extends RequestBase
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<PutPipelineRequest.Builder, PutPipelineRequest> {

    @Nullable
    private final Time clusterManagerTimeout;

    @Nullable
    private final String description;

    @Nonnull
    private final String id;

    @Deprecated
    @Nullable
    private final Time masterTimeout;

    @Nonnull
    private final Map<String, JsonData> meta;

    @Nonnull
    private final List<Processor> onFailure;

    @Nonnull
    private final List<Processor> processors;

    @Nullable
    private final Time timeout;

    @Nullable
    private final Long version;

    // ---------------------------------------------------------------------------------------------

    private PutPipelineRequest(Builder builder) {
        super(builder);
        this.clusterManagerTimeout = builder.clusterManagerTimeout;
        this.description = builder.description;
        this.id = ApiTypeHelper.requireNonNull(builder.id, this, "id");
        this.masterTimeout = builder.masterTimeout;
        this.meta = ApiTypeHelper.unmodifiable(builder.meta);
        this.onFailure = ApiTypeHelper.unmodifiable(builder.onFailure);
        this.processors = ApiTypeHelper.unmodifiable(builder.processors);
        this.timeout = builder.timeout;
        this.version = builder.version;
    }

    public static PutPipelineRequest of(Function<PutPipelineRequest.Builder, ObjectBuilder<PutPipelineRequest>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Operation timeout for connection to cluster-manager node.
     * <p>
     * API name: {@code cluster_manager_timeout}
     * </p>
     */
    @Nullable
    public final Time clusterManagerTimeout() {
        return this.clusterManagerTimeout;
    }

    /**
     * Description of the ingest pipeline.
     * <p>
     * API name: {@code description}
     * </p>
     */
    @Nullable
    public final String description() {
        return this.description;
    }

    /**
     * Required - ID of the ingest pipeline to create or update.
     * <p>
     * API name: {@code id}
     * </p>
     */
    @Nonnull
    public final String id() {
        return this.id;
    }

    /**
     * Period to wait for a connection to the cluster-manager node. If no response is received before the timeout expires, the request fails
     * and returns an error.
     * <p>
     * API name: {@code master_timeout}
     * </p>
     */
    @Deprecated
    @Nullable
    public final Time masterTimeout() {
        return this.masterTimeout;
    }

    /**
     * API name: {@code _meta}
     */
    @Nonnull
    public final Map<String, JsonData> meta() {
        return this.meta;
    }

    /**
     * Processors to run immediately after a processor failure. Each processor supports a processor-level <code>on_failure</code> value. If
     * a processor without an <code>on_failure</code> value fails, OpenSearch uses this pipeline-level parameter as a fallback. The
     * processors in this parameter run sequentially in the order specified. OpenSearch will not attempt to run the pipeline's remaining
     * processors.
     * <p>
     * API name: {@code on_failure}
     * </p>
     */
    @Nonnull
    public final List<Processor> onFailure() {
        return this.onFailure;
    }

    /**
     * Processors used to perform transformations on documents before indexing. Processors run sequentially in the order specified.
     * <p>
     * API name: {@code processors}
     * </p>
     */
    @Nonnull
    public final List<Processor> processors() {
        return this.processors;
    }

    /**
     * Period to wait for a response. If no response is received before the timeout expires, the request fails and returns an error.
     * <p>
     * API name: {@code timeout}
     * </p>
     */
    @Nullable
    public final Time timeout() {
        return this.timeout;
    }

    /**
     * API name: {@code version}
     */
    @Nullable
    public final Long version() {
        return this.version;
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
        if (this.description != null) {
            generator.writeKey("description");
            generator.write(this.description);
        }

        if (ApiTypeHelper.isDefined(this.meta)) {
            generator.writeKey("_meta");
            generator.writeStartObject();
            for (Map.Entry<String, JsonData> item0 : this.meta.entrySet()) {
                generator.writeKey(item0.getKey());
                item0.getValue().serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        if (ApiTypeHelper.isDefined(this.onFailure)) {
            generator.writeKey("on_failure");
            generator.writeStartArray();
            for (Processor item0 : this.onFailure) {
                item0.serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        if (ApiTypeHelper.isDefined(this.processors)) {
            generator.writeKey("processors");
            generator.writeStartArray();
            for (Processor item0 : this.processors) {
                item0.serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        if (this.version != null) {
            generator.writeKey("version");
            generator.write(this.version);
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
     * Builder for {@link PutPipelineRequest}.
     */
    public static class Builder extends RequestBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, PutPipelineRequest> {
        @Nullable
        private Time clusterManagerTimeout;
        @Nullable
        private String description;
        private String id;
        @Nullable
        private Time masterTimeout;
        @Nullable
        private Map<String, JsonData> meta;
        @Nullable
        private List<Processor> onFailure;
        @Nullable
        private List<Processor> processors;
        @Nullable
        private Time timeout;
        @Nullable
        private Long version;

        public Builder() {}

        private Builder(PutPipelineRequest o) {
            super(o);
            this.clusterManagerTimeout = o.clusterManagerTimeout;
            this.description = o.description;
            this.id = o.id;
            this.masterTimeout = o.masterTimeout;
            this.meta = _mapCopy(o.meta);
            this.onFailure = _listCopy(o.onFailure);
            this.processors = _listCopy(o.processors);
            this.timeout = o.timeout;
            this.version = o.version;
        }

        private Builder(Builder o) {
            super(o);
            this.clusterManagerTimeout = o.clusterManagerTimeout;
            this.description = o.description;
            this.id = o.id;
            this.masterTimeout = o.masterTimeout;
            this.meta = _mapCopy(o.meta);
            this.onFailure = _listCopy(o.onFailure);
            this.processors = _listCopy(o.processors);
            this.timeout = o.timeout;
            this.version = o.version;
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
         * Operation timeout for connection to cluster-manager node.
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
         * Operation timeout for connection to cluster-manager node.
         * <p>
         * API name: {@code cluster_manager_timeout}
         * </p>
         */
        @Nonnull
        public final Builder clusterManagerTimeout(Function<Time.Builder, ObjectBuilder<Time>> fn) {
            return clusterManagerTimeout(fn.apply(new Time.Builder()).build());
        }

        /**
         * Description of the ingest pipeline.
         * <p>
         * API name: {@code description}
         * </p>
         */
        @Nonnull
        public final Builder description(@Nullable String value) {
            this.description = value;
            return this;
        }

        /**
         * Required - ID of the ingest pipeline to create or update.
         * <p>
         * API name: {@code id}
         * </p>
         */
        @Nonnull
        public final Builder id(String value) {
            this.id = value;
            return this;
        }

        /**
         * Period to wait for a connection to the cluster-manager node. If no response is received before the timeout expires, the request
         * fails and returns an error.
         * <p>
         * API name: {@code master_timeout}
         * </p>
         */
        @Deprecated
        @Nonnull
        public final Builder masterTimeout(@Nullable Time value) {
            this.masterTimeout = value;
            return this;
        }

        /**
         * Period to wait for a connection to the cluster-manager node. If no response is received before the timeout expires, the request
         * fails and returns an error.
         * <p>
         * API name: {@code master_timeout}
         * </p>
         */
        @Deprecated
        @Nonnull
        public final Builder masterTimeout(Function<Time.Builder, ObjectBuilder<Time>> fn) {
            return masterTimeout(fn.apply(new Time.Builder()).build());
        }

        /**
         * API name: {@code _meta}
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>meta</code>.
         * </p>
         */
        @Nonnull
        public final Builder meta(Map<String, JsonData> map) {
            this.meta = _mapPutAll(this.meta, map);
            return this;
        }

        /**
         * API name: {@code _meta}
         *
         * <p>
         * Adds an entry to <code>meta</code>.
         * </p>
         */
        @Nonnull
        public final Builder meta(String key, JsonData value) {
            this.meta = _mapPut(this.meta, key, value);
            return this;
        }

        /**
         * Processors to run immediately after a processor failure. Each processor supports a processor-level <code>on_failure</code> value.
         * If a processor without an <code>on_failure</code> value fails, OpenSearch uses this pipeline-level parameter as a fallback. The
         * processors in this parameter run sequentially in the order specified. OpenSearch will not attempt to run the pipeline's remaining
         * processors.
         * <p>
         * API name: {@code on_failure}
         * </p>
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>onFailure</code>.
         * </p>
         */
        @Nonnull
        public final Builder onFailure(List<Processor> list) {
            this.onFailure = _listAddAll(this.onFailure, list);
            return this;
        }

        /**
         * Processors to run immediately after a processor failure. Each processor supports a processor-level <code>on_failure</code> value.
         * If a processor without an <code>on_failure</code> value fails, OpenSearch uses this pipeline-level parameter as a fallback. The
         * processors in this parameter run sequentially in the order specified. OpenSearch will not attempt to run the pipeline's remaining
         * processors.
         * <p>
         * API name: {@code on_failure}
         * </p>
         *
         * <p>
         * Adds one or more values to <code>onFailure</code>.
         * </p>
         */
        @Nonnull
        public final Builder onFailure(Processor value, Processor... values) {
            this.onFailure = _listAdd(this.onFailure, value, values);
            return this;
        }

        /**
         * Processors to run immediately after a processor failure. Each processor supports a processor-level <code>on_failure</code> value.
         * If a processor without an <code>on_failure</code> value fails, OpenSearch uses this pipeline-level parameter as a fallback. The
         * processors in this parameter run sequentially in the order specified. OpenSearch will not attempt to run the pipeline's remaining
         * processors.
         * <p>
         * API name: {@code on_failure}
         * </p>
         *
         * <p>
         * Adds a value to <code>onFailure</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder onFailure(Function<Processor.Builder, ObjectBuilder<Processor>> fn) {
            return onFailure(fn.apply(new Processor.Builder()).build());
        }

        /**
         * Processors used to perform transformations on documents before indexing. Processors run sequentially in the order specified.
         * <p>
         * API name: {@code processors}
         * </p>
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>processors</code>.
         * </p>
         */
        @Nonnull
        public final Builder processors(List<Processor> list) {
            this.processors = _listAddAll(this.processors, list);
            return this;
        }

        /**
         * Processors used to perform transformations on documents before indexing. Processors run sequentially in the order specified.
         * <p>
         * API name: {@code processors}
         * </p>
         *
         * <p>
         * Adds one or more values to <code>processors</code>.
         * </p>
         */
        @Nonnull
        public final Builder processors(Processor value, Processor... values) {
            this.processors = _listAdd(this.processors, value, values);
            return this;
        }

        /**
         * Processors used to perform transformations on documents before indexing. Processors run sequentially in the order specified.
         * <p>
         * API name: {@code processors}
         * </p>
         *
         * <p>
         * Adds a value to <code>processors</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder processors(Function<Processor.Builder, ObjectBuilder<Processor>> fn) {
            return processors(fn.apply(new Processor.Builder()).build());
        }

        /**
         * Period to wait for a response. If no response is received before the timeout expires, the request fails and returns an error.
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
         * Period to wait for a response. If no response is received before the timeout expires, the request fails and returns an error.
         * <p>
         * API name: {@code timeout}
         * </p>
         */
        @Nonnull
        public final Builder timeout(Function<Time.Builder, ObjectBuilder<Time>> fn) {
            return timeout(fn.apply(new Time.Builder()).build());
        }

        /**
         * API name: {@code version}
         */
        @Nonnull
        public final Builder version(@Nullable Long value) {
            this.version = value;
            return this;
        }

        /**
         * Builds a {@link PutPipelineRequest}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public PutPipelineRequest build() {
            _checkSingleUse();

            return new PutPipelineRequest(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link PutPipelineRequest}
     */
    public static final JsonpDeserializer<PutPipelineRequest> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        PutPipelineRequest::setupPutPipelineRequestDeserializer
    );

    protected static void setupPutPipelineRequestDeserializer(ObjectDeserializer<PutPipelineRequest.Builder> op) {
        op.add(Builder::description, JsonpDeserializer.stringDeserializer(), "description");
        op.add(Builder::meta, JsonpDeserializer.stringMapDeserializer(JsonData._DESERIALIZER), "_meta");
        op.add(Builder::onFailure, JsonpDeserializer.arrayDeserializer(Processor._DESERIALIZER), "on_failure");
        op.add(Builder::processors, JsonpDeserializer.arrayDeserializer(Processor._DESERIALIZER), "processors");
        op.add(Builder::version, JsonpDeserializer.longDeserializer(), "version");
    }

    // ---------------------------------------------------------------------------------------------

    @Override
    protected void applyQueryParameters(@Nonnull Map<String, String> params) {
        super.applyQueryParameters(params);
        if (this.clusterManagerTimeout != null) {
            params.put("cluster_manager_timeout", this.clusterManagerTimeout._toJsonString());
        }
        if (this.masterTimeout != null) {
            params.put("master_timeout", this.masterTimeout._toJsonString());
        }
        if (this.timeout != null) {
            params.put("timeout", this.timeout._toJsonString());
        }
    }

    /**
     * Endpoint "{@code ingest.put_pipeline}".
     */
    public static final Endpoint<PutPipelineRequest, PutPipelineResponse, ErrorResponse> _ENDPOINT = new SimpleEndpoint<>(
        // Request method
        request -> "PUT",
        // Request path
        request -> {
            StringBuilder buf = new StringBuilder();
            buf.append("/_ingest/pipeline/");
            SimpleEndpoint.pathEncode(request.id, buf);
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
        PutPipelineResponse._DESERIALIZER
    );

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.clusterManagerTimeout);
        result = 31 * result + Objects.hashCode(this.description);
        result = 31 * result + this.id.hashCode();
        result = 31 * result + Objects.hashCode(this.masterTimeout);
        result = 31 * result + Objects.hashCode(this.meta);
        result = 31 * result + Objects.hashCode(this.onFailure);
        result = 31 * result + Objects.hashCode(this.processors);
        result = 31 * result + Objects.hashCode(this.timeout);
        result = 31 * result + Objects.hashCode(this.version);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        PutPipelineRequest other = (PutPipelineRequest) o;
        return Objects.equals(this.clusterManagerTimeout, other.clusterManagerTimeout)
            && Objects.equals(this.description, other.description)
            && this.id.equals(other.id)
            && Objects.equals(this.masterTimeout, other.masterTimeout)
            && Objects.equals(this.meta, other.meta)
            && Objects.equals(this.onFailure, other.onFailure)
            && Objects.equals(this.processors, other.processors)
            && Objects.equals(this.timeout, other.timeout)
            && Objects.equals(this.version, other.version);
    }
}
