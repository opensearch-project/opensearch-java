/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.transport.grpc.translation;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.opensearch._types.ShardStatistics;
import org.opensearch.client.opensearch.core.SearchResponse;
import org.opensearch.client.opensearch.core.search.Hit;
import org.opensearch.client.opensearch.core.search.HitsMetadata;
import org.opensearch.client.opensearch.core.search.TotalHits;
import org.opensearch.client.opensearch.core.search.TotalHitsRelation;

/**
 * Converts protobuf SearchResponse to opensearch-java SearchResponse format.
 * <p>
 * Currently supports match_all queries. Other query types (term, match, bool, etc.)
 * are not yet implemented in the client-side converter but can be executed over gRPC
 * once the request converter supports them — the response format is the same regardless
 * of query type.
 * <p>
 * Note: Unsupported query types will throw UnsupportedOperationException at the request
 * conversion stage. The response converter handles all response formats since the
 * SearchResponse structure is query-agnostic.
 */
public class SearchResponseConverter {

    /**
     * Convert a protobuf SearchResponse to an opensearch-java SearchResponse.
     *
     * @param protoResponse  the protobuf SearchResponse from the server
     * @param jsonpMapper    the JSON mapper for _source deserialization
     * @param tDocumentClass the target class for hit _source deserialization
     * @param <TDocument>    the document type
     * @return the opensearch-java SearchResponse
     */
    public static <TDocument> SearchResponse<TDocument> fromProto(
        org.opensearch.protobufs.SearchResponse protoResponse,
        JsonpMapper jsonpMapper,
        Class<TDocument> tDocumentClass
    ) {
        SearchResponse.Builder<TDocument> builder = new SearchResponse.Builder<TDocument>();

        // took
        builder.took(protoResponse.getTook());

        // timed_out
        builder.timedOut(protoResponse.getTimedOut());

        // _shards
        if (protoResponse.hasXShards()) {
            org.opensearch.protobufs.ShardStatistics protoShards = protoResponse.getXShards();
            builder.shards(
                new ShardStatistics.Builder().total(protoShards.getTotal())
                    .successful(protoShards.getSuccessful())
                    .failed(protoShards.getFailed())
                    .build()
            );
        } else {
            builder.shards(new ShardStatistics.Builder().total(0).successful(0).failed(0).build());
        }

        // hits
        if (protoResponse.hasHits()) {
            builder.hits(convertHitsMetadata(protoResponse.getHits(), jsonpMapper, tDocumentClass));
        } else {
            builder.hits(new HitsMetadata.Builder<TDocument>().hits(new ArrayList<>()).build());
        }

        return builder.build();
    }

    private static <TDocument> HitsMetadata<TDocument> convertHitsMetadata(
        org.opensearch.protobufs.HitsMetadata protoHits,
        JsonpMapper jsonpMapper,
        Class<TDocument> tDocumentClass
    ) {
        HitsMetadata.Builder<TDocument> builder = new HitsMetadata.Builder<TDocument>();

        // total hits
        if (protoHits.hasTotal()) {
            org.opensearch.protobufs.HitsMetadataTotal protoTotal = protoHits.getTotal();
            if (protoTotal.hasTotalHits()) {
                org.opensearch.protobufs.TotalHits totalHits = protoTotal.getTotalHits();
                TotalHitsRelation relation = totalHits.getRelation() == org.opensearch.protobufs.TotalHitsRelation.TOTAL_HITS_RELATION_EQ
                    ? TotalHitsRelation.Eq
                    : TotalHitsRelation.Gte;
                builder.total(new TotalHits.Builder().value(totalHits.getValue()).relation(relation).build());
            }
        }

        // max_score
        if (protoHits.hasMaxScore()) {
            org.opensearch.protobufs.HitsMetadataMaxScore maxScore = protoHits.getMaxScore();
            if (maxScore.hasFloat()) {
                builder.maxScore(maxScore.getFloat());
            }
        }

        // individual hits
        List<Hit<TDocument>> hits = new ArrayList<>();
        for (org.opensearch.protobufs.HitsMetadataHitsInner protoHit : protoHits.getHitsList()) {
            hits.add(convertHit(protoHit, jsonpMapper, tDocumentClass));
        }
        builder.hits(hits);

        return builder.build();
    }

    private static <TDocument> Hit<TDocument> convertHit(
        org.opensearch.protobufs.HitsMetadataHitsInner protoHit,
        JsonpMapper jsonpMapper,
        Class<TDocument> tDocumentClass
    ) {
        Hit.Builder<TDocument> builder = new Hit.Builder<TDocument>();

        // _index
        builder.index(protoHit.getXIndex());

        // _id
        builder.id(protoHit.getXId());

        // _score
        if (protoHit.hasXScore()) {
            org.opensearch.protobufs.HitXScore score = protoHit.getXScore();
            if (score.hasDouble()) {
                builder.score(score.getDouble());
            }
        }

        // _version
        if (protoHit.hasXVersion()) {
            builder.version(protoHit.getXVersion());
        }

        // _seq_no
        if (protoHit.hasXSeqNo()) {
            builder.seqNo(protoHit.getXSeqNo());
        }

        // _primary_term
        if (protoHit.hasXPrimaryTerm()) {
            builder.primaryTerm(protoHit.getXPrimaryTerm());
        }

        // _source — decode bytes and deserialize to TDocument
        if (!protoHit.getXSource().isEmpty()) {
            TDocument source = deserializeSource(protoHit.getXSource().toByteArray(), jsonpMapper, tDocumentClass);
            builder.source(source);
        }

        return builder.build();
    }

    /**
     * Decode _source bytes from protobuf hit to a Java object.
     * The server returns _source as UTF-8 JSON bytes.
     */
    static <TDocument> TDocument deserializeSource(byte[] sourceBytes, JsonpMapper jsonpMapper, Class<TDocument> tDocumentClass) {
        InputStream stream = new ByteArrayInputStream(sourceBytes);
        jakarta.json.stream.JsonParser parser = jsonpMapper.jsonProvider().createParser(stream);
        parser.next(); // advance to first token
        return jsonpMapper.deserialize(parser, tDocumentClass);
    }
}
