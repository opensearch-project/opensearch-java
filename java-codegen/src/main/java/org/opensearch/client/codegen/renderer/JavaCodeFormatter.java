/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.codegen.renderer;

import com.diffplug.spotless.FormatExceptionPolicyStrict;
import com.diffplug.spotless.Formatter;
import com.diffplug.spotless.LineEnding;
import com.diffplug.spotless.Provisioner;
import com.diffplug.spotless.extra.java.EclipseJdtFormatterStep;
import com.diffplug.spotless.generic.EndWithNewlineStep;
import com.diffplug.spotless.generic.TrimTrailingWhitespaceStep;
import com.diffplug.spotless.java.ImportOrderStep;
import com.diffplug.spotless.java.RemoveUnusedImportsStep;
import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.List;
import java.util.Objects;
import javax.annotation.Nonnull;
import org.opensearch.client.codegen.exceptions.JavaFormatterException;
import org.opensearch.client.codegen.utils.MavenArtifactResolver;

public class JavaCodeFormatter implements AutoCloseable {
    private final Formatter formatter;

    private JavaCodeFormatter(@Nonnull Builder builder) {
        Objects.requireNonNull(builder, "builder must not be null");

        Provisioner provisioner = MavenArtifactResolver.createDefault()::resolve;

        var eclipseFormatter = EclipseJdtFormatterStep.createBuilder(provisioner);
        eclipseFormatter.setPreferences(
            List.of(Objects.requireNonNull(builder.eclipseFormatterConfig, "eclipseFormatterConfig must not be null"))
        );

        var steps = List.of(
            ImportOrderStep.forJava().createFrom(),
            RemoveUnusedImportsStep.create(RemoveUnusedImportsStep.defaultFormatter(), provisioner),
            eclipseFormatter.build(),
            TrimTrailingWhitespaceStep.create(),
            EndWithNewlineStep.create()
        );

        this.formatter = Formatter.builder()
            .name("java")
            .lineEndingsPolicy(LineEnding.UNIX.createPolicy())
            .encoding(StandardCharsets.UTF_8)
            .rootDir(Objects.requireNonNull(builder.rootDir, "rootDir must not be null"))
            .steps(steps)
            .exceptionPolicy(new FormatExceptionPolicyStrict())
            .build();
    }

    public void format(File file) throws JavaFormatterException {
        try {
            formatter.applyTo(file);
        } catch (Throwable e) {
            throw new JavaFormatterException("Failed to format: " + file, e);
        }
    }

    @Override
    public void close() {
        formatter.close();
    }

    @Nonnull
    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private Path rootDir;
        private File eclipseFormatterConfig;

        @Nonnull
        public Builder withRootDir(@Nonnull Path rootDir) {
            this.rootDir = Objects.requireNonNull(rootDir, "rootDir must not be null");
            return this;
        }

        @Nonnull
        public Builder withEclipseFormatterConfig(@Nonnull File eclipseFormatterConfig) {
            this.eclipseFormatterConfig = Objects.requireNonNull(eclipseFormatterConfig, "eclipseFormatterConfig must not be null");
            return this;
        }

        @Nonnull
        public JavaCodeFormatter build() {
            return new JavaCodeFormatter(this);
        }
    }
}
