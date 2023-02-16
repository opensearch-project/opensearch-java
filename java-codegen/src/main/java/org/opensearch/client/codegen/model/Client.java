package org.opensearch.client.codegen.model;

import org.opensearch.client.codegen.utils.Strings;

import java.util.Collection;
import java.util.Map;
import java.util.TreeMap;

public class Client {
    private final String namespace;
    private boolean async;
    private final Map<String, ClientOperation> operations = new TreeMap<>();

    public Client(String namespace) {
        this.namespace = namespace;
    }

    public void addOperation(String id) {
        operations.put(id, new ClientOperation(id));
    }

    public String className() {
        return "OpenSearch" + Strings.toPascalCase(namespace) + (async ? "Async" : "") + "Client";
    }

    public String namespace() {
        return namespace;
    }

    public Collection<ClientOperation> operations() {
        return operations.values();
    }

    public boolean async() {
        return async;
    }

    public void async(boolean async) {
        this.async = async;
    }
}
