/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.codegen.openapi;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.Test;

public class OpenApiSchemaTests {
    @Test
    public void allowsNull_withPlainArrayType_shouldReturnFalse() {
        var schema = OpenApiSchema.builder().withTypes(Set.of(OpenApiSchemaType.Array)).build();
        assertFalse(schema.allowsNull());
    }

    @Test
    public void allowsNull_withTypeIncludingNull_shouldReturnTrue() {
        // e.g. `type: [array, 'null']` -- peer_certificates_list's own shape.
        var schema = OpenApiSchema.builder().withTypes(Set.of(OpenApiSchemaType.Array, OpenApiSchemaType.Null)).build();
        assertTrue(schema.allowsNull());
    }

    @Test
    public void allowsNull_withOneOfContainingNullVariant_shouldReturnTrue() {
        // e.g. ism_template's shape: oneOf: [single object, 'null', array of objects].
        var nullVariant = OpenApiSchema.builder().withTypes(Set.of(OpenApiSchemaType.Null)).build();
        var arrayVariant = OpenApiSchema.builder().withTypes(Set.of(OpenApiSchemaType.Array)).build();
        var schema = OpenApiSchema.builder().withOneOf(List.of(arrayVariant, nullVariant)).build();
        assertTrue(schema.allowsNull());
    }

    @Test
    public void allowsNull_withOneOfNotContainingNullVariant_shouldReturnFalse() {
        var stringVariant = OpenApiSchema.builder().withTypes(Set.of(OpenApiSchemaType.String)).build();
        var arrayVariant = OpenApiSchema.builder().withTypes(Set.of(OpenApiSchemaType.Array)).build();
        var schema = OpenApiSchema.builder().withOneOf(List.of(arrayVariant, stringVariant)).build();
        assertFalse(schema.allowsNull());
    }

    @Test
    public void allowsNull_withAnyOfContainingNullVariant_shouldReturnTrue() {
        var nullVariant = OpenApiSchema.builder().withTypes(Set.of(OpenApiSchemaType.Null)).build();
        var stringVariant = OpenApiSchema.builder().withTypes(Set.of(OpenApiSchemaType.String)).build();
        var schema = OpenApiSchema.builder().withAnyOf(List.of(stringVariant, nullVariant)).build();
        assertTrue(schema.allowsNull());
    }
}
