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

// typedef: search_pipeline.OversampleRequestProcessor

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class OversampleRequestProcessor
    implements
        RequestProcessorVariant,
        PlainJsonSerializable,
        ToCopyableBuilder<OversampleRequestProcessor.Builder, OversampleRequestProcessor> {

    @Nullable
    private final String contentPrefix;

    @Nullable
    private final String description;

    @Nullable
    private final Boolean ignoreFailure;

    private final float sampleFactor;

    @Nullable
    private final String tag;

    // ---------------------------------------------------------------------------------------------

    private OversampleRequestProcessor(Builder builder) {
        this.contentPrefix = builder.contentPrefix;
        this.description = builder.description;
        this.ignoreFailure = builder.ignoreFailure;
        this.sampleFactor = ApiTypeHelper.requireNonNull(builder.sampleFactor, this, "sampleFactor");
        this.tag = builder.tag;
    }

    public static OversampleRequestProcessor of(
        Function<OversampleRequestProcessor.Builder, ObjectBuilder<OversampleRequestProcessor>> fn
    ) {
        return fn.apply(new Builder()).build();
    }

    /**
     * {@link RequestProcessor} variant kind.
     */
    @Override
    public RequestProcessor.Kind _requestProcessorKind() {
        return RequestProcessor.Kind.Oversample;
    }

    /**
     * API name: {@code content_prefix}
     */
    @Nullable
    public final String contentPrefix() {
        return this.contentPrefix;
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
     * Required - API name: {@code sample_factor}
     */
    public final float sampleFactor() {
        return this.sampleFactor;
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
        if (this.contentPrefix != null) {
            generator.writeKey("content_prefix");
            generator.write(this.contentPrefix);
        }

        if (this.description != null) {
            generator.writeKey("description");
            generator.write(this.description);
        }

        if (this.ignoreFailure != null) {
            generator.writeKey("ignore_failure");
            generator.write(this.ignoreFailure);
        }

        generator.writeKey("sample_factor");
        generator.write(this.sampleFactor);

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
     * Builder for {@link OversampleRequestProcessor}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, OversampleRequestProcessor> {
        @Nullable
        private String contentPrefix;
        @Nullable
        private String description;
        @Nullable
        private Boolean ignoreFailure;
        private Float sampleFactor;
        @Nullable
        private String tag;

        public Builder() {}

        private Builder(OversampleRequestProcessor o) {
            this.contentPrefix = o.contentPrefix;
            this.description = o.description;
            this.ignoreFailure = o.ignoreFailure;
            this.sampleFactor = o.sampleFactor;
            this.tag = o.tag;
        }

        private Builder(Builder o) {
            this.contentPrefix = o.contentPrefix;
            this.description = o.description;
            this.ignoreFailure = o.ignoreFailure;
            this.sampleFactor = o.sampleFactor;
            this.tag = o.tag;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code content_prefix}
         */
        @Nonnull
        public final Builder contentPrefix(@Nullable String value) {
            this.contentPrefix = value;
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
         * Required - API name: {@code sample_factor}
         */
        @Nonnull
        public final Builder sampleFactor(float value) {
            this.sampleFactor = value;
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
         * Builds a {@link OversampleRequestProcessor}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public OversampleRequestProcessor build() {
            _checkSingleUse();

            return new OversampleRequestProcessor(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link OversampleRequestProcessor}
     */
    public static final JsonpDeserializer<OversampleRequestProcessor> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        OversampleRequestProcessor::setupOversampleRequestProcessorDeserializer
    );

    protected static void setupOversampleRequestProcessorDeserializer(ObjectDeserializer<OversampleRequestProcessor.Builder> op) {
        op.add(Builder::contentPrefix, JsonpDeserializer.stringDeserializer(), "content_prefix");
        op.add(Builder::description, JsonpDeserializer.stringDeserializer(), "description");
        op.add(Builder::ignoreFailure, JsonpDeserializer.booleanDeserializer(), "ignore_failure");
        op.add(Builder::sampleFactor, JsonpDeserializer.floatDeserializer(), "sample_factor");
        op.add(Builder::tag, JsonpDeserializer.stringDeserializer(), "tag");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.contentPrefix);
        result = 31 * result + Objects.hashCode(this.description);
        result = 31 * result + Objects.hashCode(this.ignoreFailure);
        result = 31 * result + Float.hashCode(this.sampleFactor);
        result = 31 * result + Objects.hashCode(this.tag);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        OversampleRequestProcessor other = (OversampleRequestProcessor) o;
        return Objects.equals(this.contentPrefix, other.contentPrefix)
            && Objects.equals(this.description, other.description)
            && Objects.equals(this.ignoreFailure, other.ignoreFailure)
            && this.sampleFactor == other.sampleFactor
            && Objects.equals(this.tag, other.tag);
    }
}
