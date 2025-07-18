/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.codegen.openapi;

import static org.opensearch.client.codegen.utils.Functional.ifNonnull;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.parser.OpenAPIV3Parser;
import io.swagger.v3.parser.core.models.ParseOptions;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.opensearch.client.codegen.exceptions.ApiSpecificationParseException;
import org.opensearch.client.codegen.utils.Clone;
import org.opensearch.client.codegen.utils.Maps;
import org.opensearch.client.codegen.utils.builder.ObjectBuilderBase;
import org.opensearch.client.codegen.utils.builder.ToBuilder;
import org.opensearch.client.codegen.utils.json.JsonGenerator;

public final class OpenApiSpecification extends OpenApiElement<OpenApiSpecification> implements ToBuilder<OpenApiSpecification.Builder> {
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
    private final URI location;
    @Nullable
    private Map<String, OpenApiPath> paths;
    @Nullable
    private OpenApiComponents components;
    @Nonnull
    private final Map<OpenApiElement<?>, JsonPointer> elementPointerLookup = new HashMap<>();
    @Nonnull
    private final Map<JsonPointer, OpenApiElement<?>> pointerElementLookup = new HashMap<>();

    private OpenApiSpecification(@Nonnull Builder builder) {
        super();
        this.location = Objects.requireNonNull(builder.location, "location must not be null");
        setPaths(builder.paths);
        setComponents(builder.components);
    }

    private OpenApiSpecification(@Nonnull URI location, @Nonnull OpenAPI openApi) {
        super();
        this.location = Objects.requireNonNull(location, "location must not be null");
        Objects.requireNonNull(openApi, "openAPI must not be null");
        setPaths(children(openApi.getPaths(), OpenApiPath::new));
        setComponents(ifNonnull(openApi.getComponents(), OpenApiComponents::new));
    }

    @Override
    Optional<OpenApiSpecification> getSpecification() {
        return Optional.of(this);
    }

    @Override
    void initialize(@Nullable OpenApiElement<?> parent, @Nonnull JsonPointer pointer) {
        super.initialize(parent, pointer);
        initializeChildren("paths", paths);
        initializeChild("components", components);
    }

    void registerElement(@Nonnull OpenApiElement<?> element) {
        removeElement(element);
        var currPointer = element.getPointer();
        elementPointerLookup.put(element, currPointer);
        pointerElementLookup.put(currPointer, element);
    }

    void removeElement(@Nonnull OpenApiElement<?> element) {
        var ptr = elementPointerLookup.remove(element);
        if (ptr != null) {
            pointerElementLookup.remove(ptr);
        }
    }

    public Optional<OpenApiElement<?>> getElement(@Nonnull JsonPointer pointer) {
        return Optional.ofNullable(pointerElementLookup.get(pointer));
    }

    @Nonnull
    public Optional<Map<String, OpenApiPath>> getPaths() {
        return Maps.unmodifiableOpt(paths);
    }

    public void setPaths(@Nullable Map<String, OpenApiPath> paths) {
        this.paths = paths;
        initializeChildren("paths", paths);
    }

    @Nonnull
    public Optional<OpenApiComponents> getComponents() {
        return Optional.ofNullable(components);
    }

    public void setComponents(@Nullable OpenApiComponents components) {
        this.components = components;
        initializeChild("components", components);
    }

    @Nonnull
    public URI getLocation() {
        return location;
    }

    @Override
    protected void toJsonInner(JsonGenerator generator) {
        if (paths != null) {
            generator.writeField("paths", paths);
        }
        if (components != null) {
            generator.writeField("components", components);
        }
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

    @Override
    public @Nonnull OpenApiSpecification clone() {
        return toBuilder().build();
    }

    @Override
    public @Nonnull Builder toBuilder() {
        return builder().withLocation(location)
            .withPaths(ifNonnull(paths, Clone::clone))
            .withComponents(ifNonnull(components, Clone::clone));
    }

    public static @Nonnull Builder builder() {
        return new Builder();
    }

    public static final class Builder extends ObjectBuilderBase<OpenApiSpecification, Builder> {
        private URI location;
        @Nullable
        private Map<String, OpenApiPath> paths;
        @Nullable
        private OpenApiComponents components;

        private Builder() {}

        @Nonnull
        @Override
        protected OpenApiSpecification construct() {
            return new OpenApiSpecification(this);
        }

        public @Nonnull Builder withLocation(@Nonnull URI location) {
            this.location = Objects.requireNonNull(location, "location must not be null");
            return this;
        }

        public @Nonnull Builder withPaths(@Nullable Map<String, OpenApiPath> paths) {
            this.paths = paths;
            return this;
        }

        public @Nonnull Builder withComponents(@Nullable OpenApiComponents components) {
            this.components = components;
            return this;
        }
    }
}
