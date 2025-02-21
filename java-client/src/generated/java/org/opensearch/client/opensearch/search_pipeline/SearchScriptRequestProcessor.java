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

// typedef: search_pipeline.SearchScriptRequestProcessor

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class SearchScriptRequestProcessor
    implements
        RequestProcessorVariant,
        PlainJsonSerializable,
        ToCopyableBuilder<SearchScriptRequestProcessor.Builder, SearchScriptRequestProcessor> {

    @Nullable
    private final String description;

    @Nullable
    private final Boolean ignoreFailure;

    @Nullable
    private final String lang;

    @Nonnull
    private final String source;

    @Nullable
    private final String tag;

    // ---------------------------------------------------------------------------------------------

    private SearchScriptRequestProcessor(Builder builder) {
        this.description = builder.description;
        this.ignoreFailure = builder.ignoreFailure;
        this.lang = builder.lang;
        this.source = ApiTypeHelper.requireNonNull(builder.source, this, "source");
        this.tag = builder.tag;
    }

    public static SearchScriptRequestProcessor of(
        Function<SearchScriptRequestProcessor.Builder, ObjectBuilder<SearchScriptRequestProcessor>> fn
    ) {
        return fn.apply(new Builder()).build();
    }

    /**
     * {@link RequestProcessor} variant kind.
     */
    @Override
    public RequestProcessor.Kind _requestProcessorKind() {
        return RequestProcessor.Kind.Script;
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
     * API name: {@code lang}
     */
    @Nullable
    public final String lang() {
        return this.lang;
    }

    /**
     * Required - API name: {@code source}
     */
    @Nonnull
    public final String source() {
        return this.source;
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
        if (this.description != null) {
            generator.writeKey("description");
            generator.write(this.description);
        }

        if (this.ignoreFailure != null) {
            generator.writeKey("ignore_failure");
            generator.write(this.ignoreFailure);
        }

        if (this.lang != null) {
            generator.writeKey("lang");
            generator.write(this.lang);
        }

        generator.writeKey("source");
        generator.write(this.source);

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
     * Builder for {@link SearchScriptRequestProcessor}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, SearchScriptRequestProcessor> {
        @Nullable
        private String description;
        @Nullable
        private Boolean ignoreFailure;
        @Nullable
        private String lang;
        private String source;
        @Nullable
        private String tag;

        public Builder() {}

        private Builder(SearchScriptRequestProcessor o) {
            this.description = o.description;
            this.ignoreFailure = o.ignoreFailure;
            this.lang = o.lang;
            this.source = o.source;
            this.tag = o.tag;
        }

        private Builder(Builder o) {
            this.description = o.description;
            this.ignoreFailure = o.ignoreFailure;
            this.lang = o.lang;
            this.source = o.source;
            this.tag = o.tag;
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
         * API name: {@code ignore_failure}
         */
        @Nonnull
        public final Builder ignoreFailure(@Nullable Boolean value) {
            this.ignoreFailure = value;
            return this;
        }

        /**
         * API name: {@code lang}
         */
        @Nonnull
        public final Builder lang(@Nullable String value) {
            this.lang = value;
            return this;
        }

        /**
         * Required - API name: {@code source}
         */
        @Nonnull
        public final Builder source(String value) {
            this.source = value;
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
         * Builds a {@link SearchScriptRequestProcessor}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public SearchScriptRequestProcessor build() {
            _checkSingleUse();

            return new SearchScriptRequestProcessor(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link SearchScriptRequestProcessor}
     */
    public static final JsonpDeserializer<SearchScriptRequestProcessor> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        SearchScriptRequestProcessor::setupSearchScriptRequestProcessorDeserializer
    );

    protected static void setupSearchScriptRequestProcessorDeserializer(ObjectDeserializer<SearchScriptRequestProcessor.Builder> op) {
        op.add(Builder::description, JsonpDeserializer.stringDeserializer(), "description");
        op.add(Builder::ignoreFailure, JsonpDeserializer.booleanDeserializer(), "ignore_failure");
        op.add(Builder::lang, JsonpDeserializer.stringDeserializer(), "lang");
        op.add(Builder::source, JsonpDeserializer.stringDeserializer(), "source");
        op.add(Builder::tag, JsonpDeserializer.stringDeserializer(), "tag");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.description);
        result = 31 * result + Objects.hashCode(this.ignoreFailure);
        result = 31 * result + Objects.hashCode(this.lang);
        result = 31 * result + this.source.hashCode();
        result = 31 * result + Objects.hashCode(this.tag);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        SearchScriptRequestProcessor other = (SearchScriptRequestProcessor) o;
        return Objects.equals(this.description, other.description)
            && Objects.equals(this.ignoreFailure, other.ignoreFailure)
            && Objects.equals(this.lang, other.lang)
            && this.source.equals(other.source)
            && Objects.equals(this.tag, other.tag);
    }
}
