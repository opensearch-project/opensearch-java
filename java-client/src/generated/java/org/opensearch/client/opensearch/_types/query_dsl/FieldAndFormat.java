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

package org.opensearch.client.opensearch._types.query_dsl;

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
import org.opensearch.client.json.PlainJsonSerializable;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: _types.query_dsl.FieldAndFormat

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class FieldAndFormat implements PlainJsonSerializable, ToCopyableBuilder<FieldAndFormat.Builder, FieldAndFormat> {

    @Nonnull
    private final String field;

    @Nullable
    private final String format;

    @Nullable
    private final Boolean includeUnmapped;

    // ---------------------------------------------------------------------------------------------

    private FieldAndFormat(Builder builder) {
        this.field = ApiTypeHelper.requireNonNull(builder.field, this, "field");
        this.format = builder.format;
        this.includeUnmapped = builder.includeUnmapped;
    }

    public static FieldAndFormat of(Function<FieldAndFormat.Builder, ObjectBuilder<FieldAndFormat>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - API name: {@code field}
     */
    @Nonnull
    public final String field() {
        return this.field;
    }

    /**
     * Format in which the values are returned.
     * <p>
     * API name: {@code format}
     * </p>
     */
    @Nullable
    public final String format() {
        return this.format;
    }

    /**
     * API name: {@code include_unmapped}
     */
    @Nullable
    public final Boolean includeUnmapped() {
        return this.includeUnmapped;
    }

    /**
     * Serialize this object to JSON.
     */
    @Override
    public void serialize(JsonGenerator generator, JsonpMapper mapper) {
        generator.writeStartObject();
        serializeInternal(generator, mapper);
        generator.writeEnd();
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        generator.writeKey("field");
        generator.write(this.field);

        if (this.format != null) {
            generator.writeKey("format");
            generator.write(this.format);
        }

        if (this.includeUnmapped != null) {
            generator.writeKey("include_unmapped");
            generator.write(this.includeUnmapped);
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
     * Builder for {@link FieldAndFormat}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, FieldAndFormat> {
        private String field;
        @Nullable
        private String format;
        @Nullable
        private Boolean includeUnmapped;

        public Builder() {}

        private Builder(FieldAndFormat o) {
            this.field = o.field;
            this.format = o.format;
            this.includeUnmapped = o.includeUnmapped;
        }

        private Builder(Builder o) {
            this.field = o.field;
            this.format = o.format;
            this.includeUnmapped = o.includeUnmapped;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
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
         * Format in which the values are returned.
         * <p>
         * API name: {@code format}
         * </p>
         */
        @Nonnull
        public final Builder format(@Nullable String value) {
            this.format = value;
            return this;
        }

        /**
         * API name: {@code include_unmapped}
         */
        @Nonnull
        public final Builder includeUnmapped(@Nullable Boolean value) {
            this.includeUnmapped = value;
            return this;
        }

        /**
         * Builds a {@link FieldAndFormat}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public FieldAndFormat build() {
            _checkSingleUse();

            return new FieldAndFormat(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link FieldAndFormat}
     */
    public static final JsonpDeserializer<FieldAndFormat> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        FieldAndFormat::setupFieldAndFormatDeserializer
    );

    protected static void setupFieldAndFormatDeserializer(ObjectDeserializer<FieldAndFormat.Builder> op) {
        op.add(Builder::field, JsonpDeserializer.stringDeserializer(), "field");
        op.add(Builder::format, JsonpDeserializer.stringDeserializer(), "format");
        op.add(Builder::includeUnmapped, JsonpDeserializer.booleanDeserializer(), "include_unmapped");

        op.shortcutProperty("field");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.field.hashCode();
        result = 31 * result + Objects.hashCode(this.format);
        result = 31 * result + Objects.hashCode(this.includeUnmapped);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        FieldAndFormat other = (FieldAndFormat) o;
        return this.field.equals(other.field)
            && Objects.equals(this.format, other.format)
            && Objects.equals(this.includeUnmapped, other.includeUnmapped);
    }
}
