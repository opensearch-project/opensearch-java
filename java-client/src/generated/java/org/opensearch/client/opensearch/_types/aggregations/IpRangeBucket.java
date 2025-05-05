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
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: _types.aggregations.IpRangeBucket

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class IpRangeBucket extends MultiBucketBase implements ToCopyableBuilder<IpRangeBucket.Builder, IpRangeBucket> {

    @Nullable
    private final String from;

    @Nullable
    private final String key;

    @Nullable
    private final String to;

    // ---------------------------------------------------------------------------------------------

    private IpRangeBucket(Builder builder) {
        super(builder);
        this.from = builder.from;
        this.key = builder.key;
        this.to = builder.to;
    }

    public static IpRangeBucket of(Function<IpRangeBucket.Builder, ObjectBuilder<IpRangeBucket>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code from}
     */
    @Nullable
    public final String from() {
        return this.from;
    }

    /**
     * API name: {@code key}
     */
    @Nullable
    public final String key() {
        return this.key;
    }

    /**
     * API name: {@code to}
     */
    @Nullable
    public final String to() {
        return this.to;
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        super.serializeInternal(generator, mapper);
        if (this.from != null) {
            generator.writeKey("from");
            generator.write(this.from);
        }

        if (this.key != null) {
            generator.writeKey("key");
            generator.write(this.key);
        }

        if (this.to != null) {
            generator.writeKey("to");
            generator.write(this.to);
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
     * Builder for {@link IpRangeBucket}.
     */
    public static class Builder extends MultiBucketBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, IpRangeBucket> {
        @Nullable
        private String from;
        @Nullable
        private String key;
        @Nullable
        private String to;

        public Builder() {}

        private Builder(IpRangeBucket o) {
            super(o);
            this.from = o.from;
            this.key = o.key;
            this.to = o.to;
        }

        private Builder(Builder o) {
            super(o);
            this.from = o.from;
            this.key = o.key;
            this.to = o.to;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        @Override
        @Nonnull
        protected Builder self() {
            return this;
        }

        /**
         * API name: {@code from}
         */
        @Nonnull
        public final Builder from(@Nullable String value) {
            this.from = value;
            return this;
        }

        /**
         * API name: {@code key}
         */
        @Nonnull
        public final Builder key(@Nullable String value) {
            this.key = value;
            return this;
        }

        /**
         * API name: {@code to}
         */
        @Nonnull
        public final Builder to(@Nullable String value) {
            this.to = value;
            return this;
        }

        /**
         * Builds a {@link IpRangeBucket}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public IpRangeBucket build() {
            _checkSingleUse();

            return new IpRangeBucket(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link IpRangeBucket}
     */
    public static final JsonpDeserializer<IpRangeBucket> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        IpRangeBucket::setupIpRangeBucketDeserializer
    );

    protected static void setupIpRangeBucketDeserializer(ObjectDeserializer<IpRangeBucket.Builder> op) {
        setupMultiBucketBaseDeserializer(op);
        op.add(Builder::from, JsonpDeserializer.stringDeserializer(), "from");
        op.add(Builder::key, JsonpDeserializer.stringDeserializer(), "key");
        op.add(Builder::to, JsonpDeserializer.stringDeserializer(), "to");
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Objects.hashCode(this.from);
        result = 31 * result + Objects.hashCode(this.key);
        result = 31 * result + Objects.hashCode(this.to);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        IpRangeBucket other = (IpRangeBucket) o;
        return Objects.equals(this.from, other.from) && Objects.equals(this.key, other.key) && Objects.equals(this.to, other.to);
    }
}
