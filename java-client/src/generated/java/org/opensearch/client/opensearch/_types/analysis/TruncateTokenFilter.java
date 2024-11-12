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

// typedef: _types.analysis.TruncateTokenFilter

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class TruncateTokenFilter extends TokenFilterBase implements TokenFilterDefinitionVariant {

    @Nullable
    private final Integer length;

    // ---------------------------------------------------------------------------------------------

    private TruncateTokenFilter(Builder builder) {
        super(builder);
        this.length = builder.length;
    }

    public static TruncateTokenFilter of(Function<TruncateTokenFilter.Builder, ObjectBuilder<TruncateTokenFilter>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * {@link TokenFilterDefinition} variant kind.
     */
    @Override
    public TokenFilterDefinition.Kind _tokenFilterDefinitionKind() {
        return TokenFilterDefinition.Kind.Truncate;
    }

    /**
     * API name: {@code length}
     */
    @Nullable
    public final Integer length() {
        return this.length;
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        generator.write("type", "truncate");
        super.serializeInternal(generator, mapper);
        if (this.length != null) {
            generator.writeKey("length");
            generator.write(this.length);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Builder for {@link TruncateTokenFilter}.
     */
    public static class Builder extends TokenFilterBase.AbstractBuilder<Builder> implements ObjectBuilder<TruncateTokenFilter> {
        @Nullable
        private Integer length;

        /**
         * API name: {@code length}
         */
        public final Builder length(@Nullable Integer value) {
            this.length = value;
            return this;
        }

        @Override
        protected Builder self() {
            return this;
        }

        /**
         * Builds a {@link TruncateTokenFilter}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        public TruncateTokenFilter build() {
            _checkSingleUse();

            return new TruncateTokenFilter(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link TruncateTokenFilter}
     */
    public static final JsonpDeserializer<TruncateTokenFilter> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        TruncateTokenFilter::setupTruncateTokenFilterDeserializer
    );

    protected static void setupTruncateTokenFilterDeserializer(ObjectDeserializer<TruncateTokenFilter.Builder> op) {
        setupTokenFilterBaseDeserializer(op);
        op.add(Builder::length, JsonpDeserializer.integerDeserializer(), "length");

        op.ignore("type");
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Objects.hashCode(this.length);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        TruncateTokenFilter other = (TruncateTokenFilter) o;
        return Objects.equals(this.length, other.length);
    }
}
