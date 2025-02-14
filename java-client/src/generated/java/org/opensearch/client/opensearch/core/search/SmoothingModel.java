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
        StupidBackoff("stupid_backoff");

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

    @Override
    public final Kind _kind() {
        return _kind;
    }

    @Override
    public final SmoothingModelVariant _get() {
        return _value;
    }

    public SmoothingModel(SmoothingModelVariant value) {
        this._kind = ApiTypeHelper.requireNonNull(value._smoothingModelKind(), this, "<variant kind>");
        this._value = ApiTypeHelper.requireNonNull(value, this, "<variant value>");
    }

    private SmoothingModel(Builder builder) {
        this._kind = ApiTypeHelper.requireNonNull(builder._kind, builder, "<variant kind>");
        this._value = ApiTypeHelper.requireNonNull(builder._value, builder, "<variant value>");
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

    @Override
    public void serialize(JsonGenerator generator, JsonpMapper mapper) {
        generator.writeStartObject();
        generator.writeKey(_kind.jsonValue());
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

        public Builder() {}

        private Builder(SmoothingModel o) {
            this._kind = o._kind;
            this._value = o._value;
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
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        SmoothingModel other = (SmoothingModel) o;
        return Objects.equals(this._kind, other._kind) && Objects.equals(this._value, other._value);
    }
}
