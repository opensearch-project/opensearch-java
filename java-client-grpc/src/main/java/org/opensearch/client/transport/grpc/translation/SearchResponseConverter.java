/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.transport.grpc.translation;

import jakarta.json.stream.JsonGenerator;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.StringReader;
import java.io.StringWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.opensearch.client.json.JsonData;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.NamedDeserializer;
import org.opensearch.client.opensearch._types.ClusterStatistics;
import org.opensearch.client.opensearch._types.ShardSearchFailure;
import org.opensearch.client.opensearch._types.ShardStatistics;
import org.opensearch.client.opensearch.core.SearchResponse;
import org.opensearch.client.opensearch.core.search.Hit;
import org.opensearch.client.opensearch.core.search.HitsMetadata;
import org.opensearch.client.opensearch.core.search.MatchedQueries;
import org.opensearch.client.opensearch.core.search.TotalHits;
import org.opensearch.client.opensearch.core.search.TotalHitsRelation;
import org.opensearch.protobufs.ObjectMap;

/**
 * Converts protobuf SearchResponse to opensearch-java SearchResponse format.
 * <p>
 * The response format is the same regardless of query type. Hits carry their _source, the fields requested with
 * docvalue_fields, matched queries and metadata fields such as _routing and _ignored, which the server sends as JSON
 * values and which are read as the REST response would hold them.
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
        if (protoResponse.hasTerminatedEarly()) {
            builder.terminatedEarly(protoResponse.getTerminatedEarly());
        }

        // _shards
        if (protoResponse.hasXShards()) {
            builder.shards(convertShards(protoResponse.getXShards()));
        } else {
            builder.shards(new ShardStatistics.Builder().total(0).successful(0).failed(0).build());
        }

        // _clusters
        if (protoResponse.hasXClusters()) {
            org.opensearch.protobufs.ClusterStatistics protoClusters = protoResponse.getXClusters();
            builder.clusters(
                new ClusterStatistics.Builder().total(protoClusters.getTotal())
                    .successful(protoClusters.getSuccessful())
                    .skipped(protoClusters.getSkipped())
                    .build()
            );
        }

        // hits
        if (protoResponse.hasHits()) {
            builder.hits(convertHitsMetadata(protoResponse.getHits(), jsonpMapper, tDocumentClass));
        } else {
            builder.hits(new HitsMetadata.Builder<TDocument>().hits(new ArrayList<>()).build());
        }

        return builder.build();
    }

    private static ShardStatistics convertShards(org.opensearch.protobufs.ShardStatistics protoShards) {
        ShardStatistics.Builder builder = new ShardStatistics.Builder().total(protoShards.getTotal())
            .successful(protoShards.getSuccessful())
            .failed(protoShards.getFailed());
        if (protoShards.hasSkipped()) {
            builder.skipped(protoShards.getSkipped());
        }
        for (org.opensearch.protobufs.ShardFailure protoFailure : protoShards.getFailuresList()) {
            ShardSearchFailure.Builder failure = new ShardSearchFailure.Builder().shard(protoFailure.getShard())
                .reason(BulkResponseConverter.convertErrorCause(protoFailure.getReason()));
            if (protoFailure.hasIndex()) {
                failure.index(protoFailure.getIndex());
            }
            if (protoFailure.hasNode()) {
                failure.node(protoFailure.getNode());
            }
            builder.failures(failure.build());
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

    @SuppressWarnings("deprecation") // matched_queries, which servers without matched_queries_2 send
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

        // _routing and _ignored, and the other metadata fields
        if (protoHit.hasXRouting()) {
            builder.routing(protoHit.getXRouting());
        }
        if (protoHit.getXIgnoredCount() > 0) {
            builder.ignored(new ArrayList<>(protoHit.getXIgnoredList()));
        }
        if (protoHit.hasMetaFields()) {
            convertMetaFields(protoHit.getMetaFields(), builder, jsonpMapper, protoHit.getXIgnoredCount() > 0);
        }

        // fields, e.g. those of docvalue_fields
        if (protoHit.hasFields()) {
            builder.fields(readJson(protoHit.getFields(), JsonpDeserializer.stringMapDeserializer(JsonData._DESERIALIZER), jsonpMapper));
        }

        // matched_queries
        if (protoHit.hasMatchedQueries2()) {
            org.opensearch.protobufs.HitMatchedQueries matched = protoHit.getMatchedQueries2();
            if (matched.hasScores()) {
                builder.matchedQueries(MatchedQueries.ofScores(new LinkedHashMap<>(matched.getScores().getDoubleMapMap())));
            } else {
                builder.matchedQueries(MatchedQueries.ofNames(new ArrayList<>(matched.getNames().getStringArrayList())));
            }
        } else if (protoHit.getMatchedQueriesCount() > 0) {
            builder.matchedQueries(MatchedQueries.ofNames(new ArrayList<>(protoHit.getMatchedQueriesList())));
        }

        // _source — decode bytes and deserialize to TDocument
        if (!protoHit.getXSource().isEmpty()) {
            TDocument source = deserializeSource(protoHit.getXSource().toByteArray(), jsonpMapper, tDocumentClass);
            builder.source(source);
        }

        return builder.build();
    }

    /**
     * Sets the metadata fields of a hit as a REST hit has them. The server sends every value of each field; a REST hit holds
     * all of them for _ignored and the first for the other fields. _ignored is read from here only if x_ignored did not set
     * it.
     */
    private static <TDocument> void convertMetaFields(
        ObjectMap metaFields,
        Hit.Builder<TDocument> builder,
        JsonpMapper jsonpMapper,
        boolean ignoredSet
    ) {
        for (Map.Entry<String, ObjectMap.Value> field : metaFields.getFieldsMap().entrySet()) {
            ObjectMap.Value values = field.getValue();
            if (IGNORED.equals(field.getKey())) {
                if (ignoredSet) {
                    continue;
                }
                builder.ignored(readJson(values, JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()), jsonpMapper));
                continue;
            }
            ObjectMap.Value value = values;
            if (values.hasListValue()) {
                if (values.getListValue().getValueCount() == 0) {
                    continue;
                }
                value = values.getListValue().getValue(0);
            }
            if (ROUTING.equals(field.getKey())) {
                builder.routing(readJson(value, JsonpDeserializer.stringDeserializer(), jsonpMapper));
            } else {
                builder.metaFields(field.getKey(), readJson(value, JsonData._DESERIALIZER, jsonpMapper));
            }
        }
    }

    /**
     * Decode _source bytes from protobuf hit to a Java object.
     * The server returns _source as UTF-8 JSON bytes.
     */
    static <TDocument> TDocument deserializeSource(byte[] sourceBytes, JsonpMapper jsonpMapper, Class<TDocument> tDocumentClass) {
        InputStream stream = new ByteArrayInputStream(sourceBytes);
        jakarta.json.stream.JsonParser parser = jsonpMapper.jsonProvider().createParser(stream);
        // Not advanced: deserializers read the value from the parser's next event, as for the _source of a REST hit
        if (jsonpMapper.attribute(DOCUMENT_DESERIALIZER) != null) {
            // The document type the caller asked for, as client.search(request, Class) sets it for the REST response
            return new NamedDeserializer<TDocument>(DOCUMENT_DESERIALIZER).deserialize(parser, jsonpMapper);
        }
        return jsonpMapper.deserialize(parser, tDocumentClass);
    }

    /** Reads a value the server sends as an ObjectMap with the deserializer of its REST representation. */
    private static <T> T readJson(ObjectMap map, JsonpDeserializer<T> deserializer, JsonpMapper jsonpMapper) {
        return readJson(ObjectMap.Value.newBuilder().setObjectMap(map).build(), deserializer, jsonpMapper);
    }

    /** Reads a value the server sends as an ObjectMap value with the deserializer of its REST representation. */
    private static <T> T readJson(ObjectMap.Value value, JsonpDeserializer<T> deserializer, JsonpMapper jsonpMapper) {
        StringWriter json = new StringWriter();
        try (JsonGenerator generator = jsonpMapper.jsonProvider().createGenerator(json)) {
            writeJson(value, generator);
        }
        jakarta.json.stream.JsonParser parser = jsonpMapper.jsonProvider().createParser(new StringReader(json.toString()));
        return deserializer.deserialize(parser, jsonpMapper);
    }

    /** Writes a value as the server writes it in a REST response. */
    private static void writeJson(ObjectMap.Value value, JsonGenerator generator) {
        switch (value.getValueCase()) {
            case INT32:
                generator.write(value.getInt32());
                break;
            case INT64:
                generator.write(value.getInt64());
                break;
            case FLOAT:
                // The shortest decimal of the float, as JSON has it, rather than that of its double
                float f = value.getFloat();
                if (Float.isFinite(f)) {
                    generator.write(new BigDecimal(Float.toString(f)));
                } else {
                    generator.write(Float.toString(f));
                }
                break;
            case DOUBLE:
                double d = value.getDouble();
                if (Double.isFinite(d)) {
                    generator.write(d);
                } else {
                    generator.write(Double.toString(d));
                }
                break;
            case STRING:
                generator.write(value.getString());
                break;
            case BOOL:
                generator.write(value.getBool());
                break;
            case OBJECT_MAP:
                generator.writeStartObject();
                for (Map.Entry<String, ObjectMap.Value> entry : value.getObjectMap().getFieldsMap().entrySet()) {
                    generator.writeKey(entry.getKey());
                    writeJson(entry.getValue(), generator);
                }
                generator.writeEnd();
                break;
            case LIST_VALUE:
                generator.writeStartArray();
                for (ObjectMap.Value element : value.getListValue().getValueList()) {
                    writeJson(element, generator);
                }
                generator.writeEnd();
                break;
            default:
                generator.writeNull();
                break;
        }
    }

    /** The mapper attribute holding the deserializer of hit documents, set by {@code OpenSearchClient.search}. */
    static final String DOCUMENT_DESERIALIZER = "org.opensearch.client:Deserializer:_global.search.TDocument";

    private static final String ROUTING = "_routing";
    private static final String IGNORED = "_ignored";
}
