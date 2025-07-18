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

// typedef: ltr.add_features_to_set_by_query.Request

/**
 * Add features to an existing feature set in the default feature store.
 */
@Generated("org.opensearch.client.codegen.CodeGenerator")
public final class AddFeaturesToSetByQueryRequest extends RequestBase
    implements
        ToCopyableBuilder<AddFeaturesToSetByQueryRequest.Builder, AddFeaturesToSetByQueryRequest> {

    @Nullable
    private final Boolean merge;

    @Nonnull
    private final String name;

    @Nonnull
    private final String query;

    @Nullable
    private final String routing;

    @Nullable
    private final String store;

    @Nullable
    private final Integer version;

    // ---------------------------------------------------------------------------------------------

    private AddFeaturesToSetByQueryRequest(Builder builder) {
        super(builder);
        this.merge = builder.merge;
        this.name = ApiTypeHelper.requireNonNull(builder.name, this, "name");
        this.query = ApiTypeHelper.requireNonNull(builder.query, this, "query");
        this.routing = builder.routing;
        this.store = builder.store;
        this.version = builder.version;
    }

    public static AddFeaturesToSetByQueryRequest of(
        Function<AddFeaturesToSetByQueryRequest.Builder, ObjectBuilder<AddFeaturesToSetByQueryRequest>> fn
    ) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Whether to merge the feature list or append only.
     * <p>
     * API name: {@code merge}
     * </p>
     */
    @Nullable
    public final Boolean merge() {
        return this.merge;
    }

    /**
     * Required - The name of the feature set to add features to.
     * <p>
     * API name: {@code name}
     * </p>
     */
    @Nonnull
    public final String name() {
        return this.name;
    }

    /**
     * Required - Query string to filter existing features from the store by name. When provided, only features matching this query will be
     * added to the feature set, and no request body should be included.
     * <p>
     * API name: {@code query}
     * </p>
     */
    @Nonnull
    public final String query() {
        return this.query;
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

    /**
     * Version check to ensure feature set is modified with expected version.
     * <p>
     * API name: {@code version}
     * </p>
     */
    @Nullable
    public final Integer version() {
        return this.version;
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
     * Builder for {@link AddFeaturesToSetByQueryRequest}.
     */
    public static class Builder extends RequestBase.AbstractBuilder<Builder>
        implements
            CopyableBuilder<Builder, AddFeaturesToSetByQueryRequest> {
        @Nullable
        private Boolean merge;
        private String name;
        private String query;
        @Nullable
        private String routing;
        @Nullable
        private String store;
        @Nullable
        private Integer version;

        public Builder() {}

        private Builder(AddFeaturesToSetByQueryRequest o) {
            super(o);
            this.merge = o.merge;
            this.name = o.name;
            this.query = o.query;
            this.routing = o.routing;
            this.store = o.store;
            this.version = o.version;
        }

        private Builder(Builder o) {
            super(o);
            this.merge = o.merge;
            this.name = o.name;
            this.query = o.query;
            this.routing = o.routing;
            this.store = o.store;
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
         * Whether to merge the feature list or append only.
         * <p>
         * API name: {@code merge}
         * </p>
         */
        @Nonnull
        public final Builder merge(@Nullable Boolean value) {
            this.merge = value;
            return this;
        }

        /**
         * Required - The name of the feature set to add features to.
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
         * Required - Query string to filter existing features from the store by name. When provided, only features matching this query will
         * be added to the feature set, and no request body should be included.
         * <p>
         * API name: {@code query}
         * </p>
         */
        @Nonnull
        public final Builder query(String value) {
            this.query = value;
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
         * Version check to ensure feature set is modified with expected version.
         * <p>
         * API name: {@code version}
         * </p>
         */
        @Nonnull
        public final Builder version(@Nullable Integer value) {
            this.version = value;
            return this;
        }

        /**
         * Builds a {@link AddFeaturesToSetByQueryRequest}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public AddFeaturesToSetByQueryRequest build() {
            _checkSingleUse();

            return new AddFeaturesToSetByQueryRequest(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    @Override
    protected void applyQueryParameters(@Nonnull Map<String, String> params) {
        super.applyQueryParameters(params);
        if (this.merge != null) {
            params.put("merge", String.valueOf(this.merge));
        }
        if (this.routing != null) {
            params.put("routing", this.routing);
        }
        if (this.version != null) {
            params.put("version", String.valueOf(this.version));
        }
    }

    /**
     * Endpoint "{@code ltr.add_features_to_set_by_query}".
     */
    public static final Endpoint<AddFeaturesToSetByQueryRequest, AddFeaturesToSetByQueryResponse, ErrorResponse> _ENDPOINT =
        new SimpleEndpoint<>(
            // Request method
            request -> "POST",
            // Request path
            request -> {
                final int _name = 1 << 0;
                final int _query = 1 << 1;
                final int _store = 1 << 2;

                int propsSet = 0;

                propsSet |= _name;
                propsSet |= _query;
                if (request.store() != null) propsSet |= _store;

                if (propsSet == (_name | _query)) {
                    StringBuilder buf = new StringBuilder();
                    buf.append("/_ltr/_featureset/");
                    SimpleEndpoint.pathEncode(request.name, buf);
                    buf.append("/_addfeatures/");
                    SimpleEndpoint.pathEncode(request.query, buf);
                    return buf.toString();
                }
                if (propsSet == (_store | _name | _query)) {
                    StringBuilder buf = new StringBuilder();
                    buf.append("/_ltr/");
                    SimpleEndpoint.pathEncode(request.store, buf);
                    buf.append("/_featureset/");
                    SimpleEndpoint.pathEncode(request.name, buf);
                    buf.append("/_addfeatures/");
                    SimpleEndpoint.pathEncode(request.query, buf);
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
            AddFeaturesToSetByQueryResponse._DESERIALIZER
        );

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.merge);
        result = 31 * result + this.name.hashCode();
        result = 31 * result + this.query.hashCode();
        result = 31 * result + Objects.hashCode(this.routing);
        result = 31 * result + Objects.hashCode(this.store);
        result = 31 * result + Objects.hashCode(this.version);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        AddFeaturesToSetByQueryRequest other = (AddFeaturesToSetByQueryRequest) o;
        return Objects.equals(this.merge, other.merge)
            && this.name.equals(other.name)
            && this.query.equals(other.query)
            && Objects.equals(this.routing, other.routing)
            && Objects.equals(this.store, other.store)
            && Objects.equals(this.version, other.version);
    }
}
