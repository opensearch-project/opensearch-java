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

// typedef: search_pipeline.RerankResponseProcessor

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class RerankResponseProcessor
    implements
        ResponseProcessorVariant,
        PlainJsonSerializable,
        ToCopyableBuilder<RerankResponseProcessor.Builder, RerankResponseProcessor> {

    @Nullable
    private final RerankContext context;

    @Nullable
    private final String description;

    @Nullable
    private final Boolean ignoreFailure;

    @Nullable
    private final MLOpenSearchReranker mlOpensearch;

    @Nullable
    private final String tag;

    // ---------------------------------------------------------------------------------------------

    private RerankResponseProcessor(Builder builder) {
        this.context = builder.context;
        this.description = builder.description;
        this.ignoreFailure = builder.ignoreFailure;
        this.mlOpensearch = builder.mlOpensearch;
        this.tag = builder.tag;
    }

    public static RerankResponseProcessor of(Function<RerankResponseProcessor.Builder, ObjectBuilder<RerankResponseProcessor>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * {@link ResponseProcessor} variant kind.
     */
    @Override
    public ResponseProcessor.Kind _responseProcessorKind() {
        return ResponseProcessor.Kind.Rerank;
    }

    /**
     * API name: {@code context}
     */
    @Nullable
    public final RerankContext context() {
        return this.context;
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
     * API name: {@code ml_opensearch}
     */
    @Nullable
    public final MLOpenSearchReranker mlOpensearch() {
        return this.mlOpensearch;
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
        if (this.context != null) {
            generator.writeKey("context");
            this.context.serialize(generator, mapper);
        }

        if (this.description != null) {
            generator.writeKey("description");
            generator.write(this.description);
        }

        if (this.ignoreFailure != null) {
            generator.writeKey("ignore_failure");
            generator.write(this.ignoreFailure);
        }

        if (this.mlOpensearch != null) {
            generator.writeKey("ml_opensearch");
            this.mlOpensearch.serialize(generator, mapper);
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
     * Builder for {@link RerankResponseProcessor}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, RerankResponseProcessor> {
        @Nullable
        private RerankContext context;
        @Nullable
        private String description;
        @Nullable
        private Boolean ignoreFailure;
        @Nullable
        private MLOpenSearchReranker mlOpensearch;
        @Nullable
        private String tag;

        public Builder() {}

        private Builder(RerankResponseProcessor o) {
            this.context = o.context;
            this.description = o.description;
            this.ignoreFailure = o.ignoreFailure;
            this.mlOpensearch = o.mlOpensearch;
            this.tag = o.tag;
        }

        private Builder(Builder o) {
            this.context = o.context;
            this.description = o.description;
            this.ignoreFailure = o.ignoreFailure;
            this.mlOpensearch = o.mlOpensearch;
            this.tag = o.tag;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code context}
         */
        @Nonnull
        public final Builder context(@Nullable RerankContext value) {
            this.context = value;
            return this;
        }

        /**
         * API name: {@code context}
         */
        @Nonnull
        public final Builder context(Function<RerankContext.Builder, ObjectBuilder<RerankContext>> fn) {
            return context(fn.apply(new RerankContext.Builder()).build());
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
         * API name: {@code ml_opensearch}
         */
        @Nonnull
        public final Builder mlOpensearch(@Nullable MLOpenSearchReranker value) {
            this.mlOpensearch = value;
            return this;
        }

        /**
         * API name: {@code ml_opensearch}
         */
        @Nonnull
        public final Builder mlOpensearch(Function<MLOpenSearchReranker.Builder, ObjectBuilder<MLOpenSearchReranker>> fn) {
            return mlOpensearch(fn.apply(new MLOpenSearchReranker.Builder()).build());
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
         * Builds a {@link RerankResponseProcessor}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public RerankResponseProcessor build() {
            _checkSingleUse();

            return new RerankResponseProcessor(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link RerankResponseProcessor}
     */
    public static final JsonpDeserializer<RerankResponseProcessor> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        RerankResponseProcessor::setupRerankResponseProcessorDeserializer
    );

    protected static void setupRerankResponseProcessorDeserializer(ObjectDeserializer<RerankResponseProcessor.Builder> op) {
        op.add(Builder::context, RerankContext._DESERIALIZER, "context");
        op.add(Builder::description, JsonpDeserializer.stringDeserializer(), "description");
        op.add(Builder::ignoreFailure, JsonpDeserializer.booleanDeserializer(), "ignore_failure");
        op.add(Builder::mlOpensearch, MLOpenSearchReranker._DESERIALIZER, "ml_opensearch");
        op.add(Builder::tag, JsonpDeserializer.stringDeserializer(), "tag");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.context);
        result = 31 * result + Objects.hashCode(this.description);
        result = 31 * result + Objects.hashCode(this.ignoreFailure);
        result = 31 * result + Objects.hashCode(this.mlOpensearch);
        result = 31 * result + Objects.hashCode(this.tag);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        RerankResponseProcessor other = (RerankResponseProcessor) o;
        return Objects.equals(this.context, other.context)
            && Objects.equals(this.description, other.description)
            && Objects.equals(this.ignoreFailure, other.ignoreFailure)
            && Objects.equals(this.mlOpensearch, other.mlOpensearch)
            && Objects.equals(this.tag, other.tag);
    }
}
