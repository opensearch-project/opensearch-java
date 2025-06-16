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

// typedef: security.patch_role_mapping.Response

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class PatchRoleMappingResponse
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<PatchRoleMappingResponse.Builder, PatchRoleMappingResponse> {

    @Nullable
    private final String message;

    @Nullable
    private final String status;

    // ---------------------------------------------------------------------------------------------

    private PatchRoleMappingResponse(Builder builder) {
        this.message = builder.message;
        this.status = builder.status;
    }

    public static PatchRoleMappingResponse of(Function<PatchRoleMappingResponse.Builder, ObjectBuilder<PatchRoleMappingResponse>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * The message returned as part of an <code>OK</code> response.
     * <p>
     * API name: {@code message}
     * </p>
     */
    @Nullable
    public final String message() {
        return this.message;
    }

    /**
     * API name: {@code status}
     */
    @Nullable
    public final String status() {
        return this.status;
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
        if (this.message != null) {
            generator.writeKey("message");
            generator.write(this.message);
        }

        if (this.status != null) {
            generator.writeKey("status");
            generator.write(this.status);
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
     * Builder for {@link PatchRoleMappingResponse}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, PatchRoleMappingResponse> {
        @Nullable
        private String message;
        @Nullable
        private String status;

        public Builder() {}

        private Builder(PatchRoleMappingResponse o) {
            this.message = o.message;
            this.status = o.status;
        }

        private Builder(Builder o) {
            this.message = o.message;
            this.status = o.status;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * The message returned as part of an <code>OK</code> response.
         * <p>
         * API name: {@code message}
         * </p>
         */
        @Nonnull
        public final Builder message(@Nullable String value) {
            this.message = value;
            return this;
        }

        /**
         * API name: {@code status}
         */
        @Nonnull
        public final Builder status(@Nullable String value) {
            this.status = value;
            return this;
        }

        /**
         * Builds a {@link PatchRoleMappingResponse}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public PatchRoleMappingResponse build() {
            _checkSingleUse();

            return new PatchRoleMappingResponse(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link PatchRoleMappingResponse}
     */
    public static final JsonpDeserializer<PatchRoleMappingResponse> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        PatchRoleMappingResponse::setupPatchRoleMappingResponseDeserializer
    );

    protected static void setupPatchRoleMappingResponseDeserializer(ObjectDeserializer<PatchRoleMappingResponse.Builder> op) {
        op.add(Builder::message, JsonpDeserializer.stringDeserializer(), "message");
        op.add(Builder::status, JsonpDeserializer.stringDeserializer(), "status");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.message);
        result = 31 * result + Objects.hashCode(this.status);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        PatchRoleMappingResponse other = (PatchRoleMappingResponse) o;
        return Objects.equals(this.message, other.message) && Objects.equals(this.status, other.status);
    }
}
