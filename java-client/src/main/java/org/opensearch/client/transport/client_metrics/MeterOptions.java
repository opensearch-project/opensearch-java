/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.transport.client_metrics;

import static org.opensearch.client.transport.client_metrics.MetricConstants.DEFAULT_EXCLUDED_TAGS;
import static org.opensearch.client.transport.client_metrics.MetricConstants.DEFAULT_PERCENTILES;

import io.micrometer.core.instrument.Tags;
import java.util.Set;

/**
 * Contains settings for configuring a meter
 */
public class MeterOptions {
    private final double[] percentiles;
    private final Tags commonTags;
    private final Set<MetricTag> excludedTagNames;

    public MeterOptions(double[] percentiles, Tags commonTags, Set<MetricTag> excludedTagNames) {
        this.percentiles = percentiles == null ? DEFAULT_PERCENTILES.clone() : percentiles.clone();
        this.commonTags = commonTags == null ? Tags.empty() : commonTags;
        this.excludedTagNames = excludedTagNames == null ? DEFAULT_EXCLUDED_TAGS : excludedTagNames;
    }

    /**
     * Get percentiles to publish for Timer/Distribution meters
     * @return a double array
     */
    public double[] getPercentiles() {
        return percentiles;
    }

    /**
     * Get common {@link io.micrometer.core.instrument.Tags} that this meter need to have
     * @return a {@link io.micrometer.core.instrument.Tags}
     */
    public Tags getCommonTags() {
        return commonTags;
    }

    /**
     * Get tag names that a meter are excluded.
     * @return a set of {@link MetricTag}
     */
    public Set<MetricTag> getExcludedTagNames() {
        return excludedTagNames;
    }

}
