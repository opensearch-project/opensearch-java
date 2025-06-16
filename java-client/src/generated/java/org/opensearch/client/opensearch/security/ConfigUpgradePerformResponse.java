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
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: security.config_upgrade_perform.Response

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class ConfigUpgradePerformResponse
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<ConfigUpgradePerformResponse.Builder, ConfigUpgradePerformResponse> {

    @Nullable
    private final String status;

    @Nonnull
    private final Map<String, Map<String, List<String>>> upgrades;

    // ---------------------------------------------------------------------------------------------

    private ConfigUpgradePerformResponse(Builder builder) {
        this.status = builder.status;
        this.upgrades = ApiTypeHelper.unmodifiable(builder.upgrades);
    }

    public static ConfigUpgradePerformResponse of(
        Function<ConfigUpgradePerformResponse.Builder, ObjectBuilder<ConfigUpgradePerformResponse>> fn
    ) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code status}
     */
    @Nullable
    public final String status() {
        return this.status;
    }

    /**
     * API name: {@code upgrades}
     */
    @Nonnull
    public final Map<String, Map<String, List<String>>> upgrades() {
        return this.upgrades;
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
        if (this.status != null) {
            generator.writeKey("status");
            generator.write(this.status);
        }

        if (ApiTypeHelper.isDefined(this.upgrades)) {
            generator.writeKey("upgrades");
            generator.writeStartObject();
            for (Map.Entry<String, Map<String, List<String>>> item0 : this.upgrades.entrySet()) {
                generator.writeKey(item0.getKey());
                generator.writeStartObject();
                for (Map.Entry<String, List<String>> item1 : item0.getValue().entrySet()) {
                    generator.writeKey(item1.getKey());
                    generator.writeStartArray();
                    if (item1.getValue() != null) {
                        for (String item2 : item1.getValue()) {
                            generator.write(item2);
                        }
                    }
                    generator.writeEnd();
                }
                generator.writeEnd();
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
     * Builder for {@link ConfigUpgradePerformResponse}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, ConfigUpgradePerformResponse> {
        @Nullable
        private String status;
        @Nullable
        private Map<String, Map<String, List<String>>> upgrades;

        public Builder() {}

        private Builder(ConfigUpgradePerformResponse o) {
            this.status = o.status;
            this.upgrades = _mapCopy(o.upgrades);
        }

        private Builder(Builder o) {
            this.status = o.status;
            this.upgrades = _mapCopy(o.upgrades);
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
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
         * API name: {@code upgrades}
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>upgrades</code>.
         * </p>
         */
        @Nonnull
        public final Builder upgrades(Map<String, Map<String, List<String>>> map) {
            this.upgrades = _mapPutAll(this.upgrades, map);
            return this;
        }

        /**
         * API name: {@code upgrades}
         *
         * <p>
         * Adds an entry to <code>upgrades</code>.
         * </p>
         */
        @Nonnull
        public final Builder upgrades(String key, Map<String, List<String>> value) {
            this.upgrades = _mapPut(this.upgrades, key, value);
            return this;
        }

        /**
         * Builds a {@link ConfigUpgradePerformResponse}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public ConfigUpgradePerformResponse build() {
            _checkSingleUse();

            return new ConfigUpgradePerformResponse(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link ConfigUpgradePerformResponse}
     */
    public static final JsonpDeserializer<ConfigUpgradePerformResponse> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        ConfigUpgradePerformResponse::setupConfigUpgradePerformResponseDeserializer
    );

    protected static void setupConfigUpgradePerformResponseDeserializer(ObjectDeserializer<ConfigUpgradePerformResponse.Builder> op) {
        op.add(Builder::status, JsonpDeserializer.stringDeserializer(), "status");
        op.add(
            Builder::upgrades,
            JsonpDeserializer.stringMapDeserializer(
                JsonpDeserializer.stringMapDeserializer(JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()))
            ),
            "upgrades"
        );
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.status);
        result = 31 * result + Objects.hashCode(this.upgrades);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        ConfigUpgradePerformResponse other = (ConfigUpgradePerformResponse) o;
        return Objects.equals(this.status, other.status) && Objects.equals(this.upgrades, other.upgrades);
    }
}
