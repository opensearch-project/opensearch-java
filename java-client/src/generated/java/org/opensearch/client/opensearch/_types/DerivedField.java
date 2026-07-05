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
import org.opensearch.client.json.JsonData;
import org.opensearch.client.json.JsonpDeserializable;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.ObjectBuilderDeserializer;
import org.opensearch.client.json.ObjectDeserializer;
import org.opensearch.client.json.PlainJsonSerializable;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: _types.DerivedField

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class DerivedField implements PlainJsonSerializable, ToCopyableBuilder<DerivedField.Builder, DerivedField> {

    @Nullable
    private final String format;

    @Nullable
    private final Boolean ignoreMalformed;

    @Nonnull
    private final String name;

    @Nullable
    private final String prefilterField;

    @Nonnull
    private final Map<String, JsonData> properties;

    @Nonnull
    private final Script script;

    @Nonnull
    private final String type;

    // ---------------------------------------------------------------------------------------------

    private DerivedField(Builder builder) {
        this.format = builder.format;
        this.ignoreMalformed = builder.ignoreMalformed;
        this.name = ApiTypeHelper.requireNonNull(builder.name, this, "name");
        this.prefilterField = builder.prefilterField;
        this.properties = ApiTypeHelper.unmodifiable(builder.properties);
        this.script = ApiTypeHelper.requireNonNull(builder.script, this, "script");
        this.type = ApiTypeHelper.requireNonNull(builder.type, this, "type");
    }

    public static DerivedField of(Function<DerivedField.Builder, ObjectBuilder<DerivedField>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code format}
     */
    @Nullable
    public final String format() {
        return this.format;
    }

    /**
     * API name: {@code ignore_malformed}
     */
    @Nullable
    public final Boolean ignoreMalformed() {
        return this.ignoreMalformed;
    }

    /**
     * Required - API name: {@code name}
     */
    @Nonnull
    public final String name() {
        return this.name;
    }

    /**
     * API name: {@code prefilter_field}
     */
    @Nullable
    public final String prefilterField() {
        return this.prefilterField;
    }

    /**
     * API name: {@code properties}
     */
    @Nonnull
    public final Map<String, JsonData> properties() {
        return this.properties;
    }

    /**
     * Required - API name: {@code script}
     */
    @Nonnull
    public final Script script() {
        return this.script;
    }

    /**
     * Required - API name: {@code type}
     */
    @Nonnull
    public final String type() {
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
        if (this.format != null) {
            generator.writeKey("format");
            generator.write(this.format);
        }

        if (this.ignoreMalformed != null) {
            generator.writeKey("ignore_malformed");
            generator.write(this.ignoreMalformed);
        }

        generator.writeKey("name");
        generator.write(this.name);

        if (this.prefilterField != null) {
            generator.writeKey("prefilter_field");
            generator.write(this.prefilterField);
        }

        if (ApiTypeHelper.isDefined(this.properties)) {
            generator.writeKey("properties");
            generator.writeStartObject();
            for (Map.Entry<String, JsonData> item0 : this.properties.entrySet()) {
                generator.writeKey(item0.getKey());
                item0.getValue().serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        generator.writeKey("script");
        this.script.serialize(generator, mapper);

        generator.writeKey("type");
        generator.write(this.type);
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
     * Builder for {@link DerivedField}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, DerivedField> {
        @Nullable
        private String format;
        @Nullable
        private Boolean ignoreMalformed;
        private String name;
        @Nullable
        private String prefilterField;
        @Nullable
        private Map<String, JsonData> properties;
        private Script script;
        private String type;

        public Builder() {}

        private Builder(DerivedField o) {
            this.format = o.format;
            this.ignoreMalformed = o.ignoreMalformed;
            this.name = o.name;
            this.prefilterField = o.prefilterField;
            this.properties = _mapCopy(o.properties);
            this.script = o.script;
            this.type = o.type;
        }

        private Builder(Builder o) {
            this.format = o.format;
            this.ignoreMalformed = o.ignoreMalformed;
            this.name = o.name;
            this.prefilterField = o.prefilterField;
            this.properties = _mapCopy(o.properties);
            this.script = o.script;
            this.type = o.type;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code format}
         */
        @Nonnull
        public final Builder format(@Nullable String value) {
            this.format = value;
            return this;
        }

        /**
         * API name: {@code ignore_malformed}
         */
        @Nonnull
        public final Builder ignoreMalformed(@Nullable Boolean value) {
            this.ignoreMalformed = value;
            return this;
        }

        /**
         * Required - API name: {@code name}
         */
        @Nonnull
        public final Builder name(String value) {
            this.name = value;
            return this;
        }

        /**
         * API name: {@code prefilter_field}
         */
        @Nonnull
        public final Builder prefilterField(@Nullable String value) {
            this.prefilterField = value;
            return this;
        }

        /**
         * API name: {@code properties}
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>properties</code>.
         * </p>
         */
        @Nonnull
        public final Builder properties(Map<String, JsonData> map) {
            this.properties = _mapPutAll(this.properties, map);
            return this;
        }

        /**
         * API name: {@code properties}
         *
         * <p>
         * Adds an entry to <code>properties</code>.
         * </p>
         */
        @Nonnull
        public final Builder properties(String key, JsonData value) {
            this.properties = _mapPut(this.properties, key, value);
            return this;
        }

        /**
         * Required - API name: {@code script}
         */
        @Nonnull
        public final Builder script(Script value) {
            this.script = value;
            return this;
        }

        /**
         * Required - API name: {@code script}
         */
        @Nonnull
        public final Builder script(Function<Script.Builder, ObjectBuilder<Script>> fn) {
            return script(fn.apply(new Script.Builder()).build());
        }

        /**
         * Required - API name: {@code type}
         */
        @Nonnull
        public final Builder type(String value) {
            this.type = value;
            return this;
        }

        /**
         * Builds a {@link DerivedField}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public DerivedField build() {
            _checkSingleUse();

            return new DerivedField(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link DerivedField}
     */
    public static final JsonpDeserializer<DerivedField> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        DerivedField::setupDerivedFieldDeserializer
    );

    protected static void setupDerivedFieldDeserializer(ObjectDeserializer<DerivedField.Builder> op) {
        op.add(Builder::format, JsonpDeserializer.stringDeserializer(), "format");
        op.add(Builder::ignoreMalformed, JsonpDeserializer.booleanDeserializer(), "ignore_malformed");
        op.add(Builder::name, JsonpDeserializer.stringDeserializer(), "name");
        op.add(Builder::prefilterField, JsonpDeserializer.stringDeserializer(), "prefilter_field");
        op.add(Builder::properties, JsonpDeserializer.stringMapDeserializer(JsonData._DESERIALIZER), "properties");
        op.add(Builder::script, Script._DESERIALIZER, "script");
        op.add(Builder::type, JsonpDeserializer.stringDeserializer(), "type");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.format);
        result = 31 * result + Objects.hashCode(this.ignoreMalformed);
        result = 31 * result + this.name.hashCode();
        result = 31 * result + Objects.hashCode(this.prefilterField);
        result = 31 * result + Objects.hashCode(this.properties);
        result = 31 * result + this.script.hashCode();
        result = 31 * result + this.type.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        DerivedField other = (DerivedField) o;
        return Objects.equals(this.format, other.format)
            && Objects.equals(this.ignoreMalformed, other.ignoreMalformed)
            && this.name.equals(other.name)
            && Objects.equals(this.prefilterField, other.prefilterField)
            && Objects.equals(this.properties, other.properties)
            && this.script.equals(other.script)
            && this.type.equals(other.type);
    }
}
