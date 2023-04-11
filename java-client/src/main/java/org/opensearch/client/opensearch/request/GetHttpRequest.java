/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.opensearch.request;

import java.util.Map;
import java.util.function.Function;

import org.opensearch.client.opensearch._types.RequestBase;
import org.opensearch.client.transport.endpoints.SimpleEndpoint;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;

public class GetHttpRequest extends RequestBase {

    private final String path;
    private final Map<String, String> queryParams;
    private final Map<String, String> headers;

    private GetHttpRequest(Builder builder) {
        this.path = ApiTypeHelper.requireNonNull(builder.path, this, "path");
        this.queryParams = ApiTypeHelper.unmodifiable(builder.queryParams);
        this.headers = ApiTypeHelper.unmodifiable(builder.headers);
    }

    public static GetHttpRequest of(Function<Builder, ObjectBuilder<GetHttpRequest>> fn) {
        return fn.apply(new Builder()).build();
    }

    public final String path() {
        return this.path;
    }

    public final Map<String, String> queryParams() {
        return this.queryParams;
    }

    public final Map<String, String> headers() {
        return this.headers;
    }

    public static class Builder extends ObjectBuilderBase implements ObjectBuilder<GetHttpRequest> {

        private String path;
        private Map<String, String> queryParams;
        private Map<String, String> headers;

        public final Builder path(String path) {
            this.path = path;
            return this;
        }

        public final Builder queryParams(String key, String value) {
            this.queryParams = _mapPut(this.queryParams, key, value);
            return this;
        }

        public final Builder headers(String key, String value) {
            this.headers = _mapPut(this.headers, key, value);
            return this;
        }

        public final Builder queryParams(Map<String, String> queryParams) {
            this.queryParams = _mapPutAll(this.queryParams, queryParams);
            return this;
        }

        public final Builder headers(Map<String, String> headers) {
            this.headers = _mapPutAll(this.headers, headers);
            return this;
        }

        public GetHttpRequest build() {
            _checkSingleUse();
            return new GetHttpRequest(this);
        }

    }

    public static final SimpleEndpoint<GetHttpRequest, ?> _ENDPOINT = new SimpleEndpoint<>(request -> {
        return "GET";

    }, request -> {
        return request.path;

    }, request -> {
        return request.queryParams;

    }, request -> {
        return request.headers;

    }, false, null);

}
