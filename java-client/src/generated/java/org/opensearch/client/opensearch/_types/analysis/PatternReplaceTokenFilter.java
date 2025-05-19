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
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: _types.analysis.PatternReplaceTokenFilter

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class PatternReplaceTokenFilter extends TokenFilterBase
    implements
        TokenFilterDefinitionVariant,
        ToCopyableBuilder<PatternReplaceTokenFilter.Builder, PatternReplaceTokenFilter> {

    @Nullable
    private final Boolean all;

    @Nullable
    private final String flags;

    @Nonnull
    private final String pattern;

    @Nullable
    private final String replacement;

    // ---------------------------------------------------------------------------------------------

    private PatternReplaceTokenFilter(Builder builder) {
        super(builder);
        this.all = builder.all;
        this.flags = builder.flags;
        this.pattern = ApiTypeHelper.requireNonNull(builder.pattern, this, "pattern");
        this.replacement = builder.replacement;
    }

    public static PatternReplaceTokenFilter of(Function<PatternReplaceTokenFilter.Builder, ObjectBuilder<PatternReplaceTokenFilter>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * {@link TokenFilterDefinition} variant kind.
     */
    @Override
    public TokenFilterDefinition.Kind _tokenFilterDefinitionKind() {
        return TokenFilterDefinition.Kind.PatternReplace;
    }

    /**
     * API name: {@code all}
     */
    @Nullable
    public final Boolean all() {
        return this.all;
    }

    /**
     * API name: {@code flags}
     */
    @Nullable
    public final String flags() {
        return this.flags;
    }

    /**
     * Required - API name: {@code pattern}
     */
    @Nonnull
    public final String pattern() {
        return this.pattern;
    }

    /**
     * API name: {@code replacement}
     */
    @Nullable
    public final String replacement() {
        return this.replacement;
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        generator.write("type", "pattern_replace");
        super.serializeInternal(generator, mapper);
        if (this.all != null) {
            generator.writeKey("all");
            generator.write(this.all);
        }

        if (this.flags != null) {
            generator.writeKey("flags");
            generator.write(this.flags);
        }

        generator.writeKey("pattern");
        generator.write(this.pattern);

        if (this.replacement != null) {
            generator.writeKey("replacement");
            generator.write(this.replacement);
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
     * Builder for {@link PatternReplaceTokenFilter}.
     */
    public static class Builder extends TokenFilterBase.AbstractBuilder<Builder>
        implements
            CopyableBuilder<Builder, PatternReplaceTokenFilter> {
        @Nullable
        private Boolean all;
        @Nullable
        private String flags;
        private String pattern;
        @Nullable
        private String replacement;

        public Builder() {}

        private Builder(PatternReplaceTokenFilter o) {
            super(o);
            this.all = o.all;
            this.flags = o.flags;
            this.pattern = o.pattern;
            this.replacement = o.replacement;
        }

        private Builder(Builder o) {
            super(o);
            this.all = o.all;
            this.flags = o.flags;
            this.pattern = o.pattern;
            this.replacement = o.replacement;
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
         * API name: {@code all}
         */
        @Nonnull
        public final Builder all(@Nullable Boolean value) {
            this.all = value;
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
         * Required - API name: {@code pattern}
         */
        @Nonnull
        public final Builder pattern(String value) {
            this.pattern = value;
            return this;
        }

        /**
         * API name: {@code replacement}
         */
        @Nonnull
        public final Builder replacement(@Nullable String value) {
            this.replacement = value;
            return this;
        }

        /**
         * Builds a {@link PatternReplaceTokenFilter}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public PatternReplaceTokenFilter build() {
            _checkSingleUse();

            return new PatternReplaceTokenFilter(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link PatternReplaceTokenFilter}
     */
    public static final JsonpDeserializer<PatternReplaceTokenFilter> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        PatternReplaceTokenFilter::setupPatternReplaceTokenFilterDeserializer
    );

    protected static void setupPatternReplaceTokenFilterDeserializer(ObjectDeserializer<PatternReplaceTokenFilter.Builder> op) {
        setupTokenFilterBaseDeserializer(op);
        op.add(Builder::all, JsonpDeserializer.booleanDeserializer(), "all");
        op.add(Builder::flags, JsonpDeserializer.stringDeserializer(), "flags");
        op.add(Builder::pattern, JsonpDeserializer.stringDeserializer(), "pattern");
        op.add(Builder::replacement, JsonpDeserializer.stringDeserializer(), "replacement");

        op.ignore("type");
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Objects.hashCode(this.all);
        result = 31 * result + Objects.hashCode(this.flags);
        result = 31 * result + this.pattern.hashCode();
        result = 31 * result + Objects.hashCode(this.replacement);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        PatternReplaceTokenFilter other = (PatternReplaceTokenFilter) o;
        return Objects.equals(this.all, other.all)
            && Objects.equals(this.flags, other.flags)
            && this.pattern.equals(other.pattern)
            && Objects.equals(this.replacement, other.replacement);
    }
}
