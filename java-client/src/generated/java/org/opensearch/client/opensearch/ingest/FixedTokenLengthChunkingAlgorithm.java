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

package org.opensearch.client.opensearch.ingest;

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

// typedef: ingest.FixedTokenLengthChunkingAlgorithm

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class FixedTokenLengthChunkingAlgorithm
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<FixedTokenLengthChunkingAlgorithm.Builder, FixedTokenLengthChunkingAlgorithm> {

    @Nullable
    private final Integer maxChunkLimit;

    @Nullable
    private final Double overlapRate;

    @Nullable
    private final Integer tokenLimit;

    @Nullable
    private final String tokenizer;

    // ---------------------------------------------------------------------------------------------

    private FixedTokenLengthChunkingAlgorithm(Builder builder) {
        this.maxChunkLimit = builder.maxChunkLimit;
        this.overlapRate = builder.overlapRate;
        this.tokenLimit = builder.tokenLimit;
        this.tokenizer = builder.tokenizer;
    }

    public static FixedTokenLengthChunkingAlgorithm of(
        Function<FixedTokenLengthChunkingAlgorithm.Builder, ObjectBuilder<FixedTokenLengthChunkingAlgorithm>> fn
    ) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code max_chunk_limit}
     */
    @Nullable
    public final Integer maxChunkLimit() {
        return this.maxChunkLimit;
    }

    /**
     * Fraction of tokens to overlap between consecutive chunks. Value between 0 and 0.5.
     * <p>
     * API name: {@code overlap_rate}
     * </p>
     */
    @Nullable
    public final Double overlapRate() {
        return this.overlapRate;
    }

    /**
     * Maximum number of tokens per chunk.
     * <p>
     * API name: {@code token_limit}
     * </p>
     */
    @Nullable
    public final Integer tokenLimit() {
        return this.tokenLimit;
    }

    /**
     * The tokenizer to use, for example &quot;standard&quot;.
     * <p>
     * API name: {@code tokenizer}
     * </p>
     */
    @Nullable
    public final String tokenizer() {
        return this.tokenizer;
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
        if (this.maxChunkLimit != null) {
            generator.writeKey("max_chunk_limit");
            generator.write(this.maxChunkLimit);
        }

        if (this.overlapRate != null) {
            generator.writeKey("overlap_rate");
            generator.write(this.overlapRate);
        }

        if (this.tokenLimit != null) {
            generator.writeKey("token_limit");
            generator.write(this.tokenLimit);
        }

        if (this.tokenizer != null) {
            generator.writeKey("tokenizer");
            generator.write(this.tokenizer);
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
     * Builder for {@link FixedTokenLengthChunkingAlgorithm}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, FixedTokenLengthChunkingAlgorithm> {
        @Nullable
        private Integer maxChunkLimit;
        @Nullable
        private Double overlapRate;
        @Nullable
        private Integer tokenLimit;
        @Nullable
        private String tokenizer;

        public Builder() {}

        private Builder(FixedTokenLengthChunkingAlgorithm o) {
            this.maxChunkLimit = o.maxChunkLimit;
            this.overlapRate = o.overlapRate;
            this.tokenLimit = o.tokenLimit;
            this.tokenizer = o.tokenizer;
        }

        private Builder(Builder o) {
            this.maxChunkLimit = o.maxChunkLimit;
            this.overlapRate = o.overlapRate;
            this.tokenLimit = o.tokenLimit;
            this.tokenizer = o.tokenizer;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code max_chunk_limit}
         */
        @Nonnull
        public final Builder maxChunkLimit(@Nullable Integer value) {
            this.maxChunkLimit = value;
            return this;
        }

        /**
         * Fraction of tokens to overlap between consecutive chunks. Value between 0 and 0.5.
         * <p>
         * API name: {@code overlap_rate}
         * </p>
         */
        @Nonnull
        public final Builder overlapRate(@Nullable Double value) {
            this.overlapRate = value;
            return this;
        }

        /**
         * Maximum number of tokens per chunk.
         * <p>
         * API name: {@code token_limit}
         * </p>
         */
        @Nonnull
        public final Builder tokenLimit(@Nullable Integer value) {
            this.tokenLimit = value;
            return this;
        }

        /**
         * The tokenizer to use, for example &quot;standard&quot;.
         * <p>
         * API name: {@code tokenizer}
         * </p>
         */
        @Nonnull
        public final Builder tokenizer(@Nullable String value) {
            this.tokenizer = value;
            return this;
        }

        /**
         * Builds a {@link FixedTokenLengthChunkingAlgorithm}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public FixedTokenLengthChunkingAlgorithm build() {
            _checkSingleUse();

            return new FixedTokenLengthChunkingAlgorithm(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link FixedTokenLengthChunkingAlgorithm}
     */
    public static final JsonpDeserializer<FixedTokenLengthChunkingAlgorithm> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        FixedTokenLengthChunkingAlgorithm::setupFixedTokenLengthChunkingAlgorithmDeserializer
    );

    protected static void setupFixedTokenLengthChunkingAlgorithmDeserializer(
        ObjectDeserializer<FixedTokenLengthChunkingAlgorithm.Builder> op
    ) {
        op.add(Builder::maxChunkLimit, JsonpDeserializer.integerDeserializer(), "max_chunk_limit");
        op.add(Builder::overlapRate, JsonpDeserializer.doubleDeserializer(), "overlap_rate");
        op.add(Builder::tokenLimit, JsonpDeserializer.integerDeserializer(), "token_limit");
        op.add(Builder::tokenizer, JsonpDeserializer.stringDeserializer(), "tokenizer");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.maxChunkLimit);
        result = 31 * result + Objects.hashCode(this.overlapRate);
        result = 31 * result + Objects.hashCode(this.tokenLimit);
        result = 31 * result + Objects.hashCode(this.tokenizer);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        FixedTokenLengthChunkingAlgorithm other = (FixedTokenLengthChunkingAlgorithm) o;
        return Objects.equals(this.maxChunkLimit, other.maxChunkLimit)
            && Objects.equals(this.overlapRate, other.overlapRate)
            && Objects.equals(this.tokenLimit, other.tokenLimit)
            && Objects.equals(this.tokenizer, other.tokenizer);
    }
}
