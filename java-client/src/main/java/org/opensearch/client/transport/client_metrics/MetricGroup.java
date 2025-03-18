/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.transport.client_metrics;

import java.util.EnumSet;
import java.util.Set;

public enum MetricGroup {
    GENERAL,
    NETWORK_DETAILS;

    public static final Set<MetricGroup> REQUIRED_GROUPS = EnumSet.of(GENERAL);
    public static final Set<MetricGroup> ALL = EnumSet.allOf(MetricGroup.class);
}
