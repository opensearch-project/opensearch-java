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

package org.opensearch.client.opensearch.core.get_script_languages;

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
import org.opensearch.client.json.PlainJsonSerializable;
import org.opensearch.client.opensearch._types.ScriptLanguage;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: core.get_script_languages.LanguageContext

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class LanguageContext implements PlainJsonSerializable, ToCopyableBuilder<LanguageContext.Builder, LanguageContext> {

    @Nonnull
    private final List<String> contexts;

    @Nonnull
    private final ScriptLanguage language;

    // ---------------------------------------------------------------------------------------------

    private LanguageContext(Builder builder) {
        this.contexts = ApiTypeHelper.unmodifiableRequired(builder.contexts, this, "contexts");
        this.language = ApiTypeHelper.requireNonNull(builder.language, this, "language");
    }

    public static LanguageContext of(Function<LanguageContext.Builder, ObjectBuilder<LanguageContext>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - API name: {@code contexts}
     */
    @Nonnull
    public final List<String> contexts() {
        return this.contexts;
    }

    /**
     * Required - API name: {@code language}
     */
    @Nonnull
    public final ScriptLanguage language() {
        return this.language;
    }

    /**
     * Serialize this object to JSON.
     */
    @Override
    public void serialize(JsonGenerator generator, JsonpMapper mapper) {
        generator.writeStartObject();
        serializeInternal(generator, mapper);
        generator.writeEnd();
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        generator.writeKey("contexts");
        generator.writeStartArray();
        for (String item0 : this.contexts) {
            generator.write(item0);
        }
        generator.writeEnd();

        generator.writeKey("language");
        this.language.serialize(generator, mapper);
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
     * Builder for {@link LanguageContext}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, LanguageContext> {
        private List<String> contexts;
        private ScriptLanguage language;

        public Builder() {}

        private Builder(LanguageContext o) {
            this.contexts = _listCopy(o.contexts);
            this.language = o.language;
        }

        private Builder(Builder o) {
            this.contexts = _listCopy(o.contexts);
            this.language = o.language;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - API name: {@code contexts}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>contexts</code>.
         * </p>
         */
        @Nonnull
        public final Builder contexts(List<String> list) {
            this.contexts = _listAddAll(this.contexts, list);
            return this;
        }

        /**
         * Required - API name: {@code contexts}
         *
         * <p>
         * Adds one or more values to <code>contexts</code>.
         * </p>
         */
        @Nonnull
        public final Builder contexts(String value, String... values) {
            this.contexts = _listAdd(this.contexts, value, values);
            return this;
        }

        /**
         * Required - API name: {@code language}
         */
        @Nonnull
        public final Builder language(ScriptLanguage value) {
            this.language = value;
            return this;
        }

        /**
         * Required - API name: {@code language}
         */
        @Nonnull
        public final Builder language(Function<ScriptLanguage.Builder, ObjectBuilder<ScriptLanguage>> fn) {
            return language(fn.apply(new ScriptLanguage.Builder()).build());
        }

        /**
         * Builds a {@link LanguageContext}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public LanguageContext build() {
            _checkSingleUse();

            return new LanguageContext(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link LanguageContext}
     */
    public static final JsonpDeserializer<LanguageContext> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        LanguageContext::setupLanguageContextDeserializer
    );

    protected static void setupLanguageContextDeserializer(ObjectDeserializer<LanguageContext.Builder> op) {
        op.add(Builder::contexts, JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()), "contexts");
        op.add(Builder::language, ScriptLanguage._DESERIALIZER, "language");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.contexts.hashCode();
        result = 31 * result + this.language.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        LanguageContext other = (LanguageContext) o;
        return this.contexts.equals(other.contexts) && this.language.equals(other.language);
    }
}
