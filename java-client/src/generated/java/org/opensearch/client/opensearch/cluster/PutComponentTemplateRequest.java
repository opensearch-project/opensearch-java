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

package org.opensearch.client.opensearch.cluster;

import jakarta.json.stream.JsonGenerator;
import java.util.HashMap;
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
import org.opensearch.client.opensearch.indices.IndexState;
import org.opensearch.client.transport.Endpoint;
import org.opensearch.client.transport.endpoints.SimpleEndpoint;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: cluster.put_component_template.Request

/**
 * Creates or updates a component template.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public final class PutComponentTemplateRequest extends RequestBase
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<PutComponentTemplateRequest.Builder, PutComponentTemplateRequest> {

    @Nullable
    private final Boolean allowAutoCreate;

    @Nullable
    private final Time clusterManagerTimeout;

    @Nullable
    private final Boolean create;

    @Deprecated
    @Nullable
    private final Time masterTimeout;

    @Nonnull
    private final Map<String, JsonData> meta;

    @Nonnull
    private final String name;

    @Nonnull
    private final IndexState template;

    @Nullable
    private final Time timeout;

    @Nullable
    private final Long version;

    // ---------------------------------------------------------------------------------------------

    private PutComponentTemplateRequest(Builder builder) {
        super(builder);
        this.allowAutoCreate = builder.allowAutoCreate;
        this.clusterManagerTimeout = builder.clusterManagerTimeout;
        this.create = builder.create;
        this.masterTimeout = builder.masterTimeout;
        this.meta = ApiTypeHelper.unmodifiable(builder.meta);
        this.name = ApiTypeHelper.requireNonNull(builder.name, this, "name");
        this.template = ApiTypeHelper.requireNonNull(builder.template, this, "template");
        this.timeout = builder.timeout;
        this.version = builder.version;
    }

    public static PutComponentTemplateRequest of(
        Function<PutComponentTemplateRequest.Builder, ObjectBuilder<PutComponentTemplateRequest>> fn
    ) {
        return fn.apply(new Builder()).build();
    }

    /**
     * This setting overrides the <code>action.auto_create_index</code> cluster setting. When set to <code>true</code> in a component
     * template, indexes are automatically created using that template. When set to <code>false</code>, data streams matching the component
     * template must always be explicitly created.
     * <p>
     * API name: {@code allow_auto_create}
     * </p>
     */
    @Nullable
    public final Boolean allowAutoCreate() {
        return this.allowAutoCreate;
    }

    /**
     * A duration. Units can be <code>nanos</code>, <code>micros</code>, <code>ms</code> (milliseconds), <code>s</code> (seconds),
     * <code>m</code> (minutes), <code>h</code> (hours) and <code>d</code> (days). Also accepts &quot;0&quot; without a unit and
     * &quot;-1&quot; to indicate an unspecified value.
     * <p>
     * API name: {@code cluster_manager_timeout}
     * </p>
     */
    @Nullable
    public final Time clusterManagerTimeout() {
        return this.clusterManagerTimeout;
    }

    /**
     * When <code>true</code>, this request cannot replace or update existing component templates.
     * <p>
     * API name: {@code create}
     * </p>
     */
    @Nullable
    public final Boolean create() {
        return this.create;
    }

    /**
     * A duration. Units can be <code>nanos</code>, <code>micros</code>, <code>ms</code> (milliseconds), <code>s</code> (seconds),
     * <code>m</code> (minutes), <code>h</code> (hours) and <code>d</code> (days). Also accepts &quot;0&quot; without a unit and
     * &quot;-1&quot; to indicate an unspecified value.
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
     * Required - The name of the component template to create. OpenSearch includes the following built-in component templates:
     * <code>logs-mappings</code>; <code>logs-settings</code>; <code>metrics-mappings</code>; <code>metrics-settings</code>;
     * <code>synthetics-mapping</code>; <code>synthetics-settings</code>. OpenSearch uses these templates to configure backing indexes for
     * its data streams. If you want to overwrite one of these templates, set the replacement template <code>version</code> to a higher
     * value than the current version. If you want to disable all built-in component and index templates, set
     * <code>stack.templates.enabled</code> to <code>false</code> using the Cluster Update Settings API.
     * <p>
     * API name: {@code name}
     * </p>
     */
    @Nonnull
    public final String name() {
        return this.name;
    }

    /**
     * Required - API name: {@code template}
     */
    @Nonnull
    public final IndexState template() {
        return this.template;
    }

    /**
     * A duration. Units can be <code>nanos</code>, <code>micros</code>, <code>ms</code> (milliseconds), <code>s</code> (seconds),
     * <code>m</code> (minutes), <code>h</code> (hours) and <code>d</code> (days). Also accepts &quot;0&quot; without a unit and
     * &quot;-1&quot; to indicate an unspecified value.
     * <p>
     * API name: {@code timeout}
     * </p>
     */
    @Nullable
    public final Time timeout() {
        return this.timeout;
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
        if (this.allowAutoCreate != null) {
            generator.writeKey("allow_auto_create");
            generator.write(this.allowAutoCreate);
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

        generator.writeKey("template");
        this.template.serialize(generator, mapper);

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
     * Builder for {@link PutComponentTemplateRequest}.
     */
    public static class Builder extends RequestBase.AbstractBuilder<Builder>
        implements
            CopyableBuilder<Builder, PutComponentTemplateRequest> {
        @Nullable
        private Boolean allowAutoCreate;
        @Nullable
        private Time clusterManagerTimeout;
        @Nullable
        private Boolean create;
        @Nullable
        private Time masterTimeout;
        @Nullable
        private Map<String, JsonData> meta;
        private String name;
        private IndexState template;
        @Nullable
        private Time timeout;
        @Nullable
        private Long version;

        public Builder() {}

        private Builder(PutComponentTemplateRequest o) {
            super(o);
            this.allowAutoCreate = o.allowAutoCreate;
            this.clusterManagerTimeout = o.clusterManagerTimeout;
            this.create = o.create;
            this.masterTimeout = o.masterTimeout;
            this.meta = _mapCopy(o.meta);
            this.name = o.name;
            this.template = o.template;
            this.timeout = o.timeout;
            this.version = o.version;
        }

        private Builder(Builder o) {
            super(o);
            this.allowAutoCreate = o.allowAutoCreate;
            this.clusterManagerTimeout = o.clusterManagerTimeout;
            this.create = o.create;
            this.masterTimeout = o.masterTimeout;
            this.meta = _mapCopy(o.meta);
            this.name = o.name;
            this.template = o.template;
            this.timeout = o.timeout;
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
         * This setting overrides the <code>action.auto_create_index</code> cluster setting. When set to <code>true</code> in a component
         * template, indexes are automatically created using that template. When set to <code>false</code>, data streams matching the
         * component template must always be explicitly created.
         * <p>
         * API name: {@code allow_auto_create}
         * </p>
         */
        @Nonnull
        public final Builder allowAutoCreate(@Nullable Boolean value) {
            this.allowAutoCreate = value;
            return this;
        }

        /**
         * A duration. Units can be <code>nanos</code>, <code>micros</code>, <code>ms</code> (milliseconds), <code>s</code> (seconds),
         * <code>m</code> (minutes), <code>h</code> (hours) and <code>d</code> (days). Also accepts &quot;0&quot; without a unit and
         * &quot;-1&quot; to indicate an unspecified value.
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
         * A duration. Units can be <code>nanos</code>, <code>micros</code>, <code>ms</code> (milliseconds), <code>s</code> (seconds),
         * <code>m</code> (minutes), <code>h</code> (hours) and <code>d</code> (days). Also accepts &quot;0&quot; without a unit and
         * &quot;-1&quot; to indicate an unspecified value.
         * <p>
         * API name: {@code cluster_manager_timeout}
         * </p>
         */
        @Nonnull
        public final Builder clusterManagerTimeout(Function<Time.Builder, ObjectBuilder<Time>> fn) {
            return clusterManagerTimeout(fn.apply(new Time.Builder()).build());
        }

        /**
         * When <code>true</code>, this request cannot replace or update existing component templates.
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
         * A duration. Units can be <code>nanos</code>, <code>micros</code>, <code>ms</code> (milliseconds), <code>s</code> (seconds),
         * <code>m</code> (minutes), <code>h</code> (hours) and <code>d</code> (days). Also accepts &quot;0&quot; without a unit and
         * &quot;-1&quot; to indicate an unspecified value.
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
         * A duration. Units can be <code>nanos</code>, <code>micros</code>, <code>ms</code> (milliseconds), <code>s</code> (seconds),
         * <code>m</code> (minutes), <code>h</code> (hours) and <code>d</code> (days). Also accepts &quot;0&quot; without a unit and
         * &quot;-1&quot; to indicate an unspecified value.
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
         * Required - The name of the component template to create. OpenSearch includes the following built-in component templates:
         * <code>logs-mappings</code>; <code>logs-settings</code>; <code>metrics-mappings</code>; <code>metrics-settings</code>;
         * <code>synthetics-mapping</code>; <code>synthetics-settings</code>. OpenSearch uses these templates to configure backing indexes
         * for its data streams. If you want to overwrite one of these templates, set the replacement template <code>version</code> to a
         * higher value than the current version. If you want to disable all built-in component and index templates, set
         * <code>stack.templates.enabled</code> to <code>false</code> using the Cluster Update Settings API.
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
         * Required - API name: {@code template}
         */
        @Nonnull
        public final Builder template(IndexState value) {
            this.template = value;
            return this;
        }

        /**
         * Required - API name: {@code template}
         */
        @Nonnull
        public final Builder template(Function<IndexState.Builder, ObjectBuilder<IndexState>> fn) {
            return template(fn.apply(new IndexState.Builder()).build());
        }

        /**
         * A duration. Units can be <code>nanos</code>, <code>micros</code>, <code>ms</code> (milliseconds), <code>s</code> (seconds),
         * <code>m</code> (minutes), <code>h</code> (hours) and <code>d</code> (days). Also accepts &quot;0&quot; without a unit and
         * &quot;-1&quot; to indicate an unspecified value.
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
         * A duration. Units can be <code>nanos</code>, <code>micros</code>, <code>ms</code> (milliseconds), <code>s</code> (seconds),
         * <code>m</code> (minutes), <code>h</code> (hours) and <code>d</code> (days). Also accepts &quot;0&quot; without a unit and
         * &quot;-1&quot; to indicate an unspecified value.
         * <p>
         * API name: {@code timeout}
         * </p>
         */
        @Nonnull
        public final Builder timeout(Function<Time.Builder, ObjectBuilder<Time>> fn) {
            return timeout(fn.apply(new Time.Builder()).build());
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
         * Builds a {@link PutComponentTemplateRequest}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public PutComponentTemplateRequest build() {
            _checkSingleUse();

            return new PutComponentTemplateRequest(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link PutComponentTemplateRequest}
     */
    public static final JsonpDeserializer<PutComponentTemplateRequest> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        PutComponentTemplateRequest::setupPutComponentTemplateRequestDeserializer
    );

    protected static void setupPutComponentTemplateRequestDeserializer(ObjectDeserializer<PutComponentTemplateRequest.Builder> op) {
        op.add(Builder::allowAutoCreate, JsonpDeserializer.booleanDeserializer(), "allow_auto_create");
        op.add(Builder::meta, JsonpDeserializer.stringMapDeserializer(JsonData._DESERIALIZER), "_meta");
        op.add(Builder::template, IndexState._DESERIALIZER, "template");
        op.add(Builder::version, JsonpDeserializer.longDeserializer(), "version");
    }

    // ---------------------------------------------------------------------------------------------

    @Override
    protected void applyQueryParameters(@Nonnull Map<String, String> params) {
        super.applyQueryParameters(params);
        if (this.clusterManagerTimeout != null) {
            params.put("cluster_manager_timeout", this.clusterManagerTimeout._toJsonString());
        }
        if (this.create != null) {
            params.put("create", String.valueOf(this.create));
        }
        if (this.masterTimeout != null) {
            params.put("master_timeout", this.masterTimeout._toJsonString());
        }
        if (this.timeout != null) {
            params.put("timeout", this.timeout._toJsonString());
        }
    }

    /**
     * Endpoint "{@code cluster.put_component_template}".
     */
    public static final Endpoint<PutComponentTemplateRequest, PutComponentTemplateResponse, ErrorResponse> _ENDPOINT = new SimpleEndpoint<>(
        // Request method
        request -> "PUT",
        // Request path
        request -> {
            StringBuilder buf = new StringBuilder();
            buf.append("/_component_template/");
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
        PutComponentTemplateResponse._DESERIALIZER
    );

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.allowAutoCreate);
        result = 31 * result + Objects.hashCode(this.clusterManagerTimeout);
        result = 31 * result + Objects.hashCode(this.create);
        result = 31 * result + Objects.hashCode(this.masterTimeout);
        result = 31 * result + Objects.hashCode(this.meta);
        result = 31 * result + this.name.hashCode();
        result = 31 * result + this.template.hashCode();
        result = 31 * result + Objects.hashCode(this.timeout);
        result = 31 * result + Objects.hashCode(this.version);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        PutComponentTemplateRequest other = (PutComponentTemplateRequest) o;
        return Objects.equals(this.allowAutoCreate, other.allowAutoCreate)
            && Objects.equals(this.clusterManagerTimeout, other.clusterManagerTimeout)
            && Objects.equals(this.create, other.create)
            && Objects.equals(this.masterTimeout, other.masterTimeout)
            && Objects.equals(this.meta, other.meta)
            && this.name.equals(other.name)
            && this.template.equals(other.template)
            && Objects.equals(this.timeout, other.timeout)
            && Objects.equals(this.version, other.version);
    }
}
