/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.transport.client_metrics;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import io.micrometer.core.instrument.Tags;
import java.util.EnumSet;
import org.junit.Test;

public class MeterOptionsTest {
    @Test
    public void testMeterOptions() {
        MeterOptions meterOptions = new MeterOptions(
            new double[] { 0.80, 0.85 },
            Tags.of("test1", "test2"),
            EnumSet.of(MetricTag.CLIENT_ID)
        );
        assertArrayEquals(new double[] { 0.80, 0.85 }, meterOptions.getPercentiles(), 0);
        assertEquals(Tags.of("test1", "test2"), meterOptions.getCommonTags());
        assertEquals(EnumSet.of(MetricTag.CLIENT_ID), meterOptions.getExcludedTagNames());
    }

    @Test
    public void testMeterOptionsNoNull() {
        MeterOptions meterOptions = new MeterOptions(null, null, null);
        assertArrayEquals(MetricConstants.DEFAULT_PERCENTILES, meterOptions.getPercentiles(), 0.0);
        assertEquals(Tags.empty(), meterOptions.getCommonTags());
        assertEquals(MetricConstants.DEFAULT_EXCLUDED_TAGS, meterOptions.getExcludedTagNames());
    }
}
