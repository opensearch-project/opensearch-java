/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.opensearch.core.bulk;

import java.util.Collections;
import java.util.Map;
import org.junit.Assert;
import org.junit.Test;
import org.opensearch.client.json.JsonpSerializer;
import org.opensearch.client.opensearch._types.Script;
import org.opensearch.client.opensearch.core.search.SourceConfig;

public class UpdateOperationTest extends Assert {

    @Test
    public void propertyGetters() {
        final Map<String, String> doc = Collections.singletonMap("field", "doc");
        final Map<String, String> upsert = Collections.singletonMap("field", "upsert");
        final Script script = Script.of(s -> s.inline(i -> i.source("ctx._source.field = 'x'")));
        final SourceConfig source = SourceConfig.of(s -> s.fetch(true));
        final JsonpSerializer<Map<String, String>> serializer = (value, generator, mapper) -> {};

        final UpdateOperation<Map<String, String>> operation = UpdateOperation.<Map<String, String>>of(
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

        assertSame(doc, operation.document());
        assertSame(upsert, operation.upsert());
        assertEquals(Boolean.TRUE, operation.docAsUpsert());
        assertEquals(Boolean.FALSE, operation.scriptedUpsert());
        assertEquals(Boolean.TRUE, operation.detectNoop());
        assertSame(script, operation.script());
        assertSame(source, operation.source());
        assertSame(serializer, operation.tDocumentSerializer());
        assertEquals(Boolean.TRUE, operation.requireAlias());
        assertEquals(Integer.valueOf(3), operation.retryOnConflict());
    }

    @Test
    public void propertyGettersDefaultToNull() {
        final UpdateOperation<?> operation = UpdateOperation.of(u -> u.index("index").id("id"));

        assertNull(operation.document());
        assertNull(operation.upsert());
        assertNull(operation.docAsUpsert());
        assertNull(operation.scriptedUpsert());
        assertNull(operation.detectNoop());
        assertNull(operation.script());
        assertNull(operation.source());
        assertNull(operation.tDocumentSerializer());
    }
}
