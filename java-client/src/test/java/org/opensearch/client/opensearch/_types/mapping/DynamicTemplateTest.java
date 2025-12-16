/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.opensearch._types.mapping;

import static org.junit.Assert.assertEquals;

import org.junit.Ignore;
import org.junit.Test;

public class DynamicTemplateTest {

    @Test
    @Ignore
    public void test() {
        DynamicTemplate dynamicTemplate = new DynamicTemplate.Builder().matchMappingType("long")
            .mapping(t -> t.integer(i -> i.docValues(false)))
            .build();
        assertEquals("{}", dynamicTemplate.toJsonString());
    }

}
