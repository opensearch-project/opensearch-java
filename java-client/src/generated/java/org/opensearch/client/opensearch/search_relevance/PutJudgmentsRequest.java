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

// typedef: search_relevance.put_judgments.Request

/**
 * Creates a judgment.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public final class PutJudgmentsRequest extends RequestBase
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<PutJudgmentsRequest.Builder, PutJudgmentsRequest> {

    @Nullable
    private final String clickModel;

    @Nonnull
    private final List<String> contextFields;

    @Nullable
    private final String description;

    @Nullable
    private final Boolean ignoreFailure;

    @Nonnull
    private final List<Map<String, JsonData>> judgmentRatings;

    @Nullable
    private final Integer maxRank;

    @Nullable
    private final String modelId;

    @Nullable
    private final String name;

    @Nullable
    private final String querySetId;

    @Nonnull
    private final List<String> searchConfigurationList;

    @Nullable
    private final Integer size;

    @Nullable
    private final String type;

    // ---------------------------------------------------------------------------------------------

    private PutJudgmentsRequest(Builder builder) {
        super(builder);
        this.clickModel = builder.clickModel;
        this.contextFields = ApiTypeHelper.unmodifiable(builder.contextFields);
        this.description = builder.description;
        this.ignoreFailure = builder.ignoreFailure;
        this.judgmentRatings = ApiTypeHelper.unmodifiable(builder.judgmentRatings);
        this.maxRank = builder.maxRank;
        this.modelId = builder.modelId;
        this.name = builder.name;
        this.querySetId = builder.querySetId;
        this.searchConfigurationList = ApiTypeHelper.unmodifiable(builder.searchConfigurationList);
        this.size = builder.size;
        this.type = builder.type;
    }

    public static PutJudgmentsRequest of(Function<PutJudgmentsRequest.Builder, ObjectBuilder<PutJudgmentsRequest>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code clickModel}
     */
    @Nullable
    public final String clickModel() {
        return this.clickModel;
    }

    /**
     * API name: {@code contextFields}
     */
    @Nonnull
    public final List<String> contextFields() {
        return this.contextFields;
    }

    /**
     * API name: {@code description}
     */
    @Nullable
    public final String description() {
        return this.description;
    }

    /**
     * API name: {@code ignoreFailure}
     */
    @Nullable
    public final Boolean ignoreFailure() {
        return this.ignoreFailure;
    }

    /**
     * API name: {@code judgmentRatings}
     */
    @Nonnull
    public final List<Map<String, JsonData>> judgmentRatings() {
        return this.judgmentRatings;
    }

    /**
     * API name: {@code maxRank}
     */
    @Nullable
    public final Integer maxRank() {
        return this.maxRank;
    }

    /**
     * API name: {@code modelId}
     */
    @Nullable
    public final String modelId() {
        return this.modelId;
    }

    /**
     * API name: {@code name}
     */
    @Nullable
    public final String name() {
        return this.name;
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
    @Nonnull
    public final List<String> searchConfigurationList() {
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
        if (this.clickModel != null) {
            generator.writeKey("clickModel");
            generator.write(this.clickModel);
        }

        if (ApiTypeHelper.isDefined(this.contextFields)) {
            generator.writeKey("contextFields");
            generator.writeStartArray();
            for (String item0 : this.contextFields) {
                generator.write(item0);
            }
            generator.writeEnd();
        }

        if (this.description != null) {
            generator.writeKey("description");
            generator.write(this.description);
        }

        if (this.ignoreFailure != null) {
            generator.writeKey("ignoreFailure");
            generator.write(this.ignoreFailure);
        }

        if (ApiTypeHelper.isDefined(this.judgmentRatings)) {
            generator.writeKey("judgmentRatings");
            generator.writeStartArray();
            for (Map<String, JsonData> item0 : this.judgmentRatings) {
                generator.writeStartObject();
                if (item0 != null) {
                    for (Map.Entry<String, JsonData> item1 : item0.entrySet()) {
                        generator.writeKey(item1.getKey());
                        item1.getValue().serialize(generator, mapper);
                    }
                }
                generator.writeEnd();
            }
            generator.writeEnd();
        }

        if (this.maxRank != null) {
            generator.writeKey("maxRank");
            generator.write(this.maxRank);
        }

        if (this.modelId != null) {
            generator.writeKey("modelId");
            generator.write(this.modelId);
        }

        if (this.name != null) {
            generator.writeKey("name");
            generator.write(this.name);
        }

        if (this.querySetId != null) {
            generator.writeKey("querySetId");
            generator.write(this.querySetId);
        }

        if (ApiTypeHelper.isDefined(this.searchConfigurationList)) {
            generator.writeKey("searchConfigurationList");
            generator.writeStartArray();
            for (String item0 : this.searchConfigurationList) {
                generator.write(item0);
            }
            generator.writeEnd();
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
     * Builder for {@link PutJudgmentsRequest}.
     */
    public static class Builder extends RequestBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, PutJudgmentsRequest> {
        @Nullable
        private String clickModel;
        @Nullable
        private List<String> contextFields;
        @Nullable
        private String description;
        @Nullable
        private Boolean ignoreFailure;
        @Nullable
        private List<Map<String, JsonData>> judgmentRatings;
        @Nullable
        private Integer maxRank;
        @Nullable
        private String modelId;
        @Nullable
        private String name;
        @Nullable
        private String querySetId;
        @Nullable
        private List<String> searchConfigurationList;
        @Nullable
        private Integer size;
        @Nullable
        private String type;

        public Builder() {}

        private Builder(PutJudgmentsRequest o) {
            super(o);
            this.clickModel = o.clickModel;
            this.contextFields = _listCopy(o.contextFields);
            this.description = o.description;
            this.ignoreFailure = o.ignoreFailure;
            this.judgmentRatings = _listCopy(o.judgmentRatings);
            this.maxRank = o.maxRank;
            this.modelId = o.modelId;
            this.name = o.name;
            this.querySetId = o.querySetId;
            this.searchConfigurationList = _listCopy(o.searchConfigurationList);
            this.size = o.size;
            this.type = o.type;
        }

        private Builder(Builder o) {
            super(o);
            this.clickModel = o.clickModel;
            this.contextFields = _listCopy(o.contextFields);
            this.description = o.description;
            this.ignoreFailure = o.ignoreFailure;
            this.judgmentRatings = _listCopy(o.judgmentRatings);
            this.maxRank = o.maxRank;
            this.modelId = o.modelId;
            this.name = o.name;
            this.querySetId = o.querySetId;
            this.searchConfigurationList = _listCopy(o.searchConfigurationList);
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
         * API name: {@code clickModel}
         */
        @Nonnull
        public final Builder clickModel(@Nullable String value) {
            this.clickModel = value;
            return this;
        }

        /**
         * API name: {@code contextFields}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>contextFields</code>.
         * </p>
         */
        @Nonnull
        public final Builder contextFields(List<String> list) {
            this.contextFields = _listAddAll(this.contextFields, list);
            return this;
        }

        /**
         * API name: {@code contextFields}
         *
         * <p>
         * Adds one or more values to <code>contextFields</code>.
         * </p>
         */
        @Nonnull
        public final Builder contextFields(String value, String... values) {
            this.contextFields = _listAdd(this.contextFields, value, values);
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
         * API name: {@code ignoreFailure}
         */
        @Nonnull
        public final Builder ignoreFailure(@Nullable Boolean value) {
            this.ignoreFailure = value;
            return this;
        }

        /**
         * API name: {@code judgmentRatings}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>judgmentRatings</code>.
         * </p>
         */
        @Nonnull
        public final Builder judgmentRatings(List<Map<String, JsonData>> list) {
            this.judgmentRatings = _listAddAll(this.judgmentRatings, list);
            return this;
        }

        /**
         * API name: {@code judgmentRatings}
         *
         * <p>
         * Adds one or more values to <code>judgmentRatings</code>.
         * </p>
         */
        @Nonnull
        public final Builder judgmentRatings(Map<String, JsonData> value, Map<String, JsonData>... values) {
            this.judgmentRatings = _listAdd(this.judgmentRatings, value, values);
            return this;
        }

        /**
         * API name: {@code maxRank}
         */
        @Nonnull
        public final Builder maxRank(@Nullable Integer value) {
            this.maxRank = value;
            return this;
        }

        /**
         * API name: {@code modelId}
         */
        @Nonnull
        public final Builder modelId(@Nullable String value) {
            this.modelId = value;
            return this;
        }

        /**
         * API name: {@code name}
         */
        @Nonnull
        public final Builder name(@Nullable String value) {
            this.name = value;
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
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>searchConfigurationList</code>.
         * </p>
         */
        @Nonnull
        public final Builder searchConfigurationList(List<String> list) {
            this.searchConfigurationList = _listAddAll(this.searchConfigurationList, list);
            return this;
        }

        /**
         * API name: {@code searchConfigurationList}
         *
         * <p>
         * Adds one or more values to <code>searchConfigurationList</code>.
         * </p>
         */
        @Nonnull
        public final Builder searchConfigurationList(String value, String... values) {
            this.searchConfigurationList = _listAdd(this.searchConfigurationList, value, values);
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
         * Builds a {@link PutJudgmentsRequest}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public PutJudgmentsRequest build() {
            _checkSingleUse();

            return new PutJudgmentsRequest(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link PutJudgmentsRequest}
     */
    public static final JsonpDeserializer<PutJudgmentsRequest> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        PutJudgmentsRequest::setupPutJudgmentsRequestDeserializer
    );

    protected static void setupPutJudgmentsRequestDeserializer(ObjectDeserializer<PutJudgmentsRequest.Builder> op) {
        op.add(Builder::clickModel, JsonpDeserializer.stringDeserializer(), "clickModel");
        op.add(Builder::contextFields, JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()), "contextFields");
        op.add(Builder::description, JsonpDeserializer.stringDeserializer(), "description");
        op.add(Builder::ignoreFailure, JsonpDeserializer.booleanDeserializer(), "ignoreFailure");
        op.add(
            Builder::judgmentRatings,
            JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringMapDeserializer(JsonData._DESERIALIZER)),
            "judgmentRatings"
        );
        op.add(Builder::maxRank, JsonpDeserializer.integerDeserializer(), "maxRank");
        op.add(Builder::modelId, JsonpDeserializer.stringDeserializer(), "modelId");
        op.add(Builder::name, JsonpDeserializer.stringDeserializer(), "name");
        op.add(Builder::querySetId, JsonpDeserializer.stringDeserializer(), "querySetId");
        op.add(
            Builder::searchConfigurationList,
            JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()),
            "searchConfigurationList"
        );
        op.add(Builder::size, JsonpDeserializer.integerDeserializer(), "size");
        op.add(Builder::type, JsonpDeserializer.stringDeserializer(), "type");
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Endpoint "{@code search_relevance.put_judgments}".
     */
    public static final Endpoint<PutJudgmentsRequest, PutJudgmentsResponse, ErrorResponse> _ENDPOINT = new SimpleEndpoint<>(
        // Request method
        request -> "PUT",
        // Request path
        request -> "/_plugins/_search_relevance/judgments",
        // Request parameters
        request -> {
            Map<String, String> params = new HashMap<>();
            request.applyQueryParameters(params);
            return params;
        },
        SimpleEndpoint.emptyMap(),
        true,
        PutJudgmentsResponse._DESERIALIZER
    );

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.clickModel);
        result = 31 * result + Objects.hashCode(this.contextFields);
        result = 31 * result + Objects.hashCode(this.description);
        result = 31 * result + Objects.hashCode(this.ignoreFailure);
        result = 31 * result + Objects.hashCode(this.judgmentRatings);
        result = 31 * result + Objects.hashCode(this.maxRank);
        result = 31 * result + Objects.hashCode(this.modelId);
        result = 31 * result + Objects.hashCode(this.name);
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
        PutJudgmentsRequest other = (PutJudgmentsRequest) o;
        return Objects.equals(this.clickModel, other.clickModel)
            && Objects.equals(this.contextFields, other.contextFields)
            && Objects.equals(this.description, other.description)
            && Objects.equals(this.ignoreFailure, other.ignoreFailure)
            && Objects.equals(this.judgmentRatings, other.judgmentRatings)
            && Objects.equals(this.maxRank, other.maxRank)
            && Objects.equals(this.modelId, other.modelId)
            && Objects.equals(this.name, other.name)
            && Objects.equals(this.querySetId, other.querySetId)
            && Objects.equals(this.searchConfigurationList, other.searchConfigurationList)
            && Objects.equals(this.size, other.size)
            && Objects.equals(this.type, other.type);
    }
}
