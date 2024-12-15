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

package org.opensearch.client.opensearch.indices;

import jakarta.json.stream.JsonGenerator;
import java.util.Map;
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import org.opensearch.client.json.JsonpDeserializable;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.ObjectBuilderDeserializer;
import org.opensearch.client.json.ObjectDeserializer;
import org.opensearch.client.opensearch._types.AcknowledgedResponseBase;
import org.opensearch.client.opensearch.indices.close.CloseIndexResult;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: indices.close.Response

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class CloseIndexResponse extends AcknowledgedResponseBase
    implements
        ToCopyableBuilder<CloseIndexResponse.Builder, CloseIndexResponse> {

    @Nonnull
    private final Map<String, CloseIndexResult> indices;

    private final boolean shardsAcknowledged;

    // ---------------------------------------------------------------------------------------------

    private CloseIndexResponse(Builder builder) {
        super(builder);
        this.indices = ApiTypeHelper.unmodifiableRequired(builder.indices, this, "indices");
        this.shardsAcknowledged = ApiTypeHelper.requireNonNull(builder.shardsAcknowledged, this, "shardsAcknowledged");
    }

    public static CloseIndexResponse of(Function<CloseIndexResponse.Builder, ObjectBuilder<CloseIndexResponse>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - API name: {@code indices}
     */
    @Nonnull
    public final Map<String, CloseIndexResult> indices() {
        return this.indices;
    }

    /**
     * Required - API name: {@code shards_acknowledged}
     */
    public final boolean shardsAcknowledged() {
        return this.shardsAcknowledged;
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        super.serializeInternal(generator, mapper);
        generator.writeKey("indices");
        generator.writeStartObject();
        for (Map.Entry<String, CloseIndexResult> item0 : this.indices.entrySet()) {
            generator.writeKey(item0.getKey());
            item0.getValue().serialize(generator, mapper);
        }
        generator.writeEnd();

        generator.writeKey("shards_acknowledged");
        generator.write(this.shardsAcknowledged);
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
     * Builder for {@link CloseIndexResponse}.
     */
    public static class Builder extends AcknowledgedResponseBase.AbstractBuilder<Builder>
        implements
            CopyableBuilder<Builder, CloseIndexResponse> {
        private Map<String, CloseIndexResult> indices;
        private Boolean shardsAcknowledged;

        public Builder() {}

        private Builder(CloseIndexResponse o) {
            super(o);
            this.indices = _mapCopy(o.indices);
            this.shardsAcknowledged = o.shardsAcknowledged;
        }

        private Builder(Builder o) {
            super(o);
            this.indices = _mapCopy(o.indices);
            this.shardsAcknowledged = o.shardsAcknowledged;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        @Override
        @Nonnull
        protected Builder self() {
            return this;
        }

        /**
         * Required - API name: {@code indices}
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>indices</code>.
         * </p>
         */
        @Nonnull
        public final Builder indices(Map<String, CloseIndexResult> map) {
            this.indices = _mapPutAll(this.indices, map);
            return this;
        }

        /**
         * Required - API name: {@code indices}
         *
         * <p>
         * Adds an entry to <code>indices</code>.
         * </p>
         */
        @Nonnull
        public final Builder indices(String key, CloseIndexResult value) {
            this.indices = _mapPut(this.indices, key, value);
            return this;
        }

        /**
         * Required - API name: {@code indices}
         *
         * <p>
         * Adds a value to <code>indices</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder indices(String key, Function<CloseIndexResult.Builder, ObjectBuilder<CloseIndexResult>> fn) {
            return indices(key, fn.apply(new CloseIndexResult.Builder()).build());
        }

        /**
         * Required - API name: {@code shards_acknowledged}
         */
        @Nonnull
        public final Builder shardsAcknowledged(boolean value) {
            this.shardsAcknowledged = value;
            return this;
        }

        /**
         * Builds a {@link CloseIndexResponse}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public CloseIndexResponse build() {
            _checkSingleUse();

            return new CloseIndexResponse(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link CloseIndexResponse}
     */
    public static final JsonpDeserializer<CloseIndexResponse> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        CloseIndexResponse::setupCloseIndexResponseDeserializer
    );

    protected static void setupCloseIndexResponseDeserializer(ObjectDeserializer<CloseIndexResponse.Builder> op) {
        setupAcknowledgedResponseBaseDeserializer(op);
        op.add(Builder::indices, JsonpDeserializer.stringMapDeserializer(CloseIndexResult._DESERIALIZER), "indices");
        op.add(Builder::shardsAcknowledged, JsonpDeserializer.booleanDeserializer(), "shards_acknowledged");
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + this.indices.hashCode();
        result = 31 * result + Boolean.hashCode(this.shardsAcknowledged);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        CloseIndexResponse other = (CloseIndexResponse) o;
        return this.indices.equals(other.indices) && this.shardsAcknowledged == other.shardsAcknowledged;
    }
}
