/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.codegen.openapi;

import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;
import java.util.WeakHashMap;
import javax.annotation.Nonnull;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class JsonPointer {
    private static final WeakHashMap<JsonPointer, WeakReference<JsonPointer>> PARENT_CACHE = new WeakHashMap<>();
    @Nonnull
    public static final JsonPointer ROOT = new JsonPointer(new String[0]);

    @Nonnull
    private final String[] keys;

    @Nonnull
    public static JsonPointer parse(@Nonnull String pointer) {
        Objects.requireNonNull(pointer, "pointer must not be null");

        if (pointer.isEmpty()) {
            return ROOT;
        }

        if (!pointer.startsWith("/")) {
            throw new IllegalArgumentException("Invalid JSON pointer: \"" + pointer + "\"");
        }

        var parts = pointer.substring(1).split("/");

        return new JsonPointer(Arrays.stream(parts).map(JsonPointer::unescape).toArray(String[]::new));
    }

    @Nonnull
    public static JsonPointer of(@Nonnull String... keys) {
        return new JsonPointer(keys);
    }

    private JsonPointer(@Nonnull String[] keys) {
        Objects.requireNonNull(keys, "keys must not be null");
        this.keys = Arrays.copyOf(keys, keys.length);
    }

    @Nonnull
    public Optional<String> getLastKey() {
        if (keys.length == 0) {
            return Optional.empty();
        }
        return Optional.of(keys[keys.length - 1]);
    }

    @Nonnull
    public Optional<JsonPointer> getParent() {
        if (keys.length == 0) return Optional.empty();
        if (keys.length == 1) return Optional.of(ROOT);

        var parent = Optional.ofNullable(PARENT_CACHE.get(this)).flatMap(ref -> Optional.ofNullable(ref.get()));

        if (parent.isEmpty()) {
            var newKeys = new String[this.keys.length - 1];
            System.arraycopy(this.keys, 0, newKeys, 0, newKeys.length);
            parent = Optional.of(new JsonPointer(newKeys));
            PARENT_CACHE.put(this, new WeakReference<>(parent.get()));
        }

        return parent;
    }

    @Nonnull
    public JsonPointer append(@Nonnull String... keys) {
        Objects.requireNonNull(keys, "keys must not be null");
        var newKeys = new String[this.keys.length + keys.length];
        System.arraycopy(this.keys, 0, newKeys, 0, this.keys.length);
        System.arraycopy(keys, 0, newKeys, this.keys.length, keys.length);
        return new JsonPointer(newKeys);
    }

    public boolean isDirectChildOf(@Nonnull JsonPointer other) {
        Objects.requireNonNull(other, "other must not be null");
        return getParent().map(other::equals).orElse(false);
    }

    @Override
    public String toString() {
        if (keys.length == 0) {
            return "";
        }

        var builder = new StringBuilder();
        for (var key : keys) {
            builder.append("/").append(escape(key));
        }
        return builder.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        JsonPointer that = (JsonPointer) o;

        return new EqualsBuilder().append(keys, that.keys).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(keys).toHashCode();
    }

    @Nonnull
    private static String escape(@Nonnull String key) {
        Objects.requireNonNull(key, "key must not be null");
        return key.replace("~", "~0").replace("/", "~1");
    }

    @Nonnull
    private static String unescape(@Nonnull String key) {
        Objects.requireNonNull(key, "key must not be null");
        return key.replace("~1", "/").replace("~0", "~");
    }
}
