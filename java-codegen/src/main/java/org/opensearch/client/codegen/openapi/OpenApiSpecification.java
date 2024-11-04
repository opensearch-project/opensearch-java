/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.codegen.openapi;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.parser.OpenAPIV3Parser;
import io.swagger.v3.parser.core.models.ParseOptions;
import java.net.URI;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.opensearch.client.codegen.exceptions.ApiSpecificationParseException;
import org.opensearch.client.codegen.utils.Maps;

public class OpenApiSpecification extends OpenApiElement<OpenApiSpecification> {
    private static final Logger LOGGER = LogManager.getLogger();
    private static final ParseOptions PARSE_OPTIONS = new ParseOptions();
    private static final OpenAPIV3Parser PARSER = new OpenAPIV3Parser();
    private static final Map<URI, OpenApiSpecification> SPECS = new HashMap<>();

    public static OpenApiSpecification retrieve(URI location) {
        if (SPECS.containsKey(location)) {
            return SPECS.get(location);
        }
        LOGGER.info("Parsing spec: {}", location);
        var result = PARSER.readLocation(location.toString(), null, PARSE_OPTIONS);
        var openApi = result.getOpenAPI();
        if (openApi == null) {
            throw new ApiSpecificationParseException("Unable to parse spec: " + location, result.getMessages());
        }
        var spec = new OpenApiSpecification(location, openApi);
        SPECS.put(location, spec);
        return spec;
    }

    @Nonnull
    private final Set<JsonPointer> cachedElements = new HashSet<>();
    @Nonnull
    private final Map<Class<?>, Map<JsonPointer, OpenApiElement<?>>> elementCache = new HashMap<>();
    @Nonnull
    private final URI location;
    @Nullable
    private final Map<String, OpenApiPath> paths;
    @Nullable
    private final OpenApiComponents components;

    private OpenApiSpecification(@Nonnull URI location, @Nonnull OpenAPI openApi) {
        super(null, JsonPointer.ROOT);
        this.location = Objects.requireNonNull(location, "location must not be null");
        Objects.requireNonNull(openApi, "openAPI must not be null");
        this.paths = children("paths", openApi.getPaths(), OpenApiPath::new);
        this.components = child("components", openApi.getComponents(), OpenApiComponents::new);
    }

    @Nonnull
    @Override
    protected Optional<OpenApiSpecification> getSpecification() {
        return Optional.of(this);
    }

    <T extends OpenApiElement<T>> void addElement(@Nonnull JsonPointer pointer, @Nonnull T component) {
        Objects.requireNonNull(pointer, "pointer must not be null");
        Objects.requireNonNull(component, "component must not be null");
        if (!cachedElements.add(pointer)) {
            throw new IllegalStateException("Component with pointer `" + pointer + "` has already been registered");
        }
        elementCache.computeIfAbsent(component.getClass(), k -> new HashMap<>()).put(pointer, component);
    }

    @Nonnull
    public <T extends OpenApiElement<T>> T getElement(@Nonnull JsonPointer pointer, @Nonnull Class<T> type) {
        Objects.requireNonNull(pointer, "pointer must not be null");
        Objects.requireNonNull(type, "type must not be null");
        return Optional.ofNullable(elementCache.get(type))
            .flatMap(m -> Optional.ofNullable(m.get(pointer)))
            .map(type::cast)
            .orElseThrow(() -> new IllegalStateException("Unable to resolve component of type `" + type + "` with pointer: " + pointer));
    }

    @Nonnull
    public Optional<Map<String, OpenApiPath>> getPaths() {
        return Maps.unmodifiableOpt(paths);
    }

    @Nonnull
    public Optional<OpenApiComponents> getComponents() {
        return Optional.ofNullable(components);
    }

    @Nonnull
    public URI getLocation() {
        return location;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        OpenApiSpecification that = (OpenApiSpecification) o;

        return new EqualsBuilder().appendSuper(super.equals(o)).append(location, that.location).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).appendSuper(super.hashCode()).append(location).toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("location", location).toString();
    }
}
