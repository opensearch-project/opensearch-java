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

// typedef: ml.IndexSettings

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class IndexSettings implements PlainJsonSerializable, ToCopyableBuilder<IndexSettings.Builder, IndexSettings> {

    @Nullable
    private final MemoryIndexSettings longTermMemoryHistoryIndex;

    @Nullable
    private final MemoryIndexSettings longTermMemoryIndex;

    @Nonnull
    private final Map<String, JsonData> metadata;

    @Nullable
    private final MemoryIndexSettings sessionIndex;

    @Nullable
    private final MemoryIndexSettings shortTermMemoryIndex;

    // ---------------------------------------------------------------------------------------------

    private IndexSettings(Builder builder) {
        this.longTermMemoryHistoryIndex = builder.longTermMemoryHistoryIndex;
        this.longTermMemoryIndex = builder.longTermMemoryIndex;
        this.metadata = ApiTypeHelper.unmodifiable(builder.metadata);
        this.sessionIndex = builder.sessionIndex;
        this.shortTermMemoryIndex = builder.shortTermMemoryIndex;
    }

    public static IndexSettings of(Function<IndexSettings.Builder, ObjectBuilder<IndexSettings>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code long_term_memory_history_index}
     */
    @Nullable
    public final MemoryIndexSettings longTermMemoryHistoryIndex() {
        return this.longTermMemoryHistoryIndex;
    }

    /**
     * API name: {@code long_term_memory_index}
     */
    @Nullable
    public final MemoryIndexSettings longTermMemoryIndex() {
        return this.longTermMemoryIndex;
    }

    @Nonnull
    public final Map<String, JsonData> metadata() {
        return this.metadata;
    }

    /**
     * API name: {@code session_index}
     */
    @Nullable
    public final MemoryIndexSettings sessionIndex() {
        return this.sessionIndex;
    }

    /**
     * API name: {@code short_term_memory_index}
     */
    @Nullable
    public final MemoryIndexSettings shortTermMemoryIndex() {
        return this.shortTermMemoryIndex;
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
        if (this.longTermMemoryHistoryIndex != null) {
            generator.writeKey("long_term_memory_history_index");
            this.longTermMemoryHistoryIndex.serialize(generator, mapper);
        }

        if (this.longTermMemoryIndex != null) {
            generator.writeKey("long_term_memory_index");
            this.longTermMemoryIndex.serialize(generator, mapper);
        }

        if (this.sessionIndex != null) {
            generator.writeKey("session_index");
            this.sessionIndex.serialize(generator, mapper);
        }

        if (this.shortTermMemoryIndex != null) {
            generator.writeKey("short_term_memory_index");
            this.shortTermMemoryIndex.serialize(generator, mapper);
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
     * Builder for {@link IndexSettings}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, IndexSettings> {
        @Nullable
        private MemoryIndexSettings longTermMemoryHistoryIndex;
        @Nullable
        private MemoryIndexSettings longTermMemoryIndex;
        @Nullable
        private Map<String, JsonData> metadata;
        @Nullable
        private MemoryIndexSettings sessionIndex;
        @Nullable
        private MemoryIndexSettings shortTermMemoryIndex;

        public Builder() {}

        private Builder(IndexSettings o) {
            this.longTermMemoryHistoryIndex = o.longTermMemoryHistoryIndex;
            this.longTermMemoryIndex = o.longTermMemoryIndex;
            this.metadata = _mapCopy(o.metadata);
            this.sessionIndex = o.sessionIndex;
            this.shortTermMemoryIndex = o.shortTermMemoryIndex;
        }

        private Builder(Builder o) {
            this.longTermMemoryHistoryIndex = o.longTermMemoryHistoryIndex;
            this.longTermMemoryIndex = o.longTermMemoryIndex;
            this.metadata = _mapCopy(o.metadata);
            this.sessionIndex = o.sessionIndex;
            this.shortTermMemoryIndex = o.shortTermMemoryIndex;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code long_term_memory_history_index}
         */
        @Nonnull
        public final Builder longTermMemoryHistoryIndex(@Nullable MemoryIndexSettings value) {
            this.longTermMemoryHistoryIndex = value;
            return this;
        }

        /**
         * API name: {@code long_term_memory_history_index}
         */
        @Nonnull
        public final Builder longTermMemoryHistoryIndex(Function<MemoryIndexSettings.Builder, ObjectBuilder<MemoryIndexSettings>> fn) {
            return longTermMemoryHistoryIndex(fn.apply(new MemoryIndexSettings.Builder()).build());
        }

        /**
         * API name: {@code long_term_memory_index}
         */
        @Nonnull
        public final Builder longTermMemoryIndex(@Nullable MemoryIndexSettings value) {
            this.longTermMemoryIndex = value;
            return this;
        }

        /**
         * API name: {@code long_term_memory_index}
         */
        @Nonnull
        public final Builder longTermMemoryIndex(Function<MemoryIndexSettings.Builder, ObjectBuilder<MemoryIndexSettings>> fn) {
            return longTermMemoryIndex(fn.apply(new MemoryIndexSettings.Builder()).build());
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
         * API name: {@code session_index}
         */
        @Nonnull
        public final Builder sessionIndex(@Nullable MemoryIndexSettings value) {
            this.sessionIndex = value;
            return this;
        }

        /**
         * API name: {@code session_index}
         */
        @Nonnull
        public final Builder sessionIndex(Function<MemoryIndexSettings.Builder, ObjectBuilder<MemoryIndexSettings>> fn) {
            return sessionIndex(fn.apply(new MemoryIndexSettings.Builder()).build());
        }

        /**
         * API name: {@code short_term_memory_index}
         */
        @Nonnull
        public final Builder shortTermMemoryIndex(@Nullable MemoryIndexSettings value) {
            this.shortTermMemoryIndex = value;
            return this;
        }

        /**
         * API name: {@code short_term_memory_index}
         */
        @Nonnull
        public final Builder shortTermMemoryIndex(Function<MemoryIndexSettings.Builder, ObjectBuilder<MemoryIndexSettings>> fn) {
            return shortTermMemoryIndex(fn.apply(new MemoryIndexSettings.Builder()).build());
        }

        /**
         * Builds a {@link IndexSettings}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public IndexSettings build() {
            _checkSingleUse();

            return new IndexSettings(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link IndexSettings}
     */
    public static final JsonpDeserializer<IndexSettings> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        IndexSettings::setupIndexSettingsDeserializer
    );

    protected static void setupIndexSettingsDeserializer(ObjectDeserializer<IndexSettings.Builder> op) {
        op.add(Builder::longTermMemoryHistoryIndex, MemoryIndexSettings._DESERIALIZER, "long_term_memory_history_index");
        op.add(Builder::longTermMemoryIndex, MemoryIndexSettings._DESERIALIZER, "long_term_memory_index");
        op.add(Builder::sessionIndex, MemoryIndexSettings._DESERIALIZER, "session_index");
        op.add(Builder::shortTermMemoryIndex, MemoryIndexSettings._DESERIALIZER, "short_term_memory_index");
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
        result = 31 * result + Objects.hashCode(this.longTermMemoryHistoryIndex);
        result = 31 * result + Objects.hashCode(this.longTermMemoryIndex);
        result = 31 * result + Objects.hashCode(this.metadata);
        result = 31 * result + Objects.hashCode(this.sessionIndex);
        result = 31 * result + Objects.hashCode(this.shortTermMemoryIndex);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        IndexSettings other = (IndexSettings) o;
        return Objects.equals(this.longTermMemoryHistoryIndex, other.longTermMemoryHistoryIndex)
            && Objects.equals(this.longTermMemoryIndex, other.longTermMemoryIndex)
            && Objects.equals(this.metadata, other.metadata)
            && Objects.equals(this.sessionIndex, other.sessionIndex)
            && Objects.equals(this.shortTermMemoryIndex, other.shortTermMemoryIndex);
    }
}
