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

//----------------------------------------------------
// THIS CODE IS GENERATED. MANUAL EDITS WILL BE LOST.
//----------------------------------------------------

package org.opensearch.clients.opensearch;

import org.elasticsearch.client.RequestOptions;
import org.opensearch.clients.base.ApiClient;
import org.opensearch.clients.base.BooleanResponse;
import org.opensearch.clients.base.Transport;
import org.opensearch.clients.opensearch._global.BulkRequest;
import org.opensearch.clients.opensearch._global.BulkResponse;
import org.opensearch.clients.opensearch._global.ClearScrollRequest;
import org.opensearch.clients.opensearch._global.ClearScrollResponse;
import org.opensearch.clients.opensearch._global.ClosePointInTimeRequest;
import org.opensearch.clients.opensearch._global.ClosePointInTimeResponse;
import org.opensearch.clients.opensearch._global.CountRequest;
import org.opensearch.clients.opensearch._global.CountResponse;
import org.opensearch.clients.opensearch._global.CreateRequest;
import org.opensearch.clients.opensearch._global.CreateResponse;
import org.opensearch.clients.opensearch._global.DeleteByQueryRequest;
import org.opensearch.clients.opensearch._global.DeleteByQueryResponse;
import org.opensearch.clients.opensearch._global.DeleteByQueryRethrottleRequest;
import org.opensearch.clients.opensearch._global.DeleteByQueryRethrottleResponse;
import org.opensearch.clients.opensearch._global.DeleteRequest;
import org.opensearch.clients.opensearch._global.DeleteResponse;
import org.opensearch.clients.opensearch._global.DeleteScriptRequest;
import org.opensearch.clients.opensearch._global.DeleteScriptResponse;
import org.opensearch.clients.opensearch._global.ExistsRequest;
import org.opensearch.clients.opensearch._global.ExistsSourceRequest;
import org.opensearch.clients.opensearch._global.ExplainRequest;
import org.opensearch.clients.opensearch._global.ExplainResponse;
import org.opensearch.clients.opensearch._global.FieldCapsRequest;
import org.opensearch.clients.opensearch._global.FieldCapsResponse;
import org.opensearch.clients.opensearch._global.GetRequest;
import org.opensearch.clients.opensearch._global.GetResponse;
import org.opensearch.clients.opensearch._global.GetScriptContextRequest;
import org.opensearch.clients.opensearch._global.GetScriptContextResponse;
import org.opensearch.clients.opensearch._global.GetScriptLanguagesRequest;
import org.opensearch.clients.opensearch._global.GetScriptLanguagesResponse;
import org.opensearch.clients.opensearch._global.GetScriptRequest;
import org.opensearch.clients.opensearch._global.GetScriptResponse;
import org.opensearch.clients.opensearch._global.GetSourceRequest;
import org.opensearch.clients.opensearch._global.GetSourceResponse;
import org.opensearch.clients.opensearch._global.IndexRequest;
import org.opensearch.clients.opensearch._global.IndexResponse;
import org.opensearch.clients.opensearch._global.InfoRequest;
import org.opensearch.clients.opensearch._global.InfoResponse;
import org.opensearch.clients.opensearch._global.MgetRequest;
import org.opensearch.clients.opensearch._global.MgetResponse;
import org.opensearch.clients.opensearch._global.MsearchRequest;
import org.opensearch.clients.opensearch._global.MsearchResponse;
import org.opensearch.clients.opensearch._global.MsearchTemplateRequest;
import org.opensearch.clients.opensearch._global.MsearchTemplateResponse;
import org.opensearch.clients.opensearch._global.MtermvectorsRequest;
import org.opensearch.clients.opensearch._global.MtermvectorsResponse;
import org.opensearch.clients.opensearch._global.OpenPointInTimeRequest;
import org.opensearch.clients.opensearch._global.OpenPointInTimeResponse;
import org.opensearch.clients.opensearch._global.PingRequest;
import org.opensearch.clients.opensearch._global.PutScriptRequest;
import org.opensearch.clients.opensearch._global.PutScriptResponse;
import org.opensearch.clients.opensearch._global.RankEvalRequest;
import org.opensearch.clients.opensearch._global.RankEvalResponse;
import org.opensearch.clients.opensearch._global.ReindexRequest;
import org.opensearch.clients.opensearch._global.ReindexResponse;
import org.opensearch.clients.opensearch._global.ReindexRethrottleRequest;
import org.opensearch.clients.opensearch._global.ReindexRethrottleResponse;
import org.opensearch.clients.opensearch._global.ScriptsPainlessExecuteRequest;
import org.opensearch.clients.opensearch._global.ScriptsPainlessExecuteResponse;
import org.opensearch.clients.opensearch._global.SearchRequest;
import org.opensearch.clients.opensearch._global.SearchResponse;
import org.opensearch.clients.opensearch._global.SearchShardsRequest;
import org.opensearch.clients.opensearch._global.SearchShardsResponse;
import org.opensearch.clients.opensearch._global.SearchTemplateRequest;
import org.opensearch.clients.opensearch._global.SearchTemplateResponse;
import org.opensearch.clients.opensearch._global.TermsEnumRequest;
import org.opensearch.clients.opensearch._global.TermsEnumResponse;
import org.opensearch.clients.opensearch._global.TermvectorsRequest;
import org.opensearch.clients.opensearch._global.TermvectorsResponse;
import org.opensearch.clients.opensearch._global.UpdateByQueryRequest;
import org.opensearch.clients.opensearch._global.UpdateByQueryResponse;
import org.opensearch.clients.opensearch._global.UpdateByQueryRethrottleRequest;
import org.opensearch.clients.opensearch._global.UpdateByQueryRethrottleResponse;
import org.opensearch.clients.opensearch._global.UpdateRequest;
import org.opensearch.clients.opensearch._global.UpdateResponse;
import org.opensearch.clients.opensearch.api.cat.CatClient;
import org.opensearch.clients.opensearch.api.cluster.ClusterClient;
import org.opensearch.clients.opensearch.api.dangling_indices.DanglingIndicesClient;
import org.opensearch.clients.opensearch.api.features.FeaturesClient;
import org.opensearch.clients.opensearch.api.indices.IndicesClient;
import org.opensearch.clients.opensearch.api.ingest.IngestClient;
import org.opensearch.clients.opensearch.api.nodes.NodesClient;
import org.opensearch.clients.opensearch.api.shutdown.ShutdownClient;
import org.opensearch.clients.opensearch.api.snapshot.SnapshotClient;
import org.opensearch.clients.opensearch.api.tasks.TasksClient;
import org.opensearch.clients.util.ObjectBuilder;

import javax.annotation.Nullable;
import java.io.IOException;
import java.util.function.Function;

/**
 * Client for the namespace.
 */
public class ElasticsearchClient extends ApiClient<ElasticsearchClient> {

	public ElasticsearchClient(Transport transport) {
		super(transport, null);
	}

	public ElasticsearchClient(Transport transport, RequestOptions options) {
		super(transport, options);
	}

	// ----- Child clients

	public CatClient cat() {
		return new CatClient(this.transport);
	}

	public ClusterClient cluster() {
		return new ClusterClient(this.transport);
	}

	public DanglingIndicesClient danglingIndices() {
		return new DanglingIndicesClient(this.transport);
	}

	public FeaturesClient features() {
		return new FeaturesClient(this.transport);
	}

	public IndicesClient indices() {
		return new IndicesClient(this.transport);
	}

	public IngestClient ingest() {
		return new IngestClient(this.transport);
	}

	public NodesClient nodes() {
		return new NodesClient(this.transport);
	}

	public ShutdownClient shutdown() {
		return new ShutdownClient(this.transport);
	}

	public SnapshotClient snapshot() {
		return new SnapshotClient(this.transport);
	}

	public TasksClient tasks() {
		return new TasksClient(this.transport);
	}

	// ----- Endpoint: bulk

	/**
	 * Allows to perform multiple index/update/delete operations in a single
	 * request.
	 *
	 * @see "https://www.elastic.co/guide/en/elasticsearch/reference/master/docs-bulk.html"
	 */

	public <TSource> BulkResponse bulk(BulkRequest<TSource> request) throws IOException {
		return this.transport.performRequest(request, BulkRequest.ENDPOINT, this.requestOptions);
	}

	/**
	 * Allows to perform multiple index/update/delete operations in a single
	 * request.
	 *
	 * @see "https://www.elastic.co/guide/en/elasticsearch/reference/master/docs-bulk.html"
	 * @param fn
	 *            a function that initializes a freshly created builder. This
	 *            function can either return its builder argument after having set
	 *            its properties or return another builder.
	 */

	public final <TSource> BulkResponse bulk(
			Function<BulkRequest.Builder<TSource>, ObjectBuilder<BulkRequest<TSource>>> fn) throws IOException {
		return bulk(fn.apply(new BulkRequest.Builder<TSource>()).build());
	}

	// ----- Endpoint: clear_scroll

	/**
	 * Explicitly clears the search context for a scroll.
	 *
	 * @see "https://www.elastic.co/guide/en/elasticsearch/reference/current/clear-scroll-api.html"
	 */

	public ClearScrollResponse clearScroll(ClearScrollRequest request) throws IOException {
		return this.transport.performRequest(request, ClearScrollRequest.ENDPOINT, this.requestOptions);
	}

	/**
	 * Explicitly clears the search context for a scroll.
	 *
	 * @see "https://www.elastic.co/guide/en/elasticsearch/reference/current/clear-scroll-api.html"
	 * @param fn
	 *            a function that initializes a freshly created builder. This
	 *            function can either return its builder argument after having set
	 *            its properties or return another builder.
	 */

	public final ClearScrollResponse clearScroll(
			Function<ClearScrollRequest.Builder, ObjectBuilder<ClearScrollRequest>> fn) throws IOException {
		return clearScroll(fn.apply(new ClearScrollRequest.Builder()).build());
	}

	// ----- Endpoint: close_point_in_time

	/**
	 * Close a point in time
	 *
	 * @see "https://www.elastic.co/guide/en/elasticsearch/reference/master/point-in-time-api.html"
	 */

	public ClosePointInTimeResponse closePointInTime(ClosePointInTimeRequest request) throws IOException {
		return this.transport.performRequest(request, ClosePointInTimeRequest.ENDPOINT, this.requestOptions);
	}

	/**
	 * Close a point in time
	 *
	 * @see "https://www.elastic.co/guide/en/elasticsearch/reference/master/point-in-time-api.html"
	 * @param fn
	 *            a function that initializes a freshly created builder. This
	 *            function can either return its builder argument after having set
	 *            its properties or return another builder.
	 */

	public final ClosePointInTimeResponse closePointInTime(
			Function<ClosePointInTimeRequest.Builder, ObjectBuilder<ClosePointInTimeRequest>> fn) throws IOException {
		return closePointInTime(fn.apply(new ClosePointInTimeRequest.Builder()).build());
	}

	// ----- Endpoint: count

	/**
	 * Returns number of documents matching a query.
	 *
	 * @see "https://www.elastic.co/guide/en/elasticsearch/reference/master/search-count.html"
	 */

	public CountResponse count(CountRequest request) throws IOException {
		return this.transport.performRequest(request, CountRequest.ENDPOINT, this.requestOptions);
	}

	/**
	 * Returns number of documents matching a query.
	 *
	 * @see "https://www.elastic.co/guide/en/elasticsearch/reference/master/search-count.html"
	 * @param fn
	 *            a function that initializes a freshly created builder. This
	 *            function can either return its builder argument after having set
	 *            its properties or return another builder.
	 */

	public final CountResponse count(Function<CountRequest.Builder, ObjectBuilder<CountRequest>> fn)
			throws IOException {
		return count(fn.apply(new CountRequest.Builder()).build());
	}

	// ----- Endpoint: create

	/**
	 * Creates a new document in the index.
	 *
	 * Returns a 409 response when a document with a same ID already exists in the
	 * index.
	 *
	 * @see "https://www.elastic.co/guide/en/elasticsearch/reference/master/docs-index_.html"
	 */

	public <TDocument> CreateResponse create(CreateRequest<TDocument> request) throws IOException {
		return this.transport.performRequest(request, CreateRequest.ENDPOINT, this.requestOptions);
	}

	/**
	 * Creates a new document in the index.
	 *
	 * Returns a 409 response when a document with a same ID already exists in the
	 * index.
	 *
	 * @see "https://www.elastic.co/guide/en/elasticsearch/reference/master/docs-index_.html"
	 * @param fn
	 *            a function that initializes a freshly created builder. This
	 *            function can either return its builder argument after having set
	 *            its properties or return another builder.
	 */

	public final <TDocument> CreateResponse create(
			Function<CreateRequest.Builder<TDocument>, ObjectBuilder<CreateRequest<TDocument>>> fn) throws IOException {
		return create(fn.apply(new CreateRequest.Builder<TDocument>()).build());
	}

	// ----- Endpoint: delete

	/**
	 * Removes a document from the index.
	 *
	 * @see "https://www.elastic.co/guide/en/elasticsearch/reference/master/docs-delete.html"
	 */

	public DeleteResponse delete(DeleteRequest request) throws IOException {
		return this.transport.performRequest(request, DeleteRequest.ENDPOINT, this.requestOptions);
	}

	/**
	 * Removes a document from the index.
	 *
	 * @see "https://www.elastic.co/guide/en/elasticsearch/reference/master/docs-delete.html"
	 * @param fn
	 *            a function that initializes a freshly created builder. This
	 *            function can either return its builder argument after having set
	 *            its properties or return another builder.
	 */

	public final DeleteResponse delete(Function<DeleteRequest.Builder, ObjectBuilder<DeleteRequest>> fn)
			throws IOException {
		return delete(fn.apply(new DeleteRequest.Builder()).build());
	}

	// ----- Endpoint: delete_by_query

	/**
	 * Deletes documents matching the provided query.
	 *
	 * @see "https://www.elastic.co/guide/en/elasticsearch/reference/master/docs-delete-by-query.html"
	 */

	public DeleteByQueryResponse deleteByQuery(DeleteByQueryRequest request) throws IOException {
		return this.transport.performRequest(request, DeleteByQueryRequest.ENDPOINT, this.requestOptions);
	}

	/**
	 * Deletes documents matching the provided query.
	 *
	 * @see "https://www.elastic.co/guide/en/elasticsearch/reference/master/docs-delete-by-query.html"
	 * @param fn
	 *            a function that initializes a freshly created builder. This
	 *            function can either return its builder argument after having set
	 *            its properties or return another builder.
	 */

	public final DeleteByQueryResponse deleteByQuery(
			Function<DeleteByQueryRequest.Builder, ObjectBuilder<DeleteByQueryRequest>> fn) throws IOException {
		return deleteByQuery(fn.apply(new DeleteByQueryRequest.Builder()).build());
	}

	// ----- Endpoint: delete_by_query_rethrottle

	/**
	 * Changes the number of requests per second for a particular Delete By Query
	 * operation.
	 *
	 * @see "https://www.elastic.co/guide/en/elasticsearch/reference/current/docs-delete-by-query.html"
	 */

	public DeleteByQueryRethrottleResponse deleteByQueryRethrottle(DeleteByQueryRethrottleRequest request)
			throws IOException {
		return this.transport.performRequest(request, DeleteByQueryRethrottleRequest.ENDPOINT, this.requestOptions);
	}

	/**
	 * Changes the number of requests per second for a particular Delete By Query
	 * operation.
	 *
	 * @see "https://www.elastic.co/guide/en/elasticsearch/reference/current/docs-delete-by-query.html"
	 * @param fn
	 *            a function that initializes a freshly created builder. This
	 *            function can either return its builder argument after having set
	 *            its properties or return another builder.
	 */

	public final DeleteByQueryRethrottleResponse deleteByQueryRethrottle(
			Function<DeleteByQueryRethrottleRequest.Builder, ObjectBuilder<DeleteByQueryRethrottleRequest>> fn)
			throws IOException {
		return deleteByQueryRethrottle(fn.apply(new DeleteByQueryRethrottleRequest.Builder()).build());
	}

	// ----- Endpoint: delete_script

	/**
	 * Deletes a script.
	 *
	 * @see "https://www.elastic.co/guide/en/elasticsearch/reference/master/modules-scripting.html"
	 */

	public DeleteScriptResponse deleteScript(DeleteScriptRequest request) throws IOException {
		return this.transport.performRequest(request, DeleteScriptRequest.ENDPOINT, this.requestOptions);
	}

	/**
	 * Deletes a script.
	 *
	 * @see "https://www.elastic.co/guide/en/elasticsearch/reference/master/modules-scripting.html"
	 * @param fn
	 *            a function that initializes a freshly created builder. This
	 *            function can either return its builder argument after having set
	 *            its properties or return another builder.
	 */

	public final DeleteScriptResponse deleteScript(
			Function<DeleteScriptRequest.Builder, ObjectBuilder<DeleteScriptRequest>> fn) throws IOException {
		return deleteScript(fn.apply(new DeleteScriptRequest.Builder()).build());
	}

	// ----- Endpoint: exists

	/**
	 * Returns information about whether a document exists in an index.
	 *
	 * @see "https://www.elastic.co/guide/en/elasticsearch/reference/master/docs-get.html"
	 */

	public BooleanResponse exists(ExistsRequest request) throws IOException {
		return this.transport.performRequest(request, ExistsRequest.ENDPOINT, this.requestOptions);
	}

	/**
	 * Returns information about whether a document exists in an index.
	 *
	 * @see "https://www.elastic.co/guide/en/elasticsearch/reference/master/docs-get.html"
	 * @param fn
	 *            a function that initializes a freshly created builder. This
	 *            function can either return its builder argument after having set
	 *            its properties or return another builder.
	 */

	public final BooleanResponse exists(Function<ExistsRequest.Builder, ObjectBuilder<ExistsRequest>> fn)
			throws IOException {
		return exists(fn.apply(new ExistsRequest.Builder()).build());
	}

	// ----- Endpoint: exists_source

	/**
	 * Returns information about whether a document source exists in an index.
	 *
	 * @see "https://www.elastic.co/guide/en/elasticsearch/reference/master/docs-get.html"
	 */

	public BooleanResponse existsSource(ExistsSourceRequest request) throws IOException {
		return this.transport.performRequest(request, ExistsSourceRequest.ENDPOINT, this.requestOptions);
	}

	/**
	 * Returns information about whether a document source exists in an index.
	 *
	 * @see "https://www.elastic.co/guide/en/elasticsearch/reference/master/docs-get.html"
	 * @param fn
	 *            a function that initializes a freshly created builder. This
	 *            function can either return its builder argument after having set
	 *            its properties or return another builder.
	 */

	public final BooleanResponse existsSource(
			Function<ExistsSourceRequest.Builder, ObjectBuilder<ExistsSourceRequest>> fn) throws IOException {
		return existsSource(fn.apply(new ExistsSourceRequest.Builder()).build());
	}

	// ----- Endpoint: explain

	/**
	 * Returns information about why a specific matches (or doesn't match) a query.
	 *
	 * @see "https://www.elastic.co/guide/en/elasticsearch/reference/master/search-explain.html"
	 */

	public <TDocument> ExplainResponse<TDocument> explain(ExplainRequest request, Class<TDocument> tDocumentClass)
			throws IOException {
		return this.transport.performRequest(request,
				ExplainRequest.createExplainEndpoint(getDeserializer(tDocumentClass)), this.requestOptions);
	}

	/**
	 * Returns information about why a specific matches (or doesn't match) a query.
	 *
	 * @see "https://www.elastic.co/guide/en/elasticsearch/reference/master/search-explain.html"
	 * @param fn
	 *            a function that initializes a freshly created builder. This
	 *            function can either return its builder argument after having set
	 *            its properties or return another builder.
	 */

	public final <TDocument> ExplainResponse<TDocument> explain(
			Function<ExplainRequest.Builder, ObjectBuilder<ExplainRequest>> fn, Class<TDocument> tDocumentClass)
			throws IOException {
		return explain(fn.apply(new ExplainRequest.Builder()).build(), tDocumentClass);
	}

	// ----- Endpoint: field_caps

	/**
	 * Returns the information about the capabilities of fields among multiple
	 * indices.
	 *
	 * @see "https://www.elastic.co/guide/en/elasticsearch/reference/master/search-field-caps.html"
	 */

	public FieldCapsResponse fieldCaps(FieldCapsRequest request) throws IOException {
		return this.transport.performRequest(request, FieldCapsRequest.ENDPOINT, this.requestOptions);
	}

	/**
	 * Returns the information about the capabilities of fields among multiple
	 * indices.
	 *
	 * @see "https://www.elastic.co/guide/en/elasticsearch/reference/master/search-field-caps.html"
	 * @param fn
	 *            a function that initializes a freshly created builder. This
	 *            function can either return its builder argument after having set
	 *            its properties or return another builder.
	 */

	public final FieldCapsResponse fieldCaps(Function<FieldCapsRequest.Builder, ObjectBuilder<FieldCapsRequest>> fn)
			throws IOException {
		return fieldCaps(fn.apply(new FieldCapsRequest.Builder()).build());
	}

	// ----- Endpoint: get

	/**
	 * Returns a document.
	 *
	 * @see "https://www.elastic.co/guide/en/elasticsearch/reference/master/docs-get.html"
	 */

	public <TDocument> GetResponse<TDocument> get(GetRequest request, Class<TDocument> tDocumentClass)
			throws IOException {
		return this.transport.performRequest(request, GetRequest.createGetEndpoint(getDeserializer(tDocumentClass)),
				this.requestOptions);
	}

	/**
	 * Returns a document.
	 *
	 * @see "https://www.elastic.co/guide/en/elasticsearch/reference/master/docs-get.html"
	 * @param fn
	 *            a function that initializes a freshly created builder. This
	 *            function can either return its builder argument after having set
	 *            its properties or return another builder.
	 */

	public final <TDocument> GetResponse<TDocument> get(Function<GetRequest.Builder, ObjectBuilder<GetRequest>> fn,
			Class<TDocument> tDocumentClass) throws IOException {
		return get(fn.apply(new GetRequest.Builder()).build(), tDocumentClass);
	}

	// ----- Endpoint: get_script

	/**
	 * Returns a script.
	 *
	 * @see "https://www.elastic.co/guide/en/elasticsearch/reference/master/modules-scripting.html"
	 */

	public GetScriptResponse getScript(GetScriptRequest request) throws IOException {
		return this.transport.performRequest(request, GetScriptRequest.ENDPOINT, this.requestOptions);
	}

	/**
	 * Returns a script.
	 *
	 * @see "https://www.elastic.co/guide/en/elasticsearch/reference/master/modules-scripting.html"
	 * @param fn
	 *            a function that initializes a freshly created builder. This
	 *            function can either return its builder argument after having set
	 *            its properties or return another builder.
	 */

	public final GetScriptResponse getScript(Function<GetScriptRequest.Builder, ObjectBuilder<GetScriptRequest>> fn)
			throws IOException {
		return getScript(fn.apply(new GetScriptRequest.Builder()).build());
	}

	// ----- Endpoint: get_script_context

	/**
	 * Returns all script contexts.
	 *
	 * @see "https://www.elastic.co/guide/en/elasticsearch/painless/master/painless-contexts.html"
	 */
	public GetScriptContextResponse getScriptContext() throws IOException {
		return this.transport.performRequest(GetScriptContextRequest.INSTANCE, GetScriptContextRequest.ENDPOINT,
				this.requestOptions);
	}

	// ----- Endpoint: get_script_languages

	/**
	 * Returns available script types, languages and contexts
	 *
	 * @see "https://www.elastic.co/guide/en/elasticsearch/reference/master/modules-scripting.html"
	 */
	public GetScriptLanguagesResponse getScriptLanguages() throws IOException {
		return this.transport.performRequest(GetScriptLanguagesRequest.INSTANCE, GetScriptLanguagesRequest.ENDPOINT,
				this.requestOptions);
	}

	// ----- Endpoint: get_source

	/**
	 * Returns the source of a document.
	 *
	 * @see "https://www.elastic.co/guide/en/elasticsearch/reference/master/docs-get.html"
	 */

	public <TDocument> GetSourceResponse<TDocument> getSource(GetSourceRequest request, Class<TDocument> tDocumentClass)
			throws IOException {
		return this.transport.performRequest(request,
				GetSourceRequest.createGetSourceEndpoint(getDeserializer(tDocumentClass)), this.requestOptions);
	}

	/**
	 * Returns the source of a document.
	 *
	 * @see "https://www.elastic.co/guide/en/elasticsearch/reference/master/docs-get.html"
	 * @param fn
	 *            a function that initializes a freshly created builder. This
	 *            function can either return its builder argument after having set
	 *            its properties or return another builder.
	 */

	public final <TDocument> GetSourceResponse<TDocument> getSource(
			Function<GetSourceRequest.Builder, ObjectBuilder<GetSourceRequest>> fn, Class<TDocument> tDocumentClass)
			throws IOException {
		return getSource(fn.apply(new GetSourceRequest.Builder()).build(), tDocumentClass);
	}

	// ----- Endpoint: index

	/**
	 * Creates or updates a document in an index.
	 *
	 * @see "https://www.elastic.co/guide/en/elasticsearch/reference/master/docs-index_.html"
	 */

	public <TDocument> IndexResponse index(IndexRequest<TDocument> request) throws IOException {
		return this.transport.performRequest(request, IndexRequest.ENDPOINT, this.requestOptions);
	}

	/**
	 * Creates or updates a document in an index.
	 *
	 * @see "https://www.elastic.co/guide/en/elasticsearch/reference/master/docs-index_.html"
	 * @param fn
	 *            a function that initializes a freshly created builder. This
	 *            function can either return its builder argument after having set
	 *            its properties or return another builder.
	 */

	public final <TDocument> IndexResponse index(
			Function<IndexRequest.Builder<TDocument>, ObjectBuilder<IndexRequest<TDocument>>> fn) throws IOException {
		return index(fn.apply(new IndexRequest.Builder<TDocument>()).build());
	}

	// ----- Endpoint: info

	/**
	 * Returns basic information about the cluster.
	 *
	 * @see "https://www.elastic.co/guide/en/elasticsearch/reference/current/index.html"
	 */
	public InfoResponse info() throws IOException {
		return this.transport.performRequest(InfoRequest.INSTANCE, InfoRequest.ENDPOINT, this.requestOptions);
	}

	// ----- Endpoint: mget

	/**
	 * Allows to get multiple documents in one request.
	 *
	 * @see "https://www.elastic.co/guide/en/elasticsearch/reference/master/docs-multi-get.html"
	 */

	public <TDocument> MgetResponse<TDocument> mget(MgetRequest request, Class<TDocument> tDocumentClass)
			throws IOException {
		return this.transport.performRequest(request, MgetRequest.createMgetEndpoint(getDeserializer(tDocumentClass)),
				this.requestOptions);
	}

	/**
	 * Allows to get multiple documents in one request.
	 *
	 * @see "https://www.elastic.co/guide/en/elasticsearch/reference/master/docs-multi-get.html"
	 * @param fn
	 *            a function that initializes a freshly created builder. This
	 *            function can either return its builder argument after having set
	 *            its properties or return another builder.
	 */

	public final <TDocument> MgetResponse<TDocument> mget(Function<MgetRequest.Builder, ObjectBuilder<MgetRequest>> fn,
			Class<TDocument> tDocumentClass) throws IOException {
		return mget(fn.apply(new MgetRequest.Builder()).build(), tDocumentClass);
	}

	// ----- Endpoint: msearch

	/**
	 * Allows to execute several search operations in one request.
	 *
	 * @see "https://www.elastic.co/guide/en/elasticsearch/reference/master/search-multi-search.html"
	 */

	public <TDocument> MsearchResponse<TDocument> msearch(MsearchRequest request, Class<TDocument> tDocumentClass)
			throws IOException {
		return this.transport.performRequest(request,
				MsearchRequest.createMsearchEndpoint(getDeserializer(tDocumentClass)), this.requestOptions);
	}

	/**
	 * Allows to execute several search operations in one request.
	 *
	 * @see "https://www.elastic.co/guide/en/elasticsearch/reference/master/search-multi-search.html"
	 * @param fn
	 *            a function that initializes a freshly created builder. This
	 *            function can either return its builder argument after having set
	 *            its properties or return another builder.
	 */

	public final <TDocument> MsearchResponse<TDocument> msearch(
			Function<MsearchRequest.Builder, ObjectBuilder<MsearchRequest>> fn, Class<TDocument> tDocumentClass)
			throws IOException {
		return msearch(fn.apply(new MsearchRequest.Builder()).build(), tDocumentClass);
	}

	// ----- Endpoint: msearch_template

	/**
	 * Allows to execute several search template operations in one request.
	 *
	 * @see "https://www.elastic.co/guide/en/elasticsearch/reference/current/search-multi-search.html"
	 */

	public <TDocument> MsearchTemplateResponse<TDocument> msearchTemplate(MsearchTemplateRequest request,
			Class<TDocument> tDocumentClass) throws IOException {
		return this.transport.performRequest(request,
				MsearchTemplateRequest.createMsearchTemplateEndpoint(getDeserializer(tDocumentClass)),
				this.requestOptions);
	}

	/**
	 * Allows to execute several search template operations in one request.
	 *
	 * @see "https://www.elastic.co/guide/en/elasticsearch/reference/current/search-multi-search.html"
	 * @param fn
	 *            a function that initializes a freshly created builder. This
	 *            function can either return its builder argument after having set
	 *            its properties or return another builder.
	 */

	public final <TDocument> MsearchTemplateResponse<TDocument> msearchTemplate(
			Function<MsearchTemplateRequest.Builder, ObjectBuilder<MsearchTemplateRequest>> fn,
			Class<TDocument> tDocumentClass) throws IOException {
		return msearchTemplate(fn.apply(new MsearchTemplateRequest.Builder()).build(), tDocumentClass);
	}

	// ----- Endpoint: mtermvectors

	/**
	 * Returns multiple termvectors in one request.
	 *
	 * @see "https://www.elastic.co/guide/en/elasticsearch/reference/master/docs-multi-termvectors.html"
	 */

	public MtermvectorsResponse mtermvectors(MtermvectorsRequest request) throws IOException {
		return this.transport.performRequest(request, MtermvectorsRequest.ENDPOINT, this.requestOptions);
	}

	/**
	 * Returns multiple termvectors in one request.
	 *
	 * @see "https://www.elastic.co/guide/en/elasticsearch/reference/master/docs-multi-termvectors.html"
	 * @param fn
	 *            a function that initializes a freshly created builder. This
	 *            function can either return its builder argument after having set
	 *            its properties or return another builder.
	 */

	public final MtermvectorsResponse mtermvectors(
			Function<MtermvectorsRequest.Builder, ObjectBuilder<MtermvectorsRequest>> fn) throws IOException {
		return mtermvectors(fn.apply(new MtermvectorsRequest.Builder()).build());
	}

	// ----- Endpoint: open_point_in_time

	/**
	 * Open a point in time that can be used in subsequent searches
	 *
	 * @see "https://www.elastic.co/guide/en/elasticsearch/reference/master/point-in-time-api.html"
	 */

	public OpenPointInTimeResponse openPointInTime(OpenPointInTimeRequest request) throws IOException {
		return this.transport.performRequest(request, OpenPointInTimeRequest.ENDPOINT, this.requestOptions);
	}

	/**
	 * Open a point in time that can be used in subsequent searches
	 *
	 * @see "https://www.elastic.co/guide/en/elasticsearch/reference/master/point-in-time-api.html"
	 * @param fn
	 *            a function that initializes a freshly created builder. This
	 *            function can either return its builder argument after having set
	 *            its properties or return another builder.
	 */

	public final OpenPointInTimeResponse openPointInTime(
			Function<OpenPointInTimeRequest.Builder, ObjectBuilder<OpenPointInTimeRequest>> fn) throws IOException {
		return openPointInTime(fn.apply(new OpenPointInTimeRequest.Builder()).build());
	}

	// ----- Endpoint: ping

	/**
	 * Returns whether the cluster is running.
	 *
	 * @see "https://www.elastic.co/guide/en/elasticsearch/reference/current/index.html"
	 */
	public BooleanResponse ping() throws IOException {
		return this.transport.performRequest(PingRequest.INSTANCE, PingRequest.ENDPOINT, this.requestOptions);
	}

	// ----- Endpoint: put_script

	/**
	 * Creates or updates a script.
	 *
	 * @see "https://www.elastic.co/guide/en/elasticsearch/reference/master/modules-scripting.html"
	 */

	public PutScriptResponse putScript(PutScriptRequest request) throws IOException {
		return this.transport.performRequest(request, PutScriptRequest.ENDPOINT, this.requestOptions);
	}

	/**
	 * Creates or updates a script.
	 *
	 * @see "https://www.elastic.co/guide/en/elasticsearch/reference/master/modules-scripting.html"
	 * @param fn
	 *            a function that initializes a freshly created builder. This
	 *            function can either return its builder argument after having set
	 *            its properties or return another builder.
	 */

	public final PutScriptResponse putScript(Function<PutScriptRequest.Builder, ObjectBuilder<PutScriptRequest>> fn)
			throws IOException {
		return putScript(fn.apply(new PutScriptRequest.Builder()).build());
	}

	// ----- Endpoint: rank_eval

	/**
	 * Allows to evaluate the quality of ranked search results over a set of typical
	 * search queries
	 *
	 * @see "https://www.elastic.co/guide/en/elasticsearch/reference/master/search-rank-eval.html"
	 */

	public RankEvalResponse rankEval(RankEvalRequest request) throws IOException {
		return this.transport.performRequest(request, RankEvalRequest.ENDPOINT, this.requestOptions);
	}

	/**
	 * Allows to evaluate the quality of ranked search results over a set of typical
	 * search queries
	 *
	 * @see "https://www.elastic.co/guide/en/elasticsearch/reference/master/search-rank-eval.html"
	 * @param fn
	 *            a function that initializes a freshly created builder. This
	 *            function can either return its builder argument after having set
	 *            its properties or return another builder.
	 */

	public final RankEvalResponse rankEval(Function<RankEvalRequest.Builder, ObjectBuilder<RankEvalRequest>> fn)
			throws IOException {
		return rankEval(fn.apply(new RankEvalRequest.Builder()).build());
	}

	// ----- Endpoint: reindex

	/**
	 * Allows to copy documents from one index to another, optionally filtering the
	 * source documents by a query, changing the destination index settings, or
	 * fetching the documents from a remote cluster.
	 *
	 * @see "https://www.elastic.co/guide/en/elasticsearch/reference/master/docs-reindex.html"
	 */

	public ReindexResponse reindex(ReindexRequest request) throws IOException {
		return this.transport.performRequest(request, ReindexRequest.ENDPOINT, this.requestOptions);
	}

	/**
	 * Allows to copy documents from one index to another, optionally filtering the
	 * source documents by a query, changing the destination index settings, or
	 * fetching the documents from a remote cluster.
	 *
	 * @see "https://www.elastic.co/guide/en/elasticsearch/reference/master/docs-reindex.html"
	 * @param fn
	 *            a function that initializes a freshly created builder. This
	 *            function can either return its builder argument after having set
	 *            its properties or return another builder.
	 */

	public final ReindexResponse reindex(Function<ReindexRequest.Builder, ObjectBuilder<ReindexRequest>> fn)
			throws IOException {
		return reindex(fn.apply(new ReindexRequest.Builder()).build());
	}

	// ----- Endpoint: reindex_rethrottle

	/**
	 * Changes the number of requests per second for a particular Reindex operation.
	 *
	 * @see "https://www.elastic.co/guide/en/elasticsearch/reference/master/docs-reindex.html"
	 */

	public ReindexRethrottleResponse reindexRethrottle(ReindexRethrottleRequest request) throws IOException {
		return this.transport.performRequest(request, ReindexRethrottleRequest.ENDPOINT, this.requestOptions);
	}

	/**
	 * Changes the number of requests per second for a particular Reindex operation.
	 *
	 * @see "https://www.elastic.co/guide/en/elasticsearch/reference/master/docs-reindex.html"
	 * @param fn
	 *            a function that initializes a freshly created builder. This
	 *            function can either return its builder argument after having set
	 *            its properties or return another builder.
	 */

	public final ReindexRethrottleResponse reindexRethrottle(
			Function<ReindexRethrottleRequest.Builder, ObjectBuilder<ReindexRethrottleRequest>> fn) throws IOException {
		return reindexRethrottle(fn.apply(new ReindexRethrottleRequest.Builder()).build());
	}

	// ----- Endpoint: scripts_painless_execute

	/**
	 * Allows an arbitrary script to be executed and a result to be returned
	 *
	 * @see "https://www.elastic.co/guide/en/elasticsearch/painless/master/painless-execute-api.html"
	 */

	public <TResult> ScriptsPainlessExecuteResponse<TResult> scriptsPainlessExecute(
			ScriptsPainlessExecuteRequest request, Class<TResult> tResultClass) throws IOException {
		return this.transport.performRequest(request,
				ScriptsPainlessExecuteRequest.createScriptsPainlessExecuteEndpoint(getDeserializer(tResultClass)),
				this.requestOptions);
	}

	/**
	 * Allows an arbitrary script to be executed and a result to be returned
	 *
	 * @see "https://www.elastic.co/guide/en/elasticsearch/painless/master/painless-execute-api.html"
	 * @param fn
	 *            a function that initializes a freshly created builder. This
	 *            function can either return its builder argument after having set
	 *            its properties or return another builder.
	 */

	public final <TResult> ScriptsPainlessExecuteResponse<TResult> scriptsPainlessExecute(
			Function<ScriptsPainlessExecuteRequest.Builder, ObjectBuilder<ScriptsPainlessExecuteRequest>> fn,
			Class<TResult> tResultClass) throws IOException {
		return scriptsPainlessExecute(fn.apply(new ScriptsPainlessExecuteRequest.Builder()).build(), tResultClass);
	}

	// ----- Endpoint: search

	/**
	 * Returns results matching a query.
	 *
	 * @see "https://www.elastic.co/guide/en/elasticsearch/reference/master/search-search.html"
	 */

	public <TDocument> SearchResponse<TDocument> search(SearchRequest request, Class<TDocument> tDocumentClass)
			throws IOException {
		return this.transport.performRequest(request,
				SearchRequest.createSearchEndpoint(getDeserializer(tDocumentClass)), this.requestOptions);
	}

	/**
	 * Returns results matching a query.
	 *
	 * @see "https://www.elastic.co/guide/en/elasticsearch/reference/master/search-search.html"
	 * @param fn
	 *            a function that initializes a freshly created builder. This
	 *            function can either return its builder argument after having set
	 *            its properties or return another builder.
	 */

	public final <TDocument> SearchResponse<TDocument> search(
			Function<SearchRequest.Builder, ObjectBuilder<SearchRequest>> fn, Class<TDocument> tDocumentClass)
			throws IOException {
		return search(fn.apply(new SearchRequest.Builder()).build(), tDocumentClass);
	}

	// ----- Endpoint: search_shards

	/**
	 * Returns information about the indices and shards that a search request would
	 * be executed against.
	 *
	 * @see "https://www.elastic.co/guide/en/elasticsearch/reference/master/search-shards.html"
	 */

	public SearchShardsResponse searchShards(SearchShardsRequest request) throws IOException {
		return this.transport.performRequest(request, SearchShardsRequest.ENDPOINT, this.requestOptions);
	}

	/**
	 * Returns information about the indices and shards that a search request would
	 * be executed against.
	 *
	 * @see "https://www.elastic.co/guide/en/elasticsearch/reference/master/search-shards.html"
	 * @param fn
	 *            a function that initializes a freshly created builder. This
	 *            function can either return its builder argument after having set
	 *            its properties or return another builder.
	 */

	public final SearchShardsResponse searchShards(
			Function<SearchShardsRequest.Builder, ObjectBuilder<SearchShardsRequest>> fn) throws IOException {
		return searchShards(fn.apply(new SearchShardsRequest.Builder()).build());
	}

	// ----- Endpoint: search_template

	/**
	 * Allows to use the Mustache language to pre-render a search definition.
	 *
	 * @see "https://www.elastic.co/guide/en/elasticsearch/reference/current/search-template.html"
	 */

	public <TDocument> SearchTemplateResponse<TDocument> searchTemplate(SearchTemplateRequest request,
			Class<TDocument> tDocumentClass) throws IOException {
		return this.transport.performRequest(request,
				SearchTemplateRequest.createSearchTemplateEndpoint(getDeserializer(tDocumentClass)),
				this.requestOptions);
	}

	/**
	 * Allows to use the Mustache language to pre-render a search definition.
	 *
	 * @see "https://www.elastic.co/guide/en/elasticsearch/reference/current/search-template.html"
	 * @param fn
	 *            a function that initializes a freshly created builder. This
	 *            function can either return its builder argument after having set
	 *            its properties or return another builder.
	 */

	public final <TDocument> SearchTemplateResponse<TDocument> searchTemplate(
			Function<SearchTemplateRequest.Builder, ObjectBuilder<SearchTemplateRequest>> fn,
			Class<TDocument> tDocumentClass) throws IOException {
		return searchTemplate(fn.apply(new SearchTemplateRequest.Builder()).build(), tDocumentClass);
	}

	// ----- Endpoint: terms_enum

	/**
	 * The terms enum API can be used to discover terms in the index that begin with
	 * the provided string. It is designed for low-latency look-ups used in
	 * auto-complete scenarios.
	 *
	 * @see "https://www.elastic.co/guide/en/elasticsearch/reference/current/search-terms-enum.html"
	 */

	public TermsEnumResponse termsEnum(TermsEnumRequest request) throws IOException {
		return this.transport.performRequest(request, TermsEnumRequest.ENDPOINT, this.requestOptions);
	}

	/**
	 * The terms enum API can be used to discover terms in the index that begin with
	 * the provided string. It is designed for low-latency look-ups used in
	 * auto-complete scenarios.
	 *
	 * @see "https://www.elastic.co/guide/en/elasticsearch/reference/current/search-terms-enum.html"
	 * @param fn
	 *            a function that initializes a freshly created builder. This
	 *            function can either return its builder argument after having set
	 *            its properties or return another builder.
	 */

	public final TermsEnumResponse termsEnum(Function<TermsEnumRequest.Builder, ObjectBuilder<TermsEnumRequest>> fn)
			throws IOException {
		return termsEnum(fn.apply(new TermsEnumRequest.Builder()).build());
	}

	// ----- Endpoint: termvectors

	/**
	 * Returns information and statistics about terms in the fields of a particular
	 * document.
	 *
	 * @see "https://www.elastic.co/guide/en/elasticsearch/reference/master/docs-termvectors.html"
	 */

	public <TDocument> TermvectorsResponse termvectors(TermvectorsRequest<TDocument> request) throws IOException {
		return this.transport.performRequest(request, TermvectorsRequest.ENDPOINT, this.requestOptions);
	}

	/**
	 * Returns information and statistics about terms in the fields of a particular
	 * document.
	 *
	 * @see "https://www.elastic.co/guide/en/elasticsearch/reference/master/docs-termvectors.html"
	 * @param fn
	 *            a function that initializes a freshly created builder. This
	 *            function can either return its builder argument after having set
	 *            its properties or return another builder.
	 */

	public final <TDocument> TermvectorsResponse termvectors(
			Function<TermvectorsRequest.Builder<TDocument>, ObjectBuilder<TermvectorsRequest<TDocument>>> fn)
			throws IOException {
		return termvectors(fn.apply(new TermvectorsRequest.Builder<TDocument>()).build());
	}

	// ----- Endpoint: update

	/**
	 * Updates a document with a script or partial document.
	 *
	 * @see "https://www.elastic.co/guide/en/elasticsearch/reference/master/docs-update.html"
	 */

	public <TDocument, TPartialDocument> UpdateResponse<TDocument> update(
			UpdateRequest<TDocument, TPartialDocument> request, Class<TDocument> tDocumentClass) throws IOException {
		return this.transport.performRequest(request,
				UpdateRequest.createUpdateEndpoint(getDeserializer(tDocumentClass)), this.requestOptions);
	}

	/**
	 * Updates a document with a script or partial document.
	 *
	 * @see "https://www.elastic.co/guide/en/elasticsearch/reference/master/docs-update.html"
	 * @param fn
	 *            a function that initializes a freshly created builder. This
	 *            function can either return its builder argument after having set
	 *            its properties or return another builder.
	 */

	public final <TDocument, TPartialDocument> UpdateResponse<TDocument> update(
			Function<UpdateRequest.Builder<TDocument, TPartialDocument>, ObjectBuilder<UpdateRequest<TDocument, TPartialDocument>>> fn,
			Class<TDocument> tDocumentClass) throws IOException {
		return update(fn.apply(new UpdateRequest.Builder<TDocument, TPartialDocument>()).build(), tDocumentClass);
	}

	// ----- Endpoint: update_by_query

	/**
	 * Performs an update on every document in the index without changing the
	 * source, for example to pick up a mapping change.
	 *
	 * @see "https://www.elastic.co/guide/en/elasticsearch/reference/master/docs-update-by-query.html"
	 */

	public UpdateByQueryResponse updateByQuery(UpdateByQueryRequest request) throws IOException {
		return this.transport.performRequest(request, UpdateByQueryRequest.ENDPOINT, this.requestOptions);
	}

	/**
	 * Performs an update on every document in the index without changing the
	 * source, for example to pick up a mapping change.
	 *
	 * @see "https://www.elastic.co/guide/en/elasticsearch/reference/master/docs-update-by-query.html"
	 * @param fn
	 *            a function that initializes a freshly created builder. This
	 *            function can either return its builder argument after having set
	 *            its properties or return another builder.
	 */

	public final UpdateByQueryResponse updateByQuery(
			Function<UpdateByQueryRequest.Builder, ObjectBuilder<UpdateByQueryRequest>> fn) throws IOException {
		return updateByQuery(fn.apply(new UpdateByQueryRequest.Builder()).build());
	}

	// ----- Endpoint: update_by_query_rethrottle

	/**
	 * Changes the number of requests per second for a particular Update By Query
	 * operation.
	 *
	 * @see "https://www.elastic.co/guide/en/elasticsearch/reference/current/docs-update-by-query.html"
	 */

	public UpdateByQueryRethrottleResponse updateByQueryRethrottle(UpdateByQueryRethrottleRequest request)
			throws IOException {
		return this.transport.performRequest(request, UpdateByQueryRethrottleRequest.ENDPOINT, this.requestOptions);
	}

	/**
	 * Changes the number of requests per second for a particular Update By Query
	 * operation.
	 *
	 * @see "https://www.elastic.co/guide/en/elasticsearch/reference/current/docs-update-by-query.html"
	 * @param fn
	 *            a function that initializes a freshly created builder. This
	 *            function can either return its builder argument after having set
	 *            its properties or return another builder.
	 */

	public final UpdateByQueryRethrottleResponse updateByQueryRethrottle(
			Function<UpdateByQueryRethrottleRequest.Builder, ObjectBuilder<UpdateByQueryRethrottleRequest>> fn)
			throws IOException {
		return updateByQueryRethrottle(fn.apply(new UpdateByQueryRethrottleRequest.Builder()).build());
	}

	// ----- Misc

	/**
	 * Creates a new {@link #ElasticsearchClient} with specific request options.
	 */
	@Override
	public ElasticsearchClient withRequestOptions(@Nullable RequestOptions options) {
		return new ElasticsearchClient(transport, options);
	}

	/**
	 * Creates a new {@link #ElasticsearchClient} with specific request options,
	 * inheriting existing options.
	 *
	 * @param fn
	 *            a function taking an options builder initialized with the current
	 *            request options, or initialized with default values.
	 */
	public ElasticsearchClient withRequestOptions(Function<RequestOptions.Builder, RequestOptions.Builder> fn) {
		RequestOptions.Builder builder = requestOptions == null
				? RequestOptions.DEFAULT.toBuilder()
				: requestOptions.toBuilder();

		return withRequestOptions(fn.apply(builder).build());
	}
}
