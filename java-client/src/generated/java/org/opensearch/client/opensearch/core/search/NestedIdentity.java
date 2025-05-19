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

// typedef: core.search.NestedIdentity

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class NestedIdentity implements PlainJsonSerializable, ToCopyableBuilder<NestedIdentity.Builder, NestedIdentity> {

    @Nonnull
    private final String field;

    @Nullable
    private final NestedIdentity nested;

    private final int offset;

    // ---------------------------------------------------------------------------------------------

    private NestedIdentity(Builder builder) {
        this.field = ApiTypeHelper.requireNonNull(builder.field, this, "field");
        this.nested = builder.nested;
        this.offset = ApiTypeHelper.requireNonNull(builder.offset, this, "offset");
    }

    public static NestedIdentity of(Function<NestedIdentity.Builder, ObjectBuilder<NestedIdentity>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - API name: {@code field}
     */
    @Nonnull
    public final String field() {
        return this.field;
    }

    /**
     * API name: {@code _nested}
     */
    @Nullable
    public final NestedIdentity nested() {
        return this.nested;
    }

    /**
     * Required - API name: {@code offset}
     */
    public final int offset() {
        return this.offset;
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
        generator.writeKey("field");
        generator.write(this.field);

        if (this.nested != null) {
            generator.writeKey("_nested");
            this.nested.serialize(generator, mapper);
        }

        generator.writeKey("offset");
        generator.write(this.offset);
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
     * Builder for {@link NestedIdentity}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, NestedIdentity> {
        private String field;
        @Nullable
        private NestedIdentity nested;
        private Integer offset;

        public Builder() {}

        private Builder(NestedIdentity o) {
            this.field = o.field;
            this.nested = o.nested;
            this.offset = o.offset;
        }

        private Builder(Builder o) {
            this.field = o.field;
            this.nested = o.nested;
            this.offset = o.offset;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - API name: {@code field}
         */
        @Nonnull
        public final Builder field(String value) {
            this.field = value;
            return this;
        }

        /**
         * API name: {@code _nested}
         */
        @Nonnull
        public final Builder nested(@Nullable NestedIdentity value) {
            this.nested = value;
            return this;
        }

        /**
         * API name: {@code _nested}
         */
        @Nonnull
        public final Builder nested(Function<NestedIdentity.Builder, ObjectBuilder<NestedIdentity>> fn) {
            return nested(fn.apply(new NestedIdentity.Builder()).build());
        }

        /**
         * Required - API name: {@code offset}
         */
        @Nonnull
        public final Builder offset(int value) {
            this.offset = value;
            return this;
        }

        /**
         * Builds a {@link NestedIdentity}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public NestedIdentity build() {
            _checkSingleUse();

            return new NestedIdentity(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link NestedIdentity}
     */
    public static final JsonpDeserializer<NestedIdentity> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        NestedIdentity::setupNestedIdentityDeserializer
    );

    protected static void setupNestedIdentityDeserializer(ObjectDeserializer<NestedIdentity.Builder> op) {
        op.add(Builder::field, JsonpDeserializer.stringDeserializer(), "field");
        op.add(Builder::nested, NestedIdentity._DESERIALIZER, "_nested");
        op.add(Builder::offset, JsonpDeserializer.integerDeserializer(), "offset");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.field.hashCode();
        result = 31 * result + Objects.hashCode(this.nested);
        result = 31 * result + Integer.hashCode(this.offset);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        NestedIdentity other = (NestedIdentity) o;
        return this.field.equals(other.field) && Objects.equals(this.nested, other.nested) && this.offset == other.offset;
    }
}
