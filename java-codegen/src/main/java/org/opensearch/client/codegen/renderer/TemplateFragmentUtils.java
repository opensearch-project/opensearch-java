/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.codegen.renderer;

import com.samskivert.mustache.Template;
import java.util.Optional;

public final class TemplateFragmentUtils {
    private TemplateFragmentUtils() {}

    @SuppressWarnings("unchecked")
    public static <T> Optional<T> findParentContext(Template.Fragment fragment, Class<T> clazz) {
        var i = 0;
        while (true) {
            Object ctx;

            try {
                ctx = fragment.context(i++);
            } catch (NullPointerException ignored) {
                return Optional.empty();
            }

            if (clazz.isAssignableFrom(ctx.getClass())) {
                return Optional.of((T) ctx);
            }
        }
    }
}
