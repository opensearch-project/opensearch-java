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

// typedef: security.Role

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class Role implements PlainJsonSerializable, ToCopyableBuilder<Role.Builder, Role> {

    @Nonnull
    private final List<String> clusterPermissions;

    @Nullable
    private final String description;

    @Nullable
    private final Boolean hidden;

    @Nonnull
    private final List<IndexPermission> indexPermissions;

    @Nullable
    private final Boolean reserved;

    @Nullable
    private final Boolean static_;

    @Nonnull
    private final List<TenantPermission> tenantPermissions;

    // ---------------------------------------------------------------------------------------------

    private Role(Builder builder) {
        this.clusterPermissions = ApiTypeHelper.unmodifiable(builder.clusterPermissions);
        this.description = builder.description;
        this.hidden = builder.hidden;
        this.indexPermissions = ApiTypeHelper.unmodifiable(builder.indexPermissions);
        this.reserved = builder.reserved;
        this.static_ = builder.static_;
        this.tenantPermissions = ApiTypeHelper.unmodifiable(builder.tenantPermissions);
    }

    public static Role of(Function<Role.Builder, ObjectBuilder<Role>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code cluster_permissions}
     */
    @Nonnull
    public final List<String> clusterPermissions() {
        return this.clusterPermissions;
    }

    /**
     * API name: {@code description}
     */
    @Nullable
    public final String description() {
        return this.description;
    }

    /**
     * API name: {@code hidden}
     */
    @Nullable
    public final Boolean hidden() {
        return this.hidden;
    }

    /**
     * API name: {@code index_permissions}
     */
    @Nonnull
    public final List<IndexPermission> indexPermissions() {
        return this.indexPermissions;
    }

    /**
     * API name: {@code reserved}
     */
    @Nullable
    public final Boolean reserved() {
        return this.reserved;
    }

    /**
     * API name: {@code static}
     */
    @Nullable
    public final Boolean static_() {
        return this.static_;
    }

    /**
     * API name: {@code tenant_permissions}
     */
    @Nonnull
    public final List<TenantPermission> tenantPermissions() {
        return this.tenantPermissions;
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
        if (ApiTypeHelper.isDefined(this.clusterPermissions)) {
            generator.writeKey("cluster_permissions");
            generator.writeStartArray();
            for (String item0 : this.clusterPermissions) {
                generator.write(item0);
            }
            generator.writeEnd();
        }

        if (this.description != null) {
            generator.writeKey("description");
            generator.write(this.description);
        }

        if (this.hidden != null) {
            generator.writeKey("hidden");
            generator.write(this.hidden);
        }

        if (ApiTypeHelper.isDefined(this.indexPermissions)) {
            generator.writeKey("index_permissions");
            generator.writeStartArray();
            for (IndexPermission item0 : this.indexPermissions) {
                item0.serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        if (this.reserved != null) {
            generator.writeKey("reserved");
            generator.write(this.reserved);
        }

        if (this.static_ != null) {
            generator.writeKey("static");
            generator.write(this.static_);
        }

        if (ApiTypeHelper.isDefined(this.tenantPermissions)) {
            generator.writeKey("tenant_permissions");
            generator.writeStartArray();
            for (TenantPermission item0 : this.tenantPermissions) {
                item0.serialize(generator, mapper);
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
     * Builder for {@link Role}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, Role> {
        @Nullable
        private List<String> clusterPermissions;
        @Nullable
        private String description;
        @Nullable
        private Boolean hidden;
        @Nullable
        private List<IndexPermission> indexPermissions;
        @Nullable
        private Boolean reserved;
        @Nullable
        private Boolean static_;
        @Nullable
        private List<TenantPermission> tenantPermissions;

        public Builder() {}

        private Builder(Role o) {
            this.clusterPermissions = _listCopy(o.clusterPermissions);
            this.description = o.description;
            this.hidden = o.hidden;
            this.indexPermissions = _listCopy(o.indexPermissions);
            this.reserved = o.reserved;
            this.static_ = o.static_;
            this.tenantPermissions = _listCopy(o.tenantPermissions);
        }

        private Builder(Builder o) {
            this.clusterPermissions = _listCopy(o.clusterPermissions);
            this.description = o.description;
            this.hidden = o.hidden;
            this.indexPermissions = _listCopy(o.indexPermissions);
            this.reserved = o.reserved;
            this.static_ = o.static_;
            this.tenantPermissions = _listCopy(o.tenantPermissions);
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code cluster_permissions}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>clusterPermissions</code>.
         * </p>
         */
        @Nonnull
        public final Builder clusterPermissions(List<String> list) {
            this.clusterPermissions = _listAddAll(this.clusterPermissions, list);
            return this;
        }

        /**
         * API name: {@code cluster_permissions}
         *
         * <p>
         * Adds one or more values to <code>clusterPermissions</code>.
         * </p>
         */
        @Nonnull
        public final Builder clusterPermissions(String value, String... values) {
            this.clusterPermissions = _listAdd(this.clusterPermissions, value, values);
            return this;
        }

        /**
         * API name: {@code description}
         */
        @Nonnull
        public final Builder description(@Nullable String value) {
            this.description = value;
            return this;
        }

        /**
         * API name: {@code hidden}
         */
        @Nonnull
        public final Builder hidden(@Nullable Boolean value) {
            this.hidden = value;
            return this;
        }

        /**
         * API name: {@code index_permissions}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>indexPermissions</code>.
         * </p>
         */
        @Nonnull
        public final Builder indexPermissions(List<IndexPermission> list) {
            this.indexPermissions = _listAddAll(this.indexPermissions, list);
            return this;
        }

        /**
         * API name: {@code index_permissions}
         *
         * <p>
         * Adds one or more values to <code>indexPermissions</code>.
         * </p>
         */
        @Nonnull
        public final Builder indexPermissions(IndexPermission value, IndexPermission... values) {
            this.indexPermissions = _listAdd(this.indexPermissions, value, values);
            return this;
        }

        /**
         * API name: {@code index_permissions}
         *
         * <p>
         * Adds a value to <code>indexPermissions</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder indexPermissions(Function<IndexPermission.Builder, ObjectBuilder<IndexPermission>> fn) {
            return indexPermissions(fn.apply(new IndexPermission.Builder()).build());
        }

        /**
         * API name: {@code reserved}
         */
        @Nonnull
        public final Builder reserved(@Nullable Boolean value) {
            this.reserved = value;
            return this;
        }

        /**
         * API name: {@code static}
         */
        @Nonnull
        public final Builder static_(@Nullable Boolean value) {
            this.static_ = value;
            return this;
        }

        /**
         * API name: {@code tenant_permissions}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>tenantPermissions</code>.
         * </p>
         */
        @Nonnull
        public final Builder tenantPermissions(List<TenantPermission> list) {
            this.tenantPermissions = _listAddAll(this.tenantPermissions, list);
            return this;
        }

        /**
         * API name: {@code tenant_permissions}
         *
         * <p>
         * Adds one or more values to <code>tenantPermissions</code>.
         * </p>
         */
        @Nonnull
        public final Builder tenantPermissions(TenantPermission value, TenantPermission... values) {
            this.tenantPermissions = _listAdd(this.tenantPermissions, value, values);
            return this;
        }

        /**
         * API name: {@code tenant_permissions}
         *
         * <p>
         * Adds a value to <code>tenantPermissions</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder tenantPermissions(Function<TenantPermission.Builder, ObjectBuilder<TenantPermission>> fn) {
            return tenantPermissions(fn.apply(new TenantPermission.Builder()).build());
        }

        /**
         * Builds a {@link Role}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public Role build() {
            _checkSingleUse();

            return new Role(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link Role}
     */
    public static final JsonpDeserializer<Role> _DESERIALIZER = ObjectBuilderDeserializer.lazy(Builder::new, Role::setupRoleDeserializer);

    protected static void setupRoleDeserializer(ObjectDeserializer<Role.Builder> op) {
        op.add(
            Builder::clusterPermissions,
            JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()),
            "cluster_permissions"
        );
        op.add(Builder::description, JsonpDeserializer.stringDeserializer(), "description");
        op.add(Builder::hidden, JsonpDeserializer.booleanDeserializer(), "hidden");
        op.add(Builder::indexPermissions, JsonpDeserializer.arrayDeserializer(IndexPermission._DESERIALIZER), "index_permissions");
        op.add(Builder::reserved, JsonpDeserializer.booleanDeserializer(), "reserved");
        op.add(Builder::static_, JsonpDeserializer.booleanDeserializer(), "static");
        op.add(Builder::tenantPermissions, JsonpDeserializer.arrayDeserializer(TenantPermission._DESERIALIZER), "tenant_permissions");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.clusterPermissions);
        result = 31 * result + Objects.hashCode(this.description);
        result = 31 * result + Objects.hashCode(this.hidden);
        result = 31 * result + Objects.hashCode(this.indexPermissions);
        result = 31 * result + Objects.hashCode(this.reserved);
        result = 31 * result + Objects.hashCode(this.static_);
        result = 31 * result + Objects.hashCode(this.tenantPermissions);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Role other = (Role) o;
        return Objects.equals(this.clusterPermissions, other.clusterPermissions)
            && Objects.equals(this.description, other.description)
            && Objects.equals(this.hidden, other.hidden)
            && Objects.equals(this.indexPermissions, other.indexPermissions)
            && Objects.equals(this.reserved, other.reserved)
            && Objects.equals(this.static_, other.static_)
            && Objects.equals(this.tenantPermissions, other.tenantPermissions);
    }
}
