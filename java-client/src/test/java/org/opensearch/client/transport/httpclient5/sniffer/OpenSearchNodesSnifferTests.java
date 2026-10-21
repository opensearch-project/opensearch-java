/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.transport.httpclient5.sniffer;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;
import org.apache.hc.core5.http.HttpHost;
import org.junit.Test;
import org.opensearch.client.transport.httpclient5.internal.Node;

public class OpenSearchNodesSnifferTests {

    private static final String TWO_NODES = "{"
        + "\"_nodes\":{\"total\":2,\"successful\":2},"
        + "\"cluster_name\":\"test\","
        + "\"nodes\":{"
        + "  \"abc\":{\"name\":\"node-a\",\"version\":\"3.5.0\",\"roles\":[\"data\",\"ingest\"],"
        + "          \"attributes\":{\"zone\":\"z1\"},"
        + "          \"http\":{\"bound_address\":[\"127.0.0.1:9200\"],\"publish_address\":\"127.0.0.1:9200\"}},"
        + "  \"def\":{\"name\":\"node-b\",\"version\":\"3.5.0\",\"roles\":[\"cluster_manager\"],"
        + "          \"http\":{\"bound_address\":[\"127.0.0.1:9201\"],\"publish_address\":\"127.0.0.1:9201\"}}"
        + "}}";

    @Test
    public void parseNodes_readsHostRolesVersionName() {
        List<Node> nodes = OpenSearchNodesSniffer.parseNodes(new ByteArrayInputStream(TWO_NODES.getBytes(StandardCharsets.UTF_8)), "http");

        assertThat(nodes, hasSize(2));

        Node a = nodes.stream().filter(n -> "node-a".equals(n.getName())).findFirst().orElseThrow(AssertionError::new);
        assertThat(a.getHost(), is(new HttpHost("http", "127.0.0.1", 9200)));
        assertThat(a.getVersion(), is("3.5.0"));
        assertThat(a.getRoles().isData(), is(true));
        assertThat(a.getRoles().isIngest(), is(true));
        assertThat(a.getRoles().isClusterManagerEligible(), is(false));
        assertThat(a.getBoundHosts(), containsInAnyOrder(new HttpHost("http", "127.0.0.1", 9200)));

        Node b = nodes.stream().filter(n -> "node-b".equals(n.getName())).findFirst().orElseThrow(AssertionError::new);
        assertThat(b.getRoles().isClusterManagerEligible(), is(true));
    }

    @Test
    public void parseNodes_skipsNodesWithoutHttp() {
        String noHttp = "{\"nodes\":{\"x\":{\"name\":\"n\",\"version\":\"3.5.0\",\"roles\":[]}}}";
        List<Node> nodes = OpenSearchNodesSniffer.parseNodes(new ByteArrayInputStream(noHttp.getBytes(StandardCharsets.UTF_8)), "http");
        assertThat(nodes, hasSize(0));
    }

    @Test
    public void parseNodes_returnsEmptyListWhenNodesFieldIsNull() {
        String json = "{\"cluster_name\":\"test\",\"nodes\":null}";
        List<Node> nodes = OpenSearchNodesSniffer.parseNodes(new ByteArrayInputStream(json.getBytes(StandardCharsets.UTF_8)), "http");
        assertThat(nodes, hasSize(0));
    }

    @Test
    public void parseNodes_returnsEmptyListWhenNodesFieldIsNotAnObject() {
        String json = "{\"cluster_name\":\"test\",\"nodes\":\"not-an-object\"}";
        List<Node> nodes = OpenSearchNodesSniffer.parseNodes(new ByteArrayInputStream(json.getBytes(StandardCharsets.UTF_8)), "http");
        assertThat(nodes, hasSize(0));
    }

    @Test
    public void parseNodes_returnsEmptyListWhenRootIsNotAJsonObject() {
        // A top-level JSON array is valid JSON but reader.readObject() throws for it; parseNodes must
        // degrade to an empty list rather than let the unchecked JsonException escape.
        String json = "[1,2,3]";
        List<Node> nodes = OpenSearchNodesSniffer.parseNodes(new ByteArrayInputStream(json.getBytes(StandardCharsets.UTF_8)), "http");
        assertThat(nodes, hasSize(0));
    }

    @Test
    public void parseNodes_returnsEmptyListWhenBodyIsNotValidJson() {
        String malformed = "{not valid json";
        List<Node> nodes = OpenSearchNodesSniffer.parseNodes(new ByteArrayInputStream(malformed.getBytes(StandardCharsets.UTF_8)), "http");
        assertThat(nodes, hasSize(0));
    }

    @Test
    public void parseNodes_skipsNodeWithNullOrNonStringPublishAddress() {
        String json = "{\"nodes\":{"
            + "\"a\":{\"name\":\"n1\",\"http\":{\"publish_address\":null}},"
            + "\"b\":{\"name\":\"n2\",\"http\":{\"publish_address\":42}}"
            + "}}";
        List<Node> nodes = OpenSearchNodesSniffer.parseNodes(new ByteArrayInputStream(json.getBytes(StandardCharsets.UTF_8)), "http");
        assertThat(nodes, hasSize(0));
    }

    @Test
    public void parseNodes_keepsReachableNodeDespiteBadMetadata() {
        // Valid publish_address but a null name, a null version, and a non-string role entry. The node
        // is reachable, so it must survive with its bad metadata fields degraded to null rather than
        // being dropped entirely.
        String json = "{\"nodes\":{"
            + "\"a\":{\"name\":null,\"version\":null,\"roles\":[\"data\",7],"
            + "        \"http\":{\"publish_address\":\"127.0.0.1:9200\"}}"
            + "}}";
        List<Node> nodes = OpenSearchNodesSniffer.parseNodes(new ByteArrayInputStream(json.getBytes(StandardCharsets.UTF_8)), "http");

        assertThat(nodes, hasSize(1));
        Node a = nodes.get(0);
        assertThat(a.getHost(), is(new HttpHost("http", "127.0.0.1", 9200)));
        assertThat(a.getName(), is(nullValue()));
        assertThat(a.getVersion(), is(nullValue()));
        // The good "data" role is retained; the non-string entry is skipped.
        assertThat(a.getRoles().isData(), is(true));
    }

    @Test
    public void createHost_handlesHostnameSlashPrefix() {
        assertThat(
            OpenSearchNodesSniffer.createHost("node-1.example.com/10.0.0.1:9200", "https"),
            is(new HttpHost("https", "10.0.0.1", 9200))
        );
    }

    @Test
    public void createHost_handlesIpv6() {
        assertThat(OpenSearchNodesSniffer.createHost("[::1]:9200", "http"), is(new HttpHost("http", "::1", 9200)));
    }

    @Test
    public void createHost_handlesIpv6WithHostnamePrefix() {
        assertThat(OpenSearchNodesSniffer.createHost("node-1/[fe80::1]:9300", "http"), is(new HttpHost("http", "fe80::1", 9300)));
    }

    @Test
    public void createHost_throwsOnEmptyPort() {
        for (String addr : new String[] { "127.0.0.1:", "node/127.0.0.1:", "[::1]:" }) {
            try {
                OpenSearchNodesSniffer.createHost(addr, "http");
                org.junit.Assert.fail("expected IllegalStateException for empty port in: " + addr);
            } catch (IllegalStateException expected) {
                // expected
            }
        }
    }

    @Test
    public void createHost_throwsOnNonNumericPort() {
        try {
            OpenSearchNodesSniffer.createHost("127.0.0.1:notaport", "http");
            org.junit.Assert.fail("expected IllegalStateException for non-numeric port");
        } catch (IllegalStateException expected) {
            // expected
        }
    }
}
