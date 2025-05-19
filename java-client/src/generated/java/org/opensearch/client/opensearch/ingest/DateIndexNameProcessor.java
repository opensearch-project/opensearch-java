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

// typedef: ingest.DateIndexNameProcessor

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class DateIndexNameProcessor extends ProcessorBase
    implements
        ProcessorVariant,
        ToCopyableBuilder<DateIndexNameProcessor.Builder, DateIndexNameProcessor> {

    @Nonnull
    private final List<String> dateFormats;

    @Nonnull
    private final String dateRounding;

    @Nonnull
    private final String field;

    @Nullable
    private final String indexNameFormat;

    @Nullable
    private final String indexNamePrefix;

    @Nullable
    private final String locale;

    @Nullable
    private final String timezone;

    // ---------------------------------------------------------------------------------------------

    private DateIndexNameProcessor(Builder builder) {
        super(builder);
        this.dateFormats = ApiTypeHelper.unmodifiableRequired(builder.dateFormats, this, "dateFormats");
        this.dateRounding = ApiTypeHelper.requireNonNull(builder.dateRounding, this, "dateRounding");
        this.field = ApiTypeHelper.requireNonNull(builder.field, this, "field");
        this.indexNameFormat = builder.indexNameFormat;
        this.indexNamePrefix = builder.indexNamePrefix;
        this.locale = builder.locale;
        this.timezone = builder.timezone;
    }

    public static DateIndexNameProcessor of(Function<DateIndexNameProcessor.Builder, ObjectBuilder<DateIndexNameProcessor>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * {@link Processor} variant kind.
     */
    @Override
    public Processor.Kind _processorKind() {
        return Processor.Kind.DateIndexName;
    }

    /**
     * Required - An array of the expected date formats for parsing dates/timestamps in the document being preprocessed. Can be a java time
     * pattern or one of the following formats: <code>ISO8601</code>, <code>UNIX</code>, <code>UNIX_MS</code>, or <code>TAI64N</code>.
     * <p>
     * API name: {@code date_formats}
     * </p>
     */
    @Nonnull
    public final List<String> dateFormats() {
        return this.dateFormats;
    }

    /**
     * Required - How to round the date when formatting the date into the index name. Valid values are: <code>y</code> (year),
     * <code>M</code> (month), <code>w</code> (week), <code>d</code> (day), <code>h</code> (hour), <code>m</code> (minute) and
     * <code>s</code> (second). Supports template snippets.
     * <p>
     * API name: {@code date_rounding}
     * </p>
     */
    @Nonnull
    public final String dateRounding() {
        return this.dateRounding;
    }

    /**
     * Required - API name: {@code field}
     */
    @Nonnull
    public final String field() {
        return this.field;
    }

    /**
     * The format to be used when printing the parsed date into the index name. A valid java time pattern is expected here. Supports
     * template snippets.
     * <p>
     * API name: {@code index_name_format}
     * </p>
     */
    @Nullable
    public final String indexNameFormat() {
        return this.indexNameFormat;
    }

    /**
     * A prefix of the index name to be prepended before the printed date. Supports template snippets.
     * <p>
     * API name: {@code index_name_prefix}
     * </p>
     */
    @Nullable
    public final String indexNamePrefix() {
        return this.indexNamePrefix;
    }

    /**
     * The locale to use when parsing the date from the document being preprocessed, relevant when parsing month names or week days.
     * <p>
     * API name: {@code locale}
     * </p>
     */
    @Nullable
    public final String locale() {
        return this.locale;
    }

    /**
     * The time zone to use when parsing the date and when date math index supports resolves expressions into concrete index names.
     * <p>
     * API name: {@code timezone}
     * </p>
     */
    @Nullable
    public final String timezone() {
        return this.timezone;
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        super.serializeInternal(generator, mapper);
        generator.writeKey("date_formats");
        generator.writeStartArray();
        for (String item0 : this.dateFormats) {
            generator.write(item0);
        }
        generator.writeEnd();

        generator.writeKey("date_rounding");
        generator.write(this.dateRounding);

        generator.writeKey("field");
        generator.write(this.field);

        if (this.indexNameFormat != null) {
            generator.writeKey("index_name_format");
            generator.write(this.indexNameFormat);
        }

        if (this.indexNamePrefix != null) {
            generator.writeKey("index_name_prefix");
            generator.write(this.indexNamePrefix);
        }

        if (this.locale != null) {
            generator.writeKey("locale");
            generator.write(this.locale);
        }

        if (this.timezone != null) {
            generator.writeKey("timezone");
            generator.write(this.timezone);
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
     * Builder for {@link DateIndexNameProcessor}.
     */
    public static class Builder extends ProcessorBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, DateIndexNameProcessor> {
        private List<String> dateFormats;
        private String dateRounding;
        private String field;
        @Nullable
        private String indexNameFormat;
        @Nullable
        private String indexNamePrefix;
        @Nullable
        private String locale;
        @Nullable
        private String timezone;

        public Builder() {}

        private Builder(DateIndexNameProcessor o) {
            super(o);
            this.dateFormats = _listCopy(o.dateFormats);
            this.dateRounding = o.dateRounding;
            this.field = o.field;
            this.indexNameFormat = o.indexNameFormat;
            this.indexNamePrefix = o.indexNamePrefix;
            this.locale = o.locale;
            this.timezone = o.timezone;
        }

        private Builder(Builder o) {
            super(o);
            this.dateFormats = _listCopy(o.dateFormats);
            this.dateRounding = o.dateRounding;
            this.field = o.field;
            this.indexNameFormat = o.indexNameFormat;
            this.indexNamePrefix = o.indexNamePrefix;
            this.locale = o.locale;
            this.timezone = o.timezone;
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
         * Required - An array of the expected date formats for parsing dates/timestamps in the document being preprocessed. Can be a java
         * time pattern or one of the following formats: <code>ISO8601</code>, <code>UNIX</code>, <code>UNIX_MS</code>, or
         * <code>TAI64N</code>.
         * <p>
         * API name: {@code date_formats}
         * </p>
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>dateFormats</code>.
         * </p>
         */
        @Nonnull
        public final Builder dateFormats(List<String> list) {
            this.dateFormats = _listAddAll(this.dateFormats, list);
            return this;
        }

        /**
         * Required - An array of the expected date formats for parsing dates/timestamps in the document being preprocessed. Can be a java
         * time pattern or one of the following formats: <code>ISO8601</code>, <code>UNIX</code>, <code>UNIX_MS</code>, or
         * <code>TAI64N</code>.
         * <p>
         * API name: {@code date_formats}
         * </p>
         *
         * <p>
         * Adds one or more values to <code>dateFormats</code>.
         * </p>
         */
        @Nonnull
        public final Builder dateFormats(String value, String... values) {
            this.dateFormats = _listAdd(this.dateFormats, value, values);
            return this;
        }

        /**
         * Required - How to round the date when formatting the date into the index name. Valid values are: <code>y</code> (year),
         * <code>M</code> (month), <code>w</code> (week), <code>d</code> (day), <code>h</code> (hour), <code>m</code> (minute) and
         * <code>s</code> (second). Supports template snippets.
         * <p>
         * API name: {@code date_rounding}
         * </p>
         */
        @Nonnull
        public final Builder dateRounding(String value) {
            this.dateRounding = value;
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
         * The format to be used when printing the parsed date into the index name. A valid java time pattern is expected here. Supports
         * template snippets.
         * <p>
         * API name: {@code index_name_format}
         * </p>
         */
        @Nonnull
        public final Builder indexNameFormat(@Nullable String value) {
            this.indexNameFormat = value;
            return this;
        }

        /**
         * A prefix of the index name to be prepended before the printed date. Supports template snippets.
         * <p>
         * API name: {@code index_name_prefix}
         * </p>
         */
        @Nonnull
        public final Builder indexNamePrefix(@Nullable String value) {
            this.indexNamePrefix = value;
            return this;
        }

        /**
         * The locale to use when parsing the date from the document being preprocessed, relevant when parsing month names or week days.
         * <p>
         * API name: {@code locale}
         * </p>
         */
        @Nonnull
        public final Builder locale(@Nullable String value) {
            this.locale = value;
            return this;
        }

        /**
         * The time zone to use when parsing the date and when date math index supports resolves expressions into concrete index names.
         * <p>
         * API name: {@code timezone}
         * </p>
         */
        @Nonnull
        public final Builder timezone(@Nullable String value) {
            this.timezone = value;
            return this;
        }

        /**
         * Builds a {@link DateIndexNameProcessor}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public DateIndexNameProcessor build() {
            _checkSingleUse();

            return new DateIndexNameProcessor(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link DateIndexNameProcessor}
     */
    public static final JsonpDeserializer<DateIndexNameProcessor> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        DateIndexNameProcessor::setupDateIndexNameProcessorDeserializer
    );

    protected static void setupDateIndexNameProcessorDeserializer(ObjectDeserializer<DateIndexNameProcessor.Builder> op) {
        setupProcessorBaseDeserializer(op);
        op.add(Builder::dateFormats, JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()), "date_formats");
        op.add(Builder::dateRounding, JsonpDeserializer.stringDeserializer(), "date_rounding");
        op.add(Builder::field, JsonpDeserializer.stringDeserializer(), "field");
        op.add(Builder::indexNameFormat, JsonpDeserializer.stringDeserializer(), "index_name_format");
        op.add(Builder::indexNamePrefix, JsonpDeserializer.stringDeserializer(), "index_name_prefix");
        op.add(Builder::locale, JsonpDeserializer.stringDeserializer(), "locale");
        op.add(Builder::timezone, JsonpDeserializer.stringDeserializer(), "timezone");
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + this.dateFormats.hashCode();
        result = 31 * result + this.dateRounding.hashCode();
        result = 31 * result + this.field.hashCode();
        result = 31 * result + Objects.hashCode(this.indexNameFormat);
        result = 31 * result + Objects.hashCode(this.indexNamePrefix);
        result = 31 * result + Objects.hashCode(this.locale);
        result = 31 * result + Objects.hashCode(this.timezone);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        DateIndexNameProcessor other = (DateIndexNameProcessor) o;
        return this.dateFormats.equals(other.dateFormats)
            && this.dateRounding.equals(other.dateRounding)
            && this.field.equals(other.field)
            && Objects.equals(this.indexNameFormat, other.indexNameFormat)
            && Objects.equals(this.indexNamePrefix, other.indexNamePrefix)
            && Objects.equals(this.locale, other.locale)
            && Objects.equals(this.timezone, other.timezone);
    }
}
