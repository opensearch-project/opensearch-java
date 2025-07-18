/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.codegen.utils.json;

import java.io.IOException;
import java.util.Objects;
import javax.annotation.Nonnull;

class JacksonJsonGenerator implements JsonGenerator {
    @Nonnull
    private final com.fasterxml.jackson.core.JsonGenerator generator;

    public JacksonJsonGenerator(@Nonnull com.fasterxml.jackson.core.JsonGenerator generator) {
        this.generator = Objects.requireNonNull(generator, "generator must not be null");
    }

    @Override
    public void close() throws IOException {
        generator.close();
    }

    @Override
    public void writeStartObject() {
        try {
            generator.writeStartObject();
        } catch (IOException e) {
            throw Json.convertException(e);
        }
    }

    @Override
    public void writeEndObject() {
        try {
            generator.writeEndObject();
        } catch (IOException e) {
            throw Json.convertException(e);
        }
    }

    @Override
    public void writeStartArray() {
        try {
            generator.writeStartArray();
        } catch (IOException e) {
            throw Json.convertException(e);
        }
    }

    @Override
    public void writeEndArray() {
        try {
            generator.writeEndArray();
        } catch (IOException e) {
            throw Json.convertException(e);
        }
    }

    @Override
    public void writeFieldName(@Nonnull String name) {
        Objects.requireNonNull(name, "name must not be null");
        try {
            generator.writeFieldName(name);
        } catch (IOException e) {
            throw Json.convertException(e);
        }
    }

    @Override
    public void writeNull() {
        try {
            generator.writeNull();
        } catch (IOException e) {
            throw Json.convertException(e);
        }
    }

    @Override
    public void writeString(@Nonnull String value) {
        Objects.requireNonNull(value, "value must not be null");
        try {
            generator.writeString(value);
        } catch (IOException e) {
            throw Json.convertException(e);
        }
    }

    @Override
    public void writeBoolean(boolean value) {
        try {
            generator.writeBoolean(value);
        } catch (IOException e) {
            throw Json.convertException(e);
        }
    }

    @Override
    public void writeInteger(int value) {
        try {
            generator.writeNumber(value);
        } catch (IOException e) {
            throw Json.convertException(e);
        }
    }
}
