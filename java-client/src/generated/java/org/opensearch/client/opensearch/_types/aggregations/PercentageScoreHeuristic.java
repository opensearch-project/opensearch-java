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
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.PlainJsonSerializable;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: _types.aggregations.PercentageScoreHeuristic

@Generated("org.opensearch.client.codegen.CodeGenerator")
public class PercentageScoreHeuristic
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<PercentageScoreHeuristic.Builder, PercentageScoreHeuristic> {

    // ---------------------------------------------------------------------------------------------

    private PercentageScoreHeuristic(Builder builder) {}

    public static PercentageScoreHeuristic of(Function<PercentageScoreHeuristic.Builder, ObjectBuilder<PercentageScoreHeuristic>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Serialize this object to JSON.
     */
    @Override
    public void serialize(JsonGenerator generator, JsonpMapper mapper) {
        generator.writeStartObject();
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
     * Builder for {@link PercentageScoreHeuristic}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, PercentageScoreHeuristic> {

        public Builder() {}

        private Builder(PercentageScoreHeuristic o) {}

        private Builder(Builder o) {}

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Builds a {@link PercentageScoreHeuristic}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public PercentageScoreHeuristic build() {
            _checkSingleUse();

            return new PercentageScoreHeuristic(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Singleton instance for {@link PercentageScoreHeuristic}.
     */
    public static final PercentageScoreHeuristic _INSTANCE = builder().build();

    public static final JsonpDeserializer<PercentageScoreHeuristic> _DESERIALIZER = JsonpDeserializer.emptyObject(
        PercentageScoreHeuristic._INSTANCE
    );

    @Override
    public int hashCode() {
        int result = 17;
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        return true;
    }
}
