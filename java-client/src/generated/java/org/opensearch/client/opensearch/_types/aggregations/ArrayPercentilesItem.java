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
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: _types.aggregations.ArrayPercentilesItem

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class ArrayPercentilesItem implements PlainJsonSerializable, ToCopyableBuilder<ArrayPercentilesItem.Builder, ArrayPercentilesItem> {

    @Nonnull
    private final String key;

    @Nullable
    private final Double value;

    @Nullable
    private final String valueAsString;

    // ---------------------------------------------------------------------------------------------

    private ArrayPercentilesItem(Builder builder) {
        this.key = ApiTypeHelper.requireNonNull(builder.key, this, "key");
        this.value = builder.value;
        this.valueAsString = builder.valueAsString;
    }

    public static ArrayPercentilesItem of(Function<ArrayPercentilesItem.Builder, ObjectBuilder<ArrayPercentilesItem>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - API name: {@code key}
     */
    @Nonnull
    public final String key() {
        return this.key;
    }

    /**
     * API name: {@code value}
     */
    @Nullable
    public final Double value() {
        return this.value;
    }

    /**
     * API name: {@code value_as_string}
     */
    @Nullable
    public final String valueAsString() {
        return this.valueAsString;
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
        generator.writeKey("key");
        generator.write(this.key);

        if (this.value != null) {
            generator.writeKey("value");
            generator.write(this.value);
        }

        if (this.valueAsString != null) {
            generator.writeKey("value_as_string");
            generator.write(this.valueAsString);
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
     * Builder for {@link ArrayPercentilesItem}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, ArrayPercentilesItem> {
        private String key;
        @Nullable
        private Double value;
        @Nullable
        private String valueAsString;

        public Builder() {}

        private Builder(ArrayPercentilesItem o) {
            this.key = o.key;
            this.value = o.value;
            this.valueAsString = o.valueAsString;
        }

        private Builder(Builder o) {
            this.key = o.key;
            this.value = o.value;
            this.valueAsString = o.valueAsString;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - API name: {@code key}
         */
        @Nonnull
        public final Builder key(String value) {
            this.key = value;
            return this;
        }

        /**
         * API name: {@code value}
         */
        @Nonnull
        public final Builder value(@Nullable Double value) {
            this.value = value;
            return this;
        }

        /**
         * API name: {@code value_as_string}
         */
        @Nonnull
        public final Builder valueAsString(@Nullable String value) {
            this.valueAsString = value;
            return this;
        }

        /**
         * Builds a {@link ArrayPercentilesItem}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public ArrayPercentilesItem build() {
            _checkSingleUse();

            return new ArrayPercentilesItem(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link ArrayPercentilesItem}
     */
    public static final JsonpDeserializer<ArrayPercentilesItem> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        ArrayPercentilesItem::setupArrayPercentilesItemDeserializer
    );

    protected static void setupArrayPercentilesItemDeserializer(ObjectDeserializer<ArrayPercentilesItem.Builder> op) {
        op.add(Builder::key, JsonpDeserializer.stringDeserializer(), "key");
        op.add(Builder::value, JsonpDeserializer.doubleDeserializer(), "value");
        op.add(Builder::valueAsString, JsonpDeserializer.stringDeserializer(), "value_as_string");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.key.hashCode();
        result = 31 * result + Objects.hashCode(this.value);
        result = 31 * result + Objects.hashCode(this.valueAsString);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        ArrayPercentilesItem other = (ArrayPercentilesItem) o;
        return this.key.equals(other.key)
            && Objects.equals(this.value, other.value)
            && Objects.equals(this.valueAsString, other.valueAsString);
    }
}
