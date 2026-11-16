/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.json.jackson3;

import jakarta.json.spi.JsonProvider;
import jakarta.json.stream.JsonGenerator;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapperBase;

/**
 * Kotlin compiler refuses to load classes from META-INF/versions/* if the class variants are not present
 * in the base JAR file.
 */
public class JacksonJsonpMapper extends JsonpMapperBase {
    @Override
    public JsonProvider jsonProvider() {
        throw new UnsupportedOperationException("Use the MR-JAR implementation (JDK-21 and above)");
    }

    @Override
    protected <T> JsonpDeserializer<T> getDefaultDeserializer(Class<T> clazz) {
        throw new UnsupportedOperationException("Use the MR-JAR implementation (JDK-21 and above)");
    }

    @Override
    public <T> void serialize(T value, JsonGenerator generator) {
        throw new UnsupportedOperationException("Use the MR-JAR implementation (JDK-21 and above)");
    }
}
