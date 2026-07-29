/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

/*
 * Licensed to Elasticsearch B.V. under one or more contributor
 * license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright
 * ownership. Elasticsearch B.V. licenses this file to you under
 * the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

/*
 * Modifications Copyright OpenSearch Contributors. See
 * GitHub history for details.
 */

//----------------------------------------------------
// THIS CODE IS GENERATED. MANUAL EDITS WILL BE LOST.
//----------------------------------------------------

package org.opensearch.client.opensearch._types.analysis;

import jakarta.json.stream.JsonGenerator;
import java.util.Objects;
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import org.opensearch.client.json.JsonData;
import org.opensearch.client.json.JsonEnum;
import org.opensearch.client.json.JsonpDeserializable;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.ObjectBuilderDeserializer;
import org.opensearch.client.json.ObjectDeserializer;
import org.opensearch.client.json.PlainJsonSerializable;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.TaggedUnion;
import org.opensearch.client.util.TaggedUnionUtils;

// typedef: _types.analysis.Normalizer

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class Normalizer implements TaggedUnion<Normalizer.Kind, NormalizerVariant>, PlainJsonSerializable {
    /**
     * {@link Normalizer} variant kinds.
     */
    public enum Kind implements JsonEnum {
        Custom("custom"),
        Lowercase("lowercase"),
        /** A custom variant type not natively supported by this client. */
        _Custom(null);

        private final String jsonValue;

        Kind(String jsonValue) {
            this.jsonValue = jsonValue;
        }

        @Override
        public String jsonValue() {
            return jsonValue;
        }
    }

    private final Kind _kind;
    private final NormalizerVariant _value;
    private final String _customKind;

    @Override
    public final Kind _kind() {
        return _kind;
    }

    @Override
    public final NormalizerVariant _get() {
        return _value;
    }

    /**
     * Returns the actual type name when {@code _kind() == Kind._Custom}, otherwise {@code null}.
     */
    public final String _customKind() {
        return _customKind;
    }

    public Normalizer(NormalizerVariant value) {
        this._kind = ApiTypeHelper.requireNonNull(value._normalizerKind(), this, "<variant kind>");
        this._value = ApiTypeHelper.requireNonNull(value, this, "<variant value>");
        this._customKind = null;
    }

    private Normalizer(Builder builder) {
        this._kind = ApiTypeHelper.requireNonNull(builder._kind, builder, "<variant kind>");
        this._value = ApiTypeHelper.requireNonNull(builder._value, builder, "<variant value>");
        this._customKind = builder._customKind;
    }

    public static Normalizer of(Function<Normalizer.Builder, ObjectBuilder<Normalizer>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Is this variant instance of kind {@code custom}?
     */
    public boolean isCustom() {
        return _kind == Kind.Custom;
    }

    /**
     * Get the {@code custom} variant value.
     *
     * @throws IllegalStateException if the current variant is not the {@code custom} kind.
     */
    public CustomNormalizer custom() {
        return TaggedUnionUtils.get(this, Kind.Custom);
    }

    /**
     * Is this variant instance of kind {@code lowercase}?
     */
    public boolean isLowercase() {
        return _kind == Kind.Lowercase;
    }

    /**
     * Get the {@code lowercase} variant value.
     *
     * @throws IllegalStateException if the current variant is not the {@code lowercase} kind.
     */
    public LowercaseNormalizer lowercase() {
        return TaggedUnionUtils.get(this, Kind.Lowercase);
    }

    /**
     * Is this variant instance of kind {@code _custom}?
     */
    public boolean _isCustom() {
        return _kind == Kind._Custom;
    }

    /**
     * Get the raw JSON data for a custom (plugin-provided) variant type.
     *
     * @throws IllegalStateException if the current variant is not the {@code _custom} kind.
     */
    public JsonData _custom() {
        if (_kind != Kind._Custom) {
            throw new IllegalStateException("Expected variant kind '_custom' but got '" + _kind + "'");
        }
        return ((CustomVariant) _value).data();
    }

    @Override
    public void serialize(JsonGenerator generator, JsonpMapper mapper) {
        mapper.serialize(_value, generator);
    }

    @Nonnull
    public Builder toBuilder() {
        return new Builder(this);
    }

    @Nonnull
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder extends ObjectBuilderBase implements ObjectBuilder<Normalizer> {
        private Kind _kind;
        private NormalizerVariant _value;
        private String _customKind;

        public Builder() {}

        private Builder(Normalizer o) {
            this._kind = o._kind;
            this._value = o._value;
            this._customKind = o._customKind;
        }

        public ObjectBuilder<Normalizer> custom(CustomNormalizer v) {
            this._kind = Kind.Custom;
            this._value = v;
            return this;
        }

        public ObjectBuilder<Normalizer> custom(Function<CustomNormalizer.Builder, ObjectBuilder<CustomNormalizer>> fn) {
            return this.custom(fn.apply(new CustomNormalizer.Builder()).build());
        }

        public ObjectBuilder<Normalizer> lowercase(LowercaseNormalizer v) {
            this._kind = Kind.Lowercase;
            this._value = v;
            return this;
        }

        public ObjectBuilder<Normalizer> lowercase(Function<LowercaseNormalizer.Builder, ObjectBuilder<LowercaseNormalizer>> fn) {
            return this.lowercase(fn.apply(new LowercaseNormalizer.Builder()).build());
        }

        /**
         * Set a custom (plugin-provided) variant.
         *
         * @param type the variant type name as returned by the server
         * @param data the raw JSON body of the variant result
         */
        public ObjectBuilder<Normalizer> _custom(String type, JsonData data) {
            this._kind = Kind._Custom;
            this._customKind = ApiTypeHelper.requireNonNull(type, this, "<custom variant type>");
            this._value = new CustomVariant(ApiTypeHelper.requireNonNull(data, this, "<custom variant data>"));
            return this;
        }

        @Override
        public Normalizer build() {
            _checkSingleUse();
            return new Normalizer(this);
        }
    }

    protected static void setupNormalizerDeserializer(ObjectDeserializer<Builder> op) {
        op.add(Builder::custom, CustomNormalizer._DESERIALIZER, "custom");
        op.add(Builder::lowercase, LowercaseNormalizer._DESERIALIZER, "lowercase");
        op.setTypeProperty("type", Kind.Custom.jsonValue());
        op.setUnknownFieldHandler(
            (builder, name, parser, mapper) -> builder._custom(name, JsonData._DESERIALIZER.deserialize(parser, mapper))
        );
    }

    public static final JsonpDeserializer<Normalizer> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        Normalizer::setupNormalizerDeserializer,
        Builder::build
    );

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this._kind);
        result = 31 * result + Objects.hashCode(this._value);
        result = 31 * result + Objects.hashCode(this._customKind);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Normalizer other = (Normalizer) o;
        return Objects.equals(this._kind, other._kind) && Objects.equals(this._value, other._value) && Objects.equals(this._customKind, other._customKind);
    }

    // Wrapper so JsonData fits the variant interface slot for custom/plugin types
    private static final class CustomVariant implements NormalizerVariant, PlainJsonSerializable {
        private final JsonData data;

        CustomVariant(JsonData data) {
            this.data = data;
        }

        public JsonData data() {
            return data;
        }

        @Override
        public Kind _normalizerKind() {
            return Kind._Custom;
        }

        @Override
        public void serialize(JsonGenerator generator, JsonpMapper mapper) {
            data.serialize(generator, mapper);
        }

        @Override
        public int hashCode() {
            return data.hashCode();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            return data.equals(((CustomVariant) o).data);
        }
    }
}
