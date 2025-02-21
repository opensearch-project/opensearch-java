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

// typedef: search_pipeline.NormalizationPhaseResultsProcessor

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class NormalizationPhaseResultsProcessor
    implements
        PhaseResultsProcessorVariant,
        PlainJsonSerializable,
        ToCopyableBuilder<NormalizationPhaseResultsProcessor.Builder, NormalizationPhaseResultsProcessor> {

    @Nullable
    private final ScoreCombination combination;

    @Nullable
    private final String description;

    @Nullable
    private final Boolean ignoreFailure;

    @Nullable
    private final ScoreNormalization normalization;

    @Nullable
    private final String tag;

    // ---------------------------------------------------------------------------------------------

    private NormalizationPhaseResultsProcessor(Builder builder) {
        this.combination = builder.combination;
        this.description = builder.description;
        this.ignoreFailure = builder.ignoreFailure;
        this.normalization = builder.normalization;
        this.tag = builder.tag;
    }

    public static NormalizationPhaseResultsProcessor of(
        Function<NormalizationPhaseResultsProcessor.Builder, ObjectBuilder<NormalizationPhaseResultsProcessor>> fn
    ) {
        return fn.apply(new Builder()).build();
    }

    /**
     * {@link PhaseResultsProcessor} variant kind.
     */
    @Override
    public PhaseResultsProcessor.Kind _phaseResultsProcessorKind() {
        return PhaseResultsProcessor.Kind.NormalizationProcessor;
    }

    /**
     * API name: {@code combination}
     */
    @Nullable
    public final ScoreCombination combination() {
        return this.combination;
    }

    /**
     * API name: {@code description}
     */
    @Nullable
    public final String description() {
        return this.description;
    }

    /**
     * API name: {@code ignore_failure}
     */
    @Nullable
    public final Boolean ignoreFailure() {
        return this.ignoreFailure;
    }

    /**
     * API name: {@code normalization}
     */
    @Nullable
    public final ScoreNormalization normalization() {
        return this.normalization;
    }

    /**
     * API name: {@code tag}
     */
    @Nullable
    public final String tag() {
        return this.tag;
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
        if (this.combination != null) {
            generator.writeKey("combination");
            this.combination.serialize(generator, mapper);
        }

        if (this.description != null) {
            generator.writeKey("description");
            generator.write(this.description);
        }

        if (this.ignoreFailure != null) {
            generator.writeKey("ignore_failure");
            generator.write(this.ignoreFailure);
        }

        if (this.normalization != null) {
            generator.writeKey("normalization");
            this.normalization.serialize(generator, mapper);
        }

        if (this.tag != null) {
            generator.writeKey("tag");
            generator.write(this.tag);
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
     * Builder for {@link NormalizationPhaseResultsProcessor}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, NormalizationPhaseResultsProcessor> {
        @Nullable
        private ScoreCombination combination;
        @Nullable
        private String description;
        @Nullable
        private Boolean ignoreFailure;
        @Nullable
        private ScoreNormalization normalization;
        @Nullable
        private String tag;

        public Builder() {}

        private Builder(NormalizationPhaseResultsProcessor o) {
            this.combination = o.combination;
            this.description = o.description;
            this.ignoreFailure = o.ignoreFailure;
            this.normalization = o.normalization;
            this.tag = o.tag;
        }

        private Builder(Builder o) {
            this.combination = o.combination;
            this.description = o.description;
            this.ignoreFailure = o.ignoreFailure;
            this.normalization = o.normalization;
            this.tag = o.tag;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code combination}
         */
        @Nonnull
        public final Builder combination(@Nullable ScoreCombination value) {
            this.combination = value;
            return this;
        }

        /**
         * API name: {@code combination}
         */
        @Nonnull
        public final Builder combination(Function<ScoreCombination.Builder, ObjectBuilder<ScoreCombination>> fn) {
            return combination(fn.apply(new ScoreCombination.Builder()).build());
        }

        /**
         * API name: {@code description}
         */
        @Nonnull
        public final Builder description(@Nullable String value) {
            this.description = value;
            return this;
        }

        /**
         * API name: {@code ignore_failure}
         */
        @Nonnull
        public final Builder ignoreFailure(@Nullable Boolean value) {
            this.ignoreFailure = value;
            return this;
        }

        /**
         * API name: {@code normalization}
         */
        @Nonnull
        public final Builder normalization(@Nullable ScoreNormalization value) {
            this.normalization = value;
            return this;
        }

        /**
         * API name: {@code normalization}
         */
        @Nonnull
        public final Builder normalization(Function<ScoreNormalization.Builder, ObjectBuilder<ScoreNormalization>> fn) {
            return normalization(fn.apply(new ScoreNormalization.Builder()).build());
        }

        /**
         * API name: {@code tag}
         */
        @Nonnull
        public final Builder tag(@Nullable String value) {
            this.tag = value;
            return this;
        }

        /**
         * Builds a {@link NormalizationPhaseResultsProcessor}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public NormalizationPhaseResultsProcessor build() {
            _checkSingleUse();

            return new NormalizationPhaseResultsProcessor(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link NormalizationPhaseResultsProcessor}
     */
    public static final JsonpDeserializer<NormalizationPhaseResultsProcessor> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        NormalizationPhaseResultsProcessor::setupNormalizationPhaseResultsProcessorDeserializer
    );

    protected static void setupNormalizationPhaseResultsProcessorDeserializer(
        ObjectDeserializer<NormalizationPhaseResultsProcessor.Builder> op
    ) {
        op.add(Builder::combination, ScoreCombination._DESERIALIZER, "combination");
        op.add(Builder::description, JsonpDeserializer.stringDeserializer(), "description");
        op.add(Builder::ignoreFailure, JsonpDeserializer.booleanDeserializer(), "ignore_failure");
        op.add(Builder::normalization, ScoreNormalization._DESERIALIZER, "normalization");
        op.add(Builder::tag, JsonpDeserializer.stringDeserializer(), "tag");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.combination);
        result = 31 * result + Objects.hashCode(this.description);
        result = 31 * result + Objects.hashCode(this.ignoreFailure);
        result = 31 * result + Objects.hashCode(this.normalization);
        result = 31 * result + Objects.hashCode(this.tag);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        NormalizationPhaseResultsProcessor other = (NormalizationPhaseResultsProcessor) o;
        return Objects.equals(this.combination, other.combination)
            && Objects.equals(this.description, other.description)
            && Objects.equals(this.ignoreFailure, other.ignoreFailure)
            && Objects.equals(this.normalization, other.normalization)
            && Objects.equals(this.tag, other.tag);
    }
}
