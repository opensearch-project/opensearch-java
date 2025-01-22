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
import org.opensearch.client.opensearch._types.Time;
import org.opensearch.client.transport.Endpoint;
import org.opensearch.client.transport.endpoints.SimpleEndpoint;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: snapshot.create_repository.Request

/**
 * Creates a repository.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public final class CreateRepositoryRequest extends RequestBase
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<CreateRepositoryRequest.Builder, CreateRepositoryRequest> {

    @Nullable
    private final Time clusterManagerTimeout;

    @Deprecated
    @Nullable
    private final Time masterTimeout;

    @Nonnull
    private final String name;

    @Nullable
    private final Repository repository;

    @Nonnull
    private final RepositorySettings settings;

    @Nullable
    private final Time timeout;

    @Nonnull
    private final String type;

    @Nullable
    private final Boolean verify;

    // ---------------------------------------------------------------------------------------------

    private CreateRepositoryRequest(Builder builder) {
        super(builder);
        this.clusterManagerTimeout = builder.clusterManagerTimeout;
        this.masterTimeout = builder.masterTimeout;
        this.name = ApiTypeHelper.requireNonNull(builder.name, this, "name");
        this.repository = builder.repository;
        this.settings = ApiTypeHelper.requireNonNull(builder.settings, this, "settings");
        this.timeout = builder.timeout;
        this.type = ApiTypeHelper.requireNonNull(builder.type, this, "type");
        this.verify = builder.verify;
    }

    public static CreateRepositoryRequest of(Function<CreateRepositoryRequest.Builder, ObjectBuilder<CreateRepositoryRequest>> fn) {
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
     * Explicit operation timeout for connection to cluster-manager node
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
    public final String name() {
        return this.name;
    }

    /**
     * API name: {@code repository}
     */
    @Nullable
    public final Repository repository() {
        return this.repository;
    }

    /**
     * Required - API name: {@code settings}
     */
    @Nonnull
    public final RepositorySettings settings() {
        return this.settings;
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

    /**
     * Required - API name: {@code type}
     */
    @Nonnull
    public final String type() {
        return this.type;
    }

    /**
     * Whether to verify the repository after creation
     * <p>
     * API name: {@code verify}
     * </p>
     */
    @Nullable
    public final Boolean verify() {
        return this.verify;
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
        if (this.repository != null) {
            generator.writeKey("repository");
            this.repository.serialize(generator, mapper);
        }

        generator.writeKey("settings");
        this.settings.serialize(generator, mapper);

        generator.writeKey("type");
        generator.write(this.type);
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
     * Builder for {@link CreateRepositoryRequest}.
     */
    public static class Builder extends RequestBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, CreateRepositoryRequest> {
        @Nullable
        private Time clusterManagerTimeout;
        @Nullable
        private Time masterTimeout;
        private String name;
        @Nullable
        private Repository repository;
        private RepositorySettings settings;
        @Nullable
        private Time timeout;
        private String type;
        @Nullable
        private Boolean verify;

        public Builder() {}

        private Builder(CreateRepositoryRequest o) {
            super(o);
            this.clusterManagerTimeout = o.clusterManagerTimeout;
            this.masterTimeout = o.masterTimeout;
            this.name = o.name;
            this.repository = o.repository;
            this.settings = o.settings;
            this.timeout = o.timeout;
            this.type = o.type;
            this.verify = o.verify;
        }

        private Builder(Builder o) {
            super(o);
            this.clusterManagerTimeout = o.clusterManagerTimeout;
            this.masterTimeout = o.masterTimeout;
            this.name = o.name;
            this.repository = o.repository;
            this.settings = o.settings;
            this.timeout = o.timeout;
            this.type = o.type;
            this.verify = o.verify;
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
         * Explicit operation timeout for connection to cluster-manager node
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
         * Explicit operation timeout for connection to cluster-manager node
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
         * Required - A repository name
         * <p>
         * API name: {@code repository}
         * </p>
         */
        @Nonnull
        public final Builder name(String value) {
            this.name = value;
            return this;
        }

        /**
         * API name: {@code repository}
         */
        @Nonnull
        public final Builder repository(@Nullable Repository value) {
            this.repository = value;
            return this;
        }

        /**
         * API name: {@code repository}
         */
        @Nonnull
        public final Builder repository(Function<Repository.Builder, ObjectBuilder<Repository>> fn) {
            return repository(fn.apply(new Repository.Builder()).build());
        }

        /**
         * Required - API name: {@code settings}
         */
        @Nonnull
        public final Builder settings(RepositorySettings value) {
            this.settings = value;
            return this;
        }

        /**
         * Required - API name: {@code settings}
         */
        @Nonnull
        public final Builder settings(Function<RepositorySettings.Builder, ObjectBuilder<RepositorySettings>> fn) {
            return settings(fn.apply(new RepositorySettings.Builder()).build());
        }

        /**
         * Explicit operation timeout
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
         * Explicit operation timeout
         * <p>
         * API name: {@code timeout}
         * </p>
         */
        @Nonnull
        public final Builder timeout(Function<Time.Builder, ObjectBuilder<Time>> fn) {
            return timeout(fn.apply(new Time.Builder()).build());
        }

        /**
         * Required - API name: {@code type}
         */
        @Nonnull
        public final Builder type(String value) {
            this.type = value;
            return this;
        }

        /**
         * Whether to verify the repository after creation
         * <p>
         * API name: {@code verify}
         * </p>
         */
        @Nonnull
        public final Builder verify(@Nullable Boolean value) {
            this.verify = value;
            return this;
        }

        /**
         * Builds a {@link CreateRepositoryRequest}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public CreateRepositoryRequest build() {
            _checkSingleUse();

            return new CreateRepositoryRequest(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link CreateRepositoryRequest}
     */
    public static final JsonpDeserializer<CreateRepositoryRequest> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        CreateRepositoryRequest::setupCreateRepositoryRequestDeserializer
    );

    protected static void setupCreateRepositoryRequestDeserializer(ObjectDeserializer<CreateRepositoryRequest.Builder> op) {
        op.add(Builder::repository, Repository._DESERIALIZER, "repository");
        op.add(Builder::settings, RepositorySettings._DESERIALIZER, "settings");
        op.add(Builder::type, JsonpDeserializer.stringDeserializer(), "type");
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
        if (this.verify != null) {
            params.put("verify", String.valueOf(this.verify));
        }
    }

    /**
     * Endpoint "{@code snapshot.create_repository}".
     */
    public static final Endpoint<CreateRepositoryRequest, CreateRepositoryResponse, ErrorResponse> _ENDPOINT = new SimpleEndpoint<>(
        // Request method
        request -> "PUT",
        // Request path
        request -> {
            StringBuilder buf = new StringBuilder();
            buf.append("/_snapshot/");
            SimpleEndpoint.pathEncode(request.name, buf);
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
        CreateRepositoryResponse._DESERIALIZER
    );

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.clusterManagerTimeout);
        result = 31 * result + Objects.hashCode(this.masterTimeout);
        result = 31 * result + this.name.hashCode();
        result = 31 * result + Objects.hashCode(this.repository);
        result = 31 * result + this.settings.hashCode();
        result = 31 * result + Objects.hashCode(this.timeout);
        result = 31 * result + this.type.hashCode();
        result = 31 * result + Objects.hashCode(this.verify);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        CreateRepositoryRequest other = (CreateRepositoryRequest) o;
        return Objects.equals(this.clusterManagerTimeout, other.clusterManagerTimeout)
            && Objects.equals(this.masterTimeout, other.masterTimeout)
            && this.name.equals(other.name)
            && Objects.equals(this.repository, other.repository)
            && this.settings.equals(other.settings)
            && Objects.equals(this.timeout, other.timeout)
            && this.type.equals(other.type)
            && Objects.equals(this.verify, other.verify);
    }
}
