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

package org.opensearch.client.opensearch.search_pipeline;

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
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: search_pipeline.SearchPipelineStructure

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class SearchPipelineStructure
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<SearchPipelineStructure.Builder, SearchPipelineStructure> {

    @Nullable
    private final String description;

    @Nonnull
    private final List<PhaseResultsProcessor> phaseResultsProcessors;

    @Nonnull
    private final List<RequestProcessor> requestProcessors;

    @Nonnull
    private final List<ResponseProcessor> responseProcessors;

    @Nullable
    private final Integer version;

    // ---------------------------------------------------------------------------------------------

    private SearchPipelineStructure(Builder builder) {
        this.description = builder.description;
        this.phaseResultsProcessors = ApiTypeHelper.unmodifiable(builder.phaseResultsProcessors);
        this.requestProcessors = ApiTypeHelper.unmodifiable(builder.requestProcessors);
        this.responseProcessors = ApiTypeHelper.unmodifiable(builder.responseProcessors);
        this.version = builder.version;
    }

    public static SearchPipelineStructure of(Function<SearchPipelineStructure.Builder, ObjectBuilder<SearchPipelineStructure>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code description}
     */
    @Nullable
    public final String description() {
        return this.description;
    }

    /**
     * API name: {@code phase_results_processors}
     */
    @Nonnull
    public final List<PhaseResultsProcessor> phaseResultsProcessors() {
        return this.phaseResultsProcessors;
    }

    /**
     * API name: {@code request_processors}
     */
    @Nonnull
    public final List<RequestProcessor> requestProcessors() {
        return this.requestProcessors;
    }

    /**
     * API name: {@code response_processors}
     */
    @Nonnull
    public final List<ResponseProcessor> responseProcessors() {
        return this.responseProcessors;
    }

    /**
     * API name: {@code version}
     */
    @Nullable
    public final Integer version() {
        return this.version;
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
        if (this.description != null) {
            generator.writeKey("description");
            generator.write(this.description);
        }

        if (ApiTypeHelper.isDefined(this.phaseResultsProcessors)) {
            generator.writeKey("phase_results_processors");
            generator.writeStartArray();
            for (PhaseResultsProcessor item0 : this.phaseResultsProcessors) {
                item0.serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        if (ApiTypeHelper.isDefined(this.requestProcessors)) {
            generator.writeKey("request_processors");
            generator.writeStartArray();
            for (RequestProcessor item0 : this.requestProcessors) {
                item0.serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        if (ApiTypeHelper.isDefined(this.responseProcessors)) {
            generator.writeKey("response_processors");
            generator.writeStartArray();
            for (ResponseProcessor item0 : this.responseProcessors) {
                item0.serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        if (this.version != null) {
            generator.writeKey("version");
            generator.write(this.version);
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
     * Builder for {@link SearchPipelineStructure}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, SearchPipelineStructure> {
        @Nullable
        private String description;
        @Nullable
        private List<PhaseResultsProcessor> phaseResultsProcessors;
        @Nullable
        private List<RequestProcessor> requestProcessors;
        @Nullable
        private List<ResponseProcessor> responseProcessors;
        @Nullable
        private Integer version;

        public Builder() {}

        private Builder(SearchPipelineStructure o) {
            this.description = o.description;
            this.phaseResultsProcessors = _listCopy(o.phaseResultsProcessors);
            this.requestProcessors = _listCopy(o.requestProcessors);
            this.responseProcessors = _listCopy(o.responseProcessors);
            this.version = o.version;
        }

        private Builder(Builder o) {
            this.description = o.description;
            this.phaseResultsProcessors = _listCopy(o.phaseResultsProcessors);
            this.requestProcessors = _listCopy(o.requestProcessors);
            this.responseProcessors = _listCopy(o.responseProcessors);
            this.version = o.version;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code description}
         */
        @Nonnull
        public final Builder description(@Nullable String value) {
            this.description = value;
            return this;
        }

        /**
         * API name: {@code phase_results_processors}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>phaseResultsProcessors</code>.
         * </p>
         */
        @Nonnull
        public final Builder phaseResultsProcessors(List<PhaseResultsProcessor> list) {
            this.phaseResultsProcessors = _listAddAll(this.phaseResultsProcessors, list);
            return this;
        }

        /**
         * API name: {@code phase_results_processors}
         *
         * <p>
         * Adds one or more values to <code>phaseResultsProcessors</code>.
         * </p>
         */
        @Nonnull
        public final Builder phaseResultsProcessors(PhaseResultsProcessor value, PhaseResultsProcessor... values) {
            this.phaseResultsProcessors = _listAdd(this.phaseResultsProcessors, value, values);
            return this;
        }

        /**
         * API name: {@code phase_results_processors}
         *
         * <p>
         * Adds a value to <code>phaseResultsProcessors</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder phaseResultsProcessors(Function<PhaseResultsProcessor.Builder, ObjectBuilder<PhaseResultsProcessor>> fn) {
            return phaseResultsProcessors(fn.apply(new PhaseResultsProcessor.Builder()).build());
        }

        /**
         * API name: {@code request_processors}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>requestProcessors</code>.
         * </p>
         */
        @Nonnull
        public final Builder requestProcessors(List<RequestProcessor> list) {
            this.requestProcessors = _listAddAll(this.requestProcessors, list);
            return this;
        }

        /**
         * API name: {@code request_processors}
         *
         * <p>
         * Adds one or more values to <code>requestProcessors</code>.
         * </p>
         */
        @Nonnull
        public final Builder requestProcessors(RequestProcessor value, RequestProcessor... values) {
            this.requestProcessors = _listAdd(this.requestProcessors, value, values);
            return this;
        }

        /**
         * API name: {@code request_processors}
         *
         * <p>
         * Adds a value to <code>requestProcessors</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder requestProcessors(Function<RequestProcessor.Builder, ObjectBuilder<RequestProcessor>> fn) {
            return requestProcessors(fn.apply(new RequestProcessor.Builder()).build());
        }

        /**
         * API name: {@code response_processors}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>responseProcessors</code>.
         * </p>
         */
        @Nonnull
        public final Builder responseProcessors(List<ResponseProcessor> list) {
            this.responseProcessors = _listAddAll(this.responseProcessors, list);
            return this;
        }

        /**
         * API name: {@code response_processors}
         *
         * <p>
         * Adds one or more values to <code>responseProcessors</code>.
         * </p>
         */
        @Nonnull
        public final Builder responseProcessors(ResponseProcessor value, ResponseProcessor... values) {
            this.responseProcessors = _listAdd(this.responseProcessors, value, values);
            return this;
        }

        /**
         * API name: {@code response_processors}
         *
         * <p>
         * Adds a value to <code>responseProcessors</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder responseProcessors(Function<ResponseProcessor.Builder, ObjectBuilder<ResponseProcessor>> fn) {
            return responseProcessors(fn.apply(new ResponseProcessor.Builder()).build());
        }

        /**
         * API name: {@code version}
         */
        @Nonnull
        public final Builder version(@Nullable Integer value) {
            this.version = value;
            return this;
        }

        /**
         * Builds a {@link SearchPipelineStructure}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public SearchPipelineStructure build() {
            _checkSingleUse();

            return new SearchPipelineStructure(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link SearchPipelineStructure}
     */
    public static final JsonpDeserializer<SearchPipelineStructure> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        SearchPipelineStructure::setupSearchPipelineStructureDeserializer
    );

    protected static void setupSearchPipelineStructureDeserializer(ObjectDeserializer<SearchPipelineStructure.Builder> op) {
        op.add(Builder::description, JsonpDeserializer.stringDeserializer(), "description");
        op.add(
            Builder::phaseResultsProcessors,
            JsonpDeserializer.arrayDeserializer(PhaseResultsProcessor._DESERIALIZER),
            "phase_results_processors"
        );
        op.add(Builder::requestProcessors, JsonpDeserializer.arrayDeserializer(RequestProcessor._DESERIALIZER), "request_processors");
        op.add(Builder::responseProcessors, JsonpDeserializer.arrayDeserializer(ResponseProcessor._DESERIALIZER), "response_processors");
        op.add(Builder::version, JsonpDeserializer.integerDeserializer(), "version");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.description);
        result = 31 * result + Objects.hashCode(this.phaseResultsProcessors);
        result = 31 * result + Objects.hashCode(this.requestProcessors);
        result = 31 * result + Objects.hashCode(this.responseProcessors);
        result = 31 * result + Objects.hashCode(this.version);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        SearchPipelineStructure other = (SearchPipelineStructure) o;
        return Objects.equals(this.description, other.description)
            && Objects.equals(this.phaseResultsProcessors, other.phaseResultsProcessors)
            && Objects.equals(this.requestProcessors, other.requestProcessors)
            && Objects.equals(this.responseProcessors, other.responseProcessors)
            && Objects.equals(this.version, other.version);
    }
}
