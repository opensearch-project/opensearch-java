/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.transport.grpc.translation;

import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.opensearch._types.query_dsl.MatchAllQuery;
import org.opensearch.client.opensearch._types.query_dsl.Query;
import org.opensearch.client.opensearch.core.SearchRequest;

/**
 * Converts opensearch-java SearchRequest to protobuf SearchRequest.
 *
 * Currently supported query types:
 * - match_all — matches all documents
 *
 * Query types not yet implemented (these can be executed over gRPC once
 * the converter is extended — the server already supports them):
 * - term, terms, terms_set
 * - match, match_phrase, match_phrase_prefix, match_bool_prefix, multi_match
 * - bool, constant_score, function_score
 * - range, prefix, wildcard, regexp, fuzzy, exists, ids
 * - nested, geo_distance, geo_bounding_box
 * - knn, hybrid, script
 *
 * To add a new query type, implement a convertXxx() method and add a case
 * to convertQuery(Query).
 */
public class SearchRequestConverter {

    /**
     * Convert an opensearch-java SearchRequest to a protobuf SearchRequest.
     *
     * @param request     the client SearchRequest
     * @param jsonpMapper the JSON mapper (for future use with script queries)
     * @return the protobuf SearchRequest
     */
    public static org.opensearch.protobufs.SearchRequest toProto(SearchRequest request, JsonpMapper jsonpMapper) {
        org.opensearch.protobufs.SearchRequest.Builder protoBuilder = org.opensearch.protobufs.SearchRequest.newBuilder();

        // Set index(es)
        if (request.index() != null && !request.index().isEmpty()) {
            protoBuilder.addAllIndex(request.index());
        }

        // Build SearchRequestBody
        org.opensearch.protobufs.SearchRequestBody.Builder bodyBuilder = org.opensearch.protobufs.SearchRequestBody.newBuilder();

        // Set size
        if (request.size() != null) {
            bodyBuilder.setSize(request.size());
        }

        // Set from (pagination offset)
        if (request.from() != null) {
            bodyBuilder.setFrom(request.from());
        }

        // Convert query
        if (request.query() != null) {
            bodyBuilder.setQuery(convertQuery(request.query()));
        }

        protoBuilder.setSearchRequestBody(bodyBuilder.build());
        return protoBuilder.build();
    }

    /**
     * Convert an opensearch-java Query to a protobuf QueryContainer.
     *
     * @throws UnsupportedOperationException if the query type is not yet supported
     */
    private static org.opensearch.protobufs.QueryContainer convertQuery(Query query) {
        org.opensearch.protobufs.QueryContainer.Builder containerBuilder = org.opensearch.protobufs.QueryContainer.newBuilder();

        if (query.isMatchAll()) {
            containerBuilder.setMatchAll(convertMatchAll(query.matchAll()));
        } else {
            throw new UnsupportedOperationException(
                "Query type '"
                    + query._kind()
                    + "' is not yet supported for gRPC transport in this version. "
                    + "Use REST transport for this query type."
            );
        }

        return containerBuilder.build();
    }

    /**
     * Convert MatchAllQuery to protobuf.
     * MatchAllQuery has only optional boost and _name fields.
     */
    private static org.opensearch.protobufs.MatchAllQuery convertMatchAll(MatchAllQuery matchAll) {
        org.opensearch.protobufs.MatchAllQuery.Builder builder = org.opensearch.protobufs.MatchAllQuery.newBuilder();

        if (matchAll.boost() != null) {
            builder.setBoost(matchAll.boost().floatValue());
        }

        return builder.build();
    }
}
