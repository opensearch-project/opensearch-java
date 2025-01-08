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
import org.opensearch.client.json.JsonpDeserializable;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.ObjectBuilderDeserializer;
import org.opensearch.client.json.ObjectDeserializer;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: ingest.ConvertProcessor

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class ConvertProcessor extends ProcessorBase
    implements
        ProcessorVariant,
        ToCopyableBuilder<ConvertProcessor.Builder, ConvertProcessor> {

    @Nonnull
    private final String field;

    @Nullable
    private final Boolean ignoreMissing;

    @Nullable
    private final String targetField;

    @Nonnull
    private final ConvertType type;

    // ---------------------------------------------------------------------------------------------

    private ConvertProcessor(Builder builder) {
        super(builder);
        this.field = ApiTypeHelper.requireNonNull(builder.field, this, "field");
        this.ignoreMissing = builder.ignoreMissing;
        this.targetField = builder.targetField;
        this.type = ApiTypeHelper.requireNonNull(builder.type, this, "type");
    }

    public static ConvertProcessor of(Function<ConvertProcessor.Builder, ObjectBuilder<ConvertProcessor>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * {@link Processor} variant kind.
     */
    @Override
    public Processor.Kind _processorKind() {
        return Processor.Kind.Convert;
    }

    /**
     * Required - API name: {@code field}
     */
    @Nonnull
    public final String field() {
        return this.field;
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
     * API name: {@code target_field}
     */
    @Nullable
    public final String targetField() {
        return this.targetField;
    }

    /**
     * Required - API name: {@code type}
     */
    @Nonnull
    public final ConvertType type() {
        return this.type;
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        super.serializeInternal(generator, mapper);
        generator.writeKey("field");
        generator.write(this.field);

        if (this.ignoreMissing != null) {
            generator.writeKey("ignore_missing");
            generator.write(this.ignoreMissing);
        }

        if (this.targetField != null) {
            generator.writeKey("target_field");
            generator.write(this.targetField);
        }

        generator.writeKey("type");
        this.type.serialize(generator, mapper);
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
     * Builder for {@link ConvertProcessor}.
     */
    public static class Builder extends ProcessorBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, ConvertProcessor> {
        private String field;
        @Nullable
        private Boolean ignoreMissing;
        @Nullable
        private String targetField;
        private ConvertType type;

        public Builder() {}

        private Builder(ConvertProcessor o) {
            super(o);
            this.field = o.field;
            this.ignoreMissing = o.ignoreMissing;
            this.targetField = o.targetField;
            this.type = o.type;
        }

        private Builder(Builder o) {
            super(o);
            this.field = o.field;
            this.ignoreMissing = o.ignoreMissing;
            this.targetField = o.targetField;
            this.type = o.type;
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
         * Required - API name: {@code field}
         */
        @Nonnull
        public final Builder field(String value) {
            this.field = value;
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
         * API name: {@code target_field}
         */
        @Nonnull
        public final Builder targetField(@Nullable String value) {
            this.targetField = value;
            return this;
        }

        /**
         * Required - API name: {@code type}
         */
        @Nonnull
        public final Builder type(ConvertType value) {
            this.type = value;
            return this;
        }

        /**
         * Builds a {@link ConvertProcessor}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public ConvertProcessor build() {
            _checkSingleUse();

            return new ConvertProcessor(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link ConvertProcessor}
     */
    public static final JsonpDeserializer<ConvertProcessor> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        ConvertProcessor::setupConvertProcessorDeserializer
    );

    protected static void setupConvertProcessorDeserializer(ObjectDeserializer<ConvertProcessor.Builder> op) {
        setupProcessorBaseDeserializer(op);
        op.add(Builder::field, JsonpDeserializer.stringDeserializer(), "field");
        op.add(Builder::ignoreMissing, JsonpDeserializer.booleanDeserializer(), "ignore_missing");
        op.add(Builder::targetField, JsonpDeserializer.stringDeserializer(), "target_field");
        op.add(Builder::type, ConvertType._DESERIALIZER, "type");
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + this.field.hashCode();
        result = 31 * result + Objects.hashCode(this.ignoreMissing);
        result = 31 * result + Objects.hashCode(this.targetField);
        result = 31 * result + this.type.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        ConvertProcessor other = (ConvertProcessor) o;
        return this.field.equals(other.field)
            && Objects.equals(this.ignoreMissing, other.ignoreMissing)
            && Objects.equals(this.targetField, other.targetField)
            && this.type.equals(other.type);
    }
}