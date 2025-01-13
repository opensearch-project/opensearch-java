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
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: _types.aggregations.GoogleNormalizedDistanceHeuristic

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class GoogleNormalizedDistanceHeuristic
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<GoogleNormalizedDistanceHeuristic.Builder, GoogleNormalizedDistanceHeuristic> {

    @Nullable
    private final Boolean backgroundIsSuperset;

    // ---------------------------------------------------------------------------------------------

    private GoogleNormalizedDistanceHeuristic(Builder builder) {
        this.backgroundIsSuperset = builder.backgroundIsSuperset;
    }

    public static GoogleNormalizedDistanceHeuristic of(
        Function<GoogleNormalizedDistanceHeuristic.Builder, ObjectBuilder<GoogleNormalizedDistanceHeuristic>> fn
    ) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Set to <code>false</code> if you defined a custom background filter that represents a different set of documents that you want to
     * compare to.
     * <p>
     * API name: {@code background_is_superset}
     * </p>
     */
    @Nullable
    public final Boolean backgroundIsSuperset() {
        return this.backgroundIsSuperset;
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
        if (this.backgroundIsSuperset != null) {
            generator.writeKey("background_is_superset");
            generator.write(this.backgroundIsSuperset);
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
     * Builder for {@link GoogleNormalizedDistanceHeuristic}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, GoogleNormalizedDistanceHeuristic> {
        @Nullable
        private Boolean backgroundIsSuperset;

        public Builder() {}

        private Builder(GoogleNormalizedDistanceHeuristic o) {
            this.backgroundIsSuperset = o.backgroundIsSuperset;
        }

        private Builder(Builder o) {
            this.backgroundIsSuperset = o.backgroundIsSuperset;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Set to <code>false</code> if you defined a custom background filter that represents a different set of documents that you want to
         * compare to.
         * <p>
         * API name: {@code background_is_superset}
         * </p>
         */
        @Nonnull
        public final Builder backgroundIsSuperset(@Nullable Boolean value) {
            this.backgroundIsSuperset = value;
            return this;
        }

        /**
         * Builds a {@link GoogleNormalizedDistanceHeuristic}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public GoogleNormalizedDistanceHeuristic build() {
            _checkSingleUse();

            return new GoogleNormalizedDistanceHeuristic(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link GoogleNormalizedDistanceHeuristic}
     */
    public static final JsonpDeserializer<GoogleNormalizedDistanceHeuristic> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        GoogleNormalizedDistanceHeuristic::setupGoogleNormalizedDistanceHeuristicDeserializer
    );

    protected static void setupGoogleNormalizedDistanceHeuristicDeserializer(
        ObjectDeserializer<GoogleNormalizedDistanceHeuristic.Builder> op
    ) {
        op.add(Builder::backgroundIsSuperset, JsonpDeserializer.booleanDeserializer(), "background_is_superset");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.backgroundIsSuperset);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        GoogleNormalizedDistanceHeuristic other = (GoogleNormalizedDistanceHeuristic) o;
        return Objects.equals(this.backgroundIsSuperset, other.backgroundIsSuperset);
    }
}
