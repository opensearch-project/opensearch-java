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

// typedef: security.get_audit_configuration.Response

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class GetAuditConfigurationResponse
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<GetAuditConfigurationResponse.Builder, GetAuditConfigurationResponse> {

    @Nullable
    private final AuditConfig config;

    @Nonnull
    private final List<String> readonly;

    // ---------------------------------------------------------------------------------------------

    private GetAuditConfigurationResponse(Builder builder) {
        this.config = builder.config;
        this.readonly = ApiTypeHelper.unmodifiable(builder.readonly);
    }

    public static GetAuditConfigurationResponse of(
        Function<GetAuditConfigurationResponse.Builder, ObjectBuilder<GetAuditConfigurationResponse>> fn
    ) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code config}
     */
    @Nullable
    public final AuditConfig config() {
        return this.config;
    }

    /**
     * API name: {@code _readonly}
     */
    @Nonnull
    public final List<String> readonly() {
        return this.readonly;
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
        if (this.config != null) {
            generator.writeKey("config");
            this.config.serialize(generator, mapper);
        }

        if (ApiTypeHelper.isDefined(this.readonly)) {
            generator.writeKey("_readonly");
            generator.writeStartArray();
            for (String item0 : this.readonly) {
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
     * Builder for {@link GetAuditConfigurationResponse}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, GetAuditConfigurationResponse> {
        @Nullable
        private AuditConfig config;
        @Nullable
        private List<String> readonly;

        public Builder() {}

        private Builder(GetAuditConfigurationResponse o) {
            this.config = o.config;
            this.readonly = _listCopy(o.readonly);
        }

        private Builder(Builder o) {
            this.config = o.config;
            this.readonly = _listCopy(o.readonly);
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code config}
         */
        @Nonnull
        public final Builder config(@Nullable AuditConfig value) {
            this.config = value;
            return this;
        }

        /**
         * API name: {@code config}
         */
        @Nonnull
        public final Builder config(Function<AuditConfig.Builder, ObjectBuilder<AuditConfig>> fn) {
            return config(fn.apply(new AuditConfig.Builder()).build());
        }

        /**
         * API name: {@code _readonly}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>readonly</code>.
         * </p>
         */
        @Nonnull
        public final Builder readonly(List<String> list) {
            this.readonly = _listAddAll(this.readonly, list);
            return this;
        }

        /**
         * API name: {@code _readonly}
         *
         * <p>
         * Adds one or more values to <code>readonly</code>.
         * </p>
         */
        @Nonnull
        public final Builder readonly(String value, String... values) {
            this.readonly = _listAdd(this.readonly, value, values);
            return this;
        }

        /**
         * Builds a {@link GetAuditConfigurationResponse}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public GetAuditConfigurationResponse build() {
            _checkSingleUse();

            return new GetAuditConfigurationResponse(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link GetAuditConfigurationResponse}
     */
    public static final JsonpDeserializer<GetAuditConfigurationResponse> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        GetAuditConfigurationResponse::setupGetAuditConfigurationResponseDeserializer
    );

    protected static void setupGetAuditConfigurationResponseDeserializer(ObjectDeserializer<GetAuditConfigurationResponse.Builder> op) {
        op.add(Builder::config, AuditConfig._DESERIALIZER, "config");
        op.add(Builder::readonly, JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()), "_readonly");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.config);
        result = 31 * result + Objects.hashCode(this.readonly);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        GetAuditConfigurationResponse other = (GetAuditConfigurationResponse) o;
        return Objects.equals(this.config, other.config) && Objects.equals(this.readonly, other.readonly);
    }
}
