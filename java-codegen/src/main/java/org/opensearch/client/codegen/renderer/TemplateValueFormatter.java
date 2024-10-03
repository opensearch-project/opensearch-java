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
import org.opensearch.client.codegen.utils.builder.ObjectBuilderBase;

public final class TemplateValueFormatter implements Mustache.Formatter {
    @Nonnull
    private final Map<Class<?>, Formatter<?>> formatters;

    private TemplateValueFormatter(@Nonnull Builder builder) {
        Objects.requireNonNull(builder, "builder must not be null");
        this.formatters = Objects.requireNonNull(builder.formatters, "formatters must not be null");
    }

    @Override
    @Nonnull
    public CharSequence format(@Nonnull Object value) {
        Objects.requireNonNull(value, "value must not be null");
        return format(value, value.getClass());
    }

    @SuppressWarnings("unchecked")
    @Nonnull
    private <T> CharSequence format(@Nonnull Object value, @Nonnull Class<T> clazz) {
        Objects.requireNonNull(value, "value must not be null");
        Objects.requireNonNull(clazz, "clazz must not be null");
        var formatter = (Formatter<T>) formatters.get(clazz);
        if (formatter != null) return formatter.format((T) value);
        return String.valueOf(value);
    }

    @FunctionalInterface
    public interface Formatter<T> {
        @Nonnull
        CharSequence format(@Nonnull T value);
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder extends ObjectBuilderBase<TemplateValueFormatter, Builder> {
        private final Map<Class<?>, Formatter<?>> formatters = new HashMap<>();

        private Builder() {}

        @Nonnull
        @Override
        protected TemplateValueFormatter construct() {
            return new TemplateValueFormatter(this);
        }

        @Nonnull
        public <T> Builder withFormatter(@Nonnull Class<T> clazz, @Nonnull Formatter<? super T> formatter) {
            Objects.requireNonNull(clazz, "clazz must not be null");
            Objects.requireNonNull(formatter, "formatter must not be null");
            formatters.put(clazz, formatter);
            return this;
        }
    }
}
