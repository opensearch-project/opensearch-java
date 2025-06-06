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

// typedef: security.User

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class User implements PlainJsonSerializable, ToCopyableBuilder<User.Builder, User> {

    @Nonnull
    private final Map<String, String> attributes;

    @Nonnull
    private final List<String> backendRoles;

    @Nullable
    private final String description;

    @Nullable
    private final String hash;

    @Nullable
    private final Boolean hidden;

    @Nonnull
    private final List<String> opendistroSecurityRoles;

    @Nullable
    private final String password;

    @Nullable
    private final Boolean reserved;

    @Nullable
    private final Boolean static_;

    // ---------------------------------------------------------------------------------------------

    private User(Builder builder) {
        this.attributes = ApiTypeHelper.unmodifiable(builder.attributes);
        this.backendRoles = ApiTypeHelper.unmodifiable(builder.backendRoles);
        this.description = builder.description;
        this.hash = builder.hash;
        this.hidden = builder.hidden;
        this.opendistroSecurityRoles = ApiTypeHelper.unmodifiable(builder.opendistroSecurityRoles);
        this.password = builder.password;
        this.reserved = builder.reserved;
        this.static_ = builder.static_;
    }

    public static User of(Function<User.Builder, ObjectBuilder<User>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code attributes}
     */
    @Nonnull
    public final Map<String, String> attributes() {
        return this.attributes;
    }

    /**
     * API name: {@code backend_roles}
     */
    @Nonnull
    public final List<String> backendRoles() {
        return this.backendRoles;
    }

    /**
     * API name: {@code description}
     */
    @Nullable
    public final String description() {
        return this.description;
    }

    /**
     * API name: {@code hash}
     */
    @Nullable
    public final String hash() {
        return this.hash;
    }

    /**
     * API name: {@code hidden}
     */
    @Nullable
    public final Boolean hidden() {
        return this.hidden;
    }

    /**
     * API name: {@code opendistro_security_roles}
     */
    @Nonnull
    public final List<String> opendistroSecurityRoles() {
        return this.opendistroSecurityRoles;
    }

    /**
     * API name: {@code password}
     */
    @Nullable
    public final String password() {
        return this.password;
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
     * Serialize this object to JSON.
     */
    @Override
    public void serialize(JsonGenerator generator, JsonpMapper mapper) {
        generator.writeStartObject();
        serializeInternal(generator, mapper);
        generator.writeEnd();
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        if (ApiTypeHelper.isDefined(this.attributes)) {
            generator.writeKey("attributes");
            generator.writeStartObject();
            for (Map.Entry<String, String> item0 : this.attributes.entrySet()) {
                generator.writeKey(item0.getKey());
                generator.write(item0.getValue());
            }
            generator.writeEnd();
        }

        if (ApiTypeHelper.isDefined(this.backendRoles)) {
            generator.writeKey("backend_roles");
            generator.writeStartArray();
            for (String item0 : this.backendRoles) {
                generator.write(item0);
            }
            generator.writeEnd();
        }

        if (this.description != null) {
            generator.writeKey("description");
            generator.write(this.description);
        }

        if (this.hash != null) {
            generator.writeKey("hash");
            generator.write(this.hash);
        }

        if (this.hidden != null) {
            generator.writeKey("hidden");
            generator.write(this.hidden);
        }

        if (ApiTypeHelper.isDefined(this.opendistroSecurityRoles)) {
            generator.writeKey("opendistro_security_roles");
            generator.writeStartArray();
            for (String item0 : this.opendistroSecurityRoles) {
                generator.write(item0);
            }
            generator.writeEnd();
        }

        if (this.password != null) {
            generator.writeKey("password");
            generator.write(this.password);
        }

        if (this.reserved != null) {
            generator.writeKey("reserved");
            generator.write(this.reserved);
        }

        if (this.static_ != null) {
            generator.writeKey("static");
            generator.write(this.static_);
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
     * Builder for {@link User}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, User> {
        @Nullable
        private Map<String, String> attributes;
        @Nullable
        private List<String> backendRoles;
        @Nullable
        private String description;
        @Nullable
        private String hash;
        @Nullable
        private Boolean hidden;
        @Nullable
        private List<String> opendistroSecurityRoles;
        @Nullable
        private String password;
        @Nullable
        private Boolean reserved;
        @Nullable
        private Boolean static_;

        public Builder() {}

        private Builder(User o) {
            this.attributes = _mapCopy(o.attributes);
            this.backendRoles = _listCopy(o.backendRoles);
            this.description = o.description;
            this.hash = o.hash;
            this.hidden = o.hidden;
            this.opendistroSecurityRoles = _listCopy(o.opendistroSecurityRoles);
            this.password = o.password;
            this.reserved = o.reserved;
            this.static_ = o.static_;
        }

        private Builder(Builder o) {
            this.attributes = _mapCopy(o.attributes);
            this.backendRoles = _listCopy(o.backendRoles);
            this.description = o.description;
            this.hash = o.hash;
            this.hidden = o.hidden;
            this.opendistroSecurityRoles = _listCopy(o.opendistroSecurityRoles);
            this.password = o.password;
            this.reserved = o.reserved;
            this.static_ = o.static_;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code attributes}
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>attributes</code>.
         * </p>
         */
        @Nonnull
        public final Builder attributes(Map<String, String> map) {
            this.attributes = _mapPutAll(this.attributes, map);
            return this;
        }

        /**
         * API name: {@code attributes}
         *
         * <p>
         * Adds an entry to <code>attributes</code>.
         * </p>
         */
        @Nonnull
        public final Builder attributes(String key, String value) {
            this.attributes = _mapPut(this.attributes, key, value);
            return this;
        }

        /**
         * API name: {@code backend_roles}
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
         * API name: {@code backend_roles}
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
         * API name: {@code description}
         */
        @Nonnull
        public final Builder description(@Nullable String value) {
            this.description = value;
            return this;
        }

        /**
         * API name: {@code hash}
         */
        @Nonnull
        public final Builder hash(@Nullable String value) {
            this.hash = value;
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
         * API name: {@code opendistro_security_roles}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>opendistroSecurityRoles</code>.
         * </p>
         */
        @Nonnull
        public final Builder opendistroSecurityRoles(List<String> list) {
            this.opendistroSecurityRoles = _listAddAll(this.opendistroSecurityRoles, list);
            return this;
        }

        /**
         * API name: {@code opendistro_security_roles}
         *
         * <p>
         * Adds one or more values to <code>opendistroSecurityRoles</code>.
         * </p>
         */
        @Nonnull
        public final Builder opendistroSecurityRoles(String value, String... values) {
            this.opendistroSecurityRoles = _listAdd(this.opendistroSecurityRoles, value, values);
            return this;
        }

        /**
         * API name: {@code password}
         */
        @Nonnull
        public final Builder password(@Nullable String value) {
            this.password = value;
            return this;
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
         * Builds a {@link User}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public User build() {
            _checkSingleUse();

            return new User(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link User}
     */
    public static final JsonpDeserializer<User> _DESERIALIZER = ObjectBuilderDeserializer.lazy(Builder::new, User::setupUserDeserializer);

    protected static void setupUserDeserializer(ObjectDeserializer<User.Builder> op) {
        op.add(Builder::attributes, JsonpDeserializer.stringMapDeserializer(JsonpDeserializer.stringDeserializer()), "attributes");
        op.add(Builder::backendRoles, JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()), "backend_roles");
        op.add(Builder::description, JsonpDeserializer.stringDeserializer(), "description");
        op.add(Builder::hash, JsonpDeserializer.stringDeserializer(), "hash");
        op.add(Builder::hidden, JsonpDeserializer.booleanDeserializer(), "hidden");
        op.add(
            Builder::opendistroSecurityRoles,
            JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()),
            "opendistro_security_roles"
        );
        op.add(Builder::password, JsonpDeserializer.stringDeserializer(), "password");
        op.add(Builder::reserved, JsonpDeserializer.booleanDeserializer(), "reserved");
        op.add(Builder::static_, JsonpDeserializer.booleanDeserializer(), "static");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.attributes);
        result = 31 * result + Objects.hashCode(this.backendRoles);
        result = 31 * result + Objects.hashCode(this.description);
        result = 31 * result + Objects.hashCode(this.hash);
        result = 31 * result + Objects.hashCode(this.hidden);
        result = 31 * result + Objects.hashCode(this.opendistroSecurityRoles);
        result = 31 * result + Objects.hashCode(this.password);
        result = 31 * result + Objects.hashCode(this.reserved);
        result = 31 * result + Objects.hashCode(this.static_);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        User other = (User) o;
        return Objects.equals(this.attributes, other.attributes)
            && Objects.equals(this.backendRoles, other.backendRoles)
            && Objects.equals(this.description, other.description)
            && Objects.equals(this.hash, other.hash)
            && Objects.equals(this.hidden, other.hidden)
            && Objects.equals(this.opendistroSecurityRoles, other.opendistroSecurityRoles)
            && Objects.equals(this.password, other.password)
            && Objects.equals(this.reserved, other.reserved)
            && Objects.equals(this.static_, other.static_);
    }
}
