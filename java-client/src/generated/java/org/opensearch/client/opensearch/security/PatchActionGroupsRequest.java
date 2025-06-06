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

package org.opensearch.client.opensearch.security;

import jakarta.json.stream.JsonGenerator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
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

// typedef: security.patch_action_groups.Request

/**
 * Creates, updates, or deletes multiple action groups in a single request.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public final class PatchActionGroupsRequest extends RequestBase
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<PatchActionGroupsRequest.Builder, PatchActionGroupsRequest> {

    @Nonnull
    private final List<PatchOperation> operations;

    // ---------------------------------------------------------------------------------------------

    private PatchActionGroupsRequest(Builder builder) {
        super(builder);
        this.operations = ApiTypeHelper.unmodifiableRequired(builder.operations, this, "operations");
    }

    public static PatchActionGroupsRequest of(Function<PatchActionGroupsRequest.Builder, ObjectBuilder<PatchActionGroupsRequest>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - Request body.
     */
    @Nonnull
    public final List<PatchOperation> operations() {
        return this.operations;
    }

    /**
     * Serialize this value to JSON.
     */
    @Override
    public void serialize(JsonGenerator generator, JsonpMapper mapper) {
        generator.writeStartArray();
        for (PatchOperation item0 : this.operations) {
            item0.serialize(generator, mapper);
        }
        generator.writeEnd();
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
     * Builder for {@link PatchActionGroupsRequest}.
     */
    public static class Builder extends RequestBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, PatchActionGroupsRequest> {
        private List<PatchOperation> operations;

        public Builder() {}

        private Builder(PatchActionGroupsRequest o) {
            super(o);
            this.operations = _listCopy(o.operations);
        }

        private Builder(Builder o) {
            super(o);
            this.operations = _listCopy(o.operations);
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
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>operations</code>.
         * </p>
         */
        @Nonnull
        public final Builder operations(List<PatchOperation> list) {
            this.operations = _listAddAll(this.operations, list);
            return this;
        }

        /**
         * Required - Request body.
         *
         * <p>
         * Adds one or more values to <code>operations</code>.
         * </p>
         */
        @Nonnull
        public final Builder operations(PatchOperation value, PatchOperation... values) {
            this.operations = _listAdd(this.operations, value, values);
            return this;
        }

        /**
         * Required - Request body.
         *
         * <p>
         * Adds a value to <code>operations</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder operations(Function<PatchOperation.Builder, ObjectBuilder<PatchOperation>> fn) {
            return operations(fn.apply(new PatchOperation.Builder()).build());
        }

        /**
         * Builds a {@link PatchActionGroupsRequest}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public PatchActionGroupsRequest build() {
            _checkSingleUse();

            return new PatchActionGroupsRequest(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    public static final JsonpDeserializer<PatchActionGroupsRequest> _DESERIALIZER = createPatchActionGroupsRequestDeserializer();

    protected static JsonpDeserializer<PatchActionGroupsRequest> createPatchActionGroupsRequestDeserializer() {
        JsonpDeserializer<List<PatchOperation>> valueDeserializer = JsonpDeserializer.arrayDeserializer(PatchOperation._DESERIALIZER);
        return JsonpDeserializer.of(
            valueDeserializer.acceptedEvents(),
            (parser, mapper) -> new Builder().operations(valueDeserializer.deserialize(parser, mapper)).build()
        );
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Endpoint "{@code security.patch_action_groups}".
     */
    public static final Endpoint<PatchActionGroupsRequest, PatchActionGroupsResponse, ErrorResponse> _ENDPOINT = new SimpleEndpoint<>(
        // Request method
        request -> "PATCH",
        // Request path
        request -> "/_plugins/_security/api/actiongroups",
        // Request parameters
        request -> {
            Map<String, String> params = new HashMap<>();
            request.applyQueryParameters(params);
            return params;
        },
        SimpleEndpoint.emptyMap(),
        true,
        PatchActionGroupsResponse._DESERIALIZER
    );

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.operations.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        PatchActionGroupsRequest other = (PatchActionGroupsRequest) o;
        return this.operations.equals(other.operations);
    }
}
