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

// typedef: _types.TopLeftBottomRightGeoBounds

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class TopLeftBottomRightGeoBounds
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<TopLeftBottomRightGeoBounds.Builder, TopLeftBottomRightGeoBounds> {

    @Nonnull
    private final GeoLocation bottomRight;

    @Nonnull
    private final GeoLocation topLeft;

    // ---------------------------------------------------------------------------------------------

    private TopLeftBottomRightGeoBounds(Builder builder) {
        this.bottomRight = ApiTypeHelper.requireNonNull(builder.bottomRight, this, "bottomRight");
        this.topLeft = ApiTypeHelper.requireNonNull(builder.topLeft, this, "topLeft");
    }

    public static TopLeftBottomRightGeoBounds of(
        Function<TopLeftBottomRightGeoBounds.Builder, ObjectBuilder<TopLeftBottomRightGeoBounds>> fn
    ) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - API name: {@code bottom_right}
     */
    @Nonnull
    public final GeoLocation bottomRight() {
        return this.bottomRight;
    }

    /**
     * Required - API name: {@code top_left}
     */
    @Nonnull
    public final GeoLocation topLeft() {
        return this.topLeft;
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
        generator.writeKey("bottom_right");
        this.bottomRight.serialize(generator, mapper);

        generator.writeKey("top_left");
        this.topLeft.serialize(generator, mapper);
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
     * Builder for {@link TopLeftBottomRightGeoBounds}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, TopLeftBottomRightGeoBounds> {
        private GeoLocation bottomRight;
        private GeoLocation topLeft;

        public Builder() {}

        private Builder(TopLeftBottomRightGeoBounds o) {
            this.bottomRight = o.bottomRight;
            this.topLeft = o.topLeft;
        }

        private Builder(Builder o) {
            this.bottomRight = o.bottomRight;
            this.topLeft = o.topLeft;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - API name: {@code bottom_right}
         */
        @Nonnull
        public final Builder bottomRight(GeoLocation value) {
            this.bottomRight = value;
            return this;
        }

        /**
         * Required - API name: {@code bottom_right}
         */
        @Nonnull
        public final Builder bottomRight(Function<GeoLocation.Builder, ObjectBuilder<GeoLocation>> fn) {
            return bottomRight(fn.apply(new GeoLocation.Builder()).build());
        }

        /**
         * Required - API name: {@code top_left}
         */
        @Nonnull
        public final Builder topLeft(GeoLocation value) {
            this.topLeft = value;
            return this;
        }

        /**
         * Required - API name: {@code top_left}
         */
        @Nonnull
        public final Builder topLeft(Function<GeoLocation.Builder, ObjectBuilder<GeoLocation>> fn) {
            return topLeft(fn.apply(new GeoLocation.Builder()).build());
        }

        /**
         * Builds a {@link TopLeftBottomRightGeoBounds}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public TopLeftBottomRightGeoBounds build() {
            _checkSingleUse();

            return new TopLeftBottomRightGeoBounds(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link TopLeftBottomRightGeoBounds}
     */
    public static final JsonpDeserializer<TopLeftBottomRightGeoBounds> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        TopLeftBottomRightGeoBounds::setupTopLeftBottomRightGeoBoundsDeserializer
    );

    protected static void setupTopLeftBottomRightGeoBoundsDeserializer(ObjectDeserializer<TopLeftBottomRightGeoBounds.Builder> op) {
        op.add(Builder::bottomRight, GeoLocation._DESERIALIZER, "bottom_right");
        op.add(Builder::topLeft, GeoLocation._DESERIALIZER, "top_left");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.bottomRight.hashCode();
        result = 31 * result + this.topLeft.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        TopLeftBottomRightGeoBounds other = (TopLeftBottomRightGeoBounds) o;
        return this.bottomRight.equals(other.bottomRight) && this.topLeft.equals(other.topLeft);
    }
}
