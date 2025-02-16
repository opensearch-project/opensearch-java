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

package org.opensearch.client.opensearch.core.search;

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
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: core.search.FetchProfileBreakdown

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class FetchProfileBreakdown
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<FetchProfileBreakdown.Builder, FetchProfileBreakdown> {

    @Nullable
    private final Integer loadSource;

    @Nullable
    private final Integer loadSourceCount;

    @Nullable
    private final Integer loadStoredFields;

    @Nullable
    private final Integer loadStoredFieldsCount;

    @Nullable
    private final Integer nextReader;

    @Nullable
    private final Integer nextReaderCount;

    @Nullable
    private final Integer process;

    @Nullable
    private final Integer processCount;

    // ---------------------------------------------------------------------------------------------

    private FetchProfileBreakdown(Builder builder) {
        this.loadSource = builder.loadSource;
        this.loadSourceCount = builder.loadSourceCount;
        this.loadStoredFields = builder.loadStoredFields;
        this.loadStoredFieldsCount = builder.loadStoredFieldsCount;
        this.nextReader = builder.nextReader;
        this.nextReaderCount = builder.nextReaderCount;
        this.process = builder.process;
        this.processCount = builder.processCount;
    }

    public static FetchProfileBreakdown of(Function<FetchProfileBreakdown.Builder, ObjectBuilder<FetchProfileBreakdown>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code load_source}
     */
    @Nullable
    public final Integer loadSource() {
        return this.loadSource;
    }

    /**
     * API name: {@code load_source_count}
     */
    @Nullable
    public final Integer loadSourceCount() {
        return this.loadSourceCount;
    }

    /**
     * API name: {@code load_stored_fields}
     */
    @Nullable
    public final Integer loadStoredFields() {
        return this.loadStoredFields;
    }

    /**
     * API name: {@code load_stored_fields_count}
     */
    @Nullable
    public final Integer loadStoredFieldsCount() {
        return this.loadStoredFieldsCount;
    }

    /**
     * API name: {@code next_reader}
     */
    @Nullable
    public final Integer nextReader() {
        return this.nextReader;
    }

    /**
     * API name: {@code next_reader_count}
     */
    @Nullable
    public final Integer nextReaderCount() {
        return this.nextReaderCount;
    }

    /**
     * API name: {@code process}
     */
    @Nullable
    public final Integer process() {
        return this.process;
    }

    /**
     * API name: {@code process_count}
     */
    @Nullable
    public final Integer processCount() {
        return this.processCount;
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
        if (this.loadSource != null) {
            generator.writeKey("load_source");
            generator.write(this.loadSource);
        }

        if (this.loadSourceCount != null) {
            generator.writeKey("load_source_count");
            generator.write(this.loadSourceCount);
        }

        if (this.loadStoredFields != null) {
            generator.writeKey("load_stored_fields");
            generator.write(this.loadStoredFields);
        }

        if (this.loadStoredFieldsCount != null) {
            generator.writeKey("load_stored_fields_count");
            generator.write(this.loadStoredFieldsCount);
        }

        if (this.nextReader != null) {
            generator.writeKey("next_reader");
            generator.write(this.nextReader);
        }

        if (this.nextReaderCount != null) {
            generator.writeKey("next_reader_count");
            generator.write(this.nextReaderCount);
        }

        if (this.process != null) {
            generator.writeKey("process");
            generator.write(this.process);
        }

        if (this.processCount != null) {
            generator.writeKey("process_count");
            generator.write(this.processCount);
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
     * Builder for {@link FetchProfileBreakdown}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, FetchProfileBreakdown> {
        @Nullable
        private Integer loadSource;
        @Nullable
        private Integer loadSourceCount;
        @Nullable
        private Integer loadStoredFields;
        @Nullable
        private Integer loadStoredFieldsCount;
        @Nullable
        private Integer nextReader;
        @Nullable
        private Integer nextReaderCount;
        @Nullable
        private Integer process;
        @Nullable
        private Integer processCount;

        public Builder() {}

        private Builder(FetchProfileBreakdown o) {
            this.loadSource = o.loadSource;
            this.loadSourceCount = o.loadSourceCount;
            this.loadStoredFields = o.loadStoredFields;
            this.loadStoredFieldsCount = o.loadStoredFieldsCount;
            this.nextReader = o.nextReader;
            this.nextReaderCount = o.nextReaderCount;
            this.process = o.process;
            this.processCount = o.processCount;
        }

        private Builder(Builder o) {
            this.loadSource = o.loadSource;
            this.loadSourceCount = o.loadSourceCount;
            this.loadStoredFields = o.loadStoredFields;
            this.loadStoredFieldsCount = o.loadStoredFieldsCount;
            this.nextReader = o.nextReader;
            this.nextReaderCount = o.nextReaderCount;
            this.process = o.process;
            this.processCount = o.processCount;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code load_source}
         */
        @Nonnull
        public final Builder loadSource(@Nullable Integer value) {
            this.loadSource = value;
            return this;
        }

        /**
         * API name: {@code load_source_count}
         */
        @Nonnull
        public final Builder loadSourceCount(@Nullable Integer value) {
            this.loadSourceCount = value;
            return this;
        }

        /**
         * API name: {@code load_stored_fields}
         */
        @Nonnull
        public final Builder loadStoredFields(@Nullable Integer value) {
            this.loadStoredFields = value;
            return this;
        }

        /**
         * API name: {@code load_stored_fields_count}
         */
        @Nonnull
        public final Builder loadStoredFieldsCount(@Nullable Integer value) {
            this.loadStoredFieldsCount = value;
            return this;
        }

        /**
         * API name: {@code next_reader}
         */
        @Nonnull
        public final Builder nextReader(@Nullable Integer value) {
            this.nextReader = value;
            return this;
        }

        /**
         * API name: {@code next_reader_count}
         */
        @Nonnull
        public final Builder nextReaderCount(@Nullable Integer value) {
            this.nextReaderCount = value;
            return this;
        }

        /**
         * API name: {@code process}
         */
        @Nonnull
        public final Builder process(@Nullable Integer value) {
            this.process = value;
            return this;
        }

        /**
         * API name: {@code process_count}
         */
        @Nonnull
        public final Builder processCount(@Nullable Integer value) {
            this.processCount = value;
            return this;
        }

        /**
         * Builds a {@link FetchProfileBreakdown}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public FetchProfileBreakdown build() {
            _checkSingleUse();

            return new FetchProfileBreakdown(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link FetchProfileBreakdown}
     */
    public static final JsonpDeserializer<FetchProfileBreakdown> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        FetchProfileBreakdown::setupFetchProfileBreakdownDeserializer
    );

    protected static void setupFetchProfileBreakdownDeserializer(ObjectDeserializer<FetchProfileBreakdown.Builder> op) {
        op.add(Builder::loadSource, JsonpDeserializer.integerDeserializer(), "load_source");
        op.add(Builder::loadSourceCount, JsonpDeserializer.integerDeserializer(), "load_source_count");
        op.add(Builder::loadStoredFields, JsonpDeserializer.integerDeserializer(), "load_stored_fields");
        op.add(Builder::loadStoredFieldsCount, JsonpDeserializer.integerDeserializer(), "load_stored_fields_count");
        op.add(Builder::nextReader, JsonpDeserializer.integerDeserializer(), "next_reader");
        op.add(Builder::nextReaderCount, JsonpDeserializer.integerDeserializer(), "next_reader_count");
        op.add(Builder::process, JsonpDeserializer.integerDeserializer(), "process");
        op.add(Builder::processCount, JsonpDeserializer.integerDeserializer(), "process_count");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.loadSource);
        result = 31 * result + Objects.hashCode(this.loadSourceCount);
        result = 31 * result + Objects.hashCode(this.loadStoredFields);
        result = 31 * result + Objects.hashCode(this.loadStoredFieldsCount);
        result = 31 * result + Objects.hashCode(this.nextReader);
        result = 31 * result + Objects.hashCode(this.nextReaderCount);
        result = 31 * result + Objects.hashCode(this.process);
        result = 31 * result + Objects.hashCode(this.processCount);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        FetchProfileBreakdown other = (FetchProfileBreakdown) o;
        return Objects.equals(this.loadSource, other.loadSource)
            && Objects.equals(this.loadSourceCount, other.loadSourceCount)
            && Objects.equals(this.loadStoredFields, other.loadStoredFields)
            && Objects.equals(this.loadStoredFieldsCount, other.loadStoredFieldsCount)
            && Objects.equals(this.nextReader, other.nextReader)
            && Objects.equals(this.nextReaderCount, other.nextReaderCount)
            && Objects.equals(this.process, other.process)
            && Objects.equals(this.processCount, other.processCount);
    }
}
