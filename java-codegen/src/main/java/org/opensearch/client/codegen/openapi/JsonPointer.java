/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.codegen.openapi;

import java.util.Objects;
import java.util.Optional;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class JsonPointer {
    private static final JsonPointer ROOT = new JsonPointer(null, null);

    private final JsonPointer parent;
    private final String key;

    public static JsonPointer parse(String pointer) {
        if (pointer.isEmpty()) return ROOT;
        if (!pointer.startsWith("/")) throw new IllegalArgumentException("Invalid JSON pointer: \"" + pointer + "\"");

        var parts = pointer.substring(1).split("/");

        JsonPointer result = ROOT;
        for (var part : parts) {
            result = result.append(unescape(part));
        }

        return result;
    }

    public static JsonPointer of(String... keys) {
        JsonPointer result = ROOT;
        for (var key : keys) {
            result = result.append(key);
        }
        return ROOT.append(keys);
    }

    private JsonPointer(JsonPointer parent, String key) {
        if (parent != null) {
            Objects.requireNonNull(key, "key must not be null");
        }
        this.parent = parent;
        this.key = key;
    }

    public Optional<JsonPointer> getParent() {
        return Optional.ofNullable(parent);
    }

    public Optional<String> getKey() {
        return Optional.ofNullable(key);
    }

    public JsonPointer append(String key) {
        Objects.requireNonNull(key, "key must not be null");
        return new JsonPointer(this, key);
    }

    public JsonPointer append(String... keys) {
        JsonPointer result = this;
        for (var key : keys) {
            result = result.append(key);
        }
        return result;
    }

    @Override
    public String toString() {
        return (parent != null ? parent : "") + (key != null ? "/" + escape(key) : "");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        JsonPointer that = (JsonPointer) o;

        return new EqualsBuilder().append(parent, that.parent).append(key, that.key).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(parent).append(key).toHashCode();
    }

    private static String escape(String key) {
        return key.replace("~", "~0").replace("/", "~1");
    }

    private static String unescape(String key) {
        return key.replace("~1", "/").replace("~0", "~");
    }
}
