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

// typedef: security.config_upgrade_check.Response

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class ConfigUpgradeCheckResponse
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<ConfigUpgradeCheckResponse.Builder, ConfigUpgradeCheckResponse> {

    @Nullable
    private final String status;

    @Nonnull
    private final Map<String, Map<String, List<String>>> upgradeActions;

    @Nullable
    private final Boolean upgradeAvailable;

    // ---------------------------------------------------------------------------------------------

    private ConfigUpgradeCheckResponse(Builder builder) {
        this.status = builder.status;
        this.upgradeActions = ApiTypeHelper.unmodifiable(builder.upgradeActions);
        this.upgradeAvailable = builder.upgradeAvailable;
    }

    public static ConfigUpgradeCheckResponse of(
        Function<ConfigUpgradeCheckResponse.Builder, ObjectBuilder<ConfigUpgradeCheckResponse>> fn
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
     * API name: {@code upgradeActions}
     */
    @Nonnull
    public final Map<String, Map<String, List<String>>> upgradeActions() {
        return this.upgradeActions;
    }

    /**
     * API name: {@code upgradeAvailable}
     */
    @Nullable
    public final Boolean upgradeAvailable() {
        return this.upgradeAvailable;
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

        if (ApiTypeHelper.isDefined(this.upgradeActions)) {
            generator.writeKey("upgradeActions");
            generator.writeStartObject();
            for (Map.Entry<String, Map<String, List<String>>> item0 : this.upgradeActions.entrySet()) {
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

        if (this.upgradeAvailable != null) {
            generator.writeKey("upgradeAvailable");
            generator.write(this.upgradeAvailable);
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
     * Builder for {@link ConfigUpgradeCheckResponse}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, ConfigUpgradeCheckResponse> {
        @Nullable
        private String status;
        @Nullable
        private Map<String, Map<String, List<String>>> upgradeActions;
        @Nullable
        private Boolean upgradeAvailable;

        public Builder() {}

        private Builder(ConfigUpgradeCheckResponse o) {
            this.status = o.status;
            this.upgradeActions = _mapCopy(o.upgradeActions);
            this.upgradeAvailable = o.upgradeAvailable;
        }

        private Builder(Builder o) {
            this.status = o.status;
            this.upgradeActions = _mapCopy(o.upgradeActions);
            this.upgradeAvailable = o.upgradeAvailable;
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
         * API name: {@code upgradeActions}
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>upgradeActions</code>.
         * </p>
         */
        @Nonnull
        public final Builder upgradeActions(Map<String, Map<String, List<String>>> map) {
            this.upgradeActions = _mapPutAll(this.upgradeActions, map);
            return this;
        }

        /**
         * API name: {@code upgradeActions}
         *
         * <p>
         * Adds an entry to <code>upgradeActions</code>.
         * </p>
         */
        @Nonnull
        public final Builder upgradeActions(String key, Map<String, List<String>> value) {
            this.upgradeActions = _mapPut(this.upgradeActions, key, value);
            return this;
        }

        /**
         * API name: {@code upgradeAvailable}
         */
        @Nonnull
        public final Builder upgradeAvailable(@Nullable Boolean value) {
            this.upgradeAvailable = value;
            return this;
        }

        /**
         * Builds a {@link ConfigUpgradeCheckResponse}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public ConfigUpgradeCheckResponse build() {
            _checkSingleUse();

            return new ConfigUpgradeCheckResponse(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link ConfigUpgradeCheckResponse}
     */
    public static final JsonpDeserializer<ConfigUpgradeCheckResponse> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        ConfigUpgradeCheckResponse::setupConfigUpgradeCheckResponseDeserializer
    );

    protected static void setupConfigUpgradeCheckResponseDeserializer(ObjectDeserializer<ConfigUpgradeCheckResponse.Builder> op) {
        op.add(Builder::status, JsonpDeserializer.stringDeserializer(), "status");
        op.add(
            Builder::upgradeActions,
            JsonpDeserializer.stringMapDeserializer(
                JsonpDeserializer.stringMapDeserializer(JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()))
            ),
            "upgradeActions"
        );
        op.add(Builder::upgradeAvailable, JsonpDeserializer.booleanDeserializer(), "upgradeAvailable");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.status);
        result = 31 * result + Objects.hashCode(this.upgradeActions);
        result = 31 * result + Objects.hashCode(this.upgradeAvailable);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        ConfigUpgradeCheckResponse other = (ConfigUpgradeCheckResponse) o;
        return Objects.equals(this.status, other.status)
            && Objects.equals(this.upgradeActions, other.upgradeActions)
            && Objects.equals(this.upgradeAvailable, other.upgradeAvailable);
    }
}
