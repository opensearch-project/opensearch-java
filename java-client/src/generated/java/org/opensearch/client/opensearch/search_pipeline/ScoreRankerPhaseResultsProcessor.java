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

// typedef: search_pipeline.ScoreRankerPhaseResultsProcessor

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class ScoreRankerPhaseResultsProcessor
    implements
        PhaseResultsProcessorVariant,
        PlainJsonSerializable,
        ToCopyableBuilder<ScoreRankerPhaseResultsProcessor.Builder, ScoreRankerPhaseResultsProcessor> {

    @Nonnull
    private final ScoreRankerCombination combination;

    // ---------------------------------------------------------------------------------------------

    private ScoreRankerPhaseResultsProcessor(Builder builder) {
        this.combination = ApiTypeHelper.requireNonNull(builder.combination, this, "combination");
    }

    public static ScoreRankerPhaseResultsProcessor of(
        Function<ScoreRankerPhaseResultsProcessor.Builder, ObjectBuilder<ScoreRankerPhaseResultsProcessor>> fn
    ) {
        return fn.apply(new Builder()).build();
    }

    /**
     * {@link PhaseResultsProcessor} variant kind.
     */
    @Override
    public PhaseResultsProcessor.Kind _phaseResultsProcessorKind() {
        return PhaseResultsProcessor.Kind.ScoreRankerProcessor;
    }

    /**
     * Required - API name: {@code combination}
     */
    @Nonnull
    public final ScoreRankerCombination combination() {
        return this.combination;
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
        generator.writeKey("combination");
        this.combination.serialize(generator, mapper);
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
     * Builder for {@link ScoreRankerPhaseResultsProcessor}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, ScoreRankerPhaseResultsProcessor> {
        private ScoreRankerCombination combination;

        public Builder() {}

        private Builder(ScoreRankerPhaseResultsProcessor o) {
            this.combination = o.combination;
        }

        private Builder(Builder o) {
            this.combination = o.combination;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - API name: {@code combination}
         */
        @Nonnull
        public final Builder combination(ScoreRankerCombination value) {
            this.combination = value;
            return this;
        }

        /**
         * Required - API name: {@code combination}
         */
        @Nonnull
        public final Builder combination(Function<ScoreRankerCombination.Builder, ObjectBuilder<ScoreRankerCombination>> fn) {
            return combination(fn.apply(new ScoreRankerCombination.Builder()).build());
        }

        /**
         * Builds a {@link ScoreRankerPhaseResultsProcessor}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public ScoreRankerPhaseResultsProcessor build() {
            _checkSingleUse();

            return new ScoreRankerPhaseResultsProcessor(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link ScoreRankerPhaseResultsProcessor}
     */
    public static final JsonpDeserializer<ScoreRankerPhaseResultsProcessor> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        ScoreRankerPhaseResultsProcessor::setupScoreRankerPhaseResultsProcessorDeserializer
    );

    protected static void setupScoreRankerPhaseResultsProcessorDeserializer(
        ObjectDeserializer<ScoreRankerPhaseResultsProcessor.Builder> op
    ) {
        op.add(Builder::combination, ScoreRankerCombination._DESERIALIZER, "combination");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.combination.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        ScoreRankerPhaseResultsProcessor other = (ScoreRankerPhaseResultsProcessor) o;
        return this.combination.equals(other.combination);
    }
}
