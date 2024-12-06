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

package org.opensearch.client.opensearch.indices;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nullable;
import org.opensearch.client.ApiClient;
import org.opensearch.client.opensearch._types.OpenSearchException;
import org.opensearch.client.transport.OpenSearchTransport;
import org.opensearch.client.transport.TransportOptions;
import org.opensearch.client.transport.endpoints.BooleanResponse;
import org.opensearch.client.util.ObjectBuilder;

/**
 * Client for the indices namespace.
 */
@Generated("org.opensearch.client.codegen.CodeGenerator")
public abstract class OpenSearchIndicesAsyncClientBase<Self extends OpenSearchIndicesAsyncClientBase<Self>> extends ApiClient<
    OpenSearchTransport,
    Self> {
    public OpenSearchIndicesAsyncClientBase(OpenSearchTransport transport, @Nullable TransportOptions transportOptions) {
        super(transport, transportOptions);
    }

    // ----- Endpoint: indices.create

    /**
     * Creates an index with optional settings and mappings.
     */
    public CompletableFuture<CreateIndexResponse> create(CreateIndexRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, CreateIndexRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Creates an index with optional settings and mappings.
     *
     * @param fn a function that initializes a builder to create the {@link CreateIndexRequest}
     */
    public final CompletableFuture<CreateIndexResponse> create(Function<CreateIndexRequest.Builder, ObjectBuilder<CreateIndexRequest>> fn)
        throws IOException, OpenSearchException {
        return create(fn.apply(new CreateIndexRequest.Builder()).build());
    }

    // ----- Endpoint: indices.delete

    /**
     * Deletes an index.
     */
    public CompletableFuture<DeleteIndexResponse> delete(DeleteIndexRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, DeleteIndexRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Deletes an index.
     *
     * @param fn a function that initializes a builder to create the {@link DeleteIndexRequest}
     */
    public final CompletableFuture<DeleteIndexResponse> delete(Function<DeleteIndexRequest.Builder, ObjectBuilder<DeleteIndexRequest>> fn)
        throws IOException, OpenSearchException {
        return delete(fn.apply(new DeleteIndexRequest.Builder()).build());
    }

    // ----- Endpoint: indices.delete_index_template

    /**
     * Deletes an index template.
     */
    public CompletableFuture<DeleteIndexTemplateResponse> deleteIndexTemplate(DeleteIndexTemplateRequest request) throws IOException,
        OpenSearchException {
        return this.transport.performRequestAsync(request, DeleteIndexTemplateRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Deletes an index template.
     *
     * @param fn a function that initializes a builder to create the {@link DeleteIndexTemplateRequest}
     */
    public final CompletableFuture<DeleteIndexTemplateResponse> deleteIndexTemplate(
        Function<DeleteIndexTemplateRequest.Builder, ObjectBuilder<DeleteIndexTemplateRequest>> fn
    ) throws IOException, OpenSearchException {
        return deleteIndexTemplate(fn.apply(new DeleteIndexTemplateRequest.Builder()).build());
    }

    // ----- Endpoint: indices.delete_template

    /**
     * Deletes an index template.
     */
    public CompletableFuture<DeleteTemplateResponse> deleteTemplate(DeleteTemplateRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, DeleteTemplateRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Deletes an index template.
     *
     * @param fn a function that initializes a builder to create the {@link DeleteTemplateRequest}
     */
    public final CompletableFuture<DeleteTemplateResponse> deleteTemplate(
        Function<DeleteTemplateRequest.Builder, ObjectBuilder<DeleteTemplateRequest>> fn
    ) throws IOException, OpenSearchException {
        return deleteTemplate(fn.apply(new DeleteTemplateRequest.Builder()).build());
    }

    // ----- Endpoint: indices.exists

    /**
     * Returns information about whether a particular index exists.
     */
    public CompletableFuture<BooleanResponse> exists(ExistsRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, ExistsRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Returns information about whether a particular index exists.
     *
     * @param fn a function that initializes a builder to create the {@link ExistsRequest}
     */
    public final CompletableFuture<BooleanResponse> exists(Function<ExistsRequest.Builder, ObjectBuilder<ExistsRequest>> fn)
        throws IOException, OpenSearchException {
        return exists(fn.apply(new ExistsRequest.Builder()).build());
    }

    // ----- Endpoint: indices.exists_index_template

    /**
     * Returns information about whether a particular index template exists.
     */
    public CompletableFuture<BooleanResponse> existsIndexTemplate(ExistsIndexTemplateRequest request) throws IOException,
        OpenSearchException {
        return this.transport.performRequestAsync(request, ExistsIndexTemplateRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Returns information about whether a particular index template exists.
     *
     * @param fn a function that initializes a builder to create the {@link ExistsIndexTemplateRequest}
     */
    public final CompletableFuture<BooleanResponse> existsIndexTemplate(
        Function<ExistsIndexTemplateRequest.Builder, ObjectBuilder<ExistsIndexTemplateRequest>> fn
    ) throws IOException, OpenSearchException {
        return existsIndexTemplate(fn.apply(new ExistsIndexTemplateRequest.Builder()).build());
    }

    // ----- Endpoint: indices.exists_template

    /**
     * Returns information about whether a particular index template exists.
     */
    public CompletableFuture<BooleanResponse> existsTemplate(ExistsTemplateRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, ExistsTemplateRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Returns information about whether a particular index template exists.
     *
     * @param fn a function that initializes a builder to create the {@link ExistsTemplateRequest}
     */
    public final CompletableFuture<BooleanResponse> existsTemplate(
        Function<ExistsTemplateRequest.Builder, ObjectBuilder<ExistsTemplateRequest>> fn
    ) throws IOException, OpenSearchException {
        return existsTemplate(fn.apply(new ExistsTemplateRequest.Builder()).build());
    }

    // ----- Endpoint: indices.get

    /**
     * Returns information about one or more indexes.
     */
    public CompletableFuture<GetIndexResponse> get(GetIndexRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, GetIndexRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Returns information about one or more indexes.
     *
     * @param fn a function that initializes a builder to create the {@link GetIndexRequest}
     */
    public final CompletableFuture<GetIndexResponse> get(Function<GetIndexRequest.Builder, ObjectBuilder<GetIndexRequest>> fn)
        throws IOException, OpenSearchException {
        return get(fn.apply(new GetIndexRequest.Builder()).build());
    }

    // ----- Endpoint: indices.get_index_template

    /**
     * Returns an index template.
     */
    public CompletableFuture<GetIndexTemplateResponse> getIndexTemplate(GetIndexTemplateRequest request) throws IOException,
        OpenSearchException {
        return this.transport.performRequestAsync(request, GetIndexTemplateRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Returns an index template.
     *
     * @param fn a function that initializes a builder to create the {@link GetIndexTemplateRequest}
     */
    public final CompletableFuture<GetIndexTemplateResponse> getIndexTemplate(
        Function<GetIndexTemplateRequest.Builder, ObjectBuilder<GetIndexTemplateRequest>> fn
    ) throws IOException, OpenSearchException {
        return getIndexTemplate(fn.apply(new GetIndexTemplateRequest.Builder()).build());
    }

    /**
     * Returns an index template.
     */
    public final CompletableFuture<GetIndexTemplateResponse> getIndexTemplate() throws IOException, OpenSearchException {
        return getIndexTemplate(new GetIndexTemplateRequest.Builder().build());
    }

    // ----- Endpoint: indices.get_settings

    /**
     * Returns settings for one or more indexes.
     */
    public CompletableFuture<GetIndicesSettingsResponse> getSettings(GetIndicesSettingsRequest request) throws IOException,
        OpenSearchException {
        return this.transport.performRequestAsync(request, GetIndicesSettingsRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Returns settings for one or more indexes.
     *
     * @param fn a function that initializes a builder to create the {@link GetIndicesSettingsRequest}
     */
    public final CompletableFuture<GetIndicesSettingsResponse> getSettings(
        Function<GetIndicesSettingsRequest.Builder, ObjectBuilder<GetIndicesSettingsRequest>> fn
    ) throws IOException, OpenSearchException {
        return getSettings(fn.apply(new GetIndicesSettingsRequest.Builder()).build());
    }

    /**
     * Returns settings for one or more indexes.
     */
    public final CompletableFuture<GetIndicesSettingsResponse> getSettings() throws IOException, OpenSearchException {
        return getSettings(new GetIndicesSettingsRequest.Builder().build());
    }

    // ----- Endpoint: indices.get_template

    /**
     * Returns an index template.
     */
    public CompletableFuture<GetTemplateResponse> getTemplate(GetTemplateRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, GetTemplateRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Returns an index template.
     *
     * @param fn a function that initializes a builder to create the {@link GetTemplateRequest}
     */
    public final CompletableFuture<GetTemplateResponse> getTemplate(
        Function<GetTemplateRequest.Builder, ObjectBuilder<GetTemplateRequest>> fn
    ) throws IOException, OpenSearchException {
        return getTemplate(fn.apply(new GetTemplateRequest.Builder()).build());
    }

    /**
     * Returns an index template.
     */
    public final CompletableFuture<GetTemplateResponse> getTemplate() throws IOException, OpenSearchException {
        return getTemplate(new GetTemplateRequest.Builder().build());
    }

    // ----- Endpoint: indices.put_index_template

    /**
     * Creates or updates an index template.
     */
    public CompletableFuture<PutIndexTemplateResponse> putIndexTemplate(PutIndexTemplateRequest request) throws IOException,
        OpenSearchException {
        return this.transport.performRequestAsync(request, PutIndexTemplateRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Creates or updates an index template.
     *
     * @param fn a function that initializes a builder to create the {@link PutIndexTemplateRequest}
     */
    public final CompletableFuture<PutIndexTemplateResponse> putIndexTemplate(
        Function<PutIndexTemplateRequest.Builder, ObjectBuilder<PutIndexTemplateRequest>> fn
    ) throws IOException, OpenSearchException {
        return putIndexTemplate(fn.apply(new PutIndexTemplateRequest.Builder()).build());
    }

    // ----- Endpoint: indices.put_template

    /**
     * Creates or updates an index template.
     */
    public CompletableFuture<PutTemplateResponse> putTemplate(PutTemplateRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, PutTemplateRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Creates or updates an index template.
     *
     * @param fn a function that initializes a builder to create the {@link PutTemplateRequest}
     */
    public final CompletableFuture<PutTemplateResponse> putTemplate(
        Function<PutTemplateRequest.Builder, ObjectBuilder<PutTemplateRequest>> fn
    ) throws IOException, OpenSearchException {
        return putTemplate(fn.apply(new PutTemplateRequest.Builder()).build());
    }

    // ----- Endpoint: indices.simulate_index_template

    /**
     * Simulate matching the given index name against the index templates in the system.
     */
    public CompletableFuture<SimulateIndexTemplateResponse> simulateIndexTemplate(SimulateIndexTemplateRequest request) throws IOException,
        OpenSearchException {
        return this.transport.performRequestAsync(request, SimulateIndexTemplateRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Simulate matching the given index name against the index templates in the system.
     *
     * @param fn a function that initializes a builder to create the {@link SimulateIndexTemplateRequest}
     */
    public final CompletableFuture<SimulateIndexTemplateResponse> simulateIndexTemplate(
        Function<SimulateIndexTemplateRequest.Builder, ObjectBuilder<SimulateIndexTemplateRequest>> fn
    ) throws IOException, OpenSearchException {
        return simulateIndexTemplate(fn.apply(new SimulateIndexTemplateRequest.Builder()).build());
    }

    // ----- Endpoint: indices.simulate_template

    /**
     * Simulate resolving the given template name or body.
     */
    public CompletableFuture<SimulateTemplateResponse> simulateTemplate(SimulateTemplateRequest request) throws IOException,
        OpenSearchException {
        return this.transport.performRequestAsync(request, SimulateTemplateRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Simulate resolving the given template name or body.
     *
     * @param fn a function that initializes a builder to create the {@link SimulateTemplateRequest}
     */
    public final CompletableFuture<SimulateTemplateResponse> simulateTemplate(
        Function<SimulateTemplateRequest.Builder, ObjectBuilder<SimulateTemplateRequest>> fn
    ) throws IOException, OpenSearchException {
        return simulateTemplate(fn.apply(new SimulateTemplateRequest.Builder()).build());
    }
}
