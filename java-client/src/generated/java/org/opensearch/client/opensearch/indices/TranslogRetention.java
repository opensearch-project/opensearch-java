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

package org.opensearch.client.opensearch.indices;

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
import org.opensearch.client.opensearch._types.Time;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: indices.TranslogRetention

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class TranslogRetention implements PlainJsonSerializable, ToCopyableBuilder<TranslogRetention.Builder, TranslogRetention> {

    @Nullable
    private final Time age;

    @Nullable
    private final String size;

    // ---------------------------------------------------------------------------------------------

    private TranslogRetention(Builder builder) {
        this.age = builder.age;
        this.size = builder.size;
    }

    public static TranslogRetention of(Function<TranslogRetention.Builder, ObjectBuilder<TranslogRetention>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code age}
     */
    @Nullable
    public final Time age() {
        return this.age;
    }

    /**
     * API name: {@code size}
     */
    @Nullable
    public final String size() {
        return this.size;
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
        if (this.age != null) {
            generator.writeKey("age");
            this.age.serialize(generator, mapper);
        }

        if (this.size != null) {
            generator.writeKey("size");
            generator.write(this.size);
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
     * Builder for {@link TranslogRetention}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, TranslogRetention> {
        @Nullable
        private Time age;
        @Nullable
        private String size;

        public Builder() {}

        private Builder(TranslogRetention o) {
            this.age = o.age;
            this.size = o.size;
        }

        private Builder(Builder o) {
            this.age = o.age;
            this.size = o.size;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code age}
         */
        @Nonnull
        public final Builder age(@Nullable Time value) {
            this.age = value;
            return this;
        }

        /**
         * API name: {@code age}
         */
        @Nonnull
        public final Builder age(Function<Time.Builder, ObjectBuilder<Time>> fn) {
            return age(fn.apply(new Time.Builder()).build());
        }

        /**
         * API name: {@code size}
         */
        @Nonnull
        public final Builder size(@Nullable String value) {
            this.size = value;
            return this;
        }

        /**
         * Builds a {@link TranslogRetention}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public TranslogRetention build() {
            _checkSingleUse();

            return new TranslogRetention(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link TranslogRetention}
     */
    public static final JsonpDeserializer<TranslogRetention> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        TranslogRetention::setupTranslogRetentionDeserializer
    );

    protected static void setupTranslogRetentionDeserializer(ObjectDeserializer<TranslogRetention.Builder> op) {
        op.add(Builder::age, Time._DESERIALIZER, "age");
        op.add(Builder::size, JsonpDeserializer.stringDeserializer(), "size");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.age);
        result = 31 * result + Objects.hashCode(this.size);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        TranslogRetention other = (TranslogRetention) o;
        return Objects.equals(this.age, other.age) && Objects.equals(this.size, other.size);
    }
}
