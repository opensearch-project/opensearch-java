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

package org.opensearch.client.opensearch.ism;

import jakarta.json.stream.JsonGenerator;
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
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: ism.ErrorNotificationCustomWebhook

/**
 * The custom webhook. Requires <code>url</code> or <code>host</code>.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class ErrorNotificationCustomWebhook
    implements
        ErrorNotificationDestinationVariant,
        PlainJsonSerializable,
        ToCopyableBuilder<ErrorNotificationCustomWebhook.Builder, ErrorNotificationCustomWebhook> {

    @Nonnull
    private final Map<String, String> headerParams;

    @Nullable
    private final String host;

    @Nullable
    private final String password;

    @Nullable
    private final String path;

    @Nullable
    private final Integer port;

    @Nonnull
    private final Map<String, String> queryParams;

    @Nullable
    private final String scheme;

    @Nullable
    private final String url;

    @Nullable
    private final String username;

    // ---------------------------------------------------------------------------------------------

    private ErrorNotificationCustomWebhook(Builder builder) {
        this.headerParams = ApiTypeHelper.unmodifiable(builder.headerParams);
        this.host = builder.host;
        this.password = builder.password;
        this.path = builder.path;
        this.port = builder.port;
        this.queryParams = ApiTypeHelper.unmodifiable(builder.queryParams);
        this.scheme = builder.scheme;
        this.url = builder.url;
        this.username = builder.username;
    }

    public static ErrorNotificationCustomWebhook of(
        Function<ErrorNotificationCustomWebhook.Builder, ObjectBuilder<ErrorNotificationCustomWebhook>> fn
    ) {
        return fn.apply(new Builder()).build();
    }

    /**
     * {@link ErrorNotificationDestination} variant kind.
     */
    @Override
    public ErrorNotificationDestination.Kind _errorNotificationDestinationKind() {
        return ErrorNotificationDestination.Kind.CustomWebhook;
    }

    /**
     * The header parameters for the custom webhook.
     * <p>
     * API name: {@code header_params}
     * </p>
     */
    @Nonnull
    public final Map<String, String> headerParams() {
        return this.headerParams;
    }

    /**
     * The host for the custom webhook.
     * <p>
     * API name: {@code host}
     * </p>
     */
    @Nullable
    public final String host() {
        return this.host;
    }

    /**
     * The password for the custom webhook.
     * <p>
     * API name: {@code password}
     * </p>
     */
    @Nullable
    public final String password() {
        return this.password;
    }

    /**
     * The path for the custom webhook.
     * <p>
     * API name: {@code path}
     * </p>
     */
    @Nullable
    public final String path() {
        return this.path;
    }

    /**
     * The port for the custom webhook.
     * <p>
     * API name: {@code port}
     * </p>
     */
    @Nullable
    public final Integer port() {
        return this.port;
    }

    /**
     * The query parameters for the custom webhook.
     * <p>
     * API name: {@code query_params}
     * </p>
     */
    @Nonnull
    public final Map<String, String> queryParams() {
        return this.queryParams;
    }

    /**
     * The scheme for the custom webhook.
     * <p>
     * API name: {@code scheme}
     * </p>
     */
    @Nullable
    public final String scheme() {
        return this.scheme;
    }

    /**
     * The URL for the custom webhook.
     * <p>
     * API name: {@code url}
     * </p>
     */
    @Nullable
    public final String url() {
        return this.url;
    }

    /**
     * The username for the custom webhook.
     * <p>
     * API name: {@code username}
     * </p>
     */
    @Nullable
    public final String username() {
        return this.username;
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
        if (ApiTypeHelper.isDefined(this.headerParams)) {
            generator.writeKey("header_params");
            generator.writeStartObject();
            for (Map.Entry<String, String> item0 : this.headerParams.entrySet()) {
                generator.writeKey(item0.getKey());
                generator.write(item0.getValue());
            }
            generator.writeEnd();
        }

        if (this.host != null) {
            generator.writeKey("host");
            generator.write(this.host);
        }

        if (this.password != null) {
            generator.writeKey("password");
            generator.write(this.password);
        }

        if (this.path != null) {
            generator.writeKey("path");
            generator.write(this.path);
        }

        if (this.port != null) {
            generator.writeKey("port");
            generator.write(this.port);
        }

        if (ApiTypeHelper.isDefined(this.queryParams)) {
            generator.writeKey("query_params");
            generator.writeStartObject();
            for (Map.Entry<String, String> item0 : this.queryParams.entrySet()) {
                generator.writeKey(item0.getKey());
                generator.write(item0.getValue());
            }
            generator.writeEnd();
        }

        if (this.scheme != null) {
            generator.writeKey("scheme");
            generator.write(this.scheme);
        }

        if (this.url != null) {
            generator.writeKey("url");
            generator.write(this.url);
        }

        if (this.username != null) {
            generator.writeKey("username");
            generator.write(this.username);
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
     * Builder for {@link ErrorNotificationCustomWebhook}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, ErrorNotificationCustomWebhook> {
        @Nullable
        private Map<String, String> headerParams;
        @Nullable
        private String host;
        @Nullable
        private String password;
        @Nullable
        private String path;
        @Nullable
        private Integer port;
        @Nullable
        private Map<String, String> queryParams;
        @Nullable
        private String scheme;
        @Nullable
        private String url;
        @Nullable
        private String username;

        public Builder() {}

        private Builder(ErrorNotificationCustomWebhook o) {
            this.headerParams = _mapCopy(o.headerParams);
            this.host = o.host;
            this.password = o.password;
            this.path = o.path;
            this.port = o.port;
            this.queryParams = _mapCopy(o.queryParams);
            this.scheme = o.scheme;
            this.url = o.url;
            this.username = o.username;
        }

        private Builder(Builder o) {
            this.headerParams = _mapCopy(o.headerParams);
            this.host = o.host;
            this.password = o.password;
            this.path = o.path;
            this.port = o.port;
            this.queryParams = _mapCopy(o.queryParams);
            this.scheme = o.scheme;
            this.url = o.url;
            this.username = o.username;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * The header parameters for the custom webhook.
         * <p>
         * API name: {@code header_params}
         * </p>
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>headerParams</code>.
         * </p>
         */
        @Nonnull
        public final Builder headerParams(Map<String, String> map) {
            this.headerParams = _mapPutAll(this.headerParams, map);
            return this;
        }

        /**
         * The header parameters for the custom webhook.
         * <p>
         * API name: {@code header_params}
         * </p>
         *
         * <p>
         * Adds an entry to <code>headerParams</code>.
         * </p>
         */
        @Nonnull
        public final Builder headerParams(String key, String value) {
            this.headerParams = _mapPut(this.headerParams, key, value);
            return this;
        }

        /**
         * The host for the custom webhook.
         * <p>
         * API name: {@code host}
         * </p>
         */
        @Nonnull
        public final Builder host(@Nullable String value) {
            this.host = value;
            return this;
        }

        /**
         * The password for the custom webhook.
         * <p>
         * API name: {@code password}
         * </p>
         */
        @Nonnull
        public final Builder password(@Nullable String value) {
            this.password = value;
            return this;
        }

        /**
         * The path for the custom webhook.
         * <p>
         * API name: {@code path}
         * </p>
         */
        @Nonnull
        public final Builder path(@Nullable String value) {
            this.path = value;
            return this;
        }

        /**
         * The port for the custom webhook.
         * <p>
         * API name: {@code port}
         * </p>
         */
        @Nonnull
        public final Builder port(@Nullable Integer value) {
            this.port = value;
            return this;
        }

        /**
         * The query parameters for the custom webhook.
         * <p>
         * API name: {@code query_params}
         * </p>
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>queryParams</code>.
         * </p>
         */
        @Nonnull
        public final Builder queryParams(Map<String, String> map) {
            this.queryParams = _mapPutAll(this.queryParams, map);
            return this;
        }

        /**
         * The query parameters for the custom webhook.
         * <p>
         * API name: {@code query_params}
         * </p>
         *
         * <p>
         * Adds an entry to <code>queryParams</code>.
         * </p>
         */
        @Nonnull
        public final Builder queryParams(String key, String value) {
            this.queryParams = _mapPut(this.queryParams, key, value);
            return this;
        }

        /**
         * The scheme for the custom webhook.
         * <p>
         * API name: {@code scheme}
         * </p>
         */
        @Nonnull
        public final Builder scheme(@Nullable String value) {
            this.scheme = value;
            return this;
        }

        /**
         * The URL for the custom webhook.
         * <p>
         * API name: {@code url}
         * </p>
         */
        @Nonnull
        public final Builder url(@Nullable String value) {
            this.url = value;
            return this;
        }

        /**
         * The username for the custom webhook.
         * <p>
         * API name: {@code username}
         * </p>
         */
        @Nonnull
        public final Builder username(@Nullable String value) {
            this.username = value;
            return this;
        }

        /**
         * Builds a {@link ErrorNotificationCustomWebhook}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public ErrorNotificationCustomWebhook build() {
            _checkSingleUse();

            return new ErrorNotificationCustomWebhook(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link ErrorNotificationCustomWebhook}
     */
    public static final JsonpDeserializer<ErrorNotificationCustomWebhook> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        ErrorNotificationCustomWebhook::setupErrorNotificationCustomWebhookDeserializer
    );

    protected static void setupErrorNotificationCustomWebhookDeserializer(ObjectDeserializer<ErrorNotificationCustomWebhook.Builder> op) {
        op.add(Builder::headerParams, JsonpDeserializer.stringMapDeserializer(JsonpDeserializer.stringDeserializer()), "header_params");
        op.add(Builder::host, JsonpDeserializer.stringDeserializer(), "host");
        op.add(Builder::password, JsonpDeserializer.stringDeserializer(), "password");
        op.add(Builder::path, JsonpDeserializer.stringDeserializer(), "path");
        op.add(Builder::port, JsonpDeserializer.integerDeserializer(), "port");
        op.add(Builder::queryParams, JsonpDeserializer.stringMapDeserializer(JsonpDeserializer.stringDeserializer()), "query_params");
        op.add(Builder::scheme, JsonpDeserializer.stringDeserializer(), "scheme");
        op.add(Builder::url, JsonpDeserializer.stringDeserializer(), "url");
        op.add(Builder::username, JsonpDeserializer.stringDeserializer(), "username");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.headerParams);
        result = 31 * result + Objects.hashCode(this.host);
        result = 31 * result + Objects.hashCode(this.password);
        result = 31 * result + Objects.hashCode(this.path);
        result = 31 * result + Objects.hashCode(this.port);
        result = 31 * result + Objects.hashCode(this.queryParams);
        result = 31 * result + Objects.hashCode(this.scheme);
        result = 31 * result + Objects.hashCode(this.url);
        result = 31 * result + Objects.hashCode(this.username);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        ErrorNotificationCustomWebhook other = (ErrorNotificationCustomWebhook) o;
        return Objects.equals(this.headerParams, other.headerParams)
            && Objects.equals(this.host, other.host)
            && Objects.equals(this.password, other.password)
            && Objects.equals(this.path, other.path)
            && Objects.equals(this.port, other.port)
            && Objects.equals(this.queryParams, other.queryParams)
            && Objects.equals(this.scheme, other.scheme)
            && Objects.equals(this.url, other.url)
            && Objects.equals(this.username, other.username);
    }
}
