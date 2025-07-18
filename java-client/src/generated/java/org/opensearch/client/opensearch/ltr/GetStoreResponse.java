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

package org.opensearch.client.opensearch.ltr;

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

// typedef: ltr.get_store.Response

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class GetStoreResponse implements PlainJsonSerializable, ToCopyableBuilder<GetStoreResponse.Builder, GetStoreResponse> {

    @Nullable
    private final Boolean exists;

    // ---------------------------------------------------------------------------------------------

    private GetStoreResponse(Builder builder) {
        this.exists = builder.exists;
    }

    public static GetStoreResponse of(Function<GetStoreResponse.Builder, ObjectBuilder<GetStoreResponse>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Indicates whether the store exists.
     * <p>
     * API name: {@code exists}
     * </p>
     */
    @Nullable
    public final Boolean exists() {
        return this.exists;
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
        if (this.exists != null) {
            generator.writeKey("exists");
            generator.write(this.exists);
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
     * Builder for {@link GetStoreResponse}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, GetStoreResponse> {
        @Nullable
        private Boolean exists;

        public Builder() {}

        private Builder(GetStoreResponse o) {
            this.exists = o.exists;
        }

        private Builder(Builder o) {
            this.exists = o.exists;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Indicates whether the store exists.
         * <p>
         * API name: {@code exists}
         * </p>
         */
        @Nonnull
        public final Builder exists(@Nullable Boolean value) {
            this.exists = value;
            return this;
        }

        /**
         * Builds a {@link GetStoreResponse}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public GetStoreResponse build() {
            _checkSingleUse();

            return new GetStoreResponse(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link GetStoreResponse}
     */
    public static final JsonpDeserializer<GetStoreResponse> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        GetStoreResponse::setupGetStoreResponseDeserializer
    );

    protected static void setupGetStoreResponseDeserializer(ObjectDeserializer<GetStoreResponse.Builder> op) {
        op.add(Builder::exists, JsonpDeserializer.booleanDeserializer(), "exists");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.exists);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        GetStoreResponse other = (GetStoreResponse) o;
        return Objects.equals(this.exists, other.exists);
    }
}
