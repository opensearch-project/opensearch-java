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

package org.opensearch.client.opensearch.search_relevance;

import jakarta.json.stream.JsonGenerator;
import java.util.HashMap;
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
import org.opensearch.client.transport.Endpoint;
import org.opensearch.client.transport.endpoints.SimpleEndpoint;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: search_relevance.post_scheduled_experiments.Request

/**
 * Creates a scheduled experiment.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public final class PostScheduledExperimentsRequest extends RequestBase
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<PostScheduledExperimentsRequest.Builder, PostScheduledExperimentsRequest> {

    @Nullable
    private final String cronExpression;

    @Nullable
    private final String experimentId;

    // ---------------------------------------------------------------------------------------------

    private PostScheduledExperimentsRequest(Builder builder) {
        super(builder);
        this.cronExpression = builder.cronExpression;
        this.experimentId = builder.experimentId;
    }

    public static PostScheduledExperimentsRequest of(
        Function<PostScheduledExperimentsRequest.Builder, ObjectBuilder<PostScheduledExperimentsRequest>> fn
    ) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code cronExpression}
     */
    @Nullable
    public final String cronExpression() {
        return this.cronExpression;
    }

    /**
     * API name: {@code experimentId}
     */
    @Nullable
    public final String experimentId() {
        return this.experimentId;
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
        if (this.cronExpression != null) {
            generator.writeKey("cronExpression");
            generator.write(this.cronExpression);
        }

        if (this.experimentId != null) {
            generator.writeKey("experimentId");
            generator.write(this.experimentId);
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
     * Builder for {@link PostScheduledExperimentsRequest}.
     */
    public static class Builder extends RequestBase.AbstractBuilder<Builder>
        implements
            CopyableBuilder<Builder, PostScheduledExperimentsRequest> {
        @Nullable
        private String cronExpression;
        @Nullable
        private String experimentId;

        public Builder() {}

        private Builder(PostScheduledExperimentsRequest o) {
            super(o);
            this.cronExpression = o.cronExpression;
            this.experimentId = o.experimentId;
        }

        private Builder(Builder o) {
            super(o);
            this.cronExpression = o.cronExpression;
            this.experimentId = o.experimentId;
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
         * API name: {@code cronExpression}
         */
        @Nonnull
        public final Builder cronExpression(@Nullable String value) {
            this.cronExpression = value;
            return this;
        }

        /**
         * API name: {@code experimentId}
         */
        @Nonnull
        public final Builder experimentId(@Nullable String value) {
            this.experimentId = value;
            return this;
        }

        /**
         * Builds a {@link PostScheduledExperimentsRequest}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public PostScheduledExperimentsRequest build() {
            _checkSingleUse();

            return new PostScheduledExperimentsRequest(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link PostScheduledExperimentsRequest}
     */
    public static final JsonpDeserializer<PostScheduledExperimentsRequest> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        PostScheduledExperimentsRequest::setupPostScheduledExperimentsRequestDeserializer
    );

    protected static void setupPostScheduledExperimentsRequestDeserializer(ObjectDeserializer<PostScheduledExperimentsRequest.Builder> op) {
        op.add(Builder::cronExpression, JsonpDeserializer.stringDeserializer(), "cronExpression");
        op.add(Builder::experimentId, JsonpDeserializer.stringDeserializer(), "experimentId");
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Endpoint "{@code search_relevance.post_scheduled_experiments}".
     */
    public static final Endpoint<PostScheduledExperimentsRequest, PostScheduledExperimentsResponse, ErrorResponse> _ENDPOINT =
        new SimpleEndpoint<>(
            // Request method
            request -> "POST",
            // Request path
            request -> "/_plugins/_search_relevance/experiments/schedule",
            // Request parameters
            request -> {
                Map<String, String> params = new HashMap<>();
                request.applyQueryParameters(params);
                return params;
            },
            SimpleEndpoint.emptyMap(),
            true,
            PostScheduledExperimentsResponse._DESERIALIZER
        );

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.cronExpression);
        result = 31 * result + Objects.hashCode(this.experimentId);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        PostScheduledExperimentsRequest other = (PostScheduledExperimentsRequest) o;
        return Objects.equals(this.cronExpression, other.cronExpression) && Objects.equals(this.experimentId, other.experimentId);
    }
}
