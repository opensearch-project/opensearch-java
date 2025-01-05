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
import org.opensearch.client.opensearch._types.SortOrder;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: ingest.SortProcessor

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class SortProcessor extends ProcessorBase implements ProcessorVariant, ToCopyableBuilder<SortProcessor.Builder, SortProcessor> {

    @Nonnull
    private final String field;

    @Nullable
    private final SortOrder order;

    @Nullable
    private final String targetField;

    // ---------------------------------------------------------------------------------------------

    private SortProcessor(Builder builder) {
        super(builder);
        this.field = ApiTypeHelper.requireNonNull(builder.field, this, "field");
        this.order = builder.order;
        this.targetField = builder.targetField;
    }

    public static SortProcessor of(Function<SortProcessor.Builder, ObjectBuilder<SortProcessor>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * {@link Processor} variant kind.
     */
    @Override
    public Processor.Kind _processorKind() {
        return Processor.Kind.Sort;
    }

    /**
     * Required - API name: {@code field}
     */
    @Nonnull
    public final String field() {
        return this.field;
    }

    /**
     * API name: {@code order}
     */
    @Nullable
    public final SortOrder order() {
        return this.order;
    }

    /**
     * API name: {@code target_field}
     */
    @Nullable
    public final String targetField() {
        return this.targetField;
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        super.serializeInternal(generator, mapper);
        generator.writeKey("field");
        generator.write(this.field);

        if (this.order != null) {
            generator.writeKey("order");
            this.order.serialize(generator, mapper);
        }

        if (this.targetField != null) {
            generator.writeKey("target_field");
            generator.write(this.targetField);
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
     * Builder for {@link SortProcessor}.
     */
    public static class Builder extends ProcessorBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, SortProcessor> {
        private String field;
        @Nullable
        private SortOrder order;
        @Nullable
        private String targetField;

        public Builder() {}

        private Builder(SortProcessor o) {
            super(o);
            this.field = o.field;
            this.order = o.order;
            this.targetField = o.targetField;
        }

        private Builder(Builder o) {
            super(o);
            this.field = o.field;
            this.order = o.order;
            this.targetField = o.targetField;
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
         * API name: {@code order}
         */
        @Nonnull
        public final Builder order(@Nullable SortOrder value) {
            this.order = value;
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
         * Builds a {@link SortProcessor}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public SortProcessor build() {
            _checkSingleUse();

            return new SortProcessor(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link SortProcessor}
     */
    public static final JsonpDeserializer<SortProcessor> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        SortProcessor::setupSortProcessorDeserializer
    );

    protected static void setupSortProcessorDeserializer(ObjectDeserializer<SortProcessor.Builder> op) {
        setupProcessorBaseDeserializer(op);
        op.add(Builder::field, JsonpDeserializer.stringDeserializer(), "field");
        op.add(Builder::order, SortOrder._DESERIALIZER, "order");
        op.add(Builder::targetField, JsonpDeserializer.stringDeserializer(), "target_field");
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + this.field.hashCode();
        result = 31 * result + Objects.hashCode(this.order);
        result = 31 * result + Objects.hashCode(this.targetField);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        SortProcessor other = (SortProcessor) o;
        return this.field.equals(other.field)
            && Objects.equals(this.order, other.order)
            && Objects.equals(this.targetField, other.targetField);
    }
}
