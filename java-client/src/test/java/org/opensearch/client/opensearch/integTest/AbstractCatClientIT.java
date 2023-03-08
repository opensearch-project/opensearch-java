package org.opensearch.client.opensearch.integTest;

import org.opensearch.client.opensearch._types.Bytes;
import org.opensearch.client.opensearch.cat.IndicesResponse;
import org.opensearch.client.opensearch.cat.NodesResponse;
import org.opensearch.client.opensearch.cat.RecoveryResponse;
import org.opensearch.client.opensearch.cat.indices.IndicesRecord;
import org.opensearch.client.opensearch.cat.nodes.NodesRecord;
import org.opensearch.client.opensearch.cat.recovery.RecoveryRecord;
import org.opensearch.client.opensearch.indices.CreateIndexResponse;

public abstract class AbstractCatClientIT extends OpenSearchJavaClientTestCase {

    public void testCatNodes() throws Exception {
        NodesResponse nodesResponse = javaClient().cat().nodes(r -> r.bytes(Bytes.Bytes).fullId(true).columnNames("id,ip,name,version,pid,heap.percent,ram.percent,cpu,load_1m,load_5m,load_15m,node.role"));
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
        CreateIndexResponse createResponse = javaClient().indices().create(b -> b.index("my-index-for-cat-test"));
        assertTrue(createResponse.acknowledged());
        assertTrue(createResponse.shardsAcknowledged());

        IndicesResponse indicesResponse = javaClient().cat().indices(r -> r.columnNames("index,health,status,uuid,pri,rep,docs.count,docs.deleted,store.size,pri.store.size,creation.date,creation.date.string").bytes(Bytes.Bytes));
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
        RecoveryResponse recoveryResponse = javaClient().cat().recovery(r -> r.columnNames("index,shard,type,stage,source_host,source_node,target_host,target_node,repository,snapshot,files,files_recovered,files_percent,files_total").bytes(Bytes.Bytes));
        assertNotNull(recoveryResponse.valueBody());
        assertTrue(recoveryResponse.valueBody().size() > 0);
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

}
