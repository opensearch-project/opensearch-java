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

package org.opensearch.client.opensearch.search_relevance;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nullable;
import org.opensearch.client.ApiClient;
import org.opensearch.client.opensearch._types.ErrorResponse;
import org.opensearch.client.opensearch._types.OpenSearchException;
import org.opensearch.client.transport.JsonEndpoint;
import org.opensearch.client.transport.OpenSearchTransport;
import org.opensearch.client.transport.TransportOptions;
import org.opensearch.client.transport.endpoints.EndpointWithResponseMapperAttr;
import org.opensearch.client.util.ObjectBuilder;

/**
 * Client for the search_relevance namespace.
 */
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class OpenSearchSearchRelevanceAsyncClient extends ApiClient<OpenSearchTransport, OpenSearchSearchRelevanceAsyncClient> {
    public OpenSearchSearchRelevanceAsyncClient(OpenSearchTransport transport) {
        super(transport, null);
    }

    public OpenSearchSearchRelevanceAsyncClient(OpenSearchTransport transport, @Nullable TransportOptions transportOptions) {
        super(transport, transportOptions);
    }

    @Override
    public OpenSearchSearchRelevanceAsyncClient withTransportOptions(@Nullable TransportOptions transportOptions) {
        return new OpenSearchSearchRelevanceAsyncClient(this.transport, transportOptions);
    }

    // ----- Endpoint: search_relevance.delete_experiments

    /**
     * Deletes a specified experiment.
     */
    public CompletableFuture<DeleteExperimentsResponse> deleteExperiments(DeleteExperimentsRequest request) throws IOException,
        OpenSearchException {
        return this.transport.performRequestAsync(request, DeleteExperimentsRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Deletes a specified experiment.
     *
     * @param fn a function that initializes a builder to create the {@link DeleteExperimentsRequest}
     */
    public final CompletableFuture<DeleteExperimentsResponse> deleteExperiments(
        Function<DeleteExperimentsRequest.Builder, ObjectBuilder<DeleteExperimentsRequest>> fn
    ) throws IOException, OpenSearchException {
        return deleteExperiments(fn.apply(new DeleteExperimentsRequest.Builder()).build());
    }

    // ----- Endpoint: search_relevance.delete_judgments

    /**
     * Deletes a specified judgment.
     */
    public CompletableFuture<DeleteJudgmentsResponse> deleteJudgments(DeleteJudgmentsRequest request) throws IOException,
        OpenSearchException {
        return this.transport.performRequestAsync(request, DeleteJudgmentsRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Deletes a specified judgment.
     *
     * @param fn a function that initializes a builder to create the {@link DeleteJudgmentsRequest}
     */
    public final CompletableFuture<DeleteJudgmentsResponse> deleteJudgments(
        Function<DeleteJudgmentsRequest.Builder, ObjectBuilder<DeleteJudgmentsRequest>> fn
    ) throws IOException, OpenSearchException {
        return deleteJudgments(fn.apply(new DeleteJudgmentsRequest.Builder()).build());
    }

    // ----- Endpoint: search_relevance.delete_query_sets

    /**
     * Deletes a query set.
     */
    public CompletableFuture<DeleteQuerySetsResponse> deleteQuerySets(DeleteQuerySetsRequest request) throws IOException,
        OpenSearchException {
        return this.transport.performRequestAsync(request, DeleteQuerySetsRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Deletes a query set.
     *
     * @param fn a function that initializes a builder to create the {@link DeleteQuerySetsRequest}
     */
    public final CompletableFuture<DeleteQuerySetsResponse> deleteQuerySets(
        Function<DeleteQuerySetsRequest.Builder, ObjectBuilder<DeleteQuerySetsRequest>> fn
    ) throws IOException, OpenSearchException {
        return deleteQuerySets(fn.apply(new DeleteQuerySetsRequest.Builder()).build());
    }

    // ----- Endpoint: search_relevance.delete_scheduled_experiments

    /**
     * Deletes a specified scheduled experiment.
     */
    public CompletableFuture<DeleteScheduledExperimentsResponse> deleteScheduledExperiments(DeleteScheduledExperimentsRequest request)
        throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, DeleteScheduledExperimentsRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Deletes a specified scheduled experiment.
     *
     * @param fn a function that initializes a builder to create the {@link DeleteScheduledExperimentsRequest}
     */
    public final CompletableFuture<DeleteScheduledExperimentsResponse> deleteScheduledExperiments(
        Function<DeleteScheduledExperimentsRequest.Builder, ObjectBuilder<DeleteScheduledExperimentsRequest>> fn
    ) throws IOException, OpenSearchException {
        return deleteScheduledExperiments(fn.apply(new DeleteScheduledExperimentsRequest.Builder()).build());
    }

    // ----- Endpoint: search_relevance.delete_search_configurations

    /**
     * Deletes a specified search configuration.
     */
    public CompletableFuture<DeleteSearchConfigurationsResponse> deleteSearchConfigurations(DeleteSearchConfigurationsRequest request)
        throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, DeleteSearchConfigurationsRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Deletes a specified search configuration.
     *
     * @param fn a function that initializes a builder to create the {@link DeleteSearchConfigurationsRequest}
     */
    public final CompletableFuture<DeleteSearchConfigurationsResponse> deleteSearchConfigurations(
        Function<DeleteSearchConfigurationsRequest.Builder, ObjectBuilder<DeleteSearchConfigurationsRequest>> fn
    ) throws IOException, OpenSearchException {
        return deleteSearchConfigurations(fn.apply(new DeleteSearchConfigurationsRequest.Builder()).build());
    }

    // ----- Endpoint: search_relevance.get_experiments

    /**
     * Gets experiments.
     */
    public <TDocument> CompletableFuture<GetExperimentsResponse<TDocument>> getExperiments(
        GetExperimentsRequest request,
        Class<TDocument> tDocumentClass
    ) throws IOException, OpenSearchException {
        @SuppressWarnings("unchecked")
        JsonEndpoint<GetExperimentsRequest, GetExperimentsResponse<TDocument>, ErrorResponse> endpoint = (JsonEndpoint<
            GetExperimentsRequest,
            GetExperimentsResponse<TDocument>,
            ErrorResponse>) GetExperimentsRequest._ENDPOINT;
        endpoint = new EndpointWithResponseMapperAttr<>(
            endpoint,
            "org.opensearch.client:Deserializer:search_relevance.get_experiments.TDocument",
            getDeserializer(tDocumentClass)
        );

        return this.transport.performRequestAsync(request, endpoint, this.transportOptions);
    }

    /**
     * Gets experiments.
     *
     * @param fn a function that initializes a builder to create the {@link GetExperimentsRequest}
     */
    public final <TDocument> CompletableFuture<GetExperimentsResponse<TDocument>> getExperiments(
        Function<GetExperimentsRequest.Builder, ObjectBuilder<GetExperimentsRequest>> fn,
        Class<TDocument> tDocumentClass
    ) throws IOException, OpenSearchException {
        return getExperiments(fn.apply(new GetExperimentsRequest.Builder()).build(), tDocumentClass);
    }

    // ----- Endpoint: search_relevance.get_judgments

    /**
     * Gets judgments.
     */
    public <TDocument> CompletableFuture<GetJudgmentsResponse<TDocument>> getJudgments(
        GetJudgmentsRequest request,
        Class<TDocument> tDocumentClass
    ) throws IOException, OpenSearchException {
        @SuppressWarnings("unchecked")
        JsonEndpoint<GetJudgmentsRequest, GetJudgmentsResponse<TDocument>, ErrorResponse> endpoint = (JsonEndpoint<
            GetJudgmentsRequest,
            GetJudgmentsResponse<TDocument>,
            ErrorResponse>) GetJudgmentsRequest._ENDPOINT;
        endpoint = new EndpointWithResponseMapperAttr<>(
            endpoint,
            "org.opensearch.client:Deserializer:search_relevance.get_judgments.TDocument",
            getDeserializer(tDocumentClass)
        );

        return this.transport.performRequestAsync(request, endpoint, this.transportOptions);
    }

    /**
     * Gets judgments.
     *
     * @param fn a function that initializes a builder to create the {@link GetJudgmentsRequest}
     */
    public final <TDocument> CompletableFuture<GetJudgmentsResponse<TDocument>> getJudgments(
        Function<GetJudgmentsRequest.Builder, ObjectBuilder<GetJudgmentsRequest>> fn,
        Class<TDocument> tDocumentClass
    ) throws IOException, OpenSearchException {
        return getJudgments(fn.apply(new GetJudgmentsRequest.Builder()).build(), tDocumentClass);
    }

    // ----- Endpoint: search_relevance.get_node_stats

    /**
     * Gets stats by node.
     */
    public CompletableFuture<GetNodeStatsResponse> getNodeStats(GetNodeStatsRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, GetNodeStatsRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Gets stats by node.
     *
     * @param fn a function that initializes a builder to create the {@link GetNodeStatsRequest}
     */
    public final CompletableFuture<GetNodeStatsResponse> getNodeStats(
        Function<GetNodeStatsRequest.Builder, ObjectBuilder<GetNodeStatsRequest>> fn
    ) throws IOException, OpenSearchException {
        return getNodeStats(fn.apply(new GetNodeStatsRequest.Builder()).build());
    }

    // ----- Endpoint: search_relevance.get_query_sets

    /**
     * Lists the current query sets available.
     */
    public <TDocument> CompletableFuture<GetQuerySetsResponse<TDocument>> getQuerySets(
        GetQuerySetsRequest request,
        Class<TDocument> tDocumentClass
    ) throws IOException, OpenSearchException {
        @SuppressWarnings("unchecked")
        JsonEndpoint<GetQuerySetsRequest, GetQuerySetsResponse<TDocument>, ErrorResponse> endpoint = (JsonEndpoint<
            GetQuerySetsRequest,
            GetQuerySetsResponse<TDocument>,
            ErrorResponse>) GetQuerySetsRequest._ENDPOINT;
        endpoint = new EndpointWithResponseMapperAttr<>(
            endpoint,
            "org.opensearch.client:Deserializer:search_relevance.get_query_sets.TDocument",
            getDeserializer(tDocumentClass)
        );

        return this.transport.performRequestAsync(request, endpoint, this.transportOptions);
    }

    /**
     * Lists the current query sets available.
     *
     * @param fn a function that initializes a builder to create the {@link GetQuerySetsRequest}
     */
    public final <TDocument> CompletableFuture<GetQuerySetsResponse<TDocument>> getQuerySets(
        Function<GetQuerySetsRequest.Builder, ObjectBuilder<GetQuerySetsRequest>> fn,
        Class<TDocument> tDocumentClass
    ) throws IOException, OpenSearchException {
        return getQuerySets(fn.apply(new GetQuerySetsRequest.Builder()).build(), tDocumentClass);
    }

    // ----- Endpoint: search_relevance.get_scheduled_experiments

    /**
     * Gets the scheduled experiments.
     */
    public <TDocument> CompletableFuture<GetScheduledExperimentsResponse<TDocument>> getScheduledExperiments(
        GetScheduledExperimentsRequest request,
        Class<TDocument> tDocumentClass
    ) throws IOException, OpenSearchException {
        @SuppressWarnings("unchecked")
        JsonEndpoint<GetScheduledExperimentsRequest, GetScheduledExperimentsResponse<TDocument>, ErrorResponse> endpoint = (JsonEndpoint<
            GetScheduledExperimentsRequest,
            GetScheduledExperimentsResponse<TDocument>,
            ErrorResponse>) GetScheduledExperimentsRequest._ENDPOINT;
        endpoint = new EndpointWithResponseMapperAttr<>(
            endpoint,
            "org.opensearch.client:Deserializer:search_relevance.get_scheduled_experiments.TDocument",
            getDeserializer(tDocumentClass)
        );

        return this.transport.performRequestAsync(request, endpoint, this.transportOptions);
    }

    /**
     * Gets the scheduled experiments.
     *
     * @param fn a function that initializes a builder to create the {@link GetScheduledExperimentsRequest}
     */
    public final <TDocument> CompletableFuture<GetScheduledExperimentsResponse<TDocument>> getScheduledExperiments(
        Function<GetScheduledExperimentsRequest.Builder, ObjectBuilder<GetScheduledExperimentsRequest>> fn,
        Class<TDocument> tDocumentClass
    ) throws IOException, OpenSearchException {
        return getScheduledExperiments(fn.apply(new GetScheduledExperimentsRequest.Builder()).build(), tDocumentClass);
    }

    // ----- Endpoint: search_relevance.get_search_configurations

    /**
     * Gets the search configurations.
     */
    public <TDocument> CompletableFuture<GetSearchConfigurationsResponse<TDocument>> getSearchConfigurations(
        GetSearchConfigurationsRequest request,
        Class<TDocument> tDocumentClass
    ) throws IOException, OpenSearchException {
        @SuppressWarnings("unchecked")
        JsonEndpoint<GetSearchConfigurationsRequest, GetSearchConfigurationsResponse<TDocument>, ErrorResponse> endpoint = (JsonEndpoint<
            GetSearchConfigurationsRequest,
            GetSearchConfigurationsResponse<TDocument>,
            ErrorResponse>) GetSearchConfigurationsRequest._ENDPOINT;
        endpoint = new EndpointWithResponseMapperAttr<>(
            endpoint,
            "org.opensearch.client:Deserializer:search_relevance.get_search_configurations.TDocument",
            getDeserializer(tDocumentClass)
        );

        return this.transport.performRequestAsync(request, endpoint, this.transportOptions);
    }

    /**
     * Gets the search configurations.
     *
     * @param fn a function that initializes a builder to create the {@link GetSearchConfigurationsRequest}
     */
    public final <TDocument> CompletableFuture<GetSearchConfigurationsResponse<TDocument>> getSearchConfigurations(
        Function<GetSearchConfigurationsRequest.Builder, ObjectBuilder<GetSearchConfigurationsRequest>> fn,
        Class<TDocument> tDocumentClass
    ) throws IOException, OpenSearchException {
        return getSearchConfigurations(fn.apply(new GetSearchConfigurationsRequest.Builder()).build(), tDocumentClass);
    }

    // ----- Endpoint: search_relevance.get_stats

    /**
     * Gets stats.
     */
    public CompletableFuture<GetStatsResponse> getStats(GetStatsRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, GetStatsRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Gets stats.
     *
     * @param fn a function that initializes a builder to create the {@link GetStatsRequest}
     */
    public final CompletableFuture<GetStatsResponse> getStats(Function<GetStatsRequest.Builder, ObjectBuilder<GetStatsRequest>> fn)
        throws IOException, OpenSearchException {
        return getStats(fn.apply(new GetStatsRequest.Builder()).build());
    }

    /**
     * Gets stats.
     */
    public final CompletableFuture<GetStatsResponse> getStats() throws IOException, OpenSearchException {
        return getStats(new GetStatsRequest.Builder().build());
    }

    // ----- Endpoint: search_relevance.post_query_sets

    /**
     * Creates a new query set by sampling queries from the user behavior data.
     */
    public CompletableFuture<PostQuerySetsResponse> postQuerySets(PostQuerySetsRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, PostQuerySetsRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Creates a new query set by sampling queries from the user behavior data.
     *
     * @param fn a function that initializes a builder to create the {@link PostQuerySetsRequest}
     */
    public final CompletableFuture<PostQuerySetsResponse> postQuerySets(
        Function<PostQuerySetsRequest.Builder, ObjectBuilder<PostQuerySetsRequest>> fn
    ) throws IOException, OpenSearchException {
        return postQuerySets(fn.apply(new PostQuerySetsRequest.Builder()).build());
    }

    /**
     * Creates a new query set by sampling queries from the user behavior data.
     */
    public final CompletableFuture<PostQuerySetsResponse> postQuerySets() throws IOException, OpenSearchException {
        return postQuerySets(new PostQuerySetsRequest.Builder().build());
    }

    // ----- Endpoint: search_relevance.post_scheduled_experiments

    /**
     * Creates a scheduled experiment.
     */
    public CompletableFuture<PostScheduledExperimentsResponse> postScheduledExperiments(PostScheduledExperimentsRequest request)
        throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, PostScheduledExperimentsRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Creates a scheduled experiment.
     *
     * @param fn a function that initializes a builder to create the {@link PostScheduledExperimentsRequest}
     */
    public final CompletableFuture<PostScheduledExperimentsResponse> postScheduledExperiments(
        Function<PostScheduledExperimentsRequest.Builder, ObjectBuilder<PostScheduledExperimentsRequest>> fn
    ) throws IOException, OpenSearchException {
        return postScheduledExperiments(fn.apply(new PostScheduledExperimentsRequest.Builder()).build());
    }

    /**
     * Creates a scheduled experiment.
     */
    public final CompletableFuture<PostScheduledExperimentsResponse> postScheduledExperiments() throws IOException, OpenSearchException {
        return postScheduledExperiments(new PostScheduledExperimentsRequest.Builder().build());
    }

    // ----- Endpoint: search_relevance.put_experiments

    /**
     * Creates an experiment.
     */
    public CompletableFuture<PutExperimentsResponse> putExperiments(PutExperimentsRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, PutExperimentsRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Creates an experiment.
     *
     * @param fn a function that initializes a builder to create the {@link PutExperimentsRequest}
     */
    public final CompletableFuture<PutExperimentsResponse> putExperiments(
        Function<PutExperimentsRequest.Builder, ObjectBuilder<PutExperimentsRequest>> fn
    ) throws IOException, OpenSearchException {
        return putExperiments(fn.apply(new PutExperimentsRequest.Builder()).build());
    }

    /**
     * Creates an experiment.
     */
    public final CompletableFuture<PutExperimentsResponse> putExperiments() throws IOException, OpenSearchException {
        return putExperiments(new PutExperimentsRequest.Builder().build());
    }

    // ----- Endpoint: search_relevance.put_judgments

    /**
     * Creates a judgment.
     */
    public CompletableFuture<PutJudgmentsResponse> putJudgments(PutJudgmentsRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, PutJudgmentsRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Creates a judgment.
     *
     * @param fn a function that initializes a builder to create the {@link PutJudgmentsRequest}
     */
    public final CompletableFuture<PutJudgmentsResponse> putJudgments(
        Function<PutJudgmentsRequest.Builder, ObjectBuilder<PutJudgmentsRequest>> fn
    ) throws IOException, OpenSearchException {
        return putJudgments(fn.apply(new PutJudgmentsRequest.Builder()).build());
    }

    /**
     * Creates a judgment.
     */
    public final CompletableFuture<PutJudgmentsResponse> putJudgments() throws IOException, OpenSearchException {
        return putJudgments(new PutJudgmentsRequest.Builder().build());
    }

    // ----- Endpoint: search_relevance.put_query_sets

    /**
     * Creates a new query set by uploading manually.
     */
    public CompletableFuture<PutQuerySetsResponse> putQuerySets(PutQuerySetsRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, PutQuerySetsRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Creates a new query set by uploading manually.
     *
     * @param fn a function that initializes a builder to create the {@link PutQuerySetsRequest}
     */
    public final CompletableFuture<PutQuerySetsResponse> putQuerySets(
        Function<PutQuerySetsRequest.Builder, ObjectBuilder<PutQuerySetsRequest>> fn
    ) throws IOException, OpenSearchException {
        return putQuerySets(fn.apply(new PutQuerySetsRequest.Builder()).build());
    }

    /**
     * Creates a new query set by uploading manually.
     */
    public final CompletableFuture<PutQuerySetsResponse> putQuerySets() throws IOException, OpenSearchException {
        return putQuerySets(new PutQuerySetsRequest.Builder().build());
    }

    // ----- Endpoint: search_relevance.put_search_configurations

    /**
     * Creates a search configuration.
     */
    public CompletableFuture<PutSearchConfigurationsResponse> putSearchConfigurations(PutSearchConfigurationsRequest request)
        throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, PutSearchConfigurationsRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Creates a search configuration.
     *
     * @param fn a function that initializes a builder to create the {@link PutSearchConfigurationsRequest}
     */
    public final CompletableFuture<PutSearchConfigurationsResponse> putSearchConfigurations(
        Function<PutSearchConfigurationsRequest.Builder, ObjectBuilder<PutSearchConfigurationsRequest>> fn
    ) throws IOException, OpenSearchException {
        return putSearchConfigurations(fn.apply(new PutSearchConfigurationsRequest.Builder()).build());
    }

    /**
     * Creates a search configuration.
     */
    public final CompletableFuture<PutSearchConfigurationsResponse> putSearchConfigurations() throws IOException, OpenSearchException {
        return putSearchConfigurations(new PutSearchConfigurationsRequest.Builder().build());
    }
}
