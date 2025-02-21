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

// typedef: search_pipeline.RetrievalAugmentedGenerationResponseProcessor

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class RetrievalAugmentedGenerationResponseProcessor
    implements
        ResponseProcessorVariant,
        PlainJsonSerializable,
        ToCopyableBuilder<RetrievalAugmentedGenerationResponseProcessor.Builder, RetrievalAugmentedGenerationResponseProcessor> {

    @Nonnull
    private final List<String> contextFieldList;

    @Nullable
    private final String description;

    @Nonnull
    private final String modelId;

    @Nullable
    private final String systemPrompt;

    @Nullable
    private final String tag;

    @Nullable
    private final String userInstructions;

    // ---------------------------------------------------------------------------------------------

    private RetrievalAugmentedGenerationResponseProcessor(Builder builder) {
        this.contextFieldList = ApiTypeHelper.unmodifiableRequired(builder.contextFieldList, this, "contextFieldList");
        this.description = builder.description;
        this.modelId = ApiTypeHelper.requireNonNull(builder.modelId, this, "modelId");
        this.systemPrompt = builder.systemPrompt;
        this.tag = builder.tag;
        this.userInstructions = builder.userInstructions;
    }

    public static RetrievalAugmentedGenerationResponseProcessor of(
        Function<RetrievalAugmentedGenerationResponseProcessor.Builder, ObjectBuilder<RetrievalAugmentedGenerationResponseProcessor>> fn
    ) {
        return fn.apply(new Builder()).build();
    }

    /**
     * {@link ResponseProcessor} variant kind.
     */
    @Override
    public ResponseProcessor.Kind _responseProcessorKind() {
        return ResponseProcessor.Kind.RetrievalAugmentedGeneration;
    }

    /**
     * Required - API name: {@code context_field_list}
     */
    @Nonnull
    public final List<String> contextFieldList() {
        return this.contextFieldList;
    }

    /**
     * API name: {@code description}
     */
    @Nullable
    public final String description() {
        return this.description;
    }

    /**
     * Required - API name: {@code model_id}
     */
    @Nonnull
    public final String modelId() {
        return this.modelId;
    }

    /**
     * API name: {@code system_prompt}
     */
    @Nullable
    public final String systemPrompt() {
        return this.systemPrompt;
    }

    /**
     * API name: {@code tag}
     */
    @Nullable
    public final String tag() {
        return this.tag;
    }

    /**
     * API name: {@code user_instructions}
     */
    @Nullable
    public final String userInstructions() {
        return this.userInstructions;
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
        generator.writeKey("context_field_list");
        generator.writeStartArray();
        for (String item0 : this.contextFieldList) {
            generator.write(item0);
        }
        generator.writeEnd();

        if (this.description != null) {
            generator.writeKey("description");
            generator.write(this.description);
        }

        generator.writeKey("model_id");
        generator.write(this.modelId);

        if (this.systemPrompt != null) {
            generator.writeKey("system_prompt");
            generator.write(this.systemPrompt);
        }

        if (this.tag != null) {
            generator.writeKey("tag");
            generator.write(this.tag);
        }

        if (this.userInstructions != null) {
            generator.writeKey("user_instructions");
            generator.write(this.userInstructions);
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
     * Builder for {@link RetrievalAugmentedGenerationResponseProcessor}.
     */
    public static class Builder extends ObjectBuilderBase
        implements
            CopyableBuilder<Builder, RetrievalAugmentedGenerationResponseProcessor> {
        private List<String> contextFieldList;
        @Nullable
        private String description;
        private String modelId;
        @Nullable
        private String systemPrompt;
        @Nullable
        private String tag;
        @Nullable
        private String userInstructions;

        public Builder() {}

        private Builder(RetrievalAugmentedGenerationResponseProcessor o) {
            this.contextFieldList = _listCopy(o.contextFieldList);
            this.description = o.description;
            this.modelId = o.modelId;
            this.systemPrompt = o.systemPrompt;
            this.tag = o.tag;
            this.userInstructions = o.userInstructions;
        }

        private Builder(Builder o) {
            this.contextFieldList = _listCopy(o.contextFieldList);
            this.description = o.description;
            this.modelId = o.modelId;
            this.systemPrompt = o.systemPrompt;
            this.tag = o.tag;
            this.userInstructions = o.userInstructions;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - API name: {@code context_field_list}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>contextFieldList</code>.
         * </p>
         */
        @Nonnull
        public final Builder contextFieldList(List<String> list) {
            this.contextFieldList = _listAddAll(this.contextFieldList, list);
            return this;
        }

        /**
         * Required - API name: {@code context_field_list}
         *
         * <p>
         * Adds one or more values to <code>contextFieldList</code>.
         * </p>
         */
        @Nonnull
        public final Builder contextFieldList(String value, String... values) {
            this.contextFieldList = _listAdd(this.contextFieldList, value, values);
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
         * Required - API name: {@code model_id}
         */
        @Nonnull
        public final Builder modelId(String value) {
            this.modelId = value;
            return this;
        }

        /**
         * API name: {@code system_prompt}
         */
        @Nonnull
        public final Builder systemPrompt(@Nullable String value) {
            this.systemPrompt = value;
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
         * API name: {@code user_instructions}
         */
        @Nonnull
        public final Builder userInstructions(@Nullable String value) {
            this.userInstructions = value;
            return this;
        }

        /**
         * Builds a {@link RetrievalAugmentedGenerationResponseProcessor}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public RetrievalAugmentedGenerationResponseProcessor build() {
            _checkSingleUse();

            return new RetrievalAugmentedGenerationResponseProcessor(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link RetrievalAugmentedGenerationResponseProcessor}
     */
    public static final JsonpDeserializer<RetrievalAugmentedGenerationResponseProcessor> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        RetrievalAugmentedGenerationResponseProcessor::setupRetrievalAugmentedGenerationResponseProcessorDeserializer
    );

    protected static void setupRetrievalAugmentedGenerationResponseProcessorDeserializer(
        ObjectDeserializer<RetrievalAugmentedGenerationResponseProcessor.Builder> op
    ) {
        op.add(
            Builder::contextFieldList,
            JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()),
            "context_field_list"
        );
        op.add(Builder::description, JsonpDeserializer.stringDeserializer(), "description");
        op.add(Builder::modelId, JsonpDeserializer.stringDeserializer(), "model_id");
        op.add(Builder::systemPrompt, JsonpDeserializer.stringDeserializer(), "system_prompt");
        op.add(Builder::tag, JsonpDeserializer.stringDeserializer(), "tag");
        op.add(Builder::userInstructions, JsonpDeserializer.stringDeserializer(), "user_instructions");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.contextFieldList.hashCode();
        result = 31 * result + Objects.hashCode(this.description);
        result = 31 * result + this.modelId.hashCode();
        result = 31 * result + Objects.hashCode(this.systemPrompt);
        result = 31 * result + Objects.hashCode(this.tag);
        result = 31 * result + Objects.hashCode(this.userInstructions);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        RetrievalAugmentedGenerationResponseProcessor other = (RetrievalAugmentedGenerationResponseProcessor) o;
        return this.contextFieldList.equals(other.contextFieldList)
            && Objects.equals(this.description, other.description)
            && this.modelId.equals(other.modelId)
            && Objects.equals(this.systemPrompt, other.systemPrompt)
            && Objects.equals(this.tag, other.tag)
            && Objects.equals(this.userInstructions, other.userInstructions);
    }
}
