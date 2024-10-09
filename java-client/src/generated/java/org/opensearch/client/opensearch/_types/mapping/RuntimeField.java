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

package org.opensearch.client.opensearch._types.mapping;

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
import org.opensearch.client.json.PlainJsonSerializable;
import org.opensearch.client.opensearch._types.Script;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;

// typedef: _types.mapping.RuntimeField

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class RuntimeField implements PlainJsonSerializable {

    @Nonnull
    private final List<RuntimeFieldFetchFields> fetchFields;

    @Nullable
    private final String format;

    @Nullable
    private final String inputField;

    @Nullable
    private final Script script;

    @Nullable
    private final String targetField;

    @Nullable
    private final String targetIndex;

    @Nonnull
    private final RuntimeFieldType type;

    // ---------------------------------------------------------------------------------------------

    private RuntimeField(Builder builder) {
        this.fetchFields = ApiTypeHelper.unmodifiable(builder.fetchFields);
        this.format = builder.format;
        this.inputField = builder.inputField;
        this.script = builder.script;
        this.targetField = builder.targetField;
        this.targetIndex = builder.targetIndex;
        this.type = ApiTypeHelper.requireNonNull(builder.type, this, "type");
    }

    public static RuntimeField of(Function<RuntimeField.Builder, ObjectBuilder<RuntimeField>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * For type <code>lookup</code>
     * <p>
     * API name: {@code fetch_fields}
     * </p>
     */
    @Nonnull
    public final List<RuntimeFieldFetchFields> fetchFields() {
        return this.fetchFields;
    }

    /**
     * A custom format for <code>date</code> type runtime fields.
     * <p>
     * API name: {@code format}
     * </p>
     */
    @Nullable
    public final String format() {
        return this.format;
    }

    /**
     * API name: {@code input_field}
     */
    @Nullable
    public final String inputField() {
        return this.inputField;
    }

    /**
     * API name: {@code script}
     */
    @Nullable
    public final Script script() {
        return this.script;
    }

    /**
     * API name: {@code target_field}
     */
    @Nullable
    public final String targetField() {
        return this.targetField;
    }

    /**
     * API name: {@code target_index}
     */
    @Nullable
    public final String targetIndex() {
        return this.targetIndex;
    }

    /**
     * Required - API name: {@code type}
     */
    @Nonnull
    public final RuntimeFieldType type() {
        return this.type;
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
        if (ApiTypeHelper.isDefined(this.fetchFields)) {
            generator.writeKey("fetch_fields");
            generator.writeStartArray();
            for (RuntimeFieldFetchFields item0 : this.fetchFields) {
                item0.serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        if (this.format != null) {
            generator.writeKey("format");
            generator.write(this.format);
        }

        if (this.inputField != null) {
            generator.writeKey("input_field");
            generator.write(this.inputField);
        }

        if (this.script != null) {
            generator.writeKey("script");
            this.script.serialize(generator, mapper);
        }

        if (this.targetField != null) {
            generator.writeKey("target_field");
            generator.write(this.targetField);
        }

        if (this.targetIndex != null) {
            generator.writeKey("target_index");
            generator.write(this.targetIndex);
        }

        generator.writeKey("type");
        this.type.serialize(generator, mapper);
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Builder for {@link RuntimeField}.
     */
    public static class Builder extends ObjectBuilderBase implements ObjectBuilder<RuntimeField> {
        @Nullable
        private List<RuntimeFieldFetchFields> fetchFields;
        @Nullable
        private String format;
        @Nullable
        private String inputField;
        @Nullable
        private Script script;
        @Nullable
        private String targetField;
        @Nullable
        private String targetIndex;
        private RuntimeFieldType type;

        /**
         * For type <code>lookup</code>
         * <p>
         * API name: {@code fetch_fields}
         * </p>
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>fetchFields</code>.
         * </p>
         */
        public final Builder fetchFields(List<RuntimeFieldFetchFields> list) {
            this.fetchFields = _listAddAll(this.fetchFields, list);
            return this;
        }

        /**
         * For type <code>lookup</code>
         * <p>
         * API name: {@code fetch_fields}
         * </p>
         *
         * <p>
         * Adds one or more values to <code>fetchFields</code>.
         * </p>
         */
        public final Builder fetchFields(RuntimeFieldFetchFields value, RuntimeFieldFetchFields... values) {
            this.fetchFields = _listAdd(this.fetchFields, value, values);
            return this;
        }

        /**
         * For type <code>lookup</code>
         * <p>
         * API name: {@code fetch_fields}
         * </p>
         *
         * <p>
         * Adds a value to <code>fetchFields</code> using a builder lambda.
         * </p>
         */
        public final Builder fetchFields(Function<RuntimeFieldFetchFields.Builder, ObjectBuilder<RuntimeFieldFetchFields>> fn) {
            return fetchFields(fn.apply(new RuntimeFieldFetchFields.Builder()).build());
        }

        /**
         * A custom format for <code>date</code> type runtime fields.
         * <p>
         * API name: {@code format}
         * </p>
         */
        public final Builder format(@Nullable String value) {
            this.format = value;
            return this;
        }

        /**
         * API name: {@code input_field}
         */
        public final Builder inputField(@Nullable String value) {
            this.inputField = value;
            return this;
        }

        /**
         * API name: {@code script}
         */
        public final Builder script(@Nullable Script value) {
            this.script = value;
            return this;
        }

        /**
         * API name: {@code script}
         */
        public final Builder script(Function<Script.Builder, ObjectBuilder<Script>> fn) {
            return script(fn.apply(new Script.Builder()).build());
        }

        /**
         * API name: {@code target_field}
         */
        public final Builder targetField(@Nullable String value) {
            this.targetField = value;
            return this;
        }

        /**
         * API name: {@code target_index}
         */
        public final Builder targetIndex(@Nullable String value) {
            this.targetIndex = value;
            return this;
        }

        /**
         * Required - API name: {@code type}
         */
        public final Builder type(RuntimeFieldType value) {
            this.type = value;
            return this;
        }

        /**
         * Builds a {@link RuntimeField}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        public RuntimeField build() {
            _checkSingleUse();

            return new RuntimeField(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link RuntimeField}
     */
    public static final JsonpDeserializer<RuntimeField> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        RuntimeField::setupRuntimeFieldDeserializer
    );

    protected static void setupRuntimeFieldDeserializer(ObjectDeserializer<RuntimeField.Builder> op) {
        op.add(Builder::fetchFields, JsonpDeserializer.arrayDeserializer(RuntimeFieldFetchFields._DESERIALIZER), "fetch_fields");
        op.add(Builder::format, JsonpDeserializer.stringDeserializer(), "format");
        op.add(Builder::inputField, JsonpDeserializer.stringDeserializer(), "input_field");
        op.add(Builder::script, Script._DESERIALIZER, "script");
        op.add(Builder::targetField, JsonpDeserializer.stringDeserializer(), "target_field");
        op.add(Builder::targetIndex, JsonpDeserializer.stringDeserializer(), "target_index");
        op.add(Builder::type, RuntimeFieldType._DESERIALIZER, "type");
    }

    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.fetchFields);
        result = 31 * result + Objects.hashCode(this.format);
        result = 31 * result + Objects.hashCode(this.inputField);
        result = 31 * result + Objects.hashCode(this.script);
        result = 31 * result + Objects.hashCode(this.targetField);
        result = 31 * result + Objects.hashCode(this.targetIndex);
        result = 31 * result + this.type.hashCode();
        return result;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        RuntimeField other = (RuntimeField) o;
        return Objects.equals(this.fetchFields, other.fetchFields)
            && Objects.equals(this.format, other.format)
            && Objects.equals(this.inputField, other.inputField)
            && Objects.equals(this.script, other.script)
            && Objects.equals(this.targetField, other.targetField)
            && Objects.equals(this.targetIndex, other.targetIndex)
            && this.type.equals(other.type);
    }
}
