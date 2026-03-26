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
import org.opensearch.client.opensearch._types.GeoLocation;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: _types.aggregations.GeoCentroidAggregate

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class GeoCentroidAggregate implements PlainJsonSerializable, ToCopyableBuilder<GeoCentroidAggregate.Builder, GeoCentroidAggregate> {

    private final long count;

    @Nullable
    private final GeoLocation location;

    // ---------------------------------------------------------------------------------------------

    private GeoCentroidAggregate(Builder builder) {
        this.count = ApiTypeHelper.requireNonNull(builder.count, this, "count");
        this.location = builder.location;
    }

    public static GeoCentroidAggregate of(Function<GeoCentroidAggregate.Builder, ObjectBuilder<GeoCentroidAggregate>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - API name: {@code count}
     */
    public final long count() {
        return this.count;
    }

    /**
     * API name: {@code location}
     */
    @Nullable
    public final GeoLocation location() {
        return this.location;
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

        if (this.location != null) {
            generator.writeKey("location");
            this.location.serialize(generator, mapper);
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
     * Builder for {@link GeoCentroidAggregate}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, GeoCentroidAggregate> {
        private Long count;
        @Nullable
        private GeoLocation location;

        public Builder() {}

        private Builder(GeoCentroidAggregate o) {
            this.count = o.count;
            this.location = o.location;
        }

        private Builder(Builder o) {
            this.count = o.count;
            this.location = o.location;
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
         * API name: {@code location}
         */
        @Nonnull
        public final Builder location(@Nullable GeoLocation value) {
            this.location = value;
            return this;
        }

        /**
         * API name: {@code location}
         */
        @Nonnull
        public final Builder location(Function<GeoLocation.Builder, ObjectBuilder<GeoLocation>> fn) {
            return location(fn.apply(new GeoLocation.Builder()).build());
        }

        /**
         * Builds a {@link GeoCentroidAggregate}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public GeoCentroidAggregate build() {
            _checkSingleUse();

            return new GeoCentroidAggregate(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link GeoCentroidAggregate}
     */
    public static final JsonpDeserializer<GeoCentroidAggregate> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        GeoCentroidAggregate::setupGeoCentroidAggregateDeserializer
    );

    protected static void setupGeoCentroidAggregateDeserializer(ObjectDeserializer<GeoCentroidAggregate.Builder> op) {
        op.add(Builder::count, JsonpDeserializer.longDeserializer(), "count");
        op.add(Builder::location, GeoLocation._DESERIALIZER, "location");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Long.hashCode(this.count);
        result = 31 * result + Objects.hashCode(this.location);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        GeoCentroidAggregate other = (GeoCentroidAggregate) o;
        return this.count == other.count && Objects.equals(this.location, other.location);
    }
}
