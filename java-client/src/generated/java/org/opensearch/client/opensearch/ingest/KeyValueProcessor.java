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

package org.opensearch.client.opensearch.ingest;

import jakarta.json.stream.JsonGenerator;
import java.util.List;
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

// typedef: ingest.KeyValueProcessor

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class KeyValueProcessor extends ProcessorBase
    implements
        ProcessorVariant,
        ToCopyableBuilder<KeyValueProcessor.Builder, KeyValueProcessor> {

    @Nonnull
    private final List<String> excludeKeys;

    @Nonnull
    private final String field;

    @Nonnull
    private final String fieldSplit;

    @Nullable
    private final Boolean ignoreMissing;

    @Nonnull
    private final List<String> includeKeys;

    @Nullable
    private final String prefix;

    @Nullable
    private final Boolean stripBrackets;

    @Nullable
    private final String targetField;

    @Nullable
    private final String trimKey;

    @Nullable
    private final String trimValue;

    @Nonnull
    private final String valueSplit;

    // ---------------------------------------------------------------------------------------------

    private KeyValueProcessor(Builder builder) {
        super(builder);
        this.excludeKeys = ApiTypeHelper.unmodifiable(builder.excludeKeys);
        this.field = ApiTypeHelper.requireNonNull(builder.field, this, "field");
        this.fieldSplit = ApiTypeHelper.requireNonNull(builder.fieldSplit, this, "fieldSplit");
        this.ignoreMissing = builder.ignoreMissing;
        this.includeKeys = ApiTypeHelper.unmodifiable(builder.includeKeys);
        this.prefix = builder.prefix;
        this.stripBrackets = builder.stripBrackets;
        this.targetField = builder.targetField;
        this.trimKey = builder.trimKey;
        this.trimValue = builder.trimValue;
        this.valueSplit = ApiTypeHelper.requireNonNull(builder.valueSplit, this, "valueSplit");
    }

    public static KeyValueProcessor of(Function<KeyValueProcessor.Builder, ObjectBuilder<KeyValueProcessor>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * {@link Processor} variant kind.
     */
    @Override
    public Processor.Kind _processorKind() {
        return Processor.Kind.Kv;
    }

    /**
     * List of keys to exclude from document.
     * <p>
     * API name: {@code exclude_keys}
     * </p>
     */
    @Nonnull
    public final List<String> excludeKeys() {
        return this.excludeKeys;
    }

    /**
     * Required - API name: {@code field}
     */
    @Nonnull
    public final String field() {
        return this.field;
    }

    /**
     * Required - Regex pattern to use for splitting key-value pairs.
     * <p>
     * API name: {@code field_split}
     * </p>
     */
    @Nonnull
    public final String fieldSplit() {
        return this.fieldSplit;
    }

    /**
     * If <code>true</code> and <code>field</code> does not exist or is <code>null</code>, the processor quietly exits without modifying the
     * document.
     * <p>
     * API name: {@code ignore_missing}
     * </p>
     */
    @Nullable
    public final Boolean ignoreMissing() {
        return this.ignoreMissing;
    }

    /**
     * List of keys to filter and insert into document. Defaults to including all keys.
     * <p>
     * API name: {@code include_keys}
     * </p>
     */
    @Nonnull
    public final List<String> includeKeys() {
        return this.includeKeys;
    }

    /**
     * Prefix to be added to extracted keys.
     * <p>
     * API name: {@code prefix}
     * </p>
     */
    @Nullable
    public final String prefix() {
        return this.prefix;
    }

    /**
     * If <code>true</code>. strip brackets <code>()</code>, <code>&lt;&gt;</code>, <code>[]</code> as well as quotes <code>'</code> and
     * <code>&quot;</code> from extracted values.
     * <p>
     * API name: {@code strip_brackets}
     * </p>
     */
    @Nullable
    public final Boolean stripBrackets() {
        return this.stripBrackets;
    }

    /**
     * API name: {@code target_field}
     */
    @Nullable
    public final String targetField() {
        return this.targetField;
    }

    /**
     * String of characters to trim from extracted keys.
     * <p>
     * API name: {@code trim_key}
     * </p>
     */
    @Nullable
    public final String trimKey() {
        return this.trimKey;
    }

    /**
     * String of characters to trim from extracted values.
     * <p>
     * API name: {@code trim_value}
     * </p>
     */
    @Nullable
    public final String trimValue() {
        return this.trimValue;
    }

    /**
     * Required - Regex pattern to use for splitting the key from the value within a key-value pair.
     * <p>
     * API name: {@code value_split}
     * </p>
     */
    @Nonnull
    public final String valueSplit() {
        return this.valueSplit;
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        super.serializeInternal(generator, mapper);
        if (ApiTypeHelper.isDefined(this.excludeKeys)) {
            generator.writeKey("exclude_keys");
            generator.writeStartArray();
            for (String item0 : this.excludeKeys) {
                generator.write(item0);
            }
            generator.writeEnd();
        }

        generator.writeKey("field");
        generator.write(this.field);

        generator.writeKey("field_split");
        generator.write(this.fieldSplit);

        if (this.ignoreMissing != null) {
            generator.writeKey("ignore_missing");
            generator.write(this.ignoreMissing);
        }

        if (ApiTypeHelper.isDefined(this.includeKeys)) {
            generator.writeKey("include_keys");
            generator.writeStartArray();
            for (String item0 : this.includeKeys) {
                generator.write(item0);
            }
            generator.writeEnd();
        }

        if (this.prefix != null) {
            generator.writeKey("prefix");
            generator.write(this.prefix);
        }

        if (this.stripBrackets != null) {
            generator.writeKey("strip_brackets");
            generator.write(this.stripBrackets);
        }

        if (this.targetField != null) {
            generator.writeKey("target_field");
            generator.write(this.targetField);
        }

        if (this.trimKey != null) {
            generator.writeKey("trim_key");
            generator.write(this.trimKey);
        }

        if (this.trimValue != null) {
            generator.writeKey("trim_value");
            generator.write(this.trimValue);
        }

        generator.writeKey("value_split");
        generator.write(this.valueSplit);
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
     * Builder for {@link KeyValueProcessor}.
     */
    public static class Builder extends ProcessorBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, KeyValueProcessor> {
        @Nullable
        private List<String> excludeKeys;
        private String field;
        private String fieldSplit;
        @Nullable
        private Boolean ignoreMissing;
        @Nullable
        private List<String> includeKeys;
        @Nullable
        private String prefix;
        @Nullable
        private Boolean stripBrackets;
        @Nullable
        private String targetField;
        @Nullable
        private String trimKey;
        @Nullable
        private String trimValue;
        private String valueSplit;

        public Builder() {}

        private Builder(KeyValueProcessor o) {
            super(o);
            this.excludeKeys = _listCopy(o.excludeKeys);
            this.field = o.field;
            this.fieldSplit = o.fieldSplit;
            this.ignoreMissing = o.ignoreMissing;
            this.includeKeys = _listCopy(o.includeKeys);
            this.prefix = o.prefix;
            this.stripBrackets = o.stripBrackets;
            this.targetField = o.targetField;
            this.trimKey = o.trimKey;
            this.trimValue = o.trimValue;
            this.valueSplit = o.valueSplit;
        }

        private Builder(Builder o) {
            super(o);
            this.excludeKeys = _listCopy(o.excludeKeys);
            this.field = o.field;
            this.fieldSplit = o.fieldSplit;
            this.ignoreMissing = o.ignoreMissing;
            this.includeKeys = _listCopy(o.includeKeys);
            this.prefix = o.prefix;
            this.stripBrackets = o.stripBrackets;
            this.targetField = o.targetField;
            this.trimKey = o.trimKey;
            this.trimValue = o.trimValue;
            this.valueSplit = o.valueSplit;
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
         * List of keys to exclude from document.
         * <p>
         * API name: {@code exclude_keys}
         * </p>
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>excludeKeys</code>.
         * </p>
         */
        @Nonnull
        public final Builder excludeKeys(List<String> list) {
            this.excludeKeys = _listAddAll(this.excludeKeys, list);
            return this;
        }

        /**
         * List of keys to exclude from document.
         * <p>
         * API name: {@code exclude_keys}
         * </p>
         *
         * <p>
         * Adds one or more values to <code>excludeKeys</code>.
         * </p>
         */
        @Nonnull
        public final Builder excludeKeys(String value, String... values) {
            this.excludeKeys = _listAdd(this.excludeKeys, value, values);
            return this;
        }

        /**
         * Required - API name: {@code field}
         */
        @Nonnull
        public final Builder field(String value) {
            this.field = value;
            return this;
        }

        /**
         * Required - Regex pattern to use for splitting key-value pairs.
         * <p>
         * API name: {@code field_split}
         * </p>
         */
        @Nonnull
        public final Builder fieldSplit(String value) {
            this.fieldSplit = value;
            return this;
        }

        /**
         * If <code>true</code> and <code>field</code> does not exist or is <code>null</code>, the processor quietly exits without modifying
         * the document.
         * <p>
         * API name: {@code ignore_missing}
         * </p>
         */
        @Nonnull
        public final Builder ignoreMissing(@Nullable Boolean value) {
            this.ignoreMissing = value;
            return this;
        }

        /**
         * List of keys to filter and insert into document. Defaults to including all keys.
         * <p>
         * API name: {@code include_keys}
         * </p>
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>includeKeys</code>.
         * </p>
         */
        @Nonnull
        public final Builder includeKeys(List<String> list) {
            this.includeKeys = _listAddAll(this.includeKeys, list);
            return this;
        }

        /**
         * List of keys to filter and insert into document. Defaults to including all keys.
         * <p>
         * API name: {@code include_keys}
         * </p>
         *
         * <p>
         * Adds one or more values to <code>includeKeys</code>.
         * </p>
         */
        @Nonnull
        public final Builder includeKeys(String value, String... values) {
            this.includeKeys = _listAdd(this.includeKeys, value, values);
            return this;
        }

        /**
         * Prefix to be added to extracted keys.
         * <p>
         * API name: {@code prefix}
         * </p>
         */
        @Nonnull
        public final Builder prefix(@Nullable String value) {
            this.prefix = value;
            return this;
        }

        /**
         * If <code>true</code>. strip brackets <code>()</code>, <code>&lt;&gt;</code>, <code>[]</code> as well as quotes <code>'</code> and
         * <code>&quot;</code> from extracted values.
         * <p>
         * API name: {@code strip_brackets}
         * </p>
         */
        @Nonnull
        public final Builder stripBrackets(@Nullable Boolean value) {
            this.stripBrackets = value;
            return this;
        }

        /**
         * API name: {@code target_field}
         */
        @Nonnull
        public final Builder targetField(@Nullable String value) {
            this.targetField = value;
            return this;
        }

        /**
         * String of characters to trim from extracted keys.
         * <p>
         * API name: {@code trim_key}
         * </p>
         */
        @Nonnull
        public final Builder trimKey(@Nullable String value) {
            this.trimKey = value;
            return this;
        }

        /**
         * String of characters to trim from extracted values.
         * <p>
         * API name: {@code trim_value}
         * </p>
         */
        @Nonnull
        public final Builder trimValue(@Nullable String value) {
            this.trimValue = value;
            return this;
        }

        /**
         * Required - Regex pattern to use for splitting the key from the value within a key-value pair.
         * <p>
         * API name: {@code value_split}
         * </p>
         */
        @Nonnull
        public final Builder valueSplit(String value) {
            this.valueSplit = value;
            return this;
        }

        /**
         * Builds a {@link KeyValueProcessor}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public KeyValueProcessor build() {
            _checkSingleUse();

            return new KeyValueProcessor(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link KeyValueProcessor}
     */
    public static final JsonpDeserializer<KeyValueProcessor> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        KeyValueProcessor::setupKeyValueProcessorDeserializer
    );

    protected static void setupKeyValueProcessorDeserializer(ObjectDeserializer<KeyValueProcessor.Builder> op) {
        setupProcessorBaseDeserializer(op);
        op.add(Builder::excludeKeys, JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()), "exclude_keys");
        op.add(Builder::field, JsonpDeserializer.stringDeserializer(), "field");
        op.add(Builder::fieldSplit, JsonpDeserializer.stringDeserializer(), "field_split");
        op.add(Builder::ignoreMissing, JsonpDeserializer.booleanDeserializer(), "ignore_missing");
        op.add(Builder::includeKeys, JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()), "include_keys");
        op.add(Builder::prefix, JsonpDeserializer.stringDeserializer(), "prefix");
        op.add(Builder::stripBrackets, JsonpDeserializer.booleanDeserializer(), "strip_brackets");
        op.add(Builder::targetField, JsonpDeserializer.stringDeserializer(), "target_field");
        op.add(Builder::trimKey, JsonpDeserializer.stringDeserializer(), "trim_key");
        op.add(Builder::trimValue, JsonpDeserializer.stringDeserializer(), "trim_value");
        op.add(Builder::valueSplit, JsonpDeserializer.stringDeserializer(), "value_split");
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Objects.hashCode(this.excludeKeys);
        result = 31 * result + this.field.hashCode();
        result = 31 * result + this.fieldSplit.hashCode();
        result = 31 * result + Objects.hashCode(this.ignoreMissing);
        result = 31 * result + Objects.hashCode(this.includeKeys);
        result = 31 * result + Objects.hashCode(this.prefix);
        result = 31 * result + Objects.hashCode(this.stripBrackets);
        result = 31 * result + Objects.hashCode(this.targetField);
        result = 31 * result + Objects.hashCode(this.trimKey);
        result = 31 * result + Objects.hashCode(this.trimValue);
        result = 31 * result + this.valueSplit.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        KeyValueProcessor other = (KeyValueProcessor) o;
        return Objects.equals(this.excludeKeys, other.excludeKeys)
            && this.field.equals(other.field)
            && this.fieldSplit.equals(other.fieldSplit)
            && Objects.equals(this.ignoreMissing, other.ignoreMissing)
            && Objects.equals(this.includeKeys, other.includeKeys)
            && Objects.equals(this.prefix, other.prefix)
            && Objects.equals(this.stripBrackets, other.stripBrackets)
            && Objects.equals(this.targetField, other.targetField)
            && Objects.equals(this.trimKey, other.trimKey)
            && Objects.equals(this.trimValue, other.trimValue)
            && this.valueSplit.equals(other.valueSplit);
    }
}
