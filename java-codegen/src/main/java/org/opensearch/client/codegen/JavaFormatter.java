/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.codegen;

import com.diffplug.spotless.FormatExceptionPolicyStrict;
import com.diffplug.spotless.Formatter;
import com.diffplug.spotless.FormatterStep;
import com.diffplug.spotless.LineEnding;
import com.diffplug.spotless.Provisioner;
import com.diffplug.spotless.extra.java.EclipseJdtFormatterStep;
import com.diffplug.spotless.generic.EndWithNewlineStep;
import com.diffplug.spotless.generic.TrimTrailingWhitespaceStep;
import com.diffplug.spotless.java.ImportOrderStep;
import com.diffplug.spotless.java.RemoveUnusedImportsStep;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.List;
import java.util.Objects;
import org.opensearch.client.codegen.exceptions.JavaFormatterException;
import org.opensearch.client.codegen.utils.MavenArtifactResolver;

public class JavaFormatter implements AutoCloseable {
    private final Formatter formatter;

    public JavaFormatter(Path rootDir, File eclipseFormatterConfig) {
        Objects.requireNonNull(rootDir, "rootDir must not be null");
        Objects.requireNonNull(eclipseFormatterConfig, "eclipseFormatterConfig must not be null");

        Provisioner provisioner = MavenArtifactResolver.createDefault()::resolve;

        var steps = List.of(
            importOrderStep(),
            removeUnusedImportsStep(provisioner),
            eclipseFormatter(provisioner, eclipseFormatterConfig),
            trimTrailingWhitespaceStep(),
            endWithNewlineStep()
        );

        this.formatter = Formatter.builder()
            .name("java")
            .lineEndingsPolicy(LineEnding.UNIX.createPolicy())
            .encoding(StandardCharsets.UTF_8)
            .rootDir(rootDir)
            .steps(steps)
            .exceptionPolicy(new FormatExceptionPolicyStrict())
            .build();
    }

    private static FormatterStep importOrderStep() {
        return ImportOrderStep.forJava().createFrom();
    }

    private static FormatterStep removeUnusedImportsStep(Provisioner provisioner) {
        return RemoveUnusedImportsStep.create(RemoveUnusedImportsStep.defaultFormatter(), provisioner);
    }

    private static FormatterStep eclipseFormatter(Provisioner provisioner, File eclipseFormatterConfig) {
        var eclipseFormatter = EclipseJdtFormatterStep.createBuilder(provisioner);
        eclipseFormatter.setVersion(EclipseJdtFormatterStep.defaultVersion());
        eclipseFormatter.setPreferences(List.of(eclipseFormatterConfig));
        return eclipseFormatter.build();
    }

    private static FormatterStep endWithNewlineStep() {
        return EndWithNewlineStep.create();
    }

    private static FormatterStep trimTrailingWhitespaceStep() {
        return TrimTrailingWhitespaceStep.create();
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
}
