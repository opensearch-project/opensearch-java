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
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import org.opensearch.client.json.JsonpDeserializable;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.ObjectBuilderDeserializer;
import org.opensearch.client.json.ObjectDeserializer;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: _types.analysis.IcuTokenizer

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class IcuTokenizer extends TokenizerBase
    implements
        TokenFilterDefinitionVariant,
        TokenizerDefinitionVariant,
        ToCopyableBuilder<IcuTokenizer.Builder, IcuTokenizer> {

    @Nonnull
    private final String ruleFiles;

    // ---------------------------------------------------------------------------------------------

    private IcuTokenizer(Builder builder) {
        super(builder);
        this.ruleFiles = ApiTypeHelper.requireNonNull(builder.ruleFiles, this, "ruleFiles");
    }

    public static IcuTokenizer of(Function<IcuTokenizer.Builder, ObjectBuilder<IcuTokenizer>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * {@link TokenFilterDefinition} variant kind.
     */
    @Override
    public TokenFilterDefinition.Kind _tokenFilterDefinitionKind() {
        return TokenFilterDefinition.Kind.IcuTokenizer;
    }

    /**
     * {@link TokenizerDefinition} variant kind.
     */
    @Override
    public TokenizerDefinition.Kind _tokenizerDefinitionKind() {
        return TokenizerDefinition.Kind.IcuTokenizer;
    }

    /**
     * Required - API name: {@code rule_files}
     */
    @Nonnull
    public final String ruleFiles() {
        return this.ruleFiles;
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        generator.write("type", "icu_tokenizer");
        super.serializeInternal(generator, mapper);
        generator.writeKey("rule_files");
        generator.write(this.ruleFiles);
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
     * Builder for {@link IcuTokenizer}.
     */
    public static class Builder extends TokenizerBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, IcuTokenizer> {
        private String ruleFiles;

        public Builder() {}

        private Builder(IcuTokenizer o) {
            super(o);
            this.ruleFiles = o.ruleFiles;
        }

        private Builder(Builder o) {
            super(o);
            this.ruleFiles = o.ruleFiles;
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
         * Required - API name: {@code rule_files}
         */
        @Nonnull
        public final Builder ruleFiles(String value) {
            this.ruleFiles = value;
            return this;
        }

        /**
         * Builds a {@link IcuTokenizer}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public IcuTokenizer build() {
            _checkSingleUse();

            return new IcuTokenizer(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link IcuTokenizer}
     */
    public static final JsonpDeserializer<IcuTokenizer> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        IcuTokenizer::setupIcuTokenizerDeserializer
    );

    protected static void setupIcuTokenizerDeserializer(ObjectDeserializer<IcuTokenizer.Builder> op) {
        setupTokenizerBaseDeserializer(op);
        op.add(Builder::ruleFiles, JsonpDeserializer.stringDeserializer(), "rule_files");

        op.ignore("type");
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + this.ruleFiles.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        IcuTokenizer other = (IcuTokenizer) o;
        return this.ruleFiles.equals(other.ruleFiles);
    }
}
