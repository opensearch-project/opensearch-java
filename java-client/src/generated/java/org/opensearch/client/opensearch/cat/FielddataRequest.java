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

package org.opensearch.client.opensearch.cat;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.opensearch.client.opensearch._types.Bytes;
import org.opensearch.client.opensearch._types.ErrorResponse;
import org.opensearch.client.transport.Endpoint;
import org.opensearch.client.transport.endpoints.SimpleEndpoint;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: cat.fielddata.Request

/**
 * Shows how much heap memory is currently being used by field data on every data node in the cluster.
 */
@Generated("org.opensearch.client.codegen.CodeGenerator")
public final class FielddataRequest extends CatRequestBase implements ToCopyableBuilder<FielddataRequest.Builder, FielddataRequest> {

    @Nullable
    private final Bytes bytes;

    @Nonnull
    private final List<String> fields;

    // ---------------------------------------------------------------------------------------------

    private FielddataRequest(Builder builder) {
        super(builder);
        this.bytes = builder.bytes;
        this.fields = ApiTypeHelper.unmodifiable(builder.fields);
    }

    public static FielddataRequest of(Function<FielddataRequest.Builder, ObjectBuilder<FielddataRequest>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * The units used to display byte values.
     * <p>
     * API name: {@code bytes}
     * </p>
     */
    @Nullable
    public final Bytes bytes() {
        return this.bytes;
    }

    /**
     * A comma-separated list of fields used to limit the amount of returned information. To retrieve all fields, omit this parameter.
     * <p>
     * API name: {@code fields}
     * </p>
     */
    @Nonnull
    public final List<String> fields() {
        return this.fields;
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
     * Builder for {@link FielddataRequest}.
     */
    public static class Builder extends CatRequestBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, FielddataRequest> {
        @Nullable
        private Bytes bytes;
        @Nullable
        private List<String> fields;

        public Builder() {}

        private Builder(FielddataRequest o) {
            super(o);
            this.bytes = o.bytes;
            this.fields = _listCopy(o.fields);
        }

        private Builder(Builder o) {
            super(o);
            this.bytes = o.bytes;
            this.fields = _listCopy(o.fields);
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
         * The units used to display byte values.
         * <p>
         * API name: {@code bytes}
         * </p>
         */
        @Nonnull
        public final Builder bytes(@Nullable Bytes value) {
            this.bytes = value;
            return this;
        }

        /**
         * A comma-separated list of fields used to limit the amount of returned information. To retrieve all fields, omit this parameter.
         * <p>
         * API name: {@code fields}
         * </p>
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>fields</code>.
         * </p>
         */
        @Nonnull
        public final Builder fields(List<String> list) {
            this.fields = _listAddAll(this.fields, list);
            return this;
        }

        /**
         * A comma-separated list of fields used to limit the amount of returned information. To retrieve all fields, omit this parameter.
         * <p>
         * API name: {@code fields}
         * </p>
         *
         * <p>
         * Adds one or more values to <code>fields</code>.
         * </p>
         */
        @Nonnull
        public final Builder fields(String value, String... values) {
            this.fields = _listAdd(this.fields, value, values);
            return this;
        }

        /**
         * Builds a {@link FielddataRequest}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public FielddataRequest build() {
            _checkSingleUse();

            return new FielddataRequest(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    @Override
    protected void applyQueryParameters(@Nonnull Map<String, String> params) {
        super.applyQueryParameters(params);
        if (this.bytes != null) {
            params.put("bytes", this.bytes.jsonValue());
        }
    }

    /**
     * Endpoint "{@code cat.fielddata}".
     */
    public static final Endpoint<FielddataRequest, FielddataResponse, ErrorResponse> _ENDPOINT = new SimpleEndpoint<>(
        // Request method
        request -> "GET",
        // Request path
        request -> {
            final int _fields = 1 << 0;

            int propsSet = 0;

            if (ApiTypeHelper.isDefined(request.fields())) propsSet |= _fields;

            if (propsSet == 0) {
                return "/_cat/fielddata";
            }
            if (propsSet == (_fields)) {
                StringBuilder buf = new StringBuilder();
                buf.append("/_cat/fielddata/");
                SimpleEndpoint.pathEncode(String.join(",", request.fields), buf);
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
        false,
        FielddataResponse._DESERIALIZER
    );

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.bytes);
        result = 31 * result + Objects.hashCode(this.fields);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        FielddataRequest other = (FielddataRequest) o;
        return Objects.equals(this.bytes, other.bytes) && Objects.equals(this.fields, other.fields);
    }
}
