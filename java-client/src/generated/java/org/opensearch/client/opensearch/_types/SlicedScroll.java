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

// typedef: _types.SlicedScroll

/**
 * The configuration for a sliced scroll request.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class SlicedScroll implements PlainJsonSerializable, ToCopyableBuilder<SlicedScroll.Builder, SlicedScroll> {

    @Nullable
    private final String field;

    private final int id;

    private final int max;

    // ---------------------------------------------------------------------------------------------

    private SlicedScroll(Builder builder) {
        this.field = builder.field;
        this.id = ApiTypeHelper.requireNonNull(builder.id, this, "id");
        this.max = ApiTypeHelper.requireNonNull(builder.max, this, "max");
    }

    public static SlicedScroll of(Function<SlicedScroll.Builder, ObjectBuilder<SlicedScroll>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * The field to slice on.
     * <p>
     * API name: {@code field}
     * </p>
     */
    @Nullable
    public final String field() {
        return this.field;
    }

    /**
     * Required - The ID of the slice.
     * <p>
     * API name: {@code id}
     * </p>
     */
    public final int id() {
        return this.id;
    }

    /**
     * Required - The maximum number of slices.
     * <p>
     * API name: {@code max}
     * </p>
     */
    public final int max() {
        return this.max;
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
        if (this.field != null) {
            generator.writeKey("field");
            generator.write(this.field);
        }

        generator.writeKey("id");
        generator.write(this.id);

        generator.writeKey("max");
        generator.write(this.max);
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
     * Builder for {@link SlicedScroll}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, SlicedScroll> {
        @Nullable
        private String field;
        private Integer id;
        private Integer max;

        public Builder() {}

        private Builder(SlicedScroll o) {
            this.field = o.field;
            this.id = o.id;
            this.max = o.max;
        }

        private Builder(Builder o) {
            this.field = o.field;
            this.id = o.id;
            this.max = o.max;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * The field to slice on.
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
         * Required - The ID of the slice.
         * <p>
         * API name: {@code id}
         * </p>
         */
        @Nonnull
        public final Builder id(int value) {
            this.id = value;
            return this;
        }

        /**
         * Required - The maximum number of slices.
         * <p>
         * API name: {@code max}
         * </p>
         */
        @Nonnull
        public final Builder max(int value) {
            this.max = value;
            return this;
        }

        /**
         * Builds a {@link SlicedScroll}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public SlicedScroll build() {
            _checkSingleUse();

            return new SlicedScroll(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link SlicedScroll}
     */
    public static final JsonpDeserializer<SlicedScroll> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        SlicedScroll::setupSlicedScrollDeserializer
    );

    protected static void setupSlicedScrollDeserializer(ObjectDeserializer<SlicedScroll.Builder> op) {
        op.add(Builder::field, JsonpDeserializer.stringDeserializer(), "field");
        op.add(Builder::id, JsonpDeserializer.integerDeserializer(), "id");
        op.add(Builder::max, JsonpDeserializer.integerDeserializer(), "max");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.field);
        result = 31 * result + Integer.hashCode(this.id);
        result = 31 * result + Integer.hashCode(this.max);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        SlicedScroll other = (SlicedScroll) o;
        return Objects.equals(this.field, other.field) && this.id == other.id && this.max == other.max;
    }
}
