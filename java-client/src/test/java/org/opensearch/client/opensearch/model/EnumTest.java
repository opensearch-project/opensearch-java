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

package org.opensearch.client.opensearch.model;

import java.util.Arrays;
import org.junit.Test;
import org.opensearch.client.opensearch._types.DistanceUnit;
import org.opensearch.client.opensearch._types.mapping.DynamicMapping;
import org.opensearch.client.opensearch._types.mapping.GeoOrientation;

public class EnumTest extends ModelTestCase {

    @Test
    public void testSimpleEnum() {
        assertNull(DistanceUnit.Meters.aliases());
        assertEquals(DistanceUnit.Meters, DistanceUnit._DESERIALIZER.parse("m"));
    }

    @Test
    public void testEnumWithAliases() {
        assertEquals("left", GeoOrientation.Left.jsonValue());
        assertNotNull(GeoOrientation.Left.aliases());

        Arrays.asList("right", "RIGHT", "counterclockwise", "ccw").forEach(alias -> {
            assertEquals(GeoOrientation.Right, GeoOrientation._DESERIALIZER.parse(alias));
        });
    }

    @Test
    public void testEnumWithBooleanSupport() {
        DynamicMapping booleanAsString = fromJson("\"true\"", DynamicMapping.class);
        assertEquals(booleanAsString, DynamicMapping.True);

        DynamicMapping nonBooleanEnumValue = fromJson("\"strict\"", DynamicMapping.class);
        assertEquals(nonBooleanEnumValue, DynamicMapping.Strict);

        DynamicMapping booleanPrimitive = fromJson("false", DynamicMapping.class);
        assertEquals(booleanPrimitive, DynamicMapping.False);
    }
}
