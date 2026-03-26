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
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.opensearch.client.json.JsonData;
import org.opensearch.client.json.JsonpDeserializable;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.ObjectBuilderDeserializer;
import org.opensearch.client.json.ObjectDeserializer;
import org.opensearch.client.json.PlainJsonSerializable;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: ml.Content

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class Content implements PlainJsonSerializable, ToCopyableBuilder<Content.Builder, Content> {

    @Nonnull
    private final Map<String, JsonData> metadata;

    @Nullable
    private final String text;

    @Nullable
    private final String type;

    // ---------------------------------------------------------------------------------------------

    private Content(Builder builder) {
        this.metadata = ApiTypeHelper.unmodifiable(builder.metadata);
        this.text = builder.text;
        this.type = builder.type;
    }

    public static Content of(Function<Content.Builder, ObjectBuilder<Content>> fn) {
        return fn.apply(new Builder()).build();
    }

    @Nonnull
    public final Map<String, JsonData> metadata() {
        return this.metadata;
    }

    /**
     * API name: {@code text}
     */
    @Nullable
    public final String text() {
        return this.text;
    }

    /**
     * API name: {@code type}
     */
    @Nullable
    public final String type() {
        return this.type;
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
        for (Map.Entry<String, JsonData> item0 : this.metadata.entrySet()) {
            generator.writeKey(item0.getKey());
            item0.getValue().serialize(generator, mapper);
        }
        if (this.text != null) {
            generator.writeKey("text");
            generator.write(this.text);
        }

        if (this.type != null) {
            generator.writeKey("type");
            generator.write(this.type);
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
     * Builder for {@link Content}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, Content> {
        @Nullable
        private Map<String, JsonData> metadata;
        @Nullable
        private String text;
        @Nullable
        private String type;

        public Builder() {}

        private Builder(Content o) {
            this.metadata = _mapCopy(o.metadata);
            this.text = o.text;
            this.type = o.type;
        }

        private Builder(Builder o) {
            this.metadata = _mapCopy(o.metadata);
            this.text = o.text;
            this.type = o.type;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>metadata</code>.
         * </p>
         */
        @Nonnull
        public final Builder metadata(Map<String, JsonData> map) {
            this.metadata = _mapPutAll(this.metadata, map);
            return this;
        }

        /**
         *
         * <p>
         * Adds an entry to <code>metadata</code>.
         * </p>
         */
        @Nonnull
        public final Builder metadata(String key, JsonData value) {
            this.metadata = _mapPut(this.metadata, key, value);
            return this;
        }

        /**
         * API name: {@code text}
         */
        @Nonnull
        public final Builder text(@Nullable String value) {
            this.text = value;
            return this;
        }

        /**
         * API name: {@code type}
         */
        @Nonnull
        public final Builder type(@Nullable String value) {
            this.type = value;
            return this;
        }

        /**
         * Builds a {@link Content}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public Content build() {
            _checkSingleUse();

            return new Content(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link Content}
     */
    public static final JsonpDeserializer<Content> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        Content::setupContentDeserializer
    );

    protected static void setupContentDeserializer(ObjectDeserializer<Content.Builder> op) {
        op.add(Builder::text, JsonpDeserializer.stringDeserializer(), "text");
        op.add(Builder::type, JsonpDeserializer.stringDeserializer(), "type");
        op.setUnknownFieldHandler((builder, name, parser, mapper) -> {
            if (builder.metadata == null) {
                builder.metadata = new HashMap<>();
            }
            builder.metadata.put(name, JsonData._DESERIALIZER.deserialize(parser, mapper));
        });
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.metadata);
        result = 31 * result + Objects.hashCode(this.text);
        result = 31 * result + Objects.hashCode(this.type);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Content other = (Content) o;
        return Objects.equals(this.metadata, other.metadata)
            && Objects.equals(this.text, other.text)
            && Objects.equals(this.type, other.type);
    }
}
