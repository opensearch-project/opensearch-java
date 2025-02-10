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

// typedef: ml.Aggregation

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class Aggregation implements PlainJsonSerializable, ToCopyableBuilder<Aggregation.Builder, Aggregation> {

    @Nullable
    private final String field;

    @Nullable
    private final Aggregation max;

    @Nonnull
    private final Map<String, JsonData> metadata;

    @Nullable
    private final Aggregation sum;

    // ---------------------------------------------------------------------------------------------

    private Aggregation(Builder builder) {
        this.field = builder.field;
        this.max = builder.max;
        this.metadata = ApiTypeHelper.unmodifiable(builder.metadata);
        this.sum = builder.sum;
    }

    public static Aggregation of(Function<Aggregation.Builder, ObjectBuilder<Aggregation>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * The field name.
     * <p>
     * API name: {@code field}
     * </p>
     */
    @Nullable
    public final String field() {
        return this.field;
    }

    /**
     * API name: {@code max}
     */
    @Nullable
    public final Aggregation max() {
        return this.max;
    }

    @Nonnull
    public final Map<String, JsonData> metadata() {
        return this.metadata;
    }

    /**
     * API name: {@code sum}
     */
    @Nullable
    public final Aggregation sum() {
        return this.sum;
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
        if (this.field != null) {
            generator.writeKey("field");
            generator.write(this.field);
        }

        if (this.max != null) {
            generator.writeKey("max");
            this.max.serialize(generator, mapper);
        }

        if (this.sum != null) {
            generator.writeKey("sum");
            this.sum.serialize(generator, mapper);
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
     * Builder for {@link Aggregation}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, Aggregation> {
        @Nullable
        private String field;
        @Nullable
        private Aggregation max;
        @Nullable
        private Map<String, JsonData> metadata;
        @Nullable
        private Aggregation sum;

        public Builder() {}

        private Builder(Aggregation o) {
            this.field = o.field;
            this.max = o.max;
            this.metadata = _mapCopy(o.metadata);
            this.sum = o.sum;
        }

        private Builder(Builder o) {
            this.field = o.field;
            this.max = o.max;
            this.metadata = _mapCopy(o.metadata);
            this.sum = o.sum;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * The field name.
         * <p>
         * API name: {@code field}
         * </p>
         */
        @Nonnull
        public final Builder field(@Nullable String value) {
            this.field = value;
            return this;
        }

        /**
         * API name: {@code max}
         */
        @Nonnull
        public final Builder max(@Nullable Aggregation value) {
            this.max = value;
            return this;
        }

        /**
         * API name: {@code max}
         */
        @Nonnull
        public final Builder max(Function<Aggregation.Builder, ObjectBuilder<Aggregation>> fn) {
            return max(fn.apply(new Aggregation.Builder()).build());
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
         * API name: {@code sum}
         */
        @Nonnull
        public final Builder sum(@Nullable Aggregation value) {
            this.sum = value;
            return this;
        }

        /**
         * API name: {@code sum}
         */
        @Nonnull
        public final Builder sum(Function<Aggregation.Builder, ObjectBuilder<Aggregation>> fn) {
            return sum(fn.apply(new Aggregation.Builder()).build());
        }

        /**
         * Builds a {@link Aggregation}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public Aggregation build() {
            _checkSingleUse();

            return new Aggregation(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link Aggregation}
     */
    public static final JsonpDeserializer<Aggregation> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        Aggregation::setupAggregationDeserializer
    );

    protected static void setupAggregationDeserializer(ObjectDeserializer<Aggregation.Builder> op) {
        op.add(Builder::field, JsonpDeserializer.stringDeserializer(), "field");
        op.add(Builder::max, Aggregation._DESERIALIZER, "max");
        op.add(Builder::sum, Aggregation._DESERIALIZER, "sum");
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
        result = 31 * result + Objects.hashCode(this.field);
        result = 31 * result + Objects.hashCode(this.max);
        result = 31 * result + Objects.hashCode(this.metadata);
        result = 31 * result + Objects.hashCode(this.sum);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Aggregation other = (Aggregation) o;
        return Objects.equals(this.field, other.field)
            && Objects.equals(this.max, other.max)
            && Objects.equals(this.metadata, other.metadata)
            && Objects.equals(this.sum, other.sum);
    }
}
