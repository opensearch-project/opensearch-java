/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.opensearch.ism;

import jakarta.json.stream.JsonParser;
import java.io.StringReader;
import org.junit.Test;
import org.opensearch.client.opensearch.model.ModelTestCase;

/**
 * Regression tests for https://github.com/opensearch-project/opensearch-java/issues/1898
 *
 * last_updated_time is an epoch-millisecond timestamp and must be Long, not Integer.
 * Integer.MAX_VALUE is 2147483647 (~Jan 2038), but real timestamps like 1700000000000L
 * (Nov 2023) already exceed it and previously caused InputCoercionException or silent overflow.
 */
public class IsmLastUpdatedTimeTest extends ModelTestCase {

    private static final long EPOCH_MS = 1_700_000_000_000L;

    @Test
    public void policy_lastUpdatedTime_deserializesWithoutOverflow() {
        String json = "{\"last_updated_time\":" + EPOCH_MS + "}";
        JsonParser parser = mapper.jsonProvider().createParser(new StringReader(json));
        Policy policy = Policy._DESERIALIZER.deserialize(parser, mapper);
        assertEquals(Long.valueOf(EPOCH_MS), policy.lastUpdatedTime());
    }

    @Test
    public void ismTemplate_lastUpdatedTime_deserializesWithoutOverflow() {
        String json = "{\"last_updated_time\":" + EPOCH_MS + "}";
        JsonParser parser = mapper.jsonProvider().createParser(new StringReader(json));
        IsmTemplate template = IsmTemplate._DESERIALIZER.deserialize(parser, mapper);
        assertEquals(Long.valueOf(EPOCH_MS), template.lastUpdatedTime());
    }

    @Test
    public void policy_lastUpdatedTime_builderAcceptsLong() {
        Policy policy = Policy.of(b -> b.lastUpdatedTime(EPOCH_MS));
        assertEquals(Long.valueOf(EPOCH_MS), policy.lastUpdatedTime());
    }

    @Test
    public void ismTemplate_lastUpdatedTime_builderAcceptsLong() {
        IsmTemplate template = IsmTemplate.of(b -> b.lastUpdatedTime(EPOCH_MS));
        assertEquals(Long.valueOf(EPOCH_MS), template.lastUpdatedTime());
    }
}
