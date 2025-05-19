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

// typedef: cluster.get_settings.Response

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class GetClusterSettingsResponse
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<GetClusterSettingsResponse.Builder, GetClusterSettingsResponse> {

    @Nonnull
    private final Map<String, JsonData> defaults;

    @Nonnull
    private final Map<String, JsonData> persistent;

    @Nonnull
    private final Map<String, JsonData> transient_;

    // ---------------------------------------------------------------------------------------------

    private GetClusterSettingsResponse(Builder builder) {
        this.defaults = ApiTypeHelper.unmodifiable(builder.defaults);
        this.persistent = ApiTypeHelper.unmodifiableRequired(builder.persistent, this, "persistent");
        this.transient_ = ApiTypeHelper.unmodifiableRequired(builder.transient_, this, "transient_");
    }

    public static GetClusterSettingsResponse of(
        Function<GetClusterSettingsResponse.Builder, ObjectBuilder<GetClusterSettingsResponse>> fn
    ) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code defaults}
     */
    @Nonnull
    public final Map<String, JsonData> defaults() {
        return this.defaults;
    }

    /**
     * Required - API name: {@code persistent}
     */
    @Nonnull
    public final Map<String, JsonData> persistent() {
        return this.persistent;
    }

    /**
     * Required - API name: {@code transient}
     */
    @Nonnull
    public final Map<String, JsonData> transient_() {
        return this.transient_;
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
        if (ApiTypeHelper.isDefined(this.defaults)) {
            generator.writeKey("defaults");
            generator.writeStartObject();
            for (Map.Entry<String, JsonData> item0 : this.defaults.entrySet()) {
                generator.writeKey(item0.getKey());
                item0.getValue().serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        generator.writeKey("persistent");
        generator.writeStartObject();
        for (Map.Entry<String, JsonData> item0 : this.persistent.entrySet()) {
            generator.writeKey(item0.getKey());
            item0.getValue().serialize(generator, mapper);
        }
        generator.writeEnd();

        generator.writeKey("transient");
        generator.writeStartObject();
        for (Map.Entry<String, JsonData> item0 : this.transient_.entrySet()) {
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
     * Builder for {@link GetClusterSettingsResponse}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, GetClusterSettingsResponse> {
        @Nullable
        private Map<String, JsonData> defaults;
        private Map<String, JsonData> persistent;
        private Map<String, JsonData> transient_;

        public Builder() {}

        private Builder(GetClusterSettingsResponse o) {
            this.defaults = _mapCopy(o.defaults);
            this.persistent = _mapCopy(o.persistent);
            this.transient_ = _mapCopy(o.transient_);
        }

        private Builder(Builder o) {
            this.defaults = _mapCopy(o.defaults);
            this.persistent = _mapCopy(o.persistent);
            this.transient_ = _mapCopy(o.transient_);
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code defaults}
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>defaults</code>.
         * </p>
         */
        @Nonnull
        public final Builder defaults(Map<String, JsonData> map) {
            this.defaults = _mapPutAll(this.defaults, map);
            return this;
        }

        /**
         * API name: {@code defaults}
         *
         * <p>
         * Adds an entry to <code>defaults</code>.
         * </p>
         */
        @Nonnull
        public final Builder defaults(String key, JsonData value) {
            this.defaults = _mapPut(this.defaults, key, value);
            return this;
        }

        /**
         * Required - API name: {@code persistent}
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>persistent</code>.
         * </p>
         */
        @Nonnull
        public final Builder persistent(Map<String, JsonData> map) {
            this.persistent = _mapPutAll(this.persistent, map);
            return this;
        }

        /**
         * Required - API name: {@code persistent}
         *
         * <p>
         * Adds an entry to <code>persistent</code>.
         * </p>
         */
        @Nonnull
        public final Builder persistent(String key, JsonData value) {
            this.persistent = _mapPut(this.persistent, key, value);
            return this;
        }

        /**
         * Required - API name: {@code transient}
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>transient_</code>.
         * </p>
         */
        @Nonnull
        public final Builder transient_(Map<String, JsonData> map) {
            this.transient_ = _mapPutAll(this.transient_, map);
            return this;
        }

        /**
         * Required - API name: {@code transient}
         *
         * <p>
         * Adds an entry to <code>transient_</code>.
         * </p>
         */
        @Nonnull
        public final Builder transient_(String key, JsonData value) {
            this.transient_ = _mapPut(this.transient_, key, value);
            return this;
        }

        /**
         * Builds a {@link GetClusterSettingsResponse}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public GetClusterSettingsResponse build() {
            _checkSingleUse();

            return new GetClusterSettingsResponse(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link GetClusterSettingsResponse}
     */
    public static final JsonpDeserializer<GetClusterSettingsResponse> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        GetClusterSettingsResponse::setupGetClusterSettingsResponseDeserializer
    );

    protected static void setupGetClusterSettingsResponseDeserializer(ObjectDeserializer<GetClusterSettingsResponse.Builder> op) {
        op.add(Builder::defaults, JsonpDeserializer.stringMapDeserializer(JsonData._DESERIALIZER), "defaults");
        op.add(Builder::persistent, JsonpDeserializer.stringMapDeserializer(JsonData._DESERIALIZER), "persistent");
        op.add(Builder::transient_, JsonpDeserializer.stringMapDeserializer(JsonData._DESERIALIZER), "transient");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.defaults);
        result = 31 * result + this.persistent.hashCode();
        result = 31 * result + this.transient_.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        GetClusterSettingsResponse other = (GetClusterSettingsResponse) o;
        return Objects.equals(this.defaults, other.defaults)
            && this.persistent.equals(other.persistent)
            && this.transient_.equals(other.transient_);
    }
}
