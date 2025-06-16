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

package org.opensearch.client.opensearch.nodes.info;

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

// typedef: nodes.info.NodeInfoSearchPipelines

/**
 * The search pipeline configuration.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class NodeInfoSearchPipelines
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<NodeInfoSearchPipelines.Builder, NodeInfoSearchPipelines> {

    @Nonnull
    private final List<NodeInfoSearchPipelineProcessor> phaseResultsProcessors;

    @Nonnull
    private final List<NodeInfoSearchPipelineProcessor> requestProcessors;

    @Nonnull
    private final List<NodeInfoSearchPipelineProcessor> responseProcessors;

    // ---------------------------------------------------------------------------------------------

    private NodeInfoSearchPipelines(Builder builder) {
        this.phaseResultsProcessors = ApiTypeHelper.unmodifiable(builder.phaseResultsProcessors);
        this.requestProcessors = ApiTypeHelper.unmodifiable(builder.requestProcessors);
        this.responseProcessors = ApiTypeHelper.unmodifiable(builder.responseProcessors);
    }

    public static NodeInfoSearchPipelines of(Function<NodeInfoSearchPipelines.Builder, ObjectBuilder<NodeInfoSearchPipelines>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * The list of phase results processors in the pipeline.
     * <p>
     * API name: {@code phase_results_processors}
     * </p>
     */
    @Nonnull
    public final List<NodeInfoSearchPipelineProcessor> phaseResultsProcessors() {
        return this.phaseResultsProcessors;
    }

    /**
     * The list of request processors in the pipeline.
     * <p>
     * API name: {@code request_processors}
     * </p>
     */
    @Nonnull
    public final List<NodeInfoSearchPipelineProcessor> requestProcessors() {
        return this.requestProcessors;
    }

    /**
     * The list of response processors in the pipeline.
     * <p>
     * API name: {@code response_processors}
     * </p>
     */
    @Nonnull
    public final List<NodeInfoSearchPipelineProcessor> responseProcessors() {
        return this.responseProcessors;
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
        if (ApiTypeHelper.isDefined(this.phaseResultsProcessors)) {
            generator.writeKey("phase_results_processors");
            generator.writeStartArray();
            for (NodeInfoSearchPipelineProcessor item0 : this.phaseResultsProcessors) {
                item0.serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        if (ApiTypeHelper.isDefined(this.requestProcessors)) {
            generator.writeKey("request_processors");
            generator.writeStartArray();
            for (NodeInfoSearchPipelineProcessor item0 : this.requestProcessors) {
                item0.serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        if (ApiTypeHelper.isDefined(this.responseProcessors)) {
            generator.writeKey("response_processors");
            generator.writeStartArray();
            for (NodeInfoSearchPipelineProcessor item0 : this.responseProcessors) {
                item0.serialize(generator, mapper);
            }
            generator.writeEnd();
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
     * Builder for {@link NodeInfoSearchPipelines}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, NodeInfoSearchPipelines> {
        @Nullable
        private List<NodeInfoSearchPipelineProcessor> phaseResultsProcessors;
        @Nullable
        private List<NodeInfoSearchPipelineProcessor> requestProcessors;
        @Nullable
        private List<NodeInfoSearchPipelineProcessor> responseProcessors;

        public Builder() {}

        private Builder(NodeInfoSearchPipelines o) {
            this.phaseResultsProcessors = _listCopy(o.phaseResultsProcessors);
            this.requestProcessors = _listCopy(o.requestProcessors);
            this.responseProcessors = _listCopy(o.responseProcessors);
        }

        private Builder(Builder o) {
            this.phaseResultsProcessors = _listCopy(o.phaseResultsProcessors);
            this.requestProcessors = _listCopy(o.requestProcessors);
            this.responseProcessors = _listCopy(o.responseProcessors);
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * The list of phase results processors in the pipeline.
         * <p>
         * API name: {@code phase_results_processors}
         * </p>
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>phaseResultsProcessors</code>.
         * </p>
         */
        @Nonnull
        public final Builder phaseResultsProcessors(List<NodeInfoSearchPipelineProcessor> list) {
            this.phaseResultsProcessors = _listAddAll(this.phaseResultsProcessors, list);
            return this;
        }

        /**
         * The list of phase results processors in the pipeline.
         * <p>
         * API name: {@code phase_results_processors}
         * </p>
         *
         * <p>
         * Adds one or more values to <code>phaseResultsProcessors</code>.
         * </p>
         */
        @Nonnull
        public final Builder phaseResultsProcessors(NodeInfoSearchPipelineProcessor value, NodeInfoSearchPipelineProcessor... values) {
            this.phaseResultsProcessors = _listAdd(this.phaseResultsProcessors, value, values);
            return this;
        }

        /**
         * The list of phase results processors in the pipeline.
         * <p>
         * API name: {@code phase_results_processors}
         * </p>
         *
         * <p>
         * Adds a value to <code>phaseResultsProcessors</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder phaseResultsProcessors(
            Function<NodeInfoSearchPipelineProcessor.Builder, ObjectBuilder<NodeInfoSearchPipelineProcessor>> fn
        ) {
            return phaseResultsProcessors(fn.apply(new NodeInfoSearchPipelineProcessor.Builder()).build());
        }

        /**
         * The list of request processors in the pipeline.
         * <p>
         * API name: {@code request_processors}
         * </p>
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>requestProcessors</code>.
         * </p>
         */
        @Nonnull
        public final Builder requestProcessors(List<NodeInfoSearchPipelineProcessor> list) {
            this.requestProcessors = _listAddAll(this.requestProcessors, list);
            return this;
        }

        /**
         * The list of request processors in the pipeline.
         * <p>
         * API name: {@code request_processors}
         * </p>
         *
         * <p>
         * Adds one or more values to <code>requestProcessors</code>.
         * </p>
         */
        @Nonnull
        public final Builder requestProcessors(NodeInfoSearchPipelineProcessor value, NodeInfoSearchPipelineProcessor... values) {
            this.requestProcessors = _listAdd(this.requestProcessors, value, values);
            return this;
        }

        /**
         * The list of request processors in the pipeline.
         * <p>
         * API name: {@code request_processors}
         * </p>
         *
         * <p>
         * Adds a value to <code>requestProcessors</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder requestProcessors(
            Function<NodeInfoSearchPipelineProcessor.Builder, ObjectBuilder<NodeInfoSearchPipelineProcessor>> fn
        ) {
            return requestProcessors(fn.apply(new NodeInfoSearchPipelineProcessor.Builder()).build());
        }

        /**
         * The list of response processors in the pipeline.
         * <p>
         * API name: {@code response_processors}
         * </p>
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>responseProcessors</code>.
         * </p>
         */
        @Nonnull
        public final Builder responseProcessors(List<NodeInfoSearchPipelineProcessor> list) {
            this.responseProcessors = _listAddAll(this.responseProcessors, list);
            return this;
        }

        /**
         * The list of response processors in the pipeline.
         * <p>
         * API name: {@code response_processors}
         * </p>
         *
         * <p>
         * Adds one or more values to <code>responseProcessors</code>.
         * </p>
         */
        @Nonnull
        public final Builder responseProcessors(NodeInfoSearchPipelineProcessor value, NodeInfoSearchPipelineProcessor... values) {
            this.responseProcessors = _listAdd(this.responseProcessors, value, values);
            return this;
        }

        /**
         * The list of response processors in the pipeline.
         * <p>
         * API name: {@code response_processors}
         * </p>
         *
         * <p>
         * Adds a value to <code>responseProcessors</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder responseProcessors(
            Function<NodeInfoSearchPipelineProcessor.Builder, ObjectBuilder<NodeInfoSearchPipelineProcessor>> fn
        ) {
            return responseProcessors(fn.apply(new NodeInfoSearchPipelineProcessor.Builder()).build());
        }

        /**
         * Builds a {@link NodeInfoSearchPipelines}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public NodeInfoSearchPipelines build() {
            _checkSingleUse();

            return new NodeInfoSearchPipelines(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link NodeInfoSearchPipelines}
     */
    public static final JsonpDeserializer<NodeInfoSearchPipelines> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        NodeInfoSearchPipelines::setupNodeInfoSearchPipelinesDeserializer
    );

    protected static void setupNodeInfoSearchPipelinesDeserializer(ObjectDeserializer<NodeInfoSearchPipelines.Builder> op) {
        op.add(
            Builder::phaseResultsProcessors,
            JsonpDeserializer.arrayDeserializer(NodeInfoSearchPipelineProcessor._DESERIALIZER),
            "phase_results_processors"
        );
        op.add(
            Builder::requestProcessors,
            JsonpDeserializer.arrayDeserializer(NodeInfoSearchPipelineProcessor._DESERIALIZER),
            "request_processors"
        );
        op.add(
            Builder::responseProcessors,
            JsonpDeserializer.arrayDeserializer(NodeInfoSearchPipelineProcessor._DESERIALIZER),
            "response_processors"
        );
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.phaseResultsProcessors);
        result = 31 * result + Objects.hashCode(this.requestProcessors);
        result = 31 * result + Objects.hashCode(this.responseProcessors);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        NodeInfoSearchPipelines other = (NodeInfoSearchPipelines) o;
        return Objects.equals(this.phaseResultsProcessors, other.phaseResultsProcessors)
            && Objects.equals(this.requestProcessors, other.requestProcessors)
            && Objects.equals(this.responseProcessors, other.responseProcessors);
    }
}
