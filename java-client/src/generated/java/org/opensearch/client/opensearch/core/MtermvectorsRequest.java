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
import org.opensearch.client.opensearch._types.ErrorResponse;
import org.opensearch.client.opensearch._types.RequestBase;
import org.opensearch.client.opensearch._types.VersionType;
import org.opensearch.client.opensearch.core.mtermvectors.MultiTermVectorsOperation;
import org.opensearch.client.transport.Endpoint;
import org.opensearch.client.transport.endpoints.SimpleEndpoint;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: _global.mtermvectors.Request

/**
 * Returns multiple termvectors in one request.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public final class MtermvectorsRequest extends RequestBase
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<MtermvectorsRequest.Builder, MtermvectorsRequest> {

    @Nonnull
    private final List<MultiTermVectorsOperation> docs;

    @Nullable
    private final Boolean fieldStatistics;

    @Nonnull
    private final List<String> fields;

    @Nonnull
    private final List<String> ids;

    @Nullable
    private final String index;

    @Nullable
    private final Boolean offsets;

    @Nullable
    private final Boolean payloads;

    @Nullable
    private final Boolean positions;

    @Nullable
    private final String preference;

    @Nullable
    private final Boolean realtime;

    @Nonnull
    private final List<String> routing;

    @Nullable
    private final Boolean termStatistics;

    @Nullable
    private final Long version;

    @Nullable
    private final VersionType versionType;

    // ---------------------------------------------------------------------------------------------

    private MtermvectorsRequest(Builder builder) {
        super(builder);
        this.docs = ApiTypeHelper.unmodifiable(builder.docs);
        this.fieldStatistics = builder.fieldStatistics;
        this.fields = ApiTypeHelper.unmodifiable(builder.fields);
        this.ids = ApiTypeHelper.unmodifiable(builder.ids);
        this.index = builder.index;
        this.offsets = builder.offsets;
        this.payloads = builder.payloads;
        this.positions = builder.positions;
        this.preference = builder.preference;
        this.realtime = builder.realtime;
        this.routing = ApiTypeHelper.unmodifiable(builder.routing);
        this.termStatistics = builder.termStatistics;
        this.version = builder.version;
        this.versionType = builder.versionType;
    }

    public static MtermvectorsRequest of(Function<MtermvectorsRequest.Builder, ObjectBuilder<MtermvectorsRequest>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Array of existing or artificial documents.
     * <p>
     * API name: {@code docs}
     * </p>
     */
    @Nonnull
    public final List<MultiTermVectorsOperation> docs() {
        return this.docs;
    }

    /**
     * If <code>true</code>, the response includes the document count, sum of document frequencies, and sum of total term frequencies.
     * <p>
     * API name: {@code field_statistics}
     * </p>
     */
    @Nullable
    public final Boolean fieldStatistics() {
        return this.fieldStatistics;
    }

    /**
     * Comma-separated list or wildcard expressions of fields to include in the statistics. Used as the default list unless a specific field
     * list is provided in the <code>completion_fields</code> or <code>fielddata_fields</code> parameters.
     * <p>
     * API name: {@code fields}
     * </p>
     */
    @Nonnull
    public final List<String> fields() {
        return this.fields;
    }

    /**
     * Simplified syntax to specify documents by their ID if they're in the same index.
     * <p>
     * API name: {@code ids}
     * </p>
     */
    @Nonnull
    public final List<String> ids() {
        return this.ids;
    }

    /**
     * Name of the index that contains the documents.
     * <p>
     * API name: {@code index}
     * </p>
     */
    @Nullable
    public final String index() {
        return this.index;
    }

    /**
     * If <code>true</code>, the response includes term offsets.
     * <p>
     * API name: {@code offsets}
     * </p>
     */
    @Nullable
    public final Boolean offsets() {
        return this.offsets;
    }

    /**
     * If <code>true</code>, the response includes term payloads.
     * <p>
     * API name: {@code payloads}
     * </p>
     */
    @Nullable
    public final Boolean payloads() {
        return this.payloads;
    }

    /**
     * If <code>true</code>, the response includes term positions.
     * <p>
     * API name: {@code positions}
     * </p>
     */
    @Nullable
    public final Boolean positions() {
        return this.positions;
    }

    /**
     * Specifies the node or shard the operation should be performed on. Random by default.
     * <p>
     * API name: {@code preference}
     * </p>
     */
    @Nullable
    public final String preference() {
        return this.preference;
    }

    /**
     * If <code>true</code>, the request is real-time as opposed to near-real-time.
     * <p>
     * API name: {@code realtime}
     * </p>
     */
    @Nullable
    public final Boolean realtime() {
        return this.realtime;
    }

    /**
     * Custom value used to route operations to a specific shard.
     * <p>
     * API name: {@code routing}
     * </p>
     */
    @Nonnull
    public final List<String> routing() {
        return this.routing;
    }

    /**
     * If <code>true</code>, the response includes term frequency and document frequency.
     * <p>
     * API name: {@code term_statistics}
     * </p>
     */
    @Nullable
    public final Boolean termStatistics() {
        return this.termStatistics;
    }

    /**
     * If <code>true</code>, returns the document version as part of a hit.
     * <p>
     * API name: {@code version}
     * </p>
     */
    @Nullable
    public final Long version() {
        return this.version;
    }

    /**
     * Specific version type.
     * <p>
     * API name: {@code version_type}
     * </p>
     */
    @Nullable
    public final VersionType versionType() {
        return this.versionType;
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
        if (ApiTypeHelper.isDefined(this.docs)) {
            generator.writeKey("docs");
            generator.writeStartArray();
            for (MultiTermVectorsOperation item0 : this.docs) {
                item0.serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        if (ApiTypeHelper.isDefined(this.ids)) {
            generator.writeKey("ids");
            generator.writeStartArray();
            for (String item0 : this.ids) {
                generator.write(item0);
            }
            generator.writeEnd();
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
     * Builder for {@link MtermvectorsRequest}.
     */
    public static class Builder extends RequestBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, MtermvectorsRequest> {
        @Nullable
        private List<MultiTermVectorsOperation> docs;
        @Nullable
        private Boolean fieldStatistics;
        @Nullable
        private List<String> fields;
        @Nullable
        private List<String> ids;
        @Nullable
        private String index;
        @Nullable
        private Boolean offsets;
        @Nullable
        private Boolean payloads;
        @Nullable
        private Boolean positions;
        @Nullable
        private String preference;
        @Nullable
        private Boolean realtime;
        @Nullable
        private List<String> routing;
        @Nullable
        private Boolean termStatistics;
        @Nullable
        private Long version;
        @Nullable
        private VersionType versionType;

        public Builder() {}

        private Builder(MtermvectorsRequest o) {
            super(o);
            this.docs = _listCopy(o.docs);
            this.fieldStatistics = o.fieldStatistics;
            this.fields = _listCopy(o.fields);
            this.ids = _listCopy(o.ids);
            this.index = o.index;
            this.offsets = o.offsets;
            this.payloads = o.payloads;
            this.positions = o.positions;
            this.preference = o.preference;
            this.realtime = o.realtime;
            this.routing = _listCopy(o.routing);
            this.termStatistics = o.termStatistics;
            this.version = o.version;
            this.versionType = o.versionType;
        }

        private Builder(Builder o) {
            super(o);
            this.docs = _listCopy(o.docs);
            this.fieldStatistics = o.fieldStatistics;
            this.fields = _listCopy(o.fields);
            this.ids = _listCopy(o.ids);
            this.index = o.index;
            this.offsets = o.offsets;
            this.payloads = o.payloads;
            this.positions = o.positions;
            this.preference = o.preference;
            this.realtime = o.realtime;
            this.routing = _listCopy(o.routing);
            this.termStatistics = o.termStatistics;
            this.version = o.version;
            this.versionType = o.versionType;
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
         * Array of existing or artificial documents.
         * <p>
         * API name: {@code docs}
         * </p>
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>docs</code>.
         * </p>
         */
        @Nonnull
        public final Builder docs(List<MultiTermVectorsOperation> list) {
            this.docs = _listAddAll(this.docs, list);
            return this;
        }

        /**
         * Array of existing or artificial documents.
         * <p>
         * API name: {@code docs}
         * </p>
         *
         * <p>
         * Adds one or more values to <code>docs</code>.
         * </p>
         */
        @Nonnull
        public final Builder docs(MultiTermVectorsOperation value, MultiTermVectorsOperation... values) {
            this.docs = _listAdd(this.docs, value, values);
            return this;
        }

        /**
         * Array of existing or artificial documents.
         * <p>
         * API name: {@code docs}
         * </p>
         *
         * <p>
         * Adds a value to <code>docs</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder docs(Function<MultiTermVectorsOperation.Builder, ObjectBuilder<MultiTermVectorsOperation>> fn) {
            return docs(fn.apply(new MultiTermVectorsOperation.Builder()).build());
        }

        /**
         * If <code>true</code>, the response includes the document count, sum of document frequencies, and sum of total term frequencies.
         * <p>
         * API name: {@code field_statistics}
         * </p>
         */
        @Nonnull
        public final Builder fieldStatistics(@Nullable Boolean value) {
            this.fieldStatistics = value;
            return this;
        }

        /**
         * Comma-separated list or wildcard expressions of fields to include in the statistics. Used as the default list unless a specific
         * field list is provided in the <code>completion_fields</code> or <code>fielddata_fields</code> parameters.
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
         * Comma-separated list or wildcard expressions of fields to include in the statistics. Used as the default list unless a specific
         * field list is provided in the <code>completion_fields</code> or <code>fielddata_fields</code> parameters.
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
         * Simplified syntax to specify documents by their ID if they're in the same index.
         * <p>
         * API name: {@code ids}
         * </p>
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>ids</code>.
         * </p>
         */
        @Nonnull
        public final Builder ids(List<String> list) {
            this.ids = _listAddAll(this.ids, list);
            return this;
        }

        /**
         * Simplified syntax to specify documents by their ID if they're in the same index.
         * <p>
         * API name: {@code ids}
         * </p>
         *
         * <p>
         * Adds one or more values to <code>ids</code>.
         * </p>
         */
        @Nonnull
        public final Builder ids(String value, String... values) {
            this.ids = _listAdd(this.ids, value, values);
            return this;
        }

        /**
         * Name of the index that contains the documents.
         * <p>
         * API name: {@code index}
         * </p>
         */
        @Nonnull
        public final Builder index(@Nullable String value) {
            this.index = value;
            return this;
        }

        /**
         * If <code>true</code>, the response includes term offsets.
         * <p>
         * API name: {@code offsets}
         * </p>
         */
        @Nonnull
        public final Builder offsets(@Nullable Boolean value) {
            this.offsets = value;
            return this;
        }

        /**
         * If <code>true</code>, the response includes term payloads.
         * <p>
         * API name: {@code payloads}
         * </p>
         */
        @Nonnull
        public final Builder payloads(@Nullable Boolean value) {
            this.payloads = value;
            return this;
        }

        /**
         * If <code>true</code>, the response includes term positions.
         * <p>
         * API name: {@code positions}
         * </p>
         */
        @Nonnull
        public final Builder positions(@Nullable Boolean value) {
            this.positions = value;
            return this;
        }

        /**
         * Specifies the node or shard the operation should be performed on. Random by default.
         * <p>
         * API name: {@code preference}
         * </p>
         */
        @Nonnull
        public final Builder preference(@Nullable String value) {
            this.preference = value;
            return this;
        }

        /**
         * If <code>true</code>, the request is real-time as opposed to near-real-time.
         * <p>
         * API name: {@code realtime}
         * </p>
         */
        @Nonnull
        public final Builder realtime(@Nullable Boolean value) {
            this.realtime = value;
            return this;
        }

        /**
         * Custom value used to route operations to a specific shard.
         * <p>
         * API name: {@code routing}
         * </p>
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>routing</code>.
         * </p>
         */
        @Nonnull
        public final Builder routing(List<String> list) {
            this.routing = _listAddAll(this.routing, list);
            return this;
        }

        /**
         * Custom value used to route operations to a specific shard.
         * <p>
         * API name: {@code routing}
         * </p>
         *
         * <p>
         * Adds one or more values to <code>routing</code>.
         * </p>
         */
        @Nonnull
        public final Builder routing(String value, String... values) {
            this.routing = _listAdd(this.routing, value, values);
            return this;
        }

        /**
         * If <code>true</code>, the response includes term frequency and document frequency.
         * <p>
         * API name: {@code term_statistics}
         * </p>
         */
        @Nonnull
        public final Builder termStatistics(@Nullable Boolean value) {
            this.termStatistics = value;
            return this;
        }

        /**
         * If <code>true</code>, returns the document version as part of a hit.
         * <p>
         * API name: {@code version}
         * </p>
         */
        @Nonnull
        public final Builder version(@Nullable Long value) {
            this.version = value;
            return this;
        }

        /**
         * Specific version type.
         * <p>
         * API name: {@code version_type}
         * </p>
         */
        @Nonnull
        public final Builder versionType(@Nullable VersionType value) {
            this.versionType = value;
            return this;
        }

        /**
         * Builds a {@link MtermvectorsRequest}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public MtermvectorsRequest build() {
            _checkSingleUse();

            return new MtermvectorsRequest(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link MtermvectorsRequest}
     */
    public static final JsonpDeserializer<MtermvectorsRequest> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        MtermvectorsRequest::setupMtermvectorsRequestDeserializer
    );

    protected static void setupMtermvectorsRequestDeserializer(ObjectDeserializer<MtermvectorsRequest.Builder> op) {
        op.add(Builder::docs, JsonpDeserializer.arrayDeserializer(MultiTermVectorsOperation._DESERIALIZER), "docs");
        op.add(Builder::ids, JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()), "ids");
    }

    // ---------------------------------------------------------------------------------------------

    @Override
    protected void applyQueryParameters(@Nonnull Map<String, String> params) {
        super.applyQueryParameters(params);
        if (this.fieldStatistics != null) {
            params.put("field_statistics", String.valueOf(this.fieldStatistics));
        }
        if (ApiTypeHelper.isDefined(this.fields)) {
            params.put("fields", String.join(",", this.fields));
        }
        if (this.offsets != null) {
            params.put("offsets", String.valueOf(this.offsets));
        }
        if (this.payloads != null) {
            params.put("payloads", String.valueOf(this.payloads));
        }
        if (this.positions != null) {
            params.put("positions", String.valueOf(this.positions));
        }
        if (this.preference != null) {
            params.put("preference", this.preference);
        }
        if (this.realtime != null) {
            params.put("realtime", String.valueOf(this.realtime));
        }
        if (ApiTypeHelper.isDefined(this.routing)) {
            params.put("routing", String.join(",", this.routing));
        }
        if (this.termStatistics != null) {
            params.put("term_statistics", String.valueOf(this.termStatistics));
        }
        if (this.version != null) {
            params.put("version", String.valueOf(this.version));
        }
        if (this.versionType != null) {
            params.put("version_type", this.versionType.jsonValue());
        }
    }

    /**
     * Endpoint "{@code mtermvectors}".
     */
    public static final Endpoint<MtermvectorsRequest, MtermvectorsResponse, ErrorResponse> _ENDPOINT = new SimpleEndpoint<>(
        // Request method
        request -> "POST",
        // Request path
        request -> {
            final int _index = 1 << 0;

            int propsSet = 0;

            if (request.index() != null) propsSet |= _index;

            if (propsSet == 0) {
                return "/_mtermvectors";
            }
            if (propsSet == (_index)) {
                StringBuilder buf = new StringBuilder();
                buf.append("/");
                SimpleEndpoint.pathEncode(request.index, buf);
                buf.append("/_mtermvectors");
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
        MtermvectorsResponse._DESERIALIZER
    );

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.docs);
        result = 31 * result + Objects.hashCode(this.fieldStatistics);
        result = 31 * result + Objects.hashCode(this.fields);
        result = 31 * result + Objects.hashCode(this.ids);
        result = 31 * result + Objects.hashCode(this.index);
        result = 31 * result + Objects.hashCode(this.offsets);
        result = 31 * result + Objects.hashCode(this.payloads);
        result = 31 * result + Objects.hashCode(this.positions);
        result = 31 * result + Objects.hashCode(this.preference);
        result = 31 * result + Objects.hashCode(this.realtime);
        result = 31 * result + Objects.hashCode(this.routing);
        result = 31 * result + Objects.hashCode(this.termStatistics);
        result = 31 * result + Objects.hashCode(this.version);
        result = 31 * result + Objects.hashCode(this.versionType);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        MtermvectorsRequest other = (MtermvectorsRequest) o;
        return Objects.equals(this.docs, other.docs)
            && Objects.equals(this.fieldStatistics, other.fieldStatistics)
            && Objects.equals(this.fields, other.fields)
            && Objects.equals(this.ids, other.ids)
            && Objects.equals(this.index, other.index)
            && Objects.equals(this.offsets, other.offsets)
            && Objects.equals(this.payloads, other.payloads)
            && Objects.equals(this.positions, other.positions)
            && Objects.equals(this.preference, other.preference)
            && Objects.equals(this.realtime, other.realtime)
            && Objects.equals(this.routing, other.routing)
            && Objects.equals(this.termStatistics, other.termStatistics)
            && Objects.equals(this.version, other.version)
            && Objects.equals(this.versionType, other.versionType);
    }
}
