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

package org.opensearch.client.opensearch.security;

import jakarta.json.stream.JsonGenerator;
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
import org.opensearch.client.opensearch.nodes.NodesResponseBase;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: security.get_all_certificates.Response

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class GetAllCertificatesResponse extends NodesResponseBase
    implements
        ToCopyableBuilder<GetAllCertificatesResponse.Builder, GetAllCertificatesResponse> {

    @Nullable
    private final String clusterName;

    @Nonnull
    private final Map<String, CertificatesPerNode> nodes;

    // ---------------------------------------------------------------------------------------------

    private GetAllCertificatesResponse(Builder builder) {
        super(builder);
        this.clusterName = builder.clusterName;
        this.nodes = ApiTypeHelper.unmodifiable(builder.nodes);
    }

    public static GetAllCertificatesResponse of(
        Function<GetAllCertificatesResponse.Builder, ObjectBuilder<GetAllCertificatesResponse>> fn
    ) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Name of this cluster.
     * <p>
     * API name: {@code cluster_name}
     * </p>
     */
    @Nullable
    public final String clusterName() {
        return this.clusterName;
    }

    /**
     * API name: {@code nodes}
     */
    @Nonnull
    public final Map<String, CertificatesPerNode> nodes() {
        return this.nodes;
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        super.serializeInternal(generator, mapper);
        if (this.clusterName != null) {
            generator.writeKey("cluster_name");
            generator.write(this.clusterName);
        }

        if (ApiTypeHelper.isDefined(this.nodes)) {
            generator.writeKey("nodes");
            generator.writeStartObject();
            for (Map.Entry<String, CertificatesPerNode> item0 : this.nodes.entrySet()) {
                generator.writeKey(item0.getKey());
                item0.getValue().serialize(generator, mapper);
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
     * Builder for {@link GetAllCertificatesResponse}.
     */
    public static class Builder extends NodesResponseBase.AbstractBuilder<Builder>
        implements
            CopyableBuilder<Builder, GetAllCertificatesResponse> {
        @Nullable
        private String clusterName;
        @Nullable
        private Map<String, CertificatesPerNode> nodes;

        public Builder() {}

        private Builder(GetAllCertificatesResponse o) {
            super(o);
            this.clusterName = o.clusterName;
            this.nodes = _mapCopy(o.nodes);
        }

        private Builder(Builder o) {
            super(o);
            this.clusterName = o.clusterName;
            this.nodes = _mapCopy(o.nodes);
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
         * Name of this cluster.
         * <p>
         * API name: {@code cluster_name}
         * </p>
         */
        @Nonnull
        public final Builder clusterName(@Nullable String value) {
            this.clusterName = value;
            return this;
        }

        /**
         * API name: {@code nodes}
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>nodes</code>.
         * </p>
         */
        @Nonnull
        public final Builder nodes(Map<String, CertificatesPerNode> map) {
            this.nodes = _mapPutAll(this.nodes, map);
            return this;
        }

        /**
         * API name: {@code nodes}
         *
         * <p>
         * Adds an entry to <code>nodes</code>.
         * </p>
         */
        @Nonnull
        public final Builder nodes(String key, CertificatesPerNode value) {
            this.nodes = _mapPut(this.nodes, key, value);
            return this;
        }

        /**
         * API name: {@code nodes}
         *
         * <p>
         * Adds a value to <code>nodes</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder nodes(String key, Function<CertificatesPerNode.Builder, ObjectBuilder<CertificatesPerNode>> fn) {
            return nodes(key, fn.apply(new CertificatesPerNode.Builder()).build());
        }

        /**
         * Builds a {@link GetAllCertificatesResponse}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public GetAllCertificatesResponse build() {
            _checkSingleUse();

            return new GetAllCertificatesResponse(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link GetAllCertificatesResponse}
     */
    public static final JsonpDeserializer<GetAllCertificatesResponse> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        GetAllCertificatesResponse::setupGetAllCertificatesResponseDeserializer
    );

    protected static void setupGetAllCertificatesResponseDeserializer(ObjectDeserializer<GetAllCertificatesResponse.Builder> op) {
        setupNodesResponseBaseDeserializer(op);
        op.add(Builder::clusterName, JsonpDeserializer.stringDeserializer(), "cluster_name");
        op.add(Builder::nodes, JsonpDeserializer.stringMapDeserializer(CertificatesPerNode._DESERIALIZER), "nodes");
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Objects.hashCode(this.clusterName);
        result = 31 * result + Objects.hashCode(this.nodes);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        GetAllCertificatesResponse other = (GetAllCertificatesResponse) o;
        return Objects.equals(this.clusterName, other.clusterName) && Objects.equals(this.nodes, other.nodes);
    }
}
