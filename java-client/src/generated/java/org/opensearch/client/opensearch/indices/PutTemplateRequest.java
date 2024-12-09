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
import org.opensearch.client.opensearch._types.mapping.TypeMapping;
import org.opensearch.client.transport.Endpoint;
import org.opensearch.client.transport.endpoints.SimpleEndpoint;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: indices.put_template.Request

/**
 * Creates or updates an index template.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class PutTemplateRequest extends RequestBase
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<PutTemplateRequest.Builder, PutTemplateRequest> {

    @Nonnull
    private final Map<String, Alias> aliases;

    @Nullable
    private final Time clusterManagerTimeout;

    @Nullable
    private final Boolean create;

    @Nonnull
    private final List<String> indexPatterns;

    @Nullable
    private final TypeMapping mappings;

    @Deprecated
    @Nullable
    private final Time masterTimeout;

    @Nonnull
    private final String name;

    @Nullable
    private final Integer order;

    @Nonnull
    private final Map<String, JsonData> settings;

    @Nullable
    private final Long version;

    // ---------------------------------------------------------------------------------------------

    private PutTemplateRequest(Builder builder) {
        this.aliases = ApiTypeHelper.unmodifiable(builder.aliases);
        this.clusterManagerTimeout = builder.clusterManagerTimeout;
        this.create = builder.create;
        this.indexPatterns = ApiTypeHelper.unmodifiable(builder.indexPatterns);
        this.mappings = builder.mappings;
        this.masterTimeout = builder.masterTimeout;
        this.name = ApiTypeHelper.requireNonNull(builder.name, this, "name");
        this.order = builder.order;
        this.settings = ApiTypeHelper.unmodifiable(builder.settings);
        this.version = builder.version;
    }

    public static PutTemplateRequest of(Function<PutTemplateRequest.Builder, ObjectBuilder<PutTemplateRequest>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Aliases for the index.
     * <p>
     * API name: {@code aliases}
     * </p>
     */
    @Nonnull
    public final Map<String, Alias> aliases() {
        return this.aliases;
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
     * Array of wildcard expressions used to match the names of indexes during creation.
     * <p>
     * API name: {@code index_patterns}
     * </p>
     */
    @Nonnull
    public final List<String> indexPatterns() {
        return this.indexPatterns;
    }

    /**
     * API name: {@code mappings}
     */
    @Nullable
    public final TypeMapping mappings() {
        return this.mappings;
    }

    /**
     * Period to wait for a connection to the cluster-manager node. If no response is received before the timeout expires, the request fails
     * and returns an error.
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
     * Required - The name of the template
     * <p>
     * API name: {@code name}
     * </p>
     */
    @Nonnull
    public final String name() {
        return this.name;
    }

    /**
     * <p>
     * Order in which OpenSearch applies this template if index matches multiple templates.
     * </p>
     * <p>
     * Templates with lower 'order' values are merged first. Templates with higher 'order' values are merged later, overriding templates
     * with lower values.
     * </p>
     * <p>
     * API name: {@code order}
     * </p>
     */
    @Nullable
    public final Integer order() {
        return this.order;
    }

    /**
     * Configuration options for the index.
     * <p>
     * API name: {@code settings}
     * </p>
     */
    @Nonnull
    public final Map<String, JsonData> settings() {
        return this.settings;
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
        if (ApiTypeHelper.isDefined(this.aliases)) {
            generator.writeKey("aliases");
            generator.writeStartObject();
            for (Map.Entry<String, Alias> item0 : this.aliases.entrySet()) {
                generator.writeKey(item0.getKey());
                item0.getValue().serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        if (ApiTypeHelper.isDefined(this.indexPatterns)) {
            generator.writeKey("index_patterns");
            generator.writeStartArray();
            for (String item0 : this.indexPatterns) {
                generator.write(item0);
            }
            generator.writeEnd();
        }

        if (this.mappings != null) {
            generator.writeKey("mappings");
            this.mappings.serialize(generator, mapper);
        }

        if (this.order != null) {
            generator.writeKey("order");
            generator.write(this.order);
        }

        if (ApiTypeHelper.isDefined(this.settings)) {
            generator.writeKey("settings");
            generator.writeStartObject();
            for (Map.Entry<String, JsonData> item0 : this.settings.entrySet()) {
                generator.writeKey(item0.getKey());
                item0.getValue().serialize(generator, mapper);
            }
            generator.writeEnd();
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
     * Builder for {@link PutTemplateRequest}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, PutTemplateRequest> {
        @Nullable
        private Map<String, Alias> aliases;
        @Nullable
        private Time clusterManagerTimeout;
        @Nullable
        private Boolean create;
        @Nullable
        private List<String> indexPatterns;
        @Nullable
        private TypeMapping mappings;
        @Nullable
        private Time masterTimeout;
        private String name;
        @Nullable
        private Integer order;
        @Nullable
        private Map<String, JsonData> settings;
        @Nullable
        private Long version;

        public Builder() {}

        private Builder(PutTemplateRequest o) {
            this.aliases = _mapCopy(o.aliases);
            this.clusterManagerTimeout = o.clusterManagerTimeout;
            this.create = o.create;
            this.indexPatterns = _listCopy(o.indexPatterns);
            this.mappings = o.mappings;
            this.masterTimeout = o.masterTimeout;
            this.name = o.name;
            this.order = o.order;
            this.settings = _mapCopy(o.settings);
            this.version = o.version;
        }

        private Builder(Builder o) {
            this.aliases = _mapCopy(o.aliases);
            this.clusterManagerTimeout = o.clusterManagerTimeout;
            this.create = o.create;
            this.indexPatterns = _listCopy(o.indexPatterns);
            this.mappings = o.mappings;
            this.masterTimeout = o.masterTimeout;
            this.name = o.name;
            this.order = o.order;
            this.settings = _mapCopy(o.settings);
            this.version = o.version;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Aliases for the index.
         * <p>
         * API name: {@code aliases}
         * </p>
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>aliases</code>.
         * </p>
         */
        @Nonnull
        public final Builder aliases(Map<String, Alias> map) {
            this.aliases = _mapPutAll(this.aliases, map);
            return this;
        }

        /**
         * Aliases for the index.
         * <p>
         * API name: {@code aliases}
         * </p>
         *
         * <p>
         * Adds an entry to <code>aliases</code>.
         * </p>
         */
        @Nonnull
        public final Builder aliases(String key, Alias value) {
            this.aliases = _mapPut(this.aliases, key, value);
            return this;
        }

        /**
         * Aliases for the index.
         * <p>
         * API name: {@code aliases}
         * </p>
         *
         * <p>
         * Adds a value to <code>aliases</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder aliases(String key, Function<Alias.Builder, ObjectBuilder<Alias>> fn) {
            return aliases(key, fn.apply(new Alias.Builder()).build());
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
         * Array of wildcard expressions used to match the names of indexes during creation.
         * <p>
         * API name: {@code index_patterns}
         * </p>
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
         * Array of wildcard expressions used to match the names of indexes during creation.
         * <p>
         * API name: {@code index_patterns}
         * </p>
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
         * API name: {@code mappings}
         */
        @Nonnull
        public final Builder mappings(@Nullable TypeMapping value) {
            this.mappings = value;
            return this;
        }

        /**
         * API name: {@code mappings}
         */
        @Nonnull
        public final Builder mappings(Function<TypeMapping.Builder, ObjectBuilder<TypeMapping>> fn) {
            return mappings(fn.apply(new TypeMapping.Builder()).build());
        }

        /**
         * Period to wait for a connection to the cluster-manager node. If no response is received before the timeout expires, the request
         * fails and returns an error.
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
         * Period to wait for a connection to the cluster-manager node. If no response is received before the timeout expires, the request
         * fails and returns an error.
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
         * Required - The name of the template
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
         * <p>
         * Order in which OpenSearch applies this template if index matches multiple templates.
         * </p>
         * <p>
         * Templates with lower 'order' values are merged first. Templates with higher 'order' values are merged later, overriding templates
         * with lower values.
         * </p>
         * <p>
         * API name: {@code order}
         * </p>
         */
        @Nonnull
        public final Builder order(@Nullable Integer value) {
            this.order = value;
            return this;
        }

        /**
         * Configuration options for the index.
         * <p>
         * API name: {@code settings}
         * </p>
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>settings</code>.
         * </p>
         */
        @Nonnull
        public final Builder settings(Map<String, JsonData> map) {
            this.settings = _mapPutAll(this.settings, map);
            return this;
        }

        /**
         * Configuration options for the index.
         * <p>
         * API name: {@code settings}
         * </p>
         *
         * <p>
         * Adds an entry to <code>settings</code>.
         * </p>
         */
        @Nonnull
        public final Builder settings(String key, JsonData value) {
            this.settings = _mapPut(this.settings, key, value);
            return this;
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
         * Builds a {@link PutTemplateRequest}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public PutTemplateRequest build() {
            _checkSingleUse();

            return new PutTemplateRequest(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link PutTemplateRequest}
     */
    public static final JsonpDeserializer<PutTemplateRequest> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        PutTemplateRequest::setupPutTemplateRequestDeserializer
    );

    protected static void setupPutTemplateRequestDeserializer(ObjectDeserializer<PutTemplateRequest.Builder> op) {
        op.add(Builder::aliases, JsonpDeserializer.stringMapDeserializer(Alias._DESERIALIZER), "aliases");
        op.add(Builder::indexPatterns, JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()), "index_patterns");
        op.add(Builder::mappings, TypeMapping._DESERIALIZER, "mappings");
        op.add(Builder::name, JsonpDeserializer.stringDeserializer(), "name");
        op.add(Builder::order, JsonpDeserializer.integerDeserializer(), "order");
        op.add(Builder::settings, JsonpDeserializer.stringMapDeserializer(JsonData._DESERIALIZER), "settings");
        op.add(Builder::version, JsonpDeserializer.longDeserializer(), "version");
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Endpoint "{@code indices.put_template}".
     */
    public static final Endpoint<PutTemplateRequest, PutTemplateResponse, ErrorResponse> _ENDPOINT = new SimpleEndpoint<>(
        // Request method
        request -> "PUT",
        // Request path
        request -> {
            StringBuilder buf = new StringBuilder();
            buf.append("/_template/");
            SimpleEndpoint.pathEncode(request.name, buf);
            return buf.toString();
        },
        // Request parameters
        request -> {
            Map<String, String> params = new HashMap<>();
            if (request.clusterManagerTimeout != null) {
                params.put("cluster_manager_timeout", request.clusterManagerTimeout._toJsonString());
            }
            if (request.create != null) {
                params.put("create", String.valueOf(request.create));
            }
            if (request.masterTimeout != null) {
                params.put("master_timeout", request.masterTimeout._toJsonString());
            }
            return params;
        },
        SimpleEndpoint.emptyMap(),
        true,
        PutTemplateResponse._DESERIALIZER
    );

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.aliases);
        result = 31 * result + Objects.hashCode(this.clusterManagerTimeout);
        result = 31 * result + Objects.hashCode(this.create);
        result = 31 * result + Objects.hashCode(this.indexPatterns);
        result = 31 * result + Objects.hashCode(this.mappings);
        result = 31 * result + Objects.hashCode(this.masterTimeout);
        result = 31 * result + this.name.hashCode();
        result = 31 * result + Objects.hashCode(this.order);
        result = 31 * result + Objects.hashCode(this.settings);
        result = 31 * result + Objects.hashCode(this.version);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        PutTemplateRequest other = (PutTemplateRequest) o;
        return Objects.equals(this.aliases, other.aliases)
            && Objects.equals(this.clusterManagerTimeout, other.clusterManagerTimeout)
            && Objects.equals(this.create, other.create)
            && Objects.equals(this.indexPatterns, other.indexPatterns)
            && Objects.equals(this.mappings, other.mappings)
            && Objects.equals(this.masterTimeout, other.masterTimeout)
            && this.name.equals(other.name)
            && Objects.equals(this.order, other.order)
            && Objects.equals(this.settings, other.settings)
            && Objects.equals(this.version, other.version);
    }
}
