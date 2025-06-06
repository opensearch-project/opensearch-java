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

// typedef: security.get_permissions_info.Response

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class GetPermissionsInfoResponse
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<GetPermissionsInfoResponse.Builder, GetPermissionsInfoResponse> {

    @Nonnull
    private final Map<String, List<String>> disabledEndpoints;

    @Nullable
    private final Boolean hasApiAccess;

    @Nullable
    private final String user;

    @Nullable
    private final String userName;

    // ---------------------------------------------------------------------------------------------

    private GetPermissionsInfoResponse(Builder builder) {
        this.disabledEndpoints = ApiTypeHelper.unmodifiable(builder.disabledEndpoints);
        this.hasApiAccess = builder.hasApiAccess;
        this.user = builder.user;
        this.userName = builder.userName;
    }

    public static GetPermissionsInfoResponse of(
        Function<GetPermissionsInfoResponse.Builder, ObjectBuilder<GetPermissionsInfoResponse>> fn
    ) {
        return fn.apply(new Builder()).build();
    }

    /**
     * An object with disabled APIs as keys and an array of HTTP methods as values.
     * <p>
     * API name: {@code disabled_endpoints}
     * </p>
     */
    @Nonnull
    public final Map<String, List<String>> disabledEndpoints() {
        return this.disabledEndpoints;
    }

    /**
     * API name: {@code has_api_access}
     */
    @Nullable
    public final Boolean hasApiAccess() {
        return this.hasApiAccess;
    }

    /**
     * API name: {@code user}
     */
    @Nullable
    public final String user() {
        return this.user;
    }

    /**
     * API name: {@code user_name}
     */
    @Nullable
    public final String userName() {
        return this.userName;
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
        if (ApiTypeHelper.isDefined(this.disabledEndpoints)) {
            generator.writeKey("disabled_endpoints");
            generator.writeStartObject();
            for (Map.Entry<String, List<String>> item0 : this.disabledEndpoints.entrySet()) {
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

        if (this.hasApiAccess != null) {
            generator.writeKey("has_api_access");
            generator.write(this.hasApiAccess);
        }

        if (this.user != null) {
            generator.writeKey("user");
            generator.write(this.user);
        }

        if (this.userName != null) {
            generator.writeKey("user_name");
            generator.write(this.userName);
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
     * Builder for {@link GetPermissionsInfoResponse}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, GetPermissionsInfoResponse> {
        @Nullable
        private Map<String, List<String>> disabledEndpoints;
        @Nullable
        private Boolean hasApiAccess;
        @Nullable
        private String user;
        @Nullable
        private String userName;

        public Builder() {}

        private Builder(GetPermissionsInfoResponse o) {
            this.disabledEndpoints = _mapCopy(o.disabledEndpoints);
            this.hasApiAccess = o.hasApiAccess;
            this.user = o.user;
            this.userName = o.userName;
        }

        private Builder(Builder o) {
            this.disabledEndpoints = _mapCopy(o.disabledEndpoints);
            this.hasApiAccess = o.hasApiAccess;
            this.user = o.user;
            this.userName = o.userName;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * An object with disabled APIs as keys and an array of HTTP methods as values.
         * <p>
         * API name: {@code disabled_endpoints}
         * </p>
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>disabledEndpoints</code>.
         * </p>
         */
        @Nonnull
        public final Builder disabledEndpoints(Map<String, List<String>> map) {
            this.disabledEndpoints = _mapPutAll(this.disabledEndpoints, map);
            return this;
        }

        /**
         * An object with disabled APIs as keys and an array of HTTP methods as values.
         * <p>
         * API name: {@code disabled_endpoints}
         * </p>
         *
         * <p>
         * Adds an entry to <code>disabledEndpoints</code>.
         * </p>
         */
        @Nonnull
        public final Builder disabledEndpoints(String key, List<String> value) {
            this.disabledEndpoints = _mapPut(this.disabledEndpoints, key, value);
            return this;
        }

        /**
         * API name: {@code has_api_access}
         */
        @Nonnull
        public final Builder hasApiAccess(@Nullable Boolean value) {
            this.hasApiAccess = value;
            return this;
        }

        /**
         * API name: {@code user}
         */
        @Nonnull
        public final Builder user(@Nullable String value) {
            this.user = value;
            return this;
        }

        /**
         * API name: {@code user_name}
         */
        @Nonnull
        public final Builder userName(@Nullable String value) {
            this.userName = value;
            return this;
        }

        /**
         * Builds a {@link GetPermissionsInfoResponse}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public GetPermissionsInfoResponse build() {
            _checkSingleUse();

            return new GetPermissionsInfoResponse(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link GetPermissionsInfoResponse}
     */
    public static final JsonpDeserializer<GetPermissionsInfoResponse> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        GetPermissionsInfoResponse::setupGetPermissionsInfoResponseDeserializer
    );

    protected static void setupGetPermissionsInfoResponseDeserializer(ObjectDeserializer<GetPermissionsInfoResponse.Builder> op) {
        op.add(
            Builder::disabledEndpoints,
            JsonpDeserializer.stringMapDeserializer(JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer())),
            "disabled_endpoints"
        );
        op.add(Builder::hasApiAccess, JsonpDeserializer.booleanDeserializer(), "has_api_access");
        op.add(Builder::user, JsonpDeserializer.stringDeserializer(), "user");
        op.add(Builder::userName, JsonpDeserializer.stringDeserializer(), "user_name");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.disabledEndpoints);
        result = 31 * result + Objects.hashCode(this.hasApiAccess);
        result = 31 * result + Objects.hashCode(this.user);
        result = 31 * result + Objects.hashCode(this.userName);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        GetPermissionsInfoResponse other = (GetPermissionsInfoResponse) o;
        return Objects.equals(this.disabledEndpoints, other.disabledEndpoints)
            && Objects.equals(this.hasApiAccess, other.hasApiAccess)
            && Objects.equals(this.user, other.user)
            && Objects.equals(this.userName, other.userName);
    }
}
