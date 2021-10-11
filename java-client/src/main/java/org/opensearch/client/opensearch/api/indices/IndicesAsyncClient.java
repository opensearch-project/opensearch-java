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

package org.opensearch.client.opensearch.api.indices;

import org.opensearch.client.RequestOptions;
import org.opensearch.client.base.ApiClient;
import org.opensearch.client.base.BooleanResponse;
import org.opensearch.client.base.Transport;
import org.opensearch.client.opensearch.indices.AddBlockRequest;
import org.opensearch.client.opensearch.indices.AddBlockResponse;
import org.opensearch.client.opensearch.indices.AnalyzeRequest;
import org.opensearch.client.opensearch.indices.AnalyzeResponse;
import org.opensearch.client.opensearch.indices.ClearCacheRequest;
import org.opensearch.client.opensearch.indices.ClearCacheResponse;
import org.opensearch.client.opensearch.indices.CloneRequest;
import org.opensearch.client.opensearch.indices.CloneResponse;
import org.opensearch.client.opensearch.indices.CloseRequest;
import org.opensearch.client.opensearch.indices.CloseResponse;
import org.opensearch.client.opensearch.indices.CreateRequest;
import org.opensearch.client.opensearch.indices.CreateResponse;
import org.opensearch.client.opensearch.indices.DeleteAliasRequest;
import org.opensearch.client.opensearch.indices.DeleteAliasResponse;
import org.opensearch.client.opensearch.indices.DeleteIndexTemplateRequest;
import org.opensearch.client.opensearch.indices.DeleteIndexTemplateResponse;
import org.opensearch.client.opensearch.indices.DeleteRequest;
import org.opensearch.client.opensearch.indices.DeleteResponse;
import org.opensearch.client.opensearch.indices.DeleteTemplateRequest;
import org.opensearch.client.opensearch.indices.DeleteTemplateResponse;
import org.opensearch.client.opensearch.indices.ExistsAliasRequest;
import org.opensearch.client.opensearch.indices.ExistsIndexTemplateRequest;
import org.opensearch.client.opensearch.indices.ExistsRequest;
import org.opensearch.client.opensearch.indices.ExistsTemplateRequest;
import org.opensearch.client.opensearch.indices.ExistsTypeRequest;
import org.opensearch.client.opensearch.indices.FlushRequest;
import org.opensearch.client.opensearch.indices.FlushResponse;
import org.opensearch.client.opensearch.indices.FlushSyncedRequest;
import org.opensearch.client.opensearch.indices.FlushSyncedResponse;
import org.opensearch.client.opensearch.indices.ForcemergeRequest;
import org.opensearch.client.opensearch.indices.ForcemergeResponse;
import org.opensearch.client.opensearch.indices.GetAliasRequest;
import org.opensearch.client.opensearch.indices.GetAliasResponse;
import org.opensearch.client.opensearch.indices.GetFieldMappingRequest;
import org.opensearch.client.opensearch.indices.GetFieldMappingResponse;
import org.opensearch.client.opensearch.indices.GetIndexTemplateRequest;
import org.opensearch.client.opensearch.indices.GetIndexTemplateResponse;
import org.opensearch.client.opensearch.indices.GetMappingRequest;
import org.opensearch.client.opensearch.indices.GetMappingResponse;
import org.opensearch.client.opensearch.indices.GetRequest;
import org.opensearch.client.opensearch.indices.GetResponse;
import org.opensearch.client.opensearch.indices.GetSettingsRequest;
import org.opensearch.client.opensearch.indices.GetSettingsResponse;
import org.opensearch.client.opensearch.indices.GetTemplateRequest;
import org.opensearch.client.opensearch.indices.GetTemplateResponse;
import org.opensearch.client.opensearch.indices.GetUpgradeRequest;
import org.opensearch.client.opensearch.indices.GetUpgradeResponse;
import org.opensearch.client.opensearch.indices.OpenRequest;
import org.opensearch.client.opensearch.indices.OpenResponse;
import org.opensearch.client.opensearch.indices.PutAliasRequest;
import org.opensearch.client.opensearch.indices.PutAliasResponse;
import org.opensearch.client.opensearch.indices.PutIndexTemplateRequest;
import org.opensearch.client.opensearch.indices.PutIndexTemplateResponse;
import org.opensearch.client.opensearch.indices.PutMappingRequest;
import org.opensearch.client.opensearch.indices.PutMappingResponse;
import org.opensearch.client.opensearch.indices.PutSettingsRequest;
import org.opensearch.client.opensearch.indices.PutSettingsResponse;
import org.opensearch.client.opensearch.indices.PutTemplateRequest;
import org.opensearch.client.opensearch.indices.PutTemplateResponse;
import org.opensearch.client.opensearch.indices.RecoveryRequest;
import org.opensearch.client.opensearch.indices.RecoveryResponse;
import org.opensearch.client.opensearch.indices.RefreshRequest;
import org.opensearch.client.opensearch.indices.RefreshResponse;
import org.opensearch.client.opensearch.indices.ResolveIndexRequest;
import org.opensearch.client.opensearch.indices.ResolveIndexResponse;
import org.opensearch.client.opensearch.indices.RolloverRequest;
import org.opensearch.client.opensearch.indices.RolloverResponse;
import org.opensearch.client.opensearch.indices.SegmentsRequest;
import org.opensearch.client.opensearch.indices.SegmentsResponse;
import org.opensearch.client.opensearch.indices.ShardStoresRequest;
import org.opensearch.client.opensearch.indices.ShardStoresResponse;
import org.opensearch.client.opensearch.indices.ShrinkRequest;
import org.opensearch.client.opensearch.indices.ShrinkResponse;
import org.opensearch.client.opensearch.indices.SimulateIndexTemplateRequest;
import org.opensearch.client.opensearch.indices.SimulateIndexTemplateResponse;
import org.opensearch.client.opensearch.indices.SimulateTemplateRequest;
import org.opensearch.client.opensearch.indices.SimulateTemplateResponse;
import org.opensearch.client.opensearch.indices.SplitRequest;
import org.opensearch.client.opensearch.indices.SplitResponse;
import org.opensearch.client.opensearch.indices.StatsRequest;
import org.opensearch.client.opensearch.indices.StatsResponse;
import org.opensearch.client.opensearch.indices.UpdateAliasesRequest;
import org.opensearch.client.opensearch.indices.UpdateAliasesResponse;
import org.opensearch.client.opensearch.indices.UpgradeRequest;
import org.opensearch.client.opensearch.indices.UpgradeResponse;
import org.opensearch.client.opensearch.indices.ValidateQueryRequest;
import org.opensearch.client.opensearch.indices.ValidateQueryResponse;
import org.opensearch.client.util.ObjectBuilder;

import javax.annotation.Nullable;
import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;

/**
 * Client for the indices namespace.
 */
public class IndicesAsyncClient extends ApiClient<IndicesAsyncClient> {

	public IndicesAsyncClient(Transport transport) {
		super(transport, null);
	}

	public IndicesAsyncClient(Transport transport, RequestOptions options) {
		super(transport, options);
	}

	// ----- Endpoint: indices.add_block

	/**
	 * Adds a block to an index.
	 *
	 */

	public CompletableFuture<AddBlockResponse> addBlock(AddBlockRequest request) throws IOException {
		return this.transport.performRequestAsync(request, AddBlockRequest.ENDPOINT, this.requestOptions);
	}

	/**
	 * Adds a block to an index.
	 *
	 * @param fn
	 *            a function that initializes a freshly created builder. This
	 *            function can either return its builder argument after having set
	 *            its properties or return another builder.
	 */

	public final CompletableFuture<AddBlockResponse> addBlock(
			Function<AddBlockRequest.Builder, ObjectBuilder<AddBlockRequest>> fn) throws IOException {
		return addBlock(fn.apply(new AddBlockRequest.Builder()).build());
	}

	// ----- Endpoint: indices.analyze

	/**
	 * Performs the analysis process on a text and return the tokens breakdown of
	 * the text.
	 *
	 */

	public CompletableFuture<AnalyzeResponse> analyze(AnalyzeRequest request) throws IOException {
		return this.transport.performRequestAsync(request, AnalyzeRequest.ENDPOINT, this.requestOptions);
	}

	/**
	 * Performs the analysis process on a text and return the tokens breakdown of
	 * the text.
	 *
	 * @param fn
	 *            a function that initializes a freshly created builder. This
	 *            function can either return its builder argument after having set
	 *            its properties or return another builder.
	 */

	public final CompletableFuture<AnalyzeResponse> analyze(
			Function<AnalyzeRequest.Builder, ObjectBuilder<AnalyzeRequest>> fn) throws IOException {
		return analyze(fn.apply(new AnalyzeRequest.Builder()).build());
	}

	// ----- Endpoint: indices.clear_cache

	/**
	 * Clears all or specific caches for one or more indices.
	 *
	 */

	public CompletableFuture<ClearCacheResponse> clearCache(ClearCacheRequest request) throws IOException {
		return this.transport.performRequestAsync(request, ClearCacheRequest.ENDPOINT, this.requestOptions);
	}

	/**
	 * Clears all or specific caches for one or more indices.
	 *
	 * @param fn
	 *            a function that initializes a freshly created builder. This
	 *            function can either return its builder argument after having set
	 *            its properties or return another builder.
	 */

	public final CompletableFuture<ClearCacheResponse> clearCache(
			Function<ClearCacheRequest.Builder, ObjectBuilder<ClearCacheRequest>> fn) throws IOException {
		return clearCache(fn.apply(new ClearCacheRequest.Builder()).build());
	}

	// ----- Endpoint: indices.clone

	/**
	 * Clones an index
	 *
	 */

	public CompletableFuture<CloneResponse> clone(CloneRequest request) throws IOException {
		return this.transport.performRequestAsync(request, CloneRequest.ENDPOINT, this.requestOptions);
	}

	/**
	 * Clones an index
	 *
	 * @param fn
	 *            a function that initializes a freshly created builder. This
	 *            function can either return its builder argument after having set
	 *            its properties or return another builder.
	 */

	public final CompletableFuture<CloneResponse> clone(Function<CloneRequest.Builder, ObjectBuilder<CloneRequest>> fn)
			throws IOException {
		return clone(fn.apply(new CloneRequest.Builder()).build());
	}

	// ----- Endpoint: indices.close

	/**
	 * Closes an index.
	 *
	 */

	public CompletableFuture<CloseResponse> close(CloseRequest request) throws IOException {
		return this.transport.performRequestAsync(request, CloseRequest.ENDPOINT, this.requestOptions);
	}

	/**
	 * Closes an index.
	 *
	 * @param fn
	 *            a function that initializes a freshly created builder. This
	 *            function can either return its builder argument after having set
	 *            its properties or return another builder.
	 */

	public final CompletableFuture<CloseResponse> close(Function<CloseRequest.Builder, ObjectBuilder<CloseRequest>> fn)
			throws IOException {
		return close(fn.apply(new CloseRequest.Builder()).build());
	}

	// ----- Endpoint: indices.create

	/**
	 * Creates an index with optional settings and mappings.
	 *
	 */

	public CompletableFuture<CreateResponse> create(CreateRequest request) throws IOException {
		return this.transport.performRequestAsync(request, CreateRequest.ENDPOINT, this.requestOptions);
	}

	/**
	 * Creates an index with optional settings and mappings.
	 *
	 * @param fn
	 *            a function that initializes a freshly created builder. This
	 *            function can either return its builder argument after having set
	 *            its properties or return another builder.
	 */

	public final CompletableFuture<CreateResponse> create(
			Function<CreateRequest.Builder, ObjectBuilder<CreateRequest>> fn) throws IOException {
		return create(fn.apply(new CreateRequest.Builder()).build());
	}

	// ----- Endpoint: indices.delete

	/**
	 * Deletes an index.
	 *
	 */

	public CompletableFuture<DeleteResponse> delete(DeleteRequest request) throws IOException {
		return this.transport.performRequestAsync(request, DeleteRequest.ENDPOINT, this.requestOptions);
	}

	/**
	 * Deletes an index.
	 *
	 * @param fn
	 *            a function that initializes a freshly created builder. This
	 *            function can either return its builder argument after having set
	 *            its properties or return another builder.
	 */

	public final CompletableFuture<DeleteResponse> delete(
			Function<DeleteRequest.Builder, ObjectBuilder<DeleteRequest>> fn) throws IOException {
		return delete(fn.apply(new DeleteRequest.Builder()).build());
	}

	// ----- Endpoint: indices.delete_alias

	/**
	 * Deletes an alias.
	 *
	 */

	public CompletableFuture<DeleteAliasResponse> deleteAlias(DeleteAliasRequest request) throws IOException {
		return this.transport.performRequestAsync(request, DeleteAliasRequest.ENDPOINT, this.requestOptions);
	}

	/**
	 * Deletes an alias.
	 *
	 * @param fn
	 *            a function that initializes a freshly created builder. This
	 *            function can either return its builder argument after having set
	 *            its properties or return another builder.
	 */

	public final CompletableFuture<DeleteAliasResponse> deleteAlias(
			Function<DeleteAliasRequest.Builder, ObjectBuilder<DeleteAliasRequest>> fn) throws IOException {
		return deleteAlias(fn.apply(new DeleteAliasRequest.Builder()).build());
	}

	// ----- Endpoint: indices.delete_index_template

	/**
	 * Deletes an index template.
	 *
	 */

	public CompletableFuture<DeleteIndexTemplateResponse> deleteIndexTemplate(DeleteIndexTemplateRequest request)
			throws IOException {
		return this.transport.performRequestAsync(request, DeleteIndexTemplateRequest.ENDPOINT, this.requestOptions);
	}

	/**
	 * Deletes an index template.
	 *
	 * @param fn
	 *            a function that initializes a freshly created builder. This
	 *            function can either return its builder argument after having set
	 *            its properties or return another builder.
	 */

	public final CompletableFuture<DeleteIndexTemplateResponse> deleteIndexTemplate(
			Function<DeleteIndexTemplateRequest.Builder, ObjectBuilder<DeleteIndexTemplateRequest>> fn)
			throws IOException {
		return deleteIndexTemplate(fn.apply(new DeleteIndexTemplateRequest.Builder()).build());
	}

	// ----- Endpoint: indices.delete_template

	/**
	 * Deletes an index template.
	 *
	 */

	public CompletableFuture<DeleteTemplateResponse> deleteTemplate(DeleteTemplateRequest request) throws IOException {
		return this.transport.performRequestAsync(request, DeleteTemplateRequest.ENDPOINT, this.requestOptions);
	}

	/**
	 * Deletes an index template.
	 *
	 * @param fn
	 *            a function that initializes a freshly created builder. This
	 *            function can either return its builder argument after having set
	 *            its properties or return another builder.
	 */

	public final CompletableFuture<DeleteTemplateResponse> deleteTemplate(
			Function<DeleteTemplateRequest.Builder, ObjectBuilder<DeleteTemplateRequest>> fn) throws IOException {
		return deleteTemplate(fn.apply(new DeleteTemplateRequest.Builder()).build());
	}

	// ----- Endpoint: indices.exists

	/**
	 * Returns information about whether a particular index exists.
	 *
	 */

	public CompletableFuture<BooleanResponse> exists(ExistsRequest request) throws IOException {
		return this.transport.performRequestAsync(request, ExistsRequest.ENDPOINT, this.requestOptions);
	}

	/**
	 * Returns information about whether a particular index exists.
	 *
	 * @param fn
	 *            a function that initializes a freshly created builder. This
	 *            function can either return its builder argument after having set
	 *            its properties or return another builder.
	 */

	public final CompletableFuture<BooleanResponse> exists(
			Function<ExistsRequest.Builder, ObjectBuilder<ExistsRequest>> fn) throws IOException {
		return exists(fn.apply(new ExistsRequest.Builder()).build());
	}

	// ----- Endpoint: indices.exists_alias

	/**
	 * Returns information about whether a particular alias exists.
	 *
	 */

	public CompletableFuture<BooleanResponse> existsAlias(ExistsAliasRequest request) throws IOException {
		return this.transport.performRequestAsync(request, ExistsAliasRequest.ENDPOINT, this.requestOptions);
	}

	/**
	 * Returns information about whether a particular alias exists.
	 *
	 * @param fn
	 *            a function that initializes a freshly created builder. This
	 *            function can either return its builder argument after having set
	 *            its properties or return another builder.
	 */

	public final CompletableFuture<BooleanResponse> existsAlias(
			Function<ExistsAliasRequest.Builder, ObjectBuilder<ExistsAliasRequest>> fn) throws IOException {
		return existsAlias(fn.apply(new ExistsAliasRequest.Builder()).build());
	}

	// ----- Endpoint: indices.exists_index_template

	/**
	 * Returns information about whether a particular index template exists.
	 *
	 */

	public CompletableFuture<BooleanResponse> existsIndexTemplate(ExistsIndexTemplateRequest request)
			throws IOException {
		return this.transport.performRequestAsync(request, ExistsIndexTemplateRequest.ENDPOINT, this.requestOptions);
	}

	/**
	 * Returns information about whether a particular index template exists.
	 *
	 * @param fn
	 *            a function that initializes a freshly created builder. This
	 *            function can either return its builder argument after having set
	 *            its properties or return another builder.
	 */

	public final CompletableFuture<BooleanResponse> existsIndexTemplate(
			Function<ExistsIndexTemplateRequest.Builder, ObjectBuilder<ExistsIndexTemplateRequest>> fn)
			throws IOException {
		return existsIndexTemplate(fn.apply(new ExistsIndexTemplateRequest.Builder()).build());
	}

	// ----- Endpoint: indices.exists_template

	/**
	 * Returns information about whether a particular index template exists.
	 *
	 */

	public CompletableFuture<BooleanResponse> existsTemplate(ExistsTemplateRequest request) throws IOException {
		return this.transport.performRequestAsync(request, ExistsTemplateRequest.ENDPOINT, this.requestOptions);
	}

	/**
	 * Returns information about whether a particular index template exists.
	 *
	 * @param fn
	 *            a function that initializes a freshly created builder. This
	 *            function can either return its builder argument after having set
	 *            its properties or return another builder.
	 */

	public final CompletableFuture<BooleanResponse> existsTemplate(
			Function<ExistsTemplateRequest.Builder, ObjectBuilder<ExistsTemplateRequest>> fn) throws IOException {
		return existsTemplate(fn.apply(new ExistsTemplateRequest.Builder()).build());
	}

	// ----- Endpoint: indices.exists_type

	/**
	 * Returns information about whether a particular document type exists.
	 * (DEPRECATED)
	 *
	 */

	public CompletableFuture<BooleanResponse> existsType(ExistsTypeRequest request) throws IOException {
		return this.transport.performRequestAsync(request, ExistsTypeRequest.ENDPOINT, this.requestOptions);
	}

	/**
	 * Returns information about whether a particular document type exists.
	 * (DEPRECATED)
	 *
	 * @param fn
	 *            a function that initializes a freshly created builder. This
	 *            function can either return its builder argument after having set
	 *            its properties or return another builder.
	 */

	public final CompletableFuture<BooleanResponse> existsType(
			Function<ExistsTypeRequest.Builder, ObjectBuilder<ExistsTypeRequest>> fn) throws IOException {
		return existsType(fn.apply(new ExistsTypeRequest.Builder()).build());
	}

	// ----- Endpoint: indices.flush

	/**
	 * Performs the flush operation on one or more indices.
	 *
	 */

	public CompletableFuture<FlushResponse> flush(FlushRequest request) throws IOException {
		return this.transport.performRequestAsync(request, FlushRequest.ENDPOINT, this.requestOptions);
	}

	/**
	 * Performs the flush operation on one or more indices.
	 *
	 * @param fn
	 *            a function that initializes a freshly created builder. This
	 *            function can either return its builder argument after having set
	 *            its properties or return another builder.
	 */

	public final CompletableFuture<FlushResponse> flush(Function<FlushRequest.Builder, ObjectBuilder<FlushRequest>> fn)
			throws IOException {
		return flush(fn.apply(new FlushRequest.Builder()).build());
	}

	// ----- Endpoint: indices.flush_synced

	/**
	 * Performs a synced flush operation on one or more indices. Synced flush is
	 * deprecated and will be removed in 8.0. Use flush instead
	 *
	 */

	public CompletableFuture<FlushSyncedResponse> flushSynced(FlushSyncedRequest request) throws IOException {
		return this.transport.performRequestAsync(request, FlushSyncedRequest.ENDPOINT, this.requestOptions);
	}

	/**
	 * Performs a synced flush operation on one or more indices. Synced flush is
	 * deprecated and will be removed in 8.0. Use flush instead
	 *
	 * @param fn
	 *            a function that initializes a freshly created builder. This
	 *            function can either return its builder argument after having set
	 *            its properties or return another builder.
	 */

	public final CompletableFuture<FlushSyncedResponse> flushSynced(
			Function<FlushSyncedRequest.Builder, ObjectBuilder<FlushSyncedRequest>> fn) throws IOException {
		return flushSynced(fn.apply(new FlushSyncedRequest.Builder()).build());
	}

	// ----- Endpoint: indices.forcemerge

	/**
	 * Performs the force merge operation on one or more indices.
	 *
	 */

	public CompletableFuture<ForcemergeResponse> forcemerge(ForcemergeRequest request) throws IOException {
		return this.transport.performRequestAsync(request, ForcemergeRequest.ENDPOINT, this.requestOptions);
	}

	/**
	 * Performs the force merge operation on one or more indices.
	 *
	 * @param fn
	 *            a function that initializes a freshly created builder. This
	 *            function can either return its builder argument after having set
	 *            its properties or return another builder.
	 */

	public final CompletableFuture<ForcemergeResponse> forcemerge(
			Function<ForcemergeRequest.Builder, ObjectBuilder<ForcemergeRequest>> fn) throws IOException {
		return forcemerge(fn.apply(new ForcemergeRequest.Builder()).build());
	}

	// ----- Endpoint: indices.get

	/**
	 * Returns information about one or more indices.
	 *
	 */

	public CompletableFuture<GetResponse> get(GetRequest request) throws IOException {
		return this.transport.performRequestAsync(request, GetRequest.ENDPOINT, this.requestOptions);
	}

	/**
	 * Returns information about one or more indices.
	 *
	 * @param fn
	 *            a function that initializes a freshly created builder. This
	 *            function can either return its builder argument after having set
	 *            its properties or return another builder.
	 */

	public final CompletableFuture<GetResponse> get(Function<GetRequest.Builder, ObjectBuilder<GetRequest>> fn)
			throws IOException {
		return get(fn.apply(new GetRequest.Builder()).build());
	}

	// ----- Endpoint: indices.get_alias

	/**
	 * Returns an alias.
	 *
	 */

	public CompletableFuture<GetAliasResponse> getAlias(GetAliasRequest request) throws IOException {
		return this.transport.performRequestAsync(request, GetAliasRequest.ENDPOINT, this.requestOptions);
	}

	/**
	 * Returns an alias.
	 *
	 * @param fn
	 *            a function that initializes a freshly created builder. This
	 *            function can either return its builder argument after having set
	 *            its properties or return another builder.
	 */

	public final CompletableFuture<GetAliasResponse> getAlias(
			Function<GetAliasRequest.Builder, ObjectBuilder<GetAliasRequest>> fn) throws IOException {
		return getAlias(fn.apply(new GetAliasRequest.Builder()).build());
	}

	// ----- Endpoint: indices.get_field_mapping

	/**
	 * Returns mapping for one or more fields.
	 *
	 */

	public CompletableFuture<GetFieldMappingResponse> getFieldMapping(GetFieldMappingRequest request)
			throws IOException {
		return this.transport.performRequestAsync(request, GetFieldMappingRequest.ENDPOINT, this.requestOptions);
	}

	/**
	 * Returns mapping for one or more fields.
	 *
	 * @param fn
	 *            a function that initializes a freshly created builder. This
	 *            function can either return its builder argument after having set
	 *            its properties or return another builder.
	 */

	public final CompletableFuture<GetFieldMappingResponse> getFieldMapping(
			Function<GetFieldMappingRequest.Builder, ObjectBuilder<GetFieldMappingRequest>> fn) throws IOException {
		return getFieldMapping(fn.apply(new GetFieldMappingRequest.Builder()).build());
	}

	// ----- Endpoint: indices.get_index_template

	/**
	 * Returns an index template.
	 *
	 */

	public CompletableFuture<GetIndexTemplateResponse> getIndexTemplate(GetIndexTemplateRequest request)
			throws IOException {
		return this.transport.performRequestAsync(request, GetIndexTemplateRequest.ENDPOINT, this.requestOptions);
	}

	/**
	 * Returns an index template.
	 *
	 * @param fn
	 *            a function that initializes a freshly created builder. This
	 *            function can either return its builder argument after having set
	 *            its properties or return another builder.
	 */

	public final CompletableFuture<GetIndexTemplateResponse> getIndexTemplate(
			Function<GetIndexTemplateRequest.Builder, ObjectBuilder<GetIndexTemplateRequest>> fn) throws IOException {
		return getIndexTemplate(fn.apply(new GetIndexTemplateRequest.Builder()).build());
	}

	// ----- Endpoint: indices.get_mapping

	/**
	 * Returns mappings for one or more indices.
	 *
	 */

	public CompletableFuture<GetMappingResponse> getMapping(GetMappingRequest request) throws IOException {
		return this.transport.performRequestAsync(request, GetMappingRequest.ENDPOINT, this.requestOptions);
	}

	/**
	 * Returns mappings for one or more indices.
	 *
	 * @param fn
	 *            a function that initializes a freshly created builder. This
	 *            function can either return its builder argument after having set
	 *            its properties or return another builder.
	 */

	public final CompletableFuture<GetMappingResponse> getMapping(
			Function<GetMappingRequest.Builder, ObjectBuilder<GetMappingRequest>> fn) throws IOException {
		return getMapping(fn.apply(new GetMappingRequest.Builder()).build());
	}

	// ----- Endpoint: indices.get_settings

	/**
	 * Returns settings for one or more indices.
	 *
	 */

	public CompletableFuture<GetSettingsResponse> getSettings(GetSettingsRequest request) throws IOException {
		return this.transport.performRequestAsync(request, GetSettingsRequest.ENDPOINT, this.requestOptions);
	}

	/**
	 * Returns settings for one or more indices.
	 *
	 * @param fn
	 *            a function that initializes a freshly created builder. This
	 *            function can either return its builder argument after having set
	 *            its properties or return another builder.
	 */

	public final CompletableFuture<GetSettingsResponse> getSettings(
			Function<GetSettingsRequest.Builder, ObjectBuilder<GetSettingsRequest>> fn) throws IOException {
		return getSettings(fn.apply(new GetSettingsRequest.Builder()).build());
	}

	// ----- Endpoint: indices.get_template

	/**
	 * Returns an index template.
	 *
	 */

	public CompletableFuture<GetTemplateResponse> getTemplate(GetTemplateRequest request) throws IOException {
		return this.transport.performRequestAsync(request, GetTemplateRequest.ENDPOINT, this.requestOptions);
	}

	/**
	 * Returns an index template.
	 *
	 * @param fn
	 *            a function that initializes a freshly created builder. This
	 *            function can either return its builder argument after having set
	 *            its properties or return another builder.
	 */

	public final CompletableFuture<GetTemplateResponse> getTemplate(
			Function<GetTemplateRequest.Builder, ObjectBuilder<GetTemplateRequest>> fn) throws IOException {
		return getTemplate(fn.apply(new GetTemplateRequest.Builder()).build());
	}

	// ----- Endpoint: indices.get_upgrade

	/**
	 * DEPRECATED Returns a progress status of current upgrade.
	 *
	 */

	public CompletableFuture<GetUpgradeResponse> getUpgrade(GetUpgradeRequest request) throws IOException {
		return this.transport.performRequestAsync(request, GetUpgradeRequest.ENDPOINT, this.requestOptions);
	}

	/**
	 * DEPRECATED Returns a progress status of current upgrade.
	 *
	 * @param fn
	 *            a function that initializes a freshly created builder. This
	 *            function can either return its builder argument after having set
	 *            its properties or return another builder.
	 */

	public final CompletableFuture<GetUpgradeResponse> getUpgrade(
			Function<GetUpgradeRequest.Builder, ObjectBuilder<GetUpgradeRequest>> fn) throws IOException {
		return getUpgrade(fn.apply(new GetUpgradeRequest.Builder()).build());
	}

	// ----- Endpoint: indices.open

	/**
	 * Opens an index.
	 *
	 */

	public CompletableFuture<OpenResponse> open(OpenRequest request) throws IOException {
		return this.transport.performRequestAsync(request, OpenRequest.ENDPOINT, this.requestOptions);
	}

	/**
	 * Opens an index.
	 *
	 * @param fn
	 *            a function that initializes a freshly created builder. This
	 *            function can either return its builder argument after having set
	 *            its properties or return another builder.
	 */

	public final CompletableFuture<OpenResponse> open(Function<OpenRequest.Builder, ObjectBuilder<OpenRequest>> fn)
			throws IOException {
		return open(fn.apply(new OpenRequest.Builder()).build());
	}

	// ----- Endpoint: indices.put_alias

	/**
	 * Creates or updates an alias.
	 *
	 */

	public CompletableFuture<PutAliasResponse> putAlias(PutAliasRequest request) throws IOException {
		return this.transport.performRequestAsync(request, PutAliasRequest.ENDPOINT, this.requestOptions);
	}

	/**
	 * Creates or updates an alias.
	 *
	 * @param fn
	 *            a function that initializes a freshly created builder. This
	 *            function can either return its builder argument after having set
	 *            its properties or return another builder.
	 */

	public final CompletableFuture<PutAliasResponse> putAlias(
			Function<PutAliasRequest.Builder, ObjectBuilder<PutAliasRequest>> fn) throws IOException {
		return putAlias(fn.apply(new PutAliasRequest.Builder()).build());
	}

	// ----- Endpoint: indices.put_index_template

	/**
	 * Creates or updates an index template.
	 *
	 */

	public CompletableFuture<PutIndexTemplateResponse> putIndexTemplate(PutIndexTemplateRequest request)
			throws IOException {
		return this.transport.performRequestAsync(request, PutIndexTemplateRequest.ENDPOINT, this.requestOptions);
	}

	/**
	 * Creates or updates an index template.
	 *
	 * @param fn
	 *            a function that initializes a freshly created builder. This
	 *            function can either return its builder argument after having set
	 *            its properties or return another builder.
	 */

	public final CompletableFuture<PutIndexTemplateResponse> putIndexTemplate(
			Function<PutIndexTemplateRequest.Builder, ObjectBuilder<PutIndexTemplateRequest>> fn) throws IOException {
		return putIndexTemplate(fn.apply(new PutIndexTemplateRequest.Builder()).build());
	}

	// ----- Endpoint: indices.put_mapping

	/**
	 * Updates the index mappings.
	 *
	 */

	public CompletableFuture<PutMappingResponse> putMapping(PutMappingRequest request) throws IOException {
		return this.transport.performRequestAsync(request, PutMappingRequest.ENDPOINT, this.requestOptions);
	}

	/**
	 * Updates the index mappings.
	 *
	 * @param fn
	 *            a function that initializes a freshly created builder. This
	 *            function can either return its builder argument after having set
	 *            its properties or return another builder.
	 */

	public final CompletableFuture<PutMappingResponse> putMapping(
			Function<PutMappingRequest.Builder, ObjectBuilder<PutMappingRequest>> fn) throws IOException {
		return putMapping(fn.apply(new PutMappingRequest.Builder()).build());
	}

	// ----- Endpoint: indices.put_settings

	/**
	 * Updates the index settings.
	 *
	 */

	public CompletableFuture<PutSettingsResponse> putSettings(PutSettingsRequest request) throws IOException {
		return this.transport.performRequestAsync(request, PutSettingsRequest.ENDPOINT, this.requestOptions);
	}

	/**
	 * Updates the index settings.
	 *
	 * @param fn
	 *            a function that initializes a freshly created builder. This
	 *            function can either return its builder argument after having set
	 *            its properties or return another builder.
	 */

	public final CompletableFuture<PutSettingsResponse> putSettings(
			Function<PutSettingsRequest.Builder, ObjectBuilder<PutSettingsRequest>> fn) throws IOException {
		return putSettings(fn.apply(new PutSettingsRequest.Builder()).build());
	}

	// ----- Endpoint: indices.put_template

	/**
	 * Creates or updates an index template.
	 *
	 */

	public CompletableFuture<PutTemplateResponse> putTemplate(PutTemplateRequest request) throws IOException {
		return this.transport.performRequestAsync(request, PutTemplateRequest.ENDPOINT, this.requestOptions);
	}

	/**
	 * Creates or updates an index template.
	 *
	 * @param fn
	 *            a function that initializes a freshly created builder. This
	 *            function can either return its builder argument after having set
	 *            its properties or return another builder.
	 */

	public final CompletableFuture<PutTemplateResponse> putTemplate(
			Function<PutTemplateRequest.Builder, ObjectBuilder<PutTemplateRequest>> fn) throws IOException {
		return putTemplate(fn.apply(new PutTemplateRequest.Builder()).build());
	}

	// ----- Endpoint: indices.recovery

	/**
	 * Returns information about ongoing index shard recoveries.
	 *
	 */

	public CompletableFuture<RecoveryResponse> recovery(RecoveryRequest request) throws IOException {
		return this.transport.performRequestAsync(request, RecoveryRequest.ENDPOINT, this.requestOptions);
	}

	/**
	 * Returns information about ongoing index shard recoveries.
	 *
	 * @param fn
	 *            a function that initializes a freshly created builder. This
	 *            function can either return its builder argument after having set
	 *            its properties or return another builder.
	 */

	public final CompletableFuture<RecoveryResponse> recovery(
			Function<RecoveryRequest.Builder, ObjectBuilder<RecoveryRequest>> fn) throws IOException {
		return recovery(fn.apply(new RecoveryRequest.Builder()).build());
	}

	// ----- Endpoint: indices.refresh

	/**
	 * Performs the refresh operation in one or more indices.
	 *
	 */

	public CompletableFuture<RefreshResponse> refresh(RefreshRequest request) throws IOException {
		return this.transport.performRequestAsync(request, RefreshRequest.ENDPOINT, this.requestOptions);
	}

	/**
	 * Performs the refresh operation in one or more indices.
	 *
	 * @param fn
	 *            a function that initializes a freshly created builder. This
	 *            function can either return its builder argument after having set
	 *            its properties or return another builder.
	 */

	public final CompletableFuture<RefreshResponse> refresh(
			Function<RefreshRequest.Builder, ObjectBuilder<RefreshRequest>> fn) throws IOException {
		return refresh(fn.apply(new RefreshRequest.Builder()).build());
	}

	// ----- Endpoint: indices.resolve_index

	/**
	 * Returns information about any matching indices, aliases, and data streams
	 *
	 */

	public CompletableFuture<ResolveIndexResponse> resolveIndex(ResolveIndexRequest request) throws IOException {
		return this.transport.performRequestAsync(request, ResolveIndexRequest.ENDPOINT, this.requestOptions);
	}

	/**
	 * Returns information about any matching indices, aliases, and data streams
	 *
	 * @param fn
	 *            a function that initializes a freshly created builder. This
	 *            function can either return its builder argument after having set
	 *            its properties or return another builder.
	 */

	public final CompletableFuture<ResolveIndexResponse> resolveIndex(
			Function<ResolveIndexRequest.Builder, ObjectBuilder<ResolveIndexRequest>> fn) throws IOException {
		return resolveIndex(fn.apply(new ResolveIndexRequest.Builder()).build());
	}

	// ----- Endpoint: indices.rollover

	/**
	 * Updates an alias to point to a new index when the existing index is
	 * considered to be too large or too old.
	 *
	 */

	public CompletableFuture<RolloverResponse> rollover(RolloverRequest request) throws IOException {
		return this.transport.performRequestAsync(request, RolloverRequest.ENDPOINT, this.requestOptions);
	}

	/**
	 * Updates an alias to point to a new index when the existing index is
	 * considered to be too large or too old.
	 *
	 * @param fn
	 *            a function that initializes a freshly created builder. This
	 *            function can either return its builder argument after having set
	 *            its properties or return another builder.
	 */

	public final CompletableFuture<RolloverResponse> rollover(
			Function<RolloverRequest.Builder, ObjectBuilder<RolloverRequest>> fn) throws IOException {
		return rollover(fn.apply(new RolloverRequest.Builder()).build());
	}

	// ----- Endpoint: indices.segments

	/**
	 * Provides low-level information about segments in a Lucene index.
	 *
	 */

	public CompletableFuture<SegmentsResponse> segments(SegmentsRequest request) throws IOException {
		return this.transport.performRequestAsync(request, SegmentsRequest.ENDPOINT, this.requestOptions);
	}

	/**
	 * Provides low-level information about segments in a Lucene index.
	 *
	 * @param fn
	 *            a function that initializes a freshly created builder. This
	 *            function can either return its builder argument after having set
	 *            its properties or return another builder.
	 */

	public final CompletableFuture<SegmentsResponse> segments(
			Function<SegmentsRequest.Builder, ObjectBuilder<SegmentsRequest>> fn) throws IOException {
		return segments(fn.apply(new SegmentsRequest.Builder()).build());
	}

	// ----- Endpoint: indices.shard_stores

	/**
	 * Provides store information for shard copies of indices.
	 *
	 */

	public CompletableFuture<ShardStoresResponse> shardStores(ShardStoresRequest request) throws IOException {
		return this.transport.performRequestAsync(request, ShardStoresRequest.ENDPOINT, this.requestOptions);
	}

	/**
	 * Provides store information for shard copies of indices.
	 *
	 * @param fn
	 *            a function that initializes a freshly created builder. This
	 *            function can either return its builder argument after having set
	 *            its properties or return another builder.
	 */

	public final CompletableFuture<ShardStoresResponse> shardStores(
			Function<ShardStoresRequest.Builder, ObjectBuilder<ShardStoresRequest>> fn) throws IOException {
		return shardStores(fn.apply(new ShardStoresRequest.Builder()).build());
	}

	// ----- Endpoint: indices.shrink

	/**
	 * Allow to shrink an existing index into a new index with fewer primary shards.
	 *
	 */

	public CompletableFuture<ShrinkResponse> shrink(ShrinkRequest request) throws IOException {
		return this.transport.performRequestAsync(request, ShrinkRequest.ENDPOINT, this.requestOptions);
	}

	/**
	 * Allow to shrink an existing index into a new index with fewer primary shards.
	 *
	 * @param fn
	 *            a function that initializes a freshly created builder. This
	 *            function can either return its builder argument after having set
	 *            its properties or return another builder.
	 */

	public final CompletableFuture<ShrinkResponse> shrink(
			Function<ShrinkRequest.Builder, ObjectBuilder<ShrinkRequest>> fn) throws IOException {
		return shrink(fn.apply(new ShrinkRequest.Builder()).build());
	}

	// ----- Endpoint: indices.simulate_index_template

	/**
	 * Simulate matching the given index name against the index templates in the
	 * system
	 *
	 */

	public CompletableFuture<SimulateIndexTemplateResponse> simulateIndexTemplate(SimulateIndexTemplateRequest request)
			throws IOException {
		return this.transport.performRequestAsync(request, SimulateIndexTemplateRequest.ENDPOINT, this.requestOptions);
	}

	/**
	 * Simulate matching the given index name against the index templates in the
	 * system
	 *
	 * @param fn
	 *            a function that initializes a freshly created builder. This
	 *            function can either return its builder argument after having set
	 *            its properties or return another builder.
	 */

	public final CompletableFuture<SimulateIndexTemplateResponse> simulateIndexTemplate(
			Function<SimulateIndexTemplateRequest.Builder, ObjectBuilder<SimulateIndexTemplateRequest>> fn)
			throws IOException {
		return simulateIndexTemplate(fn.apply(new SimulateIndexTemplateRequest.Builder()).build());
	}

	// ----- Endpoint: indices.simulate_template

	/**
	 * Simulate resolving the given template name or body
	 *
	 */

	public CompletableFuture<SimulateTemplateResponse> simulateTemplate(SimulateTemplateRequest request)
			throws IOException {
		return this.transport.performRequestAsync(request, SimulateTemplateRequest.ENDPOINT, this.requestOptions);
	}

	/**
	 * Simulate resolving the given template name or body
	 *
	 * @param fn
	 *            a function that initializes a freshly created builder. This
	 *            function can either return its builder argument after having set
	 *            its properties or return another builder.
	 */

	public final CompletableFuture<SimulateTemplateResponse> simulateTemplate(
			Function<SimulateTemplateRequest.Builder, ObjectBuilder<SimulateTemplateRequest>> fn) throws IOException {
		return simulateTemplate(fn.apply(new SimulateTemplateRequest.Builder()).build());
	}

	// ----- Endpoint: indices.split

	/**
	 * Allows you to split an existing index into a new index with more primary
	 * shards.
	 *
	 */

	public CompletableFuture<SplitResponse> split(SplitRequest request) throws IOException {
		return this.transport.performRequestAsync(request, SplitRequest.ENDPOINT, this.requestOptions);
	}

	/**
	 * Allows you to split an existing index into a new index with more primary
	 * shards.
	 *
	 * @param fn
	 *            a function that initializes a freshly created builder. This
	 *            function can either return its builder argument after having set
	 *            its properties or return another builder.
	 */

	public final CompletableFuture<SplitResponse> split(Function<SplitRequest.Builder, ObjectBuilder<SplitRequest>> fn)
			throws IOException {
		return split(fn.apply(new SplitRequest.Builder()).build());
	}

	// ----- Endpoint: indices.stats

	/**
	 * Provides statistics on operations happening in an index.
	 *
	 */

	public CompletableFuture<StatsResponse> stats(StatsRequest request) throws IOException {
		return this.transport.performRequestAsync(request, StatsRequest.ENDPOINT, this.requestOptions);
	}

	/**
	 * Provides statistics on operations happening in an index.
	 *
	 * @param fn
	 *            a function that initializes a freshly created builder. This
	 *            function can either return its builder argument after having set
	 *            its properties or return another builder.
	 */

	public final CompletableFuture<StatsResponse> stats(Function<StatsRequest.Builder, ObjectBuilder<StatsRequest>> fn)
			throws IOException {
		return stats(fn.apply(new StatsRequest.Builder()).build());
	}

	// ----- Endpoint: indices.update_aliases

	/**
	 * Updates index aliases.
	 *
	 */

	public CompletableFuture<UpdateAliasesResponse> updateAliases(UpdateAliasesRequest request) throws IOException {
		return this.transport.performRequestAsync(request, UpdateAliasesRequest.ENDPOINT, this.requestOptions);
	}

	/**
	 * Updates index aliases.
	 *
	 * @param fn
	 *            a function that initializes a freshly created builder. This
	 *            function can either return its builder argument after having set
	 *            its properties or return another builder.
	 */

	public final CompletableFuture<UpdateAliasesResponse> updateAliases(
			Function<UpdateAliasesRequest.Builder, ObjectBuilder<UpdateAliasesRequest>> fn) throws IOException {
		return updateAliases(fn.apply(new UpdateAliasesRequest.Builder()).build());
	}

	// ----- Endpoint: indices.upgrade

	/**
	 * DEPRECATED Upgrades to the current version of Lucene.
	 *
	 */

	public CompletableFuture<UpgradeResponse> upgrade(UpgradeRequest request) throws IOException {
		return this.transport.performRequestAsync(request, UpgradeRequest.ENDPOINT, this.requestOptions);
	}

	/**
	 * DEPRECATED Upgrades to the current version of Lucene.
	 *
	 * @param fn
	 *            a function that initializes a freshly created builder. This
	 *            function can either return its builder argument after having set
	 *            its properties or return another builder.
	 */

	public final CompletableFuture<UpgradeResponse> upgrade(
			Function<UpgradeRequest.Builder, ObjectBuilder<UpgradeRequest>> fn) throws IOException {
		return upgrade(fn.apply(new UpgradeRequest.Builder()).build());
	}

	// ----- Endpoint: indices.validate_query

	/**
	 * Allows a user to validate a potentially expensive query without executing it.
	 *
	 */

	public CompletableFuture<ValidateQueryResponse> validateQuery(ValidateQueryRequest request) throws IOException {
		return this.transport.performRequestAsync(request, ValidateQueryRequest.ENDPOINT, this.requestOptions);
	}

	/**
	 * Allows a user to validate a potentially expensive query without executing it.
	 *
	 * @param fn
	 *            a function that initializes a freshly created builder. This
	 *            function can either return its builder argument after having set
	 *            its properties or return another builder.
	 */

	public final CompletableFuture<ValidateQueryResponse> validateQuery(
			Function<ValidateQueryRequest.Builder, ObjectBuilder<ValidateQueryRequest>> fn) throws IOException {
		return validateQuery(fn.apply(new ValidateQueryRequest.Builder()).build());
	}

	// ----- Misc

	/**
	 * Creates a new {@link #IndicesAsyncClient} with specific request options.
	 */
	@Override
	public IndicesAsyncClient withRequestOptions(@Nullable RequestOptions options) {
		return new IndicesAsyncClient(transport, options);
	}

	/**
	 * Creates a new {@link #IndicesAsyncClient} with specific request options,
	 * inheriting existing options.
	 *
	 * @param fn
	 *            a function taking an options builder initialized with the current
	 *            request options, or initialized with default values.
	 */
	public IndicesAsyncClient withRequestOptions(Function<RequestOptions.Builder, RequestOptions.Builder> fn) {
		RequestOptions.Builder builder = requestOptions == null
				? RequestOptions.DEFAULT.toBuilder()
				: requestOptions.toBuilder();

		return withRequestOptions(fn.apply(builder).build());
	}
}
