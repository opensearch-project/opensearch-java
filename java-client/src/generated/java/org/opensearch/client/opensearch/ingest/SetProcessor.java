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
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: ingest.SetProcessor

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class SetProcessor extends ProcessorBase implements ProcessorVariant, ToCopyableBuilder<SetProcessor.Builder, SetProcessor> {

    @Nullable
    private final String copyFrom;

    @Nonnull
    private final String field;

    @Nullable
    private final Boolean ignoreEmptyValue;

    @Nullable
    private final String mediaType;

    @Nullable
    private final Boolean override;

    @Nullable
    private final JsonData value;

    // ---------------------------------------------------------------------------------------------

    private SetProcessor(Builder builder) {
        super(builder);
        this.copyFrom = builder.copyFrom;
        this.field = ApiTypeHelper.requireNonNull(builder.field, this, "field");
        this.ignoreEmptyValue = builder.ignoreEmptyValue;
        this.mediaType = builder.mediaType;
        this.override = builder.override;
        this.value = builder.value;
    }

    public static SetProcessor of(Function<SetProcessor.Builder, ObjectBuilder<SetProcessor>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * {@link Processor} variant kind.
     */
    @Override
    public Processor.Kind _processorKind() {
        return Processor.Kind.Set;
    }

    /**
     * API name: {@code copy_from}
     */
    @Nullable
    public final String copyFrom() {
        return this.copyFrom;
    }

    /**
     * Required - API name: {@code field}
     */
    @Nonnull
    public final String field() {
        return this.field;
    }

    /**
     * If <code>true</code> and <code>value</code> is a template snippet that evaluates to <code>null</code> or the empty string, the
     * processor quietly exits without modifying the document.
     * <p>
     * API name: {@code ignore_empty_value}
     * </p>
     */
    @Nullable
    public final Boolean ignoreEmptyValue() {
        return this.ignoreEmptyValue;
    }

    /**
     * The media type for encoding <code>value</code>. Applies only when value is a template snippet. Must be one of
     * <code>application/json</code>, <code>text/plain</code>, or <code>application/x-www-form-urlencoded</code>.
     * <p>
     * API name: {@code media_type}
     * </p>
     */
    @Nullable
    public final String mediaType() {
        return this.mediaType;
    }

    /**
     * If <code>true</code> processor will update fields with pre-existing non-null-valued field. When set to <code>false</code>, such
     * fields will not be touched.
     * <p>
     * API name: {@code override}
     * </p>
     */
    @Nullable
    public final Boolean override() {
        return this.override;
    }

    /**
     * The value to be set for the field. Supports template snippets. May specify only one of <code>value</code> or <code>copy_from</code>.
     * <p>
     * API name: {@code value}
     * </p>
     */
    @Nullable
    public final JsonData value() {
        return this.value;
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        super.serializeInternal(generator, mapper);
        if (this.copyFrom != null) {
            generator.writeKey("copy_from");
            generator.write(this.copyFrom);
        }

        generator.writeKey("field");
        generator.write(this.field);

        if (this.ignoreEmptyValue != null) {
            generator.writeKey("ignore_empty_value");
            generator.write(this.ignoreEmptyValue);
        }

        if (this.mediaType != null) {
            generator.writeKey("media_type");
            generator.write(this.mediaType);
        }

        if (this.override != null) {
            generator.writeKey("override");
            generator.write(this.override);
        }

        if (this.value != null) {
            generator.writeKey("value");
            this.value.serialize(generator, mapper);
        }
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
     * Builder for {@link SetProcessor}.
     */
    public static class Builder extends ProcessorBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, SetProcessor> {
        @Nullable
        private String copyFrom;
        private String field;
        @Nullable
        private Boolean ignoreEmptyValue;
        @Nullable
        private String mediaType;
        @Nullable
        private Boolean override;
        @Nullable
        private JsonData value;

        public Builder() {}

        private Builder(SetProcessor o) {
            super(o);
            this.copyFrom = o.copyFrom;
            this.field = o.field;
            this.ignoreEmptyValue = o.ignoreEmptyValue;
            this.mediaType = o.mediaType;
            this.override = o.override;
            this.value = o.value;
        }

        private Builder(Builder o) {
            super(o);
            this.copyFrom = o.copyFrom;
            this.field = o.field;
            this.ignoreEmptyValue = o.ignoreEmptyValue;
            this.mediaType = o.mediaType;
            this.override = o.override;
            this.value = o.value;
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
         * API name: {@code copy_from}
         */
        @Nonnull
        public final Builder copyFrom(@Nullable String value) {
            this.copyFrom = value;
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
         * If <code>true</code> and <code>value</code> is a template snippet that evaluates to <code>null</code> or the empty string, the
         * processor quietly exits without modifying the document.
         * <p>
         * API name: {@code ignore_empty_value}
         * </p>
         */
        @Nonnull
        public final Builder ignoreEmptyValue(@Nullable Boolean value) {
            this.ignoreEmptyValue = value;
            return this;
        }

        /**
         * The media type for encoding <code>value</code>. Applies only when value is a template snippet. Must be one of
         * <code>application/json</code>, <code>text/plain</code>, or <code>application/x-www-form-urlencoded</code>.
         * <p>
         * API name: {@code media_type}
         * </p>
         */
        @Nonnull
        public final Builder mediaType(@Nullable String value) {
            this.mediaType = value;
            return this;
        }

        /**
         * If <code>true</code> processor will update fields with pre-existing non-null-valued field. When set to <code>false</code>, such
         * fields will not be touched.
         * <p>
         * API name: {@code override}
         * </p>
         */
        @Nonnull
        public final Builder override(@Nullable Boolean value) {
            this.override = value;
            return this;
        }

        /**
         * The value to be set for the field. Supports template snippets. May specify only one of <code>value</code> or
         * <code>copy_from</code>.
         * <p>
         * API name: {@code value}
         * </p>
         */
        @Nonnull
        public final Builder value(@Nullable JsonData value) {
            this.value = value;
            return this;
        }

        /**
         * Builds a {@link SetProcessor}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public SetProcessor build() {
            _checkSingleUse();

            return new SetProcessor(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link SetProcessor}
     */
    public static final JsonpDeserializer<SetProcessor> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        SetProcessor::setupSetProcessorDeserializer
    );

    protected static void setupSetProcessorDeserializer(ObjectDeserializer<SetProcessor.Builder> op) {
        setupProcessorBaseDeserializer(op);
        op.add(Builder::copyFrom, JsonpDeserializer.stringDeserializer(), "copy_from");
        op.add(Builder::field, JsonpDeserializer.stringDeserializer(), "field");
        op.add(Builder::ignoreEmptyValue, JsonpDeserializer.booleanDeserializer(), "ignore_empty_value");
        op.add(Builder::mediaType, JsonpDeserializer.stringDeserializer(), "media_type");
        op.add(Builder::override, JsonpDeserializer.booleanDeserializer(), "override");
        op.add(Builder::value, JsonData._DESERIALIZER, "value");
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Objects.hashCode(this.copyFrom);
        result = 31 * result + this.field.hashCode();
        result = 31 * result + Objects.hashCode(this.ignoreEmptyValue);
        result = 31 * result + Objects.hashCode(this.mediaType);
        result = 31 * result + Objects.hashCode(this.override);
        result = 31 * result + Objects.hashCode(this.value);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        SetProcessor other = (SetProcessor) o;
        return Objects.equals(this.copyFrom, other.copyFrom)
            && this.field.equals(other.field)
            && Objects.equals(this.ignoreEmptyValue, other.ignoreEmptyValue)
            && Objects.equals(this.mediaType, other.mediaType)
            && Objects.equals(this.override, other.override)
            && Objects.equals(this.value, other.value);
    }
}
