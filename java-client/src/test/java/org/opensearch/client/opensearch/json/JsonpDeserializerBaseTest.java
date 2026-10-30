/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.opensearch.json;

import jakarta.json.stream.JsonParser;
import jakarta.json.stream.JsonParser.Event;
import java.io.StringReader;
import java.util.EnumSet;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.junit.Test;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.opensearch._types.FieldValue;
import org.opensearch.client.opensearch.model.ModelTestCase;
import org.opensearch.client.opensearch.security.GetSslinfoResponse;

public class JsonpDeserializerBaseTest extends ModelTestCase {

    @Test
    public void testNullArrayItem() {

        String json = "[\"a\", null, \"c\"]";

        // Types that don't accept null events should end up as null values in the list
        {
            JsonpDeserializer<String> stringDeser = JsonpDeserializer.stringDeserializer();
            assertFalse(stringDeser.accepts(JsonParser.Event.VALUE_NULL));

            JsonParser parser = mapper.jsonProvider().createParser(new StringReader(json));

            List<String> stringList = JsonpDeserializer.arrayDeserializer(stringDeser).deserialize(parser, mapper);
            assertEquals("a", stringList.get(0));
            assertNull(stringList.get(1));
            assertEquals("c", stringList.get(2));
        }

        // Types that do accept null events should end up as their null representation
        {
            assertTrue(FieldValue._DESERIALIZER.accepts(JsonParser.Event.VALUE_NULL));

            JsonParser parser = mapper.jsonProvider().createParser(new StringReader(json));
            List<FieldValue> valueList = JsonpDeserializer.arrayDeserializer(FieldValue._DESERIALIZER).deserialize(parser, mapper);

            assertEquals("a", valueList.get(0)._get());
            assertTrue(valueList.get(1).isNull());
            assertEquals("c", valueList.get(2)._get());
        }
    }

    @Test
    public void testPlainArrayDoesNotAdvertiseTopLevelNull() {
        // arrayDeserializer is for array fields generally and must stay strict: only a field
        // whose schema explicitly allows null (arrayOrNullDeserializer, below) should tolerate
        // this. ObjectDeserializer's real field dispatch (see testOnlyNullableFieldToleratesNull,
        // below) decides whether to even call a field's deserializer for a given event based on
        // this flag, so this is the property that actually matters -- not calling deserialize()
        // directly, which has its own unrelated top-level-null handling at the interface's
        // 2-arg convenience overload that would mask a regression here.
        JsonpDeserializer<String> stringDeser = JsonpDeserializer.stringDeserializer();
        assertFalse(JsonpDeserializer.arrayDeserializer(stringDeser).accepts(JsonParser.Event.VALUE_NULL));
    }

    @Test
    public void testArrayOrNullAcceptsTopLevelNull() {
        // A JSON null for the whole array field (as opposed to an item within it) is treated as
        // an empty list rather than null, so it can flow into builder setters (via _listAddAll)
        // the same way an absent/empty array would, instead of throwing. Only used for fields
        // whose schema explicitly allows null, e.g. ism_template in ISM Policy.
        // See https://github.com/opensearch-project/opensearch-java/issues/1813
        String json = "null";

        JsonpDeserializer<String> stringDeser = JsonpDeserializer.stringDeserializer();
        JsonParser parser = mapper.jsonProvider().createParser(new StringReader(json));

        assertTrue(JsonpDeserializer.arrayOrNullDeserializer(stringDeser).accepts(JsonParser.Event.VALUE_NULL));
        List<String> stringList = JsonpDeserializer.arrayOrNullDeserializer(stringDeser).deserialize(parser, mapper);
        assertNotNull(stringList);
        assertTrue(stringList.isEmpty());
    }

    @Test
    public void testArrayOrNullStillDeserializesRealArray() {
        // Opting into null-tolerance must not change how an actual array is handled.
        String json = "[\"a\", \"b\"]";

        JsonpDeserializer<String> stringDeser = JsonpDeserializer.stringDeserializer();
        JsonParser parser = mapper.jsonProvider().createParser(new StringReader(json));

        List<String> stringList = JsonpDeserializer.arrayOrNullDeserializer(stringDeser).deserialize(parser, mapper);
        assertEquals(List.of("a", "b"), stringList);
    }

    @Test
    public void testOnlyNullableFieldToleratesNull() {
        // End-to-end through the real generated class and its real ObjectDeserializer field
        // dispatch (op.add(...)), not the deserializer in isolation. GetSslinfoResponse has two
        // sibling List<String> fields with the same item type -- local_certificates_list (plain
        // array, per the spec) and peer_certificates_list (schema explicitly allows null, the
        // #1813 fix) -- so this is a direct A/B on real production code: the same bug, one field
        // fixed, one deliberately left strict.
        String required = "\"peer_certificates\":\"x\","
            + "\"ssl_provider_transport_client\":\"x\","
            + "\"ssl_provider_transport_server\":\"x\"";

        GetSslinfoResponse ok = fromJson("{" + required + ",\"peer_certificates_list\":null}", GetSslinfoResponse.class);
        assertNotNull(ok.peerCertificatesList());
        assertTrue(ok.peerCertificatesList().isEmpty());

        assertThrows(Exception.class, () -> fromJson("{" + required + ",\"local_certificates_list\":null}", GetSslinfoResponse.class));
    }

    @Test
    public void testArrayAcceptedEventsAreCompleteWhileAnotherThreadComputesThem() throws Exception {
        JsonpDeserializer<String> strings = JsonpDeserializer.stringDeserializer();
        CountDownLatch firstComputationStarted = new CountDownLatch(1);
        CountDownLatch otherThreadRead = new CountDownLatch(1);
        AtomicBoolean firstCall = new AtomicBoolean(true);

        // The first call holds the array deserializer mid-computation until another thread has read its accepted events
        JsonpDeserializer<String> item = new JsonpDeserializer<String>() {
            @Override
            public EnumSet<Event> nativeEvents() {
                return strings.nativeEvents();
            }

            @Override
            public EnumSet<Event> acceptedEvents() {
                if (firstCall.getAndSet(false)) {
                    firstComputationStarted.countDown();
                    try {
                        otherThreadRead.await(10, TimeUnit.SECONDS);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
                return strings.acceptedEvents();
            }

            @Override
            public String deserialize(JsonParser parser, JsonpMapper mapper, Event event) {
                return strings.deserialize(parser, mapper, event);
            }
        };
        JsonpDeserializer<List<String>> arrays = JsonpDeserializer.arrayDeserializer(item);

        ExecutorService executor = Executors.newSingleThreadExecutor();
        try {
            Future<EnumSet<Event>> first = executor.submit(arrays::acceptedEvents);
            assertTrue(firstComputationStarted.await(10, TimeUnit.SECONDS));

            // Copied before releasing the first thread, as the check in JsonpUtils.ensureAccepts happens at that point
            EnumSet<Event> seen = EnumSet.copyOf(arrays.acceptedEvents());
            otherThreadRead.countDown();

            assertTrue(seen.toString(), seen.contains(Event.VALUE_STRING));
            assertTrue(first.get(10, TimeUnit.SECONDS).contains(Event.VALUE_STRING));
        } finally {
            executor.shutdownNow();
        }
    }
}
