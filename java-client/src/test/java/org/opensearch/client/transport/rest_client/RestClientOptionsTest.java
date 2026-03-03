/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.transport.rest_client;

import java.util.AbstractMap;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;
import org.junit.Assert;
import org.junit.Test;
import org.opensearch.client.transport.TransportOptions;

public class RestClientOptionsTest extends Assert {
    @Test
    public void testOfWithNullOptions() {
        // Null input should fall back to defaults instead of throwing.
        RestClientOptions options = RestClientOptions.of(null);

        assertNotNull(options);
        assertNotNull(options.headers());
    }

    @Test
    public void testOfWithNullHeaders() {
        // Missing headers from source options should be treated as empty.
        RestClientOptions options = RestClientOptions.of(
            transportOptions(null, Collections.emptyMap(), warnings -> warnings != null && !warnings.isEmpty())
        );

        assertNotNull(options);
        assertNotNull(options.headers());
        assertTrue(options.headers().isEmpty());
        assertNotNull(options.onWarnings());
        assertTrue(options.onWarnings().apply(Collections.singletonList("warning")));
    }

    @Test
    public void testOfWithNullQueryParameters() {
        // Null query parameters should not drop other fields during conversion.
        RestClientOptions options = RestClientOptions.of(
            transportOptions(
                Collections.singletonList(new AbstractMap.SimpleImmutableEntry<>("x-test-header", "value")),
                null,
                warnings -> warnings != null && !warnings.isEmpty()
            )
        );

        assertNotNull(options);
        assertNotNull(options.onWarnings());
        assertTrue(options.onWarnings().apply(Collections.singletonList("warning")));
        assertTrue(containsHeader(options.headers(), "x-test-header", "value"));
    }

    private static boolean containsHeader(Collection<Entry<String, String>> headers, String name, String value) {
        for (Entry<String, String> header : headers) {
            if (name.equals(header.getKey()) && value.equals(header.getValue())) {
                return true;
            }
        }

        return false;
    }

    private static TransportOptions transportOptions(
        Collection<Entry<String, String>> headers,
        Map<String, String> queryParameters,
        Function<List<String>, Boolean> warningsHandler
    ) {
        return new TransportOptions() {
            @Override
            public Collection<Entry<String, String>> headers() {
                return headers;
            }

            @Override
            public Map<String, String> queryParameters() {
                return queryParameters;
            }

            @Override
            public Function<List<String>, Boolean> onWarnings() {
                return warningsHandler;
            }

            @Override
            public Builder toBuilder() {
                return new BuilderImpl(this);
            }
        };
    }
}
