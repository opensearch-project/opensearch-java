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
import java.util.List;
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

// typedef: cluster.describe_settings.Request

/**
 * Returns the definition of each requested cluster setting: whether it is dynamic, its declared default, its value type and bounds, and its
 * description. Accepts exact setting names and prefixes ending in <code>.*</code>. Does not return configured values.
 */
@Generated("org.opensearch.client.codegen.CodeGenerator")
public final class DescribeSettingsRequest extends RequestBase
    implements
        ToCopyableBuilder<DescribeSettingsRequest.Builder, DescribeSettingsRequest> {

    @Nonnull
    private final List<String> settings;

    // ---------------------------------------------------------------------------------------------

    private DescribeSettingsRequest(Builder builder) {
        super(builder);
        this.settings = ApiTypeHelper.unmodifiableRequired(builder.settings, this, "settings");
    }

    public static DescribeSettingsRequest of(Function<DescribeSettingsRequest.Builder, ObjectBuilder<DescribeSettingsRequest>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - A comma-separated list of setting names to describe. Each entry is either an exact setting name or a prefix ending in
     * <code>.*</code>, such as <code>cluster.routing.allocation.*</code>, which expands to every registered setting under it at any depth.
     * Exact names and prefixes can be mixed. Other wildcard forms are rejected. Affix and group setting templates and secure (keystore)
     * settings are not listed under a prefix; their concrete names can still be requested exactly. At least one entry is required.
     * <p>
     * API name: {@code settings}
     * </p>
     */
    @Nonnull
    public final List<String> settings() {
        return this.settings;
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
     * Builder for {@link DescribeSettingsRequest}.
     */
    public static class Builder extends RequestBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, DescribeSettingsRequest> {
        private List<String> settings;

        public Builder() {}

        private Builder(DescribeSettingsRequest o) {
            super(o);
            this.settings = _listCopy(o.settings);
        }

        private Builder(Builder o) {
            super(o);
            this.settings = _listCopy(o.settings);
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
         * Required - A comma-separated list of setting names to describe. Each entry is either an exact setting name or a prefix ending in
         * <code>.*</code>, such as <code>cluster.routing.allocation.*</code>, which expands to every registered setting under it at any
         * depth. Exact names and prefixes can be mixed. Other wildcard forms are rejected. Affix and group setting templates and secure
         * (keystore) settings are not listed under a prefix; their concrete names can still be requested exactly. At least one entry is
         * required.
         * <p>
         * API name: {@code settings}
         * </p>
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>settings</code>.
         * </p>
         */
        @Nonnull
        public final Builder settings(List<String> list) {
            this.settings = _listAddAll(this.settings, list);
            return this;
        }

        /**
         * Required - A comma-separated list of setting names to describe. Each entry is either an exact setting name or a prefix ending in
         * <code>.*</code>, such as <code>cluster.routing.allocation.*</code>, which expands to every registered setting under it at any
         * depth. Exact names and prefixes can be mixed. Other wildcard forms are rejected. Affix and group setting templates and secure
         * (keystore) settings are not listed under a prefix; their concrete names can still be requested exactly. At least one entry is
         * required.
         * <p>
         * API name: {@code settings}
         * </p>
         *
         * <p>
         * Adds one or more values to <code>settings</code>.
         * </p>
         */
        @Nonnull
        public final Builder settings(String value, String... values) {
            this.settings = _listAdd(this.settings, value, values);
            return this;
        }

        /**
         * Builds a {@link DescribeSettingsRequest}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public DescribeSettingsRequest build() {
            _checkSingleUse();

            return new DescribeSettingsRequest(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    @Override
    protected void applyQueryParameters(@Nonnull Map<String, String> params) {
        super.applyQueryParameters(params);
        params.put("settings", String.join(",", this.settings));
    }

    /**
     * Endpoint "{@code cluster.describe_settings}".
     */
    public static final Endpoint<DescribeSettingsRequest, DescribeSettingsResponse, ErrorResponse> _ENDPOINT = new SimpleEndpoint<>(
        // Request method
        request -> "GET",
        // Request path
        request -> "/_cluster/settings/_describe",
        // Request parameters
        request -> {
            Map<String, String> params = new HashMap<>();
            request.applyQueryParameters(params);
            return params;
        },
        SimpleEndpoint.emptyMap(),
        false,
        DescribeSettingsResponse._DESERIALIZER
    );

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.settings.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        DescribeSettingsRequest other = (DescribeSettingsRequest) o;
        return this.settings.equals(other.settings);
    }
}
