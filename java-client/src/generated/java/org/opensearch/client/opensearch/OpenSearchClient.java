package org.opensearch.client.opensearch;

import org.opensearch.client.ApiClient;
import org.opensearch.client.opensearch._types.OpenSearchException;
import org.opensearch.client.opensearch._types.ErrorResponse;
import org.opensearch.client.transport.OpenSearchTransport;
import org.opensearch.client.transport.JsonEndpoint;
import org.opensearch.client.transport.TransportOptions;
import org.opensearch.client.util.ObjectBuilder;
import java.io.IOException;
import java.util.function.Function;
import javax.annotation.Nullable;

public class OpenSearchClient extends ApiClient<OpenSearchTransport, OpenSearchClient> {
    public OpenSearchClient(OpenSearchTransport transport) {
        super(transport, null);
    }

    public OpenSearchClient(
            OpenSearchTransport transport, @Nullable TransportOptions transportOptions) {
        super(transport, transportOptions);
    }

    @Override
    public OpenSearchClient withTransportOptions(@Nullable TransportOptions transportOptions) {
        return new OpenSearchClient(this.transport, transportOptions);
    }

    public DeleteIndexResponse deleteIndex(DeleteIndexRequest request)
            throws IOException, OpenSearchException {
        JsonEndpoint<DeleteIndexRequest, DeleteIndexResponse, ErrorResponse> endpoint =
                (JsonEndpoint<DeleteIndexRequest, DeleteIndexResponse, ErrorResponse>)
                        DeleteIndexRequest._ENDPOINT;

        return this.transport.performRequest(request, endpoint, this.transportOptions);
    }

    public final DeleteIndexResponse deleteIndex(
            Function<DeleteIndexRequest.Builder, ObjectBuilder<DeleteIndexRequest>> fn)
            throws IOException, OpenSearchException {
        return deleteIndex(fn.apply(new DeleteIndexRequest.Builder()).build());
    }

    public GetCatIndicesResponse getCatIndices(GetCatIndicesRequest request)
            throws IOException, OpenSearchException {
        JsonEndpoint<GetCatIndicesRequest, GetCatIndicesResponse, ErrorResponse> endpoint =
                (JsonEndpoint<GetCatIndicesRequest, GetCatIndicesResponse, ErrorResponse>)
                        GetCatIndicesRequest._ENDPOINT;

        return this.transport.performRequest(request, endpoint, this.transportOptions);
    }

    public final GetCatIndicesResponse getCatIndices(
            Function<GetCatIndicesRequest.Builder, ObjectBuilder<GetCatIndicesRequest>> fn)
            throws IOException, OpenSearchException {
        return getCatIndices(fn.apply(new GetCatIndicesRequest.Builder()).build());
    }

    public GetCatIndicesWithIndexResponse getCatIndicesWithIndex(
            GetCatIndicesWithIndexRequest request) throws IOException, OpenSearchException {
        JsonEndpoint<GetCatIndicesWithIndexRequest, GetCatIndicesWithIndexResponse, ErrorResponse>
                endpoint =
                        (JsonEndpoint<
                                        GetCatIndicesWithIndexRequest,
                                        GetCatIndicesWithIndexResponse,
                                        ErrorResponse>)
                                GetCatIndicesWithIndexRequest._ENDPOINT;

        return this.transport.performRequest(request, endpoint, this.transportOptions);
    }

    public final GetCatIndicesWithIndexResponse getCatIndicesWithIndex(
            Function<
                            GetCatIndicesWithIndexRequest.Builder,
                            ObjectBuilder<GetCatIndicesWithIndexRequest>>
                    fn)
            throws IOException, OpenSearchException {
        return getCatIndicesWithIndex(
                fn.apply(new GetCatIndicesWithIndexRequest.Builder()).build());
    }

    public GetCatNodesResponse getCatNodes(GetCatNodesRequest request)
            throws IOException, OpenSearchException {
        JsonEndpoint<GetCatNodesRequest, GetCatNodesResponse, ErrorResponse> endpoint =
                (JsonEndpoint<GetCatNodesRequest, GetCatNodesResponse, ErrorResponse>)
                        GetCatNodesRequest._ENDPOINT;

        return this.transport.performRequest(request, endpoint, this.transportOptions);
    }

    public final GetCatNodesResponse getCatNodes(
            Function<GetCatNodesRequest.Builder, ObjectBuilder<GetCatNodesRequest>> fn)
            throws IOException, OpenSearchException {
        return getCatNodes(fn.apply(new GetCatNodesRequest.Builder()).build());
    }

    public GetClusterInfoResponse getClusterInfo(GetClusterInfoRequest request)
            throws IOException, OpenSearchException {
        JsonEndpoint<GetClusterInfoRequest, GetClusterInfoResponse, ErrorResponse> endpoint =
                (JsonEndpoint<GetClusterInfoRequest, GetClusterInfoResponse, ErrorResponse>)
                        GetClusterInfoRequest._ENDPOINT;

        return this.transport.performRequest(request, endpoint, this.transportOptions);
    }

    public final GetClusterInfoResponse getClusterInfo(
            Function<GetClusterInfoRequest.Builder, ObjectBuilder<GetClusterInfoRequest>> fn)
            throws IOException, OpenSearchException {
        return getClusterInfo(fn.apply(new GetClusterInfoRequest.Builder()).build());
    }

    public GetClusterSettingsResponse getClusterSettings(GetClusterSettingsRequest request)
            throws IOException, OpenSearchException {
        JsonEndpoint<GetClusterSettingsRequest, GetClusterSettingsResponse, ErrorResponse>
                endpoint =
                        (JsonEndpoint<
                                        GetClusterSettingsRequest,
                                        GetClusterSettingsResponse,
                                        ErrorResponse>)
                                GetClusterSettingsRequest._ENDPOINT;

        return this.transport.performRequest(request, endpoint, this.transportOptions);
    }

    public final GetClusterSettingsResponse getClusterSettings(
            Function<GetClusterSettingsRequest.Builder, ObjectBuilder<GetClusterSettingsRequest>>
                    fn)
            throws IOException, OpenSearchException {
        return getClusterSettings(fn.apply(new GetClusterSettingsRequest.Builder()).build());
    }

    public GetDocumentDocResponse getDocumentDoc(GetDocumentDocRequest request)
            throws IOException, OpenSearchException {
        JsonEndpoint<GetDocumentDocRequest, GetDocumentDocResponse, ErrorResponse> endpoint =
                (JsonEndpoint<GetDocumentDocRequest, GetDocumentDocResponse, ErrorResponse>)
                        GetDocumentDocRequest._ENDPOINT;

        return this.transport.performRequest(request, endpoint, this.transportOptions);
    }

    public final GetDocumentDocResponse getDocumentDoc(
            Function<GetDocumentDocRequest.Builder, ObjectBuilder<GetDocumentDocRequest>> fn)
            throws IOException, OpenSearchException {
        return getDocumentDoc(fn.apply(new GetDocumentDocRequest.Builder()).build());
    }

    public GetDocumentSourceResponse getDocumentSource(GetDocumentSourceRequest request)
            throws IOException, OpenSearchException {
        JsonEndpoint<GetDocumentSourceRequest, GetDocumentSourceResponse, ErrorResponse> endpoint =
                (JsonEndpoint<GetDocumentSourceRequest, GetDocumentSourceResponse, ErrorResponse>)
                        GetDocumentSourceRequest._ENDPOINT;

        return this.transport.performRequest(request, endpoint, this.transportOptions);
    }

    public final GetDocumentSourceResponse getDocumentSource(
            Function<GetDocumentSourceRequest.Builder, ObjectBuilder<GetDocumentSourceRequest>> fn)
            throws IOException, OpenSearchException {
        return getDocumentSource(fn.apply(new GetDocumentSourceRequest.Builder()).build());
    }

    public GetSettingsIndexResponse getSettingsIndex(GetSettingsIndexRequest request)
            throws IOException, OpenSearchException {
        JsonEndpoint<GetSettingsIndexRequest, GetSettingsIndexResponse, ErrorResponse> endpoint =
                (JsonEndpoint<GetSettingsIndexRequest, GetSettingsIndexResponse, ErrorResponse>)
                        GetSettingsIndexRequest._ENDPOINT;

        return this.transport.performRequest(request, endpoint, this.transportOptions);
    }

    public final GetSettingsIndexResponse getSettingsIndex(
            Function<GetSettingsIndexRequest.Builder, ObjectBuilder<GetSettingsIndexRequest>> fn)
            throws IOException, OpenSearchException {
        return getSettingsIndex(fn.apply(new GetSettingsIndexRequest.Builder()).build());
    }

    public GetSettingsIndexSettingResponse getSettingsIndexSetting(
            GetSettingsIndexSettingRequest request) throws IOException, OpenSearchException {
        JsonEndpoint<GetSettingsIndexSettingRequest, GetSettingsIndexSettingResponse, ErrorResponse>
                endpoint =
                        (JsonEndpoint<
                                        GetSettingsIndexSettingRequest,
                                        GetSettingsIndexSettingResponse,
                                        ErrorResponse>)
                                GetSettingsIndexSettingRequest._ENDPOINT;

        return this.transport.performRequest(request, endpoint, this.transportOptions);
    }

    public final GetSettingsIndexSettingResponse getSettingsIndexSetting(
            Function<
                            GetSettingsIndexSettingRequest.Builder,
                            ObjectBuilder<GetSettingsIndexSettingRequest>>
                    fn)
            throws IOException, OpenSearchException {
        return getSettingsIndexSetting(
                fn.apply(new GetSettingsIndexSettingRequest.Builder()).build());
    }

    public PostAliasesResponse postAliases(PostAliasesRequest request)
            throws IOException, OpenSearchException {
        JsonEndpoint<PostAliasesRequest, PostAliasesResponse, ErrorResponse> endpoint =
                (JsonEndpoint<PostAliasesRequest, PostAliasesResponse, ErrorResponse>)
                        PostAliasesRequest._ENDPOINT;

        return this.transport.performRequest(request, endpoint, this.transportOptions);
    }

    public final PostAliasesResponse postAliases(
            Function<PostAliasesRequest.Builder, ObjectBuilder<PostAliasesRequest>> fn)
            throws IOException, OpenSearchException {
        return postAliases(fn.apply(new PostAliasesRequest.Builder()).build());
    }

    public PostRemoteStoreRestoreResponse postRemoteStoreRestore(
            PostRemoteStoreRestoreRequest request) throws IOException, OpenSearchException {
        JsonEndpoint<PostRemoteStoreRestoreRequest, PostRemoteStoreRestoreResponse, ErrorResponse>
                endpoint =
                        (JsonEndpoint<
                                        PostRemoteStoreRestoreRequest,
                                        PostRemoteStoreRestoreResponse,
                                        ErrorResponse>)
                                PostRemoteStoreRestoreRequest._ENDPOINT;

        return this.transport.performRequest(request, endpoint, this.transportOptions);
    }

    public final PostRemoteStoreRestoreResponse postRemoteStoreRestore(
            Function<
                            PostRemoteStoreRestoreRequest.Builder,
                            ObjectBuilder<PostRemoteStoreRestoreRequest>>
                    fn)
            throws IOException, OpenSearchException {
        return postRemoteStoreRestore(
                fn.apply(new PostRemoteStoreRestoreRequest.Builder()).build());
    }

    public PostSearchResponse postSearch(PostSearchRequest request)
            throws IOException, OpenSearchException {
        JsonEndpoint<PostSearchRequest, PostSearchResponse, ErrorResponse> endpoint =
                (JsonEndpoint<PostSearchRequest, PostSearchResponse, ErrorResponse>)
                        PostSearchRequest._ENDPOINT;

        return this.transport.performRequest(request, endpoint, this.transportOptions);
    }

    public final PostSearchResponse postSearch(
            Function<PostSearchRequest.Builder, ObjectBuilder<PostSearchRequest>> fn)
            throws IOException, OpenSearchException {
        return postSearch(fn.apply(new PostSearchRequest.Builder()).build());
    }

    public PostSearchWithIndexResponse postSearchWithIndex(PostSearchWithIndexRequest request)
            throws IOException, OpenSearchException {
        JsonEndpoint<PostSearchWithIndexRequest, PostSearchWithIndexResponse, ErrorResponse>
                endpoint =
                        (JsonEndpoint<
                                        PostSearchWithIndexRequest,
                                        PostSearchWithIndexResponse,
                                        ErrorResponse>)
                                PostSearchWithIndexRequest._ENDPOINT;

        return this.transport.performRequest(request, endpoint, this.transportOptions);
    }

    public final PostSearchWithIndexResponse postSearchWithIndex(
            Function<PostSearchWithIndexRequest.Builder, ObjectBuilder<PostSearchWithIndexRequest>>
                    fn)
            throws IOException, OpenSearchException {
        return postSearchWithIndex(fn.apply(new PostSearchWithIndexRequest.Builder()).build());
    }

    public PutCreateIndexResponse putCreateIndex(PutCreateIndexRequest request)
            throws IOException, OpenSearchException {
        JsonEndpoint<PutCreateIndexRequest, PutCreateIndexResponse, ErrorResponse> endpoint =
                (JsonEndpoint<PutCreateIndexRequest, PutCreateIndexResponse, ErrorResponse>)
                        PutCreateIndexRequest._ENDPOINT;

        return this.transport.performRequest(request, endpoint, this.transportOptions);
    }

    public final PutCreateIndexResponse putCreateIndex(
            Function<PutCreateIndexRequest.Builder, ObjectBuilder<PutCreateIndexRequest>> fn)
            throws IOException, OpenSearchException {
        return putCreateIndex(fn.apply(new PutCreateIndexRequest.Builder()).build());
    }

    public PutIndexMappingWithIndexResponse putIndexMappingWithIndex(
            PutIndexMappingWithIndexRequest request) throws IOException, OpenSearchException {
        JsonEndpoint<
                        PutIndexMappingWithIndexRequest,
                        PutIndexMappingWithIndexResponse,
                        ErrorResponse>
                endpoint =
                        (JsonEndpoint<
                                        PutIndexMappingWithIndexRequest,
                                        PutIndexMappingWithIndexResponse,
                                        ErrorResponse>)
                                PutIndexMappingWithIndexRequest._ENDPOINT;

        return this.transport.performRequest(request, endpoint, this.transportOptions);
    }

    public final PutIndexMappingWithIndexResponse putIndexMappingWithIndex(
            Function<
                            PutIndexMappingWithIndexRequest.Builder,
                            ObjectBuilder<PutIndexMappingWithIndexRequest>>
                    fn)
            throws IOException, OpenSearchException {
        return putIndexMappingWithIndex(
                fn.apply(new PutIndexMappingWithIndexRequest.Builder()).build());
    }

    public PutUpdateClusterSettingsResponse putUpdateClusterSettings(
            PutUpdateClusterSettingsRequest request) throws IOException, OpenSearchException {
        JsonEndpoint<
                        PutUpdateClusterSettingsRequest,
                        PutUpdateClusterSettingsResponse,
                        ErrorResponse>
                endpoint =
                        (JsonEndpoint<
                                        PutUpdateClusterSettingsRequest,
                                        PutUpdateClusterSettingsResponse,
                                        ErrorResponse>)
                                PutUpdateClusterSettingsRequest._ENDPOINT;

        return this.transport.performRequest(request, endpoint, this.transportOptions);
    }

    public final PutUpdateClusterSettingsResponse putUpdateClusterSettings(
            Function<
                            PutUpdateClusterSettingsRequest.Builder,
                            ObjectBuilder<PutUpdateClusterSettingsRequest>>
                    fn)
            throws IOException, OpenSearchException {
        return putUpdateClusterSettings(
                fn.apply(new PutUpdateClusterSettingsRequest.Builder()).build());
    }
}
