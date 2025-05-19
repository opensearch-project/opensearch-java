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

// typedef: _types.analysis.PatternTokenizer

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class PatternTokenizer extends TokenizerBase
    implements
        TokenizerDefinitionVariant,
        ToCopyableBuilder<PatternTokenizer.Builder, PatternTokenizer> {

    @Nullable
    private final String flags;

    @Nullable
    private final Integer group;

    @Nullable
    private final String pattern;

    // ---------------------------------------------------------------------------------------------

    private PatternTokenizer(Builder builder) {
        super(builder);
        this.flags = builder.flags;
        this.group = builder.group;
        this.pattern = builder.pattern;
    }

    public static PatternTokenizer of(Function<PatternTokenizer.Builder, ObjectBuilder<PatternTokenizer>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * {@link TokenizerDefinition} variant kind.
     */
    @Override
    public TokenizerDefinition.Kind _tokenizerDefinitionKind() {
        return TokenizerDefinition.Kind.Pattern;
    }

    /**
     * API name: {@code flags}
     */
    @Nullable
    public final String flags() {
        return this.flags;
    }

    /**
     * API name: {@code group}
     */
    @Nullable
    public final Integer group() {
        return this.group;
    }

    /**
     * API name: {@code pattern}
     */
    @Nullable
    public final String pattern() {
        return this.pattern;
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        generator.write("type", "pattern");
        super.serializeInternal(generator, mapper);
        if (this.flags != null) {
            generator.writeKey("flags");
            generator.write(this.flags);
        }

        if (this.group != null) {
            generator.writeKey("group");
            generator.write(this.group);
        }

        if (this.pattern != null) {
            generator.writeKey("pattern");
            generator.write(this.pattern);
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
     * Builder for {@link PatternTokenizer}.
     */
    public static class Builder extends TokenizerBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, PatternTokenizer> {
        @Nullable
        private String flags;
        @Nullable
        private Integer group;
        @Nullable
        private String pattern;

        public Builder() {}

        private Builder(PatternTokenizer o) {
            super(o);
            this.flags = o.flags;
            this.group = o.group;
            this.pattern = o.pattern;
        }

        private Builder(Builder o) {
            super(o);
            this.flags = o.flags;
            this.group = o.group;
            this.pattern = o.pattern;
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
         * API name: {@code flags}
         */
        @Nonnull
        public final Builder flags(@Nullable String value) {
            this.flags = value;
            return this;
        }

        /**
         * API name: {@code group}
         */
        @Nonnull
        public final Builder group(@Nullable Integer value) {
            this.group = value;
            return this;
        }

        /**
         * API name: {@code pattern}
         */
        @Nonnull
        public final Builder pattern(@Nullable String value) {
            this.pattern = value;
            return this;
        }

        /**
         * Builds a {@link PatternTokenizer}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public PatternTokenizer build() {
            _checkSingleUse();

            return new PatternTokenizer(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link PatternTokenizer}
     */
    public static final JsonpDeserializer<PatternTokenizer> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        PatternTokenizer::setupPatternTokenizerDeserializer
    );

    protected static void setupPatternTokenizerDeserializer(ObjectDeserializer<PatternTokenizer.Builder> op) {
        setupTokenizerBaseDeserializer(op);
        op.add(Builder::flags, JsonpDeserializer.stringDeserializer(), "flags");
        op.add(Builder::group, JsonpDeserializer.integerDeserializer(), "group");
        op.add(Builder::pattern, JsonpDeserializer.stringDeserializer(), "pattern");

        op.ignore("type");
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Objects.hashCode(this.flags);
        result = 31 * result + Objects.hashCode(this.group);
        result = 31 * result + Objects.hashCode(this.pattern);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        PatternTokenizer other = (PatternTokenizer) o;
        return Objects.equals(this.flags, other.flags)
            && Objects.equals(this.group, other.group)
            && Objects.equals(this.pattern, other.pattern);
    }
}
