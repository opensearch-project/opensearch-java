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

package org.opensearch.client.opensearch._types;

import jakarta.json.stream.JsonGenerator;
import java.util.Map;
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

// typedef: _types.InlineScript

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class InlineScript extends ScriptBase implements ToCopyableBuilder<InlineScript.Builder, InlineScript> {

    @Nullable
    private final ScriptLanguage lang;

    @Nonnull
    private final Map<String, String> options;

    @Nonnull
    private final String source;

    // ---------------------------------------------------------------------------------------------

    private InlineScript(Builder builder) {
        super(builder);
        this.lang = builder.lang;
        this.options = ApiTypeHelper.unmodifiable(builder.options);
        this.source = ApiTypeHelper.requireNonNull(builder.source, this, "source");
    }

    public static InlineScript of(Function<InlineScript.Builder, ObjectBuilder<InlineScript>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code lang}
     */
    @Nullable
    public final ScriptLanguage lang() {
        return this.lang;
    }

    /**
     * API name: {@code options}
     */
    @Nonnull
    public final Map<String, String> options() {
        return this.options;
    }

    /**
     * Required - The script source.
     * <p>
     * API name: {@code source}
     * </p>
     */
    @Nonnull
    public final String source() {
        return this.source;
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        super.serializeInternal(generator, mapper);
        if (this.lang != null) {
            generator.writeKey("lang");
            this.lang.serialize(generator, mapper);
        }

        if (ApiTypeHelper.isDefined(this.options)) {
            generator.writeKey("options");
            generator.writeStartObject();
            for (Map.Entry<String, String> item0 : this.options.entrySet()) {
                generator.writeKey(item0.getKey());
                generator.write(item0.getValue());
            }
            generator.writeEnd();
        }

        generator.writeKey("source");
        generator.write(this.source);
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
     * Builder for {@link InlineScript}.
     */
    public static class Builder extends ScriptBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, InlineScript> {
        @Nullable
        private ScriptLanguage lang;
        @Nullable
        private Map<String, String> options;
        private String source;

        public Builder() {}

        private Builder(InlineScript o) {
            super(o);
            this.lang = o.lang;
            this.options = _mapCopy(o.options);
            this.source = o.source;
        }

        private Builder(Builder o) {
            super(o);
            this.lang = o.lang;
            this.options = _mapCopy(o.options);
            this.source = o.source;
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
         * API name: {@code lang}
         */
        @Nonnull
        public final Builder lang(@Nullable ScriptLanguage value) {
            this.lang = value;
            return this;
        }

        /**
         * API name: {@code lang}
         */
        @Nonnull
        public final Builder lang(Function<ScriptLanguage.Builder, ObjectBuilder<ScriptLanguage>> fn) {
            return lang(fn.apply(new ScriptLanguage.Builder()).build());
        }

        /**
         * API name: {@code options}
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>options</code>.
         * </p>
         */
        @Nonnull
        public final Builder options(Map<String, String> map) {
            this.options = _mapPutAll(this.options, map);
            return this;
        }

        /**
         * API name: {@code options}
         *
         * <p>
         * Adds an entry to <code>options</code>.
         * </p>
         */
        @Nonnull
        public final Builder options(String key, String value) {
            this.options = _mapPut(this.options, key, value);
            return this;
        }

        /**
         * Required - The script source.
         * <p>
         * API name: {@code source}
         * </p>
         */
        @Nonnull
        public final Builder source(String value) {
            this.source = value;
            return this;
        }

        /**
         * Builds a {@link InlineScript}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public InlineScript build() {
            _checkSingleUse();

            return new InlineScript(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link InlineScript}
     */
    public static final JsonpDeserializer<InlineScript> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        InlineScript::setupInlineScriptDeserializer
    );

    protected static void setupInlineScriptDeserializer(ObjectDeserializer<InlineScript.Builder> op) {
        setupScriptBaseDeserializer(op);
        op.add(Builder::lang, ScriptLanguage._DESERIALIZER, "lang");
        op.add(Builder::options, JsonpDeserializer.stringMapDeserializer(JsonpDeserializer.stringDeserializer()), "options");
        op.add(Builder::source, JsonpDeserializer.stringDeserializer(), "source");

        op.shortcutProperty("source");
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Objects.hashCode(this.lang);
        result = 31 * result + Objects.hashCode(this.options);
        result = 31 * result + this.source.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        InlineScript other = (InlineScript) o;
        return Objects.equals(this.lang, other.lang) && Objects.equals(this.options, other.options) && this.source.equals(other.source);
    }
}
