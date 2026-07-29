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

package org.opensearch.client.opensearch.core.search;

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
import org.opensearch.client.json.JsonpSerializable;
import org.opensearch.client.json.ObjectBuilderDeserializer;
import org.opensearch.client.json.ObjectDeserializer;
import org.opensearch.client.json.PlainJsonSerializable;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.TaggedUnion;
import org.opensearch.client.util.TaggedUnionUtils;

// typedef: core.search.SmoothingModel

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class SmoothingModel implements TaggedUnion<SmoothingModel.Kind, SmoothingModelVariant>, PlainJsonSerializable {
    /**
     * {@link SmoothingModel} variant kinds.
     */
    public enum Kind implements JsonEnum {
        Laplace("laplace"),
        LinearInterpolation("linear_interpolation"),
        StupidBackoff("stupid_backoff"),
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
    private final SmoothingModelVariant _value;
    private final String _customKind;

    @Override
    public final Kind _kind() {
        return _kind;
    }

    @Override
    public final SmoothingModelVariant _get() {
        return _value;
    }

    /**
     * Returns the actual type name when {@code _kind() == Kind._Custom}, otherwise {@code null}.
     */
    public final String _customKind() {
        return _customKind;
    }

    public SmoothingModel(SmoothingModelVariant value) {
        this._kind = ApiTypeHelper.requireNonNull(value._smoothingModelKind(), this, "<variant kind>");
        this._value = ApiTypeHelper.requireNonNull(value, this, "<variant value>");
        this._customKind = null;
    }

    private SmoothingModel(Builder builder) {
        this._kind = ApiTypeHelper.requireNonNull(builder._kind, builder, "<variant kind>");
        this._value = ApiTypeHelper.requireNonNull(builder._value, builder, "<variant value>");
        this._customKind = builder._customKind;
    }

    public static SmoothingModel of(Function<SmoothingModel.Builder, ObjectBuilder<SmoothingModel>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Is this variant instance of kind {@code laplace}?
     */
    public boolean isLaplace() {
        return _kind == Kind.Laplace;
    }

    /**
     * Get the {@code laplace} variant value.
     *
     * @throws IllegalStateException if the current variant is not the {@code laplace} kind.
     */
    public LaplaceSmoothingModel laplace() {
        return TaggedUnionUtils.get(this, Kind.Laplace);
    }

    /**
     * Is this variant instance of kind {@code linear_interpolation}?
     */
    public boolean isLinearInterpolation() {
        return _kind == Kind.LinearInterpolation;
    }

    /**
     * Get the {@code linear_interpolation} variant value.
     *
     * @throws IllegalStateException if the current variant is not the {@code linear_interpolation} kind.
     */
    public LinearInterpolationSmoothingModel linearInterpolation() {
        return TaggedUnionUtils.get(this, Kind.LinearInterpolation);
    }

    /**
     * Is this variant instance of kind {@code stupid_backoff}?
     */
    public boolean isStupidBackoff() {
        return _kind == Kind.StupidBackoff;
    }

    /**
     * Get the {@code stupid_backoff} variant value.
     *
     * @throws IllegalStateException if the current variant is not the {@code stupid_backoff} kind.
     */
    public StupidBackoffSmoothingModel stupidBackoff() {
        return TaggedUnionUtils.get(this, Kind.StupidBackoff);
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
        generator.writeStartObject();
        generator.writeKey(_kind == Kind._Custom ? _customKind : _kind.jsonValue());
        if (_value instanceof JsonpSerializable) {
            ((JsonpSerializable) _value).serialize(generator, mapper);
        }
        generator.writeEnd();
    }

    @Nonnull
    public Builder toBuilder() {
        return new Builder(this);
    }

    @Nonnull
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder extends ObjectBuilderBase implements ObjectBuilder<SmoothingModel> {
        private Kind _kind;
        private SmoothingModelVariant _value;
        private String _customKind;

        public Builder() {}

        private Builder(SmoothingModel o) {
            this._kind = o._kind;
            this._value = o._value;
            this._customKind = o._customKind;
        }

        public ObjectBuilder<SmoothingModel> laplace(LaplaceSmoothingModel v) {
            this._kind = Kind.Laplace;
            this._value = v;
            return this;
        }

        public ObjectBuilder<SmoothingModel> laplace(Function<LaplaceSmoothingModel.Builder, ObjectBuilder<LaplaceSmoothingModel>> fn) {
            return this.laplace(fn.apply(new LaplaceSmoothingModel.Builder()).build());
        }

        public ObjectBuilder<SmoothingModel> linearInterpolation(LinearInterpolationSmoothingModel v) {
            this._kind = Kind.LinearInterpolation;
            this._value = v;
            return this;
        }

        public ObjectBuilder<SmoothingModel> linearInterpolation(
            Function<LinearInterpolationSmoothingModel.Builder, ObjectBuilder<LinearInterpolationSmoothingModel>> fn
        ) {
            return this.linearInterpolation(fn.apply(new LinearInterpolationSmoothingModel.Builder()).build());
        }

        public ObjectBuilder<SmoothingModel> stupidBackoff(StupidBackoffSmoothingModel v) {
            this._kind = Kind.StupidBackoff;
            this._value = v;
            return this;
        }

        public ObjectBuilder<SmoothingModel> stupidBackoff(
            Function<StupidBackoffSmoothingModel.Builder, ObjectBuilder<StupidBackoffSmoothingModel>> fn
        ) {
            return this.stupidBackoff(fn.apply(new StupidBackoffSmoothingModel.Builder()).build());
        }

        /**
         * Set a custom (plugin-provided) variant.
         *
         * @param type the variant type name as returned by the server
         * @param data the raw JSON body of the variant result
         */
        public ObjectBuilder<SmoothingModel> _custom(String type, JsonData data) {
            this._kind = Kind._Custom;
            this._customKind = ApiTypeHelper.requireNonNull(type, this, "<custom variant type>");
            this._value = new CustomVariant(ApiTypeHelper.requireNonNull(data, this, "<custom variant data>"));
            return this;
        }

        @Override
        public SmoothingModel build() {
            _checkSingleUse();
            return new SmoothingModel(this);
        }
    }

    protected static void setupSmoothingModelDeserializer(ObjectDeserializer<Builder> op) {
        op.add(Builder::laplace, LaplaceSmoothingModel._DESERIALIZER, "laplace");
        op.add(Builder::linearInterpolation, LinearInterpolationSmoothingModel._DESERIALIZER, "linear_interpolation");
        op.add(Builder::stupidBackoff, StupidBackoffSmoothingModel._DESERIALIZER, "stupid_backoff");
        op.setUnknownFieldHandler(
            (builder, name, parser, mapper) -> builder._custom(name, JsonData._DESERIALIZER.deserialize(parser, mapper))
        );
    }

    public static final JsonpDeserializer<SmoothingModel> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        SmoothingModel::setupSmoothingModelDeserializer,
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
        SmoothingModel other = (SmoothingModel) o;
        return Objects.equals(this._kind, other._kind) && Objects.equals(this._value, other._value) && Objects.equals(this._customKind, other._customKind);
    }

    // Wrapper so JsonData fits the variant interface slot for custom/plugin types
    private static final class CustomVariant implements SmoothingModelVariant, PlainJsonSerializable {
        private final JsonData data;

        CustomVariant(JsonData data) {
            this.data = data;
        }

        public JsonData data() {
            return data;
        }

        @Override
        public Kind _smoothingModelKind() {
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
