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

package org.opensearch.client.opensearch.ism;

import jakarta.json.stream.JsonGenerator;
import java.util.HashMap;
import java.util.List;
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
import org.opensearch.client.json.PlainJsonSerializable;
import org.opensearch.client.opensearch._types.ErrorResponse;
import org.opensearch.client.opensearch._types.RequestBase;
import org.opensearch.client.transport.Endpoint;
import org.opensearch.client.transport.endpoints.SimpleEndpoint;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: ism.explain_policy.Request

/**
 * Retrieves the currently applied policy on the specified indexes.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public final class ExplainPolicyRequest extends RequestBase
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<ExplainPolicyRequest.Builder, ExplainPolicyRequest> {

    @Nonnull
    private final JsonData body;

    @Nonnull
    private final List<String> index;

    // ---------------------------------------------------------------------------------------------

    private ExplainPolicyRequest(Builder builder) {
        super(builder);
        this.body = ApiTypeHelper.requireNonNull(builder.body, this, "body");
        this.index = ApiTypeHelper.unmodifiable(builder.index);
    }

    public static ExplainPolicyRequest of(Function<ExplainPolicyRequest.Builder, ObjectBuilder<ExplainPolicyRequest>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - Request body.
     */
    @Nonnull
    public final JsonData body() {
        return this.body;
    }

    /**
     * A comma-separated list of data streams, indexes, and aliases used to limit the request. Supports wildcards (<code>*</code>). To
     * target all data streams and indexes, omit this parameter or use <code>*</code> or <code>_all</code>.
     * <p>
     * API name: {@code index}
     * </p>
     */
    @Nonnull
    public final List<String> index() {
        return this.index;
    }

    /**
     * Serialize this value to JSON.
     */
    @Override
    public void serialize(JsonGenerator generator, JsonpMapper mapper) {
        this.body.serialize(generator, mapper);
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
     * Builder for {@link ExplainPolicyRequest}.
     */
    public static class Builder extends RequestBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, ExplainPolicyRequest> {
        private JsonData body;
        @Nullable
        private List<String> index;

        public Builder() {}

        private Builder(ExplainPolicyRequest o) {
            super(o);
            this.body = o.body;
            this.index = _listCopy(o.index);
        }

        private Builder(Builder o) {
            super(o);
            this.body = o.body;
            this.index = _listCopy(o.index);
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
         * Required - Request body.
         */
        @Nonnull
        public final Builder body(JsonData value) {
            this.body = value;
            return this;
        }

        /**
         * A comma-separated list of data streams, indexes, and aliases used to limit the request. Supports wildcards (<code>*</code>). To
         * target all data streams and indexes, omit this parameter or use <code>*</code> or <code>_all</code>.
         * <p>
         * API name: {@code index}
         * </p>
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>index</code>.
         * </p>
         */
        @Nonnull
        public final Builder index(List<String> list) {
            this.index = _listAddAll(this.index, list);
            return this;
        }

        /**
         * A comma-separated list of data streams, indexes, and aliases used to limit the request. Supports wildcards (<code>*</code>). To
         * target all data streams and indexes, omit this parameter or use <code>*</code> or <code>_all</code>.
         * <p>
         * API name: {@code index}
         * </p>
         *
         * <p>
         * Adds one or more values to <code>index</code>.
         * </p>
         */
        @Nonnull
        public final Builder index(String value, String... values) {
            this.index = _listAdd(this.index, value, values);
            return this;
        }

        /**
         * Builds a {@link ExplainPolicyRequest}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public ExplainPolicyRequest build() {
            _checkSingleUse();

            return new ExplainPolicyRequest(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    public static final JsonpDeserializer<ExplainPolicyRequest> _DESERIALIZER = createExplainPolicyRequestDeserializer();

    protected static JsonpDeserializer<ExplainPolicyRequest> createExplainPolicyRequestDeserializer() {
        JsonpDeserializer<JsonData> valueDeserializer = JsonData._DESERIALIZER;
        return JsonpDeserializer.of(
            valueDeserializer.acceptedEvents(),
            (parser, mapper) -> new Builder().body(valueDeserializer.deserialize(parser, mapper)).build()
        );
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Endpoint "{@code ism.explain_policy}".
     */
    public static final Endpoint<ExplainPolicyRequest, ExplainPolicyResponse, ErrorResponse> _ENDPOINT = new SimpleEndpoint<>(
        // Request method
        request -> "POST",
        // Request path
        request -> {
            final int _index = 1 << 0;

            int propsSet = 0;

            if (ApiTypeHelper.isDefined(request.index())) propsSet |= _index;

            if (propsSet == 0) {
                return "/_plugins/_ism/explain";
            }
            if (propsSet == (_index)) {
                StringBuilder buf = new StringBuilder();
                buf.append("/_plugins/_ism/explain/");
                SimpleEndpoint.pathEncode(String.join(",", request.index), buf);
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
        ExplainPolicyResponse._DESERIALIZER
    );

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.body.hashCode();
        result = 31 * result + Objects.hashCode(this.index);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        ExplainPolicyRequest other = (ExplainPolicyRequest) o;
        return this.body.equals(other.body) && Objects.equals(this.index, other.index);
    }
}
