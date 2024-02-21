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

package org.opensearch.client.opensearch.nodes;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import javax.annotation.Nullable;
import org.opensearch.client.opensearch._types.ErrorResponse;
import org.opensearch.client.opensearch._types.RequestBase;
import org.opensearch.client.opensearch._types.Time;
import org.opensearch.client.transport.Endpoint;
import org.opensearch.client.transport.endpoints.SimpleEndpoint;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;

/**
* Returns low-level information about REST actions usage on nodes.
*/
public class UsageRequest extends RequestBase {

    private final List<String> metric;

    private final List<String> nodeId;

    @Nullable
    private final Time timeout;

    // ---------------------------------------------------------------------------------------------

    private UsageRequest(Builder builder) {
        this.metric = ApiTypeHelper.unmodifiable(builder.metric);
        this.nodeId = ApiTypeHelper.unmodifiable(builder.nodeId);
        this.timeout = builder.timeout;
    }

    public static UsageRequest of(Function<UsageRequest.Builder, ObjectBuilder<UsageRequest>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**

    * <p>Limits the information returned to the specific metrics.
    A comma-separated list of the following options: `_all`, `rest_actions`.</p>

    * <p>API name: {@code metric}</p>
    */
    public final List<String> metric() {
        return this.metric;
    }

    /**

    * <p>A comma-separated list of node IDs or names to limit the returned information; use `_local` to return information from the node you're connecting to, leave empty to get information from all nodes</p>

    * <p>API name: {@code node_id}</p>
    */
    public final List<String> nodeId() {
        return this.nodeId;
    }

    /**

    * <p>Period to wait for a response.
    If no response is received before the timeout expires, the request fails and returns an error.</p>

    * <p>API name: {@code timeout}</p>
    */
    @Nullable
    public final Time timeout() {
        return this.timeout;
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Builder for {@link UsageRequest}.
     */
    public static class Builder extends ObjectBuilderBase implements ObjectBuilder<UsageRequest> {
        @Nullable
        private List<String> metric;
        @Nullable
        private List<String> nodeId;
        @Nullable
        private Time timeout;

        /**
        * <p>Limits the information returned to the specific metrics.
        A comma-separated list of the following options: `_all`, `rest_actions`.</p>

        * <p>API name: {@code metric}</p>
        * <p>Adds all elements of <code>list</code> to <code>metric</code>.</p>
        */
        public final Builder metric(List<String> list) {
            this.metric = _listAddAll(this.metric, list);
            return this;
        }

        /**
        * <p>Limits the information returned to the specific metrics.
        A comma-separated list of the following options: `_all`, `rest_actions`.</p>

        * <p>API name: {@code metric}</p>
        * <p>Adds one or more values to <code>metric</code>.</p>
        */
        public final Builder metric(String value, String... values) {
            this.metric = _listAdd(this.metric, value, values);
            return this;
        }

        /**
        * <p>A comma-separated list of node IDs or names to limit the returned information; use `_local` to return information from the node you're connecting to, leave empty to get information from all nodes</p>

        * <p>API name: {@code node_id}</p>
        * <p>Adds all elements of <code>list</code> to <code>nodeId</code>.</p>
        */
        public final Builder nodeId(List<String> list) {
            this.nodeId = _listAddAll(this.nodeId, list);
            return this;
        }

        /**
        * <p>A comma-separated list of node IDs or names to limit the returned information; use `_local` to return information from the node you're connecting to, leave empty to get information from all nodes</p>

        * <p>API name: {@code node_id}</p>
        * <p>Adds one or more values to <code>nodeId</code>.</p>
        */
        public final Builder nodeId(String value, String... values) {
            this.nodeId = _listAdd(this.nodeId, value, values);
            return this;
        }

        /**

        * <p>Period to wait for a response.
        If no response is received before the timeout expires, the request fails and returns an error.</p>

        * <p>API name: {@code timeout}</p>
        */
        public final Builder timeout(@Nullable Time value) {
            this.timeout = value;
            return this;
        }

        /**

        * <p>Period to wait for a response.
        If no response is received before the timeout expires, the request fails and returns an error.</p>

        * <p>API name: {@code timeout}</p>
        */
        public final Builder timeout(Function<Time.Builder, ObjectBuilder<Time>> fn) {
            return this.timeout(fn.apply(new Time.Builder()).build());
        }

        /**
         * Builds a {@link UsageRequest}.
         *
         * @throws NullPointerException
         *              if some of the required fields are null.
         */
        public UsageRequest build() {
            _checkSingleUse();

            return new UsageRequest(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Endpoint "{@code nodes.usage}".
     */
    public static final Endpoint<UsageRequest, UsageResponse, ErrorResponse> _ENDPOINT = new SimpleEndpoint<>(
        // Request method
        request -> "GET",
        // Request path
        request -> {
            final int _metric = 1 << 0;
            final int _nodeId = 1 << 1;

            int propsSet = 0;

            if (ApiTypeHelper.isDefined(request.metric())) propsSet |= _metric;
            if (ApiTypeHelper.isDefined(request.nodeId())) propsSet |= _nodeId;

            if (propsSet == 0) {
                return "/_nodes/usage";
            }
            if (propsSet == (_metric)) {
                StringBuilder buf = new StringBuilder();
                buf.append("/_nodes/usage/");
                SimpleEndpoint.pathEncode(String.join(",", request.metric), buf);
                return buf.toString();
            }
            if (propsSet == (_nodeId)) {
                StringBuilder buf = new StringBuilder();
                buf.append("/_nodes/");
                SimpleEndpoint.pathEncode(String.join(",", request.nodeId), buf);
                buf.append("/usage");
                return buf.toString();
            }
            if (propsSet == (_nodeId | _metric)) {
                StringBuilder buf = new StringBuilder();
                buf.append("/_nodes/");
                SimpleEndpoint.pathEncode(String.join(",", request.nodeId), buf);
                buf.append("/usage/");
                SimpleEndpoint.pathEncode(String.join(",", request.metric), buf);
                return buf.toString();
            }

            throw SimpleEndpoint.noPathTemplateFound("path");
        },
        // Request parameters
        request -> {
            Map<String, String> params = new HashMap<>();
            if (request.timeout != null) {
                params.put("timeout", request.timeout._toJsonString());
            }
            return params;
        },
        SimpleEndpoint.emptyMap(),
        false,
        UsageResponse._DESERIALIZER
    );
}
