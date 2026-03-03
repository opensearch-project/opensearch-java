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

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import org.opensearch.client.opensearch._types.ErrorResponse;
import org.opensearch.client.opensearch._types.RequestBase;
import org.opensearch.client.transport.Endpoint;
import org.opensearch.client.transport.endpoints.SimpleEndpoint;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: search_relevance.delete_scheduled_experiments.Request

/**
 * Deletes a specified scheduled experiment.
 */
@Generated("org.opensearch.client.codegen.CodeGenerator")
public final class DeleteScheduledExperimentsRequest extends RequestBase
    implements
        ToCopyableBuilder<DeleteScheduledExperimentsRequest.Builder, DeleteScheduledExperimentsRequest> {

    @Nonnull
    private final String experimentId;

    // ---------------------------------------------------------------------------------------------

    private DeleteScheduledExperimentsRequest(Builder builder) {
        super(builder);
        this.experimentId = ApiTypeHelper.requireNonNull(builder.experimentId, this, "experimentId");
    }

    public static DeleteScheduledExperimentsRequest of(
        Function<DeleteScheduledExperimentsRequest.Builder, ObjectBuilder<DeleteScheduledExperimentsRequest>> fn
    ) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - The experiment id
     * <p>
     * API name: {@code experiment_id}
     * </p>
     */
    @Nonnull
    public final String experimentId() {
        return this.experimentId;
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
     * Builder for {@link DeleteScheduledExperimentsRequest}.
     */
    public static class Builder extends RequestBase.AbstractBuilder<Builder>
        implements
            CopyableBuilder<Builder, DeleteScheduledExperimentsRequest> {
        private String experimentId;

        public Builder() {}

        private Builder(DeleteScheduledExperimentsRequest o) {
            super(o);
            this.experimentId = o.experimentId;
        }

        private Builder(Builder o) {
            super(o);
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
         * Required - The experiment id
         * <p>
         * API name: {@code experiment_id}
         * </p>
         */
        @Nonnull
        public final Builder experimentId(String value) {
            this.experimentId = value;
            return this;
        }

        /**
         * Builds a {@link DeleteScheduledExperimentsRequest}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public DeleteScheduledExperimentsRequest build() {
            _checkSingleUse();

            return new DeleteScheduledExperimentsRequest(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Endpoint "{@code search_relevance.delete_scheduled_experiments}".
     */
    public static final Endpoint<DeleteScheduledExperimentsRequest, DeleteScheduledExperimentsResponse, ErrorResponse> _ENDPOINT =
        new SimpleEndpoint<>(
            // Request method
            request -> "DELETE",
            // Request path
            request -> {
                StringBuilder buf = new StringBuilder();
                buf.append("/_plugins/_search_relevance/experiments/schedule/");
                SimpleEndpoint.pathEncode(request.experimentId, buf);
                return buf.toString();
            },
            // Request parameters
            request -> {
                Map<String, String> params = new HashMap<>();
                request.applyQueryParameters(params);
                return params;
            },
            SimpleEndpoint.emptyMap(),
            false,
            DeleteScheduledExperimentsResponse._DESERIALIZER
        );

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.experimentId.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        DeleteScheduledExperimentsRequest other = (DeleteScheduledExperimentsRequest) o;
        return this.experimentId.equals(other.experimentId);
    }
}
