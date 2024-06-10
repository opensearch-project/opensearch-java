/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.codegen.renderer;

import com.samskivert.mustache.Mustache;
import com.samskivert.mustache.MustacheException;
import com.samskivert.mustache.Template;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import javax.annotation.Nonnull;
import org.opensearch.client.codegen.exceptions.JavaFormatterException;
import org.opensearch.client.codegen.exceptions.RenderException;
import org.opensearch.client.codegen.model.Shape;

public final class TemplateRenderer {
    @Nonnull
    private final Mustache.Compiler compiler;
    @Nonnull
    private final TemplateGlobalContext context;
    @Nonnull
    private final JavaCodeFormatter javaCodeFormatter;
    @Nonnull
    private final ConcurrentHashMap<String, Template> templateCache = new ConcurrentHashMap<>();

    private TemplateRenderer(@Nonnull Builder builder) {
        Objects.requireNonNull(builder, "builder must not be null");
        this.compiler = Mustache.compiler()
            .escapeHTML(false)
            .withLoader(Objects.requireNonNull(builder.templateLoader, "templateLoader must not be null"))
            .withFormatter(Objects.requireNonNull(builder.valueFormatter, "valueFormatter must not be null"));
        this.context = TemplateGlobalContext.builder().withRenderer(this).build();
        this.javaCodeFormatter = Objects.requireNonNull(builder.javaCodeFormatter, "javaCodeFormatter must not be null");
    }

    public void render(String templateName, Object context, Writer out) throws RenderException {
        try {
            templateCache.computeIfAbsent(templateName, compiler::loadTemplate).execute(context, this.context, out);
        } catch (MustacheException e) {
            throw new RenderException("Failed to render: " + context, e);
        }
    }

    public String render(String templateName, Object context) throws RenderException {
        var out = new StringWriter();
        render(templateName, context, out);
        return out.toString();
    }

    public void renderJava(Shape shape, File outputFile) throws RenderException {
        var classBody = render(shape.getClass().getSimpleName(), shape);
        var classHeader = render("Partials/ClassHeader", shape);

        try (Writer fileWriter = new FileWriter(outputFile)) {
            fileWriter.write(classHeader);
            fileWriter.write("\n\n");
            fileWriter.write(classBody);
        } catch (IOException e) {
            throw new RenderException("Unable to write rendered output to: " + outputFile, e);
        }

        try {
            javaCodeFormatter.format(outputFile);
        } catch (JavaFormatterException e) {
            throw new RenderException("Unable to format rendered output: " + outputFile, e);
        }
    }

    @Nonnull
    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private TemplateValueFormatter valueFormatter;
        private TemplateLoader templateLoader;
        private JavaCodeFormatter javaCodeFormatter;

        @Nonnull
        public Builder withValueFormatter(@Nonnull Function<TemplateValueFormatter.Builder, TemplateValueFormatter.Builder> configurator) {
            this.valueFormatter = Objects.requireNonNull(configurator, "configurator must not be null")
                .apply(TemplateValueFormatter.builder())
                .build();
            return this;
        }

        @Nonnull
        public Builder withTemplateLoader(@Nonnull TemplateLoader templateLoader) {
            this.templateLoader = Objects.requireNonNull(templateLoader, "templateLoader must not be null");
            return this;
        }

        @Nonnull
        public Builder withJavaCodeFormatter(@Nonnull JavaCodeFormatter javaCodeFormatter) {
            this.javaCodeFormatter = Objects.requireNonNull(javaCodeFormatter, "javaCodeFormatter must not be null");
            return this;
        }

        @Nonnull
        public TemplateRenderer build() {
            return new TemplateRenderer(this);
        }
    }
}
