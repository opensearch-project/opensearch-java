/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.codegen.utils.json;

import com.fasterxml.jackson.core.JsonFactory;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Objects;
import javax.annotation.Nonnull;

public final class Json {
    private static final JsonFactory FACTORY = JsonFactory.builder().build();

    private Json() {}

    static JsonException convertException(IOException ioe) {
        if (ioe instanceof com.fasterxml.jackson.core.JsonGenerationException) {
            return new JsonGenerationException(ioe.getMessage(), ioe);
            // } else if (ioe instanceof com.fasterxml.jackson.core.JsonParseException) {
            // JsonParseException jpe = (JsonParseException) ioe;
            // return new JsonParsingException(ioe.getMessage(), jpe, new JacksonJsonpLocation(jpe.getLocation()));
        } else {
            return new JsonException("JSON exception", ioe);
        }
    }

    @Nonnull
    public static JsonGenerator createGenerator(@Nonnull Writer writer, boolean prettyPrint) {
        try {
            var generator = FACTORY.createGenerator(Objects.requireNonNull(writer, "writer must not be null"));
            if (prettyPrint) {
                generator.useDefaultPrettyPrinter();
            }
            return new JacksonJsonGenerator(generator);
        } catch (IOException e) {
            throw convertException(e);
        }
    }

    public static void toJson(@Nonnull ToJson value, @Nonnull Writer writer, boolean prettyPrint) {
        Objects.requireNonNull(value, "value must not be null");
        try (var generator = createGenerator(writer, prettyPrint)) {
            value.toJson(generator);
        } catch (IOException e) {
            throw convertException(e);
        }
    }

    @Nonnull
    public static String toJsonString(@Nonnull ToJson value, boolean prettyPrint) {
        var sw = new StringWriter();
        toJson(value, sw, prettyPrint);
        return sw.toString();
    }
}
