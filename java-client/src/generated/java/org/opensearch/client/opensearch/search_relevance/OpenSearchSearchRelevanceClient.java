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
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nullable;
import org.opensearch.client.ApiClient;
import org.opensearch.client.opensearch._types.OpenSearchException;
import org.opensearch.client.transport.OpenSearchTransport;
import org.opensearch.client.transport.TransportOptions;
import org.opensearch.client.util.ObjectBuilder;

/**
 * Client for the search_relevance namespace.
 */
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class OpenSearchSearchRelevanceClient extends ApiClient<OpenSearchTransport, OpenSearchSearchRelevanceClient> {
    public OpenSearchSearchRelevanceClient(OpenSearchTransport transport) {
        super(transport, null);
    }

    public OpenSearchSearchRelevanceClient(OpenSearchTransport transport, @Nullable TransportOptions transportOptions) {
        super(transport, transportOptions);
    }

    @Override
    public OpenSearchSearchRelevanceClient withTransportOptions(@Nullable TransportOptions transportOptions) {
        return new OpenSearchSearchRelevanceClient(this.transport, transportOptions);
    }

    // ----- Endpoint: search_relevance.delete_experiments

    /**
     * Deletes a specified experiment.
     */
    public DeleteExperimentsResponse deleteExperiments(DeleteExperimentsRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, DeleteExperimentsRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Deletes a specified experiment.
     *
     * @param fn a function that initializes a builder to create the {@link DeleteExperimentsRequest}
     */
    public final DeleteExperimentsResponse deleteExperiments(
        Function<DeleteExperimentsRequest.Builder, ObjectBuilder<DeleteExperimentsRequest>> fn
    ) throws IOException, OpenSearchException {
        return deleteExperiments(fn.apply(new DeleteExperimentsRequest.Builder()).build());
    }

    // ----- Endpoint: search_relevance.delete_judgments

    /**
     * Deletes a specified judgment.
     */
    public DeleteJudgmentsResponse deleteJudgments(DeleteJudgmentsRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, DeleteJudgmentsRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Deletes a specified judgment.
     *
     * @param fn a function that initializes a builder to create the {@link DeleteJudgmentsRequest}
     */
    public final DeleteJudgmentsResponse deleteJudgments(Function<DeleteJudgmentsRequest.Builder, ObjectBuilder<DeleteJudgmentsRequest>> fn)
        throws IOException, OpenSearchException {
        return deleteJudgments(fn.apply(new DeleteJudgmentsRequest.Builder()).build());
    }

    // ----- Endpoint: search_relevance.delete_query_sets

    /**
     * Deletes a query set.
     */
    public DeleteQuerySetsResponse deleteQuerySets(DeleteQuerySetsRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, DeleteQuerySetsRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Deletes a query set.
     *
     * @param fn a function that initializes a builder to create the {@link DeleteQuerySetsRequest}
     */
    public final DeleteQuerySetsResponse deleteQuerySets(Function<DeleteQuerySetsRequest.Builder, ObjectBuilder<DeleteQuerySetsRequest>> fn)
        throws IOException, OpenSearchException {
        return deleteQuerySets(fn.apply(new DeleteQuerySetsRequest.Builder()).build());
    }

    // ----- Endpoint: search_relevance.delete_search_configurations

    /**
     * Deletes a specified search configuration.
     */
    public DeleteSearchConfigurationsResponse deleteSearchConfigurations(DeleteSearchConfigurationsRequest request) throws IOException,
        OpenSearchException {
        return this.transport.performRequest(request, DeleteSearchConfigurationsRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Deletes a specified search configuration.
     *
     * @param fn a function that initializes a builder to create the {@link DeleteSearchConfigurationsRequest}
     */
    public final DeleteSearchConfigurationsResponse deleteSearchConfigurations(
        Function<DeleteSearchConfigurationsRequest.Builder, ObjectBuilder<DeleteSearchConfigurationsRequest>> fn
    ) throws IOException, OpenSearchException {
        return deleteSearchConfigurations(fn.apply(new DeleteSearchConfigurationsRequest.Builder()).build());
    }

    // ----- Endpoint: search_relevance.get_experiments

    /**
     * Gets experiments.
     */
    public GetExperimentsResponse getExperiments(GetExperimentsRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, GetExperimentsRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Gets experiments.
     *
     * @param fn a function that initializes a builder to create the {@link GetExperimentsRequest}
     */
    public final GetExperimentsResponse getExperiments(Function<GetExperimentsRequest.Builder, ObjectBuilder<GetExperimentsRequest>> fn)
        throws IOException, OpenSearchException {
        return getExperiments(fn.apply(new GetExperimentsRequest.Builder()).build());
    }

    /**
     * Gets experiments.
     */
    public final GetExperimentsResponse getExperiments() throws IOException, OpenSearchException {
        return getExperiments(new GetExperimentsRequest.Builder().build());
    }

    // ----- Endpoint: search_relevance.get_judgments

    /**
     * Gets judgments.
     */
    public GetJudgmentsResponse getJudgments(GetJudgmentsRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, GetJudgmentsRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Gets judgments.
     *
     * @param fn a function that initializes a builder to create the {@link GetJudgmentsRequest}
     */
    public final GetJudgmentsResponse getJudgments(Function<GetJudgmentsRequest.Builder, ObjectBuilder<GetJudgmentsRequest>> fn)
        throws IOException, OpenSearchException {
        return getJudgments(fn.apply(new GetJudgmentsRequest.Builder()).build());
    }

    /**
     * Gets judgments.
     */
    public final GetJudgmentsResponse getJudgments() throws IOException, OpenSearchException {
        return getJudgments(new GetJudgmentsRequest.Builder().build());
    }

    // ----- Endpoint: search_relevance.get_node_stats

    /**
     * Gets stats by node.
     */
    public GetNodeStatsResponse getNodeStats(GetNodeStatsRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, GetNodeStatsRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Gets stats by node.
     *
     * @param fn a function that initializes a builder to create the {@link GetNodeStatsRequest}
     */
    public final GetNodeStatsResponse getNodeStats(Function<GetNodeStatsRequest.Builder, ObjectBuilder<GetNodeStatsRequest>> fn)
        throws IOException, OpenSearchException {
        return getNodeStats(fn.apply(new GetNodeStatsRequest.Builder()).build());
    }

    // ----- Endpoint: search_relevance.get_query_sets

    /**
     * Lists the current query sets available.
     */
    public GetQuerySetsResponse getQuerySets(GetQuerySetsRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, GetQuerySetsRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Lists the current query sets available.
     *
     * @param fn a function that initializes a builder to create the {@link GetQuerySetsRequest}
     */
    public final GetQuerySetsResponse getQuerySets(Function<GetQuerySetsRequest.Builder, ObjectBuilder<GetQuerySetsRequest>> fn)
        throws IOException, OpenSearchException {
        return getQuerySets(fn.apply(new GetQuerySetsRequest.Builder()).build());
    }

    /**
     * Lists the current query sets available.
     */
    public final GetQuerySetsResponse getQuerySets() throws IOException, OpenSearchException {
        return getQuerySets(new GetQuerySetsRequest.Builder().build());
    }

    // ----- Endpoint: search_relevance.get_search_configurations

    /**
     * Gets the search configurations.
     */
    public GetSearchConfigurationsResponse getSearchConfigurations(GetSearchConfigurationsRequest request) throws IOException,
        OpenSearchException {
        return this.transport.performRequest(request, GetSearchConfigurationsRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Gets the search configurations.
     *
     * @param fn a function that initializes a builder to create the {@link GetSearchConfigurationsRequest}
     */
    public final GetSearchConfigurationsResponse getSearchConfigurations(
        Function<GetSearchConfigurationsRequest.Builder, ObjectBuilder<GetSearchConfigurationsRequest>> fn
    ) throws IOException, OpenSearchException {
        return getSearchConfigurations(fn.apply(new GetSearchConfigurationsRequest.Builder()).build());
    }

    /**
     * Gets the search configurations.
     */
    public final GetSearchConfigurationsResponse getSearchConfigurations() throws IOException, OpenSearchException {
        return getSearchConfigurations(new GetSearchConfigurationsRequest.Builder().build());
    }

    // ----- Endpoint: search_relevance.get_stats

    /**
     * Gets stats.
     */
    public GetStatsResponse getStats(GetStatsRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, GetStatsRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Gets stats.
     *
     * @param fn a function that initializes a builder to create the {@link GetStatsRequest}
     */
    public final GetStatsResponse getStats(Function<GetStatsRequest.Builder, ObjectBuilder<GetStatsRequest>> fn) throws IOException,
        OpenSearchException {
        return getStats(fn.apply(new GetStatsRequest.Builder()).build());
    }

    /**
     * Gets stats.
     */
    public final GetStatsResponse getStats() throws IOException, OpenSearchException {
        return getStats(new GetStatsRequest.Builder().build());
    }

    // ----- Endpoint: search_relevance.post_query_sets

    /**
     * Creates a new query set by sampling queries from the user behavior data.
     */
    public PostQuerySetsResponse postQuerySets(PostQuerySetsRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, PostQuerySetsRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Creates a new query set by sampling queries from the user behavior data.
     *
     * @param fn a function that initializes a builder to create the {@link PostQuerySetsRequest}
     */
    public final PostQuerySetsResponse postQuerySets(Function<PostQuerySetsRequest.Builder, ObjectBuilder<PostQuerySetsRequest>> fn)
        throws IOException, OpenSearchException {
        return postQuerySets(fn.apply(new PostQuerySetsRequest.Builder()).build());
    }

    /**
     * Creates a new query set by sampling queries from the user behavior data.
     */
    public final PostQuerySetsResponse postQuerySets() throws IOException, OpenSearchException {
        return postQuerySets(new PostQuerySetsRequest.Builder().build());
    }

    // ----- Endpoint: search_relevance.put_experiments

    /**
     * Creates an experiment.
     */
    public PutExperimentsResponse putExperiments(PutExperimentsRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, PutExperimentsRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Creates an experiment.
     *
     * @param fn a function that initializes a builder to create the {@link PutExperimentsRequest}
     */
    public final PutExperimentsResponse putExperiments(Function<PutExperimentsRequest.Builder, ObjectBuilder<PutExperimentsRequest>> fn)
        throws IOException, OpenSearchException {
        return putExperiments(fn.apply(new PutExperimentsRequest.Builder()).build());
    }

    /**
     * Creates an experiment.
     */
    public final PutExperimentsResponse putExperiments() throws IOException, OpenSearchException {
        return putExperiments(new PutExperimentsRequest.Builder().build());
    }

    // ----- Endpoint: search_relevance.put_judgments

    /**
     * Creates a judgment.
     */
    public PutJudgmentsResponse putJudgments(PutJudgmentsRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, PutJudgmentsRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Creates a judgment.
     *
     * @param fn a function that initializes a builder to create the {@link PutJudgmentsRequest}
     */
    public final PutJudgmentsResponse putJudgments(Function<PutJudgmentsRequest.Builder, ObjectBuilder<PutJudgmentsRequest>> fn)
        throws IOException, OpenSearchException {
        return putJudgments(fn.apply(new PutJudgmentsRequest.Builder()).build());
    }

    /**
     * Creates a judgment.
     */
    public final PutJudgmentsResponse putJudgments() throws IOException, OpenSearchException {
        return putJudgments(new PutJudgmentsRequest.Builder().build());
    }

    // ----- Endpoint: search_relevance.put_query_sets

    /**
     * Creates a new query set by uploading manually.
     */
    public PutQuerySetsResponse putQuerySets(PutQuerySetsRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, PutQuerySetsRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Creates a new query set by uploading manually.
     *
     * @param fn a function that initializes a builder to create the {@link PutQuerySetsRequest}
     */
    public final PutQuerySetsResponse putQuerySets(Function<PutQuerySetsRequest.Builder, ObjectBuilder<PutQuerySetsRequest>> fn)
        throws IOException, OpenSearchException {
        return putQuerySets(fn.apply(new PutQuerySetsRequest.Builder()).build());
    }

    /**
     * Creates a new query set by uploading manually.
     */
    public final PutQuerySetsResponse putQuerySets() throws IOException, OpenSearchException {
        return putQuerySets(new PutQuerySetsRequest.Builder().build());
    }

    // ----- Endpoint: search_relevance.put_search_configurations

    /**
     * Creates a search configuration.
     */
    public PutSearchConfigurationsResponse putSearchConfigurations(PutSearchConfigurationsRequest request) throws IOException,
        OpenSearchException {
        return this.transport.performRequest(request, PutSearchConfigurationsRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Creates a search configuration.
     *
     * @param fn a function that initializes a builder to create the {@link PutSearchConfigurationsRequest}
     */
    public final PutSearchConfigurationsResponse putSearchConfigurations(
        Function<PutSearchConfigurationsRequest.Builder, ObjectBuilder<PutSearchConfigurationsRequest>> fn
    ) throws IOException, OpenSearchException {
        return putSearchConfigurations(fn.apply(new PutSearchConfigurationsRequest.Builder()).build());
    }

    /**
     * Creates a search configuration.
     */
    public final PutSearchConfigurationsResponse putSearchConfigurations() throws IOException, OpenSearchException {
        return putSearchConfigurations(new PutSearchConfigurationsRequest.Builder().build());
    }
}
