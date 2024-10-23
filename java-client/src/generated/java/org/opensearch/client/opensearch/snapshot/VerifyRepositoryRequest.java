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

package org.opensearch.client.opensearch.snapshot;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.opensearch.client.opensearch._types.ErrorResponse;
import org.opensearch.client.opensearch._types.RequestBase;
import org.opensearch.client.opensearch._types.Time;
import org.opensearch.client.transport.Endpoint;
import org.opensearch.client.transport.endpoints.SimpleEndpoint;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;

// typedef: snapshot.verify_repository.Request

/**
 * Verifies a repository.
 */
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class VerifyRepositoryRequest extends RequestBase {

    @Nullable
    private final Time clusterManagerTimeout;

    @Deprecated
    @Nullable
    private final Time masterTimeout;

    @Nonnull
    private final String repository;

    @Nullable
    private final Time timeout;

    // ---------------------------------------------------------------------------------------------

    private VerifyRepositoryRequest(Builder builder) {
        this.clusterManagerTimeout = builder.clusterManagerTimeout;
        this.masterTimeout = builder.masterTimeout;
        this.repository = ApiTypeHelper.requireNonNull(builder.repository, this, "repository");
        this.timeout = builder.timeout;
    }

    public static VerifyRepositoryRequest of(Function<VerifyRepositoryRequest.Builder, ObjectBuilder<VerifyRepositoryRequest>> fn) {
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
     * Explicit operation timeout for connection to master node
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
     * Required - A repository name
     * <p>
     * API name: {@code repository}
     * </p>
     */
    @Nonnull
    public final String repository() {
        return this.repository;
    }

    /**
     * Explicit operation timeout
     * <p>
     * API name: {@code timeout}
     * </p>
     */
    @Nullable
    public final Time timeout() {
        return this.timeout;
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Builder for {@link VerifyRepositoryRequest}.
     */
    public static class Builder extends ObjectBuilderBase implements ObjectBuilder<VerifyRepositoryRequest> {
        @Nullable
        private Time clusterManagerTimeout;
        @Nullable
        private Time masterTimeout;
        private String repository;
        @Nullable
        private Time timeout;

        /**
         * Operation timeout for connection to cluster-manager node.
         * <p>
         * API name: {@code cluster_manager_timeout}
         * </p>
         */
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
        public final Builder clusterManagerTimeout(Function<Time.Builder, ObjectBuilder<Time>> fn) {
            return clusterManagerTimeout(fn.apply(new Time.Builder()).build());
        }

        /**
         * Explicit operation timeout for connection to master node
         * <p>
         * API name: {@code master_timeout}
         * </p>
         */
        @Deprecated
        public final Builder masterTimeout(@Nullable Time value) {
            this.masterTimeout = value;
            return this;
        }

        /**
         * Explicit operation timeout for connection to master node
         * <p>
         * API name: {@code master_timeout}
         * </p>
         */
        @Deprecated
        public final Builder masterTimeout(Function<Time.Builder, ObjectBuilder<Time>> fn) {
            return masterTimeout(fn.apply(new Time.Builder()).build());
        }

        /**
         * Required - A repository name
         * <p>
         * API name: {@code repository}
         * </p>
         */
        public final Builder repository(String value) {
            this.repository = value;
            return this;
        }

        /**
         * Explicit operation timeout
         * <p>
         * API name: {@code timeout}
         * </p>
         */
        public final Builder timeout(@Nullable Time value) {
            this.timeout = value;
            return this;
        }

        /**
         * Explicit operation timeout
         * <p>
         * API name: {@code timeout}
         * </p>
         */
        public final Builder timeout(Function<Time.Builder, ObjectBuilder<Time>> fn) {
            return timeout(fn.apply(new Time.Builder()).build());
        }

        /**
         * Builds a {@link VerifyRepositoryRequest}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        public VerifyRepositoryRequest build() {
            _checkSingleUse();

            return new VerifyRepositoryRequest(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Endpoint "{@code snapshot.verify_repository}".
     */
    public static final Endpoint<VerifyRepositoryRequest, VerifyRepositoryResponse, ErrorResponse> _ENDPOINT = new SimpleEndpoint<>(
        // Request method
        request -> "POST",
        // Request path
        request -> {
            StringBuilder buf = new StringBuilder();
            buf.append("/_snapshot/");
            SimpleEndpoint.pathEncode(request.repository, buf);
            buf.append("/_verify");
            return buf.toString();
        },
        // Request parameters
        request -> {
            Map<String, String> params = new HashMap<>();
            if (request.clusterManagerTimeout != null) {
                params.put("cluster_manager_timeout", request.clusterManagerTimeout._toJsonString());
            }
            if (request.masterTimeout != null) {
                params.put("master_timeout", request.masterTimeout._toJsonString());
            }
            if (request.timeout != null) {
                params.put("timeout", request.timeout._toJsonString());
            }
            return params;
        },
        SimpleEndpoint.emptyMap(),
        false,
        VerifyRepositoryResponse._DESERIALIZER
    );

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.clusterManagerTimeout);
        result = 31 * result + Objects.hashCode(this.masterTimeout);
        result = 31 * result + this.repository.hashCode();
        result = 31 * result + Objects.hashCode(this.timeout);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        VerifyRepositoryRequest other = (VerifyRepositoryRequest) o;
        return Objects.equals(this.clusterManagerTimeout, other.clusterManagerTimeout)
            && Objects.equals(this.masterTimeout, other.masterTimeout)
            && this.repository.equals(other.repository)
            && Objects.equals(this.timeout, other.timeout);
    }
}
