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
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
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

// typedef: _global.delete_pit.Request

/**
 * Deletes one or more point in time searches based on the IDs passed.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public final class DeletePitRequest extends RequestBase
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<DeletePitRequest.Builder, DeletePitRequest> {

    @Nonnull
    private final List<String> pitId;

    // ---------------------------------------------------------------------------------------------

    private DeletePitRequest(Builder builder) {
        super(builder);
        this.pitId = ApiTypeHelper.unmodifiableRequired(builder.pitId, this, "pitId");
    }

    public static DeletePitRequest of(Function<DeletePitRequest.Builder, ObjectBuilder<DeletePitRequest>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - API name: {@code pit_id}
     */
    @Nonnull
    public final List<String> pitId() {
        return this.pitId;
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
        generator.writeKey("pit_id");
        generator.writeStartArray();
        for (String item0 : this.pitId) {
            generator.write(item0);
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
     * Builder for {@link DeletePitRequest}.
     */
    public static class Builder extends RequestBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, DeletePitRequest> {
        private List<String> pitId;

        public Builder() {}

        private Builder(DeletePitRequest o) {
            super(o);
            this.pitId = _listCopy(o.pitId);
        }

        private Builder(Builder o) {
            super(o);
            this.pitId = _listCopy(o.pitId);
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
         * Required - API name: {@code pit_id}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>pitId</code>.
         * </p>
         */
        @Nonnull
        public final Builder pitId(List<String> list) {
            this.pitId = _listAddAll(this.pitId, list);
            return this;
        }

        /**
         * Required - API name: {@code pit_id}
         *
         * <p>
         * Adds one or more values to <code>pitId</code>.
         * </p>
         */
        @Nonnull
        public final Builder pitId(String value, String... values) {
            this.pitId = _listAdd(this.pitId, value, values);
            return this;
        }

        /**
         * Builds a {@link DeletePitRequest}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public DeletePitRequest build() {
            _checkSingleUse();

            return new DeletePitRequest(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link DeletePitRequest}
     */
    public static final JsonpDeserializer<DeletePitRequest> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        DeletePitRequest::setupDeletePitRequestDeserializer
    );

    protected static void setupDeletePitRequestDeserializer(ObjectDeserializer<DeletePitRequest.Builder> op) {
        op.add(Builder::pitId, JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()), "pit_id");
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Endpoint "{@code delete_pit}".
     */
    public static final Endpoint<DeletePitRequest, DeletePitResponse, ErrorResponse> _ENDPOINT = new SimpleEndpoint<>(
        // Request method
        request -> "DELETE",
        // Request path
        request -> "/_search/point_in_time",
        // Request parameters
        request -> {
            Map<String, String> params = new HashMap<>();
            request.applyQueryParameters(params);
            return params;
        },
        SimpleEndpoint.emptyMap(),
        true,
        DeletePitResponse._DESERIALIZER
    );

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.pitId.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        DeletePitRequest other = (DeletePitRequest) o;
        return this.pitId.equals(other.pitId);
    }
}
