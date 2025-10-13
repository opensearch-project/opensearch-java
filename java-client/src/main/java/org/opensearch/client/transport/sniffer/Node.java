/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.transport.sniffer;

import org.apache.hc.core5.http.HttpHost;
import java.util.Objects;

/**
 * Represents a node in the OpenSearch cluster discovered by sniffing.
 */
public class Node {

    private final HttpHost host;
    private final String roles;
    private final String version;
    private final String name;

    public Node(HttpHost host) {
        this(host, null, null, null);
    }

    public Node(HttpHost host, String roles, String version, String name) {
        this.host = Objects.requireNonNull(host, "host cannot be null");
        this.roles = roles;
        this.version = version;
        this.name = name;
    }

    /**
     * Returns the host information for this node.
     */
    public HttpHost getHost() {
        return host;
    }

    /**
     * Returns the roles of this node (e.g., "master", "data", "ingest").
     */
    public String getRoles() {
        return roles;
    }

    /**
     * Returns the OpenSearch version of this node.
     */
    public String getVersion() {
        return version;
    }

    /**
     * Returns the name of this node.
     */
    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Node node = (Node) obj;
        return Objects.equals(host, node.host);
    }

    @Override
    public int hashCode() {
        return Objects.hash(host);
    }

    @Override
    public String toString() {
        return "Node{" +
                "host=" + host +
                ", roles='" + roles + '\'' +
                ", version='" + version + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
