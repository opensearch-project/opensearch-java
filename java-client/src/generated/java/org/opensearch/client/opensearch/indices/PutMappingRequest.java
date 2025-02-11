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
import java.util.stream.Collectors;
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
import org.opensearch.client.opensearch._types.ExpandWildcard;
import org.opensearch.client.opensearch._types.RequestBase;
import org.opensearch.client.opensearch._types.Time;
import org.opensearch.client.opensearch._types.mapping.DynamicMapping;
import org.opensearch.client.opensearch._types.mapping.DynamicTemplate;
import org.opensearch.client.opensearch._types.mapping.FieldNamesField;
import org.opensearch.client.opensearch._types.mapping.Property;
import org.opensearch.client.opensearch._types.mapping.RoutingField;
import org.opensearch.client.opensearch._types.mapping.SourceField;
import org.opensearch.client.transport.Endpoint;
import org.opensearch.client.transport.endpoints.SimpleEndpoint;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: indices.put_mapping.Request

/**
 * Updates the index mappings.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public final class PutMappingRequest extends RequestBase
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<PutMappingRequest.Builder, PutMappingRequest> {

    @Nullable
    private final Boolean allowNoIndices;

    @Nullable
    private final Time clusterManagerTimeout;

    @Nullable
    private final Boolean dateDetection;

    @Nullable
    private final DynamicMapping dynamic;

    @Nonnull
    private final List<String> dynamicDateFormats;

    @Nonnull
    private final List<Map<String, DynamicTemplate>> dynamicTemplates;

    @Nonnull
    private final List<ExpandWildcard> expandWildcards;

    @Nullable
    private final FieldNamesField fieldNames;

    @Nullable
    private final Boolean ignoreUnavailable;

    @Nonnull
    private final List<String> index;

    @Deprecated
    @Nullable
    private final Time masterTimeout;

    @Nonnull
    private final Map<String, JsonData> meta;

    @Nullable
    private final Boolean numericDetection;

    @Nonnull
    private final Map<String, Property> properties;

    @Nullable
    private final RoutingField routing;

    @Nullable
    private final SourceField source;

    @Nullable
    private final Time timeout;

    @Nullable
    private final Boolean writeIndexOnly;

    // ---------------------------------------------------------------------------------------------

    private PutMappingRequest(Builder builder) {
        super(builder);
        this.allowNoIndices = builder.allowNoIndices;
        this.clusterManagerTimeout = builder.clusterManagerTimeout;
        this.dateDetection = builder.dateDetection;
        this.dynamic = builder.dynamic;
        this.dynamicDateFormats = ApiTypeHelper.unmodifiable(builder.dynamicDateFormats);
        this.dynamicTemplates = ApiTypeHelper.unmodifiable(builder.dynamicTemplates);
        this.expandWildcards = ApiTypeHelper.unmodifiable(builder.expandWildcards);
        this.fieldNames = builder.fieldNames;
        this.ignoreUnavailable = builder.ignoreUnavailable;
        this.index = ApiTypeHelper.unmodifiableRequired(builder.index, this, "index");
        this.masterTimeout = builder.masterTimeout;
        this.meta = ApiTypeHelper.unmodifiable(builder.meta);
        this.numericDetection = builder.numericDetection;
        this.properties = ApiTypeHelper.unmodifiable(builder.properties);
        this.routing = builder.routing;
        this.source = builder.source;
        this.timeout = builder.timeout;
        this.writeIndexOnly = builder.writeIndexOnly;
    }

    public static PutMappingRequest of(Function<PutMappingRequest.Builder, ObjectBuilder<PutMappingRequest>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * If <code>false</code>, the request returns an error if any wildcard expression, index alias, or <code>_all</code> value targets only
     * missing or closed indexes. This behavior applies even if the request targets other open indexes.
     * <p>
     * API name: {@code allow_no_indices}
     * </p>
     */
    @Nullable
    public final Boolean allowNoIndices() {
        return this.allowNoIndices;
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
     * Controls whether dynamic date detection is enabled.
     * <p>
     * API name: {@code date_detection}
     * </p>
     */
    @Nullable
    public final Boolean dateDetection() {
        return this.dateDetection;
    }

    /**
     * API name: {@code dynamic}
     */
    @Nullable
    public final DynamicMapping dynamic() {
        return this.dynamic;
    }

    /**
     * If date detection is enabled then new string fields are checked against <code>dynamic_date_formats</code> and if the value matches
     * then a new date field is added instead of string.
     * <p>
     * API name: {@code dynamic_date_formats}
     * </p>
     */
    @Nonnull
    public final List<String> dynamicDateFormats() {
        return this.dynamicDateFormats;
    }

    /**
     * Specify dynamic templates for the mapping.
     * <p>
     * API name: {@code dynamic_templates}
     * </p>
     */
    @Nonnull
    public final List<Map<String, DynamicTemplate>> dynamicTemplates() {
        return this.dynamicTemplates;
    }

    /**
     * Type of index that wildcard patterns can match. If the request can target data streams, this argument determines whether wildcard
     * expressions match hidden data streams. Supports comma-separated values, such as <code>open,hidden</code>. Valid values are:
     * <code>all</code>, <code>open</code>, <code>closed</code>, <code>hidden</code>, <code>none</code>.
     * <p>
     * API name: {@code expand_wildcards}
     * </p>
     */
    @Nonnull
    public final List<ExpandWildcard> expandWildcards() {
        return this.expandWildcards;
    }

    /**
     * API name: {@code _field_names}
     */
    @Nullable
    public final FieldNamesField fieldNames() {
        return this.fieldNames;
    }

    /**
     * If <code>false</code>, the request returns an error if it targets a missing or closed index.
     * <p>
     * API name: {@code ignore_unavailable}
     * </p>
     */
    @Nullable
    public final Boolean ignoreUnavailable() {
        return this.ignoreUnavailable;
    }

    /**
     * Required - A comma-separated list of index names the mapping should be added to (supports wildcards); use <code>_all</code> or omit
     * to add the mapping on all indexes.
     * <p>
     * API name: {@code index}
     * </p>
     */
    @Nonnull
    public final List<String> index() {
        return this.index;
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
     * API name: {@code _meta}
     */
    @Nonnull
    public final Map<String, JsonData> meta() {
        return this.meta;
    }

    /**
     * Automatically map strings into numeric data types for all fields.
     * <p>
     * API name: {@code numeric_detection}
     * </p>
     */
    @Nullable
    public final Boolean numericDetection() {
        return this.numericDetection;
    }

    /**
     * <p>
     * Mapping for a field. For new fields, this mapping can include:
     * </p>
     * <ul>
     * <li>Field name</li>
     * <li>Field data type</li>
     * <li>Mapping parameters</li>
     * </ul>
     * <p>
     * API name: {@code properties}
     * </p>
     */
    @Nonnull
    public final Map<String, Property> properties() {
        return this.properties;
    }

    /**
     * API name: {@code _routing}
     */
    @Nullable
    public final RoutingField routing() {
        return this.routing;
    }

    /**
     * API name: {@code _source}
     */
    @Nullable
    public final SourceField source() {
        return this.source;
    }

    /**
     * Period to wait for a response. If no response is received before the timeout expires, the request fails and returns an error.
     * <p>
     * API name: {@code timeout}
     * </p>
     */
    @Nullable
    public final Time timeout() {
        return this.timeout;
    }

    /**
     * If <code>true</code>, the mappings are applied only to the current write index for the target.
     * <p>
     * API name: {@code write_index_only}
     * </p>
     */
    @Nullable
    public final Boolean writeIndexOnly() {
        return this.writeIndexOnly;
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
        if (this.dateDetection != null) {
            generator.writeKey("date_detection");
            generator.write(this.dateDetection);
        }

        if (this.dynamic != null) {
            generator.writeKey("dynamic");
            this.dynamic.serialize(generator, mapper);
        }

        if (ApiTypeHelper.isDefined(this.dynamicDateFormats)) {
            generator.writeKey("dynamic_date_formats");
            generator.writeStartArray();
            for (String item0 : this.dynamicDateFormats) {
                generator.write(item0);
            }
            generator.writeEnd();
        }

        if (ApiTypeHelper.isDefined(this.dynamicTemplates)) {
            generator.writeKey("dynamic_templates");
            generator.writeStartArray();
            for (Map<String, DynamicTemplate> item0 : this.dynamicTemplates) {
                generator.writeStartObject();
                if (item0 != null) {
                    for (Map.Entry<String, DynamicTemplate> item1 : item0.entrySet()) {
                        generator.writeKey(item1.getKey());
                        item1.getValue().serialize(generator, mapper);
                    }
                }
                generator.writeEnd();
            }
            generator.writeEnd();
        }

        if (this.fieldNames != null) {
            generator.writeKey("_field_names");
            this.fieldNames.serialize(generator, mapper);
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

        if (this.numericDetection != null) {
            generator.writeKey("numeric_detection");
            generator.write(this.numericDetection);
        }

        if (ApiTypeHelper.isDefined(this.properties)) {
            generator.writeKey("properties");
            generator.writeStartObject();
            for (Map.Entry<String, Property> item0 : this.properties.entrySet()) {
                generator.writeKey(item0.getKey());
                item0.getValue().serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        if (this.routing != null) {
            generator.writeKey("_routing");
            this.routing.serialize(generator, mapper);
        }

        if (this.source != null) {
            generator.writeKey("_source");
            this.source.serialize(generator, mapper);
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
     * Builder for {@link PutMappingRequest}.
     */
    public static class Builder extends RequestBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, PutMappingRequest> {
        @Nullable
        private Boolean allowNoIndices;
        @Nullable
        private Time clusterManagerTimeout;
        @Nullable
        private Boolean dateDetection;
        @Nullable
        private DynamicMapping dynamic;
        @Nullable
        private List<String> dynamicDateFormats;
        @Nullable
        private List<Map<String, DynamicTemplate>> dynamicTemplates;
        @Nullable
        private List<ExpandWildcard> expandWildcards;
        @Nullable
        private FieldNamesField fieldNames;
        @Nullable
        private Boolean ignoreUnavailable;
        private List<String> index;
        @Nullable
        private Time masterTimeout;
        @Nullable
        private Map<String, JsonData> meta;
        @Nullable
        private Boolean numericDetection;
        @Nullable
        private Map<String, Property> properties;
        @Nullable
        private RoutingField routing;
        @Nullable
        private SourceField source;
        @Nullable
        private Time timeout;
        @Nullable
        private Boolean writeIndexOnly;

        public Builder() {}

        private Builder(PutMappingRequest o) {
            super(o);
            this.allowNoIndices = o.allowNoIndices;
            this.clusterManagerTimeout = o.clusterManagerTimeout;
            this.dateDetection = o.dateDetection;
            this.dynamic = o.dynamic;
            this.dynamicDateFormats = _listCopy(o.dynamicDateFormats);
            this.dynamicTemplates = _listCopy(o.dynamicTemplates);
            this.expandWildcards = _listCopy(o.expandWildcards);
            this.fieldNames = o.fieldNames;
            this.ignoreUnavailable = o.ignoreUnavailable;
            this.index = _listCopy(o.index);
            this.masterTimeout = o.masterTimeout;
            this.meta = _mapCopy(o.meta);
            this.numericDetection = o.numericDetection;
            this.properties = _mapCopy(o.properties);
            this.routing = o.routing;
            this.source = o.source;
            this.timeout = o.timeout;
            this.writeIndexOnly = o.writeIndexOnly;
        }

        private Builder(Builder o) {
            super(o);
            this.allowNoIndices = o.allowNoIndices;
            this.clusterManagerTimeout = o.clusterManagerTimeout;
            this.dateDetection = o.dateDetection;
            this.dynamic = o.dynamic;
            this.dynamicDateFormats = _listCopy(o.dynamicDateFormats);
            this.dynamicTemplates = _listCopy(o.dynamicTemplates);
            this.expandWildcards = _listCopy(o.expandWildcards);
            this.fieldNames = o.fieldNames;
            this.ignoreUnavailable = o.ignoreUnavailable;
            this.index = _listCopy(o.index);
            this.masterTimeout = o.masterTimeout;
            this.meta = _mapCopy(o.meta);
            this.numericDetection = o.numericDetection;
            this.properties = _mapCopy(o.properties);
            this.routing = o.routing;
            this.source = o.source;
            this.timeout = o.timeout;
            this.writeIndexOnly = o.writeIndexOnly;
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
         * If <code>false</code>, the request returns an error if any wildcard expression, index alias, or <code>_all</code> value targets
         * only missing or closed indexes. This behavior applies even if the request targets other open indexes.
         * <p>
         * API name: {@code allow_no_indices}
         * </p>
         */
        @Nonnull
        public final Builder allowNoIndices(@Nullable Boolean value) {
            this.allowNoIndices = value;
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
         * Controls whether dynamic date detection is enabled.
         * <p>
         * API name: {@code date_detection}
         * </p>
         */
        @Nonnull
        public final Builder dateDetection(@Nullable Boolean value) {
            this.dateDetection = value;
            return this;
        }

        /**
         * API name: {@code dynamic}
         */
        @Nonnull
        public final Builder dynamic(@Nullable DynamicMapping value) {
            this.dynamic = value;
            return this;
        }

        /**
         * If date detection is enabled then new string fields are checked against <code>dynamic_date_formats</code> and if the value
         * matches then a new date field is added instead of string.
         * <p>
         * API name: {@code dynamic_date_formats}
         * </p>
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>dynamicDateFormats</code>.
         * </p>
         */
        @Nonnull
        public final Builder dynamicDateFormats(List<String> list) {
            this.dynamicDateFormats = _listAddAll(this.dynamicDateFormats, list);
            return this;
        }

        /**
         * If date detection is enabled then new string fields are checked against <code>dynamic_date_formats</code> and if the value
         * matches then a new date field is added instead of string.
         * <p>
         * API name: {@code dynamic_date_formats}
         * </p>
         *
         * <p>
         * Adds one or more values to <code>dynamicDateFormats</code>.
         * </p>
         */
        @Nonnull
        public final Builder dynamicDateFormats(String value, String... values) {
            this.dynamicDateFormats = _listAdd(this.dynamicDateFormats, value, values);
            return this;
        }

        /**
         * Specify dynamic templates for the mapping.
         * <p>
         * API name: {@code dynamic_templates}
         * </p>
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>dynamicTemplates</code>.
         * </p>
         */
        @Nonnull
        public final Builder dynamicTemplates(List<Map<String, DynamicTemplate>> list) {
            this.dynamicTemplates = _listAddAll(this.dynamicTemplates, list);
            return this;
        }

        /**
         * Specify dynamic templates for the mapping.
         * <p>
         * API name: {@code dynamic_templates}
         * </p>
         *
         * <p>
         * Adds one or more values to <code>dynamicTemplates</code>.
         * </p>
         */
        @Nonnull
        public final Builder dynamicTemplates(Map<String, DynamicTemplate> value, Map<String, DynamicTemplate>... values) {
            this.dynamicTemplates = _listAdd(this.dynamicTemplates, value, values);
            return this;
        }

        /**
         * Type of index that wildcard patterns can match. If the request can target data streams, this argument determines whether wildcard
         * expressions match hidden data streams. Supports comma-separated values, such as <code>open,hidden</code>. Valid values are:
         * <code>all</code>, <code>open</code>, <code>closed</code>, <code>hidden</code>, <code>none</code>.
         * <p>
         * API name: {@code expand_wildcards}
         * </p>
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>expandWildcards</code>.
         * </p>
         */
        @Nonnull
        public final Builder expandWildcards(List<ExpandWildcard> list) {
            this.expandWildcards = _listAddAll(this.expandWildcards, list);
            return this;
        }

        /**
         * Type of index that wildcard patterns can match. If the request can target data streams, this argument determines whether wildcard
         * expressions match hidden data streams. Supports comma-separated values, such as <code>open,hidden</code>. Valid values are:
         * <code>all</code>, <code>open</code>, <code>closed</code>, <code>hidden</code>, <code>none</code>.
         * <p>
         * API name: {@code expand_wildcards}
         * </p>
         *
         * <p>
         * Adds one or more values to <code>expandWildcards</code>.
         * </p>
         */
        @Nonnull
        public final Builder expandWildcards(ExpandWildcard value, ExpandWildcard... values) {
            this.expandWildcards = _listAdd(this.expandWildcards, value, values);
            return this;
        }

        /**
         * API name: {@code _field_names}
         */
        @Nonnull
        public final Builder fieldNames(@Nullable FieldNamesField value) {
            this.fieldNames = value;
            return this;
        }

        /**
         * API name: {@code _field_names}
         */
        @Nonnull
        public final Builder fieldNames(Function<FieldNamesField.Builder, ObjectBuilder<FieldNamesField>> fn) {
            return fieldNames(fn.apply(new FieldNamesField.Builder()).build());
        }

        /**
         * If <code>false</code>, the request returns an error if it targets a missing or closed index.
         * <p>
         * API name: {@code ignore_unavailable}
         * </p>
         */
        @Nonnull
        public final Builder ignoreUnavailable(@Nullable Boolean value) {
            this.ignoreUnavailable = value;
            return this;
        }

        /**
         * Required - A comma-separated list of index names the mapping should be added to (supports wildcards); use <code>_all</code> or
         * omit to add the mapping on all indexes.
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
         * Required - A comma-separated list of index names the mapping should be added to (supports wildcards); use <code>_all</code> or
         * omit to add the mapping on all indexes.
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
         * Automatically map strings into numeric data types for all fields.
         * <p>
         * API name: {@code numeric_detection}
         * </p>
         */
        @Nonnull
        public final Builder numericDetection(@Nullable Boolean value) {
            this.numericDetection = value;
            return this;
        }

        /**
         * <p>
         * Mapping for a field. For new fields, this mapping can include:
         * </p>
         * <ul>
         * <li>Field name</li>
         * <li>Field data type</li>
         * <li>Mapping parameters</li>
         * </ul>
         * <p>
         * API name: {@code properties}
         * </p>
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>properties</code>.
         * </p>
         */
        @Nonnull
        public final Builder properties(Map<String, Property> map) {
            this.properties = _mapPutAll(this.properties, map);
            return this;
        }

        /**
         * <p>
         * Mapping for a field. For new fields, this mapping can include:
         * </p>
         * <ul>
         * <li>Field name</li>
         * <li>Field data type</li>
         * <li>Mapping parameters</li>
         * </ul>
         * <p>
         * API name: {@code properties}
         * </p>
         *
         * <p>
         * Adds an entry to <code>properties</code>.
         * </p>
         */
        @Nonnull
        public final Builder properties(String key, Property value) {
            this.properties = _mapPut(this.properties, key, value);
            return this;
        }

        /**
         * <p>
         * Mapping for a field. For new fields, this mapping can include:
         * </p>
         * <ul>
         * <li>Field name</li>
         * <li>Field data type</li>
         * <li>Mapping parameters</li>
         * </ul>
         * <p>
         * API name: {@code properties}
         * </p>
         *
         * <p>
         * Adds a value to <code>properties</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder properties(String key, Function<Property.Builder, ObjectBuilder<Property>> fn) {
            return properties(key, fn.apply(new Property.Builder()).build());
        }

        /**
         * API name: {@code _routing}
         */
        @Nonnull
        public final Builder routing(@Nullable RoutingField value) {
            this.routing = value;
            return this;
        }

        /**
         * API name: {@code _routing}
         */
        @Nonnull
        public final Builder routing(Function<RoutingField.Builder, ObjectBuilder<RoutingField>> fn) {
            return routing(fn.apply(new RoutingField.Builder()).build());
        }

        /**
         * API name: {@code _source}
         */
        @Nonnull
        public final Builder source(@Nullable SourceField value) {
            this.source = value;
            return this;
        }

        /**
         * API name: {@code _source}
         */
        @Nonnull
        public final Builder source(Function<SourceField.Builder, ObjectBuilder<SourceField>> fn) {
            return source(fn.apply(new SourceField.Builder()).build());
        }

        /**
         * Period to wait for a response. If no response is received before the timeout expires, the request fails and returns an error.
         * <p>
         * API name: {@code timeout}
         * </p>
         */
        @Nonnull
        public final Builder timeout(@Nullable Time value) {
            this.timeout = value;
            return this;
        }

        /**
         * Period to wait for a response. If no response is received before the timeout expires, the request fails and returns an error.
         * <p>
         * API name: {@code timeout}
         * </p>
         */
        @Nonnull
        public final Builder timeout(Function<Time.Builder, ObjectBuilder<Time>> fn) {
            return timeout(fn.apply(new Time.Builder()).build());
        }

        /**
         * If <code>true</code>, the mappings are applied only to the current write index for the target.
         * <p>
         * API name: {@code write_index_only}
         * </p>
         */
        @Nonnull
        public final Builder writeIndexOnly(@Nullable Boolean value) {
            this.writeIndexOnly = value;
            return this;
        }

        /**
         * Builds a {@link PutMappingRequest}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public PutMappingRequest build() {
            _checkSingleUse();

            return new PutMappingRequest(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link PutMappingRequest}
     */
    public static final JsonpDeserializer<PutMappingRequest> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        PutMappingRequest::setupPutMappingRequestDeserializer
    );

    protected static void setupPutMappingRequestDeserializer(ObjectDeserializer<PutMappingRequest.Builder> op) {
        op.add(Builder::dateDetection, JsonpDeserializer.booleanDeserializer(), "date_detection");
        op.add(Builder::dynamic, DynamicMapping._DESERIALIZER, "dynamic");
        op.add(
            Builder::dynamicDateFormats,
            JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()),
            "dynamic_date_formats"
        );
        op.add(
            Builder::dynamicTemplates,
            JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringMapDeserializer(DynamicTemplate._DESERIALIZER)),
            "dynamic_templates"
        );
        op.add(Builder::fieldNames, FieldNamesField._DESERIALIZER, "_field_names");
        op.add(Builder::meta, JsonpDeserializer.stringMapDeserializer(JsonData._DESERIALIZER), "_meta");
        op.add(Builder::numericDetection, JsonpDeserializer.booleanDeserializer(), "numeric_detection");
        op.add(Builder::properties, JsonpDeserializer.stringMapDeserializer(Property._DESERIALIZER), "properties");
        op.add(Builder::routing, RoutingField._DESERIALIZER, "_routing");
        op.add(Builder::source, SourceField._DESERIALIZER, "_source");
    }

    // ---------------------------------------------------------------------------------------------

    @Override
    protected void applyQueryParameters(@Nonnull Map<String, String> params) {
        super.applyQueryParameters(params);
        if (this.allowNoIndices != null) {
            params.put("allow_no_indices", String.valueOf(this.allowNoIndices));
        }
        if (this.clusterManagerTimeout != null) {
            params.put("cluster_manager_timeout", this.clusterManagerTimeout._toJsonString());
        }
        if (ApiTypeHelper.isDefined(this.expandWildcards)) {
            params.put("expand_wildcards", this.expandWildcards.stream().map(v -> v.jsonValue()).collect(Collectors.joining(",")));
        }
        if (this.ignoreUnavailable != null) {
            params.put("ignore_unavailable", String.valueOf(this.ignoreUnavailable));
        }
        if (this.masterTimeout != null) {
            params.put("master_timeout", this.masterTimeout._toJsonString());
        }
        if (this.timeout != null) {
            params.put("timeout", this.timeout._toJsonString());
        }
        if (this.writeIndexOnly != null) {
            params.put("write_index_only", String.valueOf(this.writeIndexOnly));
        }
    }

    /**
     * Endpoint "{@code indices.put_mapping}".
     */
    public static final Endpoint<PutMappingRequest, PutMappingResponse, ErrorResponse> _ENDPOINT = new SimpleEndpoint<>(
        // Request method
        request -> "PUT",
        // Request path
        request -> {
            StringBuilder buf = new StringBuilder();
            buf.append("/");
            SimpleEndpoint.pathEncode(String.join(",", request.index), buf);
            buf.append("/_mapping");
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
        PutMappingResponse._DESERIALIZER
    );

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.allowNoIndices);
        result = 31 * result + Objects.hashCode(this.clusterManagerTimeout);
        result = 31 * result + Objects.hashCode(this.dateDetection);
        result = 31 * result + Objects.hashCode(this.dynamic);
        result = 31 * result + Objects.hashCode(this.dynamicDateFormats);
        result = 31 * result + Objects.hashCode(this.dynamicTemplates);
        result = 31 * result + Objects.hashCode(this.expandWildcards);
        result = 31 * result + Objects.hashCode(this.fieldNames);
        result = 31 * result + Objects.hashCode(this.ignoreUnavailable);
        result = 31 * result + this.index.hashCode();
        result = 31 * result + Objects.hashCode(this.masterTimeout);
        result = 31 * result + Objects.hashCode(this.meta);
        result = 31 * result + Objects.hashCode(this.numericDetection);
        result = 31 * result + Objects.hashCode(this.properties);
        result = 31 * result + Objects.hashCode(this.routing);
        result = 31 * result + Objects.hashCode(this.source);
        result = 31 * result + Objects.hashCode(this.timeout);
        result = 31 * result + Objects.hashCode(this.writeIndexOnly);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        PutMappingRequest other = (PutMappingRequest) o;
        return Objects.equals(this.allowNoIndices, other.allowNoIndices)
            && Objects.equals(this.clusterManagerTimeout, other.clusterManagerTimeout)
            && Objects.equals(this.dateDetection, other.dateDetection)
            && Objects.equals(this.dynamic, other.dynamic)
            && Objects.equals(this.dynamicDateFormats, other.dynamicDateFormats)
            && Objects.equals(this.dynamicTemplates, other.dynamicTemplates)
            && Objects.equals(this.expandWildcards, other.expandWildcards)
            && Objects.equals(this.fieldNames, other.fieldNames)
            && Objects.equals(this.ignoreUnavailable, other.ignoreUnavailable)
            && this.index.equals(other.index)
            && Objects.equals(this.masterTimeout, other.masterTimeout)
            && Objects.equals(this.meta, other.meta)
            && Objects.equals(this.numericDetection, other.numericDetection)
            && Objects.equals(this.properties, other.properties)
            && Objects.equals(this.routing, other.routing)
            && Objects.equals(this.source, other.source)
            && Objects.equals(this.timeout, other.timeout)
            && Objects.equals(this.writeIndexOnly, other.writeIndexOnly);
    }
}
