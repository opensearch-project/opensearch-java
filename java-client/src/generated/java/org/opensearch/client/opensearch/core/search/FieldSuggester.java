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
import java.util.Objects;
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.opensearch.client.json.JsonData;
import org.opensearch.client.json.JsonEnum;
import org.opensearch.client.json.JsonpDeserializable;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.JsonpSerializable;
import org.opensearch.client.json.ObjectBuilderDeserializer;
import org.opensearch.client.json.ObjectDeserializer;
import org.opensearch.client.json.PlainJsonSerializable;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.TaggedUnion;
import org.opensearch.client.util.TaggedUnionUtils;

// typedef: core.search.FieldSuggester

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class FieldSuggester implements TaggedUnion<FieldSuggester.Kind, FieldSuggesterVariant>, PlainJsonSerializable {
    /**
     * {@link FieldSuggester} variant kinds.
     */
    public enum Kind implements JsonEnum {
        Completion("completion"),
        Phrase("phrase"),
        Term("term"),
        /** A custom variant type not natively supported by this client. */
        _Custom(null);

        private final String jsonValue;

        Kind(String jsonValue) {
            this.jsonValue = jsonValue;
        }

        @Override
        public String jsonValue() {
            return jsonValue;
        }
    }

    private final Kind _kind;
    private final FieldSuggesterVariant _value;
    private final String _customKind;

    @Override
    public final Kind _kind() {
        return _kind;
    }

    @Override
    public final FieldSuggesterVariant _get() {
        return _value;
    }

    /**
     * Returns the actual type name when {@code _kind() == Kind._Custom}, otherwise {@code null}.
     */
    public final String _customKind() {
        return _customKind;
    }

    @Nullable
    private final String prefix;

    @Nullable
    private final String regex;

    @Nullable
    private final String text;

    public FieldSuggester(FieldSuggesterVariant value) {
        this._kind = ApiTypeHelper.requireNonNull(value._fieldSuggesterKind(), this, "<variant kind>");
        this._value = ApiTypeHelper.requireNonNull(value, this, "<variant value>");
        this._customKind = null;
        this.prefix = null;
        this.regex = null;
        this.text = null;
    }

    private FieldSuggester(Builder builder) {
        this.prefix = builder.prefix;
        this.regex = builder.regex;
        this.text = builder.text;
        this._kind = ApiTypeHelper.requireNonNull(builder._kind, builder, "<variant kind>");
        this._value = ApiTypeHelper.requireNonNull(builder._value, builder, "<variant value>");
        this._customKind = builder._customKind;
    }

    public static FieldSuggester of(Function<FieldSuggester.Builder, ObjectBuilder<FieldSuggester>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code prefix}
     */
    @Nullable
    public final String prefix() {
        return this.prefix;
    }

    /**
     * API name: {@code regex}
     */
    @Nullable
    public final String regex() {
        return this.regex;
    }

    /**
     * API name: {@code text}
     */
    @Nullable
    public final String text() {
        return this.text;
    }

    /**
     * Is this variant instance of kind {@code completion}?
     */
    public boolean isCompletion() {
        return _kind == Kind.Completion;
    }

    /**
     * Get the {@code completion} variant value.
     *
     * @throws IllegalStateException if the current variant is not the {@code completion} kind.
     */
    public CompletionSuggester completion() {
        return TaggedUnionUtils.get(this, Kind.Completion);
    }

    /**
     * Is this variant instance of kind {@code phrase}?
     */
    public boolean isPhrase() {
        return _kind == Kind.Phrase;
    }

    /**
     * Get the {@code phrase} variant value.
     *
     * @throws IllegalStateException if the current variant is not the {@code phrase} kind.
     */
    public PhraseSuggester phrase() {
        return TaggedUnionUtils.get(this, Kind.Phrase);
    }

    /**
     * Is this variant instance of kind {@code term}?
     */
    public boolean isTerm() {
        return _kind == Kind.Term;
    }

    /**
     * Get the {@code term} variant value.
     *
     * @throws IllegalStateException if the current variant is not the {@code term} kind.
     */
    public TermSuggester term() {
        return TaggedUnionUtils.get(this, Kind.Term);
    }

    /**
     * Is this variant instance of kind {@code _custom}?
     */
    public boolean _isCustom() {
        return _kind == Kind._Custom;
    }

    /**
     * Get the raw JSON data for a custom (plugin-provided) variant type.
     *
     * @throws IllegalStateException if the current variant is not the {@code _custom} kind.
     */
    public JsonData _custom() {
        if (_kind != Kind._Custom) {
            throw new IllegalStateException("Expected variant kind '_custom' but got '" + _kind + "'");
        }
        return ((CustomVariant) _value).data();
    }

    @Override
    public void serialize(JsonGenerator generator, JsonpMapper mapper) {
        generator.writeStartObject();
        if (this.prefix != null) {
            generator.writeKey("prefix");
            generator.write(this.prefix);
        }

        if (this.regex != null) {
            generator.writeKey("regex");
            generator.write(this.regex);
        }

        if (this.text != null) {
            generator.writeKey("text");
            generator.write(this.text);
        }
        generator.writeKey(_kind == Kind._Custom ? _customKind : _kind.jsonValue());
        if (_value instanceof JsonpSerializable) {
            ((JsonpSerializable) _value).serialize(generator, mapper);
        }
        generator.writeEnd();
    }

    @Nonnull
    public Builder toBuilder() {
        return new Builder(this);
    }

    @Nonnull
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder extends ObjectBuilderBase {
        private Kind _kind;
        private FieldSuggesterVariant _value;
        private String _customKind;
        @Nullable
        private String prefix;
        @Nullable
        private String regex;
        @Nullable
        private String text;

        public Builder() {}

        private Builder(FieldSuggester o) {
            this.prefix = o.prefix;
            this.regex = o.regex;
            this.text = o.text;
            this._kind = o._kind;
            this._value = o._value;
            this._customKind = o._customKind;
        }

        /**
         * API name: {@code prefix}
         */
        @Nonnull
        public final Builder prefix(@Nullable String value) {
            this.prefix = value;
            return this;
        }

        /**
         * API name: {@code regex}
         */
        @Nonnull
        public final Builder regex(@Nullable String value) {
            this.regex = value;
            return this;
        }

        /**
         * API name: {@code text}
         */
        @Nonnull
        public final Builder text(@Nullable String value) {
            this.text = value;
            return this;
        }

        public ContainerBuilder completion(CompletionSuggester v) {
            this._kind = Kind.Completion;
            this._value = v;
            return new ContainerBuilder();
        }

        public ContainerBuilder completion(Function<CompletionSuggester.Builder, ObjectBuilder<CompletionSuggester>> fn) {
            return this.completion(fn.apply(new CompletionSuggester.Builder()).build());
        }

        public ContainerBuilder phrase(PhraseSuggester v) {
            this._kind = Kind.Phrase;
            this._value = v;
            return new ContainerBuilder();
        }

        public ContainerBuilder phrase(Function<PhraseSuggester.Builder, ObjectBuilder<PhraseSuggester>> fn) {
            return this.phrase(fn.apply(new PhraseSuggester.Builder()).build());
        }

        public ContainerBuilder term(TermSuggester v) {
            this._kind = Kind.Term;
            this._value = v;
            return new ContainerBuilder();
        }

        public ContainerBuilder term(Function<TermSuggester.Builder, ObjectBuilder<TermSuggester>> fn) {
            return this.term(fn.apply(new TermSuggester.Builder()).build());
        }

        /**
         * Set a custom (plugin-provided) variant.
         *
         * @param type the variant type name as returned by the server
         * @param data the raw JSON body of the variant result
         */
        public ContainerBuilder _custom(String type, JsonData data) {
            this._kind = Kind._Custom;
            this._customKind = ApiTypeHelper.requireNonNull(type, this, "<custom variant type>");
            this._value = new CustomVariant(ApiTypeHelper.requireNonNull(data, this, "<custom variant data>"));
            return new ContainerBuilder();
        }

        protected FieldSuggester build() {
            _checkSingleUse();
            return new FieldSuggester(this);
        }

        public class ContainerBuilder implements ObjectBuilder<FieldSuggester> {
            private ContainerBuilder() {}

            /**
             * API name: {@code prefix}
             */
            @Nonnull
            public final ContainerBuilder prefix(@Nullable String value) {
                Builder.this.prefix = value;
                return this;
            }

            /**
             * API name: {@code regex}
             */
            @Nonnull
            public final ContainerBuilder regex(@Nullable String value) {
                Builder.this.regex = value;
                return this;
            }

            /**
             * API name: {@code text}
             */
            @Nonnull
            public final ContainerBuilder text(@Nullable String value) {
                Builder.this.text = value;
                return this;
            }

            @Override
            public FieldSuggester build() {
                return Builder.this.build();
            }
        }
    }

    protected static void setupFieldSuggesterDeserializer(ObjectDeserializer<Builder> op) {
        op.add(Builder::prefix, JsonpDeserializer.stringDeserializer(), "prefix");
        op.add(Builder::regex, JsonpDeserializer.stringDeserializer(), "regex");
        op.add(Builder::text, JsonpDeserializer.stringDeserializer(), "text");
        op.add(Builder::completion, CompletionSuggester._DESERIALIZER, "completion");
        op.add(Builder::phrase, PhraseSuggester._DESERIALIZER, "phrase");
        op.add(Builder::term, TermSuggester._DESERIALIZER, "term");
        op.setUnknownFieldHandler(
            (builder, name, parser, mapper) -> builder._custom(name, JsonData._DESERIALIZER.deserialize(parser, mapper))
        );
    }

    public static final JsonpDeserializer<FieldSuggester> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        FieldSuggester::setupFieldSuggesterDeserializer,
        Builder::build
    );

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this._kind);
        result = 31 * result + Objects.hashCode(this._value);
        result = 31 * result + Objects.hashCode(this._customKind);
        result = 31 * result + Objects.hashCode(this.prefix);
        result = 31 * result + Objects.hashCode(this.regex);
        result = 31 * result + Objects.hashCode(this.text);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        FieldSuggester other = (FieldSuggester) o;
        return Objects.equals(this._kind, other._kind)
            && Objects.equals(this._value, other._value)
            && Objects.equals(this._customKind, other._customKind)
            && Objects.equals(this.prefix, other.prefix)
            && Objects.equals(this.regex, other.regex)
            && Objects.equals(this.text, other.text);
    }

    // Wrapper so JsonData fits the variant interface slot for custom/plugin types
    private static final class CustomVariant implements FieldSuggesterVariant, PlainJsonSerializable {
        private final JsonData data;

        CustomVariant(JsonData data) {
            this.data = data;
        }

        public JsonData data() {
            return data;
        }

        @Override
        public Kind _fieldSuggesterKind() {
            return Kind._Custom;
        }

        @Override
        public void serialize(JsonGenerator generator, JsonpMapper mapper) {
            data.serialize(generator, mapper);
        }

        @Override
        public int hashCode() {
            return data.hashCode();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            return data.equals(((CustomVariant) o).data);
        }
    }
}
