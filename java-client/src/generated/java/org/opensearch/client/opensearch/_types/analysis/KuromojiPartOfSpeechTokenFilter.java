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
import java.util.List;
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

// typedef: _types.analysis.KuromojiPartOfSpeechTokenFilter

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class KuromojiPartOfSpeechTokenFilter extends TokenFilterBase
    implements
        TokenFilterDefinitionVariant,
        ToCopyableBuilder<KuromojiPartOfSpeechTokenFilter.Builder, KuromojiPartOfSpeechTokenFilter> {

    @Nonnull
    private final List<String> stoptags;

    // ---------------------------------------------------------------------------------------------

    private KuromojiPartOfSpeechTokenFilter(Builder builder) {
        super(builder);
        this.stoptags = ApiTypeHelper.unmodifiableRequired(builder.stoptags, this, "stoptags");
    }

    public static KuromojiPartOfSpeechTokenFilter of(
        Function<KuromojiPartOfSpeechTokenFilter.Builder, ObjectBuilder<KuromojiPartOfSpeechTokenFilter>> fn
    ) {
        return fn.apply(new Builder()).build();
    }

    /**
     * {@link TokenFilterDefinition} variant kind.
     */
    @Override
    public TokenFilterDefinition.Kind _tokenFilterDefinitionKind() {
        return TokenFilterDefinition.Kind.KuromojiPartOfSpeech;
    }

    /**
     * Required - API name: {@code stoptags}
     */
    @Nonnull
    public final List<String> stoptags() {
        return this.stoptags;
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        generator.write("type", "kuromoji_part_of_speech");
        super.serializeInternal(generator, mapper);
        generator.writeKey("stoptags");
        generator.writeStartArray();
        for (String item0 : this.stoptags) {
            generator.write(item0);
        }
        generator.writeEnd();
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
     * Builder for {@link KuromojiPartOfSpeechTokenFilter}.
     */
    public static class Builder extends TokenFilterBase.AbstractBuilder<Builder>
        implements
            CopyableBuilder<Builder, KuromojiPartOfSpeechTokenFilter> {
        private List<String> stoptags;

        public Builder() {}

        private Builder(KuromojiPartOfSpeechTokenFilter o) {
            super(o);
            this.stoptags = _listCopy(o.stoptags);
        }

        private Builder(Builder o) {
            super(o);
            this.stoptags = _listCopy(o.stoptags);
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
         * Required - API name: {@code stoptags}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>stoptags</code>.
         * </p>
         */
        @Nonnull
        public final Builder stoptags(List<String> list) {
            this.stoptags = _listAddAll(this.stoptags, list);
            return this;
        }

        /**
         * Required - API name: {@code stoptags}
         *
         * <p>
         * Adds one or more values to <code>stoptags</code>.
         * </p>
         */
        @Nonnull
        public final Builder stoptags(String value, String... values) {
            this.stoptags = _listAdd(this.stoptags, value, values);
            return this;
        }

        /**
         * Builds a {@link KuromojiPartOfSpeechTokenFilter}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public KuromojiPartOfSpeechTokenFilter build() {
            _checkSingleUse();

            return new KuromojiPartOfSpeechTokenFilter(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link KuromojiPartOfSpeechTokenFilter}
     */
    public static final JsonpDeserializer<KuromojiPartOfSpeechTokenFilter> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        KuromojiPartOfSpeechTokenFilter::setupKuromojiPartOfSpeechTokenFilterDeserializer
    );

    protected static void setupKuromojiPartOfSpeechTokenFilterDeserializer(ObjectDeserializer<KuromojiPartOfSpeechTokenFilter.Builder> op) {
        setupTokenFilterBaseDeserializer(op);
        op.add(Builder::stoptags, JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()), "stoptags");

        op.ignore("type");
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + this.stoptags.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        KuromojiPartOfSpeechTokenFilter other = (KuromojiPartOfSpeechTokenFilter) o;
        return this.stoptags.equals(other.stoptags);
    }
}
