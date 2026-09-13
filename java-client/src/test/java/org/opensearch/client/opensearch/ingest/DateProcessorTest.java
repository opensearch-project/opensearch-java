/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.opensearch.ingest;

import org.junit.Test;
import org.opensearch.client.opensearch.model.ModelTestCase;

public class DateProcessorTest extends ModelTestCase {

    @Test
    public void testJsonRoundtripWithOutputFormat() {
        Processor processor = new Processor.Builder().date(
            d -> d.field("start_time").formats("date_time").outputFormat("epoch_millis").targetField("start_time")
        ).build();
        String json =
            "{\"date\":{\"field\":\"start_time\",\"formats\":[\"date_time\"],\"output_format\":\"epoch_millis\",\"target_field\":\"start_time\"}}";
        DateProcessor deserialized = checkJsonRoundtrip(processor, json).date();

        assertEquals("start_time", deserialized.field());
        assertEquals("epoch_millis", deserialized.outputFormat());
        assertEquals("start_time", deserialized.targetField());
    }

    @Test
    public void testJsonRoundtripWithoutOutputFormat() {
        Processor processor = new Processor.Builder().date(d -> d.field("start_time").formats("date_time")).build();
        String json = "{\"date\":{\"field\":\"start_time\",\"formats\":[\"date_time\"]}}";
        DateProcessor deserialized = checkJsonRoundtrip(processor, json).date();

        assertEquals("start_time", deserialized.field());
        assertNull(deserialized.outputFormat());
    }

    @Test
    public void testToBuilderPreservesOutputFormat() {
        DateProcessor original = DateProcessor.of(d -> d.field("start_time").formats("date_time").outputFormat("epoch_millis"));
        DateProcessor copy = original.toBuilder().build();

        assertEquals("epoch_millis", copy.outputFormat());
        assertEquals(original, copy);
        assertEquals(original.hashCode(), copy.hashCode());
    }
}
