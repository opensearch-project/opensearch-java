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
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: search_pipeline.AgenticQueryTranslatorRequestProcessor

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class AgenticQueryTranslatorRequestProcessor
    implements
        RequestProcessorVariant,
        PlainJsonSerializable,
        ToCopyableBuilder<AgenticQueryTranslatorRequestProcessor.Builder, AgenticQueryTranslatorRequestProcessor> {

    @Nonnull
    private final String agentId;

    @Nullable
    private final String description;

    @Nullable
    private final Boolean ignoreFailure;

    @Nullable
    private final String tag;

    // ---------------------------------------------------------------------------------------------

    private AgenticQueryTranslatorRequestProcessor(Builder builder) {
        this.agentId = ApiTypeHelper.requireNonNull(builder.agentId, this, "agentId");
        this.description = builder.description;
        this.ignoreFailure = builder.ignoreFailure;
        this.tag = builder.tag;
    }

    public static AgenticQueryTranslatorRequestProcessor of(
        Function<AgenticQueryTranslatorRequestProcessor.Builder, ObjectBuilder<AgenticQueryTranslatorRequestProcessor>> fn
    ) {
        return fn.apply(new Builder()).build();
    }

    /**
     * {@link RequestProcessor} variant kind.
     */
    @Override
    public RequestProcessor.Kind _requestProcessorKind() {
        return RequestProcessor.Kind.AgenticQueryTranslator;
    }

    /**
     * Required - The ID of the agent to use for query translation.
     * <p>
     * API name: {@code agent_id}
     * </p>
     */
    @Nonnull
    public final String agentId() {
        return this.agentId;
    }

    /**
     * API name: {@code description}
     */
    @Nullable
    public final String description() {
        return this.description;
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
        generator.writeKey("agent_id");
        generator.write(this.agentId);

        if (this.description != null) {
            generator.writeKey("description");
            generator.write(this.description);
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
     * Builder for {@link AgenticQueryTranslatorRequestProcessor}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, AgenticQueryTranslatorRequestProcessor> {
        private String agentId;
        @Nullable
        private String description;
        @Nullable
        private Boolean ignoreFailure;
        @Nullable
        private String tag;

        public Builder() {}

        private Builder(AgenticQueryTranslatorRequestProcessor o) {
            this.agentId = o.agentId;
            this.description = o.description;
            this.ignoreFailure = o.ignoreFailure;
            this.tag = o.tag;
        }

        private Builder(Builder o) {
            this.agentId = o.agentId;
            this.description = o.description;
            this.ignoreFailure = o.ignoreFailure;
            this.tag = o.tag;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - The ID of the agent to use for query translation.
         * <p>
         * API name: {@code agent_id}
         * </p>
         */
        @Nonnull
        public final Builder agentId(String value) {
            this.agentId = value;
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
         * Builds a {@link AgenticQueryTranslatorRequestProcessor}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public AgenticQueryTranslatorRequestProcessor build() {
            _checkSingleUse();

            return new AgenticQueryTranslatorRequestProcessor(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link AgenticQueryTranslatorRequestProcessor}
     */
    public static final JsonpDeserializer<AgenticQueryTranslatorRequestProcessor> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        AgenticQueryTranslatorRequestProcessor::setupAgenticQueryTranslatorRequestProcessorDeserializer
    );

    protected static void setupAgenticQueryTranslatorRequestProcessorDeserializer(
        ObjectDeserializer<AgenticQueryTranslatorRequestProcessor.Builder> op
    ) {
        op.add(Builder::agentId, JsonpDeserializer.stringDeserializer(), "agent_id");
        op.add(Builder::description, JsonpDeserializer.stringDeserializer(), "description");
        op.add(Builder::ignoreFailure, JsonpDeserializer.booleanDeserializer(), "ignore_failure");
        op.add(Builder::tag, JsonpDeserializer.stringDeserializer(), "tag");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.agentId.hashCode();
        result = 31 * result + Objects.hashCode(this.description);
        result = 31 * result + Objects.hashCode(this.ignoreFailure);
        result = 31 * result + Objects.hashCode(this.tag);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        AgenticQueryTranslatorRequestProcessor other = (AgenticQueryTranslatorRequestProcessor) o;
        return this.agentId.equals(other.agentId)
            && Objects.equals(this.description, other.description)
            && Objects.equals(this.ignoreFailure, other.ignoreFailure)
            && Objects.equals(this.tag, other.tag);
    }
}
