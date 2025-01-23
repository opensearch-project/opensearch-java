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

package org.opensearch.client.opensearch._types.query_dsl;

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
import org.opensearch.client.opensearch._types.GeoLocation;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: _types.query_dsl.GeoPolygonPoints

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class GeoPolygonPoints implements PlainJsonSerializable, ToCopyableBuilder<GeoPolygonPoints.Builder, GeoPolygonPoints> {

    @Nonnull
    private final List<GeoLocation> points;

    // ---------------------------------------------------------------------------------------------

    private GeoPolygonPoints(Builder builder) {
        this.points = ApiTypeHelper.unmodifiableRequired(builder.points, this, "points");
    }

    public static GeoPolygonPoints of(Function<GeoPolygonPoints.Builder, ObjectBuilder<GeoPolygonPoints>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - API name: {@code points}
     */
    @Nonnull
    public final List<GeoLocation> points() {
        return this.points;
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
        generator.writeKey("points");
        generator.writeStartArray();
        for (GeoLocation item0 : this.points) {
            item0.serialize(generator, mapper);
        }
        generator.writeEnd();
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
     * Builder for {@link GeoPolygonPoints}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, GeoPolygonPoints> {
        private List<GeoLocation> points;

        public Builder() {}

        private Builder(GeoPolygonPoints o) {
            this.points = _listCopy(o.points);
        }

        private Builder(Builder o) {
            this.points = _listCopy(o.points);
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - API name: {@code points}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>points</code>.
         * </p>
         */
        @Nonnull
        public final Builder points(List<GeoLocation> list) {
            this.points = _listAddAll(this.points, list);
            return this;
        }

        /**
         * Required - API name: {@code points}
         *
         * <p>
         * Adds one or more values to <code>points</code>.
         * </p>
         */
        @Nonnull
        public final Builder points(GeoLocation value, GeoLocation... values) {
            this.points = _listAdd(this.points, value, values);
            return this;
        }

        /**
         * Required - API name: {@code points}
         *
         * <p>
         * Adds a value to <code>points</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder points(Function<GeoLocation.Builder, ObjectBuilder<GeoLocation>> fn) {
            return points(fn.apply(new GeoLocation.Builder()).build());
        }

        /**
         * Builds a {@link GeoPolygonPoints}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public GeoPolygonPoints build() {
            _checkSingleUse();

            return new GeoPolygonPoints(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link GeoPolygonPoints}
     */
    public static final JsonpDeserializer<GeoPolygonPoints> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        GeoPolygonPoints::setupGeoPolygonPointsDeserializer
    );

    protected static void setupGeoPolygonPointsDeserializer(ObjectDeserializer<GeoPolygonPoints.Builder> op) {
        op.add(Builder::points, JsonpDeserializer.arrayDeserializer(GeoLocation._DESERIALIZER), "points");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.points.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        GeoPolygonPoints other = (GeoPolygonPoints) o;
        return this.points.equals(other.points);
    }
}
