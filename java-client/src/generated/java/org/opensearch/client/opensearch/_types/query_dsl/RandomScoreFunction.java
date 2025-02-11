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

// typedef: _types.query_dsl.RandomScoreFunction

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class RandomScoreFunction
    implements
        FunctionScoreVariant,
        PlainJsonSerializable,
        ToCopyableBuilder<RandomScoreFunction.Builder, RandomScoreFunction> {

    @Nullable
    private final String field;

    @Nullable
    private final String seed;

    // ---------------------------------------------------------------------------------------------

    private RandomScoreFunction(Builder builder) {
        this.field = builder.field;
        this.seed = builder.seed;
    }

    public static RandomScoreFunction of(Function<RandomScoreFunction.Builder, ObjectBuilder<RandomScoreFunction>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * {@link FunctionScore} variant kind.
     */
    @Override
    public FunctionScore.Kind _functionScoreKind() {
        return FunctionScore.Kind.RandomScore;
    }

    /**
     * API name: {@code field}
     */
    @Nullable
    public final String field() {
        return this.field;
    }

    /**
     * API name: {@code seed}
     */
    @Nullable
    public final String seed() {
        return this.seed;
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
        if (this.field != null) {
            generator.writeKey("field");
            generator.write(this.field);
        }

        if (this.seed != null) {
            generator.writeKey("seed");
            generator.write(this.seed);
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
     * Builder for {@link RandomScoreFunction}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, RandomScoreFunction> {
        @Nullable
        private String field;
        @Nullable
        private String seed;

        public Builder() {}

        private Builder(RandomScoreFunction o) {
            this.field = o.field;
            this.seed = o.seed;
        }

        private Builder(Builder o) {
            this.field = o.field;
            this.seed = o.seed;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code field}
         */
        @Nonnull
        public final Builder field(@Nullable String value) {
            this.field = value;
            return this;
        }

        /**
         * API name: {@code seed}
         */
        @Nonnull
        public final Builder seed(@Nullable String value) {
            this.seed = value;
            return this;
        }

        /**
         * Builds a {@link RandomScoreFunction}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public RandomScoreFunction build() {
            _checkSingleUse();

            return new RandomScoreFunction(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link RandomScoreFunction}
     */
    public static final JsonpDeserializer<RandomScoreFunction> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        RandomScoreFunction::setupRandomScoreFunctionDeserializer
    );

    protected static void setupRandomScoreFunctionDeserializer(ObjectDeserializer<RandomScoreFunction.Builder> op) {
        op.add(Builder::field, JsonpDeserializer.stringDeserializer(), "field");
        op.add(Builder::seed, JsonpDeserializer.stringDeserializer(), "seed");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.field);
        result = 31 * result + Objects.hashCode(this.seed);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        RandomScoreFunction other = (RandomScoreFunction) o;
        return Objects.equals(this.field, other.field) && Objects.equals(this.seed, other.seed);
    }
}
