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
import java.util.Map;
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
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

// typedef: cluster.describe_settings.Response

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class DescribeSettingsResponse
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<DescribeSettingsResponse.Builder, DescribeSettingsResponse> {

    @Nonnull
    private final Map<String, SettingMetadata> settings;

    // ---------------------------------------------------------------------------------------------

    private DescribeSettingsResponse(Builder builder) {
        this.settings = ApiTypeHelper.unmodifiableRequired(builder.settings, this, "settings");
    }

    public static DescribeSettingsResponse of(Function<DescribeSettingsResponse.Builder, ObjectBuilder<DescribeSettingsResponse>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - A map of setting names to their definition metadata. Setting names are returned in sorted order. A requested name is
     * omitted if it is unknown or filtered.
     * <p>
     * API name: {@code settings}
     * </p>
     */
    @Nonnull
    public final Map<String, SettingMetadata> settings() {
        return this.settings;
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
        generator.writeKey("settings");
        generator.writeStartObject();
        for (Map.Entry<String, SettingMetadata> item0 : this.settings.entrySet()) {
            generator.writeKey(item0.getKey());
            item0.getValue().serialize(generator, mapper);
        }
        generator.writeEnd();
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
     * Builder for {@link DescribeSettingsResponse}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, DescribeSettingsResponse> {
        private Map<String, SettingMetadata> settings;

        public Builder() {}

        private Builder(DescribeSettingsResponse o) {
            this.settings = _mapCopy(o.settings);
        }

        private Builder(Builder o) {
            this.settings = _mapCopy(o.settings);
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - A map of setting names to their definition metadata. Setting names are returned in sorted order. A requested name is
         * omitted if it is unknown or filtered.
         * <p>
         * API name: {@code settings}
         * </p>
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>settings</code>.
         * </p>
         */
        @Nonnull
        public final Builder settings(Map<String, SettingMetadata> map) {
            this.settings = _mapPutAll(this.settings, map);
            return this;
        }

        /**
         * Required - A map of setting names to their definition metadata. Setting names are returned in sorted order. A requested name is
         * omitted if it is unknown or filtered.
         * <p>
         * API name: {@code settings}
         * </p>
         *
         * <p>
         * Adds an entry to <code>settings</code>.
         * </p>
         */
        @Nonnull
        public final Builder settings(String key, SettingMetadata value) {
            this.settings = _mapPut(this.settings, key, value);
            return this;
        }

        /**
         * Required - A map of setting names to their definition metadata. Setting names are returned in sorted order. A requested name is
         * omitted if it is unknown or filtered.
         * <p>
         * API name: {@code settings}
         * </p>
         *
         * <p>
         * Adds a value to <code>settings</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder settings(String key, Function<SettingMetadata.Builder, ObjectBuilder<SettingMetadata>> fn) {
            return settings(key, fn.apply(new SettingMetadata.Builder()).build());
        }

        /**
         * Builds a {@link DescribeSettingsResponse}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public DescribeSettingsResponse build() {
            _checkSingleUse();

            return new DescribeSettingsResponse(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link DescribeSettingsResponse}
     */
    public static final JsonpDeserializer<DescribeSettingsResponse> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        DescribeSettingsResponse::setupDescribeSettingsResponseDeserializer
    );

    protected static void setupDescribeSettingsResponseDeserializer(ObjectDeserializer<DescribeSettingsResponse.Builder> op) {
        op.add(Builder::settings, JsonpDeserializer.stringMapDeserializer(SettingMetadata._DESERIALIZER), "settings");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.settings.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        DescribeSettingsResponse other = (DescribeSettingsResponse) o;
        return this.settings.equals(other.settings);
    }
}
