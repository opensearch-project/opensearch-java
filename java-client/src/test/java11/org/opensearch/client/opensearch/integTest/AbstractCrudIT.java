/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.opensearch.integTest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormat;
import org.opensearch.client.json.JsonData;
import org.opensearch.client.opensearch._types.BuiltinScriptLanguage;
import org.opensearch.client.opensearch._types.InlineScript;
import org.opensearch.client.opensearch._types.OpenSearchException;
import org.opensearch.client.opensearch._types.Refresh;
import org.opensearch.client.opensearch._types.Result;
import org.opensearch.client.opensearch._types.Script;
import org.opensearch.client.opensearch.core.BulkRequest;
import org.opensearch.client.opensearch.core.BulkResponse;
import org.opensearch.client.opensearch.core.DeleteResponse;
import org.opensearch.client.opensearch.core.ExistsSourceRequest;
import org.opensearch.client.opensearch.core.GetRequest;
import org.opensearch.client.opensearch.core.GetResponse;
import org.opensearch.client.opensearch.core.IndexRequest;
import org.opensearch.client.opensearch.core.IndexResponse;
import org.opensearch.client.opensearch.core.MgetResponse;
import org.opensearch.client.opensearch.core.UpdateRequest;
import org.opensearch.client.opensearch.core.UpdateResponse;
import org.opensearch.client.opensearch.core.bulk.BulkOperation;
import org.opensearch.client.opensearch.core.bulk.BulkResponseItem;
import org.opensearch.client.opensearch.indices.CreateIndexResponse;
import org.opensearch.client.opensearch.indices.DeleteIndexResponse;
import org.opensearch.client.transport.endpoints.BooleanResponse;

public abstract class AbstractCrudIT extends OpenSearchJavaClientTestCase {

    public void testDelete() throws IOException {
        {
            // Testing index deletion
            String index1 = "my-index";
            CreateIndexResponse createIndexResponse = javaClient().indices().create(b -> b.index(index1));
            assertEquals(index1, createIndexResponse.index());
            assertTrue(createIndexResponse.acknowledged());
            assertTrue(createIndexResponse.shardsAcknowledged());
            DeleteIndexResponse deleteIndexResponse = javaClient().indices().delete(b -> b.index(index1));
            assertTrue(deleteIndexResponse.acknowledged());
        }

        {
            // Testing doc deletion after data ingestion
            String docId = "id";
            String index = "my-index1";
            javaClient().indices().create(b -> b.index(index));

            String id = javaClient().index(b -> b.index(index).id(docId).document(Collections.singletonMap("foo", "bar"))).id();
            assertEquals(id, docId);

            DeleteResponse deleteResponse = javaClient().delete(d -> d.id(docId).index(index));
            assertEquals(deleteResponse.index(), index);
            assertEquals(deleteResponse.id(), docId);
            assertEquals(deleteResponse.result(), Result.Deleted);

            String docIdTemp = "does_not_exist";
            DeleteResponse deleteResponseDocNotExist = javaClient().delete(d -> d.id(docIdTemp).index(index));
            assertEquals(deleteResponseDocNotExist.index(), index);
            assertEquals(deleteResponseDocNotExist.id(), docIdTemp);
            assertEquals(deleteResponseDocNotExist.result(), Result.NotFound);

        }
    }

    public void testExists() throws IOException {
        assertFalse(javaClient().indices().exists(b -> b.index("index")).value());
        String index = "ingest-test";
        // Create an index
        CreateIndexResponse createIndexResponse = javaClient().indices().create(b -> b.index(index));
        assertEquals(index, createIndexResponse.index());

        // Check that it actually exists. Example of a boolean response
        assertTrue(javaClient().indices().exists(b -> b.index(index)).value());

        javaClient().index(b -> b.index(index).id("id").document(Collections.singletonMap("foo", "bar")).refresh(Refresh.True));

        assertTrue(javaClient().exists(b -> b.index(index).id("id")).value());
        assertFalse(javaClient().exists(b -> b.index(index).id("random_id")).value());
        assertFalse(javaClient().exists(b -> b.index(index).id("random_id").version(1L)).value());
    }

    public void testSourceExists() throws IOException {
        AppData appData = new AppData();
        appData.setIntValue(1337);
        appData.setMsg("foo");

        {
            ExistsSourceRequest request = new ExistsSourceRequest.Builder().index("index").id("id").build();
            BooleanResponse response = javaClient().existsSource(request);
            assertFalse(response.value());
        }
        javaClient().index(b -> b.index("index").id("id").refresh(Refresh.True).document(appData));
        {
            ExistsSourceRequest request = new ExistsSourceRequest.Builder().index("index").id("id").build();
            BooleanResponse response = javaClient().existsSource(request);
            assertTrue(response.value());
        }
        {
            ExistsSourceRequest request = new ExistsSourceRequest.Builder().index("index").id("does_not_exist").build();
            BooleanResponse response = javaClient().existsSource(request);
            assertFalse(response.value());
        }
    }

    public void testGet() throws IOException {

        {
            OpenSearchException exception = expectThrows(
                OpenSearchException.class,
                () -> javaClient().get(new GetRequest.Builder().index("index").id("id").build(), String.class)
            );
            assertEquals(404, exception.status());
            assertEquals("Request failed: [index_not_found_exception] no such index [index]", exception.getMessage());
        }

        AppData appData = new AppData();
        appData.setIntValue(1337);
        appData.setMsg("foo");

        javaClient().index(b -> b.index("index").id("id").document(appData).refresh(Refresh.True));

        {
            GetResponse<AppData> getResponse = javaClient().get(b -> b.index("index").id("id").version(1L), AppData.class);
            assertEquals("index", getResponse.index());
            assertEquals("id", getResponse.id());
            assertTrue(getResponse.found());
            assertEquals(java.util.Optional.of(1L), java.util.Optional.of(getResponse.version()));
            assertEquals(appData.getIntValue(), getResponse.source().getIntValue());
            assertEquals(appData.getMsg(), getResponse.source().getMsg());
        }
        {
            GetResponse<AppData> getResponse = javaClient().get(b -> b.index("index").id("does_not_exist"), AppData.class);
            assertEquals("index", getResponse.index());
            assertEquals("does_not_exist", getResponse.id());
            assertFalse(getResponse.found());
            assertNull(getResponse.version());
            assertNull(getResponse.source());
        }
    }

    public void testGetWithTypes() throws IOException {
        AppData appData = new AppData();
        appData.setIntValue(1337);
        appData.setMsg("foo");

        javaClient().index(b -> b.index("index").id("id").document(appData).refresh(Refresh.True));

        GetResponse<AppData> getResponse = javaClient().get(b -> b.index("index").id("id"), AppData.class);

        assertEquals("index", getResponse.index());
        assertEquals("id", getResponse.id());

        assertTrue(getResponse.found());
        assertEquals(java.util.Optional.of(1L), java.util.Optional.of(getResponse.version()));
        assertEquals(appData.getMsg(), getResponse.source().getMsg());
    }

    public void testMultiGet() throws IOException {
        {
            AppData appData = new AppData();
            appData.setIntValue(1337);
            appData.setMsg("foo");

            List<String> ids = new ArrayList<>();
            ids.add("id1");
            ids.add("id2");
            MgetResponse<AppData> response = javaClient().mget(b -> b.index("index").ids(ids), AppData.class);
            assertEquals(2, response.docs().size());

            assertTrue(response.docs().get(0).isFailure());
            assertEquals("id1", response.docs().get(0).failure().id());
            assertEquals("index", response.docs().get(0).failure().index());
            assertEquals("no such index [index]", response.docs().get(0).failure().error().reason());
            assertTrue(response.docs().get(1).isFailure());
            assertEquals("id2", response.docs().get(1).failure().id());
            assertEquals("index", response.docs().get(1).failure().index());
            assertEquals("no such index [index]", response.docs().get(1).failure().error().reason());
        }
    }

    public void testUpdate() throws Exception {
        AppData appData = new AppData();
        appData.setIntValue(1337);
        appData.setMsg("foo");

        AppData updatedAppData = new AppData();
        appData.setIntValue(3333);
        appData.setMsg("bar");

        {
            UpdateRequest<AppData, AppData> updateRequest = new UpdateRequest.Builder<AppData, AppData>().index("index")
                .id("does_not_exist")
                .doc(appData)
                .source(s -> s.fetch(randomBoolean()))
                .build();
            try {
                javaClient().update(updateRequest, AppData.class);
            } catch (OpenSearchException e) {
                // 1.x: [document_missing_exception] [_doc][does_not_exist]: document missing
                // 2.x: [document_missing_exception] [does_not_exist]: document missing
                assertTrue(e.getMessage().contains("[document_missing_exception]"));
                assertTrue(e.getMessage().contains("[does_not_exist]: document missing"));
                assertEquals(404, e.status());
            }
        }
        {
            IndexRequest<AppData> indexRequest = new IndexRequest.Builder<AppData>().index("index").id("id").document(appData).build();
            IndexResponse indexResponse = javaClient().index(indexRequest);
            assertEquals(Result.Created, indexResponse.result());

            long lastUpdateSeqNo;
            long lastUpdatePrimaryTerm;
            {
                UpdateRequest<AppData, AppData> updateRequest = new UpdateRequest.Builder<AppData, AppData>().index("index")
                    .id("id")
                    .doc(updatedAppData)
                    .build();
                UpdateResponse<AppData> updateResponse = javaClient().update(updateRequest, AppData.class);
                assertEquals(Result.Updated, updateResponse.result());
                assertEquals(indexResponse.version() + 1, updateResponse.version());
                lastUpdateSeqNo = updateResponse.seqNo();
                lastUpdatePrimaryTerm = updateResponse.primaryTerm();
                assertTrue(lastUpdateSeqNo >= 0L);
                assertTrue(lastUpdatePrimaryTerm >= 1L);
            }

        }
    }

    public void testUpdateWithTypes() throws IOException {

        AppData appData = new AppData();
        appData.setIntValue(1337);
        appData.setMsg("foo");

        AppData updatedAppData = new AppData();
        appData.setIntValue(3333);
        appData.setMsg("bar");

        IndexRequest<AppData> indexRequest = new IndexRequest.Builder<AppData>().index("index").id("id").document(appData).build();
        IndexResponse indexResponse = javaClient().index(indexRequest);

        UpdateRequest<AppData, AppData> updateRequest = new UpdateRequest.Builder<AppData, AppData>().index("index")
            .id("id")
            .doc(updatedAppData)
            .build();
        UpdateResponse<AppData> updateResponse = javaClient().update(updateRequest, AppData.class);

        assertEquals(Result.Updated, updateResponse.result());
        assertEquals(indexResponse.version() + 1, updateResponse.version());
    }

    public void testBulk() throws IOException {
        AppData appData = new AppData();
        appData.setIntValue(1337);
        appData.setMsg("foo");
        int nbItems = randomIntBetween(10, 100);
        boolean[] errors = new boolean[nbItems];

        List<BulkOperation> opsList = new ArrayList<>();

        for (int i = 0; i < nbItems; i++) {
            String id = String.valueOf(i);
            boolean erroneous = randomBoolean();
            errors[i] = erroneous;
            BulkOperation.Kind opType = randomFrom(
                BulkOperation.Kind.Delete,
                BulkOperation.Kind.Index,
                BulkOperation.Kind.Create,
                BulkOperation.Kind.Update
            );
            if (opType.equals(BulkOperation.Kind.Delete)) {
                if (!erroneous) {
                    assertEquals(Result.Created, javaClient().index(b -> b.index("index").id(id).document(appData)).result());
                }
                BulkOperation op = new BulkOperation.Builder().delete(d -> d.index("index").id(id)).build();
                opsList.add(op);
            } else {
                appData.setIntValue(i);
                appData.setMsg("id");
                if (opType.equals(BulkOperation.Kind.Index)) {
                    BulkOperation op = new BulkOperation.Builder().index(
                        b -> b.index("index").id(id).document(appData).ifSeqNo(erroneous ? 12L : null).ifPrimaryTerm(erroneous ? 12L : null)
                    ).build();
                    opsList.add(op);

                } else if (opType.equals(BulkOperation.Kind.Create)) {
                    BulkOperation op = new BulkOperation.Builder().create(o -> o.index("index").id(id).document(appData)).build();
                    opsList.add(op);

                    if (erroneous) {
                        assertEquals(Result.Created, javaClient().index(b -> b.index("index").id(id).document(appData)).result());
                    }

                } else if (opType.equals(BulkOperation.Kind.Update)) {
                    BulkOperation op = new BulkOperation.Builder().update(
                        o -> o.index("index").id(id).document(Collections.singletonMap("key", "value"))
                    ).build();
                    opsList.add(op);
                    if (!erroneous) {
                        assertEquals(Result.Created, javaClient().index(b -> b.index("index").id(id).document(appData)).result());
                    }
                }
            }
        }
        BulkRequest bulkRequest = new BulkRequest.Builder().operations(opsList).build();

        BulkResponse bulkResponse = javaClient().bulk(bulkRequest);
        assertTrue(bulkResponse.took() > 0);
        assertEquals(nbItems, bulkResponse.items().size());

        validateBulkResponses(nbItems, errors, bulkResponse, bulkRequest);
    }

    public void testBulkUpdateScript() throws IOException {
        final String id = "100";

        final AppData appData = new AppData();
        appData.setIntValue(1337);
        appData.setMsg("foo");

        assertEquals(Result.Created, javaClient().index(b -> b.index("index").id(id).document(appData)).result());

        final BulkOperation op = new BulkOperation.Builder().update(
            o -> o.index("index")
                .id(id)
                .script(
                    Script.of(
                        s -> s.inline(
                            new InlineScript.Builder().lang(l -> l.builtin(BuiltinScriptLanguage.Painless))
                                .source("ctx._source.intValue += params.inc")
                                .params("inc", JsonData.of(1))
                                .build()
                        )
                    )
                )
        ).build();

        BulkRequest bulkRequest = new BulkRequest.Builder().operations(op).build();
        BulkResponse bulkResponse = javaClient().bulk(bulkRequest);

        assertTrue(bulkResponse.took() > 0);
        assertEquals(1, bulkResponse.items().size());

        final GetResponse<AppData> getResponse = javaClient().get(b -> b.index("index").id(id), AppData.class);
        assertTrue(getResponse.found());
        assertEquals(1338, getResponse.source().getIntValue());
    }

    public void testBulkUpdateScriptUpsert() throws IOException {
        final String id = "100";

        final AppData appData = new AppData();
        appData.setIntValue(1337);
        appData.setMsg("foo");

        final BulkOperation op = new BulkOperation.Builder().update(
            o -> o.index("index")
                .id(id)
                .upsert(appData)
                .script(
                    Script.of(
                        s -> s.inline(
                            new InlineScript.Builder().lang(l -> l.builtin(BuiltinScriptLanguage.Painless))
                                .source("ctx._source.intValue += params.inc")
                                .params("inc", JsonData.of(1))
                                .build()
                        )
                    )
                )
        ).build();

        BulkRequest bulkRequest = new BulkRequest.Builder().operations(op).build();
        BulkResponse bulkResponse = javaClient().bulk(bulkRequest);

        assertTrue(bulkResponse.took() > 0);
        assertEquals(1, bulkResponse.items().size());

        final GetResponse<AppData> getResponse = javaClient().get(b -> b.index("index").id(id), AppData.class);
        assertTrue(getResponse.found());
        assertEquals(1337, getResponse.source().getIntValue());
    }

    public void testBulkUpdateScriptedUpsertUpdate() throws IOException {
        final String id = "777";

        final AppData appData = new AppData();
        appData.setIntValue(1337);
        appData.setMsg("foo");

        assertEquals(Result.Created, javaClient().index(b -> b.index("index").id(id).document(appData)).result());

        final BulkOperation op = new BulkOperation.Builder().update(
            o -> o.index("index")
                .id(id)
                .scriptedUpsert(true)
                .upsert(Collections.emptyMap())
                .script(
                    Script.of(
                        s -> s.inline(
                            new InlineScript.Builder().lang(l -> l.builtin(BuiltinScriptLanguage.Painless))
                                .source("ctx._source.intValue = ctx?._source?.intValue == null ? 7777 : 9999")
                                .build()
                        )
                    )
                )
        ).build();

        BulkRequest bulkRequest = new BulkRequest.Builder().operations(op).build();
        BulkResponse bulkResponse = javaClient().bulk(bulkRequest);

        assertTrue(bulkResponse.took() > 0);
        assertEquals(1, bulkResponse.items().size());

        final GetResponse<AppData> getResponse = javaClient().get(b -> b.index("index").id(id), AppData.class);
        assertTrue(getResponse.found());
        assertEquals(9999, getResponse.source().getIntValue());
    }

    public void testBulkUpdateScriptedUpsertInsert() throws IOException {
        final String id = "778";

        final BulkOperation op = new BulkOperation.Builder().update(
            o -> o.index("index")
                .id(id)
                .scriptedUpsert(true)
                .upsert(Collections.emptyMap())
                .script(
                    Script.of(
                        s -> s.inline(
                            new InlineScript.Builder().lang(l -> l.builtin(BuiltinScriptLanguage.Painless))
                                .source("ctx._source.intValue = ctx?._source?.intValue == null ? 7777 : 9999")
                                .build()
                        )
                    )
                )
        ).build();

        BulkRequest bulkRequest = new BulkRequest.Builder().operations(op).build();
        BulkResponse bulkResponse = javaClient().bulk(bulkRequest);

        assertTrue(bulkResponse.took() > 0);
        assertEquals(1, bulkResponse.items().size());

        final GetResponse<AppData> getResponse = javaClient().get(b -> b.index("index").id(id), AppData.class);
        assertTrue(getResponse.found());
        assertEquals(7777, getResponse.source().getIntValue());
    }

    public void testBulkUpdateDetectNoop() throws IOException {
        final String id = "779";

        final AppData appData = new AppData();
        appData.setIntValue(1337);
        appData.setMsg("foo");

        assertEquals(Result.Created, javaClient().index(b -> b.index("index").id(id).document(appData)).result());

        BulkOperation op = new BulkOperation.Builder().update(o -> o.index("index").id(id).detectNoop(true).document(appData)).build();

        BulkRequest bulkRequest = new BulkRequest.Builder().operations(op).build();
        BulkResponse bulkResponse = javaClient().bulk(bulkRequest);

        assertTrue(bulkResponse.took() > 0);
        assertEquals(1, bulkResponse.items().size());
        assertEquals(Result.NoOp.jsonValue(), bulkResponse.items().get(0).result());

        op = new BulkOperation.Builder().update(o -> o.index("index").id(id).detectNoop(false).document(appData)).build();

        bulkRequest = new BulkRequest.Builder().operations(op).build();
        bulkResponse = javaClient().bulk(bulkRequest);
        assertTrue(bulkResponse.took() > 0);
        assertEquals(1, bulkResponse.items().size());
        assertEquals(Result.Updated.jsonValue(), bulkResponse.items().get(0).result());

    }

    public void testBulkUpdateUpsert() throws IOException {
        final String id = "100";

        final AppData appData = new AppData();
        appData.setIntValue(1337);
        appData.setMsg("foo");

        final BulkOperation op = new BulkOperation.Builder().update(o -> o.index("index").id(id).document(new AppData()).upsert(appData))
            .build();

        BulkRequest bulkRequest = new BulkRequest.Builder().operations(op).build();
        BulkResponse bulkResponse = javaClient().bulk(bulkRequest);

        assertTrue(bulkResponse.took() > 0);
        assertEquals(1, bulkResponse.items().size());

        final GetResponse<AppData> getResponse = javaClient().get(b -> b.index("index").id(id), AppData.class);
        assertTrue(getResponse.found());
        assertEquals(1337, getResponse.source().getIntValue());
    }

    private void validateBulkResponses(int nbItems, boolean[] errors, BulkResponse bulkResponse, BulkRequest bulkRequest) {
        for (int i = 0; i < nbItems; i++) {
            BulkResponseItem bulkResponseItem = bulkResponse.items().get(i);

            assertEquals("index", bulkResponseItem.index());
            assertEquals(String.valueOf(i), bulkResponseItem.id());

            BulkOperation bulkOperation = bulkRequest.operations().get(i);
            if (bulkOperation.isIndex() || bulkOperation.isCreate()) {
                assertEquals(errors[i] ? 409 : 201, bulkResponseItem.status());
            } else if (bulkOperation.isUpdate()) {
                assertEquals(errors[i] ? 404 : 200, bulkResponseItem.status());
                assertEquals(errors[i] ? null /* no result from server */ : Result.Updated.jsonValue(), bulkResponseItem.result());
            } else if (bulkOperation.isDelete()) {
                assertEquals(errors[i] ? Result.NotFound.jsonValue() : Result.Deleted.jsonValue(), bulkResponseItem.result());
                assertEquals(errors[i] ? 404 : 200, bulkResponseItem.status());
            }
        }
    }

    public void testUrlEncode() throws IOException {
        String indexPattern = "<logstash-{now/M}>";
        String expectedIndex = "logstash-"
            + DateTimeFormat.forPattern("YYYY.MM.dd").print(new DateTime(DateTimeZone.UTC).monthOfYear().roundFloorCopy());
        AppData appData = new AppData();
        appData.setIntValue(1337);
        appData.setMsg("foo");
        {
            IndexResponse response = javaClient().index(b -> b.index(indexPattern).id("id#1").document(appData));
            assertEquals(expectedIndex, response.index());
            assertEquals("id#1", response.id());
        }
        {
            GetResponse<AppData> getResponse = javaClient().get(b -> b.index(indexPattern).id("id#1"), AppData.class);
            assertTrue(getResponse.found());
            assertEquals(expectedIndex, getResponse.index());
            assertEquals("id#1", getResponse.id());
        }

        String docId = "this/is/the/id";
        {
            IndexResponse indexResponse = javaClient().index(b -> b.index("index").id(docId).document(appData));
            assertEquals("index", indexResponse.index());
            assertEquals(docId, indexResponse.id());
        }
        {
            GetResponse<AppData> getResponse = javaClient().get(b -> b.index("index").id(docId), AppData.class);
            assertTrue(getResponse.found());
            assertEquals("index", getResponse.index());
            assertEquals(docId, getResponse.id());
        }

        assertTrue(javaClient().indices().exists(b -> b.index(indexPattern, "index")).value());
    }

    public void testParamsEncode() throws IOException {
        String routing = "test";
        {
            String id = "id";
            AppData appData = new AppData();
            appData.setIntValue(1337);
            appData.setMsg("foo");
            IndexResponse response = javaClient().index(b -> b.index("index").id(id).document(appData).routing(routing));
            assertEquals("index", response.index());
            assertEquals(id, response.id());
        }
        {
            GetResponse<AppData> getResponse = javaClient().get(b -> b.index("index").id("id").routing(routing), AppData.class);
            assertTrue(getResponse.found());
            assertEquals("index", getResponse.index());
            assertEquals("id", getResponse.id());
            assertEquals(routing, getResponse.routing());
        }
    }

    public void testGetIdWithPlusSign() throws Exception {
        String id = "id+id";
        AppData appData = new AppData();
        appData.setIntValue(1337);
        appData.setMsg("foo");

        {
            IndexResponse indexResponse = javaClient().index(b -> b.index("index").id(id).document(appData));
            assertEquals("index", indexResponse.index());
            assertEquals(id, indexResponse.id());
        }
        {
            GetResponse<AppData> getResponse = javaClient().get(b -> b.index("index").id(id), AppData.class);
            assertTrue(getResponse.found());
            assertEquals("index", getResponse.index());
            assertEquals(id, getResponse.id());
        }
    }

    public static class AppData {
        private int intValue;
        private String msg;

        public int getIntValue() {
            return intValue;
        }

        public void setIntValue(int intValue) {
            this.intValue = intValue;
        }

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }
    }
}
