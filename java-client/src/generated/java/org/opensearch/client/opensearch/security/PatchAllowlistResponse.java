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

// typedef: security.patch_allowlist.Response

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class PatchAllowlistResponse
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<PatchAllowlistResponse.Builder, PatchAllowlistResponse> {

    @Nullable
    private final Boolean enabled;

    @Nonnull
    private final Map<String, List<String>> requests;

    // ---------------------------------------------------------------------------------------------

    private PatchAllowlistResponse(Builder builder) {
        this.enabled = builder.enabled;
        this.requests = ApiTypeHelper.unmodifiable(builder.requests);
    }

    public static PatchAllowlistResponse of(Function<PatchAllowlistResponse.Builder, ObjectBuilder<PatchAllowlistResponse>> fn) {
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
     * An object with APIs as key and array of HTTP methods as values.
     * <p>
     * API name: {@code requests}
     * </p>
     */
    @Nonnull
    public final Map<String, List<String>> requests() {
        return this.requests;
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

        if (ApiTypeHelper.isDefined(this.requests)) {
            generator.writeKey("requests");
            generator.writeStartObject();
            for (Map.Entry<String, List<String>> item0 : this.requests.entrySet()) {
                generator.writeKey(item0.getKey());
                generator.writeStartArray();
                if (item0.getValue() != null) {
                    for (String item1 : item0.getValue()) {
                        generator.write(item1);
                    }
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
     * Builder for {@link PatchAllowlistResponse}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, PatchAllowlistResponse> {
        @Nullable
        private Boolean enabled;
        @Nullable
        private Map<String, List<String>> requests;

        public Builder() {}

        private Builder(PatchAllowlistResponse o) {
            this.enabled = o.enabled;
            this.requests = _mapCopy(o.requests);
        }

        private Builder(Builder o) {
            this.enabled = o.enabled;
            this.requests = _mapCopy(o.requests);
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
         * An object with APIs as key and array of HTTP methods as values.
         * <p>
         * API name: {@code requests}
         * </p>
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>requests</code>.
         * </p>
         */
        @Nonnull
        public final Builder requests(Map<String, List<String>> map) {
            this.requests = _mapPutAll(this.requests, map);
            return this;
        }

        /**
         * An object with APIs as key and array of HTTP methods as values.
         * <p>
         * API name: {@code requests}
         * </p>
         *
         * <p>
         * Adds an entry to <code>requests</code>.
         * </p>
         */
        @Nonnull
        public final Builder requests(String key, List<String> value) {
            this.requests = _mapPut(this.requests, key, value);
            return this;
        }

        /**
         * Builds a {@link PatchAllowlistResponse}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public PatchAllowlistResponse build() {
            _checkSingleUse();

            return new PatchAllowlistResponse(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link PatchAllowlistResponse}
     */
    public static final JsonpDeserializer<PatchAllowlistResponse> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        PatchAllowlistResponse::setupPatchAllowlistResponseDeserializer
    );

    protected static void setupPatchAllowlistResponseDeserializer(ObjectDeserializer<PatchAllowlistResponse.Builder> op) {
        op.add(Builder::enabled, JsonpDeserializer.booleanDeserializer(), "enabled");
        op.add(
            Builder::requests,
            JsonpDeserializer.stringMapDeserializer(JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer())),
            "requests"
        );
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.enabled);
        result = 31 * result + Objects.hashCode(this.requests);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        PatchAllowlistResponse other = (PatchAllowlistResponse) o;
        return Objects.equals(this.enabled, other.enabled) && Objects.equals(this.requests, other.requests);
    }
}
