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

package org.opensearch.client.opensearch.core.reindex;

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
import org.opensearch.client.opensearch._types.Time;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: core.reindex.RemoteSource

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class RemoteSource implements PlainJsonSerializable, ToCopyableBuilder<RemoteSource.Builder, RemoteSource> {

    @Nullable
    private final Time connectTimeout;

    @Nonnull
    private final Map<String, String> headers;

    @Nonnull
    private final String host;

    @Nullable
    private final String password;

    @Nullable
    private final Time socketTimeout;

    @Nullable
    private final String username;

    // ---------------------------------------------------------------------------------------------

    private RemoteSource(Builder builder) {
        this.connectTimeout = builder.connectTimeout;
        this.headers = ApiTypeHelper.unmodifiable(builder.headers);
        this.host = ApiTypeHelper.requireNonNull(builder.host, this, "host");
        this.password = builder.password;
        this.socketTimeout = builder.socketTimeout;
        this.username = builder.username;
    }

    public static RemoteSource of(Function<RemoteSource.Builder, ObjectBuilder<RemoteSource>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code connect_timeout}
     */
    @Nullable
    public final Time connectTimeout() {
        return this.connectTimeout;
    }

    /**
     * An object containing the headers of the request.
     * <p>
     * API name: {@code headers}
     * </p>
     */
    @Nonnull
    public final Map<String, String> headers() {
        return this.headers;
    }

    /**
     * Required - API name: {@code host}
     */
    @Nonnull
    public final String host() {
        return this.host;
    }

    /**
     * API name: {@code password}
     */
    @Nullable
    public final String password() {
        return this.password;
    }

    /**
     * API name: {@code socket_timeout}
     */
    @Nullable
    public final Time socketTimeout() {
        return this.socketTimeout;
    }

    /**
     * API name: {@code username}
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
        if (this.connectTimeout != null) {
            generator.writeKey("connect_timeout");
            this.connectTimeout.serialize(generator, mapper);
        }

        if (ApiTypeHelper.isDefined(this.headers)) {
            generator.writeKey("headers");
            generator.writeStartObject();
            for (Map.Entry<String, String> item0 : this.headers.entrySet()) {
                generator.writeKey(item0.getKey());
                generator.write(item0.getValue());
            }
            generator.writeEnd();
        }

        generator.writeKey("host");
        generator.write(this.host);

        if (this.password != null) {
            generator.writeKey("password");
            generator.write(this.password);
        }

        if (this.socketTimeout != null) {
            generator.writeKey("socket_timeout");
            this.socketTimeout.serialize(generator, mapper);
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
     * Builder for {@link RemoteSource}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, RemoteSource> {
        @Nullable
        private Time connectTimeout;
        @Nullable
        private Map<String, String> headers;
        private String host;
        @Nullable
        private String password;
        @Nullable
        private Time socketTimeout;
        @Nullable
        private String username;

        public Builder() {}

        private Builder(RemoteSource o) {
            this.connectTimeout = o.connectTimeout;
            this.headers = _mapCopy(o.headers);
            this.host = o.host;
            this.password = o.password;
            this.socketTimeout = o.socketTimeout;
            this.username = o.username;
        }

        private Builder(Builder o) {
            this.connectTimeout = o.connectTimeout;
            this.headers = _mapCopy(o.headers);
            this.host = o.host;
            this.password = o.password;
            this.socketTimeout = o.socketTimeout;
            this.username = o.username;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code connect_timeout}
         */
        @Nonnull
        public final Builder connectTimeout(@Nullable Time value) {
            this.connectTimeout = value;
            return this;
        }

        /**
         * API name: {@code connect_timeout}
         */
        @Nonnull
        public final Builder connectTimeout(Function<Time.Builder, ObjectBuilder<Time>> fn) {
            return connectTimeout(fn.apply(new Time.Builder()).build());
        }

        /**
         * An object containing the headers of the request.
         * <p>
         * API name: {@code headers}
         * </p>
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>headers</code>.
         * </p>
         */
        @Nonnull
        public final Builder headers(Map<String, String> map) {
            this.headers = _mapPutAll(this.headers, map);
            return this;
        }

        /**
         * An object containing the headers of the request.
         * <p>
         * API name: {@code headers}
         * </p>
         *
         * <p>
         * Adds an entry to <code>headers</code>.
         * </p>
         */
        @Nonnull
        public final Builder headers(String key, String value) {
            this.headers = _mapPut(this.headers, key, value);
            return this;
        }

        /**
         * Required - API name: {@code host}
         */
        @Nonnull
        public final Builder host(String value) {
            this.host = value;
            return this;
        }

        /**
         * API name: {@code password}
         */
        @Nonnull
        public final Builder password(@Nullable String value) {
            this.password = value;
            return this;
        }

        /**
         * API name: {@code socket_timeout}
         */
        @Nonnull
        public final Builder socketTimeout(@Nullable Time value) {
            this.socketTimeout = value;
            return this;
        }

        /**
         * API name: {@code socket_timeout}
         */
        @Nonnull
        public final Builder socketTimeout(Function<Time.Builder, ObjectBuilder<Time>> fn) {
            return socketTimeout(fn.apply(new Time.Builder()).build());
        }

        /**
         * API name: {@code username}
         */
        @Nonnull
        public final Builder username(@Nullable String value) {
            this.username = value;
            return this;
        }

        /**
         * Builds a {@link RemoteSource}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public RemoteSource build() {
            _checkSingleUse();

            return new RemoteSource(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link RemoteSource}
     */
    public static final JsonpDeserializer<RemoteSource> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        RemoteSource::setupRemoteSourceDeserializer
    );

    protected static void setupRemoteSourceDeserializer(ObjectDeserializer<RemoteSource.Builder> op) {
        op.add(Builder::connectTimeout, Time._DESERIALIZER, "connect_timeout");
        op.add(Builder::headers, JsonpDeserializer.stringMapDeserializer(JsonpDeserializer.stringDeserializer()), "headers");
        op.add(Builder::host, JsonpDeserializer.stringDeserializer(), "host");
        op.add(Builder::password, JsonpDeserializer.stringDeserializer(), "password");
        op.add(Builder::socketTimeout, Time._DESERIALIZER, "socket_timeout");
        op.add(Builder::username, JsonpDeserializer.stringDeserializer(), "username");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.connectTimeout);
        result = 31 * result + Objects.hashCode(this.headers);
        result = 31 * result + this.host.hashCode();
        result = 31 * result + Objects.hashCode(this.password);
        result = 31 * result + Objects.hashCode(this.socketTimeout);
        result = 31 * result + Objects.hashCode(this.username);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        RemoteSource other = (RemoteSource) o;
        return Objects.equals(this.connectTimeout, other.connectTimeout)
            && Objects.equals(this.headers, other.headers)
            && this.host.equals(other.host)
            && Objects.equals(this.password, other.password)
            && Objects.equals(this.socketTimeout, other.socketTimeout)
            && Objects.equals(this.username, other.username);
    }
}
