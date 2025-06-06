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

// typedef: security.TenantPermission

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class TenantPermission implements PlainJsonSerializable, ToCopyableBuilder<TenantPermission.Builder, TenantPermission> {

    @Nonnull
    private final List<String> allowedActions;

    @Nonnull
    private final List<String> tenantPatterns;

    // ---------------------------------------------------------------------------------------------

    private TenantPermission(Builder builder) {
        this.allowedActions = ApiTypeHelper.unmodifiable(builder.allowedActions);
        this.tenantPatterns = ApiTypeHelper.unmodifiable(builder.tenantPatterns);
    }

    public static TenantPermission of(Function<TenantPermission.Builder, ObjectBuilder<TenantPermission>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code allowed_actions}
     */
    @Nonnull
    public final List<String> allowedActions() {
        return this.allowedActions;
    }

    /**
     * API name: {@code tenant_patterns}
     */
    @Nonnull
    public final List<String> tenantPatterns() {
        return this.tenantPatterns;
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
        if (ApiTypeHelper.isDefined(this.allowedActions)) {
            generator.writeKey("allowed_actions");
            generator.writeStartArray();
            for (String item0 : this.allowedActions) {
                generator.write(item0);
            }
            generator.writeEnd();
        }

        if (ApiTypeHelper.isDefined(this.tenantPatterns)) {
            generator.writeKey("tenant_patterns");
            generator.writeStartArray();
            for (String item0 : this.tenantPatterns) {
                generator.write(item0);
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
     * Builder for {@link TenantPermission}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, TenantPermission> {
        @Nullable
        private List<String> allowedActions;
        @Nullable
        private List<String> tenantPatterns;

        public Builder() {}

        private Builder(TenantPermission o) {
            this.allowedActions = _listCopy(o.allowedActions);
            this.tenantPatterns = _listCopy(o.tenantPatterns);
        }

        private Builder(Builder o) {
            this.allowedActions = _listCopy(o.allowedActions);
            this.tenantPatterns = _listCopy(o.tenantPatterns);
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code allowed_actions}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>allowedActions</code>.
         * </p>
         */
        @Nonnull
        public final Builder allowedActions(List<String> list) {
            this.allowedActions = _listAddAll(this.allowedActions, list);
            return this;
        }

        /**
         * API name: {@code allowed_actions}
         *
         * <p>
         * Adds one or more values to <code>allowedActions</code>.
         * </p>
         */
        @Nonnull
        public final Builder allowedActions(String value, String... values) {
            this.allowedActions = _listAdd(this.allowedActions, value, values);
            return this;
        }

        /**
         * API name: {@code tenant_patterns}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>tenantPatterns</code>.
         * </p>
         */
        @Nonnull
        public final Builder tenantPatterns(List<String> list) {
            this.tenantPatterns = _listAddAll(this.tenantPatterns, list);
            return this;
        }

        /**
         * API name: {@code tenant_patterns}
         *
         * <p>
         * Adds one or more values to <code>tenantPatterns</code>.
         * </p>
         */
        @Nonnull
        public final Builder tenantPatterns(String value, String... values) {
            this.tenantPatterns = _listAdd(this.tenantPatterns, value, values);
            return this;
        }

        /**
         * Builds a {@link TenantPermission}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public TenantPermission build() {
            _checkSingleUse();

            return new TenantPermission(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link TenantPermission}
     */
    public static final JsonpDeserializer<TenantPermission> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        TenantPermission::setupTenantPermissionDeserializer
    );

    protected static void setupTenantPermissionDeserializer(ObjectDeserializer<TenantPermission.Builder> op) {
        op.add(Builder::allowedActions, JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()), "allowed_actions");
        op.add(Builder::tenantPatterns, JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()), "tenant_patterns");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.allowedActions);
        result = 31 * result + Objects.hashCode(this.tenantPatterns);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        TenantPermission other = (TenantPermission) o;
        return Objects.equals(this.allowedActions, other.allowedActions) && Objects.equals(this.tenantPatterns, other.tenantPatterns);
    }
}
