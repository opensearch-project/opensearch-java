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

// typedef: ingest.RemoveProcessor

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class RemoveProcessor extends ProcessorBase
    implements
        ProcessorVariant,
        ToCopyableBuilder<RemoveProcessor.Builder, RemoveProcessor> {

    @Nonnull
    private final List<String> field;

    @Nullable
    private final Boolean ignoreMissing;

    // ---------------------------------------------------------------------------------------------

    private RemoveProcessor(Builder builder) {
        super(builder);
        this.field = ApiTypeHelper.unmodifiableRequired(builder.field, this, "field");
        this.ignoreMissing = builder.ignoreMissing;
    }

    public static RemoveProcessor of(Function<RemoveProcessor.Builder, ObjectBuilder<RemoveProcessor>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * {@link Processor} variant kind.
     */
    @Override
    public Processor.Kind _processorKind() {
        return Processor.Kind.Remove;
    }

    /**
     * Required - API name: {@code field}
     */
    @Nonnull
    public final List<String> field() {
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

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        super.serializeInternal(generator, mapper);
        generator.writeKey("field");
        generator.writeStartArray();
        for (String item0 : this.field) {
            generator.write(item0);
        }
        generator.writeEnd();

        if (this.ignoreMissing != null) {
            generator.writeKey("ignore_missing");
            generator.write(this.ignoreMissing);
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
     * Builder for {@link RemoveProcessor}.
     */
    public static class Builder extends ProcessorBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, RemoveProcessor> {
        private List<String> field;
        @Nullable
        private Boolean ignoreMissing;

        public Builder() {}

        private Builder(RemoveProcessor o) {
            super(o);
            this.field = _listCopy(o.field);
            this.ignoreMissing = o.ignoreMissing;
        }

        private Builder(Builder o) {
            super(o);
            this.field = _listCopy(o.field);
            this.ignoreMissing = o.ignoreMissing;
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
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>field</code>.
         * </p>
         */
        @Nonnull
        public final Builder field(List<String> list) {
            this.field = _listAddAll(this.field, list);
            return this;
        }

        /**
         * Required - API name: {@code field}
         *
         * <p>
         * Adds one or more values to <code>field</code>.
         * </p>
         */
        @Nonnull
        public final Builder field(String value, String... values) {
            this.field = _listAdd(this.field, value, values);
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
         * Builds a {@link RemoveProcessor}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public RemoveProcessor build() {
            _checkSingleUse();

            return new RemoveProcessor(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link RemoveProcessor}
     */
    public static final JsonpDeserializer<RemoveProcessor> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        RemoveProcessor::setupRemoveProcessorDeserializer
    );

    protected static void setupRemoveProcessorDeserializer(ObjectDeserializer<RemoveProcessor.Builder> op) {
        setupProcessorBaseDeserializer(op);
        op.add(Builder::field, JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()), "field");
        op.add(Builder::ignoreMissing, JsonpDeserializer.booleanDeserializer(), "ignore_missing");
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + this.field.hashCode();
        result = 31 * result + Objects.hashCode(this.ignoreMissing);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        RemoveProcessor other = (RemoveProcessor) o;
        return this.field.equals(other.field) && Objects.equals(this.ignoreMissing, other.ignoreMissing);
    }
}
