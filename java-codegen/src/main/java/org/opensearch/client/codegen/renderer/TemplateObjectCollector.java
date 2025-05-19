/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.codegen.renderer;

import com.samskivert.mustache.DefaultCollector;
import com.samskivert.mustache.Mustache;
import java.util.Optional;

public class TemplateObjectCollector extends DefaultCollector {
    @Override
    public Mustache.VariableFetcher createFetcher(Object ctx, String name) {
        var fetcher = super.createFetcher(ctx, name);
        if (fetcher == null) {
            return null;
        }
        return (ctx1, name1) -> {
            var value = fetcher.get(ctx1, name1);
            if (value instanceof Optional) {
                return ((Optional<?>) value).orElse(null);
            }
            return value;
        };
    }
}
