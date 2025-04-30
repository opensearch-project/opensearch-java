/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.opensearch.indices;

import static org.hamcrest.CoreMatchers.equalTo;

import org.junit.Test;
import org.opensearch.client.opensearch._types.query_dsl.Query;
import org.opensearch.client.opensearch.model.ModelTestCase;

public class AliasDefinitionTest extends ModelTestCase {

    @Test
    public void toBuilder() {
        AliasDefinition origin = new AliasDefinition.Builder().filter(f -> f.wrapper(w -> w.query("aaa"))).build();
        AliasDefinition copied = fromJson(toJson(origin), AliasDefinition.class);
        assertEquals(toJson(copied), toJson(origin));
    }

    @Test
    public void testFromJson() {
        final AliasDefinition origin = fromJson(
            "{"
                + "\"filter\": {"
                + "\"wrapper\": {"
                + "\"query\":\"eyJib29sIiA6IHsibXVzdCIgOiB7InRlcm0iIDogeyJ0eXBlIiA6ICJhYmMifX19fQo=\""
                + "}"
                + "},"
                + "\"is_write_index\":false,"
                + "\"is_hidden\":true"
                + "}",
            AliasDefinition.class
        );

        assertThat(origin.filter()._kind(), equalTo(Query.Kind.Wrapper));
        assertThat(origin.isHidden(), equalTo(true));
        assertThat(origin.isWriteIndex(), equalTo(false));
    }

}
