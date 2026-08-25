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

// typedef: ingest.ChunkingAlgorithm

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class ChunkingAlgorithm implements PlainJsonSerializable, ToCopyableBuilder<ChunkingAlgorithm.Builder, ChunkingAlgorithm> {

    @Nullable
    private final DelimiterChunkingAlgorithm delimiter;

    @Nullable
    private final FixedTokenLengthChunkingAlgorithm fixedTokenLength;

    // ---------------------------------------------------------------------------------------------

    private ChunkingAlgorithm(Builder builder) {
        this.delimiter = builder.delimiter;
        this.fixedTokenLength = builder.fixedTokenLength;
    }

    public static ChunkingAlgorithm of(Function<ChunkingAlgorithm.Builder, ObjectBuilder<ChunkingAlgorithm>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code delimiter}
     */
    @Nullable
    public final DelimiterChunkingAlgorithm delimiter() {
        return this.delimiter;
    }

    /**
     * API name: {@code fixed_token_length}
     */
    @Nullable
    public final FixedTokenLengthChunkingAlgorithm fixedTokenLength() {
        return this.fixedTokenLength;
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
        if (this.delimiter != null) {
            generator.writeKey("delimiter");
            this.delimiter.serialize(generator, mapper);
        }

        if (this.fixedTokenLength != null) {
            generator.writeKey("fixed_token_length");
            this.fixedTokenLength.serialize(generator, mapper);
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
     * Builder for {@link ChunkingAlgorithm}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, ChunkingAlgorithm> {
        @Nullable
        private DelimiterChunkingAlgorithm delimiter;
        @Nullable
        private FixedTokenLengthChunkingAlgorithm fixedTokenLength;

        public Builder() {}

        private Builder(ChunkingAlgorithm o) {
            this.delimiter = o.delimiter;
            this.fixedTokenLength = o.fixedTokenLength;
        }

        private Builder(Builder o) {
            this.delimiter = o.delimiter;
            this.fixedTokenLength = o.fixedTokenLength;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code delimiter}
         */
        @Nonnull
        public final Builder delimiter(@Nullable DelimiterChunkingAlgorithm value) {
            this.delimiter = value;
            return this;
        }

        /**
         * API name: {@code delimiter}
         */
        @Nonnull
        public final Builder delimiter(Function<DelimiterChunkingAlgorithm.Builder, ObjectBuilder<DelimiterChunkingAlgorithm>> fn) {
            return delimiter(fn.apply(new DelimiterChunkingAlgorithm.Builder()).build());
        }

        /**
         * API name: {@code fixed_token_length}
         */
        @Nonnull
        public final Builder fixedTokenLength(@Nullable FixedTokenLengthChunkingAlgorithm value) {
            this.fixedTokenLength = value;
            return this;
        }

        /**
         * API name: {@code fixed_token_length}
         */
        @Nonnull
        public final Builder fixedTokenLength(
            Function<FixedTokenLengthChunkingAlgorithm.Builder, ObjectBuilder<FixedTokenLengthChunkingAlgorithm>> fn
        ) {
            return fixedTokenLength(fn.apply(new FixedTokenLengthChunkingAlgorithm.Builder()).build());
        }

        /**
         * Builds a {@link ChunkingAlgorithm}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public ChunkingAlgorithm build() {
            _checkSingleUse();

            return new ChunkingAlgorithm(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link ChunkingAlgorithm}
     */
    public static final JsonpDeserializer<ChunkingAlgorithm> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        ChunkingAlgorithm::setupChunkingAlgorithmDeserializer
    );

    protected static void setupChunkingAlgorithmDeserializer(ObjectDeserializer<ChunkingAlgorithm.Builder> op) {
        op.add(Builder::delimiter, DelimiterChunkingAlgorithm._DESERIALIZER, "delimiter");
        op.add(Builder::fixedTokenLength, FixedTokenLengthChunkingAlgorithm._DESERIALIZER, "fixed_token_length");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.delimiter);
        result = 31 * result + Objects.hashCode(this.fixedTokenLength);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        ChunkingAlgorithm other = (ChunkingAlgorithm) o;
        return Objects.equals(this.delimiter, other.delimiter) && Objects.equals(this.fixedTokenLength, other.fixedTokenLength);
    }
}
