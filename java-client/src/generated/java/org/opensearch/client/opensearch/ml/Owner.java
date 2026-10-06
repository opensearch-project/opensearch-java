/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

//----------------------------------------------------
// THIS CODE IS GENERATED. MANUAL EDITS WILL BE LOST.
//----------------------------------------------------

package org.opensearch.client.opensearch.ml;

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

// typedef: ml.Owner

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class Owner implements PlainJsonSerializable, ToCopyableBuilder<Owner.Builder, Owner> {

    @Nonnull
    private final List<String> backendRoles;

    @Nonnull
    private final List<String> customAttributeNames;

    @Nonnull
    private final String name;

    @Nonnull
    private final List<String> roles;

    @Nullable
    private final String userRequestedTenant;

    @Nullable
    private final String userRequestedTenantAccess;

    // ---------------------------------------------------------------------------------------------

    private Owner(Builder builder) {
        this.backendRoles = ApiTypeHelper.unmodifiable(builder.backendRoles);
        this.customAttributeNames = ApiTypeHelper.unmodifiable(builder.customAttributeNames);
        this.name = ApiTypeHelper.requireNonNull(builder.name, this, "name");
        this.roles = ApiTypeHelper.unmodifiable(builder.roles);
        this.userRequestedTenant = builder.userRequestedTenant;
        this.userRequestedTenantAccess = builder.userRequestedTenantAccess;
    }

    public static Owner of(Function<Owner.Builder, ObjectBuilder<Owner>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * The backend roles.
     * <p>
     * API name: {@code backend_roles}
     * </p>
     */
    @Nonnull
    public final List<String> backendRoles() {
        return this.backendRoles;
    }

    /**
     * The custom attribute names.
     * <p>
     * API name: {@code custom_attribute_names}
     * </p>
     */
    @Nonnull
    public final List<String> customAttributeNames() {
        return this.customAttributeNames;
    }

    /**
     * Required - API name: {@code name}
     */
    @Nonnull
    public final String name() {
        return this.name;
    }

    /**
     * The roles.
     * <p>
     * API name: {@code roles}
     * </p>
     */
    @Nonnull
    public final List<String> roles() {
        return this.roles;
    }

    /**
     * The user requested tenant.
     * <p>
     * API name: {@code user_requested_tenant}
     * </p>
     */
    @Nullable
    public final String userRequestedTenant() {
        return this.userRequestedTenant;
    }

    /**
     * The user requested tenant access.
     * <p>
     * API name: {@code user_requested_tenant_access}
     * </p>
     */
    @Nullable
    public final String userRequestedTenantAccess() {
        return this.userRequestedTenantAccess;
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
        if (ApiTypeHelper.isDefined(this.backendRoles)) {
            generator.writeKey("backend_roles");
            generator.writeStartArray();
            for (String item0 : this.backendRoles) {
                generator.write(item0);
            }
            generator.writeEnd();
        }

        if (ApiTypeHelper.isDefined(this.customAttributeNames)) {
            generator.writeKey("custom_attribute_names");
            generator.writeStartArray();
            for (String item0 : this.customAttributeNames) {
                generator.write(item0);
            }
            generator.writeEnd();
        }

        generator.writeKey("name");
        generator.write(this.name);

        if (ApiTypeHelper.isDefined(this.roles)) {
            generator.writeKey("roles");
            generator.writeStartArray();
            for (String item0 : this.roles) {
                generator.write(item0);
            }
            generator.writeEnd();
        }

        if (this.userRequestedTenant != null) {
            generator.writeKey("user_requested_tenant");
            generator.write(this.userRequestedTenant);
        }

        if (this.userRequestedTenantAccess != null) {
            generator.writeKey("user_requested_tenant_access");
            generator.write(this.userRequestedTenantAccess);
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
     * Builder for {@link Owner}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, Owner> {
        @Nullable
        private List<String> backendRoles;
        @Nullable
        private List<String> customAttributeNames;
        private String name;
        @Nullable
        private List<String> roles;
        @Nullable
        private String userRequestedTenant;
        @Nullable
        private String userRequestedTenantAccess;

        public Builder() {}

        private Builder(Owner o) {
            this.backendRoles = _listCopy(o.backendRoles);
            this.customAttributeNames = _listCopy(o.customAttributeNames);
            this.name = o.name;
            this.roles = _listCopy(o.roles);
            this.userRequestedTenant = o.userRequestedTenant;
            this.userRequestedTenantAccess = o.userRequestedTenantAccess;
        }

        private Builder(Builder o) {
            this.backendRoles = _listCopy(o.backendRoles);
            this.customAttributeNames = _listCopy(o.customAttributeNames);
            this.name = o.name;
            this.roles = _listCopy(o.roles);
            this.userRequestedTenant = o.userRequestedTenant;
            this.userRequestedTenantAccess = o.userRequestedTenantAccess;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * The backend roles.
         * <p>
         * API name: {@code backend_roles}
         * </p>
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>backendRoles</code>.
         * </p>
         */
        @Nonnull
        public final Builder backendRoles(List<String> list) {
            this.backendRoles = _listAddAll(this.backendRoles, list);
            return this;
        }

        /**
         * The backend roles.
         * <p>
         * API name: {@code backend_roles}
         * </p>
         *
         * <p>
         * Adds one or more values to <code>backendRoles</code>.
         * </p>
         */
        @Nonnull
        public final Builder backendRoles(String value, String... values) {
            this.backendRoles = _listAdd(this.backendRoles, value, values);
            return this;
        }

        /**
         * The custom attribute names.
         * <p>
         * API name: {@code custom_attribute_names}
         * </p>
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>customAttributeNames</code>.
         * </p>
         */
        @Nonnull
        public final Builder customAttributeNames(List<String> list) {
            this.customAttributeNames = _listAddAll(this.customAttributeNames, list);
            return this;
        }

        /**
         * The custom attribute names.
         * <p>
         * API name: {@code custom_attribute_names}
         * </p>
         *
         * <p>
         * Adds one or more values to <code>customAttributeNames</code>.
         * </p>
         */
        @Nonnull
        public final Builder customAttributeNames(String value, String... values) {
            this.customAttributeNames = _listAdd(this.customAttributeNames, value, values);
            return this;
        }

        /**
         * Required - API name: {@code name}
         */
        @Nonnull
        public final Builder name(String value) {
            this.name = value;
            return this;
        }

        /**
         * The roles.
         * <p>
         * API name: {@code roles}
         * </p>
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>roles</code>.
         * </p>
         */
        @Nonnull
        public final Builder roles(List<String> list) {
            this.roles = _listAddAll(this.roles, list);
            return this;
        }

        /**
         * The roles.
         * <p>
         * API name: {@code roles}
         * </p>
         *
         * <p>
         * Adds one or more values to <code>roles</code>.
         * </p>
         */
        @Nonnull
        public final Builder roles(String value, String... values) {
            this.roles = _listAdd(this.roles, value, values);
            return this;
        }

        /**
         * The user requested tenant.
         * <p>
         * API name: {@code user_requested_tenant}
         * </p>
         */
        @Nonnull
        public final Builder userRequestedTenant(@Nullable String value) {
            this.userRequestedTenant = value;
            return this;
        }

        /**
         * The user requested tenant access.
         * <p>
         * API name: {@code user_requested_tenant_access}
         * </p>
         */
        @Nonnull
        public final Builder userRequestedTenantAccess(@Nullable String value) {
            this.userRequestedTenantAccess = value;
            return this;
        }

        /**
         * Builds a {@link Owner}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public Owner build() {
            _checkSingleUse();

            return new Owner(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link Owner}
     */
    public static final JsonpDeserializer<Owner> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        Owner::setupOwnerDeserializer
    );

    protected static void setupOwnerDeserializer(ObjectDeserializer<Owner.Builder> op) {
        op.add(Builder::backendRoles, JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()), "backend_roles");
        op.add(
            Builder::customAttributeNames,
            JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()),
            "custom_attribute_names"
        );
        op.add(Builder::name, JsonpDeserializer.stringDeserializer(), "name");
        op.add(Builder::roles, JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()), "roles");
        op.add(Builder::userRequestedTenant, JsonpDeserializer.stringDeserializer(), "user_requested_tenant");
        op.add(Builder::userRequestedTenantAccess, JsonpDeserializer.stringDeserializer(), "user_requested_tenant_access");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.backendRoles);
        result = 31 * result + Objects.hashCode(this.customAttributeNames);
        result = 31 * result + this.name.hashCode();
        result = 31 * result + Objects.hashCode(this.roles);
        result = 31 * result + Objects.hashCode(this.userRequestedTenant);
        result = 31 * result + Objects.hashCode(this.userRequestedTenantAccess);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Owner other = (Owner) o;
        return Objects.equals(this.backendRoles, other.backendRoles)
            && Objects.equals(this.customAttributeNames, other.customAttributeNames)
            && this.name.equals(other.name)
            && Objects.equals(this.roles, other.roles)
            && Objects.equals(this.userRequestedTenant, other.userRequestedTenant)
            && Objects.equals(this.userRequestedTenantAccess, other.userRequestedTenantAccess);
    }
}
