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

package org.opensearch.client.opensearch.core;

import jakarta.json.stream.JsonGenerator;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.opensearch.client.json.JsonData;
import org.opensearch.client.json.JsonpDeserializable;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.ObjectBuilderDeserializer;
import org.opensearch.client.json.ObjectDeserializer;
import org.opensearch.client.json.PlainJsonSerializable;
import org.opensearch.client.opensearch._types.ErrorResponse;
import org.opensearch.client.opensearch._types.RequestBase;
import org.opensearch.client.transport.Endpoint;
import org.opensearch.client.transport.endpoints.SimpleEndpoint;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: _global.render_search_template.Request

/**
 * Allows to use the Mustache language to pre-render a search definition.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public final class RenderSearchTemplateRequest extends RequestBase
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<RenderSearchTemplateRequest.Builder, RenderSearchTemplateRequest> {

    @Nullable
    private final String id;

    @Nonnull
    private final Map<String, JsonData> params;

    @Nullable
    private final String source;

    // ---------------------------------------------------------------------------------------------

    private RenderSearchTemplateRequest(Builder builder) {
        super(builder);
        this.id = builder.id;
        this.params = ApiTypeHelper.unmodifiable(builder.params);
        this.source = builder.source;
    }

    public static RenderSearchTemplateRequest of(
        Function<RenderSearchTemplateRequest.Builder, ObjectBuilder<RenderSearchTemplateRequest>> fn
    ) {
        return fn.apply(new Builder()).build();
    }

    /**
     * ID of the search template to render. If no <code>source</code> is specified, this or the <code>id</code> request body parameter is
     * required.
     * <p>
     * API name: {@code id}
     * </p>
     */
    @Nullable
    public final String id() {
        return this.id;
    }

    /**
     * Key-value pairs used to replace Mustache variables in the template. The key is the variable name. The value is the variable value.
     * <p>
     * API name: {@code params}
     * </p>
     */
    @Nonnull
    public final Map<String, JsonData> params() {
        return this.params;
    }

    /**
     * An inline search template. Supports the same parameters as the search API request body. These parameters also support Mustache
     * variables. If no <code>id</code> or <code>&lt;templated-id&gt;</code> is specified, this parameter is required.
     * <p>
     * API name: {@code source}
     * </p>
     */
    @Nullable
    public final String source() {
        return this.source;
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
        if (ApiTypeHelper.isDefined(this.params)) {
            generator.writeKey("params");
            generator.writeStartObject();
            for (Map.Entry<String, JsonData> item0 : this.params.entrySet()) {
                generator.writeKey(item0.getKey());
                item0.getValue().serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        if (this.source != null) {
            generator.writeKey("source");
            generator.write(this.source);
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
     * Builder for {@link RenderSearchTemplateRequest}.
     */
    public static class Builder extends RequestBase.AbstractBuilder<Builder>
        implements
            CopyableBuilder<Builder, RenderSearchTemplateRequest> {
        @Nullable
        private String id;
        @Nullable
        private Map<String, JsonData> params;
        @Nullable
        private String source;

        public Builder() {}

        private Builder(RenderSearchTemplateRequest o) {
            super(o);
            this.id = o.id;
            this.params = _mapCopy(o.params);
            this.source = o.source;
        }

        private Builder(Builder o) {
            super(o);
            this.id = o.id;
            this.params = _mapCopy(o.params);
            this.source = o.source;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        @Override
        @Nonnull
        protected Builder self() {
            return this;
        }

        /**
         * ID of the search template to render. If no <code>source</code> is specified, this or the <code>id</code> request body parameter
         * is required.
         * <p>
         * API name: {@code id}
         * </p>
         */
        @Nonnull
        public final Builder id(@Nullable String value) {
            this.id = value;
            return this;
        }

        /**
         * Key-value pairs used to replace Mustache variables in the template. The key is the variable name. The value is the variable
         * value.
         * <p>
         * API name: {@code params}
         * </p>
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>params</code>.
         * </p>
         */
        @Nonnull
        public final Builder params(Map<String, JsonData> map) {
            this.params = _mapPutAll(this.params, map);
            return this;
        }

        /**
         * Key-value pairs used to replace Mustache variables in the template. The key is the variable name. The value is the variable
         * value.
         * <p>
         * API name: {@code params}
         * </p>
         *
         * <p>
         * Adds an entry to <code>params</code>.
         * </p>
         */
        @Nonnull
        public final Builder params(String key, JsonData value) {
            this.params = _mapPut(this.params, key, value);
            return this;
        }

        /**
         * An inline search template. Supports the same parameters as the search API request body. These parameters also support Mustache
         * variables. If no <code>id</code> or <code>&lt;templated-id&gt;</code> is specified, this parameter is required.
         * <p>
         * API name: {@code source}
         * </p>
         */
        @Nonnull
        public final Builder source(@Nullable String value) {
            this.source = value;
            return this;
        }

        /**
         * Builds a {@link RenderSearchTemplateRequest}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public RenderSearchTemplateRequest build() {
            _checkSingleUse();

            return new RenderSearchTemplateRequest(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link RenderSearchTemplateRequest}
     */
    public static final JsonpDeserializer<RenderSearchTemplateRequest> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        RenderSearchTemplateRequest::setupRenderSearchTemplateRequestDeserializer
    );

    protected static void setupRenderSearchTemplateRequestDeserializer(ObjectDeserializer<RenderSearchTemplateRequest.Builder> op) {
        op.add(Builder::params, JsonpDeserializer.stringMapDeserializer(JsonData._DESERIALIZER), "params");
        op.add(Builder::source, JsonpDeserializer.stringDeserializer(), "source");
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Endpoint "{@code render_search_template}".
     */
    public static final Endpoint<RenderSearchTemplateRequest, RenderSearchTemplateResponse, ErrorResponse> _ENDPOINT = new SimpleEndpoint<>(
        // Request method
        request -> "POST",
        // Request path
        request -> {
            final int _id = 1 << 0;

            int propsSet = 0;

            if (request.id() != null) propsSet |= _id;

            if (propsSet == 0) {
                return "/_render/template";
            }
            if (propsSet == (_id)) {
                StringBuilder buf = new StringBuilder();
                buf.append("/_render/template/");
                SimpleEndpoint.pathEncode(request.id, buf);
                return buf.toString();
            }

            throw SimpleEndpoint.noPathTemplateFound("path");
        },
        // Request parameters
        request -> {
            Map<String, String> params = new HashMap<>();
            request.applyQueryParameters(params);
            return params;
        },
        SimpleEndpoint.emptyMap(),
        true,
        RenderSearchTemplateResponse._DESERIALIZER
    );

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.id);
        result = 31 * result + Objects.hashCode(this.params);
        result = 31 * result + Objects.hashCode(this.source);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        RenderSearchTemplateRequest other = (RenderSearchTemplateRequest) o;
        return Objects.equals(this.id, other.id) && Objects.equals(this.params, other.params) && Objects.equals(this.source, other.source);
    }
}
