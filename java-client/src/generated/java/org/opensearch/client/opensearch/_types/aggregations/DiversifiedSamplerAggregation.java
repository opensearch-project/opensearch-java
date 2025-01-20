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
import org.opensearch.client.opensearch._types.Script;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: _types.aggregations.DiversifiedSamplerAggregation

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class DiversifiedSamplerAggregation extends BucketAggregationBase
    implements
        AggregationVariant,
        ToCopyableBuilder<DiversifiedSamplerAggregation.Builder, DiversifiedSamplerAggregation> {

    @Nullable
    private final SamplerAggregationExecutionHint executionHint;

    @Nullable
    private final String field;

    @Nullable
    private final Integer maxDocsPerValue;

    @Nullable
    private final Script script;

    @Nullable
    private final Integer shardSize;

    // ---------------------------------------------------------------------------------------------

    private DiversifiedSamplerAggregation(Builder builder) {
        super(builder);
        this.executionHint = builder.executionHint;
        this.field = builder.field;
        this.maxDocsPerValue = builder.maxDocsPerValue;
        this.script = builder.script;
        this.shardSize = builder.shardSize;
    }

    public static DiversifiedSamplerAggregation of(
        Function<DiversifiedSamplerAggregation.Builder, ObjectBuilder<DiversifiedSamplerAggregation>> fn
    ) {
        return fn.apply(new Builder()).build();
    }

    /**
     * {@link Aggregation} variant kind.
     */
    @Override
    public Aggregation.Kind _aggregationKind() {
        return Aggregation.Kind.DiversifiedSampler;
    }

    /**
     * API name: {@code execution_hint}
     */
    @Nullable
    public final SamplerAggregationExecutionHint executionHint() {
        return this.executionHint;
    }

    /**
     * API name: {@code field}
     */
    @Nullable
    public final String field() {
        return this.field;
    }

    /**
     * Limits how many documents are permitted per choice of de-duplicating value.
     * <p>
     * API name: {@code max_docs_per_value}
     * </p>
     */
    @Nullable
    public final Integer maxDocsPerValue() {
        return this.maxDocsPerValue;
    }

    /**
     * API name: {@code script}
     */
    @Nullable
    public final Script script() {
        return this.script;
    }

    /**
     * Limits how many top-scoring documents are collected in the sample processed on each shard.
     * <p>
     * API name: {@code shard_size}
     * </p>
     */
    @Nullable
    public final Integer shardSize() {
        return this.shardSize;
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        super.serializeInternal(generator, mapper);
        if (this.executionHint != null) {
            generator.writeKey("execution_hint");
            this.executionHint.serialize(generator, mapper);
        }

        if (this.field != null) {
            generator.writeKey("field");
            generator.write(this.field);
        }

        if (this.maxDocsPerValue != null) {
            generator.writeKey("max_docs_per_value");
            generator.write(this.maxDocsPerValue);
        }

        if (this.script != null) {
            generator.writeKey("script");
            this.script.serialize(generator, mapper);
        }

        if (this.shardSize != null) {
            generator.writeKey("shard_size");
            generator.write(this.shardSize);
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
     * Builder for {@link DiversifiedSamplerAggregation}.
     */
    public static class Builder extends BucketAggregationBase.AbstractBuilder<Builder>
        implements
            CopyableBuilder<Builder, DiversifiedSamplerAggregation> {
        @Nullable
        private SamplerAggregationExecutionHint executionHint;
        @Nullable
        private String field;
        @Nullable
        private Integer maxDocsPerValue;
        @Nullable
        private Script script;
        @Nullable
        private Integer shardSize;

        public Builder() {}

        private Builder(DiversifiedSamplerAggregation o) {
            super(o);
            this.executionHint = o.executionHint;
            this.field = o.field;
            this.maxDocsPerValue = o.maxDocsPerValue;
            this.script = o.script;
            this.shardSize = o.shardSize;
        }

        private Builder(Builder o) {
            super(o);
            this.executionHint = o.executionHint;
            this.field = o.field;
            this.maxDocsPerValue = o.maxDocsPerValue;
            this.script = o.script;
            this.shardSize = o.shardSize;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        @Override
        @Nonnull
        protected Builder self() {
            return this;
        }

        /**
         * API name: {@code execution_hint}
         */
        @Nonnull
        public final Builder executionHint(@Nullable SamplerAggregationExecutionHint value) {
            this.executionHint = value;
            return this;
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
         * Limits how many documents are permitted per choice of de-duplicating value.
         * <p>
         * API name: {@code max_docs_per_value}
         * </p>
         */
        @Nonnull
        public final Builder maxDocsPerValue(@Nullable Integer value) {
            this.maxDocsPerValue = value;
            return this;
        }

        /**
         * API name: {@code script}
         */
        @Nonnull
        public final Builder script(@Nullable Script value) {
            this.script = value;
            return this;
        }

        /**
         * API name: {@code script}
         */
        @Nonnull
        public final Builder script(Function<Script.Builder, ObjectBuilder<Script>> fn) {
            return script(fn.apply(new Script.Builder()).build());
        }

        /**
         * Limits how many top-scoring documents are collected in the sample processed on each shard.
         * <p>
         * API name: {@code shard_size}
         * </p>
         */
        @Nonnull
        public final Builder shardSize(@Nullable Integer value) {
            this.shardSize = value;
            return this;
        }

        /**
         * Builds a {@link DiversifiedSamplerAggregation}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public DiversifiedSamplerAggregation build() {
            _checkSingleUse();

            return new DiversifiedSamplerAggregation(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link DiversifiedSamplerAggregation}
     */
    public static final JsonpDeserializer<DiversifiedSamplerAggregation> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        DiversifiedSamplerAggregation::setupDiversifiedSamplerAggregationDeserializer
    );

    protected static void setupDiversifiedSamplerAggregationDeserializer(ObjectDeserializer<DiversifiedSamplerAggregation.Builder> op) {
        setupBucketAggregationBaseDeserializer(op);
        op.add(Builder::executionHint, SamplerAggregationExecutionHint._DESERIALIZER, "execution_hint");
        op.add(Builder::field, JsonpDeserializer.stringDeserializer(), "field");
        op.add(Builder::maxDocsPerValue, JsonpDeserializer.integerDeserializer(), "max_docs_per_value");
        op.add(Builder::script, Script._DESERIALIZER, "script");
        op.add(Builder::shardSize, JsonpDeserializer.integerDeserializer(), "shard_size");
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Objects.hashCode(this.executionHint);
        result = 31 * result + Objects.hashCode(this.field);
        result = 31 * result + Objects.hashCode(this.maxDocsPerValue);
        result = 31 * result + Objects.hashCode(this.script);
        result = 31 * result + Objects.hashCode(this.shardSize);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        DiversifiedSamplerAggregation other = (DiversifiedSamplerAggregation) o;
        return Objects.equals(this.executionHint, other.executionHint)
            && Objects.equals(this.field, other.field)
            && Objects.equals(this.maxDocsPerValue, other.maxDocsPerValue)
            && Objects.equals(this.script, other.script)
            && Objects.equals(this.shardSize, other.shardSize);
    }
}
