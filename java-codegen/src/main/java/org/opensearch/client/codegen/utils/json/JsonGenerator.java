/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.codegen.utils.json;

import java.io.Closeable;
import java.util.Collection;
import java.util.Map;
import java.util.Objects;
import java.util.function.Consumer;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public interface JsonGenerator extends Closeable {
    void writeStartObject();

    void writeEndObject();

    default void writeObject(@Nonnull Consumer<JsonGenerator> objectInner) {
        writeStartObject();
        objectInner.accept(this);
        writeEndObject();
    }

    default void writeEmptyObject() {
        writeStartObject();
        writeEndObject();
    }

    void writeStartArray();

    void writeEndArray();

    default void writeArray(@Nonnull Consumer<JsonGenerator> arrayInner) {
        writeStartArray();
        arrayInner.accept(this);
        writeEndArray();
    }

    void writeFieldName(@Nonnull String name);

    default void writeField(@Nonnull String name, @Nullable Object value) {
        writeFieldName(name);
        write(value);
    }

    void writeNull();

    void writeString(@Nonnull String value);

    void writeBoolean(boolean value);

    void writeInteger(int value);

    default void write(@Nullable Object value) {
        if (value == null) {
            writeNull();
        } else if (value instanceof String) {
            writeString((String) value);
        } else if (value instanceof Boolean) {
            writeBoolean((boolean) value);
        } else if (value instanceof Integer) {
            writeInteger((int) value);
        } else if (value instanceof Map) {
            writeMap((Map<?, ?>) value);
        } else if (value instanceof Collection) {
            writeList((Collection<?>) value);
        } else if (value instanceof ToJson) {
            ((ToJson) value).toJson(this);
        } else if (value instanceof Enum) {
            writeString(value.toString());
        } else {
            throw new IllegalArgumentException("Unsupported value type: " + value.getClass());
        }
    }

    default void writeMap(@Nonnull Map<?, ?> map) {
        Objects.requireNonNull(map, "map must not be null");
        writeObject(g -> g.writeMapInner(map));
    }

    default void writeMapInner(@Nonnull Map<?, ?> map) {
        Objects.requireNonNull(map, "map must not be null");
        for (Map.Entry<?, ?> entry : map.entrySet()) {
            writeField(entry.getKey().toString(), entry.getValue());
        }
    }

    default void writeList(@Nonnull Collection<?> list) {
        Objects.requireNonNull(list, "list must not be null");
        writeArray(g -> {
            for (Object item : list) {
                g.write(item);
            }
        });
    }
}
