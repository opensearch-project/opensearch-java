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
import org.opensearch.client.json.JsonData;
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

// typedef: core.search.ProcessorExecutionDetail

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class ProcessorExecutionDetail
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<ProcessorExecutionDetail.Builder, ProcessorExecutionDetail> {

    @Nullable
    private final Long durationMillis;

    @Nullable
    private final String error;

    @Nullable
    private final JsonData inputData;

    @Nullable
    private final JsonData outputData;

    @Nullable
    private final String processorName;

    @Nullable
    private final String status;

    @Nullable
    private final String tag;

    // ---------------------------------------------------------------------------------------------

    private ProcessorExecutionDetail(Builder builder) {
        this.durationMillis = builder.durationMillis;
        this.error = builder.error;
        this.inputData = builder.inputData;
        this.outputData = builder.outputData;
        this.processorName = builder.processorName;
        this.status = builder.status;
        this.tag = builder.tag;
    }

    public static ProcessorExecutionDetail of(Function<ProcessorExecutionDetail.Builder, ObjectBuilder<ProcessorExecutionDetail>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code duration_millis}
     */
    @Nullable
    public final Long durationMillis() {
        return this.durationMillis;
    }

    /**
     * API name: {@code error}
     */
    @Nullable
    public final String error() {
        return this.error;
    }

    /**
     * API name: {@code input_data}
     */
    @Nullable
    public final JsonData inputData() {
        return this.inputData;
    }

    /**
     * API name: {@code output_data}
     */
    @Nullable
    public final JsonData outputData() {
        return this.outputData;
    }

    /**
     * API name: {@code processor_name}
     */
    @Nullable
    public final String processorName() {
        return this.processorName;
    }

    /**
     * API name: {@code status}
     */
    @Nullable
    public final String status() {
        return this.status;
    }

    /**
     * API name: {@code tag}
     */
    @Nullable
    public final String tag() {
        return this.tag;
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
        if (this.durationMillis != null) {
            generator.writeKey("duration_millis");
            generator.write(this.durationMillis);
        }

        if (this.error != null) {
            generator.writeKey("error");
            generator.write(this.error);
        }

        if (this.inputData != null) {
            generator.writeKey("input_data");
            this.inputData.serialize(generator, mapper);
        }

        if (this.outputData != null) {
            generator.writeKey("output_data");
            this.outputData.serialize(generator, mapper);
        }

        if (this.processorName != null) {
            generator.writeKey("processor_name");
            generator.write(this.processorName);
        }

        if (this.status != null) {
            generator.writeKey("status");
            generator.write(this.status);
        }

        if (this.tag != null) {
            generator.writeKey("tag");
            generator.write(this.tag);
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
     * Builder for {@link ProcessorExecutionDetail}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, ProcessorExecutionDetail> {
        @Nullable
        private Long durationMillis;
        @Nullable
        private String error;
        @Nullable
        private JsonData inputData;
        @Nullable
        private JsonData outputData;
        @Nullable
        private String processorName;
        @Nullable
        private String status;
        @Nullable
        private String tag;

        public Builder() {}

        private Builder(ProcessorExecutionDetail o) {
            this.durationMillis = o.durationMillis;
            this.error = o.error;
            this.inputData = o.inputData;
            this.outputData = o.outputData;
            this.processorName = o.processorName;
            this.status = o.status;
            this.tag = o.tag;
        }

        private Builder(Builder o) {
            this.durationMillis = o.durationMillis;
            this.error = o.error;
            this.inputData = o.inputData;
            this.outputData = o.outputData;
            this.processorName = o.processorName;
            this.status = o.status;
            this.tag = o.tag;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code duration_millis}
         */
        @Nonnull
        public final Builder durationMillis(@Nullable Long value) {
            this.durationMillis = value;
            return this;
        }

        /**
         * API name: {@code error}
         */
        @Nonnull
        public final Builder error(@Nullable String value) {
            this.error = value;
            return this;
        }

        /**
         * API name: {@code input_data}
         */
        @Nonnull
        public final Builder inputData(@Nullable JsonData value) {
            this.inputData = value;
            return this;
        }

        /**
         * API name: {@code output_data}
         */
        @Nonnull
        public final Builder outputData(@Nullable JsonData value) {
            this.outputData = value;
            return this;
        }

        /**
         * API name: {@code processor_name}
         */
        @Nonnull
        public final Builder processorName(@Nullable String value) {
            this.processorName = value;
            return this;
        }

        /**
         * API name: {@code status}
         */
        @Nonnull
        public final Builder status(@Nullable String value) {
            this.status = value;
            return this;
        }

        /**
         * API name: {@code tag}
         */
        @Nonnull
        public final Builder tag(@Nullable String value) {
            this.tag = value;
            return this;
        }

        /**
         * Builds a {@link ProcessorExecutionDetail}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public ProcessorExecutionDetail build() {
            _checkSingleUse();

            return new ProcessorExecutionDetail(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link ProcessorExecutionDetail}
     */
    public static final JsonpDeserializer<ProcessorExecutionDetail> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        ProcessorExecutionDetail::setupProcessorExecutionDetailDeserializer
    );

    protected static void setupProcessorExecutionDetailDeserializer(ObjectDeserializer<ProcessorExecutionDetail.Builder> op) {
        op.add(Builder::durationMillis, JsonpDeserializer.longDeserializer(), "duration_millis");
        op.add(Builder::error, JsonpDeserializer.stringDeserializer(), "error");
        op.add(Builder::inputData, JsonData._DESERIALIZER, "input_data");
        op.add(Builder::outputData, JsonData._DESERIALIZER, "output_data");
        op.add(Builder::processorName, JsonpDeserializer.stringDeserializer(), "processor_name");
        op.add(Builder::status, JsonpDeserializer.stringDeserializer(), "status");
        op.add(Builder::tag, JsonpDeserializer.stringDeserializer(), "tag");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.durationMillis);
        result = 31 * result + Objects.hashCode(this.error);
        result = 31 * result + Objects.hashCode(this.inputData);
        result = 31 * result + Objects.hashCode(this.outputData);
        result = 31 * result + Objects.hashCode(this.processorName);
        result = 31 * result + Objects.hashCode(this.status);
        result = 31 * result + Objects.hashCode(this.tag);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        ProcessorExecutionDetail other = (ProcessorExecutionDetail) o;
        return Objects.equals(this.durationMillis, other.durationMillis)
            && Objects.equals(this.error, other.error)
            && Objects.equals(this.inputData, other.inputData)
            && Objects.equals(this.outputData, other.outputData)
            && Objects.equals(this.processorName, other.processorName)
            && Objects.equals(this.status, other.status)
            && Objects.equals(this.tag, other.tag);
    }
}
