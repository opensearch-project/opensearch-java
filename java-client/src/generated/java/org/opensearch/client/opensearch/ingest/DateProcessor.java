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

// typedef: ingest.DateProcessor

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class DateProcessor extends ProcessorBase implements ProcessorVariant, ToCopyableBuilder<DateProcessor.Builder, DateProcessor> {

    @Nonnull
    private final String field;

    @Nonnull
    private final List<String> formats;

    @Nullable
    private final String locale;

    @Nullable
    private final String targetField;

    @Nullable
    private final String timezone;

    // ---------------------------------------------------------------------------------------------

    private DateProcessor(Builder builder) {
        super(builder);
        this.field = ApiTypeHelper.requireNonNull(builder.field, this, "field");
        this.formats = ApiTypeHelper.unmodifiableRequired(builder.formats, this, "formats");
        this.locale = builder.locale;
        this.targetField = builder.targetField;
        this.timezone = builder.timezone;
    }

    public static DateProcessor of(Function<DateProcessor.Builder, ObjectBuilder<DateProcessor>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * {@link Processor} variant kind.
     */
    @Override
    public Processor.Kind _processorKind() {
        return Processor.Kind.Date;
    }

    /**
     * Required - API name: {@code field}
     */
    @Nonnull
    public final String field() {
        return this.field;
    }

    /**
     * Required - An array of the expected date formats. Can be a java time pattern or one of the following formats: ISO8601, UNIX, UNIX_MS,
     * or TAI64N.
     * <p>
     * API name: {@code formats}
     * </p>
     */
    @Nonnull
    public final List<String> formats() {
        return this.formats;
    }

    /**
     * The locale to use when parsing the date, relevant when parsing month names or week days. Supports template snippets.
     * <p>
     * API name: {@code locale}
     * </p>
     */
    @Nullable
    public final String locale() {
        return this.locale;
    }

    /**
     * API name: {@code target_field}
     */
    @Nullable
    public final String targetField() {
        return this.targetField;
    }

    /**
     * The time zone to use when parsing the date. Supports template snippets.
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
        generator.writeKey("field");
        generator.write(this.field);

        generator.writeKey("formats");
        generator.writeStartArray();
        for (String item0 : this.formats) {
            generator.write(item0);
        }
        generator.writeEnd();

        if (this.locale != null) {
            generator.writeKey("locale");
            generator.write(this.locale);
        }

        if (this.targetField != null) {
            generator.writeKey("target_field");
            generator.write(this.targetField);
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
     * Builder for {@link DateProcessor}.
     */
    public static class Builder extends ProcessorBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, DateProcessor> {
        private String field;
        private List<String> formats;
        @Nullable
        private String locale;
        @Nullable
        private String targetField;
        @Nullable
        private String timezone;

        public Builder() {}

        private Builder(DateProcessor o) {
            super(o);
            this.field = o.field;
            this.formats = _listCopy(o.formats);
            this.locale = o.locale;
            this.targetField = o.targetField;
            this.timezone = o.timezone;
        }

        private Builder(Builder o) {
            super(o);
            this.field = o.field;
            this.formats = _listCopy(o.formats);
            this.locale = o.locale;
            this.targetField = o.targetField;
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
         * Required - API name: {@code field}
         */
        @Nonnull
        public final Builder field(String value) {
            this.field = value;
            return this;
        }

        /**
         * Required - An array of the expected date formats. Can be a java time pattern or one of the following formats: ISO8601, UNIX,
         * UNIX_MS, or TAI64N.
         * <p>
         * API name: {@code formats}
         * </p>
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>formats</code>.
         * </p>
         */
        @Nonnull
        public final Builder formats(List<String> list) {
            this.formats = _listAddAll(this.formats, list);
            return this;
        }

        /**
         * Required - An array of the expected date formats. Can be a java time pattern or one of the following formats: ISO8601, UNIX,
         * UNIX_MS, or TAI64N.
         * <p>
         * API name: {@code formats}
         * </p>
         *
         * <p>
         * Adds one or more values to <code>formats</code>.
         * </p>
         */
        @Nonnull
        public final Builder formats(String value, String... values) {
            this.formats = _listAdd(this.formats, value, values);
            return this;
        }

        /**
         * The locale to use when parsing the date, relevant when parsing month names or week days. Supports template snippets.
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
         * API name: {@code target_field}
         */
        @Nonnull
        public final Builder targetField(@Nullable String value) {
            this.targetField = value;
            return this;
        }

        /**
         * The time zone to use when parsing the date. Supports template snippets.
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
         * Builds a {@link DateProcessor}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public DateProcessor build() {
            _checkSingleUse();

            return new DateProcessor(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link DateProcessor}
     */
    public static final JsonpDeserializer<DateProcessor> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        DateProcessor::setupDateProcessorDeserializer
    );

    protected static void setupDateProcessorDeserializer(ObjectDeserializer<DateProcessor.Builder> op) {
        setupProcessorBaseDeserializer(op);
        op.add(Builder::field, JsonpDeserializer.stringDeserializer(), "field");
        op.add(Builder::formats, JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()), "formats");
        op.add(Builder::locale, JsonpDeserializer.stringDeserializer(), "locale");
        op.add(Builder::targetField, JsonpDeserializer.stringDeserializer(), "target_field");
        op.add(Builder::timezone, JsonpDeserializer.stringDeserializer(), "timezone");
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + this.field.hashCode();
        result = 31 * result + this.formats.hashCode();
        result = 31 * result + Objects.hashCode(this.locale);
        result = 31 * result + Objects.hashCode(this.targetField);
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
        DateProcessor other = (DateProcessor) o;
        return this.field.equals(other.field)
            && this.formats.equals(other.formats)
            && Objects.equals(this.locale, other.locale)
            && Objects.equals(this.targetField, other.targetField)
            && Objects.equals(this.timezone, other.timezone);
    }
}
