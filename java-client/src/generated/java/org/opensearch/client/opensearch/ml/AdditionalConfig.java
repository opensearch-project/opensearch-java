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

// typedef: ml.AdditionalConfig

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class AdditionalConfig implements PlainJsonSerializable, ToCopyableBuilder<AdditionalConfig.Builder, AdditionalConfig> {

    @Nullable
    private final String spaceType;

    // ---------------------------------------------------------------------------------------------

    private AdditionalConfig(Builder builder) {
        this.spaceType = builder.spaceType;
    }

    public static AdditionalConfig of(Function<AdditionalConfig.Builder, ObjectBuilder<AdditionalConfig>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * The distance metric for k-NN search.
     * <p>
     * API name: {@code space_type}
     * </p>
     */
    @Nullable
    public final String spaceType() {
        return this.spaceType;
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
        if (this.spaceType != null) {
            generator.writeKey("space_type");
            generator.write(this.spaceType);
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
     * Builder for {@link AdditionalConfig}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, AdditionalConfig> {
        @Nullable
        private String spaceType;

        public Builder() {}

        private Builder(AdditionalConfig o) {
            this.spaceType = o.spaceType;
        }

        private Builder(Builder o) {
            this.spaceType = o.spaceType;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * The distance metric for k-NN search.
         * <p>
         * API name: {@code space_type}
         * </p>
         */
        @Nonnull
        public final Builder spaceType(@Nullable String value) {
            this.spaceType = value;
            return this;
        }

        /**
         * Builds a {@link AdditionalConfig}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public AdditionalConfig build() {
            _checkSingleUse();

            return new AdditionalConfig(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link AdditionalConfig}
     */
    public static final JsonpDeserializer<AdditionalConfig> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        AdditionalConfig::setupAdditionalConfigDeserializer
    );

    protected static void setupAdditionalConfigDeserializer(ObjectDeserializer<AdditionalConfig.Builder> op) {
        op.add(Builder::spaceType, JsonpDeserializer.stringDeserializer(), "space_type");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.spaceType);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        AdditionalConfig other = (AdditionalConfig) o;
        return Objects.equals(this.spaceType, other.spaceType);
    }
}
