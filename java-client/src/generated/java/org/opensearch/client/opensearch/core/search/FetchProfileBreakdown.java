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
    private final Long buildSubPhaseProcessors;

    @Nullable
    private final Long buildSubPhaseProcessorsCount;

    @Nullable
    private final Long createStoredFieldsVisitor;

    @Nullable
    private final Long createStoredFieldsVisitorCount;

    @Nullable
    private final Long getNextReader;

    @Nullable
    private final Long getNextReaderCount;

    @Nullable
    private final Long loadSource;

    @Nullable
    private final Long loadSourceCount;

    @Nullable
    private final Long loadStoredFields;

    @Nullable
    private final Long loadStoredFieldsCount;

    @Nullable
    private final Long process;

    @Nullable
    private final Long processCount;

    @Nullable
    private final Long setNextReader;

    @Nullable
    private final Long setNextReaderCount;

    // ---------------------------------------------------------------------------------------------

    private FetchProfileBreakdown(Builder builder) {
        this.buildSubPhaseProcessors = builder.buildSubPhaseProcessors;
        this.buildSubPhaseProcessorsCount = builder.buildSubPhaseProcessorsCount;
        this.createStoredFieldsVisitor = builder.createStoredFieldsVisitor;
        this.createStoredFieldsVisitorCount = builder.createStoredFieldsVisitorCount;
        this.getNextReader = builder.getNextReader;
        this.getNextReaderCount = builder.getNextReaderCount;
        this.loadSource = builder.loadSource;
        this.loadSourceCount = builder.loadSourceCount;
        this.loadStoredFields = builder.loadStoredFields;
        this.loadStoredFieldsCount = builder.loadStoredFieldsCount;
        this.process = builder.process;
        this.processCount = builder.processCount;
        this.setNextReader = builder.setNextReader;
        this.setNextReaderCount = builder.setNextReaderCount;
    }

    public static FetchProfileBreakdown of(Function<FetchProfileBreakdown.Builder, ObjectBuilder<FetchProfileBreakdown>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code build_sub_phase_processors}
     */
    @Nullable
    public final Long buildSubPhaseProcessors() {
        return this.buildSubPhaseProcessors;
    }

    /**
     * API name: {@code build_sub_phase_processors_count}
     */
    @Nullable
    public final Long buildSubPhaseProcessorsCount() {
        return this.buildSubPhaseProcessorsCount;
    }

    /**
     * API name: {@code create_stored_fields_visitor}
     */
    @Nullable
    public final Long createStoredFieldsVisitor() {
        return this.createStoredFieldsVisitor;
    }

    /**
     * API name: {@code create_stored_fields_visitor_count}
     */
    @Nullable
    public final Long createStoredFieldsVisitorCount() {
        return this.createStoredFieldsVisitorCount;
    }

    /**
     * API name: {@code get_next_reader}
     */
    @Nullable
    public final Long getNextReader() {
        return this.getNextReader;
    }

    /**
     * API name: {@code get_next_reader_count}
     */
    @Nullable
    public final Long getNextReaderCount() {
        return this.getNextReaderCount;
    }

    /**
     * API name: {@code load_source}
     */
    @Nullable
    public final Long loadSource() {
        return this.loadSource;
    }

    /**
     * API name: {@code load_source_count}
     */
    @Nullable
    public final Long loadSourceCount() {
        return this.loadSourceCount;
    }

    /**
     * API name: {@code load_stored_fields}
     */
    @Nullable
    public final Long loadStoredFields() {
        return this.loadStoredFields;
    }

    /**
     * API name: {@code load_stored_fields_count}
     */
    @Nullable
    public final Long loadStoredFieldsCount() {
        return this.loadStoredFieldsCount;
    }

    /**
     * API name: {@code process}
     */
    @Nullable
    public final Long process() {
        return this.process;
    }

    /**
     * API name: {@code process_count}
     */
    @Nullable
    public final Long processCount() {
        return this.processCount;
    }

    /**
     * API name: {@code set_next_reader}
     */
    @Nullable
    public final Long setNextReader() {
        return this.setNextReader;
    }

    /**
     * API name: {@code set_next_reader_count}
     */
    @Nullable
    public final Long setNextReaderCount() {
        return this.setNextReaderCount;
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
        if (this.buildSubPhaseProcessors != null) {
            generator.writeKey("build_sub_phase_processors");
            generator.write(this.buildSubPhaseProcessors);
        }

        if (this.buildSubPhaseProcessorsCount != null) {
            generator.writeKey("build_sub_phase_processors_count");
            generator.write(this.buildSubPhaseProcessorsCount);
        }

        if (this.createStoredFieldsVisitor != null) {
            generator.writeKey("create_stored_fields_visitor");
            generator.write(this.createStoredFieldsVisitor);
        }

        if (this.createStoredFieldsVisitorCount != null) {
            generator.writeKey("create_stored_fields_visitor_count");
            generator.write(this.createStoredFieldsVisitorCount);
        }

        if (this.getNextReader != null) {
            generator.writeKey("get_next_reader");
            generator.write(this.getNextReader);
        }

        if (this.getNextReaderCount != null) {
            generator.writeKey("get_next_reader_count");
            generator.write(this.getNextReaderCount);
        }

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

        if (this.process != null) {
            generator.writeKey("process");
            generator.write(this.process);
        }

        if (this.processCount != null) {
            generator.writeKey("process_count");
            generator.write(this.processCount);
        }

        if (this.setNextReader != null) {
            generator.writeKey("set_next_reader");
            generator.write(this.setNextReader);
        }

        if (this.setNextReaderCount != null) {
            generator.writeKey("set_next_reader_count");
            generator.write(this.setNextReaderCount);
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
        private Long buildSubPhaseProcessors;
        @Nullable
        private Long buildSubPhaseProcessorsCount;
        @Nullable
        private Long createStoredFieldsVisitor;
        @Nullable
        private Long createStoredFieldsVisitorCount;
        @Nullable
        private Long getNextReader;
        @Nullable
        private Long getNextReaderCount;
        @Nullable
        private Long loadSource;
        @Nullable
        private Long loadSourceCount;
        @Nullable
        private Long loadStoredFields;
        @Nullable
        private Long loadStoredFieldsCount;
        @Nullable
        private Long process;
        @Nullable
        private Long processCount;
        @Nullable
        private Long setNextReader;
        @Nullable
        private Long setNextReaderCount;

        public Builder() {}

        private Builder(FetchProfileBreakdown o) {
            this.buildSubPhaseProcessors = o.buildSubPhaseProcessors;
            this.buildSubPhaseProcessorsCount = o.buildSubPhaseProcessorsCount;
            this.createStoredFieldsVisitor = o.createStoredFieldsVisitor;
            this.createStoredFieldsVisitorCount = o.createStoredFieldsVisitorCount;
            this.getNextReader = o.getNextReader;
            this.getNextReaderCount = o.getNextReaderCount;
            this.loadSource = o.loadSource;
            this.loadSourceCount = o.loadSourceCount;
            this.loadStoredFields = o.loadStoredFields;
            this.loadStoredFieldsCount = o.loadStoredFieldsCount;
            this.process = o.process;
            this.processCount = o.processCount;
            this.setNextReader = o.setNextReader;
            this.setNextReaderCount = o.setNextReaderCount;
        }

        private Builder(Builder o) {
            this.buildSubPhaseProcessors = o.buildSubPhaseProcessors;
            this.buildSubPhaseProcessorsCount = o.buildSubPhaseProcessorsCount;
            this.createStoredFieldsVisitor = o.createStoredFieldsVisitor;
            this.createStoredFieldsVisitorCount = o.createStoredFieldsVisitorCount;
            this.getNextReader = o.getNextReader;
            this.getNextReaderCount = o.getNextReaderCount;
            this.loadSource = o.loadSource;
            this.loadSourceCount = o.loadSourceCount;
            this.loadStoredFields = o.loadStoredFields;
            this.loadStoredFieldsCount = o.loadStoredFieldsCount;
            this.process = o.process;
            this.processCount = o.processCount;
            this.setNextReader = o.setNextReader;
            this.setNextReaderCount = o.setNextReaderCount;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code build_sub_phase_processors}
         */
        @Nonnull
        public final Builder buildSubPhaseProcessors(@Nullable Long value) {
            this.buildSubPhaseProcessors = value;
            return this;
        }

        /**
         * API name: {@code build_sub_phase_processors_count}
         */
        @Nonnull
        public final Builder buildSubPhaseProcessorsCount(@Nullable Long value) {
            this.buildSubPhaseProcessorsCount = value;
            return this;
        }

        /**
         * API name: {@code create_stored_fields_visitor}
         */
        @Nonnull
        public final Builder createStoredFieldsVisitor(@Nullable Long value) {
            this.createStoredFieldsVisitor = value;
            return this;
        }

        /**
         * API name: {@code create_stored_fields_visitor_count}
         */
        @Nonnull
        public final Builder createStoredFieldsVisitorCount(@Nullable Long value) {
            this.createStoredFieldsVisitorCount = value;
            return this;
        }

        /**
         * API name: {@code get_next_reader}
         */
        @Nonnull
        public final Builder getNextReader(@Nullable Long value) {
            this.getNextReader = value;
            return this;
        }

        /**
         * API name: {@code get_next_reader_count}
         */
        @Nonnull
        public final Builder getNextReaderCount(@Nullable Long value) {
            this.getNextReaderCount = value;
            return this;
        }

        /**
         * API name: {@code load_source}
         */
        @Nonnull
        public final Builder loadSource(@Nullable Long value) {
            this.loadSource = value;
            return this;
        }

        /**
         * API name: {@code load_source_count}
         */
        @Nonnull
        public final Builder loadSourceCount(@Nullable Long value) {
            this.loadSourceCount = value;
            return this;
        }

        /**
         * API name: {@code load_stored_fields}
         */
        @Nonnull
        public final Builder loadStoredFields(@Nullable Long value) {
            this.loadStoredFields = value;
            return this;
        }

        /**
         * API name: {@code load_stored_fields_count}
         */
        @Nonnull
        public final Builder loadStoredFieldsCount(@Nullable Long value) {
            this.loadStoredFieldsCount = value;
            return this;
        }

        /**
         * API name: {@code process}
         */
        @Nonnull
        public final Builder process(@Nullable Long value) {
            this.process = value;
            return this;
        }

        /**
         * API name: {@code process_count}
         */
        @Nonnull
        public final Builder processCount(@Nullable Long value) {
            this.processCount = value;
            return this;
        }

        /**
         * API name: {@code set_next_reader}
         */
        @Nonnull
        public final Builder setNextReader(@Nullable Long value) {
            this.setNextReader = value;
            return this;
        }

        /**
         * API name: {@code set_next_reader_count}
         */
        @Nonnull
        public final Builder setNextReaderCount(@Nullable Long value) {
            this.setNextReaderCount = value;
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
        op.add(Builder::buildSubPhaseProcessors, JsonpDeserializer.longDeserializer(), "build_sub_phase_processors");
        op.add(Builder::buildSubPhaseProcessorsCount, JsonpDeserializer.longDeserializer(), "build_sub_phase_processors_count");
        op.add(Builder::createStoredFieldsVisitor, JsonpDeserializer.longDeserializer(), "create_stored_fields_visitor");
        op.add(Builder::createStoredFieldsVisitorCount, JsonpDeserializer.longDeserializer(), "create_stored_fields_visitor_count");
        op.add(Builder::getNextReader, JsonpDeserializer.longDeserializer(), "get_next_reader");
        op.add(Builder::getNextReaderCount, JsonpDeserializer.longDeserializer(), "get_next_reader_count");
        op.add(Builder::loadSource, JsonpDeserializer.longDeserializer(), "load_source");
        op.add(Builder::loadSourceCount, JsonpDeserializer.longDeserializer(), "load_source_count");
        op.add(Builder::loadStoredFields, JsonpDeserializer.longDeserializer(), "load_stored_fields");
        op.add(Builder::loadStoredFieldsCount, JsonpDeserializer.longDeserializer(), "load_stored_fields_count");
        op.add(Builder::process, JsonpDeserializer.longDeserializer(), "process");
        op.add(Builder::processCount, JsonpDeserializer.longDeserializer(), "process_count");
        op.add(Builder::setNextReader, JsonpDeserializer.longDeserializer(), "set_next_reader");
        op.add(Builder::setNextReaderCount, JsonpDeserializer.longDeserializer(), "set_next_reader_count");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.buildSubPhaseProcessors);
        result = 31 * result + Objects.hashCode(this.buildSubPhaseProcessorsCount);
        result = 31 * result + Objects.hashCode(this.createStoredFieldsVisitor);
        result = 31 * result + Objects.hashCode(this.createStoredFieldsVisitorCount);
        result = 31 * result + Objects.hashCode(this.getNextReader);
        result = 31 * result + Objects.hashCode(this.getNextReaderCount);
        result = 31 * result + Objects.hashCode(this.loadSource);
        result = 31 * result + Objects.hashCode(this.loadSourceCount);
        result = 31 * result + Objects.hashCode(this.loadStoredFields);
        result = 31 * result + Objects.hashCode(this.loadStoredFieldsCount);
        result = 31 * result + Objects.hashCode(this.process);
        result = 31 * result + Objects.hashCode(this.processCount);
        result = 31 * result + Objects.hashCode(this.setNextReader);
        result = 31 * result + Objects.hashCode(this.setNextReaderCount);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        FetchProfileBreakdown other = (FetchProfileBreakdown) o;
        return Objects.equals(this.buildSubPhaseProcessors, other.buildSubPhaseProcessors)
            && Objects.equals(this.buildSubPhaseProcessorsCount, other.buildSubPhaseProcessorsCount)
            && Objects.equals(this.createStoredFieldsVisitor, other.createStoredFieldsVisitor)
            && Objects.equals(this.createStoredFieldsVisitorCount, other.createStoredFieldsVisitorCount)
            && Objects.equals(this.getNextReader, other.getNextReader)
            && Objects.equals(this.getNextReaderCount, other.getNextReaderCount)
            && Objects.equals(this.loadSource, other.loadSource)
            && Objects.equals(this.loadSourceCount, other.loadSourceCount)
            && Objects.equals(this.loadStoredFields, other.loadStoredFields)
            && Objects.equals(this.loadStoredFieldsCount, other.loadStoredFieldsCount)
            && Objects.equals(this.process, other.process)
            && Objects.equals(this.processCount, other.processCount)
            && Objects.equals(this.setNextReader, other.setNextReader)
            && Objects.equals(this.setNextReaderCount, other.setNextReaderCount);
    }
}
