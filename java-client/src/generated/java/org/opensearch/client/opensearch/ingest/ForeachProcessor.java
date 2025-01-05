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

// typedef: ingest.ForeachProcessor

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class ForeachProcessor extends ProcessorBase
    implements
        ProcessorVariant,
        ToCopyableBuilder<ForeachProcessor.Builder, ForeachProcessor> {

    @Nonnull
    private final String field;

    @Nullable
    private final Boolean ignoreMissing;

    @Nonnull
    private final Processor processor;

    // ---------------------------------------------------------------------------------------------

    private ForeachProcessor(Builder builder) {
        super(builder);
        this.field = ApiTypeHelper.requireNonNull(builder.field, this, "field");
        this.ignoreMissing = builder.ignoreMissing;
        this.processor = ApiTypeHelper.requireNonNull(builder.processor, this, "processor");
    }

    public static ForeachProcessor of(Function<ForeachProcessor.Builder, ObjectBuilder<ForeachProcessor>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * {@link Processor} variant kind.
     */
    @Override
    public Processor.Kind _processorKind() {
        return Processor.Kind.Foreach;
    }

    /**
     * Required - API name: {@code field}
     */
    @Nonnull
    public final String field() {
        return this.field;
    }

    /**
     * If <code>true</code>, the processor silently exits without changing the document if the <code>field</code> is <code>null</code> or
     * missing.
     * <p>
     * API name: {@code ignore_missing}
     * </p>
     */
    @Nullable
    public final Boolean ignoreMissing() {
        return this.ignoreMissing;
    }

    /**
     * Required - API name: {@code processor}
     */
    @Nonnull
    public final Processor processor() {
        return this.processor;
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        super.serializeInternal(generator, mapper);
        generator.writeKey("field");
        generator.write(this.field);

        if (this.ignoreMissing != null) {
            generator.writeKey("ignore_missing");
            generator.write(this.ignoreMissing);
        }

        generator.writeKey("processor");
        this.processor.serialize(generator, mapper);
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
     * Builder for {@link ForeachProcessor}.
     */
    public static class Builder extends ProcessorBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, ForeachProcessor> {
        private String field;
        @Nullable
        private Boolean ignoreMissing;
        private Processor processor;

        public Builder() {}

        private Builder(ForeachProcessor o) {
            super(o);
            this.field = o.field;
            this.ignoreMissing = o.ignoreMissing;
            this.processor = o.processor;
        }

        private Builder(Builder o) {
            super(o);
            this.field = o.field;
            this.ignoreMissing = o.ignoreMissing;
            this.processor = o.processor;
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
         * If <code>true</code>, the processor silently exits without changing the document if the <code>field</code> is <code>null</code>
         * or missing.
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
         * Required - API name: {@code processor}
         */
        @Nonnull
        public final Builder processor(Processor value) {
            this.processor = value;
            return this;
        }

        /**
         * Required - API name: {@code processor}
         */
        @Nonnull
        public final Builder processor(Function<Processor.Builder, ObjectBuilder<Processor>> fn) {
            return processor(fn.apply(new Processor.Builder()).build());
        }

        /**
         * Builds a {@link ForeachProcessor}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public ForeachProcessor build() {
            _checkSingleUse();

            return new ForeachProcessor(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link ForeachProcessor}
     */
    public static final JsonpDeserializer<ForeachProcessor> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        ForeachProcessor::setupForeachProcessorDeserializer
    );

    protected static void setupForeachProcessorDeserializer(ObjectDeserializer<ForeachProcessor.Builder> op) {
        setupProcessorBaseDeserializer(op);
        op.add(Builder::field, JsonpDeserializer.stringDeserializer(), "field");
        op.add(Builder::ignoreMissing, JsonpDeserializer.booleanDeserializer(), "ignore_missing");
        op.add(Builder::processor, Processor._DESERIALIZER, "processor");
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + this.field.hashCode();
        result = 31 * result + Objects.hashCode(this.ignoreMissing);
        result = 31 * result + this.processor.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        ForeachProcessor other = (ForeachProcessor) o;
        return this.field.equals(other.field)
            && Objects.equals(this.ignoreMissing, other.ignoreMissing)
            && this.processor.equals(other.processor);
    }
}
