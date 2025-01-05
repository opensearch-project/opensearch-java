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

// typedef: ingest.AppendProcessor

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class AppendProcessor extends ProcessorBase
    implements
        ProcessorVariant,
        ToCopyableBuilder<AppendProcessor.Builder, AppendProcessor> {

    @Nullable
    private final Boolean allowDuplicates;

    @Nonnull
    private final String field;

    @Nonnull
    private final List<JsonData> value;

    // ---------------------------------------------------------------------------------------------

    private AppendProcessor(Builder builder) {
        super(builder);
        this.allowDuplicates = builder.allowDuplicates;
        this.field = ApiTypeHelper.requireNonNull(builder.field, this, "field");
        this.value = ApiTypeHelper.unmodifiableRequired(builder.value, this, "value");
    }

    public static AppendProcessor of(Function<AppendProcessor.Builder, ObjectBuilder<AppendProcessor>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * {@link Processor} variant kind.
     */
    @Override
    public Processor.Kind _processorKind() {
        return Processor.Kind.Append;
    }

    /**
     * If <code>false</code>, the processor does not append values already present in the field.
     * <p>
     * API name: {@code allow_duplicates}
     * </p>
     */
    @Nullable
    public final Boolean allowDuplicates() {
        return this.allowDuplicates;
    }

    /**
     * Required - API name: {@code field}
     */
    @Nonnull
    public final String field() {
        return this.field;
    }

    /**
     * Required - The value to be appended. Supports template snippets.
     * <p>
     * API name: {@code value}
     * </p>
     */
    @Nonnull
    public final List<JsonData> value() {
        return this.value;
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        super.serializeInternal(generator, mapper);
        if (this.allowDuplicates != null) {
            generator.writeKey("allow_duplicates");
            generator.write(this.allowDuplicates);
        }

        generator.writeKey("field");
        generator.write(this.field);

        generator.writeKey("value");
        generator.writeStartArray();
        for (JsonData item0 : this.value) {
            item0.serialize(generator, mapper);
        }
        generator.writeEnd();
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
     * Builder for {@link AppendProcessor}.
     */
    public static class Builder extends ProcessorBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, AppendProcessor> {
        @Nullable
        private Boolean allowDuplicates;
        private String field;
        private List<JsonData> value;

        public Builder() {}

        private Builder(AppendProcessor o) {
            super(o);
            this.allowDuplicates = o.allowDuplicates;
            this.field = o.field;
            this.value = _listCopy(o.value);
        }

        private Builder(Builder o) {
            super(o);
            this.allowDuplicates = o.allowDuplicates;
            this.field = o.field;
            this.value = _listCopy(o.value);
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
         * If <code>false</code>, the processor does not append values already present in the field.
         * <p>
         * API name: {@code allow_duplicates}
         * </p>
         */
        @Nonnull
        public final Builder allowDuplicates(@Nullable Boolean value) {
            this.allowDuplicates = value;
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
         * Required - The value to be appended. Supports template snippets.
         * <p>
         * API name: {@code value}
         * </p>
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>value</code>.
         * </p>
         */
        @Nonnull
        public final Builder value(List<JsonData> list) {
            this.value = _listAddAll(this.value, list);
            return this;
        }

        /**
         * Required - The value to be appended. Supports template snippets.
         * <p>
         * API name: {@code value}
         * </p>
         *
         * <p>
         * Adds one or more values to <code>value</code>.
         * </p>
         */
        @Nonnull
        public final Builder value(JsonData value, JsonData... values) {
            this.value = _listAdd(this.value, value, values);
            return this;
        }

        /**
         * Builds a {@link AppendProcessor}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public AppendProcessor build() {
            _checkSingleUse();

            return new AppendProcessor(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link AppendProcessor}
     */
    public static final JsonpDeserializer<AppendProcessor> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        AppendProcessor::setupAppendProcessorDeserializer
    );

    protected static void setupAppendProcessorDeserializer(ObjectDeserializer<AppendProcessor.Builder> op) {
        setupProcessorBaseDeserializer(op);
        op.add(Builder::allowDuplicates, JsonpDeserializer.booleanDeserializer(), "allow_duplicates");
        op.add(Builder::field, JsonpDeserializer.stringDeserializer(), "field");
        op.add(Builder::value, JsonpDeserializer.arrayDeserializer(JsonData._DESERIALIZER), "value");
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Objects.hashCode(this.allowDuplicates);
        result = 31 * result + this.field.hashCode();
        result = 31 * result + this.value.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        AppendProcessor other = (AppendProcessor) o;
        return Objects.equals(this.allowDuplicates, other.allowDuplicates)
            && this.field.equals(other.field)
            && this.value.equals(other.value);
    }
}
