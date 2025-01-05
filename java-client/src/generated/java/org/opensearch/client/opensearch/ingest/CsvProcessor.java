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

// typedef: ingest.CsvProcessor

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class CsvProcessor extends ProcessorBase implements ProcessorVariant, ToCopyableBuilder<CsvProcessor.Builder, CsvProcessor> {

    @Nullable
    private final JsonData emptyValue;

    @Nonnull
    private final String field;

    @Nullable
    private final Boolean ignoreMissing;

    @Nullable
    private final String quote;

    @Nullable
    private final String separator;

    @Nonnull
    private final List<String> targetFields;

    @Nullable
    private final Boolean trim;

    // ---------------------------------------------------------------------------------------------

    private CsvProcessor(Builder builder) {
        super(builder);
        this.emptyValue = builder.emptyValue;
        this.field = ApiTypeHelper.requireNonNull(builder.field, this, "field");
        this.ignoreMissing = builder.ignoreMissing;
        this.quote = builder.quote;
        this.separator = builder.separator;
        this.targetFields = ApiTypeHelper.unmodifiableRequired(builder.targetFields, this, "targetFields");
        this.trim = builder.trim;
    }

    public static CsvProcessor of(Function<CsvProcessor.Builder, ObjectBuilder<CsvProcessor>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * {@link Processor} variant kind.
     */
    @Override
    public Processor.Kind _processorKind() {
        return Processor.Kind.Csv;
    }

    /**
     * Value used to fill empty fields. Empty fields are skipped if this is not provided. An empty field is one with no value (2 consecutive
     * separators) or empty quotes (<code>&quot;&quot;</code>).
     * <p>
     * API name: {@code empty_value}
     * </p>
     */
    @Nullable
    public final JsonData emptyValue() {
        return this.emptyValue;
    }

    /**
     * Required - API name: {@code field}
     */
    @Nonnull
    public final String field() {
        return this.field;
    }

    /**
     * If <code>true</code> and <code>field</code> does not exist, the processor quietly exits without modifying the document.
     * <p>
     * API name: {@code ignore_missing}
     * </p>
     */
    @Nullable
    public final Boolean ignoreMissing() {
        return this.ignoreMissing;
    }

    /**
     * Quote used in CSV, has to be single character string.
     * <p>
     * API name: {@code quote}
     * </p>
     */
    @Nullable
    public final String quote() {
        return this.quote;
    }

    /**
     * Separator used in CSV, has to be single character string.
     * <p>
     * API name: {@code separator}
     * </p>
     */
    @Nullable
    public final String separator() {
        return this.separator;
    }

    /**
     * Required - API name: {@code target_fields}
     */
    @Nonnull
    public final List<String> targetFields() {
        return this.targetFields;
    }

    /**
     * Trim white spaces in unquoted fields.
     * <p>
     * API name: {@code trim}
     * </p>
     */
    @Nullable
    public final Boolean trim() {
        return this.trim;
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        super.serializeInternal(generator, mapper);
        if (this.emptyValue != null) {
            generator.writeKey("empty_value");
            this.emptyValue.serialize(generator, mapper);
        }

        generator.writeKey("field");
        generator.write(this.field);

        if (this.ignoreMissing != null) {
            generator.writeKey("ignore_missing");
            generator.write(this.ignoreMissing);
        }

        if (this.quote != null) {
            generator.writeKey("quote");
            generator.write(this.quote);
        }

        if (this.separator != null) {
            generator.writeKey("separator");
            generator.write(this.separator);
        }

        generator.writeKey("target_fields");
        generator.writeStartArray();
        for (String item0 : this.targetFields) {
            generator.write(item0);
        }
        generator.writeEnd();

        if (this.trim != null) {
            generator.writeKey("trim");
            generator.write(this.trim);
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
     * Builder for {@link CsvProcessor}.
     */
    public static class Builder extends ProcessorBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, CsvProcessor> {
        @Nullable
        private JsonData emptyValue;
        private String field;
        @Nullable
        private Boolean ignoreMissing;
        @Nullable
        private String quote;
        @Nullable
        private String separator;
        private List<String> targetFields;
        @Nullable
        private Boolean trim;

        public Builder() {}

        private Builder(CsvProcessor o) {
            super(o);
            this.emptyValue = o.emptyValue;
            this.field = o.field;
            this.ignoreMissing = o.ignoreMissing;
            this.quote = o.quote;
            this.separator = o.separator;
            this.targetFields = _listCopy(o.targetFields);
            this.trim = o.trim;
        }

        private Builder(Builder o) {
            super(o);
            this.emptyValue = o.emptyValue;
            this.field = o.field;
            this.ignoreMissing = o.ignoreMissing;
            this.quote = o.quote;
            this.separator = o.separator;
            this.targetFields = _listCopy(o.targetFields);
            this.trim = o.trim;
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
         * Value used to fill empty fields. Empty fields are skipped if this is not provided. An empty field is one with no value (2
         * consecutive separators) or empty quotes (<code>&quot;&quot;</code>).
         * <p>
         * API name: {@code empty_value}
         * </p>
         */
        @Nonnull
        public final Builder emptyValue(@Nullable JsonData value) {
            this.emptyValue = value;
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
         * If <code>true</code> and <code>field</code> does not exist, the processor quietly exits without modifying the document.
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
         * Quote used in CSV, has to be single character string.
         * <p>
         * API name: {@code quote}
         * </p>
         */
        @Nonnull
        public final Builder quote(@Nullable String value) {
            this.quote = value;
            return this;
        }

        /**
         * Separator used in CSV, has to be single character string.
         * <p>
         * API name: {@code separator}
         * </p>
         */
        @Nonnull
        public final Builder separator(@Nullable String value) {
            this.separator = value;
            return this;
        }

        /**
         * Required - API name: {@code target_fields}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>targetFields</code>.
         * </p>
         */
        @Nonnull
        public final Builder targetFields(List<String> list) {
            this.targetFields = _listAddAll(this.targetFields, list);
            return this;
        }

        /**
         * Required - API name: {@code target_fields}
         *
         * <p>
         * Adds one or more values to <code>targetFields</code>.
         * </p>
         */
        @Nonnull
        public final Builder targetFields(String value, String... values) {
            this.targetFields = _listAdd(this.targetFields, value, values);
            return this;
        }

        /**
         * Trim white spaces in unquoted fields.
         * <p>
         * API name: {@code trim}
         * </p>
         */
        @Nonnull
        public final Builder trim(@Nullable Boolean value) {
            this.trim = value;
            return this;
        }

        /**
         * Builds a {@link CsvProcessor}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public CsvProcessor build() {
            _checkSingleUse();

            return new CsvProcessor(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link CsvProcessor}
     */
    public static final JsonpDeserializer<CsvProcessor> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        CsvProcessor::setupCsvProcessorDeserializer
    );

    protected static void setupCsvProcessorDeserializer(ObjectDeserializer<CsvProcessor.Builder> op) {
        setupProcessorBaseDeserializer(op);
        op.add(Builder::emptyValue, JsonData._DESERIALIZER, "empty_value");
        op.add(Builder::field, JsonpDeserializer.stringDeserializer(), "field");
        op.add(Builder::ignoreMissing, JsonpDeserializer.booleanDeserializer(), "ignore_missing");
        op.add(Builder::quote, JsonpDeserializer.stringDeserializer(), "quote");
        op.add(Builder::separator, JsonpDeserializer.stringDeserializer(), "separator");
        op.add(Builder::targetFields, JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()), "target_fields");
        op.add(Builder::trim, JsonpDeserializer.booleanDeserializer(), "trim");
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Objects.hashCode(this.emptyValue);
        result = 31 * result + this.field.hashCode();
        result = 31 * result + Objects.hashCode(this.ignoreMissing);
        result = 31 * result + Objects.hashCode(this.quote);
        result = 31 * result + Objects.hashCode(this.separator);
        result = 31 * result + this.targetFields.hashCode();
        result = 31 * result + Objects.hashCode(this.trim);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        CsvProcessor other = (CsvProcessor) o;
        return Objects.equals(this.emptyValue, other.emptyValue)
            && this.field.equals(other.field)
            && Objects.equals(this.ignoreMissing, other.ignoreMissing)
            && Objects.equals(this.quote, other.quote)
            && Objects.equals(this.separator, other.separator)
            && this.targetFields.equals(other.targetFields)
            && Objects.equals(this.trim, other.trim);
    }
}
