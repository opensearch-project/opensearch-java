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

// typedef: search_pipeline.AgenticContextResponseProcessor

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class AgenticContextResponseProcessor
    implements
        ResponseProcessorVariant,
        PlainJsonSerializable,
        ToCopyableBuilder<AgenticContextResponseProcessor.Builder, AgenticContextResponseProcessor> {

    @Nullable
    private final Boolean agentStepsSummary;

    @Nullable
    private final String description;

    @Nullable
    private final Boolean dslQuery;

    @Nullable
    private final Boolean ignoreFailure;

    @Nullable
    private final String tag;

    // ---------------------------------------------------------------------------------------------

    private AgenticContextResponseProcessor(Builder builder) {
        this.agentStepsSummary = builder.agentStepsSummary;
        this.description = builder.description;
        this.dslQuery = builder.dslQuery;
        this.ignoreFailure = builder.ignoreFailure;
        this.tag = builder.tag;
    }

    public static AgenticContextResponseProcessor of(
        Function<AgenticContextResponseProcessor.Builder, ObjectBuilder<AgenticContextResponseProcessor>> fn
    ) {
        return fn.apply(new Builder()).build();
    }

    /**
     * {@link ResponseProcessor} variant kind.
     */
    @Override
    public ResponseProcessor.Kind _responseProcessorKind() {
        return ResponseProcessor.Kind.AgenticContext;
    }

    /**
     * Whether to include the agent's execution step summary in the response. Available for conversational agents only.
     * <p>
     * API name: {@code agent_steps_summary}
     * </p>
     */
    @Nullable
    public final Boolean agentStepsSummary() {
        return this.agentStepsSummary;
    }

    /**
     * API name: {@code description}
     */
    @Nullable
    public final String description() {
        return this.description;
    }

    /**
     * Whether to include the generated DSL query in the response. Available for both conversational and flow agents.
     * <p>
     * API name: {@code dsl_query}
     * </p>
     */
    @Nullable
    public final Boolean dslQuery() {
        return this.dslQuery;
    }

    /**
     * API name: {@code ignore_failure}
     */
    @Nullable
    public final Boolean ignoreFailure() {
        return this.ignoreFailure;
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
        if (this.agentStepsSummary != null) {
            generator.writeKey("agent_steps_summary");
            generator.write(this.agentStepsSummary);
        }

        if (this.description != null) {
            generator.writeKey("description");
            generator.write(this.description);
        }

        if (this.dslQuery != null) {
            generator.writeKey("dsl_query");
            generator.write(this.dslQuery);
        }

        if (this.ignoreFailure != null) {
            generator.writeKey("ignore_failure");
            generator.write(this.ignoreFailure);
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
     * Builder for {@link AgenticContextResponseProcessor}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, AgenticContextResponseProcessor> {
        @Nullable
        private Boolean agentStepsSummary;
        @Nullable
        private String description;
        @Nullable
        private Boolean dslQuery;
        @Nullable
        private Boolean ignoreFailure;
        @Nullable
        private String tag;

        public Builder() {}

        private Builder(AgenticContextResponseProcessor o) {
            this.agentStepsSummary = o.agentStepsSummary;
            this.description = o.description;
            this.dslQuery = o.dslQuery;
            this.ignoreFailure = o.ignoreFailure;
            this.tag = o.tag;
        }

        private Builder(Builder o) {
            this.agentStepsSummary = o.agentStepsSummary;
            this.description = o.description;
            this.dslQuery = o.dslQuery;
            this.ignoreFailure = o.ignoreFailure;
            this.tag = o.tag;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Whether to include the agent's execution step summary in the response. Available for conversational agents only.
         * <p>
         * API name: {@code agent_steps_summary}
         * </p>
         */
        @Nonnull
        public final Builder agentStepsSummary(@Nullable Boolean value) {
            this.agentStepsSummary = value;
            return this;
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
         * Whether to include the generated DSL query in the response. Available for both conversational and flow agents.
         * <p>
         * API name: {@code dsl_query}
         * </p>
         */
        @Nonnull
        public final Builder dslQuery(@Nullable Boolean value) {
            this.dslQuery = value;
            return this;
        }

        /**
         * API name: {@code ignore_failure}
         */
        @Nonnull
        public final Builder ignoreFailure(@Nullable Boolean value) {
            this.ignoreFailure = value;
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
         * Builds a {@link AgenticContextResponseProcessor}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public AgenticContextResponseProcessor build() {
            _checkSingleUse();

            return new AgenticContextResponseProcessor(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link AgenticContextResponseProcessor}
     */
    public static final JsonpDeserializer<AgenticContextResponseProcessor> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        AgenticContextResponseProcessor::setupAgenticContextResponseProcessorDeserializer
    );

    protected static void setupAgenticContextResponseProcessorDeserializer(ObjectDeserializer<AgenticContextResponseProcessor.Builder> op) {
        op.add(Builder::agentStepsSummary, JsonpDeserializer.booleanDeserializer(), "agent_steps_summary");
        op.add(Builder::description, JsonpDeserializer.stringDeserializer(), "description");
        op.add(Builder::dslQuery, JsonpDeserializer.booleanDeserializer(), "dsl_query");
        op.add(Builder::ignoreFailure, JsonpDeserializer.booleanDeserializer(), "ignore_failure");
        op.add(Builder::tag, JsonpDeserializer.stringDeserializer(), "tag");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.agentStepsSummary);
        result = 31 * result + Objects.hashCode(this.description);
        result = 31 * result + Objects.hashCode(this.dslQuery);
        result = 31 * result + Objects.hashCode(this.ignoreFailure);
        result = 31 * result + Objects.hashCode(this.tag);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        AgenticContextResponseProcessor other = (AgenticContextResponseProcessor) o;
        return Objects.equals(this.agentStepsSummary, other.agentStepsSummary)
            && Objects.equals(this.description, other.description)
            && Objects.equals(this.dslQuery, other.dslQuery)
            && Objects.equals(this.ignoreFailure, other.ignoreFailure)
            && Objects.equals(this.tag, other.tag);
    }
}
