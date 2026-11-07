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
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: security.ApiTokensConfig

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class ApiTokensConfig implements PlainJsonSerializable, ToCopyableBuilder<ApiTokensConfig.Builder, ApiTokensConfig> {

    @Nullable
    private final Boolean enabled;

    @Nullable
    private final Long maxDurationSeconds;

    @Nullable
    private final Long maxTokens;

    // ---------------------------------------------------------------------------------------------

    private ApiTokensConfig(Builder builder) {
        this.enabled = builder.enabled;
        this.maxDurationSeconds = builder.maxDurationSeconds;
        this.maxTokens = builder.maxTokens;
    }

    public static ApiTokensConfig of(Function<ApiTokensConfig.Builder, ObjectBuilder<ApiTokensConfig>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code enabled}
     */
    @Nullable
    public final Boolean enabled() {
        return this.enabled;
    }

    /**
     * API name: {@code max_duration_seconds}
     */
    @Nullable
    public final Long maxDurationSeconds() {
        return this.maxDurationSeconds;
    }

    /**
     * API name: {@code max_tokens}
     */
    @Nullable
    public final Long maxTokens() {
        return this.maxTokens;
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
        if (this.enabled != null) {
            generator.writeKey("enabled");
            generator.write(this.enabled);
        }

        if (this.maxDurationSeconds != null) {
            generator.writeKey("max_duration_seconds");
            generator.write(this.maxDurationSeconds);
        }

        if (this.maxTokens != null) {
            generator.writeKey("max_tokens");
            generator.write(this.maxTokens);
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
     * Builder for {@link ApiTokensConfig}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, ApiTokensConfig> {
        @Nullable
        private Boolean enabled;
        @Nullable
        private Long maxDurationSeconds;
        @Nullable
        private Long maxTokens;

        public Builder() {}

        private Builder(ApiTokensConfig o) {
            this.enabled = o.enabled;
            this.maxDurationSeconds = o.maxDurationSeconds;
            this.maxTokens = o.maxTokens;
        }

        private Builder(Builder o) {
            this.enabled = o.enabled;
            this.maxDurationSeconds = o.maxDurationSeconds;
            this.maxTokens = o.maxTokens;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code enabled}
         */
        @Nonnull
        public final Builder enabled(@Nullable Boolean value) {
            this.enabled = value;
            return this;
        }

        /**
         * API name: {@code max_duration_seconds}
         */
        @Nonnull
        public final Builder maxDurationSeconds(@Nullable Long value) {
            this.maxDurationSeconds = value;
            return this;
        }

        /**
         * API name: {@code max_tokens}
         */
        @Nonnull
        public final Builder maxTokens(@Nullable Long value) {
            this.maxTokens = value;
            return this;
        }

        /**
         * Builds a {@link ApiTokensConfig}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public ApiTokensConfig build() {
            _checkSingleUse();

            return new ApiTokensConfig(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link ApiTokensConfig}
     */
    public static final JsonpDeserializer<ApiTokensConfig> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        ApiTokensConfig::setupApiTokensConfigDeserializer
    );

    protected static void setupApiTokensConfigDeserializer(ObjectDeserializer<ApiTokensConfig.Builder> op) {
        op.add(Builder::enabled, JsonpDeserializer.booleanDeserializer(), "enabled");
        op.add(Builder::maxDurationSeconds, JsonpDeserializer.longDeserializer(), "max_duration_seconds");
        op.add(Builder::maxTokens, JsonpDeserializer.longDeserializer(), "max_tokens");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.enabled);
        result = 31 * result + Objects.hashCode(this.maxDurationSeconds);
        result = 31 * result + Objects.hashCode(this.maxTokens);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        ApiTokensConfig other = (ApiTokensConfig) o;
        return Objects.equals(this.enabled, other.enabled)
            && Objects.equals(this.maxDurationSeconds, other.maxDurationSeconds)
            && Objects.equals(this.maxTokens, other.maxTokens);
    }
}
