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

// ----------------------------------------------------
// THIS CODE IS GENERATED. MANUAL EDITS WILL BE LOST.
// ----------------------------------------------------

package org.opensearch.client.opensearch.cat;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.annotation.Nullable;
import org.opensearch.client.opensearch._types.ErrorResponse;
import org.opensearch.client.opensearch._types.ExpandWildcard;
import org.opensearch.client.opensearch._types.RequestBase;
import org.opensearch.client.transport.Endpoint;
import org.opensearch.client.transport.endpoints.SimpleEndpoint;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;

/**
 * Shows information about currently configured aliases to indices including filter and routing
 * infos.
 */
public class AliasesRequest extends RequestBase {

    private final List<ExpandWildcard> expandWildcards;

    @Nullable private final String format;

    private final List<String> h;

    @Nullable private final Boolean help;

    @Nullable private final Boolean local;

    private final List<String> name;

    private final List<String> s;

    @Nullable private final Boolean v;

    // ---------------------------------------------------------------------------------------------

    private AliasesRequest(Builder builder) {
        this.expandWildcards = ApiTypeHelper.unmodifiable(builder.expandWildcards);
        this.format = builder.format;
        this.h = ApiTypeHelper.unmodifiable(builder.h);
        this.help = builder.help;
        this.local = builder.local;
        this.name = ApiTypeHelper.unmodifiable(builder.name);
        this.s = ApiTypeHelper.unmodifiable(builder.s);
        this.v = builder.v;
    }

    public static AliasesRequest of(
            Function<AliasesRequest.Builder, ObjectBuilder<AliasesRequest>> fn) {
        return fn.apply(new Builder()).build();
    }
    /**
     * Whether to expand wildcard expression to concrete indices that are open, closed or both.
     *
     * <p>API name: {@code expand_wildcards}
     */
    public final List<ExpandWildcard> expandWildcards() {
        return this.expandWildcards;
    }

    /**
     * A short version of the Accept header, e.g. json, yaml.
     *
     * <p>API name: {@code format}
     */
    @Nullable
    public final String format() {
        return this.format;
    }

    /**
     * Comma-separated list of column names to display.
     *
     * <p>API name: {@code h}
     */
    public final List<String> h() {
        return this.h;
    }

    /**
     * Return help information.
     *
     * <p>API name: {@code help}
     */
    @Nullable
    public final Boolean help() {
        return this.help;
    }

    /**
     * Return local information, do not retrieve the state from cluster-manager node.
     *
     * <p>API name: {@code local}
     */
    @Nullable
    public final Boolean local() {
        return this.local;
    }

    /**
     * A comma-separated list of aliases to retrieve. Supports wildcards (`*`). To retrieve all
     * aliases, omit this parameter or use `*` or `_all`.
     *
     * <p>API name: {@code name}
     */
    public final List<String> name() {
        return this.name;
    }

    /**
     * Comma-separated list of column names or column aliases to sort by.
     *
     * <p>API name: {@code s}
     */
    public final List<String> s() {
        return this.s;
    }

    /**
     * Verbose mode. Display column headers.
     *
     * <p>API name: {@code v}
     */
    @Nullable
    public final Boolean v() {
        return this.v;
    }

    // ---------------------------------------------------------------------------------------------

    /** Builder for {@link AliasesRequest}. */
    public static class Builder extends ObjectBuilderBase implements ObjectBuilder<AliasesRequest> {
        @Nullable private List<ExpandWildcard> expandWildcards;
        @Nullable private String format;
        @Nullable private List<String> h;
        @Nullable private Boolean help;
        @Nullable private Boolean local;
        @Nullable private List<String> name;
        @Nullable private List<String> s;
        @Nullable private Boolean v;

        /**
         * Whether to expand wildcard expression to concrete indices that are open, closed or both.
         *
         * <p>API name: {@code expand_wildcards}
         *
         * <p>Adds all elements of <code>list</code> to <code>expandWildcards</code>.
         */
        public final Builder expandWildcards(List<ExpandWildcard> list) {
            this.expandWildcards = _listAddAll(this.expandWildcards, list);
            return this;
        }

        /**
         * Whether to expand wildcard expression to concrete indices that are open, closed or both.
         *
         * <p>API name: {@code expand_wildcards}
         *
         * <p>Adds one or more values to <code>expandWildcards</code>.
         */
        public final Builder expandWildcards(ExpandWildcard value, ExpandWildcard... values) {
            this.expandWildcards = _listAdd(this.expandWildcards, value, values);
            return this;
        }

        /**
         * A short version of the Accept header, e.g. json, yaml.
         *
         * <p>API name: {@code format}
         */
        public final Builder format(@Nullable String value) {
            this.format = value;
            return this;
        }

        /**
         * Comma-separated list of column names to display.
         *
         * <p>API name: {@code h}
         *
         * <p>Adds all elements of <code>list</code> to <code>h</code>.
         */
        public final Builder h(List<String> list) {
            this.h = _listAddAll(this.h, list);
            return this;
        }

        /**
         * Comma-separated list of column names to display.
         *
         * <p>API name: {@code h}
         *
         * <p>Adds one or more values to <code>h</code>.
         */
        public final Builder h(String value, String... values) {
            this.h = _listAdd(this.h, value, values);
            return this;
        }

        /**
         * Return help information.
         *
         * <p>API name: {@code help}
         */
        public final Builder help(@Nullable Boolean value) {
            this.help = value;
            return this;
        }

        /**
         * Return local information, do not retrieve the state from cluster-manager node.
         *
         * <p>API name: {@code local}
         */
        public final Builder local(@Nullable Boolean value) {
            this.local = value;
            return this;
        }

        /**
         * A comma-separated list of aliases to retrieve. Supports wildcards (`*`). To retrieve all
         * aliases, omit this parameter or use `*` or `_all`.
         *
         * <p>API name: {@code name}
         *
         * <p>Adds all elements of <code>list</code> to <code>name</code>.
         */
        public final Builder name(List<String> list) {
            this.name = _listAddAll(this.name, list);
            return this;
        }

        /**
         * A comma-separated list of aliases to retrieve. Supports wildcards (`*`). To retrieve all
         * aliases, omit this parameter or use `*` or `_all`.
         *
         * <p>API name: {@code name}
         *
         * <p>Adds one or more values to <code>name</code>.
         */
        public final Builder name(String value, String... values) {
            this.name = _listAdd(this.name, value, values);
            return this;
        }

        /**
         * Comma-separated list of column names or column aliases to sort by.
         *
         * <p>API name: {@code s}
         *
         * <p>Adds all elements of <code>list</code> to <code>s</code>.
         */
        public final Builder s(List<String> list) {
            this.s = _listAddAll(this.s, list);
            return this;
        }

        /**
         * Comma-separated list of column names or column aliases to sort by.
         *
         * <p>API name: {@code s}
         *
         * <p>Adds one or more values to <code>s</code>.
         */
        public final Builder s(String value, String... values) {
            this.s = _listAdd(this.s, value, values);
            return this;
        }

        /**
         * Verbose mode. Display column headers.
         *
         * <p>API name: {@code v}
         */
        public final Builder v(@Nullable Boolean value) {
            this.v = value;
            return this;
        }

        /**
         * Builds a {@link AliasesRequest}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        public AliasesRequest build() {
            _checkSingleUse();

            return new AliasesRequest(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /** Endpoint "{@code cat.aliases}". */
    public static final Endpoint<AliasesRequest, AliasesResponse, ErrorResponse> _ENDPOINT =
            new SimpleEndpoint<>(
                    // Request method
                    request -> "GET",
                    // Request path
                    request -> {
                        final int _name = 1 << 0;

                        int propsSet = 0;

                        if (ApiTypeHelper.isDefined(request.name())) propsSet |= _name;

                        if (propsSet == 0) {
                            return "/_cat/aliases";
                        }
                        if (propsSet == (_name)) {
                            StringBuilder buf = new StringBuilder();
                            buf.append("/_cat/aliases/");
                            SimpleEndpoint.pathEncode(String.join(",", request.name), buf);
                            return buf.toString();
                        }

                        throw SimpleEndpoint.noPathTemplateFound("path");
                    },
                    // Request parameters
                    request -> {
                        Map<String, String> params = new HashMap<>();
                        if (ApiTypeHelper.isDefined(request.expandWildcards)) {
                            params.put(
                                    "expand_wildcards",
                                    request.expandWildcards.stream()
                                            .map(v -> v.jsonValue())
                                            .collect(Collectors.joining(",")));
                        }
                        if (request.format != null) {
                            params.put("format", request.format);
                        }
                        if (ApiTypeHelper.isDefined(request.h)) {
                            params.put("h", String.join(",", request.h));
                        }
                        if (request.help != null) {
                            params.put("help", String.valueOf(request.help));
                        }
                        if (request.local != null) {
                            params.put("local", String.valueOf(request.local));
                        }
                        if (ApiTypeHelper.isDefined(request.s)) {
                            params.put("s", String.join(",", request.s));
                        }
                        if (request.v != null) {
                            params.put("v", String.valueOf(request.v));
                        }
                        return params;
                    },
                    SimpleEndpoint.emptyMap(),
                    false,
                    AliasesResponse._DESERIALIZER);
}
