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

package org.opensearch.client.opensearch.core;

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
import org.opensearch.client.opensearch.core.get_script_languages.LanguageContext;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: get_script_languages.Response

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class GetScriptLanguagesResponse
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<GetScriptLanguagesResponse.Builder, GetScriptLanguagesResponse> {

    @Nonnull
    private final List<LanguageContext> languageContexts;

    @Nonnull
    private final List<String> typesAllowed;

    // ---------------------------------------------------------------------------------------------

    private GetScriptLanguagesResponse(Builder builder) {
        this.languageContexts = ApiTypeHelper.unmodifiableRequired(builder.languageContexts, this, "languageContexts");
        this.typesAllowed = ApiTypeHelper.unmodifiableRequired(builder.typesAllowed, this, "typesAllowed");
    }

    public static GetScriptLanguagesResponse of(
        Function<GetScriptLanguagesResponse.Builder, ObjectBuilder<GetScriptLanguagesResponse>> fn
    ) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - API name: {@code language_contexts}
     */
    @Nonnull
    public final List<LanguageContext> languageContexts() {
        return this.languageContexts;
    }

    /**
     * Required - API name: {@code types_allowed}
     */
    @Nonnull
    public final List<String> typesAllowed() {
        return this.typesAllowed;
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
        generator.writeKey("language_contexts");
        generator.writeStartArray();
        for (LanguageContext item0 : this.languageContexts) {
            item0.serialize(generator, mapper);
        }
        generator.writeEnd();

        generator.writeKey("types_allowed");
        generator.writeStartArray();
        for (String item0 : this.typesAllowed) {
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
     * Builder for {@link GetScriptLanguagesResponse}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, GetScriptLanguagesResponse> {
        private List<LanguageContext> languageContexts;
        private List<String> typesAllowed;

        public Builder() {}

        private Builder(GetScriptLanguagesResponse o) {
            this.languageContexts = _listCopy(o.languageContexts);
            this.typesAllowed = _listCopy(o.typesAllowed);
        }

        private Builder(Builder o) {
            this.languageContexts = _listCopy(o.languageContexts);
            this.typesAllowed = _listCopy(o.typesAllowed);
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - API name: {@code language_contexts}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>languageContexts</code>.
         * </p>
         */
        @Nonnull
        public final Builder languageContexts(List<LanguageContext> list) {
            this.languageContexts = _listAddAll(this.languageContexts, list);
            return this;
        }

        /**
         * Required - API name: {@code language_contexts}
         *
         * <p>
         * Adds one or more values to <code>languageContexts</code>.
         * </p>
         */
        @Nonnull
        public final Builder languageContexts(LanguageContext value, LanguageContext... values) {
            this.languageContexts = _listAdd(this.languageContexts, value, values);
            return this;
        }

        /**
         * Required - API name: {@code language_contexts}
         *
         * <p>
         * Adds a value to <code>languageContexts</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder languageContexts(Function<LanguageContext.Builder, ObjectBuilder<LanguageContext>> fn) {
            return languageContexts(fn.apply(new LanguageContext.Builder()).build());
        }

        /**
         * Required - API name: {@code types_allowed}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>typesAllowed</code>.
         * </p>
         */
        @Nonnull
        public final Builder typesAllowed(List<String> list) {
            this.typesAllowed = _listAddAll(this.typesAllowed, list);
            return this;
        }

        /**
         * Required - API name: {@code types_allowed}
         *
         * <p>
         * Adds one or more values to <code>typesAllowed</code>.
         * </p>
         */
        @Nonnull
        public final Builder typesAllowed(String value, String... values) {
            this.typesAllowed = _listAdd(this.typesAllowed, value, values);
            return this;
        }

        /**
         * Builds a {@link GetScriptLanguagesResponse}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public GetScriptLanguagesResponse build() {
            _checkSingleUse();

            return new GetScriptLanguagesResponse(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link GetScriptLanguagesResponse}
     */
    public static final JsonpDeserializer<GetScriptLanguagesResponse> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        GetScriptLanguagesResponse::setupGetScriptLanguagesResponseDeserializer
    );

    protected static void setupGetScriptLanguagesResponseDeserializer(ObjectDeserializer<GetScriptLanguagesResponse.Builder> op) {
        op.add(Builder::languageContexts, JsonpDeserializer.arrayDeserializer(LanguageContext._DESERIALIZER), "language_contexts");
        op.add(Builder::typesAllowed, JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()), "types_allowed");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.languageContexts.hashCode();
        result = 31 * result + this.typesAllowed.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        GetScriptLanguagesResponse other = (GetScriptLanguagesResponse) o;
        return this.languageContexts.equals(other.languageContexts) && this.typesAllowed.equals(other.typesAllowed);
    }
}
