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

// typedef: search_pipeline.ScoreCombination

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class ScoreCombination implements PlainJsonSerializable, ToCopyableBuilder<ScoreCombination.Builder, ScoreCombination> {

    @Nullable
    private final ScoreCombinationParameters parameters;

    @Nullable
    private final ScoreCombinationTechnique technique;

    // ---------------------------------------------------------------------------------------------

    private ScoreCombination(Builder builder) {
        this.parameters = builder.parameters;
        this.technique = builder.technique;
    }

    public static ScoreCombination of(Function<ScoreCombination.Builder, ObjectBuilder<ScoreCombination>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code parameters}
     */
    @Nullable
    public final ScoreCombinationParameters parameters() {
        return this.parameters;
    }

    /**
     * API name: {@code technique}
     */
    @Nullable
    public final ScoreCombinationTechnique technique() {
        return this.technique;
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
        if (this.parameters != null) {
            generator.writeKey("parameters");
            this.parameters.serialize(generator, mapper);
        }

        if (this.technique != null) {
            generator.writeKey("technique");
            this.technique.serialize(generator, mapper);
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
     * Builder for {@link ScoreCombination}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, ScoreCombination> {
        @Nullable
        private ScoreCombinationParameters parameters;
        @Nullable
        private ScoreCombinationTechnique technique;

        public Builder() {}

        private Builder(ScoreCombination o) {
            this.parameters = o.parameters;
            this.technique = o.technique;
        }

        private Builder(Builder o) {
            this.parameters = o.parameters;
            this.technique = o.technique;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code parameters}
         */
        @Nonnull
        public final Builder parameters(@Nullable ScoreCombinationParameters value) {
            this.parameters = value;
            return this;
        }

        /**
         * API name: {@code parameters}
         */
        @Nonnull
        public final Builder parameters(Function<ScoreCombinationParameters.Builder, ObjectBuilder<ScoreCombinationParameters>> fn) {
            return parameters(fn.apply(new ScoreCombinationParameters.Builder()).build());
        }

        /**
         * API name: {@code technique}
         */
        @Nonnull
        public final Builder technique(@Nullable ScoreCombinationTechnique value) {
            this.technique = value;
            return this;
        }

        /**
         * Builds a {@link ScoreCombination}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public ScoreCombination build() {
            _checkSingleUse();

            return new ScoreCombination(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link ScoreCombination}
     */
    public static final JsonpDeserializer<ScoreCombination> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        ScoreCombination::setupScoreCombinationDeserializer
    );

    protected static void setupScoreCombinationDeserializer(ObjectDeserializer<ScoreCombination.Builder> op) {
        op.add(Builder::parameters, ScoreCombinationParameters._DESERIALIZER, "parameters");
        op.add(Builder::technique, ScoreCombinationTechnique._DESERIALIZER, "technique");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.parameters);
        result = 31 * result + Objects.hashCode(this.technique);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        ScoreCombination other = (ScoreCombination) o;
        return Objects.equals(this.parameters, other.parameters) && Objects.equals(this.technique, other.technique);
    }
}
