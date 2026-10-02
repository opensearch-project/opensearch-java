/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.transport.grpc;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import com.google.protobuf.ByteString;
import io.grpc.ManagedChannel;
import io.grpc.Server;
import io.grpc.inprocess.InProcessChannelBuilder;
import io.grpc.inprocess.InProcessServerBuilder;
import io.grpc.stub.StreamObserver;
import java.io.IOException;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.opensearch.client.json.jackson3.JacksonJsonpMapper;
import org.opensearch.client.opensearch.OpenSearchClient;
import org.opensearch.client.opensearch.core.SearchResponse;
import org.opensearch.client.opensearch.core.search.Hit;
import org.opensearch.protobufs.services.SearchServiceGrpc;

/**
 * Verifies that a strongly-typed search issued through {@link OpenSearchClient#search} over the
 * gRPC transport deserializes hit {@code _source} values into the caller-supplied document type
 * (rather than a generic {@code Object}/{@code JsonData}), i.e. that the {@code Class<TDocument>}
 * contract is honored end-to-end. Reproduces issue #2123.
 */
public class GrpcTypedSearchTest {

    /** Concrete document type the caller expects hits to be deserialized into. */
    public static class Movie {
        public String title;
        public int year;
        public String director;

        public Movie() {}
    }

    private Server server;
    private ManagedChannel channel;

    @Before
    public void setUp() throws IOException {
        String serverName = InProcessServerBuilder.generateName();

        // Fake SearchService that returns a single hit whose _source is a Movie JSON document.
        SearchServiceGrpc.SearchServiceImplBase fakeService = new SearchServiceGrpc.SearchServiceImplBase() {
            @Override
            public void search(
                org.opensearch.protobufs.SearchRequest request,
                StreamObserver<org.opensearch.protobufs.SearchResponse> responseObserver
            ) {
                ByteString source = ByteString.copyFromUtf8("{\"title\":\"The Matrix\",\"year\":1999,\"director\":\"The Wachowskis\"}");

                org.opensearch.protobufs.HitsMetadataHitsInner hit = org.opensearch.protobufs.HitsMetadataHitsInner.newBuilder()
                    .setXIndex("movies")
                    .setXId("1")
                    .setXSource(source)
                    .build();

                org.opensearch.protobufs.TotalHits totalHits = org.opensearch.protobufs.TotalHits.newBuilder()
                    .setValue(1)
                    .setRelation(org.opensearch.protobufs.TotalHitsRelation.TOTAL_HITS_RELATION_EQ)
                    .build();

                org.opensearch.protobufs.HitsMetadata hits = org.opensearch.protobufs.HitsMetadata.newBuilder()
                    .setTotal(org.opensearch.protobufs.HitsMetadataTotal.newBuilder().setTotalHits(totalHits))
                    .addHits(hit)
                    .build();

                org.opensearch.protobufs.SearchResponse response = org.opensearch.protobufs.SearchResponse.newBuilder()
                    .setTook(1)
                    .setTimedOut(false)
                    .setXShards(org.opensearch.protobufs.ShardStatistics.newBuilder().setTotal(1).setSuccessful(1).setFailed(0))
                    .setHits(hits)
                    .build();

                responseObserver.onNext(response);
                responseObserver.onCompleted();
            }
        };

        server = InProcessServerBuilder.forName(serverName).directExecutor().addService(fakeService).build().start();
        channel = InProcessChannelBuilder.forName(serverName).directExecutor().build();
    }

    @After
    public void tearDown() throws Exception {
        if (channel != null) {
            channel.shutdownNow();
        }
        if (server != null) {
            server.shutdownNow();
        }
    }

    @Test
    public void typedSearchDeserializesHitSourceToDocumentClass() throws IOException {
        GrpcTransport transport = GrpcTransport.builder("inprocess", 0).jsonpMapper(new JacksonJsonpMapper()).channel(channel).build();

        OpenSearchClient client = new OpenSearchClient(transport);

        SearchResponse<Movie> response = client.search(s -> s.index("movies").query(q -> q.matchAll(m -> m)), Movie.class);

        assertNotNull(response);
        assertNotNull(response.hits());
        List<Hit<Movie>> hits = response.hits().hits();
        assertEquals(1, hits.size());

        // The bug: hit.source() is actually a JsonData/Map, so this access throws ClassCastException.
        Movie movie = hits.get(0).source();
        assertNotNull("Hit source should be deserialized into the Movie document type", movie);
        assertEquals("The Matrix", movie.title);
        assertEquals(1999, movie.year);
        assertEquals("The Wachowskis", movie.director);
        assertTrue(hits.get(0).source() instanceof Movie);
    }
}
