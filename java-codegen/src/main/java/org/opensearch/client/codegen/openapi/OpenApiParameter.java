/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.codegen.openapi;

import static org.opensearch.client.codegen.utils.Functional.ifNonnull;

import io.swagger.v3.oas.models.parameters.Parameter;
import java.util.Optional;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.opensearch.client.codegen.model.Deprecation;
import org.opensearch.client.codegen.utils.Maps;

public class OpenApiParameter extends OpenApiRefElement<OpenApiParameter> {
    @Nullable
    private final String name;
    @Nullable
    private final String description;
    @Nullable
    private final In in;
    @Nullable
    private final Boolean isRequired;
    @Nullable
    private final OpenApiSchema schema;
    @Nullable
    private final Boolean isDeprecated;
    @Nullable
    private final String versionDeprecated;
    @Nullable
    private final String deprecationMessage;
    @Nullable
    private final Boolean isGlobal;

    protected OpenApiParameter(@Nullable OpenApiElement<?> parent, @Nonnull JsonPointer pointer, @Nonnull Parameter parameter) {
        super(parent, pointer, parameter.get$ref(), OpenApiParameter.class);
        this.name = parameter.getName();
        this.description = parameter.getDescription();
        this.in = ifNonnull(parameter.getIn(), In::from);
        this.isRequired = parameter.getRequired();
        this.schema = child("schema", parameter.getSchema(), OpenApiSchema::new);
        this.isDeprecated = parameter.getDeprecated();
        var extensions = parameter.getExtensions();
        this.versionDeprecated = Maps.tryGet(extensions, "x-version-deprecated").map(String::valueOf).orElse(null);
        this.deprecationMessage = Maps.tryGet(extensions, "x-deprecation-message").map(String::valueOf).orElse(null);
        this.isGlobal = (Boolean) Maps.tryGet(extensions, "x-global").orElse(null);
    }

    @Nonnull
    public Optional<String> getName() {
        return Optional.ofNullable(name);
    }

    @Nonnull
    public Optional<String> getDescription() {
        return Optional.ofNullable(description);
    }

    @Nonnull
    public Optional<In> getIn() {
        return Optional.ofNullable(in);
    }

    public boolean getRequired() {
        return isRequired != null && isRequired;
    }

    @Nonnull
    public Optional<OpenApiSchema> getSchema() {
        return Optional.ofNullable(schema);
    }

    public boolean isGlobal() {
        return isGlobal != null && isGlobal;
    }

    public boolean isDeprecated() {
        return isDeprecated != null && isDeprecated;
    }

    @Nonnull
    public Optional<Deprecation> getDeprecation() {
        if (versionDeprecated == null && deprecationMessage == null) return Optional.empty();
        return Optional.of(new Deprecation(deprecationMessage, versionDeprecated));
    }
}
