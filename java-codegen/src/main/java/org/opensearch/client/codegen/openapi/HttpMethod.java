package org.opensearch.client.codegen.openapi;

import io.swagger.v3.oas.models.PathItem;
import java.util.Map;
import java.util.Objects;
import javax.annotation.Nonnull;
import org.opensearch.client.codegen.utils.Maps;
import org.opensearch.client.codegen.utils.Strings;

public enum HttpMethod {
    Post,
    Get,
    Put,
    Patch,
    Delete,
    Head,
    Options,
    Trace;

    private static final Map<String, HttpMethod> VALUES = Maps.createLookupOf(values(), HttpMethod::toString);

    @Nonnull
    public static HttpMethod from(@Nonnull String httpMethod) {
        var value = VALUES.get(Strings.requireNonBlank(httpMethod, "value must not be blank"));
        if (value == null) {
            throw new IllegalArgumentException("Unknown HTTP method: " + httpMethod);
        }
        return value;
    }

    @Nonnull
    public static HttpMethod from(@Nonnull PathItem.HttpMethod httpMethod) {
        Objects.requireNonNull(httpMethod, "httpMethod must not be null");
        return from(httpMethod.name().toLowerCase());
    }

    @Override
    public String toString() {
        return name().toLowerCase();
    }
}
