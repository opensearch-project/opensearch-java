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

// typedef: security.UserTenants

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class UserTenants implements PlainJsonSerializable, ToCopyableBuilder<UserTenants.Builder, UserTenants> {

    @Nullable
    private final Boolean admin;

    @Nullable
    private final Boolean adminTenant;

    @Nullable
    private final Boolean globalTenant;

    // ---------------------------------------------------------------------------------------------

    private UserTenants(Builder builder) {
        this.admin = builder.admin;
        this.adminTenant = builder.adminTenant;
        this.globalTenant = builder.globalTenant;
    }

    public static UserTenants of(Function<UserTenants.Builder, ObjectBuilder<UserTenants>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code admin}
     */
    @Nullable
    public final Boolean admin() {
        return this.admin;
    }

    /**
     * API name: {@code admin_tenant}
     */
    @Nullable
    public final Boolean adminTenant() {
        return this.adminTenant;
    }

    /**
     * API name: {@code global_tenant}
     */
    @Nullable
    public final Boolean globalTenant() {
        return this.globalTenant;
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
        if (this.admin != null) {
            generator.writeKey("admin");
            generator.write(this.admin);
        }

        if (this.adminTenant != null) {
            generator.writeKey("admin_tenant");
            generator.write(this.adminTenant);
        }

        if (this.globalTenant != null) {
            generator.writeKey("global_tenant");
            generator.write(this.globalTenant);
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
     * Builder for {@link UserTenants}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, UserTenants> {
        @Nullable
        private Boolean admin;
        @Nullable
        private Boolean adminTenant;
        @Nullable
        private Boolean globalTenant;

        public Builder() {}

        private Builder(UserTenants o) {
            this.admin = o.admin;
            this.adminTenant = o.adminTenant;
            this.globalTenant = o.globalTenant;
        }

        private Builder(Builder o) {
            this.admin = o.admin;
            this.adminTenant = o.adminTenant;
            this.globalTenant = o.globalTenant;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code admin}
         */
        @Nonnull
        public final Builder admin(@Nullable Boolean value) {
            this.admin = value;
            return this;
        }

        /**
         * API name: {@code admin_tenant}
         */
        @Nonnull
        public final Builder adminTenant(@Nullable Boolean value) {
            this.adminTenant = value;
            return this;
        }

        /**
         * API name: {@code global_tenant}
         */
        @Nonnull
        public final Builder globalTenant(@Nullable Boolean value) {
            this.globalTenant = value;
            return this;
        }

        /**
         * Builds a {@link UserTenants}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public UserTenants build() {
            _checkSingleUse();

            return new UserTenants(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link UserTenants}
     */
    public static final JsonpDeserializer<UserTenants> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        UserTenants::setupUserTenantsDeserializer
    );

    protected static void setupUserTenantsDeserializer(ObjectDeserializer<UserTenants.Builder> op) {
        op.add(Builder::admin, JsonpDeserializer.booleanDeserializer(), "admin");
        op.add(Builder::adminTenant, JsonpDeserializer.booleanDeserializer(), "admin_tenant");
        op.add(Builder::globalTenant, JsonpDeserializer.booleanDeserializer(), "global_tenant");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.admin);
        result = 31 * result + Objects.hashCode(this.adminTenant);
        result = 31 * result + Objects.hashCode(this.globalTenant);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        UserTenants other = (UserTenants) o;
        return Objects.equals(this.admin, other.admin)
            && Objects.equals(this.adminTenant, other.adminTenant)
            && Objects.equals(this.globalTenant, other.globalTenant);
    }
}
