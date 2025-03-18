/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.transport.client_metrics;

public enum MetricTag {
    REQUEST("Request"),
    CLIENT_ID("ClientID"),
    STATUS_CODE_OR_EXCEPTION("StatusCodeOrException"),
    HOST_CONTACTED("HostContacted"),
    HOST("Host");

    private String name;

    MetricTag(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
