/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

/*
 * Licensed to Elasticsearch B.V. under one or more contributor
 * license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright
 * ownership. Elasticsearch B.V. licenses this file to you under
 * the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

/*
 * Modifications Copyright OpenSearch Contributors. See
 * GitHub history for details.
 */

package org.opensearch.client.opensearch.experiments.containers;

import jakarta.json.stream.JsonParsingException;
import org.junit.Test;
import org.opensearch.client.opensearch.model.ModelTestCase;

public class SomeUnionTest extends ModelTestCase {

    SomeUnion su = new SomeUnion.Builder().variantA(a_ -> a_.name("a-name")).build();

    String json = "{\"type\":\"variant_a\",\"name\":\"a-name\"}";

    @Test
    public void testContainerBuilder() {
        assertEquals("a-name", su.variantA().name());
    }

    @Test
    public void testDeserialization() {
        SomeUnion u = fromJson(json, SomeUnion.class);
        UVariantA uVariantA = u.variantA();
        assertEquals("a-name", uVariantA.name());
    }

    @Test
    public void testSerialization() {

        String str = toJson(su);

        System.out.println(str);

        assertEquals(json, str);

    }

    @Test
    public void testMissingVariantDeserialization() {
        String json = "{}";

        JsonParsingException e = assertThrows(JsonParsingException.class, () -> { fromJson(json, SomeUnion._DESERIALIZER); });

        assertTrue(e.getMessage().contains("Property 'type' not found"));
    }

}
