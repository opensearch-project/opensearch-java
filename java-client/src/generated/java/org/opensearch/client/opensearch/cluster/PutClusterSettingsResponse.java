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

// typedef: cluster.put_settings.Response

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class PutClusterSettingsResponse
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<PutClusterSettingsResponse.Builder, PutClusterSettingsResponse> {

    private final boolean acknowledged;

    @Nonnull
    private final Map<String, JsonData> persistent;

    @Nonnull
    private final Map<String, JsonData> transient_;

    // ---------------------------------------------------------------------------------------------

    private PutClusterSettingsResponse(Builder builder) {
        this.acknowledged = ApiTypeHelper.requireNonNull(builder.acknowledged, this, "acknowledged");
        this.persistent = ApiTypeHelper.unmodifiableRequired(builder.persistent, this, "persistent");
        this.transient_ = ApiTypeHelper.unmodifiableRequired(builder.transient_, this, "transient_");
    }

    public static PutClusterSettingsResponse of(
        Function<PutClusterSettingsResponse.Builder, ObjectBuilder<PutClusterSettingsResponse>> fn
    ) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - API name: {@code acknowledged}
     */
    public final boolean acknowledged() {
        return this.acknowledged;
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
        generator.writeKey("acknowledged");
        generator.write(this.acknowledged);

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
     * Builder for {@link PutClusterSettingsResponse}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, PutClusterSettingsResponse> {
        private Boolean acknowledged;
        private Map<String, JsonData> persistent;
        private Map<String, JsonData> transient_;

        public Builder() {}

        private Builder(PutClusterSettingsResponse o) {
            this.acknowledged = o.acknowledged;
            this.persistent = _mapCopy(o.persistent);
            this.transient_ = _mapCopy(o.transient_);
        }

        private Builder(Builder o) {
            this.acknowledged = o.acknowledged;
            this.persistent = _mapCopy(o.persistent);
            this.transient_ = _mapCopy(o.transient_);
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - API name: {@code acknowledged}
         */
        @Nonnull
        public final Builder acknowledged(boolean value) {
            this.acknowledged = value;
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
         * Builds a {@link PutClusterSettingsResponse}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public PutClusterSettingsResponse build() {
            _checkSingleUse();

            return new PutClusterSettingsResponse(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link PutClusterSettingsResponse}
     */
    public static final JsonpDeserializer<PutClusterSettingsResponse> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        PutClusterSettingsResponse::setupPutClusterSettingsResponseDeserializer
    );

    protected static void setupPutClusterSettingsResponseDeserializer(ObjectDeserializer<PutClusterSettingsResponse.Builder> op) {
        op.add(Builder::acknowledged, JsonpDeserializer.booleanDeserializer(), "acknowledged");
        op.add(Builder::persistent, JsonpDeserializer.stringMapDeserializer(JsonData._DESERIALIZER), "persistent");
        op.add(Builder::transient_, JsonpDeserializer.stringMapDeserializer(JsonData._DESERIALIZER), "transient");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Boolean.hashCode(this.acknowledged);
        result = 31 * result + this.persistent.hashCode();
        result = 31 * result + this.transient_.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        PutClusterSettingsResponse other = (PutClusterSettingsResponse) o;
        return this.acknowledged == other.acknowledged
            && this.persistent.equals(other.persistent)
            && this.transient_.equals(other.transient_);
    }
}
