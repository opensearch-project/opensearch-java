/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
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
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: _types.analysis.SmartcnTokenizer

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class SmartcnTokenizer extends TokenizerBase
    implements
        TokenizerDefinitionVariant,
        ToCopyableBuilder<SmartcnTokenizer.Builder, SmartcnTokenizer> {

    // ---------------------------------------------------------------------------------------------

    private SmartcnTokenizer(Builder builder) {
        super(builder);
    }

    public static SmartcnTokenizer of(Function<SmartcnTokenizer.Builder, ObjectBuilder<SmartcnTokenizer>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * {@link TokenizerDefinition} variant kind.
     */
    @Override
    public TokenizerDefinition.Kind _tokenizerDefinitionKind() {
        return TokenizerDefinition.Kind.SmartcnTokenizer;
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        generator.write("type", "smartcn_tokenizer");
        super.serializeInternal(generator, mapper);
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
     * Builder for {@link SmartcnTokenizer}.
     */
    public static class Builder extends TokenizerBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, SmartcnTokenizer> {

        public Builder() {}

        private Builder(SmartcnTokenizer o) {
            super(o);
        }

        private Builder(Builder o) {
            super(o);
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
         * Builds a {@link SmartcnTokenizer}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public SmartcnTokenizer build() {
            _checkSingleUse();

            return new SmartcnTokenizer(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link SmartcnTokenizer}
     */
    public static final JsonpDeserializer<SmartcnTokenizer> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        SmartcnTokenizer::setupSmartcnTokenizerDeserializer
    );

    protected static void setupSmartcnTokenizerDeserializer(ObjectDeserializer<SmartcnTokenizer.Builder> op) {
        setupTokenizerBaseDeserializer(op);

        op.ignore("type");
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        return true;
    }
}
