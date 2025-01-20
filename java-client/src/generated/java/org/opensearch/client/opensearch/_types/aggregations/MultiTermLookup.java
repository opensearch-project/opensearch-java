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

package org.opensearch.client.opensearch._types.aggregations;

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
import org.opensearch.client.opensearch._types.FieldValue;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: _types.aggregations.MultiTermLookup

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class MultiTermLookup implements PlainJsonSerializable, ToCopyableBuilder<MultiTermLookup.Builder, MultiTermLookup> {

    @Nonnull
    private final String field;

    @Nullable
    private final FieldValue missing;

    // ---------------------------------------------------------------------------------------------

    private MultiTermLookup(Builder builder) {
        this.field = ApiTypeHelper.requireNonNull(builder.field, this, "field");
        this.missing = builder.missing;
    }

    public static MultiTermLookup of(Function<MultiTermLookup.Builder, ObjectBuilder<MultiTermLookup>> fn) {
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
     * API name: {@code missing}
     */
    @Nullable
    public final FieldValue missing() {
        return this.missing;
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

        if (this.missing != null) {
            generator.writeKey("missing");
            this.missing.serialize(generator, mapper);
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
     * Builder for {@link MultiTermLookup}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, MultiTermLookup> {
        private String field;
        @Nullable
        private FieldValue missing;

        public Builder() {}

        private Builder(MultiTermLookup o) {
            this.field = o.field;
            this.missing = o.missing;
        }

        private Builder(Builder o) {
            this.field = o.field;
            this.missing = o.missing;
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
         * API name: {@code missing}
         */
        @Nonnull
        public final Builder missing(@Nullable FieldValue value) {
            this.missing = value;
            return this;
        }

        /**
         * API name: {@code missing}
         */
        @Nonnull
        public final Builder missing(Function<FieldValue.Builder, ObjectBuilder<FieldValue>> fn) {
            return missing(fn.apply(new FieldValue.Builder()).build());
        }

        /**
         * Builds a {@link MultiTermLookup}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public MultiTermLookup build() {
            _checkSingleUse();

            return new MultiTermLookup(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link MultiTermLookup}
     */
    public static final JsonpDeserializer<MultiTermLookup> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        MultiTermLookup::setupMultiTermLookupDeserializer
    );

    protected static void setupMultiTermLookupDeserializer(ObjectDeserializer<MultiTermLookup.Builder> op) {
        op.add(Builder::field, JsonpDeserializer.stringDeserializer(), "field");
        op.add(Builder::missing, FieldValue._DESERIALIZER, "missing");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.field.hashCode();
        result = 31 * result + Objects.hashCode(this.missing);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        MultiTermLookup other = (MultiTermLookup) o;
        return this.field.equals(other.field) && Objects.equals(this.missing, other.missing);
    }
}
