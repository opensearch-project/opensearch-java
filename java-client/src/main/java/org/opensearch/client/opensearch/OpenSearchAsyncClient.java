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

package org.opensearch.client.opensearch;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;
import javax.annotation.Nullable;
import org.opensearch.client.opensearch._types.ErrorResponse;
import org.opensearch.client.opensearch._types.OpenSearchException;
import org.opensearch.client.opensearch.core.BulkRequest;
import org.opensearch.client.opensearch.core.BulkResponse;
import org.opensearch.client.opensearch.core.CreateRequest;
import org.opensearch.client.opensearch.core.CreateResponse;
import org.opensearch.client.opensearch.core.IndexRequest;
import org.opensearch.client.opensearch.core.IndexResponse;
import org.opensearch.client.opensearch.core.MgetRequest;
import org.opensearch.client.opensearch.core.MgetResponse;
import org.opensearch.client.opensearch.core.MsearchRequest;
import org.opensearch.client.opensearch.core.MsearchResponse;
import org.opensearch.client.opensearch.core.MsearchTemplateRequest;
import org.opensearch.client.opensearch.core.MsearchTemplateResponse;
import org.opensearch.client.opensearch.core.TermvectorsRequest;
import org.opensearch.client.opensearch.core.TermvectorsResponse;
import org.opensearch.client.opensearch.core.UpdateRequest;
import org.opensearch.client.opensearch.core.UpdateResponse;
import org.opensearch.client.transport.JsonEndpoint;
import org.opensearch.client.transport.OpenSearchTransport;
import org.opensearch.client.transport.TransportOptions;
import org.opensearch.client.transport.endpoints.EndpointWithResponseMapperAttr;
import org.opensearch.client.util.ObjectBuilder;

/**
 * Client for the namespace.
 */
public class OpenSearchAsyncClient extends OpenSearchAsyncClientBase<OpenSearchAsyncClient> {
    public OpenSearchAsyncClient(OpenSearchTransport transport) {
        super(transport, null);
    }

    public OpenSearchAsyncClient(OpenSearchTransport transport, @Nullable TransportOptions transportOptions) {
        super(transport, transportOptions);
    }

    @Override
    public OpenSearchAsyncClient withTransportOptions(@Nullable TransportOptions transportOptions) {
        return new OpenSearchAsyncClient(this.transport, transportOptions);
    }

    // ----- Endpoint: bulk

    /**
     * Allows to perform multiple index/update/delete operations in a single
     * request.
     *
     *
     */

    public CompletableFuture<BulkResponse> bulk(BulkRequest request) throws IOException, OpenSearchException {
        @SuppressWarnings("unchecked")
        JsonEndpoint<BulkRequest, BulkResponse, ErrorResponse> endpoint = (JsonEndpoint<
            BulkRequest,
            BulkResponse,
            ErrorResponse>) BulkRequest._ENDPOINT;

        return this.transport.performRequestAsync(request, endpoint, this.transportOptions);
    }

    /**
     * Allows to perform multiple index/update/delete operations in a single
     * request.
     *
     * @param fn
     *            a function that initializes a builder to create the
     *            {@link BulkRequest}
     *
     */

    public final CompletableFuture<BulkResponse> bulk(Function<BulkRequest.Builder, ObjectBuilder<BulkRequest>> fn) throws IOException,
        OpenSearchException {
        return bulk(fn.apply(new BulkRequest.Builder()).build());
    }

    /**
     * Allows to perform multiple index/update/delete operations in a single
     * request.
     *
     *
     */

    public CompletableFuture<BulkResponse> bulk() throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(new BulkRequest.Builder().build(), BulkRequest._ENDPOINT, this.transportOptions);
    }

    // ----- Endpoint: create

    /**
     * Creates a new document in the index.
     * <p>
     * Returns a 409 response when a document with a same ID already exists in the
     * index.
     *
     *
     */

    public <TDocument> CompletableFuture<CreateResponse> create(CreateRequest<TDocument> request) throws IOException, OpenSearchException {
        @SuppressWarnings("unchecked")
        JsonEndpoint<CreateRequest<?>, CreateResponse, ErrorResponse> endpoint = (JsonEndpoint<
            CreateRequest<?>,
            CreateResponse,
            ErrorResponse>) CreateRequest._ENDPOINT;

        return this.transport.performRequestAsync(request, endpoint, this.transportOptions);
    }

    /**
     * Creates a new document in the index.
     * <p>
     * Returns a 409 response when a document with a same ID already exists in the
     * index.
     *
     * @param fn
     *            a function that initializes a builder to create the
     *            {@link CreateRequest}
     *
     */

    public final <TDocument> CompletableFuture<CreateResponse> create(
        Function<CreateRequest.Builder<TDocument>, ObjectBuilder<CreateRequest<TDocument>>> fn
    ) throws IOException, OpenSearchException {
        return create(fn.apply(new CreateRequest.Builder<TDocument>()).build());
    }

    // ----- Endpoint: index

    /**
     * Creates or updates a document in an index.
     *
     *
     */

    public <TDocument> CompletableFuture<IndexResponse> index(IndexRequest<TDocument> request) throws IOException, OpenSearchException {
        @SuppressWarnings("unchecked")
        JsonEndpoint<IndexRequest<?>, IndexResponse, ErrorResponse> endpoint = (JsonEndpoint<
            IndexRequest<?>,
            IndexResponse,
            ErrorResponse>) IndexRequest._ENDPOINT;

        return this.transport.performRequestAsync(request, endpoint, this.transportOptions);
    }

    /**
     * Creates or updates a document in an index.
     *
     * @param fn
     *            a function that initializes a builder to create the
     *            {@link IndexRequest}
     *
     */

    public final <TDocument> CompletableFuture<IndexResponse> index(
        Function<IndexRequest.Builder<TDocument>, ObjectBuilder<IndexRequest<TDocument>>> fn
    ) throws IOException, OpenSearchException {
        return index(fn.apply(new IndexRequest.Builder<TDocument>()).build());
    }

    // ----- Endpoint: mget

    /**
     * Allows to get multiple documents in one request.
     *
     *
     */

    public <TDocument> CompletableFuture<MgetResponse<TDocument>> mget(MgetRequest request, Class<TDocument> tDocumentClass)
        throws IOException, OpenSearchException {
        @SuppressWarnings("unchecked")
        JsonEndpoint<MgetRequest, MgetResponse<TDocument>, ErrorResponse> endpoint = (JsonEndpoint<
            MgetRequest,
            MgetResponse<TDocument>,
            ErrorResponse>) MgetRequest._ENDPOINT;
        endpoint = new EndpointWithResponseMapperAttr<>(
            endpoint,
            "org.opensearch.client:Deserializer:_global.mget.TDocument",
            getDeserializer(tDocumentClass)
        );

        return this.transport.performRequestAsync(request, endpoint, this.transportOptions);
    }

    /**
     * Allows to get multiple documents in one request.
     *
     * @param fn
     *            a function that initializes a builder to create the
     *            {@link MgetRequest}
     *
     */

    public final <TDocument> CompletableFuture<MgetResponse<TDocument>> mget(
        Function<MgetRequest.Builder, ObjectBuilder<MgetRequest>> fn,
        Class<TDocument> tDocumentClass
    ) throws IOException, OpenSearchException {
        return mget(fn.apply(new MgetRequest.Builder()).build(), tDocumentClass);
    }

    // ----- Endpoint: msearch

    /**
     * Allows to execute several search operations in one request.
     *
     *
     */

    public <TDocument> CompletableFuture<MsearchResponse<TDocument>> msearch(MsearchRequest request, Class<TDocument> tDocumentClass)
        throws IOException, OpenSearchException {
        @SuppressWarnings("unchecked")
        JsonEndpoint<MsearchRequest, MsearchResponse<TDocument>, ErrorResponse> endpoint = (JsonEndpoint<
            MsearchRequest,
            MsearchResponse<TDocument>,
            ErrorResponse>) MsearchRequest._ENDPOINT;
        endpoint = new EndpointWithResponseMapperAttr<>(
            endpoint,
            "org.opensearch.client:Deserializer:_global.msearch.TDocument",
            getDeserializer(tDocumentClass)
        );

        return this.transport.performRequestAsync(request, endpoint, this.transportOptions);
    }

    /**
     * Allows to execute several search operations in one request.
     *
     * @param fn
     *            a function that initializes a builder to create the
     *            {@link MsearchRequest}
     *
     */

    public final <TDocument> CompletableFuture<MsearchResponse<TDocument>> msearch(
        Function<MsearchRequest.Builder, ObjectBuilder<MsearchRequest>> fn,
        Class<TDocument> tDocumentClass
    ) throws IOException, OpenSearchException {
        return msearch(fn.apply(new MsearchRequest.Builder()).build(), tDocumentClass);
    }

    // ----- Endpoint: msearch_template

    /**
     * Allows to execute several search template operations in one request.
     *
     *
     */

    public <TDocument> CompletableFuture<MsearchTemplateResponse<TDocument>> msearchTemplate(
        MsearchTemplateRequest request,
        Class<TDocument> tDocumentClass
    ) throws IOException, OpenSearchException {
        @SuppressWarnings("unchecked")
        JsonEndpoint<MsearchTemplateRequest, MsearchTemplateResponse<TDocument>, ErrorResponse> endpoint = (JsonEndpoint<
            MsearchTemplateRequest,
            MsearchTemplateResponse<TDocument>,
            ErrorResponse>) MsearchTemplateRequest._ENDPOINT;
        endpoint = new EndpointWithResponseMapperAttr<>(
            endpoint,
            "org.opensearch.client:Deserializer:_global.msearch_template.TDocument",
            getDeserializer(tDocumentClass)
        );

        return this.transport.performRequestAsync(request, endpoint, this.transportOptions);
    }

    /**
     * Allows to execute several search template operations in one request.
     *
     * @param fn
     *            a function that initializes a builder to create the
     *            {@link MsearchTemplateRequest}
     *
     */

    public final <TDocument> CompletableFuture<MsearchTemplateResponse<TDocument>> msearchTemplate(
        Function<MsearchTemplateRequest.Builder, ObjectBuilder<MsearchTemplateRequest>> fn,
        Class<TDocument> tDocumentClass
    ) throws IOException, OpenSearchException {
        return msearchTemplate(fn.apply(new MsearchTemplateRequest.Builder()).build(), tDocumentClass);
    }

    // ----- Endpoint: termvectors

    /**
     * Returns information and statistics about terms in the fields of a particular
     * document.
     *
     *
     */

    public <TDocument> CompletableFuture<TermvectorsResponse> termvectors(TermvectorsRequest<TDocument> request) throws IOException,
        OpenSearchException {
        @SuppressWarnings("unchecked")
        JsonEndpoint<TermvectorsRequest<?>, TermvectorsResponse, ErrorResponse> endpoint = (JsonEndpoint<
            TermvectorsRequest<?>,
            TermvectorsResponse,
            ErrorResponse>) TermvectorsRequest._ENDPOINT;

        return this.transport.performRequestAsync(request, endpoint, this.transportOptions);
    }

    /**
     * Returns information and statistics about terms in the fields of a particular
     * document.
     *
     * @param fn
     *            a function that initializes a builder to create the
     *            {@link TermvectorsRequest}
     *
     */

    public final <TDocument> CompletableFuture<TermvectorsResponse> termvectors(
        Function<TermvectorsRequest.Builder<TDocument>, ObjectBuilder<TermvectorsRequest<TDocument>>> fn
    ) throws IOException, OpenSearchException {
        return termvectors(fn.apply(new TermvectorsRequest.Builder<TDocument>()).build());
    }

    // ----- Endpoint: update

    /**
     * Updates a document with a script or partial document.
     *
     *
     */

    public <TDocument, TPartialDocument> CompletableFuture<UpdateResponse<TDocument>> update(
        UpdateRequest<TDocument, TPartialDocument> request,
        Class<TDocument> tDocumentClass
    ) throws IOException, OpenSearchException {
        @SuppressWarnings("unchecked")
        JsonEndpoint<UpdateRequest<?, ?>, UpdateResponse<TDocument>, ErrorResponse> endpoint = (JsonEndpoint<
            UpdateRequest<?, ?>,
            UpdateResponse<TDocument>,
            ErrorResponse>) UpdateRequest._ENDPOINT;
        endpoint = new EndpointWithResponseMapperAttr<>(
            endpoint,
            "org.opensearch.client:Deserializer:_global.update.TDocument",
            getDeserializer(tDocumentClass)
        );

        return this.transport.performRequestAsync(request, endpoint, this.transportOptions);
    }

    /**
     * Updates a document with a script or partial document.
     *
     * @param fn
     *            a function that initializes a builder to create the
     *            {@link UpdateRequest}
     *
     */

    public final <TDocument, TPartialDocument> CompletableFuture<UpdateResponse<TDocument>> update(
        Function<UpdateRequest.Builder<TDocument, TPartialDocument>, ObjectBuilder<UpdateRequest<TDocument, TPartialDocument>>> fn,
        Class<TDocument> tDocumentClass
    ) throws IOException, OpenSearchException {
        return update(fn.apply(new UpdateRequest.Builder<TDocument, TPartialDocument>()).build(), tDocumentClass);
    }
}
