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

package org.opensearch.client.opensearch._types.analysis;

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
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: _types.analysis.StandardTokenizer

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class StandardTokenizer extends TokenizerBase
    implements
        TokenizerDefinitionVariant,
        ToCopyableBuilder<StandardTokenizer.Builder, StandardTokenizer> {

    @Nullable
    private final Integer maxTokenLength;

    // ---------------------------------------------------------------------------------------------

    private StandardTokenizer(Builder builder) {
        super(builder);
        this.maxTokenLength = builder.maxTokenLength;
    }

    public static StandardTokenizer of(Function<StandardTokenizer.Builder, ObjectBuilder<StandardTokenizer>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * {@link TokenizerDefinition} variant kind.
     */
    @Override
    public TokenizerDefinition.Kind _tokenizerDefinitionKind() {
        return TokenizerDefinition.Kind.Standard;
    }

    /**
     * API name: {@code max_token_length}
     */
    @Nullable
    public final Integer maxTokenLength() {
        return this.maxTokenLength;
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        generator.write("type", "standard");
        super.serializeInternal(generator, mapper);
        if (this.maxTokenLength != null) {
            generator.writeKey("max_token_length");
            generator.write(this.maxTokenLength);
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
     * Builder for {@link StandardTokenizer}.
     */
    public static class Builder extends TokenizerBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, StandardTokenizer> {
        @Nullable
        private Integer maxTokenLength;

        public Builder() {}

        private Builder(StandardTokenizer o) {
            super(o);
            this.maxTokenLength = o.maxTokenLength;
        }

        private Builder(Builder o) {
            super(o);
            this.maxTokenLength = o.maxTokenLength;
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
         * API name: {@code max_token_length}
         */
        @Nonnull
        public final Builder maxTokenLength(@Nullable Integer value) {
            this.maxTokenLength = value;
            return this;
        }

        /**
         * Builds a {@link StandardTokenizer}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public StandardTokenizer build() {
            _checkSingleUse();

            return new StandardTokenizer(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link StandardTokenizer}
     */
    public static final JsonpDeserializer<StandardTokenizer> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        StandardTokenizer::setupStandardTokenizerDeserializer
    );

    protected static void setupStandardTokenizerDeserializer(ObjectDeserializer<StandardTokenizer.Builder> op) {
        setupTokenizerBaseDeserializer(op);
        op.add(Builder::maxTokenLength, JsonpDeserializer.integerDeserializer(), "max_token_length");

        op.ignore("type");
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Objects.hashCode(this.maxTokenLength);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        StandardTokenizer other = (StandardTokenizer) o;
        return Objects.equals(this.maxTokenLength, other.maxTokenLength);
    }
}
