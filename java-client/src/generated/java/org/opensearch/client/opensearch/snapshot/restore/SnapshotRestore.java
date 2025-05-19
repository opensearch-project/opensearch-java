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

package org.opensearch.client.opensearch.snapshot.restore;

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
import org.opensearch.client.opensearch._types.ShardStatistics;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: snapshot.restore.SnapshotRestore

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class SnapshotRestore implements PlainJsonSerializable, ToCopyableBuilder<SnapshotRestore.Builder, SnapshotRestore> {

    @Nonnull
    private final List<String> indices;

    @Nonnull
    private final ShardStatistics shards;

    @Nonnull
    private final String snapshot;

    // ---------------------------------------------------------------------------------------------

    private SnapshotRestore(Builder builder) {
        this.indices = ApiTypeHelper.unmodifiableRequired(builder.indices, this, "indices");
        this.shards = ApiTypeHelper.requireNonNull(builder.shards, this, "shards");
        this.snapshot = ApiTypeHelper.requireNonNull(builder.snapshot, this, "snapshot");
    }

    public static SnapshotRestore of(Function<SnapshotRestore.Builder, ObjectBuilder<SnapshotRestore>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - The list of indexes that were restored.
     * <p>
     * API name: {@code indices}
     * </p>
     */
    @Nonnull
    public final List<String> indices() {
        return this.indices;
    }

    /**
     * Required - Any statistics about the restored shards.
     * <p>
     * API name: {@code shards}
     * </p>
     */
    @Nonnull
    public final ShardStatistics shards() {
        return this.shards;
    }

    /**
     * Required - The name of the snapshot that was restored.
     * <p>
     * API name: {@code snapshot}
     * </p>
     */
    @Nonnull
    public final String snapshot() {
        return this.snapshot;
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
        generator.writeKey("indices");
        generator.writeStartArray();
        for (String item0 : this.indices) {
            generator.write(item0);
        }
        generator.writeEnd();

        generator.writeKey("shards");
        this.shards.serialize(generator, mapper);

        generator.writeKey("snapshot");
        generator.write(this.snapshot);
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
     * Builder for {@link SnapshotRestore}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, SnapshotRestore> {
        private List<String> indices;
        private ShardStatistics shards;
        private String snapshot;

        public Builder() {}

        private Builder(SnapshotRestore o) {
            this.indices = _listCopy(o.indices);
            this.shards = o.shards;
            this.snapshot = o.snapshot;
        }

        private Builder(Builder o) {
            this.indices = _listCopy(o.indices);
            this.shards = o.shards;
            this.snapshot = o.snapshot;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - The list of indexes that were restored.
         * <p>
         * API name: {@code indices}
         * </p>
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>indices</code>.
         * </p>
         */
        @Nonnull
        public final Builder indices(List<String> list) {
            this.indices = _listAddAll(this.indices, list);
            return this;
        }

        /**
         * Required - The list of indexes that were restored.
         * <p>
         * API name: {@code indices}
         * </p>
         *
         * <p>
         * Adds one or more values to <code>indices</code>.
         * </p>
         */
        @Nonnull
        public final Builder indices(String value, String... values) {
            this.indices = _listAdd(this.indices, value, values);
            return this;
        }

        /**
         * Required - Any statistics about the restored shards.
         * <p>
         * API name: {@code shards}
         * </p>
         */
        @Nonnull
        public final Builder shards(ShardStatistics value) {
            this.shards = value;
            return this;
        }

        /**
         * Required - Any statistics about the restored shards.
         * <p>
         * API name: {@code shards}
         * </p>
         */
        @Nonnull
        public final Builder shards(Function<ShardStatistics.Builder, ObjectBuilder<ShardStatistics>> fn) {
            return shards(fn.apply(new ShardStatistics.Builder()).build());
        }

        /**
         * Required - The name of the snapshot that was restored.
         * <p>
         * API name: {@code snapshot}
         * </p>
         */
        @Nonnull
        public final Builder snapshot(String value) {
            this.snapshot = value;
            return this;
        }

        /**
         * Builds a {@link SnapshotRestore}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public SnapshotRestore build() {
            _checkSingleUse();

            return new SnapshotRestore(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link SnapshotRestore}
     */
    public static final JsonpDeserializer<SnapshotRestore> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        SnapshotRestore::setupSnapshotRestoreDeserializer
    );

    protected static void setupSnapshotRestoreDeserializer(ObjectDeserializer<SnapshotRestore.Builder> op) {
        op.add(Builder::indices, JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()), "indices");
        op.add(Builder::shards, ShardStatistics._DESERIALIZER, "shards");
        op.add(Builder::snapshot, JsonpDeserializer.stringDeserializer(), "snapshot");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.indices.hashCode();
        result = 31 * result + this.shards.hashCode();
        result = 31 * result + this.snapshot.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        SnapshotRestore other = (SnapshotRestore) o;
        return this.indices.equals(other.indices) && this.shards.equals(other.shards) && this.snapshot.equals(other.snapshot);
    }
}
