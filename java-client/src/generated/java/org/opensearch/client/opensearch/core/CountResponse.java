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

package org.opensearch.client.opensearch.core;

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
import org.opensearch.client.opensearch._types.ShardStatistics;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: _global.count.Response

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class CountResponse implements PlainJsonSerializable, ToCopyableBuilder<CountResponse.Builder, CountResponse> {

    private final long count;

    @Nonnull
    private final ShardStatistics shards;

    @Nullable
    private final Boolean terminatedEarly;

    // ---------------------------------------------------------------------------------------------

    private CountResponse(Builder builder) {
        this.count = ApiTypeHelper.requireNonNull(builder.count, this, "count");
        this.shards = ApiTypeHelper.requireNonNull(builder.shards, this, "shards");
        this.terminatedEarly = builder.terminatedEarly;
    }

    public static CountResponse of(Function<CountResponse.Builder, ObjectBuilder<CountResponse>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - API name: {@code count}
     */
    public final long count() {
        return this.count;
    }

    /**
     * Required - API name: {@code _shards}
     */
    @Nonnull
    public final ShardStatistics shards() {
        return this.shards;
    }

    /**
     * API name: {@code terminated_early}
     */
    @Nullable
    public final Boolean terminatedEarly() {
        return this.terminatedEarly;
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
        generator.writeKey("count");
        generator.write(this.count);

        generator.writeKey("_shards");
        this.shards.serialize(generator, mapper);

        if (this.terminatedEarly != null) {
            generator.writeKey("terminated_early");
            generator.write(this.terminatedEarly);
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
     * Builder for {@link CountResponse}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, CountResponse> {
        private Long count;
        private ShardStatistics shards;
        @Nullable
        private Boolean terminatedEarly;

        public Builder() {}

        private Builder(CountResponse o) {
            this.count = o.count;
            this.shards = o.shards;
            this.terminatedEarly = o.terminatedEarly;
        }

        private Builder(Builder o) {
            this.count = o.count;
            this.shards = o.shards;
            this.terminatedEarly = o.terminatedEarly;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - API name: {@code count}
         */
        @Nonnull
        public final Builder count(long value) {
            this.count = value;
            return this;
        }

        /**
         * Required - API name: {@code _shards}
         */
        @Nonnull
        public final Builder shards(ShardStatistics value) {
            this.shards = value;
            return this;
        }

        /**
         * Required - API name: {@code _shards}
         */
        @Nonnull
        public final Builder shards(Function<ShardStatistics.Builder, ObjectBuilder<ShardStatistics>> fn) {
            return shards(fn.apply(new ShardStatistics.Builder()).build());
        }

        /**
         * API name: {@code terminated_early}
         */
        @Nonnull
        public final Builder terminatedEarly(@Nullable Boolean value) {
            this.terminatedEarly = value;
            return this;
        }

        /**
         * Builds a {@link CountResponse}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public CountResponse build() {
            _checkSingleUse();

            return new CountResponse(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link CountResponse}
     */
    public static final JsonpDeserializer<CountResponse> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        CountResponse::setupCountResponseDeserializer
    );

    protected static void setupCountResponseDeserializer(ObjectDeserializer<CountResponse.Builder> op) {
        op.add(Builder::count, JsonpDeserializer.longDeserializer(), "count");
        op.add(Builder::shards, ShardStatistics._DESERIALIZER, "_shards");
        op.add(Builder::terminatedEarly, JsonpDeserializer.booleanDeserializer(), "terminated_early");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Long.hashCode(this.count);
        result = 31 * result + this.shards.hashCode();
        result = 31 * result + Objects.hashCode(this.terminatedEarly);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        CountResponse other = (CountResponse) o;
        return this.count == other.count && this.shards.equals(other.shards) && Objects.equals(this.terminatedEarly, other.terminatedEarly);
    }
}
