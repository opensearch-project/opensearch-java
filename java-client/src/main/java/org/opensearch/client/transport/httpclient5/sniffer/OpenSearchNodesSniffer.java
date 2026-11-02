/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.transport.httpclient5.sniffer;

import jakarta.json.Json;
import jakarta.json.JsonException;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;
import jakarta.json.JsonString;
import jakarta.json.JsonValue;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.hc.client5.http.config.RequestConfig;
import org.apache.hc.core5.http.HttpHost;
import org.apache.hc.core5.util.Timeout;
import org.opensearch.client.opensearch.generic.OpenSearchGenericClient;
import org.opensearch.client.opensearch.generic.Requests;
import org.opensearch.client.opensearch.generic.Response;
import org.opensearch.client.transport.OpenSearchTransport;
import org.opensearch.client.transport.TransportOptions;
import org.opensearch.client.transport.httpclient5.ApacheHttpClient5Options;
import org.opensearch.client.transport.httpclient5.internal.Node;

/**
 * Default {@link NodesSniffer}. Discovers nodes by calling {@code GET /_nodes/http} through the
 * client's own authenticated transport and parsing the {@code http.publish_address} of each node.
 */
public class OpenSearchNodesSniffer implements NodesSniffer {

    /** Scheme applied to discovered node addresses. */
    public static final String DEFAULT_SCHEME = "http";

    /** Default server-side {@code timeout} query parameter for the nodes-info request. */
    public static final long DEFAULT_SNIFF_REQUEST_TIMEOUT_MILLIS = 1000L;

    /** Default client-side connect/response timeout for the nodes-info request. */
    public static final long DEFAULT_SNIFF_REQUEST_SOCKET_TIMEOUT_MILLIS = 10_000L;

    /** Nodes info endpoint restricted to the http section only. */
    static final String NODES_INFO_ENDPOINT = "/_nodes/http";

    private static final Log logger = LogFactory.getLog(OpenSearchNodesSniffer.class);

    private final String scheme;
    private final long sniffRequestTimeoutMillis;
    private final OpenSearchGenericClient genericClient;

    /**
     * Discovery requests reuse {@code transport}'s auth/TLS. Uses
     * {@link #DEFAULT_SNIFF_REQUEST_TIMEOUT_MILLIS} as the server-side {@code timeout} query
     * parameter and {@link #DEFAULT_SNIFF_REQUEST_SOCKET_TIMEOUT_MILLIS} as the client-side
     * connect/response timeout.
     */
    public OpenSearchNodesSniffer(OpenSearchTransport transport, String scheme) {
        this(transport, scheme, DEFAULT_SNIFF_REQUEST_TIMEOUT_MILLIS, DEFAULT_SNIFF_REQUEST_SOCKET_TIMEOUT_MILLIS);
    }

    /**
     * Discovery requests reuse {@code transport}'s auth/TLS.
     *
     * @param transport                     the transport to use for the nodes-info request
     * @param scheme                        scheme stamped onto discovered node addresses ({@code null} defaults to {@link #DEFAULT_SCHEME})
     * @param sniffRequestTimeoutMillis     server-side {@code timeout} query parameter sent with the
     *                                      {@code /_nodes/http} request (e.g. {@code "1000ms"})
     * @param sniffRequestSocketTimeoutMillis client-side connect/response timeout acting as a
     *                                      safety-net against a wedged connection
     */
    public OpenSearchNodesSniffer(
        OpenSearchTransport transport,
        String scheme,
        long sniffRequestTimeoutMillis,
        long sniffRequestSocketTimeoutMillis
    ) {
        if (sniffRequestTimeoutMillis <= 0) {
            throw new IllegalArgumentException("sniffRequestTimeoutMillis must be > 0, got " + sniffRequestTimeoutMillis);
        }
        if (sniffRequestSocketTimeoutMillis <= 0) {
            throw new IllegalArgumentException("sniffRequestSocketTimeoutMillis must be > 0, got " + sniffRequestSocketTimeoutMillis);
        }
        this.scheme = (scheme == null) ? DEFAULT_SCHEME : scheme;
        this.sniffRequestTimeoutMillis = sniffRequestTimeoutMillis;
        this.genericClient = new OpenSearchGenericClient(transport, sniffRequestOptions(transport, sniffRequestSocketTimeoutMillis));
    }

    /**
     * Builds per-request {@link ApacheHttpClient5Options} that override only the connect/response
     * timeouts while preserving all other settings (headers, warnings handler, etc.) from the
     * transport's own options.
     */
    private static ApacheHttpClient5Options sniffRequestOptions(OpenSearchTransport transport, long socketTimeoutMillis) {
        TransportOptions base = transport.options();
        if (!(base instanceof ApacheHttpClient5Options)) {
            // The client-side socket timeout is applied via an Apache HttpClient5 RequestConfig, which
            // only a transport backed by ApacheHttpClient5Options (i.e. ApacheHttpClient5Transport) can
            // honor. Fail fast instead of silently dropping the timeout for an incompatible transport.
            throw new IllegalArgumentException(
                "OpenSearchNodesSniffer requires a transport backed by "
                    + ApacheHttpClient5Options.class.getSimpleName()
                    + " (i.e. ApacheHttpClient5Transport); got transport options: "
                    + (base == null ? "null" : base.getClass().getName())
            );
        }
        ApacheHttpClient5Options apacheBase = (ApacheHttpClient5Options) base;
        RequestConfig.Builder rc = (apacheBase.getRequestConfig() != null)
            ? RequestConfig.copy(apacheBase.getRequestConfig())
            : RequestConfig.custom();
        Timeout socketTimeout = Timeout.ofMilliseconds(socketTimeoutMillis);
        rc.setResponseTimeout(socketTimeout);
        rc.setConnectTimeout(socketTimeout);
        return apacheBase.toBuilder().setRequestConfig(rc.build()).build();
    }

    @Override
    public List<Node> sniff() throws IOException {
        try (
            Response response = genericClient.execute(
                Requests.builder()
                    .endpoint(NODES_INFO_ENDPOINT)
                    .method("GET")
                    .query(Collections.singletonMap("timeout", sniffRequestTimeoutMillis + "ms"))
                    .build()
            )
        ) {
            if (response.getStatus() < 200 || response.getStatus() >= 300) {
                throw new IOException("nodes info request failed with status " + response.getStatus());
            }
            try (InputStream body = response.getBody().orElseThrow(() -> new IOException("empty _nodes/http response")).body()) {
                return parseNodes(body, scheme);
            }
        }
    }

    /**
     * Parses a {@code _nodes/http} response body into {@link Node}s. Nodes without an
     * {@code http.publish_address} are skipped. Package-visible + static for unit testing.
     * <p>
     * This is a deliberately lenient hand-rolled parser rather than the typed
     * {@code OpenSearchClient.nodes().info()} model. The generated {@code NodeInfo}/{@code NodeRole}
     * deserializer is all-or-nothing: {@code roles} is required and {@code JsonEnum} throws on any
     * role value it doesn't know, while the server legitimately emits {@code search}, {@code warm},
     * and plugin/setting-defined ({@code UnknownRole}/{@code DynamicRole}) role names — so a single
     * such node would fail the entire sniff and break discovery on those clusters. Discovery must
     * degrade gracefully (skip odd fields per node, keep every reachable node), so we parse by hand
     * here. If the typed enums are made forward-compatible upstream, this can be revisited.
     */
    static List<Node> parseNodes(InputStream content, String scheme) {
        List<Node> nodes = new ArrayList<>();
        JsonObject root;
        try (JsonReader reader = Json.createReader(content)) {
            root = reader.readObject();
        } catch (JsonException e) {
            // Malformed or non-object response body (e.g. truncated body, top-level JSON array).
            // Degrade to no discovered nodes rather than letting an unchecked JsonException escape
            // the declared IOException contract of NodesSniffer.sniff().
            logger.warn("ignoring malformed _nodes/http response: " + e.getMessage());
            return nodes;
        }
        JsonValue nodesValue = root.get("nodes");
        if (nodesValue == null || nodesValue.getValueType() != JsonValue.ValueType.OBJECT) {
            return nodes;
        }
        JsonObject nodesObj = nodesValue.asJsonObject();
        for (Map.Entry<String, JsonValue> entry : nodesObj.entrySet()) {
            try {
                JsonObject nodeInfo = entry.getValue().asJsonObject();
                if (!nodeInfo.containsKey("http")) {
                    continue;
                }
                JsonObject http = nodeInfo.getJsonObject("http");
                JsonValue publishAddress = http.get("publish_address");
                if (publishAddress == null || publishAddress.getValueType() != JsonValue.ValueType.STRING) {
                    continue;
                }
                // The address is what makes a node usable, so parse it first and let a failure
                // here skip the node. Everything below is best-effort metadata: a bad/absent field
                // degrades to null rather than discarding an otherwise-reachable node.
                HttpHost publishHost = createHost(((JsonString) publishAddress).getString(), scheme);

                Set<HttpHost> boundHosts = parseBoundHosts(http, scheme);
                String name = parseOptionalString(nodeInfo, "name");
                String version = parseOptionalString(nodeInfo, "version");
                Node.Roles roles = parseRoles(nodeInfo);
                Map<String, List<String>> attributes = parseAttributes(nodeInfo);

                nodes.add(new Node(publishHost, boundHosts, name, version, roles, attributes));
            } catch (Exception e) {
                // Isolate per-node failures so one malformed node does not discard the whole set.
                logger.warn("skipping malformed node [" + entry.getKey() + "]: " + e.getMessage());
            }
        }
        return nodes;
    }

    /** Best-effort parse of {@code http.bound_address}; returns an empty set on any problem. */
    private static Set<HttpHost> parseBoundHosts(JsonObject http, String scheme) {
        Set<HttpHost> boundHosts = new HashSet<>();
        try {
            if (http.containsKey("bound_address")) {
                for (JsonValue b : http.getJsonArray("bound_address")) {
                    if (b.getValueType() == JsonValue.ValueType.STRING) {
                        boundHosts.add(createHost(((JsonString) b).getString(), scheme));
                    }
                }
            }
        } catch (Exception e) {
            logger.warn("ignoring malformed bound_address: " + e.getMessage());
        }
        return boundHosts;
    }

    /** Returns the string value of {@code key}, or {@code null} if absent or not a JSON string. */
    private static String parseOptionalString(JsonObject nodeInfo, String key) {
        JsonValue value = nodeInfo.get(key);
        if (value == null || value.getValueType() != JsonValue.ValueType.STRING) {
            return null;
        }
        return ((JsonString) value).getString();
    }

    /** Best-effort parse of the {@code roles} array; returns {@code null} on any problem. */
    private static Node.Roles parseRoles(JsonObject nodeInfo) {
        try {
            if (!nodeInfo.containsKey("roles")) {
                return null;
            }
            Set<String> roleSet = new HashSet<>();
            for (JsonValue rv : nodeInfo.getJsonArray("roles")) {
                if (rv.getValueType() == JsonValue.ValueType.STRING) {
                    roleSet.add(((JsonString) rv).getString());
                }
            }
            return new Node.Roles(roleSet);
        } catch (Exception e) {
            logger.warn("ignoring malformed roles: " + e.getMessage());
            return null;
        }
    }

    /** Best-effort parse of string-valued {@code attributes}; returns {@code null} on any problem. */
    private static Map<String, List<String>> parseAttributes(JsonObject nodeInfo) {
        try {
            if (!nodeInfo.containsKey("attributes")) {
                return null;
            }
            Map<String, List<String>> attributes = new TreeMap<>();
            JsonObject attrs = nodeInfo.getJsonObject("attributes");
            for (Map.Entry<String, JsonValue> attr : attrs.entrySet()) {
                if (attr.getValue().getValueType() == JsonValue.ValueType.STRING) {
                    attributes.put(attr.getKey(), Collections.singletonList(((JsonString) attr.getValue()).getString()));
                }
            }
            return attributes;
        } catch (Exception e) {
            logger.warn("ignoring malformed attributes: " + e.getMessage());
            return null;
        }
    }

    /**
     * Parses an OpenSearch published address into an {@link HttpHost}. Handles the
     * {@code hostname/ip:port} form emitted by OpenSearch as well as bare {@code ip:port} and
     * {@code [ipv6]:port}.
     */
    static HttpHost createHost(String address, String scheme) {
        String hostPort = address;
        int slash = hostPort.lastIndexOf('/');
        if (slash >= 0) {
            hostPort = hostPort.substring(slash + 1);
        }

        String host;
        String portStr;
        if (hostPort.startsWith("[")) {
            int close = hostPort.indexOf(']');
            if (close < 0 || close + 2 > hostPort.length() || hostPort.charAt(close + 1) != ':') {
                throw new IllegalStateException("malformed IPv6 publish_address: " + address);
            }
            host = hostPort.substring(1, close);
            portStr = hostPort.substring(close + 2);
        } else {
            int colon = hostPort.lastIndexOf(':');
            if (colon < 0) {
                throw new IllegalStateException("unexpected publish_address, no port: " + address);
            }
            host = hostPort.substring(0, colon);
            portStr = hostPort.substring(colon + 1);
        }
        if (portStr.isEmpty()) {
            throw new IllegalStateException("unexpected publish_address, empty port: " + address);
        }
        int port;
        try {
            port = Integer.parseInt(portStr);
        } catch (NumberFormatException e) {
            throw new IllegalStateException("unexpected publish_address, non-numeric port: " + address);
        }
        return new HttpHost(scheme, host, port);
    }
}
