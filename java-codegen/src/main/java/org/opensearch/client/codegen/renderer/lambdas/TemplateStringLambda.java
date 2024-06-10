/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.codegen.renderer.lambdas;

import com.samskivert.mustache.Mustache;
import java.util.Objects;
import javax.annotation.Nonnull;

@FunctionalInterface
public interface TemplateStringLambda {
    @Nonnull
    String execute(@Nonnull String input);

    static Mustache.Lambda asMustacheLambda(@Nonnull TemplateStringLambda lambda) {
        Objects.requireNonNull(lambda, "lambda must not be null");
        return (fragment, out) -> out.write(lambda.execute(fragment.execute()));
    }
}
