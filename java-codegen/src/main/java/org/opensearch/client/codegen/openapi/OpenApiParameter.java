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
import java.util.Set;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.opensearch.client.codegen.model.Deprecation;
import org.opensearch.client.codegen.utils.Clone;
import org.opensearch.client.codegen.utils.Maps;
import org.opensearch.client.codegen.utils.Versions;
import org.opensearch.client.codegen.utils.builder.ToBuilder;
import org.opensearch.client.codegen.utils.json.JsonGenerator;
import org.semver4j.Semver;

public final class OpenApiParameter extends OpenApiRefElement<OpenApiParameter> implements ToBuilder<OpenApiParameter.Builder> {
    @Nullable
    private final String name;
    @Nullable
    private final String description;
    @Nullable
    private final In in;
    @Nullable
    private final Boolean isRequired;
    @Nullable
    private OpenApiSchema schema;
    @Nullable
    private final Boolean isDeprecated;
    @Nullable
    private final Semver versionDeprecated;
    @Nullable
    private final String deprecationMessage;
    @Nullable
    private final Boolean isGlobal;

    private OpenApiParameter(@Nonnull Builder builder) {
        super(builder, OpenApiParameter.class);
        this.name = builder.name;
        this.description = builder.description;
        this.in = builder.in;
        this.isRequired = builder.isRequired;
        setSchema(builder.schema);
        this.isDeprecated = builder.isDeprecated;
        this.versionDeprecated = builder.versionDeprecated;
        this.deprecationMessage = builder.deprecationMessage;
        this.isGlobal = builder.isGlobal;
    }

    OpenApiParameter(@Nonnull Parameter parameter) {
        super(parameter.get$ref(), OpenApiParameter.class);
        this.name = parameter.getName();
        this.description = parameter.getDescription();
        this.in = ifNonnull(parameter.getIn(), In::from);
        this.isRequired = parameter.getRequired();
        setSchema(ifNonnull(parameter.getSchema(), OpenApiSchema::new));
        this.isDeprecated = parameter.getDeprecated();
        var extensions = parameter.getExtensions();
        this.versionDeprecated = Maps.tryGet(extensions, "x-version-deprecated").map(v -> Versions.coerce((String) v)).orElse(null);
        this.deprecationMessage = Maps.tryGet(extensions, "x-deprecation-message").map(String::valueOf).orElse(null);
        this.isGlobal = (Boolean) Maps.tryGet(extensions, "x-global").orElse(null);
    }

    @Override
    void initialize(@Nullable OpenApiElement<?> parent, @Nonnull JsonPointer pointer) {
        super.initialize(parent, pointer);
        initializeChild("schema", schema);
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
    public Optional<String> getResolvedDescription() {
        if (description != null) {
            return Optional.of(description);
        }
        if (has$ref()) {
            return resolve().getResolvedDescription();
        }
        if (schema != null) {
            return schema.getResolvedDescription();
        }
        return Optional.empty();
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

    public void setSchema(@Nullable OpenApiSchema schema) {
        this.schema = schema;
        initializeChild("schema", schema);
    }

    public boolean isGlobal() {
        return isGlobal != null && isGlobal;
    }

    public boolean isDeprecated() {
        return isDeprecated != null && isDeprecated;
    }

    @Nonnull
    public Optional<Deprecation> getDeprecation() {
        if (versionDeprecated == null) return Optional.empty();
        return Optional.of(new Deprecation(deprecationMessage, versionDeprecated));
    }

    public boolean isOverloaded() {
        return schema != null && schema.hasAnyOf() && schema.getAnyOf().orElseThrow().stream().allMatch(OpenApiSchema::hasTitle);
    }

    private static final Set<String> GLOBAL_CAT_PARAMETERS = Set.of("format", "h", "help", "local", "s", "v");

    public boolean isGlobalCatParameter() {
        return GLOBAL_CAT_PARAMETERS.contains(name);
    }

    @Override
    protected void toJsonInner(JsonGenerator generator) {
        super.toJsonInner(generator);
        if (name != null) {
            generator.writeField("name", name);
        }
        if (description != null) {
            generator.writeField("description", description);
        }
        if (in != null) {
            generator.writeField("in", in.toString());
        }
        if (isRequired != null) {
            generator.writeField("required", isRequired);
        }
        if (schema != null) {
            generator.writeField("schema", schema);
        }
        if (isDeprecated != null) {
            generator.writeField("deprecated", isDeprecated);
        }
        if (versionDeprecated != null) {
            generator.writeField("x-version-deprecated", versionDeprecated.toString());
        }
        if (deprecationMessage != null) {
            generator.writeField("x-deprecation-message", deprecationMessage);
        }
        if (isGlobal != null) {
            generator.writeField("x-global", isGlobal);
        }
    }

    @Override
    public @Nonnull OpenApiParameter clone() {
        return toBuilder().build();
    }

    @Override
    public @Nonnull Builder toBuilder() {
        return super.toBuilder(builder()).withName(name)
            .withDescription(description)
            .withIn(in)
            .withRequired(isRequired)
            .withSchema(ifNonnull(schema, Clone::clone))
            .withDeprecated(isDeprecated)
            .withVersionDeprecated(versionDeprecated)
            .withDeprecationMessage(deprecationMessage)
            .withGlobal(isGlobal);
    }

    public static @Nonnull Builder builder() {
        return new Builder();
    }

    public static final class Builder extends OpenApiRefElement.AbstractBuilder<OpenApiParameter, Builder> {
        @Nullable
        private String name;
        @Nullable
        private String description;
        @Nullable
        private In in;
        @Nullable
        private Boolean isRequired;
        @Nullable
        private OpenApiSchema schema;
        @Nullable
        private Boolean isDeprecated;
        @Nullable
        private Semver versionDeprecated;
        @Nullable
        private String deprecationMessage;
        @Nullable
        private Boolean isGlobal;

        private Builder() {}

        @Nonnull
        @Override
        protected OpenApiParameter construct() {
            return new OpenApiParameter(this);
        }

        public @Nonnull Builder withName(@Nullable String name) {
            this.name = name;
            return this;
        }

        public @Nonnull Builder withDescription(@Nullable String description) {
            this.description = description;
            return this;
        }

        public @Nonnull Builder withIn(@Nullable In in) {
            this.in = in;
            return this;
        }

        public @Nonnull Builder withRequired(@Nullable Boolean isRequired) {
            this.isRequired = isRequired;
            return this;
        }

        public @Nonnull Builder withSchema(@Nullable OpenApiSchema schema) {
            this.schema = schema;
            return this;
        }

        public @Nonnull Builder withDeprecated(@Nullable Boolean isDeprecated) {
            this.isDeprecated = isDeprecated;
            return this;
        }

        public @Nonnull Builder withVersionDeprecated(@Nullable Semver versionDeprecated) {
            this.versionDeprecated = versionDeprecated;
            return this;
        }

        public @Nonnull Builder withDeprecationMessage(@Nullable String deprecationMessage) {
            this.deprecationMessage = deprecationMessage;
            return this;
        }

        public @Nonnull Builder withGlobal(@Nullable Boolean isGlobal) {
            this.isGlobal = isGlobal;
            return this;
        }
    }
}
