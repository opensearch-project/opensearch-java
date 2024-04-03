/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.opensearch.generic;

import jakarta.json.stream.JsonGenerator;
import jakarta.json.stream.JsonParser;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;

public final class Bodies {
    private static final String APPLICATION_JSON = "application/json; charset=UTF-8";

    private Bodies() {}

    public static <C> C json(Body body, JsonpDeserializer<C> deserializer, JsonpMapper jsonpMapper) {
        try (JsonParser parser = jsonpMapper.jsonProvider().createParser(body.body())) {
            return deserializer.deserialize(parser, jsonpMapper);
        }
    }

    public static <C> C json(Body body, Class<C> clazz, JsonpMapper jsonpMapper) {
        try (JsonParser parser = jsonpMapper.jsonProvider().createParser(body.body())) {
            return jsonpMapper.deserialize(parser, clazz);
        }
    }

    public static <C> Body json(C value, JsonpMapper jsonpMapper) throws IOException {
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            try (JsonGenerator generator = jsonpMapper.jsonProvider().createGenerator(baos)) {
                jsonpMapper.serialize(value, generator);
            }
            return Body.from(baos.toByteArray(), APPLICATION_JSON);
        }
    }

    public static Body json(String str) {
        return Body.from(str.getBytes(StandardCharsets.UTF_8), APPLICATION_JSON);
    }
}
