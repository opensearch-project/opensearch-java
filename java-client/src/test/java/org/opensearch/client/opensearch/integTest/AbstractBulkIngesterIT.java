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

package org.opensearch.client.opensearch.integTest;

import java.io.IOException;
import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import org.junit.Test;
import org.opensearch.client.opensearch._helpers.bulk.BulkIngester;
import org.opensearch.client.opensearch.indices.IndicesStatsResponse;

public abstract class AbstractBulkIngesterIT extends OpenSearchJavaClientTestCase {

    static class AppData {
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

    @Test
    public void testEndToEnd() throws Exception {
        String index = "bulk-ingester-test";

        BulkIngester<?> ingester = BulkIngester.of(b -> b.client(javaClient()).globalSettings(s -> s.index(index)));

        AppData appData = new AppData();
        appData.setIntValue(42);
        appData.setMsg("Some message");

        ingester.add(_1 -> _1.create(_2 -> _2.id("abc").document(appData)));

        ingester.add(_1 -> _1.create(_2 -> _2.id("def").document(appData)));

        ingester.add(_1 -> _1.update(_2 -> _2.id("gh").docAsUpsert(true).document(appData)));

        // Closing waits until all pending requests are completed
        ingester.close();

        // Refresh to make documents searchable
        javaClient().indices().refresh(r -> r.index(index));

        // Verify documents were indexed
        for (String id : Arrays.asList("abc", "def", "gh")) {
            assertEquals(42, javaClient().get(b -> b.index(index).id(id), AppData.class).source().getIntValue());
        }

        // Clean up
        javaClient().indices().delete(d -> d.index(index));
    }

    @Test
    public void testMultiThreadStress() throws InterruptedException, IOException {

        String index = "bulk-ingester-stress-test";

        // DISCLAIMER: this configuration is highly inefficient and only used here to showcase an extreme
        // situation where the number of adding threads greatly exceeds the number of concurrent requests
        // handled by the ingester. It's strongly recommended to always tweak maxConcurrentRequests accordingly.
        BulkIngester<?> ingester = BulkIngester.of(
            b -> b.client(javaClient()).globalSettings(s -> s.index(index)).flushInterval(5, TimeUnit.SECONDS)
        );

        AppData appData = new AppData();
        appData.setIntValue(42);
        appData.setMsg("Some message");

        ExecutorService executor = Executors.newFixedThreadPool(50);

        for (int i = 0; i < 100000; i++) {
            int ii = i;
            Runnable thread = () -> {
                int finalI = ii;
                ingester.add(_1 -> _1.create(_2 -> _2.id(String.valueOf(finalI)).document(appData)));
            };
            executor.submit(thread);
        }

        executor.shutdown();
        executor.awaitTermination(30, TimeUnit.SECONDS);
        ingester.close();

        // Refresh to make documents searchable
        javaClient().indices().refresh(r -> r.index(index));

        IndicesStatsResponse indexStats = javaClient().indices().stats(g -> g.index(index));

        assertEquals(100000, indexStats.indices().get(index).primaries().docs().count());

        // Clean up
        javaClient().indices().delete(d -> d.index(index));
    }
}
