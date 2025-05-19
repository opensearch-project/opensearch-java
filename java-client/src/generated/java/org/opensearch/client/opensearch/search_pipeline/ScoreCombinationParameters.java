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

package org.opensearch.client.opensearch.search_pipeline;

import jakarta.json.stream.JsonGenerator;
import java.util.List;
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
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: search_pipeline.ScoreCombinationParameters

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class ScoreCombinationParameters
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<ScoreCombinationParameters.Builder, ScoreCombinationParameters> {

    @Nonnull
    private final List<Float> weights;

    // ---------------------------------------------------------------------------------------------

    private ScoreCombinationParameters(Builder builder) {
        this.weights = ApiTypeHelper.unmodifiable(builder.weights);
    }

    public static ScoreCombinationParameters of(
        Function<ScoreCombinationParameters.Builder, ObjectBuilder<ScoreCombinationParameters>> fn
    ) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code weights}
     */
    @Nonnull
    public final List<Float> weights() {
        return this.weights;
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
        if (ApiTypeHelper.isDefined(this.weights)) {
            generator.writeKey("weights");
            generator.writeStartArray();
            for (Float item0 : this.weights) {
                generator.write(item0);
            }
            generator.writeEnd();
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
     * Builder for {@link ScoreCombinationParameters}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, ScoreCombinationParameters> {
        @Nullable
        private List<Float> weights;

        public Builder() {}

        private Builder(ScoreCombinationParameters o) {
            this.weights = _listCopy(o.weights);
        }

        private Builder(Builder o) {
            this.weights = _listCopy(o.weights);
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code weights}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>weights</code>.
         * </p>
         */
        @Nonnull
        public final Builder weights(List<Float> list) {
            this.weights = _listAddAll(this.weights, list);
            return this;
        }

        /**
         * API name: {@code weights}
         *
         * <p>
         * Adds one or more values to <code>weights</code>.
         * </p>
         */
        @Nonnull
        public final Builder weights(Float value, Float... values) {
            this.weights = _listAdd(this.weights, value, values);
            return this;
        }

        /**
         * Builds a {@link ScoreCombinationParameters}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public ScoreCombinationParameters build() {
            _checkSingleUse();

            return new ScoreCombinationParameters(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link ScoreCombinationParameters}
     */
    public static final JsonpDeserializer<ScoreCombinationParameters> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        ScoreCombinationParameters::setupScoreCombinationParametersDeserializer
    );

    protected static void setupScoreCombinationParametersDeserializer(ObjectDeserializer<ScoreCombinationParameters.Builder> op) {
        op.add(Builder::weights, JsonpDeserializer.arrayDeserializer(JsonpDeserializer.floatDeserializer()), "weights");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.weights);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        ScoreCombinationParameters other = (ScoreCombinationParameters) o;
        return Objects.equals(this.weights, other.weights);
    }
}
