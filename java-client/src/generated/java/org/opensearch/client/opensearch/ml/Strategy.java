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

// typedef: ml.Strategy

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class Strategy implements PlainJsonSerializable, ToCopyableBuilder<Strategy.Builder, Strategy> {

    @Nullable
    private final StrategyConfiguration configuration;

    @Nullable
    private final Boolean enabled;

    @Nullable
    private final String id;

    @Nonnull
    private final List<String> namespace;

    @Nullable
    private final StrategyType type;

    // ---------------------------------------------------------------------------------------------

    private Strategy(Builder builder) {
        this.configuration = builder.configuration;
        this.enabled = builder.enabled;
        this.id = builder.id;
        this.namespace = ApiTypeHelper.unmodifiable(builder.namespace);
        this.type = builder.type;
    }

    public static Strategy of(Function<Strategy.Builder, ObjectBuilder<Strategy>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code configuration}
     */
    @Nullable
    public final StrategyConfiguration configuration() {
        return this.configuration;
    }

    /**
     * Whether to enable the strategy.
     * <p>
     * API name: {@code enabled}
     * </p>
     */
    @Nullable
    public final Boolean enabled() {
        return this.enabled;
    }

    /**
     * The strategy ID.
     * <p>
     * API name: {@code id}
     * </p>
     */
    @Nullable
    public final String id() {
        return this.id;
    }

    /**
     * The namespace.
     * <p>
     * API name: {@code namespace}
     * </p>
     */
    @Nonnull
    public final List<String> namespace() {
        return this.namespace;
    }

    /**
     * API name: {@code type}
     */
    @Nullable
    public final StrategyType type() {
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
        if (this.configuration != null) {
            generator.writeKey("configuration");
            this.configuration.serialize(generator, mapper);
        }

        if (this.enabled != null) {
            generator.writeKey("enabled");
            generator.write(this.enabled);
        }

        if (this.id != null) {
            generator.writeKey("id");
            generator.write(this.id);
        }

        if (ApiTypeHelper.isDefined(this.namespace)) {
            generator.writeKey("namespace");
            generator.writeStartArray();
            for (String item0 : this.namespace) {
                generator.write(item0);
            }
            generator.writeEnd();
        }

        if (this.type != null) {
            generator.writeKey("type");
            this.type.serialize(generator, mapper);
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
     * Builder for {@link Strategy}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, Strategy> {
        @Nullable
        private StrategyConfiguration configuration;
        @Nullable
        private Boolean enabled;
        @Nullable
        private String id;
        @Nullable
        private List<String> namespace;
        @Nullable
        private StrategyType type;

        public Builder() {}

        private Builder(Strategy o) {
            this.configuration = o.configuration;
            this.enabled = o.enabled;
            this.id = o.id;
            this.namespace = _listCopy(o.namespace);
            this.type = o.type;
        }

        private Builder(Builder o) {
            this.configuration = o.configuration;
            this.enabled = o.enabled;
            this.id = o.id;
            this.namespace = _listCopy(o.namespace);
            this.type = o.type;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code configuration}
         */
        @Nonnull
        public final Builder configuration(@Nullable StrategyConfiguration value) {
            this.configuration = value;
            return this;
        }

        /**
         * API name: {@code configuration}
         */
        @Nonnull
        public final Builder configuration(Function<StrategyConfiguration.Builder, ObjectBuilder<StrategyConfiguration>> fn) {
            return configuration(fn.apply(new StrategyConfiguration.Builder()).build());
        }

        /**
         * Whether to enable the strategy.
         * <p>
         * API name: {@code enabled}
         * </p>
         */
        @Nonnull
        public final Builder enabled(@Nullable Boolean value) {
            this.enabled = value;
            return this;
        }

        /**
         * The strategy ID.
         * <p>
         * API name: {@code id}
         * </p>
         */
        @Nonnull
        public final Builder id(@Nullable String value) {
            this.id = value;
            return this;
        }

        /**
         * The namespace.
         * <p>
         * API name: {@code namespace}
         * </p>
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>namespace</code>.
         * </p>
         */
        @Nonnull
        public final Builder namespace(List<String> list) {
            this.namespace = _listAddAll(this.namespace, list);
            return this;
        }

        /**
         * The namespace.
         * <p>
         * API name: {@code namespace}
         * </p>
         *
         * <p>
         * Adds one or more values to <code>namespace</code>.
         * </p>
         */
        @Nonnull
        public final Builder namespace(String value, String... values) {
            this.namespace = _listAdd(this.namespace, value, values);
            return this;
        }

        /**
         * API name: {@code type}
         */
        @Nonnull
        public final Builder type(@Nullable StrategyType value) {
            this.type = value;
            return this;
        }

        /**
         * Builds a {@link Strategy}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public Strategy build() {
            _checkSingleUse();

            return new Strategy(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link Strategy}
     */
    public static final JsonpDeserializer<Strategy> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        Strategy::setupStrategyDeserializer
    );

    protected static void setupStrategyDeserializer(ObjectDeserializer<Strategy.Builder> op) {
        op.add(Builder::configuration, StrategyConfiguration._DESERIALIZER, "configuration");
        op.add(Builder::enabled, JsonpDeserializer.booleanDeserializer(), "enabled");
        op.add(Builder::id, JsonpDeserializer.stringDeserializer(), "id");
        op.add(Builder::namespace, JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()), "namespace");
        op.add(Builder::type, StrategyType._DESERIALIZER, "type");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.configuration);
        result = 31 * result + Objects.hashCode(this.enabled);
        result = 31 * result + Objects.hashCode(this.id);
        result = 31 * result + Objects.hashCode(this.namespace);
        result = 31 * result + Objects.hashCode(this.type);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Strategy other = (Strategy) o;
        return Objects.equals(this.configuration, other.configuration)
            && Objects.equals(this.enabled, other.enabled)
            && Objects.equals(this.id, other.id)
            && Objects.equals(this.namespace, other.namespace)
            && Objects.equals(this.type, other.type);
    }
}
