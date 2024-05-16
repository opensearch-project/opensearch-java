package org.opensearch.client.codegen.openapi;

import io.swagger.v3.oas.models.PathItem;
import java.util.Objects;
import javax.annotation.Nonnull;
import org.opensearch.client.codegen.utils.Strings;

public enum HttpMethod {
    POST,
    GET,
    PUT,
    PATCH,
    DELETE,
    HEAD,
    OPTIONS,
    TRACE;

    @Nonnull
    public static HttpMethod from(@Nonnull String value) {
        Strings.requireNonBlank(value, "value must not be blank");
        return HttpMethod.valueOf(value.toUpperCase());
    }

    @Nonnull
    public static HttpMethod from(@Nonnull PathItem.HttpMethod value) {
        Objects.requireNonNull(value, "value must not be null");
        return HttpMethod.valueOf(value.name());
    }
}
