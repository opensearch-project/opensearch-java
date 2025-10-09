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

package org.opensearch.client.opensearch.search_relevance;

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

// typedef: search_relevance.put_experiments.Request

/**
 * Creates an experiment.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public final class PutExperimentsRequest extends RequestBase
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<PutExperimentsRequest.Builder, PutExperimentsRequest> {

    @Nonnull
    private final List<String> judgmentList;

    @Nullable
    private final String querySetId;

    @Nullable
    private final JsonData searchConfigurationList;

    @Nullable
    private final Integer size;

    @Nullable
    private final String type;

    // ---------------------------------------------------------------------------------------------

    private PutExperimentsRequest(Builder builder) {
        super(builder);
        this.judgmentList = ApiTypeHelper.unmodifiable(builder.judgmentList);
        this.querySetId = builder.querySetId;
        this.searchConfigurationList = builder.searchConfigurationList;
        this.size = builder.size;
        this.type = builder.type;
    }

    public static PutExperimentsRequest of(Function<PutExperimentsRequest.Builder, ObjectBuilder<PutExperimentsRequest>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code judgmentList}
     */
    @Nonnull
    public final List<String> judgmentList() {
        return this.judgmentList;
    }

    /**
     * API name: {@code querySetId}
     */
    @Nullable
    public final String querySetId() {
        return this.querySetId;
    }

    /**
     * API name: {@code searchConfigurationList}
     */
    @Nullable
    public final JsonData searchConfigurationList() {
        return this.searchConfigurationList;
    }

    /**
     * API name: {@code size}
     */
    @Nullable
    public final Integer size() {
        return this.size;
    }

    /**
     * API name: {@code type}
     */
    @Nullable
    public final String type() {
        return this.type;
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
        if (ApiTypeHelper.isDefined(this.judgmentList)) {
            generator.writeKey("judgmentList");
            generator.writeStartArray();
            for (String item0 : this.judgmentList) {
                generator.write(item0);
            }
            generator.writeEnd();
        }

        if (this.querySetId != null) {
            generator.writeKey("querySetId");
            generator.write(this.querySetId);
        }

        if (this.searchConfigurationList != null) {
            generator.writeKey("searchConfigurationList");
            this.searchConfigurationList.serialize(generator, mapper);
        }

        if (this.size != null) {
            generator.writeKey("size");
            generator.write(this.size);
        }

        if (this.type != null) {
            generator.writeKey("type");
            generator.write(this.type);
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
     * Builder for {@link PutExperimentsRequest}.
     */
    public static class Builder extends RequestBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, PutExperimentsRequest> {
        @Nullable
        private List<String> judgmentList;
        @Nullable
        private String querySetId;
        @Nullable
        private JsonData searchConfigurationList;
        @Nullable
        private Integer size;
        @Nullable
        private String type;

        public Builder() {}

        private Builder(PutExperimentsRequest o) {
            super(o);
            this.judgmentList = _listCopy(o.judgmentList);
            this.querySetId = o.querySetId;
            this.searchConfigurationList = o.searchConfigurationList;
            this.size = o.size;
            this.type = o.type;
        }

        private Builder(Builder o) {
            super(o);
            this.judgmentList = _listCopy(o.judgmentList);
            this.querySetId = o.querySetId;
            this.searchConfigurationList = o.searchConfigurationList;
            this.size = o.size;
            this.type = o.type;
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
         * API name: {@code judgmentList}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>judgmentList</code>.
         * </p>
         */
        @Nonnull
        public final Builder judgmentList(List<String> list) {
            this.judgmentList = _listAddAll(this.judgmentList, list);
            return this;
        }

        /**
         * API name: {@code judgmentList}
         *
         * <p>
         * Adds one or more values to <code>judgmentList</code>.
         * </p>
         */
        @Nonnull
        public final Builder judgmentList(String value, String... values) {
            this.judgmentList = _listAdd(this.judgmentList, value, values);
            return this;
        }

        /**
         * API name: {@code querySetId}
         */
        @Nonnull
        public final Builder querySetId(@Nullable String value) {
            this.querySetId = value;
            return this;
        }

        /**
         * API name: {@code searchConfigurationList}
         */
        @Nonnull
        public final Builder searchConfigurationList(@Nullable JsonData value) {
            this.searchConfigurationList = value;
            return this;
        }

        /**
         * API name: {@code size}
         */
        @Nonnull
        public final Builder size(@Nullable Integer value) {
            this.size = value;
            return this;
        }

        /**
         * API name: {@code type}
         */
        @Nonnull
        public final Builder type(@Nullable String value) {
            this.type = value;
            return this;
        }

        /**
         * Builds a {@link PutExperimentsRequest}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public PutExperimentsRequest build() {
            _checkSingleUse();

            return new PutExperimentsRequest(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link PutExperimentsRequest}
     */
    public static final JsonpDeserializer<PutExperimentsRequest> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        PutExperimentsRequest::setupPutExperimentsRequestDeserializer
    );

    protected static void setupPutExperimentsRequestDeserializer(ObjectDeserializer<PutExperimentsRequest.Builder> op) {
        op.add(Builder::judgmentList, JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()), "judgmentList");
        op.add(Builder::querySetId, JsonpDeserializer.stringDeserializer(), "querySetId");
        op.add(Builder::searchConfigurationList, JsonData._DESERIALIZER, "searchConfigurationList");
        op.add(Builder::size, JsonpDeserializer.integerDeserializer(), "size");
        op.add(Builder::type, JsonpDeserializer.stringDeserializer(), "type");
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Endpoint "{@code search_relevance.put_experiments}".
     */
    public static final Endpoint<PutExperimentsRequest, PutExperimentsResponse, ErrorResponse> _ENDPOINT = new SimpleEndpoint<>(
        // Request method
        request -> "PUT",
        // Request path
        request -> "/_plugins/_search_relevance/experiments",
        // Request parameters
        request -> {
            Map<String, String> params = new HashMap<>();
            request.applyQueryParameters(params);
            return params;
        },
        SimpleEndpoint.emptyMap(),
        true,
        PutExperimentsResponse._DESERIALIZER
    );

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.judgmentList);
        result = 31 * result + Objects.hashCode(this.querySetId);
        result = 31 * result + Objects.hashCode(this.searchConfigurationList);
        result = 31 * result + Objects.hashCode(this.size);
        result = 31 * result + Objects.hashCode(this.type);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        PutExperimentsRequest other = (PutExperimentsRequest) o;
        return Objects.equals(this.judgmentList, other.judgmentList)
            && Objects.equals(this.querySetId, other.querySetId)
            && Objects.equals(this.searchConfigurationList, other.searchConfigurationList)
            && Objects.equals(this.size, other.size)
            && Objects.equals(this.type, other.type);
    }
}
