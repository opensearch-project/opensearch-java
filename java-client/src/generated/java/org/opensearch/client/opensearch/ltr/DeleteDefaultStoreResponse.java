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

// typedef: ltr.delete_default_store.Response

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class DeleteDefaultStoreResponse
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<DeleteDefaultStoreResponse.Builder, DeleteDefaultStoreResponse> {

    @Nullable
    private final Boolean acknowledged;

    @Nullable
    private final String index;

    @Nullable
    private final Boolean shardsAcknowledged;

    // ---------------------------------------------------------------------------------------------

    private DeleteDefaultStoreResponse(Builder builder) {
        this.acknowledged = builder.acknowledged;
        this.index = builder.index;
        this.shardsAcknowledged = builder.shardsAcknowledged;
    }

    public static DeleteDefaultStoreResponse of(
        Function<DeleteDefaultStoreResponse.Builder, ObjectBuilder<DeleteDefaultStoreResponse>> fn
    ) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Indicates whether the request was acknowledged.
     * <p>
     * API name: {@code acknowledged}
     * </p>
     */
    @Nullable
    public final Boolean acknowledged() {
        return this.acknowledged;
    }

    /**
     * The name of the index.
     * <p>
     * API name: {@code index}
     * </p>
     */
    @Nullable
    public final String index() {
        return this.index;
    }

    /**
     * Indicates whether the required active shards were acknowledged.
     * <p>
     * API name: {@code shards_acknowledged}
     * </p>
     */
    @Nullable
    public final Boolean shardsAcknowledged() {
        return this.shardsAcknowledged;
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
        if (this.acknowledged != null) {
            generator.writeKey("acknowledged");
            generator.write(this.acknowledged);
        }

        if (this.index != null) {
            generator.writeKey("index");
            generator.write(this.index);
        }

        if (this.shardsAcknowledged != null) {
            generator.writeKey("shards_acknowledged");
            generator.write(this.shardsAcknowledged);
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
     * Builder for {@link DeleteDefaultStoreResponse}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, DeleteDefaultStoreResponse> {
        @Nullable
        private Boolean acknowledged;
        @Nullable
        private String index;
        @Nullable
        private Boolean shardsAcknowledged;

        public Builder() {}

        private Builder(DeleteDefaultStoreResponse o) {
            this.acknowledged = o.acknowledged;
            this.index = o.index;
            this.shardsAcknowledged = o.shardsAcknowledged;
        }

        private Builder(Builder o) {
            this.acknowledged = o.acknowledged;
            this.index = o.index;
            this.shardsAcknowledged = o.shardsAcknowledged;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Indicates whether the request was acknowledged.
         * <p>
         * API name: {@code acknowledged}
         * </p>
         */
        @Nonnull
        public final Builder acknowledged(@Nullable Boolean value) {
            this.acknowledged = value;
            return this;
        }

        /**
         * The name of the index.
         * <p>
         * API name: {@code index}
         * </p>
         */
        @Nonnull
        public final Builder index(@Nullable String value) {
            this.index = value;
            return this;
        }

        /**
         * Indicates whether the required active shards were acknowledged.
         * <p>
         * API name: {@code shards_acknowledged}
         * </p>
         */
        @Nonnull
        public final Builder shardsAcknowledged(@Nullable Boolean value) {
            this.shardsAcknowledged = value;
            return this;
        }

        /**
         * Builds a {@link DeleteDefaultStoreResponse}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public DeleteDefaultStoreResponse build() {
            _checkSingleUse();

            return new DeleteDefaultStoreResponse(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link DeleteDefaultStoreResponse}
     */
    public static final JsonpDeserializer<DeleteDefaultStoreResponse> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        DeleteDefaultStoreResponse::setupDeleteDefaultStoreResponseDeserializer
    );

    protected static void setupDeleteDefaultStoreResponseDeserializer(ObjectDeserializer<DeleteDefaultStoreResponse.Builder> op) {
        op.add(Builder::acknowledged, JsonpDeserializer.booleanDeserializer(), "acknowledged");
        op.add(Builder::index, JsonpDeserializer.stringDeserializer(), "index");
        op.add(Builder::shardsAcknowledged, JsonpDeserializer.booleanDeserializer(), "shards_acknowledged");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.acknowledged);
        result = 31 * result + Objects.hashCode(this.index);
        result = 31 * result + Objects.hashCode(this.shardsAcknowledged);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        DeleteDefaultStoreResponse other = (DeleteDefaultStoreResponse) o;
        return Objects.equals(this.acknowledged, other.acknowledged)
            && Objects.equals(this.index, other.index)
            && Objects.equals(this.shardsAcknowledged, other.shardsAcknowledged);
    }
}
