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

package org.opensearch.client.opensearch.cluster;

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

// typedef: cluster.put_decommission_awareness.Request

/**
 * Decommissions a cluster zone based on awareness. This can greatly benefit multi-zone deployments, where awareness attributes can aid in
 * applying new upgrades to a cluster in a controlled fashion.
 */
@Generated("org.opensearch.client.codegen.CodeGenerator")
public final class PutDecommissionAwarenessRequest extends RequestBase
    implements
        ToCopyableBuilder<PutDecommissionAwarenessRequest.Builder, PutDecommissionAwarenessRequest> {

    @Nonnull
    private final String awarenessAttributeName;

    @Nonnull
    private final String awarenessAttributeValue;

    // ---------------------------------------------------------------------------------------------

    private PutDecommissionAwarenessRequest(Builder builder) {
        super(builder);
        this.awarenessAttributeName = ApiTypeHelper.requireNonNull(builder.awarenessAttributeName, this, "awarenessAttributeName");
        this.awarenessAttributeValue = ApiTypeHelper.requireNonNull(builder.awarenessAttributeValue, this, "awarenessAttributeValue");
    }

    public static PutDecommissionAwarenessRequest of(
        Function<PutDecommissionAwarenessRequest.Builder, ObjectBuilder<PutDecommissionAwarenessRequest>> fn
    ) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - The name of the awareness attribute.
     * <p>
     * API name: {@code awareness_attribute_name}
     * </p>
     */
    @Nonnull
    public final String awarenessAttributeName() {
        return this.awarenessAttributeName;
    }

    /**
     * Required - The value of the awareness attribute. For example, if you have shards allocated in two different zones, you can give each
     * zone a value of <code>zone-a</code> or <code>zoneb</code>. The cluster decommission operation decommissions the zone listed in the
     * method.
     * <p>
     * API name: {@code awareness_attribute_value}
     * </p>
     */
    @Nonnull
    public final String awarenessAttributeValue() {
        return this.awarenessAttributeValue;
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
     * Builder for {@link PutDecommissionAwarenessRequest}.
     */
    public static class Builder extends RequestBase.AbstractBuilder<Builder>
        implements
            CopyableBuilder<Builder, PutDecommissionAwarenessRequest> {
        private String awarenessAttributeName;
        private String awarenessAttributeValue;

        public Builder() {}

        private Builder(PutDecommissionAwarenessRequest o) {
            super(o);
            this.awarenessAttributeName = o.awarenessAttributeName;
            this.awarenessAttributeValue = o.awarenessAttributeValue;
        }

        private Builder(Builder o) {
            super(o);
            this.awarenessAttributeName = o.awarenessAttributeName;
            this.awarenessAttributeValue = o.awarenessAttributeValue;
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
         * Required - The name of the awareness attribute.
         * <p>
         * API name: {@code awareness_attribute_name}
         * </p>
         */
        @Nonnull
        public final Builder awarenessAttributeName(String value) {
            this.awarenessAttributeName = value;
            return this;
        }

        /**
         * Required - The value of the awareness attribute. For example, if you have shards allocated in two different zones, you can give
         * each zone a value of <code>zone-a</code> or <code>zoneb</code>. The cluster decommission operation decommissions the zone listed
         * in the method.
         * <p>
         * API name: {@code awareness_attribute_value}
         * </p>
         */
        @Nonnull
        public final Builder awarenessAttributeValue(String value) {
            this.awarenessAttributeValue = value;
            return this;
        }

        /**
         * Builds a {@link PutDecommissionAwarenessRequest}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public PutDecommissionAwarenessRequest build() {
            _checkSingleUse();

            return new PutDecommissionAwarenessRequest(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Endpoint "{@code cluster.put_decommission_awareness}".
     */
    public static final Endpoint<PutDecommissionAwarenessRequest, PutDecommissionAwarenessResponse, ErrorResponse> _ENDPOINT =
        new SimpleEndpoint<>(
            // Request method
            request -> "PUT",
            // Request path
            request -> {
                StringBuilder buf = new StringBuilder();
                buf.append("/_cluster/decommission/awareness/");
                SimpleEndpoint.pathEncode(request.awarenessAttributeName, buf);
                buf.append("/");
                SimpleEndpoint.pathEncode(request.awarenessAttributeValue, buf);
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
            PutDecommissionAwarenessResponse._DESERIALIZER
        );

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.awarenessAttributeName.hashCode();
        result = 31 * result + this.awarenessAttributeValue.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        PutDecommissionAwarenessRequest other = (PutDecommissionAwarenessRequest) o;
        return this.awarenessAttributeName.equals(other.awarenessAttributeName)
            && this.awarenessAttributeValue.equals(other.awarenessAttributeValue);
    }
}
