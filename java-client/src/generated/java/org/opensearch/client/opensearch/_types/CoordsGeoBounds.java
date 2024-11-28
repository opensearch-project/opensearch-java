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

// typedef: _types.CoordsGeoBounds

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class CoordsGeoBounds implements PlainJsonSerializable, ToCopyableBuilder<CoordsGeoBounds.Builder, CoordsGeoBounds> {

    private final double bottom;

    private final double left;

    private final double right;

    private final double top;

    // ---------------------------------------------------------------------------------------------

    private CoordsGeoBounds(Builder builder) {
        this.bottom = ApiTypeHelper.requireNonNull(builder.bottom, this, "bottom");
        this.left = ApiTypeHelper.requireNonNull(builder.left, this, "left");
        this.right = ApiTypeHelper.requireNonNull(builder.right, this, "right");
        this.top = ApiTypeHelper.requireNonNull(builder.top, this, "top");
    }

    public static CoordsGeoBounds of(Function<CoordsGeoBounds.Builder, ObjectBuilder<CoordsGeoBounds>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - API name: {@code bottom}
     */
    public final double bottom() {
        return this.bottom;
    }

    /**
     * Required - API name: {@code left}
     */
    public final double left() {
        return this.left;
    }

    /**
     * Required - API name: {@code right}
     */
    public final double right() {
        return this.right;
    }

    /**
     * Required - API name: {@code top}
     */
    public final double top() {
        return this.top;
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
        generator.writeKey("bottom");
        generator.write(this.bottom);

        generator.writeKey("left");
        generator.write(this.left);

        generator.writeKey("right");
        generator.write(this.right);

        generator.writeKey("top");
        generator.write(this.top);
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
     * Builder for {@link CoordsGeoBounds}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, CoordsGeoBounds> {
        private Double bottom;
        private Double left;
        private Double right;
        private Double top;

        public Builder() {}

        private Builder(CoordsGeoBounds o) {
            this.bottom = o.bottom;
            this.left = o.left;
            this.right = o.right;
            this.top = o.top;
        }

        private Builder(Builder o) {
            this.bottom = o.bottom;
            this.left = o.left;
            this.right = o.right;
            this.top = o.top;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - API name: {@code bottom}
         */
        @Nonnull
        public final Builder bottom(double value) {
            this.bottom = value;
            return this;
        }

        /**
         * Required - API name: {@code left}
         */
        @Nonnull
        public final Builder left(double value) {
            this.left = value;
            return this;
        }

        /**
         * Required - API name: {@code right}
         */
        @Nonnull
        public final Builder right(double value) {
            this.right = value;
            return this;
        }

        /**
         * Required - API name: {@code top}
         */
        @Nonnull
        public final Builder top(double value) {
            this.top = value;
            return this;
        }

        /**
         * Builds a {@link CoordsGeoBounds}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public CoordsGeoBounds build() {
            _checkSingleUse();

            return new CoordsGeoBounds(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link CoordsGeoBounds}
     */
    public static final JsonpDeserializer<CoordsGeoBounds> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        CoordsGeoBounds::setupCoordsGeoBoundsDeserializer
    );

    protected static void setupCoordsGeoBoundsDeserializer(ObjectDeserializer<CoordsGeoBounds.Builder> op) {
        op.add(Builder::bottom, JsonpDeserializer.doubleDeserializer(), "bottom");
        op.add(Builder::left, JsonpDeserializer.doubleDeserializer(), "left");
        op.add(Builder::right, JsonpDeserializer.doubleDeserializer(), "right");
        op.add(Builder::top, JsonpDeserializer.doubleDeserializer(), "top");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Double.hashCode(this.bottom);
        result = 31 * result + Double.hashCode(this.left);
        result = 31 * result + Double.hashCode(this.right);
        result = 31 * result + Double.hashCode(this.top);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        CoordsGeoBounds other = (CoordsGeoBounds) o;
        return this.bottom == other.bottom && this.left == other.left && this.right == other.right && this.top == other.top;
    }
}
