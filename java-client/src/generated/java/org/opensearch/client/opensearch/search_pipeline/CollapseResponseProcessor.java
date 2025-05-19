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

// typedef: search_pipeline.CollapseResponseProcessor

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class CollapseResponseProcessor
    implements
        ResponseProcessorVariant,
        PlainJsonSerializable,
        ToCopyableBuilder<CollapseResponseProcessor.Builder, CollapseResponseProcessor> {

    @Nullable
    private final String contextPrefix;

    @Nullable
    private final String description;

    @Nonnull
    private final String field;

    @Nullable
    private final Boolean ignoreFailure;

    @Nullable
    private final String tag;

    // ---------------------------------------------------------------------------------------------

    private CollapseResponseProcessor(Builder builder) {
        this.contextPrefix = builder.contextPrefix;
        this.description = builder.description;
        this.field = ApiTypeHelper.requireNonNull(builder.field, this, "field");
        this.ignoreFailure = builder.ignoreFailure;
        this.tag = builder.tag;
    }

    public static CollapseResponseProcessor of(Function<CollapseResponseProcessor.Builder, ObjectBuilder<CollapseResponseProcessor>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * {@link ResponseProcessor} variant kind.
     */
    @Override
    public ResponseProcessor.Kind _responseProcessorKind() {
        return ResponseProcessor.Kind.Collapse;
    }

    /**
     * API name: {@code context_prefix}
     */
    @Nullable
    public final String contextPrefix() {
        return this.contextPrefix;
    }

    /**
     * API name: {@code description}
     */
    @Nullable
    public final String description() {
        return this.description;
    }

    /**
     * Required - API name: {@code field}
     */
    @Nonnull
    public final String field() {
        return this.field;
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
        if (this.contextPrefix != null) {
            generator.writeKey("context_prefix");
            generator.write(this.contextPrefix);
        }

        if (this.description != null) {
            generator.writeKey("description");
            generator.write(this.description);
        }

        generator.writeKey("field");
        generator.write(this.field);

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
     * Builder for {@link CollapseResponseProcessor}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, CollapseResponseProcessor> {
        @Nullable
        private String contextPrefix;
        @Nullable
        private String description;
        private String field;
        @Nullable
        private Boolean ignoreFailure;
        @Nullable
        private String tag;

        public Builder() {}

        private Builder(CollapseResponseProcessor o) {
            this.contextPrefix = o.contextPrefix;
            this.description = o.description;
            this.field = o.field;
            this.ignoreFailure = o.ignoreFailure;
            this.tag = o.tag;
        }

        private Builder(Builder o) {
            this.contextPrefix = o.contextPrefix;
            this.description = o.description;
            this.field = o.field;
            this.ignoreFailure = o.ignoreFailure;
            this.tag = o.tag;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code context_prefix}
         */
        @Nonnull
        public final Builder contextPrefix(@Nullable String value) {
            this.contextPrefix = value;
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
         * Required - API name: {@code field}
         */
        @Nonnull
        public final Builder field(String value) {
            this.field = value;
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
         * Builds a {@link CollapseResponseProcessor}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public CollapseResponseProcessor build() {
            _checkSingleUse();

            return new CollapseResponseProcessor(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link CollapseResponseProcessor}
     */
    public static final JsonpDeserializer<CollapseResponseProcessor> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        CollapseResponseProcessor::setupCollapseResponseProcessorDeserializer
    );

    protected static void setupCollapseResponseProcessorDeserializer(ObjectDeserializer<CollapseResponseProcessor.Builder> op) {
        op.add(Builder::contextPrefix, JsonpDeserializer.stringDeserializer(), "context_prefix");
        op.add(Builder::description, JsonpDeserializer.stringDeserializer(), "description");
        op.add(Builder::field, JsonpDeserializer.stringDeserializer(), "field");
        op.add(Builder::ignoreFailure, JsonpDeserializer.booleanDeserializer(), "ignore_failure");
        op.add(Builder::tag, JsonpDeserializer.stringDeserializer(), "tag");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.contextPrefix);
        result = 31 * result + Objects.hashCode(this.description);
        result = 31 * result + this.field.hashCode();
        result = 31 * result + Objects.hashCode(this.ignoreFailure);
        result = 31 * result + Objects.hashCode(this.tag);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        CollapseResponseProcessor other = (CollapseResponseProcessor) o;
        return Objects.equals(this.contextPrefix, other.contextPrefix)
            && Objects.equals(this.description, other.description)
            && this.field.equals(other.field)
            && Objects.equals(this.ignoreFailure, other.ignoreFailure)
            && Objects.equals(this.tag, other.tag);
    }
}
