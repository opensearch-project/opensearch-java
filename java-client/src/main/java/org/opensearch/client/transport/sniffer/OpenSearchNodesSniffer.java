/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.transport.sniffer;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.core5.http.HttpHost;
import org.apache.hc.core5.http.io.entity.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Implementation of {@link NodesSniffer} that discovers nodes by calling the OpenSearch cluster's nodes API.
 */
public class OpenSearchNodesSniffer implements NodesSniffer {

    public static final String NODES_INFO_PATH = "_nodes/http";
    public static final String DEFAULT_SCHEME = "http";

    private final CloseableHttpClient httpClient;
    private final List<HttpHost> hosts;
    private final String scheme;
    private final ObjectMapper objectMapper;

    public OpenSearchNodesSniffer(CloseableHttpClient httpClient, List<HttpHost> hosts, String scheme) {
        this.httpClient = httpClient;
        this.hosts = hosts;
        this.scheme = scheme != null ? scheme : DEFAULT_SCHEME;
        this.objectMapper = new ObjectMapper();
    }

    @Override
    public List<Node> sniff() throws IOException {
        List<Node> sniffedNodes = new ArrayList<>();

        for (HttpHost host : hosts) {
            try {
                List<Node> nodesFromHost = sniffFromHost(host);
                if (!nodesFromHost.isEmpty()) {
                    return nodesFromHost; // Return nodes from first successful host
                }
            } catch (IOException e) {
                // Try next host if current one fails
                continue;
            }
        }

        throw new IOException("Unable to sniff nodes from any of the provided hosts");
    }

    private List<Node> sniffFromHost(HttpHost host) throws IOException {
        String nodesInfoUrl = host.toURI() + "/" + NODES_INFO_PATH;
        HttpGet request = new HttpGet(nodesInfoUrl);

        try (CloseableHttpResponse response = httpClient.execute(request)) {
            if (response.getCode() != 200) {
                throw new IOException("Nodes info request failed with status: " + response.getCode());
            }

            try {
                String responseBody = EntityUtils.toString(response.getEntity());
                return parseNodesResponse(responseBody);
            } catch (Exception e) {
                throw new IOException("Failed to parse response body", e);
            }
        }
    }

    private List<Node> parseNodesResponse(String responseBody) throws IOException {
        List<Node> nodes = new ArrayList<>();
        JsonNode root = objectMapper.readTree(responseBody);
        JsonNode nodesNode = root.get("nodes");

        if (nodesNode != null && nodesNode.isObject()) {
            Iterator<Map.Entry<String, JsonNode>> nodeIterator = nodesNode.fields();

            while (nodeIterator.hasNext()) {
                Map.Entry<String, JsonNode> nodeEntry = nodeIterator.next();
                JsonNode nodeInfo = nodeEntry.getValue();

                Node node = parseNodeInfo(nodeInfo);
                if (node != null) {
                    nodes.add(node);
                }
            }
        }

        return nodes;
    }

    private Node parseNodeInfo(JsonNode nodeInfo) {
        try {
            JsonNode httpNode = nodeInfo.get("http");
            if (httpNode == null) {
                return null;
            }

            JsonNode publishAddressNode = httpNode.get("publish_address");
            if (publishAddressNode == null) {
                return null;
            }

            String publishAddress = publishAddressNode.asText();
            HttpHost host = parseHttpHost(publishAddress);

            String roles = extractRoles(nodeInfo);
            String version = extractVersion(nodeInfo);
            String name = extractName(nodeInfo);

            return new Node(host, roles, version, name);
        } catch (Exception e) {
            // Skip malformed node info
            return null;
        }
    }

    private HttpHost parseHttpHost(String publishAddress) {
        // Parse format like "127.0.0.1:9200" or "[::1]:9200"
        String host;
        int port;

        if (publishAddress.startsWith("[")) {
            // IPv6 format
            int closeBracket = publishAddress.indexOf(']');
            host = publishAddress.substring(1, closeBracket);
            port = Integer.parseInt(publishAddress.substring(closeBracket + 2));
        } else {
            // IPv4 format
            String[] parts = publishAddress.split(":");
            host = parts[0];
            port = Integer.parseInt(parts[1]);
        }

        return new HttpHost(scheme, host, port);
    }

    private String extractRoles(JsonNode nodeInfo) {
        JsonNode rolesNode = nodeInfo.get("roles");
        if (rolesNode != null && rolesNode.isArray()) {
            List<String> roles = new ArrayList<>();
            for (JsonNode role : rolesNode) {
                roles.add(role.asText());
            }
            return String.join(",", roles);
        }
        return null;
    }

    private String extractVersion(JsonNode nodeInfo) {
        JsonNode versionNode = nodeInfo.get("version");
        return versionNode != null ? versionNode.asText() : null;
    }

    private String extractName(JsonNode nodeInfo) {
        JsonNode nameNode = nodeInfo.get("name");
        return nameNode != null ? nameNode.asText() : null;
    }
}
