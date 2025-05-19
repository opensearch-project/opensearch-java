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

package org.opensearch.client.opensearch.core.pit;

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

// typedef: core.pit.DeletedPit

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class DeletedPit implements PlainJsonSerializable, ToCopyableBuilder<DeletedPit.Builder, DeletedPit> {

    @Nullable
    private final String pitId;

    @Nullable
    private final Boolean successful;

    // ---------------------------------------------------------------------------------------------

    private DeletedPit(Builder builder) {
        this.pitId = builder.pitId;
        this.successful = builder.successful;
    }

    public static DeletedPit of(Function<DeletedPit.Builder, ObjectBuilder<DeletedPit>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code pit_id}
     */
    @Nullable
    public final String pitId() {
        return this.pitId;
    }

    /**
     * API name: {@code successful}
     */
    @Nullable
    public final Boolean successful() {
        return this.successful;
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
        if (this.pitId != null) {
            generator.writeKey("pit_id");
            generator.write(this.pitId);
        }

        if (this.successful != null) {
            generator.writeKey("successful");
            generator.write(this.successful);
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
     * Builder for {@link DeletedPit}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, DeletedPit> {
        @Nullable
        private String pitId;
        @Nullable
        private Boolean successful;

        public Builder() {}

        private Builder(DeletedPit o) {
            this.pitId = o.pitId;
            this.successful = o.successful;
        }

        private Builder(Builder o) {
            this.pitId = o.pitId;
            this.successful = o.successful;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code pit_id}
         */
        @Nonnull
        public final Builder pitId(@Nullable String value) {
            this.pitId = value;
            return this;
        }

        /**
         * API name: {@code successful}
         */
        @Nonnull
        public final Builder successful(@Nullable Boolean value) {
            this.successful = value;
            return this;
        }

        /**
         * Builds a {@link DeletedPit}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public DeletedPit build() {
            _checkSingleUse();

            return new DeletedPit(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link DeletedPit}
     */
    public static final JsonpDeserializer<DeletedPit> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        DeletedPit::setupDeletedPitDeserializer
    );

    protected static void setupDeletedPitDeserializer(ObjectDeserializer<DeletedPit.Builder> op) {
        op.add(Builder::pitId, JsonpDeserializer.stringDeserializer(), "pit_id");
        op.add(Builder::successful, JsonpDeserializer.booleanDeserializer(), "successful");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.pitId);
        result = 31 * result + Objects.hashCode(this.successful);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        DeletedPit other = (DeletedPit) o;
        return Objects.equals(this.pitId, other.pitId) && Objects.equals(this.successful, other.successful);
    }
}
