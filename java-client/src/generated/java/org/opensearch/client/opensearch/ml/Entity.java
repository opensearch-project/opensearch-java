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
import java.util.List;
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
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: ml.Entity

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class Entity implements PlainJsonSerializable, ToCopyableBuilder<Entity.Builder, Entity> {

    @Nullable
    private final Double baseValue;

    @Nullable
    private final Double contributionValue;

    @Nonnull
    private final List<String> key;

    @Nullable
    private final Double newValue;

    // ---------------------------------------------------------------------------------------------

    private Entity(Builder builder) {
        this.baseValue = builder.baseValue;
        this.contributionValue = builder.contributionValue;
        this.key = ApiTypeHelper.unmodifiable(builder.key);
        this.newValue = builder.newValue;
    }

    public static Entity of(Function<Entity.Builder, ObjectBuilder<Entity>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * The base value.
     * <p>
     * API name: {@code base_value}
     * </p>
     */
    @Nullable
    public final Double baseValue() {
        return this.baseValue;
    }

    /**
     * The contribution value.
     * <p>
     * API name: {@code contribution_value}
     * </p>
     */
    @Nullable
    public final Double contributionValue() {
        return this.contributionValue;
    }

    /**
     * API name: {@code key}
     */
    @Nonnull
    public final List<String> key() {
        return this.key;
    }

    /**
     * The new value.
     * <p>
     * API name: {@code new_value}
     * </p>
     */
    @Nullable
    public final Double newValue() {
        return this.newValue;
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
        if (this.baseValue != null) {
            generator.writeKey("base_value");
            generator.write(this.baseValue);
        }

        if (this.contributionValue != null) {
            generator.writeKey("contribution_value");
            generator.write(this.contributionValue);
        }

        if (ApiTypeHelper.isDefined(this.key)) {
            generator.writeKey("key");
            generator.writeStartArray();
            for (String item0 : this.key) {
                generator.write(item0);
            }
            generator.writeEnd();
        }

        if (this.newValue != null) {
            generator.writeKey("new_value");
            generator.write(this.newValue);
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
     * Builder for {@link Entity}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, Entity> {
        @Nullable
        private Double baseValue;
        @Nullable
        private Double contributionValue;
        @Nullable
        private List<String> key;
        @Nullable
        private Double newValue;

        public Builder() {}

        private Builder(Entity o) {
            this.baseValue = o.baseValue;
            this.contributionValue = o.contributionValue;
            this.key = _listCopy(o.key);
            this.newValue = o.newValue;
        }

        private Builder(Builder o) {
            this.baseValue = o.baseValue;
            this.contributionValue = o.contributionValue;
            this.key = _listCopy(o.key);
            this.newValue = o.newValue;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * The base value.
         * <p>
         * API name: {@code base_value}
         * </p>
         */
        @Nonnull
        public final Builder baseValue(@Nullable Double value) {
            this.baseValue = value;
            return this;
        }

        /**
         * The contribution value.
         * <p>
         * API name: {@code contribution_value}
         * </p>
         */
        @Nonnull
        public final Builder contributionValue(@Nullable Double value) {
            this.contributionValue = value;
            return this;
        }

        /**
         * API name: {@code key}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>key</code>.
         * </p>
         */
        @Nonnull
        public final Builder key(List<String> list) {
            this.key = _listAddAll(this.key, list);
            return this;
        }

        /**
         * API name: {@code key}
         *
         * <p>
         * Adds one or more values to <code>key</code>.
         * </p>
         */
        @Nonnull
        public final Builder key(String value, String... values) {
            this.key = _listAdd(this.key, value, values);
            return this;
        }

        /**
         * The new value.
         * <p>
         * API name: {@code new_value}
         * </p>
         */
        @Nonnull
        public final Builder newValue(@Nullable Double value) {
            this.newValue = value;
            return this;
        }

        /**
         * Builds a {@link Entity}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public Entity build() {
            _checkSingleUse();

            return new Entity(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link Entity}
     */
    public static final JsonpDeserializer<Entity> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        Entity::setupEntityDeserializer
    );

    protected static void setupEntityDeserializer(ObjectDeserializer<Entity.Builder> op) {
        op.add(Builder::baseValue, JsonpDeserializer.doubleDeserializer(), "base_value");
        op.add(Builder::contributionValue, JsonpDeserializer.doubleDeserializer(), "contribution_value");
        op.add(Builder::key, JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()), "key");
        op.add(Builder::newValue, JsonpDeserializer.doubleDeserializer(), "new_value");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.baseValue);
        result = 31 * result + Objects.hashCode(this.contributionValue);
        result = 31 * result + Objects.hashCode(this.key);
        result = 31 * result + Objects.hashCode(this.newValue);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Entity other = (Entity) o;
        return Objects.equals(this.baseValue, other.baseValue)
            && Objects.equals(this.contributionValue, other.contributionValue)
            && Objects.equals(this.key, other.key)
            && Objects.equals(this.newValue, other.newValue);
    }
}
