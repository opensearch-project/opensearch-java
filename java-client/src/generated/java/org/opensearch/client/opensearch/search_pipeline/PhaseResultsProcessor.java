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
import org.opensearch.client.json.JsonEnum;
import org.opensearch.client.json.JsonpDeserializable;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.JsonpSerializable;
import org.opensearch.client.json.ObjectBuilderDeserializer;
import org.opensearch.client.json.ObjectDeserializer;
import org.opensearch.client.json.PlainJsonSerializable;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.TaggedUnion;
import org.opensearch.client.util.TaggedUnionUtils;

// typedef: search_pipeline.PhaseResultsProcessor

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class PhaseResultsProcessor implements TaggedUnion<PhaseResultsProcessor.Kind, PhaseResultsProcessorVariant>, PlainJsonSerializable {
    /**
     * {@link PhaseResultsProcessor} variant kinds.
     */
    public enum Kind implements JsonEnum {
        NormalizationProcessor("normalization-processor"),
        ScoreRankerProcessor("score-ranker-processor");

        private final String jsonValue;

        Kind(String jsonValue) {
            this.jsonValue = jsonValue;
        }

        @Override
        public String jsonValue() {
            return jsonValue;
        }
    }

    private final Kind _kind;
    private final PhaseResultsProcessorVariant _value;

    @Override
    public final Kind _kind() {
        return _kind;
    }

    @Override
    public final PhaseResultsProcessorVariant _get() {
        return _value;
    }

    public PhaseResultsProcessor(PhaseResultsProcessorVariant value) {
        this._kind = ApiTypeHelper.requireNonNull(value._phaseResultsProcessorKind(), this, "<variant kind>");
        this._value = ApiTypeHelper.requireNonNull(value, this, "<variant value>");
    }

    private PhaseResultsProcessor(Builder builder) {
        this._kind = ApiTypeHelper.requireNonNull(builder._kind, builder, "<variant kind>");
        this._value = ApiTypeHelper.requireNonNull(builder._value, builder, "<variant value>");
    }

    public static PhaseResultsProcessor of(Function<PhaseResultsProcessor.Builder, ObjectBuilder<PhaseResultsProcessor>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Is this variant instance of kind {@code normalization-processor}?
     */
    public boolean isNormalizationProcessor() {
        return _kind == Kind.NormalizationProcessor;
    }

    /**
     * Get the {@code normalization-processor} variant value.
     *
     * @throws IllegalStateException if the current variant is not the {@code normalization-processor} kind.
     */
    public NormalizationPhaseResultsProcessor normalizationProcessor() {
        return TaggedUnionUtils.get(this, Kind.NormalizationProcessor);
    }

    /**
     * Is this variant instance of kind {@code score-ranker-processor}?
     */
    public boolean isScoreRankerProcessor() {
        return _kind == Kind.ScoreRankerProcessor;
    }

    /**
     * Get the {@code score-ranker-processor} variant value.
     *
     * @throws IllegalStateException if the current variant is not the {@code score-ranker-processor} kind.
     */
    public ScoreRankerPhaseResultsProcessor scoreRankerProcessor() {
        return TaggedUnionUtils.get(this, Kind.ScoreRankerProcessor);
    }

    @Override
    public void serialize(JsonGenerator generator, JsonpMapper mapper) {
        generator.writeStartObject();
        generator.writeKey(_kind.jsonValue());
        if (_value instanceof JsonpSerializable) {
            ((JsonpSerializable) _value).serialize(generator, mapper);
        }
        generator.writeEnd();
    }

    @Nonnull
    public Builder toBuilder() {
        return new Builder(this);
    }

    @Nonnull
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder extends ObjectBuilderBase implements ObjectBuilder<PhaseResultsProcessor> {
        private Kind _kind;
        private PhaseResultsProcessorVariant _value;

        public Builder() {}

        private Builder(PhaseResultsProcessor o) {
            this._kind = o._kind;
            this._value = o._value;
        }

        public ObjectBuilder<PhaseResultsProcessor> normalizationProcessor(NormalizationPhaseResultsProcessor v) {
            this._kind = Kind.NormalizationProcessor;
            this._value = v;
            return this;
        }

        public ObjectBuilder<PhaseResultsProcessor> normalizationProcessor(
            Function<NormalizationPhaseResultsProcessor.Builder, ObjectBuilder<NormalizationPhaseResultsProcessor>> fn
        ) {
            return this.normalizationProcessor(fn.apply(new NormalizationPhaseResultsProcessor.Builder()).build());
        }

        public ObjectBuilder<PhaseResultsProcessor> scoreRankerProcessor(ScoreRankerPhaseResultsProcessor v) {
            this._kind = Kind.ScoreRankerProcessor;
            this._value = v;
            return this;
        }

        public ObjectBuilder<PhaseResultsProcessor> scoreRankerProcessor(
            Function<ScoreRankerPhaseResultsProcessor.Builder, ObjectBuilder<ScoreRankerPhaseResultsProcessor>> fn
        ) {
            return this.scoreRankerProcessor(fn.apply(new ScoreRankerPhaseResultsProcessor.Builder()).build());
        }

        @Override
        public PhaseResultsProcessor build() {
            _checkSingleUse();
            return new PhaseResultsProcessor(this);
        }
    }

    protected static void setupPhaseResultsProcessorDeserializer(ObjectDeserializer<Builder> op) {
        op.add(Builder::normalizationProcessor, NormalizationPhaseResultsProcessor._DESERIALIZER, "normalization-processor");
        op.add(Builder::scoreRankerProcessor, ScoreRankerPhaseResultsProcessor._DESERIALIZER, "score-ranker-processor");
    }

    public static final JsonpDeserializer<PhaseResultsProcessor> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        PhaseResultsProcessor::setupPhaseResultsProcessorDeserializer,
        Builder::build
    );

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this._kind);
        result = 31 * result + Objects.hashCode(this._value);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        PhaseResultsProcessor other = (PhaseResultsProcessor) o;
        return Objects.equals(this._kind, other._kind) && Objects.equals(this._value, other._value);
    }
}
