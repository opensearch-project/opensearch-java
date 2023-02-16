/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.codegen.model;

import org.opensearch.client.codegen.utils.Strings;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class EnumShape extends Shape {
    public final List<Variant> variants;

    public EnumShape(String namespace, String className, Collection<String> variants) {
        super(namespace, className);
        this.variants = variants.stream().map(Variant::new).collect(Collectors.toList());
    }

    public static class Variant {
        public final String wireName;

        public Variant(String wireName) {
            this.wireName = wireName;
        }

        public String name() {
            return Strings.toPascalCase(wireName);
        }
    }
}
