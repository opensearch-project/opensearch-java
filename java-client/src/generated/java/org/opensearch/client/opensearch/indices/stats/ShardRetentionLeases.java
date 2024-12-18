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

package org.opensearch.client.opensearch.indices.stats;

import jakarta.json.stream.JsonGenerator;
import java.util.List;
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

// typedef: indices.stats.ShardRetentionLeases

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class ShardRetentionLeases implements PlainJsonSerializable, ToCopyableBuilder<ShardRetentionLeases.Builder, ShardRetentionLeases> {

    @Nonnull
    private final List<ShardLease> leases;

    private final long primaryTerm;

    private final long version;

    // ---------------------------------------------------------------------------------------------

    private ShardRetentionLeases(Builder builder) {
        this.leases = ApiTypeHelper.unmodifiableRequired(builder.leases, this, "leases");
        this.primaryTerm = ApiTypeHelper.requireNonNull(builder.primaryTerm, this, "primaryTerm");
        this.version = ApiTypeHelper.requireNonNull(builder.version, this, "version");
    }

    public static ShardRetentionLeases of(Function<ShardRetentionLeases.Builder, ObjectBuilder<ShardRetentionLeases>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - API name: {@code leases}
     */
    @Nonnull
    public final List<ShardLease> leases() {
        return this.leases;
    }

    /**
     * Required - API name: {@code primary_term}
     */
    public final long primaryTerm() {
        return this.primaryTerm;
    }

    /**
     * Required - API name: {@code version}
     */
    public final long version() {
        return this.version;
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
        generator.writeKey("leases");
        generator.writeStartArray();
        for (ShardLease item0 : this.leases) {
            item0.serialize(generator, mapper);
        }
        generator.writeEnd();

        generator.writeKey("primary_term");
        generator.write(this.primaryTerm);

        generator.writeKey("version");
        generator.write(this.version);
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
     * Builder for {@link ShardRetentionLeases}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, ShardRetentionLeases> {
        private List<ShardLease> leases;
        private Long primaryTerm;
        private Long version;

        public Builder() {}

        private Builder(ShardRetentionLeases o) {
            this.leases = _listCopy(o.leases);
            this.primaryTerm = o.primaryTerm;
            this.version = o.version;
        }

        private Builder(Builder o) {
            this.leases = _listCopy(o.leases);
            this.primaryTerm = o.primaryTerm;
            this.version = o.version;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - API name: {@code leases}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>leases</code>.
         * </p>
         */
        @Nonnull
        public final Builder leases(List<ShardLease> list) {
            this.leases = _listAddAll(this.leases, list);
            return this;
        }

        /**
         * Required - API name: {@code leases}
         *
         * <p>
         * Adds one or more values to <code>leases</code>.
         * </p>
         */
        @Nonnull
        public final Builder leases(ShardLease value, ShardLease... values) {
            this.leases = _listAdd(this.leases, value, values);
            return this;
        }

        /**
         * Required - API name: {@code leases}
         *
         * <p>
         * Adds a value to <code>leases</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder leases(Function<ShardLease.Builder, ObjectBuilder<ShardLease>> fn) {
            return leases(fn.apply(new ShardLease.Builder()).build());
        }

        /**
         * Required - API name: {@code primary_term}
         */
        @Nonnull
        public final Builder primaryTerm(long value) {
            this.primaryTerm = value;
            return this;
        }

        /**
         * Required - API name: {@code version}
         */
        @Nonnull
        public final Builder version(long value) {
            this.version = value;
            return this;
        }

        /**
         * Builds a {@link ShardRetentionLeases}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public ShardRetentionLeases build() {
            _checkSingleUse();

            return new ShardRetentionLeases(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link ShardRetentionLeases}
     */
    public static final JsonpDeserializer<ShardRetentionLeases> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        ShardRetentionLeases::setupShardRetentionLeasesDeserializer
    );

    protected static void setupShardRetentionLeasesDeserializer(ObjectDeserializer<ShardRetentionLeases.Builder> op) {
        op.add(Builder::leases, JsonpDeserializer.arrayDeserializer(ShardLease._DESERIALIZER), "leases");
        op.add(Builder::primaryTerm, JsonpDeserializer.longDeserializer(), "primary_term");
        op.add(Builder::version, JsonpDeserializer.longDeserializer(), "version");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.leases.hashCode();
        result = 31 * result + Long.hashCode(this.primaryTerm);
        result = 31 * result + Long.hashCode(this.version);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        ShardRetentionLeases other = (ShardRetentionLeases) o;
        return this.leases.equals(other.leases) && this.primaryTerm == other.primaryTerm && this.version == other.version;
    }
}
