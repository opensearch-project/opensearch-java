/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.codegen.model;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import org.opensearch.client.codegen.openapi.OpenApiSchema;
import org.opensearch.client.codegen.utils.Strings;

public class EnumShape extends Shape {
    public static EnumShape from(Context ctx, String name, OpenApiSchema schema) {
        return new EnumShape(ctx.namespace, name, schema.getEnum().orElseThrow().stream().map(Variant::new).collect(Collectors.toList()));
    }

    private final List<Variant> variants;

    private EnumShape(Namespace parent, String className, List<Variant> variants) {
        super(parent, className);
        this.variants = variants;
    }

    public Collection<Variant> variants() {
        return Collections.unmodifiableCollection(variants);
    }

    public static class Variant {
        private final String wireName;

        private Variant(String wireName) {
            this.wireName = wireName;
        }

        public String wireName() {
            return wireName;
        }

        public String name() {
            return Strings.toPascalCase(wireName);
        }
    }
}
