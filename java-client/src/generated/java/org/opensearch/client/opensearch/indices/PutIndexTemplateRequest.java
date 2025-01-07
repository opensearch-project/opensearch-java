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

package org.opensearch.client.opensearch.indices;

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
import org.opensearch.client.opensearch._types.Time;
import org.opensearch.client.opensearch.indices.put_index_template.IndexTemplateMapping;
import org.opensearch.client.transport.Endpoint;
import org.opensearch.client.transport.endpoints.SimpleEndpoint;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: indices.put_index_template.Request

/**
 * Creates or updates an index template.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public final class PutIndexTemplateRequest extends RequestBase
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<PutIndexTemplateRequest.Builder, PutIndexTemplateRequest> {

    @Nullable
    private final String cause;

    @Nullable
    private final Time clusterManagerTimeout;

    @Nonnull
    private final List<String> composedOf;

    @Nullable
    private final Boolean create;

    @Nullable
    private final IndexTemplateDataStreamConfiguration dataStream;

    @Nonnull
    private final List<String> indexPatterns;

    @Deprecated
    @Nullable
    private final Time masterTimeout;

    @Nonnull
    private final Map<String, JsonData> meta;

    @Nonnull
    private final String name;

    @Nullable
    private final Integer priority;

    @Nullable
    private final IndexTemplateMapping template;

    @Nullable
    private final Long version;

    // ---------------------------------------------------------------------------------------------

    private PutIndexTemplateRequest(Builder builder) {
        super(builder);
        this.cause = builder.cause;
        this.clusterManagerTimeout = builder.clusterManagerTimeout;
        this.composedOf = ApiTypeHelper.unmodifiable(builder.composedOf);
        this.create = builder.create;
        this.dataStream = builder.dataStream;
        this.indexPatterns = ApiTypeHelper.unmodifiable(builder.indexPatterns);
        this.masterTimeout = builder.masterTimeout;
        this.meta = ApiTypeHelper.unmodifiable(builder.meta);
        this.name = ApiTypeHelper.requireNonNull(builder.name, this, "name");
        this.priority = builder.priority;
        this.template = builder.template;
        this.version = builder.version;
    }

    public static PutIndexTemplateRequest of(Function<PutIndexTemplateRequest.Builder, ObjectBuilder<PutIndexTemplateRequest>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * User defined reason for creating/updating the index template.
     * <p>
     * API name: {@code cause}
     * </p>
     */
    @Nullable
    public final String cause() {
        return this.cause;
    }

    /**
     * Operation timeout for connection to cluster-manager node.
     * <p>
     * API name: {@code cluster_manager_timeout}
     * </p>
     */
    @Nullable
    public final Time clusterManagerTimeout() {
        return this.clusterManagerTimeout;
    }

    /**
     * An ordered list of component template names. Component templates are merged in the order specified, meaning that the last component
     * template specified has the highest precedence.
     * <p>
     * API name: {@code composed_of}
     * </p>
     */
    @Nonnull
    public final List<String> composedOf() {
        return this.composedOf;
    }

    /**
     * If <code>true</code>, this request cannot replace or update existing index templates.
     * <p>
     * API name: {@code create}
     * </p>
     */
    @Nullable
    public final Boolean create() {
        return this.create;
    }

    /**
     * API name: {@code data_stream}
     */
    @Nullable
    public final IndexTemplateDataStreamConfiguration dataStream() {
        return this.dataStream;
    }

    /**
     * API name: {@code index_patterns}
     */
    @Nonnull
    public final List<String> indexPatterns() {
        return this.indexPatterns;
    }

    /**
     * Operation timeout for connection to cluster-manager node.
     * <p>
     * API name: {@code master_timeout}
     * </p>
     */
    @Deprecated
    @Nullable
    public final Time masterTimeout() {
        return this.masterTimeout;
    }

    /**
     * API name: {@code _meta}
     */
    @Nonnull
    public final Map<String, JsonData> meta() {
        return this.meta;
    }

    /**
     * Required - Index or template name
     * <p>
     * API name: {@code name}
     * </p>
     */
    @Nonnull
    public final String name() {
        return this.name;
    }

    /**
     * Priority to determine index template precedence when a new data stream or index is created. The index template with the highest
     * priority is chosen. If no priority is specified the template is treated as though it is of priority 0 (lowest priority). This number
     * is not automatically generated by OpenSearch.
     * <p>
     * API name: {@code priority}
     * </p>
     */
    @Nullable
    public final Integer priority() {
        return this.priority;
    }

    /**
     * API name: {@code template}
     */
    @Nullable
    public final IndexTemplateMapping template() {
        return this.template;
    }

    /**
     * API name: {@code version}
     */
    @Nullable
    public final Long version() {
        return this.version;
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
        if (ApiTypeHelper.isDefined(this.composedOf)) {
            generator.writeKey("composed_of");
            generator.writeStartArray();
            for (String item0 : this.composedOf) {
                generator.write(item0);
            }
            generator.writeEnd();
        }

        if (this.dataStream != null) {
            generator.writeKey("data_stream");
            this.dataStream.serialize(generator, mapper);
        }

        if (ApiTypeHelper.isDefined(this.indexPatterns)) {
            generator.writeKey("index_patterns");
            generator.writeStartArray();
            for (String item0 : this.indexPatterns) {
                generator.write(item0);
            }
            generator.writeEnd();
        }

        if (ApiTypeHelper.isDefined(this.meta)) {
            generator.writeKey("_meta");
            generator.writeStartObject();
            for (Map.Entry<String, JsonData> item0 : this.meta.entrySet()) {
                generator.writeKey(item0.getKey());
                item0.getValue().serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        if (this.priority != null) {
            generator.writeKey("priority");
            generator.write(this.priority);
        }

        if (this.template != null) {
            generator.writeKey("template");
            this.template.serialize(generator, mapper);
        }

        if (this.version != null) {
            generator.writeKey("version");
            generator.write(this.version);
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
     * Builder for {@link PutIndexTemplateRequest}.
     */
    public static class Builder extends RequestBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, PutIndexTemplateRequest> {
        @Nullable
        private String cause;
        @Nullable
        private Time clusterManagerTimeout;
        @Nullable
        private List<String> composedOf;
        @Nullable
        private Boolean create;
        @Nullable
        private IndexTemplateDataStreamConfiguration dataStream;
        @Nullable
        private List<String> indexPatterns;
        @Nullable
        private Time masterTimeout;
        @Nullable
        private Map<String, JsonData> meta;
        private String name;
        @Nullable
        private Integer priority;
        @Nullable
        private IndexTemplateMapping template;
        @Nullable
        private Long version;

        public Builder() {}

        private Builder(PutIndexTemplateRequest o) {
            super(o);
            this.cause = o.cause;
            this.clusterManagerTimeout = o.clusterManagerTimeout;
            this.composedOf = _listCopy(o.composedOf);
            this.create = o.create;
            this.dataStream = o.dataStream;
            this.indexPatterns = _listCopy(o.indexPatterns);
            this.masterTimeout = o.masterTimeout;
            this.meta = _mapCopy(o.meta);
            this.name = o.name;
            this.priority = o.priority;
            this.template = o.template;
            this.version = o.version;
        }

        private Builder(Builder o) {
            super(o);
            this.cause = o.cause;
            this.clusterManagerTimeout = o.clusterManagerTimeout;
            this.composedOf = _listCopy(o.composedOf);
            this.create = o.create;
            this.dataStream = o.dataStream;
            this.indexPatterns = _listCopy(o.indexPatterns);
            this.masterTimeout = o.masterTimeout;
            this.meta = _mapCopy(o.meta);
            this.name = o.name;
            this.priority = o.priority;
            this.template = o.template;
            this.version = o.version;
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
         * User defined reason for creating/updating the index template.
         * <p>
         * API name: {@code cause}
         * </p>
         */
        @Nonnull
        public final Builder cause(@Nullable String value) {
            this.cause = value;
            return this;
        }

        /**
         * Operation timeout for connection to cluster-manager node.
         * <p>
         * API name: {@code cluster_manager_timeout}
         * </p>
         */
        @Nonnull
        public final Builder clusterManagerTimeout(@Nullable Time value) {
            this.clusterManagerTimeout = value;
            return this;
        }

        /**
         * Operation timeout for connection to cluster-manager node.
         * <p>
         * API name: {@code cluster_manager_timeout}
         * </p>
         */
        @Nonnull
        public final Builder clusterManagerTimeout(Function<Time.Builder, ObjectBuilder<Time>> fn) {
            return clusterManagerTimeout(fn.apply(new Time.Builder()).build());
        }

        /**
         * An ordered list of component template names. Component templates are merged in the order specified, meaning that the last
         * component template specified has the highest precedence.
         * <p>
         * API name: {@code composed_of}
         * </p>
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>composedOf</code>.
         * </p>
         */
        @Nonnull
        public final Builder composedOf(List<String> list) {
            this.composedOf = _listAddAll(this.composedOf, list);
            return this;
        }

        /**
         * An ordered list of component template names. Component templates are merged in the order specified, meaning that the last
         * component template specified has the highest precedence.
         * <p>
         * API name: {@code composed_of}
         * </p>
         *
         * <p>
         * Adds one or more values to <code>composedOf</code>.
         * </p>
         */
        @Nonnull
        public final Builder composedOf(String value, String... values) {
            this.composedOf = _listAdd(this.composedOf, value, values);
            return this;
        }

        /**
         * If <code>true</code>, this request cannot replace or update existing index templates.
         * <p>
         * API name: {@code create}
         * </p>
         */
        @Nonnull
        public final Builder create(@Nullable Boolean value) {
            this.create = value;
            return this;
        }

        /**
         * API name: {@code data_stream}
         */
        @Nonnull
        public final Builder dataStream(@Nullable IndexTemplateDataStreamConfiguration value) {
            this.dataStream = value;
            return this;
        }

        /**
         * API name: {@code data_stream}
         */
        @Nonnull
        public final Builder dataStream(
            Function<IndexTemplateDataStreamConfiguration.Builder, ObjectBuilder<IndexTemplateDataStreamConfiguration>> fn
        ) {
            return dataStream(fn.apply(new IndexTemplateDataStreamConfiguration.Builder()).build());
        }

        /**
         * API name: {@code index_patterns}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>indexPatterns</code>.
         * </p>
         */
        @Nonnull
        public final Builder indexPatterns(List<String> list) {
            this.indexPatterns = _listAddAll(this.indexPatterns, list);
            return this;
        }

        /**
         * API name: {@code index_patterns}
         *
         * <p>
         * Adds one or more values to <code>indexPatterns</code>.
         * </p>
         */
        @Nonnull
        public final Builder indexPatterns(String value, String... values) {
            this.indexPatterns = _listAdd(this.indexPatterns, value, values);
            return this;
        }

        /**
         * Operation timeout for connection to cluster-manager node.
         * <p>
         * API name: {@code master_timeout}
         * </p>
         */
        @Deprecated
        @Nonnull
        public final Builder masterTimeout(@Nullable Time value) {
            this.masterTimeout = value;
            return this;
        }

        /**
         * Operation timeout for connection to cluster-manager node.
         * <p>
         * API name: {@code master_timeout}
         * </p>
         */
        @Deprecated
        @Nonnull
        public final Builder masterTimeout(Function<Time.Builder, ObjectBuilder<Time>> fn) {
            return masterTimeout(fn.apply(new Time.Builder()).build());
        }

        /**
         * API name: {@code _meta}
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>meta</code>.
         * </p>
         */
        @Nonnull
        public final Builder meta(Map<String, JsonData> map) {
            this.meta = _mapPutAll(this.meta, map);
            return this;
        }

        /**
         * API name: {@code _meta}
         *
         * <p>
         * Adds an entry to <code>meta</code>.
         * </p>
         */
        @Nonnull
        public final Builder meta(String key, JsonData value) {
            this.meta = _mapPut(this.meta, key, value);
            return this;
        }

        /**
         * Required - Index or template name
         * <p>
         * API name: {@code name}
         * </p>
         */
        @Nonnull
        public final Builder name(String value) {
            this.name = value;
            return this;
        }

        /**
         * Priority to determine index template precedence when a new data stream or index is created. The index template with the highest
         * priority is chosen. If no priority is specified the template is treated as though it is of priority 0 (lowest priority). This
         * number is not automatically generated by OpenSearch.
         * <p>
         * API name: {@code priority}
         * </p>
         */
        @Nonnull
        public final Builder priority(@Nullable Integer value) {
            this.priority = value;
            return this;
        }

        /**
         * API name: {@code template}
         */
        @Nonnull
        public final Builder template(@Nullable IndexTemplateMapping value) {
            this.template = value;
            return this;
        }

        /**
         * API name: {@code template}
         */
        @Nonnull
        public final Builder template(Function<IndexTemplateMapping.Builder, ObjectBuilder<IndexTemplateMapping>> fn) {
            return template(fn.apply(new IndexTemplateMapping.Builder()).build());
        }

        /**
         * API name: {@code version}
         */
        @Nonnull
        public final Builder version(@Nullable Long value) {
            this.version = value;
            return this;
        }

        /**
         * Builds a {@link PutIndexTemplateRequest}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public PutIndexTemplateRequest build() {
            _checkSingleUse();

            return new PutIndexTemplateRequest(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link PutIndexTemplateRequest}
     */
    public static final JsonpDeserializer<PutIndexTemplateRequest> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        PutIndexTemplateRequest::setupPutIndexTemplateRequestDeserializer
    );

    protected static void setupPutIndexTemplateRequestDeserializer(ObjectDeserializer<PutIndexTemplateRequest.Builder> op) {
        op.add(Builder::composedOf, JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()), "composed_of");
        op.add(Builder::dataStream, IndexTemplateDataStreamConfiguration._DESERIALIZER, "data_stream");
        op.add(Builder::indexPatterns, JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()), "index_patterns");
        op.add(Builder::meta, JsonpDeserializer.stringMapDeserializer(JsonData._DESERIALIZER), "_meta");
        op.add(Builder::priority, JsonpDeserializer.integerDeserializer(), "priority");
        op.add(Builder::template, IndexTemplateMapping._DESERIALIZER, "template");
        op.add(Builder::version, JsonpDeserializer.longDeserializer(), "version");
    }

    // ---------------------------------------------------------------------------------------------

    @Override
    protected void applyQueryParameters(@Nonnull Map<String, String> params) {
        super.applyQueryParameters(params);
        if (this.cause != null) {
            params.put("cause", this.cause);
        }
        if (this.clusterManagerTimeout != null) {
            params.put("cluster_manager_timeout", this.clusterManagerTimeout._toJsonString());
        }
        if (this.create != null) {
            params.put("create", String.valueOf(this.create));
        }
        if (this.masterTimeout != null) {
            params.put("master_timeout", this.masterTimeout._toJsonString());
        }
    }

    /**
     * Endpoint "{@code indices.put_index_template}".
     */
    public static final Endpoint<PutIndexTemplateRequest, PutIndexTemplateResponse, ErrorResponse> _ENDPOINT = new SimpleEndpoint<>(
        // Request method
        request -> "PUT",
        // Request path
        request -> {
            StringBuilder buf = new StringBuilder();
            buf.append("/_index_template/");
            SimpleEndpoint.pathEncode(request.name, buf);
            return buf.toString();
        },
        // Request parameters
        request -> {
            Map<String, String> params = new HashMap<>();
            request.applyQueryParameters(params);
            return params;
        },
        SimpleEndpoint.emptyMap(),
        true,
        PutIndexTemplateResponse._DESERIALIZER
    );

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.cause);
        result = 31 * result + Objects.hashCode(this.clusterManagerTimeout);
        result = 31 * result + Objects.hashCode(this.composedOf);
        result = 31 * result + Objects.hashCode(this.create);
        result = 31 * result + Objects.hashCode(this.dataStream);
        result = 31 * result + Objects.hashCode(this.indexPatterns);
        result = 31 * result + Objects.hashCode(this.masterTimeout);
        result = 31 * result + Objects.hashCode(this.meta);
        result = 31 * result + this.name.hashCode();
        result = 31 * result + Objects.hashCode(this.priority);
        result = 31 * result + Objects.hashCode(this.template);
        result = 31 * result + Objects.hashCode(this.version);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        PutIndexTemplateRequest other = (PutIndexTemplateRequest) o;
        return Objects.equals(this.cause, other.cause)
            && Objects.equals(this.clusterManagerTimeout, other.clusterManagerTimeout)
            && Objects.equals(this.composedOf, other.composedOf)
            && Objects.equals(this.create, other.create)
            && Objects.equals(this.dataStream, other.dataStream)
            && Objects.equals(this.indexPatterns, other.indexPatterns)
            && Objects.equals(this.masterTimeout, other.masterTimeout)
            && Objects.equals(this.meta, other.meta)
            && this.name.equals(other.name)
            && Objects.equals(this.priority, other.priority)
            && Objects.equals(this.template, other.template)
            && Objects.equals(this.version, other.version);
    }
}
