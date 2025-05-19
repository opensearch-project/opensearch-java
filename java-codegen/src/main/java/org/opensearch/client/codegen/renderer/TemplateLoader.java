/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.codegen.renderer;

import com.samskivert.mustache.Mustache;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.nio.charset.StandardCharsets;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import javax.annotation.Nonnull;
import org.apache.commons.io.IOUtils;
import org.opensearch.client.codegen.utils.Strings;
import org.opensearch.client.codegen.utils.builder.ObjectBuilderBase;

public final class TemplateLoader implements Mustache.TemplateLoader {
    private static final ConcurrentHashMap<String, String> CACHE = new ConcurrentHashMap<>();
    @Nonnull
    private final String templatesResourceSubPath;

    private TemplateLoader(@Nonnull Builder builder) {
        Objects.requireNonNull(builder, "builder must not be null");
        this.templatesResourceSubPath = Strings.requireNonBlank(
            builder.templatesResourceSubPath,
            "templatesResourceSubPath must not be blank"
        );
    }

    @Nonnull
    @Override
    public Reader getTemplate(@Nonnull String name) throws Exception {
        Strings.requireNonBlank(name, "name must not be blank");
        var path = templatesResourceSubPath + name + ".mustache";

        var contents = CACHE.get(path);

        if (contents == null) {
            try {
                contents = IOUtils.resourceToString(path, StandardCharsets.UTF_8);
                CACHE.put(path, contents);
            } catch (IOException e) {
                throw new Exception("Unable to load template: " + path, e);
            }
        }

        return new StringReader(contents);
    }

    @Nonnull
    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder extends ObjectBuilderBase<TemplateLoader, Builder> {
        private String templatesResourceSubPath;

        private Builder() {}

        @Nonnull
        @Override
        protected TemplateLoader construct() {
            return new TemplateLoader(this);
        }

        @Nonnull
        public Builder withTemplatesResourceSubPath(@Nonnull String templatesResourceSubPath) {
            Strings.requireNonBlank(templatesResourceSubPath, "templatesResourceSubPath must not be blank");
            if (!templatesResourceSubPath.startsWith("/")) {
                throw new IllegalArgumentException("templatesResourceSubPath must be absolute");
            }
            if (!templatesResourceSubPath.endsWith("/")) {
                templatesResourceSubPath += "/";
            }
            this.templatesResourceSubPath = templatesResourceSubPath;
            return this;
        }
    }
}
