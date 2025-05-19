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

package org.opensearch.client.opensearch.ingest.simulate;

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
import org.opensearch.client.json.PlainJsonSerializable;
import org.opensearch.client.opensearch._types.ActionStatusOptions;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: ingest.simulate.PipelineSimulation

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class PipelineSimulation implements PlainJsonSerializable, ToCopyableBuilder<PipelineSimulation.Builder, PipelineSimulation> {

    @Nullable
    private final DocumentSimulation doc;

    @Nonnull
    private final List<PipelineSimulation> processorResults;

    @Nullable
    private final String processorType;

    @Nullable
    private final ActionStatusOptions status;

    @Nullable
    private final String tag;

    // ---------------------------------------------------------------------------------------------

    private PipelineSimulation(Builder builder) {
        this.doc = builder.doc;
        this.processorResults = ApiTypeHelper.unmodifiable(builder.processorResults);
        this.processorType = builder.processorType;
        this.status = builder.status;
        this.tag = builder.tag;
    }

    public static PipelineSimulation of(Function<PipelineSimulation.Builder, ObjectBuilder<PipelineSimulation>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code doc}
     */
    @Nullable
    public final DocumentSimulation doc() {
        return this.doc;
    }

    /**
     * API name: {@code processor_results}
     */
    @Nonnull
    public final List<PipelineSimulation> processorResults() {
        return this.processorResults;
    }

    /**
     * API name: {@code processor_type}
     */
    @Nullable
    public final String processorType() {
        return this.processorType;
    }

    /**
     * API name: {@code status}
     */
    @Nullable
    public final ActionStatusOptions status() {
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
        if (this.doc != null) {
            generator.writeKey("doc");
            this.doc.serialize(generator, mapper);
        }

        if (ApiTypeHelper.isDefined(this.processorResults)) {
            generator.writeKey("processor_results");
            generator.writeStartArray();
            for (PipelineSimulation item0 : this.processorResults) {
                item0.serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        if (this.processorType != null) {
            generator.writeKey("processor_type");
            generator.write(this.processorType);
        }

        if (this.status != null) {
            generator.writeKey("status");
            this.status.serialize(generator, mapper);
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
     * Builder for {@link PipelineSimulation}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, PipelineSimulation> {
        @Nullable
        private DocumentSimulation doc;
        @Nullable
        private List<PipelineSimulation> processorResults;
        @Nullable
        private String processorType;
        @Nullable
        private ActionStatusOptions status;
        @Nullable
        private String tag;

        public Builder() {}

        private Builder(PipelineSimulation o) {
            this.doc = o.doc;
            this.processorResults = _listCopy(o.processorResults);
            this.processorType = o.processorType;
            this.status = o.status;
            this.tag = o.tag;
        }

        private Builder(Builder o) {
            this.doc = o.doc;
            this.processorResults = _listCopy(o.processorResults);
            this.processorType = o.processorType;
            this.status = o.status;
            this.tag = o.tag;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code doc}
         */
        @Nonnull
        public final Builder doc(@Nullable DocumentSimulation value) {
            this.doc = value;
            return this;
        }

        /**
         * API name: {@code doc}
         */
        @Nonnull
        public final Builder doc(Function<DocumentSimulation.Builder, ObjectBuilder<DocumentSimulation>> fn) {
            return doc(fn.apply(new DocumentSimulation.Builder()).build());
        }

        /**
         * API name: {@code processor_results}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>processorResults</code>.
         * </p>
         */
        @Nonnull
        public final Builder processorResults(List<PipelineSimulation> list) {
            this.processorResults = _listAddAll(this.processorResults, list);
            return this;
        }

        /**
         * API name: {@code processor_results}
         *
         * <p>
         * Adds one or more values to <code>processorResults</code>.
         * </p>
         */
        @Nonnull
        public final Builder processorResults(PipelineSimulation value, PipelineSimulation... values) {
            this.processorResults = _listAdd(this.processorResults, value, values);
            return this;
        }

        /**
         * API name: {@code processor_results}
         *
         * <p>
         * Adds a value to <code>processorResults</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder processorResults(Function<PipelineSimulation.Builder, ObjectBuilder<PipelineSimulation>> fn) {
            return processorResults(fn.apply(new PipelineSimulation.Builder()).build());
        }

        /**
         * API name: {@code processor_type}
         */
        @Nonnull
        public final Builder processorType(@Nullable String value) {
            this.processorType = value;
            return this;
        }

        /**
         * API name: {@code status}
         */
        @Nonnull
        public final Builder status(@Nullable ActionStatusOptions value) {
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
         * Builds a {@link PipelineSimulation}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public PipelineSimulation build() {
            _checkSingleUse();

            return new PipelineSimulation(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link PipelineSimulation}
     */
    public static final JsonpDeserializer<PipelineSimulation> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        PipelineSimulation::setupPipelineSimulationDeserializer
    );

    protected static void setupPipelineSimulationDeserializer(ObjectDeserializer<PipelineSimulation.Builder> op) {
        op.add(Builder::doc, DocumentSimulation._DESERIALIZER, "doc");
        op.add(Builder::processorResults, JsonpDeserializer.arrayDeserializer(PipelineSimulation._DESERIALIZER), "processor_results");
        op.add(Builder::processorType, JsonpDeserializer.stringDeserializer(), "processor_type");
        op.add(Builder::status, ActionStatusOptions._DESERIALIZER, "status");
        op.add(Builder::tag, JsonpDeserializer.stringDeserializer(), "tag");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.doc);
        result = 31 * result + Objects.hashCode(this.processorResults);
        result = 31 * result + Objects.hashCode(this.processorType);
        result = 31 * result + Objects.hashCode(this.status);
        result = 31 * result + Objects.hashCode(this.tag);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        PipelineSimulation other = (PipelineSimulation) o;
        return Objects.equals(this.doc, other.doc)
            && Objects.equals(this.processorResults, other.processorResults)
            && Objects.equals(this.processorType, other.processorType)
            && Objects.equals(this.status, other.status)
            && Objects.equals(this.tag, other.tag);
    }
}
