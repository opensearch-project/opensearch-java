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

package org.opensearch.client.opensearch._types;

import jakarta.json.stream.JsonGenerator;
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
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

// typedef: _types.TopRightBottomLeftGeoBounds

/**
 * The geographical bounds specified using upper-right and lower-left points.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class TopRightBottomLeftGeoBounds
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<TopRightBottomLeftGeoBounds.Builder, TopRightBottomLeftGeoBounds> {

    @Nonnull
    private final GeoLocation bottomLeft;

    @Nonnull
    private final GeoLocation topRight;

    // ---------------------------------------------------------------------------------------------

    private TopRightBottomLeftGeoBounds(Builder builder) {
        this.bottomLeft = ApiTypeHelper.requireNonNull(builder.bottomLeft, this, "bottomLeft");
        this.topRight = ApiTypeHelper.requireNonNull(builder.topRight, this, "topRight");
    }

    public static TopRightBottomLeftGeoBounds of(
        Function<TopRightBottomLeftGeoBounds.Builder, ObjectBuilder<TopRightBottomLeftGeoBounds>> fn
    ) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - The lower-left corner coordinates.
     * <p>
     * API name: {@code bottom_left}
     * </p>
     */
    @Nonnull
    public final GeoLocation bottomLeft() {
        return this.bottomLeft;
    }

    /**
     * Required - The upper-right corner coordinates.
     * <p>
     * API name: {@code top_right}
     * </p>
     */
    @Nonnull
    public final GeoLocation topRight() {
        return this.topRight;
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
        generator.writeKey("bottom_left");
        this.bottomLeft.serialize(generator, mapper);

        generator.writeKey("top_right");
        this.topRight.serialize(generator, mapper);
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
     * Builder for {@link TopRightBottomLeftGeoBounds}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, TopRightBottomLeftGeoBounds> {
        private GeoLocation bottomLeft;
        private GeoLocation topRight;

        public Builder() {}

        private Builder(TopRightBottomLeftGeoBounds o) {
            this.bottomLeft = o.bottomLeft;
            this.topRight = o.topRight;
        }

        private Builder(Builder o) {
            this.bottomLeft = o.bottomLeft;
            this.topRight = o.topRight;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - The lower-left corner coordinates.
         * <p>
         * API name: {@code bottom_left}
         * </p>
         */
        @Nonnull
        public final Builder bottomLeft(GeoLocation value) {
            this.bottomLeft = value;
            return this;
        }

        /**
         * Required - The lower-left corner coordinates.
         * <p>
         * API name: {@code bottom_left}
         * </p>
         */
        @Nonnull
        public final Builder bottomLeft(Function<GeoLocation.Builder, ObjectBuilder<GeoLocation>> fn) {
            return bottomLeft(fn.apply(new GeoLocation.Builder()).build());
        }

        /**
         * Required - The upper-right corner coordinates.
         * <p>
         * API name: {@code top_right}
         * </p>
         */
        @Nonnull
        public final Builder topRight(GeoLocation value) {
            this.topRight = value;
            return this;
        }

        /**
         * Required - The upper-right corner coordinates.
         * <p>
         * API name: {@code top_right}
         * </p>
         */
        @Nonnull
        public final Builder topRight(Function<GeoLocation.Builder, ObjectBuilder<GeoLocation>> fn) {
            return topRight(fn.apply(new GeoLocation.Builder()).build());
        }

        /**
         * Builds a {@link TopRightBottomLeftGeoBounds}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public TopRightBottomLeftGeoBounds build() {
            _checkSingleUse();

            return new TopRightBottomLeftGeoBounds(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link TopRightBottomLeftGeoBounds}
     */
    public static final JsonpDeserializer<TopRightBottomLeftGeoBounds> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        TopRightBottomLeftGeoBounds::setupTopRightBottomLeftGeoBoundsDeserializer
    );

    protected static void setupTopRightBottomLeftGeoBoundsDeserializer(ObjectDeserializer<TopRightBottomLeftGeoBounds.Builder> op) {
        op.add(Builder::bottomLeft, GeoLocation._DESERIALIZER, "bottom_left");
        op.add(Builder::topRight, GeoLocation._DESERIALIZER, "top_right");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.bottomLeft.hashCode();
        result = 31 * result + this.topRight.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        TopRightBottomLeftGeoBounds other = (TopRightBottomLeftGeoBounds) o;
        return this.bottomLeft.equals(other.bottomLeft) && this.topRight.equals(other.topRight);
    }
}
