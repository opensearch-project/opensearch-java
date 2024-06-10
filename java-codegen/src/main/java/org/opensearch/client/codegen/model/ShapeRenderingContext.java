/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.codegen.model;

import java.io.File;
import java.util.Objects;
import java.util.function.Function;
import javax.annotation.Nonnull;
import org.opensearch.client.codegen.renderer.JavaCodeFormatter;
import org.opensearch.client.codegen.renderer.TemplateLoader;
import org.opensearch.client.codegen.renderer.TemplateRenderer;
import org.opensearch.client.codegen.renderer.TemplateValueFormatter;
import org.opensearch.client.codegen.utils.Strings;

public final class ShapeRenderingContext implements AutoCloseable {
    @Nonnull
    private final File outputDir;
    @Nonnull
    private final TemplateLoader templateLoader;
    @Nonnull
    private final JavaCodeFormatter javaCodeFormatter;
    private final boolean ownedJavaCodeFormatter;

    private ShapeRenderingContext(Builder builder) {
        this.outputDir = Objects.requireNonNull(builder.outputDir, "outputDir must not be null");
        this.templateLoader = Objects.requireNonNull(builder.templateLoader, "templateLoader must not be null");
        this.javaCodeFormatter = Objects.requireNonNull(builder.javaCodeFormatter, "javaCodeFormatter must not be null");
        this.ownedJavaCodeFormatter = builder.ownedJavaCodeFormatter;
    }

    @Nonnull
    public ShapeRenderingContext forSubDir(@Nonnull String name) {
        return builder()
                .withOutputDir(new File(outputDir, Strings.requireNonBlank(name, "name must not be null")))
                .withTemplateLoader(templateLoader)
                .withJavaCodeFormatter(javaCodeFormatter)
                .build();
    }

    @Nonnull
    public File getOutputFile(@Nonnull String name) {
        outputDir.mkdirs();
        return new File(outputDir, Strings.requireNonBlank(name, "name must not be blank"));
    }

    @Nonnull
    public TemplateRenderer getTemplateRenderer(@Nonnull Function<TemplateValueFormatter.Builder, TemplateValueFormatter.Builder> valueFormatterConfigurator) {
        return TemplateRenderer.builder()
                .withValueFormatter(valueFormatterConfigurator)
                .withTemplateLoader(templateLoader)
                .withJavaCodeFormatter(javaCodeFormatter)
                .build();
    }

    @Override
    public void close() throws Exception {
        if (ownedJavaCodeFormatter) {
            javaCodeFormatter.close();
        }
    }

    @Nonnull
    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private File outputDir;
        private TemplateLoader templateLoader;
        private JavaCodeFormatter javaCodeFormatter;
        private boolean ownedJavaCodeFormatter;

        @Nonnull
        public Builder withOutputDir(@Nonnull File outputDir) {
            this.outputDir = Objects.requireNonNull(outputDir, "outputDir must not be null");
            return this;
        }

        @Nonnull
        public Builder withTemplateLoader(@Nonnull TemplateLoader templateLoader) {
            this.templateLoader = Objects.requireNonNull(templateLoader, "templateLoader must not be null");
            return this;
        }

        @Nonnull
        public Builder withTemplateLoader(@Nonnull Function<TemplateLoader.Builder, TemplateLoader.Builder> configurator) {
            return withTemplateLoader(Objects.requireNonNull(configurator, "configurator must not be null").apply(TemplateLoader.builder()).build());
        }

        @Nonnull
        public Builder withJavaCodeFormatter(@Nonnull JavaCodeFormatter javaCodeFormatter, boolean owned) {
            if (this.ownedJavaCodeFormatter && this.javaCodeFormatter != null) {
                this.javaCodeFormatter.close();
            }
            this.javaCodeFormatter = Objects.requireNonNull(javaCodeFormatter, "javaCodeFormatter must not be null");
            this.ownedJavaCodeFormatter = owned;
            return this;
        }

        @Nonnull
        public Builder withJavaCodeFormatter(@Nonnull JavaCodeFormatter javaCodeFormatter) {
            return withJavaCodeFormatter(javaCodeFormatter, false);
        }

        @Nonnull
        public Builder withJavaCodeFormatter(@Nonnull Function<JavaCodeFormatter.Builder, JavaCodeFormatter.Builder> configurator) {
            return withJavaCodeFormatter(Objects.requireNonNull(configurator, "configurator must not be null").apply(JavaCodeFormatter.builder()).build(), true);
        }

        @Nonnull
        public ShapeRenderingContext build() {
            return new ShapeRenderingContext(this);
        }
    }
}
