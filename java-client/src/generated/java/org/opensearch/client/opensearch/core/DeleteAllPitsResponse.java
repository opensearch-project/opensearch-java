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

package org.opensearch.client.opensearch.core;

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
import org.opensearch.client.opensearch.core.pit.DeletedPit;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: delete_all_pits.Response

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class DeleteAllPitsResponse
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<DeleteAllPitsResponse.Builder, DeleteAllPitsResponse> {

    @Nonnull
    private final List<DeletedPit> pits;

    // ---------------------------------------------------------------------------------------------

    private DeleteAllPitsResponse(Builder builder) {
        this.pits = ApiTypeHelper.unmodifiable(builder.pits);
    }

    public static DeleteAllPitsResponse of(Function<DeleteAllPitsResponse.Builder, ObjectBuilder<DeleteAllPitsResponse>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code pits}
     */
    @Nonnull
    public final List<DeletedPit> pits() {
        return this.pits;
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
        if (ApiTypeHelper.isDefined(this.pits)) {
            generator.writeKey("pits");
            generator.writeStartArray();
            for (DeletedPit item0 : this.pits) {
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
     * Builder for {@link DeleteAllPitsResponse}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, DeleteAllPitsResponse> {
        @Nullable
        private List<DeletedPit> pits;

        public Builder() {}

        private Builder(DeleteAllPitsResponse o) {
            this.pits = _listCopy(o.pits);
        }

        private Builder(Builder o) {
            this.pits = _listCopy(o.pits);
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code pits}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>pits</code>.
         * </p>
         */
        @Nonnull
        public final Builder pits(List<DeletedPit> list) {
            this.pits = _listAddAll(this.pits, list);
            return this;
        }

        /**
         * API name: {@code pits}
         *
         * <p>
         * Adds one or more values to <code>pits</code>.
         * </p>
         */
        @Nonnull
        public final Builder pits(DeletedPit value, DeletedPit... values) {
            this.pits = _listAdd(this.pits, value, values);
            return this;
        }

        /**
         * API name: {@code pits}
         *
         * <p>
         * Adds a value to <code>pits</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder pits(Function<DeletedPit.Builder, ObjectBuilder<DeletedPit>> fn) {
            return pits(fn.apply(new DeletedPit.Builder()).build());
        }

        /**
         * Builds a {@link DeleteAllPitsResponse}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public DeleteAllPitsResponse build() {
            _checkSingleUse();

            return new DeleteAllPitsResponse(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link DeleteAllPitsResponse}
     */
    public static final JsonpDeserializer<DeleteAllPitsResponse> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        DeleteAllPitsResponse::setupDeleteAllPitsResponseDeserializer
    );

    protected static void setupDeleteAllPitsResponseDeserializer(ObjectDeserializer<DeleteAllPitsResponse.Builder> op) {
        op.add(Builder::pits, JsonpDeserializer.arrayDeserializer(DeletedPit._DESERIALIZER), "pits");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.pits);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        DeleteAllPitsResponse other = (DeleteAllPitsResponse) o;
        return Objects.equals(this.pits, other.pits);
    }
}
