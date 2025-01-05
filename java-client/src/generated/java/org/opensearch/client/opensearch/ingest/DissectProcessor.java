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

// typedef: ingest.DissectProcessor

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class DissectProcessor extends ProcessorBase
    implements
        ProcessorVariant,
        ToCopyableBuilder<DissectProcessor.Builder, DissectProcessor> {

    @Nullable
    private final String appendSeparator;

    @Nonnull
    private final String field;

    @Nullable
    private final Boolean ignoreMissing;

    @Nonnull
    private final String pattern;

    // ---------------------------------------------------------------------------------------------

    private DissectProcessor(Builder builder) {
        super(builder);
        this.appendSeparator = builder.appendSeparator;
        this.field = ApiTypeHelper.requireNonNull(builder.field, this, "field");
        this.ignoreMissing = builder.ignoreMissing;
        this.pattern = ApiTypeHelper.requireNonNull(builder.pattern, this, "pattern");
    }

    public static DissectProcessor of(Function<DissectProcessor.Builder, ObjectBuilder<DissectProcessor>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * {@link Processor} variant kind.
     */
    @Override
    public Processor.Kind _processorKind() {
        return Processor.Kind.Dissect;
    }

    /**
     * The character(s) that separate the appended fields.
     * <p>
     * API name: {@code append_separator}
     * </p>
     */
    @Nullable
    public final String appendSeparator() {
        return this.appendSeparator;
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
     * Required - The pattern to apply to the field.
     * <p>
     * API name: {@code pattern}
     * </p>
     */
    @Nonnull
    public final String pattern() {
        return this.pattern;
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        super.serializeInternal(generator, mapper);
        if (this.appendSeparator != null) {
            generator.writeKey("append_separator");
            generator.write(this.appendSeparator);
        }

        generator.writeKey("field");
        generator.write(this.field);

        if (this.ignoreMissing != null) {
            generator.writeKey("ignore_missing");
            generator.write(this.ignoreMissing);
        }

        generator.writeKey("pattern");
        generator.write(this.pattern);
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
     * Builder for {@link DissectProcessor}.
     */
    public static class Builder extends ProcessorBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, DissectProcessor> {
        @Nullable
        private String appendSeparator;
        private String field;
        @Nullable
        private Boolean ignoreMissing;
        private String pattern;

        public Builder() {}

        private Builder(DissectProcessor o) {
            super(o);
            this.appendSeparator = o.appendSeparator;
            this.field = o.field;
            this.ignoreMissing = o.ignoreMissing;
            this.pattern = o.pattern;
        }

        private Builder(Builder o) {
            super(o);
            this.appendSeparator = o.appendSeparator;
            this.field = o.field;
            this.ignoreMissing = o.ignoreMissing;
            this.pattern = o.pattern;
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
         * The character(s) that separate the appended fields.
         * <p>
         * API name: {@code append_separator}
         * </p>
         */
        @Nonnull
        public final Builder appendSeparator(@Nullable String value) {
            this.appendSeparator = value;
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
         * Required - The pattern to apply to the field.
         * <p>
         * API name: {@code pattern}
         * </p>
         */
        @Nonnull
        public final Builder pattern(String value) {
            this.pattern = value;
            return this;
        }

        /**
         * Builds a {@link DissectProcessor}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public DissectProcessor build() {
            _checkSingleUse();

            return new DissectProcessor(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link DissectProcessor}
     */
    public static final JsonpDeserializer<DissectProcessor> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        DissectProcessor::setupDissectProcessorDeserializer
    );

    protected static void setupDissectProcessorDeserializer(ObjectDeserializer<DissectProcessor.Builder> op) {
        setupProcessorBaseDeserializer(op);
        op.add(Builder::appendSeparator, JsonpDeserializer.stringDeserializer(), "append_separator");
        op.add(Builder::field, JsonpDeserializer.stringDeserializer(), "field");
        op.add(Builder::ignoreMissing, JsonpDeserializer.booleanDeserializer(), "ignore_missing");
        op.add(Builder::pattern, JsonpDeserializer.stringDeserializer(), "pattern");
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Objects.hashCode(this.appendSeparator);
        result = 31 * result + this.field.hashCode();
        result = 31 * result + Objects.hashCode(this.ignoreMissing);
        result = 31 * result + this.pattern.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        DissectProcessor other = (DissectProcessor) o;
        return Objects.equals(this.appendSeparator, other.appendSeparator)
            && this.field.equals(other.field)
            && Objects.equals(this.ignoreMissing, other.ignoreMissing)
            && this.pattern.equals(other.pattern);
    }
}
