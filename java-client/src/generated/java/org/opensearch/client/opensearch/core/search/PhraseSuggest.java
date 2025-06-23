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

package org.opensearch.client.opensearch.core.search;

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

// typedef: core.search.PhraseSuggest

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class PhraseSuggest extends SuggestBase implements SuggestVariant, ToCopyableBuilder<PhraseSuggest.Builder, PhraseSuggest> {

    @Nonnull
    private final List<PhraseSuggestOption> options;

    // ---------------------------------------------------------------------------------------------

    private PhraseSuggest(Builder builder) {
        super(builder);
        this.options = ApiTypeHelper.unmodifiableRequired(builder.options, this, "options");
    }

    public static PhraseSuggest of(Function<PhraseSuggest.Builder, ObjectBuilder<PhraseSuggest>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * {@link Suggest} variant kind.
     */
    @Override
    public Suggest.Kind _suggestKind() {
        return Suggest.Kind.Phrase;
    }

    /**
     * Required - API name: {@code options}
     */
    @Nonnull
    public final List<PhraseSuggestOption> options() {
        return this.options;
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        super.serializeInternal(generator, mapper);
        generator.writeKey("options");
        generator.writeStartArray();
        for (PhraseSuggestOption item0 : this.options) {
            item0.serialize(generator, mapper);
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
     * Builder for {@link PhraseSuggest}.
     */
    public static class Builder extends SuggestBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, PhraseSuggest> {
        private List<PhraseSuggestOption> options;

        public Builder() {}

        private Builder(PhraseSuggest o) {
            super(o);
            this.options = _listCopy(o.options);
        }

        private Builder(Builder o) {
            super(o);
            this.options = _listCopy(o.options);
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
         * Required - API name: {@code options}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>options</code>.
         * </p>
         */
        @Nonnull
        public final Builder options(List<PhraseSuggestOption> list) {
            this.options = _listAddAll(this.options, list);
            return this;
        }

        /**
         * Required - API name: {@code options}
         *
         * <p>
         * Adds one or more values to <code>options</code>.
         * </p>
         */
        @Nonnull
        public final Builder options(PhraseSuggestOption value, PhraseSuggestOption... values) {
            this.options = _listAdd(this.options, value, values);
            return this;
        }

        /**
         * Required - API name: {@code options}
         *
         * <p>
         * Adds a value to <code>options</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder options(Function<PhraseSuggestOption.Builder, ObjectBuilder<PhraseSuggestOption>> fn) {
            return options(fn.apply(new PhraseSuggestOption.Builder()).build());
        }

        /**
         * Builds a {@link PhraseSuggest}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public PhraseSuggest build() {
            _checkSingleUse();

            return new PhraseSuggest(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link PhraseSuggest}
     */
    public static final JsonpDeserializer<PhraseSuggest> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        PhraseSuggest::setupPhraseSuggestDeserializer
    );

    protected static void setupPhraseSuggestDeserializer(ObjectDeserializer<PhraseSuggest.Builder> op) {
        setupSuggestBaseDeserializer(op);
        op.add(Builder::options, JsonpDeserializer.arrayDeserializer(PhraseSuggestOption._DESERIALIZER), "options");
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + this.options.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        PhraseSuggest other = (PhraseSuggest) o;
        return this.options.equals(other.options);
    }
}
