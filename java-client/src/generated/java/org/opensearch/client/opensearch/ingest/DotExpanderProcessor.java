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

// typedef: ingest.DotExpanderProcessor

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class DotExpanderProcessor extends ProcessorBase
    implements
        ProcessorVariant,
        ToCopyableBuilder<DotExpanderProcessor.Builder, DotExpanderProcessor> {

    @Nonnull
    private final String field;

    @Nullable
    private final String path;

    // ---------------------------------------------------------------------------------------------

    private DotExpanderProcessor(Builder builder) {
        super(builder);
        this.field = ApiTypeHelper.requireNonNull(builder.field, this, "field");
        this.path = builder.path;
    }

    public static DotExpanderProcessor of(Function<DotExpanderProcessor.Builder, ObjectBuilder<DotExpanderProcessor>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * {@link Processor} variant kind.
     */
    @Override
    public Processor.Kind _processorKind() {
        return Processor.Kind.DotExpander;
    }

    /**
     * Required - API name: {@code field}
     */
    @Nonnull
    public final String field() {
        return this.field;
    }

    /**
     * The field that contains the field to expand. Only required if the field to expand is part another object field, because the
     * <code>field</code> option can only understand leaf fields.
     * <p>
     * API name: {@code path}
     * </p>
     */
    @Nullable
    public final String path() {
        return this.path;
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        super.serializeInternal(generator, mapper);
        generator.writeKey("field");
        generator.write(this.field);

        if (this.path != null) {
            generator.writeKey("path");
            generator.write(this.path);
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
     * Builder for {@link DotExpanderProcessor}.
     */
    public static class Builder extends ProcessorBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, DotExpanderProcessor> {
        private String field;
        @Nullable
        private String path;

        public Builder() {}

        private Builder(DotExpanderProcessor o) {
            super(o);
            this.field = o.field;
            this.path = o.path;
        }

        private Builder(Builder o) {
            super(o);
            this.field = o.field;
            this.path = o.path;
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
         * The field that contains the field to expand. Only required if the field to expand is part another object field, because the
         * <code>field</code> option can only understand leaf fields.
         * <p>
         * API name: {@code path}
         * </p>
         */
        @Nonnull
        public final Builder path(@Nullable String value) {
            this.path = value;
            return this;
        }

        /**
         * Builds a {@link DotExpanderProcessor}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public DotExpanderProcessor build() {
            _checkSingleUse();

            return new DotExpanderProcessor(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link DotExpanderProcessor}
     */
    public static final JsonpDeserializer<DotExpanderProcessor> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        DotExpanderProcessor::setupDotExpanderProcessorDeserializer
    );

    protected static void setupDotExpanderProcessorDeserializer(ObjectDeserializer<DotExpanderProcessor.Builder> op) {
        setupProcessorBaseDeserializer(op);
        op.add(Builder::field, JsonpDeserializer.stringDeserializer(), "field");
        op.add(Builder::path, JsonpDeserializer.stringDeserializer(), "path");
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + this.field.hashCode();
        result = 31 * result + Objects.hashCode(this.path);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        DotExpanderProcessor other = (DotExpanderProcessor) o;
        return this.field.equals(other.field) && Objects.equals(this.path, other.path);
    }
}
