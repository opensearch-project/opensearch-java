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

import org.junit.Test;
import org.opensearch.client.opensearch._types.Script;
import org.opensearch.client.opensearch._types.query_dsl.SimpleQueryStringFlag;
import org.opensearch.client.opensearch._types.query_dsl.SimpleQueryStringFlags;

public class UnionTests extends ModelTestCase {

    @Test
    public void testScriptDeserializer() {
        // A union discriminated by its field names (source -> inline, id -> stored)
        {
            Script s = Script.of(_1 -> _1.inline(_2 -> _2.source("a script")));
            s = checkJsonRoundtrip(s, "{\"source\":\"a script\"}");
            assertEquals("a script", s.inline().source());
        }

        {
            Script s = Script.of(_1 -> _1.stored(_2 -> _2.id("script_id")));
            s = checkJsonRoundtrip(s, "{\"id\":\"script_id\"}");
            assertEquals("script_id", s.stored().id());
        }

        {
            // Test shortcut property
            Script s = fromJson("\"a script\"", Script.class);
            assertEquals("a script", s.inline().source());
        }
    }

    @Test
    public void testSimpleQueryStringFlag() {
        // Ambiguous union on strings

        SimpleQueryStringFlags f;

        f = fromJson("\"OR\"", SimpleQueryStringFlags.class);
        assertEquals(SimpleQueryStringFlag.Or, f.single());

        f = fromJson("\"OR|AND\"", SimpleQueryStringFlags.class);
        assertEquals("OR|AND", f.multiple());

    }
}
