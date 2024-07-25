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

import org.junit.Assert;
import org.junit.Test;
import org.opensearch.client.opensearch._types.ExpandWildcard;
import org.opensearch.client.opensearch.core.GetRequest;
import org.opensearch.client.opensearch.indices.RefreshRequest;

public class EndpointTest extends Assert {
    @Test
    public void testIdEncoding() {
        GetRequest req = new GetRequest.Builder().index("db").id("a:b:c::2.0").build();
        assertEquals("/db/_doc/a%3Ab%3Ac%3A%3A2.0", GetRequest._ENDPOINT.requestUrl(req));
    }

    @Test
    public void testArrayPathParameter() {
        RefreshRequest req;

        req = RefreshRequest.of(b -> b);
        assertNotNull(req.index());
        assertEquals("/_refresh", RefreshRequest._ENDPOINT.requestUrl(req));

        req = RefreshRequest.of(b -> b.index("a"));
        assertEquals("/a/_refresh", RefreshRequest._ENDPOINT.requestUrl(req));

        req = RefreshRequest.of(b -> b.index("a", "b"));
        assertEquals("/a%2Cb/_refresh", RefreshRequest._ENDPOINT.requestUrl(req));

        req = RefreshRequest.of(b -> b.index("a", "b", "c"));
        assertEquals("/a%2Cb%2Cc/_refresh", RefreshRequest._ENDPOINT.requestUrl(req));
    }

    @Test
    public void testPathEncoding() {
        RefreshRequest req;

        req = RefreshRequest.of(b -> b.index("a/b"));
        assertEquals("/a%2Fb/_refresh", RefreshRequest._ENDPOINT.requestUrl(req));

        req = RefreshRequest.of(b -> b.index("a/b", "c/d"));
        assertEquals("/a%2Fb%2Cc%2Fd/_refresh", RefreshRequest._ENDPOINT.requestUrl(req));

    }

    @Test
    public void testArrayQueryParameter() {
        RefreshRequest req;

        req = RefreshRequest.of(b -> b);
        assertNotNull(req.expandWildcards()); // undefined list
        assertNull(RefreshRequest._ENDPOINT.queryParameters(req).get("expand_wildcards"));

        req = RefreshRequest.of(b -> b.expandWildcards(ExpandWildcard.All));
        // Also tests query encoding of enums
        assertEquals("all", RefreshRequest._ENDPOINT.queryParameters(req).get("expand_wildcards"));

        req = RefreshRequest.of(b -> b.expandWildcards(ExpandWildcard.All, ExpandWildcard.Closed));
        assertEquals("all,closed", RefreshRequest._ENDPOINT.queryParameters(req).get("expand_wildcards"));
    }
}
