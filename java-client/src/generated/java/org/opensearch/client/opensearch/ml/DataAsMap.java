/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

//----------------------------------------------------
// THIS CODE IS GENERATED. MANUAL EDITS WILL BE LOST.
//----------------------------------------------------

package org.opensearch.client.opensearch.ml;

import jakarta.json.stream.JsonGenerator;
import java.util.Objects;
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.opensearch.client.json.JsonpDeserializable;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.ObjectBuilderDeserializer;
import org.opensearch.client.json.ObjectDeserializer;
import org.opensearch.client.json.PlainJsonSerializable;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: ml.DataAsMap

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class DataAsMap implements PlainJsonSerializable, ToCopyableBuilder<DataAsMap.Builder, DataAsMap> {

    @Nullable
    private final String content;

    @Nullable
    private final Boolean isLast;

    // ---------------------------------------------------------------------------------------------

    private DataAsMap(Builder builder) {
        this.content = builder.content;
        this.isLast = builder.isLast;
    }

    public static DataAsMap of(Function<DataAsMap.Builder, ObjectBuilder<DataAsMap>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * The streaming content chunk.
     * <p>
     * API name: {@code content}
     * </p>
     */
    @Nullable
    public final String content() {
        return this.content;
    }

    /**
     * Whether this is the last chunk.
     * <p>
     * API name: {@code is_last}
     * </p>
     */
    @Nullable
    public final Boolean isLast() {
        return this.isLast;
    }

    /**
     * Serialize this object to JSON.
     */
    @Override
    public void serialize(JsonGenerator generator, JsonpMapper mapper) {
        generator.writeStartObject();
        serializeInternal(generator, mapper);
        generator.writeEnd();
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        if (this.content != null) {
            generator.writeKey("content");
            generator.write(this.content);
        }

        if (this.isLast != null) {
            generator.writeKey("is_last");
            generator.write(this.isLast);
        }
    }

    // ---------------------------------------------------------------------------------------------

    @Override
    @Nonnull
    public Builder toBuilder() {
        return new Builder(this);
    }

    @Nonnull
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Builder for {@link DataAsMap}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, DataAsMap> {
        @Nullable
        private String content;
        @Nullable
        private Boolean isLast;

        public Builder() {}

        private Builder(DataAsMap o) {
            this.content = o.content;
            this.isLast = o.isLast;
        }

        private Builder(Builder o) {
            this.content = o.content;
            this.isLast = o.isLast;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * The streaming content chunk.
         * <p>
         * API name: {@code content}
         * </p>
         */
        @Nonnull
        public final Builder content(@Nullable String value) {
            this.content = value;
            return this;
        }

        /**
         * Whether this is the last chunk.
         * <p>
         * API name: {@code is_last}
         * </p>
         */
        @Nonnull
        public final Builder isLast(@Nullable Boolean value) {
            this.isLast = value;
            return this;
        }

        /**
         * Builds a {@link DataAsMap}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public DataAsMap build() {
            _checkSingleUse();

            return new DataAsMap(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link DataAsMap}
     */
    public static final JsonpDeserializer<DataAsMap> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        DataAsMap::setupDataAsMapDeserializer
    );

    protected static void setupDataAsMapDeserializer(ObjectDeserializer<DataAsMap.Builder> op) {
        op.add(Builder::content, JsonpDeserializer.stringDeserializer(), "content");
        op.add(Builder::isLast, JsonpDeserializer.booleanDeserializer(), "is_last");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.content);
        result = 31 * result + Objects.hashCode(this.isLast);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        DataAsMap other = (DataAsMap) o;
        return Objects.equals(this.content, other.content) && Objects.equals(this.isLast, other.isLast);
    }
}
