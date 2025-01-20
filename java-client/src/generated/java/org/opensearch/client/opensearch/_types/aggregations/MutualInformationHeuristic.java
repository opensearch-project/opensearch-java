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

// typedef: _types.aggregations.MutualInformationHeuristic

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class MutualInformationHeuristic
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<MutualInformationHeuristic.Builder, MutualInformationHeuristic> {

    @Nullable
    private final Boolean backgroundIsSuperset;

    @Nullable
    private final Boolean includeNegatives;

    // ---------------------------------------------------------------------------------------------

    private MutualInformationHeuristic(Builder builder) {
        this.backgroundIsSuperset = builder.backgroundIsSuperset;
        this.includeNegatives = builder.includeNegatives;
    }

    public static MutualInformationHeuristic of(
        Function<MutualInformationHeuristic.Builder, ObjectBuilder<MutualInformationHeuristic>> fn
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
     * Set to <code>false</code> to filter out the terms that appear less often in the subset than in documents outside the subset.
     * <p>
     * API name: {@code include_negatives}
     * </p>
     */
    @Nullable
    public final Boolean includeNegatives() {
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
        if (this.backgroundIsSuperset != null) {
            generator.writeKey("background_is_superset");
            generator.write(this.backgroundIsSuperset);
        }

        if (this.includeNegatives != null) {
            generator.writeKey("include_negatives");
            generator.write(this.includeNegatives);
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
     * Builder for {@link MutualInformationHeuristic}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, MutualInformationHeuristic> {
        @Nullable
        private Boolean backgroundIsSuperset;
        @Nullable
        private Boolean includeNegatives;

        public Builder() {}

        private Builder(MutualInformationHeuristic o) {
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
         * Set to <code>false</code> to filter out the terms that appear less often in the subset than in documents outside the subset.
         * <p>
         * API name: {@code include_negatives}
         * </p>
         */
        @Nonnull
        public final Builder includeNegatives(@Nullable Boolean value) {
            this.includeNegatives = value;
            return this;
        }

        /**
         * Builds a {@link MutualInformationHeuristic}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public MutualInformationHeuristic build() {
            _checkSingleUse();

            return new MutualInformationHeuristic(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link MutualInformationHeuristic}
     */
    public static final JsonpDeserializer<MutualInformationHeuristic> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        MutualInformationHeuristic::setupMutualInformationHeuristicDeserializer
    );

    protected static void setupMutualInformationHeuristicDeserializer(ObjectDeserializer<MutualInformationHeuristic.Builder> op) {
        op.add(Builder::backgroundIsSuperset, JsonpDeserializer.booleanDeserializer(), "background_is_superset");
        op.add(Builder::includeNegatives, JsonpDeserializer.booleanDeserializer(), "include_negatives");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.backgroundIsSuperset);
        result = 31 * result + Objects.hashCode(this.includeNegatives);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        MutualInformationHeuristic other = (MutualInformationHeuristic) o;
        return Objects.equals(this.backgroundIsSuperset, other.backgroundIsSuperset)
            && Objects.equals(this.includeNegatives, other.includeNegatives);
    }
}
