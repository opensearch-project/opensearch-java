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
import javax.annotation.Nullable;
import org.opensearch.client.json.JsonpDeserializable;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.ObjectBuilderDeserializer;
import org.opensearch.client.json.ObjectDeserializer;
import org.opensearch.client.util.ObjectBuilder;

// typedef: _types.analysis.LimitTokenCountTokenFilter

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class LimitTokenCountTokenFilter extends TokenFilterBase implements TokenFilterDefinitionVariant {

    @Nullable
    private final Boolean consumeAllTokens;

    @Nullable
    private final Integer maxTokenCount;

    // ---------------------------------------------------------------------------------------------

    private LimitTokenCountTokenFilter(Builder builder) {
        super(builder);
        this.consumeAllTokens = builder.consumeAllTokens;
        this.maxTokenCount = builder.maxTokenCount;
    }

    public static LimitTokenCountTokenFilter of(
        Function<LimitTokenCountTokenFilter.Builder, ObjectBuilder<LimitTokenCountTokenFilter>> fn
    ) {
        return fn.apply(new Builder()).build();
    }

    /**
     * {@link TokenFilterDefinition} variant kind.
     */
    @Override
    public TokenFilterDefinition.Kind _tokenFilterDefinitionKind() {
        return TokenFilterDefinition.Kind.Limit;
    }

    /**
     * API name: {@code consume_all_tokens}
     */
    @Nullable
    public final Boolean consumeAllTokens() {
        return this.consumeAllTokens;
    }

    /**
     * API name: {@code max_token_count}
     */
    @Nullable
    public final Integer maxTokenCount() {
        return this.maxTokenCount;
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        generator.write("type", "limit");
        super.serializeInternal(generator, mapper);
        if (this.consumeAllTokens != null) {
            generator.writeKey("consume_all_tokens");
            generator.write(this.consumeAllTokens);
        }

        if (this.maxTokenCount != null) {
            generator.writeKey("max_token_count");
            generator.write(this.maxTokenCount);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Builder for {@link LimitTokenCountTokenFilter}.
     */
    public static class Builder extends TokenFilterBase.AbstractBuilder<Builder> implements ObjectBuilder<LimitTokenCountTokenFilter> {
        @Nullable
        private Boolean consumeAllTokens;
        @Nullable
        private Integer maxTokenCount;

        /**
         * API name: {@code consume_all_tokens}
         */
        public final Builder consumeAllTokens(@Nullable Boolean value) {
            this.consumeAllTokens = value;
            return this;
        }

        /**
         * API name: {@code max_token_count}
         */
        public final Builder maxTokenCount(@Nullable Integer value) {
            this.maxTokenCount = value;
            return this;
        }

        @Override
        protected Builder self() {
            return this;
        }

        /**
         * Builds a {@link LimitTokenCountTokenFilter}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        public LimitTokenCountTokenFilter build() {
            _checkSingleUse();

            return new LimitTokenCountTokenFilter(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link LimitTokenCountTokenFilter}
     */
    public static final JsonpDeserializer<LimitTokenCountTokenFilter> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        LimitTokenCountTokenFilter::setupLimitTokenCountTokenFilterDeserializer
    );

    protected static void setupLimitTokenCountTokenFilterDeserializer(ObjectDeserializer<LimitTokenCountTokenFilter.Builder> op) {
        setupTokenFilterBaseDeserializer(op);
        op.add(Builder::consumeAllTokens, JsonpDeserializer.booleanDeserializer(), "consume_all_tokens");
        op.add(Builder::maxTokenCount, JsonpDeserializer.integerDeserializer(), "max_token_count");

        op.ignore("type");
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Objects.hashCode(this.consumeAllTokens);
        result = 31 * result + Objects.hashCode(this.maxTokenCount);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        LimitTokenCountTokenFilter other = (LimitTokenCountTokenFilter) o;
        return Objects.equals(this.consumeAllTokens, other.consumeAllTokens) && Objects.equals(this.maxTokenCount, other.maxTokenCount);
    }
}
