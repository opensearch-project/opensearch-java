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

import javax.annotation.Nullable;

import org.opensearch.client.Response;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.JsonpSerializable;
import org.opensearch.client.json.JsonpSerializer;
import org.opensearch.client.json.JsonpUtils;
import org.opensearch.client.opensearch._types.ErrorResponse;
import org.opensearch.client.opensearch._types.RequestBase;
import org.opensearch.client.transport.Endpoint;
import org.opensearch.client.transport.endpoints.SimpleEndpoint;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;

import jakarta.json.stream.JsonGenerator;

public class PutHttpRequest<TDocument> extends RequestBase implements JsonpSerializable {

    private final String path;
    private final Map<String, String> queryParams;
    private final Map<String, String> headers;

    private final TDocument document;

    @Nullable
    private final JsonpSerializer<TDocument> tDocumentSerializer;

    private PutHttpRequest(Builder<TDocument> builder) {
        this.path = ApiTypeHelper.requireNonNull(builder.path, this, "path");
        this.queryParams = ApiTypeHelper.unmodifiable(builder.queryParams);
        this.headers = ApiTypeHelper.unmodifiable(builder.headers);
        this.document = ApiTypeHelper.requireNonNull(builder.document, this, "document");
        this.tDocumentSerializer = builder.tDocumentSerializer;
    }

    public static <TDocument> PutHttpRequest<TDocument> of(
            Function<Builder<TDocument>, ObjectBuilder<PutHttpRequest<TDocument>>> fn) {
        return fn.apply(new Builder<>()).build();
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

    public final TDocument document() {
        return this.document;
    }

    public void serialize(JsonGenerator generator, JsonpMapper mapper) {
        JsonpUtils.serialize(this.document, generator, tDocumentSerializer, mapper);

    }

    public static class Builder<TDocument> extends ObjectBuilderBase
            implements ObjectBuilder<PutHttpRequest<TDocument>> {
        private String path;
        private Map<String, String> queryParams;
        private Map<String, String> headers;

        private TDocument document;

        @Nullable
        private JsonpSerializer<TDocument> tDocumentSerializer;

        public final Builder<TDocument> path(String path) {
            this.path = path;
            return this;
        }

        public final Builder<TDocument> queryParams(String key, String value) {
            this.queryParams = _mapPut(this.queryParams, key, value);
            return this;
        }

        public final Builder<TDocument> headers(String key, String value) {
            this.headers = _mapPut(this.headers, key, value);
            return this;
        }

        public final Builder<TDocument> queryParams(Map<String, String> queryParams) {
            this.queryParams = _mapPutAll(this.queryParams, queryParams);
            return this;
        }

        public final Builder<TDocument> headers(Map<String, String> headers) {
            this.headers = _mapPutAll(this.headers, headers);
            return this;
        }

        public final Builder<TDocument> document(TDocument value) {
            this.document = value;
            return this;
        }

        public final Builder<TDocument> tDocumentSerializer(@Nullable JsonpSerializer<TDocument> value) {
            this.tDocumentSerializer = value;
            return this;
        }

        public PutHttpRequest<TDocument> build() {
            _checkSingleUse();

            return new PutHttpRequest<TDocument>(this);
        }
    }

    public static final Endpoint<PutHttpRequest<?>, Response, ErrorResponse> _ENDPOINT = new SimpleEndpoint<>(

            // Request method
            request -> {
                return "PUT";

            }, request -> {
                return request.path;

            }, request -> {
                return request.queryParams;

            }, request -> {
                return request.headers;

            }, true, null);
}
