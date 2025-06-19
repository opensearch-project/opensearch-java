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

import jakarta.json.stream.JsonGenerator;
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
import org.opensearch.client.opensearch.cluster.weighted_routing.WeightsBase;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: cluster.get_weighted_routing.Response

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class GetWeightedRoutingResponse extends WeightsBase
    implements
        ToCopyableBuilder<GetWeightedRoutingResponse.Builder, GetWeightedRoutingResponse> {

    @Nullable
    private final Boolean discoveredClusterManager;

    // ---------------------------------------------------------------------------------------------

    private GetWeightedRoutingResponse(Builder builder) {
        super(builder);
        this.discoveredClusterManager = builder.discoveredClusterManager;
    }

    public static GetWeightedRoutingResponse of(
        Function<GetWeightedRoutingResponse.Builder, ObjectBuilder<GetWeightedRoutingResponse>> fn
    ) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code discovered_cluster_manager}
     */
    @Nullable
    public final Boolean discoveredClusterManager() {
        return this.discoveredClusterManager;
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        super.serializeInternal(generator, mapper);
        if (this.discoveredClusterManager != null) {
            generator.writeKey("discovered_cluster_manager");
            generator.write(this.discoveredClusterManager);
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
     * Builder for {@link GetWeightedRoutingResponse}.
     */
    public static class Builder extends WeightsBase.AbstractBuilder<Builder>
        implements
            CopyableBuilder<Builder, GetWeightedRoutingResponse> {
        @Nullable
        private Boolean discoveredClusterManager;

        public Builder() {}

        private Builder(GetWeightedRoutingResponse o) {
            super(o);
            this.discoveredClusterManager = o.discoveredClusterManager;
        }

        private Builder(Builder o) {
            super(o);
            this.discoveredClusterManager = o.discoveredClusterManager;
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
         * API name: {@code discovered_cluster_manager}
         */
        @Nonnull
        public final Builder discoveredClusterManager(@Nullable Boolean value) {
            this.discoveredClusterManager = value;
            return this;
        }

        /**
         * Builds a {@link GetWeightedRoutingResponse}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public GetWeightedRoutingResponse build() {
            _checkSingleUse();

            return new GetWeightedRoutingResponse(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link GetWeightedRoutingResponse}
     */
    public static final JsonpDeserializer<GetWeightedRoutingResponse> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        GetWeightedRoutingResponse::setupGetWeightedRoutingResponseDeserializer
    );

    protected static void setupGetWeightedRoutingResponseDeserializer(ObjectDeserializer<GetWeightedRoutingResponse.Builder> op) {
        setupWeightsBaseDeserializer(op);
        op.add(Builder::discoveredClusterManager, JsonpDeserializer.booleanDeserializer(), "discovered_cluster_manager");
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Objects.hashCode(this.discoveredClusterManager);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        GetWeightedRoutingResponse other = (GetWeightedRoutingResponse) o;
        return Objects.equals(this.discoveredClusterManager, other.discoveredClusterManager);
    }
}
