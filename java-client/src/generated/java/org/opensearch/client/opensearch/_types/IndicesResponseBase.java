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

package org.opensearch.client.opensearch._types;

import jakarta.json.stream.JsonGenerator;
import java.util.Objects;
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.ObjectDeserializer;
import org.opensearch.client.util.ObjectBuilder;

// typedef: _types.IndicesResponseBase

/**
 * The base response for index operations.
 */
@Generated("org.opensearch.client.codegen.CodeGenerator")
public abstract class IndicesResponseBase extends AcknowledgedResponseBase {

    @Nullable
    private final ShardStatistics shards;

    // ---------------------------------------------------------------------------------------------

    protected IndicesResponseBase(AbstractBuilder<?> builder) {
        super(builder);
        this.shards = builder.shards;
    }

    /**
     * API name: {@code _shards}
     */
    @Nullable
    public final ShardStatistics shards() {
        return this.shards;
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        super.serializeInternal(generator, mapper);
        if (this.shards != null) {
            generator.writeKey("_shards");
            this.shards.serialize(generator, mapper);
        }
    }

    // ---------------------------------------------------------------------------------------------

    public abstract static class AbstractBuilder<BuilderT extends AbstractBuilder<BuilderT>> extends
        AcknowledgedResponseBase.AbstractBuilder<BuilderT> {
        @Nullable
        private ShardStatistics shards;

        protected AbstractBuilder() {}

        protected AbstractBuilder(IndicesResponseBase o) {
            super(o);
            this.shards = o.shards;
        }

        protected AbstractBuilder(AbstractBuilder<BuilderT> o) {
            super(o);
            this.shards = o.shards;
        }

        /**
         * API name: {@code _shards}
         */
        @Nonnull
        public final BuilderT shards(@Nullable ShardStatistics value) {
            this.shards = value;
            return self();
        }

        /**
         * API name: {@code _shards}
         */
        @Nonnull
        public final BuilderT shards(Function<ShardStatistics.Builder, ObjectBuilder<ShardStatistics>> fn) {
            return shards(fn.apply(new ShardStatistics.Builder()).build());
        }
    }

    // ---------------------------------------------------------------------------------------------

    protected static <BuilderT extends AbstractBuilder<BuilderT>> void setupIndicesResponseBaseDeserializer(
        ObjectDeserializer<BuilderT> op
    ) {
        setupAcknowledgedResponseBaseDeserializer(op);
        op.add(AbstractBuilder::shards, ShardStatistics._DESERIALIZER, "_shards");
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Objects.hashCode(this.shards);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        IndicesResponseBase other = (IndicesResponseBase) o;
        return Objects.equals(this.shards, other.shards);
    }
}
