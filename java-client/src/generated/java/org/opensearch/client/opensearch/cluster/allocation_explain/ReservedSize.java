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

package org.opensearch.client.opensearch.cluster.allocation_explain;

import jakarta.json.stream.JsonGenerator;
import java.util.List;
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
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

// typedef: cluster.allocation_explain.ReservedSize

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class ReservedSize implements PlainJsonSerializable, ToCopyableBuilder<ReservedSize.Builder, ReservedSize> {

    @Nonnull
    private final String nodeId;

    @Nonnull
    private final String path;

    @Nonnull
    private final List<String> shards;

    private final long total;

    // ---------------------------------------------------------------------------------------------

    private ReservedSize(Builder builder) {
        this.nodeId = ApiTypeHelper.requireNonNull(builder.nodeId, this, "nodeId");
        this.path = ApiTypeHelper.requireNonNull(builder.path, this, "path");
        this.shards = ApiTypeHelper.unmodifiableRequired(builder.shards, this, "shards");
        this.total = ApiTypeHelper.requireNonNull(builder.total, this, "total");
    }

    public static ReservedSize of(Function<ReservedSize.Builder, ObjectBuilder<ReservedSize>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - API name: {@code node_id}
     */
    @Nonnull
    public final String nodeId() {
        return this.nodeId;
    }

    /**
     * Required - API name: {@code path}
     */
    @Nonnull
    public final String path() {
        return this.path;
    }

    /**
     * Required - API name: {@code shards}
     */
    @Nonnull
    public final List<String> shards() {
        return this.shards;
    }

    /**
     * Required - API name: {@code total}
     */
    public final long total() {
        return this.total;
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
        generator.writeKey("node_id");
        generator.write(this.nodeId);

        generator.writeKey("path");
        generator.write(this.path);

        generator.writeKey("shards");
        generator.writeStartArray();
        for (String item0 : this.shards) {
            generator.write(item0);
        }
        generator.writeEnd();

        generator.writeKey("total");
        generator.write(this.total);
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
     * Builder for {@link ReservedSize}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, ReservedSize> {
        private String nodeId;
        private String path;
        private List<String> shards;
        private Long total;

        public Builder() {}

        private Builder(ReservedSize o) {
            this.nodeId = o.nodeId;
            this.path = o.path;
            this.shards = _listCopy(o.shards);
            this.total = o.total;
        }

        private Builder(Builder o) {
            this.nodeId = o.nodeId;
            this.path = o.path;
            this.shards = _listCopy(o.shards);
            this.total = o.total;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - API name: {@code node_id}
         */
        @Nonnull
        public final Builder nodeId(String value) {
            this.nodeId = value;
            return this;
        }

        /**
         * Required - API name: {@code path}
         */
        @Nonnull
        public final Builder path(String value) {
            this.path = value;
            return this;
        }

        /**
         * Required - API name: {@code shards}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>shards</code>.
         * </p>
         */
        @Nonnull
        public final Builder shards(List<String> list) {
            this.shards = _listAddAll(this.shards, list);
            return this;
        }

        /**
         * Required - API name: {@code shards}
         *
         * <p>
         * Adds one or more values to <code>shards</code>.
         * </p>
         */
        @Nonnull
        public final Builder shards(String value, String... values) {
            this.shards = _listAdd(this.shards, value, values);
            return this;
        }

        /**
         * Required - API name: {@code total}
         */
        @Nonnull
        public final Builder total(long value) {
            this.total = value;
            return this;
        }

        /**
         * Builds a {@link ReservedSize}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public ReservedSize build() {
            _checkSingleUse();

            return new ReservedSize(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link ReservedSize}
     */
    public static final JsonpDeserializer<ReservedSize> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        ReservedSize::setupReservedSizeDeserializer
    );

    protected static void setupReservedSizeDeserializer(ObjectDeserializer<ReservedSize.Builder> op) {
        op.add(Builder::nodeId, JsonpDeserializer.stringDeserializer(), "node_id");
        op.add(Builder::path, JsonpDeserializer.stringDeserializer(), "path");
        op.add(Builder::shards, JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()), "shards");
        op.add(Builder::total, JsonpDeserializer.longDeserializer(), "total");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.nodeId.hashCode();
        result = 31 * result + this.path.hashCode();
        result = 31 * result + this.shards.hashCode();
        result = 31 * result + Long.hashCode(this.total);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        ReservedSize other = (ReservedSize) o;
        return this.nodeId.equals(other.nodeId)
            && this.path.equals(other.path)
            && this.shards.equals(other.shards)
            && this.total == other.total;
    }
}
