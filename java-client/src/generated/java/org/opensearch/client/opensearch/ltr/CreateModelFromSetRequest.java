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

package org.opensearch.client.opensearch.ltr;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.opensearch.client.opensearch._types.ErrorResponse;
import org.opensearch.client.opensearch._types.RequestBase;
import org.opensearch.client.transport.Endpoint;
import org.opensearch.client.transport.endpoints.SimpleEndpoint;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: ltr.create_model_from_set.Request

/**
 * Create a model from an existing feature set in the default feature store.
 */
@Generated("org.opensearch.client.codegen.CodeGenerator")
public final class CreateModelFromSetRequest extends RequestBase
    implements
        ToCopyableBuilder<CreateModelFromSetRequest.Builder, CreateModelFromSetRequest> {

    @Nonnull
    private final String name;

    @Nullable
    private final String routing;

    @Nullable
    private final String store;

    // ---------------------------------------------------------------------------------------------

    private CreateModelFromSetRequest(Builder builder) {
        super(builder);
        this.name = ApiTypeHelper.requireNonNull(builder.name, this, "name");
        this.routing = builder.routing;
        this.store = builder.store;
    }

    public static CreateModelFromSetRequest of(Function<CreateModelFromSetRequest.Builder, ObjectBuilder<CreateModelFromSetRequest>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - The name of the feature set to use for creating the model.
     * <p>
     * API name: {@code name}
     * </p>
     */
    @Nonnull
    public final String name() {
        return this.name;
    }

    /**
     * Specific routing value.
     * <p>
     * API name: {@code routing}
     * </p>
     */
    @Nullable
    public final String routing() {
        return this.routing;
    }

    /**
     * The name of the feature store.
     * <p>
     * API name: {@code store}
     * </p>
     */
    @Nullable
    public final String store() {
        return this.store;
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
     * Builder for {@link CreateModelFromSetRequest}.
     */
    public static class Builder extends RequestBase.AbstractBuilder<Builder>
        implements
            CopyableBuilder<Builder, CreateModelFromSetRequest> {
        private String name;
        @Nullable
        private String routing;
        @Nullable
        private String store;

        public Builder() {}

        private Builder(CreateModelFromSetRequest o) {
            super(o);
            this.name = o.name;
            this.routing = o.routing;
            this.store = o.store;
        }

        private Builder(Builder o) {
            super(o);
            this.name = o.name;
            this.routing = o.routing;
            this.store = o.store;
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
         * Required - The name of the feature set to use for creating the model.
         * <p>
         * API name: {@code name}
         * </p>
         */
        @Nonnull
        public final Builder name(String value) {
            this.name = value;
            return this;
        }

        /**
         * Specific routing value.
         * <p>
         * API name: {@code routing}
         * </p>
         */
        @Nonnull
        public final Builder routing(@Nullable String value) {
            this.routing = value;
            return this;
        }

        /**
         * The name of the feature store.
         * <p>
         * API name: {@code store}
         * </p>
         */
        @Nonnull
        public final Builder store(@Nullable String value) {
            this.store = value;
            return this;
        }

        /**
         * Builds a {@link CreateModelFromSetRequest}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public CreateModelFromSetRequest build() {
            _checkSingleUse();

            return new CreateModelFromSetRequest(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    @Override
    protected void applyQueryParameters(@Nonnull Map<String, String> params) {
        super.applyQueryParameters(params);
        if (this.routing != null) {
            params.put("routing", this.routing);
        }
    }

    /**
     * Endpoint "{@code ltr.create_model_from_set}".
     */
    public static final Endpoint<CreateModelFromSetRequest, CreateModelFromSetResponse, ErrorResponse> _ENDPOINT = new SimpleEndpoint<>(
        // Request method
        request -> "POST",
        // Request path
        request -> {
            final int _name = 1 << 0;
            final int _store = 1 << 1;

            int propsSet = 0;

            propsSet |= _name;
            if (request.store() != null) propsSet |= _store;

            if (propsSet == (_name)) {
                StringBuilder buf = new StringBuilder();
                buf.append("/_ltr/_featureset/");
                SimpleEndpoint.pathEncode(request.name, buf);
                buf.append("/_createmodel");
                return buf.toString();
            }
            if (propsSet == (_store | _name)) {
                StringBuilder buf = new StringBuilder();
                buf.append("/_ltr/");
                SimpleEndpoint.pathEncode(request.store, buf);
                buf.append("/_featureset/");
                SimpleEndpoint.pathEncode(request.name, buf);
                buf.append("/_createmodel");
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
        false,
        CreateModelFromSetResponse._DESERIALIZER
    );

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.name.hashCode();
        result = 31 * result + Objects.hashCode(this.routing);
        result = 31 * result + Objects.hashCode(this.store);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        CreateModelFromSetRequest other = (CreateModelFromSetRequest) o;
        return this.name.equals(other.name) && Objects.equals(this.routing, other.routing) && Objects.equals(this.store, other.store);
    }
}
