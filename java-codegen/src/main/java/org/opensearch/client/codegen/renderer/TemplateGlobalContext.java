/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.codegen.renderer;

import com.samskivert.mustache.Mustache;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.apache.commons.text.StringEscapeUtils;
import org.opensearch.client.codegen.model.Types;
import org.opensearch.client.codegen.renderer.lambdas.TemplateStringLambda;
import org.opensearch.client.codegen.utils.ObjectBuilderBase;
import org.opensearch.client.codegen.utils.Strings;

public final class TemplateGlobalContext implements Mustache.CustomContext {
    @Nonnull
    private final Map<String, Object> values;
    @Nonnull
    private final TemplateRenderer renderer;

    private TemplateGlobalContext(@Nonnull Builder builder) {
        Objects.requireNonNull(builder, "builder must not be null");
        this.values = Objects.requireNonNull(builder.values, "values must not be null");
        this.renderer = Objects.requireNonNull(builder.renderer, "renderer must not be null");
    }

    @Override
    @Nullable
    public Object get(@Nonnull String name) throws Exception {
        return values.get(Strings.requireNonBlank(name, "name must not be blank"));
    }

    @Nonnull
    public TemplateRenderer getRenderer() {
        return renderer;
    }

    public static Builder builder() {
        return new Builder().withLambda("quoted", s -> '\"' + StringEscapeUtils.escapeJava(s) + '\"')
            .withLambda("camelCase", Strings::toCamelCase)
            .withLambda("pascalCase", Strings::toPascalCase)
            .withLambda("toLower", s -> s.toLowerCase())
            .withLambda("ERROR", s -> {
                throw new RuntimeException(s);
            })
            .withValue("TYPES", Types.TYPES_MAP);
    }

    public static final class Builder extends ObjectBuilderBase<TemplateGlobalContext, Builder> {
        private final Map<String, Object> values = new HashMap<>();
        private TemplateRenderer renderer;

        private Builder() {}

        @Nonnull
        @Override
        protected TemplateGlobalContext construct() {
            return new TemplateGlobalContext(this);
        }

        @Nonnull
        public Builder withLambda(@Nonnull String name, @Nonnull TemplateStringLambda lambda) {
            return withLambda(name, TemplateStringLambda.asMustacheLambda(lambda));
        }

        @Nonnull
        public Builder withLambda(@Nonnull String name, @Nonnull Mustache.Lambda lambda) {
            return withValue(name, lambda);
        }

        @Nonnull
        public Builder withValue(@Nonnull String name, @Nonnull Object value) {
            Objects.requireNonNull(name, "name must not be null");
            Objects.requireNonNull(value, "value must not be null");
            values.put(name, value);
            return this;
        }

        @Nonnull
        public Builder withRenderer(@Nonnull TemplateRenderer renderer) {
            this.renderer = Objects.requireNonNull(renderer, "renderer must not be null");
            return this;
        }
    }
}
