/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.opensearch.core.bulk;

import java.util.Map;
import org.junit.Assert;
import org.junit.Test;
import org.opensearch.client.json.JsonpSerializer;
import org.opensearch.client.opensearch._types.Script;
import org.opensearch.client.opensearch.core.search.SourceConfig;

public class UpdateOperationTest extends Assert {

    @Test
    public void dataGetters() {
        final var doc = Map.of("field", "doc");
        final var upsert = Map.of("field", "upsert");
        final var script = Script.of(s -> s.inline(i -> i.source("ctx._source.field = 'x'")));
        final var source = SourceConfig.of(s -> s.fetch(true));
        final JsonpSerializer<Map<String, String>> serializer = (value, generator, mapper) -> {};

        final var operation = UpdateOperation.<Map<String, String>>of(
            u -> u.index("index")
                .id("id")
                .document(doc)
                .upsert(upsert)
                .docAsUpsert(true)
                .scriptedUpsert(false)
                .detectNoop(true)
                .script(script)
                .source(source)
                .requireAlias(true)
                .retryOnConflict(3)
                .tDocumentSerializer(serializer)
        );

        final var data = operation.data();
        assertSame(doc, data.document());
        assertSame(upsert, data.upsert());
        assertEquals(Boolean.TRUE, data.docAsUpsert());
        assertEquals(Boolean.FALSE, data.scriptedUpsert());
        assertEquals(Boolean.TRUE, data.detectNoop());
        assertSame(script, data.script());
        assertSame(source, data.source());
        assertSame(serializer, data.tDocumentSerializer());
        assertEquals(Boolean.TRUE, operation.requireAlias());
        assertEquals(Integer.valueOf(3), operation.retryOnConflict());
    }

    @Test
    public void dataGettersDefaultToNull() {
        final var data = UpdateOperation.of(u -> u.index("index").id("id")).data();

        assertNull(data.document());
        assertNull(data.upsert());
        assertNull(data.docAsUpsert());
        assertNull(data.scriptedUpsert());
        assertNull(data.detectNoop());
        assertNull(data.script());
        assertNull(data.source());
        assertNull(data.tDocumentSerializer());
    }
}
