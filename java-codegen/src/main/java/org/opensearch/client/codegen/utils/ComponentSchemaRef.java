package org.opensearch.client.codegen.utils;

import static org.opensearch.client.codegen.utils.OpenApiKeywords.REF_LOCAL_COMPONENTS_SCHEMAS_PREFIX;

public class ComponentSchemaRef {
    private final String namespace;
    private final String name;

    public static ComponentSchemaRef from(String $ref) {
        if (!$ref.startsWith(REF_LOCAL_COMPONENTS_SCHEMAS_PREFIX)) {
            throw new IllegalArgumentException("Non-relative reference: " + $ref);
        }

        var parts = $ref.split("/");
        var schemaName = parts[parts.length - 1];
        var colonIdx = schemaName.indexOf(':');
        var ns = colonIdx >= 0 ? schemaName.substring(0, colonIdx) : "";
        var name = colonIdx >= 0 ? schemaName.substring(colonIdx + 1) : schemaName;
        return new ComponentSchemaRef(ns, name);
    }

    private ComponentSchemaRef(String namespace, String name) {
        this.namespace = namespace;
        this.name = name;
    }

    public String namespace() {
        return namespace;
    }

    public String name() {
        return name;
    }
}
