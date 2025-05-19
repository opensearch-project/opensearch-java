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
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import org.opensearch.client.json.JsonpDeserializable;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.ObjectBuilderDeserializer;
import org.opensearch.client.json.ObjectDeserializer;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: _types.aggregations.GeoTileGridBucket

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class GeoTileGridBucket extends MultiBucketBase implements ToCopyableBuilder<GeoTileGridBucket.Builder, GeoTileGridBucket> {

    @Nonnull
    private final String key;

    // ---------------------------------------------------------------------------------------------

    private GeoTileGridBucket(Builder builder) {
        super(builder);
        this.key = ApiTypeHelper.requireNonNull(builder.key, this, "key");
    }

    public static GeoTileGridBucket of(Function<GeoTileGridBucket.Builder, ObjectBuilder<GeoTileGridBucket>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - API name: {@code key}
     */
    @Nonnull
    public final String key() {
        return this.key;
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        super.serializeInternal(generator, mapper);
        generator.writeKey("key");
        generator.write(this.key);
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
     * Builder for {@link GeoTileGridBucket}.
     */
    public static class Builder extends MultiBucketBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, GeoTileGridBucket> {
        private String key;

        public Builder() {}

        private Builder(GeoTileGridBucket o) {
            super(o);
            this.key = o.key;
        }

        private Builder(Builder o) {
            super(o);
            this.key = o.key;
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
         * Required - API name: {@code key}
         */
        @Nonnull
        public final Builder key(String value) {
            this.key = value;
            return this;
        }

        /**
         * Builds a {@link GeoTileGridBucket}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public GeoTileGridBucket build() {
            _checkSingleUse();

            return new GeoTileGridBucket(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link GeoTileGridBucket}
     */
    public static final JsonpDeserializer<GeoTileGridBucket> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        GeoTileGridBucket::setupGeoTileGridBucketDeserializer
    );

    protected static void setupGeoTileGridBucketDeserializer(ObjectDeserializer<GeoTileGridBucket.Builder> op) {
        setupMultiBucketBaseDeserializer(op);
        op.add(Builder::key, JsonpDeserializer.stringDeserializer(), "key");
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + this.key.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        GeoTileGridBucket other = (GeoTileGridBucket) o;
        return this.key.equals(other.key);
    }
}
