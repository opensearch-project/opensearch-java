/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.opensearch.integTest;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.junit.Test;
import org.opensearch.Version;
import org.opensearch.client.opensearch._types.Bytes;
import org.opensearch.client.opensearch._types.Refresh;
import org.opensearch.client.opensearch._types.Result;
import org.opensearch.client.opensearch._types.Time;
import org.opensearch.client.opensearch.cat.AliasesResponse;
import org.opensearch.client.opensearch.cat.AllocationResponse;
import org.opensearch.client.opensearch.cat.IndicesResponse;
import org.opensearch.client.opensearch.cat.NodesResponse;
import org.opensearch.client.opensearch.cat.PluginsResponse;
import org.opensearch.client.opensearch.cat.RecoveryResponse;
import org.opensearch.client.opensearch.cat.SegmentsResponse;
import org.opensearch.client.opensearch.cat.ShardsResponse;
import org.opensearch.client.opensearch.cat.aliases.AliasesRecord;
import org.opensearch.client.opensearch.cat.allocation.AllocationRecord;
import org.opensearch.client.opensearch.cat.indices.IndicesRecord;
import org.opensearch.client.opensearch.cat.nodes.NodesRecord;
import org.opensearch.client.opensearch.cat.recovery.RecoveryRecord;
import org.opensearch.client.opensearch.cat.segments.SegmentsRecord;
import org.opensearch.client.opensearch.cat.shards.ShardsRecord;
import org.opensearch.client.opensearch.core.IndexResponse;
import org.opensearch.client.opensearch.core.InfoResponse;
import org.opensearch.client.opensearch.core.point_in_time.CreatePointInTimeResponse;
import org.opensearch.client.opensearch.indices.CreateIndexResponse;

public abstract class AbstractCatClientIT extends OpenSearchJavaClientTestCase {

    public void testCatNodes() throws Exception {
        NodesResponse nodesResponse = javaClient().cat().nodes(r -> r.bytes(Bytes.Bytes).fullId(true)
                .headers("id,ip,name,version,pid,heap.percent,ram.percent,cpu,load_1m,load_5m,load_15m,node.role"));

        assertNotNull(nodesResponse.valueBody());
        assertTrue(nodesResponse.valueBody().size() > 0);

        NodesRecord nodesRecord = nodesResponse.valueBody().get(0);

        assertNotNull(nodesRecord.id());
        assertNotNull(nodesRecord.ip());
        assertNotNull(nodesRecord.name());
        assertNotNull(nodesRecord.version());
        assertNotNull(nodesRecord.pid());
        assertNotNull(nodesRecord.heapPercent());
        assertNotNull(nodesRecord.ramPercent());
        assertNotNull(nodesRecord.cpu());
        assertNotNull(nodesRecord.load1m());
        assertNotNull(nodesRecord.load5m());
        assertNotNull(nodesRecord.load15m());
        assertNotNull(nodesRecord.nodeRole());
    }

    public void testCatIndices() throws Exception {
        createIndex("my-index-for-cat-test");

        IndicesResponse indicesResponse = javaClient().cat().indices(r -> r.headers("index,health,status,uuid,pri,rep,docs.count," +
                "docs.deleted,store.size,pri.store.size,creation.date,creation.date.string").bytes(Bytes.Bytes));

        assertNotNull(indicesResponse.valueBody());
        assertTrue(indicesResponse.valueBody().size() > 0);

        IndicesRecord indicesRecord = indicesResponse.valueBody().get(0);

        assertNotNull(indicesRecord.index());
        assertNotNull(indicesRecord.health());
        assertNotNull(indicesRecord.status());
        assertNotNull(indicesRecord.uuid());
        assertNotNull(indicesRecord.pri());
        assertNotNull(indicesRecord.rep());
        assertNotNull(indicesRecord.docsCount());
        assertNotNull(indicesRecord.docsDeleted());
        assertNotNull(indicesRecord.storeSize());
        assertNotNull(indicesRecord.priStoreSize());
        assertNotNull(indicesRecord.creationDate());
        assertNotNull(indicesRecord.creationDateString());
    }

    public void testCatRecovery() throws Exception {
        createIndex("test-cat-recovery-index");
        RecoveryResponse recoveryResponse = javaClient().cat().recovery(r -> r.headers("index,shard,type,stage,source_host,source_node," +
                "target_host,target_node,repository,snapshot,files,files_recovered,files_percent,files_total").bytes(Bytes.Bytes));

        assertNotNull("recoveryResponse.valueBody() is null", recoveryResponse.valueBody());
        assertTrue("recoveryResponse.valueBody().size() == 0", recoveryResponse.valueBody().size() > 0);

        RecoveryRecord recoveryRecord = recoveryResponse.valueBody().get(0);

        assertNotNull(recoveryRecord.index());
        assertNotNull(recoveryRecord.shard());
        assertNotNull(recoveryRecord.type());
        assertNotNull(recoveryRecord.stage());
        assertNotNull(recoveryRecord.sourceHost());
        assertNotNull(recoveryRecord.sourceNode());
        assertNotNull(recoveryRecord.targetHost());
        assertNotNull(recoveryRecord.targetNode());
        assertNotNull(recoveryRecord.repository());
        assertNotNull(recoveryRecord.snapshot());
        assertNotNull(recoveryRecord.files());
        assertNotNull(recoveryRecord.filesRecovered());
        assertNotNull(recoveryRecord.filesPercent());
        assertNotNull(recoveryRecord.filesTotal());
    }

    public void testCatAliases() throws Exception {
        String indexName = "test-aliases-index";
        String alias = "new-alias";
        createIndex(indexName);
        assertTrue(javaClient().indices().putAlias(r -> r.index(indexName).name(alias).isWriteIndex(true)).acknowledged());

        AliasesResponse aliasesResponse = javaClient().cat().aliases(r ->
                r.headers("alias,index,is_write_index,routing.index,routing.search").sort("is_write_index"));

        assertNotNull(aliasesResponse.valueBody());
        assertTrue(aliasesResponse.valueBody().size() > 0);

        AliasesRecord aliasRecord = aliasesResponse.valueBody().stream().filter(aliasesRecord -> aliasesRecord.alias().equals(alias))
                .findAny().get();

        assertTrue(aliasRecord.index().equals(indexName));
        assertTrue(aliasRecord.isWriteIndex().equals(Boolean.TRUE.toString()));
        assertNotNull(aliasRecord.routingIndex());
        assertNotNull(aliasRecord.routingSearch());
        assertNull(aliasRecord.filter());
    }

    public void testCatShards() throws Exception {
        createIndex("test-cat-shards-index-1");
        createIndex("test-cat-shards-index-3");
        createIndex("test-cat-shards-index-2");
        createIndex("a-test-cat-shards-index");

        ShardsResponse shardsResponse = javaClient().cat().shards(r -> r.headers("index,shard,prirep,state,store").sort("index")
                .bytes(Bytes.Bytes));
        assertNotNull(shardsResponse.valueBody());
        assertTrue(shardsResponse.valueBody().size() > 0);

        ShardsRecord shardsRecord = shardsResponse.valueBody().get(0);

        assertNotNull(shardsRecord.index());
        assertNotNull(shardsRecord.shard());
        assertNotNull(shardsRecord.prirep());
        assertNotNull(shardsRecord.state());
        assertNotNull(shardsRecord.store());
        assertNull(shardsRecord.node());
        assertNull(shardsRecord.ip());

        List<String> indices = shardsResponse.valueBody().stream().map(shardRecord -> shardRecord.index()).collect(Collectors.toList());
        assertTrue(indices.equals(indices.stream().sorted().collect(Collectors.toList())));
    }

    public void testCatAllocation() throws Exception {
        createIndex("test-cat-allocations-index");

        AllocationResponse allocationResponse = javaClient().cat().allocation(r ->
                r.headers("ip,node,shards,disk.indices,disk.used,disk.avail,disk.total,disk.percent").sort("ip"));
        assertNotNull(allocationResponse.valueBody());
        assertTrue(allocationResponse.valueBody().size() > 0);

        AllocationRecord allocationRecord = allocationResponse.valueBody().stream().filter(allocation ->
                !allocation.node().equals("UNASSIGNED")).findAny().get();
        assertNotNull(allocationRecord.ip());
        assertNotNull(allocationRecord.node());
        assertNotNull(allocationRecord.shards());
        assertNotNull(allocationRecord.diskIndices());
        assertNotNull(allocationRecord.diskUsed());
        assertNotNull(allocationRecord.diskAvail());
        assertNotNull(allocationRecord.diskTotal());
        assertNotNull(allocationRecord.diskPercent());
        assertNull(allocationRecord.host());
    }

    public void testCatPlugins() throws Exception {
        assumeTrue("There are no plugins installed when HTTP is used", isHttps());
        PluginsResponse pluginsResponse = javaClient().cat().plugins();
        assertNotNull(pluginsResponse.valueBody());
        assertTrue(pluginsResponse.valueBody().size() > 0);
    }

    public void testCatSegments() throws Exception {
        createIndex("cat-segments-test-index");

        final IndexResponse index = javaClient().index(b -> b
                .index("test-cat-segments-index")
                .id("id")
                .refresh(Refresh.True)
                .document(Map.of("test-cat-segments-key", "test-cat-segments-value")));

        assertTrue(index.result() == Result.Created);

        SegmentsResponse segmentsResponse = javaClient().cat().segments(r -> r.headers("index,shard,id,segment,size"));
        assertNotNull("segmentsResponse.valueBody() is null", segmentsResponse.valueBody());
        assertTrue("segmentsResponse.valueBody().size() == 0", segmentsResponse.valueBody().size() > 0);

        SegmentsRecord segmentsRecord = segmentsResponse.valueBody().get(0);

        assertNotNull(segmentsRecord.id());
        assertNotNull(segmentsRecord.index());
        assertNotNull(segmentsRecord.shard());
        assertNotNull(segmentsRecord.segment());
        assertNotNull(segmentsRecord.size());
        assertNull(segmentsRecord.ip());
        assertNull(segmentsRecord.prirep());
    }
    
    @Test
    public void testCatPointInTimeSegments() throws Exception {
        InfoResponse info = javaClient().info();
        String version = info.version().number();
        if (version.contains("SNAPSHOT")) {
                version = version.split("-")[0];
        }
        if (Version.fromString(version).onOrAfter(Version.fromString("2.4.0"))) {
            createIndex("cat-pit-segments-test-index");

            final IndexResponse index = javaClient().index(b -> b
                    .index("test-cat-pit-segments-index")
                    .id("id")
                    .refresh(Refresh.True)
                    .document(Map.of("test-cat-pit-segments-key", "test-cat-pit-segments-value")));

            assertTrue(index.result() == Result.Created);

            createPIT("cat-pit-segments-test-index");

            SegmentsResponse pointInTimeSegmentsResponse = javaClient().cat()
                    .pointInTimeSegments(r -> r.headers("index,shard,id,segment,size"));

            assertNotNull("pointInTimeSegmentsResponse.segments() is null", pointInTimeSegmentsResponse.valueBody());
            assertTrue("pointInTimeSegmentsResponse.segments().size() == 0",
                    pointInTimeSegmentsResponse.valueBody().size() > 0);
        }
    }

    private void createIndex(String indexName) throws Exception {
        CreateIndexResponse createResponse = javaClient().indices().create(b -> b.index(indexName));
        assertTrue(createResponse.acknowledged());
        assertTrue(createResponse.shardsAcknowledged());
    }

    private void createPIT(String indexName) throws Exception {
        CreatePointInTimeResponse createPointInTimeResponse = javaClient()
                .createPointInTime(r -> r.targetIndexes(Collections.singletonList(indexName))
                        .keepAlive(new Time.Builder().time("100m").build()));
        assertNotNull(createPointInTimeResponse);
        assertNotNull(createPointInTimeResponse.pitId());
    }

}
