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

// typedef: _types.analysis.PathHierarchyTokenizer

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class PathHierarchyTokenizer extends TokenizerBase
    implements
        TokenizerDefinitionVariant,
        ToCopyableBuilder<PathHierarchyTokenizer.Builder, PathHierarchyTokenizer> {

    private final int bufferSize;

    @Nonnull
    private final String delimiter;

    @Nullable
    private final String replacement;

    private final boolean reverse;

    private final int skip;

    // ---------------------------------------------------------------------------------------------

    private PathHierarchyTokenizer(Builder builder) {
        super(builder);
        this.bufferSize = ApiTypeHelper.requireNonNull(builder.bufferSize, this, "bufferSize");
        this.delimiter = ApiTypeHelper.requireNonNull(builder.delimiter, this, "delimiter");
        this.replacement = builder.replacement;
        this.reverse = ApiTypeHelper.requireNonNull(builder.reverse, this, "reverse");
        this.skip = ApiTypeHelper.requireNonNull(builder.skip, this, "skip");
    }

    public static PathHierarchyTokenizer of(Function<PathHierarchyTokenizer.Builder, ObjectBuilder<PathHierarchyTokenizer>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * {@link TokenizerDefinition} variant kind.
     */
    @Override
    public TokenizerDefinition.Kind _tokenizerDefinitionKind() {
        return TokenizerDefinition.Kind.PathHierarchy;
    }

    /**
     * Required - API name: {@code buffer_size}
     */
    public final int bufferSize() {
        return this.bufferSize;
    }

    /**
     * Required - API name: {@code delimiter}
     */
    @Nonnull
    public final String delimiter() {
        return this.delimiter;
    }

    /**
     * API name: {@code replacement}
     */
    @Nullable
    public final String replacement() {
        return this.replacement;
    }

    /**
     * Required - API name: {@code reverse}
     */
    public final boolean reverse() {
        return this.reverse;
    }

    /**
     * Required - API name: {@code skip}
     */
    public final int skip() {
        return this.skip;
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        generator.write("type", "path_hierarchy");
        super.serializeInternal(generator, mapper);
        generator.writeKey("buffer_size");
        generator.write(this.bufferSize);

        generator.writeKey("delimiter");
        generator.write(this.delimiter);

        if (this.replacement != null) {
            generator.writeKey("replacement");
            generator.write(this.replacement);
        }

        generator.writeKey("reverse");
        generator.write(this.reverse);

        generator.writeKey("skip");
        generator.write(this.skip);
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
     * Builder for {@link PathHierarchyTokenizer}.
     */
    public static class Builder extends TokenizerBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, PathHierarchyTokenizer> {
        private Integer bufferSize;
        private String delimiter;
        @Nullable
        private String replacement;
        private Boolean reverse;
        private Integer skip;

        public Builder() {}

        private Builder(PathHierarchyTokenizer o) {
            super(o);
            this.bufferSize = o.bufferSize;
            this.delimiter = o.delimiter;
            this.replacement = o.replacement;
            this.reverse = o.reverse;
            this.skip = o.skip;
        }

        private Builder(Builder o) {
            super(o);
            this.bufferSize = o.bufferSize;
            this.delimiter = o.delimiter;
            this.replacement = o.replacement;
            this.reverse = o.reverse;
            this.skip = o.skip;
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
         * Required - API name: {@code buffer_size}
         */
        @Nonnull
        public final Builder bufferSize(int value) {
            this.bufferSize = value;
            return this;
        }

        /**
         * Required - API name: {@code delimiter}
         */
        @Nonnull
        public final Builder delimiter(String value) {
            this.delimiter = value;
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
         * Required - API name: {@code reverse}
         */
        @Nonnull
        public final Builder reverse(boolean value) {
            this.reverse = value;
            return this;
        }

        /**
         * Required - API name: {@code skip}
         */
        @Nonnull
        public final Builder skip(int value) {
            this.skip = value;
            return this;
        }

        /**
         * Builds a {@link PathHierarchyTokenizer}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public PathHierarchyTokenizer build() {
            _checkSingleUse();

            return new PathHierarchyTokenizer(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link PathHierarchyTokenizer}
     */
    public static final JsonpDeserializer<PathHierarchyTokenizer> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        PathHierarchyTokenizer::setupPathHierarchyTokenizerDeserializer
    );

    protected static void setupPathHierarchyTokenizerDeserializer(ObjectDeserializer<PathHierarchyTokenizer.Builder> op) {
        setupTokenizerBaseDeserializer(op);
        op.add(Builder::bufferSize, JsonpDeserializer.integerDeserializer(), "buffer_size");
        op.add(Builder::delimiter, JsonpDeserializer.stringDeserializer(), "delimiter");
        op.add(Builder::replacement, JsonpDeserializer.stringDeserializer(), "replacement");
        op.add(Builder::reverse, JsonpDeserializer.booleanDeserializer(), "reverse");
        op.add(Builder::skip, JsonpDeserializer.integerDeserializer(), "skip");

        op.ignore("type");
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Integer.hashCode(this.bufferSize);
        result = 31 * result + this.delimiter.hashCode();
        result = 31 * result + Objects.hashCode(this.replacement);
        result = 31 * result + Boolean.hashCode(this.reverse);
        result = 31 * result + Integer.hashCode(this.skip);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        PathHierarchyTokenizer other = (PathHierarchyTokenizer) o;
        return this.bufferSize == other.bufferSize
            && this.delimiter.equals(other.delimiter)
            && Objects.equals(this.replacement, other.replacement)
            && this.reverse == other.reverse
            && this.skip == other.skip;
    }
}
