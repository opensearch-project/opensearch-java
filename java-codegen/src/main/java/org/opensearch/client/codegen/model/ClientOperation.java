package org.opensearch.client.codegen.model;

import org.opensearch.client.codegen.utils.Strings;

public class ClientOperation {
    private final String id;

    public ClientOperation(String id) {
        this.id = id;
    }

    public String name() {
        return Strings.toCamelCase(id);
    }

    public String requestType() {
        return Strings.toPascalCase(id) + "Request";
    }

    public String responseType() {
        return Strings.toPascalCase(id) + "Response";
    }
}
