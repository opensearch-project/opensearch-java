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
import org.opensearch.client.json.PlainJsonSerializable;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: _types.aggregations.ChiSquareHeuristic

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class ChiSquareHeuristic implements PlainJsonSerializable, ToCopyableBuilder<ChiSquareHeuristic.Builder, ChiSquareHeuristic> {

    private final boolean backgroundIsSuperset;

    private final boolean includeNegatives;

    // ---------------------------------------------------------------------------------------------

    private ChiSquareHeuristic(Builder builder) {
        this.backgroundIsSuperset = ApiTypeHelper.requireNonNull(builder.backgroundIsSuperset, this, "backgroundIsSuperset");
        this.includeNegatives = ApiTypeHelper.requireNonNull(builder.includeNegatives, this, "includeNegatives");
    }

    public static ChiSquareHeuristic of(Function<ChiSquareHeuristic.Builder, ObjectBuilder<ChiSquareHeuristic>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - Set to <code>false</code> if you defined a custom background filter that represents a different set of documents that you
     * want to compare to.
     * <p>
     * API name: {@code background_is_superset}
     * </p>
     */
    public final boolean backgroundIsSuperset() {
        return this.backgroundIsSuperset;
    }

    /**
     * Required - Set to <code>false</code> to filter out the terms that appear less often in the subset than in documents outside the
     * subset.
     * <p>
     * API name: {@code include_negatives}
     * </p>
     */
    public final boolean includeNegatives() {
        return this.includeNegatives;
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
        generator.writeKey("background_is_superset");
        generator.write(this.backgroundIsSuperset);

        generator.writeKey("include_negatives");
        generator.write(this.includeNegatives);
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
     * Builder for {@link ChiSquareHeuristic}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, ChiSquareHeuristic> {
        private Boolean backgroundIsSuperset;
        private Boolean includeNegatives;

        public Builder() {}

        private Builder(ChiSquareHeuristic o) {
            this.backgroundIsSuperset = o.backgroundIsSuperset;
            this.includeNegatives = o.includeNegatives;
        }

        private Builder(Builder o) {
            this.backgroundIsSuperset = o.backgroundIsSuperset;
            this.includeNegatives = o.includeNegatives;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - Set to <code>false</code> if you defined a custom background filter that represents a different set of documents that
         * you want to compare to.
         * <p>
         * API name: {@code background_is_superset}
         * </p>
         */
        @Nonnull
        public final Builder backgroundIsSuperset(boolean value) {
            this.backgroundIsSuperset = value;
            return this;
        }

        /**
         * Required - Set to <code>false</code> to filter out the terms that appear less often in the subset than in documents outside the
         * subset.
         * <p>
         * API name: {@code include_negatives}
         * </p>
         */
        @Nonnull
        public final Builder includeNegatives(boolean value) {
            this.includeNegatives = value;
            return this;
        }

        /**
         * Builds a {@link ChiSquareHeuristic}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public ChiSquareHeuristic build() {
            _checkSingleUse();

            return new ChiSquareHeuristic(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link ChiSquareHeuristic}
     */
    public static final JsonpDeserializer<ChiSquareHeuristic> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        ChiSquareHeuristic::setupChiSquareHeuristicDeserializer
    );

    protected static void setupChiSquareHeuristicDeserializer(ObjectDeserializer<ChiSquareHeuristic.Builder> op) {
        op.add(Builder::backgroundIsSuperset, JsonpDeserializer.booleanDeserializer(), "background_is_superset");
        op.add(Builder::includeNegatives, JsonpDeserializer.booleanDeserializer(), "include_negatives");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Boolean.hashCode(this.backgroundIsSuperset);
        result = 31 * result + Boolean.hashCode(this.includeNegatives);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        ChiSquareHeuristic other = (ChiSquareHeuristic) o;
        return this.backgroundIsSuperset == other.backgroundIsSuperset && this.includeNegatives == other.includeNegatives;
    }
}
