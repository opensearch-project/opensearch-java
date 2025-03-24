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
import org.opensearch.client.json.JsonpDeserializable;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.ObjectBuilderDeserializer;
import org.opensearch.client.json.ObjectDeserializer;
import org.opensearch.client.json.PlainJsonSerializable;
import org.opensearch.client.opensearch._types.ErrorResponse;
import org.opensearch.client.opensearch._types.RequestBase;
import org.opensearch.client.opensearch.ingest.simulate.Document;
import org.opensearch.client.transport.Endpoint;
import org.opensearch.client.transport.endpoints.SimpleEndpoint;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: ingest.simulate.Request

/**
 * Simulates an ingest pipeline with example documents.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public final class SimulateRequest extends RequestBase
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<SimulateRequest.Builder, SimulateRequest> {

    @Nonnull
    private final List<Document> docs;

    @Nullable
    private final String id;

    @Nullable
    private final Pipeline pipeline;

    @Nullable
    private final Boolean verbose;

    // ---------------------------------------------------------------------------------------------

    private SimulateRequest(Builder builder) {
        super(builder);
        this.docs = ApiTypeHelper.unmodifiable(builder.docs);
        this.id = builder.id;
        this.pipeline = builder.pipeline;
        this.verbose = builder.verbose;
    }

    public static SimulateRequest of(Function<SimulateRequest.Builder, ObjectBuilder<SimulateRequest>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * A list of sample documents to test in the pipeline.
     * <p>
     * API name: {@code docs}
     * </p>
     */
    @Nonnull
    public final List<Document> docs() {
        return this.docs;
    }

    /**
     * The pipeline to test. If you don't specify a <code>pipeline</code> in the request body, this parameter is required.
     * <p>
     * API name: {@code id}
     * </p>
     */
    @Nullable
    public final String id() {
        return this.id;
    }

    /**
     * API name: {@code pipeline}
     */
    @Nullable
    public final Pipeline pipeline() {
        return this.pipeline;
    }

    /**
     * When <code>true</code>, the response includes output data for each processor in the pipeline
     * <p>
     * API name: {@code verbose}
     * </p>
     */
    @Nullable
    public final Boolean verbose() {
        return this.verbose;
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
        if (ApiTypeHelper.isDefined(this.docs)) {
            generator.writeKey("docs");
            generator.writeStartArray();
            for (Document item0 : this.docs) {
                item0.serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        if (this.pipeline != null) {
            generator.writeKey("pipeline");
            this.pipeline.serialize(generator, mapper);
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
     * Builder for {@link SimulateRequest}.
     */
    public static class Builder extends RequestBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, SimulateRequest> {
        @Nullable
        private List<Document> docs;
        @Nullable
        private String id;
        @Nullable
        private Pipeline pipeline;
        @Nullable
        private Boolean verbose;

        public Builder() {}

        private Builder(SimulateRequest o) {
            super(o);
            this.docs = _listCopy(o.docs);
            this.id = o.id;
            this.pipeline = o.pipeline;
            this.verbose = o.verbose;
        }

        private Builder(Builder o) {
            super(o);
            this.docs = _listCopy(o.docs);
            this.id = o.id;
            this.pipeline = o.pipeline;
            this.verbose = o.verbose;
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
         * A list of sample documents to test in the pipeline.
         * <p>
         * API name: {@code docs}
         * </p>
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>docs</code>.
         * </p>
         */
        @Nonnull
        public final Builder docs(List<Document> list) {
            this.docs = _listAddAll(this.docs, list);
            return this;
        }

        /**
         * A list of sample documents to test in the pipeline.
         * <p>
         * API name: {@code docs}
         * </p>
         *
         * <p>
         * Adds one or more values to <code>docs</code>.
         * </p>
         */
        @Nonnull
        public final Builder docs(Document value, Document... values) {
            this.docs = _listAdd(this.docs, value, values);
            return this;
        }

        /**
         * A list of sample documents to test in the pipeline.
         * <p>
         * API name: {@code docs}
         * </p>
         *
         * <p>
         * Adds a value to <code>docs</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder docs(Function<Document.Builder, ObjectBuilder<Document>> fn) {
            return docs(fn.apply(new Document.Builder()).build());
        }

        /**
         * The pipeline to test. If you don't specify a <code>pipeline</code> in the request body, this parameter is required.
         * <p>
         * API name: {@code id}
         * </p>
         */
        @Nonnull
        public final Builder id(@Nullable String value) {
            this.id = value;
            return this;
        }

        /**
         * API name: {@code pipeline}
         */
        @Nonnull
        public final Builder pipeline(@Nullable Pipeline value) {
            this.pipeline = value;
            return this;
        }

        /**
         * API name: {@code pipeline}
         */
        @Nonnull
        public final Builder pipeline(Function<Pipeline.Builder, ObjectBuilder<Pipeline>> fn) {
            return pipeline(fn.apply(new Pipeline.Builder()).build());
        }

        /**
         * When <code>true</code>, the response includes output data for each processor in the pipeline
         * <p>
         * API name: {@code verbose}
         * </p>
         */
        @Nonnull
        public final Builder verbose(@Nullable Boolean value) {
            this.verbose = value;
            return this;
        }

        /**
         * Builds a {@link SimulateRequest}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public SimulateRequest build() {
            _checkSingleUse();

            return new SimulateRequest(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link SimulateRequest}
     */
    public static final JsonpDeserializer<SimulateRequest> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        SimulateRequest::setupSimulateRequestDeserializer
    );

    protected static void setupSimulateRequestDeserializer(ObjectDeserializer<SimulateRequest.Builder> op) {
        op.add(Builder::docs, JsonpDeserializer.arrayDeserializer(Document._DESERIALIZER), "docs");
        op.add(Builder::pipeline, Pipeline._DESERIALIZER, "pipeline");
    }

    // ---------------------------------------------------------------------------------------------

    @Override
    protected void applyQueryParameters(@Nonnull Map<String, String> params) {
        super.applyQueryParameters(params);
        if (this.verbose != null) {
            params.put("verbose", String.valueOf(this.verbose));
        }
    }

    /**
     * Endpoint "{@code ingest.simulate}".
     */
    public static final Endpoint<SimulateRequest, SimulateResponse, ErrorResponse> _ENDPOINT = new SimpleEndpoint<>(
        // Request method
        request -> "POST",
        // Request path
        request -> {
            final int _id = 1 << 0;

            int propsSet = 0;

            if (request.id() != null) propsSet |= _id;

            if (propsSet == 0) {
                return "/_ingest/pipeline/_simulate";
            }
            if (propsSet == (_id)) {
                StringBuilder buf = new StringBuilder();
                buf.append("/_ingest/pipeline/");
                SimpleEndpoint.pathEncode(request.id, buf);
                buf.append("/_simulate");
                return buf.toString();
            }

            throw SimpleEndpoint.noPathTemplateFound("path");
        },
        // Request parameters
        request -> {
            Map<String, String> params = new HashMap<>();
            request.applyQueryParameters(params);
            return params;
        },
        SimpleEndpoint.emptyMap(),
        true,
        SimulateResponse._DESERIALIZER
    );

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.docs);
        result = 31 * result + Objects.hashCode(this.id);
        result = 31 * result + Objects.hashCode(this.pipeline);
        result = 31 * result + Objects.hashCode(this.verbose);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        SimulateRequest other = (SimulateRequest) o;
        return Objects.equals(this.docs, other.docs)
            && Objects.equals(this.id, other.id)
            && Objects.equals(this.pipeline, other.pipeline)
            && Objects.equals(this.verbose, other.verbose);
    }
}
