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
import org.opensearch.client.opensearch.core.DeleteScriptRequest;
import org.opensearch.client.opensearch.core.DeleteScriptResponse;
import org.opensearch.client.opensearch.core.ExistsRequest;
import org.opensearch.client.opensearch.core.ExistsSourceRequest;
import org.opensearch.client.opensearch.core.ExplainRequest;
import org.opensearch.client.opensearch.core.ExplainResponse;
import org.opensearch.client.opensearch.core.FieldCapsRequest;
import org.opensearch.client.opensearch.core.FieldCapsResponse;
import org.opensearch.client.opensearch.core.GetRequest;
import org.opensearch.client.opensearch.core.GetResponse;
import org.opensearch.client.opensearch.core.GetScriptContextRequest;
import org.opensearch.client.opensearch.core.GetScriptContextResponse;
import org.opensearch.client.opensearch.core.GetScriptLanguagesRequest;
import org.opensearch.client.opensearch.core.GetScriptLanguagesResponse;
import org.opensearch.client.opensearch.core.GetScriptRequest;
import org.opensearch.client.opensearch.core.GetScriptResponse;
import org.opensearch.client.opensearch.core.GetSourceRequest;
import org.opensearch.client.opensearch.core.GetSourceResponse;
import org.opensearch.client.opensearch.core.IndexRequest;
import org.opensearch.client.opensearch.core.IndexResponse;
import org.opensearch.client.opensearch.core.MgetRequest;
import org.opensearch.client.opensearch.core.MgetResponse;
import org.opensearch.client.opensearch.core.MsearchRequest;
import org.opensearch.client.opensearch.core.MsearchResponse;
import org.opensearch.client.opensearch.core.MsearchTemplateRequest;
import org.opensearch.client.opensearch.core.MsearchTemplateResponse;
import org.opensearch.client.opensearch.core.MtermvectorsRequest;
import org.opensearch.client.opensearch.core.MtermvectorsResponse;
import org.opensearch.client.opensearch.core.PingRequest;
import org.opensearch.client.opensearch.core.PutScriptRequest;
import org.opensearch.client.opensearch.core.PutScriptResponse;
import org.opensearch.client.opensearch.core.RankEvalRequest;
import org.opensearch.client.opensearch.core.RankEvalResponse;
import org.opensearch.client.opensearch.core.RenderSearchTemplateRequest;
import org.opensearch.client.opensearch.core.RenderSearchTemplateResponse;
import org.opensearch.client.opensearch.core.ScriptsPainlessExecuteRequest;
import org.opensearch.client.opensearch.core.ScriptsPainlessExecuteResponse;
import org.opensearch.client.opensearch.core.ScrollRequest;
import org.opensearch.client.opensearch.core.ScrollResponse;
import org.opensearch.client.opensearch.core.SearchRequest;
import org.opensearch.client.opensearch.core.SearchResponse;
import org.opensearch.client.opensearch.core.SearchShardsRequest;
import org.opensearch.client.opensearch.core.SearchShardsResponse;
import org.opensearch.client.opensearch.core.SearchTemplateRequest;
import org.opensearch.client.opensearch.core.SearchTemplateResponse;
import org.opensearch.client.opensearch.core.TermsEnumRequest;
import org.opensearch.client.opensearch.core.TermsEnumResponse;
import org.opensearch.client.opensearch.core.TermvectorsRequest;
import org.opensearch.client.opensearch.core.TermvectorsResponse;
import org.opensearch.client.opensearch.core.UpdateRequest;
import org.opensearch.client.opensearch.core.UpdateResponse;
import org.opensearch.client.transport.JsonEndpoint;
import org.opensearch.client.transport.OpenSearchTransport;
import org.opensearch.client.transport.TransportOptions;
import org.opensearch.client.transport.endpoints.BooleanResponse;
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

    // ----- Endpoint: delete_script

    /**
     * Deletes a script.
     *
     *
     */

    public CompletableFuture<DeleteScriptResponse> deleteScript(DeleteScriptRequest request) throws IOException, OpenSearchException {
        @SuppressWarnings("unchecked")
        JsonEndpoint<DeleteScriptRequest, DeleteScriptResponse, ErrorResponse> endpoint = (JsonEndpoint<
            DeleteScriptRequest,
            DeleteScriptResponse,
            ErrorResponse>) DeleteScriptRequest._ENDPOINT;

        return this.transport.performRequestAsync(request, endpoint, this.transportOptions);
    }

    /**
     * Deletes a script.
     *
     * @param fn
     *            a function that initializes a builder to create the
     *            {@link DeleteScriptRequest}
     *
     */

    public final CompletableFuture<DeleteScriptResponse> deleteScript(
        Function<DeleteScriptRequest.Builder, ObjectBuilder<DeleteScriptRequest>> fn
    ) throws IOException, OpenSearchException {
        return deleteScript(fn.apply(new DeleteScriptRequest.Builder()).build());
    }

    // ----- Endpoint: exists

    /**
     * Returns information about whether a document exists in an index.
     *
     *
     */

    public CompletableFuture<BooleanResponse> exists(ExistsRequest request) throws IOException, OpenSearchException {
        @SuppressWarnings("unchecked")
        JsonEndpoint<ExistsRequest, BooleanResponse, ErrorResponse> endpoint = (JsonEndpoint<
            ExistsRequest,
            BooleanResponse,
            ErrorResponse>) ExistsRequest._ENDPOINT;

        return this.transport.performRequestAsync(request, endpoint, this.transportOptions);
    }

    /**
     * Returns information about whether a document exists in an index.
     *
     * @param fn
     *            a function that initializes a builder to create the
     *            {@link ExistsRequest}
     *
     */

    public final CompletableFuture<BooleanResponse> exists(Function<ExistsRequest.Builder, ObjectBuilder<ExistsRequest>> fn)
        throws IOException, OpenSearchException {
        return exists(fn.apply(new ExistsRequest.Builder()).build());
    }

    // ----- Endpoint: exists_source

    /**
     * Returns information about whether a document source exists in an index.
     *
     *
     */

    public CompletableFuture<BooleanResponse> existsSource(ExistsSourceRequest request) throws IOException, OpenSearchException {
        @SuppressWarnings("unchecked")
        JsonEndpoint<ExistsSourceRequest, BooleanResponse, ErrorResponse> endpoint = (JsonEndpoint<
            ExistsSourceRequest,
            BooleanResponse,
            ErrorResponse>) ExistsSourceRequest._ENDPOINT;

        return this.transport.performRequestAsync(request, endpoint, this.transportOptions);
    }

    /**
     * Returns information about whether a document source exists in an index.
     *
     * @param fn
     *            a function that initializes a builder to create the
     *            {@link ExistsSourceRequest}
     *
     */

    public final CompletableFuture<BooleanResponse> existsSource(
        Function<ExistsSourceRequest.Builder, ObjectBuilder<ExistsSourceRequest>> fn
    ) throws IOException, OpenSearchException {
        return existsSource(fn.apply(new ExistsSourceRequest.Builder()).build());
    }

    // ----- Endpoint: explain

    /**
     * Returns information about why a specific matches (or doesn't match) a query.
     *
     *
     */

    public <TDocument> CompletableFuture<ExplainResponse<TDocument>> explain(ExplainRequest request, Class<TDocument> tDocumentClass)
        throws IOException, OpenSearchException {
        @SuppressWarnings("unchecked")
        JsonEndpoint<ExplainRequest, ExplainResponse<TDocument>, ErrorResponse> endpoint = (JsonEndpoint<
            ExplainRequest,
            ExplainResponse<TDocument>,
            ErrorResponse>) ExplainRequest._ENDPOINT;
        endpoint = new EndpointWithResponseMapperAttr<>(
            endpoint,
            "org.opensearch.client:Deserializer:_global.explain.TDocument",
            getDeserializer(tDocumentClass)
        );

        return this.transport.performRequestAsync(request, endpoint, this.transportOptions);
    }

    /**
     * Returns information about why a specific matches (or doesn't match) a query.
     *
     * @param fn
     *            a function that initializes a builder to create the
     *            {@link ExplainRequest}
     *
     */

    public final <TDocument> CompletableFuture<ExplainResponse<TDocument>> explain(
        Function<ExplainRequest.Builder, ObjectBuilder<ExplainRequest>> fn,
        Class<TDocument> tDocumentClass
    ) throws IOException, OpenSearchException {
        return explain(fn.apply(new ExplainRequest.Builder()).build(), tDocumentClass);
    }

    // ----- Endpoint: field_caps

    /**
     * Returns the information about the capabilities of fields among multiple
     * indices.
     */

    public CompletableFuture<FieldCapsResponse> fieldCaps(FieldCapsRequest request) throws IOException, OpenSearchException {
        @SuppressWarnings("unchecked")
        JsonEndpoint<FieldCapsRequest, FieldCapsResponse, ErrorResponse> endpoint = (JsonEndpoint<
            FieldCapsRequest,
            FieldCapsResponse,
            ErrorResponse>) FieldCapsRequest._ENDPOINT;

        return this.transport.performRequestAsync(request, endpoint, this.transportOptions);
    }

    /**
     * Returns the information about the capabilities of fields among multiple
     * indices.
     *
     * @param fn
     *            a function that initializes a builder to create the
     *            {@link FieldCapsRequest}
     *
     */

    public final CompletableFuture<FieldCapsResponse> fieldCaps(Function<FieldCapsRequest.Builder, ObjectBuilder<FieldCapsRequest>> fn)
        throws IOException, OpenSearchException {
        return fieldCaps(fn.apply(new FieldCapsRequest.Builder()).build());
    }

    /**
     * Returns the information about the capabilities of fields among multiple
     * indices.
     *
     *
     */

    public CompletableFuture<FieldCapsResponse> fieldCaps() throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(
            new FieldCapsRequest.Builder().build(),
            FieldCapsRequest._ENDPOINT,
            this.transportOptions
        );
    }

    // ----- Endpoint: get

    /**
     * Returns a document.
     *
     *
     */

    public <TDocument> CompletableFuture<GetResponse<TDocument>> get(GetRequest request, Class<TDocument> tDocumentClass)
        throws IOException, OpenSearchException {
        @SuppressWarnings("unchecked")
        JsonEndpoint<GetRequest, GetResponse<TDocument>, ErrorResponse> endpoint = (JsonEndpoint<
            GetRequest,
            GetResponse<TDocument>,
            ErrorResponse>) GetRequest._ENDPOINT;
        endpoint = new EndpointWithResponseMapperAttr<>(
            endpoint,
            "org.opensearch.client:Deserializer:_global.get.TDocument",
            getDeserializer(tDocumentClass)
        );

        return this.transport.performRequestAsync(request, endpoint, this.transportOptions);
    }

    /**
     * Returns a document.
     *
     * @param fn
     *            a function that initializes a builder to create the
     *            {@link GetRequest}
     *
     */

    public final <TDocument> CompletableFuture<GetResponse<TDocument>> get(
        Function<GetRequest.Builder, ObjectBuilder<GetRequest>> fn,
        Class<TDocument> tDocumentClass
    ) throws IOException, OpenSearchException {
        return get(fn.apply(new GetRequest.Builder()).build(), tDocumentClass);
    }

    // ----- Endpoint: get_script

    /**
     * Returns a script.
     *
     *
     */

    public CompletableFuture<GetScriptResponse> getScript(GetScriptRequest request) throws IOException, OpenSearchException {
        @SuppressWarnings("unchecked")
        JsonEndpoint<GetScriptRequest, GetScriptResponse, ErrorResponse> endpoint = (JsonEndpoint<
            GetScriptRequest,
            GetScriptResponse,
            ErrorResponse>) GetScriptRequest._ENDPOINT;

        return this.transport.performRequestAsync(request, endpoint, this.transportOptions);
    }

    /**
     * Returns a script.
     *
     * @param fn
     *            a function that initializes a builder to create the
     *            {@link GetScriptRequest}
     *
     */

    public final CompletableFuture<GetScriptResponse> getScript(Function<GetScriptRequest.Builder, ObjectBuilder<GetScriptRequest>> fn)
        throws IOException, OpenSearchException {
        return getScript(fn.apply(new GetScriptRequest.Builder()).build());
    }

    // ----- Endpoint: get_script_context

    /**
     * Returns all script contexts.
     *
     *
     */
    public CompletableFuture<GetScriptContextResponse> getScriptContext() throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(
            GetScriptContextRequest._INSTANCE,
            GetScriptContextRequest._ENDPOINT,
            this.transportOptions
        );
    }

    // ----- Endpoint: get_script_languages

    /**
     * Returns available script types, languages and contexts
     *
     *
     */
    public CompletableFuture<GetScriptLanguagesResponse> getScriptLanguages() throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(
            GetScriptLanguagesRequest._INSTANCE,
            GetScriptLanguagesRequest._ENDPOINT,
            this.transportOptions
        );
    }

    // ----- Endpoint: get_source

    /**
     * Returns the source of a document.
     *
     *
     */

    public <TDocument> CompletableFuture<GetSourceResponse<TDocument>> getSource(GetSourceRequest request, Class<TDocument> tDocumentClass)
        throws IOException, OpenSearchException {
        @SuppressWarnings("unchecked")
        JsonEndpoint<GetSourceRequest, GetSourceResponse<TDocument>, ErrorResponse> endpoint = (JsonEndpoint<
            GetSourceRequest,
            GetSourceResponse<TDocument>,
            ErrorResponse>) GetSourceRequest._ENDPOINT;
        endpoint = new EndpointWithResponseMapperAttr<>(
            endpoint,
            "org.opensearch.client:Deserializer:_global.get_source.TDocument",
            getDeserializer(tDocumentClass)
        );

        return this.transport.performRequestAsync(request, endpoint, this.transportOptions);
    }

    /**
     * Returns the source of a document.
     *
     * @param fn
     *            a function that initializes a builder to create the
     *            {@link GetSourceRequest}
     *
     */

    public final <TDocument> CompletableFuture<GetSourceResponse<TDocument>> getSource(
        Function<GetSourceRequest.Builder, ObjectBuilder<GetSourceRequest>> fn,
        Class<TDocument> tDocumentClass
    ) throws IOException, OpenSearchException {
        return getSource(fn.apply(new GetSourceRequest.Builder()).build(), tDocumentClass);
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

    // ----- Endpoint: mtermvectors

    /**
     * Returns multiple termvectors in one request.
     *
     *
     */

    public CompletableFuture<MtermvectorsResponse> mtermvectors(MtermvectorsRequest request) throws IOException, OpenSearchException {
        @SuppressWarnings("unchecked")
        JsonEndpoint<MtermvectorsRequest, MtermvectorsResponse, ErrorResponse> endpoint = (JsonEndpoint<
            MtermvectorsRequest,
            MtermvectorsResponse,
            ErrorResponse>) MtermvectorsRequest._ENDPOINT;

        return this.transport.performRequestAsync(request, endpoint, this.transportOptions);
    }

    /**
     * Returns multiple termvectors in one request.
     *
     * @param fn
     *            a function that initializes a builder to create the
     *            {@link MtermvectorsRequest}
     *
     */

    public final CompletableFuture<MtermvectorsResponse> mtermvectors(
        Function<MtermvectorsRequest.Builder, ObjectBuilder<MtermvectorsRequest>> fn
    ) throws IOException, OpenSearchException {
        return mtermvectors(fn.apply(new MtermvectorsRequest.Builder()).build());
    }

    /**
     * Returns multiple termvectors in one request.
     *
     *
     */

    public CompletableFuture<MtermvectorsResponse> mtermvectors() throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(
            new MtermvectorsRequest.Builder().build(),
            MtermvectorsRequest._ENDPOINT,
            this.transportOptions
        );
    }

    // ----- Endpoint: ping

    /**
     * Returns whether the cluster is running.
     *
     *
     */
    public CompletableFuture<BooleanResponse> ping() throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(PingRequest._INSTANCE, PingRequest._ENDPOINT, this.transportOptions);
    }

    // ----- Endpoint: put_script

    /**
     * Creates or updates a script.
     *
     *
     */

    public CompletableFuture<PutScriptResponse> putScript(PutScriptRequest request) throws IOException, OpenSearchException {
        @SuppressWarnings("unchecked")
        JsonEndpoint<PutScriptRequest, PutScriptResponse, ErrorResponse> endpoint = (JsonEndpoint<
            PutScriptRequest,
            PutScriptResponse,
            ErrorResponse>) PutScriptRequest._ENDPOINT;

        return this.transport.performRequestAsync(request, endpoint, this.transportOptions);
    }

    /**
     * Creates or updates a script.
     *
     * @param fn
     *            a function that initializes a builder to create the
     *            {@link PutScriptRequest}
     *
     */

    public final CompletableFuture<PutScriptResponse> putScript(Function<PutScriptRequest.Builder, ObjectBuilder<PutScriptRequest>> fn)
        throws IOException, OpenSearchException {
        return putScript(fn.apply(new PutScriptRequest.Builder()).build());
    }

    // ----- Endpoint: rank_eval

    /**
     * Allows to evaluate the quality of ranked search results over a set of typical
     * search queries
     *
     *
     */

    public CompletableFuture<RankEvalResponse> rankEval(RankEvalRequest request) throws IOException, OpenSearchException {
        @SuppressWarnings("unchecked")
        JsonEndpoint<RankEvalRequest, RankEvalResponse, ErrorResponse> endpoint = (JsonEndpoint<
            RankEvalRequest,
            RankEvalResponse,
            ErrorResponse>) RankEvalRequest._ENDPOINT;

        return this.transport.performRequestAsync(request, endpoint, this.transportOptions);
    }

    /**
     * Allows to evaluate the quality of ranked search results over a set of typical
     * search queries
     *
     * @param fn
     *            a function that initializes a builder to create the
     *            {@link RankEvalRequest}
     *
     */

    public final CompletableFuture<RankEvalResponse> rankEval(Function<RankEvalRequest.Builder, ObjectBuilder<RankEvalRequest>> fn)
        throws IOException, OpenSearchException {
        return rankEval(fn.apply(new RankEvalRequest.Builder()).build());
    }

    // ----- Endpoint: render_search_template

    /**
     * Allows to use the Mustache language to pre-render a search definition.
     *
     *
     */

    public CompletableFuture<RenderSearchTemplateResponse> renderSearchTemplate(RenderSearchTemplateRequest request) throws IOException,
        OpenSearchException {
        @SuppressWarnings("unchecked")
        JsonEndpoint<RenderSearchTemplateRequest, RenderSearchTemplateResponse, ErrorResponse> endpoint = (JsonEndpoint<
            RenderSearchTemplateRequest,
            RenderSearchTemplateResponse,
            ErrorResponse>) RenderSearchTemplateRequest._ENDPOINT;

        return this.transport.performRequestAsync(request, endpoint, this.transportOptions);
    }

    /**
     * Allows to use the Mustache language to pre-render a search definition.
     *
     * @param fn
     *            a function that initializes a builder to create the
     *            {@link RenderSearchTemplateRequest}
     *
     */

    public final CompletableFuture<RenderSearchTemplateResponse> renderSearchTemplate(
        Function<RenderSearchTemplateRequest.Builder, ObjectBuilder<RenderSearchTemplateRequest>> fn
    ) throws IOException, OpenSearchException {
        return renderSearchTemplate(fn.apply(new RenderSearchTemplateRequest.Builder()).build());
    }

    /**
     * Allows to use the Mustache language to pre-render a search definition.
     *
     *
     */

    public CompletableFuture<RenderSearchTemplateResponse> renderSearchTemplate() throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(
            new RenderSearchTemplateRequest.Builder().build(),
            RenderSearchTemplateRequest._ENDPOINT,
            this.transportOptions
        );
    }

    // ----- Endpoint: scripts_painless_execute

    /**
     * Allows an arbitrary script to be executed and a result to be returned
     *
     *
     */

    public <TResult> CompletableFuture<ScriptsPainlessExecuteResponse<TResult>> scriptsPainlessExecute(
        ScriptsPainlessExecuteRequest request,
        Class<TResult> tResultClass
    ) throws IOException, OpenSearchException {
        @SuppressWarnings("unchecked")
        JsonEndpoint<ScriptsPainlessExecuteRequest, ScriptsPainlessExecuteResponse<TResult>, ErrorResponse> endpoint = (JsonEndpoint<
            ScriptsPainlessExecuteRequest,
            ScriptsPainlessExecuteResponse<TResult>,
            ErrorResponse>) ScriptsPainlessExecuteRequest._ENDPOINT;
        endpoint = new EndpointWithResponseMapperAttr<>(
            endpoint,
            "org.opensearch.client:Deserializer:_global.scripts_painless_execute.TResult",
            getDeserializer(tResultClass)
        );

        return this.transport.performRequestAsync(request, endpoint, this.transportOptions);
    }

    /**
     * Allows an arbitrary script to be executed and a result to be returned
     *
     * @param fn
     *            a function that initializes a builder to create the
     *            {@link ScriptsPainlessExecuteRequest}
     *
     */

    public final <TResult> CompletableFuture<ScriptsPainlessExecuteResponse<TResult>> scriptsPainlessExecute(
        Function<ScriptsPainlessExecuteRequest.Builder, ObjectBuilder<ScriptsPainlessExecuteRequest>> fn,
        Class<TResult> tResultClass
    ) throws IOException, OpenSearchException {
        return scriptsPainlessExecute(fn.apply(new ScriptsPainlessExecuteRequest.Builder()).build(), tResultClass);
    }

    // ----- Endpoint: scroll

    /**
     * Allows to retrieve a large numbers of results from a single search request.
     *
     */

    public <TDocument> CompletableFuture<ScrollResponse<TDocument>> scroll(ScrollRequest request, Class<TDocument> tDocumentClass)
        throws IOException, OpenSearchException {
        @SuppressWarnings("unchecked")
        JsonEndpoint<ScrollRequest, ScrollResponse<TDocument>, ErrorResponse> endpoint = (JsonEndpoint<
            ScrollRequest,
            ScrollResponse<TDocument>,
            ErrorResponse>) ScrollRequest._ENDPOINT;
        endpoint = new EndpointWithResponseMapperAttr<>(
            endpoint,
            "org.opensearch.client:Deserializer:_global.scroll.TDocument",
            getDeserializer(tDocumentClass)
        );

        return this.transport.performRequestAsync(request, endpoint, this.transportOptions);
    }

    /**
     * Allows to retrieve a large numbers of results from a single search request.
     *
     * @param fn
     *            a function that initializes a builder to create the
     *            {@link ScrollRequest}
     */

    public final <TDocument> CompletableFuture<ScrollResponse<TDocument>> scroll(
        Function<ScrollRequest.Builder, ObjectBuilder<ScrollRequest>> fn,
        Class<TDocument> tDocumentClass
    ) throws IOException, OpenSearchException {
        return scroll(fn.apply(new ScrollRequest.Builder()).build(), tDocumentClass);
    }

    // ----- Endpoint: search

    /**
     * Returns results matching a query.
     *
     *
     */

    public <TDocument> CompletableFuture<SearchResponse<TDocument>> search(SearchRequest request, Class<TDocument> tDocumentClass)
        throws IOException, OpenSearchException {
        @SuppressWarnings("unchecked")
        JsonEndpoint<SearchRequest, SearchResponse<TDocument>, ErrorResponse> endpoint = (JsonEndpoint<
            SearchRequest,
            SearchResponse<TDocument>,
            ErrorResponse>) SearchRequest._ENDPOINT;
        endpoint = new EndpointWithResponseMapperAttr<>(
            endpoint,
            "org.opensearch.client:Deserializer:_global.search.TDocument",
            getDeserializer(tDocumentClass)
        );

        return this.transport.performRequestAsync(request, endpoint, this.transportOptions);
    }

    /**
     * Returns results matching a query.
     *
     * @param fn
     *            a function that initializes a builder to create the
     *            {@link SearchRequest}
     *
     */

    public final <TDocument> CompletableFuture<SearchResponse<TDocument>> search(
        Function<SearchRequest.Builder, ObjectBuilder<SearchRequest>> fn,
        Class<TDocument> tDocumentClass
    ) throws IOException, OpenSearchException {
        return search(fn.apply(new SearchRequest.Builder()).build(), tDocumentClass);
    }

    // ----- Endpoint: search_shards

    /**
     * Returns information about the indices and shards that a search request would
     * be executed against.
     *
     *
     */

    public CompletableFuture<SearchShardsResponse> searchShards(SearchShardsRequest request) throws IOException, OpenSearchException {
        @SuppressWarnings("unchecked")
        JsonEndpoint<SearchShardsRequest, SearchShardsResponse, ErrorResponse> endpoint = (JsonEndpoint<
            SearchShardsRequest,
            SearchShardsResponse,
            ErrorResponse>) SearchShardsRequest._ENDPOINT;

        return this.transport.performRequestAsync(request, endpoint, this.transportOptions);
    }

    /**
     * Returns information about the indices and shards that a search request would
     * be executed against.
     *
     * @param fn
     *            a function that initializes a builder to create the
     *            {@link SearchShardsRequest}
     *
     */

    public final CompletableFuture<SearchShardsResponse> searchShards(
        Function<SearchShardsRequest.Builder, ObjectBuilder<SearchShardsRequest>> fn
    ) throws IOException, OpenSearchException {
        return searchShards(fn.apply(new SearchShardsRequest.Builder()).build());
    }

    /**
     * Returns information about the indices and shards that a search request would
     * be executed against.
     *
     *
     */

    public CompletableFuture<SearchShardsResponse> searchShards() throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(
            new SearchShardsRequest.Builder().build(),
            SearchShardsRequest._ENDPOINT,
            this.transportOptions
        );
    }

    // ----- Endpoint: search_template

    /**
     * Allows to use the Mustache language to pre-render a search definition.
     *
     *
     */

    public <TDocument> CompletableFuture<SearchTemplateResponse<TDocument>> searchTemplate(
        SearchTemplateRequest request,
        Class<TDocument> tDocumentClass
    ) throws IOException, OpenSearchException {
        @SuppressWarnings("unchecked")
        JsonEndpoint<SearchTemplateRequest, SearchTemplateResponse<TDocument>, ErrorResponse> endpoint = (JsonEndpoint<
            SearchTemplateRequest,
            SearchTemplateResponse<TDocument>,
            ErrorResponse>) SearchTemplateRequest._ENDPOINT;
        endpoint = new EndpointWithResponseMapperAttr<>(
            endpoint,
            "org.opensearch.client:Deserializer:_global.search_template.TDocument",
            getDeserializer(tDocumentClass)
        );

        return this.transport.performRequestAsync(request, endpoint, this.transportOptions);
    }

    /**
     * Allows to use the Mustache language to pre-render a search definition.
     *
     * @param fn
     *            a function that initializes a builder to create the
     *            {@link SearchTemplateRequest}
     *
     */

    public final <TDocument> CompletableFuture<SearchTemplateResponse<TDocument>> searchTemplate(
        Function<SearchTemplateRequest.Builder, ObjectBuilder<SearchTemplateRequest>> fn,
        Class<TDocument> tDocumentClass
    ) throws IOException, OpenSearchException {
        return searchTemplate(fn.apply(new SearchTemplateRequest.Builder()).build(), tDocumentClass);
    }

    // ----- Endpoint: terms_enum

    /**
     * The terms enum API can be used to discover terms in the index that begin with
     * the provided string. It is designed for low-latency look-ups used in
     * auto-complete scenarios.
     *
     *
     */

    public CompletableFuture<TermsEnumResponse> termsEnum(TermsEnumRequest request) throws IOException, OpenSearchException {
        @SuppressWarnings("unchecked")
        JsonEndpoint<TermsEnumRequest, TermsEnumResponse, ErrorResponse> endpoint = (JsonEndpoint<
            TermsEnumRequest,
            TermsEnumResponse,
            ErrorResponse>) TermsEnumRequest._ENDPOINT;

        return this.transport.performRequestAsync(request, endpoint, this.transportOptions);
    }

    /**
     * The terms enum API can be used to discover terms in the index that begin with
     * the provided string. It is designed for low-latency look-ups used in
     * auto-complete scenarios.
     *
     * @param fn
     *            a function that initializes a builder to create the
     *            {@link TermsEnumRequest}
     *
     */

    public final CompletableFuture<TermsEnumResponse> termsEnum(Function<TermsEnumRequest.Builder, ObjectBuilder<TermsEnumRequest>> fn)
        throws IOException, OpenSearchException {
        return termsEnum(fn.apply(new TermsEnumRequest.Builder()).build());
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
