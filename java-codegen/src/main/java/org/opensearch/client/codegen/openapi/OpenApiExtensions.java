package org.opensearch.client.codegen.openapi;

import java.util.Map;
import java.util.Optional;

public interface OpenApiExtensions {
    Map<String, Object> getExtensions();

    default Optional<Object> getExtension(String name) {
        Map<String, Object> extensions = getExtensions();
        if (extensions == null) return Optional.empty();
        return Optional.ofNullable(extensions.get(name));
    }

    default Optional<String> getExtensionAsString(String name) {
        return getExtension(name).map(String.class::cast);
    }
}
