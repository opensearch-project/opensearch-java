/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.codegen.model;

import org.opensearch.client.codegen.utils.Strings;

import java.util.Collection;
import java.util.Map;
import java.util.TreeMap;

public class Client extends Shape {
    private final boolean async;
    private final Map<String, ClientOperation> operations = new TreeMap<>();

    public Client(String namespace) {
        this(namespace, false);
    }

    private Client(String namespace, boolean async) {
        super(namespace, "OpenSearch" + Strings.toPascalCase(namespace) + (async ? "Async" : "") + "Client");
        this.async = async;
    }

    public void addOperation(String id) {
        operations.put(id, new ClientOperation(id));
    }

    public Collection<ClientOperation> operations() {
        return operations.values();
    }

    public boolean async() {
        return async;
    }

    public Client async(boolean async) {
        if (async == this.async) return this;
        Client client = new Client(namespace, async);
        operations.keySet().forEach(client::addOperation);
        return client;
    }
}
