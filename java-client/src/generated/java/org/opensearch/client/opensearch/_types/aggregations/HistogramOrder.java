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
import org.opensearch.client.opensearch._types.SortOrder;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: _types.aggregations.HistogramOrder

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class HistogramOrder implements PlainJsonSerializable, ToCopyableBuilder<HistogramOrder.Builder, HistogramOrder> {

    @Nullable
    private final SortOrder count;

    @Nullable
    private final SortOrder key;

    // ---------------------------------------------------------------------------------------------

    private HistogramOrder(Builder builder) {
        this.count = builder.count;
        this.key = builder.key;
    }

    public static HistogramOrder of(Function<HistogramOrder.Builder, ObjectBuilder<HistogramOrder>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code _count}
     */
    @Nullable
    public final SortOrder count() {
        return this.count;
    }

    /**
     * API name: {@code _key}
     */
    @Nullable
    public final SortOrder key() {
        return this.key;
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
        if (this.count != null) {
            generator.writeKey("_count");
            this.count.serialize(generator, mapper);
        }

        if (this.key != null) {
            generator.writeKey("_key");
            this.key.serialize(generator, mapper);
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
     * Builder for {@link HistogramOrder}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, HistogramOrder> {
        @Nullable
        private SortOrder count;
        @Nullable
        private SortOrder key;

        public Builder() {}

        private Builder(HistogramOrder o) {
            this.count = o.count;
            this.key = o.key;
        }

        private Builder(Builder o) {
            this.count = o.count;
            this.key = o.key;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code _count}
         */
        @Nonnull
        public final Builder count(@Nullable SortOrder value) {
            this.count = value;
            return this;
        }

        /**
         * API name: {@code _key}
         */
        @Nonnull
        public final Builder key(@Nullable SortOrder value) {
            this.key = value;
            return this;
        }

        /**
         * Builds a {@link HistogramOrder}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public HistogramOrder build() {
            _checkSingleUse();

            return new HistogramOrder(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link HistogramOrder}
     */
    public static final JsonpDeserializer<HistogramOrder> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        HistogramOrder::setupHistogramOrderDeserializer
    );

    protected static void setupHistogramOrderDeserializer(ObjectDeserializer<HistogramOrder.Builder> op) {
        op.add(Builder::count, SortOrder._DESERIALIZER, "_count");
        op.add(Builder::key, SortOrder._DESERIALIZER, "_key");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.count);
        result = 31 * result + Objects.hashCode(this.key);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        HistogramOrder other = (HistogramOrder) o;
        return Objects.equals(this.count, other.count) && Objects.equals(this.key, other.key);
    }
}
