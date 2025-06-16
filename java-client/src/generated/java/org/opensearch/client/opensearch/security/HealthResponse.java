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

package org.opensearch.client.opensearch.security;

import jakarta.json.stream.JsonGenerator;
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
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: security.health.Response

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class HealthResponse implements PlainJsonSerializable, ToCopyableBuilder<HealthResponse.Builder, HealthResponse> {

    @Nullable
    private final String message;

    @Nullable
    private final String mode;

    @Nonnull
    private final Map<String, JsonData> settings;

    @Nullable
    private final String status;

    // ---------------------------------------------------------------------------------------------

    private HealthResponse(Builder builder) {
        this.message = builder.message;
        this.mode = builder.mode;
        this.settings = ApiTypeHelper.unmodifiable(builder.settings);
        this.status = builder.status;
    }

    public static HealthResponse of(Function<HealthResponse.Builder, ObjectBuilder<HealthResponse>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code message}
     */
    @Nullable
    public final String message() {
        return this.message;
    }

    /**
     * API name: {@code mode}
     */
    @Nullable
    public final String mode() {
        return this.mode;
    }

    /**
     * API name: {@code settings}
     */
    @Nonnull
    public final Map<String, JsonData> settings() {
        return this.settings;
    }

    /**
     * API name: {@code status}
     */
    @Nullable
    public final String status() {
        return this.status;
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
        if (this.message != null) {
            generator.writeKey("message");
            generator.write(this.message);
        }

        if (this.mode != null) {
            generator.writeKey("mode");
            generator.write(this.mode);
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

        if (this.status != null) {
            generator.writeKey("status");
            generator.write(this.status);
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
     * Builder for {@link HealthResponse}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, HealthResponse> {
        @Nullable
        private String message;
        @Nullable
        private String mode;
        @Nullable
        private Map<String, JsonData> settings;
        @Nullable
        private String status;

        public Builder() {}

        private Builder(HealthResponse o) {
            this.message = o.message;
            this.mode = o.mode;
            this.settings = _mapCopy(o.settings);
            this.status = o.status;
        }

        private Builder(Builder o) {
            this.message = o.message;
            this.mode = o.mode;
            this.settings = _mapCopy(o.settings);
            this.status = o.status;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code message}
         */
        @Nonnull
        public final Builder message(@Nullable String value) {
            this.message = value;
            return this;
        }

        /**
         * API name: {@code mode}
         */
        @Nonnull
        public final Builder mode(@Nullable String value) {
            this.mode = value;
            return this;
        }

        /**
         * API name: {@code settings}
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
         * API name: {@code settings}
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
         * API name: {@code status}
         */
        @Nonnull
        public final Builder status(@Nullable String value) {
            this.status = value;
            return this;
        }

        /**
         * Builds a {@link HealthResponse}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public HealthResponse build() {
            _checkSingleUse();

            return new HealthResponse(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link HealthResponse}
     */
    public static final JsonpDeserializer<HealthResponse> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        HealthResponse::setupHealthResponseDeserializer
    );

    protected static void setupHealthResponseDeserializer(ObjectDeserializer<HealthResponse.Builder> op) {
        op.add(Builder::message, JsonpDeserializer.stringDeserializer(), "message");
        op.add(Builder::mode, JsonpDeserializer.stringDeserializer(), "mode");
        op.add(Builder::settings, JsonpDeserializer.stringMapDeserializer(JsonData._DESERIALIZER), "settings");
        op.add(Builder::status, JsonpDeserializer.stringDeserializer(), "status");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.message);
        result = 31 * result + Objects.hashCode(this.mode);
        result = 31 * result + Objects.hashCode(this.settings);
        result = 31 * result + Objects.hashCode(this.status);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        HealthResponse other = (HealthResponse) o;
        return Objects.equals(this.message, other.message)
            && Objects.equals(this.mode, other.mode)
            && Objects.equals(this.settings, other.settings)
            && Objects.equals(this.status, other.status);
    }
}
